/*     */ package org.a.c.h.c;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.c;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.h.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */   implements c
/*     */ {
/*     */   private final org.a.c.b.d a;
/*     */   private k b;
/*     */   
/*     */   public d() {
/*  87 */     this.a = new org.a.c.b.d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d(org.a.c.b.d paramd) {
/*  96 */     this.a = paramd;
/*  97 */     this.b = l.a.a(r());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a() {
/* 107 */     if (this.b == null)
/*     */     {
/* 109 */       throw new IOException("No security handler for filter " + r());
/*     */     }
/* 111 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(k paramk) {
/* 120 */     this.b = paramk;
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
/*     */   public final org.a.c.b.d b() {
/* 153 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/* 163 */     this.a.a(j.aY, (b)j.a(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String r() {
/* 173 */     return this.a.g(j.aY);
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
/*     */   public final void b(String paramString) {
/* 193 */     this.a.a(j.dC, paramString);
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
/*     */   public final void a(int paramInt) {
/* 206 */     this.a.a(j.dU, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c() {
/* 217 */     return this.a.b(j.dU, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(int paramInt) {
/* 227 */     this.a.a(j.bX, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int d() {
/* 238 */     return this.a.b(j.bX, 40);
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
/*     */   public final void c(int paramInt) {
/* 254 */     this.a.a(j.da, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int e() {
/* 265 */     return this.a.b(j.da, 0);
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
/*     */   public final void a(byte[] paramArrayOfbyte) {
/* 277 */     this.a.a(j.ct, (b)new s(paramArrayOfbyte));
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
/*     */   public final byte[] g() {
/* 289 */     byte[] arrayOfByte = null;
/*     */     s s;
/* 291 */     if ((s = (s)this.a.a(j.ct)) != null)
/*     */     {
/* 293 */       arrayOfByte = s.c();
/*     */     }
/* 295 */     return arrayOfByte;
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
/*     */   public final void b(byte[] paramArrayOfbyte) {
/* 307 */     this.a.a(j.dR, (b)new s(paramArrayOfbyte));
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
/*     */   public final byte[] h() {
/* 319 */     byte[] arrayOfByte = null;
/*     */     s s;
/* 321 */     if ((s = (s)this.a.a(j.dR)) != null)
/*     */     {
/* 323 */       arrayOfByte = s.c();
/*     */     }
/* 325 */     return arrayOfByte;
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
/*     */   public final void c(byte[] paramArrayOfbyte) {
/* 337 */     this.a.a(j.cA, (b)new s(paramArrayOfbyte));
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
/*     */   public final byte[] i() {
/* 349 */     byte[] arrayOfByte = null;
/*     */     s s;
/* 351 */     if ((s = (s)this.a.a(j.cA)) != null)
/*     */     {
/* 353 */       arrayOfByte = s.c();
/*     */     }
/* 355 */     return arrayOfByte;
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
/*     */   public final void d(byte[] paramArrayOfbyte) {
/* 367 */     this.a.a(j.dS, (b)new s(paramArrayOfbyte));
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
/*     */   public final byte[] j() {
/* 379 */     byte[] arrayOfByte = null;
/*     */     s s;
/* 381 */     if ((s = (s)this.a.a(j.dS)) != null)
/*     */     {
/* 383 */       arrayOfByte = s.c();
/*     */     }
/* 385 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void d(int paramInt) {
/* 395 */     this.a.a(j.cJ, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int k() {
/* 405 */     return this.a.b(j.cJ, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean l() {
/* 416 */     boolean bool = true;
/*     */     
/*     */     b b;
/*     */     
/* 420 */     if (b = this.a.a(j.aT) instanceof c)
/*     */     {
/* 422 */       bool = ((c)b).a();
/*     */     }
/*     */     
/* 425 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte[][] paramArrayOfbyte) {
/* 436 */     a a = new a(); int i; byte b;
/* 437 */     for (i = (paramArrayOfbyte = paramArrayOfbyte).length, b = 0; b < i; ) { byte[] arrayOfByte = paramArrayOfbyte[b];
/*     */       
/* 439 */       s s = new s(arrayOfByte);
/* 440 */       a.a((b)s); b++; }
/*     */     
/* 442 */     this.a.a(j.dc, (b)a);
/* 443 */     a.a(true);
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
/*     */   public final c m() {
/* 477 */     return c(j.du);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c n() {
/* 487 */     return c(j.at);
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
/*     */   private c c(j paramj) {
/*     */     b b;
/* 501 */     if (b = this.a.a(j.Q) instanceof org.a.c.b.d) {
/*     */       b b1;
/*     */       
/* 504 */       if (b1 = ((org.a.c.b.d)b).a(paramj) instanceof org.a.c.b.d)
/*     */       {
/* 506 */         return new c((org.a.c.b.d)b1);
/*     */       }
/*     */     } 
/* 509 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(j paramj, c paramc) {
/*     */     org.a.c.b.d d1;
/* 521 */     if ((d1 = this.a.d(j.Q)) == null) {
/*     */       
/* 523 */       d1 = new org.a.c.b.d();
/* 524 */       this.a.a(j.Q, (b)d1);
/*     */     } 
/* 526 */     d1.a(true);
/* 527 */     d1.a(paramj, (b)paramc.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(c paramc) {
/* 537 */     paramc.a().a(true);
/* 538 */     a(j.du, paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(c paramc) {
/* 548 */     paramc.a().a(true);
/* 549 */     a(j.at, paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j o() {
/*     */     j j;
/* 561 */     if ((j = (j)this.a.a(j.dw)) == null)
/*     */     {
/* 563 */       j = j.bB;
/*     */     }
/* 565 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(j paramj) {
/* 575 */     this.a.a(j.dw, (b)paramj);
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
/*     */   public final void b(j paramj) {
/* 601 */     this.a.a(j.dx, (b)paramj);
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
/*     */   public final void e(byte[] paramArrayOfbyte) {
/* 613 */     this.a.a(j.cR, (b)new s(paramArrayOfbyte));
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
/*     */   public final byte[] p() {
/* 625 */     byte[] arrayOfByte = null;
/*     */     s s;
/* 627 */     if ((s = (s)this.a.a(j.cR)) != null)
/*     */     {
/* 629 */       arrayOfByte = s.c();
/*     */     }
/* 631 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void q() {
/* 639 */     this.a.a(j.Q, null);
/* 640 */     this.a.a(j.dw, null);
/* 641 */     this.a.a(j.dx, null);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */