/*     */ package com.d.c.d;
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
/*     */ public final class h
/*     */   implements g
/*     */ {
/*  23 */   public static final h a = new h(0, 0, 0);
/*  24 */   public static final h b = new h(255, 0, 0);
/*  25 */   public static final h c = new h(0, 255, 0);
/*  26 */   public static final h d = new h(0, 0, 255);
/*  27 */   public static final h e = new h(0, 0, 0);
/*     */   
/*     */   private int f;
/*     */   private int g;
/*     */   private int h;
/*     */   
/*     */   public h(int paramInt1, int paramInt2, int paramInt3) {
/*  34 */     if (paramInt1 < 0 || paramInt1 > 255) {
/*  35 */       throw new IllegalArgumentException();
/*     */     }
/*  37 */     if (paramInt2 < 0 || paramInt2 > 255) {
/*  38 */       throw new IllegalArgumentException();
/*     */     }
/*  40 */     if (paramInt3 < 0 || paramInt3 > 255) {
/*  41 */       throw new IllegalArgumentException();
/*     */     }
/*  43 */     this.f = paramInt1;
/*  44 */     this.g = paramInt2;
/*  45 */     this.h = paramInt3;
/*     */   }
/*     */   
/*     */   public h(int paramInt) {
/*  49 */     this(paramInt >> 16 & 0xFF, paramInt >> 8 & 0xFF, paramInt & 0xFF);
/*     */   }
/*     */   
/*     */   public final int a() {
/*  53 */     return this.h;
/*     */   }
/*     */   
/*     */   public final int b() {
/*  57 */     return this.g;
/*     */   }
/*     */   
/*     */   public final int c() {
/*  61 */     return this.f;
/*     */   }
/*     */   
/*     */   public final String toString() {
/*  65 */     return "#" + a(this.f) + a(this.g) + a(this.h);
/*     */   }
/*     */   
/*     */   private static String a(int paramInt) {
/*     */     String str;
/*  70 */     if ((str = Integer.toHexString(paramInt)).length() == 1) {
/*  71 */       return "0" + str;
/*     */     }
/*  73 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/*  78 */     if (this == paramObject) return true; 
/*  79 */     if (!(paramObject instanceof h)) return false;
/*     */     
/*  81 */     paramObject = paramObject;
/*     */     
/*  83 */     if (this.h != ((h)paramObject).h) return false; 
/*  84 */     if (this.g != ((h)paramObject).g) return false; 
/*  85 */     if (this.f != ((h)paramObject).f) return false;
/*     */     
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/*  91 */     int i = this.f;
/*  92 */     i = i * 31 + this.g;
/*     */     
/*  94 */     return i = i * 31 + this.h;
/*     */   }
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
/*     */   public final g e() {
/* 113 */     float arrayOfFloat[], f2 = (arrayOfFloat = a(c(), b(), a(), null))[0];
/* 114 */     float f3 = arrayOfFloat[1];
/* 115 */     float f1 = arrayOfFloat[2];
/*     */ 
/*     */ 
/*     */     
/* 119 */     f1 = 0.56F * f1;
/*     */     
/* 121 */     int[] arrayOfInt = a(f2, f3, f1);
/* 122 */     return new h(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]);
/*     */   }
/*     */ 
/*     */   
/*     */   private static float[] a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat) {
/*     */     float f1, f2;
/* 128 */     if (paramArrayOffloat == null) {
/* 129 */       paramArrayOffloat = new float[3];
/*     */     }
/* 131 */     int i = (paramInt1 > paramInt2) ? paramInt1 : paramInt2;
/* 132 */     if (paramInt3 > i)
/* 133 */       i = paramInt3; 
/* 134 */     int j = (paramInt1 < paramInt2) ? paramInt1 : paramInt2;
/* 135 */     if (paramInt3 < j) {
/* 136 */       j = paramInt3;
/*     */     }
/* 138 */     float f3 = i / 255.0F;
/* 139 */     if (i != 0) {
/* 140 */       f2 = (i - j) / i;
/*     */     } else {
/* 142 */       f2 = 0.0F;
/* 143 */     }  if (f2 == 0.0F) {
/* 144 */       f1 = 0.0F;
/*     */     } else {
/* 146 */       float f5 = (i - f1) / (i - j);
/* 147 */       float f6 = (i - paramInt2) / (i - j);
/* 148 */       float f4 = (i - paramInt3) / (i - j);
/* 149 */       if (f1 == i) {
/* 150 */         f1 = f4 - f6;
/* 151 */       } else if (paramInt2 == i) {
/* 152 */         f1 = f5 + 2.0F - f4;
/*     */       } else {
/* 154 */         f1 = f6 + 4.0F - f5;
/*     */       } 
/* 156 */       if ((f1 = f1 / 6.0F) < 0.0F)
/* 157 */         f1++; 
/*     */     } 
/* 159 */     paramArrayOffloat[0] = f1;
/* 160 */     paramArrayOffloat[1] = f2;
/* 161 */     paramArrayOffloat[2] = f3;
/* 162 */     return paramArrayOffloat;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int[] a(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 167 */     int i = 0, j = 0, k = 0;
/* 168 */     if (paramFloat2 == 0.0F) {
/* 169 */       i = j = k = (int)(paramFloat3 * 255.0F + 0.5F);
/*     */     } else {
/*     */       
/* 172 */       float f1 = (paramFloat1 = (paramFloat1 - (float)Math.floor(paramFloat1)) * 6.0F) - (float)Math.floor(paramFloat1);
/* 173 */       float f2 = paramFloat3 * (1.0F - paramFloat2);
/* 174 */       float f3 = paramFloat3 * (1.0F - paramFloat2 * f1);
/* 175 */       paramFloat2 = paramFloat3 * (1.0F - paramFloat2 * (1.0F - f1));
/* 176 */       switch ((int)paramFloat1) {
/*     */         case 0:
/* 178 */           i = (int)(paramFloat3 * 255.0F + 0.5F);
/* 179 */           j = (int)(paramFloat2 * 255.0F + 0.5F);
/* 180 */           k = (int)(f2 * 255.0F + 0.5F);
/*     */           break;
/*     */         case 1:
/* 183 */           i = (int)(f3 * 255.0F + 0.5F);
/* 184 */           j = (int)(paramFloat3 * 255.0F + 0.5F);
/* 185 */           k = (int)(f2 * 255.0F + 0.5F);
/*     */           break;
/*     */         case 2:
/* 188 */           i = (int)(f2 * 255.0F + 0.5F);
/* 189 */           j = (int)(paramFloat3 * 255.0F + 0.5F);
/* 190 */           k = (int)(paramFloat2 * 255.0F + 0.5F);
/*     */           break;
/*     */         case 3:
/* 193 */           i = (int)(f2 * 255.0F + 0.5F);
/* 194 */           j = (int)(f3 * 255.0F + 0.5F);
/* 195 */           k = (int)(paramFloat3 * 255.0F + 0.5F);
/*     */           break;
/*     */         case 4:
/* 198 */           i = (int)(paramFloat2 * 255.0F + 0.5F);
/* 199 */           j = (int)(f2 * 255.0F + 0.5F);
/* 200 */           k = (int)(paramFloat3 * 255.0F + 0.5F);
/*     */           break;
/*     */         case 5:
/* 203 */           i = (int)(paramFloat3 * 255.0F + 0.5F);
/* 204 */           j = (int)(f2 * 255.0F + 0.5F);
/* 205 */           k = (int)(f3 * 255.0F + 0.5F);
/*     */           break;
/*     */       } 
/*     */     } 
/* 209 */     return new int[] { i, j, k };
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */