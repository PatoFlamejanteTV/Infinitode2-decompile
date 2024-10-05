/*     */ package net.bytebuddy.dynamic;
/*     */ 
/*     */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.ValueHandling;
/*     */ import net.bytebuddy.description.method.MethodDescription;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.loading.ClassInjector;
/*     */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.LoadedTypeInitializer;
/*     */ import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
/*     */ import net.bytebuddy.implementation.bytecode.Removal;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
/*     */ import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.NullConstant;
/*     */ import net.bytebuddy.implementation.bytecode.constant.TextConstant;
/*     */ import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.utility.JavaModule;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Enhance
/*     */ public class NexusAccessor
/*     */ {
/*  58 */   private static final Dispatcher DISPATCHER = doPrivileged(Dispatcher.CreationAction.INSTANCE); @MaybeNull @ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY) private final ReferenceQueue<? super ClassLoader> referenceQueue; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NexusAccessor() {
/*  71 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NexusAccessor(@MaybeNull ReferenceQueue<? super ClassLoader> paramReferenceQueue) {
/*  83 */     this.referenceQueue = paramReferenceQueue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction) {
/*  95 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAlive() {
/* 104 */     return DISPATCHER.isAlive();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clean(Reference<? extends ClassLoader> paramReference) {
/* 115 */     DISPATCHER.clean(paramReference);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void register(String paramString, @MaybeNull ClassLoader paramClassLoader, int paramInt, LoadedTypeInitializer paramLoadedTypeInitializer) {
/* 127 */     if (paramLoadedTypeInitializer.isAlive())
/* 128 */       DISPATCHER.register(paramString, paramClassLoader, this.referenceQueue, paramInt, paramLoadedTypeInitializer); 
/*     */   } public boolean equals(@MaybeNull Object<? super ClassLoader> paramObject) { ReferenceQueue<? super ClassLoader> referenceQueue; if (this == paramObject)
/*     */       return true; 
/*     */     if (paramObject == null)
/*     */       return false; 
/*     */     if (getClass() != paramObject.getClass())
/*     */       return false; 
/*     */     paramObject = (Object<? super ClassLoader>)((NexusAccessor)paramObject).referenceQueue;
/*     */     if (paramObject != null) {
/*     */       if ((referenceQueue = this.referenceQueue) != null) {
/*     */         if (!referenceQueue.equals(paramObject))
/*     */           return false; 
/*     */       } else {
/*     */         return false;
/*     */       } 
/*     */     } else if ((referenceQueue = this.referenceQueue) != null) {
/*     */       return false;
/*     */     } 
/*     */     return true; } public int hashCode() { ReferenceQueue<? super ClassLoader> referenceQueue;
/*     */     if ((referenceQueue = this.referenceQueue) != null);
/*     */     return getClass().hashCode() * 31 + referenceQueue.hashCode(); } @Enhance public static class InitializationAppender implements ByteCodeAppender { private final int identification;
/* 149 */     public InitializationAppender(int param1Int) { this.identification = param1Int; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ByteCodeAppender.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context, MethodDescription param1MethodDescription) {
/*     */       try {
/* 157 */         return (new ByteCodeAppender.Simple(new StackManipulation[] { (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/* 158 */                   (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(ClassLoader.class.getMethod("getSystemClassLoader", new Class[0]))), (StackManipulation)new TextConstant(Nexus.class
/* 159 */                     .getName()), 
/* 160 */                   (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(ClassLoader.class.getMethod("loadClass", new Class[] { String.class }))), (StackManipulation)new TextConstant("initialize"), 
/*     */                   
/* 162 */                   ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class))
/* 163 */                   .withValues(Arrays.asList(new StackManipulation[] {
/* 164 */                         ClassConstant.of(TypeDescription.ForLoadedType.of(Class.class)), 
/* 165 */                         ClassConstant.of(TypeDescription.ForLoadedType.of(int.class))
/* 166 */                       })), (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Class.class.getMethod("getMethod", new Class[] { String.class, Class[].class }))), (StackManipulation)NullConstant.INSTANCE, 
/*     */                   
/* 168 */                   ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class))
/* 169 */                   .withValues(Arrays.asList(new StackManipulation[] {
/* 170 */                         ClassConstant.of(param1MethodDescription.getDeclaringType().asErasure()), (StackManipulation)new StackManipulation.Compound(new StackManipulation[] {
/*     */                             
/* 172 */                             IntegerConstant.forValue(this.identification), 
/* 173 */                             (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Integer.class.getMethod("valueOf", new Class[] { int.class }))) })
/* 174 */                       })), (StackManipulation)MethodInvocation.invoke((MethodDescription.InDefinedShape)new MethodDescription.ForLoadedMethod(Method.class.getMethod("invoke", new Class[] { Object.class, Object[].class }))), (StackManipulation)Removal.SINGLE
/*     */                 
/* 176 */                 }) })).apply(param1MethodVisitor, param1Context, param1MethodDescription);
/* 177 */       } catch (NoSuchMethodException noSuchMethodException) {
/* 178 */         throw new IllegalStateException("Cannot locate method", noSuchMethodException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.identification != ((InitializationAppender)param1Object).identification))));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.identification;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum CreationAction
/*     */     implements PrivilegedAction<Dispatcher>
/*     */   {
/* 225 */     INSTANCE;
/*     */ 
/*     */ 
/*     */     
/*     */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*     */     public final NexusAccessor.Dispatcher run()
/*     */     {
/* 232 */       if (Boolean.getBoolean("net.bytebuddy.nexus.disabled")) {
/* 233 */         return new NexusAccessor.Dispatcher.Unavailable("Nexus injection was explicitly disabled");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 239 */       try { Class clazz = (Class)(new ClassInjector.UsingReflection(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.NO_PROTECTION_DOMAIN)).inject(Collections.singletonMap(TypeDescription.ForLoadedType.of(Nexus.class), ClassFileLocator.ForClassLoader.read(Nexus.class))).get(TypeDescription.ForLoadedType.of(Nexus.class));
/* 240 */         return new NexusAccessor.Dispatcher.Available(clazz.getMethod("register", new Class[] { String.class, ClassLoader.class, ReferenceQueue.class, int.class, Object.class }), clazz
/* 241 */             .getMethod("clean", new Class[] { Reference.class })); }
/* 242 */       catch (Exception exception)
/*     */       { Class<?> clazz; try {
/* 244 */           clazz = ClassLoader.getSystemClassLoader().loadClass(Nexus.class.getName());
/* 245 */         } catch (Exception exception1) {
/* 246 */           return new NexusAccessor.Dispatcher.Unavailable(exception.toString());
/*     */         } 
/*     */ 
/*     */         
/* 250 */         try { JavaModule javaModule1 = JavaModule.ofType(NexusAccessor.class), javaModule2 = JavaModule.ofType(clazz);
/* 251 */           if (javaModule1 != null && !javaModule1.canRead(javaModule2)) {
/*     */             Class<?> clazz1;
/* 253 */             (clazz1 = Class.forName("java.lang.Module")).getMethod("addReads", new Class[] { clazz1 }).invoke(javaModule1.unwrap(), new Object[] { javaModule2.unwrap() });
/*     */           } 
/* 255 */           return new NexusAccessor.Dispatcher.Available(clazz
/* 256 */               .getMethod("register", new Class[] { String.class, ClassLoader.class, ReferenceQueue.class, int.class, Object.class }), clazz
/* 257 */               .getMethod("clean", new Class[] { Reference.class })); }
/* 258 */         catch (Exception exception1)
/* 259 */         { return new NexusAccessor.Dispatcher.Unavailable(exception1.toString()); }  }  } } protected static interface Dispatcher { boolean isAlive(); void clean(Reference<? extends ClassLoader> param1Reference); void register(String param1String, @MaybeNull ClassLoader param1ClassLoader, @MaybeNull ReferenceQueue<? super ClassLoader> param1ReferenceQueue, int param1Int, LoadedTypeInitializer param1LoadedTypeInitializer); public enum CreationAction implements PrivilegedAction<Dispatcher> { @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final NexusAccessor.Dispatcher run() { if (Boolean.getBoolean("net.bytebuddy.nexus.disabled")) return new NexusAccessor.Dispatcher.Unavailable("Nexus injection was explicitly disabled");  try { Class clazz = (Class)(new ClassInjector.UsingReflection(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.NO_PROTECTION_DOMAIN)).inject(Collections.singletonMap(TypeDescription.ForLoadedType.of(Nexus.class), ClassFileLocator.ForClassLoader.read(Nexus.class))).get(TypeDescription.ForLoadedType.of(Nexus.class)); return new NexusAccessor.Dispatcher.Available(clazz.getMethod("register", new Class[] { String.class, ClassLoader.class, ReferenceQueue.class, int.class, Object.class }), clazz.getMethod("clean", new Class[] { Reference.class })); } catch (Exception exception) { Class<?> clazz; try { clazz = ClassLoader.getSystemClassLoader().loadClass(Nexus.class.getName()); } catch (Exception exception1) { return new NexusAccessor.Dispatcher.Unavailable(exception.toString()); }  try { JavaModule javaModule1 = JavaModule.ofType(NexusAccessor.class), javaModule2 = JavaModule.ofType(clazz); if (javaModule1 != null && !javaModule1.canRead(javaModule2)) { Class<?> clazz1; (clazz1 = Class.forName("java.lang.Module")).getMethod("addReads", new Class[] { clazz1 }).invoke(javaModule1.unwrap(), new Object[] { javaModule2.unwrap() }); }  return new NexusAccessor.Dispatcher.Available(clazz.getMethod("register", new Class[] { String.class, ClassLoader.class, ReferenceQueue.class, int.class, Object.class }), clazz.getMethod("clean", new Class[] { Reference.class })); } catch (Exception exception1) { return new NexusAccessor.Dispatcher.Unavailable(exception1.toString()); }
/*     */            }
/*     */          }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       INSTANCE; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Available
/*     */       implements Dispatcher
/*     */     {
/*     */       private final Method register;
/*     */ 
/*     */ 
/*     */       
/*     */       private final Method clean;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Available(Method param2Method1, Method param2Method2) {
/* 288 */         this.register = param2Method1;
/* 289 */         this.clean = param2Method2;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isAlive() {
/* 296 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void clean(Reference<? extends ClassLoader> param2Reference) {
/*     */         try {
/* 304 */           this.clean.invoke(null, new Object[] { param2Reference }); return;
/* 305 */         } catch (IllegalAccessException illegalAccessException) {
/* 306 */           throw new IllegalStateException(illegalAccessException);
/* 307 */         } catch (InvocationTargetException invocationTargetException) {
/* 308 */           throw new IllegalStateException(invocationTargetException.getTargetException());
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void register(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull ReferenceQueue<? super ClassLoader> param2ReferenceQueue, int param2Int, LoadedTypeInitializer param2LoadedTypeInitializer) {
/*     */         try {
/* 321 */           this.register.invoke(null, new Object[] { param2String, param2ClassLoader, param2ReferenceQueue, Integer.valueOf(param2Int), param2LoadedTypeInitializer }); return;
/* 322 */         } catch (IllegalAccessException illegalAccessException) {
/* 323 */           throw new IllegalStateException(illegalAccessException);
/* 324 */         } catch (InvocationTargetException invocationTargetException) {
/* 325 */           throw new IllegalStateException(invocationTargetException.getTargetException());
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.register.equals(((Available)param2Object).register) ? false : (!!this.clean.equals(((Available)param2Object).clean)))));
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*     */         return (getClass().hashCode() * 31 + this.register.hashCode()) * 31 + this.clean.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     @Enhance
/*     */     public static class Unavailable
/*     */       implements Dispatcher
/*     */     {
/*     */       private final String message;
/*     */       
/*     */       protected Unavailable(String param2String) {
/* 347 */         this.message = param2String;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isAlive() {
/* 354 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void clean(Reference<? extends ClassLoader> param2Reference) {
/* 361 */         throw new UnsupportedOperationException("Could not initialize Nexus accessor: " + this.message);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void register(String param2String, @MaybeNull ClassLoader param2ClassLoader, @MaybeNull ReferenceQueue<? super ClassLoader> param2ReferenceQueue, int param2Int, LoadedTypeInitializer param2LoadedTypeInitializer) {
/* 372 */         throw new UnsupportedOperationException("Could not initialize Nexus accessor: " + this.message);
/*     */       }
/*     */       
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.message.equals(((Unavailable)param2Object).message))));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.message.hashCode();
/*     */       }
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\NexusAccessor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */