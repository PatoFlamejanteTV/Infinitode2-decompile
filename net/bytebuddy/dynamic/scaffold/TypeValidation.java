/*    */ package net.bytebuddy.dynamic.scaffold;
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
/*    */ public enum TypeValidation
/*    */ {
/* 36 */   ENABLED(true),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 41 */   DISABLED(false);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean enabled;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   TypeValidation(boolean paramBoolean) {
/* 54 */     this.enabled = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TypeValidation of(boolean paramBoolean) {
/* 64 */     return paramBoolean ? ENABLED : DISABLED;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isEnabled() {
/* 75 */     return this.enabled;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\scaffold\TypeValidation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */