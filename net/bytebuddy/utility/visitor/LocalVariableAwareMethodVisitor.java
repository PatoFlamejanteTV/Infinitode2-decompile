/*    */ package net.bytebuddy.utility.visitor;
/*    */ 
/*    */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*    */ import net.bytebuddy.description.method.MethodDescription;
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
/*    */ public class LocalVariableAwareMethodVisitor
/*    */   extends MethodVisitor
/*    */ {
/*    */   private int freeOffset;
/*    */   
/*    */   public LocalVariableAwareMethodVisitor(MethodVisitor paramMethodVisitor, MethodDescription paramMethodDescription) {
/* 41 */     super(OpenedClassReader.ASM_API, paramMethodVisitor);
/* 42 */     this.freeOffset = paramMethodDescription.getStackSize();
/*    */   }
/*    */ 
/*    */   
/*    */   @SuppressFBWarnings(value = {"SF_SWITCH_NO_DEFAULT"}, justification = "No action required on default option.")
/*    */   public void visitVarInsn(int paramInt1, int paramInt2) {
/* 48 */     switch (paramInt1) {
/*    */       case 54:
/*    */       case 56:
/*    */       case 58:
/* 52 */         this.freeOffset = Math.max(this.freeOffset, paramInt2 + 1);
/*    */         break;
/*    */       case 55:
/*    */       case 57:
/* 56 */         this.freeOffset = Math.max(this.freeOffset, paramInt2 + 2);
/*    */         break;
/*    */     } 
/* 59 */     super.visitVarInsn(paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFreeOffset() {
/* 68 */     return this.freeOffset;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\visitor\LocalVariableAwareMethodVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */