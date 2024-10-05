/*    */ package net.bytebuddy.implementation.bytecode.member;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.implementation.Implementation;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.jar.asm.MethodVisitor;
/*    */ import net.bytebuddy.utility.JavaConstant;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Enhance
/*    */ public class HandleInvocation
/*    */   extends StackManipulation.AbstractBase
/*    */ {
/*    */   private static final String METHOD_HANDLE_NAME = "java/lang/invoke/MethodHandle";
/*    */   private static final String INVOKE_EXACT = "invokeExact";
/*    */   private final JavaConstant.MethodType methodType;
/*    */   
/*    */   public HandleInvocation(JavaConstant.MethodType paramMethodType) {
/* 52 */     this.methodType = paramMethodType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 59 */     paramMethodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandle", "invokeExact", this.methodType.getDescriptor(), false);
/* 60 */     int i = this.methodType.getReturnType().getStackSize().getSize() - this.methodType.getParameterTypes().getStackSize();
/* 61 */     return new StackManipulation.Size(i, Math.max(i, 0));
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.methodType.equals(((HandleInvocation)paramObject).methodType))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.methodType.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\member\HandleInvocation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */