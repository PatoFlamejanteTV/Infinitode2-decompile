/*     */ package com.c.b;
/*     */ 
/*     */ import com.c.a.a;
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
/*     */ final class v
/*     */ {
/*     */   int a;
/*     */   int b;
/*     */   int[] c;
/*     */   private int d;
/*     */   private int e;
/*     */   private int f;
/*     */   private int g;
/*     */   private int h;
/*     */   private int[] i;
/*     */   
/*     */   final int a(a parama) {
/*     */     byte b;
/*     */     int i;
/* 188 */     if (parama.c(24) != 5653314)
/*     */     {
/*     */       
/* 191 */       return -1;
/*     */     }
/*     */ 
/*     */     
/* 195 */     this.a = parama.c(16);
/* 196 */     this.b = parama.c(24);
/* 197 */     if (this.b == -1)
/*     */     {
/*     */       
/* 200 */       return -1;
/*     */     }
/*     */ 
/*     */     
/* 204 */     switch (parama.c(1)) {
/*     */       
/*     */       case 0:
/* 207 */         this.c = new int[this.b];
/*     */ 
/*     */         
/* 210 */         if (parama.c(1) != 0) {
/*     */ 
/*     */           
/* 213 */           for (byte b1 = 0; b1 < this.b; b1++) {
/* 214 */             if (parama.c(1) != 0) {
/*     */               int j;
/* 216 */               if ((j = parama.c(5)) == -1)
/*     */               {
/*     */                 
/* 219 */                 return -1;
/*     */               }
/* 221 */               this.c[b1] = j + 1;
/*     */             } else {
/*     */               
/* 224 */               this.c[b1] = 0;
/*     */             } 
/*     */           } 
/*     */           
/*     */           break;
/*     */         } 
/* 230 */         for (b = 0; b < this.b; b++) {
/*     */           int j;
/* 232 */           if ((j = parama.c(5)) == -1)
/*     */           {
/*     */             
/* 235 */             return -1;
/*     */           }
/* 237 */           this.c[b] = j + 1;
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/* 244 */         i = parama.c(5) + 1;
/* 245 */         this.c = new int[this.b];
/*     */         
/* 247 */         for (b = 0; b < this.b; ) {
/*     */           int j;
/* 249 */           if ((j = parama.c(o.a(this.b - b))) == -1)
/*     */           {
/*     */             
/* 252 */             return -1;
/*     */           }
/* 254 */           for (byte b1 = 0; b1 < j; b1++, b++) {
/* 255 */             this.c[b] = i;
/*     */           }
/* 257 */           i++;
/*     */         } 
/*     */         break;
/*     */ 
/*     */       
/*     */       default:
/* 263 */         return -1;
/*     */     } 
/*     */ 
/*     */     
/* 267 */     switch (this.d = parama.c(4)) {
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
/*     */       case 0:
/* 309 */         return 0;
/*     */       case 1:
/*     */       case 2:
/*     */         this.e = parama.c(32); this.f = parama.c(32); this.g = parama.c(4) + 1; this.h = parama.c(1); i = 0; switch (this.d) {
/*     */           case 1:
/*     */             i = b(); break;
/*     */           case 2:
/*     */             i = this.b * this.a; break;
/*     */         }  this.i = new int[i]; for (b = 0; b < i; b++)
/*     */           this.i[b] = parama.c(this.g);  if (this.i[i - 1] == -1)
/*     */           return -1; 
/* 320 */     }  return -1; } private int b() { int i = (int)Math.floor(Math.pow(this.b, 1.0D / this.a));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 328 */       int j = 1;
/* 329 */       int k = 1;
/* 330 */       for (byte b = 0; b < this.a; b++) {
/* 331 */         j *= i;
/* 332 */         k *= i + 1;
/*     */       } 
/* 334 */       if (j <= this.b && k > this.b) {
/* 335 */         return i;
/*     */       }
/*     */       
/* 338 */       if (j > this.b) {
/* 339 */         i--;
/*     */         continue;
/*     */       } 
/* 342 */       i++;
/*     */     }  }
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
/*     */   final float[] a() {
/* 358 */     if (this.d == 1 || this.d == 2) {
/*     */       int i; byte b;
/* 360 */       float f1 = a(this.e);
/* 361 */       float f2 = a(this.f);
/* 362 */       float[] arrayOfFloat = new float[this.b * this.a];
/*     */ 
/*     */ 
/*     */       
/* 366 */       switch (this.d) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 1:
/* 374 */           i = b();
/* 375 */           for (b = 0; b < this.b; b++) {
/* 376 */             float f = 0.0F;
/* 377 */             int j = 1;
/* 378 */             for (byte b1 = 0; b1 < this.a; b1++) {
/* 379 */               int k = b / j % i;
/*     */               
/* 381 */               float f3 = Math.abs(f3 = this.i[k]) * f2 + f1 + f;
/* 382 */               if (this.h != 0)
/* 383 */                 f = f3; 
/* 384 */               arrayOfFloat[b * this.a + b1] = f3;
/* 385 */               j *= i;
/*     */             } 
/*     */           } 
/*     */           break;
/*     */         case 2:
/* 390 */           for (b = 0; b < this.b; b++) {
/* 391 */             float f = 0.0F;
/* 392 */             for (byte b1 = 0; b1 < this.a; b1++) {
/*     */ 
/*     */               
/* 395 */               float f3 = Math.abs(f3 = this.i[b * this.a + b1]) * f2 + f1 + f;
/* 396 */               if (this.h != 0)
/* 397 */                 f = f3; 
/* 398 */               arrayOfFloat[b * this.a + b1] = f3;
/*     */             } 
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       
/* 404 */       return arrayOfFloat;
/*     */     } 
/* 406 */     return null;
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
/*     */   private static float a(int paramInt) {
/* 433 */     float f1 = (paramInt & 0x1FFFFF);
/* 434 */     float f2 = ((paramInt & 0x7FE00000) >>> 21);
/* 435 */     if ((paramInt & Integer.MIN_VALUE) != 0)
/* 436 */       f1 = -f1; 
/* 437 */     return a(f1, (int)f2 - 20 - 768);
/*     */   }
/*     */   
/*     */   private static float a(float paramFloat, int paramInt) {
/* 441 */     return (float)(paramFloat * Math.pow(2.0D, paramInt));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\b\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */