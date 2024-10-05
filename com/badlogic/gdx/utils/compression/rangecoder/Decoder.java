/*    */ package com.badlogic.gdx.utils.compression.rangecoder;
/*    */ 
/*    */ import java.io.InputStream;
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
/*    */ public class Decoder
/*    */ {
/*    */   static final int kTopMask = -16777216;
/*    */   static final int kNumBitModelTotalBits = 11;
/*    */   static final int kBitModelTotal = 2048;
/*    */   static final int kNumMoveBits = 5;
/*    */   int Range;
/*    */   int Code;
/*    */   InputStream Stream;
/*    */   
/*    */   public final void SetStream(InputStream paramInputStream) {
/* 34 */     this.Stream = paramInputStream;
/*    */   }
/*    */   
/*    */   public final void ReleaseStream() {
/* 38 */     this.Stream = null;
/*    */   }
/*    */   
/*    */   public final void Init() {
/* 42 */     this.Code = 0;
/* 43 */     this.Range = -1;
/* 44 */     for (byte b = 0; b < 5; b++)
/* 45 */       this.Code = this.Code << 8 | this.Stream.read(); 
/*    */   }
/*    */   
/*    */   public final int DecodeDirectBits(int paramInt) {
/* 49 */     int i = 0;
/* 50 */     for (paramInt = paramInt; paramInt != 0; paramInt--) {
/* 51 */       this.Range >>>= 1;
/* 52 */       int j = this.Code - this.Range >>> 31;
/* 53 */       this.Code -= this.Range & j - 1;
/* 54 */       i = i << 1 | 1 - j;
/*    */       
/* 56 */       if ((this.Range & 0xFF000000) == 0) {
/* 57 */         this.Code = this.Code << 8 | this.Stream.read();
/* 58 */         this.Range <<= 8;
/*    */       } 
/*    */     } 
/* 61 */     return i;
/*    */   }
/*    */   
/*    */   public int DecodeBit(short[] paramArrayOfshort, int paramInt) {
/* 65 */     short s = paramArrayOfshort[paramInt];
/* 66 */     int i = (this.Range >>> 11) * s;
/* 67 */     if ((this.Code ^ Integer.MIN_VALUE) < (i ^ Integer.MIN_VALUE)) {
/* 68 */       this.Range = i;
/* 69 */       paramArrayOfshort[paramInt] = (short)(s + (2048 - s >>> 5));
/* 70 */       if ((this.Range & 0xFF000000) == 0) {
/* 71 */         this.Code = this.Code << 8 | this.Stream.read();
/* 72 */         this.Range <<= 8;
/*    */       } 
/* 74 */       return 0;
/*    */     } 
/* 76 */     this.Range -= i;
/* 77 */     this.Code -= i;
/* 78 */     paramArrayOfshort[paramInt] = (short)(s - (s >>> 5));
/* 79 */     if ((this.Range & 0xFF000000) == 0) {
/* 80 */       this.Code = this.Code << 8 | this.Stream.read();
/* 81 */       this.Range <<= 8;
/*    */     } 
/* 83 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void InitBitModels(short[] paramArrayOfshort) {
/* 88 */     for (byte b = 0; b < paramArrayOfshort.length; b++)
/* 89 */       paramArrayOfshort[b] = 1024; 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\rangecoder\Decoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */