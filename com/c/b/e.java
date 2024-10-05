/*     */ package com.c.b;
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
/*     */ public class e
/*     */ {
/*     */   l a;
/*     */   int b;
/*     */   private float[][] g;
/*     */   private int h;
/*     */   private int i;
/*     */   private int j;
/*     */   private int k;
/*     */   private int l;
/*     */   private int m;
/*     */   private long n;
/*     */   private long o;
/*     */   private long p;
/*     */   private long q;
/*     */   private long r;
/*     */   private long s;
/*     */   float[][][][][] c;
/*     */   Object[][] d;
/*     */   b[] e;
/*     */   Object[] f;
/*     */   
/*     */   public e() {
/*  78 */     this.d = new Object[2][];
/*  79 */     this.c = new float[2][][][][];
/*  80 */     this.c[0] = new float[2][][][];
/*  81 */     this.c[0][0] = new float[2][][];
/*  82 */     this.c[0][1] = new float[2][][];
/*  83 */     this.c[0][0][0] = new float[2][];
/*  84 */     this.c[0][0][1] = new float[2][];
/*  85 */     this.c[0][1][0] = new float[2][];
/*  86 */     this.c[0][1][1] = new float[2][];
/*  87 */     this.c[1] = new float[2][][][];
/*  88 */     this.c[1][0] = new float[2][][];
/*  89 */     this.c[1][1] = new float[2][][];
/*  90 */     this.c[1][0][0] = new float[2][];
/*  91 */     this.c[1][0][1] = new float[2][];
/*  92 */     this.c[1][1][0] = new float[2][];
/*  93 */     this.c[1][1][1] = new float[2][];
/*     */   }
/*     */   private static float[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*     */     int i;
/*  97 */     float[] arrayOfFloat = new float[paramInt2];
/*  98 */     switch (paramInt1) {
/*     */ 
/*     */       
/*     */       case 0:
/* 102 */         paramInt1 = paramInt2 / 4 - paramInt3 / 2;
/* 103 */         paramInt2 = paramInt2 - paramInt2 / 4 - paramInt4 / 2;
/*     */         
/* 105 */         for (i = 0; i < paramInt3; i++) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 110 */           float f = (float)Math.sin((f = (float)((f = (f = (float)Math.sin((f = (float)((i + 0.5D) / paramInt3 * 3.1415927410125732D / 2.0D)))) * f) * 1.5707963705062866D)));
/* 111 */           arrayOfFloat[i + paramInt1] = f;
/*     */         } 
/*     */         
/* 114 */         for (i = paramInt1 + paramInt3; i < paramInt2; i++) {
/* 115 */           arrayOfFloat[i] = 1.0F;
/*     */         }
/*     */         
/* 118 */         for (i = 0; i < paramInt4; i++) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 123 */           float f = (float)Math.sin((f = (float)((f = (f = (float)Math.sin((f = (float)(((paramInt4 - i) - 0.5D) / paramInt4 * 3.1415927410125732D / 2.0D)))) * f) * 1.5707963705062866D)));
/* 124 */           arrayOfFloat[i + paramInt2] = f;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 132 */         return arrayOfFloat;
/*     */     } 
/*     */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int b(l paraml) {
/* 140 */     this.a = paraml;
/* 141 */     this.b = o.b(paraml.d);
/*     */     
/* 143 */     this.d[0] = new Object[1];
/* 144 */     this.d[1] = new Object[1];
/*     */ 
/*     */ 
/*     */     
/* 148 */     this.d[0][0] = new q();
/* 149 */     this.d[1][0] = new q();
/* 150 */     ((q)this.d[0][0]).a(paraml.c[0]);
/* 151 */     ((q)this.d[1][0]).a(paraml.c[1]);
/*     */     
/* 153 */     this.c[0][0][0] = new float[1][];
/* 154 */     this.c[0][0][1] = this.c[0][0][0];
/* 155 */     this.c[0][1][0] = this.c[0][0][0];
/* 156 */     this.c[0][1][1] = this.c[0][0][0];
/* 157 */     this.c[1][0][0] = new float[1][];
/* 158 */     this.c[1][0][1] = new float[1][];
/* 159 */     this.c[1][1][0] = new float[1][];
/* 160 */     this.c[1][1][1] = new float[1][];
/*     */     byte b1;
/* 162 */     for (b1 = 0; b1; b1++) {
/* 163 */       this.c[0][0][0][0] = a(0, paraml.c[0], paraml.c[0] / 2, paraml.c[0] / 2);
/*     */       
/* 165 */       this.c[1][0][0][0] = a(0, paraml.c[1], paraml.c[0] / 2, paraml.c[0] / 2);
/*     */       
/* 167 */       this.c[1][0][1][0] = a(0, paraml.c[1], paraml.c[0] / 2, paraml.c[1] / 2);
/*     */       
/* 169 */       this.c[1][1][0][0] = a(0, paraml.c[1], paraml.c[1] / 2, paraml.c[0] / 2);
/*     */       
/* 171 */       this.c[1][1][1][0] = a(0, paraml.c[1], paraml.c[1] / 2, paraml.c[1] / 2);
/*     */     } 
/*     */ 
/*     */     
/* 175 */     this.e = new b[paraml.h];
/* 176 */     for (b1 = 0; b1 < paraml.h; b1++) {
/* 177 */       this.e[b1] = new b();
/* 178 */       this.e[b1].a(paraml.r[b1]);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     this.h = 8192;
/*     */ 
/*     */     
/* 187 */     this.g = new float[paraml.a][];
/*     */     
/* 189 */     for (b1 = 0; b1 < paraml.a; b1++) {
/* 190 */       this.g[b1] = new float[this.h];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     this.k = 0;
/* 197 */     this.l = 0;
/*     */ 
/*     */     
/* 200 */     this.m = paraml.c[1] / 2;
/*     */     
/* 202 */     this.i = this.m;
/*     */ 
/*     */     
/* 205 */     this.f = new Object[paraml.d];
/* 206 */     for (b1 = 0; b1 < paraml.d; b1++) {
/* 207 */       int i = (paraml.i[b1]).d;
/* 208 */       int j = paraml.j[i];
/* 209 */       this.f[b1] = i.a[j].a(this, paraml.i[b1], paraml.k[i]);
/*     */     } 
/*     */     
/* 212 */     return 0;
/*     */   }
/*     */   
/*     */   public final int a(l paraml) {
/* 216 */     b(paraml);
/*     */     
/* 218 */     this.j = this.m;
/* 219 */     this.m -= paraml.c[this.l] / 4 + paraml.c[this.k] / 4;
/* 220 */     this.n = -1L;
/* 221 */     this.o = -1L;
/* 222 */     return 0;
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
/*     */   
/*     */   public final int a(a parama) {
/* 242 */     if (this.m > this.a.c[1] / 2 && this.j > 8192) {
/*     */ 
/*     */ 
/*     */       
/* 246 */       int i2 = this.m - this.a.c[1] / 2;
/* 247 */       i2 = (this.j < i2) ? this.j : i2;
/*     */       
/* 249 */       this.i -= i2;
/* 250 */       this.m -= i2;
/* 251 */       this.j -= i2;
/* 252 */       if (i2 != 0) {
/* 253 */         for (byte b2 = 0; b2 < this.a.a; b2++) {
/* 254 */           System.arraycopy(this.g[b2], i2, this.g[b2], 0, this.i);
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 259 */     this.k = this.l;
/* 260 */     this.l = parama.d;
/*     */ 
/*     */     
/* 263 */     this.p = this.p;
/* 264 */     this.q = this.q;
/* 265 */     this.r = this.r;
/* 266 */     this.s = this.s;
/*     */     
/* 268 */     if (this.o + 1L != parama.j) {
/* 269 */       this.n = -1L;
/*     */     }
/* 271 */     this.o = parama.j;
/*     */ 
/*     */     
/* 274 */     int i = this.a.c[this.l];
/*     */ 
/*     */     
/* 277 */     int j, k, m = (k = (j = this.m + this.a.c[this.k] / 4 + i / 4) - i / 2) + i;
/* 278 */     int n = 0;
/* 279 */     int i1 = 0;
/*     */ 
/*     */     
/* 282 */     if (m > this.h) {
/*     */       
/* 284 */       this.h = m + this.a.c[1];
/* 285 */       for (byte b2 = 0; b2 < this.a.a; b2++) {
/* 286 */         float[] arrayOfFloat = new float[this.h];
/* 287 */         System.arraycopy(this.g[b2], 0, arrayOfFloat, 0, (this.g[b2]).length);
/* 288 */         this.g[b2] = arrayOfFloat;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 293 */     switch (this.l) {
/*     */       case 0:
/* 295 */         n = 0;
/* 296 */         i1 = this.a.c[0] / 2;
/*     */         break;
/*     */       
/*     */       case 1:
/* 300 */         i1 = (n = this.a.c[1] / 4 - this.a.c[this.k] / 4) + this.a.c[this.k] / 2;
/*     */         break;
/*     */     } 
/*     */     
/* 304 */     for (byte b1 = 0; b1 < this.a.a; b1++) {
/* 305 */       int i2 = k;
/*     */       
/*     */       int i3;
/* 308 */       for (i3 = n; i3 < i1; i3++) {
/* 309 */         this.g[b1][i2 + i3] = this.g[b1][i2 + i3] + parama.a[b1][i3];
/*     */       }
/*     */       
/* 312 */       for (; i3 < i; i3++) {
/* 313 */         this.g[b1][i2 + i3] = parama.a[b1][i3];
/*     */       }
/*     */     } 
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
/* 328 */     if (this.n != -1L)
/*     */     
/*     */     { 
/*     */       
/* 332 */       this.n += (j - this.m);
/* 333 */       if (parama.i != -1L && this.n != parama.i)
/* 334 */       { if (this.n > parama.i && parama.h != 0)
/*     */         {
/* 336 */           j = (int)(j - this.n - parama.i);
/*     */ 
/*     */         
/*     */         }
/*     */          }
/*     */       
/*     */       else
/*     */       
/*     */       { 
/* 345 */         this.m = j;
/* 346 */         this.i = m;
/*     */ 
/*     */ 
/*     */         
/* 350 */         return 0; }  }  this.n = parama.i; this.m = j; this.i = m; return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int a(float[][][] paramArrayOffloat, int[] paramArrayOfint) {
/* 355 */     if (this.j < this.m) {
/*     */       
/* 357 */       for (byte b1 = 0; b1 < this.a.a; b1++) {
/* 358 */         paramArrayOfint[b1] = this.j;
/*     */       }
/* 360 */       paramArrayOffloat[0] = this.g;
/*     */       
/* 362 */       return this.m - this.j;
/*     */     } 
/* 364 */     return 0;
/*     */   }
/*     */   
/*     */   public final int a(int paramInt) {
/* 368 */     if (paramInt != 0 && this.j + paramInt > this.m)
/* 369 */       return -1; 
/* 370 */     this.j += paramInt;
/* 371 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */