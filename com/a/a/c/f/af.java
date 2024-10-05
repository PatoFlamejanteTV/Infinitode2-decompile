/*      */ package com.a.a.c.f;
/*      */ 
/*      */ import com.a.a.a.ac;
/*      */ import com.a.a.a.ak;
/*      */ import com.a.a.a.s;
/*      */ import com.a.a.a.x;
/*      */ import com.a.a.c.b.g;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.l.o;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.v;
/*      */ import com.a.a.c.w;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import java.util.stream.Collectors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class af
/*      */   extends s
/*      */   implements Comparable<af>
/*      */ {
/*   32 */   private static final com.a.a.c.a.a c = com.a.a.c.a.a.a("");
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean d;
/*      */ 
/*      */ 
/*      */   
/*      */   private q<?> e;
/*      */ 
/*      */ 
/*      */   
/*      */   protected final com.a.a.c.a b;
/*      */ 
/*      */ 
/*      */   
/*      */   private w f;
/*      */ 
/*      */ 
/*      */   
/*      */   private w g;
/*      */ 
/*      */ 
/*      */   
/*      */   private a<h> h;
/*      */ 
/*      */ 
/*      */   
/*      */   private a<n> i;
/*      */ 
/*      */   
/*      */   private a<k> j;
/*      */ 
/*      */   
/*      */   private a<k> k;
/*      */ 
/*      */   
/*      */   private transient v l;
/*      */ 
/*      */   
/*      */   private transient com.a.a.c.a.a m;
/*      */ 
/*      */ 
/*      */   
/*      */   public af(q<?> paramq, com.a.a.c.a parama, boolean paramBoolean, w paramw) {
/*   77 */     this(paramq, parama, paramBoolean, paramw, paramw);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private af(q<?> paramq, com.a.a.c.a parama, boolean paramBoolean, w paramw1, w paramw2) {
/*   83 */     this.e = paramq;
/*   84 */     this.b = parama;
/*   85 */     this.g = paramw1;
/*   86 */     this.f = paramw2;
/*   87 */     this.d = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private af(af paramaf, w paramw) {
/*   93 */     this.e = paramaf.e;
/*   94 */     this.b = paramaf.b;
/*   95 */     this.g = paramaf.g;
/*   96 */     this.f = paramw;
/*   97 */     this.h = paramaf.h;
/*   98 */     this.i = paramaf.i;
/*   99 */     this.j = paramaf.j;
/*  100 */     this.k = paramaf.k;
/*  101 */     this.d = paramaf.d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final af b(w paramw) {
/*  112 */     return new af(this, paramw);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final af a(String paramString) {
/*      */     w w1;
/*  119 */     return ((w1 = this.f.b(paramString)) == this.f) ? this : new af(this, w1);
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
/*      */   private int b(af paramaf) {
/*  134 */     if (this.i != null) {
/*  135 */       if (paramaf.i == null) {
/*  136 */         return -1;
/*      */       }
/*  138 */     } else if (paramaf.i != null) {
/*  139 */       return 1;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  144 */     return a().compareTo(paramaf.a());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String a() {
/*  155 */     return (this.f == null) ? null : this.f.b();
/*      */   }
/*      */ 
/*      */   
/*      */   public final w b() {
/*  160 */     return this.f;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean a(w paramw) {
/*  165 */     return this.f.equals(paramw);
/*      */   }
/*      */   
/*      */   public final String C() {
/*  169 */     return this.g.b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final w c() {
/*      */     j j;
/*  179 */     if ((j = v()) == null || this.b == null) return null;  return 
/*  180 */       com.a.a.c.a.b();
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
/*      */   public final boolean d() {
/*  193 */     if (e(this.h) || 
/*  194 */       e(this.j) || 
/*  195 */       e(this.k) || 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  200 */       f(this.i)) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */   
/*      */   public final boolean e() {
/*  206 */     if (f(this.h) || 
/*  207 */       f(this.j) || 
/*  208 */       f(this.k) || 
/*  209 */       f(this.i)) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final v h() {
/*  222 */     if (this.l == null) {
/*      */       j j;
/*      */ 
/*      */ 
/*      */       
/*  227 */       if ((j = O()) == null) {
/*  228 */         this.l = v.c;
/*      */       } else {
/*  230 */         Boolean bool = this.b.f(j);
/*  231 */         String str1 = this.b.j(j);
/*  232 */         Integer integer = this.b.k(j);
/*  233 */         String str2 = this.b.i(j);
/*      */         
/*  235 */         if (bool == null && integer == null && str2 == null) {
/*  236 */           this
/*  237 */             .l = (str1 == null) ? v.c : v.c.a(str1);
/*      */         } else {
/*  239 */           this.l = v.a(bool, str1, integer, str2);
/*      */         } 
/*  241 */         if (!this.d) {
/*  242 */           this.l = a(this.l, j);
/*      */         }
/*      */       } 
/*      */     } 
/*  246 */     return this.l;
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
/*      */   private v a(v paramv, j paramj) {
/*  258 */     boolean bool = true;
/*  259 */     ak ak1 = null;
/*  260 */     ak ak2 = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  265 */     j j1 = s();
/*      */     
/*  267 */     if (paramj != null) {
/*      */       
/*  269 */       if (this.b != null) {
/*  270 */         Boolean bool1; if (j1 != null && (
/*      */           
/*  272 */           bool1 = this.b.G(paramj)) != null) {
/*  273 */           bool = false;
/*  274 */           if (bool1.booleanValue()) {
/*  275 */             paramv = paramv.a(v.a.c(j1));
/*      */           }
/*      */         } 
/*      */         
/*      */         ac.a a1;
/*  280 */         if ((a1 = this.b.F(paramj)) != null) {
/*  281 */           ak1 = a1.c();
/*  282 */           ak2 = a1.d();
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  287 */       if (bool || ak1 == null || ak2 == null) {
/*      */ 
/*      */ 
/*      */         
/*  291 */         Class<?> clazz = a(paramj);
/*      */         g g;
/*      */         ac.a a1;
/*  294 */         if ((a1 = (g = this.e.d(clazz)).g()) != null) {
/*  295 */           if (ak1 == null) {
/*  296 */             ak1 = a1.c();
/*      */           }
/*  298 */           if (ak2 == null)
/*  299 */             ak2 = a1.d(); 
/*      */         } 
/*      */         Boolean bool1;
/*  302 */         if (bool && j1 != null && (
/*      */           
/*  304 */           bool1 = g.i()) != null) {
/*  305 */           bool = false;
/*  306 */           if (bool1.booleanValue()) {
/*  307 */             paramv = paramv.a(v.a.b(j1));
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  313 */     if (bool || ak1 == null || ak2 == null) {
/*  314 */       ac.a a1 = this.e.q();
/*  315 */       if (ak1 == null) {
/*  316 */         ak1 = a1.c();
/*      */       }
/*  318 */       if (ak2 == null) {
/*  319 */         ak2 = a1.d();
/*      */       }
/*  321 */       if (bool) {
/*  322 */         Boolean bool1 = this.e.r();
/*  323 */         if (Boolean.TRUE.equals(bool1) && j1 != null) {
/*  324 */           paramv = paramv.a(v.a.a(j1));
/*      */         }
/*      */       } 
/*      */     } 
/*  328 */     if (ak1 != null || ak2 != null) {
/*  329 */       paramv = paramv.a(ak1, ak2);
/*      */     }
/*  331 */     return paramv;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j f() {
/*      */     h h;
/*  341 */     if (this.d) {
/*      */       k k1;
/*  343 */       if ((k1 = n()) == null && (
/*      */         
/*  345 */         h = p()) == null)
/*      */       {
/*  347 */         return o.b();
/*      */       }
/*      */       
/*  350 */       return h.c();
/*      */     } 
/*      */     n n;
/*  353 */     if ((n = q()) == null) {
/*      */       k k1;
/*      */ 
/*      */       
/*  357 */       if ((k1 = o()) != null) {
/*  358 */         return k1.b(0);
/*      */       }
/*  360 */       h = p();
/*      */     } 
/*      */     k k;
/*  363 */     if (h == null && (
/*      */       
/*  365 */       k = n()) == null) {
/*  366 */       return o.b();
/*      */     }
/*      */     
/*  369 */     return k.c();
/*      */   }
/*      */ 
/*      */   
/*      */   public final Class<?> g() {
/*  374 */     return f().b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean D() {
/*  384 */     return (this.j != null);
/*      */   }
/*      */   public final boolean k() {
/*  387 */     return (this.k != null);
/*      */   }
/*      */   public final boolean l() {
/*  390 */     return (this.h != null);
/*      */   }
/*      */   public final boolean m() {
/*  393 */     return (this.i != null);
/*      */   }
/*      */   
/*      */   public final boolean i() {
/*  397 */     return (this.i != null || this.k != null || this.h != null);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean j() {
/*  402 */     return (this.j != null || this.h != null);
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
/*      */   public final k n() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield j : Lcom/a/a/c/f/af$a;
/*      */     //   4: dup
/*      */     //   5: astore_1
/*      */     //   6: ifnonnull -> 11
/*      */     //   9: aconst_null
/*      */     //   10: areturn
/*      */     //   11: aload_1
/*      */     //   12: getfield b : Lcom/a/a/c/f/af$a;
/*      */     //   15: dup
/*      */     //   16: astore_2
/*      */     //   17: ifnonnull -> 28
/*      */     //   20: aload_1
/*      */     //   21: getfield a : Ljava/lang/Object;
/*      */     //   24: checkcast com/a/a/c/f/k
/*      */     //   27: areturn
/*      */     //   28: aload_2
/*      */     //   29: ifnull -> 195
/*      */     //   32: aload_1
/*      */     //   33: getfield a : Ljava/lang/Object;
/*      */     //   36: checkcast com/a/a/c/f/k
/*      */     //   39: invokevirtual h : ()Ljava/lang/Class;
/*      */     //   42: astore_3
/*      */     //   43: aload_2
/*      */     //   44: getfield a : Ljava/lang/Object;
/*      */     //   47: checkcast com/a/a/c/f/k
/*      */     //   50: invokevirtual h : ()Ljava/lang/Class;
/*      */     //   53: astore #4
/*      */     //   55: aload_3
/*      */     //   56: aload #4
/*      */     //   58: if_acmpeq -> 84
/*      */     //   61: aload_3
/*      */     //   62: aload #4
/*      */     //   64: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
/*      */     //   67: ifeq -> 75
/*      */     //   70: aload_2
/*      */     //   71: astore_1
/*      */     //   72: goto -> 187
/*      */     //   75: aload #4
/*      */     //   77: aload_3
/*      */     //   78: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
/*      */     //   81: ifne -> 187
/*      */     //   84: aload_2
/*      */     //   85: getfield a : Ljava/lang/Object;
/*      */     //   88: checkcast com/a/a/c/f/k
/*      */     //   91: invokestatic a : (Lcom/a/a/c/f/k;)I
/*      */     //   94: istore_3
/*      */     //   95: aload_1
/*      */     //   96: getfield a : Ljava/lang/Object;
/*      */     //   99: checkcast com/a/a/c/f/k
/*      */     //   102: invokestatic a : (Lcom/a/a/c/f/k;)I
/*      */     //   105: istore #4
/*      */     //   107: iload_3
/*      */     //   108: iload #4
/*      */     //   110: if_icmpeq -> 124
/*      */     //   113: iload_3
/*      */     //   114: iload #4
/*      */     //   116: if_icmpge -> 187
/*      */     //   119: aload_2
/*      */     //   120: astore_1
/*      */     //   121: goto -> 187
/*      */     //   124: new java/lang/IllegalArgumentException
/*      */     //   127: dup
/*      */     //   128: new java/lang/StringBuilder
/*      */     //   131: dup
/*      */     //   132: ldc 'Conflicting getter definitions for property "'
/*      */     //   134: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   137: aload_0
/*      */     //   138: invokevirtual a : ()Ljava/lang/String;
/*      */     //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   144: ldc '": '
/*      */     //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   149: aload_1
/*      */     //   150: getfield a : Ljava/lang/Object;
/*      */     //   153: checkcast com/a/a/c/f/k
/*      */     //   156: invokevirtual j : ()Ljava/lang/String;
/*      */     //   159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   162: ldc ' vs '
/*      */     //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   167: aload_2
/*      */     //   168: getfield a : Ljava/lang/Object;
/*      */     //   171: checkcast com/a/a/c/f/k
/*      */     //   174: invokevirtual j : ()Ljava/lang/String;
/*      */     //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   180: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   183: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   186: athrow
/*      */     //   187: aload_2
/*      */     //   188: getfield b : Lcom/a/a/c/f/af$a;
/*      */     //   191: astore_2
/*      */     //   192: goto -> 28
/*      */     //   195: aload_0
/*      */     //   196: aload_1
/*      */     //   197: invokevirtual a : ()Lcom/a/a/c/f/af$a;
/*      */     //   200: putfield j : Lcom/a/a/c/f/af$a;
/*      */     //   203: aload_1
/*      */     //   204: getfield a : Ljava/lang/Object;
/*      */     //   207: checkcast com/a/a/c/f/k
/*      */     //   210: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #409	-> 0
/*      */     //   #410	-> 5
/*      */     //   #411	-> 9
/*      */     //   #413	-> 11
/*      */     //   #414	-> 16
/*      */     //   #415	-> 20
/*      */     //   #418	-> 28
/*      */     //   #422	-> 32
/*      */     //   #423	-> 43
/*      */     //   #424	-> 55
/*      */     //   #425	-> 61
/*      */     //   #426	-> 70
/*      */     //   #427	-> 72
/*      */     //   #429	-> 75
/*      */     //   #439	-> 84
/*      */     //   #440	-> 95
/*      */     //   #442	-> 107
/*      */     //   #443	-> 113
/*      */     //   #444	-> 119
/*      */     //   #448	-> 124
/*      */     //   #449	-> 156
/*      */     //   #418	-> 187
/*      */     //   #452	-> 195
/*      */     //   #453	-> 203
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
/*      */   protected final k E() {
/*      */     a<k> a1;
/*  463 */     if ((a1 = this.j) == null) {
/*  464 */       return null;
/*      */     }
/*  466 */     return (k)a1.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k o() {
/*      */     a<k> a1;
/*  474 */     if ((a1 = this.k) == null) {
/*  475 */       return null;
/*      */     }
/*      */     a<k> a2;
/*  478 */     if ((a2 = a1.b) == null) {
/*  479 */       return (k)a1.a;
/*      */     }
/*      */     
/*  482 */     for (; a2 != null; a2 = a2.b) {
/*      */       k k;
/*  484 */       if ((k = a((k)a1.a, (k)a2.a)) != a1.a)
/*      */       {
/*      */         
/*  487 */         if (k == a2.a) {
/*  488 */           a1 = a2;
/*      */         }
/*      */         else {
/*      */           
/*  492 */           return a(a1, a2);
/*      */         } 
/*      */       }
/*      */     } 
/*  496 */     this.k = a1.a();
/*  497 */     return (k)a1.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final k F() {
/*      */     a<k> a1;
/*  507 */     if ((a1 = this.k) == null) {
/*  508 */       return null;
/*      */     }
/*  510 */     return (k)a1.a;
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
/*      */   private k a(a<k> parama1, a<k> parama2) {
/*      */     ArrayList<T> arrayList;
/*  533 */     (arrayList = new ArrayList<>()).add(parama1.a);
/*  534 */     arrayList.add(parama2.a);
/*      */     
/*  536 */     parama2 = parama2.b;
/*  537 */     for (; parama2 != null; parama2 = parama2.b) {
/*      */       k k;
/*  539 */       if ((k = a((k)parama1.a, (k)parama2.a)) != parama1.a)
/*      */       {
/*      */ 
/*      */         
/*  543 */         if (k == parama2.a) {
/*      */           
/*  545 */           arrayList.clear();
/*  546 */           parama1 = parama2;
/*      */         }
/*      */         else {
/*      */           
/*  550 */           arrayList.add(parama2.a);
/*      */         } 
/*      */       }
/*      */     } 
/*  554 */     if (arrayList.isEmpty()) {
/*  555 */       this.k = parama1.a();
/*  556 */       return (k)parama1.a;
/*      */     } 
/*      */ 
/*      */     
/*  560 */     String str = arrayList.stream().map(k::j).collect(Collectors.joining(" vs "));
/*  561 */     throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s", new Object[] {
/*      */             
/*  563 */             a(), str
/*      */           }));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private k a(k paramk1, k paramk2) {
/*  570 */     Class<?> clazz1 = paramk1.h();
/*  571 */     Class<?> clazz2 = paramk2.h();
/*  572 */     if (clazz1 != clazz2) {
/*  573 */       if (clazz1.isAssignableFrom(clazz2)) {
/*  574 */         return paramk2;
/*      */       }
/*  576 */       if (clazz2.isAssignableFrom(clazz1)) {
/*  577 */         return paramk1;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  588 */     int i = b(paramk2);
/*  589 */     int j = b(paramk1);
/*      */     
/*  591 */     if (i != j) {
/*      */       
/*  593 */       if (i < j) {
/*  594 */         return paramk2;
/*      */       }
/*      */       
/*  597 */       return paramk1;
/*      */     } 
/*      */     
/*  600 */     return (this.b == null) ? null : this.b
/*  601 */       .a(paramk1, paramk2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final h p() {
/*  607 */     if (this.h == null) {
/*  608 */       return null;
/*      */     }
/*      */     
/*  611 */     h h = (h)this.h.a;
/*  612 */     a<h> a1 = this.h.b;
/*  613 */     for (; a1 != null; a1 = a1.b) {
/*  614 */       h h1 = (h)a1.a;
/*  615 */       Class<?> clazz1 = h.h();
/*  616 */       Class<?> clazz2 = h1.h();
/*  617 */       if (clazz1 != clazz2)
/*  618 */       { if (clazz1.isAssignableFrom(clazz2))
/*  619 */         { h = h1;
/*      */            }
/*      */         
/*  622 */         else if (!clazz2.isAssignableFrom(clazz1))
/*      */         
/*      */         { 
/*      */           
/*  626 */           throw new IllegalArgumentException("Multiple fields representing property \"" + a() + "\": " + h
/*  627 */               .j() + " vs " + h1.j()); }  } else { throw new IllegalArgumentException("Multiple fields representing property \"" + a() + "\": " + h.j() + " vs " + h1.j()); }
/*      */     
/*  629 */     }  return h;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final h G() {
/*      */     a<h> a1;
/*  639 */     if ((a1 = this.h) == null) {
/*  640 */       return null;
/*      */     }
/*  642 */     return (h)a1.a;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final n q() {
/*  648 */     if (this.i == null) {
/*  649 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  659 */     a<n> a1 = this.i;
/*      */     while (true) {
/*  661 */       if (((n)a1.a).e() instanceof f) {
/*  662 */         return (n)a1.a;
/*      */       }
/*      */       
/*  665 */       if ((a1 = a1.b) == null)
/*  666 */         return (n)this.i.a; 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final Iterator<n> r() {
/*  671 */     if (this.i == null) {
/*  672 */       return i.a();
/*      */     }
/*  674 */     return new b<>(this.i);
/*      */   }
/*      */ 
/*      */   
/*      */   public final j v() {
/*  679 */     if (this.d) {
/*  680 */       return s();
/*      */     }
/*      */     
/*      */     j j;
/*  684 */     if ((j = t()) == null) {
/*  685 */       j = s();
/*      */     }
/*  687 */     return j;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private j O() {
/*  695 */     if (this.d) {
/*      */       
/*  697 */       if (this.j != null) {
/*  698 */         return (j)this.j.a;
/*      */       }
/*      */       
/*  701 */       if (this.h != null) {
/*  702 */         return (j)this.h.a;
/*      */       }
/*  704 */       return null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  710 */     if (this.i != null) {
/*  711 */       return (j)this.i.a;
/*      */     }
/*      */     
/*  714 */     if (this.k != null) {
/*  715 */       return (j)this.k.a;
/*      */     }
/*      */     
/*  718 */     if (this.h != null) {
/*  719 */       return (j)this.h.a;
/*      */     }
/*      */ 
/*      */     
/*  723 */     if (this.j != null) {
/*  724 */       return (j)this.j.a;
/*      */     }
/*  726 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static int a(k paramk) {
/*      */     String str;
/*  733 */     if ((str = paramk.b()).startsWith("get") && str.length() > 3)
/*      */     {
/*  735 */       return 1;
/*      */     }
/*  737 */     if (str.startsWith("is") && str.length() > 2) {
/*  738 */       return 2;
/*      */     }
/*  740 */     return 3;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int b(k paramk) {
/*      */     String str;
/*  746 */     if ((str = paramk.b()).startsWith("set") && str.length() > 3)
/*      */     {
/*  748 */       return 1;
/*      */     }
/*  750 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Class<?>[] w() {
/*  761 */     return a(new ag(this));
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
/*      */   public final com.a.a.c.a.a x() {
/*      */     com.a.a.c.a.a a1;
/*  774 */     if ((a1 = this.m) != null) {
/*  775 */       if (a1 == c) {
/*  776 */         return null;
/*      */       }
/*  778 */       return a1;
/*      */     } 
/*  780 */     a1 = a(new ah(this));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  786 */     this.m = (a1 == null) ? c : a1;
/*  787 */     return a1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean z() {
/*      */     Boolean bool;
/*  798 */     if ((bool = a(new ai(this))) != null && bool.booleanValue()) return true;  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final ad A() {
/*  803 */     return a(new aj(this));
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
/*      */   public final s.b B() {
/*  817 */     j j = s();
/*      */ 
/*      */ 
/*      */     
/*      */     s.b b;
/*      */ 
/*      */     
/*  824 */     return ((b = (s.b)((this.b == null) ? null : this.b.t(j))) == null) ? s.b.a() : b;
/*      */   }
/*      */   
/*      */   private x.a P() {
/*  828 */     return a(new ak(this), x.a.a);
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
/*      */   public final void a(h paramh, w paramw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  843 */     this.h = new a<>(paramh, this.h, paramw, paramBoolean1, paramBoolean2, paramBoolean3);
/*      */   }
/*      */   
/*      */   public final void a(n paramn, w paramw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  847 */     this.i = new a<>(paramn, this.i, paramw, paramBoolean1, true, false);
/*      */   }
/*      */   
/*      */   public final void a(k paramk, w paramw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  851 */     this.j = new a<>(paramk, this.j, paramw, paramBoolean1, paramBoolean2, paramBoolean3);
/*      */   }
/*      */   
/*      */   public final void b(k paramk, w paramw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  855 */     this.k = new a<>(paramk, this.k, paramw, paramBoolean1, paramBoolean2, paramBoolean3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(af paramaf) {
/*  864 */     this.h = b(this.h, paramaf.h);
/*  865 */     this.i = b(this.i, paramaf.i);
/*  866 */     this.j = b(this.j, paramaf.j);
/*  867 */     this.k = b(this.k, paramaf.k);
/*      */   }
/*      */ 
/*      */   
/*      */   private static <T> a<T> b(a<T> parama1, a<T> parama2) {
/*  872 */     if (parama1 == null) {
/*  873 */       return parama2;
/*      */     }
/*  875 */     if (parama2 == null) {
/*  876 */       return parama1;
/*      */     }
/*  878 */     return parama1.b(parama2);
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
/*      */   public final void H() {
/*  893 */     this.h = b(this.h);
/*  894 */     this.j = b(this.j);
/*  895 */     this.k = b(this.k);
/*  896 */     this.i = b(this.i);
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
/*      */   public final x.a a(boolean paramBoolean, ae paramae) {
/*      */     x.a a1;
/*  918 */     if ((a1 = P()) == null) {
/*  919 */       a1 = x.a.a;
/*      */     }
/*  921 */     switch (al.a[a1.ordinal()]) {
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/*  926 */         if (paramae != null) {
/*  927 */           paramae.a(a());
/*  928 */           for (w w1 : N()) {
/*  929 */             paramae.a(w1.b());
/*      */           }
/*      */         } 
/*      */         
/*  933 */         this.k = null;
/*  934 */         this.i = null;
/*  935 */         if (!this.d) {
/*  936 */           this.h = null;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/*  959 */         return a1;
/*      */       case 3:
/*      */         this.j = null; if (this.d)
/*      */           this.h = null; 
/*      */     }  this.j = c(this.j);
/*      */     this.i = c(this.i);
/*      */     if (!paramBoolean || this.j == null) {
/*      */       this.h = c(this.h);
/*      */       this.k = c(this.k);
/*  968 */     }  } public final void I() { this.i = null; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void J() {
/*  978 */     this.h = d(this.h);
/*  979 */     this.j = d(this.j);
/*  980 */     this.k = d(this.k);
/*  981 */     this.i = d(this.i);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(boolean paramBoolean) {
/*  987 */     if (paramBoolean) {
/*  988 */       if (this.j != null) {
/*  989 */         aa aa = a(0, (a<? extends j>[])new a[] { this.j, this.h, this.i, this.k });
/*  990 */         this.j = a(this.j, aa); return;
/*  991 */       }  if (this.h != null) {
/*  992 */         aa aa = a(0, (a<? extends j>[])new a[] { this.h, this.i, this.k });
/*  993 */         this.h = a(this.h, aa); return;
/*      */       } 
/*      */     } else {
/*  996 */       if (this.i != null) {
/*  997 */         aa aa = a(0, (a<? extends j>[])new a[] { this.i, this.k, this.h, this.j });
/*  998 */         this.i = a(this.i, aa); return;
/*  999 */       }  if (this.k != null) {
/* 1000 */         aa aa = a(0, (a<? extends j>[])new a[] { this.k, this.h, this.j });
/* 1001 */         this.k = a(this.k, aa); return;
/* 1002 */       }  if (this.h != null) {
/* 1003 */         aa aa = a(0, (a<? extends j>[])new a[] { this.h, this.j });
/* 1004 */         this.h = a(this.h, aa);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private aa a(int paramInt, a<? extends j>... paramVarArgs) {
/* 1012 */     aa aa = a(paramVarArgs[paramInt]);
/* 1013 */     while (++paramInt < paramVarArgs.length) {
/* 1014 */       if (paramVarArgs[paramInt] != null) {
/* 1015 */         return aa.a(aa, a(paramInt, paramVarArgs));
/*      */       }
/*      */     } 
/* 1018 */     return aa;
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
/*      */   private <T extends j> aa a(a<T> parama) {
/* 1031 */     aa aa = ((j)parama.a).k();
/* 1032 */     if (parama.b != null) {
/* 1033 */       aa = aa.a(aa, a(parama.b));
/*      */     }
/* 1035 */     return aa;
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
/*      */   private <T extends j> a<T> a(a<T> parama, aa paramaa) {
/* 1049 */     j j = (j)((j)parama.a).a(paramaa);
/* 1050 */     if (parama.b != null) {
/* 1051 */       parama = parama.a(a(parama.b, paramaa));
/*      */     }
/* 1053 */     return parama.a((T)j);
/*      */   }
/*      */ 
/*      */   
/*      */   private static <T> a<T> b(a<T> parama) {
/* 1058 */     if (parama == null) {
/* 1059 */       return parama;
/*      */     }
/* 1061 */     return parama.b();
/*      */   }
/*      */ 
/*      */   
/*      */   private static <T> a<T> c(a<T> parama) {
/* 1066 */     if (parama == null) {
/* 1067 */       return parama;
/*      */     }
/* 1069 */     return parama.c();
/*      */   }
/*      */ 
/*      */   
/*      */   private static <T> a<T> d(a<T> parama) {
/* 1074 */     if (parama == null) {
/* 1075 */       return parama;
/*      */     }
/* 1077 */     return parama.d();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T> boolean e(a<T> parama) {
/* 1088 */     for (; parama != null; parama = parama.b) {
/* 1089 */       if (parama.c != null && parama.c.c()) {
/* 1090 */         return true;
/*      */       }
/*      */     } 
/* 1093 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static <T> boolean f(a<T> parama) {
/* 1098 */     for (; parama != null; parama = parama.b) {
/* 1099 */       if (parama.c != null && parama.d) {
/* 1100 */         return true;
/*      */       }
/*      */     } 
/* 1103 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean K() {
/* 1107 */     if (g(this.h) || 
/* 1108 */       g(this.j) || 
/* 1109 */       g(this.k) || 
/* 1110 */       g(this.i)) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */   
/*      */   private static <T> boolean g(a<T> parama) {
/* 1116 */     for (; parama != null; parama = parama.b) {
/* 1117 */       if (parama.e) {
/* 1118 */         return true;
/*      */       }
/*      */     } 
/* 1121 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean L() {
/* 1125 */     if (h(this.h) || 
/* 1126 */       h(this.j) || 
/* 1127 */       h(this.k) || 
/* 1128 */       h(this.i)) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */   
/*      */   private static <T> boolean h(a<T> parama) {
/* 1134 */     for (; parama != null; parama = parama.b) {
/* 1135 */       if (parama.f) {
/* 1136 */         return true;
/*      */       }
/*      */     } 
/* 1139 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean M() {
/* 1144 */     if (i(this.h) || 
/* 1145 */       i(this.j) || 
/* 1146 */       i(this.k) || 
/*      */       
/* 1148 */       j(this.i)) return true; 
/*      */     return false;
/*      */   }
/*      */   
/*      */   private static <T> boolean i(a<T> parama) {
/* 1153 */     for (; parama != null; parama = parama.b) {
/* 1154 */       if (!parama.f && parama.c != null && parama.c
/* 1155 */         .c()) {
/* 1156 */         return true;
/*      */       }
/*      */     } 
/* 1159 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static <T> boolean j(a<T> parama) {
/* 1164 */     for (; parama != null; parama = parama.b) {
/* 1165 */       if (!parama.f && parama.c != null && parama.d)
/*      */       {
/* 1167 */         return true;
/*      */       }
/*      */     } 
/* 1170 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Set<w> N() {
/* 1181 */     Set<w> set = null;
/* 1182 */     set = a((a)this.h, set);
/* 1183 */     set = a((a)this.j, set);
/* 1184 */     set = a((a)this.k, set);
/*      */     
/* 1186 */     if ((set = a((a)this.i, set)) == null) {
/* 1187 */       return Collections.emptySet();
/*      */     }
/* 1189 */     return set;
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
/*      */   public final Collection<af> a(Collection<w> paramCollection) {
/* 1202 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 1203 */     a(paramCollection, (Map)hashMap, this.h);
/* 1204 */     a(paramCollection, (Map)hashMap, this.j);
/* 1205 */     a(paramCollection, (Map)hashMap, this.k);
/* 1206 */     a(paramCollection, (Map)hashMap, this.i);
/* 1207 */     return hashMap.values();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Collection<w> paramCollection, Map<w, af> paramMap, a<?> parama) {
/* 1215 */     a<?> a1 = parama;
/* 1216 */     for (parama = parama; parama != null; parama = parama.b) {
/* 1217 */       w w1 = parama.c;
/* 1218 */       if (!parama.d || w1 == null) {
/*      */         
/* 1220 */         if (parama.e)
/*      */         {
/*      */ 
/*      */           
/* 1224 */           throw new IllegalStateException("Conflicting/ambiguous property name definitions (implicit name " + 
/* 1225 */               i.a(this.f) + "): found multiple explicit names: " + paramCollection + ", but also implicit accessor: " + parama);
/*      */         }
/*      */       } else {
/*      */         af af1;
/* 1229 */         if ((af1 = paramMap.get(w1)) == null) {
/* 1230 */           af1 = new af(this.e, this.b, this.d, this.g, w1);
/*      */           
/* 1232 */           paramMap.put(w1, af1);
/*      */         } 
/*      */         
/* 1235 */         if (a1 == this.h) {
/* 1236 */           a<?> a2 = parama;
/* 1237 */           af1.h = (a)a2.a(af1.h);
/* 1238 */         } else if (a1 == this.j) {
/* 1239 */           a<?> a2 = parama;
/* 1240 */           af1.j = (a)a2.a(af1.j);
/* 1241 */         } else if (a1 == this.k) {
/* 1242 */           a<?> a2 = parama;
/* 1243 */           af1.k = (a)a2.a(af1.k);
/* 1244 */         } else if (a1 == this.i) {
/* 1245 */           a<?> a2 = parama;
/* 1246 */           af1.i = (a)a2.a(af1.i);
/*      */         } else {
/* 1248 */           throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static Set<w> a(a<? extends j> parama, Set<w> paramSet) {
/* 1256 */     for (; parama != null; parama = parama.b) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1263 */       if (parama.d && parama.c != null) {
/*      */ 
/*      */         
/* 1266 */         if (paramSet == null) {
/* 1267 */           paramSet = new HashSet<>();
/*      */         }
/* 1269 */         paramSet.add(parama.c);
/*      */       } 
/* 1271 */     }  return paramSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String toString() {
/*      */     StringBuilder stringBuilder;
/* 1279 */     (stringBuilder = new StringBuilder()).append("[Property '").append(this.f)
/* 1280 */       .append("'; ctors: ").append(this.i)
/* 1281 */       .append(", field(s): ").append(this.h)
/* 1282 */       .append(", getter(s): ").append(this.j)
/* 1283 */       .append(", setter(s): ").append(this.k);
/*      */     
/* 1285 */     stringBuilder.append("]");
/* 1286 */     return stringBuilder.toString();
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
/*      */   private <T> T a(c<T> paramc) {
/* 1301 */     T t = null;
/* 1302 */     if (this.b != null) {
/* 1303 */       if (this.d) {
/* 1304 */         if (this.j != null) {
/* 1305 */           t = paramc.a((j)this.j.a);
/*      */         }
/*      */       } else {
/* 1308 */         if (this.i != null) {
/* 1309 */           t = paramc.a((j)this.i.a);
/*      */         }
/* 1311 */         if (t == null && this.k != null) {
/* 1312 */           t = paramc.a((j)this.k.a);
/*      */         }
/*      */       } 
/* 1315 */       if (t == null && this.h != null) {
/* 1316 */         t = paramc.a((j)this.h.a);
/*      */       }
/*      */     } 
/* 1319 */     return t;
/*      */   }
/*      */ 
/*      */   
/*      */   private <T> T a(c<T> paramc, T paramT) {
/* 1324 */     if (this.b == null) {
/* 1325 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1330 */     if (this.d) {
/* 1331 */       T t1; if (this.j != null && (
/*      */         
/* 1333 */         t1 = paramc.a((j)this.j.a)) != null && t1 != paramT) {
/* 1334 */         return t1;
/*      */       }
/*      */       
/* 1337 */       if (this.h != null && (
/*      */         
/* 1339 */         t1 = paramc.a((j)this.h.a)) != null && t1 != paramT) {
/* 1340 */         return t1;
/*      */       }
/*      */       
/* 1343 */       if (this.i != null && (
/*      */         
/* 1345 */         t1 = paramc.a((j)this.i.a)) != null && t1 != paramT) {
/* 1346 */         return t1;
/*      */       }
/*      */       
/* 1349 */       if (this.k != null && (
/*      */         
/* 1351 */         t1 = paramc.a((j)this.k.a)) != null && t1 != paramT) {
/* 1352 */         return t1;
/*      */       }
/*      */       
/* 1355 */       return null;
/*      */     }  T t;
/* 1357 */     if (this.i != null && (
/*      */       
/* 1359 */       t = paramc.a((j)this.i.a)) != null && t != paramT) {
/* 1360 */       return t;
/*      */     }
/*      */     
/* 1363 */     if (this.k != null && (
/*      */       
/* 1365 */       t = paramc.a((j)this.k.a)) != null && t != paramT) {
/* 1366 */       return t;
/*      */     }
/*      */     
/* 1369 */     if (this.h != null && (
/*      */       
/* 1371 */       t = paramc.a((j)this.h.a)) != null && t != paramT) {
/* 1372 */       return t;
/*      */     }
/*      */     
/* 1375 */     if (this.j != null && (
/*      */       
/* 1377 */       t = paramc.a((j)this.j.a)) != null && t != paramT) {
/* 1378 */       return t;
/*      */     }
/*      */     
/* 1381 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Class<?> a(j paramj) {
/*      */     k k;
/* 1391 */     if (paramj instanceof k && (
/*      */       
/* 1393 */       k = (k)paramj).f() > 0)
/*      */     {
/*      */       
/* 1396 */       return k.b(0).b();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1401 */     return paramj.c().b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static interface c<T>
/*      */   {
/*      */     T a(j param1j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class b<T extends j>
/*      */     implements Iterator<T>
/*      */   {
/*      */     private af.a<T> a;
/*      */ 
/*      */ 
/*      */     
/*      */     public b(af.a<T> param1a) {
/* 1423 */       this.a = param1a;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean hasNext() {
/* 1428 */       return (this.a != null);
/*      */     }
/*      */ 
/*      */     
/*      */     private T a() {
/* 1433 */       if (this.a == null) throw new NoSuchElementException(); 
/* 1434 */       j j = (j)this.a.a;
/* 1435 */       this.a = this.a.b;
/* 1436 */       return (T)j;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void remove() {
/* 1441 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class a<T>
/*      */   {
/*      */     public final T a;
/*      */     
/*      */     public final a<T> b;
/*      */     
/*      */     public final w c;
/*      */     
/*      */     public final boolean d;
/*      */     
/*      */     public final boolean e;
/*      */     
/*      */     public final boolean f;
/*      */ 
/*      */     
/*      */     public a(T param1T, a<T> param1a, w param1w, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3) {
/* 1463 */       this.a = param1T;
/* 1464 */       this.b = param1a;
/*      */       
/* 1466 */       this.c = (param1w == null || param1w.e()) ? null : param1w;
/*      */       
/* 1468 */       if (param1Boolean1) {
/* 1469 */         if (this.c == null) {
/* 1470 */           throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
/*      */         }
/*      */ 
/*      */         
/* 1474 */         if (!param1w.c()) {
/* 1475 */           param1Boolean1 = false;
/*      */         }
/*      */       } 
/*      */       
/* 1479 */       this.d = param1Boolean1;
/* 1480 */       this.e = param1Boolean2;
/* 1481 */       this.f = param1Boolean3;
/*      */     }
/*      */     
/*      */     public final a<T> a() {
/* 1485 */       if (this.b == null) {
/* 1486 */         return this;
/*      */       }
/* 1488 */       return new a(this.a, null, this.c, this.d, this.e, this.f);
/*      */     }
/*      */     
/*      */     public final a<T> a(T param1T) {
/* 1492 */       if (param1T == this.a) {
/* 1493 */         return this;
/*      */       }
/* 1495 */       return new a(param1T, this.b, this.c, this.d, this.e, this.f);
/*      */     }
/*      */     
/*      */     public final a<T> a(a<T> param1a) {
/* 1499 */       if (param1a == this.b) {
/* 1500 */         return this;
/*      */       }
/* 1502 */       return new a(this.a, param1a, this.c, this.d, this.e, this.f);
/*      */     }
/*      */     
/*      */     public final a<T> b() {
/* 1506 */       if (this.f)
/* 1507 */         return (this.b == null) ? null : this.b.b(); 
/*      */       a<T> a1;
/* 1509 */       if (this.b != null && (
/*      */         
/* 1511 */         a1 = this.b.b()) != this.b) {
/* 1512 */         return a(a1);
/*      */       }
/*      */       
/* 1515 */       return this;
/*      */     }
/*      */     
/*      */     public final a<T> c() {
/* 1519 */       a<T> a1 = (this.b == null) ? null : this.b.c();
/* 1520 */       return this.e ? a(a1) : a1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected final a<T> b(a<T> param1a) {
/* 1528 */       if (this.b == null) {
/* 1529 */         return a(param1a);
/*      */       }
/* 1531 */       return a(this.b.b(param1a));
/*      */     }
/*      */     
/*      */     public final a<T> d() {
/* 1535 */       if (this.b == null) {
/* 1536 */         return this;
/*      */       }
/* 1538 */       a<T> a1 = this.b.d();
/* 1539 */       if (this.c != null) {
/* 1540 */         if (a1.c == null) {
/* 1541 */           return a((a<T>)null);
/*      */         }
/*      */         
/* 1544 */         return a(a1);
/*      */       } 
/* 1546 */       if (a1.c != null) {
/* 1547 */         return a1;
/*      */       }
/*      */       
/* 1550 */       if (this.e == a1.e) {
/* 1551 */         return a(a1);
/*      */       }
/* 1553 */       return this.e ? a((a<T>)null) : a1;
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1558 */       String str = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", new Object[] { this.a
/* 1559 */             .toString(), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.d) });
/* 1560 */       if (this.b != null) {
/* 1561 */         str = str + ", " + this.b.toString();
/*      */       }
/* 1563 */       return str;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\af.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */