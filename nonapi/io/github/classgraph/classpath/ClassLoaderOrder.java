/*     */ package nonapi.io.github.classgraph.classpath;
/*     */ 
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
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
/*     */ public class ClassLoaderOrder
/*     */ {
/*  50 */   private final List<Map.Entry<ClassLoader, ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry>> classLoaderOrder = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectionUtils reflectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   private final Set<ClassLoader> added = Collections.newSetFromMap(new IdentityHashMap<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   private final Set<ClassLoader> delegatedTo = Collections.newSetFromMap(new IdentityHashMap<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   private final Set<ClassLoader> allParentClassLoaders = Collections.newSetFromMap(new IdentityHashMap<>());
/*     */ 
/*     */   
/*  78 */   private final Map<ClassLoader, ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry> classLoaderToClassLoaderHandlerRegistryEntry = new IdentityHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassLoaderOrder(ReflectionUtils paramReflectionUtils) {
/*  84 */     this.reflectionUtils = paramReflectionUtils;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Map.Entry<ClassLoader, ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry>> getClassLoaderOrder() {
/*  94 */     return this.classLoaderOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<ClassLoader> getAllParentClassLoaders() {
/* 103 */     return this.allParentClassLoaders;
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
/*     */   private ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry getRegistryEntry(ClassLoader paramClassLoader, LogNode paramLogNode) {
/*     */     ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry classLoaderHandlerRegistryEntry;
/* 117 */     if ((classLoaderHandlerRegistryEntry = this.classLoaderToClassLoaderHandlerRegistryEntry.get(paramClassLoader)) == null) {
/*     */       
/* 119 */       Class<?> clazz = paramClassLoader.getClass();
/* 120 */       while (clazz != Object.class && clazz != null) {
/*     */ 
/*     */         
/* 123 */         for (Iterator<ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry> iterator = ClassLoaderHandlerRegistry.CLASS_LOADER_HANDLERS.iterator(); iterator.hasNext();) {
/* 124 */           if ((classLoaderHandlerRegistryEntry1 = iterator.next()).canHandle(clazz, paramLogNode)) {
/*     */             
/* 126 */             classLoaderHandlerRegistryEntry = classLoaderHandlerRegistryEntry1;
/*     */             break;
/*     */           } 
/*     */         } 
/* 130 */         if (classLoaderHandlerRegistryEntry == null) {
/*     */           clazz = clazz.getSuperclass();
/*     */         }
/*     */       } 
/*     */       
/* 135 */       if (classLoaderHandlerRegistryEntry == null)
/*     */       {
/* 137 */         classLoaderHandlerRegistryEntry = ClassLoaderHandlerRegistry.FALLBACK_HANDLER;
/*     */       }
/* 139 */       this.classLoaderToClassLoaderHandlerRegistryEntry.put(paramClassLoader, classLoaderHandlerRegistryEntry);
/*     */     } 
/* 141 */     return classLoaderHandlerRegistryEntry;
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
/*     */   public void add(ClassLoader paramClassLoader, LogNode paramLogNode) {
/* 153 */     if (paramClassLoader == null)
/*     */       return; 
/*     */     ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry classLoaderHandlerRegistryEntry;
/* 156 */     if (this.added.add(paramClassLoader) && (
/*     */       
/* 158 */       classLoaderHandlerRegistryEntry = getRegistryEntry(paramClassLoader, paramLogNode)) != null) {
/* 159 */       this.classLoaderOrder.add(new AbstractMap.SimpleEntry<>(paramClassLoader, classLoaderHandlerRegistryEntry));
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
/*     */   public void delegateTo(ClassLoader paramClassLoader, boolean paramBoolean, LogNode paramLogNode) {
/* 175 */     if (paramClassLoader == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 181 */     if (paramBoolean) {
/* 182 */       this.allParentClassLoaders.add(paramClassLoader);
/*     */     }
/*     */     
/* 185 */     if (this.delegatedTo.add(paramClassLoader)) {
/*     */       ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry classLoaderHandlerRegistryEntry;
/*     */ 
/*     */       
/* 189 */       (classLoaderHandlerRegistryEntry = getRegistryEntry(paramClassLoader, paramLogNode)).findClassLoaderOrder(paramClassLoader, this, paramLogNode);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classpath\ClassLoaderOrder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */