/*     */ package com.badlogic.gdx.utils.compression.rangecoder;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Encoder
/*     */ {
/*     */   static final int kTopMask = -16777216;
/*     */   static final int kNumBitModelTotalBits = 11;
/*     */   static final int kBitModelTotal = 2048;
/*     */   static final int kNumMoveBits = 5;
/*     */   OutputStream Stream;
/*     */   long Low;
/*     */   int Range;
/*     */   int _cacheSize;
/*     */   int _cache;
/*     */   long _position;
/*     */   static final int kNumMoveReducingBits = 2;
/*     */   public static final int kNumBitPriceShiftBits = 6;
/*     */   
/*     */   public void SetStream(OutputStream paramOutputStream) {
/*  38 */     this.Stream = paramOutputStream;
/*     */   }
/*     */   
/*     */   public void ReleaseStream() {
/*  42 */     this.Stream = null;
/*     */   }
/*     */   
/*     */   public void Init() {
/*  46 */     this._position = 0L;
/*  47 */     this.Low = 0L;
/*  48 */     this.Range = -1;
/*  49 */     this._cacheSize = 1;
/*  50 */     this._cache = 0;
/*     */   }
/*     */   
/*     */   public void FlushData() {
/*  54 */     for (byte b = 0; b < 5; b++)
/*  55 */       ShiftLow(); 
/*     */   }
/*     */   
/*     */   public void FlushStream() {
/*  59 */     this.Stream.flush();
/*     */   }
/*     */   
/*     */   public void ShiftLow() {
/*     */     int i;
/*  64 */     if ((i = (int)(this.Low >>> 32L)) != 0 || this.Low < 4278190080L) {
/*  65 */       this._position += this._cacheSize;
/*  66 */       int j = this._cache;
/*     */       do {
/*  68 */         this.Stream.write(j + i);
/*  69 */         j = 255;
/*  70 */       } while (--this._cacheSize != 0);
/*  71 */       this._cache = (int)this.Low >>> 24;
/*     */     } 
/*  73 */     this._cacheSize++;
/*  74 */     this.Low = (this.Low & 0xFFFFFFL) << 8L;
/*     */   }
/*     */   
/*     */   public void EncodeDirectBits(int paramInt1, int paramInt2) {
/*  78 */     for (; --paramInt2 >= 0; paramInt2--) {
/*  79 */       this.Range >>>= 1;
/*  80 */       if ((paramInt1 >>> paramInt2 & 0x1) == 1) this.Low += this.Range; 
/*  81 */       if ((this.Range & 0xFF000000) == 0) {
/*  82 */         this.Range <<= 8;
/*  83 */         ShiftLow();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public long GetProcessedSizeAdd() {
/*  89 */     return this._cacheSize + this._position + 4L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void InitBitModels(short[] paramArrayOfshort) {
/*  96 */     for (byte b = 0; b < paramArrayOfshort.length; b++)
/*  97 */       paramArrayOfshort[b] = 1024; 
/*     */   }
/*     */   
/*     */   public void Encode(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 101 */     short s = paramArrayOfshort[paramInt1];
/* 102 */     int i = (this.Range >>> 11) * s;
/* 103 */     if (paramInt2 == 0) {
/* 104 */       this.Range = i;
/* 105 */       paramArrayOfshort[paramInt1] = (short)(s + (2048 - s >>> 5));
/*     */     } else {
/* 107 */       this.Low += i & 0xFFFFFFFFL;
/* 108 */       this.Range -= i;
/* 109 */       paramArrayOfshort[paramInt1] = (short)(s - (s >>> 5));
/*     */     } 
/* 111 */     if ((this.Range & 0xFF000000) == 0) {
/* 112 */       this.Range <<= 8;
/* 113 */       ShiftLow();
/*     */     } 
/*     */   }
/*     */   
/* 117 */   private static int[] ProbPrices = new int[512];
/*     */ 
/*     */   
/*     */   static {
/* 121 */     for (byte b = 8; b >= 0; b--) {
/* 122 */       int i = 1 << 9 - b - 1;
/* 123 */       int j = 1 << 9 - b;
/* 124 */       for (i = i; i < j; i++)
/* 125 */         ProbPrices[i] = (b << 6) + (j - i << 6 >>> 9 - b - 1); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int GetPrice(int paramInt1, int paramInt2) {
/* 130 */     return ProbPrices[((paramInt1 - paramInt2 ^ -paramInt2) & 0x7FF) >>> 2];
/*     */   }
/*     */   
/*     */   public static int GetPrice0(int paramInt) {
/* 134 */     return ProbPrices[paramInt >>> 2];
/*     */   }
/*     */   
/*     */   public static int GetPrice1(int paramInt) {
/* 138 */     return ProbPrices[2048 - paramInt >>> 2];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\rangecoder\Encoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */