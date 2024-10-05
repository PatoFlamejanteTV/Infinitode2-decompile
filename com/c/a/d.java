/*     */ package com.c.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*     */   private byte[] a;
/*     */   private int b;
/*     */   private int c;
/*     */   private int d;
/*     */   private int[] e;
/*     */   private long[] f;
/*     */   private int g;
/*     */   private int h;
/*     */   private int i;
/*     */   private int j;
/*     */   private int k;
/*     */   private int l;
/*     */   private long m;
/*     */   
/*     */   public d() {
/*  61 */     b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/*  70 */     this.b = 16384;
/*  71 */     this.a = new byte[this.b];
/*  72 */     this.g = 1024;
/*  73 */     this.e = new int[this.g];
/*  74 */     this.f = new long[this.g];
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/*  78 */     if (this.a == null) {
/*  79 */       b();
/*     */     } else {
/*     */       byte b;
/*  82 */       for (b = 0; b < this.a.length; b++)
/*  83 */         this.a[b] = 0; 
/*  84 */       for (b = 0; b < this.e.length; b++)
/*  85 */         this.e[b] = 0; 
/*  86 */       for (b = 0; b < this.f.length; b++)
/*  87 */         this.f[b] = 0L; 
/*     */     } 
/*  89 */     this.k = paramInt;
/*     */   }
/*     */   
/*     */   public final void a() {
/*  93 */     this.a = null;
/*  94 */     this.e = null;
/*  95 */     this.f = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(int paramInt) {
/* 103 */     if (this.b <= this.c + paramInt) {
/* 104 */       this.b += paramInt + 1024;
/* 105 */       byte[] arrayOfByte = new byte[this.b];
/* 106 */       System.arraycopy(this.a, 0, arrayOfByte, 0, this.a.length);
/* 107 */       this.a = arrayOfByte;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c(int paramInt) {
/* 112 */     if (this.g <= this.h + paramInt) {
/* 113 */       this.g += paramInt + 32;
/* 114 */       int[] arrayOfInt = new int[this.g];
/* 115 */       System.arraycopy(this.e, 0, arrayOfInt, 0, this.e.length);
/* 116 */       this.e = arrayOfInt;
/*     */       
/* 118 */       long[] arrayOfLong = new long[this.g];
/* 119 */       System.arraycopy(this.f, 0, arrayOfLong, 0, this.f.length);
/* 120 */       this.f = arrayOfLong;
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
/*     */   public final int a(b paramb) {
/* 180 */     int i = this.j;
/*     */     
/* 182 */     if (this.i <= i) {
/* 183 */       return 0;
/*     */     }
/*     */     
/* 186 */     if ((this.e[i] & 0x400) != 0) {
/*     */       
/* 188 */       this.j++;
/*     */ 
/*     */ 
/*     */       
/* 192 */       this.m++;
/* 193 */       return -1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 198 */     int j = this.e[i] & 0xFF;
/*     */ 
/*     */     
/* 201 */     paramb.a = this.a;
/* 202 */     paramb.b = this.d;
/* 203 */     paramb.e = this.e[i] & 0x200;
/* 204 */     paramb.d = this.e[i] & 0x100;
/* 205 */     int k = j + 0;
/*     */     
/* 207 */     while (j == 255) {
/*     */       int m;
/* 209 */       j = (m = this.e[++i]) & 0xFF;
/* 210 */       if ((m & 0x200) != 0)
/* 211 */         paramb.e = 512; 
/* 212 */       k += j;
/*     */     } 
/*     */     
/* 215 */     paramb.g = this.m;
/* 216 */     paramb.f = this.f[i];
/* 217 */     paramb.c = k;
/*     */     
/* 219 */     this.d += k;
/*     */     
/* 221 */     this.j = i + 1;
/*     */     
/* 223 */     this.m++;
/* 224 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(c paramc) {
/* 231 */     byte[] arrayOfByte1 = paramc.a;
/* 232 */     int j = paramc.b;
/* 233 */     byte[] arrayOfByte2 = paramc.d;
/* 234 */     int k = paramc.e;
/* 235 */     int m = paramc.f;
/* 236 */     byte b = 0;
/*     */     
/* 238 */     int n = paramc.a();
/* 239 */     int i1 = paramc.b();
/* 240 */     int i2 = paramc.c();
/* 241 */     int i3 = paramc.d();
/* 242 */     long l = paramc.e();
/* 243 */     int i4 = paramc.f();
/* 244 */     int i = paramc.g();
/* 245 */     int i5 = arrayOfByte1[j + 26] & 0xFF;
/*     */ 
/*     */ 
/*     */     
/* 249 */     int i6 = this.j;
/*     */     
/*     */     int i7;
/*     */     
/* 253 */     if ((i7 = this.d) != 0) {
/* 254 */       this.c -= i7;
/* 255 */       if (this.c != 0) {
/* 256 */         System.arraycopy(this.a, i7, this.a, 0, this.c);
/*     */       }
/* 258 */       this.d = 0;
/*     */     } 
/*     */     
/* 261 */     if (i6 != 0) {
/*     */       
/* 263 */       if (this.h - i6 != 0) {
/* 264 */         System.arraycopy(this.e, i6, this.e, 0, this.h - i6);
/* 265 */         System.arraycopy(this.f, i6, this.f, 0, this.h - i6);
/*     */       } 
/* 267 */       this.h -= i6;
/* 268 */       this.i -= i6;
/* 269 */       this.j = 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 274 */     if (i4 != this.k)
/* 275 */       return -1; 
/* 276 */     if (n > 0) {
/* 277 */       return -1;
/*     */     }
/* 279 */     c(i5 + 1);
/*     */ 
/*     */     
/* 282 */     if (i != this.l) {
/*     */ 
/*     */ 
/*     */       
/* 286 */       for (i6 = this.i; i6 < this.h; i6++) {
/* 287 */         this.c -= this.e[i6] & 0xFF;
/*     */       }
/*     */       
/* 290 */       this.h = this.i;
/*     */ 
/*     */       
/* 293 */       if (this.l != -1) {
/* 294 */         this.e[this.h++] = 1024;
/* 295 */         this.i++;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 300 */       if (i1 != 0) {
/* 301 */         i2 = 0;
/* 302 */         for (; b < i5; b++) {
/* 303 */           i7 = arrayOfByte1[j + 27 + b] & 0xFF;
/* 304 */           k += i7;
/* 305 */           m -= i7;
/* 306 */           if (i7 < 255) {
/* 307 */             b++;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 314 */     if (m != 0) {
/* 315 */       b(m);
/* 316 */       System.arraycopy(arrayOfByte2, k, this.a, this.c, m);
/* 317 */       this.c += m;
/*     */     } 
/*     */ 
/*     */     
/* 321 */     i6 = -1;
/* 322 */     while (b < i5) {
/* 323 */       i7 = arrayOfByte1[j + 27 + b] & 0xFF;
/* 324 */       this.e[this.h] = i7;
/* 325 */       this.f[this.h] = -1L;
/*     */       
/* 327 */       if (i2 != 0) {
/* 328 */         this.e[this.h] = this.e[this.h] | 0x100;
/* 329 */         i2 = 0;
/*     */       } 
/*     */       
/* 332 */       if (i7 < 255) {
/* 333 */         i6 = this.h;
/*     */       }
/* 335 */       this.h++;
/* 336 */       b++;
/*     */       
/* 338 */       if (i7 < 255) {
/* 339 */         this.i = this.h;
/*     */       }
/*     */     } 
/*     */     
/* 343 */     if (i6 != -1) {
/* 344 */       this.f[i6] = l;
/*     */     }
/*     */ 
/*     */     
/* 348 */     if (i3 != 0)
/*     */     {
/* 350 */       if (this.h > 0) {
/* 351 */         this.e[this.h - 1] = this.e[this.h - 1] | 0x200;
/*     */       }
/*     */     }
/* 354 */     this.l = i + 1;
/* 355 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\c\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */