/*    */ package net.bytebuddy.implementation.bytecode;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.implementation.Implementation;
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
/*    */ public class TypeCreation
/*    */   extends StackManipulation.AbstractBase
/*    */ {
/*    */   private final TypeDescription typeDescription;
/*    */   
/*    */   protected TypeCreation(TypeDescription paramTypeDescription) {
/* 41 */     this.typeDescription = paramTypeDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static StackManipulation of(TypeDescription paramTypeDescription) {
/* 51 */     if (paramTypeDescription.isArray() || paramTypeDescription.isPrimitive() || paramTypeDescription.isAbstract()) {
/* 52 */       throw new IllegalArgumentException(paramTypeDescription + " is not instantiable");
/*    */     }
/* 54 */     return new TypeCreation(paramTypeDescription);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StackManipulation.Size apply(MethodVisitor paramMethodVisitor, Implementation.Context paramContext) {
/* 61 */     paramMethodVisitor.visitTypeInsn(187, this.typeDescription.getInternalName());
/* 62 */     return new StackManipulation.Size(1, 1);
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.typeDescription.equals(((TypeCreation)paramObject).typeDescription))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.typeDescription.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\TypeCreation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */