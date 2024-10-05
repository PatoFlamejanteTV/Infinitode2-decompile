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
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum IntegerConstant
/*     */   implements StackManipulation
/*     */ {
/*  36 */   MINUS_ONE(2),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   ZERO(3),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   ONE(4),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   TWO(5),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   THREE(6),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   FOUR(7),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   FIVE(8);
/*     */   private static final StackManipulation.Size SIZE;
/*     */   private final int opcode;
/*     */   
/*     */   static {
/*  71 */     SIZE = StackSize.SINGLE.toIncreasingSize();
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
/*     */   IntegerConstant(int paramInt1) {
/*  84 */     this.opcode = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackManipulation forValue(boolean paramBoolean) {
/*  94 */     return paramBoolean ? ONE : ZERO;
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
/*     */   public static StackManipulation forValue(int paramInt) {
/* 106 */     switch (paramInt) {
/*     */       case -1:
/* 108 */         return MINUS_ONE;
/*     */       case 0:
/* 110 */         return ZERO;
/*     */       case 1:
/* 112 */         return ONE;
/*     */       case 2:
/* 114 */         return TWO;
/*     */       case 3:
/* 116 */         return THREE;
/*     */       case 4:
/* 118 */         return FOUR;
/*     */       case 5:
/* 120 */         return FIVE;
/*     */     } 
/* 122 */     if (paramInt >= -128 && paramInt <= 127)
/* 123 */       return (StackManipulation)new SingleBytePush((byte)paramInt); 
/* 124 */     if (paramInt >= -32768 && paramInt <= 32767) {
/* 125 */       return (StackManipulation)new TwoBytePush((short)paramInt);
/*     */     }
/* 127 */     return (StackManipulation)new ConstantPool(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isValid() {
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 143 */     paramMethodVisitor.visitInsn(this.opcode);
/* 144 */     return SIZE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class SingleBytePush
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final byte value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected SingleBytePush(byte param1Byte) {
/* 165 */       this.value = param1Byte;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 172 */       param1MethodVisitor.visitIntInsn(16, this.value);
/* 173 */       return IntegerConstant.a();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((SingleBytePush)param1Object).value))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.value;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Enhance
/*     */   protected static class TwoBytePush
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final short value;
/*     */     
/*     */     protected TwoBytePush(short param1Short) {
/* 195 */       this.value = param1Short;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 202 */       param1MethodVisitor.visitIntInsn(17, this.value);
/* 203 */       return IntegerConstant.a();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((TwoBytePush)param1Object).value))));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.value;
/*     */     }
/*     */   }
/*     */   
/*     */   @Enhance
/*     */   protected static class ConstantPool
/*     */     extends StackManipulation.AbstractBase
/*     */   {
/*     */     private final int value;
/*     */     
/*     */     protected ConstantPool(int param1Int) {
/* 224 */       this.value = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackManipulation.Size apply(MethodVisitor param1MethodVisitor, Implementation.Context param1Context) {
/* 231 */       param1MethodVisitor.visitLdcInsn(Integer.valueOf(this.value));
/* 232 */       return IntegerConstant.a();
/*     */     }
/*     */     
/*     */     public boolean equals(@MaybeNull Object param1Object) {
/*     */       return (this == param1Object) ? true : ((param1Object == null) ? false : ((getClass() != param1Object.getClass()) ? false : (!(this.value != ((ConstantPool)param1Object).value))));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return getClass().hashCode() * 31 + this.value;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\IntegerConstant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */