/*     */ package com.a.a.b.a;
/*     */ 
/*     */ import com.a.a.b.a;
/*     */ import com.a.a.b.b.a;
/*     */ import com.a.a.b.c.e;
/*     */ import com.a.a.b.c.h;
/*     */ import com.a.a.b.g.q;
/*     */ import com.a.a.b.k;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class c
/*     */   extends l
/*     */ {
/*  62 */   protected static final byte[] u = new byte[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   protected static final BigInteger v = BigInteger.valueOf(-2147483648L);
/*  98 */   protected static final BigInteger w = BigInteger.valueOf(2147483647L);
/*     */   
/* 100 */   protected static final BigInteger x = BigInteger.valueOf(Long.MIN_VALUE);
/* 101 */   protected static final BigInteger y = BigInteger.valueOf(Long.MAX_VALUE);
/*     */   
/* 103 */   protected static final BigDecimal z = new BigDecimal(x);
/* 104 */   protected static final BigDecimal A = new BigDecimal(y);
/*     */   
/* 106 */   protected static final BigDecimal B = new BigDecimal(v);
/* 107 */   protected static final BigDecimal C = new BigDecimal(w);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected o D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected c() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected c(int paramInt) {
/* 160 */     super(paramInt);
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
/*     */   public abstract o g();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o k() {
/* 186 */     return this.D;
/*     */   } public final int l() {
/*     */     o o1;
/* 189 */     return ((o1 = this.D) == null) ? 0 : o1.a();
/*     */   }
/*     */   public final o m() {
/* 192 */     return this.D;
/*     */   }
/*     */   @Deprecated
/*     */   public final int n() {
/*     */     o o1;
/* 197 */     return ((o1 = this.D) == null) ? 0 : o1.a();
/*     */   }
/*     */   public final boolean o() {
/* 200 */     return (this.D != null);
/*     */   } public final boolean c(int paramInt) {
/*     */     o o1;
/* 203 */     if ((o1 = this.D) == null) {
/* 204 */       return (paramInt == 0);
/*     */     }
/* 206 */     return (o1.a() == paramInt);
/*     */   }
/*     */   
/*     */   public final boolean a(o paramo) {
/* 210 */     return (this.D == paramo);
/*     */   }
/*     */   
/* 213 */   public final boolean p() { return (this.D == o.d); }
/* 214 */   public final boolean q() { return (this.D == o.b); } public final boolean r() {
/* 215 */     return (this.D == o.i);
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
/*     */   public final l j() {
/* 231 */     if (this.D != o.b && this.D != o.d)
/*     */     {
/* 233 */       return this;
/*     */     }
/* 235 */     byte b = 1;
/*     */ 
/*     */     
/*     */     while (true) {
/*     */       o o1;
/*     */       
/* 241 */       if ((o1 = g()) == null) {
/* 242 */         Y();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 247 */         return this;
/*     */       } 
/* 249 */       if (o1.e()) {
/* 250 */         b++; continue;
/* 251 */       }  if (o1.f()) {
/* 252 */         if (--b == 0)
/* 253 */           return this; 
/*     */         continue;
/*     */       } 
/* 256 */       if (o1 == o.a)
/*     */       {
/*     */         
/* 259 */         a("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", 
/* 260 */             getClass().getName());
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
/*     */   protected abstract void Y();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String u();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void t() {
/* 294 */     if (this.D != null)
/*     */     {
/* 296 */       this.D = null;
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
/*     */   public abstract String w();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int P() {
/*     */     o o1;
/* 371 */     if ((o1 = this.D) == o.i || o1 == o.j) {
/* 372 */       return G();
/*     */     }
/* 374 */     return d(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int d(int paramInt) {
/*     */     o o1;
/* 381 */     if ((o1 = this.D) == o.i || o1 == o.j) {
/* 382 */       return G();
/*     */     }
/* 384 */     if (o1 != null) {
/* 385 */       String str; Object object; switch (o1.a()) {
/*     */         
/*     */         case 6:
/* 388 */           if (h(str = w())) {
/* 389 */             return 0;
/*     */           }
/* 391 */           return h.a(str, paramInt);
/*     */         case 9:
/* 393 */           return 1;
/*     */         case 10:
/* 395 */           return 0;
/*     */         case 11:
/* 397 */           return 0;
/*     */         
/*     */         case 12:
/* 400 */           if (object = N() instanceof Number)
/* 401 */             return ((Number)object).intValue(); 
/*     */           break;
/*     */       } 
/*     */     } 
/* 405 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final long Q() {
/*     */     o o1;
/* 412 */     if ((o1 = this.D) == o.i || o1 == o.j) {
/* 413 */       return H();
/*     */     }
/* 415 */     return a(0L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final long a(long paramLong) {
/*     */     o o1;
/* 422 */     if ((o1 = this.D) == o.i || o1 == o.j) {
/* 423 */       return H();
/*     */     }
/* 425 */     if (o1 != null) {
/* 426 */       String str; Object object; switch (o1.a()) {
/*     */         
/*     */         case 6:
/* 429 */           if (h(str = w())) {
/* 430 */             return 0L;
/*     */           }
/* 432 */           return h.a(str, paramLong);
/*     */         case 9:
/* 434 */           return 1L;
/*     */         case 10:
/*     */         case 11:
/* 437 */           return 0L;
/*     */         
/*     */         case 12:
/* 440 */           if (object = N() instanceof Number)
/* 441 */             return ((Number)object).longValue(); 
/*     */           break;
/*     */       } 
/*     */     } 
/* 445 */     return paramLong;
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
/*     */   public String R() {
/* 481 */     return a((String)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String a(String paramString) {
/* 486 */     if (this.D == o.h) {
/* 487 */       return w();
/*     */     }
/* 489 */     if (this.D == o.f) {
/* 490 */       return u();
/*     */     }
/* 492 */     if (this.D == null || this.D == o.m || !this.D.g()) {
/* 493 */       return paramString;
/*     */     }
/* 495 */     return w();
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
/*     */   protected final void a(String paramString, com.a.a.b.g.c paramc, a parama) {
/*     */     try {
/* 518 */       parama.a(paramString, paramc); return;
/* 519 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 520 */       g(illegalArgumentException.getMessage());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean h(String paramString) {
/* 544 */     return "null".equals(paramString);
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
/*     */   protected final <T> T b(int paramInt, String paramString) {
/* 561 */     String str = String.format("Unexpected character (%s) in numeric value", new Object[] { g(paramInt) });
/*     */     
/* 563 */     str = str + ": " + paramString;
/*     */     
/* 565 */     g(str);
/* 566 */     return null;
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
/*     */   protected final void c(String paramString) {
/* 585 */     g("Invalid numeric value: " + paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void ai() {
/* 596 */     d(w());
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void d(String paramString) {
/* 601 */     a(paramString, k());
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(String paramString, o paramo) {
/* 606 */     a(String.format("Numeric value (%s) out of range of int (%d - %s)", new Object[] {
/* 607 */             i(paramString), Integer.valueOf(-2147483648), Integer.valueOf(2147483647)
/*     */           }), paramo, int.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void aj() {
/* 619 */     e(w());
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void e(String paramString) {
/* 624 */     c(paramString, k());
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(String paramString, o paramo) {
/* 629 */     a(String.format("Numeric value (%s) out of range of long (%d - %s)", new Object[] {
/* 630 */             i(paramString), Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE)
/*     */           }), paramo, long.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(String paramString, o paramo, Class<?> paramClass) {
/* 637 */     throw new a(this, paramString, paramo, paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String i(String paramString) {
/*     */     int i;
/* 643 */     if ((i = paramString.length()) < 1000) {
/* 644 */       return paramString;
/*     */     }
/* 646 */     if (paramString.startsWith("-")) {
/* 647 */       i--;
/*     */     }
/* 649 */     return String.format("[Integer with %d digits]", new Object[] { Integer.valueOf(i) });
/*     */   }
/*     */ 
/*     */   
/*     */   protected static String f(String paramString) {
/*     */     int i;
/* 655 */     if ((i = paramString.length()) < 1000) {
/* 656 */       return paramString;
/*     */     }
/* 658 */     if (paramString.startsWith("-")) {
/* 659 */       i--;
/*     */     }
/* 661 */     return String.format("[number with %d characters]", new Object[] { Integer.valueOf(i) });
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void c(int paramInt, String paramString) {
/* 666 */     if (paramInt < 0) {
/* 667 */       ak();
/*     */     }
/* 669 */     String str = String.format("Unexpected character (%s)", new Object[] { g(paramInt) });
/* 670 */     if (paramString != null) {
/* 671 */       str = str + ": " + paramString;
/*     */     }
/* 673 */     g(str);
/*     */   }
/*     */   
/*     */   protected final void ak() {
/* 677 */     b(" in " + this.D, this.D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void b(o paramo) {
/*     */     String str;
/* 683 */     if (paramo == o.h) {
/* 684 */       str = " in a String value";
/* 685 */     } else if (paramo == o.i || paramo == o.j) {
/*     */       
/* 687 */       str = " in a Number value";
/*     */     } else {
/* 689 */       str = " in a value";
/*     */     } 
/* 691 */     b(str, paramo);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void b(String paramString, o paramo) {
/* 696 */     throw new e(this, paramo, "Unexpected end-of-input" + paramString);
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
/*     */   protected final void e(int paramInt) {
/* 721 */     c(paramInt, "Expected space separating root-level values");
/*     */   }
/*     */   
/*     */   protected final void f(int paramInt) {
/* 725 */     paramInt = (char)paramInt;
/* 726 */     String str = "Illegal character (" + g(paramInt) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens";
/* 727 */     g(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static final String g(int paramInt) {
/*     */     char c1;
/* 739 */     if (Character.isISOControl(c1 = (char)paramInt)) {
/* 740 */       return "(CTRL-CHAR, code " + paramInt + ")";
/*     */     }
/* 742 */     if (paramInt > 255) {
/* 743 */       return "'" + c1 + "' (code " + paramInt + " / 0x" + Integer.toHexString(paramInt) + ")";
/*     */     }
/* 745 */     return "'" + c1 + "' (code " + paramInt + ")";
/*     */   }
/*     */   
/*     */   protected final void g(String paramString) {
/* 749 */     throw b(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(String paramString, Object paramObject) {
/* 754 */     throw b(String.format(paramString, new Object[] { paramObject }));
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(String paramString, Object paramObject1, Object paramObject2) {
/* 759 */     throw b(String.format(paramString, new Object[] { paramObject1, paramObject2 }));
/*     */   }
/*     */   
/*     */   protected final void a(String paramString, Throwable paramThrowable) {
/* 763 */     throw b(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   protected static void al() {
/* 767 */     q.a();
/*     */   }
/*     */   
/*     */   private k b(String paramString, Throwable paramThrowable) {
/* 771 */     return new k(this, paramString, paramThrowable);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */