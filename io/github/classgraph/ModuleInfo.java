/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.net.URI;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.utils.Assert;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModuleInfo
/*     */   implements HasName, Comparable<ModuleInfo>
/*     */ {
/*     */   private String name;
/*     */   private transient ClasspathElement classpathElement;
/*     */   private transient ModuleRef moduleRef;
/*     */   private transient URI locationURI;
/*     */   private Set<AnnotationInfo> annotationInfoSet;
/*     */   private AnnotationInfoList annotationInfo;
/*     */   private Set<PackageInfo> packageInfoSet;
/*     */   private Set<ClassInfo> classInfoSet;
/*     */   
/*     */   ModuleInfo() {}
/*     */   
/*     */   ModuleInfo(ModuleRef paramModuleRef, ClasspathElement paramClasspathElement) {
/*  85 */     this.moduleRef = paramModuleRef;
/*  86 */     this.classpathElement = paramClasspathElement;
/*  87 */     this.name = paramClasspathElement.getModuleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  97 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getLocation() {
/* 106 */     if (this.locationURI == null) {
/* 107 */       this.locationURI = (this.moduleRef != null) ? this.moduleRef.getLocation() : null;
/* 108 */       if (this.locationURI == null) {
/* 109 */         this.locationURI = this.classpathElement.getURI();
/*     */       }
/*     */     } 
/* 112 */     return this.locationURI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModuleRef getModuleRef() {
/* 123 */     return this.moduleRef;
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
/*     */   void addClassInfo(ClassInfo paramClassInfo) {
/* 135 */     if (this.classInfoSet == null) {
/* 136 */       this.classInfoSet = new HashSet<>();
/*     */     }
/* 138 */     this.classInfoSet.add(paramClassInfo);
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
/*     */   public ClassInfo getClassInfo(String paramString) {
/* 151 */     for (Iterator<ClassInfo> iterator = this.classInfoSet.iterator(); iterator.hasNext();) {
/* 152 */       if ((classInfo = iterator.next()).getName().equals(paramString)) {
/* 153 */         return classInfo;
/*     */       }
/*     */     } 
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getClassInfo() {
/* 165 */     return new ClassInfoList(this.classInfoSet, true);
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
/*     */   void addPackageInfo(PackageInfo paramPackageInfo) {
/* 177 */     if (this.packageInfoSet == null) {
/* 178 */       this.packageInfoSet = new HashSet<>();
/*     */     }
/* 180 */     this.packageInfoSet.add(paramPackageInfo);
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
/*     */   public PackageInfo getPackageInfo(String paramString) {
/* 193 */     if (this.packageInfoSet == null) {
/* 194 */       return null;
/*     */     }
/* 196 */     for (Iterator<PackageInfo> iterator = this.packageInfoSet.iterator(); iterator.hasNext();) {
/* 197 */       if ((packageInfo = iterator.next()).getName().equals(paramString)) {
/* 198 */         return packageInfo;
/*     */       }
/*     */     } 
/* 201 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackageInfoList getPackageInfo() {
/* 210 */     if (this.packageInfoSet == null) {
/* 211 */       return new PackageInfoList(1);
/*     */     }
/*     */     PackageInfoList packageInfoList;
/* 214 */     CollectionUtils.sortIfNotEmpty(packageInfoList = new PackageInfoList(this.packageInfoSet));
/* 215 */     return packageInfoList;
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
/*     */   void addAnnotations(AnnotationInfoList paramAnnotationInfoList) {
/* 228 */     if (paramAnnotationInfoList != null && !paramAnnotationInfoList.isEmpty()) {
/* 229 */       if (this.annotationInfoSet == null) {
/* 230 */         this.annotationInfoSet = new LinkedHashSet<>();
/*     */       }
/* 232 */       this.annotationInfoSet.addAll(paramAnnotationInfoList);
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
/*     */   public AnnotationInfo getAnnotationInfo(Class<? extends Annotation> paramClass) {
/* 245 */     Assert.isAnnotation(paramClass);
/* 246 */     return getAnnotationInfo(paramClass.getName());
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
/*     */   public AnnotationInfo getAnnotationInfo(String paramString) {
/* 258 */     return getAnnotationInfo().get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList getAnnotationInfo() {
/* 267 */     if (this.annotationInfo == null) {
/* 268 */       if (this.annotationInfoSet == null) {
/* 269 */         this.annotationInfo = AnnotationInfoList.EMPTY_LIST;
/*     */       } else {
/* 271 */         this.annotationInfo = new AnnotationInfoList();
/* 272 */         this.annotationInfo.addAll(this.annotationInfoSet);
/*     */       } 
/*     */     }
/* 275 */     return this.annotationInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAnnotation(Class<? extends Annotation> paramClass) {
/* 286 */     Assert.isAnnotation(paramClass);
/* 287 */     return hasAnnotation(paramClass.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAnnotation(String paramString) {
/* 298 */     return getAnnotationInfo().containsName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ModuleInfo paramModuleInfo) {
/*     */     int i;
/* 309 */     if ((i = this.name.compareTo(paramModuleInfo.name)) != 0) {
/* 310 */       return i;
/*     */     }
/* 312 */     URI uRI2 = getLocation();
/* 313 */     URI uRI1 = paramModuleInfo.getLocation();
/* 314 */     if (uRI2 != null && uRI1 != null) {
/* 315 */       return uRI2.compareTo(uRI1);
/*     */     }
/* 317 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 325 */     return this.name.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 333 */     if (paramObject == this)
/* 334 */       return true; 
/* 335 */     if (!(paramObject instanceof ModuleInfo)) {
/* 336 */       return false;
/*     */     }
/* 338 */     return (compareTo((ModuleInfo)paramObject) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 346 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ModuleInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */