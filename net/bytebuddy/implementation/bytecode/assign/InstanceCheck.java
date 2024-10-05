/*    */ package net.bytebuddy.implementation.bytecode.assign;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.implementation.Implementation;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.jar.asm.MethodVisitor;
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
/*    */ @Enhance
/*    */ public class InstanceCheck
/*    */   extends StackManipulation.AbstractBase
/*    */ {
/*    */   private final TypeDescription typeDescription;
/*    */   
/*    */   protected InstanceCheck(TypeDescription paramTypeDescription) {
/* 42 */     this.typeDescription = paramTypeDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static StackManipulation of(TypeDescription paramTypeDescription) {
/* 52 */     if (paramTypeDescription.isPrimitive()) {
/* 53 */       throw new IllegalArgumentException("Cannot check an instance against a primitive type: " + paramTypeDescription);
/*    */     }
/* 55 */     return (StackManipulation)new InstanceCheck(paramTypeDescription);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 62 */     paramMethodVisitor.visitTypeInsn(193, this.typeDescription.getInternalName());
/* 63 */     return StackManipulation.Size.ZERO;
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.typeDescription.equals(((InstanceCheck)paramObject).typeDescription))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\InstanceCheck.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */