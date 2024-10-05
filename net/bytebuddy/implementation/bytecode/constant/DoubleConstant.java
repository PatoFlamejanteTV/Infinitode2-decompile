/*     */ package net.bytebuddy.implementation.bytecode.constant;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.implementation.bytecode.StackSize;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.utility.nullability.MaybeNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum DoubleConstant
/*     */   implements StackManipulation
/*     */ {
/*  33 */   ZERO(14),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   ONE(15);
/*     */   private static final StackManipulation.Size SIZE;
/*     */   private final int opcode;
/*     */   
/*     */   static {
/*  43 */     SIZE = StackSize.DOUBLE.toIncreasingSize();
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
/*     */   DoubleConstant(int paramInt1) {
/*  56 */     this.opcode = paramInt1;
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
/*     */   public static StackManipulation forValue(double paramDouble) {
/*  68 */     if (paramDouble == 0.0D)
/*  69 */       return ZERO; 
/*  70 */     if (paramDouble == 1.0D) {
/*  71 */       return ONE;
/*     */     }
/*  73 */     return (StackManipulation)new ConstantPool(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid() {
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/*  88 */     paramMethodVisitor.visitInsn(this.opcode);
/*  89 */     return SIZE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class ConstantPool
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final double value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ConstantPool(double param1Double) {
/* 109 */       this.value = param1Double;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 116 */       param1MethodVisitor.visitLdcInsn(Double.valueOf(this.value));
/* 117 */       return DoubleConstant.a();
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(Double.compare(this.value, ((ConstantPool)param1Object).value) != 0))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + (int)(Double.doubleToLongBits(this.value) ^ Double.doubleToLongBits(this.value) >>> 32L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\DoubleConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */