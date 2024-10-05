/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.RecordComponentVisitor;
/*     */ import net.bytebuddy.jar.asm.TypePath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RecordComponentRemapper
/*     */   extends RecordComponentVisitor
/*     */ {
/*     */   protected final Remapper remapper;
/*     */   
/*     */   public RecordComponentRemapper(RecordComponentVisitor paramRecordComponentVisitor, Remapper paramRemapper) {
/*  56 */     this(589824, paramRecordComponentVisitor, paramRemapper);
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
/*     */   protected RecordComponentRemapper(int paramInt, RecordComponentVisitor paramRecordComponentVisitor, Remapper paramRemapper) {
/*  69 */     super(paramInt, paramRecordComponentVisitor);
/*  70 */     this.remapper = paramRemapper;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/*  77 */     if ((annotationVisitor = super.visitAnnotation(this.remapper.mapDesc(paramString), paramBoolean)) == null)
/*  78 */       return null; 
/*  79 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/*  87 */     if ((annotationVisitor = super.visitTypeAnnotation(paramInt, paramTypePath, this.remapper.mapDesc(paramString), paramBoolean)) == null)
/*  88 */       return null; 
/*  89 */     return createAnnotationRemapper(paramString, annotationVisitor);
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
/*     */   @Deprecated
/*     */   protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor paramAnnotationVisitor) {
/* 102 */     return new AnnotationRemapper(this.api, null, paramAnnotationVisitor, this.remapper);
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
/*     */   protected AnnotationVisitor createAnnotationRemapper(String paramString, AnnotationVisitor paramAnnotationVisitor) {
/* 115 */     return (new AnnotationRemapper(this.api, paramString, paramAnnotationVisitor, this.remapper))
/* 116 */       .a(createAnnotationRemapper(paramAnnotationVisitor));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\RecordComponentRemapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */