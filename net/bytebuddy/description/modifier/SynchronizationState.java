/*    */ package net.bytebuddy.description.modifier;
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
/*    */ public enum SynchronizationState
/*    */   implements ModifierContributor.ForMethod
/*    */ {
/* 28 */   PLAIN(0),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   SYNCHRONIZED(32);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final int mask;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   SynchronizationState(int paramInt1) {
/* 46 */     this.mask = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getMask() {
/* 53 */     return this.mask;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getRange() {
/* 60 */     return 32;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isDefault() {
/* 67 */     return (this == PLAIN);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isSynchronized() {
/* 76 */     return (this == SYNCHRONIZED);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\modifier\SynchronizationState.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */