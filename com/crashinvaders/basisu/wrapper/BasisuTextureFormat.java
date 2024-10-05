/*    */ package com.crashinvaders.basisu.wrapper;
/*    */ 
/*    */ public enum BasisuTextureFormat
/*    */   implements UniqueIdUtils.UniqueIdValue {
/*  5 */   ETC1S(0),
/*  6 */   UASTC4x4(1);
/*    */   
/*    */   private final int id;
/*    */ 
/*    */   
/*    */   BasisuTextureFormat(int paramInt1) {
/* 12 */     this.id = paramInt1;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int getId() {
/* 17 */     return this.id;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\BasisuTextureFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */