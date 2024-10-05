/*     */ package com.a.a.b.d;
/*     */ 
/*     */ import com.a.a.b.c.g;
/*     */ import com.a.a.b.c.l;
/*     */ import com.a.a.b.e;
/*     */ import com.a.a.b.e.b;
/*     */ import com.a.a.b.f;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.p;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.CharConversionException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private final com.a.a.b.c.a a;
/*     */   private final InputStream b;
/*     */   private final byte[] c;
/*     */   private int d;
/*     */   private int e;
/*     */   private final boolean f;
/*     */   private boolean g = true;
/*     */   private int h;
/*     */   
/*     */   public a(com.a.a.b.c.a parama, InputStream paramInputStream) {
/*  88 */     this.a = parama;
/*  89 */     this.b = paramInputStream;
/*  90 */     this.c = parama.e();
/*  91 */     this.e = this.d = 0;
/*     */     
/*  93 */     this.f = true;
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
/*     */   private e a() {
/*     */     e e;
/* 124 */     boolean bool = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     if (d(4)) {
/* 134 */       int i = this.c[this.d] << 24 | (this.c[this.d + 1] & 0xFF) << 16 | (this.c[this.d + 2] & 0xFF) << 8 | this.c[this.d + 3] & 0xFF;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       if (a(i)) {
/* 140 */         bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 148 */       else if (b(i)) {
/* 149 */         bool = true;
/* 150 */       } else if (c(i >>> 16)) {
/* 151 */         bool = true;
/*     */       }
/*     */     
/* 154 */     } else if (d(2)) {
/* 155 */       int i = (this.c[this.d] & 0xFF) << 8 | this.c[this.d + 1] & 0xFF;
/*     */       
/* 157 */       if (c(i)) {
/* 158 */         bool = true;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     if (!bool)
/* 166 */     { e = e.a; }
/*     */     else
/* 168 */     { switch (this.h) { case 1:
/* 169 */           e = e.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 178 */           this.a.a(e);
/* 179 */           return e;case 2: e = this.g ? e.b : e.c; this.a.a(e); return e;case 4: e = this.g ? e.d : e.e; this.a.a(e); return e; }  throw new RuntimeException("Internal error"); }  this.a.a(e); return e;
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
/*     */   private Reader b() {
/*     */     InputStream inputStream;
/*     */     g g;
/*     */     e e;
/* 225 */     switch ((e = this.a.a()).c()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 8:
/*     */       case 16:
/* 232 */         if ((inputStream = this.b) == null) {
/* 233 */           inputStream = new ByteArrayInputStream(this.c, this.d, this.e);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 238 */         else if (this.d < this.e) {
/* 239 */           g = new g(this.a, inputStream, this.c, this.d, this.e);
/*     */         } 
/*     */         
/* 242 */         return new InputStreamReader((InputStream)g, e.a());
/*     */       
/*     */       case 32:
/* 245 */         return (Reader)new l(this.a, this.b, this.c, this.d, this.e, this.a
/* 246 */             .a().b());
/*     */     } 
/* 248 */     throw new RuntimeException("Internal error");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final l a(int paramInt1, p paramp, com.a.a.b.e.a parama, b paramb, int paramInt2) {
/* 255 */     int i = this.d;
/* 256 */     e e = a();
/* 257 */     i = this.d - i;
/*     */     
/* 259 */     if (e == e.a)
/*     */     {
/*     */ 
/*     */       
/* 263 */       if (f.a.b.a(paramInt2)) {
/* 264 */         parama = parama.a(paramInt2);
/* 265 */         return (l)new h(this.a, paramInt1, this.b, paramp, parama, this.c, this.d, this.e, i, true);
/*     */       } 
/*     */     }
/*     */     
/* 269 */     return (l)new g(this.a, paramInt1, b(), paramp, paramb
/* 270 */         .a(paramInt2));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(int paramInt) {
/* 431 */     switch (paramInt) {
/*     */       case 65279:
/* 433 */         this.g = true;
/* 434 */         this.d += 4;
/* 435 */         this.h = 4;
/* 436 */         return true;
/*     */       case -131072:
/* 438 */         this.d += 4;
/* 439 */         this.h = 4;
/* 440 */         this.g = false;
/* 441 */         return true;
/*     */       case 65534:
/* 443 */         a("2143");
/*     */         break;
/*     */       case -16842752:
/* 446 */         a("3412");
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/*     */     int i;
/* 452 */     if ((i = paramInt >>> 16) == 65279) {
/* 453 */       this.d += 2;
/* 454 */       this.h = 2;
/* 455 */       this.g = true;
/* 456 */       return true;
/*     */     } 
/* 458 */     if (i == 65534) {
/* 459 */       this.d += 2;
/* 460 */       this.h = 2;
/* 461 */       this.g = false;
/* 462 */       return true;
/*     */     } 
/*     */     
/* 465 */     if (paramInt >>> 8 == 15711167) {
/* 466 */       this.d += 3;
/* 467 */       this.h = 1;
/* 468 */       this.g = true;
/* 469 */       return true;
/*     */     } 
/* 471 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b(int paramInt) {
/* 479 */     if (paramInt >> 8 == 0) {
/* 480 */       this.g = true;
/* 481 */     } else if ((paramInt & 0xFFFFFF) == 0) {
/* 482 */       this.g = false;
/* 483 */     } else if ((paramInt & 0xFF00FFFF) == 0) {
/* 484 */       a("3412");
/* 485 */     } else if ((paramInt & 0xFFFF00FF) == 0) {
/* 486 */       a("2143");
/*     */     } else {
/*     */       
/* 489 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 493 */     this.h = 4;
/* 494 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean c(int paramInt) {
/* 499 */     if ((paramInt & 0xFF00) == 0) {
/* 500 */       this.g = true;
/* 501 */     } else if ((paramInt & 0xFF) == 0) {
/* 502 */       this.g = false;
/*     */     } else {
/* 504 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 508 */     this.h = 2;
/* 509 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(String paramString) {
/* 519 */     throw new CharConversionException("Unsupported UCS-4 endianness (" + paramString + ") detected");
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
/*     */   private boolean d(int paramInt) {
/* 532 */     int i = this.e - this.d;
/* 533 */     while (i < paramInt) {
/*     */       int j;
/*     */       
/* 536 */       if (this.b == null) {
/* 537 */         j = -1;
/*     */       } else {
/* 539 */         j = this.b.read(this.c, this.e, this.c.length - this.e);
/*     */       } 
/* 541 */       if (j <= 0) {
/* 542 */         return false;
/*     */       }
/* 544 */       this.e += j;
/* 545 */       i += j;
/*     */     } 
/* 547 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */