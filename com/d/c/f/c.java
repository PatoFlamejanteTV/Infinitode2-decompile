/*      */ package com.d.c.f;
/*      */ 
/*      */ import com.a.a.b.c.a;
/*      */ import com.d.c.a.a;
/*      */ import com.d.c.c.a;
/*      */ import com.d.c.d.a.l;
/*      */ import com.d.c.d.d;
/*      */ import com.d.c.d.g;
/*      */ import com.d.c.d.h;
/*      */ import com.d.c.d.j;
/*      */ import com.d.c.f.a.a;
/*      */ import com.d.c.f.a.c;
/*      */ import com.d.c.f.a.d;
/*      */ import com.d.c.f.a.e;
/*      */ import com.d.c.f.a.f;
/*      */ import com.d.c.f.a.h;
/*      */ import com.d.c.g.a;
/*      */ import com.d.e.ad;
/*      */ import com.d.f.d;
/*      */ import com.d.h.w;
/*      */ import com.d.i.ab;
/*      */ import com.d.i.e;
/*      */ import com.d.i.f;
/*      */ import com.d.i.k;
/*      */ import com.d.i.l;
/*      */ import com.d.i.v;
/*      */ import com.d.m.a;
/*      */ import com.d.m.l;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import java.util.stream.Collectors;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class c
/*      */ {
/*      */   private c a;
/*      */   private a b;
/*      */   private h c;
/*      */   private h d;
/*      */   private float e;
/*      */   private boolean f;
/*      */   private k g;
/*      */   private l h;
/*      */   private boolean i = true;
/*      */   private boolean j = true;
/*      */   private boolean k = true;
/*      */   private a l;
/*   99 */   private final Map<String, c> m = new HashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final g[] n;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private a o;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected c() {
/*  125 */     this.n = new g[a.a()];
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
/*      */   private c(c paramc, a parama) {
/*  137 */     this();
/*  138 */     this.a = paramc;
/*      */     
/*  140 */     b(parama);
/*      */     
/*  142 */     aD();
/*  143 */     aE();
/*  144 */     aF();
/*      */   }
/*      */   
/*      */   private void aD() {
/*      */     com.d.c.a.c c1;
/*  149 */     if ((c1 = e(a.G)) == com.d.c.a.c.bb || c1 == com.d.c.a.c.bd || c1 == com.d.c.a.c.ba || c1 == com.d.c.a.c.bc) {
/*      */       
/*  151 */       this.j = false; return;
/*  152 */     }  if ((c1 == com.d.c.a.c.aV || c1 == com.d.c.a.c.T) && am()) {
/*  153 */       this.j = false;
/*      */     }
/*      */   }
/*      */   
/*      */   private void aE() {
/*      */     com.d.c.a.c c1;
/*  159 */     if ((c1 = e(a.G)) == com.d.c.a.c.bb || c1 == com.d.c.a.c.bd || c1 == com.d.c.a.c.ba || c1 == com.d.c.a.c.bc || c1 == com.d.c.a.c.aX)
/*      */     {
/*      */       
/*  162 */       this.i = false;
/*      */     }
/*      */   }
/*      */   
/*      */   private void aF() {
/*      */     com.d.c.a.c c1;
/*  168 */     if ((c1 = e(a.G)) == com.d.c.a.c.bb || c1 == com.d.c.a.c.bd || c1 == com.d.c.a.c.ba || c1 == com.d.c.a.c.bc)
/*      */     {
/*  170 */       this.k = false;
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
/*      */   public final synchronized c a(a parama) {
/*  183 */     String str = parama.b();
/*      */     
/*      */     c c1;
/*  186 */     if ((c1 = this.m.get(str)) == null) {
/*  187 */       c1 = new c(this, parama);
/*  188 */       this.m.put(str, c1);
/*      */     } 
/*  190 */     return c1;
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
/*      */   public final c a() {
/*  207 */     return this.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  216 */     return aI();
/*      */   }
/*      */   
/*      */   public final g a(a parama) {
/*      */     g g1;
/*  221 */     if ((g1 = i(parama)) == com.d.c.a.c.bj) {
/*  222 */       return (g)h.a;
/*      */     }
/*  224 */     return g1.c();
/*      */   }
/*      */ 
/*      */   
/*      */   public final float b(a parama) {
/*  229 */     return i(parama).b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String[] c(a parama) {
/*  237 */     return i(parama).e();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean d(a parama) {
/*      */     boolean bool;
/*      */     try {
/*  250 */       bool = i(parama).g();
/*  251 */     } catch (Exception exception) {
/*  252 */       l.g(Level.WARNING, "Property " + parama + " has an assignment we don't understand, and can't tell if it's an absolute unit or not. Assuming it is not. Exception was: " + exception
/*      */           
/*  254 */           .getMessage());
/*  255 */       bool = false;
/*      */     } 
/*  257 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a(a parama, com.d.c.a.c paramc) {
/*  268 */     return (i(parama) == paramc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final com.d.c.a.c e(a parama) {
/*  278 */     return i(parama).f();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final g b() {
/*  289 */     return a(a.b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final g c() {
/*      */     g g1;
/*  301 */     if ((g1 = i(a.c)) == com.d.c.a.c.bj) {
/*  302 */       return null;
/*      */     }
/*  304 */     return a(a.c);
/*      */   }
/*      */ 
/*      */   
/*      */   public final a d() {
/*  309 */     if (this.l == null) {
/*  310 */       this.l = aG();
/*      */     }
/*      */     
/*  313 */     return this.l;
/*      */   }
/*      */   private a aG() {
/*      */     com.d.c.a.c c1;
/*      */     g g1;
/*  318 */     if (g1 = i(a.h) instanceof com.d.c.a.c) {
/*      */       
/*  320 */       if ((c1 = (com.d.c.a.c)g1) == com.d.c.a.c.s)
/*  321 */         return new a(false, true, false); 
/*  322 */       if (c1 == com.d.c.a.c.r) {
/*  323 */         return new a(true, false, false);
/*      */       }
/*      */     } else {
/*      */       List<j> list;
/*      */       f f;
/*  328 */       boolean bool1 = (((j)(list = (f = (f)c1).j()).get(0)).h() == com.d.c.a.c.e) ? true : false;
/*  329 */       boolean bool2 = (((j)list.get(1)).h() == com.d.c.a.c.e) ? true : false;
/*      */       
/*  331 */       if (bool1 && bool2) {
/*  332 */         return new a(false, false, true);
/*      */       }
/*  334 */       return new a(list.get(0), list.get(1));
/*      */     } 
/*      */ 
/*      */     
/*  338 */     throw new RuntimeException("internal error");
/*      */   }
/*      */   
/*      */   public final a e() {
/*      */     f f;
/*  343 */     List<j> list = (f = (f)i(a.g)).j();
/*      */     
/*  345 */     return new a(list
/*  346 */         .get(0), list.get(1));
/*      */   }
/*      */ 
/*      */   
/*      */   public final List<ad> f() {
/*      */     g g1;
/*  352 */     if ((g1 = i(a.E)) == com.d.c.a.c.ap) {
/*  353 */       return null;
/*      */     }
/*  355 */     return ((c)g1).j();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<ad> g() {
/*      */     g g1;
/*  362 */     if ((g1 = i(a.D)) == com.d.c.a.c.ap) {
/*  363 */       return null;
/*      */     }
/*  365 */     return ((c)g1).j();
/*      */   }
/*      */ 
/*      */   
/*      */   public final a a(d paramd) {
/*  370 */     if (!this.k) {
/*  371 */       return a.a;
/*      */     }
/*      */     a a1;
/*  374 */     return a1 = a(this, paramd);
/*      */   }
/*      */ 
/*      */   
/*      */   public final a b(d paramd) {
/*  379 */     if (this.o == null) {
/*  380 */       this.o = new a();
/*      */       
/*  382 */       this.o.c = i(a.O).e();
/*      */       
/*      */       g g1;
/*  385 */       if (g1 = i(a.M) instanceof com.d.c.a.c) {
/*      */         j j;
/*      */         com.d.c.a.c c1;
/*  388 */         if ((c1 = aH()) != null) {
/*  389 */           j = h.a(c1, this.o.c);
/*      */         } else {
/*  391 */           j = h.c((com.d.c.a.c)j);
/*      */         } 
/*  393 */         this.o.a = e.a(this, a.M, j
/*  394 */             .d(), j
/*  395 */             .f(), j.a(), 0.0F, paramd);
/*      */       } else {
/*  397 */         this.o.a = a(a.M, 0.0F, paramd);
/*      */       } 
/*      */       
/*  400 */       this.o.b = e(a.L);
/*      */       
/*  402 */       this.o.d = e(a.J);
/*  403 */       this.o.e = e(a.K);
/*      */     } 
/*  405 */     return this.o;
/*      */   }
/*      */   
/*      */   public final a h() {
/*  409 */     return this.o;
/*      */   }
/*      */   
/*      */   private com.d.c.a.c aH() {
/*      */     g g1;
/*  414 */     if (!(g1 = i(a.M) instanceof com.d.c.a.c)) {
/*  415 */       return null;
/*      */     }
/*  417 */     com.d.c.a.c c1 = (com.d.c.a.c)g1;
/*  418 */     if (l.o.get(c1.a)) {
/*  419 */       return c1;
/*      */     }
/*      */     
/*      */     com.d.c.a.c c2;
/*  423 */     if ((c2 = a().aH()) != null) {
/*  424 */       if (c1 == com.d.c.a.c.bG)
/*  425 */         return h.a(c2); 
/*  426 */       if (g1 == com.d.c.a.c.bw) {
/*  427 */         return h.b(c2);
/*      */       }
/*      */     } 
/*      */     
/*  431 */     return null;
/*      */   }
/*      */   
/*      */   public final float a(a parama, float paramFloat, d paramd) {
/*  435 */     return i(parama).a(parama, paramFloat, paramd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final float b(a parama, float paramFloat, d paramd) {
/*  445 */     return i(parama).a(parama, paramFloat, paramd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final float c(a parama, float paramFloat, d paramd) {
/*  455 */     return i(parama).a(parama, paramFloat, paramd);
/*      */   }
/*      */   
/*      */   public final float c(d paramd) {
/*  459 */     if (!this.f) {
/*  460 */       float f; if (a(a.N, com.d.c.a.c.aq)) {
/*  461 */         float f1 = (b(paramd)).a * 1.1F;
/*      */         
/*      */         l l1;
/*      */         
/*  465 */         f = (float)Math.ceil(((l1 = e(paramd)).b() + l1.a()));
/*  466 */         this.e = Math.max(f1, f);
/*  467 */       } else if (g(a.N)) {
/*      */         
/*  469 */         this.e = c(a.N, 0.0F, f);
/*      */       } else {
/*      */         
/*  472 */         this.e = (b(f)).a * i(a.N).b();
/*      */       } 
/*  474 */       this.f = true;
/*      */     } 
/*  476 */     return this.e;
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
/*      */   public final h a(float paramFloat, d paramd) {
/*  489 */     return a(paramFloat, paramd, true);
/*      */   }
/*      */   
/*      */   public final h a(float paramFloat, d paramd, boolean paramBoolean) {
/*  493 */     if (!this.i) {
/*  494 */       return h.b;
/*      */     }
/*  496 */     return b(this, a.bi, a.bk, paramFloat, paramd, paramBoolean);
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
/*      */   private h b(float paramFloat, d paramd, boolean paramBoolean) {
/*  511 */     if (!this.j) {
/*  512 */       return h.b;
/*      */     }
/*  514 */     return a(this, a.bj, a.bl, paramFloat, paramd, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public final h b(float paramFloat, d paramd) {
/*  519 */     return b(paramFloat, paramd, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String f(a parama) {
/*  527 */     return i(parama).d();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean g(a parama) {
/*      */     g g1;
/*  535 */     return g1 = i(parama) instanceof e;
/*      */   }
/*      */   
/*      */   public final boolean h(a parama) {
/*      */     g g1;
/*  540 */     if (g1 = i(parama) instanceof com.d.c.f.a.g || g1 instanceof e) return true;  return false;
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
/*      */   public final g i(a parama) {
/*      */     g g1;
/*  553 */     boolean bool = ((g1 = this.n[parama.a]) == com.d.c.a.c.L) ? true : false;
/*      */ 
/*      */     
/*  556 */     if (g1 == null || bool) {
/*      */ 
/*      */       
/*  559 */       if (bool || !a.a(parama) || this.a == null || (
/*      */ 
/*      */         
/*  562 */         g1 = this.a.i(parama)) == null) {
/*      */         String str;
/*      */ 
/*      */ 
/*      */         
/*  567 */         if ((str = a.b(parama)) == null) {
/*  568 */           throw new w.a("Property '" + parama + "' has no initial values assigned. Check CSSName declarations.");
/*      */         }
/*      */         
/*  571 */         if (str.charAt(0) == '=') {
/*  572 */           a a1 = a.a(str.substring(1));
/*  573 */           g1 = i(a1);
/*      */         } else {
/*  575 */           g1 = a.c(parama);
/*      */         } 
/*      */       } 
/*  578 */       this.n[parama.a] = g1;
/*      */     } 
/*  580 */     return g1;
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
/*      */   private void b(a parama) {
/*  604 */     if (parama == null) {
/*      */       return;
/*      */     }
/*      */     
/*  608 */     for (v v : parama.a()) {
/*  609 */       g g1 = a(v.d(), v.e());
/*  610 */       this.n[(v.d()).a] = g1;
/*      */     } 
/*      */   }
/*      */   
/*      */   private g a(a parama, d paramd) {
/*  615 */     return a.a(this, parama, (j)paramd);
/*      */   }
/*      */   
/*      */   private String aI() {
/*  619 */     StringBuilder stringBuilder = new StringBuilder();
/*  620 */     for (byte b = 0; b < this.n.length; b++) {
/*  621 */       a a1 = a.a(b);
/*      */       g g1;
/*  623 */       if ((g1 = this.n[b]) != null) {
/*  624 */         stringBuilder.append(a1.toString());
/*      */       } else {
/*  626 */         stringBuilder.append("(no prop assigned in this pos)");
/*      */       } 
/*  628 */       stringBuilder.append("|\n");
/*      */     } 
/*  630 */     return stringBuilder.toString();
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
/*      */   private static h a(c paramc, a parama, a.a parama1, float paramFloat, d paramd, boolean paramBoolean) {
/*  656 */     if (!paramBoolean) {
/*  657 */       return a(paramc, parama, parama1, paramFloat, paramd);
/*      */     }
/*  659 */     if (paramc.d == null) {
/*      */       h h1;
/*      */       
/*      */       boolean bool;
/*  663 */       if (bool = (h1 = a(paramc, parama, parama1, paramFloat, paramd)).A()) {
/*  664 */         h1 = h.b;
/*      */       }
/*      */       
/*  667 */       paramc.d = h1;
/*      */       
/*  669 */       if (!bool && paramc.d.B()) {
/*  670 */         paramc.d.C();
/*      */       }
/*      */     } 
/*      */     
/*  674 */     return paramc.d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static h b(c paramc, a parama, a.a parama1, float paramFloat, d paramd, boolean paramBoolean) {
/*  684 */     if (!paramBoolean) {
/*  685 */       return a(paramc, parama, parama1, paramFloat, paramd);
/*      */     }
/*  687 */     if (paramc.c == null) {
/*      */       h h1;
/*  689 */       if ((h1 = a(paramc, parama, parama1, paramFloat, paramd)).A()) {
/*  690 */         h1 = h.b;
/*      */       }
/*  692 */       paramc.c = h1;
/*      */     } 
/*      */     
/*  695 */     return paramc.c;
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
/*      */   private static h a(c paramc, a parama, a.a parama1, float paramFloat, d paramd) {
/*      */     h h1;
/*  710 */     return h1 = h.a(paramc, parama, parama1, paramFloat, paramd);
/*      */   }
/*      */ 
/*      */   
/*      */   private static a a(c paramc, d paramd) {
/*  715 */     if (paramc.b == null) {
/*      */       a a1;
/*      */       
/*      */       boolean bool;
/*  719 */       if ((bool = (a1 = a.a(paramc, paramd)).A()) && !a1.n() && !a1.o()) {
/*  720 */         a1 = a.a;
/*      */       }
/*      */       
/*  723 */       paramc.b = a1;
/*      */       
/*  725 */       if (!bool && paramc.b.B()) {
/*  726 */         paramc.b.C();
/*      */       }
/*      */     } 
/*  729 */     return paramc.b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a(d paramd, int paramInt1, int paramInt2) {
/*  740 */     a a1 = a(paramd);
/*  741 */     h h2 = a(paramInt1, paramd);
/*  742 */     h h1 = b(paramInt1, paramd);
/*      */     
/*  744 */     switch (paramInt2) {
/*      */       case 1:
/*  746 */         return (int)(h2.w() + a1.w() + h1.w());
/*      */       case 2:
/*  748 */         return (int)(h2.u() + a1.u() + h1.u());
/*      */       case 3:
/*  750 */         return (int)(h2.t() + a1.t() + h1.t());
/*      */       case 4:
/*  752 */         return (int)(h2.v() + a1.v() + h1.v());
/*      */     } 
/*  754 */     throw new IllegalArgumentException();
/*      */   }
/*      */ 
/*      */   
/*      */   public final com.d.c.a.c i() {
/*  759 */     return e(a.au);
/*      */   }
/*      */   
/*      */   public final k d(d paramd) {
/*  763 */     if (this.g == null) {
/*  764 */       this.g = paramd.c(b(paramd));
/*      */     }
/*  766 */     return this.g;
/*      */   }
/*      */   
/*      */   public final l e(d paramd) {
/*  770 */     if (this.h == null) {
/*  771 */       this.h = paramd.a(d(paramd));
/*      */     }
/*  773 */     return this.h;
/*      */   }
/*      */   
/*      */   public final com.d.c.a.c j() {
/*  777 */     return e(a.av);
/*      */   }
/*      */   
/*      */   public final boolean k() {
/*      */     com.d.c.a.c c1;
/*  782 */     if ((c1 = e(a.z)) == com.d.c.a.c.aa || c1 == com.d.c.a.c.k) return true;  return false;
/*      */   }
/*      */   
/*      */   public final boolean l() {
/*      */     com.d.c.a.c c1;
/*  787 */     if ((c1 = e(a.z)) == com.d.c.a.c.aJ || c1 == com.d.c.a.c.k) return true;  return false;
/*      */   }
/*      */   
/*      */   public final boolean m() {
/*  791 */     return !a(a.z, com.d.c.a.c.ap);
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
/*      */   public final boolean n() {
/*  803 */     return (e(a.f) == com.d.c.a.c.B);
/*      */   }
/*      */   
/*      */   public final boolean o() {
/*  807 */     if (a(a.G, com.d.c.a.c.R) && 
/*  808 */       !C() && !A() && !B() && !P()) return true; 
/*      */     return false;
/*      */   }
/*      */   public final boolean p() {
/*  812 */     return a(a.G, com.d.c.a.c.S);
/*      */   }
/*      */   
/*      */   public final boolean q() {
/*  816 */     return a(a.G, com.d.c.a.c.aV);
/*      */   }
/*      */   
/*      */   public final boolean r() {
/*  820 */     return a(a.G, com.d.c.a.c.T);
/*      */   }
/*      */   
/*      */   public final boolean s() {
/*  824 */     return a(a.G, com.d.c.a.c.aX);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean t() {
/*      */     com.d.c.a.c c1;
/*  830 */     if ((c1 = e(a.G)) == com.d.c.a.c.bd || c1 == com.d.c.a.c.bb || c1 == com.d.c.a.c.ba) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean u() {
/*  836 */     return a(a.G, com.d.c.a.c.aW);
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
/*      */   public final boolean v() {
/*  848 */     return a(a.G, com.d.c.a.c.bc);
/*      */   }
/*      */   
/*      */   public final boolean w() {
/*  852 */     return a(a.G, com.d.c.a.c.ap);
/*      */   }
/*      */   
/*      */   public final boolean x() {
/*  856 */     return a(a.G, com.d.c.a.c.h);
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
/*      */   public final boolean y() {
/*  875 */     if (C() || A() || B() || P()) {
/*  876 */       return true;
/*      */     }
/*      */     com.d.c.a.c c1;
/*  879 */     if ((c1 = e(a.G)) == com.d.c.a.c.R || c1 == com.d.c.a.c.S || c1 == com.d.c.a.c.T) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean z() {
/*  885 */     return (!A() && !B() && !C() && !p());
/*      */   }
/*      */   
/*      */   public final boolean A() {
/*  889 */     return a(a.ah, com.d.c.a.c.b);
/*      */   }
/*      */   
/*      */   public final boolean B() {
/*  893 */     return a(a.ah, com.d.c.a.c.B);
/*      */   }
/*      */   
/*      */   public final boolean C() {
/*      */     com.d.c.a.c c1;
/*  898 */     if ((c1 = e(a.I)) == com.d.c.a.c.aa || c1 == com.d.c.a.c.aJ) return true;  return false;
/*      */   }
/*      */   
/*      */   public final boolean D() {
/*  902 */     return a(a.I, com.d.c.a.c.aa);
/*      */   }
/*      */   
/*      */   public final boolean E() {
/*  906 */     return a(a.I, com.d.c.a.c.aJ);
/*      */   }
/*      */   
/*      */   public final boolean F() {
/*  910 */     return a(a.ah, com.d.c.a.c.aE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean G() {
/*  918 */     return (A() || B() || F());
/*      */   }
/*      */   
/*      */   public final boolean H() {
/*  922 */     return a(a.ax, com.d.c.a.c.e);
/*      */   }
/*      */   
/*      */   public final boolean I() {
/*  926 */     return i(a.ax).g();
/*      */   }
/*      */   
/*      */   public final boolean J() {
/*  930 */     return a(a.R, com.d.c.a.c.e);
/*      */   }
/*      */   
/*      */   public final boolean K() {
/*  934 */     return a(a.aV, com.d.c.a.c.e);
/*      */   }
/*      */   
/*      */   public final boolean L() {
/*  938 */     return a(a.aT, com.d.c.a.c.e);
/*      */   }
/*      */   
/*      */   public final boolean M() {
/*  942 */     return a(a.aB, com.d.c.a.c.e);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean N() {
/*      */     g g1;
/*  948 */     if (g1 = i(a.ah) instanceof d) {
/*  949 */       return false;
/*      */     }
/*  951 */     com.d.c.a.c c2 = e(a.G);
/*  952 */     com.d.c.a.c c1 = (com.d.c.a.c)g1;
/*      */     
/*  954 */     if (C() || c1 == com.d.c.a.c.b || c1 == com.d.c.a.c.B || c2 == com.d.c.a.c.S || c2 == com.d.c.a.c.aX || 
/*      */ 
/*      */       
/*  957 */       !a(a.ac, com.d.c.a.c.bp)) return true; 
/*      */     return false;
/*      */   }
/*      */   
/*      */   public final boolean O() {
/*  962 */     if (!a(a.ay, com.d.c.a.c.ap)) {
/*  963 */       return true;
/*      */     }
/*      */     
/*      */     g g1;
/*      */     
/*  968 */     if (g1 = i(a.ah) instanceof d) {
/*  969 */       return false;
/*      */     }
/*      */     
/*      */     com.d.c.a.c c1;
/*  973 */     if ((c1 = e(a.ah)) == com.d.c.a.c.b || c1 == com.d.c.a.c.aE || c1 == com.d.c.a.c.B)
/*      */     {
/*  975 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  979 */     if (((c1 = e(a.ac)) == com.d.c.a.c.aM || c1 == com.d.c.a.c.e) && 
/*  980 */       R()) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */   
/*      */   public final boolean P() {
/*      */     g g1;
/*  987 */     return g1 = i(a.ah) instanceof d;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final String Q() {
/*      */     d d;
/*      */     j j;
/*      */     e e;
/*  996 */     return (j = (e = (d = (d)i(a.ah)).j()).b().get(0)).c();
/*      */   }
/*      */   
/*      */   public final boolean R() {
/*      */     com.d.c.a.c c1;
/* 1001 */     if ((c1 = e(a.G)) == com.d.c.a.c.h || c1 == com.d.c.a.c.ae || c1 == com.d.c.a.c.aV || c1 == com.d.c.a.c.S || c1 == com.d.c.a.c.aX) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean S() {
/* 1007 */     return (i(a.ac) == com.d.c.a.c.bp);
/*      */   }
/*      */   
/*      */   public final boolean T() {
/*      */     com.d.c.a.c c1;
/* 1012 */     if ((c1 = e(a.e)) == com.d.c.a.c.aG || c1 == com.d.c.a.c.aF) return true;  return false;
/*      */   }
/*      */   
/*      */   public final boolean U() {
/*      */     com.d.c.a.c c1;
/* 1017 */     if ((c1 = e(a.e)) == com.d.c.a.c.aH || c1 == com.d.c.a.c.aF) return true;  return false;
/*      */   }
/*      */   
/*      */   public final boolean V() {
/* 1021 */     return a(a.ar, com.d.c.a.c.e);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean W() {
/* 1026 */     return a(a.x, com.d.c.a.c.e);
/*      */   }
/*      */   
/*      */   public final boolean X() {
/* 1030 */     return a(a.G, com.d.c.a.c.ae);
/*      */   }
/*      */   
/*      */   public final boolean Y() {
/* 1034 */     return (!a(a.A, com.d.c.a.c.e) && b(a.A) > 1.0F);
/*      */   }
/*      */   
/*      */   public final int Z() {
/* 1038 */     return (int)b(a.A);
/*      */   }
/*      */   
/*      */   public final int aa() {
/* 1042 */     return (int)b(a.bc);
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
/*      */   public final boolean a(ab paramab, f paramf) {
/*      */     com.d.c.a.c c1;
/* 1060 */     if ((c1 = e(a.at)) == com.d.c.a.c.bp)
/* 1061 */       return true; 
/* 1062 */     if (paramab != null && 
/* 1063 */       c1 == com.d.c.a.c.M) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1068 */       paramf = paramf.U();
/* 1069 */       while (paramf != null && (
/* 1070 */         !paramf.a().q() || 
/* 1071 */         !((d)paramf).m())) {
/* 1072 */         paramf = paramf.O();
/*      */       }
/* 1074 */       if (paramf != null) {
/*      */         d d;
/* 1076 */         return !(d = (d)paramf).e(paramab);
/*      */       } 
/*      */     } 
/*      */     
/* 1080 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean ab() {
/*      */     com.d.c.a.c c1;
/* 1085 */     if ((c1 = e(a.af)) == com.d.c.a.c.c || c1 == com.d.c.a.c.aa || c1 == com.d.c.a.c.aJ) return true;  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean ac() {
/*      */     com.d.c.a.c c1;
/* 1091 */     if ((c1 = e(a.ae)) == com.d.c.a.c.c || c1 == com.d.c.a.c.aa || c1 == com.d.c.a.c.aJ) return true;  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean ad() {
/* 1096 */     return a(a.ag, com.d.c.a.c.f);
/*      */   }
/*      */   
/*      */   public final c a(com.d.c.a.c paramc) {
/* 1100 */     return a(a.a(paramc));
/*      */   }
/*      */   
/*      */   public final boolean ae() {
/*      */     com.d.c.a.c c1;
/* 1105 */     if ((c1 = e(a.G)) == com.d.c.a.c.h || c1 == com.d.c.a.c.ae || c1 == com.d.c.a.c.aL || c1 == com.d.c.a.c.aV || c1 == com.d.c.a.c.aX || c1 == com.d.c.a.c.aW || c1 == com.d.c.a.c.S) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean af() {
/*      */     com.d.c.a.c c1;
/* 1116 */     if ((c1 = e(a.G)) == com.d.c.a.c.h || c1 == com.d.c.a.c.ae || c1 == com.d.c.a.c.aX || c1 == com.d.c.a.c.aW || c1 == com.d.c.a.c.S) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean ag() {
/* 1124 */     return (C() || A() || B() || P());
/*      */   }
/*      */   
/*      */   public final boolean ah() {
/* 1128 */     if (a(a.ac, com.d.c.a.c.bp) && 
/* 1129 */       !C() && !A() && !B() && !p()) return true; 
/*      */     return false;
/*      */   }
/*      */   public final boolean ai() {
/* 1133 */     return (A() || B() || p() || r());
/*      */   }
/*      */   
/*      */   public final boolean aj() {
/* 1137 */     return a(a.Y, com.d.c.a.c.ap);
/*      */   }
/*      */   
/*      */   public final boolean ak() {
/* 1141 */     return a(a.X, com.d.c.a.c.ap);
/*      */   }
/*      */   
/*      */   private boolean aJ() {
/* 1145 */     return (a(a.ba, com.d.c.a.c.bW) || a(a.ba, com.d.c.a.c.bX));
/*      */   }
/*      */   public final boolean al() {
/* 1148 */     return !aJ();
/*      */   }
/*      */   
/*      */   public final int a(d paramd, int paramInt) {
/* 1152 */     return (int)a(a.aa, paramInt, paramd);
/*      */   }
/*      */   
/*      */   public final int b(d paramd, int paramInt) {
/* 1156 */     return (int)a(a.Y, paramInt, paramd);
/*      */   }
/*      */   
/*      */   public final int c(d paramd, int paramInt) {
/* 1160 */     return (int)a(a.Z, paramInt, paramd);
/*      */   }
/*      */   
/*      */   public final int d(d paramd, int paramInt) {
/* 1164 */     return (int)a(a.X, paramInt, paramd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean am() {
/* 1171 */     return a(a.i, com.d.c.a.c.q);
/*      */   }
/*      */   
/*      */   public final int f(d paramd) {
/* 1175 */     return am() ? 0 : (int)a(a.j, 0.0F, paramd);
/*      */   }
/*      */   
/*      */   public final int g(d paramd) {
/* 1179 */     return am() ? 0 : (int)a(a.k, 0.0F, paramd);
/*      */   }
/*      */   
/*      */   public final int an() {
/*      */     int i;
/* 1184 */     return ((i = (int)b(a.Q)) > 0) ? i : 1;
/*      */   }
/*      */   
/*      */   public final int ao() {
/*      */     int i;
/* 1189 */     return ((i = (int)b(a.P)) > 0) ? i : 1;
/*      */   }
/*      */   
/*      */   public final float h(d paramd) {
/* 1193 */     return a(a.w, 0.0F, paramd);
/*      */   }
/*      */   
/*      */   public final i a(d paramd, a parama) {
/* 1197 */     i i = new i();
/*      */     
/*      */     g g1;
/* 1200 */     if (g1 = i(parama) instanceof e || g1 instanceof com.d.c.f.a.g) {
/* 1201 */       if (g1.g()) {
/* 1202 */         i.a((int)g1.a(parama, 0.0F, paramd));
/* 1203 */         i.a(2);
/*      */       } else {
/* 1205 */         i.a((int)g1.b());
/* 1206 */         i.a(3);
/*      */       } 
/*      */     }
/*      */     
/* 1210 */     return i;
/*      */   }
/*      */   
/*      */   public final boolean ap() {
/* 1214 */     return (am() || a(a.H, com.d.c.a.c.aO));
/*      */   }
/*      */   
/*      */   public final boolean aq() {
/* 1218 */     if (!a(a.c, com.d.c.a.c.bj) || 
/* 1219 */       !a(a.d, com.d.c.a.c.ap)) return true; 
/*      */     return false;
/*      */   }
/*      */   public final List<com.d.c.a.c> ar() {
/*      */     g g1;
/* 1224 */     if ((g1 = i(a.ao)) == com.d.c.a.c.ap) {
/* 1225 */       return null;
/*      */     }
/*      */     List<?> list;
/* 1228 */     return (List<com.d.c.a.c>)(list = ((f)g1).j()).stream()
/* 1229 */       .map(paramj -> (com.d.c.a.c)a.a(this, a.ao, paramj))
/* 1230 */       .collect(Collectors.toList());
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
/*      */   public final boolean as() {
/* 1279 */     return a(a.u, com.d.c.a.c.ay);
/*      */   }
/*      */   
/*      */   public final boolean at() {
/* 1283 */     if (a(a.an, com.d.c.a.c.X) && 
/* 1284 */       !a(a.au, com.d.c.a.c.aB) && 
/* 1285 */       !a(a.au, com.d.c.a.c.aC)) return true; 
/*      */     return false;
/*      */   }
/*      */   public final boolean au() {
/* 1289 */     return a(a.V, com.d.c.a.c.V);
/*      */   }
/*      */   
/*      */   public final boolean av() {
/* 1293 */     return a(a.o, com.d.c.a.c.Y);
/*      */   }
/*      */   
/*      */   public final boolean aw() {
/* 1297 */     return a(a.l, com.d.c.a.c.A);
/*      */   }
/*      */   
/*      */   public final boolean ax() {
/* 1301 */     return (aw() && H() && !ay());
/*      */   }
/*      */   
/*      */   public final boolean ay() {
/* 1305 */     return (p() || C() || A() || B());
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
/*      */   public final com.d.c.a.c az() {
/* 1321 */     return e(a.F);
/*      */   }
/*      */   
/*      */   public final boolean aA() {
/* 1325 */     return !a(a.T, com.d.c.a.c.aq);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean aB() {
/*      */     com.d.c.a.c c1;
/* 1331 */     if (((c1 = e(a.G)) != com.d.c.a.c.R && c1 != com.d.c.a.c.S && c1 != com.d.c.a.c.T) || 
/*      */ 
/*      */       
/* 1334 */       ag()) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean aC() {
/* 1341 */     return a(a.bb, com.d.c.a.c.bY);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */