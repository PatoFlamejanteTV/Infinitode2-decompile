/*      */ package net.bytebuddy.utility.dispatcher;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.annotation.Documented;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.lang.annotation.Retention;
/*      */ import java.lang.annotation.RetentionPolicy;
/*      */ import java.lang.annotation.Target;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.InvocationHandler;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.Proxy;
/*      */ import java.security.AccessController;
/*      */ import java.security.Permission;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.Map;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.jar.asm.ClassWriter;
/*      */ import net.bytebuddy.jar.asm.MethodVisitor;
/*      */ import net.bytebuddy.jar.asm.Type;
/*      */ import net.bytebuddy.utility.GraalImageCode;
/*      */ import net.bytebuddy.utility.Invoker;
/*      */ import net.bytebuddy.utility.MethodComparator;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Enhance
/*      */ public class JavaDispatcher<T>
/*      */   implements PrivilegedAction<T>
/*      */ {
/*      */   public static final String GENERATE_PROPERTY = "net.bytebuddy.generate";
/*   74 */   private static final boolean GENERATE = Boolean.parseBoolean(doPrivileged((PrivilegedAction<String>)new GetSystemPropertyAction("net.bytebuddy.generate")));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   81 */   private static final DynamicClassLoader.Resolver RESOLVER = doPrivileged(DynamicClassLoader.Resolver.CreationAction.INSTANCE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   87 */   private static final Invoker INVOKER = doPrivileged(new InvokerCreationAction((byte)0)); private final Class<T> proxy; @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) private final ClassLoader classLoader; private final boolean generate; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected JavaDispatcher(Class<T> paramClass, @MaybeNull ClassLoader paramClassLoader, boolean paramBoolean) {
/*  114 */     this.proxy = paramClass;
/*  115 */     this.classLoader = paramClassLoader;
/*  116 */     this.generate = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) {
/*  128 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> PrivilegedAction<T> of(Class<T> paramClass) {
/*  139 */     return of(paramClass, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static <T> PrivilegedAction<T> of(Class<T> paramClass, @MaybeNull ClassLoader paramClassLoader) {
/*  151 */     return of(paramClass, paramClassLoader, GENERATE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static <T> PrivilegedAction<T> of(Class<T> paramClass, @MaybeNull ClassLoader paramClassLoader, boolean paramBoolean) {
/*  164 */     if (!paramClass.isInterface())
/*  165 */       throw new IllegalArgumentException("Expected an interface instead of " + paramClass); 
/*  166 */     if (!paramClass.isAnnotationPresent((Class)Proxied.class))
/*  167 */       throw new IllegalArgumentException("Expected " + paramClass.getName() + " to be annotated with " + Proxied.class.getName()); 
/*  168 */     if (((Proxied)paramClass.<Proxied>getAnnotation(Proxied.class)).value().startsWith("java.security.")) {
/*  169 */       throw new IllegalArgumentException("Classes related to Java security cannot be proxied: " + paramClass.getName());
/*      */     }
/*  171 */     return new JavaDispatcher<T>(paramClass, paramClassLoader, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public T run() {
/*      */     Class<?> clazz;
/*      */     try {
/*      */       Object object;
/*  182 */       if ((object = System.class.getMethod("getSecurityManager", new Class[0]).invoke((Object)null, new Object[0])) != null) {
/*  183 */         Class.forName("java.lang.SecurityManager")
/*  184 */           .getMethod("checkPermission", new Class[] { Permission.class
/*  185 */             }).invoke(object, new Object[] { new RuntimePermission("net.bytebuddy.createJavaDispatcher") });
/*      */       }
/*  187 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */     
/*  189 */     } catch (ClassNotFoundException classNotFoundException) {
/*      */     
/*  191 */     } catch (InvocationTargetException invocationTargetException2) {
/*      */       InvocationTargetException invocationTargetException1; Throwable throwable;
/*  193 */       if (throwable = (invocationTargetException1 = null).getTargetException() instanceof RuntimeException) {
/*  194 */         throw (RuntimeException)throwable;
/*      */       }
/*  196 */       throw new IllegalStateException("Failed to assert access rights using security manager", throwable);
/*      */     }
/*  198 */     catch (IllegalAccessException illegalAccessException) {
/*  199 */       throw new IllegalStateException("Failed to access security manager", illegalAccessException);
/*      */     } 
/*  201 */     HashMap<Method, Dispatcher.ForDefaultValue> hashMap = this.generate ? new LinkedHashMap<Object, Object>() : new HashMap<Object, Object>();
/*      */ 
/*      */     
/*  204 */     boolean bool1 = this.proxy.isAnnotationPresent((Class)Defaults.class);
/*  205 */     String str = ((Proxied)this.proxy.<Proxied>getAnnotation(Proxied.class)).value();
/*      */     
/*      */     try {
/*  208 */       clazz = Class.forName(str, false, this.classLoader);
/*  209 */     } catch (ClassNotFoundException classNotFoundException) {
/*  210 */       Method[] arrayOfMethod1; int j; byte b1; for (j = (arrayOfMethod1 = this.generate ? 
/*  211 */         (Method[])GraalImageCode.getCurrent().sorted((Object[])this.proxy.getMethods(), (Comparator)MethodComparator.INSTANCE) : this.proxy
/*  212 */         .getMethods()).length, b1 = 0; b1 < j; b1++) {
/*  213 */         Method method; if ((method = arrayOfMethod1[b1]).getDeclaringClass() != Object.class)
/*      */         {
/*      */           
/*  216 */           if (method.isAnnotationPresent((Class)Instance.class)) {
/*  217 */             if ((method.getParameterTypes()).length != 1 || method.getParameterTypes()[0].isPrimitive() || method.getParameterTypes()[0].isArray())
/*  218 */               throw new IllegalStateException("Instance check requires a single regular-typed argument: " + method); 
/*  219 */             if (method.getReturnType() != boolean.class) {
/*  220 */               throw new IllegalStateException("Instance check requires a boolean return type: " + method);
/*      */             }
/*  222 */             hashMap.put(method, Dispatcher.ForDefaultValue.BOOLEAN);
/*      */           } else {
/*      */             
/*  225 */             hashMap.put(method, (bool1 || method.isAnnotationPresent((Class)Defaults.class)) ? 
/*  226 */                 Dispatcher.ForDefaultValue.of(method.getReturnType()) : new Dispatcher.ForUnresolvedMethod("Type not available on current VM: " + classNotFoundException
/*  227 */                   .getMessage()));
/*      */           }  } 
/*      */       } 
/*  230 */       if (this.generate) {
/*  231 */         return (T)DynamicClassLoader.proxy(this.proxy, (Map)hashMap);
/*      */       }
/*  233 */       return (T)Proxy.newProxyInstance(this.proxy.getClassLoader(), new Class[] { this.proxy }, new ProxiedInvocationHandler(str, (Map)hashMap));
/*      */     } 
/*      */     boolean bool2;
/*      */     Method[] arrayOfMethod;
/*      */     int i;
/*      */     byte b;
/*  239 */     for (i = (arrayOfMethod = (bool2 = this.generate) ? 
/*  240 */       (Method[])GraalImageCode.getCurrent().sorted((Object[])this.proxy.getMethods(), (Comparator)MethodComparator.INSTANCE) : this.proxy
/*  241 */       .getMethods()).length, b = 0; b < i; b++) {
/*  242 */       Method method; if ((method = arrayOfMethod[b]).getDeclaringClass() != Object.class)
/*      */       {
/*      */         
/*  245 */         if (method.isAnnotationPresent((Class)Instance.class)) {
/*  246 */           if ((method.getParameterTypes()).length != 1 || !method.getParameterTypes()[0].isAssignableFrom(clazz))
/*  247 */             throw new IllegalStateException("Instance check requires a single regular-typed argument: " + method); 
/*  248 */           if (method.getReturnType() != boolean.class) {
/*  249 */             throw new IllegalStateException("Instance check requires a boolean return type: " + method);
/*      */           }
/*  251 */           hashMap.put(method, new Dispatcher.ForInstanceCheck(clazz));
/*      */         }
/*  253 */         else if (method.isAnnotationPresent((Class)Container.class)) {
/*  254 */           if ((method.getParameterTypes()).length != 1 || method.getParameterTypes()[0] != int.class)
/*  255 */             throw new IllegalStateException("Container creation requires a single int-typed argument: " + method); 
/*  256 */           if (!method.getReturnType().isArray() || !method.getReturnType().getComponentType().isAssignableFrom(clazz)) {
/*  257 */             throw new IllegalStateException("Container creation requires an assignable array as return value: " + method);
/*      */           }
/*  259 */           hashMap.put(method, new Dispatcher.ForContainerCreation(clazz));
/*      */         } else {
/*  261 */           if (clazz.getName().equals("java.lang.invoke.MethodHandles") && method.getName().equals("lookup"))
/*  262 */             throw new UnsupportedOperationException("Cannot resolve Byte Buddy lookup via dispatcher"); 
/*      */           try {
/*      */             byte b1;
/*  265 */             Class[] arrayOfClass = method.getParameterTypes();
/*      */             
/*  267 */             if (method.isAnnotationPresent((Class)IsStatic.class) || method.isAnnotationPresent((Class)IsConstructor.class)) {
/*  268 */               b1 = 0;
/*      */             } else {
/*  270 */               b1 = 1;
/*  271 */               if (arrayOfClass.length == 0)
/*  272 */                 throw new IllegalStateException("Expected self type: " + method); 
/*  273 */               if (!arrayOfClass[0].isAssignableFrom(clazz)) {
/*  274 */                 throw new IllegalStateException("Cannot assign self type: " + clazz + " on " + method);
/*      */               }
/*  276 */               Class[] arrayOfClass1 = new Class[arrayOfClass.length - 1];
/*  277 */               System.arraycopy(arrayOfClass, 1, arrayOfClass1, 0, arrayOfClass1.length);
/*  278 */               arrayOfClass = arrayOfClass1;
/*      */             } 
/*  280 */             Annotation[][] arrayOfAnnotation = method.getParameterAnnotations();
/*  281 */             for (byte b2 = 0; b2 < arrayOfClass.length; b2++) {
/*  282 */               Annotation[] arrayOfAnnotation1; int j; byte b3; for (j = (arrayOfAnnotation1 = arrayOfAnnotation[b2 + b1]).length, b3 = 0; b3 < j; b3++) {
/*  283 */                 Annotation annotation; if (annotation = arrayOfAnnotation1[b3] instanceof Proxied) {
/*  284 */                   byte b4 = 0;
/*  285 */                   while (arrayOfClass[b2].isArray()) {
/*  286 */                     b4++;
/*  287 */                     arrayOfClass[b2] = arrayOfClass[b2].getComponentType();
/*      */                   } 
/*  289 */                   if (b4 > 0) {
/*  290 */                     if (arrayOfClass[b2].isPrimitive())
/*  291 */                       throw new IllegalStateException("Primitive values are not supposed to be proxied: " + b2 + " of " + method); 
/*  292 */                     if (!arrayOfClass[b2].isAssignableFrom(Class.forName(((Proxied)annotation).value(), false, this.classLoader))) {
/*  293 */                       throw new IllegalStateException("Cannot resolve to component type: " + ((Proxied)annotation).value() + " at " + b2 + " of " + method);
/*      */                     }
/*  295 */                     StringBuilder stringBuilder = new StringBuilder();
/*  296 */                     while (b4-- > 0) {
/*  297 */                       stringBuilder.append('[');
/*      */                     }
/*  299 */                     arrayOfClass[b2] = Class.forName(stringBuilder.append('L')
/*  300 */                         .append(((Proxied)annotation).value())
/*  301 */                         .append(';')
/*  302 */                         .toString(), false, this.classLoader); break;
/*      */                   } 
/*  304 */                   Class<?> clazz1 = Class.forName(((Proxied)annotation).value(), false, this.classLoader);
/*  305 */                   if (!arrayOfClass[b2].isAssignableFrom(clazz1)) {
/*  306 */                     throw new IllegalStateException("Cannot resolve to type: " + clazz1.getName() + " at " + b2 + " of " + method);
/*      */                   }
/*  308 */                   arrayOfClass[b2] = clazz1;
/*      */                   
/*      */                   break;
/*      */                 } 
/*      */               } 
/*      */             } 
/*  314 */             if (method.isAnnotationPresent((Class)IsConstructor.class)) {
/*  315 */               Constructor<?> constructor = clazz.getConstructor(arrayOfClass);
/*  316 */               if (!method.getReturnType().isAssignableFrom(clazz)) {
/*  317 */                 throw new IllegalStateException("Cannot assign " + constructor.getDeclaringClass().getName() + " to " + method);
/*      */               }
/*  319 */               if ((constructor.getModifiers() & 0x1) == 0 || (clazz.getModifiers() & 0x1) == 0) {
/*  320 */                 constructor.setAccessible(true);
/*  321 */                 bool2 = false;
/*      */               } 
/*  323 */               hashMap.put(method, new Dispatcher.ForConstructor(constructor));
/*      */             } else {
/*  325 */               Proxied proxied = method.<Proxied>getAnnotation(Proxied.class);
/*  326 */               Method method1 = clazz.getMethod((proxied == null) ? method.getName() : proxied.value(), arrayOfClass);
/*  327 */               if (!method.getReturnType().isAssignableFrom(method1.getReturnType()))
/*  328 */                 throw new IllegalStateException("Cannot assign " + method1.getReturnType().getName() + " to " + method);  Class[] arrayOfClass1;
/*      */               int j;
/*      */               byte b3;
/*  331 */               for (j = (arrayOfClass1 = method1.getExceptionTypes()).length, b3 = 0; b3 < j; ) { Class<?> clazz1 = arrayOfClass1[b3];
/*  332 */                 if (!RuntimeException.class.isAssignableFrom(clazz1) && !Error.class.isAssignableFrom(clazz1)) {
/*      */                   Class[] arrayOfClass2;
/*      */                   
/*  335 */                   int k = (arrayOfClass2 = method.getExceptionTypes()).length; b1 = 0; while (true) { if (b1 < k) {
/*  336 */                       Class<?> clazz2; if (!(clazz2 = arrayOfClass2[b1]).isAssignableFrom(clazz1)) {
/*      */                         b1++; continue;
/*      */                       }  break;
/*      */                     } 
/*  340 */                     throw new IllegalStateException("Resolved method for " + method + " throws undeclared checked exception " + clazz1.getName()); } 
/*      */                 }  b3++; }
/*  342 */                if ((method1.getModifiers() & 0x1) == 0 || (method1.getDeclaringClass().getModifiers() & 0x1) == 0) {
/*  343 */                 method1.setAccessible(true);
/*  344 */                 bool2 = false;
/*      */               } 
/*  346 */               if (Modifier.isStatic(method1.getModifiers())) {
/*  347 */                 if (!method.isAnnotationPresent((Class)IsStatic.class)) {
/*  348 */                   throw new IllegalStateException("Resolved method for " + method + " was expected to be static: " + method1);
/*      */                 }
/*  350 */                 hashMap.put(method, new Dispatcher.ForStaticMethod(method1));
/*      */               } else {
/*  352 */                 if (method.isAnnotationPresent((Class)IsStatic.class)) {
/*  353 */                   throw new IllegalStateException("Resolved method for " + method + " was expected to be virtual: " + method1);
/*      */                 }
/*  355 */                 hashMap.put(method, new Dispatcher.ForNonStaticMethod(method1));
/*      */               } 
/*      */             } 
/*  358 */           } catch (ClassNotFoundException classNotFoundException) {
/*  359 */             hashMap.put(method, (bool1 || method.isAnnotationPresent((Class)Defaults.class)) ? 
/*  360 */                 Dispatcher.ForDefaultValue.of(method.getReturnType()) : new Dispatcher.ForUnresolvedMethod("Class not available on current VM: " + classNotFoundException
/*  361 */                   .getMessage()));
/*  362 */           } catch (NoSuchMethodException noSuchMethodException) {
/*  363 */             hashMap.put(method, (bool1 || method.isAnnotationPresent((Class)Defaults.class)) ? 
/*  364 */                 Dispatcher.ForDefaultValue.of(method.getReturnType()) : new Dispatcher.ForUnresolvedMethod("Method not available on current VM: " + noSuchMethodException
/*  365 */                   .getMessage()));
/*  366 */           } catch (Throwable throwable) {
/*  367 */             hashMap.put(method, new Dispatcher.ForUnresolvedMethod("Unexpected error: " + throwable.getMessage()));
/*      */           } 
/*      */         }  } 
/*      */     } 
/*  371 */     if (bool2) {
/*  372 */       return (T)DynamicClassLoader.proxy(this.proxy, (Map)hashMap);
/*      */     }
/*  374 */     return (T)Proxy.newProxyInstance(this.proxy.getClassLoader(), new Class[] { this.proxy }, new ProxiedInvocationHandler(clazz
/*      */           
/*  376 */           .getName(), (Map)hashMap));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(@MaybeNull Object paramObject) {
/*      */     ClassLoader classLoader;
/*      */     if (this == paramObject) {
/*      */       return true;
/*      */     }
/*      */     if (paramObject == null) {
/*      */       return false;
/*      */     }
/*      */     if (getClass() != paramObject.getClass()) {
/*      */       return false;
/*      */     }
/*      */     if (this.generate != ((JavaDispatcher)paramObject).generate) {
/*      */       return false;
/*      */     }
/*      */     if (!this.proxy.equals(((JavaDispatcher)paramObject).proxy)) {
/*      */       return false;
/*      */     }
/*      */     paramObject = ((JavaDispatcher)paramObject).classLoader;
/*      */     if (paramObject != null) {
/*      */       if ((classLoader = this.classLoader) != null) {
/*      */         if (!classLoader.equals(paramObject)) {
/*      */           return false;
/*      */         }
/*      */       } else {
/*      */         return false;
/*      */       } 
/*      */     } else if ((classLoader = this.classLoader) != null) {
/*      */       return false;
/*      */     } 
/*      */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*      */     ClassLoader classLoader;
/*      */     if ((classLoader = this.classLoader) != null);
/*      */     return ((getClass().hashCode() * 31 + this.proxy.hashCode()) * 31 + classLoader.hashCode()) * 31 + this.generate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   private static class InvokerCreationAction
/*      */     implements PrivilegedAction<Invoker>
/*      */   {
/*      */     private InvokerCreationAction() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Invoker run() {
/*  459 */       return JavaDispatcher.DynamicClassLoader.invoker();
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass())));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode();
/*      */     } }
/*      */   
/*      */   @Enhance
/*      */   private static class DirectInvoker implements Invoker { private DirectInvoker() {}
/*      */     
/*      */     public Object newInstance(Constructor<?> param1Constructor, Object[] param1ArrayOfObject) {
/*  474 */       return param1Constructor.newInstance(param1ArrayOfObject);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object invoke(Method param1Method, @MaybeNull Object param1Object, @MaybeNull Object[] param1ArrayOfObject) {
/*  481 */       return param1Method.invoke(param1Object, param1ArrayOfObject);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : (!(getClass() != param1Object.getClass())));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForInstanceCheck
/*      */     implements Dispatcher
/*      */   {
/*      */     private final Class<?> target;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForInstanceCheck(Class<?> param1Class) {
/*  526 */       this.target = param1Class;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object invoke(Object[] param1ArrayOfObject) {
/*  533 */       return Boolean.valueOf(this.target.isInstance(param1ArrayOfObject[0]));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int apply(MethodVisitor param1MethodVisitor, Method param1Method) {
/*  540 */       param1MethodVisitor.visitVarInsn(25, 1);
/*  541 */       param1MethodVisitor.visitTypeInsn(193, Type.getInternalName(this.target));
/*  542 */       param1MethodVisitor.visitInsn(172);
/*  543 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.target.equals(((ForInstanceCheck)param1Object).target))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.target.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForContainerCreation
/*      */     implements Dispatcher
/*      */   {
/*      */     private final Class<?> target;
/*      */     
/*      */     protected ForContainerCreation(Class<?> param1Class) {
/*  564 */       this.target = param1Class;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object invoke(Object[] param1ArrayOfObject) {
/*  571 */       return Array.newInstance(this.target, ((Integer)param1ArrayOfObject[0]).intValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int apply(MethodVisitor param1MethodVisitor, Method param1Method) {
/*  578 */       param1MethodVisitor.visitVarInsn(21, 1);
/*  579 */       param1MethodVisitor.visitTypeInsn(189, Type.getInternalName(this.target));
/*  580 */       param1MethodVisitor.visitInsn(176);
/*  581 */       return 1;
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.target.equals(((ForContainerCreation)param1Object).target))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.target.hashCode();
/*      */     } }
/*      */   
/*      */   public enum ForDefaultValue implements Dispatcher {
/*  593 */     VOID(null, 0, 177, 0),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  598 */     BOOLEAN((String)Boolean.FALSE, 3, 172, 1),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  603 */     BOOLEAN_REVERSE((String)Boolean.TRUE, 4, 172, 1),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  608 */     BYTE((String)Byte.valueOf((byte)0), 3, 172, 1),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  613 */     SHORT((String)Short.valueOf((short)0), 3, 172, 1),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  618 */     CHARACTER((String)Character.valueOf(false), 3, 172, 1),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  623 */     INTEGER((String)Integer.valueOf(0), 3, 172, 1),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  628 */     LONG((String)Long.valueOf(0L), 9, 173, 2),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  633 */     FLOAT((String)Float.valueOf(0.0F), 11, 174, 1),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  638 */     DOUBLE((String)Double.valueOf(0.0D), 14, 175, 2),
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  643 */     REFERENCE(null, 1, 176, 1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     private final Object value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int load;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int returned;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int size;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ForDefaultValue(Object param1Object, int param1Int1, int param1Int2, int param1Int3) {
/*  675 */       this.value = param1Object;
/*  676 */       this.load = param1Int1;
/*  677 */       this.returned = param1Int2;
/*  678 */       this.size = param1Int3;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static JavaDispatcher.Dispatcher of(Class<?> param1Class) {
/*  688 */       if (param1Class == void.class)
/*  689 */         return VOID; 
/*  690 */       if (param1Class == boolean.class)
/*  691 */         return BOOLEAN; 
/*  692 */       if (param1Class == byte.class)
/*  693 */         return BYTE; 
/*  694 */       if (param1Class == short.class)
/*  695 */         return SHORT; 
/*  696 */       if (param1Class == char.class)
/*  697 */         return CHARACTER; 
/*  698 */       if (param1Class == int.class)
/*  699 */         return INTEGER; 
/*  700 */       if (param1Class == long.class)
/*  701 */         return LONG; 
/*  702 */       if (param1Class == float.class)
/*  703 */         return FLOAT; 
/*  704 */       if (param1Class == double.class)
/*  705 */         return DOUBLE; 
/*  706 */       if (param1Class.isArray()) {
/*  707 */         if (param1Class.getComponentType() == boolean.class)
/*  708 */           return OfPrimitiveArray.BOOLEAN; 
/*  709 */         if (param1Class.getComponentType() == byte.class)
/*  710 */           return OfPrimitiveArray.BYTE; 
/*  711 */         if (param1Class.getComponentType() == short.class)
/*  712 */           return OfPrimitiveArray.SHORT; 
/*  713 */         if (param1Class.getComponentType() == char.class)
/*  714 */           return OfPrimitiveArray.CHARACTER; 
/*  715 */         if (param1Class.getComponentType() == int.class)
/*  716 */           return OfPrimitiveArray.INTEGER; 
/*  717 */         if (param1Class.getComponentType() == long.class)
/*  718 */           return OfPrimitiveArray.LONG; 
/*  719 */         if (param1Class.getComponentType() == float.class)
/*  720 */           return OfPrimitiveArray.FLOAT; 
/*  721 */         if (param1Class.getComponentType() == double.class) {
/*  722 */           return OfPrimitiveArray.DOUBLE;
/*      */         }
/*  724 */         return OfNonPrimitiveArray.of(param1Class.getComponentType());
/*      */       } 
/*      */       
/*  727 */       return REFERENCE;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public final Object invoke(Object[] param1ArrayOfObject) {
/*  736 */       return this.value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int apply(MethodVisitor param1MethodVisitor, Method param1Method) {
/*  743 */       if (this.load != 0) {
/*  744 */         param1MethodVisitor.visitInsn(this.load);
/*      */       }
/*  746 */       param1MethodVisitor.visitInsn(this.returned);
/*  747 */       return this.size;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected enum OfPrimitiveArray
/*      */       implements JavaDispatcher.Dispatcher
/*      */     {
/*  758 */       BOOLEAN((String)new boolean[0], 4),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  763 */       BYTE((String)new byte[0], 8),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  768 */       SHORT((String)new short[0], 9),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  773 */       CHARACTER((String)new char[0], 5),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  778 */       INTEGER((String)new int[0], 10),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  783 */       LONG((String)new long[0], 11),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  788 */       FLOAT((String)new float[0], 6),
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  793 */       DOUBLE((String)new double[0], 7);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Object value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final int operand;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       OfPrimitiveArray(Object param3Object, int param3Int1) {
/*  812 */         this.value = param3Object;
/*  813 */         this.operand = param3Int1;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Object invoke(Object[] param3ArrayOfObject) {
/*  820 */         return this.value;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final int apply(MethodVisitor param3MethodVisitor, Method param3Method) {
/*  827 */         param3MethodVisitor.visitInsn(3);
/*  828 */         param3MethodVisitor.visitIntInsn(188, this.operand);
/*  829 */         param3MethodVisitor.visitInsn(176);
/*  830 */         return 1;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class OfNonPrimitiveArray
/*      */       implements JavaDispatcher.Dispatcher
/*      */     {
/*      */       @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
/*      */       private final Object value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Class<?> componentType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected OfNonPrimitiveArray(Object param3Object, Class<?> param3Class) {
/*  858 */         this.value = param3Object;
/*  859 */         this.componentType = param3Class;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected static JavaDispatcher.Dispatcher of(Class<?> param3Class) {
/*  869 */         return new OfNonPrimitiveArray(Array.newInstance(param3Class, 0), param3Class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Object invoke(Object[] param3ArrayOfObject) {
/*  876 */         return this.value;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int apply(MethodVisitor param3MethodVisitor, Method param3Method) {
/*  883 */         param3MethodVisitor.visitInsn(3);
/*  884 */         param3MethodVisitor.visitTypeInsn(189, Type.getInternalName(this.componentType));
/*  885 */         param3MethodVisitor.visitInsn(176);
/*  886 */         return 1;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.componentType.equals(((OfNonPrimitiveArray)param3Object).componentType))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.componentType.hashCode();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForConstructor
/*      */     implements Dispatcher
/*      */   {
/*      */     private final Constructor<?> constructor;
/*      */     
/*      */     protected ForConstructor(Constructor<?> param1Constructor) {
/*  908 */       this.constructor = param1Constructor;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object invoke(Object[] param1ArrayOfObject) {
/*  915 */       return JavaDispatcher.a().newInstance(this.constructor, param1ArrayOfObject);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int apply(MethodVisitor param1MethodVisitor, Method param1Method) {
/*  922 */       Class[] arrayOfClass1 = param1Method.getParameterTypes(), arrayOfClass2 = this.constructor.getParameterTypes();
/*  923 */       param1MethodVisitor.visitTypeInsn(187, Type.getInternalName(this.constructor.getDeclaringClass()));
/*  924 */       param1MethodVisitor.visitInsn(89);
/*  925 */       int i = 1;
/*  926 */       for (byte b = 0; b < arrayOfClass1.length; b++) {
/*  927 */         Type type = Type.getType(arrayOfClass1[b]);
/*  928 */         param1MethodVisitor.visitVarInsn(type.getOpcode(21), i);
/*  929 */         if (arrayOfClass1[b] != arrayOfClass2[b]) {
/*  930 */           param1MethodVisitor.visitTypeInsn(192, Type.getInternalName(arrayOfClass2[b]));
/*      */         }
/*  932 */         i += type.getSize();
/*      */       } 
/*  934 */       param1MethodVisitor.visitMethodInsn(183, 
/*  935 */           Type.getInternalName(this.constructor.getDeclaringClass()), "<init>", 
/*      */           
/*  937 */           Type.getConstructorDescriptor(this.constructor), false);
/*      */       
/*  939 */       param1MethodVisitor.visitInsn(176);
/*  940 */       return i + 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.constructor.equals(((ForConstructor)param1Object).constructor))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.constructor.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForStaticMethod
/*      */     implements Dispatcher
/*      */   {
/*      */     private final Method method;
/*      */     
/*      */     protected ForStaticMethod(Method param1Method) {
/*  961 */       this.method = param1Method;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public Object invoke(Object[] param1ArrayOfObject) {
/*  969 */       return JavaDispatcher.a().invoke(this.method, null, param1ArrayOfObject);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int apply(MethodVisitor param1MethodVisitor, Method param1Method) {
/*  976 */       Class[] arrayOfClass1 = param1Method.getParameterTypes(), arrayOfClass2 = this.method.getParameterTypes();
/*  977 */       int i = 1;
/*  978 */       for (byte b = 0; b < arrayOfClass1.length; b++) {
/*  979 */         Type type = Type.getType(arrayOfClass1[b]);
/*  980 */         param1MethodVisitor.visitVarInsn(type.getOpcode(21), i);
/*  981 */         if (arrayOfClass1[b] != arrayOfClass2[b]) {
/*  982 */           param1MethodVisitor.visitTypeInsn(192, Type.getInternalName(arrayOfClass2[b]));
/*      */         }
/*  984 */         i += type.getSize();
/*      */       } 
/*  986 */       param1MethodVisitor.visitMethodInsn(184, 
/*  987 */           Type.getInternalName(this.method.getDeclaringClass()), this.method
/*  988 */           .getName(), 
/*  989 */           Type.getMethodDescriptor(this.method), this.method
/*  990 */           .getDeclaringClass().isInterface());
/*  991 */       param1MethodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
/*  992 */       return Math.max(i - 1, Type.getReturnType(this.method).getSize());
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.method.equals(((ForStaticMethod)param1Object).method))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.method.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/* 1005 */   public static class ForNonStaticMethod implements Dispatcher { private static final Object[] NO_ARGUMENTS = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Method method;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForNonStaticMethod(Method param1Method) {
/* 1018 */       this.method = param1Method;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object invoke(Object[] param1ArrayOfObject) {
/*      */       Object[] arrayOfObject;
/* 1026 */       if (param1ArrayOfObject.length == 1) {
/* 1027 */         arrayOfObject = NO_ARGUMENTS;
/*      */       } else {
/* 1029 */         arrayOfObject = new Object[param1ArrayOfObject.length - 1];
/* 1030 */         System.arraycopy(param1ArrayOfObject, 1, arrayOfObject, 0, arrayOfObject.length);
/*      */       } 
/* 1032 */       return JavaDispatcher.a().invoke(this.method, param1ArrayOfObject[0], arrayOfObject);
/*      */     }
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.method.equals(((ForNonStaticMethod)param1Object).method))));
/*      */     } public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.method.hashCode();
/*      */     }
/* 1039 */     public int apply(MethodVisitor param1MethodVisitor, Method param1Method) { Class[] arrayOfClass1 = param1Method.getParameterTypes(), arrayOfClass2 = this.method.getParameterTypes();
/* 1040 */       int i = 1;
/* 1041 */       for (byte b = 0; b < arrayOfClass1.length; b++) {
/* 1042 */         Type type = Type.getType(arrayOfClass1[b]);
/* 1043 */         param1MethodVisitor.visitVarInsn(type.getOpcode(21), i);
/* 1044 */         if (arrayOfClass1[b] != ((b == 0) ? this.method.getDeclaringClass() : arrayOfClass2[b - 1])) {
/* 1045 */           param1MethodVisitor.visitTypeInsn(192, Type.getInternalName((b == 0) ? this.method
/* 1046 */                 .getDeclaringClass() : arrayOfClass2[b - 1]));
/*      */         }
/*      */         
/* 1049 */         i += type.getSize();
/*      */       } 
/* 1051 */       param1MethodVisitor.visitMethodInsn(this.method.getDeclaringClass().isInterface() ? 185 : 182, 
/* 1052 */           Type.getInternalName(this.method.getDeclaringClass()), this.method
/* 1053 */           .getName(), 
/* 1054 */           Type.getMethodDescriptor(this.method), this.method
/* 1055 */           .getDeclaringClass().isInterface());
/* 1056 */       param1MethodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
/* 1057 */       return Math.max(i - 1, Type.getReturnType(this.method).getSize()); } } protected static interface Dispatcher { @MaybeNull Object invoke(Object[] param1ArrayOfObject); int apply(MethodVisitor param1MethodVisitor, Method param1Method); @Enhance public static class ForInstanceCheck implements Dispatcher { private final Class<?> target; protected ForInstanceCheck(Class<?> param2Class) { this.target = param2Class; } public Object invoke(Object[] param2ArrayOfObject) { return Boolean.valueOf(this.target.isInstance(param2ArrayOfObject[0])); } public int apply(MethodVisitor param2MethodVisitor, Method param2Method) { param2MethodVisitor.visitVarInsn(25, 1); param2MethodVisitor.visitTypeInsn(193, Type.getInternalName(this.target)); param2MethodVisitor.visitInsn(172); return 1; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.target.equals(((ForInstanceCheck)param2Object).target)))); } public int hashCode() { return getClass().hashCode() * 31 + this.target.hashCode(); } } @Enhance public static class ForContainerCreation implements Dispatcher { private final Class<?> target; protected ForContainerCreation(Class<?> param2Class) { this.target = param2Class; } public Object invoke(Object[] param2ArrayOfObject) { return Array.newInstance(this.target, ((Integer)param2ArrayOfObject[0]).intValue()); } public int apply(MethodVisitor param2MethodVisitor, Method param2Method) { param2MethodVisitor.visitVarInsn(21, 1); param2MethodVisitor.visitTypeInsn(189, Type.getInternalName(this.target)); param2MethodVisitor.visitInsn(176); return 1; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.target.equals(((ForContainerCreation)param2Object).target)))); } public int hashCode() { return getClass().hashCode() * 31 + this.target.hashCode(); } } public enum ForDefaultValue implements Dispatcher { VOID(null, 0, 177, 0), BOOLEAN((String)Boolean.FALSE, 3, 172, 1), BOOLEAN_REVERSE((String)Boolean.TRUE, 4, 172, 1), BYTE((String)Byte.valueOf((byte)0), 3, 172, 1), SHORT((String)Short.valueOf((short)0), 3, 172, 1), CHARACTER((String)Character.valueOf(false), 3, 172, 1), INTEGER((String)Integer.valueOf(0), 3, 172, 1), LONG((String)Long.valueOf(0L), 9, 173, 2), FLOAT((String)Float.valueOf(0.0F), 11, 174, 1), DOUBLE((String)Double.valueOf(0.0D), 14, 175, 2), REFERENCE(null, 1, 176, 1); @MaybeNull private final Object value; private final int load; private final int returned; private final int size; ForDefaultValue(Object param2Object, int param2Int1, int param2Int2, int param2Int3) { this.value = param2Object; this.load = param2Int1; this.returned = param2Int2; this.size = param2Int3; } protected static JavaDispatcher.Dispatcher of(Class<?> param2Class) { if (param2Class == void.class) return VOID;  if (param2Class == boolean.class) return BOOLEAN;  if (param2Class == byte.class) return BYTE;  if (param2Class == short.class) return SHORT;  if (param2Class == char.class) return CHARACTER;  if (param2Class == int.class) return INTEGER;  if (param2Class == long.class) return LONG;  if (param2Class == float.class) return FLOAT;  if (param2Class == double.class) return DOUBLE;  if (param2Class.isArray()) { if (param2Class.getComponentType() == boolean.class) return OfPrimitiveArray.BOOLEAN;  if (param2Class.getComponentType() == byte.class) return OfPrimitiveArray.BYTE;  if (param2Class.getComponentType() == short.class) return OfPrimitiveArray.SHORT;  if (param2Class.getComponentType() == char.class) return OfPrimitiveArray.CHARACTER;  if (param2Class.getComponentType() == int.class) return OfPrimitiveArray.INTEGER;  if (param2Class.getComponentType() == long.class) return OfPrimitiveArray.LONG;  if (param2Class.getComponentType() == float.class) return OfPrimitiveArray.FLOAT;  if (param2Class.getComponentType() == double.class) return OfPrimitiveArray.DOUBLE;  return OfNonPrimitiveArray.of(param2Class.getComponentType()); }  return REFERENCE; } @MaybeNull public final Object invoke(Object[] param2ArrayOfObject) { return this.value; } public final int apply(MethodVisitor param2MethodVisitor, Method param2Method) { if (this.load != 0) param2MethodVisitor.visitInsn(this.load);  param2MethodVisitor.visitInsn(this.returned); return this.size; } protected enum OfPrimitiveArray implements JavaDispatcher.Dispatcher { BOOLEAN((String)new boolean[0], 4), BYTE((String)new byte[0], 8), SHORT((String)new short[0], 9), CHARACTER((String)new char[0], 5), INTEGER((String)new int[0], 10), LONG((String)new long[0], 11), FLOAT((String)new float[0], 6), DOUBLE((String)new double[0], 7); private final Object value; private final int operand; OfPrimitiveArray(Object param3Object, int param3Int1) { this.value = param3Object; this.operand = param3Int1; } public final Object invoke(Object[] param3ArrayOfObject) { return this.value; } public final int apply(MethodVisitor param3MethodVisitor, Method param3Method) { param3MethodVisitor.visitInsn(3); param3MethodVisitor.visitIntInsn(188, this.operand); param3MethodVisitor.visitInsn(176); return 1; } } @Enhance protected static class OfNonPrimitiveArray implements JavaDispatcher.Dispatcher { @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE) private final Object value; private final Class<?> componentType; protected OfNonPrimitiveArray(Object param3Object, Class<?> param3Class) { this.value = param3Object; this.componentType = param3Class; } protected static JavaDispatcher.Dispatcher of(Class<?> param3Class) { return new OfNonPrimitiveArray(Array.newInstance(param3Class, 0), param3Class); } public Object invoke(Object[] param3ArrayOfObject) { return this.value; } public int apply(MethodVisitor param3MethodVisitor, Method param3Method) { param3MethodVisitor.visitInsn(3); param3MethodVisitor.visitTypeInsn(189, Type.getInternalName(this.componentType)); param3MethodVisitor.visitInsn(176); return 1; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.componentType.equals(((OfNonPrimitiveArray)param3Object).componentType)))); } public int hashCode() { return getClass().hashCode() * 31 + this.componentType.hashCode(); } } } @Enhance public static class ForConstructor implements Dispatcher { private final Constructor<?> constructor; protected ForConstructor(Constructor<?> param2Constructor) { this.constructor = param2Constructor; } public Object invoke(Object[] param2ArrayOfObject) { return JavaDispatcher.a().newInstance(this.constructor, param2ArrayOfObject); } public int apply(MethodVisitor param2MethodVisitor, Method param2Method) { Class[] arrayOfClass1 = param2Method.getParameterTypes(), arrayOfClass2 = this.constructor.getParameterTypes(); param2MethodVisitor.visitTypeInsn(187, Type.getInternalName(this.constructor.getDeclaringClass())); param2MethodVisitor.visitInsn(89); int i = 1; for (byte b = 0; b < arrayOfClass1.length; b++) { Type type = Type.getType(arrayOfClass1[b]); param2MethodVisitor.visitVarInsn(type.getOpcode(21), i); if (arrayOfClass1[b] != arrayOfClass2[b]) param2MethodVisitor.visitTypeInsn(192, Type.getInternalName(arrayOfClass2[b]));  i += type.getSize(); }  param2MethodVisitor.visitMethodInsn(183, Type.getInternalName(this.constructor.getDeclaringClass()), "<init>", Type.getConstructorDescriptor(this.constructor), false); param2MethodVisitor.visitInsn(176); return i + 1; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.constructor.equals(((ForConstructor)param2Object).constructor)))); } public int hashCode() { return getClass().hashCode() * 31 + this.constructor.hashCode(); } } @Enhance public static class ForStaticMethod implements Dispatcher { private final Method method; protected ForStaticMethod(Method param2Method) { this.method = param2Method; } @MaybeNull public Object invoke(Object[] param2ArrayOfObject) { return JavaDispatcher.a().invoke(this.method, null, param2ArrayOfObject); } public int apply(MethodVisitor param2MethodVisitor, Method param2Method) { Class[] arrayOfClass1 = param2Method.getParameterTypes(), arrayOfClass2 = this.method.getParameterTypes(); int i = 1; for (byte b = 0; b < arrayOfClass1.length; b++) { Type type = Type.getType(arrayOfClass1[b]); param2MethodVisitor.visitVarInsn(type.getOpcode(21), i); if (arrayOfClass1[b] != arrayOfClass2[b]) param2MethodVisitor.visitTypeInsn(192, Type.getInternalName(arrayOfClass2[b]));  i += type.getSize(); }  param2MethodVisitor.visitMethodInsn(184, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface()); param2MethodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172)); return Math.max(i - 1, Type.getReturnType(this.method).getSize()); } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.method.equals(((ForStaticMethod)param2Object).method)))); } public int hashCode() { return getClass().hashCode() * 31 + this.method.hashCode(); } } @Enhance public static class ForNonStaticMethod implements Dispatcher { private static final Object[] NO_ARGUMENTS = new Object[0]; private final Method method; public int apply(MethodVisitor param2MethodVisitor, Method param2Method) { Class[] arrayOfClass1 = param2Method.getParameterTypes(), arrayOfClass2 = this.method.getParameterTypes(); int i = 1; for (byte b = 0; b < arrayOfClass1.length; b++) { Type type = Type.getType(arrayOfClass1[b]); param2MethodVisitor.visitVarInsn(type.getOpcode(21), i); if (arrayOfClass1[b] != ((b == 0) ? this.method.getDeclaringClass() : arrayOfClass2[b - 1])) param2MethodVisitor.visitTypeInsn(192, Type.getInternalName((b == 0) ? this.method.getDeclaringClass() : arrayOfClass2[b - 1]));  i += type.getSize(); }  param2MethodVisitor.visitMethodInsn(this.method.getDeclaringClass().isInterface() ? 185 : 182, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface()); param2MethodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172)); return Math.max(i - 1, Type.getReturnType(this.method).getSize()); }
/*      */        protected ForNonStaticMethod(Method param2Method) {
/*      */         this.method = param2Method;
/*      */       } public Object invoke(Object[] param2ArrayOfObject) {
/*      */         Object[] arrayOfObject;
/*      */         if (param2ArrayOfObject.length == 1) {
/*      */           arrayOfObject = NO_ARGUMENTS;
/*      */         } else {
/*      */           arrayOfObject = new Object[param2ArrayOfObject.length - 1];
/*      */           System.arraycopy(param2ArrayOfObject, 1, arrayOfObject, 0, arrayOfObject.length);
/*      */         } 
/*      */         return JavaDispatcher.a().invoke(this.method, param2ArrayOfObject[0], arrayOfObject);
/*      */       } public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.method.equals(((ForNonStaticMethod)param2Object).method))));
/*      */       }
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.method.hashCode();
/*      */       } }
/*      */     @Enhance
/*      */     public static class ForUnresolvedMethod implements Dispatcher { private final String message;
/*      */       protected ForUnresolvedMethod(String param2String) {
/* 1078 */         this.message = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Object invoke(Object[] param2ArrayOfObject) {
/* 1085 */         throw new IllegalStateException("Could not invoke proxy: " + this.message);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int apply(MethodVisitor param2MethodVisitor, Method param2Method)
/*      */       {
/* 1092 */         param2MethodVisitor.visitTypeInsn(187, Type.getInternalName(IllegalStateException.class));
/* 1093 */         param2MethodVisitor.visitInsn(89);
/* 1094 */         param2MethodVisitor.visitLdcInsn(this.message);
/* 1095 */         param2MethodVisitor.visitMethodInsn(183, 
/* 1096 */             Type.getInternalName(IllegalStateException.class), "<init>", 
/*      */             
/* 1098 */             Type.getMethodDescriptor(Type.VOID_TYPE, new Type[] { Type.getType(String.class) }), false);
/*      */         
/* 1100 */         param2MethodVisitor.visitInsn(191);
/* 1101 */         return 3; } public boolean equals(@MaybeNull Object param2Object) { return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.message.equals(((ForUnresolvedMethod)param2Object).message)))); } public int hashCode() { return getClass().hashCode() * 31 + this.message.hashCode(); } } } @Enhance public static class ForUnresolvedMethod implements Dispatcher { private final String message; protected ForUnresolvedMethod(String param1String) { this.message = param1String; } public Object invoke(Object[] param1ArrayOfObject) { throw new IllegalStateException("Could not invoke proxy: " + this.message); } public int apply(MethodVisitor param1MethodVisitor, Method param1Method) { param1MethodVisitor.visitTypeInsn(187, Type.getInternalName(IllegalStateException.class)); param1MethodVisitor.visitInsn(89); param1MethodVisitor.visitLdcInsn(this.message); param1MethodVisitor.visitMethodInsn(183, Type.getInternalName(IllegalStateException.class), "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[] { Type.getType(String.class) }), false); param1MethodVisitor.visitInsn(191); return 3; }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.message.equals(((ForUnresolvedMethod)param1Object).message))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.message.hashCode();
/*      */     } }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   protected static class ProxiedInvocationHandler implements InvocationHandler {
/* 1115 */     private static final Object[] NO_ARGUMENTS = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final String name;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Map<Method, JavaDispatcher.Dispatcher> targets;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ProxiedInvocationHandler(String param1String, Map<Method, JavaDispatcher.Dispatcher> param1Map) {
/* 1134 */       this.name = param1String;
/* 1135 */       this.targets = param1Map;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     public Object invoke(Object param1Object, Method param1Method, @MaybeNull Object[] param1ArrayOfObject) {
/* 1143 */       if (param1Method.getDeclaringClass() == Object.class) {
/* 1144 */         if (param1Method.getName().equals("hashCode"))
/* 1145 */           return Integer.valueOf(super.hashCode()); 
/* 1146 */         if (param1Method.getName().equals("equals"))
/* 1147 */           return Boolean.valueOf((param1ArrayOfObject[0] != null && 
/* 1148 */               Proxy.isProxyClass(param1ArrayOfObject[0].getClass()) && 
/* 1149 */               Proxy.getInvocationHandler(param1ArrayOfObject[0]).equals(this))); 
/* 1150 */         if (param1Method.getName().equals("toString")) {
/* 1151 */           return "Call proxy for " + this.name;
/*      */         }
/* 1153 */         throw new IllegalStateException("Unexpected object method: " + param1Method);
/*      */       } 
/*      */       
/* 1156 */       param1Object = this.targets.get(param1Method);
/*      */       
/*      */       try {
/* 1159 */         if (param1Object == null) {
/* 1160 */           throw new IllegalStateException("No proxy target found for " + param1Method);
/*      */         }
/* 1162 */         return param1Object.invoke((param1ArrayOfObject == null) ? NO_ARGUMENTS : param1ArrayOfObject);
/*      */ 
/*      */       
/*      */       }
/* 1166 */       catch (InvocationTargetException invocationTargetException) {
/* 1167 */         throw (param1Object = null).getTargetException();
/*      */       }
/* 1169 */       catch (RuntimeException runtimeException) {
/* 1170 */         throw param1Object = null;
/* 1171 */       } catch (Error error) {
/* 1172 */         throw param1Object = null;
/* 1173 */       } catch (Throwable throwable) {
/* 1174 */         Class[] arrayOfClass; int i; byte b; for (i = (arrayOfClass = param1Method.getExceptionTypes()).length, b = 0; b < i; b++) {
/* 1175 */           Class<?> clazz; if ((clazz = arrayOfClass[b]).isInstance(throwable)) {
/* 1176 */             throw throwable;
/*      */           }
/*      */         } 
/* 1179 */         throw new IllegalStateException("Failed to invoke proxy for " + param1Method, throwable);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.name.equals(((ProxiedInvocationHandler)param1Object).name) ? false : (!!this.targets.equals(((ProxiedInvocationHandler)param1Object).targets)))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.name.hashCode()) * 31 + this.targets.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   protected static class DynamicClassLoader
/*      */     extends ClassLoader
/*      */   {
/*      */     @MaybeNull
/*      */     private static final String DUMP_FOLDER;
/* 1198 */     private static final Class<?>[] NO_PARAMETER = new Class[0];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1203 */     private static final Object[] NO_ARGUMENT = new Object[0];
/*      */     
/*      */     static {
/*      */       String str;
/*      */     }
/*      */     
/*      */     static {
/*      */       try {
/* 1211 */         str = (String)JavaDispatcher.a((PrivilegedAction)new GetSystemPropertyAction("net.bytebuddy.dump"));
/* 1212 */       } catch (Throwable throwable) {
/* 1213 */         str = null;
/*      */       } 
/* 1215 */       DUMP_FOLDER = str;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected DynamicClassLoader(Class<?> param1Class) {
/* 1224 */       super(param1Class.getClassLoader());
/* 1225 */       JavaDispatcher.b().accept(this, param1Class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"}, justification = "Expected internal invocation.")
/*      */     protected static Object proxy(Class<?> param1Class, Map<Method, JavaDispatcher.Dispatcher> param1Map) {
/*      */       ClassWriter classWriter;
/* 1238 */       (classWriter = new ClassWriter(0)).visit(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).getMinorMajorVersion(), 1, 
/*      */           
/* 1240 */           Type.getInternalName(param1Class) + "$Proxy", null, 
/*      */           
/* 1242 */           Type.getInternalName(Object.class), new String[] {
/* 1243 */             Type.getInternalName(param1Class) });
/* 1244 */       for (Iterator<Map.Entry> iterator = param1Map.entrySet().iterator(); iterator.hasNext(); ) {
/*      */         Map.Entry<Method, ?> entry; Class[] arrayOfClass1;
/* 1246 */         String[] arrayOfString = new String[(arrayOfClass1 = ((Method)(entry = iterator.next()).getKey()).getExceptionTypes()).length];
/* 1247 */         for (byte b1 = 0; b1 < arrayOfClass1.length; b1++) {
/* 1248 */           arrayOfString[b1] = Type.getInternalName(arrayOfClass1[b1]);
/*      */         }
/*      */ 
/*      */         
/*      */         MethodVisitor methodVisitor1;
/*      */ 
/*      */         
/* 1255 */         (methodVisitor1 = classWriter.visitMethod(1, ((Method)entry.getKey()).getName(), Type.getMethodDescriptor(entry.getKey()), null, arrayOfString)).visitCode();
/* 1256 */         int i = ((((Method)entry.getKey()).getModifiers() & 0x8) == 0) ? 1 : 0; Class[] arrayOfClass2; int j; byte b2;
/* 1257 */         for (j = (arrayOfClass2 = ((Method)entry.getKey()).getParameterTypes()).length, b2 = 0; b2 < j; ) { Class clazz = arrayOfClass2[b2];
/* 1258 */           i += Type.getType(clazz).getSize(); b2++; }
/*      */         
/* 1260 */         methodVisitor1.visitMaxs(((JavaDispatcher.Dispatcher)entry.getValue()).apply(methodVisitor1, entry.getKey()), i);
/* 1261 */         methodVisitor1.visitEnd();
/*      */       } 
/*      */ 
/*      */       
/*      */       MethodVisitor methodVisitor;
/*      */ 
/*      */       
/* 1268 */       (methodVisitor = classWriter.visitMethod(1, "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), null, null)).visitCode();
/* 1269 */       methodVisitor.visitVarInsn(25, 0);
/* 1270 */       methodVisitor.visitMethodInsn(183, 
/* 1271 */           Type.getInternalName(Object.class), "<init>", 
/*      */           
/* 1273 */           Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), false);
/*      */       
/* 1275 */       methodVisitor.visitInsn(177);
/* 1276 */       methodVisitor.visitMaxs(1, 1);
/* 1277 */       methodVisitor.visitEnd();
/* 1278 */       classWriter.visitEnd();
/* 1279 */       byte[] arrayOfByte = classWriter.toByteArray();
/* 1280 */       if (DUMP_FOLDER != null) {
/*      */         try {
/* 1282 */           FileOutputStream fileOutputStream = new FileOutputStream(new File(DUMP_FOLDER, param1Class.getName() + "$Proxy.class"));
/*      */           try {
/* 1284 */             fileOutputStream.write(arrayOfByte);
/*      */           } finally {
/* 1286 */             fileOutputStream.close();
/*      */           } 
/* 1288 */         } catch (Throwable throwable) {}
/*      */       }
/*      */ 
/*      */       
/*      */       try {
/* 1293 */         return (new DynamicClassLoader(param1Class))
/* 1294 */           .defineClass(param1Class.getName() + "$Proxy", arrayOfByte, 0, arrayOfByte.length, JavaDispatcher.class
/*      */ 
/*      */ 
/*      */             
/* 1298 */             .getProtectionDomain())
/* 1299 */           .getConstructor(NO_PARAMETER)
/* 1300 */           .newInstance(NO_ARGUMENT);
/* 1301 */       } catch (Exception exception) {
/* 1302 */         throw new IllegalStateException("Failed to create proxy for " + param1Class.getName(), exception);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"}, justification = "Expected internal invocation.")
/*      */     protected static Invoker invoker() {
/*      */       ClassWriter classWriter;
/* 1314 */       (classWriter = new ClassWriter(0)).visit(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).getMinorMajorVersion(), 1, 
/*      */           
/* 1316 */           Type.getInternalName(Invoker.class) + "$Dispatcher", null, 
/*      */           
/* 1318 */           Type.getInternalName(Object.class), new String[] {
/* 1319 */             Type.getInternalName(Invoker.class) }); Method[] arrayOfMethod; int i; byte b;
/* 1320 */       for (i = (arrayOfMethod = (Method[])GraalImageCode.getCurrent().sorted((Object[])Invoker.class.getMethods(), (Comparator)MethodComparator.INSTANCE)).length, b = 0; b < i; b++) {
/*      */         Method method; Class[] arrayOfClass;
/* 1322 */         String[] arrayOfString = new String[(arrayOfClass = (method = arrayOfMethod[b]).getExceptionTypes()).length];
/* 1323 */         for (byte b1 = 0; b1 < arrayOfClass.length; b1++) {
/* 1324 */           arrayOfString[b1] = Type.getInternalName(arrayOfClass[b1]);
/*      */         }
/*      */ 
/*      */         
/*      */         MethodVisitor methodVisitor1;
/*      */ 
/*      */         
/* 1331 */         (methodVisitor1 = classWriter.visitMethod(1, method.getName(), Type.getMethodDescriptor(method), null, arrayOfString)).visitCode();
/* 1332 */         int j = 1;
/* 1333 */         Type[] arrayOfType = new Type[(method.getParameterTypes()).length - 1];
/* 1334 */         for (byte b2 = 0; b2 < (method.getParameterTypes()).length; b2++) {
/* 1335 */           Type type = Type.getType(method.getParameterTypes()[b2]);
/* 1336 */           if (b2 > 0) {
/* 1337 */             arrayOfType[b2 - 1] = type;
/*      */           }
/* 1339 */           methodVisitor1.visitVarInsn(type.getOpcode(21), j);
/* 1340 */           j += type.getSize();
/*      */         } 
/* 1342 */         methodVisitor1.visitMethodInsn(182, 
/* 1343 */             Type.getInternalName(method.getParameterTypes()[0]), method
/* 1344 */             .getName(), 
/* 1345 */             Type.getMethodDescriptor(Type.getReturnType(method), arrayOfType), false);
/*      */         
/* 1347 */         methodVisitor1.visitInsn(Type.getReturnType(method).getOpcode(172));
/* 1348 */         methodVisitor1.visitMaxs(Math.max(j - 1, Type.getReturnType(method).getSize()), j);
/* 1349 */         methodVisitor1.visitEnd();
/*      */       } 
/*      */ 
/*      */       
/*      */       MethodVisitor methodVisitor;
/*      */ 
/*      */       
/* 1356 */       (methodVisitor = classWriter.visitMethod(1, "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), null, null)).visitCode();
/* 1357 */       methodVisitor.visitVarInsn(25, 0);
/* 1358 */       methodVisitor.visitMethodInsn(183, 
/* 1359 */           Type.getInternalName(Object.class), "<init>", 
/*      */           
/* 1361 */           Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), false);
/*      */       
/* 1363 */       methodVisitor.visitInsn(177);
/* 1364 */       methodVisitor.visitMaxs(1, 1);
/* 1365 */       methodVisitor.visitEnd();
/* 1366 */       classWriter.visitEnd();
/* 1367 */       byte[] arrayOfByte = classWriter.toByteArray();
/*      */       try {
/*      */         String str;
/* 1370 */         if ((str = System.getProperty("net.bytebuddy.dump")) != null) {
/* 1371 */           FileOutputStream fileOutputStream = new FileOutputStream(new File(str, Invoker.class.getName() + "$Dispatcher.class"));
/*      */           try {
/* 1373 */             fileOutputStream.write(arrayOfByte);
/*      */           } finally {
/* 1375 */             fileOutputStream.close();
/*      */           } 
/*      */         } 
/* 1378 */       } catch (Throwable throwable) {}
/*      */ 
/*      */       
/*      */       try {
/* 1382 */         return (new DynamicClassLoader(Invoker.class))
/* 1383 */           .defineClass(Invoker.class.getName() + "$Dispatcher", arrayOfByte, 0, arrayOfByte.length, JavaDispatcher.class
/*      */ 
/*      */ 
/*      */             
/* 1387 */             .getProtectionDomain())
/* 1388 */           .getConstructor(NO_PARAMETER)
/* 1389 */           .newInstance(NO_ARGUMENT);
/* 1390 */       } catch (UnsupportedOperationException unsupportedOperationException) {
/* 1391 */         return new JavaDispatcher.DirectInvoker((byte)0);
/* 1392 */       } catch (Exception exception) {
/* 1393 */         throw new IllegalStateException("Failed to create invoker for " + Invoker.class.getName(), exception);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static interface Resolver
/*      */     {
/*      */       void accept(@MaybeNull ClassLoader param2ClassLoader, Class<?> param2Class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum CreationAction
/*      */         implements PrivilegedAction<Resolver>
/*      */       {
/* 1418 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*      */         public final JavaDispatcher.DynamicClassLoader.Resolver run() {
/*      */           try {
/* 1426 */             Class<?> clazz = Class.forName("java.lang.Module", false, (ClassLoader)null);
/* 1427 */             return new JavaDispatcher.DynamicClassLoader.Resolver.ForModuleSystem(Class.class.getMethod("getModule", new Class[0]), clazz
/* 1428 */                 .getMethod("isExported", new Class[] { String.class }), clazz
/* 1429 */                 .getMethod("addExports", new Class[] { String.class, clazz }), ClassLoader.class
/* 1430 */                 .getMethod("getUnnamedModule", new Class[0]));
/* 1431 */           } catch (Exception exception) {
/* 1432 */             return JavaDispatcher.DynamicClassLoader.Resolver.NoOp.INSTANCE;
/*      */           } 
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum NoOp
/*      */         implements Resolver
/*      */       {
/* 1445 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final void accept(@MaybeNull ClassLoader param3ClassLoader, Class<?> param3Class) {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class ForModuleSystem
/*      */         implements Resolver
/*      */       {
/*      */         private final Method getModule;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method isExported;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method addExports;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method getUnnamedModule;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForModuleSystem(Method param3Method1, Method param3Method2, Method param3Method3, Method param3Method4) {
/* 1493 */           this.getModule = param3Method1;
/* 1494 */           this.isExported = param3Method2;
/* 1495 */           this.addExports = param3Method3;
/* 1496 */           this.getUnnamedModule = param3Method4;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should always be wrapped for clarity.")
/*      */         public void accept(@MaybeNull ClassLoader param3ClassLoader, Class<?> param3Class)
/*      */         {
/*      */           Package package_;
/* 1505 */           if ((package_ = param3Class.getPackage()) != null)
/*      */             
/* 1507 */             try { Object object = this.getModule.invoke(param3Class, new Object[0]);
/* 1508 */               if (!((Boolean)this.isExported.invoke(object, new Object[] { package_.getName() })).booleanValue())
/* 1509 */                 this.addExports.invoke(object, new Object[] { package_.getName(), this.getUnnamedModule.invoke(param3ClassLoader, new Object[0]) }); 
/*      */               return; }
/* 1511 */             catch (Exception exception)
/* 1512 */             { throw new IllegalStateException("Failed to adjust module graph for dispatcher", exception); }   } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.getModule.equals(((ForModuleSystem)param3Object).getModule) ? false : (!this.isExported.equals(((ForModuleSystem)param3Object).isExported) ? false : (!this.addExports.equals(((ForModuleSystem)param3Object).addExports) ? false : (!!this.getUnnamedModule.equals(((ForModuleSystem)param3Object).getUnnamedModule))))))); } public int hashCode() { return (((getClass().hashCode() * 31 + this.getModule.hashCode()) * 31 + this.isExported.hashCode()) * 31 + this.addExports.hashCode()) * 31 + this.getUnnamedModule.hashCode(); } } } } public enum CreationAction implements PrivilegedAction<DynamicClassLoader.Resolver> { INSTANCE; @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final JavaDispatcher.DynamicClassLoader.Resolver run() { try { Class<?> clazz = Class.forName("java.lang.Module", false, (ClassLoader)null); return new JavaDispatcher.DynamicClassLoader.Resolver.ForModuleSystem(Class.class.getMethod("getModule", new Class[0]), clazz.getMethod("isExported", new Class[] { String.class }), clazz.getMethod("addExports", new Class[] { String.class, clazz }), ClassLoader.class.getMethod("getUnnamedModule", new Class[0])); } catch (Exception exception) { return JavaDispatcher.DynamicClassLoader.Resolver.NoOp.INSTANCE; }  } } protected static interface Resolver { void accept(@MaybeNull ClassLoader param1ClassLoader, Class<?> param1Class); public enum CreationAction implements PrivilegedAction<Resolver> { INSTANCE; @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final JavaDispatcher.DynamicClassLoader.Resolver run() { try { Class<?> clazz = Class.forName("java.lang.Module", false, (ClassLoader)null); return new JavaDispatcher.DynamicClassLoader.Resolver.ForModuleSystem(Class.class.getMethod("getModule", new Class[0]), clazz.getMethod("isExported", new Class[] { String.class }), clazz.getMethod("addExports", new Class[] { String.class, clazz }), ClassLoader.class.getMethod("getUnnamedModule", new Class[0])); } catch (Exception exception) { return JavaDispatcher.DynamicClassLoader.Resolver.NoOp.INSTANCE; }  } } public enum NoOp implements Resolver { INSTANCE; public final void accept(@MaybeNull ClassLoader param3ClassLoader, Class<?> param3Class) {} } @Enhance public static class ForModuleSystem implements Resolver { private final Method getModule; private final Method isExported; private final Method addExports; private final Method getUnnamedModule; protected ForModuleSystem(Method param3Method1, Method param3Method2, Method param3Method3, Method param3Method4) { this.getModule = param3Method1; this.isExported = param3Method2; this.addExports = param3Method3; this.getUnnamedModule = param3Method4; } @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should always be wrapped for clarity.") public void accept(@MaybeNull ClassLoader param3ClassLoader, Class<?> param3Class) { Package package_; if ((package_ = param3Class.getPackage()) != null) try { Object object = this.getModule.invoke(param3Class, new Object[0]); if (!((Boolean)this.isExported.invoke(object, new Object[] { package_.getName() })).booleanValue()) this.addExports.invoke(object, new Object[] { package_.getName(), this.getUnnamedModule.invoke(param3ClassLoader, new Object[0]) });  return; } catch (Exception exception) { throw new IllegalStateException("Failed to adjust module graph for dispatcher", exception); }
/*      */             }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param3Object) {
/*      */         return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.getModule.equals(((ForModuleSystem)param3Object).getModule) ? false : (!this.isExported.equals(((ForModuleSystem)param3Object).isExported) ? false : (!this.addExports.equals(((ForModuleSystem)param3Object).addExports) ? false : (!!this.getUnnamedModule.equals(((ForModuleSystem)param3Object).getUnnamedModule)))))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return (((getClass().hashCode() * 31 + this.getModule.hashCode()) * 31 + this.isExported.hashCode()) * 31 + this.addExports.hashCode()) * 31 + this.getUnnamedModule.hashCode();
/*      */       } }
/*      */      }
/*      */ 
/*      */   
/*      */   @Documented
/*      */   @Target({ElementType.TYPE, ElementType.METHOD})
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   public static @interface Defaults {}
/*      */   
/*      */   @Documented
/*      */   @Target({ElementType.METHOD})
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   public static @interface Container {}
/*      */   
/*      */   @Documented
/*      */   @Target({ElementType.METHOD})
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   public static @interface Instance {}
/*      */   
/*      */   @Documented
/*      */   @Target({ElementType.METHOD})
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   public static @interface IsConstructor {}
/*      */   
/*      */   @Documented
/*      */   @Target({ElementType.METHOD})
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   public static @interface IsStatic {}
/*      */   
/*      */   @Documented
/*      */   @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   public static @interface Proxied {
/*      */     String value();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\dispatcher\JavaDispatcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */