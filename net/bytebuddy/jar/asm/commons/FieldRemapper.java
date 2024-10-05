/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ import net.bytebuddy.jar.asm.FieldVisitor;
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
/*     */ public class FieldRemapper
/*     */   extends FieldVisitor
/*     */ {
/*     */   protected final Remapper remapper;
/*     */   
/*     */   public FieldRemapper(FieldVisitor paramFieldVisitor, Remapper paramRemapper) {
/*  54 */     this(589824, paramFieldVisitor, paramRemapper);
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
/*     */   protected FieldRemapper(int paramInt, FieldVisitor paramFieldVisitor, Remapper paramRemapper) {
/*  66 */     super(paramInt, paramFieldVisitor);
/*  67 */     this.remapper = paramRemapper;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/*  74 */     if ((annotationVisitor = super.visitAnnotation(this.remapper.mapDesc(paramString), paramBoolean)) == null)
/*  75 */       return null; 
/*  76 */     return createAnnotationRemapper(paramString, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/*     */     AnnotationVisitor annotationVisitor;
/*  84 */     if ((annotationVisitor = super.visitTypeAnnotation(paramInt, paramTypePath, this.remapper.mapDesc(paramString), paramBoolean)) == null)
/*  85 */       return null; 
/*  86 */     return createAnnotationRemapper(paramString, annotationVisitor);
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
/*  99 */     return new AnnotationRemapper(this.api, null, paramAnnotationVisitor, this.remapper);
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
/* 112 */     return (new AnnotationRemapper(this.api, paramString, paramAnnotationVisitor, this.remapper))
/* 113 */       .a(createAnnotationRemapper(paramAnnotationVisitor));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\FieldRemapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */