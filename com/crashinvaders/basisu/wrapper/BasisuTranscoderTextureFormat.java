/*    */ package com.crashinvaders.basisu.wrapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BasisuTranscoderTextureFormat
/*    */   implements UniqueIdUtils.UniqueIdValue
/*    */ {
/*  8 */   ETC1_RGB(0),
/*    */   
/* 10 */   ETC2_RGBA(1),
/*    */   
/* 12 */   ETC2_EAC_R11(20),
/*    */   
/* 14 */   ETC2_EAC_RG11(21),
/*    */ 
/*    */ 
/*    */   
/* 18 */   BC1_RGB(2),
/*    */   
/* 20 */   BC3_RGBA(3),
/*    */   
/* 22 */   BC4_R(4),
/*    */   
/* 24 */   BC5_RG(5),
/*    */   
/* 26 */   BC7_RGBA(6),
/*    */ 
/*    */ 
/*    */   
/* 30 */   PVRTC1_4_RGB(8),
/*    */   
/* 32 */   PVRTC1_4_RGBA(9),
/*    */   
/* 34 */   PVRTC2_4_RGB(18),
/*    */   
/* 36 */   PVRTC2_4_RGBA(19),
/*    */ 
/*    */ 
/*    */   
/* 40 */   ASTC_4x4_RGBA(10),
/*    */ 
/*    */ 
/*    */   
/* 44 */   ATC_RGB(11),
/*    */   
/* 46 */   ATC_RGBA(12),
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
/* 58 */   RGBA32(13),
/*    */   
/* 60 */   RGB565(14),
/*    */   
/* 62 */   RGBA4444(16);
/*    */   
/*    */   private final int id;
/*    */ 
/*    */   
/*    */   BasisuTranscoderTextureFormat(int paramInt1) {
/* 68 */     this.id = paramInt1;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int getId() {
/* 73 */     return this.id;
/*    */   }
/*    */   
/*    */   public final boolean isCompressedFormat() {
/* 77 */     return (this != RGBA32 && this != RGB565 && this != RGBA4444);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\BasisuTranscoderTextureFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */