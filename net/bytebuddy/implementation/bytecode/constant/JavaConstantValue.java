/*     */ package net.bytebuddy.implementation.bytecode.constant;
/*     */ 
/*     */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*     */ import net.bytebuddy.description.type.TypeDescription;
/*     */ import net.bytebuddy.implementation.Implementation;
/*     */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*     */ import net.bytebuddy.jar.asm.ConstantDynamic;
/*     */ import net.bytebuddy.jar.asm.Handle;
/*     */ import net.bytebuddy.jar.asm.MethodVisitor;
/*     */ import net.bytebuddy.jar.asm.Type;
/*     */ import net.bytebuddy.utility.JavaConstant;
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
/*     */ 
/*     */ @Enhance
/*     */ public class JavaConstantValue
/*     */   extends StackManipulation.AbstractBase
/*     */ {
/*     */   private final JavaConstant constant;
/*     */   
/*     */   public JavaConstantValue(JavaConstant paramJavaConstant) {
/*  45 */     this.constant = paramJavaConstant;
/*     */   }
/*     */   public boolean equals(@MaybeNull Object paramObject) {
/*     */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.constant.equals(((JavaConstantValue)paramObject).constant))));
/*     */   }
/*     */   
/*     */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/*  52 */     paramMethodVisitor.visitLdcInsn(this.constant.accept(Visitor.INSTANCE));
/*  53 */     return this.constant.getTypeDescription().getStackSize().toIncreasingSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     return getClass().hashCode() * 31 + this.constant.hashCode();
/*     */   }
/*     */   
/*     */   public enum Visitor
/*     */     implements JavaConstant.Visitor<Object>
/*     */   {
/*  64 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object onValue(JavaConstant.Simple<?> param1Simple) {
/*  70 */       return param1Simple.getValue();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Type onType(JavaConstant.Simple<TypeDescription> param1Simple) {
/*  77 */       return Type.getType(((TypeDescription)param1Simple.getValue()).getDescriptor());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Type onMethodType(JavaConstant.MethodType param1MethodType) {
/*  84 */       StringBuilder stringBuilder = new StringBuilder("(");
/*  85 */       for (TypeDescription typeDescription : param1MethodType.getParameterTypes()) {
/*  86 */         stringBuilder.append(typeDescription.getDescriptor());
/*     */       }
/*  88 */       return Type.getMethodType(stringBuilder.append(')').append(param1MethodType.getReturnType().getDescriptor()).toString());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Handle onMethodHandle(JavaConstant.MethodHandle param1MethodHandle) {
/*  95 */       return new Handle(param1MethodHandle.getHandleType().getIdentifier(), param1MethodHandle
/*  96 */           .getOwnerType().getInternalName(), param1MethodHandle
/*  97 */           .getName(), param1MethodHandle
/*  98 */           .getDescriptor(), param1MethodHandle
/*  99 */           .getOwnerType().isInterface());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ConstantDynamic onDynamic(JavaConstant.Dynamic param1Dynamic) {
/* 106 */       Object[] arrayOfObject = new Object[param1Dynamic.getArguments().size()];
/* 107 */       for (byte b = 0; b < arrayOfObject.length; b++) {
/* 108 */         arrayOfObject[b] = ((JavaConstant)param1Dynamic.getArguments().get(b)).accept(this);
/*     */       }
/* 110 */       return new ConstantDynamic(param1Dynamic.getName(), param1Dynamic
/* 111 */           .getTypeDescription().getDescriptor(), 
/* 112 */           onMethodHandle(param1Dynamic.getBootstrap()), arrayOfObject);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\constant\JavaConstantValue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */