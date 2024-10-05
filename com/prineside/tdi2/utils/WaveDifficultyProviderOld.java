/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WaveDifficultyProviderOld
/*     */ {
/*     */   private final int[] a;
/*  17 */   private final int[] b = new int[16];
/*  18 */   private final float[] c = new float[16];
/*     */   public WaveDifficultyProviderOld(int[] paramArrayOfint) {
/*  20 */     Arrays.fill(this.b, -1);
/*     */     
/*  22 */     this.d = 0;
/*     */ 
/*     */     
/*  25 */     Preconditions.checkArgument((paramArrayOfint.length == 4), "difficultyGrowWaves must be int[4]");
/*  26 */     this.a = paramArrayOfint;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */   
/*     */   private float a(float paramFloat, int paramInt) {
/*  35 */     for (byte b = 3; b >= 0; b--) {
/*  36 */       if (this.a[b] != 0 && paramInt > this.a[b]) {
/*  37 */         if (b == 0) {
/*     */           
/*  39 */           paramFloat = (float)(paramFloat + 0.01D); break;
/*  40 */         }  if (b == 1) {
/*     */           
/*  42 */           paramFloat = (float)(paramFloat + 0.02D); break;
/*  43 */         }  if (b == 2) {
/*     */           
/*  45 */           paramInt -= this.a[2];
/*  46 */           paramFloat = (float)(paramFloat + 0.03D + StrictMath.pow(paramInt, 1.15D) * 0.004D);
/*     */           break;
/*     */         } 
/*  49 */         paramInt -= this.a[2];
/*  50 */         paramFloat = (float)(paramFloat + 0.04D + StrictMath.pow(paramInt, 1.15D) * 0.005D);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/*  56 */     return paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   private float a(int paramInt) {
/*  61 */     int i = -1; int j;
/*  62 */     for (j = 0; j < 16; j++) {
/*     */       int k;
/*  64 */       if ((k = this.b[j]) != -1 && k <= paramInt) {
/*  65 */         if (i != -1) {
/*     */           int m;
/*     */           
/*  68 */           if ((m = this.b[i]) < k) {
/*  69 */             i = j;
/*     */           }
/*     */         } else {
/*  72 */           i = j;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  77 */     if (i != -1) {
/*     */       
/*  79 */       j = this.b[i];
/*  80 */       float f1 = this.c[i];
/*  81 */       if (j == paramInt) return f1;
/*     */       
/*  83 */       for (int k = j + 1; k <= paramInt; k++) {
/*  84 */         f1 = a(f1, k);
/*     */       }
/*     */ 
/*     */       
/*  88 */       this.b[this.d] = paramInt;
/*  89 */       this.c[this.d] = f1;
/*  90 */       this.d++;
/*  91 */       if (this.d == 16) {
/*  92 */         this.d = 0;
/*     */       }
/*     */       
/*  95 */       return f1;
/*     */     } 
/*     */     
/*  98 */     float f = 1.0F;
/*  99 */     for (byte b = 1; b <= paramInt; b++) {
/* 100 */       f = a(f, b);
/*     */     }
/*     */ 
/*     */     
/* 104 */     this.b[this.d] = paramInt;
/* 105 */     this.c[this.d] = f;
/* 106 */     this.d++;
/* 107 */     if (this.d == 16) {
/* 108 */       this.d = 0;
/*     */     }
/*     */     
/* 111 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getDifficultWavesMultiplier(int paramInt1, int paramInt2) {
/* 122 */     float f1 = a(paramInt1);
/*     */     
/* 124 */     float f2 = 0.04F;
/* 125 */     for (byte b = 3; b >= 0; b--) {
/* 126 */       if (this.a[b] != 0 && paramInt1 > this.a[b]) {
/* 127 */         if (b == 0) {
/*     */           
/* 129 */           f2 = 0.04F; break;
/* 130 */         }  if (b == 1) {
/*     */           
/* 132 */           f2 = 0.035F; break;
/* 133 */         }  if (b == 2) {
/*     */           
/* 135 */           f2 = 0.025F;
/*     */           break;
/*     */         } 
/* 138 */         f2 = 0.015F;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/*     */     float f3;
/* 145 */     if ((f3 = PMath.sin((paramInt1 + 90)) * f2) < 0.0F) {
/* 146 */       f1 += f1 * f3;
/*     */     }
/*     */     
/* 149 */     return MathUtils.round(paramInt2 * f1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\WaveDifficultyProviderOld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */