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
/*     */ final class q
/*     */ {
/*     */   private int a;
/*     */   private int b;
/*     */   private float[] c;
/*     */   private int[] d;
/*     */   
/*     */   final void a(int paramInt) {
/*  40 */     this.d = new int[paramInt / 4];
/*  41 */     this.c = new float[paramInt + paramInt / 4];
/*     */     
/*  43 */     this.b = (int)Math.rint(Math.log(paramInt) / Math.log(2.0D));
/*  44 */     this.a = paramInt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     int i, j = (i = 0 + paramInt / 2) + 1;
/*     */     
/*  51 */     int k, m = (k = i + paramInt / 2) + 1;
/*     */     int n;
/*  53 */     for (n = 0; n < paramInt / 4; n++) {
/*  54 */       this.c[0 + (n << 1)] = (float)Math.cos(Math.PI / paramInt * (4 * n));
/*  55 */       this.c[1 + (n << 1)] = (float)-Math.sin(Math.PI / paramInt * (4 * n));
/*  56 */       this.c[i + (n << 1)] = (float)Math.cos(Math.PI / (2 * paramInt) * (2 * n + 1));
/*  57 */       this.c[j + (n << 1)] = (float)Math.sin(Math.PI / (2 * paramInt) * (2 * n + 1));
/*     */     } 
/*  59 */     for (n = 0; n < paramInt / 8; n++) {
/*  60 */       this.c[k + (n << 1)] = (float)Math.cos(Math.PI / paramInt * (4 * n + 2));
/*  61 */       this.c[m + (n << 1)] = (float)-Math.sin(Math.PI / paramInt * (4 * n + 2));
/*     */     } 
/*     */ 
/*     */     
/*  65 */     n = (1 << this.b - 1) - 1;
/*  66 */     i = 1 << this.b - 2;
/*  67 */     for (j = 0; j < paramInt / 8; j++) {
/*  68 */       k = 0;
/*  69 */       for (m = 0; i >>> m != 0; m++) {
/*  70 */         if ((i >>> m & j) != 0)
/*  71 */           k |= 1 << m; 
/*  72 */       }  this.d[j << 1] = (k ^ 0xFFFFFFFF) & n;
/*     */       
/*  74 */       this.d[(j << 1) + 1] = k;
/*     */     } 
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
/*  86 */   private float[] e = new float[1024];
/*  87 */   private float[] f = new float[1024];
/*     */   
/*     */   final synchronized void a(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/*  90 */     if (this.e.length < this.a / 2) {
/*  91 */       this.e = new float[this.a / 2];
/*     */     }
/*  93 */     if (this.f.length < this.a / 2) {
/*  94 */       this.f = new float[this.a / 2];
/*     */     }
/*  96 */     float[] arrayOfFloat1 = this.e;
/*  97 */     float[] arrayOfFloat2 = this.f;
/*  98 */     int m = this.a >>> 1;
/*  99 */     int n = this.a >>> 2;
/* 100 */     int i1 = this.a >>> 3;
/*     */ 
/*     */ 
/*     */     
/* 104 */     int i2 = 1;
/* 105 */     byte b = 0;
/* 106 */     int i3 = m;
/*     */     
/*     */     int i4;
/* 109 */     for (i4 = 0; i4 < i1; i4++) {
/* 110 */       i3 -= 2;
/* 111 */       arrayOfFloat1[b++] = -paramArrayOffloat1[i2 + 2] * this.c[i3 + 1] - paramArrayOffloat1[i2] * this.c[i3];
/* 112 */       arrayOfFloat1[b++] = paramArrayOffloat1[i2] * this.c[i3 + 1] - paramArrayOffloat1[i2 + 2] * this.c[i3];
/* 113 */       i2 += 4;
/*     */     } 
/*     */     
/* 116 */     i2 = m - 4;
/*     */     
/* 118 */     for (i4 = 0; i4 < i1; i4++) {
/* 119 */       i3 -= 2;
/* 120 */       arrayOfFloat1[b++] = paramArrayOffloat1[i2] * this.c[i3 + 1] + paramArrayOffloat1[i2 + 2] * this.c[i3];
/* 121 */       arrayOfFloat1[b++] = paramArrayOffloat1[i2] * this.c[i3] - paramArrayOffloat1[i2 + 2] * this.c[i3 + 1];
/* 122 */       i2 -= 4;
/*     */     } 
/*     */ 
/*     */     
/* 126 */     float[] arrayOfFloat3 = a(arrayOfFloat1, arrayOfFloat2, this.a, m, n, i1);
/* 127 */     b = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     i3 = m;
/* 133 */     int i = (i4 = n) - 1;
/* 134 */     int j, k = (j = n + m) - 1;
/*     */     
/* 136 */     for (m = 0; m < n; m++) {
/* 137 */       float f1 = arrayOfFloat3[b] * this.c[i3 + 1] - arrayOfFloat3[b + 1] * this.c[i3];
/* 138 */       float f2 = -(arrayOfFloat3[b] * this.c[i3] + arrayOfFloat3[b + 1] * this.c[i3 + 1]);
/*     */       
/* 140 */       paramArrayOffloat2[i4] = -f1;
/* 141 */       paramArrayOffloat2[i] = f1;
/* 142 */       paramArrayOffloat2[j] = f2;
/* 143 */       paramArrayOffloat2[k] = f2;
/*     */       
/* 145 */       i4++;
/* 146 */       i--;
/* 147 */       j++;
/* 148 */       k--;
/* 149 */       b += 2;
/* 150 */       i3 += 2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float[] a(float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 159 */     int i = paramInt3;
/* 160 */     int j = 0;
/* 161 */     int k = paramInt3;
/* 162 */     int m = paramInt2;
/*     */     int n;
/* 164 */     for (n = 0; n < paramInt3; ) {
/* 165 */       float f1 = paramArrayOffloat1[i] - paramArrayOffloat1[j];
/*     */       
/* 167 */       paramArrayOffloat2[k + n] = paramArrayOffloat1[i++] + paramArrayOffloat1[j++];
/*     */       
/* 169 */       float f2 = paramArrayOffloat1[i] - paramArrayOffloat1[j];
/* 170 */       m -= 4;
/*     */       
/* 172 */       paramArrayOffloat2[n++] = f1 * this.c[m] + f2 * this.c[m + 1];
/* 173 */       paramArrayOffloat2[n] = f2 * this.c[m] - f1 * this.c[m + 1];
/*     */       
/* 175 */       paramArrayOffloat2[k + n] = paramArrayOffloat1[i++] + paramArrayOffloat1[j++];
/* 176 */       n++;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     for (n = 0; n < this.b - 3; n++) {
/* 183 */       int i1 = paramInt1 >>> n + 2;
/* 184 */       int i2 = 1 << n + 3;
/* 185 */       paramInt3 = paramInt2 - 2;
/*     */       
/* 187 */       m = 0;
/*     */ 
/*     */       
/* 190 */       for (j = 0; j < i1 >>> 2; j++) {
/*     */         int i3;
/* 192 */         k = (i3 = paramInt3) - (i1 >> 1);
/* 193 */         float f1 = this.c[m];
/* 194 */         float f2 = this.c[m + 1];
/* 195 */         paramInt3 -= 2;
/*     */         
/* 197 */         i1++;
/* 198 */         for (byte b = 0; b < 2 << n; b++) {
/* 199 */           float f4 = paramArrayOffloat2[i3] - paramArrayOffloat2[k];
/* 200 */           paramArrayOffloat1[i3] = paramArrayOffloat2[i3] + paramArrayOffloat2[k];
/*     */           
/* 202 */           float f3 = paramArrayOffloat2[++i3] - paramArrayOffloat2[++k];
/* 203 */           paramArrayOffloat1[i3] = paramArrayOffloat2[i3] + paramArrayOffloat2[k];
/*     */           
/* 205 */           paramArrayOffloat1[k] = f3 * f1 - f4 * f2;
/* 206 */           paramArrayOffloat1[k - 1] = f4 * f1 + f3 * f2;
/*     */           
/* 208 */           i3 -= i1;
/* 209 */           k -= i1;
/*     */         } 
/* 211 */         i1--;
/* 212 */         m += i2;
/*     */       } 
/*     */       
/* 215 */       float[] arrayOfFloat = paramArrayOffloat2;
/* 216 */       paramArrayOffloat2 = paramArrayOffloat1;
/* 217 */       paramArrayOffloat1 = arrayOfFloat;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     n = paramInt1;
/* 224 */     byte b1 = 0;
/* 225 */     byte b2 = 0;
/* 226 */     paramInt3 = paramInt2 - 1;
/*     */     
/* 228 */     for (i = 0; i < paramInt4; i++) {
/* 229 */       j = this.d[b1++];
/* 230 */       int i1 = this.d[b1++];
/*     */       
/* 232 */       float f4 = paramArrayOffloat2[j] - paramArrayOffloat2[i1 + 1];
/* 233 */       float f5 = paramArrayOffloat2[j - 1] + paramArrayOffloat2[i1];
/* 234 */       float f6 = paramArrayOffloat2[j] + paramArrayOffloat2[i1 + 1];
/* 235 */       float f7 = paramArrayOffloat2[j - 1] - paramArrayOffloat2[i1];
/*     */       
/* 237 */       float f8 = f4 * this.c[n];
/* 238 */       float f1 = f5 * this.c[n++];
/* 239 */       float f2 = f4 * this.c[n];
/* 240 */       float f3 = f5 * this.c[n++];
/*     */       
/* 242 */       paramArrayOffloat1[b2++] = (f6 + f2 + f1) * 0.5F;
/* 243 */       paramArrayOffloat1[paramInt3--] = (-f7 + f3 - f8) * 0.5F;
/* 244 */       paramArrayOffloat1[b2++] = (f7 + f3 - f8) * 0.5F;
/* 245 */       paramArrayOffloat1[paramInt3--] = (f6 - f2 - f1) * 0.5F;
/*     */     } 
/*     */     
/* 248 */     return paramArrayOffloat1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */