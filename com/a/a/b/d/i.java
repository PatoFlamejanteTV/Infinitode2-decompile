/*      */ package com.a.a.b.d;
/*      */ 
/*      */ import com.a.a.b.a;
/*      */ import com.a.a.b.c.a;
/*      */ import com.a.a.b.c.b;
/*      */ import com.a.a.b.c.c;
/*      */ import com.a.a.b.h;
/*      */ import com.a.a.b.n;
/*      */ import com.a.a.b.p;
/*      */ import com.a.a.b.r;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.Writer;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class i
/*      */   extends c
/*      */ {
/*   22 */   private static char[] l = b.a(true);
/*   23 */   private static char[] m = b.a(false); private Writer n; private char o;
/*      */   
/*      */   private char[] p() {
/*   26 */     return this.k ? l : m;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] p;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int q;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int r;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int s;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] t;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private r u;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] v;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public i(a parama, int paramInt, p paramp, Writer paramWriter, char paramChar) {
/*  110 */     super(parama, paramInt, paramp);
/*  111 */     this.n = paramWriter;
/*  112 */     this.p = parama.h();
/*  113 */     this.s = this.p.length;
/*  114 */     this.o = paramChar;
/*  115 */     if (paramChar != '"') {
/*  116 */       this.f = b.a(paramChar);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(String paramString) {
/*      */     int j;
/*  152 */     if ((j = this.d.a(paramString)) == 4) {
/*  153 */       f("Can not write a field name, expecting a value");
/*      */     }
/*  155 */     a(paramString, (j == 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(r paramr) {
/*      */     int j;
/*  163 */     if ((j = this.d.a(paramr.a())) == 4) {
/*  164 */       f("Can not write a field name, expecting a value");
/*      */     }
/*  166 */     a(paramr, (j == 1));
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(String paramString, boolean paramBoolean) {
/*  171 */     if (this.b != null) {
/*  172 */       b(paramString, paramBoolean);
/*      */       
/*      */       return;
/*      */     } 
/*  176 */     if (this.r + 1 >= this.s) {
/*  177 */       s();
/*      */     }
/*  179 */     if (paramBoolean) {
/*  180 */       this.p[this.r++] = ',';
/*      */     }
/*      */     
/*  183 */     if (this.j) {
/*  184 */       k(paramString);
/*      */       
/*      */       return;
/*      */     } 
/*  188 */     this.p[this.r++] = this.o;
/*      */     
/*  190 */     k(paramString);
/*      */     
/*  192 */     if (this.r >= this.s) {
/*  193 */       s();
/*      */     }
/*  195 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(r paramr, boolean paramBoolean) {
/*  200 */     if (this.b != null) {
/*  201 */       b(paramr, paramBoolean);
/*      */       
/*      */       return;
/*      */     } 
/*  205 */     if (this.r + 1 >= this.s) {
/*  206 */       s();
/*      */     }
/*  208 */     if (paramBoolean) {
/*  209 */       this.p[this.r++] = ',';
/*      */     }
/*      */     
/*  212 */     if (this.j) {
/*  213 */       char[] arrayOfChar = paramr.b();
/*  214 */       b(arrayOfChar, 0, arrayOfChar.length);
/*      */       
/*      */       return;
/*      */     } 
/*  218 */     this.p[this.r++] = this.o;
/*      */     
/*      */     int j;
/*      */     
/*  222 */     if ((j = paramr.a(this.p, this.r)) < 0) {
/*  223 */       f(paramr);
/*      */       return;
/*      */     } 
/*  226 */     this.r += j;
/*  227 */     if (this.r >= this.s) {
/*  228 */       s();
/*      */     }
/*  230 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */   
/*      */   private final void f(r paramr) {
/*  235 */     char[] arrayOfChar = paramr.b();
/*  236 */     b(arrayOfChar, 0, arrayOfChar.length);
/*  237 */     if (this.r >= this.s) {
/*  238 */       s();
/*      */     }
/*  240 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void g() {
/*  252 */     g("start an array");
/*  253 */     this.d = this.d.i();
/*  254 */     if (this.b != null) {
/*  255 */       this.b.e((h)this); return;
/*      */     } 
/*  257 */     if (this.r >= this.s) {
/*  258 */       s();
/*      */     }
/*  260 */     this.p[this.r++] = '[';
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(Object paramObject) {
/*  267 */     g("start an array");
/*  268 */     this.d = this.d.b(paramObject);
/*  269 */     if (this.b != null) {
/*  270 */       this.b.e((h)this); return;
/*      */     } 
/*  272 */     if (this.r >= this.s) {
/*  273 */       s();
/*      */     }
/*  275 */     this.p[this.r++] = '[';
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(Object paramObject, int paramInt) {
/*  282 */     g("start an array");
/*  283 */     this.d = this.d.b(paramObject);
/*  284 */     if (this.b != null) {
/*  285 */       this.b.e((h)this); return;
/*      */     } 
/*  287 */     if (this.r >= this.s) {
/*  288 */       s();
/*      */     }
/*  290 */     this.p[this.r++] = '[';
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void h() {
/*  297 */     if (!this.d.b()) {
/*  298 */       f("Current context not Array but " + this.d.e());
/*      */     }
/*  300 */     if (this.b != null) {
/*  301 */       this.b.b((h)this, this.d.f());
/*      */     } else {
/*  303 */       if (this.r >= this.s) {
/*  304 */         s();
/*      */       }
/*  306 */       this.p[this.r++] = ']';
/*      */     } 
/*  308 */     this.d = this.d.l();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void i() {
/*  314 */     g("start an object");
/*  315 */     this.d = this.d.j();
/*  316 */     if (this.b != null) {
/*  317 */       this.b.b((h)this); return;
/*      */     } 
/*  319 */     if (this.r >= this.s) {
/*  320 */       s();
/*      */     }
/*  322 */     this.p[this.r++] = '{';
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void c(Object paramObject) {
/*  329 */     g("start an object");
/*  330 */     paramObject = this.d.c(paramObject);
/*  331 */     this.d = (f)paramObject;
/*  332 */     if (this.b != null) {
/*  333 */       this.b.b((h)this); return;
/*      */     } 
/*  335 */     if (this.r >= this.s) {
/*  336 */       s();
/*      */     }
/*  338 */     this.p[this.r++] = '{';
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void d(Object paramObject) {
/*  344 */     c(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void j() {
/*  350 */     if (!this.d.d()) {
/*  351 */       f("Current context not Object but " + this.d.e());
/*      */     }
/*  353 */     if (this.b != null) {
/*  354 */       this.b.a((h)this, this.d.f());
/*      */     } else {
/*  356 */       if (this.r >= this.s) {
/*  357 */         s();
/*      */       }
/*  359 */       this.p[this.r++] = '}';
/*      */     } 
/*  361 */     this.d = this.d.l();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(String paramString, boolean paramBoolean) {
/*  368 */     if (paramBoolean) {
/*  369 */       this.b.c((h)this);
/*      */     } else {
/*  371 */       this.b.h((h)this);
/*      */     } 
/*      */     
/*  374 */     if (this.j) {
/*  375 */       k(paramString); return;
/*      */     } 
/*  377 */     if (this.r >= this.s) {
/*  378 */       s();
/*      */     }
/*  380 */     this.p[this.r++] = this.o;
/*  381 */     k(paramString);
/*  382 */     if (this.r >= this.s) {
/*  383 */       s();
/*      */     }
/*  385 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(r paramr, boolean paramBoolean) {
/*  391 */     if (paramBoolean) {
/*  392 */       this.b.c((h)this);
/*      */     } else {
/*  394 */       this.b.h((h)this);
/*      */     } 
/*  396 */     char[] arrayOfChar = paramr.b();
/*  397 */     if (this.j) {
/*  398 */       b(arrayOfChar, 0, arrayOfChar.length); return;
/*      */     } 
/*  400 */     if (this.r >= this.s) {
/*  401 */       s();
/*      */     }
/*  403 */     this.p[this.r++] = this.o;
/*  404 */     b(arrayOfChar, 0, arrayOfChar.length);
/*  405 */     if (this.r >= this.s) {
/*  406 */       s();
/*      */     }
/*  408 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(String paramString) {
/*  421 */     g("write a string");
/*  422 */     if (paramString == null) {
/*  423 */       q();
/*      */       return;
/*      */     } 
/*  426 */     if (this.r >= this.s) {
/*  427 */       s();
/*      */     }
/*  429 */     this.p[this.r++] = this.o;
/*  430 */     k(paramString);
/*      */     
/*  432 */     if (this.r >= this.s) {
/*  433 */       s();
/*      */     }
/*  435 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  477 */     g("write a string");
/*  478 */     if (this.r >= this.s) {
/*  479 */       s();
/*      */     }
/*  481 */     this.p[this.r++] = this.o;
/*  482 */     d(paramArrayOfchar, paramInt1, paramInt2);
/*      */     
/*  484 */     if (this.r >= this.s) {
/*  485 */       s();
/*      */     }
/*  487 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void c(r paramr) {
/*  493 */     g("write a string");
/*  494 */     if (this.r >= this.s) {
/*  495 */       s();
/*      */     }
/*  497 */     this.p[this.r++] = this.o;
/*      */     int j;
/*  499 */     if ((j = paramr.a(this.p, this.r)) < 0) {
/*  500 */       g(paramr);
/*      */       return;
/*      */     } 
/*  503 */     this.r += j;
/*  504 */     if (this.r >= this.s) {
/*  505 */       s();
/*      */     }
/*  507 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void g(r paramr) {
/*      */     char[] arrayOfChar;
/*      */     int j;
/*  515 */     if ((j = (arrayOfChar = paramr.b()).length) < 32) {
/*  516 */       int k = this.s - this.r;
/*  517 */       if (j > k) {
/*  518 */         s();
/*      */       }
/*  520 */       System.arraycopy(arrayOfChar, 0, this.p, this.r, j);
/*  521 */       this.r += j;
/*      */     } else {
/*  523 */       s();
/*  524 */       this.n.write(arrayOfChar, 0, j);
/*      */     } 
/*  526 */     if (this.r >= this.s) {
/*  527 */       s();
/*      */     }
/*  529 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void c(String paramString) {
/*  554 */     int j = paramString.length();
/*      */     
/*      */     int k;
/*  557 */     if ((k = this.s - this.r) == 0) {
/*  558 */       s();
/*  559 */       k = this.s - this.r;
/*      */     } 
/*      */     
/*  562 */     if (k >= j) {
/*  563 */       paramString.getChars(0, j, this.p, this.r);
/*  564 */       this.r += j; return;
/*      */     } 
/*  566 */     i(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void d(r paramr) {
/*      */     int j;
/*  595 */     if ((j = paramr.b(this.p, this.r)) < 0) {
/*  596 */       c(paramr.a());
/*      */       return;
/*      */     } 
/*  599 */     this.r += j;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  605 */     c(paramArrayOfchar, 0, paramInt2);
/*      */ 
/*      */     
/*  608 */     if (paramInt2 < 32) {
/*  609 */       paramInt1 = this.s - this.r;
/*  610 */       if (paramInt2 > paramInt1) {
/*  611 */         s();
/*      */       }
/*  613 */       System.arraycopy(paramArrayOfchar, 0, this.p, this.r, paramInt2);
/*  614 */       this.r += paramInt2;
/*      */       
/*      */       return;
/*      */     } 
/*  618 */     s();
/*  619 */     this.n.write(paramArrayOfchar, 0, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(char paramChar) {
/*  625 */     if (this.r >= this.s) {
/*  626 */       s();
/*      */     }
/*  628 */     this.p[this.r++] = paramChar;
/*      */   }
/*      */ 
/*      */   
/*      */   private void i(String paramString) {
/*  633 */     int j = this.s - this.r;
/*      */     
/*  635 */     paramString.getChars(0, j, this.p, this.r);
/*  636 */     this.r += j;
/*  637 */     s();
/*  638 */     int k = j;
/*  639 */     j = paramString.length() - j;
/*      */     
/*  641 */     while (j > this.s) {
/*  642 */       int m = this.s;
/*  643 */       paramString.getChars(k, k + m, this.p, 0);
/*  644 */       this.q = 0;
/*  645 */       this.r = m;
/*  646 */       s();
/*  647 */       k += m;
/*  648 */       j -= m;
/*      */     } 
/*      */     
/*  651 */     paramString.getChars(k, k + j, this.p, 0);
/*  652 */     this.q = 0;
/*  653 */     this.r = j;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(a parama, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  666 */     b(paramArrayOfbyte, paramInt1, paramInt2);
/*      */     
/*  668 */     g("write a binary value");
/*      */     
/*  670 */     if (this.r >= this.s) {
/*  671 */       s();
/*      */     }
/*  673 */     this.p[this.r++] = this.o;
/*  674 */     b(parama, paramArrayOfbyte, paramInt1, paramInt1 + paramInt2);
/*      */     
/*  676 */     if (this.r >= this.s) {
/*  677 */       s();
/*      */     }
/*  679 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a(a parama, InputStream paramInputStream, int paramInt) {
/*  687 */     g("write a binary value");
/*      */     
/*  689 */     if (this.r >= this.s) {
/*  690 */       s();
/*      */     }
/*  692 */     this.p[this.r++] = this.o;
/*  693 */     byte[] arrayOfByte = this.e.f();
/*      */     try {
/*      */       int j;
/*  696 */       if (paramInt < 0) {
/*  697 */         j = a(parama, paramInputStream, arrayOfByte);
/*      */       } else {
/*      */         
/*  700 */         if ((j = a(j, paramInputStream, arrayOfByte, paramInt)) > 0) {
/*  701 */           f("Too few bytes available: missing " + j + " bytes (out of " + paramInt + ")");
/*      */         }
/*  703 */         j = paramInt;
/*      */       } 
/*      */     } finally {
/*  706 */       this.e.b(arrayOfByte);
/*      */     } 
/*      */     
/*  709 */     if (this.r >= this.s) {
/*  710 */       s();
/*      */     }
/*  712 */     this.p[this.r++] = this.o;
/*  713 */     return parama;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(short paramShort) {
/*  725 */     g("write a number");
/*  726 */     if (this.c) {
/*  727 */       b(paramShort);
/*      */       
/*      */       return;
/*      */     } 
/*  731 */     if (this.r + 6 >= this.s) {
/*  732 */       s();
/*      */     }
/*  734 */     this.r = com.a.a.b.c.i.a(paramShort, this.p, this.r);
/*      */   }
/*      */   
/*      */   private void b(short paramShort) {
/*  738 */     if (this.r + 8 >= this.s) {
/*  739 */       s();
/*      */     }
/*  741 */     this.p[this.r++] = this.o;
/*  742 */     this.r = com.a.a.b.c.i.a(paramShort, this.p, this.r);
/*  743 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void c(int paramInt) {
/*  749 */     g("write a number");
/*  750 */     if (this.c) {
/*  751 */       d(paramInt);
/*      */       
/*      */       return;
/*      */     } 
/*  755 */     if (this.r + 11 >= this.s) {
/*  756 */       s();
/*      */     }
/*  758 */     this.r = com.a.a.b.c.i.a(paramInt, this.p, this.r);
/*      */   }
/*      */   
/*      */   private void d(int paramInt) {
/*  762 */     if (this.r + 13 >= this.s) {
/*  763 */       s();
/*      */     }
/*  765 */     this.p[this.r++] = this.o;
/*  766 */     this.r = com.a.a.b.c.i.a(paramInt, this.p, this.r);
/*  767 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(long paramLong) {
/*  773 */     g("write a number");
/*  774 */     if (this.c) {
/*  775 */       c(paramLong);
/*      */       return;
/*      */     } 
/*  778 */     if (this.r + 21 >= this.s)
/*      */     {
/*  780 */       s();
/*      */     }
/*  782 */     this.r = com.a.a.b.c.i.a(paramLong, this.p, this.r);
/*      */   }
/*      */   
/*      */   private void c(long paramLong) {
/*  786 */     if (this.r + 23 >= this.s) {
/*  787 */       s();
/*      */     }
/*  789 */     this.p[this.r++] = this.o;
/*  790 */     this.r = com.a.a.b.c.i.a(paramLong, this.p, this.r);
/*  791 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(BigInteger paramBigInteger) {
/*  799 */     g("write a number");
/*  800 */     if (paramBigInteger == null) {
/*  801 */       q(); return;
/*  802 */     }  if (this.c) {
/*  803 */       j(paramBigInteger.toString()); return;
/*      */     } 
/*  805 */     c(paramBigInteger.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(double paramDouble) {
/*  813 */     if (this.c || (
/*  814 */       com.a.a.b.c.i.b(paramDouble) && b(h.a.e))) {
/*  815 */       b(com.a.a.b.c.i.a(paramDouble, b(h.a.j)));
/*      */       
/*      */       return;
/*      */     } 
/*  819 */     g("write a number");
/*  820 */     c(com.a.a.b.c.i.a(paramDouble, b(h.a.j)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(float paramFloat) {
/*  827 */     if (this.c || (
/*  828 */       com.a.a.b.c.i.b(paramFloat) && b(h.a.e))) {
/*  829 */       b(com.a.a.b.c.i.a(paramFloat, b(h.a.j)));
/*      */       
/*      */       return;
/*      */     } 
/*  833 */     g("write a number");
/*  834 */     c(com.a.a.b.c.i.a(paramFloat, b(h.a.j)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(BigDecimal paramBigDecimal) {
/*  841 */     g("write a number");
/*  842 */     if (paramBigDecimal == null) {
/*  843 */       q(); return;
/*  844 */     }  if (this.c) {
/*  845 */       j(b(paramBigDecimal)); return;
/*      */     } 
/*  847 */     c(b(paramBigDecimal));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void e(String paramString) {
/*  854 */     g("write a number");
/*  855 */     if (paramString == null) {
/*  856 */       q(); return;
/*  857 */     }  if (this.c) {
/*  858 */       j(paramString); return;
/*      */     } 
/*  860 */     c(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void j(String paramString) {
/*  876 */     if (this.r >= this.s) {
/*  877 */       s();
/*      */     }
/*  879 */     this.p[this.r++] = this.o;
/*  880 */     c(paramString);
/*  881 */     if (this.r >= this.s) {
/*  882 */       s();
/*      */     }
/*  884 */     this.p[this.r++] = this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(boolean paramBoolean) {
/*  903 */     g("write a boolean value");
/*  904 */     if (this.r + 5 >= this.s) {
/*  905 */       s();
/*      */     }
/*  907 */     int j = this.r;
/*  908 */     char[] arrayOfChar = this.p;
/*  909 */     if (paramBoolean) {
/*  910 */       arrayOfChar[j] = 't';
/*  911 */       arrayOfChar[++j] = 'r';
/*  912 */       arrayOfChar[++j] = 'u';
/*  913 */       arrayOfChar[++j] = 'e';
/*      */     } else {
/*  915 */       arrayOfChar[j] = 'f';
/*  916 */       arrayOfChar[++j] = 'a';
/*  917 */       arrayOfChar[++j] = 'l';
/*  918 */       arrayOfChar[++j] = 's';
/*  919 */       arrayOfChar[++j] = 'e';
/*      */     } 
/*  921 */     this.r = j + 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void k() {
/*  926 */     g("write a null");
/*  927 */     q();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void g(String paramString) {
/*      */     byte b;
/*  939 */     int j = this.d.n();
/*  940 */     if (this.b != null) {
/*      */       
/*  942 */       a(paramString, j);
/*      */       
/*      */       return;
/*      */     } 
/*  946 */     switch (j) {
/*      */       default:
/*      */         return;
/*      */       
/*      */       case 1:
/*  951 */         b = 44;
/*      */         break;
/*      */       case 2:
/*  954 */         b = 58;
/*      */         break;
/*      */       case 3:
/*  957 */         if (this.i != null) {
/*  958 */           c(this.i.a());
/*      */         }
/*      */         return;
/*      */       case 5:
/*  962 */         h(b);
/*      */         return;
/*      */     } 
/*  965 */     if (this.r >= this.s) {
/*  966 */       s();
/*      */     }
/*  968 */     this.p[this.r++] = b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void flush() {
/*  980 */     s();
/*  981 */     if (this.n != null && 
/*  982 */       b(h.a.c)) {
/*  983 */       this.n.flush();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void close() {
/*  991 */     super.close();
/*      */ 
/*      */ 
/*      */     
/*  995 */     IOException iOException = null;
/*      */     try {
/*  997 */       if (this.p != null && 
/*  998 */         b(h.a.b)) {
/*      */         while (true) {
/*      */           n n;
/* 1001 */           while ((n = a()).b())
/* 1002 */             h(); 
/* 1003 */           if (n.d()) {
/* 1004 */             j();
/*      */             continue;
/*      */           } 
/*      */           break;
/*      */         } 
/*      */       }
/* 1010 */       s();
/* 1011 */     } catch (IOException iOException2) {
/*      */ 
/*      */       
/* 1014 */       IOException iOException1 = null;
/*      */     } 
/* 1016 */     this.q = 0;
/* 1017 */     this.r = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1025 */     if (this.n != null) {
/*      */       try {
/* 1027 */         if (this.e.b() || b(h.a.a)) {
/* 1028 */           this.n.close();
/* 1029 */         } else if (b(h.a.c)) {
/*      */           
/* 1031 */           this.n.flush();
/*      */         } 
/* 1033 */       } catch (IOException|RuntimeException iOException1) {
/* 1034 */         if (iOException != null) {
/* 1035 */           iOException1.addSuppressed(iOException);
/*      */         }
/* 1037 */         throw iOException1;
/*      */       } 
/*      */     }
/*      */     
/* 1041 */     o();
/*      */     
/* 1043 */     if (iOException != null) {
/* 1044 */       throw iOException;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void o() {
/*      */     char[] arrayOfChar;
/* 1052 */     if ((arrayOfChar = this.p) != null) {
/* 1053 */       this.p = null;
/* 1054 */       this.e.b(arrayOfChar);
/*      */     } 
/*      */     
/* 1057 */     if ((arrayOfChar = this.v) != null) {
/* 1058 */       this.v = null;
/* 1059 */       this.e.c(arrayOfChar);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void k(String paramString) {
/*      */     int j;
/* 1077 */     if ((j = paramString.length()) > this.s) {
/* 1078 */       l(paramString);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1084 */     if (this.r + j > this.s) {
/* 1085 */       s();
/*      */     }
/* 1087 */     paramString.getChars(0, j, this.p, this.r);
/*      */     
/* 1089 */     if (this.h != null) {
/* 1090 */       g(j); return;
/* 1091 */     }  if (this.g != 0) {
/* 1092 */       c(j, this.g); return;
/*      */     } 
/* 1094 */     e(j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void e(int paramInt) {
/* 1101 */     paramInt = this.r + paramInt;
/*      */     
/* 1103 */     int arrayOfInt[], j = (arrayOfInt = this.f).length;
/*      */ 
/*      */     
/* 1106 */     while (this.r < paramInt) {
/*      */       label15: while (true) {
/*      */         char c1;
/*      */ 
/*      */         
/* 1111 */         if ((c1 = this.p[this.r]) >= j || arrayOfInt[c1] == 0) {
/*      */ 
/*      */           
/* 1114 */           if (++this.r < paramInt) {
/*      */             continue;
/*      */           }
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/*      */         int k;
/*      */         
/* 1124 */         if ((k = this.r - this.q) > 0) {
/* 1125 */           this.n.write(this.p, this.q, k);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1130 */           k = this.p[this.r++];
/* 1131 */           a(k, arrayOfInt[k]);
/*      */           continue;
/*      */         } 
/*      */         break label15;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void l(String paramString) {
/*      */     int m;
/* 1142 */     s();
/*      */ 
/*      */     
/* 1145 */     int j = paramString.length();
/* 1146 */     int k = 0;
/*      */     do {
/* 1148 */       m = this.s;
/* 1149 */       m = (k + m > j) ? (j - k) : m;
/*      */       
/* 1151 */       paramString.getChars(k, k + m, this.p, 0);
/* 1152 */       if (this.h != null) {
/* 1153 */         h(m);
/* 1154 */       } else if (this.g != 0) {
/* 1155 */         d(m, this.g);
/*      */       } else {
/* 1157 */         f(m);
/*      */       }
/*      */     
/* 1160 */     } while ((k = k + m) < j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void f(int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield f : [I
/*      */     //   4: dup
/*      */     //   5: astore_2
/*      */     //   6: arraylength
/*      */     //   7: istore_3
/*      */     //   8: iconst_0
/*      */     //   9: istore #4
/*      */     //   11: iconst_0
/*      */     //   12: istore #5
/*      */     //   14: iload #4
/*      */     //   16: iload_1
/*      */     //   17: if_icmpge -> 107
/*      */     //   20: aload_0
/*      */     //   21: getfield p : [C
/*      */     //   24: iload #4
/*      */     //   26: caload
/*      */     //   27: dup
/*      */     //   28: istore #6
/*      */     //   30: iload_3
/*      */     //   31: if_icmpge -> 41
/*      */     //   34: aload_2
/*      */     //   35: iload #6
/*      */     //   37: iaload
/*      */     //   38: ifne -> 50
/*      */     //   41: iinc #4, 1
/*      */     //   44: iload #4
/*      */     //   46: iload_1
/*      */     //   47: if_icmplt -> 20
/*      */     //   50: iload #4
/*      */     //   52: iload #5
/*      */     //   54: isub
/*      */     //   55: dup
/*      */     //   56: istore #7
/*      */     //   58: ifle -> 82
/*      */     //   61: aload_0
/*      */     //   62: getfield n : Ljava/io/Writer;
/*      */     //   65: aload_0
/*      */     //   66: getfield p : [C
/*      */     //   69: iload #5
/*      */     //   71: iload #7
/*      */     //   73: invokevirtual write : ([CII)V
/*      */     //   76: iload #4
/*      */     //   78: iload_1
/*      */     //   79: if_icmpge -> 107
/*      */     //   82: iinc #4, 1
/*      */     //   85: aload_0
/*      */     //   86: dup
/*      */     //   87: getfield p : [C
/*      */     //   90: iload #4
/*      */     //   92: iload_1
/*      */     //   93: iload #6
/*      */     //   95: aload_2
/*      */     //   96: iload #6
/*      */     //   98: iaload
/*      */     //   99: invokespecial a : ([CIICI)I
/*      */     //   102: istore #5
/*      */     //   104: goto -> 14
/*      */     //   107: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1174	-> 0
/*      */     //   #1175	-> 5
/*      */     //   #1177	-> 8
/*      */     //   #1178	-> 11
/*      */     //   #1181	-> 14
/*      */     //   #1185	-> 20
/*      */     //   #1186	-> 28
/*      */     //   #1189	-> 41
/*      */     //   #1198	-> 50
/*      */     //   #1199	-> 56
/*      */     //   #1200	-> 61
/*      */     //   #1201	-> 76
/*      */     //   #1205	-> 82
/*      */     //   #1207	-> 85
/*      */     //   #1208	-> 104
/*      */     //   #1209	-> 107
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1217 */     if (this.h != null) {
/* 1218 */       e(paramArrayOfchar, paramInt1, paramInt2);
/*      */       return;
/*      */     } 
/* 1221 */     if (this.g != 0) {
/* 1222 */       a(paramArrayOfchar, paramInt1, paramInt2, this.g);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 1229 */     paramInt2 += paramInt1;
/*      */     
/* 1231 */     int arrayOfInt[], j = (arrayOfInt = this.f).length;
/* 1232 */     while (paramInt1 < paramInt2) {
/* 1233 */       int k = paramInt1;
/*      */       
/*      */       char c1;
/*      */       
/* 1237 */       while ((c1 = paramArrayOfchar[paramInt1]) >= j || arrayOfInt[c1] == 0) {
/*      */ 
/*      */         
/* 1240 */         if (++paramInt1 < paramInt2);
/*      */       } 
/*      */ 
/*      */       
/*      */       int m;
/*      */ 
/*      */       
/* 1247 */       if ((m = paramInt1 - k) < 32) {
/*      */         
/* 1249 */         if (this.r + m > this.s) {
/* 1250 */           s();
/*      */         }
/* 1252 */         if (m > 0) {
/* 1253 */           System.arraycopy(paramArrayOfchar, k, this.p, this.r, m);
/* 1254 */           this.r += m;
/*      */         } 
/*      */       } else {
/* 1257 */         s();
/* 1258 */         this.n.write(paramArrayOfchar, k, m);
/*      */       } 
/*      */       
/* 1261 */       if (paramInt1 < paramInt2) {
/*      */ 
/*      */ 
/*      */         
/* 1265 */         k = paramArrayOfchar[paramInt1++];
/* 1266 */         b(k, arrayOfInt[k]);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(int paramInt1, int paramInt2) {
/* 1284 */     paramInt1 = this.r + paramInt1;
/*      */     
/* 1286 */     int arrayOfInt[], j = Math.min((arrayOfInt = this.f).length, paramInt2 + 1);
/*      */ 
/*      */ 
/*      */     
/* 1290 */     while (this.r < paramInt1) {
/*      */       byte b;
/*      */       
/*      */       char c1;
/*      */       
/*      */       while (true) {
/* 1296 */         if ((c1 = this.p[this.r]) < j) {
/*      */           
/* 1298 */           if ((b = arrayOfInt[c1]) != 0) {
/*      */             break;
/*      */           }
/* 1301 */         } else if (c1 > paramInt2) {
/* 1302 */           b = -1;
/*      */           break;
/*      */         } 
/* 1305 */         if (++this.r >= paramInt1) {
/*      */           return;
/*      */         }
/*      */       } 
/*      */       int k;
/* 1310 */       if ((k = this.r - this.q) > 0) {
/* 1311 */         this.n.write(this.p, this.q, k);
/*      */       }
/* 1313 */       this.r++;
/* 1314 */       a(c1, b);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(int paramInt1, int paramInt2) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield f : [I
/*      */     //   4: dup
/*      */     //   5: astore_3
/*      */     //   6: arraylength
/*      */     //   7: iload_2
/*      */     //   8: iconst_1
/*      */     //   9: iadd
/*      */     //   10: invokestatic min : (II)I
/*      */     //   13: istore #4
/*      */     //   15: iconst_0
/*      */     //   16: istore #5
/*      */     //   18: iconst_0
/*      */     //   19: istore #6
/*      */     //   21: iconst_0
/*      */     //   22: istore #7
/*      */     //   24: iload #5
/*      */     //   26: iload_1
/*      */     //   27: if_icmpge -> 134
/*      */     //   30: aload_0
/*      */     //   31: getfield p : [C
/*      */     //   34: iload #5
/*      */     //   36: caload
/*      */     //   37: dup
/*      */     //   38: istore #8
/*      */     //   40: iload #4
/*      */     //   42: if_icmpge -> 58
/*      */     //   45: aload_3
/*      */     //   46: iload #8
/*      */     //   48: iaload
/*      */     //   49: dup
/*      */     //   50: istore #6
/*      */     //   52: ifeq -> 70
/*      */     //   55: goto -> 79
/*      */     //   58: iload #8
/*      */     //   60: iload_2
/*      */     //   61: if_icmple -> 70
/*      */     //   64: iconst_m1
/*      */     //   65: istore #6
/*      */     //   67: goto -> 79
/*      */     //   70: iinc #5, 1
/*      */     //   73: iload #5
/*      */     //   75: iload_1
/*      */     //   76: if_icmplt -> 30
/*      */     //   79: iload #5
/*      */     //   81: iload #7
/*      */     //   83: isub
/*      */     //   84: dup
/*      */     //   85: istore #9
/*      */     //   87: ifle -> 111
/*      */     //   90: aload_0
/*      */     //   91: getfield n : Ljava/io/Writer;
/*      */     //   94: aload_0
/*      */     //   95: getfield p : [C
/*      */     //   98: iload #7
/*      */     //   100: iload #9
/*      */     //   102: invokevirtual write : ([CII)V
/*      */     //   105: iload #5
/*      */     //   107: iload_1
/*      */     //   108: if_icmpge -> 134
/*      */     //   111: iinc #5, 1
/*      */     //   114: aload_0
/*      */     //   115: dup
/*      */     //   116: getfield p : [C
/*      */     //   119: iload #5
/*      */     //   121: iload_1
/*      */     //   122: iload #8
/*      */     //   124: iload #6
/*      */     //   126: invokespecial a : ([CIICI)I
/*      */     //   129: istore #7
/*      */     //   131: goto -> 24
/*      */     //   134: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1321	-> 0
/*      */     //   #1322	-> 5
/*      */     //   #1324	-> 15
/*      */     //   #1325	-> 18
/*      */     //   #1326	-> 21
/*      */     //   #1329	-> 24
/*      */     //   #1333	-> 30
/*      */     //   #1334	-> 38
/*      */     //   #1335	-> 45
/*      */     //   #1336	-> 50
/*      */     //   #1337	-> 55
/*      */     //   #1339	-> 58
/*      */     //   #1340	-> 64
/*      */     //   #1341	-> 67
/*      */     //   #1343	-> 70
/*      */     //   #1347	-> 79
/*      */     //   #1348	-> 85
/*      */     //   #1349	-> 90
/*      */     //   #1350	-> 105
/*      */     //   #1354	-> 111
/*      */     //   #1355	-> 114
/*      */     //   #1356	-> 131
/*      */     //   #1357	-> 134
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 1363 */     paramInt2 += paramInt1;
/*      */     
/* 1365 */     int arrayOfInt[], j = Math.min((arrayOfInt = this.f).length, paramInt3 + 1);
/*      */     
/* 1367 */     int k = 0;
/*      */     
/* 1369 */     while (paramInt1 < paramInt2) {
/* 1370 */       char c1; int m = paramInt1;
/*      */ 
/*      */ 
/*      */       
/*      */       do {
/* 1375 */         if ((c1 = paramArrayOfchar[paramInt1]) < j) {
/*      */           
/* 1377 */           if ((k = arrayOfInt[c1]) != 0) {
/*      */             break;
/*      */           }
/* 1380 */         } else if (c1 > paramInt3) {
/* 1381 */           k = -1;
/*      */           break;
/*      */         } 
/* 1384 */       } while (++paramInt1 < paramInt2);
/*      */ 
/*      */ 
/*      */       
/*      */       int n;
/*      */ 
/*      */       
/* 1391 */       if ((n = paramInt1 - m) < 32) {
/*      */         
/* 1393 */         if (this.r + n > this.s) {
/* 1394 */           s();
/*      */         }
/* 1396 */         if (n > 0) {
/* 1397 */           System.arraycopy(paramArrayOfchar, m, this.p, this.r, n);
/* 1398 */           this.r += n;
/*      */         } 
/*      */       } else {
/* 1401 */         s();
/* 1402 */         this.n.write(paramArrayOfchar, m, n);
/*      */       } 
/*      */       
/* 1405 */       if (paramInt1 < paramInt2) {
/*      */ 
/*      */ 
/*      */         
/* 1409 */         paramInt1++;
/* 1410 */         b(c1, k);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void g(int paramInt) {
/* 1428 */     paramInt = this.r + paramInt;
/* 1429 */     int[] arrayOfInt = this.f;
/* 1430 */     byte b = (this.g <= 0) ? 65535 : this.g;
/* 1431 */     int j = Math.min(arrayOfInt.length, b + 1);
/*      */     
/* 1433 */     c c1 = this.h;
/*      */ 
/*      */     
/* 1436 */     while (this.r < paramInt) {
/*      */       byte b1;
/*      */       
/*      */       char c2;
/*      */       
/*      */       while (true) {
/* 1442 */         if ((c2 = this.p[this.r]) < j) {
/*      */           
/* 1444 */           if ((b1 = arrayOfInt[c2]) != 0)
/*      */             break; 
/*      */         } else {
/* 1447 */           if (c2 > b) {
/* 1448 */             b1 = -1;
/*      */             break;
/*      */           } 
/* 1451 */           throw null;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1456 */         if (++this.r >= paramInt) {
/*      */           return;
/*      */         }
/*      */       } 
/*      */       int k;
/* 1461 */       if ((k = this.r - this.q) > 0) {
/* 1462 */         this.n.write(this.p, this.q, k);
/*      */       }
/* 1464 */       this.r++;
/* 1465 */       a(c2, b1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void h(int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield f : [I
/*      */     //   4: astore_2
/*      */     //   5: aload_0
/*      */     //   6: getfield g : I
/*      */     //   9: ifgt -> 17
/*      */     //   12: ldc 65535
/*      */     //   14: goto -> 21
/*      */     //   17: aload_0
/*      */     //   18: getfield g : I
/*      */     //   21: istore_3
/*      */     //   22: aload_2
/*      */     //   23: arraylength
/*      */     //   24: iload_3
/*      */     //   25: iconst_1
/*      */     //   26: iadd
/*      */     //   27: invokestatic min : (II)I
/*      */     //   30: istore #4
/*      */     //   32: aload_0
/*      */     //   33: getfield h : Lcom/a/a/b/c/c;
/*      */     //   36: astore #5
/*      */     //   38: iconst_0
/*      */     //   39: istore #6
/*      */     //   41: iconst_0
/*      */     //   42: istore #7
/*      */     //   44: iconst_0
/*      */     //   45: istore #8
/*      */     //   47: iload #6
/*      */     //   49: iload_1
/*      */     //   50: if_icmpge -> 162
/*      */     //   53: aload_0
/*      */     //   54: getfield p : [C
/*      */     //   57: iload #6
/*      */     //   59: caload
/*      */     //   60: dup
/*      */     //   61: istore #9
/*      */     //   63: iload #4
/*      */     //   65: if_icmpge -> 81
/*      */     //   68: aload_2
/*      */     //   69: iload #9
/*      */     //   71: iaload
/*      */     //   72: dup
/*      */     //   73: istore #7
/*      */     //   75: ifeq -> 98
/*      */     //   78: goto -> 107
/*      */     //   81: iload #9
/*      */     //   83: iload_3
/*      */     //   84: if_icmple -> 93
/*      */     //   87: iconst_m1
/*      */     //   88: istore #7
/*      */     //   90: goto -> 107
/*      */     //   93: aload_0
/*      */     //   94: aload #5
/*      */     //   96: aconst_null
/*      */     //   97: athrow
/*      */     //   98: iinc #6, 1
/*      */     //   101: iload #6
/*      */     //   103: iload_1
/*      */     //   104: if_icmplt -> 53
/*      */     //   107: iload #6
/*      */     //   109: iload #8
/*      */     //   111: isub
/*      */     //   112: dup
/*      */     //   113: istore #10
/*      */     //   115: ifle -> 139
/*      */     //   118: aload_0
/*      */     //   119: getfield n : Ljava/io/Writer;
/*      */     //   122: aload_0
/*      */     //   123: getfield p : [C
/*      */     //   126: iload #8
/*      */     //   128: iload #10
/*      */     //   130: invokevirtual write : ([CII)V
/*      */     //   133: iload #6
/*      */     //   135: iload_1
/*      */     //   136: if_icmpge -> 162
/*      */     //   139: iinc #6, 1
/*      */     //   142: aload_0
/*      */     //   143: dup
/*      */     //   144: getfield p : [C
/*      */     //   147: iload #6
/*      */     //   149: iload_1
/*      */     //   150: iload #9
/*      */     //   152: iload #7
/*      */     //   154: invokespecial a : ([CIICI)I
/*      */     //   157: istore #8
/*      */     //   159: goto -> 47
/*      */     //   162: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1472	-> 0
/*      */     //   #1473	-> 5
/*      */     //   #1474	-> 22
/*      */     //   #1475	-> 32
/*      */     //   #1477	-> 38
/*      */     //   #1478	-> 41
/*      */     //   #1479	-> 44
/*      */     //   #1482	-> 47
/*      */     //   #1486	-> 53
/*      */     //   #1487	-> 61
/*      */     //   #1488	-> 68
/*      */     //   #1489	-> 73
/*      */     //   #1490	-> 78
/*      */     //   #1492	-> 81
/*      */     //   #1493	-> 87
/*      */     //   #1494	-> 90
/*      */     //   #1496	-> 93
/*      */     //   #1501	-> 98
/*      */     //   #1505	-> 107
/*      */     //   #1506	-> 113
/*      */     //   #1507	-> 118
/*      */     //   #1508	-> 133
/*      */     //   #1512	-> 139
/*      */     //   #1513	-> 142
/*      */     //   #1514	-> 159
/*      */     //   #1515	-> 162
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void e(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1520 */     paramInt2 += paramInt1;
/* 1521 */     int[] arrayOfInt = this.f;
/* 1522 */     byte b = (this.g <= 0) ? 65535 : this.g;
/* 1523 */     int j = Math.min(arrayOfInt.length, b + 1);
/* 1524 */     c c1 = this.h;
/*      */     
/* 1526 */     int k = 0;
/*      */     
/* 1528 */     while (paramInt1 < paramInt2) {
/* 1529 */       char c2; int m = paramInt1;
/*      */ 
/*      */ 
/*      */       
/*      */       do {
/* 1534 */         if ((c2 = paramArrayOfchar[paramInt1]) < j) {
/*      */           
/* 1536 */           if ((k = arrayOfInt[c2]) != 0)
/*      */             break; 
/*      */         } else {
/* 1539 */           if (c2 > b) {
/* 1540 */             k = -1;
/*      */             break;
/*      */           } 
/* 1543 */           throw null;
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 1548 */       while (++paramInt1 < paramInt2);
/*      */ 
/*      */ 
/*      */       
/*      */       int n;
/*      */ 
/*      */       
/* 1555 */       if ((n = paramInt1 - m) < 32) {
/*      */         
/* 1557 */         if (this.r + n > this.s) {
/* 1558 */           s();
/*      */         }
/* 1560 */         if (n > 0) {
/* 1561 */           System.arraycopy(paramArrayOfchar, m, this.p, this.r, n);
/* 1562 */           this.r += n;
/*      */         } 
/*      */       } else {
/* 1565 */         s();
/* 1566 */         this.n.write(paramArrayOfchar, m, n);
/*      */       } 
/*      */       
/* 1569 */       if (paramInt1 < paramInt2) {
/*      */ 
/*      */ 
/*      */         
/* 1573 */         paramInt1++;
/* 1574 */         b(c2, k);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(a parama, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 1588 */     int j = paramInt2 - 3;
/*      */     
/* 1590 */     int k = this.s - 6;
/* 1591 */     int m = parama.c() >> 2;
/*      */ 
/*      */     
/* 1594 */     while (paramInt1 <= j) {
/* 1595 */       if (this.r > k) {
/* 1596 */         s();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1601 */       int i1 = (i1 = (i1 = paramArrayOfbyte[paramInt1++] << 8) | paramArrayOfbyte[paramInt1++] & 0xFF) << 8 | paramArrayOfbyte[paramInt1++] & 0xFF;
/* 1602 */       this.r = parama.a(i1, this.p, this.r);
/* 1603 */       if (--m <= 0) {
/*      */         
/* 1605 */         this.p[this.r++] = '\\';
/* 1606 */         this.p[this.r++] = 'n';
/* 1607 */         m = parama.c() >> 2;
/*      */       } 
/*      */     } 
/*      */     
/*      */     int n;
/*      */     
/* 1613 */     if ((n = paramInt2 - paramInt1) > 0) {
/* 1614 */       if (this.r > k) {
/* 1615 */         s();
/*      */       }
/* 1617 */       paramInt2 = paramArrayOfbyte[paramInt1++] << 16;
/* 1618 */       if (n == 2) {
/* 1619 */         paramInt2 |= (paramArrayOfbyte[paramInt1] & 0xFF) << 8;
/*      */       }
/* 1621 */       this.r = parama.a(paramInt2, n, this.p, this.r);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(a parama, InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt) {
/* 1630 */     byte b = 0;
/* 1631 */     int j = 0;
/* 1632 */     int k = -3;
/*      */ 
/*      */     
/* 1635 */     int m = this.s - 6;
/* 1636 */     int n = parama.c() >> 2;
/*      */     
/* 1638 */     while (paramInt > 2) {
/* 1639 */       if (b > k) {
/* 1640 */         j = a(paramInputStream, paramArrayOfbyte, b, j, paramInt);
/* 1641 */         b = 0;
/* 1642 */         if (j >= 3)
/*      */         
/*      */         { 
/* 1645 */           k = j - 3; } else { break; }
/*      */       
/* 1647 */       }  if (this.r > m) {
/* 1648 */         s();
/*      */       }
/*      */ 
/*      */       
/* 1652 */       int i1 = (i1 = (i1 = paramArrayOfbyte[b++] << 8) | paramArrayOfbyte[b++] & 0xFF) << 8 | paramArrayOfbyte[b++] & 0xFF;
/* 1653 */       paramInt -= 3;
/* 1654 */       this.r = parama.a(i1, this.p, this.r);
/* 1655 */       if (--n <= 0) {
/* 1656 */         this.p[this.r++] = '\\';
/* 1657 */         this.p[this.r++] = 'n';
/* 1658 */         n = parama.c() >> 2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1663 */     if (paramInt > 0 && (
/*      */ 
/*      */       
/* 1666 */       j = a(paramInputStream, paramArrayOfbyte, b, j, paramInt)) > 0) {
/* 1667 */       byte b1; if (this.r > m) {
/* 1668 */         s();
/*      */       }
/* 1670 */       int i1 = paramArrayOfbyte[0] << 16;
/*      */       
/* 1672 */       if (1 < j) {
/* 1673 */         i1 |= (paramArrayOfbyte[1] & 0xFF) << 8;
/* 1674 */         b1 = 2;
/*      */       } else {
/* 1676 */         b1 = 1;
/*      */       } 
/* 1678 */       this.r = parama.a(i1, b1, this.p, this.r);
/* 1679 */       paramInt -= b1;
/*      */     } 
/*      */     
/* 1682 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(a parama, InputStream paramInputStream, byte[] paramArrayOfbyte) {
/* 1690 */     byte b = 0;
/* 1691 */     int j = 0;
/* 1692 */     int k = -3;
/* 1693 */     int m = 0;
/*      */ 
/*      */     
/* 1696 */     int n = this.s - 6;
/* 1697 */     int i1 = parama.c() >> 2;
/*      */ 
/*      */     
/*      */     while (true) {
/* 1701 */       if (b > k) {
/* 1702 */         j = a(paramInputStream, paramArrayOfbyte, b, j, paramArrayOfbyte.length);
/* 1703 */         b = 0;
/* 1704 */         if (j >= 3)
/*      */         
/*      */         { 
/* 1707 */           k = j - 3; } else { break; }
/*      */       
/* 1709 */       }  if (this.r > n) {
/* 1710 */         s();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1715 */       int i2 = (i2 = (i2 = paramArrayOfbyte[b++] << 8) | paramArrayOfbyte[b++] & 0xFF) << 8 | paramArrayOfbyte[b++] & 0xFF;
/* 1716 */       m += true;
/* 1717 */       this.r = parama.a(i2, this.p, this.r);
/* 1718 */       if (--i1 <= 0) {
/* 1719 */         this.p[this.r++] = '\\';
/* 1720 */         this.p[this.r++] = 'n';
/* 1721 */         i1 = parama.c() >> 2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1726 */     if (j > 0) {
/* 1727 */       if (this.r > n) {
/* 1728 */         s();
/*      */       }
/* 1730 */       int i2 = paramArrayOfbyte[0] << 16;
/* 1731 */       byte b1 = 1;
/* 1732 */       if (1 < j) {
/* 1733 */         i2 |= (paramArrayOfbyte[1] & 0xFF) << 8;
/* 1734 */         b1 = 2;
/*      */       } 
/* 1736 */       m += b1;
/* 1737 */       this.r = parama.a(i2, b1, this.p, this.r);
/*      */     } 
/* 1739 */     return m;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int a(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/* 1747 */     byte b = 0;
/* 1748 */     while (paramInt1 < paramInt2) {
/* 1749 */       paramArrayOfbyte[b++] = paramArrayOfbyte[paramInt1++];
/*      */     }
/*      */     
/* 1752 */     paramInt2 = b;
/* 1753 */     paramInt3 = Math.min(paramInt3, paramArrayOfbyte.length);
/*      */ 
/*      */ 
/*      */     
/* 1757 */     while ((paramInt1 = paramInt3 - paramInt2) != 0)
/*      */     
/*      */     { 
/*      */       
/* 1761 */       if ((paramInt1 = paramInputStream.read(paramArrayOfbyte, paramInt2, paramInt1)) < 0) {
/* 1762 */         return paramInt2;
/*      */       }
/*      */       
/* 1765 */       if ((paramInt2 = paramInt2 + paramInt1) >= 3)
/* 1766 */         break;  }  return paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void q() {
/* 1777 */     if (this.r + 4 >= this.s) {
/* 1778 */       s();
/*      */     }
/* 1780 */     int j = this.r;
/*      */     char[] arrayOfChar;
/* 1782 */     (arrayOfChar = this.p)[j] = 'n';
/* 1783 */     arrayOfChar[++j] = 'u';
/* 1784 */     arrayOfChar[++j] = 'l';
/* 1785 */     arrayOfChar[++j] = 'l';
/* 1786 */     this.r = j + 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(char paramChar, int paramInt) {
/* 1803 */     if (paramInt >= 0) {
/* 1804 */       if (this.r >= 2) {
/* 1805 */         int j = this.r - 2;
/* 1806 */         this.q = j;
/* 1807 */         this.p[j++] = '\\';
/* 1808 */         this.p[j] = (char)paramInt;
/*      */         
/*      */         return;
/*      */       } 
/*      */       char[] arrayOfChar;
/* 1813 */       if ((arrayOfChar = this.t) == null) {
/* 1814 */         arrayOfChar = r();
/*      */       }
/* 1816 */       this.q = this.r;
/* 1817 */       arrayOfChar[1] = (char)paramInt;
/* 1818 */       this.n.write(arrayOfChar, 0, 2);
/*      */       return;
/*      */     } 
/* 1821 */     if (paramInt != -2) {
/* 1822 */       char[] arrayOfChar2 = p();
/* 1823 */       if (this.r >= 6) {
/* 1824 */         char[] arrayOfChar = this.p;
/* 1825 */         int j = this.r - 6;
/* 1826 */         this.q = j;
/* 1827 */         arrayOfChar[j] = '\\';
/* 1828 */         arrayOfChar[++j] = 'u';
/*      */         
/* 1830 */         if (paramChar > 'ÿ') {
/* 1831 */           int k = paramChar >> 8 & 0xFF;
/* 1832 */           arrayOfChar[++j] = arrayOfChar2[k >> 4];
/* 1833 */           arrayOfChar[++j] = arrayOfChar2[k & 0xF];
/* 1834 */           paramChar = (char)(paramChar & 0xFF);
/*      */         } else {
/* 1836 */           arrayOfChar[++j] = '0';
/* 1837 */           arrayOfChar[++j] = '0';
/*      */         } 
/* 1839 */         arrayOfChar[++j] = arrayOfChar2[paramChar >> 4];
/* 1840 */         arrayOfChar[++j] = arrayOfChar2[paramChar & 0xF];
/*      */         
/*      */         return;
/*      */       } 
/*      */       char[] arrayOfChar1;
/* 1845 */       if ((arrayOfChar1 = this.t) == null) {
/* 1846 */         arrayOfChar1 = r();
/*      */       }
/* 1848 */       this.q = this.r;
/* 1849 */       if (paramChar > 'ÿ') {
/* 1850 */         int j = paramChar >> 8 & 0xFF;
/* 1851 */         int k = paramChar & 0xFF;
/* 1852 */         arrayOfChar1[10] = arrayOfChar2[j >> 4];
/* 1853 */         arrayOfChar1[11] = arrayOfChar2[j & 0xF];
/* 1854 */         arrayOfChar1[12] = arrayOfChar2[k >> 4];
/* 1855 */         arrayOfChar1[13] = arrayOfChar2[k & 0xF];
/* 1856 */         this.n.write(arrayOfChar1, 8, 6); return;
/*      */       } 
/* 1858 */       arrayOfChar1[6] = arrayOfChar2[paramChar >> 4];
/* 1859 */       arrayOfChar1[7] = arrayOfChar2[paramChar & 0xF];
/* 1860 */       this.n.write(arrayOfChar1, 2, 6);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1866 */     if (this.u == null) {
/* 1867 */       throw null;
/*      */     }
/* 1869 */     String str = this.u.a();
/* 1870 */     this.u = null;
/*      */     
/* 1872 */     paramInt = str.length();
/* 1873 */     if (this.r >= paramInt) {
/* 1874 */       int j = this.r - paramInt;
/* 1875 */       this.q = j;
/* 1876 */       str.getChars(0, paramInt, this.p, j);
/*      */       
/*      */       return;
/*      */     } 
/* 1880 */     this.q = this.r;
/* 1881 */     this.n.write(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(char[] paramArrayOfchar, int paramInt1, int paramInt2, char paramChar, int paramInt3) {
/*      */     int j;
/* 1895 */     if (paramInt3 >= 0) {
/* 1896 */       if (paramInt1 > 1 && paramInt1 < paramInt2) {
/* 1897 */         paramInt1 -= 2;
/* 1898 */         paramArrayOfchar[paramInt1] = '\\';
/* 1899 */         paramArrayOfchar[paramInt1 + 1] = (char)paramInt3;
/*      */       } else {
/*      */         char[] arrayOfChar;
/* 1902 */         if ((arrayOfChar = this.t) == null) {
/* 1903 */           arrayOfChar = r();
/*      */         }
/* 1905 */         arrayOfChar[1] = (char)paramInt3;
/* 1906 */         this.n.write(arrayOfChar, 0, 2);
/*      */       } 
/* 1908 */       return paramInt1;
/*      */     } 
/* 1910 */     if (paramInt3 != -2) {
/* 1911 */       char[] arrayOfChar = p();
/* 1912 */       if (paramInt1 > 5 && paramInt1 < paramInt2) {
/* 1913 */         paramInt1 -= 6;
/* 1914 */         paramArrayOfchar[paramInt1++] = '\\';
/* 1915 */         paramArrayOfchar[paramInt1++] = 'u';
/*      */         
/* 1917 */         if (paramChar > 'ÿ') {
/* 1918 */           paramInt3 = paramChar >> 8 & 0xFF;
/* 1919 */           paramArrayOfchar[paramInt1++] = arrayOfChar[paramInt3 >> 4];
/* 1920 */           paramArrayOfchar[paramInt1++] = arrayOfChar[paramInt3 & 0xF];
/* 1921 */           paramChar = (char)(paramChar & 0xFF);
/*      */         } else {
/* 1923 */           paramArrayOfchar[paramInt1++] = '0';
/* 1924 */           paramArrayOfchar[paramInt1++] = '0';
/*      */         } 
/* 1926 */         paramArrayOfchar[paramInt1++] = arrayOfChar[paramChar >> 4];
/* 1927 */         paramArrayOfchar[paramInt1] = arrayOfChar[paramChar & 0xF];
/* 1928 */         paramInt1 -= 5;
/*      */       } else {
/*      */         char[] arrayOfChar1;
/*      */         
/* 1932 */         if ((arrayOfChar1 = this.t) == null) {
/* 1933 */           arrayOfChar1 = r();
/*      */         }
/* 1935 */         this.q = this.r;
/* 1936 */         if (paramChar > 'ÿ') {
/* 1937 */           j = paramChar >> 8 & 0xFF;
/* 1938 */           paramInt2 = paramChar & 0xFF;
/* 1939 */           arrayOfChar1[10] = arrayOfChar[j >> 4];
/* 1940 */           arrayOfChar1[11] = arrayOfChar[j & 0xF];
/* 1941 */           arrayOfChar1[12] = arrayOfChar[paramInt2 >> 4];
/* 1942 */           arrayOfChar1[13] = arrayOfChar[paramInt2 & 0xF];
/* 1943 */           this.n.write(arrayOfChar1, 8, 6);
/*      */         } else {
/* 1945 */           arrayOfChar1[6] = arrayOfChar[paramChar >> 4];
/* 1946 */           arrayOfChar1[7] = arrayOfChar[paramChar & 0xF];
/* 1947 */           this.n.write(arrayOfChar1, 2, 6);
/*      */         } 
/*      */       } 
/* 1950 */       return paramInt1;
/*      */     } 
/*      */     
/* 1953 */     if (this.u == null) {
/* 1954 */       throw null;
/*      */     }
/* 1956 */     String str = this.u.a();
/* 1957 */     this.u = null;
/*      */     
/* 1959 */     paramInt3 = str.length();
/* 1960 */     if (paramInt1 >= paramInt3 && paramInt1 < paramInt2) {
/* 1961 */       paramInt1 -= paramInt3;
/* 1962 */       str.getChars(0, paramInt3, j, paramInt1);
/*      */     } else {
/* 1964 */       this.n.write(str);
/*      */     } 
/* 1966 */     return paramInt1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(char paramChar, int paramInt) {
/* 1976 */     if (paramInt >= 0) {
/* 1977 */       if (this.r + 2 > this.s) {
/* 1978 */         s();
/*      */       }
/* 1980 */       this.p[this.r++] = '\\';
/* 1981 */       this.p[this.r++] = (char)paramInt;
/*      */       return;
/*      */     } 
/* 1984 */     if (paramInt != -2) {
/* 1985 */       if (this.r + 5 >= this.s) {
/* 1986 */         s();
/*      */       }
/* 1988 */       paramInt = this.r;
/* 1989 */       char[] arrayOfChar1 = this.p;
/* 1990 */       char[] arrayOfChar2 = p();
/* 1991 */       arrayOfChar1[paramInt++] = '\\';
/* 1992 */       arrayOfChar1[paramInt++] = 'u';
/*      */       
/* 1994 */       if (paramChar > 'ÿ') {
/* 1995 */         int k = paramChar >> 8 & 0xFF;
/* 1996 */         arrayOfChar1[paramInt++] = arrayOfChar2[k >> 4];
/* 1997 */         arrayOfChar1[paramInt++] = arrayOfChar2[k & 0xF];
/* 1998 */         paramChar = (char)(paramChar & 0xFF);
/*      */       } else {
/* 2000 */         arrayOfChar1[paramInt++] = '0';
/* 2001 */         arrayOfChar1[paramInt++] = '0';
/*      */       } 
/* 2003 */       arrayOfChar1[paramInt++] = arrayOfChar2[paramChar >> 4];
/* 2004 */       arrayOfChar1[paramInt++] = arrayOfChar2[paramChar & 0xF];
/* 2005 */       this.r = paramInt;
/*      */       
/*      */       return;
/*      */     } 
/* 2009 */     if (this.u == null) {
/* 2010 */       throw null;
/*      */     }
/* 2012 */     String str = this.u.a();
/* 2013 */     this.u = null;
/*      */     
/* 2015 */     int j = str.length();
/* 2016 */     if (this.r + j > this.s) {
/* 2017 */       s();
/* 2018 */       if (j > this.s) {
/* 2019 */         this.n.write(str);
/*      */         return;
/*      */       } 
/*      */     } 
/* 2023 */     str.getChars(0, j, this.p, this.r);
/* 2024 */     this.r += j;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] r() {
/*      */     char[] arrayOfChar;
/* 2031 */     (arrayOfChar = new char[14])[0] = '\\';
/*      */     
/* 2033 */     arrayOfChar[2] = '\\';
/* 2034 */     arrayOfChar[3] = 'u';
/* 2035 */     arrayOfChar[4] = '0';
/* 2036 */     arrayOfChar[5] = '0';
/*      */     
/* 2038 */     arrayOfChar[8] = '\\';
/* 2039 */     arrayOfChar[9] = 'u';
/* 2040 */     this.t = arrayOfChar;
/* 2041 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void s() {
/*      */     int j;
/* 2057 */     if ((j = this.r - this.q) > 0) {
/* 2058 */       int k = this.q;
/* 2059 */       this.r = this.q = 0;
/* 2060 */       this.n.write(this.p, k, j);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\d\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */