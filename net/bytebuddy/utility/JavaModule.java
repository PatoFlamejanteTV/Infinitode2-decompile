/*     */ package net.bytebuddy.utility;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import net.bytebuddy.ClassFileVersion;
/*     */ import net.bytebuddy.build.AccessControllerPlugin.Enhance;
/*     */ import net.bytebuddy.description.NamedElement;
/*     */ import net.bytebuddy.description.annotation.AnnotationList;
/*     */ import net.bytebuddy.description.annotation.AnnotationSource;
/*     */ import net.bytebuddy.description.type.PackageDescription;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults;
/*     */ import net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;
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
/*     */ public class JavaModule
/*     */   implements NamedElement.WithOptionalName, AnnotationSource
/*     */ {
/*     */   @AlwaysNull
/*  42 */   public static final JavaModule UNSUPPORTED = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   protected static final Resolver RESOLVER = doPrivileged(JavaDispatcher.of(Resolver.class));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   protected static final Module MODULE = doPrivileged(JavaDispatcher.of(Module.class)); static { try { Class.forName("java.security.AccessController", false, (ClassLoader)null); ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true")); } catch (ClassNotFoundException classNotFoundException) { ACCESS_CONTROLLER = false; } catch (SecurityException securityException) { ACCESS_CONTROLLER = true; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final AnnotatedElement module;
/*     */ 
/*     */   
/*     */   private static final boolean ACCESS_CONTROLLER;
/*     */ 
/*     */   
/*     */   protected JavaModule(AnnotatedElement paramAnnotatedElement) {
/*  65 */     this.module = paramAnnotatedElement;
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
/*  77 */     return ACCESS_CONTROLLER ? AccessController.doPrivileged(paramPrivilegedAction) : paramPrivilegedAction.run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   public static JavaModule ofType(Class<?> paramClass) {
/*     */     Object object;
/*  89 */     return ((object = RESOLVER.getModule(paramClass)) == null) ? UNSUPPORTED : new JavaModule((AnnotatedElement)object);
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
/*     */   public static JavaModule of(Object paramObject) {
/* 102 */     if (!MODULE.isInstance(paramObject)) {
/* 103 */       throw new IllegalArgumentException("Not a Java module: " + paramObject);
/*     */     }
/* 105 */     return new JavaModule((AnnotatedElement)paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSupported() {
/* 114 */     return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNamed() {
/* 121 */     return MODULE.isNamed(this.module);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActualName() {
/* 128 */     return MODULE.getName(this.module);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   public InputStream getResourceAsStream(String paramString) {
/* 140 */     return MODULE.getResourceAsStream(this.module, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @MaybeNull
/*     */   public ClassLoader getClassLoader() {
/* 150 */     return MODULE.getClassLoader(this.module);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object unwrap() {
/* 159 */     return this.module;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canRead(JavaModule paramJavaModule) {
/* 169 */     return MODULE.canRead(this.module, paramJavaModule.unwrap());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExported(@MaybeNull PackageDescription paramPackageDescription, JavaModule paramJavaModule) {
/* 180 */     if (paramPackageDescription == null || paramPackageDescription
/* 181 */       .isDefault() || MODULE
/* 182 */       .isExported(this.module, paramPackageDescription.getName(), paramJavaModule.unwrap())) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpened(@MaybeNull PackageDescription paramPackageDescription, JavaModule paramJavaModule) {
/* 193 */     if (paramPackageDescription == null || paramPackageDescription
/* 194 */       .isDefault() || MODULE
/* 195 */       .isOpen(this.module, paramPackageDescription.getName(), paramJavaModule.unwrap())) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnnotationList getDeclaredAnnotations() {
/* 202 */     return (AnnotationList)new AnnotationList.ForLoadedAnnotations(this.module.getDeclaredAnnotations());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 207 */     return this.module.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/* 212 */     if (this == paramObject)
/* 213 */       return true; 
/* 214 */     if (!(paramObject instanceof JavaModule)) {
/* 215 */       return false;
/*     */     }
/* 217 */     paramObject = paramObject;
/* 218 */     return this.module.equals(((JavaModule)paramObject).module);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 223 */     return this.module.toString();
/*     */   }
/*     */   
/*     */   @Proxied("java.lang.Module")
/*     */   protected static interface Module {
/*     */     @Instance
/*     */     @Proxied("isInstance")
/*     */     boolean isInstance(Object param1Object);
/*     */     
/*     */     @Proxied("isNamed")
/*     */     boolean isNamed(Object param1Object);
/*     */     
/*     */     @Proxied("getName")
/*     */     String getName(Object param1Object);
/*     */     
/*     */     @MaybeNull
/*     */     @Proxied("getClassLoader")
/*     */     ClassLoader getClassLoader(Object param1Object);
/*     */     
/*     */     @MaybeNull
/*     */     @Proxied("getResourceAsStream")
/*     */     InputStream getResourceAsStream(Object param1Object, String param1String);
/*     */     
/*     */     @Proxied("isExported")
/*     */     boolean isExported(Object param1Object1, String param1String, @Proxied("java.lang.Module") Object param1Object2);
/*     */     
/*     */     @Proxied("isOpen")
/*     */     boolean isOpen(Object param1Object1, String param1String, @Proxied("java.lang.Module") Object param1Object2);
/*     */     
/*     */     @Proxied("canRead")
/*     */     boolean canRead(Object param1Object1, @Proxied("java.lang.Module") Object param1Object2);
/*     */   }
/*     */   
/*     */   @Proxied("java.lang.Class")
/*     */   protected static interface Resolver {
/*     */     @MaybeNull
/*     */     @Defaults
/*     */     @Proxied("getModule")
/*     */     Object getModule(Class<?> param1Class);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\JavaModule.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */