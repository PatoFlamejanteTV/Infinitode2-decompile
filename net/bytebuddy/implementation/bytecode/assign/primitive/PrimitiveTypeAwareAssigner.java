/*    */ package net.bytebuddy.implementation.bytecode.assign.primitive;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Enhance
/*    */ public class PrimitiveTypeAwareAssigner
/*    */   implements Assigner
/*    */ {
/*    */   private final Assigner referenceTypeAwareAssigner;
/*    */   
/*    */   public PrimitiveTypeAwareAssigner(Assigner paramAssigner) {
/* 54 */     this.referenceTypeAwareAssigner = paramAssigner;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StackManipulation assign(TypeDescription.Generic paramGeneric1, TypeDescription.Generic paramGeneric2, Assigner.Typing paramTyping) {
/* 61 */     if (paramGeneric1.isPrimitive() && paramGeneric2.isPrimitive())
/* 62 */       return PrimitiveWideningDelegate.forPrimitive((TypeDefinition)paramGeneric1).widenTo((TypeDefinition)paramGeneric2); 
/* 63 */     if (paramGeneric1.isPrimitive())
/* 64 */       return PrimitiveBoxingDelegate.forPrimitive((TypeDefinition)paramGeneric1).assignBoxedTo(paramGeneric2, this.referenceTypeAwareAssigner, paramTyping); 
/* 65 */     if (paramGeneric2.isPrimitive()) {
/* 66 */       return PrimitiveUnboxingDelegate.forReferenceType((TypeDefinition)paramGeneric1).assignUnboxedTo(paramGeneric2, this.referenceTypeAwareAssigner, paramTyping);
/*    */     }
/* 68 */     return this.referenceTypeAwareAssigner.assign(paramGeneric1, paramGeneric2, paramTyping);
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.referenceTypeAwareAssigner.equals(((PrimitiveTypeAwareAssigner)paramObject).referenceTypeAwareAssigner))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.referenceTypeAwareAssigner.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\primitive\PrimitiveTypeAwareAssigner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */