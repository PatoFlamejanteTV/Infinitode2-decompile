/*     */ package net.bytebuddy.dynamic.loading;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.lang.instrument.ClassDefinition;
/*     */ import java.lang.instrument.ClassFileTransformer;
/*     */ import java.lang.instrument.Instrumentation;
/*     */ import java.lang.instrument.UnmodifiableClassException;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import net.bytebuddy.agent.builder.AgentBuilder;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.dynamic.ClassFileLocator;
/*     */ import net.bytebuddy.utility.JavaModule;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
/*     */ import net.bytebuddy.utility.nullability.AlwaysNull;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Enhance
/*     */ public class ClassReloadingStrategy
/*     */   implements ClassLoadingStrategy<ClassLoader>
/*     */ {
/*  59 */   protected static final Dispatcher DISPATCHER = doPrivileged(JavaDispatcher.of(Dispatcher.class)); private final Instrumentation instrumentation; private final Strategy strategy; private final BootstrapInjection bootstrapInjection; private final Map<String, Class<?>> preregisteredTypes; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
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
/*     */   public ClassReloadingStrategy(Instrumentation paramInstrumentation, Strategy paramStrategy) {
/*  90 */     this(paramInstrumentation, paramStrategy, BootstrapInjection.Disabled.INSTANCE, 
/*     */ 
/*     */         
/*  93 */         Collections.emptyMap());
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassReloadingStrategy(Instrumentation paramInstrumentation, Strategy paramStrategy, BootstrapInjection paramBootstrapInjection, Map<String, Class<?>> paramMap) {
/* 108 */     this.instrumentation = paramInstrumentation;
/* 109 */     this.strategy = paramStrategy.validate(paramInstrumentation);
/* 110 */     this.bootstrapInjection = paramBootstrapInjection;
/* 111 */     this.preregisteredTypes = paramMap;
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
/* 123 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
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
/*     */   
/*     */   public static ClassReloadingStrategy of(Instrumentation paramInstrumentation) {
/* 136 */     if (DISPATCHER.isRetransformClassesSupported(paramInstrumentation))
/* 137 */       return new ClassReloadingStrategy(paramInstrumentation, Strategy.RETRANSFORMATION); 
/* 138 */     if (paramInstrumentation.isRedefineClassesSupported()) {
/* 139 */       return new ClassReloadingStrategy(paramInstrumentation, Strategy.REDEFINITION);
/*     */     }
/* 141 */     throw new IllegalArgumentException("Instrumentation does not support reloading of classes: " + paramInstrumentation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Instrumentation resolveByteBuddyAgentInstrumentation() {
/*     */     try {
/* 152 */       Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("net.bytebuddy.agent.Installer");
/* 153 */       JavaModule javaModule1 = JavaModule.ofType(AgentBuilder.class), javaModule2 = JavaModule.ofType(clazz);
/* 154 */       if (javaModule1 != null && !javaModule1.canRead(javaModule2)) {
/*     */         Class<?> clazz1;
/* 156 */         (clazz1 = Class.forName("java.lang.Module")).getMethod("addReads", new Class[] { clazz1 }).invoke(javaModule1.unwrap(), new Object[] { javaModule2.unwrap() });
/*     */       } 
/* 158 */       return (Instrumentation)clazz.getMethod("getInstrumentation", new Class[0]).invoke(null, new Object[0]);
/* 159 */     } catch (RuntimeException runtimeException2) {
/* 160 */       RuntimeException runtimeException1; throw runtimeException1 = null;
/* 161 */     } catch (Exception exception) {
/* 162 */       throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", exception);
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassReloadingStrategy fromInstalledAgent() {
/* 183 */     return of(resolveByteBuddyAgentInstrumentation());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ClassReloadingStrategy fromInstalledAgent(Strategy paramStrategy) {
/* 203 */     return new ClassReloadingStrategy(resolveByteBuddyAgentInstrumentation(), paramStrategy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader paramClassLoader, Map<TypeDescription, byte[]> paramMap) {
/* 210 */     HashMap<String, Class<?>> hashMap = new HashMap<String, Class<?>>(this.preregisteredTypes); Class[] arrayOfClass; int i; byte b;
/* 211 */     for (i = (arrayOfClass = this.instrumentation.getInitiatedClasses(paramClassLoader)).length, b = 0; b < i; ) { Class<?> clazz = arrayOfClass[b];
/* 212 */       hashMap.put(TypeDescription.ForLoadedType.getName(clazz), clazz); b++; }
/*     */     
/* 214 */     ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
/* 215 */     HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 216 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 217 */     for (Map.Entry<TypeDescription, byte> entry : paramMap.entrySet()) {
/*     */       Class<?> clazz;
/* 219 */       if ((clazz = hashMap.get(((TypeDescription)entry.getKey()).getName())) != null) {
/* 220 */         concurrentHashMap.put(clazz, new ClassDefinition(clazz, (byte[])entry.getValue()));
/* 221 */         hashMap1.put(entry.getKey(), clazz); continue;
/*     */       } 
/* 223 */       linkedHashMap.put(entry.getKey(), entry.getValue());
/*     */     } 
/*     */     
/*     */     try {
/* 227 */       this.strategy.apply(this.instrumentation, (Map)concurrentHashMap);
/* 228 */       if (!linkedHashMap.isEmpty()) {
/* 229 */         hashMap1.putAll(((paramClassLoader == null) ? this.bootstrapInjection
/* 230 */             .make(this.instrumentation) : new ClassInjector.UsingReflection(paramClassLoader))
/* 231 */             .inject((Map)linkedHashMap));
/*     */       }
/* 233 */     } catch (ClassNotFoundException classNotFoundException) {
/* 234 */       throw new IllegalArgumentException("Could not locate classes for redefinition", classNotFoundException);
/* 235 */     } catch (UnmodifiableClassException unmodifiableClassException) {
/* 236 */       throw new IllegalStateException("Cannot redefine specified class", unmodifiableClassException);
/*     */     } 
/* 238 */     return (Map)hashMap1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassReloadingStrategy reset(Class<?>... paramVarArgs) {
/* 249 */     return (paramVarArgs.length == 0) ? this : 
/*     */       
/* 251 */       reset(ClassFileLocator.ForClassLoader.of(paramVarArgs[0].getClassLoader()), paramVarArgs);
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
/*     */   public ClassReloadingStrategy reset(ClassFileLocator paramClassFileLocator, Class<?>... paramVarArgs) {
/* 263 */     if (paramVarArgs.length > 0) {
/*     */       try {
/* 265 */         this.strategy.reset(this.instrumentation, paramClassFileLocator, Arrays.asList(paramVarArgs));
/* 266 */       } catch (ClassNotFoundException classNotFoundException) {
/* 267 */         throw new IllegalArgumentException("Cannot locate types " + Arrays.toString(paramVarArgs), classNotFoundException);
/* 268 */       } catch (UnmodifiableClassException unmodifiableClassException) {
/* 269 */         throw new IllegalStateException("Cannot reset types " + Arrays.toString(paramVarArgs), unmodifiableClassException);
/*     */       } 
/*     */     }
/* 272 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassReloadingStrategy enableBootstrapInjection(File paramFile) {
/* 282 */     return new ClassReloadingStrategy(this.instrumentation, this.strategy, new BootstrapInjection.Enabled(paramFile), this.preregisteredTypes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassReloadingStrategy preregistered(Class<?>... paramVarArgs) {
/* 292 */     HashMap<String, Class<?>> hashMap = new HashMap<String, Class<?>>(this.preregisteredTypes); int i; byte b;
/* 293 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Class<?> clazz = paramVarArgs[b];
/* 294 */       hashMap.put(TypeDescription.ForLoadedType.getName(clazz), clazz); b++; }
/*     */     
/* 296 */     return new ClassReloadingStrategy(this.instrumentation, this.strategy, this.bootstrapInjection, hashMap);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!this.strategy.equals(((ClassReloadingStrategy)paramObject).strategy) ? false : (!this.instrumentation.equals(((ClassReloadingStrategy)paramObject).instrumentation) ? false : (!this.bootstrapInjection.equals(((ClassReloadingStrategy)paramObject).bootstrapInjection) ? false : (!!this.preregisteredTypes.equals(((ClassReloadingStrategy)paramObject).preregisteredTypes)))))));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return (((getClass().hashCode() * 31 + this.instrumentation.hashCode()) * 31 + this.strategy.hashCode()) * 31 + this.bootstrapInjection.hashCode()) * 31 + this.preregisteredTypes.hashCode();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Strategy
/*     */   {
/* 355 */     REDEFINITION(true)
/*     */     {
/*     */       protected final void apply(Instrumentation param2Instrumentation, Map<Class<?>, ClassDefinition> param2Map)
/*     */       {
/* 359 */         param2Instrumentation.redefineClasses((ClassDefinition[])param2Map.values().toArray((Object[])new ClassDefinition[0]));
/*     */       }
/*     */ 
/*     */       
/*     */       protected final Strategy validate(Instrumentation param2Instrumentation) {
/* 364 */         if (!param2Instrumentation.isRedefineClassesSupported()) {
/* 365 */           throw new IllegalArgumentException("Does not support redefinition: " + param2Instrumentation);
/*     */         }
/* 367 */         return this;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public final void reset(Instrumentation param2Instrumentation, ClassFileLocator param2ClassFileLocator, List<Class<?>> param2List) {
/* 373 */         HashMap<Object, Object> hashMap = new HashMap<Object, Object>(param2List.size());
/* 374 */         for (Class<?> clazz : param2List) {
/* 375 */           hashMap.put(clazz, new ClassDefinition(clazz, param2ClassFileLocator.locate(TypeDescription.ForLoadedType.getName(clazz)).resolve()));
/*     */         }
/* 377 */         apply(param2Instrumentation, (Map)hashMap);
/*     */       }
/*     */     },
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
/* 392 */     RETRANSFORMATION(false)
/*     */     {
/*     */       protected final void apply(Instrumentation param2Instrumentation, Map<Class<?>, ClassDefinition> param2Map) {
/* 395 */         ClassRedefinitionTransformer classRedefinitionTransformer = new ClassRedefinitionTransformer(param2Map);
/* 396 */         synchronized (this) {
/* 397 */           ClassReloadingStrategy.DISPATCHER.addTransformer(param2Instrumentation, classRedefinitionTransformer, true);
/*     */           try {
/* 399 */             ClassReloadingStrategy.DISPATCHER.retransformClasses(param2Instrumentation, (Class[])param2Map.keySet().toArray((Object[])new Class[0]));
/*     */           } finally {
/* 401 */             param2Instrumentation.removeTransformer(classRedefinitionTransformer);
/*     */           } 
/*     */         } 
/* 404 */         classRedefinitionTransformer.assertTransformation();
/*     */       }
/*     */ 
/*     */       
/*     */       protected final Strategy validate(Instrumentation param2Instrumentation) {
/* 409 */         if (!ClassReloadingStrategy.DISPATCHER.isRetransformClassesSupported(param2Instrumentation)) {
/* 410 */           throw new IllegalArgumentException("Does not support retransformation: " + param2Instrumentation);
/*     */         }
/* 412 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public final void reset(Instrumentation param2Instrumentation, ClassFileLocator param2ClassFileLocator, List<Class<?>> param2List) {
/* 417 */         for (Class<?> clazz : param2List) {
/* 418 */           if (!ClassReloadingStrategy.DISPATCHER.isModifiableClass(param2Instrumentation, clazz)) {
/* 419 */             throw new IllegalArgumentException("Cannot modify type: " + clazz);
/*     */           }
/*     */         } 
/* 422 */         ClassReloadingStrategy.DISPATCHER.addTransformer(param2Instrumentation, ClassResettingTransformer.INSTANCE, true);
/*     */         try {
/* 424 */           ClassReloadingStrategy.DISPATCHER.retransformClasses(param2Instrumentation, (Class[])param2List.<Class<?>[]>toArray((Class<?>[][])new Class[0])); return;
/*     */         } finally {
/* 426 */           param2Instrumentation.removeTransformer(ClassResettingTransformer.INSTANCE);
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @AlwaysNull
/* 435 */     private static final byte[] NO_REDEFINITION = null;
/*     */ 
/*     */ 
/*     */     
/*     */     private static final boolean REDEFINE_CLASSES = true;
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean redefinition;
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Strategy(boolean param1Boolean) {
/* 454 */       this.redefinition = param1Boolean;
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
/*     */     public boolean isRedefinition() {
/* 482 */       return this.redefinition;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract void apply(Instrumentation param1Instrumentation, Map<Class<?>, ClassDefinition> param1Map);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract Strategy validate(Instrumentation param1Instrumentation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract void reset(Instrumentation param1Instrumentation, ClassFileLocator param1ClassFileLocator, List<Class<?>> param1List);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected static class ClassRedefinitionTransformer
/*     */       implements ClassFileTransformer
/*     */     {
/*     */       private final Map<Class<?>, ClassDefinition> redefinedClasses;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected ClassRedefinitionTransformer(Map<Class<?>, ClassDefinition> param2Map) {
/* 513 */         this.redefinedClasses = param2Map;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public byte[] transform(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull String param2String, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain, byte[] param2ArrayOfbyte) {
/* 525 */         if (param2String == null) {
/* 526 */           return ClassReloadingStrategy.Strategy.a();
/*     */         }
/*     */         ClassDefinition classDefinition;
/* 529 */         if ((classDefinition = this.redefinedClasses.remove(param2Class)) == null)
/* 530 */           return ClassReloadingStrategy.Strategy.a();  return classDefinition
/* 531 */           .getDefinitionClassFile();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void assertTransformation() {
/* 538 */         if (!this.redefinedClasses.isEmpty()) {
/* 539 */           throw new IllegalStateException("Could not transform: " + this.redefinedClasses.keySet());
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected enum ClassResettingTransformer
/*     */       implements ClassFileTransformer
/*     */     {
/* 552 */       INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @MaybeNull
/*     */       public final byte[] transform(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull String param2String, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain, byte[] param2ArrayOfbyte) {
/* 563 */         return ClassReloadingStrategy.Strategy.a();
/*     */       }
/*     */     }
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
/*     */   public enum Disabled
/*     */     implements BootstrapInjection
/*     */   {
/* 589 */     INSTANCE;
/*     */ 
/*     */ 
/*     */     
/*     */     public final ClassInjector make(Instrumentation param1Instrumentation)
/*     */     {
/* 595 */       throw new IllegalStateException("Bootstrap injection is not enabled"); } } protected static interface BootstrapInjection { ClassInjector make(Instrumentation param1Instrumentation); public enum Disabled implements BootstrapInjection { INSTANCE; public final ClassInjector make(Instrumentation param2Instrumentation) { throw new IllegalStateException("Bootstrap injection is not enabled"); }
/*     */        }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Enhance
/*     */     public static class Enabled
/*     */       implements BootstrapInjection
/*     */     {
/*     */       private final File folder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected Enabled(File param2File) {
/* 616 */         this.folder = param2File;
/*     */       }
/*     */       public boolean equals(@MaybeNull Object param2Object) {
/*     */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.folder.equals(((Enabled)param2Object).folder))));
/*     */       } public int hashCode() {
/*     */         return getClass().hashCode() * 31 + this.folder.hashCode();
/*     */       }
/* 623 */       public ClassInjector make(Instrumentation param2Instrumentation) { return ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, param2Instrumentation); } } } @Enhance public static class Enabled implements BootstrapInjection { public ClassInjector make(Instrumentation param1Instrumentation) { return ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, param1Instrumentation); }
/*     */ 
/*     */     
/*     */     private final File folder;
/*     */     
/*     */     protected Enabled(File param1File) {
/*     */       this.folder = param1File;
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.folder.equals(((Enabled)param1Object).folder))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.folder.hashCode();
/*     */     } }
/*     */ 
/*     */   
/*     */   @Proxied("java.lang.instrument.Instrumentation")
/*     */   protected static interface Dispatcher {
/*     */     @Proxied("isModifiableClass")
/*     */     boolean isModifiableClass(Instrumentation param1Instrumentation, Class<?> param1Class);
/*     */     
/*     */     @Proxied("isRetransformClassesSupported")
/*     */     boolean isRetransformClassesSupported(Instrumentation param1Instrumentation);
/*     */     
/*     */     @Proxied("addTransformer")
/*     */     void addTransformer(Instrumentation param1Instrumentation, ClassFileTransformer param1ClassFileTransformer, boolean param1Boolean);
/*     */     
/*     */     @Proxied("retransformClasses")
/*     */     void retransformClasses(Instrumentation param1Instrumentation, Class<?>[] param1ArrayOfClass);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\loading\ClassReloadingStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */