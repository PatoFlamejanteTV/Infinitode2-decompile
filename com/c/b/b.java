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
/*     */ final class b
/*     */ {
/*     */   int a;
/*     */   private int b;
/*  34 */   private v c = new v();
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
/*     */   private float[] d;
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
/*     */   private a e;
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
/*  84 */   private int[] f = new int[15];
/*     */   
/*     */   final synchronized int a(float[] paramArrayOffloat, int paramInt1, com.c.a.a parama, int paramInt2) {
/*  87 */     paramInt2 /= this.a;
/*     */ 
/*     */ 
/*     */     
/*  91 */     if (this.f.length < paramInt2) {
/*  92 */       this.f = new int[paramInt2];
/*     */     }
/*     */     byte b1;
/*  95 */     for (b1 = 0; b1 < paramInt2; b1++) {
/*     */       int j;
/*  97 */       if ((j = a(parama)) == -1)
/*  98 */         return -1; 
/*  99 */       this.f[b1] = j * this.a;
/*     */     }  int i;
/* 101 */     for (b1 = 0, i = 0; b1 < this.a; b1++, i += paramInt2) {
/* 102 */       for (byte b2 = 0; b2 < paramInt2; b2++) {
/* 103 */         paramArrayOffloat[paramInt1 + i + b2] = paramArrayOffloat[paramInt1 + i + b2] + this.d[this.f[b2] + b1];
/*     */       }
/*     */     } 
/*     */     
/* 107 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int b(float[] paramArrayOffloat, int paramInt1, com.c.a.a parama, int paramInt2) {
/* 114 */     if (this.a > 8) {
/* 115 */       for (byte b1 = 0; b1 < paramInt2; ) {
/*     */         int i;
/* 117 */         if ((i = a(parama)) == -1)
/* 118 */           return -1; 
/* 119 */         int j = i * this.a;
/* 120 */         for (i = 0; i < this.a;) {
/* 121 */           paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + i++];
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 126 */       for (byte b1 = 0; b1 < paramInt2; ) {
/*     */         int i;
/* 128 */         if ((i = a(parama)) == -1)
/* 129 */           return -1; 
/* 130 */         int j = i * this.a;
/* 131 */         i = 0;
/* 132 */         switch (this.a) {
/*     */           case 8:
/* 134 */             i++; paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + 0];
/*     */           case 7:
/* 136 */             paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + i++];
/*     */           case 6:
/* 138 */             paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + i++];
/*     */           case 5:
/* 140 */             paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + i++];
/*     */           case 4:
/* 142 */             paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + i++];
/*     */           case 3:
/* 144 */             paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + i++];
/*     */           case 2:
/* 146 */             paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + i++];
/*     */           case 1:
/* 148 */             paramArrayOffloat[paramInt1 + b1++] = paramArrayOffloat[paramInt1 + b1++] + this.d[j + i];
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/* 154 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int c(float[] paramArrayOffloat, int paramInt1, com.c.a.a parama, int paramInt2) {
/* 161 */     for (byte b1 = 0; b1 < paramInt2; ) {
/*     */       int i;
/* 163 */       if ((i = a(parama)) == -1)
/* 164 */         return -1; 
/* 165 */       int j = i * this.a;
/* 166 */       for (i = 0; i < this.a;) {
/* 167 */         paramArrayOffloat[paramInt1 + b1++] = this.d[j + i++];
/*     */       }
/*     */     } 
/* 170 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   final int a(float[][] paramArrayOffloat, int paramInt1, int paramInt2, com.c.a.a parama, int paramInt3) {
/* 175 */     byte b1 = 0;
/*     */     
/* 177 */     for (int i = paramInt1 / paramInt2; i < (paramInt1 + paramInt3) / paramInt2; ) {
/*     */       int j;
/* 179 */       if ((j = a(parama)) == -1) {
/* 180 */         return -1;
/*     */       }
/* 182 */       int k = j * this.a;
/* 183 */       for (j = 0; j < this.a; j++) {
/* 184 */         paramArrayOffloat[b1++][i] = paramArrayOffloat[b1++][i] + this.d[k + j];
/* 185 */         if (b1 == paramInt2) {
/* 186 */           b1 = 0;
/* 187 */           i++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 191 */     return 0;
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
/*     */   final int a(com.c.a.a parama) {
/* 210 */     int i = 0;
/* 211 */     a a1 = this.e;
/*     */     
/*     */     int j;
/* 214 */     if ((j = parama.a(a1.c)) >= 0) {
/* 215 */       i = a1.a[j];
/* 216 */       parama.b(a1.b[j]);
/* 217 */       if (i <= 0) {
/* 218 */         return -i;
/*     */       }
/*     */     } 
/*     */     while (true) {
/* 222 */       switch (parama.a()) {
/*     */         case 0:
/* 224 */           i = a1.d[i];
/*     */           break;
/*     */         case 1:
/* 227 */           i = a1.e[i];
/*     */           break;
/*     */         
/*     */         default:
/* 231 */           return -1;
/*     */       } 
/*     */       
/* 234 */       if (i <= 0) {
/* 235 */         return -i;
/*     */       }
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
/*     */   final int a(v paramv) {
/* 318 */     this.c = paramv;
/* 319 */     this.b = paramv.b;
/* 320 */     this.a = paramv.a;
/* 321 */     this.d = paramv.a();
/*     */     
/* 323 */     this.e = a();
/* 324 */     if (this.e == null)
/*     */     {
/* 326 */       return -1;
/*     */     }
/* 328 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] a(int[] paramArrayOfint, int paramInt) {
/* 335 */     int[] arrayOfInt1 = new int[33];
/* 336 */     int[] arrayOfInt2 = new int[paramInt];
/*     */     byte b1;
/* 338 */     for (b1 = 0; b1 < paramInt; b1++) {
/*     */       int i;
/* 340 */       if ((i = paramArrayOfint[b1]) > 0) {
/* 341 */         int j = arrayOfInt1[i];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 349 */         if (i < 32 && j >>> i != 0)
/*     */         {
/*     */           
/* 352 */           return null;
/*     */         }
/* 354 */         arrayOfInt2[b1] = j;
/*     */ 
/*     */         
/*     */         int k;
/*     */         
/* 359 */         for (k = i; k > 0; k--) {
/* 360 */           if ((arrayOfInt1[k] & 0x1) != 0) {
/*     */             
/* 362 */             if (k == 1) {
/* 363 */               arrayOfInt1[1] = arrayOfInt1[1] + 1; break;
/*     */             } 
/* 365 */             arrayOfInt1[k] = arrayOfInt1[k - 1] << 1;
/*     */             
/*     */             break;
/*     */           } 
/* 369 */           arrayOfInt1[k] = arrayOfInt1[k] + 1;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 376 */         for (k = i + 1; k < 33 && 
/* 377 */           arrayOfInt1[k] >>> 1 == j; k++) {
/* 378 */           j = arrayOfInt1[k];
/* 379 */           arrayOfInt1[k] = arrayOfInt1[k - 1] << 1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 390 */     for (b1 = 0; b1 < paramInt; b1++) {
/* 391 */       int i = 0;
/* 392 */       for (byte b2 = 0; b2 < paramArrayOfint[b1]; b2++)
/*     */       {
/* 394 */         i = (i = i << 1) | arrayOfInt2[b1] >>> b2 & 0x1;
/*     */       }
/* 396 */       arrayOfInt2[b1] = i;
/*     */     } 
/*     */     
/* 399 */     return arrayOfInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   private a a() {
/* 404 */     byte b1 = 0;
/*     */     a a1;
/* 406 */     int[] arrayOfInt1 = (a1 = new a(this)).d = new int[this.b << 1];
/* 407 */     int[] arrayOfInt2 = a1.e = new int[this.b << 1];
/*     */     
/*     */     int[] arrayOfInt3;
/* 410 */     if ((arrayOfInt3 = a(this.c.c, this.c.b)) == null) {
/* 411 */       return null;
/*     */     }
/*     */     int i;
/* 414 */     for (i = 0; i < this.b; i++) {
/* 415 */       if (this.c.c[i] > 0) {
/* 416 */         int j = 0;
/*     */         byte b3;
/* 418 */         for (b3 = 0; b3 < this.c.c[i] - 1; b3++) {
/*     */           int k;
/* 420 */           if ((k = arrayOfInt3[i] >>> b3 & 0x1) == 0) {
/* 421 */             if (arrayOfInt1[j] == 0) {
/* 422 */               arrayOfInt1[j] = ++b1;
/*     */             }
/* 424 */             j = arrayOfInt1[j];
/*     */           } else {
/*     */             
/* 427 */             if (arrayOfInt2[j] == 0) {
/* 428 */               arrayOfInt2[j] = ++b1;
/*     */             }
/* 430 */             j = arrayOfInt2[j];
/*     */           } 
/*     */         } 
/*     */         
/* 434 */         if ((arrayOfInt3[i] >>> b3 & 0x1) == 0) {
/* 435 */           arrayOfInt1[j] = -i;
/*     */         } else {
/*     */           
/* 438 */           arrayOfInt2[j] = -i;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 444 */     a1.c = o.a(this.b) - 4;
/*     */     
/* 446 */     if (a1.c < 5)
/* 447 */       a1.c = 5; 
/* 448 */     i = 1 << a1.c;
/* 449 */     a1.a = new int[i];
/* 450 */     a1.b = new int[i];
/* 451 */     for (byte b2 = 0; b2 < i; b2++) {
/* 452 */       int j = 0;
/*     */       byte b3;
/* 454 */       for (b3 = 0; b3 < a1.c && (!j || b3 == 0); b3++) {
/* 455 */         if ((b2 & 1 << b3) != 0) {
/* 456 */           j = arrayOfInt2[j];
/*     */         } else {
/*     */           
/* 459 */           j = arrayOfInt1[j];
/*     */         } 
/*     */       } 
/* 462 */       a1.a[b2] = j;
/* 463 */       a1.b[b2] = b3;
/*     */     } 
/*     */     
/* 466 */     return a1;
/*     */   }
/*     */   
/*     */   class a {
/*     */     int[] a;
/*     */     int[] b;
/*     */     int c;
/*     */     int[] d;
/*     */     int[] e;
/*     */     
/*     */     a(b this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */