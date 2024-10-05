/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import java.util.Random;
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
/*     */ public class RandomXS128
/*     */   extends Random
/*     */ {
/*     */   private static final double NORM_DOUBLE = 1.1102230246251565E-16D;
/*     */   private static final double NORM_FLOAT = 5.960464477539063E-8D;
/*     */   private long seed0;
/*     */   private long seed1;
/*     */   
/*     */   public RandomXS128() {
/*  49 */     setSeed((new Random()).nextLong());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomXS128(long paramLong) {
/*  55 */     setSeed(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomXS128(long paramLong1, long paramLong2) {
/*  62 */     setState(paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long nextLong() {
/*  70 */     long l1 = this.seed0;
/*  71 */     long l2 = this.seed1;
/*  72 */     this.seed0 = l2;
/*  73 */     l1 ^= l1 << 23L;
/*  74 */     return (this.seed1 = l1 ^ l2 ^ l1 >>> 17L ^ l2 >>> 26L) + l2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final int next(int paramInt) {
/*  80 */     return (int)(nextLong() & (1L << paramInt) - 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextInt() {
/*  88 */     return (int)nextLong();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextInt(int paramInt) {
/*  99 */     return (int)nextLong(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long nextLong(long paramLong) {
/*     */     long l1;
/*     */     long l2;
/* 110 */     if (paramLong <= 0L) throw new IllegalArgumentException("n must be positive");
/*     */     
/*     */     do {
/* 113 */       l2 = (l1 = nextLong() >>> 1L) % paramLong;
/* 114 */     } while (l1 - l2 + paramLong - 1L < 0L); return l2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double nextDouble() {
/* 124 */     return (nextLong() >>> 11L) * 1.1102230246251565E-16D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float nextFloat() {
/* 133 */     return (float)((nextLong() >>> 40L) * 5.960464477539063E-8D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean nextBoolean() {
/* 141 */     return ((nextLong() & 0x1L) != 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void nextBytes(byte[] paramArrayOfbyte) {
/* 151 */     int i = paramArrayOfbyte.length;
/* 152 */     while (i != 0) {
/* 153 */       byte b = (i < 8) ? i : 8; long l;
/* 154 */       for (l = nextLong(); b-- != 0; l >>= 8L) {
/* 155 */         paramArrayOfbyte[--i] = (byte)(int)l;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeed(long paramLong) {
/* 166 */     long l = murmurHash3((paramLong == 0L) ? Long.MIN_VALUE : paramLong);
/* 167 */     setState(l, murmurHash3(l));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(long paramLong1, long paramLong2) {
/* 174 */     this.seed0 = paramLong1;
/* 175 */     this.seed1 = paramLong2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getState(int paramInt) {
/* 182 */     return (paramInt == 0) ? this.seed0 : this.seed1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long murmurHash3(long paramLong) {
/* 192 */     return paramLong = (paramLong = (paramLong = (paramLong = (paramLong = paramLong ^ paramLong >>> 33L) * -49064778989728563L) ^ paramLong >>> 33L) * -4265267296055464877L) ^ paramLong >>> 33L;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\RandomXS128.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */