/*    */ package net.bytebuddy.implementation.bytecode.assign.reference;
/*    */ 
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*    */ import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
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
/*    */ public enum ReferenceTypeAwareAssigner
/*    */   implements Assigner
/*    */ {
/* 32 */   INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final StackManipulation assign(TypeDescription.Generic paramGeneric1, TypeDescription.Generic paramGeneric2, Assigner.Typing paramTyping) {
/* 38 */     if (paramGeneric1.isPrimitive() || paramGeneric2.isPrimitive()) {
/* 39 */       return paramGeneric1.equals(paramGeneric2) ? (StackManipulation)StackManipulation.Trivial.INSTANCE : (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*    */     }
/*    */     
/* 42 */     if (paramGeneric1.asErasure().isAssignableTo(paramGeneric2.asErasure()))
/* 43 */       return (StackManipulation)StackManipulation.Trivial.INSTANCE; 
/* 44 */     if (paramTyping.isDynamic()) {
/* 45 */       return TypeCasting.to((TypeDefinition)paramGeneric2);
/*    */     }
/* 47 */     return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\reference\ReferenceTypeAwareAssigner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */