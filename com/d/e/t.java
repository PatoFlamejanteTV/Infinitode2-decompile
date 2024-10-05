/*      */ package com.d.e;
/*      */ 
/*      */ import com.d.c.a.a;
/*      */ import com.d.c.a.c;
/*      */ import com.d.c.a.d;
/*      */ import com.d.c.a.e;
/*      */ import com.d.c.c.e;
/*      */ import com.d.c.d.j;
/*      */ import com.d.c.f.a.f;
/*      */ import com.d.c.f.a.h;
/*      */ import com.d.c.f.c;
/*      */ import com.d.c.f.d;
/*      */ import com.d.c.f.f;
/*      */ import com.d.c.f.g;
/*      */ import com.d.f.f;
/*      */ import com.d.i.a.r;
/*      */ import com.d.i.aa;
/*      */ import com.d.i.ab;
/*      */ import com.d.i.ae;
/*      */ import com.d.i.c;
/*      */ import com.d.i.f;
/*      */ import com.d.i.g;
/*      */ import com.d.m.l;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Point;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.logging.Level;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class t
/*      */ {
/*      */   private t a;
/*      */   private boolean b;
/*      */   private List<t> c;
/*      */   private f d;
/*      */   private List<c> e;
/*      */   private boolean f;
/*      */   private boolean g;
/*      */   private List<aa> h;
/*   76 */   private aa i = null;
/*      */ 
/*      */ 
/*      */   
/*      */   private Set<c> j;
/*      */ 
/*      */ 
/*      */   
/*      */   private List<c> k;
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, List<c>> l;
/*      */ 
/*      */   
/*      */   private boolean m;
/*      */ 
/*      */   
/*      */   private boolean n;
/*      */ 
/*      */   
/*      */   private AffineTransform o;
/*      */ 
/*      */   
/*      */   private final boolean p;
/*      */ 
/*      */ 
/*      */   
/*      */   public t(f paramf, d paramd) {
/*  105 */     this((t)null, paramf);
/*  106 */     d(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public t(t paramt, f paramf) {
/*  113 */     this.a = paramt;
/*  114 */     this.d = paramf;
/*  115 */     d(((paramf
/*  116 */         .a().G() && !paramf.a().M()) || 
/*  117 */         !paramf.a().a(a.ay, c.ap)));
/*  118 */     paramf.a(this);
/*  119 */     paramf.b(this);
/*  120 */     this.p = !paramf.a().a(a.ay, c.ap);
/*  121 */     this.n = ((paramt != null && paramt.n) || paramf.a().B());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(d paramd) {
/*  130 */     AffineTransform affineTransform = (this.a == null) ? null : this.a.o;
/*  131 */     this
/*  132 */       .o = this.p ? r.a(f(), paramd, affineTransform) : affineTransform;
/*      */     
/*  134 */     for (Iterator<t> iterator = q().iterator(); iterator.hasNext();) {
/*  135 */       (t1 = iterator.next()).a(paramd);
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
/*      */   public final AffineTransform a() {
/*  149 */     return this.o;
/*      */   }
/*      */   
/*      */   public final boolean b() {
/*  153 */     return this.p;
/*      */   }
/*      */   
/*      */   public final void a(boolean paramBoolean) {
/*  157 */     this.m = true;
/*      */   }
/*      */   
/*      */   private boolean n() {
/*  161 */     return this.m;
/*      */   }
/*      */   
/*      */   public final boolean c() {
/*  165 */     return this.n;
/*      */   }
/*      */   
/*      */   public final t d() {
/*  169 */     return this.a;
/*      */   }
/*      */   
/*      */   public final boolean e() {
/*  173 */     return this.b;
/*      */   }
/*      */   
/*      */   private void d(boolean paramBoolean) {
/*  177 */     this.b = paramBoolean;
/*      */   }
/*      */   
/*      */   private int o() {
/*  181 */     if (this.d.a().a(a.aB, c.e)) {
/*  182 */       return 0;
/*      */     }
/*  184 */     return (int)this.d.a().b(a.aB);
/*      */   }
/*      */   
/*      */   private boolean p() {
/*  188 */     return this.d.a().a(a.aB, c.e);
/*      */   }
/*      */   
/*      */   public final f f() {
/*  192 */     return this.d;
/*      */   }
/*      */   
/*      */   public final void a(t paramt) {
/*  196 */     if (this.c == null) {
/*  197 */       this.c = new ArrayList<>();
/*      */     }
/*  199 */     this.c.add(paramt);
/*      */   }
/*      */   
/*      */   public static aa a(d paramd, String paramString) {
/*  203 */     aa aa1 = new aa();
/*      */     
/*  205 */     String str = null;
/*      */ 
/*      */ 
/*      */     
/*  209 */     if (paramd instanceof v) {
/*  210 */       str = ((v)paramd).B();
/*      */     }
/*      */     
/*  213 */     e e = paramd.c().a(str, paramString);
/*  214 */     aa1.a(e);
/*      */     
/*  216 */     c c = (new f()).a(e.a());
/*  217 */     aa1.a(c);
/*  218 */     aa1.e(aa1.a(paramd));
/*      */     
/*  220 */     return aa1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(c paramc) {
/*  227 */     if (this.e != null) {
/*  228 */       this.e.remove(paramc);
/*      */     }
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   private void e(ab paramab) {
/*  234 */     if (this.e != null) {
/*  235 */       for (int i = this.e.size() - 1; i >= 0; i--) {
/*  236 */         c c = this.e.get(i);
/*  237 */         a(paramab, c);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   private static void a(ab paramab, List<t> paramList) {
/*  244 */     for (Iterator<t> iterator = paramList.iterator(); iterator.hasNext();) {
/*  245 */       (t1 = iterator.next()).a(paramab);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(c paramc) {
/*  255 */     if (this.e == null) {
/*  256 */       this.e = new ArrayList<>();
/*      */     }
/*      */     
/*  259 */     this.e.add(paramc);
/*      */     
/*  261 */     paramc.L().a(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<t> a(int paramInt) {
/*  271 */     ArrayList<t> arrayList = new ArrayList();
/*  272 */     List<t> list = q();
/*      */     
/*  274 */     arrayList.addAll(e(paramInt));
/*      */     
/*  276 */     for (Iterator<t> iterator = list.iterator(); iterator.hasNext();) {
/*  277 */       if (!(t1 = iterator.next()).e()) {
/*  278 */         if (!t1.n())
/*      */         {
/*  280 */           if (paramInt == 4 && t1.p()) {
/*  281 */             arrayList.add(t1);
/*  282 */           } else if (paramInt == 3 && t1.o() < 0) {
/*  283 */             arrayList.add(t1);
/*  284 */           } else if (paramInt == 1 && t1.o() > 0) {
/*  285 */             arrayList.add(t1);
/*  286 */           } else if (paramInt == 2 && !t1.p() && t1.o() == 0) {
/*  287 */             arrayList.add(t1);
/*      */           }  } 
/*  289 */         arrayList.addAll(t1.a(paramInt));
/*      */       } 
/*      */     } 
/*      */     
/*  293 */     return arrayList;
/*      */   }
/*      */   
/*      */   private List<t> e(int paramInt) {
/*  297 */     ArrayList<t> arrayList = new ArrayList();
/*      */     
/*      */     List<t> list;
/*  300 */     for (Iterator<t> iterator = (list = q()).iterator(); iterator.hasNext();) {
/*  301 */       if (!(t1 = iterator.next()).n())
/*      */       {
/*  303 */         if (t1.e()) {
/*  304 */           if (!t1.p()) {
/*  305 */             int i = t1.o();
/*  306 */             if (paramInt == 3 && i < 0) {
/*  307 */               arrayList.add(t1); continue;
/*  308 */             }  if (paramInt == 1 && i > 0) {
/*  309 */               arrayList.add(t1); continue;
/*  310 */             }  if (paramInt == 2 && i == 0)
/*  311 */               arrayList.add(t1);  continue;
/*      */           } 
/*  313 */           if (paramInt == 4) {
/*  314 */             arrayList.add(t1);
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*  319 */     return arrayList;
/*      */   }
/*      */ 
/*      */   
/*      */   public final List<t> b(int paramInt) {
/*      */     List<t> list;
/*  325 */     Collections.sort(list = a(paramInt), (paramt1, paramt2) -> paramt1.o() - paramt2.o());
/*      */     
/*  327 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   private void a(ab paramab, List<f> paramList, Map paramMap, h paramh) {
/*  334 */     g g = new g(paramab.p(), paramh.a());
/*      */     
/*  336 */     for (byte b = 0; b < paramList.size(); b++) {
/*  337 */       g.a(b);
/*      */       
/*      */       c c;
/*      */       
/*  341 */       (c = (c)paramList.get(b)).b(paramab);
/*  342 */       c.c(paramab);
/*  343 */       if (paramab.j())
/*  344 */         c.g(paramab); 
/*      */       f f1;
/*      */       List list;
/*  347 */       if (paramMap != null && c instanceof f && (
/*      */         
/*  349 */         f1 = (f)c).o() && (
/*      */         
/*  351 */         list = (List)paramMap.get(f1)) != null) {
/*  352 */         c(paramab, list);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  357 */       g.a(paramab, b);
/*      */     } 
/*      */     
/*  360 */     g.a(paramList.size());
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   private static void b(ab paramab, List paramList) {
/*  365 */     paramab.p();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Dimension a(v paramv) {
/*  376 */     return e(paramv).b();
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   private static void a(ab paramab, List<s> paramList, h paramh) {
/*  382 */     g g = new g(paramab.p(), paramh.b());
/*      */     
/*  384 */     for (byte b = 0; b < paramList.size(); b++) {
/*  385 */       g.a(b);
/*  386 */       g.a(paramab, b);
/*      */       
/*      */       s s;
/*  389 */       (s = paramList.get(b)).a(paramab);
/*      */     } 
/*      */     
/*  392 */     g.a(paramList.size());
/*      */   }
/*      */   @Deprecated
/*      */   public final void a(ab paramab) {
/*      */     List<AffineTransform> list;
/*  397 */     if (f().a().B()) {
/*  398 */       b(paramab);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  403 */     if (h()) {
/*  404 */       f().h(paramab);
/*      */     }
/*      */     
/*  407 */     if (!j() && ((c)f()).A()) {
/*  408 */       list = a(paramab, f());
/*  409 */       f(paramab);
/*  410 */       b(paramab, (c)f());
/*      */     } else {
/*      */       
/*  413 */       h h = new h();
/*      */       
/*  415 */       ArrayList<f> arrayList1 = new ArrayList();
/*  416 */       ArrayList<f> arrayList2 = new ArrayList();
/*      */       
/*      */       d d;
/*  419 */       (d = new d()).a((d)paramab, paramab.p().c(), this, arrayList1, arrayList2, h);
/*      */       
/*  421 */       list = a(paramab, f());
/*      */       
/*  423 */       if (!j()) {
/*  424 */         f(paramab);
/*  425 */         if (paramab.j()) {
/*  426 */           ((c)f()).g(paramab);
/*      */         }
/*      */       } 
/*      */       
/*  430 */       if (h() || e()) {
/*  431 */         a(paramab, b(3));
/*      */       }
/*      */       
/*  434 */       Map map = a(arrayList1);
/*  435 */       a(paramab, arrayList1, map, h);
/*  436 */       e(paramab);
/*  437 */       b(paramab, arrayList1, h);
/*  438 */       a(paramab, arrayList2, h);
/*  439 */       c(paramab, arrayList1, h);
/*  440 */       b(paramab, arrayList2);
/*      */       
/*  442 */       if (h() || e()) {
/*  443 */         a(paramab, a(4));
/*      */         
/*  445 */         a(paramab, b(2));
/*  446 */         a(paramab, b(1));
/*      */       } 
/*      */     } 
/*  449 */     paramab.p().b(list);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   private static float a(j paramj) {
/*  456 */     if (paramj.a() == 11)
/*  457 */       return (float)Math.toRadians(paramj.f()); 
/*  458 */     if (paramj.a() == 12) {
/*  459 */       return paramj.f();
/*      */     }
/*  461 */     return (float)(paramj.f() * 0.015707963267948967D);
/*      */   }
/*      */ 
/*      */   
/*      */   public final List<c> g() {
/*  466 */     return (this.e == null) ? Collections.emptyList() : this.e;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   private List<AffineTransform> a(ab paramab, f paramf) {
/*      */     g g;
/*  476 */     if ((g = paramf.a().i(a.ay)).h() && g.f() == c.ap) {
/*  477 */       return Collections.emptyList();
/*      */     }
/*      */ 
/*      */     
/*  481 */     float f2 = paramf.a().b(a.az, paramf
/*  482 */         .Q(), (d)paramab);
/*  483 */     float f3 = paramf.a().c(a.aA, paramf
/*  484 */         .as(), (d)paramab);
/*      */     
/*  486 */     float f4 = paramab.p().f() ? -1.0F : 1.0F;
/*      */     
/*  488 */     f2 += paramf.ab();
/*  489 */     float f1 = f3 + paramf.aa();
/*      */     
/*  491 */     f2 -= paramab.p().a();
/*  492 */     f1 -= paramab.p().b();
/*      */ 
/*      */ 
/*      */     
/*  496 */     if (paramab.p().f()) {
/*  497 */       h h = paramab.s().g((d)paramab);
/*  498 */       f2 += h.w();
/*  499 */       f1 += h.t();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  505 */       for (byte b = 0; b < paramab.t() && b < k().size(); b++) {
/*  506 */         h h1 = ((aa)k().get(b)).g((d)paramab);
/*  507 */         f1 += h1.t() + h1.v();
/*      */       } 
/*      */       
/*      */       d[] arrayOfD;
/*      */       
/*  512 */       if ((arrayOfD = paramab.s().h()) != null) {
/*  513 */         boolean bool1 = false, bool2 = false, bool3 = false;
/*  514 */         boolean bool4 = false, bool5 = false; int i; byte b1;
/*  515 */         for (i = (arrayOfD = arrayOfD).length, b1 = 0; b1 < i; ) {
/*  516 */           d d; if ((d = arrayOfD[b1]) == d.k || d == d.l || d == d.m)
/*      */           {
/*  518 */             bool1 = true; } 
/*  519 */           if (d == d.b || d == d.c || d == d.d)
/*      */           {
/*  521 */             bool2 = true; } 
/*  522 */           if (d == d.g || d == d.h || d == d.i)
/*      */           {
/*  524 */             bool4 = true;
/*      */           }
/*      */           
/*  527 */           if (d == d.e) {
/*  528 */             bool3 = true;
/*      */           }
/*      */           
/*  531 */           if (d == d.j)
/*  532 */             bool5 = true; 
/*      */           b1++;
/*      */         } 
/*  535 */         if (bool1)
/*  536 */           f2 -= h.w(); 
/*  537 */         if (bool2)
/*  538 */           f1 -= h.t(); 
/*  539 */         if (bool4) {
/*  540 */           f1 -= h.t() + h.v();
/*      */         }
/*  542 */         f2 -= h.w();
/*  543 */         f1 -= h.t();
/*      */         
/*  545 */         if (bool3) {
/*  546 */           f2 -= h.w();
/*  547 */           f1 -= h.t();
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  553 */         if (bool4)
/*      */         {
/*  555 */           f1 -= h.t() + h.v();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  561 */         if (bool5) {
/*  562 */           f2 -= h.w();
/*  563 */           f1 -= h.t() + h.v();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  568 */     List<j> list = ((f)g).j();
/*  569 */     ArrayList<AffineTransform> arrayList = new ArrayList();
/*  570 */     AffineTransform affineTransform1 = AffineTransform.getTranslateInstance(f2, f1);
/*  571 */     AffineTransform affineTransform2 = AffineTransform.getTranslateInstance(-f2, -f1);
/*      */     
/*  573 */     arrayList.add(affineTransform1);
/*      */     
/*  575 */     a(f4, list, arrayList);
/*      */     
/*  577 */     arrayList.add(affineTransform2);
/*      */     
/*  579 */     return paramab.p().a(arrayList);
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   private void a(float paramFloat, List<j> paramList, List<AffineTransform> paramList1) {
/*  584 */     for (Iterator<j> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  585 */       j j; String str = (j = iterator.next()).n().a();
/*  586 */       List<j> list = j.n().b();
/*      */       
/*  588 */       if ("rotate".equalsIgnoreCase(str)) {
/*  589 */         float f1 = paramFloat * a(list.get(0));
/*  590 */         paramList1.add(AffineTransform.getRotateInstance(f1)); continue;
/*  591 */       }  if ("scale".equalsIgnoreCase(str) || "scalex".equalsIgnoreCase(str) || "scaley"
/*  592 */         .equalsIgnoreCase(str)) {
/*  593 */         float f1 = ((j)list.get(0)).f();
/*  594 */         float f2 = ((j)list.get(0)).f();
/*  595 */         if (list.size() > 1)
/*  596 */           f2 = ((j)list.get(1)).f(); 
/*  597 */         if ("scalex".equalsIgnoreCase(str))
/*  598 */           f2 = 1.0F; 
/*  599 */         if ("scaley".equalsIgnoreCase(str))
/*  600 */           f1 = 1.0F; 
/*  601 */         paramList1.add(AffineTransform.getScaleInstance(f1, f2)); continue;
/*  602 */       }  if ("skew".equalsIgnoreCase(str)) {
/*  603 */         float f1 = paramFloat * a(list.get(0));
/*  604 */         float f2 = 0.0F;
/*  605 */         if (list.size() > 1)
/*  606 */           f2 = a(list.get(1)); 
/*  607 */         paramList1.add(AffineTransform.getShearInstance(Math.tan(f1), Math.tan(f2))); continue;
/*  608 */       }  if ("skewx".equalsIgnoreCase(str)) {
/*  609 */         float f1 = paramFloat * a(list.get(0));
/*  610 */         paramList1.add(AffineTransform.getShearInstance(Math.tan(f1), 0.0D)); continue;
/*  611 */       }  if ("skewy".equalsIgnoreCase(str)) {
/*  612 */         float f1 = paramFloat * a(list.get(0));
/*  613 */         paramList1.add(AffineTransform.getShearInstance(0.0D, Math.tan(f1))); continue;
/*  614 */       }  if ("matrix".equalsIgnoreCase(str)) {
/*  615 */         paramList1.add(new AffineTransform(((j)list.get(0)).f(), ((j)list.get(1)).f(), ((j)list
/*  616 */               .get(2)).f(), ((j)list.get(3)).f(), ((j)list
/*  617 */               .get(4)).f(), ((j)list.get(5)).f())); continue;
/*  618 */       }  if ("translate".equalsIgnoreCase(str)) {
/*  619 */         l.g(Level.WARNING, "translate function not implemented at this time"); continue;
/*  620 */       }  if ("translateX".equalsIgnoreCase(str)) {
/*  621 */         l.g(Level.WARNING, "translateX function not implemented at this time"); continue;
/*  622 */       }  if ("translateY".equalsIgnoreCase(str)) {
/*  623 */         l.g(Level.WARNING, "translateY function not implemented at this time");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   private static void c(ab paramab, List paramList) {
/*  688 */     for (Iterator<k> iterator = paramList.iterator(); iterator.hasNext();)
/*      */     {
/*  690 */       (k = iterator.next()).a().a(paramab, k.b());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   private static Map a(List paramList) {
/*  702 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  703 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*      */     
/*  705 */     HashSet hashSet = new HashSet();
/*  706 */     for (Iterator<f> iterator = paramList.iterator(); iterator.hasNext();) {
/*      */       
/*  708 */       if (f1 = iterator.next() instanceof f && (
/*      */         
/*  710 */         f2 = (f)f1).o()) {
/*      */         List list;
/*  712 */         if ((list = (List)hashMap2.get(f2.f())) == null) {
/*  713 */           list = new ArrayList();
/*  714 */           hashMap2.put(f2.f(), list);
/*      */         } 
/*  716 */         hashMap3.put(f2.f(), f2);
/*  717 */         f2.a(hashSet, list);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  722 */     if (hashMap3.size() == 0) {
/*  723 */       return null;
/*      */     }
/*  725 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*      */     
/*  727 */     for (f f1 : hashMap3.values()) {
/*      */       List<Comparable> list;
/*      */       
/*  730 */       Collections.sort(list = (List<Comparable>)hashMap2.get(f1.f()));
/*  731 */       hashMap1.put(f1, list);
/*      */     } 
/*      */     
/*  734 */     return hashMap1;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final void a(ab paramab, c paramc) {
/*  740 */     h h = new h();
/*      */     
/*  742 */     ArrayList<f> arrayList1 = new ArrayList();
/*  743 */     ArrayList<f> arrayList2 = new ArrayList();
/*      */     
/*      */     d d;
/*  746 */     (d = new d()).a((d)paramab, paramab.p().c(), this, (f)paramc, arrayList1, arrayList2, h);
/*      */ 
/*      */     
/*  749 */     Map map = a(arrayList1);
/*      */     
/*  751 */     a(paramab, arrayList1, map, h);
/*  752 */     b(paramab, arrayList1, h);
/*  753 */     a(paramab, arrayList2, h);
/*  754 */     b(paramab, arrayList2);
/*  755 */     c(paramab, arrayList1, h);
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   private static void b(ab paramab, List<c> paramList, h paramh) {
/*  760 */     g g = new g(paramab.p(), paramh.a());
/*      */     
/*  762 */     for (byte b = 0; b < paramList.size(); b++) {
/*  763 */       g.a(b);
/*      */       
/*      */       c c;
/*  766 */       (c = paramList.get(b)).f(paramab);
/*      */       
/*  768 */       g.a(paramab, b);
/*      */     } 
/*      */     
/*  771 */     g.a(paramList.size());
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   private void c(ab paramab, List<c> paramList, h paramh) {
/*  776 */     g g = new g(paramab.p(), paramh.a());
/*      */     
/*  778 */     for (byte b = 0; b < paramList.size(); b++) {
/*  779 */       g.a(b);
/*      */       
/*      */       c c;
/*  782 */       if ((c = paramList.get(b)).A()) {
/*  783 */         b(paramab, c);
/*      */       }
/*      */       
/*  786 */       g.a(paramab, b);
/*      */     } 
/*      */     
/*  789 */     g.a(paramList.size());
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   private void f(ab paramab) {
/*  794 */     if (f() instanceof c) {
/*      */       c c;
/*  796 */       (c = (c)f()).b(paramab);
/*  797 */       c.c(paramab);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void b(ab paramab) {
/*  802 */     Rectangle rectangle = paramab.h();
/*      */     
/*      */     f f1;
/*      */     
/*  806 */     (f1 = f()).n(0);
/*  807 */     f1.o(0);
/*  808 */     f1.m(0);
/*  809 */     f1.l(0);
/*      */     
/*  811 */     f1.g((f)new ae(rectangle));
/*  812 */     ((c)f1).b((d)paramab, 3);
/*      */     
/*  814 */     f1.c((d)paramab, false);
/*      */   }
/*      */   
/*      */   public final boolean h() {
/*  818 */     return (d() == null && e());
/*      */   }
/*      */   
/*      */   private static void a(Dimension paramDimension1, Dimension paramDimension2) {
/*  822 */     if (paramDimension2.width > paramDimension1.width) {
/*  823 */       paramDimension1.width = paramDimension2.width;
/*      */     }
/*  825 */     if (paramDimension2.height > paramDimension1.height) {
/*  826 */       paramDimension1.height = paramDimension2.height;
/*      */     }
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   private static void b(ab paramab, c paramc) {
/*  832 */     Rectangle rectangle = paramc.c(paramc
/*  833 */         .ab(), paramc.aa(), (d)paramab);
/*      */ 
/*      */     
/*  836 */     Point point = paramc.E().c();
/*  837 */     if (rectangle.x != point.x || rectangle.y != point.y) {
/*  838 */       paramc.E().a(rectangle.x, rectangle.y);
/*      */     }
/*  840 */     if (paramab.n()) { paramc.E(); return; }
/*  841 */      paramab.p().a(paramab, paramc);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void b(v paramv) {
/*  846 */     for (Iterator<t> iterator = q().iterator(); iterator.hasNext();) {
/*  847 */       (t1 = iterator.next()).g(paramv);
/*      */     }
/*      */   }
/*      */   
/*      */   private y e(v paramv) {
/*  852 */     f().c(paramv, true);
/*  853 */     y y = f().at().c();
/*      */     
/*  855 */     for (Iterator<t> iterator = q().iterator(); iterator.hasNext();) {
/*  856 */       if (!(t1 = iterator.next()).f().a().B())
/*      */       {
/*  858 */         if (t1.f().a().A()) {
/*  859 */           y y1 = t1.e(paramv);
/*  860 */           a(y.b(), y1.b());
/*      */         } 
/*      */       }
/*      */     } 
/*  864 */     return y;
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
/*      */   private List<t> q() {
/*  891 */     return (this.c == null) ? Collections.emptyList() : this.c;
/*      */   }
/*      */   
/*      */   private void b(t paramt) {
/*  895 */     boolean bool = false;
/*      */     
/*  897 */     if (this.c != null) {
/*  898 */       for (Iterator<t> iterator = this.c.iterator(); iterator.hasNext();) {
/*      */         
/*  900 */         if ((t1 = iterator.next()) == paramt) {
/*  901 */           bool = true;
/*  902 */           iterator.remove();
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  908 */     if (!bool) {
/*  909 */       throw new RuntimeException("Could not find layer to remove");
/*      */     }
/*      */   }
/*      */   
/*      */   public final void i() {
/*  914 */     if (d() != null) {
/*  915 */       d().b(this);
/*      */     }
/*  917 */     a(true);
/*      */   }
/*      */   
/*      */   public final boolean j() {
/*  921 */     return this.f;
/*      */   }
/*      */   
/*      */   public final void b(boolean paramBoolean) {
/*  925 */     this.f = true;
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
/*      */   private boolean r() {
/*  937 */     return this.g;
/*      */   }
/*      */   
/*      */   public final void c(boolean paramBoolean) {
/*  941 */     this.g = paramBoolean;
/*      */   }
/*      */   
/*      */   public final void c(v paramv) {
/*  945 */     if (paramv.r()) {
/*  946 */       f(paramv);
/*      */     }
/*  948 */     if (!j()) {
/*  949 */       b(paramv);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void f(v paramv) {
/*      */     List<t> list;
/*  956 */     if ((list = q()).size() > 0) {
/*  957 */       w w = paramv.j();
/*      */       
/*  959 */       for (byte b = 0; b < list.size(); b++) {
/*      */         t t1;
/*  961 */         boolean bool = (t1 = list.get(b)).f().a().B();
/*      */         
/*  963 */         if (t1.r()) {
/*  964 */           a(paramv, t1);
/*      */           
/*  966 */           if (!bool && t1
/*  967 */             .f().a().ad() && t1
/*  968 */             .f().u(paramv)) {
/*      */             c c;
/*      */ 
/*      */             
/*  972 */             (c = (c)t1.f()).c(paramv);
/*  973 */             c.e(true);
/*      */             
/*  975 */             a(paramv, t1);
/*      */             
/*  977 */             if (c.u(paramv)) {
/*  978 */               c.c(paramv);
/*  979 */               a(paramv, t1);
/*      */             } 
/*      */           } 
/*      */           
/*  983 */           t1.c(false);
/*  984 */           t1.c(paramv);
/*      */           
/*  986 */           if (!bool) {
/*  987 */             paramv.p().c(paramv, t1.f());
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  992 */       paramv.a(w);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void g(v paramv) {
/*  998 */     if (f().a().A() && !paramv.r()) {
/*  999 */       ((c)f()).b(paramv, 3); return;
/* 1000 */     }  if (f().a().F() && (
/* 1001 */       j() || ((c)f()).v())) {
/* 1002 */       f().m(paramv);
/* 1003 */       if (!j()) {
/* 1004 */         f().B();
/* 1005 */         f().C();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final List<aa> k() {
/* 1012 */     if (this.h == null)
/* 1013 */       return (this.a == null) ? Collections.emptyList() : this.a.k(); 
/* 1014 */     return this.h;
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
/*      */   private static void a(v paramv, t paramt) {
/* 1026 */     c c = (c)paramt.f();
/*      */     
/* 1028 */     if (paramt.f().a().W()) {
/*      */       
/* 1030 */       c.b(paramv, 3);
/* 1031 */       c.j(paramv);
/* 1032 */       paramv.a(true);
/* 1033 */       ((c)paramt.f()).b(paramv);
/*      */       
/* 1035 */       c.b(paramv, 2);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1041 */     paramv.a(true);
/* 1042 */     c.b(paramv);
/*      */     
/* 1044 */     g g1 = c.av();
/* 1045 */     c.c(paramv);
/* 1046 */     g g2 = c.av();
/* 1047 */     c.a(g1);
/* 1048 */     c.b(paramv, 3);
/* 1049 */     c.j(paramv);
/* 1050 */     c.a(g2);
/*      */     
/* 1052 */     paramv.a(true);
/* 1053 */     ((c)paramt.f()).b(paramv);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void l() {
/*      */     aa aa1;
/* 1059 */     if ((aa1 = this.h.remove(this.h.size() - 1)) == t()) {
/* 1060 */       a((aa)null);
/*      */     }
/*      */   }
/*      */   
/*      */   public final void b(d paramd) {
/*      */     String str;
/* 1066 */     if (this.h == null) {
/* 1067 */       this.h = new ArrayList<>();
/*      */     }
/*      */     
/*      */     List<aa> list;
/* 1071 */     if ((list = k()).size() == 0) {
/* 1072 */       str = "first";
/* 1073 */     } else if (list.size() % 2 == 0) {
/* 1074 */       str = "right";
/*      */     } else {
/* 1076 */       str = "left";
/*      */     } 
/* 1078 */     aa aa1 = a(paramd, str);
/* 1079 */     if (list.size() == 0) {
/* 1080 */       aa1.a(paramd, 0);
/*      */     } else {
/* 1082 */       aa aa2 = list.get(list.size() - 1);
/* 1083 */       aa1.a(paramd, aa2.a());
/*      */     } 
/*      */     
/* 1086 */     aa1.d(list.size());
/* 1087 */     list.add(aa1);
/*      */   }
/*      */   
/*      */   public final aa a(d paramd, f paramf) {
/* 1091 */     return a(paramd, paramf.aa());
/*      */   }
/*      */   
/*      */   public final aa b(d paramd, f paramf) {
/* 1095 */     return a(paramd, paramf.aa() + paramf.as() - 1);
/*      */   }
/*      */   
/*      */   public final void c(d paramd, f paramf) {
/* 1099 */     b(paramd, paramf);
/*      */   }
/*      */   public final aa a(d paramd, int paramInt) {
/*      */     int i;
/* 1103 */     List<aa> list = k();
/* 1104 */     if (paramInt < 0) {
/* 1105 */       return null;
/*      */     }
/*      */     aa aa1;
/* 1108 */     if ((aa1 = t()) != null && 
/* 1109 */       paramInt >= aa1.b() && paramInt < aa1.a()) {
/* 1110 */       return aa1;
/*      */     }
/*      */     
/* 1113 */     aa1 = list.get(list.size() - 1);
/* 1114 */     if (paramInt < aa1.a()) {
/*      */       int j;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1120 */       for (j = (i = list.size()) - 1; j >= 0 && j >= i - 5; j--) {
/* 1121 */         aa aa2 = list.get(j);
/* 1122 */         if (paramInt >= aa2.b() && paramInt < aa2.a()) {
/* 1123 */           a(aa2);
/* 1124 */           return aa2;
/*      */         } 
/*      */       } 
/*      */       
/* 1128 */       j = 0;
/* 1129 */       int k = i - 6;
/*      */       
/* 1131 */       while (j <= k) {
/* 1132 */         i = j + k >> 1;
/* 1133 */         aa aa2 = list.get(i);
/*      */         
/* 1135 */         if (paramInt >= aa2.b() && paramInt < aa2.a()) {
/* 1136 */           a(aa2);
/* 1137 */           return aa2;
/*      */         } 
/*      */         
/* 1140 */         if (aa2.b() < paramInt) {
/* 1141 */           j = i + 1; continue;
/*      */         } 
/* 1143 */         k = i - 1;
/*      */       } 
/*      */     } else {
/*      */       
/* 1147 */       b(i, paramInt);
/* 1148 */       aa aa2 = list.get(list.size() - 1);
/* 1149 */       a(aa2);
/* 1150 */       return aa2;
/*      */     } 
/*      */ 
/*      */     
/* 1154 */     throw new RuntimeException("internal error");
/*      */   }
/*      */   
/*      */   private void b(d paramd, int paramInt) {
/*      */     List<aa> list;
/* 1159 */     aa aa1 = (list = k()).get(list.size() - 1);
/* 1160 */     while (paramInt >= aa1.a()) {
/* 1161 */       b(paramd);
/* 1162 */       aa1 = list.get(list.size() - 1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void c(int paramInt) {
/*      */     List<aa> list;
/*      */     aa aa1;
/* 1170 */     for (int i = (list = k()).size() - 1; i > 0 && (
/*      */       
/* 1172 */       aa1 = list.get(i)).b() >= paramInt; i--) {
/* 1173 */       if (aa1 == t()) {
/* 1174 */         a((aa)null);
/*      */       }
/* 1176 */       list.remove(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void d(int paramInt) {
/* 1184 */     while (this.h.size() > paramInt) {
/*      */       aa aa1;
/* 1186 */       if ((aa1 = this.h.remove(this.h.size() - 1)) == t()) {
/* 1187 */         a((aa)null);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void a(d paramd, short paramShort) {
/* 1193 */     a(paramd, 2, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(d paramd, int paramInt1, int paramInt2) {
/* 1198 */     List<aa> list = k();
/* 1199 */     int i = 0;
/* 1200 */     for (Iterator<aa> iterator = list.iterator(); iterator.hasNext(); ) {
/* 1201 */       aa aa1; (aa1 = iterator.next()).c(i);
/* 1202 */       if (paramInt1 == 1) {
/* 1203 */         aa1.b(i + aa1.b(paramd));
/* 1204 */       } else if (paramInt1 == 2) {
/* 1205 */         aa1.b(i + aa1.c(paramd));
/*      */       } else {
/* 1207 */         throw new IllegalArgumentException("Illegal mode");
/*      */       } 
/* 1209 */       i = aa1.c();
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
/*      */   public final aa m() {
/*      */     List<aa> list;
/* 1228 */     return ((list = k()).size() == 0) ? null : list.get(list.size() - 1);
/*      */   }
/*      */   
/*      */   public final boolean a(v paramv, int paramInt1, int paramInt2) {
/* 1232 */     if (paramInt1 < 0) {
/* 1233 */       return false;
/*      */     }
/* 1235 */     aa aa1 = a(paramv, paramInt1);
/* 1236 */     return (paramInt2 >= aa1.a() - paramv.z());
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
/*      */   public final void c(c paramc) {
/* 1248 */     if (this.l == null) {
/* 1249 */       this.l = new HashMap<>();
/*      */     }
/*      */     
/* 1252 */     String str = paramc.a().Q();
/*      */     
/*      */     List<c> list;
/* 1255 */     if ((list = this.l.get(str)) == null) {
/* 1256 */       list = new ArrayList();
/* 1257 */       this.l.put(str, list);
/*      */     } 
/*      */     
/* 1260 */     list.add(paramc);
/*      */     
/* 1262 */     Collections.sort(list, (paramc1, paramc2) -> paramc1.aa() - paramc2.aa());
/*      */   }
/*      */   
/*      */   public final void d(c paramc) {
/* 1266 */     if (this.l == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1270 */     String str = paramc.a().Q();
/*      */     
/*      */     List list;
/* 1273 */     if ((list = this.l.get(str)) == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1277 */     list.remove(paramc); } public final c a(String paramString, aa paramaa, e parame) { c c2; Iterator<c> iterator1; c c1;
/*      */     Iterator<c> iterator3;
/*      */     c c3;
/*      */     Iterator<c> iterator2;
/* 1281 */     if (this.l == null) {
/* 1282 */       return null;
/*      */     }
/*      */     
/*      */     List list;
/* 1286 */     if ((list = this.l.get(paramString)) == null) {
/* 1287 */       return null;
/*      */     }
/*      */     
/* 1290 */     if (parame == e.a) {
/* 1291 */       parame = null; c c;
/* 1292 */       for (iterator3 = list.iterator(); iterator3.hasNext() && (
/*      */         
/* 1294 */         c = iterator3.next()).y().aa() < paramaa.b();)
/*      */       {
/*      */         
/* 1297 */         c2 = c;
/*      */       }
/* 1299 */       return c2;
/* 1300 */     }  if (c2 == e.b) {
/* 1301 */       for (iterator1 = iterator3.iterator(); iterator1.hasNext();) {
/*      */ 
/*      */         
/* 1304 */         if ((i = (c3 = iterator1.next()).y().aa()) >= paramaa.b() && i < paramaa.a()) {
/* 1305 */           return c3;
/*      */         }
/*      */       } 
/* 1308 */       return a(paramString, paramaa, e.a);
/* 1309 */     }  if (iterator1 == e.c) {
/* 1310 */       iterator1 = null; c c;
/* 1311 */       for (iterator2 = c3.iterator(); iterator2.hasNext() && (
/*      */         
/* 1313 */         c = iterator2.next()).y().aa() <= paramaa.a();)
/*      */       {
/*      */         
/* 1316 */         c1 = c;
/*      */       }
/* 1318 */       return c1;
/* 1319 */     }  if (c1 == e.d) {
/* 1320 */       c1 = null;
/* 1321 */       for (iterator2 = iterator2.iterator(); iterator2.hasNext(); ) {
/*      */         int i;
/*      */         c c;
/* 1324 */         if ((i = (c = iterator2.next()).y().aa()) >= paramaa.b() && i < paramaa.a()) {
/* 1325 */           return null;
/*      */         }
/* 1327 */         if (i <= paramaa.a())
/*      */         {
/*      */           
/* 1330 */           c1 = c; } 
/*      */       } 
/* 1332 */       return c1;
/*      */     } 
/*      */     
/* 1335 */     throw new RuntimeException("bug: internal error"); }
/*      */ 
/*      */   
/*      */   public final void d(v paramv) {
/* 1339 */     paramv.a(paramv.p());
/* 1340 */     for (Iterator<aa> iterator = this.h.iterator(); iterator.hasNext();) {
/* 1341 */       (aa1 = iterator.next()).a(paramv);
/*      */     }
/*      */   }
/*      */   
/*      */   public final void e(c paramc) {
/* 1346 */     if (this.j == null) {
/* 1347 */       this.j = new HashSet<>();
/*      */     }
/*      */     
/* 1350 */     this.j.add(paramc);
/*      */   }
/*      */   
/*      */   private List<c> s() {
/* 1354 */     if (this.j == null) {
/* 1355 */       return null;
/*      */     }
/*      */     
/* 1358 */     if (this.k == null) {
/*      */       ArrayList<c> arrayList;
/*      */       
/* 1361 */       Collections.sort(arrayList = new ArrayList<>(this.j), new u(this));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1367 */       this.k = arrayList;
/*      */     } 
/*      */     
/* 1370 */     return this.k;
/*      */   }
/*      */   
/*      */   public final int a(ab paramab, int paramInt) {
/* 1374 */     List<c> list = s();
/* 1375 */     int k = 0;
/* 1376 */     if (paramab.v() > 0) {
/* 1377 */       k = paramab.v() - 1;
/*      */     }
/* 1379 */     if (list == null || list.isEmpty()) {
/* 1380 */       return k + a((d)paramab, paramInt).i();
/*      */     }
/* 1382 */     c c = a(list, paramInt);
/* 1383 */     int j = a((d)paramab, c.aa()).i();
/*      */     int i;
/* 1385 */     return (i = a((d)paramab, paramInt).i()) - j;
/*      */   }
/*      */ 
/*      */   
/*      */   private static c a(List<c> paramList, int paramInt) {
/* 1390 */     c c = null;
/*      */     
/* 1392 */     for (byte b = 0; b < paramList.size(); ) {
/* 1393 */       c = paramList.get(b);
/* 1394 */       if (b >= paramList.size() - 1 || ((c)paramList.get(b + 1)).aa() <= paramInt) {
/*      */         b++;
/*      */       }
/*      */     } 
/*      */     
/* 1399 */     return c;
/*      */   }
/*      */   
/*      */   public final int c(ab paramab) {
/* 1403 */     List<c> list = s();
/* 1404 */     int i = 0;
/* 1405 */     if (paramab.v() > 0) {
/* 1406 */       i = paramab.v() - 1;
/*      */     }
/* 1408 */     if (list == null) {
/* 1409 */       return i + paramab.t();
/*      */     }
/*      */     int j;
/* 1412 */     if ((j = a(list, paramab.s())) == -1) {
/* 1413 */       return i + paramab.t();
/*      */     }
/* 1415 */     c c = list.get(j);
/* 1416 */     return paramab.t() - a((d)paramab, (f)c).i();
/*      */   }
/*      */ 
/*      */   
/*      */   public final int d(ab paramab) {
/*      */     int i, k;
/* 1422 */     List<c> list = s();
/* 1423 */     int j = 0;
/* 1424 */     if (paramab.v() > 0) {
/* 1425 */       j = paramab.v() - 1;
/*      */     }
/* 1427 */     if (list == null) {
/* 1428 */       return j + paramab.r();
/*      */     }
/*      */ 
/*      */     
/*      */     int m;
/*      */ 
/*      */     
/* 1435 */     if ((m = a(list, paramab.s())) == -1) {
/* 1436 */       k = 0;
/*      */     } else {
/* 1438 */       c c = list.get(m);
/* 1439 */       k = a((d)paramab, (f)c).i();
/*      */     } 
/*      */     
/* 1442 */     if (m < list.size() - 1) {
/* 1443 */       c c = list.get(m + 1);
/* 1444 */       i = a((d)paramab, (f)c).i();
/*      */     } else {
/* 1446 */       i = i.r();
/*      */     } 
/*      */     
/* 1449 */     int n = i - k;
/* 1450 */     if (m == -1) {
/* 1451 */       n += j;
/*      */     }
/*      */     
/* 1454 */     return n;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int a(List<c> paramList, aa paramaa) {
/* 1459 */     for (int i = paramList.size() - 1; i >= 0; i--) {
/*      */       c c;
/* 1461 */       if ((c = paramList.get(i)).aa() < paramaa.a() - 1) {
/* 1462 */         return i;
/*      */       }
/*      */     } 
/*      */     
/* 1466 */     return -1;
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
/*      */   private aa t() {
/* 1518 */     return this.i;
/*      */   }
/*      */   
/*      */   private void a(aa paramaa) {
/* 1522 */     this.i = paramaa;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */