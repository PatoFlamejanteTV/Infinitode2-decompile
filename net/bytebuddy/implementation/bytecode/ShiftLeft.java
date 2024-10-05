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
/*    */ public enum ShiftLeft
/*    */   implements StackManipulation
/*    */ {
/* 30 */   INTEGER(120, StackSize.SINGLE),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   LONG(121, StackSize.DOUBLE);
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
/*    */   ShiftLeft(int paramInt1, StackSize paramStackSize) {
/* 54 */     this.opcode = paramInt1;
/* 55 */     this.stackSize = paramStackSize;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isValid() {
/* 62 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 69 */     paramMethodVisitor.visitInsn(this.opcode);
/* 70 */     return this.stackSize.toDecreasingSize();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\ShiftLeft.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */