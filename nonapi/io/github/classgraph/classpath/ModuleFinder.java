/*     */ package nonapi.io.github.classgraph.classpath;
/*     */ 
/*     */ import io.github.classgraph.ModuleRef;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Deque;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModuleFinder
/*     */ {
/*     */   private List<ModuleRef> systemModuleRefs;
/*     */   private List<ModuleRef> nonSystemModuleRefs;
/*     */   private boolean forceScanJavaClassPath;
/*     */   private final ReflectionUtils reflectionUtils;
/*     */   
/*     */   public List<ModuleRef> getSystemModuleRefs() {
/*  68 */     return this.systemModuleRefs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ModuleRef> getNonSystemModuleRefs() {
/*  78 */     return this.nonSystemModuleRefs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean forceScanJavaClassPath() {
/*  87 */     return this.forceScanJavaClassPath;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void findLayerOrder(Object paramObject, Set<Object> paramSet1, Set<Object> paramSet2, Deque<Object> paramDeque) {
/* 113 */     if (paramSet1.add(paramObject)) {
/*     */       List<?> list;
/*     */ 
/*     */       
/* 117 */       if ((list = (List)this.reflectionUtils.invokeMethod(true, paramObject, "parents")) != null) {
/* 118 */         paramSet2.addAll(list);
/* 119 */         for (Object object : list) {
/* 120 */           findLayerOrder(object, paramSet1, paramSet2, paramDeque);
/*     */         }
/*     */       } 
/* 123 */       paramDeque.push(paramObject);
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
/*     */   private List<ModuleRef> findModuleRefs(LinkedHashSet<Object> paramLinkedHashSet, ScanSpec paramScanSpec, LogNode paramLogNode) {
/*     */     ArrayList arrayList;
/* 140 */     if (paramLinkedHashSet.isEmpty()) {
/* 141 */       return Collections.emptyList();
/*     */     }
/*     */ 
/*     */     
/* 145 */     arrayDeque = new ArrayDeque();
/* 146 */     HashSet<Object> hashSet1 = new HashSet(); Iterator<Object> iterator;
/* 147 */     for (iterator = paramLinkedHashSet.iterator(); iterator.hasNext();) {
/* 148 */       if ((object = iterator.next()) != null) {
/* 149 */         findLayerOrder(object, new HashSet(), hashSet1, arrayDeque);
/*     */       }
/*     */     } 
/* 152 */     if (paramScanSpec.addedModuleLayers != null) {
/* 153 */       for (iterator = paramScanSpec.addedModuleLayers.iterator(); iterator.hasNext();) {
/* 154 */         if ((object = iterator.next()) != null) {
/* 155 */           findLayerOrder(object, new HashSet(), hashSet1, arrayDeque);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 162 */     if (paramScanSpec.ignoreParentModuleLayers) {
/* 163 */       arrayList = new ArrayList();
/* 164 */       for (ScanSpec paramScanSpec : arrayDeque) {
/* 165 */         if (!hashSet1.contains(paramScanSpec)) {
/* 166 */           arrayList.add(paramScanSpec);
/*     */         }
/*     */       } 
/*     */     } else {
/* 170 */       arrayList = new ArrayList(arrayDeque);
/*     */     } 
/*     */ 
/*     */     
/* 174 */     HashSet<Object> hashSet2 = new HashSet();
/* 175 */     LinkedHashSet<ModuleRef> linkedHashSet = new LinkedHashSet();
/* 176 */     for (ArrayDeque<Object> arrayDeque : (Iterable<ArrayDeque<Object>>)arrayList) {
/*     */       Object object;
/*     */       
/* 179 */       if ((object = this.reflectionUtils.invokeMethod(true, arrayDeque, "configuration")) != null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 184 */         if ((object = this.reflectionUtils.invokeMethod(true, object, "modules")) != null) {
/* 185 */           ArrayList<ModuleRef> arrayList1 = new ArrayList();
/* 186 */           for (Object object1 : object) {
/*     */ 
/*     */             
/* 189 */             if ((object1 = this.reflectionUtils.invokeMethod(true, object1, "reference")) != null && hashSet2.add(object1)) {
/*     */               try {
/* 191 */                 arrayList1.add(new ModuleRef(object1, arrayDeque, this.reflectionUtils));
/* 192 */               } catch (IllegalArgumentException illegalArgumentException) {
/* 193 */                 if (paramLogNode != null) {
/* 194 */                   paramLogNode.log("Exception while creating ModuleRef for module " + object1, illegalArgumentException);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */           
/* 200 */           CollectionUtils.sortIfNotEmpty(arrayList1);
/* 201 */           linkedHashSet.addAll(arrayList1);
/*     */         } 
/*     */       }
/*     */     } 
/* 205 */     return new ArrayList<>(linkedHashSet);
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
/*     */   private List<ModuleRef> findModuleRefsFromCallstack(Class<?>[] paramArrayOfClass, ScanSpec paramScanSpec, boolean paramBoolean, LogNode paramLogNode) {
/*     */     Class<?> clazz;
/* 223 */     LinkedHashSet<Object> linkedHashSet = new LinkedHashSet();
/* 224 */     if (paramArrayOfClass != null) {
/* 225 */       int i; byte b; for (i = (paramArrayOfClass = paramArrayOfClass).length, b = 0; b < i; ) { Class<?> clazz1 = paramArrayOfClass[b];
/*     */         
/*     */         Object object;
/* 228 */         if ((object = this.reflectionUtils.invokeMethod(false, clazz1, "getModule")) != null)
/*     */         {
/*     */           
/* 231 */           if ((object = this.reflectionUtils.invokeMethod(true, object, "getLayer")) != null) {
/* 232 */             linkedHashSet.add(object);
/* 233 */           } else if (paramBoolean) {
/*     */ 
/*     */             
/* 236 */             this.forceScanJavaClassPath = true;
/*     */           } 
/*     */         }
/*     */         b++; }
/*     */     
/*     */     } 
/* 242 */     paramArrayOfClass = null;
/*     */     try {
/* 244 */       clazz = Class.forName("java.lang.ModuleLayer");
/* 245 */     } catch (ClassNotFoundException|LinkageError classNotFoundException) {}
/*     */ 
/*     */     
/* 248 */     if (clazz != null) {
/*     */       Object object;
/*     */       
/* 251 */       if ((object = this.reflectionUtils.invokeStaticMethod(false, clazz, "boot")) != null) {
/* 252 */         linkedHashSet.add(object);
/* 253 */       } else if (paramBoolean) {
/*     */ 
/*     */ 
/*     */         
/* 257 */         this.forceScanJavaClassPath = true;
/*     */       } 
/*     */     } 
/* 260 */     return findModuleRefs(linkedHashSet, paramScanSpec, paramLogNode);
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
/*     */   public ModuleFinder(Class<?>[] paramArrayOfClass, ScanSpec paramScanSpec, boolean paramBoolean1, boolean paramBoolean2, ReflectionUtils paramReflectionUtils, LogNode paramLogNode) {
/*     */     List<ModuleRef> list;
/* 281 */     this.reflectionUtils = paramReflectionUtils;
/*     */ 
/*     */     
/* 284 */     paramReflectionUtils = null;
/* 285 */     if (paramScanSpec.overrideModuleLayers == null) {
/*     */       
/* 287 */       if (paramArrayOfClass != null && paramArrayOfClass.length > 0) {
/* 288 */         list = findModuleRefsFromCallstack(paramArrayOfClass, paramScanSpec, paramBoolean1, paramLogNode);
/*     */       }
/*     */     } else {
/* 291 */       if (paramLogNode != null) {
/* 292 */         LogNode logNode = paramLogNode.log("Overriding module layers");
/* 293 */         for (Object object : paramScanSpec.overrideModuleLayers) {
/* 294 */           logNode.log(object.toString());
/*     */         }
/*     */       } 
/* 297 */       list = findModuleRefs(new LinkedHashSet(paramScanSpec.overrideModuleLayers), paramScanSpec, paramLogNode);
/*     */     } 
/* 299 */     if (list != null) {
/*     */       
/* 301 */       this.systemModuleRefs = new ArrayList<>();
/* 302 */       this.nonSystemModuleRefs = new ArrayList<>();
/* 303 */       for (Iterator<ModuleRef> iterator = list.iterator(); iterator.hasNext();) {
/* 304 */         if ((moduleRef = iterator.next()) != null) {
/*     */           boolean bool;
/* 306 */           if ((bool = moduleRef.isSystemModule()) && paramBoolean2) {
/* 307 */             this.systemModuleRefs.add(moduleRef); continue;
/* 308 */           }  if (!bool && paramBoolean1) {
/* 309 */             this.nonSystemModuleRefs.add(moduleRef);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 315 */     if (paramLogNode != null) {
/* 316 */       if (paramBoolean2) {
/* 317 */         LogNode logNode = paramLogNode.log("System modules found:");
/* 318 */         if (this.systemModuleRefs != null && !this.systemModuleRefs.isEmpty()) {
/* 319 */           for (ModuleRef moduleRef : this.systemModuleRefs) {
/* 320 */             logNode.log(moduleRef.toString());
/*     */           }
/*     */         } else {
/* 323 */           logNode.log("[None]");
/*     */         } 
/*     */       } else {
/* 326 */         paramLogNode.log("Scanning of system modules is not enabled");
/*     */       } 
/* 328 */       if (paramBoolean1) {
/* 329 */         LogNode logNode = paramLogNode.log("Non-system modules found:");
/* 330 */         if (this.nonSystemModuleRefs != null && !this.nonSystemModuleRefs.isEmpty()) {
/* 331 */           for (ModuleRef moduleRef : this.nonSystemModuleRefs) {
/* 332 */             logNode.log(moduleRef.toString());
/*     */           }
/*     */         } else {
/* 335 */           logNode.log("[None]"); return;
/*     */         } 
/*     */       } else {
/* 338 */         paramLogNode.log("Scanning of non-system modules is not enabled");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classpath\ModuleFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */