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
/*     */ public abstract class RecordComponentVisitor
/*     */ {
/*     */   protected final int api;
/*     */   protected RecordComponentVisitor delegate;
/*     */   
/*     */   protected RecordComponentVisitor(int paramInt) {
/*  57 */     this(paramInt, null);
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
/*     */   protected RecordComponentVisitor(int paramInt, RecordComponentVisitor paramRecordComponentVisitor) {
/*  69 */     if (paramInt != 589824 && paramInt != 524288 && paramInt != 458752 && paramInt != 393216 && paramInt != 327680 && paramInt != 262144 && paramInt != 17432576)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       throw new IllegalArgumentException("Unsupported api " + paramInt);
/*     */     }
/*  78 */     if (paramInt == 17432576) {
/*  79 */       Constants.a(this);
/*     */     }
/*  81 */     this.api = paramInt;
/*  82 */     this.delegate = paramRecordComponentVisitor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecordComponentVisitor getDelegate() {
/*  92 */     return this.delegate;
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
/*     */   public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/* 104 */     if (this.delegate != null) {
/* 105 */       return this.delegate.visitAnnotation(paramString, paramBoolean);
/*     */     }
/* 107 */     return null;
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
/*     */   public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 127 */     if (this.delegate != null) {
/* 128 */       return this.delegate.visitTypeAnnotation(paramInt, paramTypePath, paramString, paramBoolean);
/*     */     }
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitAttribute(Attribute paramAttribute) {
/* 139 */     if (this.delegate != null) {
/* 140 */       this.delegate.visitAttribute(paramAttribute);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitEnd() {
/* 149 */     if (this.delegate != null)
/* 150 */       this.delegate.visitEnd(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\RecordComponentVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */