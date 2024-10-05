/*      */ package com.d.i;
/*      */ 
/*      */ import com.d.c.a.a;
/*      */ import com.d.c.a.c;
/*      */ import com.d.c.f.a.a;
/*      */ import com.d.c.f.a.h;
/*      */ import com.d.c.f.c;
/*      */ import com.d.c.f.d;
/*      */ import com.d.d.b;
/*      */ import com.d.e.ac;
/*      */ import com.d.e.t;
/*      */ import com.d.e.v;
/*      */ import com.d.e.y;
/*      */ import com.d.m.l;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Shape;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.awt.geom.Area;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.logging.Level;
/*      */ import org.w3c.dom.Element;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class f
/*      */   implements b, ac
/*      */ {
/*      */   private Element a;
/*      */   private int b;
/*      */   private int c;
/*      */   private int d;
/*      */   private int e;
/*      */   private int f;
/*      */   
/*      */   static {
/*   51 */     System.getProperty("line.separator");
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
/*   65 */   private int g = 0;
/*   66 */   private int h = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   private int i;
/*      */ 
/*      */   
/*   73 */   private t j = null;
/*      */ 
/*      */ 
/*      */   
/*      */   private t k;
/*      */ 
/*      */ 
/*      */   
/*      */   private f l;
/*      */ 
/*      */ 
/*      */   
/*      */   private List<f> m;
/*      */ 
/*      */ 
/*      */   
/*      */   private int n;
/*      */ 
/*      */ 
/*      */   
/*      */   private int o;
/*      */ 
/*      */ 
/*      */   
/*      */   private c p;
/*      */ 
/*      */ 
/*      */   
/*      */   private f q;
/*      */ 
/*      */ 
/*      */   
/*      */   private Dimension r;
/*      */ 
/*      */   
/*      */   private y s;
/*      */ 
/*      */   
/*      */   private h t;
/*      */ 
/*      */   
/*      */   private int u;
/*      */ 
/*      */   
/*      */   private String v;
/*      */ 
/*      */   
/*      */   private boolean w;
/*      */ 
/*      */   
/*      */   private Area x;
/*      */ 
/*      */   
/*      */   private boolean y = false;
/*      */ 
/*      */ 
/*      */   
/*      */   private Rectangle b(ab paramab, t paramt) {
/*  131 */     return c(paramab, paramt);
/*      */   }
/*      */   
/*      */   private f c() {
/*  135 */     if (a() != null && a().G())
/*  136 */       return Y(); 
/*  137 */     if (this instanceof c && ((c)this)
/*  138 */       .K()) {
/*  139 */       return Y();
/*      */     }
/*  141 */     return U();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Rectangle a(ab paramab, t paramt) {
/*      */     f f1;
/*  152 */     if ((f1 = c()) == null || f1.af() != paramt) {
/*  153 */       return null;
/*      */     }
/*      */     
/*  156 */     return f1.b(paramab, paramt);
/*      */   }
/*      */   private Rectangle c(ab paramab, t paramt) {
/*      */     Rectangle rectangle;
/*  160 */     if (af() != paramt)
/*  161 */       return null; 
/*  162 */     if (a() != null && a().a(a.ac, c.P))
/*      */     {
/*  164 */       return ((rectangle = a(paramab, paramt)) != null) ? k(paramab).intersection(rectangle) : k(paramab);
/*      */     }
/*  166 */     return a(paramab, (t)rectangle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Area i(d paramd) {
/*  175 */     if (!this.y) {
/*  176 */       this.x = a(paramd);
/*  177 */       this.y = true;
/*      */     } 
/*  179 */     return (this.x != null) ? (Area)this.x.clone() : null;
/*      */   }
/*      */   
/*      */   private Area a(d paramd) {
/*  183 */     Rectangle rectangle = (a() != null && a().a(a.ac, c.P)) ? k(paramd) : null;
/*      */     f f1;
/*  185 */     Area area = ((f1 = c()) != null) ? f1.i(paramd) : null;
/*      */     
/*  187 */     if (rectangle != null) {
/*  188 */       AffineTransform affineTransform = af().a();
/*  189 */       Area area1 = new Area((affineTransform != null) ? affineTransform.createTransformedShape(rectangle) : rectangle);
/*  190 */       if (area != null) {
/*  191 */         area1.intersect(area);
/*      */       }
/*  193 */       return area1;
/*      */     } 
/*  195 */     return area;
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
/*      */   public int Q() {
/*  214 */     return d_() + ar() + aq();
/*      */   }
/*      */   
/*      */   public String toString() {
/*      */     StringBuilder stringBuilder;
/*  219 */     (stringBuilder = new StringBuilder()).append("Box: ");
/*  220 */     stringBuilder.append(" (" + ab() + "," + aa() + ")->(" + Q() + " x " + as() + ")");
/*  221 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   public final void a(v paramv, f paramf) {
/*  225 */     b(paramf);
/*      */     
/*  227 */     paramf.r(paramv);
/*      */   }
/*      */   
/*      */   public final void b(f paramf) {
/*  231 */     if (this.m == null) {
/*  232 */       this.m = new ArrayList<>();
/*      */     }
/*  234 */     if (paramf == null) {
/*  235 */       throw new NullPointerException("trying to add null child");
/*      */     }
/*  237 */     paramf.f(this);
/*  238 */     paramf.a(this.m.size());
/*  239 */     this.m.add(paramf);
/*      */   }
/*      */   
/*      */   public final void c(List<f> paramList) {
/*  243 */     for (f f1 : paramList) {
/*  244 */       b(f1);
/*      */     }
/*      */   }
/*      */   
/*      */   public final void R() {
/*  249 */     if (this.m != null) {
/*  250 */       this.m.clear();
/*      */     }
/*      */   }
/*      */   
/*      */   public void c(f paramf) {
/*  255 */     if (this.m != null) {
/*  256 */       boolean bool = false;
/*  257 */       for (Iterator<f> iterator = W(); iterator.hasNext(); ) {
/*      */         f f1;
/*  259 */         if ((f1 = iterator.next()).equals(paramf)) {
/*  260 */           iterator.remove();
/*  261 */           bool = true; continue;
/*  262 */         }  if (bool) {
/*  263 */           f1.a(f1.ak() - 1);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final f S() {
/*      */     f f1;
/*  271 */     return ((f1 = U()) == null) ? null : f1.d(this);
/*      */   }
/*      */   
/*      */   public final f T() {
/*      */     f f1;
/*  276 */     return ((f1 = U()) == null) ? null : f1.e(this);
/*      */   }
/*      */   
/*      */   protected f d(f paramf) {
/*  280 */     return (paramf.ak() == 0) ? null : k(paramf.ak() - 1);
/*      */   }
/*      */   
/*      */   protected f e(f paramf) {
/*  284 */     return (paramf.ak() == V() - 1) ? null : k(paramf.ak() + 1);
/*      */   }
/*      */   
/*      */   public void j(int paramInt) {
/*  288 */     if (this.m != null) {
/*  289 */       c(k(paramInt));
/*      */     }
/*      */   }
/*      */   
/*      */   public final void f(f paramf) {
/*  294 */     this.l = paramf;
/*      */   }
/*      */   
/*      */   public f U() {
/*  298 */     return this.l;
/*      */   }
/*      */   
/*      */   public f O() {
/*  302 */     return U();
/*      */   }
/*      */   
/*      */   public final int V() {
/*  306 */     return (this.m == null) ? 0 : this.m.size();
/*      */   }
/*      */   
/*      */   public final f k(int paramInt) {
/*  310 */     if (this.m == null) {
/*  311 */       throw new IndexOutOfBoundsException();
/*      */     }
/*  313 */     return this.m.get(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public final Iterator<f> W() {
/*  318 */     return (this.m == null) ? Collections.emptyIterator() : this.m.iterator();
/*      */   }
/*      */   
/*      */   public final List<f> X() {
/*  322 */     return (this.m == null) ? Collections.emptyList() : this.m;
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
/*      */   public final c a() {
/*  360 */     return this.p;
/*      */   }
/*      */   
/*      */   public void a(c paramc) {
/*  364 */     this.p = paramc;
/*      */   }
/*      */   
/*      */   public final f Y() {
/*  368 */     return (this.q == null) ? U() : this.q;
/*      */   }
/*      */   
/*      */   public final void g(f paramf) {
/*  372 */     this.q = paramf;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Rectangle a(int paramInt1, int paramInt2, d paramd, int paramInt3, int paramInt4) {
/*      */     Rectangle rectangle;
/*  379 */     (rectangle = new Rectangle(paramInt1, paramInt2, Q(), as())).translate(paramInt3, paramInt4);
/*  380 */     return rectangle;
/*      */   }
/*      */   
/*      */   public Rectangle a(d paramd, int paramInt1, int paramInt2) {
/*  384 */     return a(am(), an(), paramd, paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   public final Rectangle j(d paramd) {
/*  388 */     return a(ab(), aa(), paramd);
/*      */   }
/*      */   
/*      */   private Rectangle c(d paramd) {
/*  392 */     return b(ab(), aa(), paramd);
/*      */   }
/*      */   
/*      */   public Rectangle g(d paramd) {
/*  396 */     return j(paramd);
/*      */   }
/*      */   
/*      */   public final Rectangle k(d paramd) {
/*  400 */     return c(paramd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(d paramd, Shape paramShape) {
/*      */     AffineTransform affineTransform;
/*  410 */     if ((affineTransform = af().a()) == null || paramShape == null) {
/*  411 */       return (paramShape == null || paramShape.intersects(g(paramd)));
/*      */     }
/*  413 */     Shape shape = affineTransform.createTransformedShape(g(paramd));
/*  414 */     return paramShape.intersects(shape.getBounds2D());
/*      */   }
/*      */ 
/*      */   
/*      */   public Rectangle a(int paramInt1, int paramInt2, d paramd) {
/*  419 */     h h1 = n(paramd);
/*      */ 
/*      */     
/*      */     Rectangle rectangle;
/*      */     
/*  424 */     return rectangle = new Rectangle(paramInt1 + (int)h1.w(), paramInt2 + (int)h1.t(), Q() - (int)h1.w() - (int)h1.u(), as() - (int)h1.t() - (int)h1.v());
/*      */   }
/*      */   
/*      */   public Rectangle b(int paramInt1, int paramInt2, d paramd) {
/*  428 */     h h1 = n(paramd);
/*  429 */     a a = b(paramd);
/*      */ 
/*      */     
/*      */     Rectangle rectangle;
/*      */     
/*  434 */     return rectangle = new Rectangle(paramInt1 + (int)h1.w() + (int)a.w(), paramInt2 + (int)h1.t() + (int)a.t(), Q() - (int)h1.y() - (int)a.y(), as() - (int)h1.x() - (int)a.x());
/*      */   }
/*      */   
/*      */   protected int l(d paramd) {
/*      */     h h1;
/*  439 */     return (int)(h1 = o(paramd)).w() + d_() + (int)h1.u();
/*      */   }
/*      */   
/*      */   public Rectangle c(int paramInt1, int paramInt2, d paramd) {
/*  443 */     h h2 = n(paramd);
/*  444 */     a a = b(paramd);
/*  445 */     h h1 = o(paramd);
/*      */ 
/*      */ 
/*      */     
/*      */     Rectangle rectangle;
/*      */ 
/*      */     
/*  452 */     return rectangle = new Rectangle(paramInt1 + (int)h2.w() + (int)a.w() + (int)h1.w(), paramInt2 + (int)h2.t() + (int)a.t() + (int)h1.t(), Q() - (int)h2.y() - (int)a.y() - (int)h1.y(), as() - (int)h2.x() - (int)a.x() - (int)h1.x());
/*      */   }
/*      */   
/*      */   public final t Z() {
/*  456 */     return this.j;
/*      */   }
/*      */   
/*      */   public final void a(t paramt) {
/*  460 */     this.j = paramt;
/*      */   }
/*      */   
/*      */   public Dimension m(d paramd) {
/*  464 */     int i = am();
/*  465 */     int j = an();
/*      */     
/*      */     c c1;
/*  468 */     if (!(c1 = a()).a(a.S, c.e)) {
/*  469 */       n(am() + (int)c1.b(a.S, 
/*  470 */             Y().d_(), paramd));
/*  471 */     } else if (!c1.a(a.aj, c.e)) {
/*  472 */       n(am() - (int)c1.b(a.aj, 
/*  473 */             Y().d_(), paramd));
/*      */     } 
/*      */     
/*  476 */     int k = 0;
/*  477 */     if (!Y().a().J()) {
/*      */       c c2;
/*  479 */       int m = (int)(c2 = Y().a()).c(a.R, 0.0F, paramd);
/*      */     }
/*  481 */     else if (N()) {
/*      */       
/*  483 */       k = Y().as();
/*      */     } 
/*      */     
/*  486 */     if (!c1.a(a.ar, c.e)) {
/*  487 */       o(an() + (int)c1.c(a.ar, k, paramd));
/*      */     }
/*  489 */     else if (!c1.a(a.x, c.e)) {
/*  490 */       o(an() - (int)c1.c(a.x, k, paramd));
/*      */     } 
/*      */ 
/*      */     
/*  494 */     a(new Dimension(am() - i, an() - j));
/*  495 */     return ag();
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean N() {
/*  500 */     return false;
/*      */   }
/*      */   
/*      */   public final void l(int paramInt) {
/*  504 */     this.d = paramInt;
/*      */   }
/*      */   
/*      */   public final int aa() {
/*  508 */     return this.d;
/*      */   }
/*      */   
/*      */   public final void m(int paramInt) {
/*  512 */     this.e = paramInt;
/*      */   }
/*      */   
/*      */   public final int ab() {
/*  516 */     return this.e;
/*      */   }
/*      */   
/*      */   public final boolean ac() {
/*  520 */     return (this.p != null);
/*      */   }
/*      */   
/*      */   public int ad() {
/*  524 */     return 15;
/*      */   }
/*      */   
/*      */   public void c(ab paramab) {
/*  528 */     paramab.p().a(paramab, this);
/*      */   }
/*      */   
/*      */   private boolean e() {
/*  532 */     if ((ah() && a().aq()) || (
/*  533 */       f() && !U().a().aq())) return true; 
/*      */     return false;
/*      */   }
/*      */   public void b(ab paramab) {
/*  537 */     if (!e()) {
/*  538 */       paramab.p().b(paramab, this);
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
/*      */   public final void h(ab paramab) {
/*      */     y y1;
/*  568 */     if ((y1 = at()) != null) {
/*  569 */       if (a().aq()) {
/*  570 */         a(paramab, y1); return;
/*  571 */       }  if (V() > 0) {
/*      */         f f1;
/*  573 */         (f1 = k(0)).a(paramab, y1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(ab paramab, y paramy) {
/*  579 */     Dimension dimension = paramy.b();
/*      */     Rectangle rectangle;
/*  581 */     (rectangle = new Rectangle(0, 0, dimension.width, dimension.height)).add(paramab.i());
/*  582 */     paramab.p().a(paramab, a(), rectangle, rectangle, a.a);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean ae() {
/*  589 */     if (a().aq())
/*  590 */       return true; 
/*  591 */     if (V() > 0 && 
/*  592 */       k(0).a().aq()) {
/*  593 */       return true;
/*      */     }
/*      */     
/*  596 */     return false;
/*      */   }
/*      */   
/*      */   public final t af() {
/*  600 */     return this.k;
/*      */   }
/*      */   
/*      */   public final void b(t paramt) {
/*  604 */     this.k = paramt;
/*      */   }
/*      */   
/*      */   public final void r(v paramv) {
/*  608 */     if (Z() != null) {
/*  609 */       b(Z()); return;
/*  610 */     }  if (af() == null) {
/*  611 */       if (U() == null || U().af() == null) {
/*  612 */         throw new RuntimeException("internal error");
/*      */       }
/*  614 */       b(U().af());
/*      */ 
/*      */       
/*      */       List<f> list;
/*      */ 
/*      */       
/*  620 */       if (paramv.o().j() && (
/*      */ 
/*      */         
/*  623 */         list = ((r)paramv.o().f()).l()).contains(this)) {
/*  624 */         b(paramv.o());
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void s(v paramv) {
/*  632 */     for (byte b1 = 0; b1 < V(); b1++) {
/*      */       f f1;
/*  634 */       (f1 = k(b1)).b(paramv.o());
/*  635 */       f1.s(paramv);
/*      */     } 
/*      */   }
/*      */   
/*      */   public List<f> b(Element paramElement) {
/*  640 */     ArrayList<f> arrayList = new ArrayList();
/*  641 */     for (byte b1 = 0; b1 < V(); b1++) {
/*      */       f f1;
/*  643 */       if ((f1 = k(b1)).ai() == paramElement) {
/*  644 */         arrayList.add(f1);
/*      */       }
/*  646 */       arrayList.addAll(f1.b(paramElement));
/*      */     } 
/*  648 */     return arrayList;
/*      */   }
/*      */   
/*      */   public void c(v paramv) {
/*  652 */     t(paramv);
/*  653 */     if (this.j != null) {
/*  654 */       this.j.i();
/*  655 */       this.j = null;
/*      */     } 
/*      */     
/*  658 */     b((t)null);
/*  659 */     a((t)null);
/*  660 */     a((y)null);
/*  661 */     u(0);
/*      */     
/*  663 */     this.t = null;
/*      */     
/*      */     String str2;
/*  666 */     if ((str2 = paramv.e().g(ai())) != null) {
/*  667 */       paramv.a(str2);
/*      */     }
/*      */     Element element;
/*      */     String str1;
/*  671 */     if ((element = ai()) != null && (
/*      */       
/*  673 */       str1 = paramv.e().b(element)) != null) {
/*  674 */       paramv.a(str1);
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
/*      */   public final void a(v paramv, int paramInt1, int paramInt2) {
/*  689 */     for (paramInt1 = paramInt1; paramInt1 <= paramInt2; paramInt1++) {
/*      */       f f1;
/*  691 */       (f1 = k(paramInt1)).c(paramv);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void t(v paramv) {
/*  696 */     int i = V();
/*  697 */     for (byte b1 = 0; b1 < i; b1++) {
/*      */       f f1;
/*  699 */       (f1 = k(b1)).c(paramv);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void C() {
/*  706 */     for (byte b1 = 0; b1 < V(); b1++) {
/*      */       f f1;
/*  708 */       (f1 = k(b1)).B();
/*  709 */       f1.C();
/*      */     } 
/*      */   }
/*      */   
/*      */   public int a(v paramv, c paramc, boolean paramBoolean) {
/*      */     aa aa;
/*  715 */     if ((aa = paramv.p().a((d)paramv, this)) == null) {
/*  716 */       l.g(Level.WARNING, "Box has no page");
/*  717 */       return 0;
/*      */     } 
/*  719 */     byte b1 = 1;
/*  720 */     if (aa.b() == aa()) {
/*  721 */       b1--;
/*  722 */       if (paramBoolean && aa == paramv.p().m()) {
/*  723 */         paramv.p().l();
/*  724 */         paramv.b(paramv.E());
/*  725 */         paramv.p().b((d)paramv);
/*      */       } 
/*      */     } 
/*  728 */     if ((aa.j() && paramc == c.aa) || (aa
/*  729 */       .k() && paramc == c.aJ)) {
/*  730 */       b1++;
/*      */     }
/*      */     
/*  733 */     if (b1 == 0) {
/*  734 */       return 0;
/*      */     }
/*      */     
/*  737 */     if (b1 == 1 && paramBoolean) {
/*  738 */       paramv.b(paramv.E());
/*      */     }
/*      */     
/*  741 */     int i = aa.a() + paramv.A() - aa();
/*  742 */     if (aa == paramv.p().m()) {
/*  743 */       paramv.p().b((d)paramv);
/*      */     }
/*      */     
/*  746 */     if (b1 == 2) {
/*  747 */       aa = paramv.p().k().get(aa.i() + 1);
/*  748 */       i += aa.c((d)paramv);
/*      */       
/*  750 */       if (paramBoolean) {
/*  751 */         paramv.b(paramv.E());
/*      */       }
/*      */       
/*  754 */       if (aa == paramv.p().m()) {
/*  755 */         paramv.p().b((d)paramv);
/*      */       }
/*      */     } 
/*      */     
/*  759 */     o(an() + i);
/*      */     
/*  761 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(v paramv, c paramc) {
/*  766 */     boolean bool = false;
/*      */     
/*      */     aa aa;
/*  769 */     if ((aa = paramv.p().b((d)paramv, this)) != null) {
/*  770 */       if ((aa.j() && paramc == c.aa) || (aa
/*  771 */         .k() && paramc == c.aJ)) {
/*  772 */         bool = true;
/*      */       }
/*      */ 
/*      */       
/*  776 */       int i = aa.a() + paramv.A() - aa() + g((d)paramv, 3) + as();
/*      */       
/*  778 */       if (aa == paramv.p().m()) {
/*  779 */         paramv.p().b((d)paramv);
/*      */       }
/*      */       
/*  782 */       if (bool) {
/*  783 */         aa = paramv.p().k().get(aa.i() + 1);
/*  784 */         i += aa.c((d)paramv);
/*      */         
/*  786 */         if (aa == paramv.p().m()) {
/*  787 */           paramv.p().b((d)paramv);
/*      */         }
/*      */       } 
/*      */       
/*  791 */       t(as() + i);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final boolean u(v paramv) {
/*  796 */     if (!paramv.D()) {
/*  797 */       return false;
/*      */     }
/*      */     
/*      */     aa aa;
/*  801 */     if ((aa = paramv.p().a((d)paramv, this)) == null) {
/*  802 */       return false;
/*      */     }
/*  804 */     return (aa() + as() >= aa.a() - paramv.z());
/*      */   }
/*      */ 
/*      */   
/*      */   public final Dimension ag() {
/*  809 */     return this.r;
/*      */   }
/*      */   
/*      */   private void a(Dimension paramDimension) {
/*  813 */     this.r = paramDimension;
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
/*      */   public final boolean ah() {
/*  836 */     return (ai() != null && !au() && ai().getParentNode().getNodeType() == 9);
/*      */   }
/*      */   
/*      */   private boolean f() {
/*  840 */     return (U() != null && U().ah());
/*      */   }
/*      */   
/*      */   public final Element ai() {
/*  844 */     return this.a;
/*      */   }
/*      */   
/*      */   public void a(Element paramElement) {
/*  848 */     this.a = paramElement;
/*      */   }
/*      */   
/*      */   public final void c(d paramd, int paramInt) {
/*  852 */     d(paramd);
/*  853 */     this.t.a(paramInt);
/*      */   }
/*      */   
/*      */   public final void d(d paramd, int paramInt) {
/*  857 */     d(paramd);
/*  858 */     this.t.c(paramInt);
/*      */   }
/*      */   
/*      */   public final void e(d paramd, int paramInt) {
/*  862 */     d(paramd);
/*  863 */     this.t.d(paramInt);
/*      */   }
/*      */   
/*      */   public final void f(d paramd, int paramInt) {
/*  867 */     d(paramd);
/*  868 */     this.t.b(paramInt);
/*      */   }
/*      */   
/*      */   private void d(d paramd) {
/*  872 */     if (this.t == null) {
/*  873 */       this.t = e(paramd).z();
/*      */     }
/*      */   }
/*      */   
/*      */   public final h n(d paramd) {
/*  878 */     return (this.t != null) ? this.t : e(paramd);
/*      */   }
/*      */   
/*      */   private h e(d paramd) {
/*  882 */     return a().a(aj(), paramd);
/*      */   }
/*      */   
/*      */   protected final h b(d paramd, boolean paramBoolean) {
/*  886 */     return a().a(aj(), paramd, false);
/*      */   }
/*      */   
/*      */   public final h o(d paramd) {
/*  890 */     return a().b(aj(), paramd);
/*      */   }
/*      */   
/*      */   public a b(d paramd) {
/*  894 */     return a().a(paramd);
/*      */   }
/*      */   
/*      */   protected int aj() {
/*  898 */     return Y().d_();
/*      */   }
/*      */   
/*      */   protected final void p(d paramd) {
/*  902 */     if (this.t != null) {
/*  903 */       h h1 = e(paramd);
/*      */       
/*  905 */       this.t.a(h1.t());
/*      */     } 
/*      */   }
/*      */   
/*      */   public final y c(d paramd, boolean paramBoolean) {
/*      */     y y1;
/*  911 */     if ((y1 = at()) != null && paramBoolean) {
/*  912 */       return y1;
/*      */     }
/*      */     
/*  915 */     y1 = new y();
/*      */     
/*  917 */     Rectangle rectangle = a(ab(), aa(), paramd, 0, 0);
/*  918 */     y1.a(new Dimension(rectangle.x + rectangle.width, rectangle.y + rectangle.height));
/*      */ 
/*      */     
/*  921 */     y1.a(g(paramd));
/*      */     
/*  923 */     if (!a().R() || a().S()) {
/*  924 */       a(paramd, y1, paramBoolean);
/*      */     }
/*      */     
/*  927 */     a(y1);
/*      */     
/*  929 */     return y1;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void a(d paramd, y paramy, boolean paramBoolean) {
/*  934 */     for (byte b1 = 0; b1 < V(); b1++) {
/*      */       f f1;
/*  936 */       y y1 = (f1 = k(b1)).c(paramd, paramBoolean);
/*  937 */       a(paramy.b(), y1.b());
/*  938 */       paramy.a().add(y1.a());
/*      */     } 
/*      */   }
/*      */   
/*      */   public final int g(d paramd, int paramInt) {
/*  943 */     a a = b(paramd);
/*  944 */     h h2 = n(paramd);
/*  945 */     h h1 = o(paramd);
/*      */     
/*  947 */     switch (paramInt) {
/*      */       case 1:
/*  949 */         return (int)(h2.w() + a.w() + h1.w());
/*      */       case 2:
/*  951 */         return (int)(h2.u() + a.u() + h1.u());
/*      */       case 3:
/*  953 */         return (int)(h2.t() + a.t() + h1.t());
/*      */       case 4:
/*  955 */         return (int)(h2.v() + a.v() + h1.v());
/*      */     } 
/*  957 */     throw new IllegalArgumentException();
/*      */   }
/*      */ 
/*      */   
/*      */   protected static void a(Dimension paramDimension1, Dimension paramDimension2) {
/*  962 */     if (paramDimension2.width > paramDimension1.width) {
/*  963 */       paramDimension1.width = paramDimension2.width;
/*      */     }
/*  965 */     if (paramDimension2.height > paramDimension1.height) {
/*  966 */       paramDimension1.height = paramDimension2.height;
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
/*      */   protected final int ak() {
/* 1023 */     return this.u;
/*      */   }
/*      */   
/*      */   private void a(int paramInt) {
/* 1027 */     this.u = paramInt;
/*      */   }
/*      */   
/*      */   public final String al() {
/* 1031 */     return this.v;
/*      */   }
/*      */   
/*      */   public final void a(String paramString) {
/* 1035 */     this.v = paramString;
/*      */   }
/*      */   
/*      */   public final void n(int paramInt) {
/* 1039 */     this.b = paramInt;
/*      */   }
/*      */   
/*      */   public final int am() {
/* 1043 */     return this.b;
/*      */   }
/*      */   
/*      */   public final void o(int paramInt) {
/* 1047 */     this.c = paramInt;
/*      */   }
/*      */   
/*      */   public final int an() {
/* 1051 */     return this.c;
/*      */   }
/*      */   
/*      */   public final void p(int paramInt) {
/* 1055 */     this.o = paramInt;
/*      */   }
/*      */   
/*      */   public final int ao() {
/* 1059 */     return this.o;
/*      */   }
/*      */   
/*      */   public final void q(int paramInt) {
/* 1063 */     this.n = paramInt;
/*      */   }
/*      */   
/*      */   public final int ap() {
/* 1067 */     return this.n;
/*      */   }
/*      */   
/*      */   public final void r(int paramInt) {
/* 1071 */     this.g = paramInt;
/*      */   }
/*      */   
/*      */   public final int aq() {
/* 1075 */     return this.g;
/*      */   }
/*      */   
/*      */   public final void s(int paramInt) {
/* 1079 */     this.h = paramInt;
/*      */   }
/*      */   
/*      */   public final int ar() {
/* 1083 */     return this.h;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void t(int paramInt) {
/* 1090 */     this.i = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int as() {
/* 1097 */     return this.i;
/*      */   }
/*      */   
/*      */   protected final void h(d paramd, int paramInt) {
/* 1101 */     a a = b(paramd);
/* 1102 */     h h1 = o(paramd);
/* 1103 */     t((int)Math.max(0.0F, paramInt - a.x() - h1.x()));
/*      */   }
/*      */   
/*      */   protected final int q(d paramd) {
/* 1107 */     a a = b(paramd);
/* 1108 */     h h1 = o(paramd);
/* 1109 */     return (int)(as() + a.x() + h1.x());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Rectangle r(d paramd) {
/* 1116 */     h h1 = n(paramd);
/*      */     
/* 1118 */     int i = s(paramd);
/* 1119 */     int k = as() - (int)h1.t() - (int)h1.v();
/* 1120 */     int m = ab() + (int)h1.w();
/* 1121 */     int j = aa() + (int)h1.t();
/*      */     
/* 1123 */     return new Rectangle(m, j, i, k);
/*      */   }
/*      */   
/*      */   public final void u(int paramInt) {
/* 1127 */     this.f = (paramInt < 0) ? 0 : paramInt;
/*      */   }
/*      */   
/*      */   public int d_() {
/* 1131 */     return this.f;
/*      */   }
/*      */   
/*      */   public final int s(d paramd) {
/* 1135 */     a a = b(paramd);
/* 1136 */     h h1 = o(paramd);
/* 1137 */     return (int)(d_() + a.y() + h1.y());
/*      */   }
/*      */   
/*      */   public final void i(d paramd, int paramInt) {
/* 1141 */     a a = b(paramd);
/* 1142 */     h h1 = o(paramd);
/* 1143 */     u((int)(paramInt - a.y() - h1.y()));
/*      */   }
/*      */   
/*      */   public final y at() {
/* 1147 */     return this.s;
/*      */   }
/*      */   
/*      */   private void a(y paramy) {
/* 1151 */     this.s = paramy;
/*      */   }
/*      */   
/*      */   public final boolean au() {
/* 1155 */     return this.w;
/*      */   }
/*      */   
/*      */   public final void i(boolean paramBoolean) {
/* 1159 */     this.w = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final g av() {
/*      */     g g;
/* 1165 */     (g = new g()).c(ar());
/* 1166 */     g.d(aq());
/* 1167 */     g.a(d_());
/* 1168 */     g.b(as());
/*      */     
/* 1170 */     return g;
/*      */   }
/*      */   
/*      */   public final void a(g paramg) {
/* 1174 */     s(paramg.c());
/* 1175 */     r(paramg.d());
/* 1176 */     u(paramg.a());
/* 1177 */     t(paramg.b());
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
/*      */   public final boolean aw() {
/* 1229 */     f f1 = this;
/*      */     
/*      */     f f2;
/* 1232 */     while ((f2 = f1.U()) != null)
/*      */     {
/*      */       
/* 1235 */       f1 = f2;
/*      */     }
/*      */ 
/*      */     
/* 1239 */     return f1.ah();
/*      */   }
/*      */   
/*      */   public void a(v paramv, j paramj) {
/* 1243 */     paramj.a(paramv, aa());
/* 1244 */     for (Iterator<f> iterator = X().iterator(); iterator.hasNext();) {
/* 1245 */       (f1 = iterator.next()).a(paramv, paramj);
/*      */     }
/* 1247 */     paramj.b(paramv, aa() + as());
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
/*      */   protected boolean b() {
/* 1272 */     return false;
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
/*      */   protected boolean ax() {
/* 1294 */     return false;
/*      */   }
/*      */   
/*      */   public abstract void B();
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */