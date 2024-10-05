/*    */ package com.crashinvaders.basisu.wrapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BasisuTextureType
/*    */   implements UniqueIdUtils.UniqueIdValue
/*    */ {
/* 11 */   REGULAR_2D(0),
/* 12 */   REGULAR_2D_ARRAY(1),
/* 13 */   CUBEMAP_ARRAY(2),
/* 14 */   VIDEO_FRAMES(3),
/* 15 */   VOLUME(4);
/*    */   
/*    */   private final int id;
/*    */ 
/*    */   
/*    */   BasisuTextureType(int paramInt1) {
/* 21 */     this.id = paramInt1;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int getId() {
/* 26 */     return this.id;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\BasisuTextureType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */