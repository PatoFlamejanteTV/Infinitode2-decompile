/*    */ package net.bytebuddy.utility.visitor;
/*    */ 
/*    */ import net.bytebuddy.jar.asm.Label;
/*    */ import net.bytebuddy.jar.asm.MethodVisitor;
/*    */ import net.bytebuddy.utility.OpenedClassReader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LineNumberPrependingMethodVisitor
/*    */   extends ExceptionTableSensitiveMethodVisitor
/*    */ {
/*    */   private final Label startOfMethod;
/*    */   private boolean prependLineNumber;
/*    */   
/*    */   public LineNumberPrependingMethodVisitor(MethodVisitor paramMethodVisitor) {
/* 43 */     super(OpenedClassReader.ASM_API, paramMethodVisitor);
/* 44 */     this.startOfMethod = new Label();
/* 45 */     this.prependLineNumber = true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void onAfterExceptionTable() {
/* 50 */     visitLabel(this.startOfMethod);
/*    */   }
/*    */ 
/*    */   
/*    */   public void visitLineNumber(int paramInt, Label paramLabel) {
/* 55 */     if (this.prependLineNumber) {
/* 56 */       paramLabel = this.startOfMethod;
/* 57 */       this.prependLineNumber = false;
/*    */     } 
/* 59 */     super.visitLineNumber(paramInt, paramLabel);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\visitor\LineNumberPrependingMethodVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */