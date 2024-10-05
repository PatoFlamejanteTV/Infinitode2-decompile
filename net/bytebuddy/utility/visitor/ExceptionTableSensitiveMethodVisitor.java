/*     */ package net.bytebuddy.utility.visitor;
/*     */ 
/*     */ import net.bytebuddy.jar.asm.Handle;
/*     */ import net.bytebuddy.jar.asm.Label;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ExceptionTableSensitiveMethodVisitor
/*     */   extends MethodVisitor
/*     */ {
/*     */   private boolean trigger;
/*     */   
/*     */   protected ExceptionTableSensitiveMethodVisitor(int paramInt, MethodVisitor paramMethodVisitor) {
/*  39 */     super(paramInt, paramMethodVisitor);
/*  40 */     this.trigger = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void considerEndOfExceptionTable() {
/*  47 */     if (this.trigger) {
/*  48 */       this.trigger = false;
/*  49 */       onAfterExceptionTable();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void onAfterExceptionTable();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2) {
/*  62 */     considerEndOfExceptionTable();
/*  63 */     onVisitFrame(paramInt1, paramInt2, paramArrayOfObject1, paramInt3, paramArrayOfObject2);
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
/*     */   protected void onVisitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2) {
/*  76 */     super.visitFrame(paramInt1, paramInt2, paramArrayOfObject1, paramInt3, paramArrayOfObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitLabel(Label paramLabel) {
/*  81 */     considerEndOfExceptionTable();
/*  82 */     onVisitLabel(paramLabel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitLabel(Label paramLabel) {
/*  92 */     super.visitLabel(paramLabel);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitIntInsn(int paramInt1, int paramInt2) {
/*  97 */     considerEndOfExceptionTable();
/*  98 */     onVisitIntInsn(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitIntInsn(int paramInt1, int paramInt2) {
/* 108 */     super.visitIntInsn(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitVarInsn(int paramInt1, int paramInt2) {
/* 113 */     considerEndOfExceptionTable();
/* 114 */     onVisitVarInsn(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitVarInsn(int paramInt1, int paramInt2) {
/* 124 */     super.visitVarInsn(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitTypeInsn(int paramInt, String paramString) {
/* 129 */     considerEndOfExceptionTable();
/* 130 */     onVisitTypeInsn(paramInt, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitTypeInsn(int paramInt, String paramString) {
/* 140 */     super.visitTypeInsn(paramInt, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 145 */     considerEndOfExceptionTable();
/* 146 */     onVisitFieldInsn(paramInt, paramString1, paramString2, paramString3);
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
/*     */   protected void onVisitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 158 */     super.visitFieldInsn(paramInt, paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 164 */     considerEndOfExceptionTable();
/* 165 */     onVisitMethodInsn(paramInt, paramString1, paramString2, paramString3);
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
/*     */   protected void onVisitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 180 */     super.visitMethodInsn(paramInt, paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 185 */     considerEndOfExceptionTable();
/* 186 */     onVisitMethodInsn(paramInt, paramString1, paramString2, paramString3, paramBoolean);
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
/*     */   protected void onVisitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 199 */     super.visitMethodInsn(paramInt, paramString1, paramString2, paramString3, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/* 204 */     considerEndOfExceptionTable();
/* 205 */     onVisitInvokeDynamicInsn(paramString1, paramString2, paramHandle, paramVarArgs);
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
/*     */   protected void onVisitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object... paramVarArgs) {
/* 217 */     super.visitInvokeDynamicInsn(paramString1, paramString2, paramHandle, paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitJumpInsn(int paramInt, Label paramLabel) {
/* 222 */     considerEndOfExceptionTable();
/* 223 */     onVisitJumpInsn(paramInt, paramLabel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitJumpInsn(int paramInt, Label paramLabel) {
/* 233 */     super.visitJumpInsn(paramInt, paramLabel);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitLdcInsn(Object paramObject) {
/* 238 */     considerEndOfExceptionTable();
/* 239 */     onVisitLdcInsn(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitLdcInsn(Object paramObject) {
/* 248 */     super.visitLdcInsn(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitIincInsn(int paramInt1, int paramInt2) {
/* 253 */     considerEndOfExceptionTable();
/* 254 */     onVisitIincInsn(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitIincInsn(int paramInt1, int paramInt2) {
/* 264 */     super.visitIincInsn(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label... paramVarArgs) {
/* 269 */     considerEndOfExceptionTable();
/* 270 */     onVisitTableSwitchInsn(paramInt1, paramInt2, paramLabel, paramVarArgs);
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
/*     */   protected void onVisitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label... paramVarArgs) {
/* 282 */     super.visitTableSwitchInsn(paramInt1, paramInt2, paramLabel, paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfint, Label[] paramArrayOfLabel) {
/* 287 */     considerEndOfExceptionTable();
/* 288 */     onVisitLookupSwitchInsn(paramLabel, paramArrayOfint, paramArrayOfLabel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfint, Label[] paramArrayOfLabel) {
/* 299 */     super.visitLookupSwitchInsn(paramLabel, paramArrayOfint, paramArrayOfLabel);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitMultiANewArrayInsn(String paramString, int paramInt) {
/* 304 */     considerEndOfExceptionTable();
/* 305 */     onVisitMultiANewArrayInsn(paramString, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitMultiANewArrayInsn(String paramString, int paramInt) {
/* 315 */     super.visitMultiANewArrayInsn(paramString, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void visitInsn(int paramInt) {
/* 320 */     considerEndOfExceptionTable();
/* 321 */     onVisitInsn(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onVisitInsn(int paramInt) {
/* 330 */     super.visitInsn(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\visitor\ExceptionTableSensitiveMethodVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */