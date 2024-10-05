/*     */ package org.a.c.d;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */   implements Cloneable, e
/*     */ {
/*  33 */   private int a = 1024;
/*     */   
/*  35 */   private List<byte[]> b = null;
/*     */ 
/*     */   
/*     */   private byte[] c;
/*     */ 
/*     */   
/*     */   private long d;
/*     */ 
/*     */   
/*     */   private int e;
/*     */   
/*     */   private long f;
/*     */   
/*     */   private int g;
/*     */   
/*     */   private int h;
/*     */ 
/*     */   
/*     */   public b() {
/*  54 */     this(1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b(int paramInt) {
/*  63 */     this.b = (List)new ArrayList<byte>();
/*  64 */     this.a = paramInt;
/*  65 */     this.c = new byte[this.a];
/*  66 */     this.b.add(this.c);
/*  67 */     this.d = 0L;
/*  68 */     this.e = 0;
/*  69 */     this.f = 0L;
/*  70 */     this.g = 0;
/*  71 */     this.h = 0;
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
/*     */   public b(byte[] paramArrayOfbyte) {
/*  83 */     this.b = (List)new ArrayList<byte>(1);
/*  84 */     this.a = paramArrayOfbyte.length;
/*  85 */     this.c = paramArrayOfbyte;
/*  86 */     this.b.add(this.c);
/*  87 */     this.d = 0L;
/*  88 */     this.e = 0;
/*  89 */     this.f = this.a;
/*  90 */     this.g = 0;
/*  91 */     this.h = 0;
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
/*     */   private b g() {
/*     */     b b1;
/* 117 */     (b1 = new b(this.a)).b = (List)new ArrayList<byte>(this.b.size());
/* 118 */     for (Iterator<byte> iterator = this.b.iterator(); iterator.hasNext(); ) {
/*     */       
/* 120 */       byte[] arrayOfByte1, arrayOfByte2 = new byte[(arrayOfByte1 = (byte[])iterator.next()).length];
/* 121 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
/* 122 */       b1.b.add(arrayOfByte2);
/*     */     } 
/* 124 */     if (this.c != null) {
/*     */       
/* 126 */       b1.c = b1.b.get(b1.b.size() - 1);
/*     */     }
/*     */     else {
/*     */       
/* 130 */       b1.c = null;
/*     */     } 
/* 132 */     b1.d = this.d;
/* 133 */     b1.e = this.e;
/* 134 */     b1.f = this.f;
/* 135 */     b1.g = this.g;
/* 136 */     b1.h = this.h;
/*     */     
/* 138 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void close() {
/* 147 */     this.c = null;
/* 148 */     this.b.clear();
/* 149 */     this.d = 0L;
/* 150 */     this.e = 0;
/* 151 */     this.f = 0L;
/* 152 */     this.g = 0;
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
/*     */   public final void a(long paramLong) {
/* 177 */     j();
/* 178 */     if (paramLong < 0L)
/*     */     {
/* 180 */       throw new IOException("Invalid position " + paramLong);
/*     */     }
/* 182 */     this.d = paramLong;
/* 183 */     if (this.d < this.f) {
/*     */ 
/*     */       
/* 186 */       this.g = (int)(this.d / this.a);
/* 187 */       this.e = (int)(this.d % this.a);
/* 188 */       this.c = this.b.get(this.g);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 194 */     this.g = this.h;
/* 195 */     this.c = this.b.get(this.g);
/* 196 */     this.e = (int)(this.f % this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long a() {
/* 206 */     j();
/* 207 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 216 */     j();
/* 217 */     if (this.d >= this.f)
/*     */     {
/* 219 */       return -1;
/*     */     }
/* 221 */     if (this.e >= this.a) {
/*     */       
/* 223 */       if (this.g >= this.h)
/*     */       {
/* 225 */         return -1;
/*     */       }
/*     */ 
/*     */       
/* 229 */       this.c = this.b.get(++this.g);
/* 230 */       this.e = 0;
/*     */     } 
/*     */     
/* 233 */     this.d++;
/* 234 */     return this.c[this.e++] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 243 */     j();
/* 244 */     if (this.d >= this.f)
/*     */     {
/* 246 */       return 0;
/*     */     }
/* 248 */     int i = c(paramArrayOfbyte, paramInt1, paramInt2);
/* 249 */     while (i < paramInt2 && k() > 0) {
/*     */       
/* 251 */       i += c(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
/* 252 */       if (this.e == this.a)
/*     */       {
/* 254 */         i();
/*     */       }
/*     */     } 
/* 257 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private int c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 262 */     if (this.d >= this.f)
/*     */     {
/* 264 */       return 0;
/*     */     }
/* 266 */     paramInt2 = (int)Math.min(paramInt2, this.f - this.d);
/*     */     
/*     */     int i;
/* 269 */     if ((i = this.a - this.e) == 0)
/*     */     {
/* 271 */       return 0;
/*     */     }
/* 273 */     if (paramInt2 >= i) {
/*     */ 
/*     */       
/* 276 */       System.arraycopy(this.c, this.e, paramArrayOfbyte, paramInt1, i);
/*     */       
/* 278 */       this.e += i;
/* 279 */       this.d += i;
/* 280 */       return i;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 285 */     System.arraycopy(this.c, this.e, paramArrayOfbyte, paramInt1, paramInt2);
/*     */     
/* 287 */     this.e += paramInt2;
/* 288 */     this.d += paramInt2;
/* 289 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long c() {
/* 299 */     j();
/* 300 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/* 309 */     j();
/*     */     
/* 311 */     if (this.e >= this.a) {
/*     */       
/* 313 */       if (this.d + this.a >= 2147483647L)
/*     */       {
/* 315 */         throw new IOException("RandomAccessBuffer overflow");
/*     */       }
/* 317 */       h();
/*     */     } 
/* 319 */     this.c[this.e++] = (byte)paramInt;
/* 320 */     this.d++;
/* 321 */     if (this.d > this.f)
/*     */     {
/* 323 */       this.f = this.d;
/*     */     }
/*     */     
/* 326 */     if (this.e >= this.a) {
/*     */       
/* 328 */       if (this.d + this.a >= 2147483647L)
/*     */       {
/* 330 */         throw new IOException("RandomAccessBuffer overflow");
/*     */       }
/* 332 */       h();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte[] paramArrayOfbyte) {
/* 343 */     b(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 352 */     j();
/* 353 */     long l = this.d + paramInt2;
/* 354 */     int i = this.a - this.e;
/* 355 */     if (paramInt2 >= i) {
/*     */       
/* 357 */       if (l > 2147483647L)
/*     */       {
/* 359 */         throw new IOException("RandomAccessBuffer overflow");
/*     */       }
/*     */       
/* 362 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.c, this.e, i);
/* 363 */       paramInt1 += i;
/*     */       
/*     */       long l1;
/* 366 */       int j = (int)(l1 = (paramInt2 - i)) / this.a;
/* 367 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         
/* 369 */         h();
/* 370 */         System.arraycopy(paramArrayOfbyte, paramInt1, this.c, this.e, this.a);
/* 371 */         paramInt1 += this.a;
/*     */       } 
/*     */ 
/*     */       
/* 375 */       if ((l1 = l1 - j * this.a) >= 0L)
/*     */       {
/* 377 */         h();
/* 378 */         if (l1 > 0L)
/*     */         {
/* 380 */           System.arraycopy(paramArrayOfbyte, paramInt1, this.c, this.e, (int)l1);
/*     */         }
/* 382 */         this.e = (int)l1;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 387 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.c, this.e, paramInt2);
/* 388 */       this.e += paramInt2;
/*     */     } 
/* 390 */     this.d += paramInt2;
/* 391 */     if (this.d > this.f)
/*     */     {
/* 393 */       this.f = this.d;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void h() {
/* 402 */     if (this.h > this.g) {
/*     */ 
/*     */       
/* 405 */       i();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 410 */     this.c = new byte[this.a];
/* 411 */     this.b.add(this.c);
/* 412 */     this.e = 0;
/* 413 */     this.h++;
/* 414 */     this.g++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void i() {
/* 423 */     if (this.g == this.h)
/*     */     {
/* 425 */       throw new IOException("No more chunks available, end of buffer reached");
/*     */     }
/* 427 */     this.e = 0;
/* 428 */     this.c = this.b.get(++this.g);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void j() {
/* 437 */     if (this.c == null)
/*     */     {
/*     */       
/* 440 */       throw new IOException("RandomAccessBuffer already closed");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean d() {
/* 451 */     return (this.c == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean e() {
/* 460 */     j();
/* 461 */     return (this.d >= this.f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int k() {
/* 470 */     return (int)Math.min(c() - a(), 2147483647L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int f() {
/*     */     int i;
/* 480 */     if ((i = b()) != -1)
/*     */     {
/* 482 */       b(1);
/*     */     }
/* 484 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(int paramInt) {
/* 493 */     j();
/* 494 */     a(a() - paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] c(int paramInt) {
/* 503 */     byte[] arrayOfByte = new byte[paramInt];
/* 504 */     int i = b(arrayOfByte);
/* 505 */     while (i < paramInt)
/*     */     {
/* 507 */       i += a(arrayOfByte, i, paramInt - i);
/*     */     }
/* 509 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b(byte[] paramArrayOfbyte) {
/* 518 */     return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */