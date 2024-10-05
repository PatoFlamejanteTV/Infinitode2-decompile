/*    */ package com.badlogic.gdx.utils.compression.lzma;public class Base { public static final int kNumRepDistances = 4; public static final int kNumStates = 12; public static final int kNumPosSlotBits = 6; public static final int kDicLogSizeMin = 0; public static final int kNumLenToPosStatesBits = 2; public static final int kNumLenToPosStates = 4; public static final int kMatchMinLen = 2;
/*    */   public static final int kNumAlignBits = 4;
/*    */   public static final int kAlignTableSize = 16;
/*    */   public static final int kAlignMask = 15;
/*    */   public static final int kStartPosModelIndex = 4;
/*    */   public static final int kEndPosModelIndex = 14;
/*    */   public static final int kNumPosModels = 10;
/*    */   
/*    */   public static final int StateInit() {
/* 10 */     return 0;
/*    */   }
/*    */   public static final int kNumFullDistances = 128; public static final int kNumLitPosStatesBitsEncodingMax = 4; public static final int kNumLitContextBitsMax = 8; public static final int kNumPosStatesBitsMax = 4; public static final int kNumPosStatesMax = 16; public static final int kNumPosStatesBitsEncodingMax = 4; public static final int kNumPosStatesEncodingMax = 16; public static final int kNumLowLenBits = 3; public static final int kNumMidLenBits = 3; public static final int kNumHighLenBits = 8; public static final int kNumLowLenSymbols = 8; public static final int kNumMidLenSymbols = 8; public static final int kNumLenSymbols = 272; public static final int kMatchMaxLen = 273;
/*    */   public static final int StateUpdateChar(int paramInt) {
/* 14 */     if (paramInt < 4) return 0; 
/* 15 */     if (paramInt < 10) return paramInt - 3; 
/* 16 */     return paramInt - 6;
/*    */   }
/*    */   
/*    */   public static final int StateUpdateMatch(int paramInt) {
/* 20 */     return (paramInt < 7) ? 7 : 10;
/*    */   }
/*    */   
/*    */   public static final int StateUpdateRep(int paramInt) {
/* 24 */     return (paramInt < 7) ? 8 : 11;
/*    */   }
/*    */   
/*    */   public static final int StateUpdateShortRep(int paramInt) {
/* 28 */     return (paramInt < 7) ? 9 : 11;
/*    */   }
/*    */   
/*    */   public static final boolean StateIsCharState(int paramInt) {
/* 32 */     return (paramInt < 7);
/*    */   }
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
/*    */   public static final int GetLenToPosState(int paramInt) {
/* 46 */     paramInt -= 2;
/* 47 */     if (paramInt < 4) return paramInt; 
/* 48 */     return 3;
/*    */   } }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\lzma\Base.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */