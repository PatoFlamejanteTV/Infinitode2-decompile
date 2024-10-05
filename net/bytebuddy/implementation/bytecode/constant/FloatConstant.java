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
/*     */ public enum FloatConstant
/*     */   implements StackManipulation
/*     */ {
/*  33 */   ZERO(11),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   ONE(12),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   TWO(13);
/*     */   private static final StackManipulation.Size SIZE;
/*     */   private final int opcode;
/*     */   
/*     */   static {
/*  48 */     SIZE = StackSize.SINGLE.toIncreasingSize();
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
/*     */   FloatConstant(int paramInt1) {
/*  61 */     this.opcode = paramInt1;
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
/*     */   public static StackManipulation forValue(float paramFloat) {
/*  73 */     if (paramFloat == 0.0F)
/*  74 */       return ZERO; 
/*  75 */     if (paramFloat == 1.0F)
/*  76 */       return ONE; 
/*  77 */     if (paramFloat == 2.0F) {
/*  78 */       return TWO;
/*     */     }
/*  80 */     return (StackManipulation)new ConstantPool(paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid() {
/*  88 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/*  95 */     paramMethodVisitor.visitInsn(this.opcode);
/*  96 */     return SIZE;
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
/*     */     private final float value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ConstantPool(float param1Float) {
/* 116 */       this.value = param1Float;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 123 */       param1MethodVisitor.visitLdcInsn(Float.valueOf(this.value));
/* 124 */       return FloatConstant.a();
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(Float.compare(this.value, ((ConstantPool)param1Object).value) != 0))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + Float.floatToIntBits(this.value);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\FloatConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */