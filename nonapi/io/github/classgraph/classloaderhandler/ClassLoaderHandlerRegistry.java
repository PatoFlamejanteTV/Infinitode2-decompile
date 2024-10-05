/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import nonapi.io.github.classgraph.classpath.ClassLoaderOrder;
/*     */ import nonapi.io.github.classgraph.classpath.ClasspathOrder;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassLoaderHandlerRegistry
/*     */ {
/*  48 */   public static final List<ClassLoaderHandlerRegistryEntry> CLASS_LOADER_HANDLERS = Collections.unmodifiableList(Arrays.asList(new ClassLoaderHandlerRegistryEntry[] { 
/*     */           new ClassLoaderHandlerRegistryEntry(AntClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(EquinoxClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(EquinoxContextFinderClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(FelixClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(JBossClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(WeblogicClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(WebsphereLibertyClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(WebsphereTraditionalClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(OSGiDefaultClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(SpringBootRestartClassLoaderHandler.class), 
/*     */           new ClassLoaderHandlerRegistryEntry(TomcatWebappClassLoaderBaseHandler.class), new ClassLoaderHandlerRegistryEntry(CxfContainerClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(PlexusClassWorldsClassRealmClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(QuarkusClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(UnoOneJarClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(ParentLastDelegationOrderTestClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(JPMSClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(URLClassLoaderHandler.class), new ClassLoaderHandlerRegistryEntry(ClassGraphClassLoaderHandler.class) }));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   public static final ClassLoaderHandlerRegistryEntry FALLBACK_HANDLER = new ClassLoaderHandlerRegistryEntry(FallbackClassLoaderHandler.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static final String[] AUTOMATIC_LIB_DIR_PREFIXES = new String[] { "BOOT-INF/lib/", "WEB-INF/lib/", "WEB-INF/lib-provided/", "META-INF/lib/", "lib/", "lib/ext/", "main/" };
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
/* 112 */   public static final String[] AUTOMATIC_PACKAGE_ROOT_PREFIXES = new String[] { "classes/", "test-classes/", "BOOT-INF/classes/", "WEB-INF/classes/" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ClassLoaderHandlerRegistryEntry
/*     */   {
/*     */     private final Method canHandleMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Method findClassLoaderOrderMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Method findClasspathOrderMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Class<? extends ClassLoaderHandler> classLoaderHandlerClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ClassLoaderHandlerRegistryEntry(Class<? extends ClassLoaderHandler> param1Class) {
/* 157 */       this.classLoaderHandlerClass = param1Class;
/*     */       try {
/* 159 */         this.canHandleMethod = param1Class.getDeclaredMethod("canHandle", new Class[] { Class.class, LogNode.class });
/*     */       }
/* 161 */       catch (Exception exception) {
/* 162 */         throw new RuntimeException("Could not find canHandle method for " + param1Class
/* 163 */             .getName(), exception);
/*     */       } 
/*     */       try {
/* 166 */         this.findClassLoaderOrderMethod = param1Class.getDeclaredMethod("findClassLoaderOrder", new Class[] { ClassLoader.class, ClassLoaderOrder.class, LogNode.class });
/*     */       }
/* 168 */       catch (Exception exception) {
/* 169 */         throw new RuntimeException("Could not find findClassLoaderOrder method for " + param1Class
/* 170 */             .getName(), exception);
/*     */       } 
/*     */       try {
/* 173 */         this.findClasspathOrderMethod = param1Class.getDeclaredMethod("findClasspathOrder", new Class[] { ClassLoader.class, ClasspathOrder.class, ScanSpec.class, LogNode.class });
/*     */         return;
/* 175 */       } catch (Exception exception) {
/* 176 */         throw new RuntimeException("Could not find findClasspathOrder method for " + param1Class
/* 177 */             .getName(), exception);
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
/*     */     public boolean canHandle(Class<?> param1Class, LogNode param1LogNode) {
/*     */       try {
/* 192 */         return ((Boolean)this.canHandleMethod.invoke(null, new Object[] { param1Class, param1LogNode })).booleanValue();
/* 193 */       } catch (Throwable throwable) {
/* 194 */         throw new RuntimeException("Exception while calling canHandle for " + this.classLoaderHandlerClass
/* 195 */             .getName(), throwable);
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
/*     */     
/*     */     public void findClassLoaderOrder(ClassLoader param1ClassLoader, ClassLoaderOrder param1ClassLoaderOrder, LogNode param1LogNode) {
/*     */       try {
/* 213 */         this.findClassLoaderOrderMethod.invoke(null, new Object[] { param1ClassLoader, param1ClassLoaderOrder, param1LogNode }); return;
/* 214 */       } catch (Throwable throwable) {
/* 215 */         throw new RuntimeException("Exception while calling findClassLoaderOrder for " + this.classLoaderHandlerClass
/* 216 */             .getName(), throwable);
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
/*     */ 
/*     */ 
/*     */     
/*     */     public void findClasspathOrder(ClassLoader param1ClassLoader, ClasspathOrder param1ClasspathOrder, ScanSpec param1ScanSpec, LogNode param1LogNode) {
/*     */       try {
/* 236 */         this.findClasspathOrderMethod.invoke(null, new Object[] { param1ClassLoader, param1ClasspathOrder, param1ScanSpec, param1LogNode }); return;
/* 237 */       } catch (Throwable throwable) {
/* 238 */         throw new RuntimeException("Exception while calling findClassLoaderOrder for " + this.classLoaderHandlerClass
/* 239 */             .getName(), throwable);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\ClassLoaderHandlerRegistry.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */