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
/*    */ public enum FieldManifestation
/*    */   implements ModifierContributor.ForField
/*    */ {
/* 28 */   PLAIN(0),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   FINAL(16),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   VOLATILE(64);
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
/*    */   FieldManifestation(int paramInt1) {
/* 51 */     this.mask = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getMask() {
/* 58 */     return this.mask;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getRange() {
/* 65 */     return 80;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isDefault() {
/* 72 */     return (this == PLAIN);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isFinal() {
/* 81 */     return ((this.mask & 0x10) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isVolatile() {
/* 90 */     return ((this.mask & 0x40) != 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isPlain() {
/* 99 */     return (!isFinal() && !isVolatile());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\modifier\FieldManifestation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */