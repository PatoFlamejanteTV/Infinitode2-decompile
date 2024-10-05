/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
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
/*     */ public class PackageInfo
/*     */   implements HasName, Comparable<PackageInfo>
/*     */ {
/*     */   private String name;
/*     */   private Set<AnnotationInfo> annotationInfoSet;
/*     */   private AnnotationInfoList annotationInfo;
/*     */   private PackageInfo parent;
/*     */   private Set<PackageInfo> children;
/*     */   private Map<String, ClassInfo> memberClassNameToClassInfo;
/*     */   
/*     */   PackageInfo() {}
/*     */   
/*     */   PackageInfo(String paramString) {
/*  80 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  90 */     return this.name;
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
/* 103 */     if (paramAnnotationInfoList != null && !paramAnnotationInfoList.isEmpty()) {
/* 104 */       if (this.annotationInfoSet == null) {
/* 105 */         this.annotationInfoSet = new LinkedHashSet<>();
/*     */       }
/* 107 */       this.annotationInfoSet.addAll(paramAnnotationInfoList);
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
/*     */   void addClassInfo(ClassInfo paramClassInfo) {
/* 119 */     if (this.memberClassNameToClassInfo == null) {
/* 120 */       this.memberClassNameToClassInfo = new HashMap<>();
/*     */     }
/* 122 */     this.memberClassNameToClassInfo.put(paramClassInfo.getName(), paramClassInfo);
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
/*     */   public AnnotationInfo getAnnotationInfo(Class<? extends Annotation> paramClass) {
/* 136 */     Assert.isAnnotation(paramClass);
/* 137 */     return getAnnotationInfo(paramClass.getName());
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
/* 149 */     return getAnnotationInfo().get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList getAnnotationInfo() {
/* 158 */     if (this.annotationInfo == null) {
/* 159 */       if (this.annotationInfoSet == null) {
/* 160 */         this.annotationInfo = AnnotationInfoList.EMPTY_LIST;
/*     */       } else {
/* 162 */         this.annotationInfo = new AnnotationInfoList();
/* 163 */         this.annotationInfo.addAll(this.annotationInfoSet);
/*     */       } 
/*     */     }
/* 166 */     return this.annotationInfo;
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
/* 177 */     Assert.isAnnotation(paramClass);
/* 178 */     return hasAnnotation(paramClass.getName());
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
/* 189 */     return getAnnotationInfo().containsName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackageInfo getParent() {
/* 200 */     return this.parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackageInfoList getChildren() {
/* 209 */     if (this.children == null) {
/* 210 */       return PackageInfoList.EMPTY_LIST;
/*     */     }
/*     */     
/*     */     PackageInfoList packageInfoList;
/* 214 */     CollectionUtils.sortIfNotEmpty(packageInfoList = new PackageInfoList(this.children), new Comparator<PackageInfo>()
/*     */         {
/*     */           public int compare(PackageInfo param1PackageInfo1, PackageInfo param1PackageInfo2) {
/* 217 */             return param1PackageInfo1.name.compareTo(param1PackageInfo2.name);
/*     */           }
/*     */         });
/* 220 */     return packageInfoList;
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
/*     */   public ClassInfo getClassInfo(String paramString) {
/* 235 */     return (this.memberClassNameToClassInfo == null) ? null : this.memberClassNameToClassInfo.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getClassInfo() {
/* 244 */     return (this.memberClassNameToClassInfo == null) ? ClassInfoList.EMPTY_LIST : new ClassInfoList(new HashSet<>(this.memberClassNameToClassInfo
/* 245 */           .values()), true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void obtainClassInfoRecursive(Set<ClassInfo> paramSet) {
/* 255 */     if (this.memberClassNameToClassInfo != null) {
/* 256 */       paramSet.addAll(this.memberClassNameToClassInfo.values());
/*     */     }
/* 258 */     for (Iterator<PackageInfo> iterator = getChildren().iterator(); iterator.hasNext();) {
/* 259 */       (packageInfo = iterator.next()).obtainClassInfoRecursive(paramSet);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassInfoList getClassInfoRecursive() {
/* 269 */     HashSet<ClassInfo> hashSet = new HashSet();
/* 270 */     obtainClassInfoRecursive(hashSet);
/* 271 */     return new ClassInfoList(hashSet, true);
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
/*     */   static String getParentPackageName(String paramString) {
/* 285 */     if (paramString.isEmpty()) {
/* 286 */       return null;
/*     */     }
/*     */     int i;
/* 289 */     return ((i = paramString.lastIndexOf('.')) < 0) ? "" : paramString.substring(0, i);
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
/*     */   static PackageInfo getOrCreatePackage(String paramString, Map<String, PackageInfo> paramMap, ScanSpec paramScanSpec) {
/*     */     PackageInfo packageInfo;
/* 309 */     if ((packageInfo = paramMap.get(paramString)) != null)
/*     */     {
/* 311 */       return packageInfo;
/*     */     }
/*     */ 
/*     */     
/* 315 */     paramMap.put(paramString, packageInfo = new PackageInfo(paramString));
/*     */ 
/*     */     
/* 318 */     if (!paramString.isEmpty()) {
/*     */ 
/*     */       
/* 321 */       paramString = getParentPackageName(packageInfo.name); PackageInfo packageInfo1;
/* 322 */       if ((paramScanSpec.packageAcceptReject.isAcceptedAndNotRejected(paramString) || paramScanSpec.packagePrefixAcceptReject
/* 323 */         .isAcceptedAndNotRejected(paramString)) && (
/*     */ 
/*     */         
/* 326 */         packageInfo1 = getOrCreatePackage(paramString, paramMap, paramScanSpec)) != null) {
/*     */         
/* 328 */         if (packageInfo1.children == null) {
/* 329 */           packageInfo1.children = new HashSet<>();
/*     */         }
/* 331 */         packageInfo1.children.add(packageInfo);
/* 332 */         packageInfo.parent = packageInfo1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 338 */     return packageInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(PackageInfo paramPackageInfo) {
/* 348 */     return this.name.compareTo(paramPackageInfo.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 356 */     return this.name.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 364 */     if (paramObject == this)
/* 365 */       return true; 
/* 366 */     if (!(paramObject instanceof PackageInfo)) {
/* 367 */       return false;
/*     */     }
/* 369 */     return this.name.equals(((PackageInfo)paramObject).name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 377 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\PackageInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */