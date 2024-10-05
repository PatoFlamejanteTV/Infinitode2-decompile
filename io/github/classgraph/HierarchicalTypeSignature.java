/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class HierarchicalTypeSignature
/*     */   extends ScanResultObject
/*     */ {
/*     */   protected AnnotationInfoList typeAnnotationInfo;
/*     */   
/*     */   protected void addTypeAnnotation(AnnotationInfo paramAnnotationInfo) {
/*  48 */     if (this.typeAnnotationInfo == null) {
/*  49 */       this.typeAnnotationInfo = new AnnotationInfoList(1);
/*     */     }
/*  51 */     this.typeAnnotationInfo.add(paramAnnotationInfo);
/*     */   }
/*     */ 
/*     */   
/*     */   void setScanResult(ScanResult paramScanResult) {
/*  56 */     super.setScanResult(paramScanResult);
/*  57 */     if (this.typeAnnotationInfo != null) {
/*  58 */       for (Iterator<AnnotationInfo> iterator = this.typeAnnotationInfo.iterator(); iterator.hasNext();) {
/*  59 */         (annotationInfo = iterator.next()).setScanResult(paramScanResult);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationInfoList getTypeAnnotationInfo() {
/*  70 */     return this.typeAnnotationInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void toString(boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 107 */     toStringInternal(paramBoolean, null, paramStringBuilder);
/*     */   }
/*     */   
/*     */   protected abstract void addTypeAnnotation(List<Classfile.TypePathNode> paramList, AnnotationInfo paramAnnotationInfo);
/*     */   
/*     */   protected abstract void toStringInternal(boolean paramBoolean, AnnotationInfoList paramAnnotationInfoList, StringBuilder paramStringBuilder);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\HierarchicalTypeSignature.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */