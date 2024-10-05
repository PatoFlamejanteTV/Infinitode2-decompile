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
/*    */ public enum FieldPersistence
/*    */   implements ModifierContributor.ForField
/*    */ {
/* 28 */   PLAIN(0),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   TRANSIENT(128);
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
/*    */   FieldPersistence(int paramInt1) {
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
/* 60 */     return 128;
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
/*    */   public final boolean isTransient() {
/* 76 */     return ((this.mask & 0x80) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\modifier\FieldPersistence.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */