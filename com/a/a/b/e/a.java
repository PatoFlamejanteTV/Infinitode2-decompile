/*      */ package com.a.a.b.e;
/*      */ 
/*      */ import com.a.a.b.f;
/*      */ import com.a.a.b.g.g;
/*      */ import java.util.Arrays;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class a
/*      */ {
/*      */   private a h;
/*      */   private AtomicReference<a> i;
/*      */   private int j;
/*      */   private boolean k;
/*      */   private boolean l;
/*      */   protected int[] a;
/*      */   protected int b;
/*      */   private int m;
/*      */   private int n;
/*      */   protected int c;
/*      */   protected int d;
/*      */   protected String[] e;
/*      */   protected int f;
/*      */   protected int g;
/*      */   private boolean o;
/*      */   
/*      */   private a(int paramInt1, int paramInt2) {
/*  229 */     this.h = null;
/*  230 */     this.d = 0;
/*      */ 
/*      */     
/*  233 */     this.o = true;
/*  234 */     this.j = paramInt2;
/*  235 */     this.k = false;
/*  236 */     this.l = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  251 */     this.i = new AtomicReference<>(a.a(64));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private a(a parama, int paramInt, a parama1, boolean paramBoolean1, boolean paramBoolean2) {
/*  261 */     this.h = parama;
/*  262 */     this.j = paramInt;
/*  263 */     this.k = paramBoolean1;
/*  264 */     this.l = paramBoolean2;
/*  265 */     this.i = null;
/*      */ 
/*      */     
/*  268 */     this.d = parama1.b;
/*  269 */     this.b = parama1.a;
/*  270 */     this.m = this.b << 2;
/*  271 */     this.n = this.m + (this.m >> 1);
/*  272 */     this.c = parama1.c;
/*      */     
/*  274 */     this.a = parama1.d;
/*  275 */     this.e = parama1.e;
/*      */     
/*  277 */     this.f = parama1.f;
/*  278 */     this.g = parama1.g;
/*      */ 
/*      */     
/*  281 */     this.o = true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static a a() {
/*      */     long l;
/*      */     int i;
/*  344 */     return d(i = (int)(l = System.currentTimeMillis()) + (int)(l >>> 32L) | 0x1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static a d(int paramInt) {
/*  350 */     return new a(64, paramInt);
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
/*      */   public final a a(int paramInt) {
/*  362 */     return new a(this, this.j, this.i
/*  363 */         .get(), f.a.a
/*  364 */         .a(paramInt), f.a.c
/*  365 */         .a(paramInt));
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
/*      */   public final void b() {
/*  401 */     if (this.h != null && c()) {
/*  402 */       this.h.a(new a(this));
/*      */ 
/*      */       
/*  405 */       this.o = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(a parama) {
/*  411 */     int i = parama.b;
/*  412 */     a a1 = this.i.get();
/*      */ 
/*      */ 
/*      */     
/*  416 */     if (i == a1.b) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  424 */     if (i > 6000)
/*      */     {
/*  426 */       parama = a.a(64);
/*      */     }
/*  428 */     this.i.compareAndSet(a1, parama);
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
/*      */   private boolean c() {
/*  461 */     return !this.o;
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
/*      */   private int d() {
/*  485 */     byte b1 = 0; byte b2; int i;
/*  486 */     for (b2 = 3, i = this.m; b2 < i; b2 += 4) {
/*  487 */       if (this.a[b2] != 0) {
/*  488 */         b1++;
/*      */       }
/*      */     } 
/*  491 */     return b1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int e() {
/*  501 */     byte b = 0;
/*  502 */     int i = this.m + 3;
/*  503 */     for (int j = this.n; i < j; i += 4) {
/*  504 */       if (this.a[i] != 0) {
/*  505 */         b++;
/*      */       }
/*      */     } 
/*  508 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int f() {
/*  518 */     byte b = 0;
/*      */     int i;
/*  520 */     for (int j = (i = this.n + 3) + this.b; i < j; i += 4) {
/*  521 */       if (this.a[i] != 0) {
/*  522 */         b++;
/*      */       }
/*      */     } 
/*  525 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int g() {
/*  536 */     return this.f - l() >> 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private int h() {
/*  541 */     byte b1 = 0; byte b2; int i;
/*  542 */     for (b2 = 3, i = this.b << 3; b2 < i; b2 += 4) {
/*  543 */       if (this.a[b2] != 0) {
/*  544 */         b1++;
/*      */       }
/*      */     } 
/*  547 */     return b1;
/*      */   }
/*      */ 
/*      */   
/*      */   public final String toString() {
/*  552 */     int i = d();
/*  553 */     int j = e();
/*  554 */     int k = f();
/*  555 */     int m = g();
/*  556 */     int n = h();
/*  557 */     return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[] {
/*  558 */           getClass().getName(), Integer.valueOf(this.d), Integer.valueOf(this.b), 
/*  559 */           Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i + j + k + m), Integer.valueOf(n)
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String b(int paramInt) {
/*  570 */     int i = e(h(paramInt));
/*      */ 
/*      */     
/*      */     int arrayOfInt[], j;
/*      */ 
/*      */     
/*  576 */     if ((j = (arrayOfInt = this.a)[i + 3]) == 1) {
/*  577 */       if (arrayOfInt[i] == paramInt) {
/*  578 */         return this.e[i >> 2];
/*      */       }
/*  580 */     } else if (j == 0) {
/*  581 */       return null;
/*      */     } 
/*      */     
/*  584 */     int k = this.m + (i >> 3 << 2);
/*      */ 
/*      */ 
/*      */     
/*  588 */     if ((j = arrayOfInt[k + 3]) == 1) {
/*  589 */       if (arrayOfInt[k] == paramInt) {
/*  590 */         return this.e[k >> 2];
/*      */       }
/*  592 */     } else if (j == 0) {
/*  593 */       return null;
/*      */     } 
/*      */ 
/*      */     
/*  597 */     return b(i, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public final String a(int paramInt1, int paramInt2) {
/*  602 */     int i = e(c(paramInt1, paramInt2));
/*      */ 
/*      */     
/*      */     int arrayOfInt[], j;
/*      */ 
/*      */     
/*  608 */     if ((j = (arrayOfInt = this.a)[i + 3]) == 2) {
/*  609 */       if (paramInt1 == arrayOfInt[i] && paramInt2 == arrayOfInt[i + 1]) {
/*  610 */         return this.e[i >> 2];
/*      */       }
/*  612 */     } else if (j == 0) {
/*  613 */       return null;
/*      */     } 
/*      */     
/*  616 */     int k = this.m + (i >> 3 << 2);
/*      */ 
/*      */ 
/*      */     
/*  620 */     if ((j = arrayOfInt[k + 3]) == 2) {
/*  621 */       if (paramInt1 == arrayOfInt[k] && paramInt2 == arrayOfInt[k + 1]) {
/*  622 */         return this.e[k >> 2];
/*      */       }
/*  624 */     } else if (j == 0) {
/*  625 */       return null;
/*      */     } 
/*  627 */     return b(i, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public final String a(int paramInt1, int paramInt2, int paramInt3) {
/*  632 */     int i = e(c(paramInt1, paramInt2, paramInt3));
/*      */     
/*      */     int arrayOfInt[], j;
/*      */     
/*  636 */     if ((j = (arrayOfInt = this.a)[i + 3]) == 3) {
/*  637 */       if (paramInt1 == arrayOfInt[i] && arrayOfInt[i + 1] == paramInt2 && arrayOfInt[i + 2] == paramInt3) {
/*  638 */         return this.e[i >> 2];
/*      */       }
/*  640 */     } else if (j == 0) {
/*  641 */       return null;
/*      */     } 
/*      */     
/*  644 */     int k = this.m + (i >> 3 << 2);
/*      */ 
/*      */ 
/*      */     
/*  648 */     if ((j = arrayOfInt[k + 3]) == 3) {
/*  649 */       if (paramInt1 == arrayOfInt[k] && arrayOfInt[k + 1] == paramInt2 && arrayOfInt[k + 2] == paramInt3) {
/*  650 */         return this.e[k >> 2];
/*      */       }
/*  652 */     } else if (j == 0) {
/*  653 */       return null;
/*      */     } 
/*  655 */     return a(i, paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String a(int[] paramArrayOfint, int paramInt) {
/*  664 */     if (paramInt < 4) {
/*  665 */       switch (paramInt) {
/*      */         case 3:
/*  667 */           return a(paramArrayOfint[0], paramArrayOfint[1], paramArrayOfint[2]);
/*      */         case 2:
/*  669 */           return a(paramArrayOfint[0], paramArrayOfint[1]);
/*      */         case 1:
/*  671 */           return b(paramArrayOfint[0]);
/*      */       } 
/*  673 */       return "";
/*      */     } 
/*      */     
/*  676 */     int i = c(paramArrayOfint, paramInt);
/*  677 */     int j = e(i);
/*      */ 
/*      */ 
/*      */     
/*  681 */     int arrayOfInt[], k = (arrayOfInt = this.a)[j + 3];
/*      */     
/*  683 */     if (i == arrayOfInt[j] && k == paramInt)
/*      */     {
/*  685 */       if (a(paramArrayOfint, paramInt, arrayOfInt[j + 1])) {
/*  686 */         return this.e[j >> 2];
/*      */       }
/*      */     }
/*  689 */     if (k == 0) {
/*  690 */       return null;
/*      */     }
/*      */     
/*  693 */     k = this.m + (j >> 3 << 2);
/*      */     
/*  695 */     int m = arrayOfInt[k + 3];
/*  696 */     if (i == arrayOfInt[k] && m == paramInt && 
/*  697 */       a(paramArrayOfint, paramInt, arrayOfInt[k + 1])) {
/*  698 */       return this.e[k >> 2];
/*      */     }
/*      */     
/*  701 */     return a(j, i, paramArrayOfint, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int e(int paramInt) {
/*  711 */     return (paramInt = paramInt & this.b - 1) << 2;
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
/*      */   private String b(int paramInt1, int paramInt2) {
/*  726 */     paramInt1 = this.n + (paramInt1 >> this.c + 2 << this.c);
/*  727 */     int[] arrayOfInt = this.a;
/*  728 */     int i = 1 << this.c;
/*  729 */     for (i = paramInt1 + i; paramInt1 < i; paramInt1 += 4) {
/*  730 */       int j = arrayOfInt[paramInt1 + 3];
/*  731 */       if (paramInt2 == arrayOfInt[paramInt1] && 1 == j) {
/*  732 */         return this.e[paramInt1 >> 2];
/*      */       }
/*  734 */       if (j == 0) {
/*  735 */         return null;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  741 */     for (paramInt1 = l(); paramInt1 < this.f; paramInt1 += 4) {
/*  742 */       if (paramInt2 == arrayOfInt[paramInt1] && 1 == arrayOfInt[paramInt1 + 3]) {
/*  743 */         return this.e[paramInt1 >> 2];
/*      */       }
/*      */     } 
/*  746 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private String b(int paramInt1, int paramInt2, int paramInt3) {
/*  751 */     paramInt1 = this.n + (paramInt1 >> this.c + 2 << this.c);
/*  752 */     int[] arrayOfInt = this.a;
/*      */     
/*  754 */     int i = 1 << this.c;
/*  755 */     for (i = paramInt1 + i; paramInt1 < i; paramInt1 += 4) {
/*  756 */       int j = arrayOfInt[paramInt1 + 3];
/*  757 */       if (paramInt2 == arrayOfInt[paramInt1] && paramInt3 == arrayOfInt[paramInt1 + 1] && 2 == j) {
/*  758 */         return this.e[paramInt1 >> 2];
/*      */       }
/*  760 */       if (j == 0) {
/*  761 */         return null;
/*      */       }
/*      */     } 
/*  764 */     for (paramInt1 = l(); paramInt1 < this.f; paramInt1 += 4) {
/*  765 */       if (paramInt2 == arrayOfInt[paramInt1] && paramInt3 == arrayOfInt[paramInt1 + 1] && 2 == arrayOfInt[paramInt1 + 3]) {
/*  766 */         return this.e[paramInt1 >> 2];
/*      */       }
/*      */     } 
/*  769 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  774 */     paramInt1 = this.n + (paramInt1 >> this.c + 2 << this.c);
/*  775 */     int[] arrayOfInt = this.a;
/*      */     
/*  777 */     int i = 1 << this.c;
/*  778 */     for (i = paramInt1 + i; paramInt1 < i; paramInt1 += 4) {
/*  779 */       int j = arrayOfInt[paramInt1 + 3];
/*  780 */       if (paramInt2 == arrayOfInt[paramInt1] && paramInt3 == arrayOfInt[paramInt1 + 1] && paramInt4 == arrayOfInt[paramInt1 + 2] && 3 == j) {
/*  781 */         return this.e[paramInt1 >> 2];
/*      */       }
/*  783 */       if (j == 0) {
/*  784 */         return null;
/*      */       }
/*      */     } 
/*  787 */     for (paramInt1 = l(); paramInt1 < this.f; paramInt1 += 4) {
/*  788 */       if (paramInt2 == arrayOfInt[paramInt1] && paramInt3 == arrayOfInt[paramInt1 + 1] && paramInt4 == arrayOfInt[paramInt1 + 2] && 3 == arrayOfInt[paramInt1 + 3])
/*      */       {
/*  790 */         return this.e[paramInt1 >> 2];
/*      */       }
/*      */     } 
/*  793 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private String a(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/*  798 */     paramInt1 = this.n + (paramInt1 >> this.c + 2 << this.c);
/*  799 */     int[] arrayOfInt = this.a;
/*      */     
/*  801 */     int i = 1 << this.c;
/*  802 */     for (i = paramInt1 + i; paramInt1 < i; paramInt1 += 4) {
/*  803 */       int j = arrayOfInt[paramInt1 + 3];
/*  804 */       if (paramInt2 == arrayOfInt[paramInt1] && paramInt3 == j && 
/*  805 */         a(paramArrayOfint, paramInt3, arrayOfInt[paramInt1 + 1])) {
/*  806 */         return this.e[paramInt1 >> 2];
/*      */       }
/*      */       
/*  809 */       if (j == 0) {
/*  810 */         return null;
/*      */       }
/*      */     } 
/*  813 */     for (paramInt1 = l(); paramInt1 < this.f; paramInt1 += 4) {
/*  814 */       if (paramInt2 == arrayOfInt[paramInt1] && paramInt3 == arrayOfInt[paramInt1 + 3] && 
/*  815 */         a(paramArrayOfint, paramInt3, arrayOfInt[paramInt1 + 1])) {
/*  816 */         return this.e[paramInt1 >> 2];
/*      */       }
/*      */     } 
/*      */     
/*  820 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  825 */     int[] arrayOfInt = this.a;
/*      */     
/*  827 */     byte b = 0;
/*      */     
/*  829 */     switch (paramInt1)
/*      */     { default:
/*  831 */         return b(paramArrayOfint, paramInt1, paramInt2);
/*      */       case 8:
/*  833 */         b++; if (paramArrayOfint[0] != arrayOfInt[paramInt2++]) return false; 
/*      */       case 7:
/*  835 */         if (paramArrayOfint[b++] != arrayOfInt[paramInt2++]) return false; 
/*      */       case 6:
/*  837 */         if (paramArrayOfint[b++] != arrayOfInt[paramInt2++]) return false; 
/*      */       case 5:
/*  839 */         if (paramArrayOfint[b++] != arrayOfInt[paramInt2++]) return false;  break;
/*      */       case 4:
/*  841 */         break; }  if (paramArrayOfint[b++] != arrayOfInt[paramInt2++]) return false; 
/*  842 */     if (paramArrayOfint[b++] != arrayOfInt[paramInt2++]) return false; 
/*  843 */     if (paramArrayOfint[b++] != arrayOfInt[paramInt2++]) return false; 
/*  844 */     if (paramArrayOfint[b] != arrayOfInt[paramInt2]) return false;
/*      */     
/*  846 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean b(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  851 */     byte b = 0;
/*      */     while (true) {
/*  853 */       if (paramArrayOfint[b++] != this.a[paramInt2++]) {
/*  854 */         return false;
/*      */       }
/*  856 */       if (b >= paramInt1) {
/*  857 */         return true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String a(String paramString, int[] paramArrayOfint, int paramInt) {
/*  916 */     i();
/*  917 */     if (this.k) {
/*  918 */       paramString = g.a.a(paramString);
/*      */     }
/*      */ 
/*      */     
/*  922 */     switch (paramInt)
/*      */     
/*      */     { case 1:
/*  925 */         j = f(h(paramArrayOfint[0]));
/*  926 */         this.a[j] = paramArrayOfint[0];
/*  927 */         this.a[j + 3] = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  957 */         this.e[j >> 2] = paramString;
/*      */ 
/*      */         
/*  960 */         this.d++;
/*  961 */         return paramString;case 2: j = f(c(paramArrayOfint[0], paramArrayOfint[1])); this.a[j] = paramArrayOfint[0]; this.a[j + 1] = paramArrayOfint[1]; this.a[j + 3] = 2; this.e[j >> 2] = paramString; this.d++; return paramString;case 3: j = f(c(paramArrayOfint[0], paramArrayOfint[1], paramArrayOfint[2])); this.a[j] = paramArrayOfint[0]; this.a[j + 1] = paramArrayOfint[1]; this.a[j + 2] = paramArrayOfint[2]; this.a[j + 3] = 3; this.e[j >> 2] = paramString; this.d++; return paramString; }  int k = c(paramArrayOfint, paramInt); int j = f(k); this.a[j] = k; int i = b(paramArrayOfint, paramInt); this.a[j + 1] = i; this.a[j + 3] = paramInt; this.e[j >> 2] = paramString; this.d++; return paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   private void i() {
/*  966 */     if (this.o) {
/*      */ 
/*      */       
/*  969 */       if (this.h == null) {
/*  970 */         if (this.d == 0) {
/*  971 */           throw new IllegalStateException("Cannot add names to Root symbol table");
/*      */         }
/*  973 */         throw new IllegalStateException("Cannot add names to Placeholder symbol table");
/*      */       } 
/*      */       
/*  976 */       this.a = Arrays.copyOf(this.a, this.a.length);
/*  977 */       this.e = Arrays.<String>copyOf(this.e, this.e.length);
/*  978 */       this.o = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int f(int paramInt) {
/*  988 */     int i = e(paramInt);
/*      */     int[] arrayOfInt;
/*  990 */     if ((arrayOfInt = this.a)[i + 3] == 0)
/*      */     {
/*  992 */       return i;
/*      */     }
/*      */ 
/*      */     
/*  996 */     if (j()) {
/*  997 */       return g(paramInt);
/*      */     }
/*      */ 
/*      */     
/* 1001 */     int j = this.m + (i >> 3 << 2);
/* 1002 */     if (arrayOfInt[j + 3] == 0)
/*      */     {
/* 1004 */       return j;
/*      */     }
/*      */ 
/*      */     
/* 1008 */     j = this.n + (i >> this.c + 2 << this.c);
/* 1009 */     i = 1 << this.c; int k;
/* 1010 */     for (k = j + i; j < k; j += 4) {
/* 1011 */       if (arrayOfInt[j + 3] == 0)
/*      */       {
/* 1013 */         return j;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1018 */     i = this.f;
/* 1019 */     this.f += 4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1029 */     k = this.b << 3;
/* 1030 */     if (this.f >= k) {
/* 1031 */       if (this.l) {
/* 1032 */         m();
/*      */       }
/* 1034 */       return g(paramInt);
/*      */     } 
/* 1036 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int g(int paramInt) {
/* 1043 */     k();
/*      */ 
/*      */     
/* 1046 */     paramInt = e(paramInt);
/*      */     int[] arrayOfInt;
/* 1048 */     if ((arrayOfInt = this.a)[paramInt + 3] == 0) {
/* 1049 */       return paramInt;
/*      */     }
/* 1051 */     int i = this.m + (paramInt >> 3 << 2);
/* 1052 */     if (arrayOfInt[i + 3] == 0) {
/* 1053 */       return i;
/*      */     }
/* 1055 */     i = this.n + (paramInt >> this.c + 2 << this.c);
/* 1056 */     paramInt = 1 << this.c;
/* 1057 */     for (paramInt = i + paramInt; i < paramInt; i += 4) {
/* 1058 */       if (arrayOfInt[i + 3] == 0) {
/* 1059 */         return i;
/*      */       }
/*      */     } 
/* 1062 */     paramInt = this.f;
/* 1063 */     this.f += 4;
/* 1064 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean j() {
/*      */     int i;
/* 1070 */     if (this.d > this.b >> 1 && ((
/*      */       
/* 1072 */       i = this.f - l() >> 2) > 1 + this.d >> 7 || this.d > this.b * 0.8D))
/*      */     {
/* 1074 */       return true;
/*      */     }
/*      */     
/* 1077 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int b(int[] paramArrayOfint, int paramInt) {
/*      */     int i;
/* 1085 */     if ((i = this.g) + paramInt > this.a.length) {
/*      */       
/* 1087 */       int j = i + paramInt - this.a.length;
/*      */       
/* 1089 */       int k = Math.min(4096, this.b);
/*      */       
/* 1091 */       j = this.a.length + Math.max(j, k);
/* 1092 */       this.a = Arrays.copyOf(this.a, j);
/*      */     } 
/* 1094 */     System.arraycopy(paramArrayOfint, 0, this.a, i, paramInt);
/* 1095 */     this.g += paramInt;
/* 1096 */     return i;
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
/*      */   private int h(int paramInt) {
/* 1130 */     return paramInt = (paramInt = (paramInt = (paramInt = paramInt ^ this.j) + (paramInt >>> 16)) ^ paramInt << 3) + (paramInt >>> 12);
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
/*      */   private int c(int paramInt1, int paramInt2) {
/* 1147 */     return paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = paramInt1) + (paramInt1 >>> 15)) ^ paramInt1 >>> 9) + paramInt2 * 33) ^ this.j) + (paramInt1 >>> 16)) ^ paramInt1 >>> 4) + (paramInt1 << 3);
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
/*      */   private int c(int paramInt1, int paramInt2, int paramInt3) {
/* 1165 */     return paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = (paramInt1 = paramInt1 ^ this.j) + (paramInt1 >>> 9)) * 31) + paramInt2) * 33) + (paramInt1 >>> 15)) ^ paramInt3) + (paramInt1 >>> 4)) + (paramInt1 >>> 15)) ^ paramInt1 << 9;
/*      */   }
/*      */ 
/*      */   
/*      */   private int c(int[] paramArrayOfint, int paramInt) {
/* 1170 */     if (paramInt < 4) {
/* 1171 */       throw new IllegalArgumentException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1184 */     int i = (i = (i = (i = (i = (i = (i = paramArrayOfint[0] ^ this.j) + (i >>> 9)) + paramArrayOfint[1]) + (i >>> 15)) * 33) ^ paramArrayOfint[2]) + (i >>> 4);
/*      */     
/* 1186 */     for (byte b = 3; b < paramInt; b++) {
/*      */       
/* 1188 */       int j = (j = paramArrayOfint[b]) ^ j >> 21;
/* 1189 */       i += j;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1196 */     return i = (i = (i = i * 65599) + (i >>> 19)) ^ i << 5;
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
/*      */   private void k() {
/* 1208 */     this.o = false;
/*      */ 
/*      */ 
/*      */     
/* 1212 */     int[] arrayOfInt1 = this.a;
/* 1213 */     String[] arrayOfString = this.e;
/* 1214 */     int i = this.b;
/* 1215 */     int j = this.d;
/* 1216 */     int k = i + i;
/* 1217 */     int m = this.f;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1222 */     if (k > 65536) {
/* 1223 */       a(true);
/*      */       
/*      */       return;
/*      */     } 
/* 1227 */     this.a = new int[arrayOfInt1.length + (i << 3)];
/* 1228 */     this.b = k;
/* 1229 */     this.m = k << 2;
/* 1230 */     this.n = this.m + (this.m >> 1);
/* 1231 */     this.c = c(k);
/*      */ 
/*      */     
/* 1234 */     this.e = new String[arrayOfString.length << 1];
/* 1235 */     a(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1242 */     i = 0;
/* 1243 */     int[] arrayOfInt2 = new int[16];
/* 1244 */     for (byte b = 0; b < m; b += 4) {
/*      */       int n;
/* 1246 */       if ((n = arrayOfInt1[b + 3]) != 0) {
/*      */         int i1;
/*      */         
/* 1249 */         i++;
/* 1250 */         String str = arrayOfString[b >> 2];
/* 1251 */         switch (n) {
/*      */           case 1:
/* 1253 */             arrayOfInt2[0] = arrayOfInt1[b];
/* 1254 */             a(str, arrayOfInt2, 1);
/*      */             break;
/*      */           case 2:
/* 1257 */             arrayOfInt2[0] = arrayOfInt1[b];
/* 1258 */             arrayOfInt2[1] = arrayOfInt1[b + 1];
/* 1259 */             a(str, arrayOfInt2, 2);
/*      */             break;
/*      */           case 3:
/* 1262 */             arrayOfInt2[0] = arrayOfInt1[b];
/* 1263 */             arrayOfInt2[1] = arrayOfInt1[b + 1];
/* 1264 */             arrayOfInt2[2] = arrayOfInt1[b + 2];
/* 1265 */             a(str, arrayOfInt2, 3);
/*      */             break;
/*      */           default:
/* 1268 */             if (n > arrayOfInt2.length) {
/* 1269 */               arrayOfInt2 = new int[n];
/*      */             }
/*      */             
/* 1272 */             i1 = arrayOfInt1[b + 1];
/* 1273 */             System.arraycopy(arrayOfInt1, i1, arrayOfInt2, 0, n);
/* 1274 */             a(str, arrayOfInt2, n);
/*      */             break;
/*      */         } 
/*      */ 
/*      */       
/*      */       } 
/*      */     } 
/* 1281 */     if (i != j) {
/* 1282 */       throw new IllegalStateException("Failed rehash(): old count=" + j + ", copyCount=" + i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(boolean paramBoolean) {
/* 1291 */     this.d = 0;
/*      */     
/* 1293 */     this.f = l();
/*      */     
/* 1295 */     this.g = this.b << 3;
/* 1296 */     if (paramBoolean) {
/* 1297 */       Arrays.fill(this.a, 0);
/* 1298 */       Arrays.fill((Object[])this.e, (Object)null);
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
/*      */   private final int l() {
/*      */     int i;
/* 1315 */     return ((i = this.b) << 3) - i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void m() {
/* 1321 */     if (this.b <= 1024) {
/*      */       return;
/*      */     }
/* 1324 */     throw new IllegalStateException("Spill-over slots in symbol table with " + this.d + " entries, hash area of " + this.b + " slots is now full (all " + (this.b >> 3) + " slots -- suspect a DoS attack based on hash collisions. You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
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
/*      */   static int c(int paramInt) {
/* 1336 */     if ((paramInt = paramInt >> 2) < 64) {
/* 1337 */       return 4;
/*      */     }
/* 1339 */     if (paramInt <= 256) {
/* 1340 */       return 5;
/*      */     }
/* 1342 */     if (paramInt <= 1024) {
/* 1343 */       return 6;
/*      */     }
/*      */     
/* 1346 */     return 7;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static final class a
/*      */   {
/*      */     public final int a;
/*      */ 
/*      */     
/*      */     public final int b;
/*      */ 
/*      */     
/*      */     public final int c;
/*      */ 
/*      */     
/*      */     public final int[] d;
/*      */ 
/*      */     
/*      */     public final String[] e;
/*      */ 
/*      */     
/*      */     public final int f;
/*      */ 
/*      */     
/*      */     public final int g;
/*      */ 
/*      */     
/*      */     private a(int param1Int1, int param1Int2, int param1Int3, int[] param1ArrayOfint, String[] param1ArrayOfString, int param1Int4, int param1Int5) {
/* 1375 */       this.a = param1Int1;
/* 1376 */       this.b = 0;
/* 1377 */       this.c = param1Int3;
/* 1378 */       this.d = param1ArrayOfint;
/* 1379 */       this.e = param1ArrayOfString;
/* 1380 */       this.f = param1Int4;
/* 1381 */       this.g = param1Int5;
/*      */     }
/*      */ 
/*      */     
/*      */     public a(a param1a) {
/* 1386 */       this.a = param1a.b;
/* 1387 */       this.b = param1a.d;
/* 1388 */       this.c = param1a.c;
/* 1389 */       this.d = param1a.a;
/* 1390 */       this.e = param1a.e;
/* 1391 */       this.f = param1a.f;
/* 1392 */       this.g = param1a.g;
/*      */     }
/*      */     
/*      */     public static a a(int param1Int) {
/* 1396 */       int i = param1Int << 3;
/* 1397 */       int j = a.c(param1Int);
/*      */       
/* 1399 */       return new a(param1Int, 0, j, new int[i], new String[param1Int << 1], i - param1Int, i);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */