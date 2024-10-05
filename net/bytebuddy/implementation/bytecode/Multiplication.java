/*    */ package net.bytebuddy.implementation.bytecode;
/*    */ 
/*    */ import net.bytebuddy.implementation.Implementation;
/*    */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*    */ public enum Multiplication
/*    */   implements StackManipulation
/*    */ {
/* 30 */   INTEGER(104, StackSize.SINGLE),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   LONG(105, StackSize.DOUBLE),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 40 */   FLOAT(106, StackSize.SINGLE),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   DOUBLE(107, StackSize.DOUBLE);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final int opcode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final StackSize stackSize;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   Multiplication(int paramInt1, StackSize paramStackSize) {
/* 64 */     this.opcode = paramInt1;
/* 65 */     this.stackSize = paramStackSize;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isValid() {
/* 72 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 79 */     paramMethodVisitor.visitInsn(this.opcode);
/* 80 */     return this.stackSize.toDecreasingSize();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\Multiplication.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */