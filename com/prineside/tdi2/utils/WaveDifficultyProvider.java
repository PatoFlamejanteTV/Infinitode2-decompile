/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public final class WaveDifficultyProvider {
/*   8 */   private static final TLog a = TLog.forClass(WaveDifficultyProvider.class);
/*     */ 
/*     */   
/*  11 */   private static final float[] b = new float[] { 0.2F, 0.25F, 0.3F, 0.35F, 0.4F, 0.45F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 1.0F }; private static final float c; private float d;
/*     */   
/*     */   static {
/*  14 */     float f = 0.0F; float[] arrayOfFloat; int i; byte b;
/*  15 */     for (i = (arrayOfFloat = b).length, b = 0; b < i; ) { float f1 = arrayOfFloat[b];
/*  16 */       f += f1; b++; }
/*     */     
/*  18 */     c = f;
/*     */   }
/*     */ 
/*     */   
/*  22 */   private float e = 1.0F;
/*  23 */   private final int[] f = new int[64];
/*     */ 
/*     */ 
/*     */   
/*     */   private final RandomXS128 g;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WaveDifficultyProvider(int paramInt, float paramFloat1, float paramFloat2) {
/*  33 */     this.d = paramFloat1;
/*  34 */     this.e = paramFloat2;
/*  35 */     if (paramFloat2 < -1.0F) {
/*  36 */       a.i("limiting expectedPlaytime to -1 (" + paramFloat2 + " given)", new Object[0]);
/*  37 */       this.e = -1.0F;
/*     */     } 
/*     */     
/*  40 */     this.g = new RandomXS128(paramInt);
/*  41 */     for (paramInt = 0; paramInt < 64; paramInt++) {
/*  42 */       this.f[paramInt] = this.g.nextInt();
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/*  47 */     paramInt += 64;
/*  48 */     this.g.setSeed(this.f[paramInt % 64] + (paramInt << 32L));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getDifficultWavesMultiplier(int paramInt) {
/*  53 */     int j = (int)(15.0F + 5.0F * this.e);
/*  54 */     int k = (int)(25.0F + 15.0F * this.e);
/*  55 */     int m = (int)(35.0F + 25.0F * this.e);
/*  56 */     int n = (int)(55.0F + 35.0F * this.e);
/*     */ 
/*     */     
/*  59 */     float f6 = this.d * 0.01F;
/*     */     
/*  61 */     float f5 = 0.01F * Math.max(f6 - 1.0F, 0.0F);
/*  62 */     f5 = 1.0F + paramInt * f5;
/*     */     
/*  64 */     f6 = 1.0F + f6 * 0.05F;
/*     */     
/*  66 */     float f7 = 0.01F * f6;
/*  67 */     j = Math.max(0, paramInt - j);
/*  68 */     f5 += j * f7;
/*     */     
/*  70 */     float f3 = 0.02F * f6;
/*  71 */     k = Math.max(0, paramInt - k);
/*  72 */     f5 += k * f3;
/*     */ 
/*     */     
/*  75 */     int i = Math.max(0, paramInt - m);
/*  76 */     float f4 = 0.031F + ((float)Math.pow((i * 0.03F + 1.0F), (1.13F + f6 * 0.05F)) - 1.0F) * 0.01F;
/*  77 */     f5 += i * f4;
/*     */ 
/*     */     
/*  80 */     i = Math.max(0, paramInt - n);
/*     */     
/*  82 */     if ((f4 = this.e + 1.0F) > 2.0F) {
/*  83 */       f4 = 2.0F;
/*     */     }
/*  85 */     f4 = (2.0F - f4) * 0.5F;
/*  86 */     f4 = 0.062F + 0.02F * f4;
/*     */     
/*  88 */     f4 = 0.04F + ((float)Math.pow((i * f4 + 1.0F), (1.16F + f6 * 0.05F + i * 1.8E-4F)) - 1.0F) * 0.037F;
/*  89 */     f5 += i * f4;
/*     */ 
/*     */     
/*  92 */     float f2 = 0.0F;
/*  93 */     for (byte b = 0; b < b.length; b++) {
/*  94 */       a(paramInt - b);
/*  95 */       f2 += this.g.nextFloat() * b[b];
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     float f1 = (f2 = MathUtils.clamp(((f2 = f2 / c) - 0.25F) * 2.0F, 0.0F, 1.0F)) * 0.2F + 0.8F;
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
/* 116 */     return MathUtils.round(f5 = (f5 = f5 * f1) * this.d);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\WaveDifficultyProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */