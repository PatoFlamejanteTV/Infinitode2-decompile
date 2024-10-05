/*     */ package net.bytebuddy.implementation.bytecode;
/*     */ 
/*     */ import net.bytebuddy.description.type.TypeDefinition;
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
/*     */ public enum Removal
/*     */   implements StackManipulation
/*     */ {
/*  31 */   ZERO(StackSize.ZERO, 0)
/*     */   {
/*     */     public final StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/*  34 */       return StackManipulation.Size.ZERO;
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   SINGLE(StackSize.SINGLE, 87),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   DOUBLE(StackSize.DOUBLE, 88);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StackManipulation.Size size;
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
/*     */   Removal(StackSize paramStackSize, int paramInt1) {
/*  65 */     this.size = paramStackSize.toDecreasingSize();
/*  66 */     this.opcode = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation of(TypeDefinition paramTypeDefinition) {
/*  76 */     switch (null.a[paramTypeDefinition.getStackSize().ordinal()]) {
/*     */       case 1:
/*  78 */         return SINGLE;
/*     */       case 2:
/*  80 */         return DOUBLE;
/*     */       case 3:
/*  82 */         return ZERO;
/*     */     } 
/*  84 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/*  99 */     paramMethodVisitor.visitInsn(this.opcode);
/* 100 */     return this.size;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\Removal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */