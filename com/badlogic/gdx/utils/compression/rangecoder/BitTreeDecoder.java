/*    */ package com.badlogic.gdx.utils.compression.rangecoder;
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
/*    */ public class BitTreeDecoder
/*    */ {
/*    */   short[] Models;
/*    */   int NumBitLevels;
/*    */   
/*    */   public BitTreeDecoder(int paramInt) {
/* 24 */     this.NumBitLevels = paramInt;
/* 25 */     this.Models = new short[1 << paramInt];
/*    */   }
/*    */   
/*    */   public void Init() {
/* 29 */     Decoder.InitBitModels(this.Models);
/*    */   }
/*    */   
/*    */   public int Decode(Decoder paramDecoder) {
/* 33 */     int i = 1;
/* 34 */     for (int j = this.NumBitLevels; j != 0; j--)
/* 35 */       i = (i << 1) + paramDecoder.DecodeBit(this.Models, i); 
/* 36 */     return i - (1 << this.NumBitLevels);
/*    */   }
/*    */   
/*    */   public int ReverseDecode(Decoder paramDecoder) {
/* 40 */     int i = 1;
/* 41 */     int j = 0;
/* 42 */     for (byte b = 0; b < this.NumBitLevels; b++) {
/* 43 */       int k = paramDecoder.DecodeBit(this.Models, i);
/*    */       
/* 45 */       i = (i = i << 1) + k;
/* 46 */       j |= k << b;
/*    */     } 
/* 48 */     return j;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int ReverseDecode(short[] paramArrayOfshort, int paramInt1, Decoder paramDecoder, int paramInt2) {
/* 53 */     int i = 1;
/* 54 */     int j = 0;
/* 55 */     for (byte b = 0; b < paramInt2; b++) {
/* 56 */       int k = paramDecoder.DecodeBit(paramArrayOfshort, paramInt1 + i);
/*    */       
/* 58 */       i = (i = i << 1) + k;
/* 59 */       j |= k << b;
/*    */     } 
/* 61 */     return j;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\rangecoder\BitTreeDecoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */