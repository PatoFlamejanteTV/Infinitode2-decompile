/*     */ package net.bytebuddy.jar.asm.commons;
/*     */ 
/*     */ import net.bytebuddy.jar.asm.AnnotationVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnnotationRemapper
/*     */   extends AnnotationVisitor
/*     */ {
/*     */   protected final String descriptor;
/*     */   protected final Remapper remapper;
/*     */   
/*     */   @Deprecated
/*     */   public AnnotationRemapper(AnnotationVisitor paramAnnotationVisitor, Remapper paramRemapper) {
/*  60 */     this((String)null, paramAnnotationVisitor, paramRemapper);
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
/*     */   public AnnotationRemapper(String paramString, AnnotationVisitor paramAnnotationVisitor, Remapper paramRemapper) {
/*  74 */     this(589824, paramString, paramAnnotationVisitor, paramRemapper);
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
/*     */   @Deprecated
/*     */   protected AnnotationRemapper(int paramInt, AnnotationVisitor paramAnnotationVisitor, Remapper paramRemapper) {
/*  89 */     this(paramInt, (String)null, paramAnnotationVisitor, paramRemapper);
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
/*     */   protected AnnotationRemapper(int paramInt, String paramString, AnnotationVisitor paramAnnotationVisitor, Remapper paramRemapper) {
/* 106 */     super(paramInt, paramAnnotationVisitor);
/* 107 */     this.descriptor = paramString;
/* 108 */     this.remapper = paramRemapper;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visit(String paramString, Object paramObject) {
/* 113 */     super.visit(mapAnnotationAttributeName(paramString), this.remapper.mapValue(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitEnum(String paramString1, String paramString2, String paramString3) {
/* 118 */     super.visitEnum(mapAnnotationAttributeName(paramString1), this.remapper.mapDesc(paramString2), paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String paramString1, String paramString2) {
/*     */     AnnotationVisitor annotationVisitor;
/* 125 */     if ((annotationVisitor = super.visitAnnotation(mapAnnotationAttributeName(paramString1), this.remapper.mapDesc(paramString2))) == null) {
/* 126 */       return null;
/*     */     }
/* 128 */     if (annotationVisitor == this.av)
/* 129 */       return this; 
/* 130 */     return createAnnotationRemapper(paramString2, annotationVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor visitArray(String paramString) {
/*     */     AnnotationVisitor annotationVisitor;
/* 137 */     if ((annotationVisitor = super.visitArray(mapAnnotationAttributeName(paramString))) == null) {
/* 138 */       return null;
/*     */     }
/* 140 */     if (annotationVisitor == this.av)
/* 141 */       return this; 
/* 142 */     return createAnnotationRemapper((String)null, annotationVisitor);
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
/*     */   @Deprecated
/*     */   protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor paramAnnotationVisitor) {
/* 156 */     return new AnnotationRemapper(this.api, null, paramAnnotationVisitor, this.remapper);
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
/* 169 */     return (new AnnotationRemapper(this.api, paramString, paramAnnotationVisitor, this.remapper))
/* 170 */       .a(createAnnotationRemapper(paramAnnotationVisitor));
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
/*     */   final AnnotationVisitor a(AnnotationVisitor paramAnnotationVisitor) {
/*     */     AnnotationRemapper annotationRemapper;
/* 185 */     if (paramAnnotationVisitor.getClass() == getClass() && 
/*     */ 
/*     */       
/* 188 */       (annotationRemapper = (AnnotationRemapper)paramAnnotationVisitor).api == this.api && annotationRemapper.av == this.av && annotationRemapper.remapper == this.remapper)
/*     */     {
/*     */       
/* 191 */       return this;
/*     */     }
/*     */     
/* 194 */     return paramAnnotationVisitor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String mapAnnotationAttributeName(String paramString) {
/* 205 */     if (this.descriptor == null) {
/* 206 */       return paramString;
/*     */     }
/* 208 */     return this.remapper.mapAnnotationAttributeName(this.descriptor, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\commons\AnnotationRemapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */