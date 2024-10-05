/*      */ package net.bytebuddy.dynamic.loading;
/*      */ 
/*      */ import com.sun.jna.FunctionMapper;
/*      */ import com.sun.jna.JNIEnv;
/*      */ import com.sun.jna.Library;
/*      */ import com.sun.jna.Native;
/*      */ import com.sun.jna.NativeLibrary;
/*      */ import com.sun.jna.Platform;
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.lang.instrument.Instrumentation;
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.ReflectPermission;
/*      */ import java.lang.reflect.Type;
/*      */ import java.net.URL;
/*      */ import java.security.AccessController;
/*      */ import java.security.Permission;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.security.ProtectionDomain;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.jar.JarEntry;
/*      */ import java.util.jar.JarFile;
/*      */ import java.util.jar.JarOutputStream;
/*      */ import net.bytebuddy.ByteBuddy;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.asm.AsmVisitorWrapper;
/*      */ import net.bytebuddy.asm.MemberRemoval;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*      */ import net.bytebuddy.description.modifier.ModifierContributor;
/*      */ import net.bytebuddy.description.modifier.Visibility;
/*      */ import net.bytebuddy.description.type.PackageDescription;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.DynamicType;
/*      */ import net.bytebuddy.dynamic.scaffold.TypeValidation;
/*      */ import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
/*      */ import net.bytebuddy.implementation.FixedValue;
/*      */ import net.bytebuddy.implementation.Implementation;
/*      */ import net.bytebuddy.implementation.MethodCall;
/*      */ import net.bytebuddy.matcher.ElementMatcher;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.GraalImageCode;
/*      */ import net.bytebuddy.utility.JavaModule;
/*      */ import net.bytebuddy.utility.JavaType;
/*      */ import net.bytebuddy.utility.RandomString;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsStatic;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ import net.bytebuddy.utility.nullability.UnknownNull;
/*      */ import net.bytebuddy.utility.privilege.GetMethodAction;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface ClassInjector
/*      */ {
/*   75 */   public static final Permission SUPPRESS_ACCESS_CHECKS = new ReflectPermission("suppressAccessChecks");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final boolean ALLOW_EXISTING_TYPES = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isAlive();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> paramMap);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> paramMap);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class AbstractBase
/*      */     implements ClassInjector
/*      */   {
/*      */     public Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> param1Map) {
/*  114 */       LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<Object, Object>();
/*  115 */       for (Map.Entry<? extends TypeDescription, byte> entry : param1Map.entrySet()) {
/*  116 */         linkedHashMap1.put(((TypeDescription)entry.getKey()).getName(), entry.getValue());
/*      */       }
/*  118 */       Map<String, Class<?>> map = injectRaw((Map)linkedHashMap1);
/*  119 */       LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<Object, Object>();
/*  120 */       for (TypeDescription typeDescription : param1Map.keySet()) {
/*  121 */         linkedHashMap2.put(typeDescription, map.get(typeDescription.getName()));
/*      */       }
/*  123 */       return (Map)linkedHashMap2;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class UsingReflection
/*      */     extends AbstractBase
/*      */   {
/*  136 */     private static final Dispatcher.Initializable DISPATCHER = doPrivileged(Dispatcher.CreationAction.INSTANCE);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  141 */     private static final System SYSTEM = doPrivileged(JavaDispatcher.of(System.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  146 */     private static final Method CHECK_PERMISSION = doPrivileged((PrivilegedAction<Method>)new GetMethodAction("java.lang.SecurityManager", "checkPermission", new Class[] { Permission.class })); private final ClassLoader classLoader; @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) private final ProtectionDomain protectionDomain; private final PackageDefinitionStrategy packageDefinitionStrategy; private final boolean forbidExisting; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
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
/*      */     
/*      */     public UsingReflection(ClassLoader param1ClassLoader) {
/*  179 */       this(param1ClassLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public UsingReflection(ClassLoader param1ClassLoader, @MaybeNull ProtectionDomain param1ProtectionDomain) {
/*  190 */       this(param1ClassLoader, param1ProtectionDomain, PackageDefinitionStrategy.Trivial.INSTANCE, false);
/*      */     }
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
/*      */     public UsingReflection(ClassLoader param1ClassLoader, @MaybeNull ProtectionDomain param1ProtectionDomain, PackageDefinitionStrategy param1PackageDefinitionStrategy, boolean param1Boolean) {
/*  208 */       if (param1ClassLoader == null) {
/*  209 */         throw new IllegalArgumentException("Cannot inject classes into the bootstrap class loader");
/*      */       }
/*  211 */       this.classLoader = param1ClassLoader;
/*  212 */       this.protectionDomain = param1ProtectionDomain;
/*  213 */       this.packageDefinitionStrategy = param1PackageDefinitionStrategy;
/*  214 */       this.forbidExisting = param1Boolean;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/*  226 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAlive() {
/*  233 */       return isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> param1Map) {
/*  240 */       Dispatcher dispatcher = DISPATCHER.initialize();
/*  241 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  242 */       for (Map.Entry<? extends String, byte> entry : param1Map.entrySet()) {
/*  243 */         synchronized (dispatcher.getClassLoadingLock(this.classLoader, (String)entry.getKey())) {
/*      */           Class<?> clazz;
/*  245 */           if ((clazz = dispatcher.findClass(this.classLoader, (String)entry.getKey())) == null) {
/*      */ 
/*      */             
/*  248 */             String str = ((String)entry.getKey()).substring(0, i); int i;
/*      */             PackageDefinitionStrategy.Definition definition;
/*  250 */             if ((i = ((String)entry.getKey()).lastIndexOf('.')) != -1 && (definition = this.packageDefinitionStrategy.define(this.classLoader, str, (String)entry.getKey())).isDefined()) {
/*      */               Package package_;
/*  252 */               if ((package_ = dispatcher.getDefinedPackage(this.classLoader, str)) == null) {
/*      */                 try {
/*  254 */                   dispatcher.definePackage(this.classLoader, str, definition
/*      */                       
/*  256 */                       .getSpecificationTitle(), definition
/*  257 */                       .getSpecificationVersion(), definition
/*  258 */                       .getSpecificationVendor(), definition
/*  259 */                       .getImplementationTitle(), definition
/*  260 */                       .getImplementationVersion(), definition
/*  261 */                       .getImplementationVendor(), definition
/*  262 */                       .getSealBase());
/*  263 */                 } catch (IllegalStateException illegalStateException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  273 */                   if ((package_ = dispatcher.getPackage(this.classLoader, str)) == null)
/*  274 */                     throw illegalStateException; 
/*  275 */                   if (!definition.isCompatibleTo(package_)) {
/*  276 */                     throw new SecurityException("Sealing violation for package " + str + " (getPackage fallback)");
/*      */                   }
/*      */                 } 
/*  279 */               } else if (!definition.isCompatibleTo(package_)) {
/*  280 */                 throw new SecurityException("Sealing violation for package " + str);
/*      */               } 
/*      */             } 
/*      */             
/*  284 */             clazz = dispatcher.defineClass(this.classLoader, (String)entry.getKey(), (byte[])entry.getValue(), this.protectionDomain);
/*  285 */           } else if (this.forbidExisting) {
/*  286 */             throw new IllegalStateException("Cannot inject already loaded type: " + clazz);
/*      */           } 
/*  288 */           hashMap.put(entry.getKey(), clazz);
/*      */         } 
/*      */       } 
/*  291 */       return (Map)hashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static boolean isAvailable() {
/*  300 */       return DISPATCHER.isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassInjector ofSystemClassLoader() {
/*  309 */       return new UsingReflection(ClassLoader.getSystemClassLoader());
/*      */     } public boolean equals(@MaybeNull Object param1Object) { ProtectionDomain protectionDomain2; if (this == param1Object)
/*      */         return true;  if (param1Object == null)
/*      */         return false;  if (getClass() != param1Object.getClass())
/*      */         return false;  if (this.forbidExisting != ((UsingReflection)param1Object).forbidExisting)
/*      */         return false;  if (!this.classLoader.equals(((UsingReflection)param1Object).classLoader))
/*      */         return false;  ProtectionDomain protectionDomain1 = ((UsingReflection)param1Object).protectionDomain; if (protectionDomain1 != null) { if ((protectionDomain2 = this.protectionDomain) != null) { if (!protectionDomain2.equals(protectionDomain1))
/*      */             return false;  } else { return false; }
/*      */          }
/*      */       else if ((protectionDomain2 = this.protectionDomain) != null) { return false; }
/*      */        return !!this.packageDefinitionStrategy.equals(((UsingReflection)param1Object).packageDefinitionStrategy); } public int hashCode() { ProtectionDomain protectionDomain; if ((protectionDomain = this.protectionDomain) != null); return (((getClass().hashCode() * 31 + this.classLoader.hashCode()) * 31 + protectionDomain.hashCode()) * 31 + this.packageDefinitionStrategy.hashCode()) * 31 + this.forbidExisting; } @Proxied("java.lang.System") protected static interface System {
/*      */       @MaybeNull @IsStatic @Defaults @Proxied("getSecurityManager") Object getSecurityManager(); }
/*  321 */     protected static interface Dispatcher { @AlwaysNull public static final Class<?> UNDEFINED = null;
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
/*      */       Object getClassLoadingLock(ClassLoader param2ClassLoader, String param2String);
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
/*      */       @MaybeNull
/*      */       Class<?> findClass(ClassLoader param2ClassLoader, String param2String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Class<?> defineClass(ClassLoader param2ClassLoader, String param2String, byte[] param2ArrayOfbyte, @MaybeNull ProtectionDomain param2ProtectionDomain);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       Package getDefinedPackage(ClassLoader param2ClassLoader, String param2String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       Package getPackage(ClassLoader param2ClassLoader, String param2String);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Package definePackage(ClassLoader param2ClassLoader, String param2String1, @MaybeNull String param2String2, @MaybeNull String param2String3, @MaybeNull String param2String4, @MaybeNull String param2String5, @MaybeNull String param2String6, @MaybeNull String param2String7, @MaybeNull URL param2URL);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static interface Initializable
/*      */       {
/*      */         boolean isAvailable();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         ClassInjector.UsingReflection.Dispatcher initialize();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         public static class Unavailable
/*      */           implements ClassInjector.UsingReflection.Dispatcher, Initializable
/*      */         {
/*      */           private final String message;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected Unavailable(String param4String) {
/*  433 */             this.message = param4String;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isAvailable() {
/*  440 */             return false;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public ClassInjector.UsingReflection.Dispatcher initialize() {
/*  447 */             return this;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getClassLoadingLock(ClassLoader param4ClassLoader, String param4String) {
/*  454 */             return param4ClassLoader;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Class<?> findClass(ClassLoader param4ClassLoader, String param4String) {
/*      */             try {
/*  462 */               return param4ClassLoader.loadClass(param4String);
/*  463 */             } catch (ClassNotFoundException classNotFoundException) {
/*  464 */               return UNDEFINED;
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Class<?> defineClass(ClassLoader param4ClassLoader, String param4String, byte[] param4ArrayOfbyte, @MaybeNull ProtectionDomain param4ProtectionDomain) {
/*  472 */             throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Package getDefinedPackage(ClassLoader param4ClassLoader, String param4String) {
/*  479 */             throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Package getPackage(ClassLoader param4ClassLoader, String param4String) {
/*  486 */             throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
/*      */           }
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
/*      */           public Package definePackage(ClassLoader param4ClassLoader, String param4String1, @MaybeNull String param4String2, @MaybeNull String param4String3, @MaybeNull String param4String4, @MaybeNull String param4String5, @MaybeNull String param4String6, @MaybeNull String param4String7, @MaybeNull URL param4URL) {
/*  501 */             throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
/*      */           }
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.message.equals(((Unavailable)param4Object).message))));
/*      */           }
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.message.hashCode();
/*      */           } }
/*      */       }
/*      */       
/*      */       public enum CreationAction implements PrivilegedAction<Initializable> {
/*  514 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*      */         public final ClassInjector.UsingReflection.Dispatcher.Initializable run() {
/*      */           try {
/*  522 */             if (JavaModule.isSupported()) {
/*  523 */               if (ClassInjector.UsingUnsafe.isAvailable())
/*  524 */                 return ClassInjector.UsingReflection.Dispatcher.UsingUnsafeInjection.make(); 
/*  525 */               return ClassInjector.UsingReflection.Dispatcher.UsingUnsafeOverride.make();
/*      */             } 
/*  527 */             return ClassInjector.UsingReflection.Dispatcher.Direct.make();
/*      */           }
/*  529 */           catch (InvocationTargetException invocationTargetException) {
/*  530 */             return new ClassInjector.UsingReflection.Dispatcher.Initializable.Unavailable(invocationTargetException.getTargetException().getMessage());
/*  531 */           } catch (Exception exception) {
/*  532 */             return new ClassInjector.UsingReflection.Dispatcher.Initializable.Unavailable(exception.getMessage());
/*      */           } 
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static abstract class Direct
/*      */         implements Dispatcher, Initializable
/*      */       {
/*      */         protected final Method findLoadedClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Method defineClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @UnknownNull
/*      */         protected final Method getDefinedPackage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Method getPackage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Method definePackage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Direct(Method param3Method1, Method param3Method2, @MaybeNull Method param3Method3, Method param3Method4, Method param3Method5) {
/*  583 */           this.findLoadedClass = param3Method1;
/*  584 */           this.defineClass = param3Method2;
/*  585 */           this.getDefinedPackage = param3Method3;
/*  586 */           this.getPackage = param3Method4;
/*  587 */           this.definePackage = param3Method5;
/*      */         }
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
/*      */         @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Assuring privilege is explicit user responsibility.")
/*      */         protected static ClassInjector.UsingReflection.Dispatcher.Initializable make() {
/*      */           // Byte code:
/*      */           //   0: invokestatic isSupported : ()Z
/*      */           //   3: ifeq -> 27
/*      */           //   6: ldc java/lang/ClassLoader
/*      */           //   8: ldc 'getDefinedPackage'
/*      */           //   10: iconst_1
/*      */           //   11: anewarray java/lang/Class
/*      */           //   14: dup
/*      */           //   15: iconst_0
/*      */           //   16: ldc java/lang/String
/*      */           //   18: aastore
/*      */           //   19: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   22: astore_0
/*      */           //   23: goto -> 29
/*      */           //   26: pop
/*      */           //   27: aconst_null
/*      */           //   28: astore_0
/*      */           //   29: ldc java/lang/ClassLoader
/*      */           //   31: ldc 'getPackage'
/*      */           //   33: iconst_1
/*      */           //   34: anewarray java/lang/Class
/*      */           //   37: dup
/*      */           //   38: iconst_0
/*      */           //   39: ldc java/lang/String
/*      */           //   41: aastore
/*      */           //   42: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   45: dup
/*      */           //   46: astore_1
/*      */           //   47: iconst_1
/*      */           //   48: invokevirtual setAccessible : (Z)V
/*      */           //   51: ldc java/lang/ClassLoader
/*      */           //   53: ldc 'findLoadedClass'
/*      */           //   55: iconst_1
/*      */           //   56: anewarray java/lang/Class
/*      */           //   59: dup
/*      */           //   60: iconst_0
/*      */           //   61: ldc java/lang/String
/*      */           //   63: aastore
/*      */           //   64: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   67: dup
/*      */           //   68: astore_2
/*      */           //   69: iconst_1
/*      */           //   70: invokevirtual setAccessible : (Z)V
/*      */           //   73: ldc java/lang/ClassLoader
/*      */           //   75: ldc 'defineClass'
/*      */           //   77: iconst_5
/*      */           //   78: anewarray java/lang/Class
/*      */           //   81: dup
/*      */           //   82: iconst_0
/*      */           //   83: ldc java/lang/String
/*      */           //   85: aastore
/*      */           //   86: dup
/*      */           //   87: iconst_1
/*      */           //   88: ldc [B
/*      */           //   90: aastore
/*      */           //   91: dup
/*      */           //   92: iconst_2
/*      */           //   93: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
/*      */           //   96: aastore
/*      */           //   97: dup
/*      */           //   98: iconst_3
/*      */           //   99: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
/*      */           //   102: aastore
/*      */           //   103: dup
/*      */           //   104: iconst_4
/*      */           //   105: ldc java/security/ProtectionDomain
/*      */           //   107: aastore
/*      */           //   108: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   111: dup
/*      */           //   112: astore_3
/*      */           //   113: iconst_1
/*      */           //   114: invokevirtual setAccessible : (Z)V
/*      */           //   117: ldc java/lang/ClassLoader
/*      */           //   119: ldc 'definePackage'
/*      */           //   121: bipush #8
/*      */           //   123: anewarray java/lang/Class
/*      */           //   126: dup
/*      */           //   127: iconst_0
/*      */           //   128: ldc java/lang/String
/*      */           //   130: aastore
/*      */           //   131: dup
/*      */           //   132: iconst_1
/*      */           //   133: ldc java/lang/String
/*      */           //   135: aastore
/*      */           //   136: dup
/*      */           //   137: iconst_2
/*      */           //   138: ldc java/lang/String
/*      */           //   140: aastore
/*      */           //   141: dup
/*      */           //   142: iconst_3
/*      */           //   143: ldc java/lang/String
/*      */           //   145: aastore
/*      */           //   146: dup
/*      */           //   147: iconst_4
/*      */           //   148: ldc java/lang/String
/*      */           //   150: aastore
/*      */           //   151: dup
/*      */           //   152: iconst_5
/*      */           //   153: ldc java/lang/String
/*      */           //   155: aastore
/*      */           //   156: dup
/*      */           //   157: bipush #6
/*      */           //   159: ldc java/lang/String
/*      */           //   161: aastore
/*      */           //   162: dup
/*      */           //   163: bipush #7
/*      */           //   165: ldc java/net/URL
/*      */           //   167: aastore
/*      */           //   168: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   171: dup
/*      */           //   172: astore #4
/*      */           //   174: iconst_1
/*      */           //   175: invokevirtual setAccessible : (Z)V
/*      */           //   178: ldc java/lang/ClassLoader
/*      */           //   180: ldc 'getClassLoadingLock'
/*      */           //   182: iconst_1
/*      */           //   183: anewarray java/lang/Class
/*      */           //   186: dup
/*      */           //   187: iconst_0
/*      */           //   188: ldc java/lang/String
/*      */           //   190: aastore
/*      */           //   191: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   194: dup
/*      */           //   195: astore #5
/*      */           //   197: iconst_1
/*      */           //   198: invokevirtual setAccessible : (Z)V
/*      */           //   201: new net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Direct$ForJava7CapableVm
/*      */           //   204: dup
/*      */           //   205: aload_2
/*      */           //   206: aload_3
/*      */           //   207: aload_0
/*      */           //   208: aload_1
/*      */           //   209: aload #4
/*      */           //   211: aload #5
/*      */           //   213: invokespecial <init> : (Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V
/*      */           //   216: areturn
/*      */           //   217: pop
/*      */           //   218: new net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Direct$ForLegacyVm
/*      */           //   221: dup
/*      */           //   222: aload_2
/*      */           //   223: aload_3
/*      */           //   224: aload_0
/*      */           //   225: aload_1
/*      */           //   226: aload #4
/*      */           //   228: invokespecial <init> : (Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V
/*      */           //   231: areturn
/*      */           // Line number table:
/*      */           //   Java source line number -> byte code offset
/*      */           //   #599	-> 0
/*      */           //   #601	-> 6
/*      */           //   #604	-> 23
/*      */           //   #602	-> 26
/*      */           //   #606	-> 27
/*      */           //   #608	-> 29
/*      */           //   #609	-> 46
/*      */           //   #610	-> 51
/*      */           //   #611	-> 68
/*      */           //   #612	-> 73
/*      */           //   #618	-> 112
/*      */           //   #619	-> 117
/*      */           //   #628	-> 172
/*      */           //   #630	-> 178
/*      */           //   #631	-> 195
/*      */           //   #632	-> 201
/*      */           //   #638	-> 217
/*      */           //   #639	-> 218
/*      */           // Exception table:
/*      */           //   from	to	target	type
/*      */           //   6	23	26	java/lang/NoSuchMethodException
/*      */           //   178	216	217	java/lang/NoSuchMethodException
/*      */         }
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
/*      */         public boolean isAvailable() {
/*  647 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ClassInjector.UsingReflection.Dispatcher initialize() {
/*      */           Object object;
/*  655 */           if ((object = ClassInjector.UsingReflection.a().getSecurityManager()) != null) {
/*      */             try {
/*  657 */               ClassInjector.UsingReflection.b().invoke(object, new Object[] { ClassInjector.SUPPRESS_ACCESS_CHECKS });
/*  658 */             } catch (InvocationTargetException invocationTargetException) {
/*  659 */               return new ClassInjector.UsingReflection.Dispatcher.Unavailable(invocationTargetException.getTargetException().getMessage());
/*  660 */             } catch (Exception exception) {
/*  661 */               return new ClassInjector.UsingReflection.Dispatcher.Unavailable(exception.getMessage());
/*      */             } 
/*      */           }
/*  664 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> findClass(ClassLoader param3ClassLoader, String param3String) {
/*      */           try {
/*  672 */             return (Class)this.findLoadedClass.invoke(param3ClassLoader, new Object[] { param3String });
/*  673 */           } catch (IllegalAccessException illegalAccessException) {
/*  674 */             throw new IllegalStateException(illegalAccessException);
/*  675 */           } catch (InvocationTargetException invocationTargetException) {
/*  676 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> defineClass(ClassLoader param3ClassLoader, String param3String, byte[] param3ArrayOfbyte, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/*      */           try {
/*  685 */             return (Class)this.defineClass.invoke(param3ClassLoader, new Object[] { param3String, param3ArrayOfbyte, Integer.valueOf(0), Integer.valueOf(param3ArrayOfbyte.length), param3ProtectionDomain });
/*  686 */           } catch (IllegalAccessException illegalAccessException) {
/*  687 */             throw new IllegalStateException(illegalAccessException);
/*  688 */           } catch (InvocationTargetException invocationTargetException) {
/*  689 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public Package getDefinedPackage(ClassLoader param3ClassLoader, String param3String) {
/*  698 */           if (this.getDefinedPackage == null) {
/*  699 */             return getPackage(param3ClassLoader, param3String);
/*      */           }
/*      */           try {
/*  702 */             return (Package)this.getDefinedPackage.invoke(param3ClassLoader, new Object[] { param3String });
/*  703 */           } catch (IllegalAccessException illegalAccessException) {
/*  704 */             throw new IllegalStateException(illegalAccessException);
/*  705 */           } catch (InvocationTargetException invocationTargetException) {
/*  706 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Package getPackage(ClassLoader param3ClassLoader, String param3String) {
/*      */           try {
/*  715 */             return (Package)this.getPackage.invoke(param3ClassLoader, new Object[] { param3String });
/*  716 */           } catch (IllegalAccessException illegalAccessException) {
/*  717 */             throw new IllegalStateException(illegalAccessException);
/*  718 */           } catch (InvocationTargetException invocationTargetException) {
/*  719 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
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
/*      */         public Package definePackage(ClassLoader param3ClassLoader, String param3String1, @MaybeNull String param3String2, @MaybeNull String param3String3, @MaybeNull String param3String4, @MaybeNull String param3String5, @MaybeNull String param3String6, @MaybeNull String param3String7, @MaybeNull URL param3URL) {
/*      */           try {
/*  736 */             return (Package)this.definePackage.invoke(param3ClassLoader, new Object[] { param3String1, param3String2, param3String3, param3String4, param3String5, param3String6, param3String7, param3URL });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  745 */           catch (IllegalAccessException illegalAccessException) {
/*  746 */             throw new IllegalStateException(illegalAccessException);
/*  747 */           } catch (InvocationTargetException invocationTargetException) {
/*  748 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.findLoadedClass.equals(((Direct)param3Object).findLoadedClass) ? false : (!this.defineClass.equals(((Direct)param3Object).defineClass) ? false : (!this.getDefinedPackage.equals(((Direct)param3Object).getDefinedPackage) ? false : (!this.getPackage.equals(((Direct)param3Object).getPackage) ? false : (!!this.definePackage.equals(((Direct)param3Object).definePackage))))))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return ((((getClass().hashCode() * 31 + this.findLoadedClass.hashCode()) * 31 + this.defineClass.hashCode()) * 31 + this.getDefinedPackage.hashCode()) * 31 + this.getPackage.hashCode()) * 31 + this.definePackage.hashCode();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         protected static class ForJava7CapableVm
/*      */           extends Direct
/*      */         {
/*      */           private final Method getClassLoadingLock;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           protected ForJava7CapableVm(Method param4Method1, Method param4Method2, @MaybeNull Method param4Method3, Method param4Method4, Method param4Method5, Method param4Method6) {
/*  779 */             super(param4Method1, param4Method2, param4Method3, param4Method4, param4Method5);
/*  780 */             this.getClassLoadingLock = param4Method6;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getClassLoadingLock(ClassLoader param4ClassLoader, String param4String) {
/*      */             try {
/*  788 */               return this.getClassLoadingLock.invoke(param4ClassLoader, new Object[] { param4String });
/*  789 */             } catch (IllegalAccessException illegalAccessException) {
/*  790 */               throw new IllegalStateException(illegalAccessException);
/*  791 */             } catch (InvocationTargetException invocationTargetException) {
/*  792 */               throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return !super.equals(param4Object) ? false : ((this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.getClassLoadingLock.equals(((ForJava7CapableVm)param4Object).getClassLoadingLock)))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return super.hashCode() * 31 + this.getClassLoadingLock.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class ForLegacyVm
/*      */           extends Direct
/*      */         {
/*      */           protected ForLegacyVm(Method param4Method1, Method param4Method2, @MaybeNull Method param4Method3, Method param4Method4, Method param4Method5) {
/*  816 */             super(param4Method1, param4Method2, param4Method3, param4Method4, param4Method5);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getClassLoadingLock(ClassLoader param4ClassLoader, String param4String) {
/*  823 */             return param4ClassLoader;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class UsingUnsafeInjection
/*      */         implements Dispatcher, Initializable
/*      */       {
/*      */         private final Object accessor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method findLoadedClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method defineClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @UnknownNull
/*      */         private final Method getDefinedPackage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method getPackage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method definePackage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method getClassLoadingLock;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected UsingUnsafeInjection(Object param3Object, Method param3Method1, Method param3Method2, @MaybeNull Method param3Method3, Method param3Method4, Method param3Method5, Method param3Method6) {
/*  890 */           this.accessor = param3Object;
/*  891 */           this.findLoadedClass = param3Method1;
/*  892 */           this.defineClass = param3Method2;
/*  893 */           this.getDefinedPackage = param3Method3;
/*  894 */           this.getPackage = param3Method4;
/*  895 */           this.definePackage = param3Method5;
/*  896 */           this.getClassLoadingLock = param3Method6;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Assuring privilege is explicit user responsibility.")
/*      */         protected static ClassInjector.UsingReflection.Dispatcher.Initializable make() {
/*  907 */           if (Boolean.parseBoolean(System.getProperty("net.bytebuddy.safe", Boolean.toString(GraalImageCode.getCurrent().isDefined())))) {
/*  908 */             return new ClassInjector.UsingReflection.Dispatcher.Initializable.Unavailable("Use of Unsafe was disabled by system property");
/*      */           }
/*      */           Class<?> clazz;
/*      */           Field field;
/*  912 */           (field = (clazz = Class.forName("sun.misc.Unsafe")).getDeclaredField("theUnsafe")).setAccessible(true);
/*  913 */           Object object = field.get(null);
/*      */           
/*  915 */           if (JavaModule.isSupported()) {
/*      */             Method method; try {
/*  917 */               method = ClassLoader.class.getDeclaredMethod("getDefinedPackage", new Class[] { String.class });
/*  918 */             } catch (NoSuchMethodException noSuchMethodException) {
/*      */ 
/*      */ 
/*      */               
/*  922 */               method = null;
/*      */             } 
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
/*  950 */             DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition receiverTypeDefinition = (new ByteBuddy()).with(TypeValidation.DISABLED).subclass(Object.class, (ConstructorStrategy)ConstructorStrategy.Default.NO_CONSTRUCTORS).name(ClassLoader.class.getName() + "$ByteBuddyAccessor$V1").defineMethod("findLoadedClass", Class.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new Type[] { ClassLoader.class, String.class }).intercept((Implementation)MethodCall.invoke(ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[] { String.class })).onArgument(0).withArgument(new int[] { 1 })).defineMethod("defineClass", Class.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new Type[] { ClassLoader.class, String.class, byte[].class, int.class, int.class, ProtectionDomain.class }).intercept((Implementation)MethodCall.invoke(ClassLoader.class.getDeclaredMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ProtectionDomain.class })).onArgument(0).withArgument(new int[] { 1, 2, 3, 4, 5 })).defineMethod("getPackage", Package.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new Type[] { ClassLoader.class, String.class }).intercept((Implementation)MethodCall.invoke(ClassLoader.class.getDeclaredMethod("getPackage", new Class[] { String.class })).onArgument(0).withArgument(new int[] { 1 })).defineMethod("definePackage", Package.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new Type[] { ClassLoader.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class }).intercept((Implementation)MethodCall.invoke(ClassLoader.class
/*  951 */                   .getDeclaredMethod("definePackage", new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class
/*  952 */                     })).onArgument(0)
/*  953 */                 .withArgument(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
/*  954 */             if (method != null)
/*      */             {
/*      */ 
/*      */               
/*  958 */               receiverTypeDefinition = receiverTypeDefinition.defineMethod("getDefinedPackage", Package.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new Type[] { ClassLoader.class, String.class }).intercept((Implementation)MethodCall.invoke(method)
/*  959 */                   .onArgument(0)
/*  960 */                   .withArgument(new int[] { 1 }));
/*      */             }
/*      */ 
/*      */             
/*      */             try {
/*  965 */               receiverTypeDefinition = receiverTypeDefinition.defineMethod("getClassLoadingLock", Object.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new Type[] { ClassLoader.class, String.class }).intercept((Implementation)MethodCall.invoke(ClassLoader.class.getDeclaredMethod("getClassLoadingLock", new Class[] { String.class
/*  966 */                       })).onArgument(0)
/*  967 */                   .withArgument(new int[] { 1 }));
/*  968 */             } catch (NoSuchMethodException noSuchMethodException) {
/*      */ 
/*      */               
/*  971 */               receiverTypeDefinition = receiverTypeDefinition.defineMethod("getClassLoadingLock", Object.class, new ModifierContributor.ForMethod[] { (ModifierContributor.ForMethod)Visibility.PUBLIC }).withParameters(new Type[] { ClassLoader.class, String.class }).intercept((Implementation)FixedValue.argument(0));
/*      */             } 
/*      */ 
/*      */             
/*  975 */             Class clazz1 = receiverTypeDefinition.make().load(ClassLoadingStrategy.BOOTSTRAP_LOADER, new ClassLoadingStrategy.ForUnsafeInjection()).getLoaded();
/*  976 */             return new UsingUnsafeInjection(clazz
/*  977 */                 .getMethod("allocateInstance", new Class[] { Class.class }).invoke(object, new Object[] { clazz1 }), clazz1
/*  978 */                 .getMethod("findLoadedClass", new Class[] { ClassLoader.class, String.class }), clazz1
/*  979 */                 .getMethod("defineClass", new Class[] { ClassLoader.class, String.class, byte[].class, int.class, int.class, ProtectionDomain.class }), (method != null) ? clazz1
/*  980 */                 .getMethod("getDefinedPackage", new Class[] { ClassLoader.class, String.class }) : null, clazz1
/*  981 */                 .getMethod("getPackage", new Class[] { ClassLoader.class, String.class }), clazz1
/*  982 */                 .getMethod("definePackage", new Class[] { ClassLoader.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class }), clazz1
/*  983 */                 .getMethod("getClassLoadingLock", new Class[] { ClassLoader.class, String.class }));
/*      */           } 
/*      */           Object object1 = null;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean isAvailable() {
/*  990 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ClassInjector.UsingReflection.Dispatcher initialize() {
/*      */           Object object;
/*  998 */           if ((object = ClassInjector.UsingReflection.a().getSecurityManager()) != null) {
/*      */             try {
/* 1000 */               ClassInjector.UsingReflection.b().invoke(object, new Object[] { ClassInjector.SUPPRESS_ACCESS_CHECKS });
/* 1001 */             } catch (InvocationTargetException invocationTargetException) {
/* 1002 */               return new ClassInjector.UsingReflection.Dispatcher.Unavailable(invocationTargetException.getTargetException().getMessage());
/* 1003 */             } catch (Exception exception) {
/* 1004 */               return new ClassInjector.UsingReflection.Dispatcher.Unavailable(exception.getMessage());
/*      */             } 
/*      */           }
/* 1007 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Object getClassLoadingLock(ClassLoader param3ClassLoader, String param3String) {
/*      */           try {
/* 1015 */             return this.getClassLoadingLock.invoke(this.accessor, new Object[] { param3ClassLoader, param3String });
/* 1016 */           } catch (IllegalAccessException illegalAccessException) {
/* 1017 */             throw new IllegalStateException(illegalAccessException);
/* 1018 */           } catch (InvocationTargetException invocationTargetException) {
/* 1019 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> findClass(ClassLoader param3ClassLoader, String param3String) {
/*      */           try {
/* 1028 */             return (Class)this.findLoadedClass.invoke(this.accessor, new Object[] { param3ClassLoader, param3String });
/* 1029 */           } catch (IllegalAccessException illegalAccessException) {
/* 1030 */             throw new IllegalStateException(illegalAccessException);
/* 1031 */           } catch (InvocationTargetException invocationTargetException) {
/* 1032 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> defineClass(ClassLoader param3ClassLoader, String param3String, byte[] param3ArrayOfbyte, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/*      */           try {
/* 1041 */             return (Class)this.defineClass.invoke(this.accessor, new Object[] { param3ClassLoader, param3String, param3ArrayOfbyte, Integer.valueOf(0), Integer.valueOf(param3ArrayOfbyte.length), param3ProtectionDomain });
/* 1042 */           } catch (IllegalAccessException illegalAccessException) {
/* 1043 */             throw new IllegalStateException(illegalAccessException);
/* 1044 */           } catch (InvocationTargetException invocationTargetException) {
/* 1045 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public Package getDefinedPackage(ClassLoader param3ClassLoader, String param3String) {
/* 1054 */           if (this.getDefinedPackage == null) {
/* 1055 */             return getPackage(param3ClassLoader, param3String);
/*      */           }
/*      */           try {
/* 1058 */             return (Package)this.getDefinedPackage.invoke(this.accessor, new Object[] { param3ClassLoader, param3String });
/* 1059 */           } catch (IllegalAccessException illegalAccessException) {
/* 1060 */             throw new IllegalStateException(illegalAccessException);
/* 1061 */           } catch (InvocationTargetException invocationTargetException) {
/* 1062 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Package getPackage(ClassLoader param3ClassLoader, String param3String) {
/*      */           try {
/* 1071 */             return (Package)this.getPackage.invoke(this.accessor, new Object[] { param3ClassLoader, param3String });
/* 1072 */           } catch (IllegalAccessException illegalAccessException) {
/* 1073 */             throw new IllegalStateException(illegalAccessException);
/* 1074 */           } catch (InvocationTargetException invocationTargetException) {
/* 1075 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
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
/*      */         public Package definePackage(ClassLoader param3ClassLoader, String param3String1, @MaybeNull String param3String2, @MaybeNull String param3String3, @MaybeNull String param3String4, @MaybeNull String param3String5, @MaybeNull String param3String6, @MaybeNull String param3String7, @MaybeNull URL param3URL) {
/*      */           try {
/* 1092 */             return (Package)this.definePackage.invoke(this.accessor, new Object[] { param3ClassLoader, param3String1, param3String2, param3String3, param3String4, param3String5, param3String6, param3String7, param3URL });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/* 1102 */           catch (IllegalAccessException illegalAccessException) {
/* 1103 */             throw new IllegalStateException(illegalAccessException);
/* 1104 */           } catch (InvocationTargetException invocationTargetException) {
/* 1105 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.accessor.equals(((UsingUnsafeInjection)param3Object).accessor) ? false : (!this.findLoadedClass.equals(((UsingUnsafeInjection)param3Object).findLoadedClass) ? false : (!this.defineClass.equals(((UsingUnsafeInjection)param3Object).defineClass) ? false : (!this.getDefinedPackage.equals(((UsingUnsafeInjection)param3Object).getDefinedPackage) ? false : (!this.getPackage.equals(((UsingUnsafeInjection)param3Object).getPackage) ? false : (!this.definePackage.equals(((UsingUnsafeInjection)param3Object).definePackage) ? false : (!!this.getClassLoadingLock.equals(((UsingUnsafeInjection)param3Object).getClassLoadingLock))))))))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return ((((((getClass().hashCode() * 31 + this.accessor.hashCode()) * 31 + this.findLoadedClass.hashCode()) * 31 + this.defineClass.hashCode()) * 31 + this.getDefinedPackage.hashCode()) * 31 + this.getPackage.hashCode()) * 31 + this.definePackage.hashCode()) * 31 + this.getClassLoadingLock.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static abstract class UsingUnsafeOverride
/*      */         implements Dispatcher, Initializable
/*      */       {
/*      */         protected final Method findLoadedClass;
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Method defineClass;
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         protected final Method getDefinedPackage;
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Method getPackage;
/*      */ 
/*      */ 
/*      */         
/*      */         protected final Method definePackage;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected UsingUnsafeOverride(Method param3Method1, Method param3Method2, @MaybeNull Method param3Method3, Method param3Method4, Method param3Method5) {
/* 1156 */           this.findLoadedClass = param3Method1;
/* 1157 */           this.defineClass = param3Method2;
/* 1158 */           this.getDefinedPackage = param3Method3;
/* 1159 */           this.getPackage = param3Method4;
/* 1160 */           this.definePackage = param3Method5;
/*      */         }
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
/*      */         @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Assuring privilege is explicit user responsibility.")
/*      */         protected static ClassInjector.UsingReflection.Dispatcher.Initializable make() {
/*      */           // Byte code:
/*      */           //   0: ldc 'net.bytebuddy.safe'
/*      */           //   2: invokestatic getCurrent : ()Lnet/bytebuddy/utility/GraalImageCode;
/*      */           //   5: invokevirtual isDefined : ()Z
/*      */           //   8: invokestatic toString : (Z)Ljava/lang/String;
/*      */           //   11: invokestatic getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*      */           //   14: invokestatic parseBoolean : (Ljava/lang/String;)Z
/*      */           //   17: ifeq -> 30
/*      */           //   20: new net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Initializable$Unavailable
/*      */           //   23: dup
/*      */           //   24: ldc 'Use of Unsafe was disabled by system property'
/*      */           //   26: invokespecial <init> : (Ljava/lang/String;)V
/*      */           //   29: areturn
/*      */           //   30: ldc 'sun.misc.Unsafe'
/*      */           //   32: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
/*      */           //   35: dup
/*      */           //   36: astore_0
/*      */           //   37: ldc 'theUnsafe'
/*      */           //   39: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
/*      */           //   42: dup
/*      */           //   43: astore_1
/*      */           //   44: iconst_1
/*      */           //   45: invokevirtual setAccessible : (Z)V
/*      */           //   48: aload_1
/*      */           //   49: aconst_null
/*      */           //   50: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */           //   53: astore_1
/*      */           //   54: ldc java/lang/reflect/AccessibleObject
/*      */           //   56: ldc 'override'
/*      */           //   58: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
/*      */           //   61: astore_2
/*      */           //   62: goto -> 163
/*      */           //   65: pop
/*      */           //   66: new net/bytebuddy/ByteBuddy
/*      */           //   69: dup
/*      */           //   70: invokespecial <init> : ()V
/*      */           //   73: ldc java/lang/reflect/AccessibleObject
/*      */           //   75: invokevirtual redefine : (Ljava/lang/Class;)Lnet/bytebuddy/dynamic/DynamicType$Builder;
/*      */           //   78: new java/lang/StringBuilder
/*      */           //   81: dup
/*      */           //   82: ldc 'net.bytebuddy.mirror.'
/*      */           //   84: invokespecial <init> : (Ljava/lang/String;)V
/*      */           //   87: ldc java/lang/reflect/AccessibleObject
/*      */           //   89: invokevirtual getSimpleName : ()Ljava/lang/String;
/*      */           //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */           //   95: invokevirtual toString : ()Ljava/lang/String;
/*      */           //   98: invokeinterface name : (Ljava/lang/String;)Lnet/bytebuddy/dynamic/DynamicType$Builder;
/*      */           //   103: invokeinterface noNestMate : ()Lnet/bytebuddy/dynamic/DynamicType$Builder;
/*      */           //   108: new net/bytebuddy/asm/MemberRemoval
/*      */           //   111: dup
/*      */           //   112: invokespecial <init> : ()V
/*      */           //   115: invokestatic any : ()Lnet/bytebuddy/matcher/ElementMatcher$Junction;
/*      */           //   118: invokevirtual stripInvokables : (Lnet/bytebuddy/matcher/ElementMatcher;)Lnet/bytebuddy/asm/MemberRemoval;
/*      */           //   121: invokeinterface visit : (Lnet/bytebuddy/asm/AsmVisitorWrapper;)Lnet/bytebuddy/dynamic/DynamicType$Builder;
/*      */           //   126: invokeinterface make : ()Lnet/bytebuddy/dynamic/DynamicType$Unloaded;
/*      */           //   131: ldc java/lang/reflect/AccessibleObject
/*      */           //   133: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
/*      */           //   136: getstatic net/bytebuddy/dynamic/loading/ClassLoadingStrategy$Default.WRAPPER : Lnet/bytebuddy/dynamic/loading/ClassLoadingStrategy$Default;
/*      */           //   139: ldc java/lang/reflect/AccessibleObject
/*      */           //   141: invokevirtual getProtectionDomain : ()Ljava/security/ProtectionDomain;
/*      */           //   144: invokevirtual with : (Ljava/security/ProtectionDomain;)Lnet/bytebuddy/dynamic/loading/ClassLoadingStrategy$Configurable;
/*      */           //   147: invokeinterface load : (Ljava/lang/ClassLoader;Lnet/bytebuddy/dynamic/loading/ClassLoadingStrategy;)Lnet/bytebuddy/dynamic/DynamicType$Loaded;
/*      */           //   152: invokeinterface getLoaded : ()Ljava/lang/Class;
/*      */           //   157: ldc 'override'
/*      */           //   159: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
/*      */           //   162: astore_2
/*      */           //   163: aload_0
/*      */           //   164: ldc 'objectFieldOffset'
/*      */           //   166: iconst_1
/*      */           //   167: anewarray java/lang/Class
/*      */           //   170: dup
/*      */           //   171: iconst_0
/*      */           //   172: ldc java/lang/reflect/Field
/*      */           //   174: aastore
/*      */           //   175: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   178: aload_1
/*      */           //   179: iconst_1
/*      */           //   180: anewarray java/lang/Object
/*      */           //   183: dup
/*      */           //   184: iconst_0
/*      */           //   185: aload_2
/*      */           //   186: aastore
/*      */           //   187: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*      */           //   190: checkcast java/lang/Long
/*      */           //   193: invokevirtual longValue : ()J
/*      */           //   196: lstore #4
/*      */           //   198: aload_0
/*      */           //   199: ldc 'putBoolean'
/*      */           //   201: iconst_3
/*      */           //   202: anewarray java/lang/Class
/*      */           //   205: dup
/*      */           //   206: iconst_0
/*      */           //   207: ldc java/lang/Object
/*      */           //   209: aastore
/*      */           //   210: dup
/*      */           //   211: iconst_1
/*      */           //   212: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
/*      */           //   215: aastore
/*      */           //   216: dup
/*      */           //   217: iconst_2
/*      */           //   218: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
/*      */           //   221: aastore
/*      */           //   222: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   225: astore_0
/*      */           //   226: invokestatic isSupported : ()Z
/*      */           //   229: ifeq -> 253
/*      */           //   232: ldc java/lang/ClassLoader
/*      */           //   234: ldc 'getDefinedPackage'
/*      */           //   236: iconst_1
/*      */           //   237: anewarray java/lang/Class
/*      */           //   240: dup
/*      */           //   241: iconst_0
/*      */           //   242: ldc java/lang/String
/*      */           //   244: aastore
/*      */           //   245: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   248: astore_2
/*      */           //   249: goto -> 255
/*      */           //   252: pop
/*      */           //   253: aconst_null
/*      */           //   254: astore_2
/*      */           //   255: ldc java/lang/ClassLoader
/*      */           //   257: ldc 'getPackage'
/*      */           //   259: iconst_1
/*      */           //   260: anewarray java/lang/Class
/*      */           //   263: dup
/*      */           //   264: iconst_0
/*      */           //   265: ldc java/lang/String
/*      */           //   267: aastore
/*      */           //   268: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   271: astore_3
/*      */           //   272: aload_0
/*      */           //   273: aload_1
/*      */           //   274: iconst_3
/*      */           //   275: anewarray java/lang/Object
/*      */           //   278: dup
/*      */           //   279: iconst_0
/*      */           //   280: aload_3
/*      */           //   281: aastore
/*      */           //   282: dup
/*      */           //   283: iconst_1
/*      */           //   284: lload #4
/*      */           //   286: invokestatic valueOf : (J)Ljava/lang/Long;
/*      */           //   289: aastore
/*      */           //   290: dup
/*      */           //   291: iconst_2
/*      */           //   292: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*      */           //   295: aastore
/*      */           //   296: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*      */           //   299: pop
/*      */           //   300: ldc java/lang/ClassLoader
/*      */           //   302: ldc 'findLoadedClass'
/*      */           //   304: iconst_1
/*      */           //   305: anewarray java/lang/Class
/*      */           //   308: dup
/*      */           //   309: iconst_0
/*      */           //   310: ldc java/lang/String
/*      */           //   312: aastore
/*      */           //   313: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   316: astore #6
/*      */           //   318: ldc java/lang/ClassLoader
/*      */           //   320: ldc 'defineClass'
/*      */           //   322: iconst_5
/*      */           //   323: anewarray java/lang/Class
/*      */           //   326: dup
/*      */           //   327: iconst_0
/*      */           //   328: ldc java/lang/String
/*      */           //   330: aastore
/*      */           //   331: dup
/*      */           //   332: iconst_1
/*      */           //   333: ldc [B
/*      */           //   335: aastore
/*      */           //   336: dup
/*      */           //   337: iconst_2
/*      */           //   338: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
/*      */           //   341: aastore
/*      */           //   342: dup
/*      */           //   343: iconst_3
/*      */           //   344: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
/*      */           //   347: aastore
/*      */           //   348: dup
/*      */           //   349: iconst_4
/*      */           //   350: ldc java/security/ProtectionDomain
/*      */           //   352: aastore
/*      */           //   353: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   356: astore #7
/*      */           //   358: ldc java/lang/ClassLoader
/*      */           //   360: ldc 'definePackage'
/*      */           //   362: bipush #8
/*      */           //   364: anewarray java/lang/Class
/*      */           //   367: dup
/*      */           //   368: iconst_0
/*      */           //   369: ldc java/lang/String
/*      */           //   371: aastore
/*      */           //   372: dup
/*      */           //   373: iconst_1
/*      */           //   374: ldc java/lang/String
/*      */           //   376: aastore
/*      */           //   377: dup
/*      */           //   378: iconst_2
/*      */           //   379: ldc java/lang/String
/*      */           //   381: aastore
/*      */           //   382: dup
/*      */           //   383: iconst_3
/*      */           //   384: ldc java/lang/String
/*      */           //   386: aastore
/*      */           //   387: dup
/*      */           //   388: iconst_4
/*      */           //   389: ldc java/lang/String
/*      */           //   391: aastore
/*      */           //   392: dup
/*      */           //   393: iconst_5
/*      */           //   394: ldc java/lang/String
/*      */           //   396: aastore
/*      */           //   397: dup
/*      */           //   398: bipush #6
/*      */           //   400: ldc java/lang/String
/*      */           //   402: aastore
/*      */           //   403: dup
/*      */           //   404: bipush #7
/*      */           //   406: ldc java/net/URL
/*      */           //   408: aastore
/*      */           //   409: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   412: astore #8
/*      */           //   414: aload_0
/*      */           //   415: aload_1
/*      */           //   416: iconst_3
/*      */           //   417: anewarray java/lang/Object
/*      */           //   420: dup
/*      */           //   421: iconst_0
/*      */           //   422: aload #7
/*      */           //   424: aastore
/*      */           //   425: dup
/*      */           //   426: iconst_1
/*      */           //   427: lload #4
/*      */           //   429: invokestatic valueOf : (J)Ljava/lang/Long;
/*      */           //   432: aastore
/*      */           //   433: dup
/*      */           //   434: iconst_2
/*      */           //   435: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*      */           //   438: aastore
/*      */           //   439: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*      */           //   442: pop
/*      */           //   443: aload_0
/*      */           //   444: aload_1
/*      */           //   445: iconst_3
/*      */           //   446: anewarray java/lang/Object
/*      */           //   449: dup
/*      */           //   450: iconst_0
/*      */           //   451: aload #6
/*      */           //   453: aastore
/*      */           //   454: dup
/*      */           //   455: iconst_1
/*      */           //   456: lload #4
/*      */           //   458: invokestatic valueOf : (J)Ljava/lang/Long;
/*      */           //   461: aastore
/*      */           //   462: dup
/*      */           //   463: iconst_2
/*      */           //   464: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*      */           //   467: aastore
/*      */           //   468: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*      */           //   471: pop
/*      */           //   472: aload_0
/*      */           //   473: aload_1
/*      */           //   474: iconst_3
/*      */           //   475: anewarray java/lang/Object
/*      */           //   478: dup
/*      */           //   479: iconst_0
/*      */           //   480: aload #8
/*      */           //   482: aastore
/*      */           //   483: dup
/*      */           //   484: iconst_1
/*      */           //   485: lload #4
/*      */           //   487: invokestatic valueOf : (J)Ljava/lang/Long;
/*      */           //   490: aastore
/*      */           //   491: dup
/*      */           //   492: iconst_2
/*      */           //   493: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*      */           //   496: aastore
/*      */           //   497: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*      */           //   500: pop
/*      */           //   501: ldc java/lang/ClassLoader
/*      */           //   503: ldc 'getClassLoadingLock'
/*      */           //   505: iconst_1
/*      */           //   506: anewarray java/lang/Class
/*      */           //   509: dup
/*      */           //   510: iconst_0
/*      */           //   511: ldc java/lang/String
/*      */           //   513: aastore
/*      */           //   514: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
/*      */           //   517: astore #9
/*      */           //   519: aload_0
/*      */           //   520: aload_1
/*      */           //   521: iconst_3
/*      */           //   522: anewarray java/lang/Object
/*      */           //   525: dup
/*      */           //   526: iconst_0
/*      */           //   527: aload #9
/*      */           //   529: aastore
/*      */           //   530: dup
/*      */           //   531: iconst_1
/*      */           //   532: lload #4
/*      */           //   534: invokestatic valueOf : (J)Ljava/lang/Long;
/*      */           //   537: aastore
/*      */           //   538: dup
/*      */           //   539: iconst_2
/*      */           //   540: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
/*      */           //   543: aastore
/*      */           //   544: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*      */           //   547: pop
/*      */           //   548: new net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$UsingUnsafeOverride$ForJava7CapableVm
/*      */           //   551: dup
/*      */           //   552: aload #6
/*      */           //   554: aload #7
/*      */           //   556: aload_2
/*      */           //   557: aload_3
/*      */           //   558: aload #8
/*      */           //   560: aload #9
/*      */           //   562: invokespecial <init> : (Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V
/*      */           //   565: areturn
/*      */           //   566: pop
/*      */           //   567: new net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$UsingUnsafeOverride$ForLegacyVm
/*      */           //   570: dup
/*      */           //   571: aload #6
/*      */           //   573: aload #7
/*      */           //   575: aload_2
/*      */           //   576: aload_3
/*      */           //   577: aload #8
/*      */           //   579: invokespecial <init> : (Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V
/*      */           //   582: areturn
/*      */           // Line number table:
/*      */           //   Java source line number -> byte code offset
/*      */           //   #1171	-> 0
/*      */           //   #1172	-> 20
/*      */           //   #1174	-> 30
/*      */           //   #1175	-> 36
/*      */           //   #1176	-> 43
/*      */           //   #1177	-> 48
/*      */           //   #1180	-> 54
/*      */           //   #1195	-> 62
/*      */           //   #1181	-> 65
/*      */           //   #1186	-> 66
/*      */           //   #1187	-> 75
/*      */           //   #1188	-> 89
/*      */           //   #1189	-> 103
/*      */           //   #1190	-> 115
/*      */           //   #1191	-> 126
/*      */           //   #1192	-> 133
/*      */           //   #1193	-> 152
/*      */           //   #1194	-> 159
/*      */           //   #1196	-> 163
/*      */           //   #1197	-> 175
/*      */           //   #1198	-> 187
/*      */           //   #1196	-> 193
/*      */           //   #1199	-> 198
/*      */           //   #1201	-> 226
/*      */           //   #1203	-> 232
/*      */           //   #1206	-> 249
/*      */           //   #1204	-> 252
/*      */           //   #1208	-> 253
/*      */           //   #1210	-> 255
/*      */           //   #1211	-> 272
/*      */           //   #1212	-> 300
/*      */           //   #1213	-> 318
/*      */           //   #1219	-> 358
/*      */           //   #1228	-> 414
/*      */           //   #1229	-> 443
/*      */           //   #1230	-> 472
/*      */           //   #1232	-> 501
/*      */           //   #1233	-> 519
/*      */           //   #1234	-> 548
/*      */           //   #1240	-> 566
/*      */           //   #1241	-> 567
/*      */           // Exception table:
/*      */           //   from	to	target	type
/*      */           //   54	62	65	java/lang/NoSuchFieldException
/*      */           //   232	249	252	java/lang/NoSuchMethodException
/*      */           //   501	565	566	java/lang/NoSuchMethodException
/*      */         }
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
/*      */         public boolean isAvailable() {
/* 1249 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ClassInjector.UsingReflection.Dispatcher initialize() {
/*      */           Object object;
/* 1257 */           if ((object = ClassInjector.UsingReflection.a().getSecurityManager()) != null) {
/*      */             try {
/* 1259 */               ClassInjector.UsingReflection.b().invoke(object, new Object[] { ClassInjector.SUPPRESS_ACCESS_CHECKS });
/* 1260 */             } catch (InvocationTargetException invocationTargetException) {
/* 1261 */               return new ClassInjector.UsingReflection.Dispatcher.Unavailable(invocationTargetException.getTargetException().getMessage());
/* 1262 */             } catch (Exception exception) {
/* 1263 */               return new ClassInjector.UsingReflection.Dispatcher.Unavailable(exception.getMessage());
/*      */             } 
/*      */           }
/* 1266 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> findClass(ClassLoader param3ClassLoader, String param3String) {
/*      */           try {
/* 1274 */             return (Class)this.findLoadedClass.invoke(param3ClassLoader, new Object[] { param3String });
/* 1275 */           } catch (IllegalAccessException illegalAccessException) {
/* 1276 */             throw new IllegalStateException(illegalAccessException);
/* 1277 */           } catch (InvocationTargetException invocationTargetException) {
/* 1278 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> defineClass(ClassLoader param3ClassLoader, String param3String, byte[] param3ArrayOfbyte, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/*      */           try {
/* 1287 */             return (Class)this.defineClass.invoke(param3ClassLoader, new Object[] { param3String, param3ArrayOfbyte, Integer.valueOf(0), Integer.valueOf(param3ArrayOfbyte.length), param3ProtectionDomain });
/* 1288 */           } catch (IllegalAccessException illegalAccessException) {
/* 1289 */             throw new IllegalStateException(illegalAccessException);
/* 1290 */           } catch (InvocationTargetException invocationTargetException) {
/* 1291 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public Package getDefinedPackage(ClassLoader param3ClassLoader, String param3String) {
/* 1300 */           if (this.getDefinedPackage == null) {
/* 1301 */             return getPackage(param3ClassLoader, param3String);
/*      */           }
/*      */           try {
/* 1304 */             return (Package)this.getDefinedPackage.invoke(param3ClassLoader, new Object[] { param3String });
/* 1305 */           } catch (IllegalAccessException illegalAccessException) {
/* 1306 */             throw new IllegalStateException(illegalAccessException);
/* 1307 */           } catch (InvocationTargetException invocationTargetException) {
/* 1308 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Package getPackage(ClassLoader param3ClassLoader, String param3String) {
/*      */           try {
/* 1317 */             return (Package)this.getPackage.invoke(param3ClassLoader, new Object[] { param3String });
/* 1318 */           } catch (IllegalAccessException illegalAccessException) {
/* 1319 */             throw new IllegalStateException(illegalAccessException);
/* 1320 */           } catch (InvocationTargetException invocationTargetException) {
/* 1321 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
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
/*      */         public Package definePackage(ClassLoader param3ClassLoader, String param3String1, @MaybeNull String param3String2, @MaybeNull String param3String3, @MaybeNull String param3String4, @MaybeNull String param3String5, @MaybeNull String param3String6, @MaybeNull String param3String7, @MaybeNull URL param3URL) {
/*      */           try {
/* 1338 */             return (Package)this.definePackage.invoke(param3ClassLoader, new Object[] { param3String1, param3String2, param3String3, param3String4, param3String5, param3String6, param3String7, param3URL });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/* 1347 */           catch (IllegalAccessException illegalAccessException) {
/* 1348 */             throw new IllegalStateException(illegalAccessException);
/* 1349 */           } catch (InvocationTargetException invocationTargetException) {
/* 1350 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
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
/*      */         @Enhance
/*      */         protected static class ForJava7CapableVm
/*      */           extends UsingUnsafeOverride
/*      */         {
/*      */           private final Method getClassLoadingLock;
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
/*      */           protected ForJava7CapableVm(Method param4Method1, Method param4Method2, @MaybeNull Method param4Method3, Method param4Method4, Method param4Method5, Method param4Method6) {
/* 1381 */             super(param4Method1, param4Method2, param4Method3, param4Method4, param4Method5);
/* 1382 */             this.getClassLoadingLock = param4Method6;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getClassLoadingLock(ClassLoader param4ClassLoader, String param4String) {
/*      */             try {
/* 1390 */               return this.getClassLoadingLock.invoke(param4ClassLoader, new Object[] { param4String });
/* 1391 */             } catch (IllegalAccessException illegalAccessException) {
/* 1392 */               throw new IllegalStateException(illegalAccessException);
/* 1393 */             } catch (InvocationTargetException invocationTargetException) {
/* 1394 */               throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean equals(@MaybeNull Object param4Object) {
/*      */             return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.getClassLoadingLock.equals(((ForJava7CapableVm)param4Object).getClassLoadingLock))));
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public int hashCode() {
/*      */             return getClass().hashCode() * 31 + this.getClassLoadingLock.hashCode();
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         protected static class ForLegacyVm
/*      */           extends UsingUnsafeOverride
/*      */         {
/*      */           protected ForLegacyVm(Method param4Method1, Method param4Method2, @MaybeNull Method param4Method3, Method param4Method4, Method param4Method5) {
/* 1418 */             super(param4Method1, param4Method2, param4Method3, param4Method4, param4Method5);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public Object getClassLoadingLock(ClassLoader param4ClassLoader, String param4String) {
/* 1425 */             return param4ClassLoader;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Unavailable
/*      */         implements Dispatcher
/*      */       {
/*      */         private final String message;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Unavailable(String param3String) {
/* 1447 */           this.message = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Object getClassLoadingLock(ClassLoader param3ClassLoader, String param3String) {
/* 1454 */           return param3ClassLoader;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> findClass(ClassLoader param3ClassLoader, String param3String) {
/*      */           try {
/* 1462 */             return param3ClassLoader.loadClass(param3String);
/* 1463 */           } catch (ClassNotFoundException classNotFoundException) {
/* 1464 */             return UNDEFINED;
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> defineClass(ClassLoader param3ClassLoader, String param3String, byte[] param3ArrayOfbyte, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/* 1472 */           throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Package getDefinedPackage(ClassLoader param3ClassLoader, String param3String) {
/* 1479 */           throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Package getPackage(ClassLoader param3ClassLoader, String param3String) {
/* 1486 */           throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.message.equals(((Unavailable)param3Object).message))));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Package definePackage(ClassLoader param3ClassLoader, String param3String1, @MaybeNull String param3String2, @MaybeNull String param3String3, @MaybeNull String param3String4, @MaybeNull String param3String5, @MaybeNull String param3String6, @MaybeNull String param3String7, @MaybeNull URL param3URL) {
/* 1501 */           throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
/*      */         } public int hashCode() { return getClass().hashCode() * 31 + this.message.hashCode(); }
/*      */       } }
/*      */      public static interface Initializable { boolean isAvailable(); ClassInjector.UsingReflection.Dispatcher initialize(); @Enhance
/*      */       public static class Unavailable implements ClassInjector.UsingReflection.Dispatcher, Initializable { private final String message; protected Unavailable(String param4String) { this.message = param4String; } public boolean isAvailable() { return false; } public ClassInjector.UsingReflection.Dispatcher initialize() { return this; } public Object getClassLoadingLock(ClassLoader param4ClassLoader, String param4String) { return param4ClassLoader; } public Class<?> findClass(ClassLoader param4ClassLoader, String param4String) { try {
/*      */             return param4ClassLoader.loadClass(param4String);
/*      */           } catch (ClassNotFoundException classNotFoundException) {
/*      */             return UNDEFINED;
/*      */           }  }
/*      */         public Class<?> defineClass(ClassLoader param4ClassLoader, String param4String, byte[] param4ArrayOfbyte, @MaybeNull ProtectionDomain param4ProtectionDomain) { throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message); }
/*      */         public Package getDefinedPackage(ClassLoader param4ClassLoader, String param4String) { throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message); }
/*      */         public Package getPackage(ClassLoader param4ClassLoader, String param4String) { throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message); }
/*      */         public Package definePackage(ClassLoader param4ClassLoader, String param4String1, @MaybeNull String param4String2, @MaybeNull String param4String3, @MaybeNull String param4String4, @MaybeNull String param4String5, @MaybeNull String param4String6, @MaybeNull String param4String7, @MaybeNull URL param4URL) { throw new UnsupportedOperationException("Cannot define package using injection: " + this.message); }
/*      */         public boolean equals(@MaybeNull Object param4Object) {
/*      */           return (this == param4Object) ? true : ((param4Object == null) ? false : ((getClass() != param4Object.getClass()) ? false : (!!this.message.equals(((Unavailable)param4Object).message))));
/*      */         }
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.message.hashCode();
/*      */         } } }
/*      */     public enum CreationAction implements PrivilegedAction<Dispatcher.Initializable> { INSTANCE;
/*      */       @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*      */       public final ClassInjector.UsingReflection.Dispatcher.Initializable run() {
/*      */         try {
/*      */           if (JavaModule.isSupported()) {
/*      */             if (ClassInjector.UsingUnsafe.isAvailable())
/*      */               return ClassInjector.UsingReflection.Dispatcher.UsingUnsafeInjection.make(); 
/*      */             return ClassInjector.UsingReflection.Dispatcher.UsingUnsafeOverride.make();
/*      */           } 
/*      */           return ClassInjector.UsingReflection.Dispatcher.Direct.make();
/*      */         } catch (InvocationTargetException invocationTargetException) {
/*      */           return new ClassInjector.UsingReflection.Dispatcher.Initializable.Unavailable(invocationTargetException.getTargetException().getMessage());
/*      */         } catch (Exception exception) {
/*      */           return new ClassInjector.UsingReflection.Dispatcher.Initializable.Unavailable(exception.getMessage());
/*      */         } 
/*      */       } }
/*      */   }
/*      */   @Enhance
/* 1538 */   public static class UsingLookup extends AbstractBase { private static final MethodHandles METHOD_HANDLES = doPrivileged(JavaDispatcher.of(MethodHandles.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1543 */     private static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP = doPrivileged(JavaDispatcher.of(MethodHandles.Lookup.class)); private static final int PACKAGE_LOOKUP = 8; private final Object lookup; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
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
/*      */     protected UsingLookup(Object param1Object) {
/* 1561 */       this.lookup = param1Object;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 1573 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UsingLookup of(Object param1Object) {
/* 1583 */       if (!isAvailable())
/* 1584 */         throw new IllegalStateException("The current VM does not support class definition via method handle lookups"); 
/* 1585 */       if (!JavaType.METHOD_HANDLES_LOOKUP.isInstance(param1Object))
/* 1586 */         throw new IllegalArgumentException("Not a method handle lookup: " + param1Object); 
/* 1587 */       if ((METHOD_HANDLES_LOOKUP.lookupModes(param1Object) & 0x8) == 0) {
/* 1588 */         throw new IllegalArgumentException("Lookup does not imply package-access: " + param1Object);
/*      */       }
/* 1590 */       return new UsingLookup(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Class<?> lookupType() {
/* 1599 */       return METHOD_HANDLES_LOOKUP.lookupClass(this.lookup);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public UsingLookup in(Class<?> param1Class) {
/*      */       try {
/* 1610 */         return new UsingLookup(METHOD_HANDLES.privateLookupIn(param1Class, this.lookup));
/* 1611 */       } catch (IllegalAccessException illegalAccessException) {
/* 1612 */         throw new IllegalStateException("Cannot access " + param1Class.getName() + " from " + this.lookup, illegalAccessException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAlive() {
/* 1620 */       return isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> param1Map) {
/*      */       PackageDescription packageDescription;
/* 1628 */       if ((packageDescription = TypeDescription.ForLoadedType.of(lookupType()).getPackage()) == null) {
/* 1629 */         throw new IllegalArgumentException("Cannot inject array or primitive type");
/*      */       }
/* 1631 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 1632 */       for (Iterator<Map.Entry> iterator = param1Map.entrySet().iterator(); iterator.hasNext(); ) {
/* 1633 */         Map.Entry<String, ?> entry; int i = ((String)(entry = iterator.next()).getKey()).lastIndexOf('.');
/* 1634 */         if (!packageDescription.getName().equals((i == -1) ? "" : ((String)entry.getKey()).substring(0, i))) {
/* 1635 */           throw new IllegalArgumentException((String)entry.getKey() + " must be defined in the same package as " + this.lookup);
/*      */         }
/*      */         try {
/* 1638 */           hashMap.put(entry.getKey(), METHOD_HANDLES_LOOKUP.defineClass(this.lookup, (byte[])entry.getValue()));
/* 1639 */         } catch (Exception exception) {
/* 1640 */           throw new IllegalStateException(exception);
/*      */         } 
/*      */       } 
/* 1643 */       return (Map)hashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static boolean isAvailable() {
/* 1652 */       return JavaType.MODULE.isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.lookup.equals(((UsingLookup)param1Object).lookup))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.lookup.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Proxied("java.lang.invoke.MethodHandles")
/*      */     protected static interface MethodHandles
/*      */     {
/*      */       @IsStatic
/*      */       @Proxied("privateLookupIn")
/*      */       Object privateLookupIn(Class<?> param2Class, @Proxied("java.lang.invoke.MethodHandles$Lookup") Object param2Object);
/*      */ 
/*      */ 
/*      */       
/*      */       @Proxied("java.lang.invoke.MethodHandles$Lookup")
/*      */       public static interface Lookup
/*      */       {
/*      */         @Proxied("lookupClass")
/*      */         Class<?> lookupClass(Object param3Object);
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("lookupModes")
/*      */         int lookupModes(Object param3Object);
/*      */ 
/*      */ 
/*      */         
/*      */         @Proxied("defineClass")
/*      */         Class<?> defineClass(Object param3Object, byte[] param3ArrayOfbyte);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Proxied("java.lang.invoke.MethodHandles$Lookup")
/*      */     public static interface Lookup
/*      */     {
/*      */       @Proxied("lookupClass")
/*      */       Class<?> lookupClass(Object param2Object);
/*      */ 
/*      */       
/*      */       @Proxied("lookupModes")
/*      */       int lookupModes(Object param2Object);
/*      */ 
/*      */       
/*      */       @Proxied("defineClass")
/*      */       Class<?> defineClass(Object param2Object, byte[] param2ArrayOfbyte);
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class UsingUnsafe
/*      */     extends AbstractBase
/*      */   {
/*      */     public static final String SAFE_PROPERTY = "net.bytebuddy.safe";
/*      */     
/* 1721 */     private static final Dispatcher.Initializable DISPATCHER = doPrivileged(Dispatcher.CreationAction.INSTANCE);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1726 */     private static final System SYSTEM = doPrivileged(JavaDispatcher.of(System.class));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1731 */     private static final Method CHECK_PERMISSION = doPrivileged((PrivilegedAction<Method>)new GetMethodAction("java.lang.SecurityManager", "checkPermission", new Class[] { Permission.class }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1738 */     private static final Object BOOTSTRAP_LOADER_LOCK = new Object(); @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) private final ClassLoader classLoader; @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) private final ProtectionDomain protectionDomain; private final Dispatcher.Initializable dispatcher; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
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
/*      */     public UsingUnsafe(@MaybeNull ClassLoader param1ClassLoader) {
/* 1765 */       this(param1ClassLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public UsingUnsafe(@MaybeNull ClassLoader param1ClassLoader, @MaybeNull ProtectionDomain param1ProtectionDomain) {
/* 1775 */       this(param1ClassLoader, param1ProtectionDomain, DISPATCHER);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected UsingUnsafe(@MaybeNull ClassLoader param1ClassLoader, @MaybeNull ProtectionDomain param1ProtectionDomain, Dispatcher.Initializable param1Initializable) {
/* 1786 */       this.classLoader = param1ClassLoader;
/* 1787 */       this.protectionDomain = param1ProtectionDomain;
/* 1788 */       this.dispatcher = param1Initializable;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 1800 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAlive() {
/* 1807 */       return this.dispatcher.isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> param1Map) {
/* 1814 */       Dispatcher dispatcher = this.dispatcher.initialize();
/* 1815 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 1816 */       synchronized ((this.classLoader == null) ? BOOTSTRAP_LOADER_LOCK : this.classLoader) {
/*      */ 
/*      */         
/* 1819 */         for (Map.Entry<? extends String, byte> entry : param1Map.entrySet()) {
/*      */           try {
/* 1821 */             hashMap.put(entry.getKey(), Class.forName((String)entry.getKey(), false, this.classLoader));
/* 1822 */           } catch (ClassNotFoundException classNotFoundException) {
/* 1823 */             hashMap.put(entry.getKey(), dispatcher.defineClass(this.classLoader, (String)entry.getKey(), (byte[])entry.getValue(), this.protectionDomain));
/*      */           } 
/*      */         } 
/*      */       } 
/* 1827 */       return (Map)hashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static boolean isAvailable() {
/* 1836 */       return DISPATCHER.isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassInjector ofSystemLoader() {
/* 1845 */       return new UsingUnsafe(ClassLoader.getSystemClassLoader());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassInjector ofPlatformLoader() {
/* 1855 */       return new UsingUnsafe(ClassLoader.getSystemClassLoader().getParent());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassInjector ofBootLoader() {
/* 1864 */       return new UsingUnsafe(ClassLoadingStrategy.BOOTSTRAP_LOADER);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       ClassLoader classLoader2;
/*      */       ProtectionDomain protectionDomain2;
/*      */       if (this == param1Object) {
/*      */         return true;
/*      */       }
/*      */       if (param1Object == null) {
/*      */         return false;
/*      */       }
/*      */       if (getClass() != param1Object.getClass())
/*      */         return false; 
/*      */       ClassLoader classLoader1 = ((UsingUnsafe)param1Object).classLoader;
/*      */       if (classLoader1 != null) {
/*      */         if ((classLoader2 = this.classLoader) != null) {
/*      */           if (!classLoader2.equals(classLoader1))
/*      */             return false; 
/*      */         } else {
/*      */           return false;
/*      */         } 
/*      */       } else if ((classLoader2 = this.classLoader) != null) {
/*      */         return false;
/*      */       } 
/*      */       ProtectionDomain protectionDomain1 = ((UsingUnsafe)param1Object).protectionDomain;
/*      */       if (protectionDomain1 != null) {
/*      */         if ((protectionDomain2 = this.protectionDomain) != null) {
/*      */           if (!protectionDomain2.equals(protectionDomain1))
/*      */             return false; 
/*      */         } else {
/*      */           return false;
/*      */         } 
/*      */       } else if ((protectionDomain2 = this.protectionDomain) != null) {
/*      */         return false;
/*      */       } 
/*      */       return !!this.dispatcher.equals(((UsingUnsafe)param1Object).dispatcher);
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       ClassLoader classLoader;
/*      */       if ((classLoader = this.classLoader) != null);
/*      */       ProtectionDomain protectionDomain;
/*      */       if ((protectionDomain = this.protectionDomain) != null);
/*      */       return ((getClass().hashCode() * 31 + classLoader.hashCode()) * 31 + protectionDomain.hashCode()) * 31 + this.dispatcher.hashCode();
/*      */     }
/*      */     
/*      */     public enum CreationAction
/*      */       implements PrivilegedAction<Dispatcher.Initializable>
/*      */     {
/* 1914 */       INSTANCE;
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*      */       public final ClassInjector.UsingUnsafe.Dispatcher.Initializable run()
/*      */       {
/* 1921 */         if (Boolean.parseBoolean(System.getProperty("net.bytebuddy.safe", Boolean.toString(GraalImageCode.getCurrent().isDefined())))) {
/* 1922 */           return new ClassInjector.UsingUnsafe.Dispatcher.Unavailable("Use of Unsafe was disabled by system property");
/*      */         }
/*      */         
/*      */         try { Class<?> clazz;
/*      */           Field field;
/* 1927 */           (field = (clazz = Class.forName("sun.misc.Unsafe")).getDeclaredField("theUnsafe")).setAccessible(true);
/* 1928 */           Object object = field.get(null);
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/*      */             Method method;
/*      */ 
/*      */ 
/*      */             
/* 1937 */             (method = clazz.getMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class })).setAccessible(true);
/* 1938 */             return new ClassInjector.UsingUnsafe.Dispatcher.Enabled(object, method);
/* 1939 */           } catch (Exception exception) {
/*      */             try {
/*      */               Field field1;
/*      */               try {
/* 1943 */                 field1 = AccessibleObject.class.getDeclaredField("override");
/* 1944 */               } catch (NoSuchFieldException noSuchFieldException) {
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
/* 1957 */                 field1 = (new ByteBuddy()).redefine(AccessibleObject.class).name("net.bytebuddy.mirror." + AccessibleObject.class.getSimpleName()).noNestMate().visit((AsmVisitorWrapper)(new MemberRemoval()).stripInvokables((ElementMatcher)ElementMatchers.any())).make().load(AccessibleObject.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(AccessibleObject.class.getProtectionDomain())).getLoaded().getDeclaredField("override");
/*      */               } 
/* 1959 */               long l = ((Long)clazz
/* 1960 */                 .getMethod("objectFieldOffset", new Class[] { Field.class
/* 1961 */                   }).invoke(object, new Object[] { field1 })).longValue();
/* 1962 */               Method method1 = clazz.getMethod("putBoolean", new Class[] { Object.class, long.class, boolean.class });
/*      */               Class<?> clazz1;
/* 1964 */               Field field2 = (clazz1 = Class.forName("jdk.internal.misc.Unsafe")).getDeclaredField("theUnsafe");
/* 1965 */               method1.invoke(object, new Object[] { field2, Long.valueOf(l), Boolean.TRUE });
/* 1966 */               Method method2 = clazz1.getMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1973 */               method1.invoke(object, new Object[] { method2, Long.valueOf(l), Boolean.TRUE });
/* 1974 */               return new ClassInjector.UsingUnsafe.Dispatcher.Enabled(field2.get(null), method2);
/* 1975 */             } catch (Exception exception1) {
/* 1976 */               throw exception;
/*      */             } 
/*      */           }  }
/* 1979 */         catch (Exception exception)
/* 1980 */         { return new ClassInjector.UsingUnsafe.Dispatcher.Unavailable(exception.getMessage()); }  } } public static interface Initializable { boolean isAvailable(); ClassInjector.UsingUnsafe.Dispatcher initialize(); } protected static interface Dispatcher { Class<?> defineClass(@MaybeNull ClassLoader param2ClassLoader, String param2String, byte[] param2ArrayOfbyte, @MaybeNull ProtectionDomain param2ProtectionDomain); public static interface Initializable { boolean isAvailable(); ClassInjector.UsingUnsafe.Dispatcher initialize(); } public enum CreationAction implements PrivilegedAction<Initializable> { @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final ClassInjector.UsingUnsafe.Dispatcher.Initializable run() { if (Boolean.parseBoolean(System.getProperty("net.bytebuddy.safe", Boolean.toString(GraalImageCode.getCurrent().isDefined())))) return new ClassInjector.UsingUnsafe.Dispatcher.Unavailable("Use of Unsafe was disabled by system property");  try { Class<?> clazz; Field field; (field = (clazz = Class.forName("sun.misc.Unsafe")).getDeclaredField("theUnsafe")).setAccessible(true); Object object = field.get(null); try { Method method; (method = clazz.getMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class })).setAccessible(true); return new ClassInjector.UsingUnsafe.Dispatcher.Enabled(object, method); } catch (Exception exception) { try { Field field1; try { field1 = AccessibleObject.class.getDeclaredField("override"); } catch (NoSuchFieldException noSuchFieldException) { field1 = (new ByteBuddy()).redefine(AccessibleObject.class).name("net.bytebuddy.mirror." + AccessibleObject.class.getSimpleName()).noNestMate().visit((AsmVisitorWrapper)(new MemberRemoval()).stripInvokables((ElementMatcher)ElementMatchers.any())).make().load(AccessibleObject.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(AccessibleObject.class.getProtectionDomain())).getLoaded().getDeclaredField("override"); }  long l = ((Long)clazz.getMethod("objectFieldOffset", new Class[] { Field.class }).invoke(object, new Object[] { field1 })).longValue(); Method method1 = clazz.getMethod("putBoolean", new Class[] { Object.class, long.class, boolean.class }); Class<?> clazz1; Field field2 = (clazz1 = Class.forName("jdk.internal.misc.Unsafe")).getDeclaredField("theUnsafe"); method1.invoke(object, new Object[] { field2, Long.valueOf(l), Boolean.TRUE }); Method method2 = clazz1.getMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class }); method1.invoke(object, new Object[] { method2, Long.valueOf(l), Boolean.TRUE }); return new ClassInjector.UsingUnsafe.Dispatcher.Enabled(field2.get(null), method2); } catch (Exception exception1) { throw exception; }  }  } catch (Exception exception) { return new ClassInjector.UsingUnsafe.Dispatcher.Unavailable(exception.getMessage()); }
/*      */            }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         INSTANCE; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Enabled
/*      */         implements Dispatcher, Initializable
/*      */       {
/*      */         private final Object unsafe;
/*      */ 
/*      */ 
/*      */         
/*      */         private final Method defineClass;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Enabled(Object param3Object, Method param3Method) {
/* 2008 */           this.unsafe = param3Object;
/* 2009 */           this.defineClass = param3Method;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isAvailable() {
/* 2016 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ClassInjector.UsingUnsafe.Dispatcher initialize() {
/*      */           Object object;
/* 2024 */           if ((object = ClassInjector.UsingUnsafe.a().getSecurityManager()) != null) {
/*      */             try {
/* 2026 */               ClassInjector.UsingUnsafe.b().invoke(object, new Object[] { ClassInjector.SUPPRESS_ACCESS_CHECKS });
/* 2027 */             } catch (InvocationTargetException invocationTargetException) {
/* 2028 */               return new ClassInjector.UsingUnsafe.Dispatcher.Unavailable(invocationTargetException.getTargetException().getMessage());
/* 2029 */             } catch (Exception exception) {
/* 2030 */               return new ClassInjector.UsingUnsafe.Dispatcher.Unavailable(exception.getMessage());
/*      */             } 
/*      */           }
/* 2033 */           return this;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> defineClass(@MaybeNull ClassLoader param3ClassLoader, String param3String, byte[] param3ArrayOfbyte, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/*      */           try {
/* 2041 */             return (Class)this.defineClass.invoke(this.unsafe, new Object[] { param3String, param3ArrayOfbyte, 
/*      */ 
/*      */                   
/* 2044 */                   Integer.valueOf(0), 
/* 2045 */                   Integer.valueOf(param3ArrayOfbyte.length), param3ClassLoader, param3ProtectionDomain });
/*      */           
/*      */           }
/* 2048 */           catch (IllegalAccessException illegalAccessException) {
/* 2049 */             throw new IllegalStateException(illegalAccessException);
/* 2050 */           } catch (InvocationTargetException invocationTargetException) {
/* 2051 */             throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.unsafe.equals(((Enabled)param3Object).unsafe) ? false : (!!this.defineClass.equals(((Enabled)param3Object).defineClass)))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return (getClass().hashCode() * 31 + this.unsafe.hashCode()) * 31 + this.defineClass.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       public static class Unavailable
/*      */         implements Dispatcher, Initializable
/*      */       {
/*      */         private final String message;
/*      */         
/*      */         protected Unavailable(String param3String) {
/* 2073 */           this.message = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isAvailable() {
/* 2080 */           return false;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public ClassInjector.UsingUnsafe.Dispatcher initialize() {
/* 2087 */           throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> defineClass(@MaybeNull ClassLoader param3ClassLoader, String param3String, byte[] param3ArrayOfbyte, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/* 2094 */           throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.message.equals(((Unavailable)param3Object).message))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.message.hashCode();
/*      */         }
/*      */       } }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class Factory
/*      */     {
/*      */       private final ClassInjector.UsingUnsafe.Dispatcher.Initializable dispatcher;
/*      */       
/*      */       public Factory() {
/* 2116 */         this(AccessResolver.Default.INSTANCE);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*      */       public Factory(AccessResolver param2AccessResolver) {
/*      */         ClassInjector.UsingUnsafe.Dispatcher.Initializable initializable;
/* 2127 */         if (ClassInjector.UsingUnsafe.c().isAvailable()) {
/* 2128 */           initializable = ClassInjector.UsingUnsafe.c();
/*      */         } else {
/*      */           try {
/*      */             Class<?> clazz;
/* 2132 */             Field field = (clazz = Class.forName("jdk.internal.misc.Unsafe")).getDeclaredField("theUnsafe");
/* 2133 */             initializable.apply(field);
/* 2134 */             Object object = field.get(null);
/* 2135 */             Method method = clazz.getMethod("defineClass", new Class[] { String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2142 */             initializable.apply(method);
/* 2143 */             initializable = new ClassInjector.UsingUnsafe.Dispatcher.Enabled(object, method);
/* 2144 */           } catch (Exception exception) {
/* 2145 */             initializable = new ClassInjector.UsingUnsafe.Dispatcher.Unavailable(exception.getMessage());
/*      */           } 
/*      */         } 
/* 2148 */         this.dispatcher = initializable;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Factory(ClassInjector.UsingUnsafe.Dispatcher.Initializable param2Initializable) {
/* 2157 */         this.dispatcher = param2Initializable;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static Factory resolve(Instrumentation param2Instrumentation) {
/* 2169 */         return resolve(param2Instrumentation, false);
/*      */       }
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
/*      */       @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION", "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Exception intends to trigger disabled injection strategy. Modules are assumed if module system is supported.")
/*      */       public static Factory resolve(Instrumentation param2Instrumentation, boolean param2Boolean) {
/* 2186 */         if (ClassInjector.UsingUnsafe.isAvailable() || !JavaModule.isSupported()) {
/* 2187 */           return new Factory();
/*      */         }
/*      */         try {
/* 2190 */           Class<?> clazz1 = Class.forName("jdk.internal.misc.Unsafe");
/* 2191 */           PackageDescription.ForLoadedPackage forLoadedPackage = new PackageDescription.ForLoadedPackage(clazz1.getPackage());
/* 2192 */           JavaModule javaModule1 = JavaModule.ofType(clazz1), javaModule2 = JavaModule.ofType(ClassInjector.UsingUnsafe.class);
/* 2193 */           if (javaModule1.isOpened((PackageDescription)forLoadedPackage, javaModule2))
/* 2194 */             return new Factory(); 
/* 2195 */           if (param2Boolean) {
/* 2196 */             JavaModule javaModule = JavaModule.ofType(AccessResolver.Default.class);
/* 2197 */             ClassInjector.UsingInstrumentation.redefineModule(param2Instrumentation, javaModule1, 
/*      */                 
/* 2199 */                 Collections.singleton(javaModule), 
/* 2200 */                 Collections.emptyMap(), 
/* 2201 */                 Collections.singletonMap(forLoadedPackage.getName(), Collections.singleton(javaModule)), 
/* 2202 */                 Collections.emptySet(), 
/* 2203 */                 Collections.emptyMap());
/* 2204 */             return new Factory();
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           Class<AccessResolver> clazz;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2215 */           javaModule2 = JavaModule.ofType(clazz = (new ByteBuddy()).subclass(AccessResolver.class).method((ElementMatcher)ElementMatchers.named("apply")).intercept((Implementation)MethodCall.invoke(AccessibleObject.class.getMethod("setAccessible", new Class[] { boolean.class })).onArgument(0).with(new Object[] { Boolean.TRUE })).make().load(AccessResolver.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(AccessResolver.class.getProtectionDomain())).getLoaded());
/* 2216 */           ClassInjector.UsingInstrumentation.redefineModule(param2Instrumentation, javaModule1, 
/*      */               
/* 2218 */               Collections.singleton(javaModule2), 
/* 2219 */               Collections.emptyMap(), 
/* 2220 */               Collections.singletonMap(forLoadedPackage.getName(), Collections.singleton(javaModule2)), 
/* 2221 */               Collections.emptySet(), 
/* 2222 */               Collections.emptyMap());
/* 2223 */           return new Factory(clazz.getConstructor(new Class[0]).newInstance(new Object[0]));
/*      */         }
/* 2225 */         catch (Exception exception) {
/* 2226 */           return new Factory(new ClassInjector.UsingUnsafe.Dispatcher.Unavailable(exception.getMessage()));
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isAvailable() {
/* 2237 */         return this.dispatcher.isAvailable();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ClassInjector make(@MaybeNull ClassLoader param2ClassLoader) {
/* 2247 */         return make(param2ClassLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ClassInjector make(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull ProtectionDomain param2ProtectionDomain) {
/* 2258 */         return new ClassInjector.UsingUnsafe(param2ClassLoader, param2ProtectionDomain, this.dispatcher);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.dispatcher.equals(((Factory)param2Object).dispatcher))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.dispatcher.hashCode();
/*      */       }
/*      */ 
/*      */       
/*      */       public static interface AccessResolver
/*      */       {
/*      */         void apply(AccessibleObject param3AccessibleObject);
/*      */ 
/*      */         
/*      */         public enum Default
/*      */           implements AccessResolver
/*      */         {
/* 2281 */           INSTANCE;
/*      */ 
/*      */ 
/*      */           
/*      */           public final void apply(AccessibleObject param4AccessibleObject)
/*      */           {
/* 2287 */             param4AccessibleObject.setAccessible(true); } } } public enum Default implements AccessResolver { INSTANCE; public final void apply(AccessibleObject param3AccessibleObject) { param3AccessibleObject.setAccessible(true); }
/*      */          }
/*      */     
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Proxied("java.lang.System")
/*      */     protected static interface System
/*      */     {
/*      */       @MaybeNull
/*      */       @IsStatic
/*      */       @Defaults
/*      */       @Proxied("getSecurityManager")
/*      */       Object getSecurityManager();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class UsingInstrumentation
/*      */     extends AbstractBase
/*      */   {
/*      */     private static final String JAR = "jar";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String CLASS_FILE_EXTENSION = ".class";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2331 */     private static final Dispatcher DISPATCHER = doPrivileged(JavaDispatcher.of(Dispatcher.class)); private final Instrumentation instrumentation; private final Target target; private final File folder; private final RandomString randomString; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
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
/*      */ 
/*      */     
/*      */     protected UsingInstrumentation(File param1File, Target param1Target, Instrumentation param1Instrumentation, RandomString param1RandomString) {
/* 2365 */       this.folder = param1File;
/* 2366 */       this.target = param1Target;
/* 2367 */       this.instrumentation = param1Instrumentation;
/* 2368 */       this.randomString = param1RandomString;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 2380 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
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
/*      */     public static void redefineModule(Instrumentation param1Instrumentation, JavaModule param1JavaModule, Set<JavaModule> param1Set, Map<String, Set<JavaModule>> param1Map1, Map<String, Set<JavaModule>> param1Map2, Set<Class<?>> param1Set1, Map<Class<?>, List<Class<?>>> param1Map) {
/* 2401 */       if (!DISPATCHER.isModifiableModule(param1Instrumentation, param1JavaModule.unwrap())) {
/* 2402 */         throw new IllegalArgumentException("Cannot modify module: " + param1JavaModule);
/*      */       }
/* 2404 */       HashSet<Object> hashSet = new HashSet();
/* 2405 */       for (JavaModule javaModule : param1Set) {
/* 2406 */         hashSet.add(javaModule.unwrap());
/*      */       }
/* 2408 */       HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 2409 */       for (Map.Entry<String, Set<JavaModule>> entry : param1Map1.entrySet()) {
/* 2410 */         HashSet<Object> hashSet1 = new HashSet();
/* 2411 */         for (JavaModule javaModule : entry.getValue()) {
/* 2412 */           hashSet1.add(javaModule.unwrap());
/*      */         }
/* 2414 */         hashMap1.put(entry.getKey(), hashSet1);
/*      */       } 
/* 2416 */       HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/* 2417 */       for (Map.Entry<String, Set<JavaModule>> entry : param1Map2.entrySet()) {
/* 2418 */         HashSet<Object> hashSet1 = new HashSet();
/* 2419 */         for (JavaModule javaModule : entry.getValue()) {
/* 2420 */           hashSet1.add(javaModule.unwrap());
/*      */         }
/* 2422 */         hashMap2.put(entry.getKey(), hashSet1);
/*      */       } 
/* 2424 */       DISPATCHER.redefineModule(param1Instrumentation, param1JavaModule.unwrap(), hashSet, (Map)hashMap1, (Map)hashMap2, param1Set1, param1Map);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassInjector of(File param1File, Target param1Target, Instrumentation param1Instrumentation) {
/* 2436 */       return new UsingInstrumentation(param1File, param1Target, param1Instrumentation, new RandomString());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAlive() {
/* 2443 */       return isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> param1Map) {
/* 2450 */       File file = new File(this.folder, "jar" + this.randomString.nextString() + ".jar");
/*      */       try {
/* 2452 */         if (!file.createNewFile()) {
/* 2453 */           throw new IllegalStateException("Cannot create file " + file);
/*      */         }
/*      */         try {
/* 2456 */           JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file));
/*      */           try {
/* 2458 */             for (Map.Entry<? extends String, byte> entry : param1Map.entrySet()) {
/* 2459 */               jarOutputStream.putNextEntry(new JarEntry(((String)entry.getKey()).replace('.', '/') + ".class"));
/* 2460 */               jarOutputStream.write((byte[])entry.getValue());
/*      */             } 
/*      */           } finally {
/* 2463 */             jarOutputStream.close();
/*      */           } 
/* 2465 */           JarFile jarFile = new JarFile(file, false);
/*      */           try {
/* 2467 */             this.target.inject(this.instrumentation, jarFile);
/*      */           } finally {
/* 2469 */             jarFile.close();
/*      */           } 
/* 2471 */           HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 2472 */           for (String str : param1Map.keySet()) {
/* 2473 */             hashMap.put(str, Class.forName(str, false, this.target.getClassLoader()));
/*      */           }
/* 2475 */           return (Map)hashMap;
/*      */         } finally {
/* 2477 */           if (!file.delete()) {
/* 2478 */             file.deleteOnExit();
/*      */           }
/*      */         } 
/* 2481 */       } catch (IOException iOException) {
/* 2482 */         throw new IllegalStateException("Cannot write jar file to disk", iOException);
/* 2483 */       } catch (ClassNotFoundException classNotFoundException) {
/* 2484 */         throw new IllegalStateException("Cannot load injected class", classNotFoundException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static boolean isAvailable() {
/* 2494 */       return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V6);
/*      */     }
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
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.target.equals(((UsingInstrumentation)param1Object).target) ? false : (!this.instrumentation.equals(((UsingInstrumentation)param1Object).instrumentation) ? false : (!this.folder.equals(((UsingInstrumentation)param1Object).folder) ? false : (!!this.randomString.equals(((UsingInstrumentation)param1Object).randomString)))))));
/*      */     }
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
/*      */     public int hashCode() {
/*      */       return (((getClass().hashCode() * 31 + this.instrumentation.hashCode()) * 31 + this.target.hashCode()) * 31 + this.folder.hashCode()) * 31 + this.randomString.hashCode();
/*      */     }
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
/*      */     public enum Target
/*      */     {
/* 2556 */       BOOTSTRAP(null)
/*      */       {
/*      */         protected final void inject(Instrumentation param3Instrumentation, JarFile param3JarFile) {
/* 2559 */           ClassInjector.UsingInstrumentation.a().appendToBootstrapClassLoaderSearch(param3Instrumentation, param3JarFile);
/*      */         }
/*      */       },
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2566 */       SYSTEM((String)ClassLoader.getSystemClassLoader())
/*      */       {
/*      */         protected final void inject(Instrumentation param3Instrumentation, JarFile param3JarFile) {
/* 2569 */           ClassInjector.UsingInstrumentation.a().appendToSystemClassLoaderSearch(param3Instrumentation, param3JarFile);
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       private final ClassLoader classLoader;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       Target(ClassLoader param2ClassLoader) {
/* 2585 */         this.classLoader = param2ClassLoader;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       protected ClassLoader getClassLoader() {
/* 2595 */         return this.classLoader;
/*      */       }
/*      */       
/*      */       protected abstract void inject(Instrumentation param2Instrumentation, JarFile param2JarFile);
/*      */     }
/*      */     
/*      */     @Proxied("java.lang.instrument.Instrumentation")
/*      */     protected static interface Dispatcher {
/*      */       @Proxied("appendToBootstrapClassLoaderSearch")
/*      */       void appendToBootstrapClassLoaderSearch(Instrumentation param2Instrumentation, JarFile param2JarFile);
/*      */       
/*      */       @Proxied("appendToSystemClassLoaderSearch")
/*      */       void appendToSystemClassLoaderSearch(Instrumentation param2Instrumentation, JarFile param2JarFile);
/*      */       
/*      */       @Proxied("isModifiableModule")
/*      */       boolean isModifiableModule(Instrumentation param2Instrumentation, @Proxied("java.lang.Module") Object param2Object);
/*      */       
/*      */       @Proxied("redefineModule")
/*      */       void redefineModule(Instrumentation param2Instrumentation, @Proxied("java.lang.Module") Object param2Object, Set<?> param2Set, Map<String, Set<?>> param2Map1, Map<String, Set<?>> param2Map2, Set<Class<?>> param2Set1, Map<Class<?>, List<Class<?>>> param2Map);
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class UsingJna extends AbstractBase {
/* 2619 */     private static final Dispatcher DISPATCHER = doPrivileged(Dispatcher.CreationAction.INSTANCE);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2624 */     private static final Object BOOTSTRAP_LOADER_LOCK = new Object(); @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) private final ClassLoader classLoader; @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) private final ProtectionDomain protectionDomain; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */        }
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
/*      */     public UsingJna(@MaybeNull ClassLoader param1ClassLoader) {
/* 2646 */       this(param1ClassLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public UsingJna(@MaybeNull ClassLoader param1ClassLoader, @MaybeNull ProtectionDomain param1ProtectionDomain) {
/* 2656 */       this.classLoader = param1ClassLoader;
/* 2657 */       this.protectionDomain = param1ProtectionDomain;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     private static <T> T doPrivileged(PrivilegedAction<T> param1PrivilegedAction) {
/* 2669 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static boolean isAvailable() {
/* 2678 */       return DISPATCHER.isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassInjector ofSystemLoader() {
/* 2687 */       return new UsingJna(ClassLoader.getSystemClassLoader());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassInjector ofPlatformLoader() {
/* 2697 */       return new UsingJna(ClassLoader.getSystemClassLoader().getParent());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassInjector ofBootLoader() {
/* 2706 */       return new UsingJna(ClassLoadingStrategy.BOOTSTRAP_LOADER);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAlive() {
/* 2713 */       return DISPATCHER.isAvailable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> param1Map) {
/* 2720 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 2721 */       synchronized ((this.classLoader == null) ? BOOTSTRAP_LOADER_LOCK : this.classLoader) {
/*      */ 
/*      */         
/* 2724 */         for (Map.Entry<? extends String, byte> entry : param1Map.entrySet()) {
/*      */           try {
/* 2726 */             hashMap.put(entry.getKey(), Class.forName((String)entry.getKey(), false, this.classLoader));
/* 2727 */           } catch (ClassNotFoundException classNotFoundException) {
/* 2728 */             hashMap.put(entry.getKey(), DISPATCHER.defineClass(this.classLoader, (String)entry.getKey(), (byte[])entry.getValue(), this.protectionDomain));
/*      */           } 
/*      */         } 
/*      */       } 
/* 2732 */       return (Map)hashMap;
/*      */     } public boolean equals(@MaybeNull Object param1Object) { ClassLoader classLoader2;
/*      */       ProtectionDomain protectionDomain2;
/*      */       if (this == param1Object)
/*      */         return true; 
/*      */       if (param1Object == null)
/*      */         return false; 
/*      */       if (getClass() != param1Object.getClass())
/*      */         return false; 
/*      */       ClassLoader classLoader1 = ((UsingJna)param1Object).classLoader;
/*      */       if (classLoader1 != null) {
/*      */         if ((classLoader2 = this.classLoader) != null) {
/*      */           if (!classLoader2.equals(classLoader1))
/*      */             return false; 
/*      */         } else {
/*      */           return false;
/*      */         } 
/*      */       } else if ((classLoader2 = this.classLoader) != null) {
/*      */         return false;
/*      */       } 
/*      */       ProtectionDomain protectionDomain1 = ((UsingJna)param1Object).protectionDomain;
/*      */       if (protectionDomain1 != null) {
/*      */         if ((protectionDomain2 = this.protectionDomain) != null) {
/*      */           if (!protectionDomain2.equals(protectionDomain1))
/*      */             return false; 
/*      */         } else {
/*      */           return false;
/*      */         } 
/*      */       } else if ((protectionDomain2 = this.protectionDomain) != null) {
/*      */         return false;
/*      */       } 
/*      */       return true; } public int hashCode() {
/*      */       ClassLoader classLoader;
/*      */       if ((classLoader = this.classLoader) != null);
/*      */       ProtectionDomain protectionDomain;
/*      */       if ((protectionDomain = this.protectionDomain) != null);
/*      */       return (getClass().hashCode() * 31 + classLoader.hashCode()) * 31 + protectionDomain.hashCode();
/* 2769 */     } public enum CreationAction implements PrivilegedAction<Dispatcher> { INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final ClassInjector.UsingJna.Dispatcher run()
/*      */       {
/* 2776 */         if (System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9")) {
/* 2777 */           return new ClassInjector.UsingJna.Dispatcher.Unavailable("J9 does not support JNA-based class definition");
/*      */         }
/*      */         
/*      */         try { HashMap<Object, Object> hashMap;
/* 2781 */           (hashMap = new HashMap<Object, Object>()).put("allow-objects", Boolean.TRUE);
/* 2782 */           if (Platform.isWindows() && !Platform.is64Bit()) {
/* 2783 */             hashMap.put("function-mapper", ClassInjector.UsingJna.Dispatcher.Windows32BitFunctionMapper.INSTANCE);
/*      */           }
/* 2785 */           return new ClassInjector.UsingJna.Dispatcher.Enabled((ClassInjector.UsingJna.Dispatcher.Jvm)Native.loadLibrary("jvm", ClassInjector.UsingJna.Dispatcher.Jvm.class, hashMap)); }
/* 2786 */         catch (Throwable throwable)
/* 2787 */         { return new ClassInjector.UsingJna.Dispatcher.Unavailable(throwable.getMessage()); }  } } protected static interface Dispatcher { boolean isAvailable(); Class<?> defineClass(@MaybeNull ClassLoader param2ClassLoader, String param2String, byte[] param2ArrayOfbyte, @MaybeNull ProtectionDomain param2ProtectionDomain); public enum CreationAction implements PrivilegedAction<Dispatcher> { INSTANCE; public final ClassInjector.UsingJna.Dispatcher run() { if (System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9")) return new ClassInjector.UsingJna.Dispatcher.Unavailable("J9 does not support JNA-based class definition");  try { HashMap<Object, Object> hashMap; (hashMap = new HashMap<Object, Object>()).put("allow-objects", Boolean.TRUE); if (Platform.isWindows() && !Platform.is64Bit()) hashMap.put("function-mapper", ClassInjector.UsingJna.Dispatcher.Windows32BitFunctionMapper.INSTANCE);  return new ClassInjector.UsingJna.Dispatcher.Enabled((ClassInjector.UsingJna.Dispatcher.Jvm)Native.loadLibrary("jvm", ClassInjector.UsingJna.Dispatcher.Jvm.class, hashMap)); } catch (Throwable throwable) { return new ClassInjector.UsingJna.Dispatcher.Unavailable(throwable.getMessage()); }
/*      */            }
/*      */          }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public enum Windows32BitFunctionMapper
/*      */         implements FunctionMapper
/*      */       {
/* 2800 */         INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public final String getFunctionName(NativeLibrary param3NativeLibrary, Method param3Method) {
/* 2806 */           if (param3Method.getName().equals("JVM_DefineClass")) {
/* 2807 */             return "_JVM_DefineClass@24";
/*      */           }
/* 2809 */           return param3Method.getName();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Enabled
/*      */         implements Dispatcher
/*      */       {
/*      */         private final ClassInjector.UsingJna.Dispatcher.Jvm jvm;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected Enabled(ClassInjector.UsingJna.Dispatcher.Jvm param3Jvm) {
/* 2830 */           this.jvm = param3Jvm;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isAvailable() {
/* 2837 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> defineClass(@MaybeNull ClassLoader param3ClassLoader, String param3String, byte[] param3ArrayOfbyte, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/* 2844 */           return this.jvm.JVM_DefineClass(JNIEnv.CURRENT, param3String
/* 2845 */               .replace('.', '/'), param3ClassLoader, param3ArrayOfbyte, param3ArrayOfbyte.length, param3ProtectionDomain);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.jvm.equals(((Enabled)param3Object).jvm))));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.jvm.hashCode();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Unavailable
/*      */         implements Dispatcher
/*      */       {
/*      */         private final String error;
/*      */ 
/*      */         
/*      */         protected Unavailable(String param3String) {
/* 2870 */           this.error = param3String;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean isAvailable() {
/* 2877 */           return false;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> defineClass(@MaybeNull ClassLoader param3ClassLoader, String param3String, byte[] param3ArrayOfbyte, @MaybeNull ProtectionDomain param3ProtectionDomain) {
/* 2884 */           throw new UnsupportedOperationException("JNA is not available and JNA-based injection cannot be used: " + this.error);
/*      */         }
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.error.equals(((Unavailable)param3Object).error))));
/*      */         }
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + this.error.hashCode();
/*      */         }
/*      */       }
/*      */       
/*      */       public static interface Jvm extends Library {
/*      */         Class<?> JVM_DefineClass(JNIEnv param3JNIEnv, String param3String, @MaybeNull ClassLoader param3ClassLoader, byte[] param3ArrayOfbyte, int param3Int, @MaybeNull ProtectionDomain param3ProtectionDomain);
/*      */       } }
/*      */   
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\loading\ClassInjector.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */