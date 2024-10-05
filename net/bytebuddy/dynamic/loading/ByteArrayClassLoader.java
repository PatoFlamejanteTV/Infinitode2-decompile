/*      */ package net.bytebuddy.dynamic.loading;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.InputStream;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.URL;
/*      */ import java.net.URLConnection;
/*      */ import java.net.URLEncoder;
/*      */ import java.net.URLStreamHandler;
/*      */ import java.security.AccessControlContext;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.security.ProtectionDomain;
/*      */ import java.util.Arrays;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.ConcurrentMap;
/*      */ import net.bytebuddy.ClassFileVersion;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.utility.GraalImageCode;
/*      */ import net.bytebuddy.utility.JavaModule;
/*      */ import net.bytebuddy.utility.nullability.AlwaysNull;
/*      */ import net.bytebuddy.utility.nullability.MaybeNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ByteArrayClassLoader
/*      */   extends InjectionClassLoader
/*      */ {
/*      */   public static final String URL_SCHEMA = "bytebuddy";
/*      */   private static final int FROM_BEGINNING = 0;
/*      */   @AlwaysNull
/*   72 */   private static final URL NO_URL = null;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   77 */   private static final PackageLookupStrategy PACKAGE_LOOKUP_STRATEGY = doPrivileged(PackageLookupStrategy.CreationAction.INSTANCE);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   82 */   protected static final SynchronizationStrategy.Initializable SYNCHRONIZATION_STRATEGY = doPrivileged(SynchronizationStrategy.CreationAction.INSTANCE); protected final ConcurrentMap<String, byte[]> typeDefinitions; protected final PersistenceHandler persistenceHandler; @MaybeNull
/*      */   protected final ProtectionDomain protectionDomain; protected final PackageDefinitionStrategy packageDefinitionStrategy; protected final ClassFilePostProcessor classFilePostProcessor;
/*      */   @MaybeNull
/*      */   protected final Object accessControlContext;
/*      */   private static final boolean ACCESS_CONTROLLER;
/*      */   
/*   88 */   static { doRegisterAsParallelCapable(); } static { 
/*   89 */     try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */      }
/*      */ 
/*      */ 
/*      */   
/*      */   @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Must be invoked from targeting class loader type.")
/*      */   private static void doRegisterAsParallelCapable() {
/*      */     try {
/*      */       Method method;
/*   98 */       (method = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0])).setAccessible(true);
/*   99 */       method.invoke(null, new Object[0]); return;
/*  100 */     } catch (Throwable throwable) {
/*      */       return;
/*      */     } 
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
/*  114 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteArrayClassLoader(@MaybeNull ClassLoader paramClassLoader, Map<String, byte[]> paramMap) {
/*  156 */     this(paramClassLoader, true, paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteArrayClassLoader(@MaybeNull ClassLoader paramClassLoader, boolean paramBoolean, Map<String, byte[]> paramMap) {
/*  167 */     this(paramClassLoader, paramBoolean, paramMap, PersistenceHandler.LATENT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteArrayClassLoader(@MaybeNull ClassLoader paramClassLoader, Map<String, byte[]> paramMap, PersistenceHandler paramPersistenceHandler) {
/*  178 */     this(paramClassLoader, true, paramMap, paramPersistenceHandler);
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
/*      */   public ByteArrayClassLoader(@MaybeNull ClassLoader paramClassLoader, boolean paramBoolean, Map<String, byte[]> paramMap, PersistenceHandler paramPersistenceHandler) {
/*  190 */     this(paramClassLoader, paramBoolean, paramMap, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, paramPersistenceHandler, PackageDefinitionStrategy.Trivial.INSTANCE);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteArrayClassLoader(@MaybeNull ClassLoader paramClassLoader, Map<String, byte[]> paramMap, @MaybeNull ProtectionDomain paramProtectionDomain, PersistenceHandler paramPersistenceHandler, PackageDefinitionStrategy paramPackageDefinitionStrategy) {
/*  207 */     this(paramClassLoader, true, paramMap, paramProtectionDomain, paramPersistenceHandler, paramPackageDefinitionStrategy);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteArrayClassLoader(@MaybeNull ClassLoader paramClassLoader, boolean paramBoolean, Map<String, byte[]> paramMap, @MaybeNull ProtectionDomain paramProtectionDomain, PersistenceHandler paramPersistenceHandler, PackageDefinitionStrategy paramPackageDefinitionStrategy) {
/*  226 */     this(paramClassLoader, paramBoolean, paramMap, paramProtectionDomain, paramPersistenceHandler, paramPackageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteArrayClassLoader(@MaybeNull ClassLoader paramClassLoader, Map<String, byte[]> paramMap, @MaybeNull ProtectionDomain paramProtectionDomain, PersistenceHandler paramPersistenceHandler, PackageDefinitionStrategy paramPackageDefinitionStrategy, ClassFilePostProcessor paramClassFilePostProcessor) {
/*  245 */     this(paramClassLoader, true, paramMap, paramProtectionDomain, paramPersistenceHandler, paramPackageDefinitionStrategy, paramClassFilePostProcessor);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteArrayClassLoader(@MaybeNull ClassLoader paramClassLoader, boolean paramBoolean, Map<String, byte[]> paramMap, @MaybeNull ProtectionDomain paramProtectionDomain, PersistenceHandler paramPersistenceHandler, PackageDefinitionStrategy paramPackageDefinitionStrategy, ClassFilePostProcessor paramClassFilePostProcessor) {
/*  266 */     super(paramClassLoader, paramBoolean);
/*  267 */     this.typeDefinitions = (ConcurrentMap)new ConcurrentHashMap<String, byte>((Map)paramMap);
/*  268 */     this.protectionDomain = paramProtectionDomain;
/*  269 */     this.persistenceHandler = paramPersistenceHandler;
/*  270 */     this.packageDefinitionStrategy = paramPackageDefinitionStrategy;
/*  271 */     this.classFilePostProcessor = paramClassFilePostProcessor;
/*  272 */     this.accessControlContext = getContext();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @MaybeNull
/*      */   @Enhance
/*      */   private static Object getContext() {
/*  283 */     return ACCESS_CONTROLLER ? AccessController.getContext() : null;
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
/*      */   @Enhance
/*      */   private static <T> T doPrivileged(PrivilegedAction<T> paramPrivilegedAction, @MaybeNull Object paramObject) {
/*  296 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction, (AccessControlContext)paramObject) : paramPrivilegedAction.run();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Object methodHandle() {
/*  306 */     return Class.forName("java.lang.invoke.MethodHandles").getMethod("lookup", new Class[0]).invoke(null, new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader paramClassLoader, Map<TypeDescription, byte[]> paramMap) {
/*  317 */     return load(paramClassLoader, paramMap, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, PersistenceHandler.LATENT, PackageDefinitionStrategy.Trivial.INSTANCE, false, true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SuppressFBWarnings(value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"}, justification = "Assuring privilege is explicit user responsibility.")
/*      */   public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader paramClassLoader, Map<TypeDescription, byte[]> paramMap, @MaybeNull ProtectionDomain paramProtectionDomain, PersistenceHandler paramPersistenceHandler, PackageDefinitionStrategy paramPackageDefinitionStrategy, boolean paramBoolean1, boolean paramBoolean2) {
/*  346 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  347 */     for (Map.Entry<TypeDescription, byte> entry : paramMap.entrySet()) {
/*  348 */       hashMap.put(((TypeDescription)entry.getKey()).getName(), entry.getValue());
/*      */     }
/*  350 */     paramClassLoader = new ByteArrayClassLoader(paramClassLoader, paramBoolean2, (Map)hashMap, paramProtectionDomain, paramPersistenceHandler, paramPackageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  357 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*  358 */     for (TypeDescription typeDescription : paramMap.keySet()) {
/*      */       try {
/*  360 */         Class<?> clazz = Class.forName(typeDescription.getName(), false, paramClassLoader);
/*  361 */         if (!GraalImageCode.getCurrent().isNativeImageExecution() && paramBoolean1 && clazz.getClassLoader() != paramClassLoader) {
/*  362 */           throw new IllegalStateException("Class already loaded: " + clazz);
/*      */         }
/*  364 */         linkedHashMap.put(typeDescription, clazz);
/*  365 */       } catch (ClassNotFoundException classNotFoundException) {
/*  366 */         throw new IllegalStateException("Cannot load class " + typeDescription, classNotFoundException);
/*      */       } 
/*      */     } 
/*  369 */     return (Map)linkedHashMap;
/*      */   }
/*      */ 
/*      */   
/*      */   protected Map<String, Class<?>> doDefineClasses(Map<String, byte[]> paramMap) {
/*  374 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  375 */     for (Map.Entry<String, byte> entry : paramMap.entrySet()) {
/*  376 */       hashMap.put(entry.getKey(), this.typeDefinitions.putIfAbsent((String)entry.getKey(), (byte[])entry.getValue()));
/*      */     }
/*      */     try {
/*  379 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*  380 */       for (String null : paramMap.keySet()) {
/*  381 */         synchronized (SYNCHRONIZATION_STRATEGY.initialize().getClassLoadingLock(this, null)) {
/*  382 */           linkedHashMap.put(null, loadClass(null));
/*      */         } 
/*      */       } 
/*  385 */       return (Map)linkedHashMap;
/*      */     } finally {
/*  387 */       for (Iterator<Map.Entry> iterator = hashMap.entrySet().iterator(); iterator.hasNext(); ) {
/*  388 */         Map.Entry<?, ?> entry; if ((entry = iterator.next()).getValue() == null) {
/*  389 */           this.persistenceHandler.release((String)entry.getKey(), this.typeDefinitions); continue;
/*      */         } 
/*  391 */         this.typeDefinitions.put((String)entry.getKey(), (byte[])entry.getValue());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Class<?> findClass(String paramString) {
/*      */     byte[] arrayOfByte;
/*  402 */     if ((arrayOfByte = this.persistenceHandler.lookup(paramString, this.typeDefinitions)) == null) {
/*  403 */       throw new ClassNotFoundException(paramString);
/*      */     }
/*  405 */     return doPrivileged(new ClassDefinitionAction(this, paramString, this.classFilePostProcessor.transform(this, paramString, this.protectionDomain, arrayOfByte)), this.accessControlContext);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @MaybeNull
/*      */   protected URL findResource(String paramString) {
/*  417 */     return this.persistenceHandler.url(paramString, this.typeDefinitions);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Enumeration<URL> findResources(String paramString) {
/*      */     URL uRL;
/*  425 */     return (Enumeration<URL>)(((uRL = this.persistenceHandler.url(paramString, this.typeDefinitions)) == null) ? EmptyEnumeration.INSTANCE : new SingletonEnumeration(uRL));
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
/*      */   @MaybeNull
/*      */   private Package doGetPackage(String paramString) {
/*  439 */     return getPackage(paramString);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum CreationAction
/*      */     implements PrivilegedAction<SynchronizationStrategy.Initializable>
/*      */   {
/*  477 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*      */     public final ByteArrayClassLoader.SynchronizationStrategy.Initializable run()
/*      */     {
/*      */       
/*  486 */       try { Class<?> clazz1 = Class.forName("java.lang.invoke.MethodType"), clazz2 = Class.forName("java.lang.invoke.MethodHandle");
/*  487 */         return new ByteArrayClassLoader.SynchronizationStrategy.ForJava8CapableVm(Class.forName("java.lang.invoke.MethodHandles$Lookup")
/*  488 */             .getMethod("findVirtual", new Class[] { Class.class, String.class, clazz1
/*  489 */               }).invoke(ByteArrayClassLoader.a(), new Object[] { ClassLoader.class, "getClassLoadingLock", clazz1.getMethod("methodType", new Class[] { Class.class, Class[].class
/*      */                   
/*  491 */                   }).invoke(null, new Object[] { Object.class, { String.class }
/*  492 */                   }) }), clazz2.getMethod("bindTo", new Class[] { Object.class }), clazz2
/*  493 */             .getMethod("invokeWithArguments", new Class[] { Object[].class })); }
/*  494 */       catch (Exception exception)
/*      */       
/*      */       { 
/*  497 */         return (ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V9) && ByteArrayClassLoader.class.getClassLoader() == null) ? ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE : new ByteArrayClassLoader.SynchronizationStrategy.ForJava7CapableVm(ClassLoader.class
/*      */             
/*  499 */             .getDeclaredMethod("getClassLoadingLock", new Class[] { String.class })); }
/*      */       
/*  501 */       catch (Exception exception)
/*  502 */       { return ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE; }  } } protected static interface SynchronizationStrategy { Object getClassLoadingLock(ByteArrayClassLoader param1ByteArrayClassLoader, String param1String); public static interface Initializable { ByteArrayClassLoader.SynchronizationStrategy initialize(); } public enum CreationAction implements PrivilegedAction<Initializable> { @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final ByteArrayClassLoader.SynchronizationStrategy.Initializable run() { try { Class<?> clazz1 = Class.forName("java.lang.invoke.MethodType"), clazz2 = Class.forName("java.lang.invoke.MethodHandle"); return new ByteArrayClassLoader.SynchronizationStrategy.ForJava8CapableVm(Class.forName("java.lang.invoke.MethodHandles$Lookup").getMethod("findVirtual", new Class[] { Class.class, String.class, clazz1 }).invoke(ByteArrayClassLoader.a(), new Object[] { ClassLoader.class, "getClassLoadingLock", clazz1.getMethod("methodType", new Class[] { Class.class, Class[].class }).invoke(null, new Object[] { Object.class, { String.class } }) }), clazz2.getMethod("bindTo", new Class[] { Object.class }), clazz2.getMethod("invokeWithArguments", new Class[] { Object[].class })); } catch (Exception exception) { return (ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V9) && ByteArrayClassLoader.class.getClassLoader() == null) ? ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE : new ByteArrayClassLoader.SynchronizationStrategy.ForJava7CapableVm(ClassLoader.class.getDeclaredMethod("getClassLoadingLock", new Class[] { String.class })); } catch (Exception exception) { return ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE; }
/*      */          }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       INSTANCE; }
/*      */ 
/*      */ 
/*      */     
/*      */     public enum ForLegacyVm
/*      */       implements SynchronizationStrategy, Initializable
/*      */     {
/*  515 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final Object getClassLoadingLock(ByteArrayClassLoader param2ByteArrayClassLoader, String param2String) {
/*  521 */         return param2ByteArrayClassLoader;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final ByteArrayClassLoader.SynchronizationStrategy initialize() {
/*  528 */         return this;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForJava7CapableVm
/*      */       implements SynchronizationStrategy, Initializable
/*      */     {
/*      */       private final Method method;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForJava7CapableVm(Method param2Method) {
/*  549 */         this.method = param2Method;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Object getClassLoadingLock(ByteArrayClassLoader param2ByteArrayClassLoader, String param2String) {
/*      */         try {
/*  557 */           return this.method.invoke(param2ByteArrayClassLoader, new Object[] { param2String });
/*  558 */         } catch (IllegalAccessException illegalAccessException) {
/*  559 */           throw new IllegalStateException(illegalAccessException);
/*  560 */         } catch (InvocationTargetException invocationTargetException) {
/*  561 */           throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Assuring privilege is explicit user responsibility.")
/*      */       public ByteArrayClassLoader.SynchronizationStrategy initialize() {
/*      */         try {
/*  571 */           this.method.setAccessible(true);
/*  572 */           return this;
/*  573 */         } catch (Exception exception) {
/*  574 */           return ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE;
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.method.equals(((ForJava7CapableVm)param2Object).method))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.method.hashCode();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForJava8CapableVm
/*      */       implements SynchronizationStrategy, Initializable
/*      */     {
/*      */       private final Object methodHandle;
/*      */ 
/*      */       
/*      */       private final Method bindTo;
/*      */ 
/*      */       
/*      */       private final Method invokeWithArguments;
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForJava8CapableVm(Object param2Object, Method param2Method1, Method param2Method2) {
/*  608 */         this.methodHandle = param2Object;
/*  609 */         this.bindTo = param2Method1;
/*  610 */         this.invokeWithArguments = param2Method2;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteArrayClassLoader.SynchronizationStrategy initialize() {
/*  617 */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Object getClassLoadingLock(ByteArrayClassLoader param2ByteArrayClassLoader, String param2String) {
/*      */         try {
/*  625 */           return this.invokeWithArguments.invoke(this.bindTo.invoke(this.methodHandle, new Object[] { param2ByteArrayClassLoader }), new Object[] { { param2String } });
/*  626 */         } catch (IllegalAccessException illegalAccessException) {
/*  627 */           throw new IllegalStateException(illegalAccessException);
/*  628 */         } catch (InvocationTargetException invocationTargetException) {
/*  629 */           throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.methodHandle.equals(((ForJava8CapableVm)param2Object).methodHandle) ? false : (!this.bindTo.equals(((ForJava8CapableVm)param2Object).bindTo) ? false : (!!this.invokeWithArguments.equals(((ForJava8CapableVm)param2Object).invokeWithArguments))))));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return ((getClass().hashCode() * 31 + this.methodHandle.hashCode()) * 31 + this.bindTo.hashCode()) * 31 + this.invokeWithArguments.hashCode();
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance(includeSyntheticFields = true)
/*      */   protected class ClassDefinitionAction
/*      */     implements PrivilegedAction<Class<?>>
/*      */   {
/*      */     private final String name;
/*      */     
/*      */     private final byte[] binaryRepresentation;
/*      */ 
/*      */     
/*      */     protected ClassDefinitionAction(ByteArrayClassLoader this$0, String param1String, byte[] param1ArrayOfbyte) {
/*  658 */       this.name = param1String;
/*  659 */       this.binaryRepresentation = param1ArrayOfbyte;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Class<?> run() {
/*  668 */       String str = this.name.substring(0, i); int i;
/*      */       PackageDefinitionStrategy.Definition definition;
/*  670 */       if ((i = this.name.lastIndexOf('.')) != -1 && (definition = this.a.packageDefinitionStrategy.define(this.a, str, this.name)).isDefined()) {
/*      */         Package package_;
/*  672 */         if ((package_ = ByteArrayClassLoader.b().apply(this.a, str)) == null) {
/*  673 */           ByteArrayClassLoader.a(this.a, str, definition
/*  674 */               .getSpecificationTitle(), definition
/*  675 */               .getSpecificationVersion(), definition
/*  676 */               .getSpecificationVendor(), definition
/*  677 */               .getImplementationTitle(), definition
/*  678 */               .getImplementationVersion(), definition
/*  679 */               .getImplementationVendor(), definition
/*  680 */               .getSealBase());
/*  681 */         } else if (!definition.isCompatibleTo(package_)) {
/*  682 */           throw new SecurityException("Sealing violation for package " + str);
/*      */         } 
/*      */       } 
/*      */       
/*  686 */       return ByteArrayClassLoader.a(this.a, this.name, this.binaryRepresentation, 0, this.binaryRepresentation.length, this.a.protectionDomain);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.name.equals(((ClassDefinitionAction)param1Object).name) ? false : (!Arrays.equals(this.binaryRepresentation, ((ClassDefinitionAction)param1Object).binaryRepresentation) ? false : (!!this.a.equals(((ClassDefinitionAction)param1Object).a))))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return ((getClass().hashCode() * 31 + this.name.hashCode()) * 31 + Arrays.hashCode(this.binaryRepresentation)) * 31 + this.a.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum CreationAction
/*      */     implements PrivilegedAction<PackageLookupStrategy>
/*      */   {
/*  713 */     INSTANCE;
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.")
/*      */     public final ByteArrayClassLoader.PackageLookupStrategy run()
/*      */     {
/*  720 */       if (JavaModule.isSupported()) {
/*      */         try {
/*  722 */           return new ByteArrayClassLoader.PackageLookupStrategy.ForJava9CapableVm(ClassLoader.class.getMethod("getDefinedPackage", new Class[] { String.class }));
/*  723 */         } catch (Exception exception) {
/*  724 */           return ByteArrayClassLoader.PackageLookupStrategy.ForLegacyVm.INSTANCE;
/*      */         } 
/*      */       }
/*  727 */       return ByteArrayClassLoader.PackageLookupStrategy.ForLegacyVm.INSTANCE; } } protected static interface PackageLookupStrategy { @MaybeNull Package apply(ByteArrayClassLoader param1ByteArrayClassLoader, String param1String); public enum CreationAction implements PrivilegedAction<PackageLookupStrategy> { INSTANCE; @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback.") public final ByteArrayClassLoader.PackageLookupStrategy run() { if (JavaModule.isSupported()) try { return new ByteArrayClassLoader.PackageLookupStrategy.ForJava9CapableVm(ClassLoader.class.getMethod("getDefinedPackage", new Class[] { String.class })); } catch (Exception exception) { return ByteArrayClassLoader.PackageLookupStrategy.ForLegacyVm.INSTANCE; }   return ByteArrayClassLoader.PackageLookupStrategy.ForLegacyVm.INSTANCE; }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum ForLegacyVm
/*      */       implements PackageLookupStrategy
/*      */     {
/*  740 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public final Package apply(ByteArrayClassLoader param2ByteArrayClassLoader, String param2String) {
/*  747 */         return ByteArrayClassLoader.a(param2ByteArrayClassLoader, param2String);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     public static class ForJava9CapableVm
/*      */       implements PackageLookupStrategy
/*      */     {
/*      */       private final Method getDefinedPackage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ForJava9CapableVm(Method param2Method) {
/*  768 */         this.getDefinedPackage = param2Method;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public Package apply(ByteArrayClassLoader param2ByteArrayClassLoader, String param2String) {
/*      */         try {
/*  777 */           return (Package)this.getDefinedPackage.invoke(param2ByteArrayClassLoader, new Object[] { param2String });
/*  778 */         } catch (IllegalAccessException illegalAccessException) {
/*  779 */           throw new IllegalStateException(illegalAccessException);
/*  780 */         } catch (InvocationTargetException invocationTargetException) {
/*  781 */           throw new IllegalStateException(invocationTargetException.getTargetException());
/*      */         } 
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.getDefinedPackage.equals(((ForJava9CapableVm)param2Object).getDefinedPackage))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.getDefinedPackage.hashCode();
/*      */       }
/*      */     } }
/*      */ 
/*      */   
/*      */   public enum PersistenceHandler {
/*  796 */     MANIFEST(true)
/*      */     {
/*      */       protected final byte[] lookup(String param2String, ConcurrentMap<String, byte[]> param2ConcurrentMap) {
/*  799 */         return param2ConcurrentMap.get(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       protected final URL url(String param2String, ConcurrentMap<String, byte[]> param2ConcurrentMap) {
/*  804 */         if (!param2String.endsWith(".class"))
/*  805 */           return ByteArrayClassLoader.c(); 
/*  806 */         if (param2String.startsWith("/")) {
/*  807 */           param2String = param2String.substring(1);
/*      */         }
/*  809 */         String str = param2String.replace('/', '.').substring(0, param2String.length() - 6);
/*      */         byte[] arrayOfByte;
/*  811 */         if ((arrayOfByte = param2ConcurrentMap.get(str)) == null)
/*  812 */           return ByteArrayClassLoader.c(); 
/*  813 */         return (URL)ByteArrayClassLoader.a(new UrlDefinitionAction(param2String, arrayOfByte));
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
/*      */       protected final void release(String param2String, ConcurrentMap<String, byte[]> param2ConcurrentMap) {}
/*      */     },
/*  826 */     LATENT(false)
/*      */     {
/*      */       protected final byte[] lookup(String param2String, ConcurrentMap<String, byte[]> param2ConcurrentMap) {
/*  829 */         return param2ConcurrentMap.remove(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       protected final URL url(String param2String, ConcurrentMap<String, byte[]> param2ConcurrentMap) {
/*  834 */         return ByteArrayClassLoader.c();
/*      */       }
/*      */ 
/*      */       
/*      */       protected final void release(String param2String, ConcurrentMap<String, byte[]> param2ConcurrentMap) {
/*  839 */         param2ConcurrentMap.remove(param2String);
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String CLASS_FILE_SUFFIX = ".class";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean manifest;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     PersistenceHandler(boolean param1Boolean) {
/*  859 */       this.manifest = param1Boolean;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isManifest() {
/*  868 */       return this.manifest;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     protected abstract byte[] lookup(String param1String, ConcurrentMap<String, byte[]> param1ConcurrentMap);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @MaybeNull
/*      */     protected abstract URL url(String param1String, ConcurrentMap<String, byte[]> param1ConcurrentMap);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected abstract void release(String param1String, ConcurrentMap<String, byte[]> param1ConcurrentMap);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Enhance
/*      */     protected static class UrlDefinitionAction
/*      */       implements PrivilegedAction<URL>
/*      */     {
/*      */       private static final String ENCODING = "UTF-8";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final int NO_PORT = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static final String NO_FILE = "";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final String typeName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final byte[] binaryRepresentation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected UrlDefinitionAction(String param2String, byte[] param2ArrayOfbyte) {
/*  937 */         this.typeName = param2String;
/*  938 */         this.binaryRepresentation = param2ArrayOfbyte;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public URL run() {
/*      */         try {
/*  946 */           return new URL("bytebuddy", 
/*  947 */               URLEncoder.encode(this.typeName.replace('.', '/'), "UTF-8"), -1, "", new ByteArrayUrlStreamHandler(this.binaryRepresentation));
/*      */ 
/*      */         
/*      */         }
/*  951 */         catch (MalformedURLException malformedURLException) {
/*  952 */           throw new IllegalStateException("Cannot create URL for " + this.typeName, malformedURLException);
/*  953 */         } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  954 */           throw new IllegalStateException("Could not find encoding: UTF-8", unsupportedEncodingException);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.typeName.equals(((UrlDefinitionAction)param2Object).typeName) ? false : (!!Arrays.equals(this.binaryRepresentation, ((UrlDefinitionAction)param2Object).binaryRepresentation)))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.typeName.hashCode()) * 31 + Arrays.hashCode(this.binaryRepresentation);
/*      */       }
/*      */       
/*      */       @Enhance
/*      */       protected static class ByteArrayUrlStreamHandler
/*      */         extends URLStreamHandler
/*      */       {
/*      */         private final byte[] binaryRepresentation;
/*      */         
/*      */         protected ByteArrayUrlStreamHandler(byte[] param3ArrayOfbyte) {
/*  975 */           this.binaryRepresentation = param3ArrayOfbyte;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected URLConnection openConnection(URL param3URL) {
/*  982 */           return new ByteArrayUrlConnection(param3URL, new ByteArrayInputStream(this.binaryRepresentation));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean equals(@MaybeNull Object param3Object) {
/*      */           return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!Arrays.equals(this.binaryRepresentation, ((ByteArrayUrlStreamHandler)param3Object).binaryRepresentation))));
/*      */         }
/*      */ 
/*      */         
/*      */         public int hashCode() {
/*      */           return getClass().hashCode() * 31 + Arrays.hashCode(this.binaryRepresentation);
/*      */         }
/*      */ 
/*      */         
/*      */         protected static class ByteArrayUrlConnection
/*      */           extends URLConnection
/*      */         {
/*      */           private final InputStream inputStream;
/*      */           
/*      */           protected ByteArrayUrlConnection(URL param4URL, InputStream param4InputStream) {
/* 1002 */             super(param4URL);
/* 1003 */             this.inputStream = param4InputStream;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void connect() {
/* 1010 */             this.connected = true;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public InputStream getInputStream() {
/* 1017 */             connect();
/* 1018 */             return this.inputStream;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
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
/*      */   public static class ChildFirst
/*      */     extends ByteArrayClassLoader
/*      */   {
/*      */     private static final String CLASS_FILE_SUFFIX = ".class";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/* 1046 */       doRegisterAsParallelCapable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Must be invoked from targeting class loader type.")
/*      */     private static void doRegisterAsParallelCapable() {
/*      */       try {
/*      */         Method method;
/* 1056 */         (method = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0])).setAccessible(true);
/* 1057 */         method.invoke(null, new Object[0]); return;
/* 1058 */       } catch (Throwable throwable) {
/*      */         return;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ChildFirst(@MaybeNull ClassLoader param1ClassLoader, Map<String, byte[]> param1Map) {
/* 1070 */       super(param1ClassLoader, param1Map);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ChildFirst(@MaybeNull ClassLoader param1ClassLoader, boolean param1Boolean, Map<String, byte[]> param1Map) {
/* 1081 */       super(param1ClassLoader, param1Boolean, param1Map);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ChildFirst(@MaybeNull ClassLoader param1ClassLoader, Map<String, byte[]> param1Map, ByteArrayClassLoader.PersistenceHandler param1PersistenceHandler) {
/* 1092 */       super(param1ClassLoader, param1Map, param1PersistenceHandler);
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
/*      */     public ChildFirst(@MaybeNull ClassLoader param1ClassLoader, boolean param1Boolean, Map<String, byte[]> param1Map, ByteArrayClassLoader.PersistenceHandler param1PersistenceHandler) {
/* 1104 */       super(param1ClassLoader, param1Boolean, param1Map, param1PersistenceHandler);
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
/*      */     public ChildFirst(@MaybeNull ClassLoader param1ClassLoader, Map<String, byte[]> param1Map, @MaybeNull ProtectionDomain param1ProtectionDomain, ByteArrayClassLoader.PersistenceHandler param1PersistenceHandler, PackageDefinitionStrategy param1PackageDefinitionStrategy) {
/* 1121 */       super(param1ClassLoader, param1Map, param1ProtectionDomain, param1PersistenceHandler, param1PackageDefinitionStrategy);
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
/*      */     public ChildFirst(@MaybeNull ClassLoader param1ClassLoader, boolean param1Boolean, Map<String, byte[]> param1Map, @MaybeNull ProtectionDomain param1ProtectionDomain, ByteArrayClassLoader.PersistenceHandler param1PersistenceHandler, PackageDefinitionStrategy param1PackageDefinitionStrategy) {
/* 1140 */       super(param1ClassLoader, param1Boolean, param1Map, param1ProtectionDomain, param1PersistenceHandler, param1PackageDefinitionStrategy);
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
/*      */     public ChildFirst(@MaybeNull ClassLoader param1ClassLoader, Map<String, byte[]> param1Map, @MaybeNull ProtectionDomain param1ProtectionDomain, ByteArrayClassLoader.PersistenceHandler param1PersistenceHandler, PackageDefinitionStrategy param1PackageDefinitionStrategy, ClassFilePostProcessor param1ClassFilePostProcessor) {
/* 1159 */       super(param1ClassLoader, param1Map, param1ProtectionDomain, param1PersistenceHandler, param1PackageDefinitionStrategy, param1ClassFilePostProcessor);
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
/*      */     public ChildFirst(@MaybeNull ClassLoader param1ClassLoader, boolean param1Boolean, Map<String, byte[]> param1Map, @MaybeNull ProtectionDomain param1ProtectionDomain, ByteArrayClassLoader.PersistenceHandler param1PersistenceHandler, PackageDefinitionStrategy param1PackageDefinitionStrategy, ClassFilePostProcessor param1ClassFilePostProcessor) {
/* 1180 */       super(param1ClassLoader, param1Boolean, param1Map, param1ProtectionDomain, param1PersistenceHandler, param1PackageDefinitionStrategy, param1ClassFilePostProcessor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param1ClassLoader, Map<TypeDescription, byte[]> param1Map) {
/* 1191 */       return load(param1ClassLoader, param1Map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, ByteArrayClassLoader.PersistenceHandler.LATENT, PackageDefinitionStrategy.Trivial.INSTANCE, false, true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"}, justification = "Assuring privilege is explicit user responsibility.")
/*      */     public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader param1ClassLoader, Map<TypeDescription, byte[]> param1Map, @MaybeNull ProtectionDomain param1ProtectionDomain, ByteArrayClassLoader.PersistenceHandler param1PersistenceHandler, PackageDefinitionStrategy param1PackageDefinitionStrategy, boolean param1Boolean1, boolean param1Boolean2) {
/* 1220 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 1221 */       for (Map.Entry<TypeDescription, byte> entry : param1Map.entrySet()) {
/* 1222 */         hashMap.put(((TypeDescription)entry.getKey()).getName(), entry.getValue());
/*      */       }
/* 1224 */       param1ClassLoader = new ChildFirst(param1ClassLoader, param1Boolean2, (Map)hashMap, param1ProtectionDomain, param1PersistenceHandler, param1PackageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1231 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 1232 */       for (TypeDescription typeDescription : param1Map.keySet()) {
/*      */         try {
/* 1234 */           Class<?> clazz = Class.forName(typeDescription.getName(), false, param1ClassLoader);
/* 1235 */           if (!GraalImageCode.getCurrent().isNativeImageExecution() && param1Boolean1 && clazz.getClassLoader() != param1ClassLoader) {
/* 1236 */             throw new IllegalStateException("Class already loaded: " + clazz);
/*      */           }
/* 1238 */           linkedHashMap.put(typeDescription, clazz);
/* 1239 */         } catch (ClassNotFoundException classNotFoundException) {
/* 1240 */           throw new IllegalStateException("Cannot load class " + typeDescription, classNotFoundException);
/*      */         } 
/*      */       } 
/* 1243 */       return (Map)linkedHashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Class<?> loadClass(String param1String, boolean param1Boolean) {
/* 1250 */       synchronized (SYNCHRONIZATION_STRATEGY.initialize().getClassLoadingLock(this, param1String)) {
/*      */         Class<?> clazz;
/* 1252 */         if ((clazz = findLoadedClass(param1String)) != null) {
/* 1253 */           return clazz;
/*      */         }
/*      */         try {
/* 1256 */           clazz = findClass(param1String);
/* 1257 */           if (param1Boolean) {
/* 1258 */             resolveClass(clazz);
/*      */           }
/* 1260 */           return clazz;
/* 1261 */         } catch (ClassNotFoundException classNotFoundException) {
/*      */ 
/*      */ 
/*      */           
/* 1265 */           return super.loadClass(param1String, param1Boolean);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public URL getResource(String param1String) {
/*      */       URL uRL;
/* 1278 */       if ((uRL = this.persistenceHandler.url(param1String, this.typeDefinitions)) != null || isShadowed(param1String)) return uRL;  return super
/*      */         
/* 1280 */         .getResource(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Enumeration<URL> getResources(String param1String) {
/*      */       URL uRL;
/* 1288 */       if ((uRL = this.persistenceHandler.url(param1String, this.typeDefinitions)) == null)
/* 1289 */         return super.getResources(param1String);  return new PrependingEnumeration(uRL, super
/* 1290 */           .getResources(param1String));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean isShadowed(String param1String) {
/* 1300 */       if (this.persistenceHandler.isManifest() || !param1String.endsWith(".class")) {
/* 1301 */         return false;
/*      */       }
/*      */       
/* 1304 */       synchronized (this) {
/* 1305 */         param1String = param1String.replace('/', '.').substring(0, param1String.length() - 6);
/* 1306 */         if (this.typeDefinitions.containsKey(param1String))
/* 1307 */           return true; 
/*      */         Class<?> clazz;
/* 1309 */         return ((
/* 1310 */           clazz = findLoadedClass(param1String)) != null && clazz.getClassLoader() == this);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static class PrependingEnumeration
/*      */       implements Enumeration<URL>
/*      */     {
/*      */       @MaybeNull
/*      */       private URL nextElement;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final Enumeration<URL> enumeration;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected PrependingEnumeration(URL param2URL, Enumeration<URL> param2Enumeration) {
/* 1337 */         this.nextElement = param2URL;
/* 1338 */         this.enumeration = param2Enumeration;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasMoreElements() {
/* 1345 */         return (this.nextElement != null && this.enumeration.hasMoreElements());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public URL nextElement() {
/* 1352 */         if (this.nextElement != null && this.enumeration.hasMoreElements()) {
/*      */           try {
/* 1354 */             return this.nextElement;
/*      */           } finally {
/* 1356 */             this.nextElement = this.enumeration.nextElement();
/*      */           } 
/*      */         }
/* 1359 */         throw new NoSuchElementException();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected enum EmptyEnumeration
/*      */     implements Enumeration<URL>
/*      */   {
/* 1373 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean hasMoreElements() {
/* 1379 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final URL nextElement() {
/* 1386 */       throw new NoSuchElementException();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class SingletonEnumeration
/*      */     implements Enumeration<URL>
/*      */   {
/*      */     @MaybeNull
/*      */     private URL element;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected SingletonEnumeration(URL param1URL) {
/* 1407 */       this.element = param1URL;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasMoreElements() {
/* 1414 */       return (this.element != null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public URL nextElement() {
/* 1421 */       if (this.element == null) {
/* 1422 */         throw new NoSuchElementException();
/*      */       }
/*      */       try {
/* 1425 */         return this.element;
/*      */       } finally {
/* 1427 */         this.element = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface Initializable {
/*      */     ByteArrayClassLoader.SynchronizationStrategy initialize();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\loading\ByteArrayClassLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */