/*    */ package net.bytebuddy.implementation.bind;
/*    */ 
/*    */ import net.bytebuddy.description.method.MethodDescription;
/*    */ import net.bytebuddy.description.type.TypeDescription;
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
/*    */ public enum DeclaringTypeResolver
/*    */   implements MethodDelegationBinder.AmbiguityResolver
/*    */ {
/* 30 */   INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription paramMethodDescription, MethodDelegationBinder.MethodBinding paramMethodBinding1, MethodDelegationBinder.MethodBinding paramMethodBinding2) {
/* 38 */     TypeDescription typeDescription1 = paramMethodBinding1.getTarget().getDeclaringType().asErasure();
/* 39 */     TypeDescription typeDescription2 = paramMethodBinding2.getTarget().getDeclaringType().asErasure();
/* 40 */     if (typeDescription1.equals(typeDescription2))
/* 41 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS; 
/* 42 */     if (typeDescription1.isAssignableFrom(typeDescription2))
/* 43 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT; 
/* 44 */     if (typeDescription1.isAssignableTo(typeDescription2)) {
/* 45 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
/*    */     }
/* 47 */     return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\DeclaringTypeResolver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */