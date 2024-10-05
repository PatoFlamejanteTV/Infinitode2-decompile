/*     */ package org.a.c.d;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class h
/*     */   implements e
/*     */ {
/*     */   private final int a;
/*     */   private g b;
/*  40 */   private long c = 0L;
/*     */ 
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */ 
/*     */   
/*     */   private long e;
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] f;
/*     */ 
/*     */ 
/*     */   
/*     */   private int g;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean h = false;
/*     */ 
/*     */   
/*  63 */   private int[] i = new int[16];
/*     */   
/*  65 */   private int j = 0;
/*     */   
/*  67 */   private static final a k = c.a(h.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   h(g paramg) {
/*  78 */     paramg.c();
/*     */     
/*  80 */     this.b = paramg;
/*     */     
/*  82 */     this.a = 4096;
/*     */     
/*  84 */     h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void g() {
/*  95 */     if (this.b == null)
/*     */     {
/*  97 */       throw new IOException("Buffer already closed");
/*     */     }
/*  99 */     this.b.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void h() {
/* 109 */     if (this.j + 1 >= this.i.length) {
/*     */       int j;
/*     */ 
/*     */       
/* 113 */       if ((j = this.i.length << 1) < this.i.length) {
/*     */         
/* 115 */         if (this.i.length == Integer.MAX_VALUE)
/*     */         {
/* 117 */           throw new IOException("Maximum buffer size reached.");
/*     */         }
/* 119 */         j = Integer.MAX_VALUE;
/*     */       } 
/* 121 */       int[] arrayOfInt = new int[j];
/* 122 */       System.arraycopy(this.i, 0, arrayOfInt, 0, this.j);
/* 123 */       this.i = arrayOfInt;
/*     */     } 
/*     */     
/* 126 */     int i = this.b.b();
/*     */     
/* 128 */     this.i[this.j] = i;
/* 129 */     this.d = this.j;
/* 130 */     this.e = this.j * this.a;
/* 131 */     this.j++;
/* 132 */     this.f = new byte[this.a];
/* 133 */     this.g = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long c() {
/* 142 */     return this.c;
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
/*     */   private boolean a(boolean paramBoolean) {
/* 164 */     if (this.g >= this.a) {
/*     */ 
/*     */       
/* 167 */       if (this.h) {
/*     */ 
/*     */         
/* 170 */         this.b.a(this.i[this.d], this.f);
/* 171 */         this.h = false;
/*     */       } 
/*     */       
/* 174 */       if (this.d + 1 < this.j) {
/*     */ 
/*     */         
/* 177 */         this.f = this.b.a(this.i[++this.d]);
/* 178 */         this.e = this.d * this.a;
/* 179 */         this.g = 0;
/*     */       }
/* 181 */       else if (paramBoolean) {
/*     */ 
/*     */         
/* 184 */         h();
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 189 */         return false;
/*     */       } 
/*     */     } 
/* 192 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/* 201 */     g();
/*     */     
/* 203 */     a(true);
/*     */     
/* 205 */     this.f[this.g++] = (byte)paramInt;
/* 206 */     this.h = true;
/*     */     
/* 208 */     if (this.e + this.g > this.c)
/*     */     {
/* 210 */       this.c = this.e + this.g;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte[] paramArrayOfbyte) {
/* 220 */     b(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 229 */     g();
/*     */     
/* 231 */     paramInt2 = paramInt2;
/* 232 */     paramInt1 = paramInt1;
/*     */     
/* 234 */     while (paramInt2 > 0) {
/*     */       
/* 236 */       a(true);
/*     */       
/* 238 */       int i = Math.min(paramInt2, this.a - this.g);
/*     */       
/* 240 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.f, this.g, i);
/*     */       
/* 242 */       this.g += i;
/* 243 */       this.h = true;
/*     */       
/* 245 */       paramInt1 += i;
/* 246 */       paramInt2 -= i;
/*     */     } 
/*     */     
/* 249 */     if (this.e + this.g > this.c)
/*     */     {
/* 251 */       this.c = this.e + this.g;
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
/*     */   public final long a() {
/* 285 */     g();
/* 286 */     return this.e + this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(long paramLong) {
/* 295 */     g();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 300 */     if (paramLong > this.c)
/*     */     {
/* 302 */       throw new EOFException();
/*     */     }
/*     */     
/* 305 */     if (paramLong < 0L)
/*     */     {
/* 307 */       throw new IOException("Negative seek offset: " + paramLong);
/*     */     }
/*     */     
/* 310 */     if (paramLong >= this.e && paramLong <= this.e + this.a) {
/*     */ 
/*     */       
/* 313 */       this.g = (int)(paramLong - this.e);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 320 */     if (this.h) {
/*     */       
/* 322 */       this.b.a(this.i[this.d], this.f);
/* 323 */       this.h = false;
/*     */     } 
/*     */     
/* 326 */     int i = (int)(paramLong / this.a);
/*     */     
/* 328 */     this.f = this.b.a(this.i[i]);
/* 329 */     this.d = i;
/* 330 */     this.e = this.d * this.a;
/* 331 */     this.g = (int)(paramLong - this.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean d() {
/* 341 */     return (this.b == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int f() {
/*     */     int i;
/* 351 */     if ((i = b()) != -1)
/*     */     {
/* 353 */       b(1);
/*     */     }
/* 355 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(int paramInt) {
/* 364 */     a(this.e + this.g - paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] c(int paramInt) {
/*     */     int j;
/* 373 */     byte[] arrayOfByte = new byte[paramInt];
/*     */     
/* 375 */     int i = 0;
/*     */ 
/*     */     
/*     */     do {
/* 379 */       if ((j = a(arrayOfByte, i, paramInt - i)) < 0)
/*     */       {
/* 381 */         throw new EOFException();
/*     */       }
/*     */     }
/* 384 */     while ((i = i + j) < paramInt);
/*     */     
/* 386 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean e() {
/* 395 */     g();
/* 396 */     return (this.e + this.g >= this.c);
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
/*     */   public final int b() {
/* 415 */     g();
/*     */     
/* 417 */     if (this.e + this.g >= this.c)
/*     */     {
/* 419 */       return -1;
/*     */     }
/*     */     
/* 422 */     if (!a(false))
/*     */     {
/*     */       
/* 425 */       throw new IOException("Unexpectedly no bytes available for read in buffer.");
/*     */     }
/*     */     
/* 428 */     return this.f[this.g++] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b(byte[] paramArrayOfbyte) {
/* 437 */     return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 446 */     g();
/*     */     
/* 448 */     if (this.e + this.g >= this.c)
/*     */     {
/* 450 */       return -1;
/*     */     }
/*     */     
/* 453 */     paramInt2 = (int)Math.min(paramInt2, this.c - this.e + this.g);
/*     */     
/* 455 */     int i = 0;
/* 456 */     paramInt1 = paramInt1;
/*     */     
/* 458 */     while (paramInt2 > 0) {
/*     */       
/* 460 */       if (!a(false))
/*     */       {
/*     */         
/* 463 */         throw new IOException("Unexpectedly no bytes available for read in buffer.");
/*     */       }
/*     */       
/* 466 */       int j = Math.min(paramInt2, this.a - this.g);
/*     */       
/* 468 */       System.arraycopy(this.f, this.g, paramArrayOfbyte, paramInt1, j);
/*     */       
/* 470 */       this.g += j;
/* 471 */       i += j;
/* 472 */       paramInt1 += j;
/* 473 */       paramInt2 -= j;
/*     */     } 
/*     */     
/* 476 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 485 */     if (this.b != null) {
/*     */       
/* 487 */       this.b.a(this.i, 0, this.j);
/* 488 */       this.b = null;
/*     */       
/* 490 */       this.i = null;
/* 491 */       this.f = null;
/* 492 */       this.e = 0L;
/* 493 */       this.d = -1;
/* 494 */       this.g = 0;
/* 495 */       this.c = 0L;
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
/*     */   protected void finalize() {
/*     */     try {
/* 518 */       close();
/*     */       
/*     */       return;
/*     */     } finally {
/* 522 */       super.finalize();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */