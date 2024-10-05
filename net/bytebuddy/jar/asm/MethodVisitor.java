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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MethodVisitor
/*     */ {
/*     */   private static final String REQUIRES_ASM5 = "This feature requires ASM5";
/*     */   protected final int api;
/*     */   protected MethodVisitor mv;
/*     */   
/*     */   protected MethodVisitor(int paramInt) {
/*  71 */     this(paramInt, null);
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
/*     */   protected MethodVisitor(int paramInt, MethodVisitor paramMethodVisitor) {
/*  83 */     if (paramInt != 589824 && paramInt != 524288 && paramInt != 458752 && paramInt != 393216 && paramInt != 327680 && paramInt != 262144 && paramInt != 17432576)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  90 */       throw new IllegalArgumentException("Unsupported api " + paramInt);
/*     */     }
/*  92 */     if (paramInt == 17432576) {
/*  93 */       Constants.a(this);
/*     */     }
/*  95 */     this.api = paramInt;
/*  96 */     this.mv = paramMethodVisitor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodVisitor getDelegate() {
/* 106 */     return this.mv;
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
/*     */   public void visitParameter(String paramString, int paramInt) {
/* 121 */     if (this.api < 327680) {
/* 122 */       throw new UnsupportedOperationException("This feature requires ASM5");
/*     */     }
/* 124 */     if (this.mv != null) {
/* 125 */       this.mv.visitParameter(paramString, paramInt);
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
/*     */   public AnnotationVisitor visitAnnotationDefault() {
/* 138 */     if (this.mv != null) {
/* 139 */       return this.mv.visitAnnotationDefault();
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
/*     */   public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
/* 153 */     if (this.mv != null) {
/* 154 */       return this.mv.visitAnnotation(paramString, paramBoolean);
/*     */     }
/* 156 */     return null;
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
/*     */   public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 177 */     if (this.api < 327680) {
/* 178 */       throw new UnsupportedOperationException("This feature requires ASM5");
/*     */     }
/* 180 */     if (this.mv != null) {
/* 181 */       return this.mv.visitTypeAnnotation(paramInt, paramTypePath, paramString, paramBoolean);
/*     */     }
/* 183 */     return null;
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
/*     */   public void visitAnnotableParameterCount(int paramInt, boolean paramBoolean) {
/* 201 */     if (this.mv != null) {
/* 202 */       this.mv.visitAnnotableParameterCount(paramInt, paramBoolean);
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
/*     */   public AnnotationVisitor visitParameterAnnotation(int paramInt, String paramString, boolean paramBoolean) {
/* 222 */     if (this.mv != null) {
/* 223 */       return this.mv.visitParameterAnnotation(paramInt, paramString, paramBoolean);
/*     */     }
/* 225 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitAttribute(Attribute paramAttribute) {
/* 234 */     if (this.mv != null) {
/* 235 */       this.mv.visitAttribute(paramAttribute);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitCode() {
/* 241 */     if (this.mv != null) {
/* 242 */       this.mv.visitCode();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2) {
/* 311 */     if (this.mv != null) {
/* 312 */       this.mv.visitFrame(paramInt1, paramInt2, paramArrayOfObject1, paramInt3, paramArrayOfObject2);
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
/*     */   public void visitInsn(int paramInt) {
/* 335 */     if (this.mv != null) {
/* 336 */       this.mv.visitInsn(paramInt);
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
/*     */   public void visitIntInsn(int paramInt1, int paramInt2) {
/* 355 */     if (this.mv != null) {
/* 356 */       this.mv.visitIntInsn(paramInt1, paramInt2);
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
/*     */   public void visitVarInsn(int paramInt1, int paramInt2) {
/* 370 */     if (this.mv != null) {
/* 371 */       this.mv.visitVarInsn(paramInt1, paramInt2);
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
/*     */   public void visitTypeInsn(int paramInt, String paramString) {
/* 385 */     if (this.mv != null) {
/* 386 */       this.mv.visitTypeInsn(paramInt, paramString);
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
/*     */   public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 402 */     if (this.mv != null) {
/* 403 */       this.mv.visitFieldInsn(paramInt, paramString1, paramString2, paramString3);
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
/*     */   @Deprecated
/*     */   public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 421 */     int i = paramInt | ((this.api < 327680) ? 256 : 0);
/* 422 */     visitMethodInsn(i, paramString1, paramString2, paramString3, (paramInt == 185));
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
/*     */   public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 442 */     if (this.api < 327680 && (paramInt & 0x100) == 0) {
/* 443 */       if (paramBoolean != ((paramInt == 185))) {
/* 444 */         throw new UnsupportedOperationException("INVOKESPECIAL/STATIC on interfaces requires ASM5");
/*     */       }
/* 446 */       visitMethodInsn(paramInt, paramString1, paramString2, paramString3);
/*     */       return;
/*     */     } 
/* 449 */     if (this.mv != null) {
/* 450 */       this.mv.visitMethodInsn(paramInt & 0xFFFFFEFF, paramString1, paramString2, paramString3, paramBoolean);
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
/*     */   public void visitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/* 470 */     if (this.api < 327680) {
/* 471 */       throw new UnsupportedOperationException("This feature requires ASM5");
/*     */     }
/* 473 */     if (this.mv != null) {
/* 474 */       this.mv.visitInvokeDynamicInsn(paramString1, paramString2, paramHandle, paramVarArgs);
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
/*     */   public void visitJumpInsn(int paramInt, Label paramLabel) {
/* 489 */     if (this.mv != null) {
/* 490 */       this.mv.visitJumpInsn(paramInt, paramLabel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitLabel(Label paramLabel) {
/* 500 */     if (this.mv != null) {
/* 501 */       this.mv.visitLabel(paramLabel);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitLdcInsn(Object paramObject) {
/* 553 */     if (this.api < 327680 && (paramObject instanceof Handle || (paramObject instanceof Type && ((Type)paramObject)
/*     */       
/* 555 */       .getSort() == 11))) {
/* 556 */       throw new UnsupportedOperationException("This feature requires ASM5");
/*     */     }
/* 558 */     if (this.api < 458752 && paramObject instanceof ConstantDynamic) {
/* 559 */       throw new UnsupportedOperationException("This feature requires ASM7");
/*     */     }
/* 561 */     if (this.mv != null) {
/* 562 */       this.mv.visitLdcInsn(paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitIincInsn(int paramInt1, int paramInt2) {
/* 573 */     if (this.mv != null) {
/* 574 */       this.mv.visitIincInsn(paramInt1, paramInt2);
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
/*     */   public void visitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label... paramVarArgs) {
/* 589 */     if (this.mv != null) {
/* 590 */       this.mv.visitTableSwitchInsn(paramInt1, paramInt2, paramLabel, paramVarArgs);
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
/*     */   public void visitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfint, Label[] paramArrayOfLabel) {
/* 603 */     if (this.mv != null) {
/* 604 */       this.mv.visitLookupSwitchInsn(paramLabel, paramArrayOfint, paramArrayOfLabel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitMultiANewArrayInsn(String paramString, int paramInt) {
/* 615 */     if (this.mv != null) {
/* 616 */       this.mv.visitMultiANewArrayInsn(paramString, paramInt);
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
/*     */   public AnnotationVisitor visitInsnAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 641 */     if (this.api < 327680) {
/* 642 */       throw new UnsupportedOperationException("This feature requires ASM5");
/*     */     }
/* 644 */     if (this.mv != null) {
/* 645 */       return this.mv.visitInsnAnnotation(paramInt, paramTypePath, paramString, paramBoolean);
/*     */     }
/* 647 */     return null;
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
/*     */   public void visitTryCatchBlock(Label paramLabel1, Label paramLabel2, Label paramLabel3, String paramString) {
/* 668 */     if (this.mv != null) {
/* 669 */       this.mv.visitTryCatchBlock(paramLabel1, paramLabel2, paramLabel3, paramString);
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
/*     */   public AnnotationVisitor visitTryCatchAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
/* 690 */     if (this.api < 327680) {
/* 691 */       throw new UnsupportedOperationException("This feature requires ASM5");
/*     */     }
/* 693 */     if (this.mv != null) {
/* 694 */       return this.mv.visitTryCatchAnnotation(paramInt, paramTypePath, paramString, paramBoolean);
/*     */     }
/* 696 */     return null;
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
/*     */   public void visitLocalVariable(String paramString1, String paramString2, String paramString3, Label paramLabel1, Label paramLabel2, int paramInt) {
/* 720 */     if (this.mv != null) {
/* 721 */       this.mv.visitLocalVariable(paramString1, paramString2, paramString3, paramLabel1, paramLabel2, paramInt);
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
/*     */   public AnnotationVisitor visitLocalVariableAnnotation(int paramInt, TypePath paramTypePath, Label[] paramArrayOfLabel1, Label[] paramArrayOfLabel2, int[] paramArrayOfint, String paramString, boolean paramBoolean) {
/* 753 */     if (this.api < 327680) {
/* 754 */       throw new UnsupportedOperationException("This feature requires ASM5");
/*     */     }
/* 756 */     if (this.mv != null) {
/* 757 */       return this.mv.visitLocalVariableAnnotation(paramInt, paramTypePath, paramArrayOfLabel1, paramArrayOfLabel2, paramArrayOfint, paramString, paramBoolean);
/*     */     }
/*     */     
/* 760 */     return null;
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
/*     */   public void visitLineNumber(int paramInt, Label paramLabel) {
/* 773 */     if (this.mv != null) {
/* 774 */       this.mv.visitLineNumber(paramInt, paramLabel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitMaxs(int paramInt1, int paramInt2) {
/* 785 */     if (this.mv != null) {
/* 786 */       this.mv.visitMaxs(paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitEnd() {
/* 795 */     if (this.mv != null)
/* 796 */       this.mv.visitEnd(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\MethodVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */