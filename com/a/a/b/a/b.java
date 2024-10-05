/*      */ package com.a.a.b.a;
/*      */ 
/*      */ import com.a.a.b.a;
/*      */ import com.a.a.b.c.a;
/*      */ import com.a.a.b.c.d;
/*      */ import com.a.a.b.c.h;
/*      */ import com.a.a.b.d.d;
/*      */ import com.a.a.b.g.c;
/*      */ import com.a.a.b.g.i;
/*      */ import com.a.a.b.g.o;
/*      */ import com.a.a.b.j;
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.n;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.b.s;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Arrays;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class b
/*      */   extends c
/*      */ {
/*   28 */   protected static final i<s> c = a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final a d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean E;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected long g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   84 */   protected int h = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected long j;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  113 */   protected int k = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int l;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected d m;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected o n;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final o o;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected char[] p;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean q;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private c F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected byte[] r;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  188 */   protected int s = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int t;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long G;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private float H;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private double I;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BigInteger J;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BigDecimal K;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean M;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int N;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected b(a parama, int paramInt) {
/*  251 */     super(paramInt);
/*  252 */     this.d = parama;
/*  253 */     this.o = parama.d();
/*      */     
/*  255 */     com.a.a.b.d.b b1 = l.a.o.a(paramInt) ? com.a.a.b.d.b.a(this) : null;
/*  256 */     this.m = d.b(b1);
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
/*      */   public final void a(Object paramObject) {
/*  268 */     this.m.a(paramObject);
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
/*      */   @Deprecated
/*      */   public final l a(int paramInt) {
/*      */     int j;
/*  301 */     if ((j = this.b ^ paramInt) != 0) {
/*  302 */       this.b = paramInt;
/*  303 */       b(paramInt, j);
/*      */     } 
/*  305 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public final l a(int paramInt1, int paramInt2) {
/*      */     int j;
/*  311 */     paramInt1 = (j = this.b) & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2;
/*      */     
/*  313 */     if ((paramInt2 = j ^ paramInt1) != 0) {
/*  314 */       this.b = paramInt1;
/*  315 */       b(paramInt1, paramInt2);
/*      */     } 
/*  317 */     return this;
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
/*      */   private void b(int paramInt1, int paramInt2) {
/*  331 */     int j = l.a.o.c();
/*      */     
/*  333 */     if ((paramInt2 & j) != 0 && (
/*  334 */       paramInt1 & j) != 0) {
/*  335 */       if (this.m.k() == null) {
/*  336 */         this.m = this.m.a(com.a.a.b.d.b.a(this)); return;
/*      */       } 
/*  338 */       this.m = this.m.a(null);
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
/*      */   public final String u() {
/*      */     d d1;
/*  356 */     if ((this.D == o.b || this.D == o.d) && (
/*      */       
/*  358 */       d1 = this.m.i()) != null) {
/*  359 */       return d1.g();
/*      */     }
/*      */     
/*  362 */     return this.m.g();
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
/*      */   public void close() {
/*  381 */     if (!this.E) {
/*      */       
/*  383 */       this.e = Math.max(this.e, this.f);
/*  384 */       this.E = true;
/*      */       try {
/*  386 */         W();
/*      */         
/*      */         return;
/*      */       } finally {
/*  390 */         X();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private d am() {
/*  396 */     return this.m;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public j f() {
/*  405 */     return new j(ag(), -1L, 
/*  406 */         an(), 
/*  407 */         ao(), 
/*  408 */         ap());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public j e() {
/*  417 */     int j = this.e - this.i + 1;
/*  418 */     return new j(ag(), -1L, this.g + this.e, this.h, j);
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
/*      */   public final boolean A() {
/*  431 */     if (this.D == o.h) return true; 
/*  432 */     if (this.D == o.f) return this.q; 
/*  433 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] a(a parama) {
/*  440 */     if (this.r == null) {
/*  441 */       if (this.D != o.h) {
/*  442 */         g("Current token (" + this.D + ") not VALUE_STRING, can not access as binary");
/*      */       }
/*  444 */       c c1 = aa();
/*  445 */       a(w(), c1, parama);
/*  446 */       this.r = c1.b();
/*      */     } 
/*  448 */     return this.r;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long an() {
/*  457 */     return this.j; } private int ao() {
/*  458 */     return this.k;
/*      */   }
/*      */   private int ap() {
/*      */     int j;
/*  462 */     return ((j = this.l) < 0) ? j : (j + 1);
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
/*      */   protected void X() {
/*  489 */     this.o.a();
/*      */     char[] arrayOfChar;
/*  491 */     if ((arrayOfChar = this.p) != null) {
/*  492 */       this.p = null;
/*  493 */       this.d.c(arrayOfChar);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void Y() {
/*  504 */     if (!this.m.c()) {
/*  505 */       String str = this.m.b() ? "Array" : "Object";
/*  506 */       b(String.format(": expected close marker for %s (start marker at %s)", new Object[] { str, this.m
/*      */ 
/*      */               
/*  509 */               .a(ag()) }), (o)null);
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
/*      */   protected final int Z() {
/*  523 */     Y();
/*  524 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final c aa() {
/*  535 */     if (this.F == null) {
/*  536 */       this.F = new c();
/*      */     } else {
/*  538 */       this.F.a();
/*      */     } 
/*  540 */     return this.F;
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
/*      */   protected final o a(boolean paramBoolean, int paramInt) {
/*  561 */     this.M = paramBoolean;
/*  562 */     this.N = paramInt;
/*      */ 
/*      */     
/*  565 */     this.s = 0;
/*  566 */     return o.i;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final o a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
/*  571 */     this.M = paramBoolean;
/*  572 */     this.N = paramInt1;
/*      */ 
/*      */     
/*  575 */     this.s = 0;
/*  576 */     return o.j;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final o a(String paramString, double paramDouble) {
/*  581 */     this.o.a(paramString);
/*  582 */     this.I = paramDouble;
/*  583 */     this.s = 8;
/*  584 */     return o.j;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean s() {
/*  589 */     if (this.D == o.j && (
/*  590 */       this.s & 0x8) != 0) {
/*      */       double d1;
/*      */       
/*  593 */       if (Double.isNaN(d1 = this.I) || Double.isInfinite(d1)) return true;  return false;
/*      */     } 
/*      */     
/*  596 */     return false;
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
/*      */   public final Number B() {
/*  608 */     if (this.s == 0) {
/*  609 */       h(0);
/*      */     }
/*      */     
/*  612 */     if (this.D == o.i) {
/*  613 */       if ((this.s & 0x1) != 0) {
/*  614 */         return Integer.valueOf(this.t);
/*      */       }
/*  616 */       if ((this.s & 0x2) != 0) {
/*  617 */         return Long.valueOf(this.G);
/*      */       }
/*  619 */       if ((this.s & 0x4) != 0) {
/*  620 */         return av();
/*      */       }
/*  622 */       al();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  627 */     if ((this.s & 0x10) != 0) {
/*  628 */       return aw();
/*      */     }
/*  630 */     if ((this.s & 0x20) != 0) {
/*  631 */       return Float.valueOf(this.H);
/*      */     }
/*  633 */     if ((this.s & 0x8) == 0) {
/*  634 */       al();
/*      */     }
/*  636 */     return Double.valueOf(this.I);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Number C() {
/*  643 */     if (this.D == o.i) {
/*  644 */       if (this.s == 0) {
/*  645 */         h(0);
/*      */       }
/*  647 */       if ((this.s & 0x1) != 0) {
/*  648 */         return Integer.valueOf(this.t);
/*      */       }
/*  650 */       if ((this.s & 0x2) != 0) {
/*  651 */         return Long.valueOf(this.G);
/*      */       }
/*  653 */       if ((this.s & 0x4) != 0) {
/*  654 */         return av();
/*      */       }
/*  656 */       al();
/*      */     } 
/*      */     
/*  659 */     if (this.s == 0) {
/*  660 */       h(16);
/*      */     }
/*  662 */     if ((this.s & 0x10) != 0) {
/*  663 */       return aw();
/*      */     }
/*  665 */     if ((this.s & 0x20) != 0) {
/*  666 */       return Float.valueOf(this.H);
/*      */     }
/*  668 */     if ((this.s & 0x8) == 0) {
/*  669 */       al();
/*      */     }
/*  671 */     return Double.valueOf(this.I);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final l.b D() {
/*  677 */     if (this.s == 0) {
/*  678 */       h(0);
/*      */     }
/*  680 */     if (this.D == o.i) {
/*  681 */       if ((this.s & 0x1) != 0) {
/*  682 */         return l.b.a;
/*      */       }
/*  684 */       if ((this.s & 0x2) != 0) {
/*  685 */         return l.b.b;
/*      */       }
/*  687 */       return l.b.c;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  696 */     if ((this.s & 0x10) != 0) {
/*  697 */       return l.b.f;
/*      */     }
/*  699 */     if ((this.s & 0x20) != 0) {
/*  700 */       return l.b.d;
/*      */     }
/*  702 */     return l.b.e;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final int G() {
/*  708 */     if ((this.s & 0x1) == 0) {
/*  709 */       if (this.s == 0) {
/*  710 */         return ab();
/*      */       }
/*  712 */       if ((this.s & 0x1) == 0) {
/*  713 */         ac();
/*      */       }
/*      */     } 
/*  716 */     return this.t;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final long H() {
/*  722 */     if ((this.s & 0x2) == 0) {
/*  723 */       if (this.s == 0) {
/*  724 */         h(2);
/*      */       }
/*  726 */       if ((this.s & 0x2) == 0) {
/*  727 */         aq();
/*      */       }
/*      */     } 
/*  730 */     return this.G;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final BigInteger I() {
/*  736 */     if ((this.s & 0x4) == 0) {
/*  737 */       if (this.s == 0) {
/*  738 */         h(4);
/*      */       }
/*  740 */       if ((this.s & 0x4) == 0) {
/*  741 */         ar();
/*      */       }
/*      */     } 
/*  744 */     return av();
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
/*      */   public final float J() {
/*  758 */     if ((this.s & 0x20) == 0) {
/*  759 */       if (this.s == 0) {
/*  760 */         h(32);
/*      */       }
/*  762 */       if ((this.s & 0x20) == 0) {
/*  763 */         at();
/*      */       }
/*      */     } 
/*  766 */     return this.H;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final double K() {
/*  772 */     if ((this.s & 0x8) == 0) {
/*  773 */       if (this.s == 0) {
/*  774 */         h(8);
/*      */       }
/*  776 */       if ((this.s & 0x8) == 0) {
/*  777 */         as();
/*      */       }
/*      */     } 
/*  780 */     return this.I;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final BigDecimal L() {
/*  786 */     if ((this.s & 0x10) == 0) {
/*  787 */       if (this.s == 0) {
/*  788 */         h(16);
/*      */       }
/*  790 */       if ((this.s & 0x10) == 0) {
/*  791 */         au();
/*      */       }
/*      */     } 
/*  794 */     return aw();
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
/*      */   private void h(int paramInt) {
/*  820 */     if (this.E) {
/*  821 */       g("Internal error: _parseNumericValue called when parser instance closed");
/*      */     }
/*      */ 
/*      */     
/*  825 */     if (this.D == o.i) {
/*      */       int j;
/*      */       
/*  828 */       if ((j = this.N) <= 9) {
/*  829 */         int k = this.o.c(this.M);
/*  830 */         this.t = k;
/*  831 */         this.s = 1;
/*      */         return;
/*      */       } 
/*  834 */       if (j <= 18) {
/*  835 */         long l = this.o.d(this.M);
/*      */         
/*  837 */         if (j == 10) {
/*  838 */           if (this.M) {
/*  839 */             if (l >= -2147483648L) {
/*  840 */               this.t = (int)l;
/*  841 */               this.s = 1;
/*      */               
/*      */               return;
/*      */             } 
/*  845 */           } else if (l <= 2147483647L) {
/*  846 */             this.t = (int)l;
/*  847 */             this.s = 1;
/*      */             
/*      */             return;
/*      */           } 
/*      */         }
/*  852 */         this.G = l;
/*  853 */         this.s = 2;
/*      */         return;
/*      */       } 
/*  856 */       j(paramInt);
/*      */       return;
/*      */     } 
/*  859 */     if (this.D == o.j) {
/*  860 */       i(paramInt);
/*      */       return;
/*      */     } 
/*  863 */     a("Current token (%s) not numeric, can not use numeric value accessors", this.D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final int ab() {
/*  872 */     if (this.E) {
/*  873 */       g("Internal error: _parseNumericValue called when parser instance closed");
/*      */     }
/*      */     
/*  876 */     if (this.D == o.i && 
/*  877 */       this.N <= 9) {
/*  878 */       int j = this.o.c(this.M);
/*  879 */       this.t = j;
/*  880 */       this.s = 1;
/*  881 */       return j;
/*      */     } 
/*      */ 
/*      */     
/*  885 */     h(1);
/*  886 */     if ((this.s & 0x1) == 0) {
/*  887 */       ac();
/*      */     }
/*  889 */     return this.t;
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
/*      */   private void i(int paramInt) {
/*      */     try {
/*  902 */       if (paramInt == 16) {
/*  903 */         this.K = null;
/*  904 */         this.L = this.o.e();
/*  905 */         this.s = 16;
/*  906 */       } else if (paramInt == 32) {
/*  907 */         this.H = this.o.b(a(l.a.r));
/*  908 */         this.s = 32;
/*      */       } else {
/*      */         
/*  911 */         this.I = this.o.a(a(l.a.r));
/*  912 */         this.s = 8; return;
/*      */       } 
/*  914 */     } catch (NumberFormatException numberFormatException) {
/*      */       
/*  916 */       a("Malformed numeric value (" + f(this.o.e()) + ")", numberFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void j(int paramInt) {
/*  922 */     String str = this.o.e();
/*      */     try {
/*  924 */       int j = this.N;
/*  925 */       char[] arrayOfChar = this.o.d();
/*  926 */       int k = this.o.c();
/*  927 */       if (this.M) {
/*  928 */         k++;
/*      */       }
/*      */       
/*  931 */       if (h.a(arrayOfChar, k, j, this.M)) {
/*      */         
/*  933 */         this.G = Long.parseLong(str);
/*  934 */         this.s = 2;
/*      */       } else {
/*      */         
/*  937 */         if (paramInt == 1 || paramInt == 2) {
/*  938 */           d(paramInt, str);
/*      */         }
/*  940 */         if (paramInt == 8 || paramInt == 32) {
/*  941 */           this.I = h.b(str, a(l.a.r));
/*  942 */           this.s = 8;
/*      */         } else {
/*      */           
/*  945 */           this.J = null;
/*  946 */           this.L = str;
/*  947 */           this.s = 4; return;
/*      */         } 
/*      */       } 
/*  950 */     } catch (NumberFormatException numberFormatException) {
/*      */       
/*  952 */       a("Malformed numeric value (" + f(str) + ")", numberFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(int paramInt, String paramString) {
/*  959 */     if (paramInt == 1) {
/*  960 */       d(paramString); return;
/*      */     } 
/*  962 */     e(paramString);
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
/*      */   protected final void ac() {
/*  975 */     if ((this.s & 0x2) != 0) {
/*      */       int j;
/*      */       
/*  978 */       if ((j = (int)this.G) != this.G) {
/*  979 */         a(w(), k());
/*      */       }
/*  981 */       this.t = j;
/*  982 */     } else if ((this.s & 0x4) != 0) {
/*  983 */       BigInteger bigInteger = av();
/*  984 */       if (v.compareTo(bigInteger) > 0 || w
/*  985 */         .compareTo(bigInteger) < 0) {
/*  986 */         ai();
/*      */       }
/*  988 */       this.t = bigInteger.intValue();
/*  989 */     } else if ((this.s & 0x8) != 0) {
/*      */       
/*  991 */       if (this.I < -2.147483648E9D || this.I > 2.147483647E9D) {
/*  992 */         ai();
/*      */       }
/*  994 */       this.t = (int)this.I;
/*  995 */     } else if ((this.s & 0x10) != 0) {
/*  996 */       BigDecimal bigDecimal = aw();
/*  997 */       if (B.compareTo(bigDecimal) > 0 || C
/*  998 */         .compareTo(bigDecimal) < 0) {
/*  999 */         ai();
/*      */       }
/* 1001 */       this.t = bigDecimal.intValue();
/*      */     } else {
/* 1003 */       al();
/*      */     } 
/* 1005 */     this.s |= 0x1;
/*      */   }
/*      */ 
/*      */   
/*      */   private void aq() {
/* 1010 */     if ((this.s & 0x1) != 0) {
/* 1011 */       this.G = this.t;
/* 1012 */     } else if ((this.s & 0x4) != 0) {
/* 1013 */       BigInteger bigInteger = av();
/* 1014 */       if (x.compareTo(bigInteger) > 0 || y
/* 1015 */         .compareTo(bigInteger) < 0) {
/* 1016 */         aj();
/*      */       }
/* 1018 */       this.G = bigInteger.longValue();
/* 1019 */     } else if ((this.s & 0x8) != 0) {
/*      */       
/* 1021 */       if (this.I < -9.223372036854776E18D || this.I > 9.223372036854776E18D) {
/* 1022 */         aj();
/*      */       }
/* 1024 */       this.G = (long)this.I;
/* 1025 */     } else if ((this.s & 0x10) != 0) {
/* 1026 */       BigDecimal bigDecimal = aw();
/* 1027 */       if (z.compareTo(bigDecimal) > 0 || A
/* 1028 */         .compareTo(bigDecimal) < 0) {
/* 1029 */         aj();
/*      */       }
/* 1031 */       this.G = bigDecimal.longValue();
/*      */     } else {
/* 1033 */       al();
/*      */     } 
/* 1035 */     this.s |= 0x2;
/*      */   }
/*      */ 
/*      */   
/*      */   private void ar() {
/* 1040 */     if ((this.s & 0x10) != 0) {
/*      */       
/* 1042 */       this.J = aw().toBigInteger();
/* 1043 */     } else if ((this.s & 0x2) != 0) {
/* 1044 */       this.J = BigInteger.valueOf(this.G);
/* 1045 */     } else if ((this.s & 0x1) != 0) {
/* 1046 */       this.J = BigInteger.valueOf(this.t);
/* 1047 */     } else if ((this.s & 0x8) != 0) {
/* 1048 */       this.J = BigDecimal.valueOf(this.I).toBigInteger();
/*      */     } else {
/* 1050 */       al();
/*      */     } 
/* 1052 */     this.s |= 0x4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void as() {
/* 1063 */     if ((this.s & 0x10) != 0) {
/* 1064 */       this.I = aw().doubleValue();
/* 1065 */     } else if ((this.s & 0x4) != 0) {
/* 1066 */       this.I = av().doubleValue();
/* 1067 */     } else if ((this.s & 0x2) != 0) {
/* 1068 */       this.I = this.G;
/* 1069 */     } else if ((this.s & 0x1) != 0) {
/* 1070 */       this.I = this.t;
/* 1071 */     } else if ((this.s & 0x20) != 0) {
/* 1072 */       this.I = this.H;
/*      */     } else {
/* 1074 */       al();
/*      */     } 
/* 1076 */     this.s |= 0x8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void at() {
/* 1087 */     if ((this.s & 0x10) != 0) {
/* 1088 */       this.H = aw().floatValue();
/* 1089 */     } else if ((this.s & 0x4) != 0) {
/* 1090 */       this.H = av().floatValue();
/* 1091 */     } else if ((this.s & 0x2) != 0) {
/* 1092 */       this.H = (float)this.G;
/* 1093 */     } else if ((this.s & 0x1) != 0) {
/* 1094 */       this.H = this.t;
/* 1095 */     } else if ((this.s & 0x8) != 0) {
/* 1096 */       this.H = (float)this.I;
/*      */     } else {
/* 1098 */       al();
/*      */     } 
/* 1100 */     this.s |= 0x20;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void au() {
/* 1111 */     if ((this.s & 0x8) != 0) {
/*      */ 
/*      */       
/* 1114 */       this.K = h.d(w());
/* 1115 */     } else if ((this.s & 0x4) != 0) {
/* 1116 */       this.K = new BigDecimal(av());
/* 1117 */     } else if ((this.s & 0x2) != 0) {
/* 1118 */       this.K = BigDecimal.valueOf(this.G);
/* 1119 */     } else if ((this.s & 0x1) != 0) {
/* 1120 */       this.K = BigDecimal.valueOf(this.t);
/*      */     } else {
/* 1122 */       al();
/*      */     } 
/* 1124 */     this.s |= 0x10;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BigInteger av() {
/* 1134 */     if (this.J != null)
/* 1135 */       return this.J; 
/* 1136 */     if (this.L == null) {
/* 1137 */       throw new IllegalStateException("cannot get BigInteger from current parser state");
/*      */     }
/* 1139 */     this.J = h.e(this.L);
/* 1140 */     this.L = null;
/* 1141 */     return this.J;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private BigDecimal aw() {
/* 1151 */     if (this.K != null)
/* 1152 */       return this.K; 
/* 1153 */     if (this.L == null) {
/* 1154 */       throw new IllegalStateException("cannot get BigDecimal from current parser state");
/*      */     }
/* 1156 */     this.K = h.d(this.L);
/* 1157 */     this.L = null;
/* 1158 */     return this.K;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void a(int paramInt, char paramChar) {
/* 1168 */     d d1 = am();
/* 1169 */     g(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", new Object[] {
/*      */             
/* 1171 */             Character.valueOf((char)paramInt), Character.valueOf(paramChar), d1.e(), d1
/* 1172 */             .a(ag())
/*      */           }));
/*      */   }
/*      */ 
/*      */   
/*      */   protected final char a(char paramChar) {
/* 1178 */     if (a(l.a.g)) {
/* 1179 */       return paramChar;
/*      */     }
/*      */     
/* 1182 */     if (paramChar == '\'' && a(l.a.e)) {
/* 1183 */       return paramChar;
/*      */     }
/* 1185 */     g("Unrecognized character escape " + g(paramChar));
/* 1186 */     return paramChar;
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
/*      */   protected final void a(int paramInt, String paramString) {
/* 1203 */     if (!a(l.a.f) || paramInt > 32) {
/* 1204 */       paramInt = (char)paramInt;
/* 1205 */       String str = "Illegal unquoted character (" + g(paramInt) + "): has to be escaped using backslash to be included in " + paramString;
/* 1206 */       g(str);
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
/*      */   protected final String ad() {
/* 1220 */     return ae();
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
/*      */   protected final String ae() {
/* 1234 */     if (a(l.a.l)) {
/* 1235 */       return "(JSON String, Number (or 'NaN'/'INF'/'+INF'), Array, Object or token 'null', 'true' or 'false')";
/*      */     }
/* 1237 */     return "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
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
/*      */   protected char af() {
/* 1256 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final int a(a parama, int paramInt1, int paramInt2) {
/* 1262 */     if (paramInt1 != 92) {
/* 1263 */       throw b(parama, paramInt1, paramInt2);
/*      */     }
/*      */ 
/*      */     
/* 1267 */     if ((paramInt1 = af()) <= 32 && 
/* 1268 */       paramInt2 == 0) {
/* 1269 */       return -1;
/*      */     }
/*      */     
/*      */     int j;
/*      */     
/* 1274 */     if ((j = parama.b(paramInt1)) < 0 && 
/* 1275 */       j != -2) {
/* 1276 */       throw b(parama, paramInt1, paramInt2);
/*      */     }
/*      */     
/* 1279 */     return j;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final int a(a parama, char paramChar, int paramInt) {
/* 1284 */     if (paramChar != '\\') {
/* 1285 */       throw b(parama, paramChar, paramInt);
/*      */     }
/*      */ 
/*      */     
/* 1289 */     if ((paramChar = af()) <= ' ' && 
/* 1290 */       paramInt == 0) {
/* 1291 */       return -1;
/*      */     }
/*      */     
/*      */     int j;
/*      */     
/* 1296 */     if ((j = parama.b(paramChar)) < 0)
/*      */     {
/* 1298 */       if (j != -2 || paramInt < 2) {
/* 1299 */         throw b(parama, paramChar, paramInt);
/*      */       }
/*      */     }
/* 1302 */     return j;
/*      */   }
/*      */   
/*      */   private IllegalArgumentException b(a parama, int paramInt1, int paramInt2) {
/* 1306 */     return a(parama, paramInt1, paramInt2, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static IllegalArgumentException a(a parama, int paramInt1, int paramInt2, String paramString) {
/*      */     String str;
/* 1315 */     if (paramInt1 <= 32) {
/* 1316 */       str = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", new Object[] {
/* 1317 */             Integer.toHexString(paramInt1), Integer.valueOf(paramInt2 + 1) });
/* 1318 */     } else if (str.a(paramInt1)) {
/* 1319 */       str = "Unexpected padding character ('" + str.b() + "') as character #" + (paramInt2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
/* 1320 */     } else if (!Character.isDefined(paramInt1) || Character.isISOControl(paramInt1)) {
/*      */       
/* 1322 */       str = "Illegal character (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
/*      */     } else {
/* 1324 */       str = "Illegal character '" + (char)paramInt1 + "' (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
/*      */     } 
/* 1326 */     if (paramString != null) {
/* 1327 */       str = str + ": " + paramString;
/*      */     }
/* 1329 */     return new IllegalArgumentException(str);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void b(a parama) {
/* 1335 */     g(parama.d());
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
/*      */   protected final d ag() {
/* 1366 */     if (l.a.q.a(this.b)) {
/* 1367 */       return this.d.c();
/*      */     }
/* 1369 */     return d.a();
/*      */   }
/*      */ 
/*      */   
/*      */   protected static int[] a(int[] paramArrayOfint, int paramInt) {
/* 1374 */     if (paramArrayOfint == null) {
/* 1375 */       return new int[paramInt];
/*      */     }
/* 1377 */     return Arrays.copyOf(paramArrayOfint, paramArrayOfint.length + paramInt);
/*      */   }
/*      */   
/*      */   protected void ah() {}
/*      */   
/*      */   protected abstract void W();
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */