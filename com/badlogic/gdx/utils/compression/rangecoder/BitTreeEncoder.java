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
/*    */ 
/*    */ 
/*    */ public class BitTreeEncoder
/*    */ {
/*    */   short[] Models;
/*    */   int NumBitLevels;
/*    */   
/*    */   public BitTreeEncoder(int paramInt) {
/* 26 */     this.NumBitLevels = paramInt;
/* 27 */     this.Models = new short[1 << paramInt];
/*    */   }
/*    */   
/*    */   public void Init() {
/* 31 */     Decoder.InitBitModels(this.Models);
/*    */   }
/*    */   
/*    */   public void Encode(Encoder paramEncoder, int paramInt) {
/* 35 */     int i = 1;
/* 36 */     for (int j = this.NumBitLevels; j != 0; ) {
/* 37 */       j--;
/* 38 */       int k = paramInt >>> j & 0x1;
/* 39 */       paramEncoder.Encode(this.Models, i, k);
/* 40 */       i = i << 1 | k;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void ReverseEncode(Encoder paramEncoder, int paramInt) {
/* 45 */     int i = 1;
/* 46 */     for (byte b = 0; b < this.NumBitLevels; b++) {
/* 47 */       int j = paramInt & 0x1;
/* 48 */       paramEncoder.Encode(this.Models, i, j);
/* 49 */       i = i << 1 | j;
/* 50 */       paramInt >>= 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public int GetPrice(int paramInt) {
/* 55 */     int i = 0;
/* 56 */     int j = 1;
/* 57 */     for (int k = this.NumBitLevels; k != 0; ) {
/* 58 */       k--;
/* 59 */       int m = paramInt >>> k & 0x1;
/* 60 */       i += Encoder.GetPrice(this.Models[j], m);
/* 61 */       j = (j << 1) + m;
/*    */     } 
/* 63 */     return i;
/*    */   }
/*    */   
/*    */   public int ReverseGetPrice(int paramInt) {
/* 67 */     int i = 0;
/* 68 */     int j = 1;
/* 69 */     for (int k = this.NumBitLevels; k != 0; k--) {
/* 70 */       int m = paramInt & 0x1;
/* 71 */       paramInt >>>= 1;
/* 72 */       i += Encoder.GetPrice(this.Models[j], m);
/* 73 */       j = j << 1 | m;
/*    */     } 
/* 75 */     return i;
/*    */   }
/*    */   
/*    */   public static int ReverseGetPrice(short[] paramArrayOfshort, int paramInt1, int paramInt2, int paramInt3) {
/* 79 */     int i = 0;
/* 80 */     int j = 1;
/* 81 */     for (paramInt2 = paramInt2; paramInt2 != 0; paramInt2--) {
/* 82 */       int k = paramInt3 & 0x1;
/* 83 */       paramInt3 >>>= 1;
/* 84 */       i += Encoder.GetPrice(paramArrayOfshort[paramInt1 + j], k);
/* 85 */       j = j << 1 | k;
/*    */     } 
/* 87 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void ReverseEncode(short[] paramArrayOfshort, int paramInt1, Encoder paramEncoder, int paramInt2, int paramInt3) {
/* 92 */     int i = 1;
/* 93 */     for (byte b = 0; b < paramInt2; b++) {
/* 94 */       int j = paramInt3 & 0x1;
/* 95 */       paramEncoder.Encode(paramArrayOfshort, paramInt1 + i, j);
/* 96 */       i = i << 1 | j;
/* 97 */       paramInt3 >>= 1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\rangecoder\BitTreeEncoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */