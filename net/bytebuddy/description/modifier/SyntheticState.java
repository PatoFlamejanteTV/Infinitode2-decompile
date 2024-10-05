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
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum SyntheticState
/*    */   implements ModifierContributor.ForField, ModifierContributor.ForMethod, ModifierContributor.ForParameter, ModifierContributor.ForType
/*    */ {
/* 31 */   PLAIN(0),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   SYNTHETIC(4096);
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
/*    */   SyntheticState(int paramInt1) {
/* 49 */     this.mask = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getMask() {
/* 56 */     return this.mask;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getRange() {
/* 63 */     return 4096;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isDefault() {
/* 70 */     return (this == PLAIN);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isSynthetic() {
/* 79 */     return (this == SYNTHETIC);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\modifier\SyntheticState.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */