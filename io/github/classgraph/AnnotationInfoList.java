/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.utils.Assert;
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
/*     */ public class AnnotationInfoList
/*     */   extends MappableInfoList<AnnotationInfo>
/*     */ {
/*     */   private AnnotationInfoList directlyRelatedAnnotations;
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final AnnotationInfoList EMPTY_LIST;
/*     */   
/*     */   static {
/*  59 */     (EMPTY_LIST = new AnnotationInfoList()).makeUnmodifiable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AnnotationInfoList emptyList() {
/*  68 */     return EMPTY_LIST;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList(int paramInt) {
/*  85 */     super(paramInt);
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
/*     */   public AnnotationInfoList(AnnotationInfoList paramAnnotationInfoList) {
/*  97 */     this(paramAnnotationInfoList, paramAnnotationInfoList);
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
/*     */   AnnotationInfoList(AnnotationInfoList paramAnnotationInfoList1, AnnotationInfoList paramAnnotationInfoList2) {
/* 110 */     super(paramAnnotationInfoList1);
/* 111 */     this.directlyRelatedAnnotations = paramAnnotationInfoList2;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList filter(AnnotationInfoFilter paramAnnotationInfoFilter) {
/* 143 */     AnnotationInfoList annotationInfoList = new AnnotationInfoList();
/* 144 */     for (AnnotationInfo annotationInfo : this) {
/* 145 */       if (paramAnnotationInfoFilter.accept(annotationInfo)) {
/* 146 */         annotationInfoList.add(annotationInfo);
/*     */       }
/*     */     } 
/* 149 */     return annotationInfoList;
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
/*     */   protected void findReferencedClassInfo(Map<String, ClassInfo> paramMap, Set<ClassInfo> paramSet, LogNode paramLogNode) {
/* 166 */     for (Iterator<AnnotationInfo> iterator = iterator(); iterator.hasNext();) {
/* 167 */       (annotationInfo = iterator.next()).findReferencedClassInfo(paramMap, paramSet, paramLogNode);
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
/*     */   void handleRepeatableAnnotations(Set<String> paramSet, ClassInfo paramClassInfo, ClassInfo.RelType paramRelType1, ClassInfo.RelType paramRelType2, ClassInfo.RelType paramRelType3) {
/* 190 */     ArrayList<AnnotationInfo> arrayList = null;
/* 191 */     for (int i = size() - 1; i >= 0; i--) {
/* 192 */       AnnotationInfo annotationInfo = get(i);
/* 193 */       if (paramSet.contains(annotationInfo.getName())) {
/* 194 */         if (arrayList == null) {
/* 195 */           arrayList = new ArrayList();
/*     */         }
/* 197 */         arrayList.add(annotationInfo);
/*     */         
/* 199 */         remove(i);
/*     */       } 
/*     */     } 
/*     */     
/* 203 */     if (arrayList != null) {
/* 204 */       for (Iterator<AnnotationInfo> iterator = arrayList.iterator(); iterator.hasNext();) {
/*     */         
/* 206 */         if (!(annotationParameterValueList = (annotationInfo = iterator.next()).getParameterValues()).isEmpty() && (
/*     */           
/* 208 */           annotationParameterValue = annotationParameterValueList.get("value")) != null && 
/*     */           
/* 210 */           object = annotationParameterValue.getValue() instanceof Object[]) {
/* 211 */           int j; byte b; for (j = (object = object).length, b = 0; b < j; b++) {
/* 212 */             Object object1; if (object1 = object[b] instanceof AnnotationInfo) {
/* 213 */               object1 = object1;
/* 214 */               add((AnnotationInfo)object1);
/*     */ 
/*     */               
/* 217 */               if (paramRelType1 != null && (paramRelType2 != null || paramRelType3 != null))
/*     */               {
/*     */                 
/* 220 */                 if ((object1 = object1.getClassInfo()) != null) {
/* 221 */                   paramClassInfo.addRelatedClass(paramRelType1, (ClassInfo)object1);
/* 222 */                   if (paramRelType2 != null) {
/* 223 */                     object1.addRelatedClass(paramRelType2, paramClassInfo);
/*     */                   }
/*     */                   
/* 226 */                   if (paramRelType3 != null) {
/* 227 */                     object1.addRelatedClass(paramRelType3, paramClassInfo);
/*     */                   }
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
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
/*     */   private static void findMetaAnnotations(AnnotationInfo paramAnnotationInfo, AnnotationInfoList paramAnnotationInfoList, Set<ClassInfo> paramSet) {
/*     */     ClassInfo classInfo;
/* 256 */     if ((classInfo = paramAnnotationInfo.getClassInfo()) != null && classInfo.annotationInfo != null && paramSet
/*     */       
/* 258 */       .add(classInfo)) {
/* 259 */       for (Iterator<AnnotationInfo> iterator = classInfo.annotationInfo.iterator(); iterator.hasNext();) {
/*     */ 
/*     */ 
/*     */         
/* 263 */         if (!(str = (classInfo1 = (annotationInfo = iterator.next()).getClassInfo()).getName()).startsWith("java.lang.annotation.")) {
/*     */           
/* 265 */           paramAnnotationInfoList.add(annotationInfo);
/*     */           
/* 267 */           findMetaAnnotations(annotationInfo, paramAnnotationInfoList, paramSet);
/*     */         } 
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
/*     */   static AnnotationInfoList getIndirectAnnotations(AnnotationInfoList paramAnnotationInfoList, ClassInfo paramClassInfo) {
/* 285 */     HashSet<ClassInfo> hashSet1 = new HashSet();
/* 286 */     HashSet<ClassInfo> hashSet2 = new HashSet();
/*     */     
/* 288 */     AnnotationInfoList annotationInfoList1 = new AnnotationInfoList((paramAnnotationInfoList == null) ? 2 : paramAnnotationInfoList.size());
/* 289 */     if (paramAnnotationInfoList != null) {
/* 290 */       for (AnnotationInfo annotationInfo : paramAnnotationInfoList) {
/* 291 */         hashSet1.add(annotationInfo.getClassInfo());
/* 292 */         annotationInfoList1.add(annotationInfo);
/* 293 */         findMetaAnnotations(annotationInfo, annotationInfoList1, hashSet2);
/*     */       } 
/*     */     }
/* 296 */     if (paramClassInfo != null)
/*     */     {
/* 298 */       for (Iterator<ClassInfo> iterator = paramClassInfo.getSuperclasses().iterator(); iterator.hasNext();) {
/* 299 */         if ((classInfo = iterator.next()).annotationInfo != null) {
/* 300 */           for (Iterator<AnnotationInfo> iterator1 = classInfo.annotationInfo.iterator(); iterator1.hasNext();) {
/*     */             
/* 302 */             if ((annotationInfo = iterator1.next()).isInherited() && hashSet1.add(annotationInfo.getClassInfo())) {
/* 303 */               annotationInfoList1.add(annotationInfo);
/* 304 */               AnnotationInfoList annotationInfoList = new AnnotationInfoList(2);
/* 305 */               findMetaAnnotations(annotationInfo, annotationInfoList, hashSet2);
/*     */               
/* 307 */               for (Iterator<AnnotationInfo> iterator2 = annotationInfoList.iterator(); iterator2.hasNext();) {
/* 308 */                 if ((annotationInfo1 = iterator2.next()).isInherited()) {
/* 309 */                   annotationInfoList1.add(annotationInfo1);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     AnnotationInfoList annotationInfoList2;
/*     */     
/* 321 */     CollectionUtils.sortIfNotEmpty(annotationInfoList2 = (AnnotationInfoList)((paramAnnotationInfoList == null) ? EMPTY_LIST : new AnnotationInfoList(paramAnnotationInfoList)));
/*     */     
/*     */     AnnotationInfoList annotationInfoList3;
/* 324 */     CollectionUtils.sortIfNotEmpty(annotationInfoList3 = new AnnotationInfoList(annotationInfoList1, annotationInfoList2));
/* 325 */     return annotationInfoList3;
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
/*     */   public AnnotationInfoList directOnly() {
/* 342 */     return (this.directlyRelatedAnnotations == null) ? this : new AnnotationInfoList(this.directlyRelatedAnnotations, null);
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
/*     */   public AnnotationInfoList getRepeatable(Class<? extends Annotation> paramClass) {
/* 357 */     Assert.isAnnotation(paramClass);
/* 358 */     return getRepeatable(paramClass.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList getRepeatable(String paramString) {
/* 369 */     boolean bool = false;
/* 370 */     for (Iterator<AnnotationInfo> iterator1 = iterator(); iterator1.hasNext();) {
/* 371 */       if ((annotationInfo = iterator1.next()).getName().equals(paramString)) {
/* 372 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 376 */     if (!bool) {
/* 377 */       return EMPTY_LIST;
/*     */     }
/* 379 */     AnnotationInfoList annotationInfoList = new AnnotationInfoList(size());
/* 380 */     for (Iterator<AnnotationInfo> iterator2 = iterator(); iterator2.hasNext();) {
/* 381 */       if ((annotationInfo = iterator2.next()).getName().equals(paramString)) {
/* 382 */         annotationInfoList.add(annotationInfo);
/*     */       }
/*     */     } 
/* 385 */     return annotationInfoList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 395 */     if (this == paramObject)
/* 396 */       return true; 
/* 397 */     if (!(paramObject instanceof AnnotationInfoList)) {
/* 398 */       return false;
/*     */     }
/* 400 */     paramObject = paramObject;
/* 401 */     if (((this.directlyRelatedAnnotations == null) ? true : false) != ((((AnnotationInfoList)paramObject).directlyRelatedAnnotations == null) ? true : false)) {
/* 402 */       return false;
/*     */     }
/* 404 */     if (this.directlyRelatedAnnotations == null) {
/* 405 */       return super.equals(paramObject);
/*     */     }
/* 407 */     return (super.equals(paramObject) && this.directlyRelatedAnnotations.equals(((AnnotationInfoList)paramObject).directlyRelatedAnnotations));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 415 */     return super.hashCode() ^ ((this.directlyRelatedAnnotations == null) ? 0 : this.directlyRelatedAnnotations.hashCode());
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface AnnotationInfoFilter {
/*     */     boolean accept(AnnotationInfo param1AnnotationInfo);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\AnnotationInfoList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */