/*     */ package net.bytebuddy.jar.asm;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AnnotationVisitor
/*     */ {
/*     */   protected final int api;
/*     */   protected AnnotationVisitor av;
/*     */   
/*     */   protected AnnotationVisitor(int paramInt) {
/*  59 */     this(paramInt, null);
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
/*     */   protected AnnotationVisitor(int paramInt, AnnotationVisitor paramAnnotationVisitor) {
/*  71 */     if (paramInt != 589824 && paramInt != 524288 && paramInt != 458752 && paramInt != 393216 && paramInt != 327680 && paramInt != 262144 && paramInt != 17432576)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  78 */       throw new IllegalArgumentException("Unsupported api " + paramInt);
/*     */     }
/*  80 */     if (paramInt == 17432576) {
/*  81 */       Constants.a(this);
/*     */     }
/*  83 */     this.api = paramInt;
/*  84 */     this.av = paramAnnotationVisitor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationVisitor getDelegate() {
/*  95 */     return this.av;
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
/*     */   public void visit(String paramString, Object paramObject) {
/* 110 */     if (this.av != null) {
/* 111 */       this.av.visit(paramString, paramObject);
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
/*     */   public void visitEnum(String paramString1, String paramString2, String paramString3) {
/* 123 */     if (this.av != null) {
/* 124 */       this.av.visitEnum(paramString1, paramString2, paramString3);
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
/*     */   public AnnotationVisitor visitAnnotation(String paramString1, String paramString2) {
/* 138 */     if (this.av != null) {
/* 139 */       return this.av.visitAnnotation(paramString1, paramString2);
/*     */     }
/* 141 */     return null;
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
/*     */   public AnnotationVisitor visitArray(String paramString) {
/* 156 */     if (this.av != null) {
/* 157 */       return this.av.visitArray(paramString);
/*     */     }
/* 159 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitEnd() {
/* 164 */     if (this.av != null)
/* 165 */       this.av.visitEnd(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\AnnotationVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */