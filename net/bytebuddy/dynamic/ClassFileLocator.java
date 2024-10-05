/*      */ package net.bytebuddy.dynamic;
/*      */ 
/*      */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.lang.instrument.ClassFileTransformer;
/*      */ import java.lang.instrument.Instrumentation;
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.net.URL;
/*      */ import java.net.URLClassLoader;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedAction;
/*      */ import java.security.ProtectionDomain;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.Vector;
/*      */ import java.util.jar.JarFile;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.zip.ZipEntry;
/*      */ import java.util.zip.ZipFile;
/*      */ import net.bytebuddy.agent.builder.AgentBuilder;
/*      */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*      */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*      */ import net.bytebuddy.description.type.TypeDescription;
/*      */ import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
/*      */ import net.bytebuddy.matcher.ElementMatchers;
/*      */ import net.bytebuddy.utility.JavaModule;
/*      */ import net.bytebuddy.utility.JavaType;
/*      */ import net.bytebuddy.utility.StreamDrainer;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*      */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface ClassFileLocator
/*      */   extends Closeable
/*      */ {
/*      */   public static final String CLASS_FILE_EXTENSION = ".class";
/*      */   
/*      */   Resolution locate(String paramString);
/*      */   
/*      */   public static interface Resolution
/*      */   {
/*      */     boolean isResolved();
/*      */     
/*      */     byte[] resolve();
/*      */     
/*      */     @Enhance
/*      */     public static class Illegal
/*      */       implements Resolution
/*      */     {
/*      */       private final String typeName;
/*      */       
/*      */       public Illegal(String param2String) {
/*  107 */         this.typeName = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isResolved() {
/*  114 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public byte[] resolve() {
/*  121 */         throw new IllegalStateException("Could not locate class file for " + this.typeName);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.typeName.equals(((Illegal)param2Object).typeName))));
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.typeName.hashCode();
/*      */       }
/*      */     }
/*      */     
/*      */     @Enhance
/*      */     public static class Explicit
/*      */       implements Resolution
/*      */     {
/*      */       private final byte[] binaryRepresentation;
/*      */       
/*      */       @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is not modified by class contract.")
/*      */       public Explicit(byte[] param2ArrayOfbyte) {
/*  143 */         this.binaryRepresentation = param2ArrayOfbyte;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean isResolved() {
/*  150 */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @SuppressFBWarnings(value = {"EI_EXPOSE_REP"}, justification = "The array is not modified by class contract.")
/*      */       public byte[] resolve() {
/*  158 */         return this.binaryRepresentation;
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!Arrays.equals(this.binaryRepresentation, ((Explicit)param2Object).binaryRepresentation))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + Arrays.hashCode(this.binaryRepresentation);
/*      */       } }
/*      */   }
/*      */   
/*      */   public enum NoOp implements ClassFileLocator {
/*  171 */     INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final ClassFileLocator.Resolution locate(String param1String) {
/*  177 */       return new ClassFileLocator.Resolution.Illegal(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void close() {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Simple
/*      */     implements ClassFileLocator
/*      */   {
/*      */     private final Map<String, byte[]> classFiles;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Simple(Map<String, byte[]> param1Map) {
/*  205 */       this.classFiles = param1Map;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator of(String param1String, byte[] param1ArrayOfbyte) {
/*  216 */       return new Simple((Map)Collections.singletonMap(param1String, param1ArrayOfbyte));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator of(DynamicType param1DynamicType) {
/*  226 */       return of(param1DynamicType.getAllTypes());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator of(Map<TypeDescription, byte[]> param1Map) {
/*  236 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  237 */       for (Map.Entry<TypeDescription, byte> entry : param1Map.entrySet()) {
/*  238 */         hashMap.put(((TypeDescription)entry.getKey()).getName(), entry.getValue());
/*      */       }
/*  240 */       return new Simple((Map)hashMap);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator ofResources(Map<String, byte[]> param1Map) {
/*  250 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  251 */       for (Iterator<Map.Entry> iterator = param1Map.entrySet().iterator(); iterator.hasNext();) {
/*  252 */         if (((String)(entry = iterator.next()).getKey()).endsWith(".class")) {
/*  253 */           hashMap.put(((String)entry.getKey()).substring(0, ((String)entry.getKey()).length() - 6).replace('/', '.'), entry.getValue());
/*      */         }
/*      */       } 
/*  256 */       return new Simple((Map)hashMap);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/*      */       byte[] arrayOfByte;
/*  264 */       return (ClassFileLocator.Resolution)(((arrayOfByte = this.classFiles.get(param1String)) == null) ? new ClassFileLocator.Resolution.Illegal(param1String) : new ClassFileLocator.Resolution.Explicit(arrayOfByte));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.classFiles.equals(((Simple)param1Object).classFiles))));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.classFiles.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForClassLoader
/*      */     implements ClassFileLocator
/*      */   {
/*  292 */     private static final ClassLoader BOOT_LOADER_PROXY = doPrivileged(BootLoaderProxyCreationAction.INSTANCE); private final ClassLoader classLoader; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
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
/*      */     protected ForClassLoader(ClassLoader param1ClassLoader) {
/*  305 */       this.classLoader = param1ClassLoader;
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
/*  317 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator ofSystemLoader() {
/*  326 */       return new ForClassLoader(ClassLoader.getSystemClassLoader());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator ofPlatformLoader() {
/*  336 */       return of(ClassLoader.getSystemClassLoader().getParent());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator ofBootLoader() {
/*  345 */       return new ForClassLoader(BOOT_LOADER_PROXY);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator of(@MaybeNull ClassLoader param1ClassLoader) {
/*  355 */       return new ForClassLoader((param1ClassLoader == null) ? BOOT_LOADER_PROXY : param1ClassLoader);
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
/*      */     public static byte[] read(Class<?> param1Class) {
/*      */       try {
/*      */         ClassLoader classLoader;
/*  370 */         return locate(((classLoader = param1Class.getClassLoader()) == null) ? BOOT_LOADER_PROXY : classLoader, 
/*      */             
/*  372 */             TypeDescription.ForLoadedType.getName(param1Class)).resolve();
/*  373 */       } catch (IOException iOException) {
/*  374 */         throw new IllegalStateException("Cannot read class file for " + param1Class, iOException);
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
/*      */     public static Map<Class<?>, byte[]> read(Class<?>... param1VarArgs) {
/*  386 */       return read(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<Class<?>, byte[]> read(Collection<? extends Class<?>> param1Collection) {
/*  397 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  398 */       for (Class<?> clazz : param1Collection) {
/*  399 */         hashMap.put(clazz, read(clazz));
/*      */       }
/*  401 */       return (Map)hashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, byte[]> readToNames(Class<?>... param1VarArgs) {
/*  412 */       return readToNames(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Map<String, byte[]> readToNames(Collection<? extends Class<?>> param1Collection) {
/*  423 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  424 */       for (Class<?> clazz : param1Collection) {
/*  425 */         hashMap.put(clazz.getName(), read(clazz));
/*      */       }
/*  427 */       return (Map)hashMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/*  434 */       return locate(this.classLoader, param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected static ClassFileLocator.Resolution locate(ClassLoader param1ClassLoader, String param1String) {
/*      */       InputStream inputStream;
/*  454 */       if ((inputStream = param1ClassLoader.getResourceAsStream(param1String.replace('.', '/') + ".class")) != null) {
/*      */         try {
/*  456 */           return new ClassFileLocator.Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
/*      */         } finally {
/*  458 */           inputStream.close();
/*      */         } 
/*      */       }
/*  461 */       return new ClassFileLocator.Resolution.Illegal(param1String);
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.classLoader.equals(((ForClassLoader)param1Object).classLoader))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.classLoader.hashCode();
/*      */     }
/*      */     
/*      */     protected enum BootLoaderProxyCreationAction implements PrivilegedAction<ClassLoader> {
/*  473 */       INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final ClassLoader run() {
/*  479 */         return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER);
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
/*      */     
/*      */     public static class WeaklyReferenced
/*      */       extends WeakReference<ClassLoader>
/*      */       implements ClassFileLocator
/*      */     {
/*      */       private final int hashCode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected WeaklyReferenced(ClassLoader param2ClassLoader) {
/*  506 */         super(param2ClassLoader);
/*  507 */         this.hashCode = System.identityHashCode(param2ClassLoader);
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
/*      */       public static ClassFileLocator of(@MaybeNull ClassLoader param2ClassLoader) {
/*  521 */         if (param2ClassLoader == null || param2ClassLoader == ClassLoader.getSystemClassLoader() || param2ClassLoader == ClassLoader.getSystemClassLoader().getParent())
/*  522 */           return ClassFileLocator.ForClassLoader.of(param2ClassLoader);  return new WeaklyReferenced(param2ClassLoader);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ClassFileLocator.Resolution locate(String param2String) {
/*      */         ClassLoader classLoader;
/*  531 */         return ((classLoader = get()) == null) ? new ClassFileLocator.Resolution.Illegal(param2String) : 
/*      */           
/*  533 */           ClassFileLocator.ForClassLoader.locate(classLoader, param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*  545 */         return this.hashCode;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*  550 */         if (this == param2Object)
/*  551 */           return true; 
/*  552 */         if (param2Object == null || getClass() != param2Object.getClass()) {
/*  553 */           return false;
/*      */         }
/*      */ 
/*      */         
/*  557 */         if ((param2Object = (param2Object = param2Object).get()) != null && get() == param2Object) return true;  return false;
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
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForModule
/*      */     implements ClassFileLocator
/*      */   {
/*  577 */     private static final Object[] NO_ARGUMENT = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final JavaModule module;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ForModule(JavaModule param1JavaModule) {
/*  590 */       this.module = param1JavaModule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should always be wrapped for clarity")
/*      */     public static ClassFileLocator ofBootLayer() {
/*      */       try {
/*  602 */         HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  603 */         Class<?> clazz = Class.forName("java.lang.ModuleLayer");
/*  604 */         Method method = JavaType.MODULE.load().getMethod("getPackages", new Class[0]);
/*  605 */         for (Iterator<Object> iterator = ((Set)clazz.getMethod("modules", new Class[0]).invoke(clazz.getMethod("boot", new Class[0]).invoke(null, new Object[0]), new Object[0])).iterator(); iterator.hasNext(); ) {
/*  606 */           ClassFileLocator classFileLocator = of(JavaModule.of(null = (Iterator<Object>)iterator.next()));
/*  607 */           for (String str : method.invoke(null, NO_ARGUMENT)) {
/*  608 */             hashMap.put(str, classFileLocator);
/*      */           }
/*      */         } 
/*  611 */         return new ClassFileLocator.PackageDiscriminating((Map)hashMap);
/*  612 */       } catch (Exception exception) {
/*  613 */         throw new IllegalStateException("Cannot process boot layer", exception);
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
/*      */     public static ClassFileLocator of(JavaModule param1JavaModule) {
/*  625 */       return param1JavaModule.isNamed() ? new ForModule(param1JavaModule) : 
/*      */         
/*  627 */         ClassFileLocator.ForClassLoader.of(param1JavaModule.getClassLoader());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/*  634 */       return locate(this.module, param1String);
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
/*      */     protected static ClassFileLocator.Resolution locate(JavaModule param1JavaModule, String param1String) {
/*      */       InputStream inputStream;
/*  647 */       if ((inputStream = param1JavaModule.getResourceAsStream(param1String.replace('.', '/') + ".class")) != null) {
/*      */         try {
/*  649 */           return new ClassFileLocator.Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
/*      */         } finally {
/*  651 */           inputStream.close();
/*      */         } 
/*      */       }
/*  654 */       return new ClassFileLocator.Resolution.Illegal(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.module.equals(((ForModule)param1Object).module))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.module.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class WeaklyReferenced
/*      */       extends WeakReference<Object>
/*      */       implements ClassFileLocator
/*      */     {
/*      */       private final int hashCode;
/*      */ 
/*      */ 
/*      */       
/*      */       protected WeaklyReferenced(Object param2Object) {
/*  688 */         super(param2Object);
/*  689 */         this.hashCode = System.identityHashCode(param2Object);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static ClassFileLocator of(JavaModule param2JavaModule) {
/*  700 */         if (param2JavaModule.isNamed()) {
/*  701 */           return (ClassFileLocator)((param2JavaModule.getClassLoader() == null || param2JavaModule.getClassLoader() == ClassLoader.getSystemClassLoader() || param2JavaModule.getClassLoader() == ClassLoader.getSystemClassLoader().getParent()) ? new ClassFileLocator.ForModule(param2JavaModule) : new WeaklyReferenced(param2JavaModule
/*      */               
/*  703 */               .unwrap()));
/*      */         }
/*  705 */         return ClassFileLocator.ForClassLoader.WeaklyReferenced.of(param2JavaModule.getClassLoader());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ClassFileLocator.Resolution locate(String param2String) {
/*      */         Object object;
/*  714 */         return ((object = get()) == null) ? new ClassFileLocator.Resolution.Illegal(param2String) : 
/*      */           
/*  716 */           ClassFileLocator.ForModule.locate(JavaModule.of(object), param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*  730 */         return this.hashCode;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*  737 */         if (this == param2Object)
/*  738 */           return true; 
/*  739 */         if (param2Object == null || getClass() != param2Object.getClass()) {
/*  740 */           return false;
/*      */         }
/*      */ 
/*      */         
/*  744 */         if ((param2Object = (param2Object = param2Object).get()) != null && get() == param2Object) return true;  return false;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForJarFile
/*      */     implements ClassFileLocator
/*      */   {
/*  758 */     private static final List<String> RUNTIME_LOCATIONS = Arrays.asList(new String[] { "lib/rt.jar", "../lib/rt.jar", "../Classes/classes.jar" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final JarFile jarFile;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForJarFile(JarFile param1JarFile) {
/*  771 */       this.jarFile = param1JarFile;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator of(File param1File) {
/*  782 */       return new ForJarFile(new JarFile(param1File));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator ofClassPath() {
/*  793 */       return ofClassPath(System.getProperty("java.class.path"));
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
/*      */     public static ClassFileLocator ofClassPath(String param1String) {
/*  809 */       ArrayList<ClassFileLocator.ForFolder> arrayList = new ArrayList(); String[] arrayOfString; int i; byte b;
/*  810 */       for (i = (arrayOfString = Pattern.compile(System.getProperty("path.separator"), 16).split(param1String)).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*      */         File file;
/*  812 */         if ((file = new File(str)).isDirectory()) {
/*  813 */           arrayList.add(new ClassFileLocator.ForFolder(file));
/*  814 */         } else if (file.isFile()) {
/*  815 */           arrayList.add(of(file));
/*      */         }  b++; }
/*      */       
/*  818 */       return new ClassFileLocator.Compound((List)arrayList);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator ofRuntimeJar() {
/*  828 */       String str = System.getProperty("java.home").replace('\\', '/');
/*  829 */       File file = null;
/*  830 */       for (String str1 : RUNTIME_LOCATIONS) {
/*      */         File file1;
/*  832 */         if ((file1 = new File(str, str1)).isFile()) {
/*  833 */           file = file1;
/*      */           break;
/*      */         } 
/*      */       } 
/*  837 */       if (file == null) {
/*  838 */         throw new IllegalStateException("Runtime jar does not exist in " + str + " for any of " + RUNTIME_LOCATIONS);
/*      */       }
/*  840 */       return of(file);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/*      */       ZipEntry zipEntry;
/*  848 */       if ((zipEntry = this.jarFile.getEntry(param1String.replace('.', '/') + ".class")) == null) {
/*  849 */         return new ClassFileLocator.Resolution.Illegal(param1String);
/*      */       }
/*  851 */       InputStream inputStream = this.jarFile.getInputStream(zipEntry);
/*      */       try {
/*  853 */         return new ClassFileLocator.Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
/*      */       } finally {
/*  855 */         inputStream.close();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/*  864 */       this.jarFile.close();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.jarFile.equals(((ForJarFile)param1Object).jarFile))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.jarFile.hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForModuleFile
/*      */     implements ClassFileLocator
/*      */   {
/*      */     private static final String JMOD_FILE_EXTENSION = ".jmod";
/*  883 */     private static final List<String> BOOT_LOCATIONS = Arrays.asList(new String[] { "jmods", "../jmods", "modules" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final ZipFile zipFile;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForModuleFile(ZipFile param1ZipFile) {
/*  896 */       this.zipFile = param1ZipFile;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator ofBootPath() {
/*  906 */       String str = System.getProperty("java.home").replace('\\', '/');
/*  907 */       File file = null;
/*  908 */       for (String str1 : BOOT_LOCATIONS) {
/*      */         File file1;
/*  910 */         if ((file1 = new File(str, str1)).isDirectory()) {
/*  911 */           file = file1;
/*      */           break;
/*      */         } 
/*      */       } 
/*  915 */       if (file == null) {
/*  916 */         throw new IllegalStateException("Boot modules do not exist in " + str + " for any of " + BOOT_LOCATIONS);
/*      */       }
/*  918 */       return ofBootPath(file);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator ofBootPath(File param1File) {
/*      */       File[] arrayOfFile;
/*  930 */       if ((arrayOfFile = param1File.listFiles()) == null) {
/*  931 */         return ClassFileLocator.NoOp.INSTANCE;
/*      */       }
/*  933 */       ArrayList<ClassFileLocator> arrayList = new ArrayList(arrayOfFile.length); int i; byte b;
/*  934 */       for (i = (arrayOfFile = arrayOfFile).length, b = 0; b < i; b++) {
/*  935 */         File file; if ((file = arrayOfFile[b]).isFile()) {
/*  936 */           arrayList.add(of(file));
/*  937 */         } else if (file.isDirectory()) {
/*  938 */           arrayList.add(new ClassFileLocator.ForFolder(file));
/*      */         } 
/*      */       } 
/*  941 */       return new ClassFileLocator.Compound(arrayList);
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
/*      */     public static ClassFileLocator ofModulePath() {
/*      */       String str;
/*  957 */       return ((str = System.getProperty("jdk.module.path")) == null) ? ClassFileLocator.NoOp.INSTANCE : 
/*      */         
/*  959 */         ofModulePath(str);
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
/*      */     public static ClassFileLocator ofModulePath(String param1String) {
/*  976 */       return ofModulePath(param1String, System.getProperty("user.dir"));
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
/*      */     public static ClassFileLocator ofModulePath(String param1String1, String param1String2) {
/*  993 */       ArrayList<ClassFileLocator.ForFolder> arrayList = new ArrayList(); String[] arrayOfString; int i; byte b;
/*  994 */       for (i = (arrayOfString = Pattern.compile(System.getProperty("path.separator"), 16).split(param1String1)).length, b = 0; b < i; ) { File[] arrayOfFile; String str = arrayOfString[b];
/*      */         File file;
/*  996 */         if ((file = new File(param1String2, str)).isDirectory()) {
/*      */           
/*  998 */           if ((arrayOfFile = file.listFiles()) != null) {
/*  999 */             int j; byte b1; for (j = (arrayOfFile = arrayOfFile).length, b1 = 0; b1 < j; b1++) {
/* 1000 */               File file1; if ((file1 = arrayOfFile[b1]).isDirectory()) {
/* 1001 */                 arrayList.add(new ClassFileLocator.ForFolder(file1));
/* 1002 */               } else if (file1.isFile()) {
/* 1003 */                 arrayList.add(file1.getName().endsWith(".jmod") ? 
/* 1004 */                     of(file1) : 
/* 1005 */                     ClassFileLocator.ForJarFile.of(file1));
/*      */               } 
/*      */             } 
/*      */           } 
/* 1009 */         } else if (arrayOfFile.isFile()) {
/* 1010 */           arrayList.add(arrayOfFile.getName().endsWith(".jmod") ? 
/* 1011 */               of((File)arrayOfFile) : 
/* 1012 */               ClassFileLocator.ForJarFile.of((File)arrayOfFile));
/*      */         }  b++; }
/*      */       
/* 1015 */       return new ClassFileLocator.Compound((List)arrayList);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator of(File param1File) {
/* 1026 */       return new ForModuleFile(new ZipFile(param1File));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/*      */       ZipEntry zipEntry;
/* 1034 */       if ((zipEntry = this.zipFile.getEntry("classes/" + param1String.replace('.', '/') + ".class")) == null) {
/* 1035 */         return new ClassFileLocator.Resolution.Illegal(param1String);
/*      */       }
/* 1037 */       InputStream inputStream = this.zipFile.getInputStream(zipEntry);
/*      */       try {
/* 1039 */         return new ClassFileLocator.Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
/*      */       } finally {
/* 1041 */         inputStream.close();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/* 1050 */       this.zipFile.close();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.zipFile.equals(((ForModuleFile)param1Object).zipFile))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.zipFile.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForFolder
/*      */     implements ClassFileLocator
/*      */   {
/*      */     private final File folder;
/*      */ 
/*      */     
/*      */     public ForFolder(File param1File) {
/* 1073 */       this.folder = param1File;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/*      */       FileInputStream fileInputStream;
/*      */       File file;
/* 1081 */       if ((file = new File(this.folder, param1String.replace('.', File.separatorChar) + ".class")).exists()) {
/* 1082 */         fileInputStream = new FileInputStream(file);
/*      */         try {
/* 1084 */           return new ClassFileLocator.Resolution.Explicit(StreamDrainer.DEFAULT.drain(fileInputStream));
/*      */         } finally {
/* 1086 */           fileInputStream.close();
/*      */         } 
/*      */       } 
/* 1089 */       return new ClassFileLocator.Resolution.Illegal((String)fileInputStream);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.folder.equals(((ForFolder)param1Object).folder))));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.folder.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class ForUrl
/*      */     implements ClassFileLocator
/*      */   {
/*      */     private final ClassLoader classLoader;
/*      */     
/*      */     private static final boolean ACCESS_CONTROLLER;
/*      */ 
/*      */     
/*      */     public ForUrl(URL... param1VarArgs) {
/* 1119 */       this.classLoader = doPrivileged(new ClassLoaderCreationAction(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForUrl(Collection<? extends URL> param1Collection) {
/* 1128 */       this(param1Collection.<URL>toArray(new URL[0]));
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
/* 1140 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/* 1147 */       return ClassFileLocator.ForClassLoader.locate(this.classLoader, param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/* 1154 */       if (this.classLoader instanceof Closeable)
/* 1155 */         ((Closeable)this.classLoader).close(); 
/*      */     } public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.classLoader.equals(((ForUrl)param1Object).classLoader))));
/*      */     } public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.classLoader.hashCode();
/*      */     } static {
/*      */       try {
/*      */         Class.forName("java.security.AccessController", false, (ClassLoader)null);
/*      */         ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
/*      */         return;
/*      */       } catch (ClassNotFoundException classNotFoundException) {
/*      */         ACCESS_CONTROLLER = false;
/*      */         return;
/*      */       } catch (SecurityException securityException) {
/*      */         ACCESS_CONTROLLER = true;
/*      */         return;
/*      */       } 
/*      */     }
/*      */     @Enhance
/*      */     protected static class ClassLoaderCreationAction implements PrivilegedAction<ClassLoader> { private final URL[] url;
/*      */       protected ClassLoaderCreationAction(URL[] param2ArrayOfURL) {
/* 1176 */         this.url = param2ArrayOfURL;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ClassLoader run() {
/* 1183 */         return new URLClassLoader(this.url, ClassLoadingStrategy.BOOTSTRAP_LOADER);
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!Arrays.equals((Object[])this.url, (Object[])((ClassLoaderCreationAction)param2Object).url))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + Arrays.hashCode((Object[])this.url);
/*      */       } }
/*      */   
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class ForInstrumentation
/*      */     implements ClassFileLocator {
/* 1199 */     private static final Dispatcher DISPATCHER = doPrivileged(JavaDispatcher.of(Dispatcher.class)); private final Instrumentation instrumentation; private final ClassLoadingDelegate classLoadingDelegate; private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
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
/*      */     public ForInstrumentation(Instrumentation param1Instrumentation, @MaybeNull ClassLoader param1ClassLoader) {
/* 1218 */       this(param1Instrumentation, ClassLoadingDelegate.Default.of(param1ClassLoader));
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
/* 1230 */       return ACCESS_CONTROLLER ? AccessController.doPrivileged(param1PrivilegedAction) : param1PrivilegedAction.run();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForInstrumentation(Instrumentation param1Instrumentation, ClassLoadingDelegate param1ClassLoadingDelegate) {
/* 1240 */       if (!DISPATCHER.isRetransformClassesSupported(param1Instrumentation)) {
/* 1241 */         throw new IllegalArgumentException(param1Instrumentation + " does not support retransformation");
/*      */       }
/* 1243 */       this.instrumentation = param1Instrumentation;
/* 1244 */       this.classLoadingDelegate = param1ClassLoadingDelegate;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static Instrumentation resolveByteBuddyAgentInstrumentation() {
/*      */       try {
/* 1254 */         Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("net.bytebuddy.agent.Installer");
/* 1255 */         JavaModule javaModule1 = JavaModule.ofType(AgentBuilder.class), javaModule2 = JavaModule.ofType(clazz);
/* 1256 */         if (javaModule1 != null && !javaModule1.canRead(javaModule2)) {
/*      */           Class<?> clazz1;
/* 1258 */           (clazz1 = Class.forName("java.lang.Module")).getMethod("addReads", new Class[] { clazz1 }).invoke(javaModule1.unwrap(), new Object[] { javaModule2.unwrap() });
/*      */         } 
/* 1260 */         return (Instrumentation)clazz.getMethod("getInstrumentation", new Class[0]).invoke(null, new Object[0]);
/* 1261 */       } catch (RuntimeException runtimeException2) {
/* 1262 */         RuntimeException runtimeException1; throw runtimeException1 = null;
/* 1263 */       } catch (Exception exception) {
/* 1264 */         throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", exception);
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
/*      */     public static ClassFileLocator fromInstalledAgent(@MaybeNull ClassLoader param1ClassLoader) {
/* 1276 */       return new ForInstrumentation(resolveByteBuddyAgentInstrumentation(), param1ClassLoader);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ClassFileLocator of(Instrumentation param1Instrumentation, Class<?> param1Class) {
/* 1287 */       return new ForInstrumentation(param1Instrumentation, ClassLoadingDelegate.Explicit.of(param1Class));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/*      */       try {
/* 1295 */         ExtractionClassFileTransformer extractionClassFileTransformer = new ExtractionClassFileTransformer(this.classLoadingDelegate.getClassLoader(), param1String);
/* 1296 */         DISPATCHER.addTransformer(this.instrumentation, extractionClassFileTransformer, true);
/*      */         try {
/* 1298 */           DISPATCHER.retransformClasses(this.instrumentation, new Class[] { this.classLoadingDelegate.locate(param1String) });
/*      */           byte[] arrayOfByte;
/* 1300 */           return (ClassFileLocator.Resolution)(((arrayOfByte = extractionClassFileTransformer.getBinaryRepresentation()) == null) ? new ClassFileLocator.Resolution.Illegal(param1String) : new ClassFileLocator.Resolution.Explicit(arrayOfByte));
/*      */         }
/*      */         finally {
/*      */           
/* 1304 */           this.instrumentation.removeTransformer(extractionClassFileTransformer);
/*      */         } 
/* 1306 */       } catch (RuntimeException runtimeException2) {
/* 1307 */         RuntimeException runtimeException1; throw runtimeException1 = null;
/* 1308 */       } catch (Exception exception) {
/* 1309 */         return new ClassFileLocator.Resolution.Illegal(param1String);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!this.instrumentation.equals(((ForInstrumentation)param1Object).instrumentation) ? false : (!!this.classLoadingDelegate.equals(((ForInstrumentation)param1Object).classLoadingDelegate)))));
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
/*      */     public int hashCode() {
/*      */       return (getClass().hashCode() * 31 + this.instrumentation.hashCode()) * 31 + this.classLoadingDelegate.hashCode();
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
/*      */     @Enhance
/*      */     public static class Default
/*      */       implements ClassLoadingDelegate
/*      */     {
/* 1384 */       private static final ClassLoader BOOT_LOADER_PROXY = (ClassLoader)ClassFileLocator.ForInstrumentation.a(BootLoaderProxyCreationAction.INSTANCE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected final ClassLoader classLoader;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected Default(ClassLoader param2ClassLoader) {
/* 1397 */         this.classLoader = param2ClassLoader;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static ClassFileLocator.ForInstrumentation.ClassLoadingDelegate of(@MaybeNull ClassLoader param2ClassLoader) {
/* 1407 */         return ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.isDelegating(param2ClassLoader) ? new ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader(param2ClassLoader) : new Default((param2ClassLoader == null) ? BOOT_LOADER_PROXY : param2ClassLoader);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Class<?> locate(String param2String) {
/* 1416 */         return this.classLoader.loadClass(param2String);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       public ClassLoader getClassLoader() {
/* 1424 */         return (this.classLoader == BOOT_LOADER_PROXY) ? ClassLoadingStrategy.BOOTSTRAP_LOADER : this.classLoader;
/*      */       }
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!!this.classLoader.equals(((Default)param2Object).classLoader))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return getClass().hashCode() * 31 + this.classLoader.hashCode();
/*      */       }
/*      */       
/*      */       protected enum BootLoaderProxyCreationAction
/*      */         implements PrivilegedAction<ClassLoader> {
/* 1437 */         INSTANCE;
/*      */ 
/*      */ 
/*      */         
/*      */         public final ClassLoader run()
/*      */         {
/* 1443 */           return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER); } } } public static interface ClassLoadingDelegate { Class<?> locate(String param2String); @MaybeNull ClassLoader getClassLoader(); @Enhance public static class Default implements ClassLoadingDelegate { private static final ClassLoader BOOT_LOADER_PROXY = (ClassLoader)ClassFileLocator.ForInstrumentation.a(BootLoaderProxyCreationAction.INSTANCE); protected final ClassLoader classLoader; protected Default(ClassLoader param3ClassLoader) { this.classLoader = param3ClassLoader; } public static ClassFileLocator.ForInstrumentation.ClassLoadingDelegate of(@MaybeNull ClassLoader param3ClassLoader) { return ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.isDelegating(param3ClassLoader) ? new ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader(param3ClassLoader) : new Default((param3ClassLoader == null) ? BOOT_LOADER_PROXY : param3ClassLoader); } public Class<?> locate(String param3String) { return this.classLoader.loadClass(param3String); } @MaybeNull public ClassLoader getClassLoader() { return (this.classLoader == BOOT_LOADER_PROXY) ? ClassLoadingStrategy.BOOTSTRAP_LOADER : this.classLoader; } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!!this.classLoader.equals(((Default)param3Object).classLoader)))); } public int hashCode() { return getClass().hashCode() * 31 + this.classLoader.hashCode(); } protected enum BootLoaderProxyCreationAction implements PrivilegedAction<ClassLoader> { public final ClassLoader run() { return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           INSTANCE; }
/*      */          }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static class ForDelegatingClassLoader
/*      */         extends Default
/*      */       {
/*      */         private static final String DELEGATING_CLASS_LOADER_NAME = "sun.reflect.DelegatingClassLoader";
/*      */ 
/*      */ 
/*      */         
/*      */         private static final int ONLY = 0;
/*      */ 
/*      */ 
/*      */         
/* 1467 */         private static final Dispatcher.Initializable DISPATCHER = doPrivileged(Dispatcher.CreationAction.INSTANCE); private static final boolean ACCESS_CONTROLLER; static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*      */            }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected ForDelegatingClassLoader(ClassLoader param3ClassLoader) {
/* 1475 */           super(param3ClassLoader);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @Enhance
/*      */         private static <T> T doPrivileged(PrivilegedAction<T> param3PrivilegedAction) {
/* 1487 */           return ACCESS_CONTROLLER ? AccessController.doPrivileged(param3PrivilegedAction) : param3PrivilegedAction.run();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected static boolean isDelegating(@MaybeNull ClassLoader param3ClassLoader) {
/* 1497 */           return (param3ClassLoader != null && param3ClassLoader.getClass().getName().equals("sun.reflect.DelegatingClassLoader"));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> locate(String param3String) {
/*      */           Vector<Class<?>> vector;
/*      */           try {
/* 1506 */             vector = DISPATCHER.initialize().extract(this.classLoader);
/* 1507 */           } catch (RuntimeException runtimeException) {
/* 1508 */             return super.locate(param3String);
/*      */           } 
/* 1510 */           if (vector.size() != 1) {
/* 1511 */             return super.locate(param3String);
/*      */           }
/*      */           Class<?> clazz;
/* 1514 */           return TypeDescription.ForLoadedType.getName(clazz = vector.get(0)).equals(param3String) ? clazz : super
/*      */             
/* 1516 */             .locate(param3String);
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
/*      */         public enum CreationAction
/*      */           implements PrivilegedAction<Dispatcher.Initializable>
/*      */         {
/* 1553 */           INSTANCE;
/*      */ 
/*      */ 
/*      */           
/*      */           public final ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Initializable run()
/*      */           {
/*      */             
/* 1560 */             try { return new ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Resolved(ClassLoader.class.getDeclaredField("classes")); }
/* 1561 */             catch (Exception exception)
/* 1562 */             { return new ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Unresolved(exception.getMessage()); }  } } public static interface Initializable { ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher initialize(); } protected static interface Dispatcher { Vector<Class<?>> extract(ClassLoader param4ClassLoader); public static interface Initializable { ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher initialize(); } public enum CreationAction implements PrivilegedAction<Initializable> { INSTANCE; public final ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Initializable run() { try { return new ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Resolved(ClassLoader.class.getDeclaredField("classes")); } catch (Exception exception) { return new ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Unresolved(exception.getMessage()); }
/*      */                }
/*      */              }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           @Enhance
/*      */           public static class Resolved
/*      */             implements PrivilegedAction<Dispatcher>, Dispatcher, Initializable
/*      */           {
/*      */             private final Field field;
/*      */ 
/*      */ 
/*      */             
/*      */             private static final boolean ACCESS_CONTROLLER;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Resolved(Field param5Field) {
/* 1584 */               this.field = param5Field;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             @Enhance
/*      */             private static <T> T doPrivileged(PrivilegedAction<T> param5PrivilegedAction) {
/* 1596 */               return ACCESS_CONTROLLER ? AccessController.doPrivileged(param5PrivilegedAction) : param5PrivilegedAction.run();
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher initialize() {
/* 1603 */               return doPrivileged(this);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public Vector<Class<?>> extract(ClassLoader param5ClassLoader) {
/*      */               try {
/* 1612 */                 return (Vector<Class<?>>)this.field.get(param5ClassLoader);
/* 1613 */               } catch (IllegalAccessException illegalAccessException) {
/* 1614 */                 throw new IllegalStateException("Cannot access field", illegalAccessException);
/*      */               } 
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher run() {
/* 1622 */               this.field.setAccessible(true);
/* 1623 */               return this;
/*      */             } public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.field.equals(((Resolved)param5Object).field))));
/*      */             } public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.field.hashCode();
/*      */             } static {
/*      */               try {
/*      */                 Class.forName("java.security.AccessController", false, (ClassLoader)null);
/*      */                 ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
/*      */                 return;
/*      */               } catch (ClassNotFoundException classNotFoundException) {
/*      */                 ACCESS_CONTROLLER = false;
/*      */                 return;
/*      */               } catch (SecurityException securityException) {
/*      */                 ACCESS_CONTROLLER = true;
/*      */                 return;
/*      */               } 
/*      */             } }
/*      */           @Enhance
/*      */           public static class Unresolved implements Initializable { private final String message;
/*      */             public Unresolved(String param5String) {
/* 1644 */               this.message = param5String;
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher initialize() {
/* 1651 */               throw new UnsupportedOperationException("Could not locate classes vector: " + this.message);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean equals(@MaybeNull Object param5Object) {
/*      */               return (this == param5Object) ? true : ((param5Object == null) ? false : ((getClass() != param5Object.getClass()) ? false : (!!this.message.equals(((Unresolved)param5Object).message))));
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public int hashCode() {
/*      */               return getClass().hashCode() * 31 + this.message.hashCode();
/*      */             } }
/*      */            }
/*      */       
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       @Enhance
/*      */       public static class Explicit
/*      */         implements ClassLoadingDelegate
/*      */       {
/*      */         private final ClassFileLocator.ForInstrumentation.ClassLoadingDelegate fallbackDelegate;
/*      */ 
/*      */         
/*      */         private final Map<String, Class<?>> types;
/*      */ 
/*      */ 
/*      */         
/*      */         public Explicit(@MaybeNull ClassLoader param3ClassLoader, Collection<? extends Class<?>> param3Collection) {
/* 1683 */           this(ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.Default.of(param3ClassLoader), param3Collection);
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
/*      */         public Explicit(ClassFileLocator.ForInstrumentation.ClassLoadingDelegate param3ClassLoadingDelegate, Collection<? extends Class<?>> param3Collection) {
/* 1695 */           this.fallbackDelegate = param3ClassLoadingDelegate;
/* 1696 */           this.types = new HashMap<String, Class<?>>();
/* 1697 */           for (Class<?> clazz : param3Collection) {
/* 1698 */             this.types.put(TypeDescription.ForLoadedType.getName(clazz), clazz);
/*      */           }
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public static ClassFileLocator.ForInstrumentation.ClassLoadingDelegate of(Class<?> param3Class) {
/* 1709 */           return new Explicit(param3Class.getClassLoader(), Collections.singleton(param3Class));
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public Class<?> locate(String param3String) {
/*      */           Class<?> clazz;
/* 1717 */           if ((clazz = this.types.get(param3String)) == null)
/* 1718 */             return this.fallbackDelegate.locate(param3String);  return clazz;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         @MaybeNull
/*      */         public ClassLoader getClassLoader()
/*      */         {
/* 1727 */           return this.fallbackDelegate.getClassLoader(); } public boolean equals(@MaybeNull Object param3Object) { return (this == param3Object) ? true : ((param3Object == null) ? false : ((getClass() != param3Object.getClass()) ? false : (!this.fallbackDelegate.equals(((Explicit)param3Object).fallbackDelegate) ? false : (!!this.types.equals(((Explicit)param3Object).types))))); } public int hashCode() { return (getClass().hashCode() * 31 + this.fallbackDelegate.hashCode()) * 31 + this.types.hashCode(); } } } @Enhance public static class Explicit implements ClassLoadingDelegate { private final ClassFileLocator.ForInstrumentation.ClassLoadingDelegate fallbackDelegate; private final Map<String, Class<?>> types; public Explicit(@MaybeNull ClassLoader param2ClassLoader, Collection<? extends Class<?>> param2Collection) { this(ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.Default.of(param2ClassLoader), param2Collection); } public Explicit(ClassFileLocator.ForInstrumentation.ClassLoadingDelegate param2ClassLoadingDelegate, Collection<? extends Class<?>> param2Collection) { this.fallbackDelegate = param2ClassLoadingDelegate; this.types = new HashMap<String, Class<?>>(); for (Class<?> clazz : param2Collection) this.types.put(TypeDescription.ForLoadedType.getName(clazz), clazz);  } public static ClassFileLocator.ForInstrumentation.ClassLoadingDelegate of(Class<?> param2Class) { return new Explicit(param2Class.getClassLoader(), Collections.singleton(param2Class)); } public Class<?> locate(String param2String) { Class<?> clazz; if ((clazz = this.types.get(param2String)) == null) return this.fallbackDelegate.locate(param2String);  return clazz; } @MaybeNull public ClassLoader getClassLoader() { return this.fallbackDelegate.getClassLoader(); }
/*      */ 
/*      */       
/*      */       public boolean equals(@MaybeNull Object param2Object) {
/*      */         return (this == param2Object) ? true : ((param2Object == null) ? false : ((getClass() != param2Object.getClass()) ? false : (!this.fallbackDelegate.equals(((Explicit)param2Object).fallbackDelegate) ? false : (!!this.types.equals(((Explicit)param2Object).types)))));
/*      */       }
/*      */       
/*      */       public int hashCode() {
/*      */         return (getClass().hashCode() * 31 + this.fallbackDelegate.hashCode()) * 31 + this.types.hashCode();
/*      */       } }
/*      */ 
/*      */     
/*      */     protected static class ExtractionClassFileTransformer implements ClassFileTransformer {
/*      */       @AlwaysNull
/* 1741 */       private static final byte[] DO_NOT_TRANSFORM = null;
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
/*      */       private final String typeName;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       @SuppressFBWarnings(value = {"VO_VOLATILE_REFERENCE_TO_ARRAY"}, justification = "The array is not to be modified by contract")
/*      */       private volatile byte[] binaryRepresentation;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected ExtractionClassFileTransformer(@MaybeNull ClassLoader param2ClassLoader, String param2String) {
/* 1768 */         this.classLoader = param2ClassLoader;
/* 1769 */         this.typeName = param2String;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       @SuppressFBWarnings(value = {"EI_EXPOSE_REP", "EI_EXPOSE_REP2"}, justification = "The array is not modified by class contract.")
/*      */       public byte[] transform(@MaybeNull ClassLoader param2ClassLoader, @MaybeNull String param2String, @MaybeNull Class<?> param2Class, ProtectionDomain param2ProtectionDomain, byte[] param2ArrayOfbyte) {
/* 1782 */         if (param2String != null && ElementMatchers.isChildOf(this.classLoader).matches(param2ClassLoader) && this.typeName.equals(param2String.replace('/', '.'))) {
/* 1783 */           this.binaryRepresentation = (byte[])param2ArrayOfbyte.clone();
/*      */         }
/* 1785 */         return DO_NOT_TRANSFORM;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       @MaybeNull
/*      */       @SuppressFBWarnings(value = {"EI_EXPOSE_REP"}, justification = "The array is not to be modified by contract")
/*      */       protected byte[] getBinaryRepresentation() {
/* 1797 */         return this.binaryRepresentation;
/*      */       }
/*      */     }
/*      */     
/*      */     @Proxied("java.lang.instrument.Instrumentation")
/*      */     protected static interface Dispatcher {
/*      */       @Proxied("isRetransformClassesSupported")
/*      */       boolean isRetransformClassesSupported(Instrumentation param2Instrumentation);
/*      */       
/*      */       @Proxied("addTransformer")
/*      */       void addTransformer(Instrumentation param2Instrumentation, ClassFileTransformer param2ClassFileTransformer, boolean param2Boolean);
/*      */       
/*      */       @Proxied("retransformClasses")
/*      */       void retransformClasses(Instrumentation param2Instrumentation, Class<?>[] param2ArrayOfClass);
/*      */     }
/*      */   }
/*      */   
/*      */   @Enhance
/*      */   public static class PackageDiscriminating implements ClassFileLocator {
/*      */     private final Map<String, ClassFileLocator> classFileLocators;
/*      */     
/*      */     public PackageDiscriminating(Map<String, ClassFileLocator> param1Map) {
/* 1819 */       this.classFileLocators = param1Map;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/* 1826 */       int i = param1String.lastIndexOf('.');
/*      */       
/*      */       ClassFileLocator classFileLocator;
/*      */       
/* 1830 */       return ((classFileLocator = this.classFileLocators.get((i == -1) ? "" : param1String.substring(0, i))) == null) ? new ClassFileLocator.Resolution.Illegal(param1String) : classFileLocator
/*      */         
/* 1832 */         .locate(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/* 1839 */       for (Iterator<ClassFileLocator> iterator = this.classFileLocators.values().iterator(); iterator.hasNext();) {
/* 1840 */         (classFileLocator = iterator.next()).close();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.classFileLocators.equals(((PackageDiscriminating)param1Object).classFileLocators))));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.classFileLocators.hashCode();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Enhance
/*      */   public static class Compound
/*      */     implements Closeable, ClassFileLocator
/*      */   {
/*      */     public Compound(ClassFileLocator... param1VarArgs) {
/* 1866 */       this(Arrays.asList(param1VarArgs));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1876 */     private final List<ClassFileLocator> classFileLocators = new ArrayList<ClassFileLocator>(); public Compound(List<? extends ClassFileLocator> param1List) {
/* 1877 */       for (Iterator<? extends ClassFileLocator> iterator = param1List.iterator(); iterator.hasNext(); ) {
/* 1878 */         ClassFileLocator classFileLocator; if (classFileLocator = iterator.next() instanceof Compound) {
/* 1879 */           this.classFileLocators.addAll(((Compound)classFileLocator).classFileLocators); continue;
/* 1880 */         }  if (!(classFileLocator instanceof ClassFileLocator.NoOp)) {
/* 1881 */           this.classFileLocators.add(classFileLocator);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ClassFileLocator.Resolution locate(String param1String) {
/* 1890 */       for (Iterator<ClassFileLocator> iterator = this.classFileLocators.iterator(); iterator.hasNext();) {
/*      */         
/* 1892 */         if ((resolution = (classFileLocator = iterator.next()).locate(param1String)).isResolved()) {
/* 1893 */           return resolution;
/*      */         }
/*      */       } 
/* 1896 */       return new ClassFileLocator.Resolution.Illegal(param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/* 1903 */       for (Iterator<ClassFileLocator> iterator = this.classFileLocators.iterator(); iterator.hasNext();)
/* 1904 */         (classFileLocator = iterator.next()).close(); 
/*      */     }
/*      */     
/*      */     public boolean equals(@MaybeNull Object param1Object) {
/*      */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!!this.classFileLocators.equals(((Compound)param1Object).classFileLocators))));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/*      */       return getClass().hashCode() * 31 + this.classFileLocators.hashCode();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\ClassFileLocator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */