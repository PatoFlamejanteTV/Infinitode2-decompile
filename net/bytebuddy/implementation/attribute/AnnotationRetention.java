/*    */ package net.bytebuddy.implementation.attribute;
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
/*    */ public enum AnnotationRetention
/*    */ {
/* 29 */   ENABLED(true),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   DISABLED(false);
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
/*    */   AnnotationRetention(boolean paramBoolean) {
/* 47 */     this.enabled = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static AnnotationRetention of(boolean paramBoolean) {
/* 57 */     return paramBoolean ? ENABLED : DISABLED;
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
/* 68 */     return this.enabled;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\attribute\AnnotationRetention.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */