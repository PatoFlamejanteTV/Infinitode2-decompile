/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public class AnnotationParameterValueList
/*     */   extends MappableInfoList<AnnotationParameterValue>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final AnnotationParameterValueList EMPTY_LIST;
/*     */   
/*     */   static {
/*  45 */     (EMPTY_LIST = new AnnotationParameterValueList()).makeUnmodifiable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AnnotationParameterValueList emptyList() {
/*  54 */     return EMPTY_LIST;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationParameterValueList() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationParameterValueList(int paramInt) {
/*  71 */     super(paramInt);
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
/*     */   public AnnotationParameterValueList(Collection<AnnotationParameterValue> paramCollection) {
/*  83 */     super(paramCollection);
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
/* 100 */     for (Iterator<AnnotationParameterValue> iterator = iterator(); iterator.hasNext();) {
/* 101 */       (annotationParameterValue = iterator.next()).findReferencedClassInfo(paramMap, paramSet, paramLogNode);
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
/*     */   void convertWrapperArraysToPrimitiveArrays(ClassInfo paramClassInfo) {
/* 115 */     for (Iterator<AnnotationParameterValue> iterator = iterator(); iterator.hasNext();) {
/* 116 */       (annotationParameterValue = iterator.next()).convertWrapperArraysToPrimitiveArrays(paramClassInfo);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String paramString) {
/*     */     AnnotationParameterValue annotationParameterValue;
/* 150 */     return ((annotationParameterValue = get(paramString)) == null) ? null : annotationParameterValue.getValue();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\AnnotationParameterValueList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */