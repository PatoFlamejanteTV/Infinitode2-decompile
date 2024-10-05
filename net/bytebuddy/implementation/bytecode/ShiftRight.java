/*     */ package net.bytebuddy.implementation.bytecode;
/*     */ 
/*     */ import net.bytebuddy.implementation.Implementation;
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
/*     */ public enum ShiftRight
/*     */   implements StackManipulation
/*     */ {
/*  30 */   INTEGER(122, StackSize.SINGLE, Unsigned.INTEGER),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   LONG(123, StackSize.DOUBLE, Unsigned.LONG);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int opcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackSize stackSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation unsigned;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ShiftRight(int paramInt1, StackSize paramStackSize, StackManipulation paramStackManipulation) {
/*  60 */     this.opcode = paramInt1;
/*  61 */     this.stackSize = paramStackSize;
/*  62 */     this.unsigned = paramStackManipulation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation toUnsigned() {
/*  71 */     return this.unsigned;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid() {
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/*  85 */     paramMethodVisitor.visitInsn(this.opcode);
/*  86 */     return this.stackSize.toDecreasingSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum Unsigned
/*     */     implements StackManipulation
/*     */   {
/*  97 */     INTEGER(124, StackSize.SINGLE),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     LONG(125, StackSize.DOUBLE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int opcode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final StackSize stackSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Unsigned(int param1Int1, StackSize param1StackSize) {
/* 121 */       this.opcode = param1Int1;
/* 122 */       this.stackSize = param1StackSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isValid() {
/* 129 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 136 */       param1MethodVisitor.visitInsn(this.opcode);
/* 137 */       return this.stackSize.toDecreasingSize();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\ShiftRight.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */