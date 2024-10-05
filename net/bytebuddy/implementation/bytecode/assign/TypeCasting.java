/*    */ package net.bytebuddy.implementation.bytecode.assign;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.implementation.Implementation;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.implementation.bytecode.StackSize;
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
/*    */ 
/*    */ @Enhance
/*    */ public class TypeCasting
/*    */   extends StackManipulation.AbstractBase
/*    */ {
/*    */   private final TypeDescription typeDescription;
/*    */   
/*    */   protected TypeCasting(TypeDescription paramTypeDescription) {
/* 45 */     this.typeDescription = paramTypeDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static StackManipulation to(TypeDefinition paramTypeDefinition) {
/* 55 */     if (paramTypeDefinition.isPrimitive()) {
/* 56 */       throw new IllegalArgumentException("Cannot cast to primitive type: " + paramTypeDefinition);
/*    */     }
/* 58 */     return (StackManipulation)new TypeCasting(paramTypeDefinition.asErasure());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 65 */     paramMethodVisitor.visitTypeInsn(192, this.typeDescription.getInternalName());
/* 66 */     return StackSize.ZERO.toIncreasingSize();
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.typeDescription.equals(((TypeCasting)paramObject).typeDescription))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\TypeCasting.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */