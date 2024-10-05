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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum MethodNameEqualityResolver
/*    */   implements MethodDelegationBinder.AmbiguityResolver
/*    */ {
/* 34 */   INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription paramMethodDescription, MethodDelegationBinder.MethodBinding paramMethodBinding1, MethodDelegationBinder.MethodBinding paramMethodBinding2) {
/* 42 */     boolean bool2 = paramMethodBinding1.getTarget().getName().equals(paramMethodDescription.getName());
/* 43 */     boolean bool1 = paramMethodBinding2.getTarget().getName().equals(paramMethodDescription.getName());
/* 44 */     if (bool2 ^ bool1) {
/* 45 */       return bool2 ? MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
/*    */     }
/* 47 */     return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bind\MethodNameEqualityResolver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */