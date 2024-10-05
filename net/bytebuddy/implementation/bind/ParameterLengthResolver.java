/*    */ package net.bytebuddy.implementation.bind;
/*    */ 
/*    */ import net.bytebuddy.description.method.MethodDescription;
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
/*    */ public enum ParameterLengthResolver
/*    */   implements MethodDelegationBinder.AmbiguityResolver
/*    */ {
/* 29 */   INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription paramMethodDescription, MethodDelegationBinder.MethodBinding paramMethodBinding1, MethodDelegationBinder.MethodBinding paramMethodBinding2) {
/* 37 */     int i = paramMethodBinding1.getTarget().getParameters().size();
/* 38 */     int j = paramMethodBinding2.getTarget().getParameters().size();
/* 39 */     if (i == j)
/* 40 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS; 
/* 41 */     if (i < j) {
/* 42 */       return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
/*    */     }
/* 44 */     return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\ParameterLengthResolver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */