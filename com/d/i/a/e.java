/*      */ package com.d.i.a;
/*      */ 
/*      */ import com.d.e.t;
/*      */ import com.d.e.y;
/*      */ import com.d.f.j;
/*      */ import com.d.i.aa;
/*      */ import com.d.i.ab;
/*      */ import com.d.i.r;
/*      */ import com.d.i.u;
/*      */ import com.d.i.y;
/*      */ import com.d.i.z;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Shape;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.awt.geom.Area;
/*      */ import java.awt.geom.Point2D;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ 
/*      */ public final class e
/*      */ {
/*      */   private final List<h> a;
/*      */   private final List<aa> b;
/*      */   private final f c;
/*      */   private final int d;
/*      */   
/*      */   public static class h
/*      */   {
/*   32 */     private List<com.d.d.b> a = null;
/*   33 */     private List<com.d.d.b> b = null;
/*   34 */     private List<com.d.f.f> c = null;
/*   35 */     private List<com.d.d.b> d = null;
/*   36 */     private List<com.d.d.b> e = null;
/*   37 */     private List<com.d.i.c> f = null;
/*   38 */     private List<h> g = null;
/*      */     private boolean h = false;
/*      */     private boolean i = false;
/*   41 */     private Rectangle j = null;
/*   42 */     private Rectangle k = null;
/*      */     
/*      */     private void b(h param1h) {
/*   45 */       if (this.g == null) {
/*   46 */         this.g = new ArrayList<>();
/*      */       }
/*   48 */       this.g.add(param1h);
/*      */     }
/*      */     
/*      */     private void a(com.d.i.c param1c) {
/*   52 */       if (this.f == null) {
/*   53 */         this.f = new ArrayList<>();
/*      */       }
/*   55 */       this.f.add(param1c);
/*      */     }
/*      */     
/*      */     private void a(com.d.d.b param1b) {
/*   59 */       if (this.a == null) {
/*   60 */         this.a = new ArrayList<>();
/*      */       }
/*   62 */       this.a.add(param1b);
/*      */     }
/*      */     
/*      */     private void b(com.d.d.b param1b) {
/*   66 */       if (this.b == null) {
/*   67 */         this.b = new ArrayList<>();
/*      */       }
/*   69 */       this.b.add(param1b);
/*      */     }
/*      */     
/*      */     private void a(com.d.f.f param1f) {
/*   73 */       if (this.c == null) {
/*   74 */         this.c = new ArrayList<>();
/*      */       }
/*   76 */       this.c.add(param1f);
/*      */     }
/*      */     
/*      */     private void c(com.d.d.b param1b) {
/*   80 */       if (this.d == null) {
/*   81 */         this.d = new ArrayList<>();
/*      */       }
/*   83 */       this.d.add(param1b);
/*      */       
/*   85 */       if (!(param1b instanceof y) && !(param1b instanceof z))
/*      */       {
/*   87 */         this.i = true;
/*      */       }
/*      */     }
/*      */     
/*      */     private void d(com.d.d.b param1b) {
/*   92 */       if (this.e == null) {
/*   93 */         this.e = new ArrayList<>();
/*      */       }
/*   95 */       this.e.add(param1b);
/*      */       
/*   97 */       if (!(param1b instanceof y) && !(param1b instanceof z))
/*      */       {
/*   99 */         this.h = true;
/*      */       }
/*      */     }
/*      */     
/*      */     private void a(y param1y) {
/*  104 */       a((com.d.d.b)param1y);
/*  105 */       b((com.d.d.b)param1y);
/*  106 */       c((com.d.d.b)param1y);
/*  107 */       d((com.d.d.b)param1y);
/*      */     }
/*      */     
/*      */     private void a(z param1z) {
/*  111 */       a((com.d.d.b)param1z);
/*  112 */       b((com.d.d.b)param1z);
/*  113 */       c((com.d.d.b)param1z);
/*  114 */       d((com.d.d.b)param1z);
/*      */     }
/*      */     
/*      */     public final List<com.d.i.c> a() {
/*  118 */       return (this.f == null) ? Collections.emptyList() : this.f;
/*      */     }
/*      */     
/*      */     public final List<com.d.d.b> b() {
/*  122 */       return (this.a == null) ? Collections.emptyList() : this.a;
/*      */     }
/*      */     
/*      */     public final List<com.d.d.b> c() {
/*  126 */       return (this.b == null) ? Collections.emptyList() : this.b;
/*      */     }
/*      */     
/*      */     public final List<com.d.f.f> d() {
/*  130 */       return (this.c == null) ? Collections.emptyList() : this.c;
/*      */     }
/*      */     
/*      */     public final List<com.d.d.b> e() {
/*  134 */       return this.i ? this.d : Collections.emptyList();
/*      */     }
/*      */     
/*      */     public final List<com.d.d.b> f() {
/*  138 */       return this.h ? this.e : Collections.emptyList();
/*      */     }
/*      */     
/*      */     public final List<h> g() {
/*  142 */       return (this.g == null) ? Collections.emptyList() : this.g;
/*      */     }
/*      */     
/*      */     public final boolean a(int param1Int) {
/*  146 */       return (this.g != null && param1Int < this.g.size());
/*      */     }
/*      */     
/*      */     private Rectangle a(aa param1aa, com.d.c.f.d param1d) {
/*  150 */       if (this.j == null) {
/*  151 */         this.j = param1aa.e(param1d);
/*      */       }
/*  153 */       return this.j;
/*      */     }
/*      */     
/*      */     public final Rectangle a(aa param1aa, com.d.c.f.d param1d, int param1Int) {
/*  157 */       if (param1Int == 0 && this.k == null) {
/*  158 */         this.k = param1aa.b(param1d, param1Int);
/*  159 */         return this.k;
/*  160 */       }  if (param1Int == 0) {
/*  161 */         return this.k;
/*      */       }
/*  163 */       return param1aa.b(param1d, param1Int);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class f
/*      */   {
/*  169 */     private int a = 0;
/*      */     
/*      */     private final List<aa> b;
/*      */ 
/*      */     
/*      */     public f(List<aa> param1List) {
/*  175 */       this.b = param1List;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int a(com.d.c.f.d param1d, int param1Int) {
/*      */       int i;
/*  181 */       if ((i = a(param1Int)) == -1)
/*  182 */         return 0; 
/*  183 */       if (i == -2) {
/*  184 */         return this.b.size() - 1;
/*      */       }
/*  186 */       return i;
/*      */     }
/*      */ 
/*      */     
/*      */     private int a(int param1Int) {
/*  191 */       if (param1Int < 0) {
/*  192 */         return -1;
/*      */       }
/*  194 */       aa aa = this.b.get(this.a);
/*  195 */       if (param1Int >= aa.b() && param1Int < aa.a()) {
/*  196 */         return this.a;
/*      */       }
/*      */       
/*  199 */       aa = this.b.get(this.b.size() - 1);
/*      */       
/*  201 */       if (param1Int >= aa.b() && param1Int < aa.a()) {
/*  202 */         this.a = this.b.size() - 1;
/*  203 */         return this.a;
/*      */       } 
/*      */       
/*  206 */       if (param1Int < aa.a()) {
/*      */         int i, j;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  212 */         for (j = (i = this.b.size()) - 1; j >= 0 && j >= i - 5; j--) {
/*  213 */           aa aa1 = this.b.get(j);
/*      */           
/*  215 */           if (param1Int >= aa1.b() && param1Int < aa1.a()) {
/*  216 */             this.a = j;
/*  217 */             return j;
/*      */           } 
/*      */         } 
/*      */         
/*  221 */         j = 0;
/*  222 */         int k = i - 6;
/*      */         
/*  224 */         while (j <= k) {
/*  225 */           i = j + k >> 1;
/*  226 */           aa aa1 = this.b.get(i);
/*      */           
/*  228 */           if (param1Int >= aa1.b() && param1Int < aa1.a()) {
/*  229 */             this.a = i;
/*  230 */             return i;
/*      */           } 
/*      */           
/*  233 */           if (aa1.b() < param1Int) {
/*  234 */             j = i + 1; continue;
/*      */           } 
/*  236 */           k = i - 1;
/*      */         } 
/*      */       } else {
/*      */         
/*  240 */         return -2;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  245 */       return -1;
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
/*      */   public e(List<aa> paramList, int paramInt1, int paramInt2) {
/*  259 */     this.b = paramList;
/*  260 */     this.a = new ArrayList<>(paramInt2 - paramInt1 + 1);
/*  261 */     this.c = new f(paramList);
/*  262 */     this.d = paramInt1;
/*      */     
/*  264 */     for (int i = paramInt1; i <= paramInt2; i++) {
/*  265 */       this.a.add(new h());
/*      */     }
/*      */   }
/*      */   
/*      */   public final void a(com.d.c.f.d paramd, t paramt) {
/*  270 */     if (paramt.j()) {
/*  271 */       c(paramd, paramt); return;
/*      */     } 
/*  273 */     a(paramd, paramt, paramt.f(), -2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(com.d.c.f.d paramd, t paramt) {
/*      */     r r;
/*      */     List<?> list;
/*  282 */     for (com.d.i.f f1 : list = (r = (r)paramt.f()).l()) {
/*      */       
/*  284 */       int i = a(paramd, f1, paramt.a());
/*  285 */       int j = b(paramd, f1, paramt.a());
/*      */       
/*  287 */       for (i = i; i <= j; i++) {
/*  288 */         Rectangle rectangle = h.a(a(i), d(i), paramd);
/*      */         
/*  290 */         if (f1.a(paramd, rectangle)) {
/*  291 */           if (f1 instanceof r) {
/*  292 */             h.a(a(i), (com.d.d.b)f1);
/*      */           } else {
/*      */             com.d.i.c c;
/*      */             
/*  296 */             if ((c = (com.d.i.c)f1).v()) {
/*  297 */               if (a(paramd, rectangle, f1, f1)) {
/*  298 */                 h.a(a(i), (com.d.d.b)f1);
/*      */               }
/*      */             } else {
/*  301 */               a(paramd, paramt, (com.d.i.f)c, -2);
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b(com.d.c.f.d paramd, t paramt) {
/*  310 */     for (int i = paramt.g().size() - 1; i >= 0; i--) {
/*  311 */       com.d.i.c c = paramt.g().get(i);
/*      */       
/*  313 */       int j = a(paramd, (com.d.i.f)c, paramt.a());
/*  314 */       int k = b(paramd, (com.d.i.f)c, paramt.a());
/*      */       
/*  316 */       for (j = b(j); j <= c(k); j++) {
/*  317 */         h h = a(j);
/*  318 */         aa aa = d(j);
/*      */         
/*  320 */         if (a(paramd, h.a(h, aa, paramd), (com.d.i.f)c)) {
/*  321 */           h.a(h, c);
/*      */         }
/*      */         
/*  324 */         if (aa.e()) {
/*  325 */           a(paramd, (com.d.i.f)c, j, h, (Shape)null, (List<h>)null, paramt, b.b());
/*      */         }
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
/*      */   private void a(com.d.c.f.d paramd, t paramt, com.d.i.f paramf, int paramInt) {
/*      */     int i, j;
/*  344 */     if (paramf instanceof com.d.i.c) {
/*  345 */       Rectangle rectangle = paramf.r(paramd);
/*  346 */       i = a(paramd, rectangle, paramt.a());
/*  347 */       j = b(paramd, rectangle, paramt.a());
/*      */     } else {
/*  349 */       i = a(paramd, paramf, paramt.a());
/*  350 */       j = b(paramd, paramf, paramt.a());
/*      */     } 
/*      */     
/*  353 */     a(paramd, paramt, paramf, i, j, paramInt);
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
/*      */   public final void a(com.d.c.f.d paramd, t paramt, com.d.i.f paramf, int paramInt1, int paramInt2, int paramInt3) {
/*  367 */     if (paramt != paramf.af()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  372 */     if (paramf instanceof u) {
/*      */       
/*  374 */       for (int i = b(paramInt1); i <= c(paramInt2); i++) {
/*  375 */         if (paramInt3 == -2) {
/*  376 */           a(paramd, paramt, (u)paramf, i, true);
/*  377 */         } else if (paramInt3 == -1) {
/*  378 */           a(paramd, paramt, (u)paramf, i, false);
/*      */         } else {
/*  380 */           a(paramd, paramt, (u)paramf, i, paramInt3);
/*      */         } 
/*      */       } 
/*      */       
/*      */       return;
/*      */     } 
/*  386 */     Rectangle rectangle = null;
/*  387 */     ArrayList<h> arrayList = null;
/*      */     
/*  389 */     if (paramf.Z() == null || paramt
/*  390 */       .f() == paramf || !(paramf instanceof com.d.i.c)) {
/*      */ 
/*      */ 
/*      */       
/*  394 */       if (paramd instanceof ab && paramf instanceof com.d.i.c) {
/*      */         com.d.i.c c;
/*      */ 
/*      */ 
/*      */         
/*  399 */         if ((c = (com.d.i.c)paramf).P()) {
/*      */           
/*  401 */           rectangle = c.k(paramd);
/*  402 */           arrayList = new ArrayList();
/*      */         } 
/*      */       } 
/*      */       
/*  406 */       if (paramInt3 == -2) {
/*  407 */         a(paramd, paramt, paramf, paramInt1, paramInt2, rectangle, arrayList, true);
/*  408 */       } else if (paramInt3 == -1) {
/*  409 */         a(paramd, paramt, paramf, paramInt1, paramInt2, rectangle, arrayList, false);
/*      */       } else {
/*  411 */         a(paramd, paramf, paramInt1, paramInt2, rectangle, arrayList, paramInt3);
/*      */       } 
/*      */     } 
/*      */     
/*  415 */     if (paramf instanceof j && (((j)paramf)
/*  416 */       .q() || ((j)paramf).p()) && ((j)paramf)
/*  417 */       .f().m() && (paramf
/*  418 */       .Z() == null || paramf == paramt.f()) && paramd instanceof ab) {
/*      */ 
/*      */       
/*  421 */       b(paramd, paramt, paramf, paramInt3);
/*      */     
/*      */     }
/*  424 */     else if (paramf.Z() == null || paramf == paramt.f()) {
/*  425 */       for (byte b = 0; b < paramf.V(); b++) {
/*  426 */         com.d.i.f f1 = paramf.k(b);
/*  427 */         a(paramd, paramt, f1, paramInt3);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  432 */     if (arrayList != null)
/*      */     {
/*  434 */       for (Iterator<h> iterator = arrayList.iterator(); iterator.hasNext();) {
/*  435 */         h.a(h = iterator.next(), new z(null));
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(com.d.c.f.d paramd, t paramt, com.d.i.f paramf, int paramInt1, int paramInt2, Shape paramShape, List<h> paramList, boolean paramBoolean) {
/*  443 */     for (paramInt1 = b(paramInt1); paramInt1 <= c(paramInt2); paramInt1++) {
/*  444 */       h h = a(paramInt1);
/*  445 */       aa aa = d(paramInt1);
/*  446 */       Rectangle rectangle = h.a(h, aa, paramd);
/*      */ 
/*      */       
/*  449 */       if (b(paramd, rectangle, paramf)) {
/*  450 */         a(paramf, h);
/*      */         
/*  452 */         if (paramShape != null) {
/*      */           
/*  454 */           h.a(h, new y(paramShape));
/*      */ 
/*      */           
/*  457 */           paramList.add(h);
/*      */         } 
/*      */       } 
/*      */       
/*  461 */       if (paramBoolean && aa.e()) {
/*  462 */         a(paramd, paramf, paramInt1, h, paramShape, paramList, paramt, a.b());
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(com.d.c.f.d paramd, com.d.i.f paramf, int paramInt1, int paramInt2, Shape paramShape, List<h> paramList, int paramInt3) {
/*  468 */     for (paramInt1 = b(paramInt1); paramInt1 <= c(paramInt2); paramInt1++) {
/*  469 */       h h = a(paramInt1);
/*  470 */       aa aa = d(paramInt1);
/*  471 */       Rectangle rectangle = h.a(aa, paramd, paramInt3);
/*      */ 
/*      */       
/*  474 */       if (b(paramd, rectangle, paramf)) {
/*  475 */         h = a(h, paramInt3);
/*  476 */         a(paramf, h);
/*      */         
/*  478 */         if (paramShape != null) {
/*      */           
/*  480 */           h.a(h, new y(paramShape));
/*      */ 
/*      */           
/*  483 */           paramList.add(h);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(com.d.c.f.d paramd, t paramt, u paramu, int paramInt1, int paramInt2) {
/*  490 */     h h = a(paramInt1);
/*  491 */     aa aa = d(paramInt1);
/*  492 */     Rectangle rectangle = h.a(aa, paramd, paramInt2);
/*      */     
/*  494 */     if (a(paramd, rectangle, (com.d.i.f)paramu)) {
/*      */       h h1;
/*      */       
/*  497 */       h.a(h1 = a(h, paramInt2), (com.d.d.b)paramu);
/*      */ 
/*      */       
/*  500 */       paramu.a(h.a(h1), paramt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(com.d.c.f.d paramd, t paramt, u paramu, int paramInt, boolean paramBoolean) {
/*  508 */     h h = a(paramInt);
/*  509 */     aa aa = d(paramInt);
/*  510 */     Rectangle rectangle = h.a(h, aa, paramd);
/*      */     
/*  512 */     if (a(paramd, rectangle, (com.d.i.f)paramu)) {
/*  513 */       h.a(h, (com.d.d.b)paramu);
/*      */ 
/*      */       
/*  516 */       paramu.a(h.a(h), paramt);
/*      */     } 
/*      */     
/*  519 */     if (paramBoolean && aa.e()) {
/*  520 */       a(paramd, (com.d.i.f)paramu, paramInt, h, (Shape)null, (List<h>)null, paramt, c.b());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static h a(h paramh, int paramInt) {
/*  528 */     while (paramInt >= paramh.g().size()) {
/*  529 */       h.a(paramh, new h());
/*      */     }
/*      */     
/*  532 */     return paramh.g().get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static interface d
/*      */   {
/*      */     int a();
/*      */ 
/*      */ 
/*      */     
/*      */     boolean a(e param1e, e.h param1h, com.d.i.f param1f, Shape param1Shape, t param1t);
/*      */   }
/*      */ 
/*      */   
/*      */   static class a
/*      */     implements d
/*      */   {
/*  550 */     private static final e.d a = new a();
/*      */ 
/*      */     
/*      */     public final int a() {
/*  554 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean a(e param1e, e.h param1h, com.d.i.f param1f, Shape param1Shape, t param1t) {
/*  559 */       e.a(param1e, param1f, param1h);
/*      */       
/*  561 */       if (param1Shape != null) {
/*  562 */         e.h.a(param1h, new y(param1Shape));
/*  563 */         return true;
/*      */       } 
/*      */       
/*  566 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   static class c implements d {
/*  571 */     private static final e.d a = new c();
/*      */ 
/*      */     
/*      */     public final int a() {
/*  575 */       return 2;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean a(e param1e, e.h param1h, com.d.i.f param1f, Shape param1Shape, t param1t) {
/*  580 */       e.h.a(param1h, (com.d.d.b)param1f);
/*      */ 
/*      */       
/*  583 */       ((u)param1f).a(e.h.a(param1h), param1t);
/*      */       
/*  585 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   static class b implements d {
/*  590 */     private static final e.d a = new b();
/*      */ 
/*      */     
/*      */     public final int a() {
/*  594 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean a(e param1e, e.h param1h, com.d.i.f param1f, Shape param1Shape, t param1t) {
/*  599 */       e.h.a(param1h, (com.d.i.c)param1f);
/*  600 */       return false;
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
/*      */   private void a(com.d.c.f.d paramd, com.d.i.f paramf, int paramInt, h paramh, Shape paramShape, List<h> paramList, t paramt, d paramd1) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: iload_3
/*      */     //   2: invokevirtual d : (I)Lcom/d/i/aa;
/*      */     //   5: astore_3
/*      */     //   6: aload_2
/*      */     //   7: invokevirtual af : ()Lcom/d/e/t;
/*      */     //   10: invokevirtual a : ()Ljava/awt/geom/AffineTransform;
/*      */     //   13: astore #9
/*      */     //   15: aload_2
/*      */     //   16: aload_1
/*      */     //   17: invokevirtual r : (Lcom/d/c/f/d;)Ljava/awt/Rectangle;
/*      */     //   20: astore #10
/*      */     //   22: aload #9
/*      */     //   24: ifnonnull -> 31
/*      */     //   27: aconst_null
/*      */     //   28: goto -> 38
/*      */     //   31: aload #10
/*      */     //   33: aload #9
/*      */     //   35: invokestatic a : (Ljava/awt/Rectangle;Ljava/awt/geom/AffineTransform;)Lcom/d/i/a/e$e;
/*      */     //   38: astore #11
/*      */     //   40: aload_3
/*      */     //   41: invokevirtual g : ()Lcom/d/c/a/c;
/*      */     //   44: getstatic com/d/c/a/c.ak : Lcom/d/c/a/c;
/*      */     //   47: if_acmpne -> 90
/*      */     //   50: aload #9
/*      */     //   52: ifnonnull -> 63
/*      */     //   55: aload #10
/*      */     //   57: invokevirtual getMaxX : ()D
/*      */     //   60: goto -> 68
/*      */     //   63: aload #11
/*      */     //   65: invokestatic d : (Lcom/d/i/a/e$e;)D
/*      */     //   68: d2i
/*      */     //   69: istore #10
/*      */     //   71: aload_3
/*      */     //   72: invokevirtual f : ()I
/*      */     //   75: aload_3
/*      */     //   76: aload_1
/*      */     //   77: iload #10
/*      */     //   79: invokevirtual c : (Lcom/d/c/f/d;I)I
/*      */     //   82: invokestatic min : (II)I
/*      */     //   85: istore #9
/*      */     //   87: goto -> 127
/*      */     //   90: aload #9
/*      */     //   92: ifnonnull -> 103
/*      */     //   95: aload #10
/*      */     //   97: invokevirtual getMinX : ()D
/*      */     //   100: goto -> 108
/*      */     //   103: aload #11
/*      */     //   105: invokestatic b : (Lcom/d/i/a/e$e;)D
/*      */     //   108: d2i
/*      */     //   109: istore #10
/*      */     //   111: aload_3
/*      */     //   112: invokevirtual f : ()I
/*      */     //   115: aload_3
/*      */     //   116: aload_1
/*      */     //   117: iload #10
/*      */     //   119: invokevirtual c : (Lcom/d/c/f/d;I)I
/*      */     //   122: invokestatic min : (II)I
/*      */     //   125: istore #9
/*      */     //   127: iconst_0
/*      */     //   128: istore #10
/*      */     //   130: iload #10
/*      */     //   132: iload #9
/*      */     //   134: if_icmpge -> 227
/*      */     //   137: aload #4
/*      */     //   139: aload_3
/*      */     //   140: aload_1
/*      */     //   141: iload #10
/*      */     //   143: invokevirtual a : (Lcom/d/i/aa;Lcom/d/c/f/d;I)Ljava/awt/Rectangle;
/*      */     //   146: astore #11
/*      */     //   148: aload #8
/*      */     //   150: invokeinterface a : ()I
/*      */     //   155: iconst_2
/*      */     //   156: if_icmpne -> 170
/*      */     //   159: aload_0
/*      */     //   160: aload_1
/*      */     //   161: aload #11
/*      */     //   163: aload_2
/*      */     //   164: invokespecial a : (Lcom/d/c/f/d;Ljava/awt/Shape;Lcom/d/i/f;)Z
/*      */     //   167: goto -> 178
/*      */     //   170: aload_0
/*      */     //   171: aload_1
/*      */     //   172: aload #11
/*      */     //   174: aload_2
/*      */     //   175: invokespecial b : (Lcom/d/c/f/d;Ljava/awt/Shape;Lcom/d/i/f;)Z
/*      */     //   178: dup
/*      */     //   179: istore #11
/*      */     //   181: ifeq -> 221
/*      */     //   184: aload #4
/*      */     //   186: iload #10
/*      */     //   188: invokestatic a : (Lcom/d/i/a/e$h;I)Lcom/d/i/a/e$h;
/*      */     //   191: astore #11
/*      */     //   193: aload #8
/*      */     //   195: aload_0
/*      */     //   196: aload #11
/*      */     //   198: aload_2
/*      */     //   199: aload #5
/*      */     //   201: aload #7
/*      */     //   203: invokeinterface a : (Lcom/d/i/a/e;Lcom/d/i/a/e$h;Lcom/d/i/f;Ljava/awt/Shape;Lcom/d/e/t;)Z
/*      */     //   208: ifeq -> 221
/*      */     //   211: aload #6
/*      */     //   213: aload #11
/*      */     //   215: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   220: pop
/*      */     //   221: iinc #10, 1
/*      */     //   224: goto -> 130
/*      */     //   227: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #613	-> 0
/*      */     //   #615	-> 6
/*      */     //   #616	-> 15
/*      */     //   #617	-> 22
/*      */     //   #620	-> 40
/*      */     //   #621	-> 50
/*      */     //   #622	-> 71
/*      */     //   #623	-> 87
/*      */     //   #624	-> 90
/*      */     //   #625	-> 111
/*      */     //   #628	-> 127
/*      */     //   #629	-> 137
/*      */     //   #631	-> 148
/*      */     //   #632	-> 159
/*      */     //   #633	-> 170
/*      */     //   #635	-> 179
/*      */     //   #636	-> 184
/*      */     //   #638	-> 193
/*      */     //   #639	-> 211
/*      */     //   #628	-> 221
/*      */     //   #643	-> 227
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
/*      */   private void b(com.d.c.f.d paramd, t paramt, com.d.i.f paramf, int paramInt) {
/*  651 */     com.d.f.d d1 = ((j)paramf).f();
/*  652 */     ab ab = (ab)paramd;
/*      */     
/*  654 */     int i = a(paramd, (com.d.i.f)d1, paramt.a());
/*  655 */     int j = b(paramd, (com.d.i.f)d1, paramt.a());
/*      */     
/*  657 */     for (i = b(i); i <= c(j); i++) {
/*  658 */       ab.a(i, d(i));
/*  659 */       d1.d(ab);
/*      */       
/*  661 */       for (byte b = 0; b < paramf.V(); b++) {
/*  662 */         com.d.i.f f1 = paramf.k(b);
/*  663 */         a(paramd, paramt, f1, paramInt);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(com.d.i.f paramf, h paramh) {
/*  672 */     h.b(paramh, (com.d.d.b)paramf);
/*      */     
/*  674 */     if (paramf instanceof com.d.i.c) {
/*      */       com.d.i.c c;
/*      */       
/*  677 */       if ((c = (com.d.i.c)paramf).E() != null) {
/*  678 */         h.c(paramh, (com.d.d.b)c);
/*      */       }
/*      */       
/*  681 */       if (c.u()) {
/*  682 */         h.d(paramh, (com.d.d.b)c);
/*      */       }
/*      */     } 
/*      */     
/*  686 */     if (paramf instanceof com.d.f.f && ((com.d.f.f)paramf)
/*  687 */       .o()) {
/*  688 */       h.a(paramh, (com.d.f.f)paramf);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean a(com.d.c.f.d paramd, Shape paramShape, com.d.i.f paramf) {
/*  693 */     if (paramShape == null) {
/*  694 */       return true;
/*      */     }
/*      */     
/*      */     y y;
/*      */     
/*  699 */     if ((y = paramf.at()) == null) {
/*  700 */       return false;
/*      */     }
/*      */     
/*  703 */     Rectangle rectangle = y.a();
/*      */     
/*  705 */     return a(paramd, paramShape, paramf, rectangle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean b(com.d.c.f.d paramd, Shape paramShape, com.d.i.f paramf) {
/*  713 */     Rectangle rectangle = paramf.r(paramd);
/*      */     
/*  715 */     return a(paramd, paramShape, paramf, rectangle);
/*      */   }
/*      */   
/*      */   private static boolean a(com.d.c.f.d paramd, Shape paramShape, com.d.i.f paramf, Rectangle paramRectangle) {
/*  719 */     AffineTransform affineTransform = paramf.af().a();
/*  720 */     Area area1 = paramf.i(paramd);
/*      */     
/*  722 */     if (affineTransform == null && area1 == null)
/*  723 */       return paramShape.intersects(paramRectangle); 
/*  724 */     if (affineTransform != null && area1 == null) {
/*  725 */       Shape shape = affineTransform.createTransformedShape(paramRectangle);
/*  726 */       area1 = new Area(shape);
/*  727 */       paramShape = new Area(paramShape);
/*  728 */       area1.intersect((Area)paramShape);
/*      */       
/*  730 */       return !area1.isEmpty();
/*      */     } 
/*      */     Area area2;
/*  733 */     (area2 = new Area((affineTransform == null) ? paramRectangle : affineTransform.createTransformedShape(paramRectangle))).intersect(area1);
/*  734 */     area2.intersect(new Area(paramShape));
/*      */     
/*  736 */     return !area2.isEmpty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(com.d.c.f.d paramd, Shape paramShape, com.d.i.f paramf1, com.d.i.f paramf2) {
/*  743 */     if (paramf2 instanceof u) {
/*  744 */       if (paramf2.a(paramd, paramShape)) {
/*  745 */         return true;
/*      */       }
/*      */     } else {
/*  748 */       if ((paramf2.Z() == null || !(paramf2 instanceof com.d.i.c)) && 
/*  749 */         paramf2.a(paramd, paramShape)) {
/*  750 */         return true;
/*      */       }
/*      */ 
/*      */       
/*  754 */       if (paramf2.Z() == null || paramf2 == paramf1) {
/*  755 */         for (byte b = 0; b < paramf2.V(); b++) {
/*  756 */           com.d.i.f f1 = paramf2.k(b);
/*      */           boolean bool;
/*  758 */           if (bool = a(paramd, paramShape, paramf1, f1)) {
/*  759 */             return true;
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  765 */     return false;
/*      */   }
/*      */   
/*      */   static class e {
/*      */     private final Point2D a;
/*      */     private final Point2D b;
/*      */     private final Point2D c;
/*      */     private final Point2D d;
/*      */     
/*      */     private e(Point2D param1Point2D1, Point2D param1Point2D2, Point2D param1Point2D3, Point2D param1Point2D4) {
/*  775 */       this.a = param1Point2D1;
/*  776 */       this.b = param1Point2D2;
/*  777 */       this.c = param1Point2D3;
/*  778 */       this.d = param1Point2D4;
/*      */     }
/*      */   }
/*      */   
/*      */   private static e a(Rectangle paramRectangle, AffineTransform paramAffineTransform) {
/*  783 */     Point2D.Double double_2 = new Point2D.Double(paramRectangle.getMinX(), paramRectangle.getMinY());
/*  784 */     Point2D.Double double_3 = new Point2D.Double(paramRectangle.getMaxX(), paramRectangle.getMinY());
/*  785 */     Point2D.Double double_4 = new Point2D.Double(paramRectangle.getMinX(), paramRectangle.getMaxY());
/*  786 */     Point2D.Double double_1 = new Point2D.Double(paramRectangle.getMaxX(), paramRectangle.getMaxY());
/*      */     
/*  788 */     Point2D point2D2 = paramAffineTransform.transform(double_2, null);
/*  789 */     Point2D point2D3 = paramAffineTransform.transform(double_3, null);
/*  790 */     Point2D point2D4 = paramAffineTransform.transform(double_4, null);
/*  791 */     Point2D point2D1 = paramAffineTransform.transform(double_1, null);
/*      */     
/*  793 */     return new e(point2D2, point2D3, point2D4, point2D1, (byte)0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static double b(Rectangle paramRectangle, AffineTransform paramAffineTransform) {
/*      */     e e1;
/*  804 */     double d = Math.min(e.a(e1 = a(paramRectangle, paramAffineTransform)).getY(), e.b(e1).getY());
/*  805 */     d = Math.min(e.c(e1).getY(), d);
/*      */ 
/*      */     
/*  808 */     return d = Math.min(e.d(e1).getY(), d);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static double c(Rectangle paramRectangle, AffineTransform paramAffineTransform) {
/*      */     e e1;
/*  819 */     double d = Math.max(e.a(e1 = a(paramRectangle, paramAffineTransform)).getY(), e.b(e1).getY());
/*  820 */     d = Math.max(e.c(e1).getY(), d);
/*      */ 
/*      */     
/*  823 */     return d = Math.max(e.d(e1).getY(), d);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(com.d.c.f.d paramd, Rectangle paramRectangle, AffineTransform paramAffineTransform) {
/*  888 */     double d1 = (paramAffineTransform == null) ? paramRectangle.getMinY() : b(paramRectangle, paramAffineTransform);
/*  889 */     return this.c.a(paramd, (int)d1);
/*      */   }
/*      */   
/*      */   private int b(com.d.c.f.d paramd, Rectangle paramRectangle, AffineTransform paramAffineTransform) {
/*  893 */     double d1 = (paramAffineTransform == null) ? paramRectangle.getMaxY() : c(paramRectangle, paramAffineTransform);
/*  894 */     return this.c.a(paramd, (int)d1);
/*      */   }
/*      */ 
/*      */   
/*      */   private int a(com.d.c.f.d paramd, com.d.i.f paramf, AffineTransform paramAffineTransform) {
/*      */     y y;
/*  900 */     if ((y = paramf.c(paramd, true)) == null) {
/*  901 */       return -1;
/*      */     }
/*      */     Rectangle rectangle;
/*  904 */     if ((rectangle = y.a()) == null) {
/*  905 */       return -1;
/*      */     }
/*      */     
/*  908 */     double d1 = (paramAffineTransform == null) ? rectangle.getMinY() : b(rectangle, paramAffineTransform);
/*  909 */     return this.c.a(paramd, (int)d1);
/*      */   }
/*      */   
/*      */   private int b(com.d.c.f.d paramd, com.d.i.f paramf, AffineTransform paramAffineTransform) {
/*      */     y y;
/*  914 */     if ((y = paramf.c(paramd, true)) == null) {
/*  915 */       return -1;
/*      */     }
/*      */     Rectangle rectangle;
/*  918 */     if ((rectangle = y.a()) == null) {
/*  919 */       return -1;
/*      */     }
/*      */     
/*  922 */     double d1 = (paramAffineTransform == null) ? rectangle.getMaxY() : c(rectangle, paramAffineTransform);
/*  923 */     return this.c.a(paramd, (int)d1);
/*      */   }
/*      */   
/*      */   protected final h a(int paramInt) {
/*  927 */     return this.a.get(paramInt - this.d);
/*      */   }
/*      */   
/*      */   private int a() {
/*  931 */     return this.d + this.a.size() - 1;
/*      */   }
/*      */   
/*      */   private int b() {
/*  935 */     return this.d;
/*      */   }
/*      */   
/*      */   private int b(int paramInt) {
/*  939 */     return Math.max(paramInt, b());
/*      */   }
/*      */   
/*      */   private int c(int paramInt) {
/*  943 */     return Math.min(paramInt, a());
/*      */   }
/*      */   
/*      */   private aa d(int paramInt) {
/*  947 */     return this.b.get(paramInt);
/*      */   }
/*      */   
/*      */   private static Rectangle a(com.d.c.f.d paramd, com.d.i.f paramf) {
/*      */     Rectangle rectangle;
/*      */     y y;
/*  953 */     return rectangle = (y = paramf.c(paramd, true)).a();
/*      */   }
/*      */   
/*      */   private static Rectangle d(com.d.c.f.d paramd, t paramt) {
/*  957 */     com.d.i.f f1 = paramt.f();
/*  958 */     Rectangle rectangle = a(paramd, f1);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  963 */     for (com.d.i.c c : paramt.g()) {
/*  964 */       Rectangle rectangle1 = a(paramd, (com.d.i.f)c);
/*  965 */       rectangle.add(rectangle1);
/*      */     } 
/*      */     
/*  968 */     return rectangle;
/*      */   }
/*      */   
/*      */   private static double a(e parame) {
/*  972 */     double d = Math.min(e.a(parame).getY(), e.b(parame).getY());
/*  973 */     d = Math.min(e.c(parame).getY(), d);
/*      */     
/*  975 */     return d = Math.min(e.d(parame).getY(), d);
/*      */   }
/*      */   
/*      */   private static double b(e parame) {
/*  979 */     double d = Math.min(e.a(parame).getX(), e.b(parame).getX());
/*  980 */     d = Math.min(e.c(parame).getX(), d);
/*      */     
/*  982 */     return d = Math.min(e.d(parame).getX(), d);
/*      */   }
/*      */   
/*      */   private static double c(e parame) {
/*  986 */     double d = Math.max(e.a(parame).getY(), e.b(parame).getY());
/*  987 */     d = Math.max(e.c(parame).getY(), d);
/*      */     
/*  989 */     return d = Math.max(e.d(parame).getY(), d);
/*      */   }
/*      */   
/*      */   private static double d(e parame) {
/*  993 */     double d = Math.max(e.a(parame).getX(), e.b(parame).getX());
/*  994 */     d = Math.max(e.c(parame).getX(), d);
/*      */     
/*  996 */     return d = Math.max(e.d(parame).getX(), d);
/*      */   }
/*      */   
/*      */   public static class g {
/*      */     private g(int param1Int1, int param1Int2) {
/* 1001 */       this.a = param1Int1;
/* 1002 */       this.b = param1Int2;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int a;
/*      */     public final int b;
/*      */   }
/*      */   
/*      */   private static void d(Rectangle paramRectangle, AffineTransform paramAffineTransform) {
/* 1011 */     if (paramAffineTransform != null) {
/*      */       e e1;
/*      */       
/* 1014 */       double d1 = b(e1 = a(paramRectangle, paramAffineTransform));
/* 1015 */       double d2 = a(e1);
/* 1016 */       double d3 = d(e1);
/* 1017 */       double d4 = c(e1);
/*      */       
/* 1019 */       paramRectangle.setBounds((int)d1, (int)d2, (int)(d3 - d1), (int)(d4 - d2));
/*      */     } 
/*      */   }
/*      */   private static Rectangle a(Rectangle paramRectangle, Area paramArea) {
/*      */     Area area;
/* 1024 */     if (paramArea != null) {
/*      */       
/* 1026 */       (area = new Area(paramRectangle)).intersect(paramArea);
/* 1027 */       return area.getBounds();
/*      */     } 
/* 1029 */     return (Rectangle)area;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<g> a(com.d.c.f.d paramd, t paramt, List<aa> paramList) {
/* 1038 */     f f2 = new f(paramList);
/* 1039 */     Rectangle rectangle = d(paramd, paramt);
/*      */     com.d.i.f f1;
/* 1041 */     AffineTransform affineTransform = (f1 = paramt.f()).af().a();
/* 1042 */     Area area = f1.i(paramd);
/*      */     
/* 1044 */     d(rectangle, affineTransform);
/* 1045 */     rectangle = a(rectangle, area);
/*      */     
/* 1047 */     int i = f2.a(paramd, (int)rectangle.getMinY());
/* 1048 */     int j = f2.a(paramd, (int)rectangle.getMaxY());
/*      */     
/* 1050 */     ArrayList<g> arrayList = new ArrayList();
/*      */     
/* 1052 */     for (i = i; i <= j; i++) {
/* 1053 */       arrayList.add(new g(i, -1, (byte)0));
/*      */       
/* 1055 */       if (((aa)paramList.get(i)).e()) {
/* 1056 */         int k = ((aa)paramList.get(i)).c(paramd, (int)rectangle.getMaxX());
/* 1057 */         int m = ((aa)paramList.get(i)).c(paramd, (int)rectangle.getMinX());
/*      */ 
/*      */         
/* 1060 */         k = Math.min(k = Math.max(k, m), ((aa)paramList.get(i)).f());
/*      */         
/* 1062 */         for (m = 0; m < k; m++) {
/* 1063 */           arrayList.add(new g(i, m, (byte)0));
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1068 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int a(com.d.c.f.d paramd, com.d.i.f paramf, List<aa> paramList) {
/* 1075 */     f f1 = new f(paramList);
/*      */     y y;
/* 1077 */     Rectangle rectangle = (y = paramf.c(paramd, true)).a();
/*      */     
/*      */     AffineTransform affineTransform;
/* 1080 */     double d1 = ((affineTransform = paramf.af().a()) == null) ? rectangle.getMinY() : b(rectangle, affineTransform);
/* 1081 */     return f1.a(paramd, (int)d1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int b(com.d.c.f.d paramd, com.d.i.f paramf, List<aa> paramList) {
/* 1088 */     f f1 = new f(paramList);
/*      */     y y;
/* 1090 */     Rectangle rectangle = (y = paramf.c(paramd, true)).a();
/*      */     
/*      */     AffineTransform affineTransform;
/* 1093 */     double d1 = ((affineTransform = paramf.af().a()) == null) ? rectangle.getMaxY() : c(rectangle, affineTransform);
/* 1094 */     return f1.a(paramd, (int)d1);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */