/*    */ package net.bytebuddy.implementation.bytecode.assign.primitive;
/*    */ 
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.description.type.TypeDefinition;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ import net.bytebuddy.implementation.bytecode.Removal;
/*    */ import net.bytebuddy.implementation.bytecode.StackManipulation;
/*    */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
/*    */ import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
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
/*    */ @Enhance
/*    */ public class VoidAwareAssigner
/*    */   implements Assigner
/*    */ {
/*    */   private final Assigner chained;
/*    */   
/*    */   public VoidAwareAssigner(Assigner paramAssigner) {
/* 51 */     this.chained = paramAssigner;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StackManipulation assign(TypeDescription.Generic paramGeneric1, TypeDescription.Generic paramGeneric2, Assigner.Typing paramTyping) {
/* 58 */     if (paramGeneric1.represents(void.class) && paramGeneric2.represents(void.class))
/* 59 */       return (StackManipulation)StackManipulation.Trivial.INSTANCE; 
/* 60 */     if (paramGeneric1.represents(void.class)) {
/* 61 */       if (paramTyping.isDynamic())
/* 62 */         return DefaultValue.of((TypeDefinition)paramGeneric2);  return (StackManipulation)StackManipulation.Illegal.INSTANCE;
/*    */     } 
/* 64 */     if (paramGeneric2.represents(void.class)) {
/* 65 */       return Removal.of((TypeDefinition)paramGeneric1);
/*    */     }
/* 67 */     return this.chained.assign(paramGeneric1, paramGeneric2, paramTyping);
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!!this.chained.equals(((VoidAwareAssigner)paramObject).chained))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.chained.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\assign\primitive\VoidAwareAssigner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */