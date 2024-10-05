/*     */ package b.a.a;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*  50 */   static byte a = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   static byte b = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   private final int[] c = new int[433];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   private byte[] e = new byte[1732];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int f;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int g;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int h;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Float i;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean j;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   private final int[] k = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071 };
/*     */ 
/*     */ 
/*     */   
/*     */   private final PushbackInputStream l;
/*     */ 
/*     */   
/* 114 */   private final g m = new g();
/*     */   
/* 116 */   private final byte[] n = new byte[4];
/*     */   
/* 118 */   private d[] o = new d[1];
/*     */   
/* 120 */   private byte[] p = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean q = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(InputStream paramInputStream) {
/* 130 */     if (paramInputStream == null) throw new NullPointerException("in"); 
/* 131 */     paramInputStream = new BufferedInputStream(paramInputStream);
/* 132 */     a(paramInputStream);
/* 133 */     this.q = true;
/*     */     
/* 135 */     this.l = new PushbackInputStream(paramInputStream, 1732);
/*     */     
/* 137 */     d();
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
/*     */   private void a(InputStream paramInputStream) {
/* 156 */     int i = -1;
/*     */ 
/*     */     
/* 159 */     try { paramInputStream.mark(10);
/* 160 */       i = b(paramInputStream); }
/*     */     
/* 162 */     catch (IOException iOException)
/*     */     
/*     */     { 
/*     */       try {
/* 166 */         paramInputStream.reset();
/* 167 */       } catch (IOException iOException1) {} } finally { try { paramInputStream.reset(); } catch (IOException iOException) {} }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 172 */       if (i > 0) {
/* 173 */         this.p = new byte[i];
/* 174 */         paramInputStream.read(this.p, 0, this.p.length);
/* 175 */         a(this.p);
/*     */       }  return;
/* 177 */     } catch (IOException iOException) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int b(InputStream paramInputStream) {
/* 189 */     byte[] arrayOfByte = new byte[4];
/* 190 */     int i = -10;
/* 191 */     paramInputStream.read(arrayOfByte, 0, 3);
/*     */     
/* 193 */     if (arrayOfByte[0] == 73 && arrayOfByte[1] == 68 && arrayOfByte[2] == 51) {
/* 194 */       paramInputStream.read(arrayOfByte, 0, 3);
/* 195 */       paramInputStream.read(arrayOfByte, 0, 4);
/* 196 */       i = (arrayOfByte[0] << 21) + (arrayOfByte[1] << 14) + (arrayOfByte[2] << 7) + arrayOfByte[3];
/*     */     } 
/* 198 */     return i + 10;
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
/*     */   private void a(byte[] paramArrayOfbyte) {
/* 215 */     if (paramArrayOfbyte == null)
/* 216 */       return;  if (!"ID3".equals(new String(paramArrayOfbyte, 0, 3)))
/*     */       return;  int i;
/* 218 */     if ((i = paramArrayOfbyte[3] & 0xFF) < 2 || i > 4) {
/*     */       return;
/*     */     }
/*     */     try {
/* 222 */       Float float_1 = null, float_2 = null;
/*     */       
/*     */       int j;
/* 225 */       for (j = 10; j < paramArrayOfbyte.length && paramArrayOfbyte[j] > 0; j += SYNTHETIC_LOCAL_VARIABLE_5) {
/* 226 */         if (i == 3 || i == 4) {
/*     */           
/* 228 */           String str1 = new String(paramArrayOfbyte, j, 4);
/* 229 */           int m = paramArrayOfbyte[j + 4] << 24 & 0xFF000000 | paramArrayOfbyte[j + 5] << 16 & 0xFF0000 | paramArrayOfbyte[j + 6] << 8 & 0xFF00 | paramArrayOfbyte[j + 7] & 0xFF;
/*     */           
/* 231 */           j += 10; String[] arrayOfString1;
/* 232 */           if (str1.equals("TXXX") && (
/*     */ 
/*     */             
/* 235 */             arrayOfString1 = (str1 = a(paramArrayOfbyte, j, m, 1)).split("\000")).length == 2) {
/* 236 */             String str3 = arrayOfString1[0];
/* 237 */             String str2 = arrayOfString1[1];
/* 238 */             if (str3.equals("replaygain_track_peak"))
/* 239 */             { float_2 = Float.valueOf(Float.parseFloat(str2));
/* 240 */               if (float_1 != null)
/* 241 */                 break;  continue; }  if (str3.equals("replaygain_track_gain")) {
/* 242 */               float_1 = Float.valueOf(Float.parseFloat(str2.replace(" dB", "")) + 3.0F);
/* 243 */               if (float_2 == null)
/*     */                 continue;  break;
/*     */             } 
/*     */           } 
/*     */           continue;
/*     */         } 
/* 249 */         String str = new String(paramArrayOfbyte, j, 3);
/* 250 */         int k = 0 + (paramArrayOfbyte[j + 3] << 16) + (paramArrayOfbyte[j + 4] << 8) + paramArrayOfbyte[j + 5];
/* 251 */         j += 6; String[] arrayOfString;
/* 252 */         if (str.equals("TXXX") && (
/*     */ 
/*     */           
/* 255 */           arrayOfString = (str = a(paramArrayOfbyte, j, k, 1)).split("\000")).length == 2) {
/* 256 */           String str2 = arrayOfString[0];
/* 257 */           String str1 = arrayOfString[1];
/* 258 */           if (str2.equals("replaygain_track_peak"))
/* 259 */           { float_2 = Float.valueOf(Float.parseFloat(str1));
/* 260 */             if (float_1 != null)
/* 261 */               break;  continue; }  if (str2.equals("replaygain_track_gain")) {
/* 262 */             float_1 = Float.valueOf(Float.parseFloat(str1.replace(" dB", "")) + 3.0F);
/* 263 */             if (float_2 == null)
/*     */               continue;  break;
/*     */           } 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 269 */       if (float_1 != null && float_2 != null) {
/* 270 */         this.i = Float.valueOf((float)Math.pow(10.0D, (float_1.floatValue() / 20.0F)));
/*     */         
/* 272 */         this.i = Float.valueOf(Math.min(1.0F / float_2.floatValue(), this.i.floatValue()));
/*     */       }  return;
/* 274 */     } catch (RuntimeException runtimeException) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   private static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/* 279 */     String str = null;
/*     */     try {
/* 281 */       String[] arrayOfString = { "ISO-8859-1", "UTF16", "UTF-16BE", "UTF-8" };
/* 282 */       str = new String(paramArrayOfbyte, paramInt1 + 1, paramInt2 - 1, arrayOfString[paramArrayOfbyte[paramInt1]]);
/* 283 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {}
/*     */     
/* 285 */     return str;
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
/*     */   public final void a() {
/*     */     try {
/* 298 */       this.l.close(); return;
/* 299 */     } catch (IOException iOException) {
/* 300 */       throw a(258, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final g b() {
/* 309 */     g g1 = null;
/*     */     try {
/* 311 */       g1 = f();
/*     */       
/* 313 */       if (this.q == true) {
/* 314 */         g1.a(this.e);
/* 315 */         this.q = false;
/*     */       } 
/* 317 */     } catch (c c2) {
/* 318 */       c c1; if ((c1 = null).a() == 261) {
/*     */ 
/*     */         
/*     */         try {
/* 322 */           d();
/* 323 */           g1 = f();
/* 324 */         } catch (c c) {
/* 325 */           if ((c1 = null).a() != 260)
/* 326 */             throw a(c1.a(), c1); 
/*     */         } 
/* 328 */       } else if (c1.a() != 260) {
/* 329 */         throw a(c1.a(), c1);
/*     */       } 
/* 331 */     }  return g1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private g f() {
/* 340 */     if (this.d == -1) g(); 
/* 341 */     return this.m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void g() {
/* 350 */     this.m.a(this, this.o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c() {
/* 359 */     if (this.f == -1 && this.g == -1 && this.d > 0) {
/* 360 */       try { this.l.unread(this.e, 0, this.d); return; }
/* 361 */       catch (IOException iOException)
/* 362 */       { throw b(258); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void d() {
/* 370 */     this.d = -1;
/* 371 */     this.f = -1;
/* 372 */     this.g = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(int paramInt) {
/* 379 */     int i = b(this.n, 0, 4);
/* 380 */     int j = this.n[0] << 24 & 0xFF000000 | this.n[1] << 16 & 0xFF0000 | this.n[2] << 8 & 0xFF00 | this.n[3] & 0xFF;
/*     */ 
/*     */     
/*     */     try {
/* 384 */       this.l.unread(this.n, 0, i);
/* 385 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/* 388 */     boolean bool = false;
/* 389 */     switch (i) {
/*     */       case 0:
/* 391 */         bool = true;
/*     */         break;
/*     */       case 4:
/* 394 */         bool = a(j, paramInt, this.h);
/*     */         break;
/*     */     } 
/*     */     
/* 398 */     return bool;
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
/*     */   protected static c b(int paramInt) {
/* 414 */     return new c(paramInt, null);
/*     */   }
/*     */   
/*     */   private static c a(int paramInt, Throwable paramThrowable) {
/* 418 */     return new c(paramInt, paramThrowable);
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
/*     */   final int a(byte paramByte) {
/*     */     int i;
/* 432 */     if ((i = b(this.n, 0, 3)) != 3) throw a(260, null);
/*     */     
/* 434 */     int j = this.n[0] << 16 & 0xFF0000 | this.n[1] << 8 & 0xFF00 | this.n[2] & 0xFF;
/*     */     boolean bool;
/*     */     do {
/* 437 */       j <<= 8;
/*     */       
/* 439 */       if (b(this.n, 3, 1) != 1) throw a(260, null);
/*     */       
/* 441 */       j |= this.n[3] & 0xFF;
/*     */     
/*     */     }
/* 444 */     while (!(bool = a(j, paramByte, this.h)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 449 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(int paramInt1, int paramInt2, int paramInt3) {
/* 455 */     if (paramInt2 == 0) {
/* 456 */       paramInt2 = ((paramInt1 & 0xFFE00000) == -2097152) ? 1 : 0;
/*     */     } else {
/* 458 */       paramInt2 = ((paramInt1 & 0xFFF80C00) == paramInt3 && (((paramInt1 & 0xC0) == 192)) == this.j) ? 1 : 0;
/*     */     } 
/*     */     
/* 461 */     if (paramInt2 != 0) paramInt2 = ((paramInt1 >>> 10 & 0x3) != 3) ? 1 : 0;
/*     */     
/* 463 */     if (paramInt2 != 0) paramInt2 = ((paramInt1 >>> 17 & 0x3) != 0) ? 1 : 0;
/*     */     
/* 465 */     if (paramInt2 != 0) paramInt2 = ((paramInt1 >>> 19 & 0x3) != 1) ? 1 : 0;
/*     */     
/* 467 */     return paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int c(int paramInt) {
/* 475 */     int i = a(this.e, 0, paramInt);
/* 476 */     this.d = paramInt;
/* 477 */     this.f = -1;
/* 478 */     this.g = -1;
/* 479 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void e() {
/* 487 */     byte b1 = 0;
/* 488 */     byte[] arrayOfByte = this.e;
/* 489 */     int i = this.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 501 */     for (j = 0; j < i; j += 4) {
/*     */       
/* 503 */       byte b3 = 0;
/* 504 */       byte b4 = 0;
/* 505 */       byte b5 = 0;
/* 506 */       byte b2 = arrayOfByte[j];
/* 507 */       if (j + 1 < i) b3 = arrayOfByte[j + 1]; 
/* 508 */       if (j + 2 < i) b4 = arrayOfByte[j + 2]; 
/* 509 */       if (j + 3 < i) b5 = arrayOfByte[j + 3]; 
/* 510 */       this.c[b1++] = b2 << 24 & 0xFF000000 | b3 << 16 & 0xFF0000 | b4 << 8 & 0xFF00 | b5 & 0xFF;
/*     */     } 
/* 512 */     this.f = 0;
/* 513 */     this.g = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int d(int paramInt) {
/* 522 */     int j = this.g + paramInt;
/*     */ 
/*     */ 
/*     */     
/* 526 */     if (this.f < 0) this.f = 0;
/*     */ 
/*     */     
/* 529 */     if (j <= 32) {
/*     */       
/* 531 */       int m = this.c[this.f] >>> 32 - j & this.k[paramInt];
/*     */       
/* 533 */       if ((this.g += paramInt) == 32) {
/* 534 */         this.g = 0;
/* 535 */         this.f++;
/*     */       } 
/* 537 */       return m;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 544 */     int i = this.c[this.f] & 0xFFFF;
/* 545 */     this.f++;
/* 546 */     int k = this.c[this.f] & 0xFFFF0000;
/*     */ 
/*     */ 
/*     */     
/* 550 */     i = (i = (i = i << 16 & 0xFFFF0000 | k >>> 16 & 0xFFFF) >>> 48 - j) & this.k[paramInt];
/* 551 */     this.g = j - 32;
/* 552 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void e(int paramInt) {
/* 559 */     this.h = paramInt & 0xFFFFFF3F;
/* 560 */     this.j = ((paramInt & 0xC0) == 192);
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
/*     */   private int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 573 */     int i = 0;
/*     */     try {
/* 575 */       while (paramInt2 > 0) {
/*     */         int j;
/* 577 */         if ((j = this.l.read(paramArrayOfbyte, paramInt1, paramInt2)) == -1) {
/* 578 */           while (paramInt2-- > 0) {
/* 579 */             paramArrayOfbyte[paramInt1++] = 0;
/*     */           }
/*     */           break;
/*     */         } 
/* 583 */         i += j;
/* 584 */         paramInt1 += j;
/* 585 */         paramInt2 -= j;
/*     */       } 
/* 587 */     } catch (IOException iOException) {
/* 588 */       throw a(258, iOException);
/*     */     } 
/* 590 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 597 */     int i = 0; try {
/*     */       int j;
/* 599 */       while (paramInt2 > 0 && (
/*     */         
/* 601 */         j = this.l.read(paramArrayOfbyte, paramInt1, paramInt2)) != -1) {
/* 602 */         i += j;
/* 603 */         paramInt1 += j;
/* 604 */         paramInt2 -= j;
/*     */       } 
/* 606 */     } catch (IOException iOException) {
/* 607 */       throw a(258, iOException);
/*     */     } 
/* 609 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */