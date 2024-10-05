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
/*    */ public enum Division
/*    */   implements StackManipulation
/*    */ {
/* 30 */   INTEGER(108, StackSize.SINGLE),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 35 */   LONG(109, StackSize.DOUBLE),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 40 */   FLOAT(110, StackSize.SINGLE),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   DOUBLE(111, StackSize.DOUBLE);
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
/*    */   Division(int paramInt1, StackSize paramStackSize) {
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


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\Division.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */