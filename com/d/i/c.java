/*      */ package com.d.i;
/*      */ 
/*      */ import com.d.c.d.g;
/*      */ import com.d.c.d.h;
/*      */ import com.d.c.f.a.h;
/*      */ import com.d.c.f.d;
/*      */ import com.d.c.f.g;
/*      */ import com.d.d.n;
/*      */ import com.d.e.ac;
/*      */ import com.d.e.i;
/*      */ import com.d.e.l;
/*      */ import com.d.e.n;
/*      */ import com.d.e.q;
/*      */ import com.d.e.s;
/*      */ import com.d.e.v;
/*      */ import com.d.e.y;
/*      */ import com.d.e.z;
/*      */ import com.d.f.i;
/*      */ import com.d.m.i;
/*      */ import java.awt.Point;
/*      */ import java.awt.Rectangle;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   extends f
/*      */   implements s
/*      */ {
/*      */   private x a;
/*      */   private int b;
/*      */   private z c;
/*      */   private f d;
/*      */   private boolean e;
/*      */   private n f;
/*      */   private int g;
/*      */   private List<ac> h;
/*      */   private boolean i;
/*      */   private boolean j;
/*      */   private b k;
/*      */   private int l;
/*      */   private int m;
/*      */   private boolean n;
/*      */   private boolean o;
/*      */   private boolean p;
/*      */   private com.d.c.c.a q;
/*      */   private com.d.c.c.a r;
/*      */   private n s;
/*      */   private int t;
/*      */   private boolean u;
/*      */   private boolean v;
/*      */   
/*      */   public final void a(Element paramElement) {
/*  118 */     super.a(paramElement);
/*  119 */     this.v = i.a().a().t().a(paramElement);
/*      */   }
/*      */   
/*      */   public c c() {
/*      */     c c1;
/*  124 */     (c1 = new c()).a(a());
/*  125 */     c1.a(ai());
/*      */     
/*  127 */     return c1;
/*      */   }
/*      */   
/*      */   protected String a_() {
/*  131 */     return "";
/*      */   }
/*      */   
/*      */   public String toString() {
/*  135 */     StringBuilder stringBuilder = new StringBuilder();
/*  136 */     String str = getClass().getName();
/*  137 */     stringBuilder.append(str.substring(str.lastIndexOf('.') + 1));
/*  138 */     stringBuilder.append(": ");
/*  139 */     if (ai() != null && !au()) {
/*  140 */       stringBuilder.append("<");
/*  141 */       stringBuilder.append(ai().getNodeName());
/*  142 */       stringBuilder.append("> ");
/*      */     } 
/*  144 */     if (au()) {
/*  145 */       stringBuilder.append("(anonymous) ");
/*      */     }
/*  147 */     if (al() != null) {
/*  148 */       stringBuilder.append(':');
/*  149 */       stringBuilder.append(al());
/*  150 */       stringBuilder.append(' ');
/*      */     } 
/*  152 */     stringBuilder.append('(');
/*  153 */     stringBuilder.append(a().e(com.d.c.a.a.G).toString());
/*  154 */     stringBuilder.append(") ");
/*      */     
/*  156 */     if (a().P()) {
/*  157 */       stringBuilder.append("(running) ");
/*      */     }
/*      */     
/*  160 */     stringBuilder.append('(');
/*  161 */     switch (F()) {
/*      */       case 2:
/*  163 */         stringBuilder.append('B');
/*      */         break;
/*      */       case 1:
/*  166 */         stringBuilder.append('I');
/*      */         break;
/*      */       case 4:
/*  169 */         stringBuilder.append('E');
/*      */         break;
/*      */     } 
/*  172 */     stringBuilder.append(") ");
/*      */     
/*  174 */     stringBuilder.append(a_());
/*      */     
/*  176 */     a(stringBuilder);
/*  177 */     stringBuilder.append("(" + ab() + "," + aa() + ")->(" + Q() + " x " + as() + ")");
/*  178 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private void a(StringBuilder paramStringBuilder) {
/*  182 */     if (a().F()) {
/*  183 */       paramStringBuilder.append("(relative) ");
/*      */     }
/*  185 */     if (a().B()) {
/*  186 */       paramStringBuilder.append("(fixed) ");
/*      */     }
/*  188 */     if (a().A()) {
/*  189 */       paramStringBuilder.append("(absolute) ");
/*      */     }
/*  191 */     if (a().C()) {
/*  192 */       paramStringBuilder.append("(floated) ");
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
/*      */   public final boolean u() {
/*  246 */     return a().X();
/*      */   }
/*      */   
/*      */   public final void f(ab paramab) {
/*  250 */     if (!a().a(paramab, this)) {
/*      */       return;
/*      */     }
/*      */     
/*  254 */     if (u()) {
/*  255 */       v.a(paramab, this);
/*      */     }
/*      */   }
/*      */   
/*      */   public Rectangle g(d paramd) {
/*  260 */     Rectangle rectangle = super.g(paramd);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  265 */     if (a().X()) {
/*  266 */       int i = rectangle.x;
/*  267 */       rectangle.x = 0;
/*  268 */       rectangle.width += i;
/*      */     } 
/*      */     
/*  271 */     return rectangle;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(ab paramab) {
/*  276 */     if (!a().a(paramab, this)) {
/*      */       return;
/*      */     }
/*      */     
/*  280 */     af().a(paramab, this);
/*      */   }
/*      */   
/*      */   public final boolean v() {
/*      */     f f1;
/*  285 */     if (f1 = U() instanceof u || f1 instanceof r) return true;  return false;
/*      */   }
/*      */   
/*      */   private u f() {
/*  289 */     if (!v()) {
/*  290 */       return null;
/*      */     }
/*  292 */     f f1 = U();
/*  293 */     while (!(f1 instanceof u)) {
/*  294 */       f1 = f1.U();
/*      */     }
/*  296 */     return (u)f1;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void g(ab paramab) {
/*  301 */     paramab.p().a(paramab, this, (g)h.b);
/*      */   }
/*      */   
/*      */   public final x w() {
/*  305 */     return this.a;
/*      */   }
/*      */   
/*      */   private void a(x paramx) {
/*  309 */     this.a = paramx;
/*      */   }
/*      */   
/*      */   private void f(v paramv) {
/*  313 */     if (w() != null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  318 */     ac ac = q.a(paramv, this);
/*      */     
/*  320 */     boolean bool = false;
/*      */     
/*      */     x x1;
/*  323 */     (x1 = new x()).a(ac);
/*      */     
/*      */     com.d.c.f.c c1;
/*  326 */     com.d.c.a.c c2 = (c1 = a()).e(com.d.c.a.a.U);
/*      */     
/*      */     String str;
/*  329 */     if (!(str = c1.f(com.d.c.a.a.W)).equals("none")) {
/*  330 */       x1.a(a(paramv, ac, str));
/*  331 */       bool = (x1.c() != null) ? true : false;
/*      */     } 
/*      */     
/*  334 */     if (c2 != com.d.c.a.c.ap && !bool) {
/*  335 */       if (c2 == com.d.c.a.c.o || c2 == com.d.c.a.c.aR || c2 == com.d.c.a.c.x) {
/*      */         
/*  337 */         x1.a(a(ac));
/*      */       } else {
/*  339 */         x1.a(b(paramv, c2));
/*      */       } 
/*      */     }
/*      */     
/*  343 */     a(x1);
/*      */   }
/*      */   
/*      */   private static x.a a(ac paramac) {
/*  347 */     int i = (int)((paramac.a() + paramac.c()) / 3.0F);
/*      */     
/*      */     x.a a1;
/*  350 */     (a1 = new x.a()).a(i);
/*  351 */     a1.b(i * 3);
/*      */     
/*  353 */     return a1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static x.b a(v paramv, ac paramac, String paramString) {
/*      */     com.d.d.c c1;
/*  360 */     if (!paramString.equals("none") && (
/*      */       
/*  362 */       c1 = paramv.q().b(paramString).d()) != null) {
/*  363 */       paramac = paramac;
/*  364 */       if (c1.b() > paramac.a()) {
/*  365 */         c1.a(-1, (int)paramac.a());
/*      */       }
/*      */       x.b b1;
/*  368 */       (b1 = new x.b()).a(c1);
/*  369 */       b1.a(c1.a() << 1);
/*  370 */       return b1;
/*      */     } 
/*      */     
/*  373 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private x.c b(v paramv, com.d.c.a.c paramc) {
/*  379 */     int j = g();
/*  380 */     String str = l.a(paramc, j);
/*      */     
/*  382 */     str = str + ".  ";
/*      */     
/*  384 */     paramv
/*  385 */       .w();
/*  386 */     int i = paramv.d().a(a().d((d)paramv), str);
/*      */     
/*      */     x.c c1;
/*      */     
/*  390 */     (c1 = new x.c()).a(str);
/*  391 */     c1.a(i);
/*      */     
/*  393 */     return c1;
/*      */   }
/*      */   
/*      */   private int g() {
/*  397 */     return this.b;
/*      */   }
/*      */   
/*      */   public final void f(int paramInt) {
/*  401 */     this.b = paramInt;
/*      */   }
/*      */   
/*      */   public final z x() {
/*  405 */     return this.c;
/*      */   }
/*      */   
/*      */   public final void a(z paramz) {
/*  409 */     this.c = paramz;
/*      */   }
/*      */   
/*      */   public final f y() {
/*  413 */     return this.d;
/*      */   }
/*      */   
/*      */   public final void a(f paramf) {
/*  417 */     this.d = paramf;
/*      */   }
/*      */   
/*      */   public final boolean z() {
/*  421 */     return this.v;
/*      */   }
/*      */   
/*      */   public final boolean A() {
/*  425 */     return (this.f != null);
/*      */   }
/*      */   
/*      */   public final void B() {
/*      */     n n1;
/*  430 */     if (K() && (
/*      */       
/*  432 */       n1 = this.s.b()) != null) {
/*  433 */       Point point1 = n1.b(this);
/*  434 */       m(n1.b().ab() + am() - point1.x);
/*  435 */       l(n1.b().aa() + an() - point1.y);
/*      */     } 
/*      */     
/*      */     f f1;
/*      */     
/*  440 */     if ((f1 = f()) == null) {
/*      */       f f2;
/*  442 */       if ((f2 = U()) != null) {
/*  443 */         m(f2.ab() + f2.ap() + am());
/*  444 */         l(f2.aa() + f2.ao() + an());
/*  445 */       } else if (ac() && a().ai() && (
/*      */         
/*  447 */         f1 = Y()) != null) {
/*  448 */         m(f1.ab() + am());
/*  449 */         l(f1.aa() + an());
/*      */       } 
/*      */     } else {
/*      */       
/*  453 */       m(f1.ab() + am());
/*  454 */       l(f1.aa() + an());
/*      */     } 
/*      */     Point point;
/*  457 */     if (A() && (
/*      */       
/*  459 */       (point = E().c()).x != ab() || point.y != aa())) {
/*  460 */       E().a(ab(), aa());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final void h(v paramv) {
/*  466 */     Point point = paramv.l().a();
/*  467 */     n n1 = paramv.l().b();
/*  468 */     m(n1.b().ab() + am() - point.x);
/*  469 */     l(n1.b().aa() + an() - point.y);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void C() {
/*  474 */     super.C();
/*      */     
/*  476 */     if (this.c != null) {
/*  477 */       this.c.a().a();
/*      */     }
/*      */   }
/*      */   
/*      */   public final boolean D() {
/*  482 */     return this.e;
/*      */   }
/*      */   
/*      */   public final void e(boolean paramBoolean) {
/*  486 */     this.e = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   private void j() {
/*  491 */     if (this.d.aa() != aa()) {
/*  492 */       o(this.d.aa() - aa());
/*  493 */       l(this.d.aa());
/*      */     } 
/*      */   }
/*      */   public final void b(d paramd, int paramInt) {
/*      */     Rectangle rectangle;
/*  498 */     com.d.c.f.c c1 = a();
/*      */ 
/*      */ 
/*      */     
/*  502 */     int i = (Y().c(0, 0, paramd)).height;
/*      */     
/*  504 */     if (Y() instanceof c) {
/*  505 */       rectangle = Y().b(0, 0, paramd);
/*      */     } else {
/*  507 */       rectangle = Y().c(0, 0, paramd);
/*      */     } 
/*      */     
/*  510 */     if ((paramInt & 0x2) != 0) {
/*  511 */       n(0);
/*  512 */       if (!c1.a(com.d.c.a.a.S, com.d.c.a.c.e)) {
/*  513 */         n((int)c1.b(com.d.c.a.a.S, Y().d_(), paramd));
/*  514 */       } else if (!c1.a(com.d.c.a.a.aj, com.d.c.a.c.e)) {
/*  515 */         n(rectangle.width - 
/*  516 */             (int)c1.b(com.d.c.a.a.aj, Y().d_(), paramd) - Q());
/*      */       } 
/*  518 */       n(am() + rectangle.x);
/*      */     } 
/*      */     
/*  521 */     if ((paramInt & 0x1) != 0) {
/*  522 */       o(0);
/*  523 */       if (!c1.a(com.d.c.a.a.ar, com.d.c.a.c.e)) {
/*  524 */         o((int)c1.c(com.d.c.a.a.ar, i, paramd));
/*  525 */       } else if (!c1.a(com.d.c.a.a.x, com.d.c.a.c.e)) {
/*  526 */         o(rectangle.height - 
/*  527 */             (int)c1.b(com.d.c.a.a.x, i, paramd) - as());
/*      */       } 
/*      */ 
/*      */       
/*      */       int j;
/*      */       
/*  533 */       if ((j = e(paramd)) != -1 && h(paramd) == -1) {
/*  534 */         t(j);
/*  535 */         t(paramd);
/*      */       } 
/*      */       
/*  538 */       o(an() + rectangle.y);
/*      */     } 
/*      */     
/*  541 */     B();
/*      */     
/*  543 */     if ((paramInt & 0x1) != 0 && 
/*  544 */       a().V() && a().W()) {
/*  545 */       j();
/*      */     }
/*      */     
/*  548 */     C();
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
/*      */   public final boolean i(v paramv) {
/*  563 */     float f1 = a().h((d)paramv);
/*      */     aa aa;
/*  565 */     if ((aa = paramv.p().a((d)paramv, this)) != null && aa() + f1 > aa.a()) return true;  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void j(v paramv) {
/*  570 */     if (paramv.r() && (
/*  571 */       a().ab() || D() || i(paramv))) {
/*  572 */       a(paramv, a().e(com.d.c.a.a.af), false);
/*  573 */       B();
/*  574 */       C();
/*      */       
/*  576 */       e(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final n E() {
/*  581 */     return this.f;
/*      */   }
/*      */   
/*      */   private void a(n paramn) {
/*  585 */     this.f = paramn;
/*      */   }
/*      */ 
/*      */   
/*      */   public void c(v paramv) {
/*  590 */     super.c(paramv);
/*  591 */     a(false);
/*  592 */     b(false);
/*  593 */     g(false);
/*  594 */     f(false);
/*  595 */     b(0);
/*  596 */     if (A()) {
/*  597 */       E().a(paramv);
/*  598 */       a((n)null);
/*      */     } 
/*  600 */     if (F() == 1) {
/*  601 */       R();
/*      */     }
/*      */     
/*  604 */     if (K()) {
/*  605 */       this.s.b().a(this);
/*  606 */       this.s.a().a(this);
/*      */     } 
/*      */     
/*  609 */     if (a().P()) {
/*  610 */       paramv.p().d(this);
/*      */     }
/*      */   }
/*      */   
/*      */   private int c(d paramd) {
/*  615 */     if (!a().a(com.d.c.a.a.S, com.d.c.a.c.e) && 
/*  616 */       !a().a(com.d.c.a.a.aj, com.d.c.a.c.e)) {
/*  617 */       Rectangle rectangle = Y().b(0, 0, paramd);
/*      */       
/*  619 */       int j = (int)a().a(com.d.c.a.a.S, rectangle.width, paramd);
/*      */       
/*  621 */       int i = (int)a().a(com.d.c.a.a.aj, rectangle.width, paramd);
/*      */ 
/*      */ 
/*      */       
/*  625 */       return ((i = rectangle.width - j - i - ar() - aq()) < 0) ? 0 : i;
/*      */     } 
/*      */     
/*  628 */     return -1;
/*      */   }
/*      */   
/*      */   private int e(d paramd) {
/*  632 */     if (!a().a(com.d.c.a.a.ar, com.d.c.a.c.e) && 
/*  633 */       !a().a(com.d.c.a.a.x, com.d.c.a.c.e)) {
/*  634 */       Rectangle rectangle = Y().b(0, 0, paramd);
/*      */       
/*  636 */       int j = (int)a().a(com.d.c.a.a.ar, rectangle.height, paramd);
/*      */       
/*  638 */       int i = (int)a().a(com.d.c.a.a.x, rectangle.height, paramd);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  643 */       return ((i = rectangle.height - j - i) < 0) ? 0 : i;
/*      */     } 
/*      */     
/*  646 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void a(v paramv, int paramInt, h paramh, com.d.c.f.a.a parama) {
/*  656 */     if ((paramInt = (int)parama.w() + (int)paramh.w() + paramInt + (int)paramh.u() + (int)parama.u()) < aj()) {
/*  657 */       paramInt = aj() - paramInt;
/*      */       
/*  659 */       boolean bool1 = a().K();
/*  660 */       boolean bool2 = a().L();
/*      */       
/*  662 */       if (bool1 && bool2) {
/*  663 */         e((d)paramv, paramInt / 2);
/*  664 */         f((d)paramv, paramInt / 2); return;
/*  665 */       }  if (bool1) {
/*  666 */         e((d)paramv, paramInt); return;
/*  667 */       }  if (bool2) {
/*  668 */         f((d)paramv, paramInt);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private int g(v paramv) {
/*  674 */     int i = 0;
/*  675 */     int j = 0;
/*      */     
/*  677 */     boolean bool = true;
/*      */     
/*  679 */     c c1 = this;
/*      */     while (true) {
/*      */       com.d.c.f.c c2;
/*  682 */       if ((c2 = c1.a()).H() && !c2.ay()) {
/*  683 */         i += c1.ar();
/*  684 */         j += c1.aq();
/*      */       } else {
/*  686 */         bool = false;
/*      */         
/*      */         break;
/*      */       } 
/*  690 */       if (!c1.Y().ax()) {
/*      */ 
/*      */         
/*  693 */         f f1 = c1.Y(); continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  697 */     if (bool) {
/*      */       aa aa;
/*  699 */       return (aa = paramv.p().a((d)paramv, this)).d((d)paramv) - i - j;
/*      */     } 
/*  701 */     return aj() - ar() - aq();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void v(v paramv) {
/*      */     n n1;
/*  711 */     if ((n1 = E()) == null) {
/*  712 */       int i = a((d)paramv);
/*  713 */       int j = h((d)paramv);
/*      */ 
/*      */ 
/*      */       
/*  717 */       int k = u((d)paramv);
/*  718 */       int m = w((d)paramv);
/*      */       
/*  720 */       if (k > i && k > 0)
/*      */       {
/*  722 */         i = k;
/*      */       }
/*      */       
/*  725 */       if (m > j && m > 0)
/*      */       {
/*  727 */         j = m;
/*      */       }
/*      */ 
/*      */       
/*      */       n n2;
/*      */       
/*  733 */       if ((n2 = paramv.v().a(paramv, this, paramv.q(), i, j)) != null) {
/*  734 */         a(n2);
/*  735 */         a(paramv, n2);
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
/*      */   private void a(v paramv, n paramn) {
/*  747 */     int i, i2, k = a((d)paramv);
/*  748 */     int m = h((d)paramv);
/*      */     
/*  750 */     boolean bool = (k >= 0 && m >= 0) ? true : false;
/*      */     
/*  752 */     int i1 = paramn.a();
/*  753 */     int j = paramn.b();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  759 */     k = ((k = (!a().aj() && (i1 > v((d)paramv) || k > v((d)paramv))) ? v((d)paramv) : k) >= 0 && u((d)paramv) > 0 && k < u((d)paramv)) ? u((d)paramv) : k;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  765 */     m = ((m = (!a().ak() && (j > x((d)paramv) || m > x((d)paramv))) ? x((d)paramv) : m) >= 0 && w((d)paramv) > 0 && m < w((d)paramv)) ? w((d)paramv) : m;
/*      */     
/*  767 */     if (a().aC()) {
/*  768 */       com.d.c.f.a.a a1 = b((d)paramv);
/*  769 */       h h = o((d)paramv);
/*  770 */       k = (k < 0) ? k : (int)Math.max(0.0F, k - a1.y() - h.y());
/*  771 */       m = (m < 0) ? m : (int)Math.max(0.0F, m - a1.x() - h.x());
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  777 */     if (k > 0 && m > 0) {
/*  778 */       if (bool) {
/*      */         
/*  780 */         i2 = k;
/*  781 */         i = m;
/*  782 */       } else if (i1 > k || j > m) {
/*      */         
/*  784 */         double d1 = i1 / k;
/*  785 */         double d2 = j / m;
/*      */         
/*  787 */         if (d1 > d2) {
/*  788 */           i2 = k;
/*  789 */           i = j;
/*      */         } else {
/*  791 */           i2 = i1;
/*  792 */           i = m;
/*      */         } 
/*      */       } else {
/*      */         
/*  796 */         double d1 = i1 / k;
/*  797 */         double d2 = j / m;
/*      */         
/*  799 */         if (d1 > d2) {
/*  800 */           i2 = k;
/*  801 */           i = (int)(j / d1);
/*      */         } else {
/*  803 */           i2 = (int)(i1 / d2);
/*  804 */           i = m;
/*      */         } 
/*      */       } 
/*  807 */     } else if (k > 0) {
/*      */       
/*  809 */       i2 = k;
/*  810 */       i = (int)(k / i1 * j);
/*  811 */     } else if (m > 0) {
/*      */       
/*  813 */       i = m;
/*  814 */       i2 = (int)(m / j * i1);
/*  815 */     } else if (k == 0 || m == 0) {
/*      */       
/*  817 */       i2 = k;
/*  818 */       i = m;
/*      */     } else {
/*      */       
/*  821 */       i2 = i1;
/*  822 */       i = j;
/*      */     } 
/*      */     
/*  825 */     u(i2);
/*  826 */     t(i);
/*      */   }
/*      */   
/*      */   public final void k(v paramv) {
/*  830 */     d(paramv, a((d)paramv));
/*      */   }
/*      */   
/*      */   protected final void d(v paramv, int paramInt) {
/*  834 */     if (!s()) {
/*  835 */       com.d.c.f.c c1 = a();
/*      */       
/*  837 */       h h1 = o((d)paramv);
/*  838 */       com.d.c.f.a.a a1 = b((d)paramv);
/*      */       
/*  840 */       if (paramInt != -1 && !au() && (
/*  841 */         a().a(com.d.c.a.a.aV, com.d.c.a.c.e) || 
/*  842 */         a().a(com.d.c.a.a.aT, com.d.c.a.c.e)) && 
/*  843 */         a().z()) {
/*  844 */         a(paramv, paramInt, h1, a1);
/*      */       }
/*      */       
/*  847 */       H(paramv);
/*  848 */       h h2 = n((d)paramv);
/*      */ 
/*      */       
/*  851 */       s((int)h2.w() + (int)a1.w() + (int)h1.w());
/*  852 */       r((int)h1.u() + (int)a1.u() + (int)h2.u());
/*      */       
/*  854 */       v(paramv);
/*  855 */       if (A()) {
/*  856 */         g(true);
/*      */         
/*      */         return;
/*      */       } 
/*  860 */       if (paramv.r() && a().aw()) {
/*  861 */         u(g(paramv));
/*      */       } else {
/*  863 */         u(aj() - ar() - aq());
/*      */       } 
/*      */       
/*  866 */       t(0);
/*      */       
/*  868 */       if (!au() || (aA() && K())) {
/*  869 */         int i = -1;
/*      */         
/*  871 */         if (paramInt != -1) {
/*  872 */           if (c1.aC()) {
/*  873 */             i((d)paramv, paramInt);
/*      */           } else {
/*  875 */             u(paramInt);
/*      */           } 
/*  877 */         } else if ((a().A() || a().B()) && (
/*      */           
/*  879 */           i = c((d)paramv)) != -1) {
/*  880 */           u(i);
/*      */         } 
/*      */         
/*      */         int j;
/*      */         
/*  885 */         if ((j = h((d)paramv)) != -1) {
/*  886 */           if (c1.aC()) {
/*  887 */             h((d)paramv, j);
/*      */           } else {
/*  889 */             t(j);
/*      */           } 
/*      */         }
/*      */         
/*      */         n n1;
/*      */         
/*  895 */         if ((n1 = E()) == null)
/*      */         {
/*  897 */           if (paramInt == -1 && i == -1 && c1
/*  898 */             .ay()) {
/*  899 */             c(true);
/*      */           }
/*      */         }
/*  902 */         if (!A()) {
/*  903 */           f((d)paramv);
/*      */         }
/*      */       } 
/*      */       
/*  907 */       g(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void w(v paramv) {
/*  912 */     if (a().m() && !a().C()) {
/*  913 */       paramv.a(0, -an());
/*  914 */       paramv.l().a(paramv, this);
/*  915 */       paramv.a(0, an());
/*  916 */       B();
/*      */     } 
/*      */   }
/*      */   private void x(v paramv) {
/*      */     aa aa;
/*  921 */     if (paramv.D() && paramv
/*  922 */       .A() > 0 && (a().x() || a().X()) && (
/*      */       
/*  924 */       aa = paramv.p().a((d)paramv, this)) != null && aa.b() + paramv.A() > aa()) {
/*  925 */       int i = aa.b() + paramv.A() - aa();
/*  926 */       o(an() + i);
/*  927 */       paramv.a(0, i);
/*  928 */       B();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void y(v paramv) {
/*  934 */     if (!au()) {
/*      */       String str;
/*  936 */       if ((str = paramv.e().g(ai())) != null) {
/*  937 */         paramv.a(str, this);
/*      */       }
/*      */       
/*  940 */       if ((str = paramv.e().b(ai())) != null) {
/*  941 */         paramv.a(str, this);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(v paramv) {
/*  947 */     a_(paramv, 0);
/*      */   }
/*      */   
/*      */   public void a_(v paramv, int paramInt) {
/*  951 */     com.d.c.f.c c1 = a();
/*  952 */     boolean bool1 = false;
/*      */     
/*  954 */     if (ah()) {
/*  955 */       bool1 = true;
/*  956 */       paramv.a(this);
/*      */       
/*  958 */       if (paramv.r()) {
/*  959 */         if (!c1.a(com.d.c.a.a.ad, com.d.c.a.c.e)) {
/*  960 */           paramv.b(c1.f(com.d.c.a.a.ad));
/*      */         }
/*  962 */         paramv.p().b((d)paramv);
/*      */       } 
/*  964 */     } else if (c1.O() && Z() == null) {
/*  965 */       bool1 = true;
/*  966 */       paramv.a(this);
/*  967 */     } else if (c1.O()) {
/*      */ 
/*      */ 
/*      */       
/*  971 */       Z().a(true);
/*  972 */       bool1 = true;
/*  973 */       paramv.a(this);
/*      */     } 
/*      */     
/*  976 */     if (c1.n()) {
/*  977 */       paramv.p();
/*      */     }
/*      */     
/*  980 */     w(paramv);
/*      */     
/*  982 */     if (ah() || a().N() || b()) {
/*  983 */       com.d.e.b b1 = new com.d.e.b(this, paramv);
/*  984 */       paramv.a(b1);
/*      */     } 
/*      */     
/*  987 */     y(paramv);
/*      */     
/*  989 */     if (paramv.r() && a().a(com.d.c.a.a.r, com.d.c.a.c.bH)) {
/*  990 */       paramv.p().e(this);
/*      */     }
/*      */     
/*  993 */     v(paramv);
/*  994 */     k(paramv);
/*  995 */     z(paramv);
/*  996 */     B(paramv);
/*      */     
/*  998 */     x(paramv);
/*      */     aa aa;
/* 1000 */     if (paramv.r() && (
/*      */       
/* 1002 */       aa = paramv.p().a((d)paramv, this)) != null && aa.b() == aa() - l()) {
/* 1003 */       p((d)paramv);
/*      */     }
/*      */ 
/*      */     
/* 1007 */     com.d.c.f.a.a a1 = b((d)paramv);
/* 1008 */     h h1 = n((d)paramv);
/* 1009 */     h h2 = o((d)paramv);
/*      */ 
/*      */     
/* 1012 */     int i = as();
/*      */     
/* 1014 */     if (!A()) {
/* 1015 */       t(0);
/*      */     }
/*      */     
/* 1018 */     boolean bool2 = false;
/* 1019 */     if (a().X()) {
/* 1020 */       f(paramv);
/* 1021 */       paramv.a(w());
/* 1022 */       bool2 = true;
/*      */     } 
/*      */ 
/*      */     
/* 1026 */     int j = (int)h1.w() + (int)a1.w() + (int)h2.w();
/* 1027 */     int k = (int)h1.t() + (int)a1.t() + (int)h2.t();
/* 1028 */     q(j);
/* 1029 */     p(k);
/* 1030 */     paramv.a(ap(), ao());
/* 1031 */     if (!A()) {
/* 1032 */       a(paramv, paramInt);
/*      */     }
/*      */ 
/*      */     
/* 1036 */     paramv.a(-ap(), -ao());
/*      */     
/* 1038 */     b(as());
/*      */     
/* 1040 */     if (!A()) {
/* 1041 */       if (!b_() && ((
/*      */         
/* 1043 */         paramInt = i - as()) > 0 || h())) {
/* 1044 */         t(i);
/*      */       }
/*      */ 
/*      */       
/* 1048 */       t((d)paramv);
/*      */     } 
/*      */     
/* 1051 */     if ((ah() || a().N()) && 
/* 1052 */       a().J())
/*      */     {
/*      */ 
/*      */       
/* 1056 */       if ((paramInt = paramv.l().b().a((d)paramv, ao() + as())) > 0) {
/* 1057 */         t(as() + paramInt);
/* 1058 */         b(M() + paramInt);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1063 */     if (bool2) {
/* 1064 */       paramv.a(null);
/*      */     }
/*      */     
/* 1067 */     a(paramv, a1, h1, h2);
/*      */     
/* 1069 */     if (ah() || a().N()) {
/* 1070 */       paramv.m();
/*      */     }
/*      */     
/* 1073 */     if (bool1) {
/* 1074 */       paramv.n();
/*      */     }
/*      */   }
/*      */   
/*      */   protected boolean h() {
/* 1079 */     return true;
/*      */   }
/*      */   
/*      */   protected int l() {
/* 1083 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void a(v paramv, com.d.c.f.a.a parama, h paramh1, h paramh2) {
/* 1093 */     t(as() + (int)paramh1.t() + (int)parama.t() + (int)paramh2.t() + 
/* 1094 */         (int)paramh2.v() + (int)parama.v() + (int)paramh1.v());
/* 1095 */     b(M() + (int)paramh1.t() + (int)parama.t() + (int)paramh2.t() + 
/* 1096 */         (int)paramh2.v() + (int)parama.v() + (int)paramh1.v());
/*      */   }
/*      */ 
/*      */   
/*      */   private void z(v paramv) {
/* 1101 */     if (t()) {
/* 1102 */       u(F(paramv) - ar() - aq());
/* 1103 */       f((d)paramv);
/* 1104 */       c(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void f(d paramd) {
/* 1109 */     int i = a().aC() ? s(paramd) : d_();
/*      */     
/* 1111 */     if (!a().aj()) {
/* 1112 */       int k = v(paramd);
/* 1113 */       if (i > k) {
/* 1114 */         if (a().aC()) {
/* 1115 */           i(paramd, k);
/*      */         } else {
/* 1117 */           u(k);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*      */     int j;
/* 1123 */     if ((j = u(paramd)) > 0 && i < j) {
/* 1124 */       if (a().aC()) {
/* 1125 */         i(paramd, j); return;
/*      */       } 
/* 1127 */       u(j);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void t(d paramd) {
/* 1133 */     int i = a().aC() ? q(paramd) : as();
/*      */     
/* 1135 */     if (!a().ak()) {
/* 1136 */       int k = x(paramd);
/* 1137 */       if (i > k) {
/* 1138 */         if (a().aC()) {
/* 1139 */           h(paramd, k);
/*      */         } else {
/* 1141 */           t(k);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*      */     int j;
/* 1147 */     if ((j = w(paramd)) > 0 && i < j) {
/* 1148 */       if (a().aC()) {
/* 1149 */         h(paramd, j); return;
/*      */       } 
/* 1151 */       t(j);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void l(v paramv) {
/* 1157 */     if (F() == 0) {
/* 1158 */       com.d.e.c.a(paramv, this);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected void a(v paramv, int paramInt) {
/* 1164 */     l(paramv);
/*      */     
/* 1166 */     if (q() != null) {
/* 1167 */       paramv.t().a(q());
/*      */     }
/* 1169 */     if (r() != null) {
/* 1170 */       paramv.s().a(r());
/*      */     }
/*      */     
/* 1173 */     switch (F()) {
/*      */       case 1:
/* 1175 */         a(paramv, paramInt, m(paramv), true);
/*      */         break;
/*      */       case 2:
/* 1178 */         com.d.e.a.a(paramv, this, paramInt);
/*      */         break;
/*      */     } 
/*      */     
/* 1182 */     if (q() != null) {
/* 1183 */       paramv.t().a();
/*      */     }
/* 1185 */     if (r() != null) {
/* 1186 */       paramv.s().a();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void a(v paramv, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 1194 */     q.a(paramv, this, paramInt1, paramInt2);
/*      */     
/* 1196 */     if (paramv.r() && paramv.D() && V() > 1) {
/* 1197 */       a(paramv, paramInt1, paramBoolean);
/*      */     }
/*      */     
/* 1200 */     if (paramBoolean && a().at()) {
/* 1201 */       A(paramv);
/*      */     }
/*      */   }
/*      */   
/*      */   private void A(v paramv) {
/* 1206 */     for (Iterator<f> iterator = W(); iterator.hasNext();)
/*      */     {
/* 1208 */       (u = (u)iterator.next()).g();
/*      */     }
/*      */   }
/*      */   
/*      */   private void a(v paramv, int paramInt, boolean paramBoolean) {
/* 1213 */     u u1 = (u)k(0);
/*      */     
/*      */     aa aa;
/* 1216 */     if ((aa = paramv.p().a((d)paramv, u1)) == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1220 */     byte b1 = 0;
/* 1221 */     byte b2 = 0;
/* 1222 */     int i = V(); u u2;
/* 1223 */     while (b2 < i && (
/*      */       
/* 1225 */       u2 = (u)k(b2)).aa() < aa.a()) {
/*      */ 
/*      */       
/* 1228 */       if (!u2.f()) {
/* 1229 */         b1++;
/*      */       }
/* 1231 */       b2++;
/*      */     } 
/*      */     
/* 1234 */     if (b2 != i) {
/* 1235 */       int k = (int)a().b(com.d.c.a.a.ab);
/* 1236 */       if (b2 - b1 < k) {
/* 1237 */         e(true); return;
/*      */       } 
/* 1239 */       u u3 = (u)k(i - 1);
/*      */       List<aa> list;
/* 1241 */       aa = (list = paramv.p().k()).get(aa.i() + 1);
/* 1242 */       while (aa.i() != list.size() - 1 && aa
/* 1243 */         .a() < u3.aa()) {
/* 1244 */         aa = list.get(aa.i() + 1);
/*      */       }
/*      */       
/* 1247 */       byte b3 = 0;
/* 1248 */       int j = i - 1; u u4;
/* 1249 */       while (j >= 0 && k(j).aa() >= aa.b() && (
/*      */         
/* 1251 */         u4 = (u)k(j)).aa() >= aa.b()) {
/*      */ 
/*      */         
/* 1254 */         if (!u4.f()) {
/* 1255 */           b3++;
/*      */         }
/* 1257 */         j--;
/*      */       } 
/*      */       
/* 1260 */       int m = (int)a().b(com.d.c.a.a.aw);
/* 1261 */       if (i - 1 - j - b3 < m) {
/* 1262 */         if (i - 1 - m < k) {
/* 1263 */           e(true); return;
/* 1264 */         }  if (paramBoolean) {
/* 1265 */           int i1 = i - 1 - m;
/*      */           
/* 1267 */           t(paramv);
/* 1268 */           R();
/*      */           
/* 1270 */           a(paramv, paramInt, i1, false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final int F() {
/* 1278 */     return this.g;
/*      */   }
/*      */   
/*      */   public final void g(int paramInt) {
/* 1282 */     this.g = paramInt;
/*      */   }
/*      */   
/*      */   public final List<ac> G() {
/* 1286 */     return this.h;
/*      */   }
/*      */   
/*      */   public final void b(List<ac> paramList) {
/* 1290 */     this.h = paramList;
/* 1291 */     if (paramList != null) {
/* 1292 */       for (Iterator<ac> iterator = paramList.iterator(); iterator.hasNext();) {
/* 1293 */         if (ac = iterator.next() instanceof f) {
/* 1294 */           ((f)ac).g(this);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   protected boolean n() {
/* 1301 */     return false;
/*      */   }
/*      */   
/*      */   protected boolean k() {
/* 1305 */     return (!ah() && a().ah());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void B(v paramv) {
/* 1312 */     if (!o() || !p()) {
/* 1313 */       H(paramv);
/* 1314 */       h h = n((d)paramv);
/*      */       
/* 1316 */       if (!o() && !p() && E(paramv)) {
/*      */ 
/*      */         
/* 1319 */         b b1 = (this.k != null) ? this.k : new b();
/* 1320 */         a(paramv, b1);
/* 1321 */         a(paramv, h, b1); return;
/*      */       } 
/* 1323 */       if (!o()) {
/*      */ 
/*      */         
/* 1326 */         b b1 = (this.k != null) ? this.k : new b();
/*      */         
/* 1328 */         a(paramv, true, b1);
/* 1329 */         if ((int)h.t() != b1.a()) {
/* 1330 */           c((d)paramv, b1.a());
/*      */         }
/*      */       } 
/*      */       
/* 1334 */       if (!p()) {
/* 1335 */         b b1 = new b();
/* 1336 */         b(paramv, true, b1);
/*      */         
/* 1338 */         a(paramv, h, b1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(v paramv, h paramh, b paramb) {
/* 1345 */     c c1 = null;
/* 1346 */     if (!v()) {
/* 1347 */       c1 = a(paramb);
/*      */     }
/* 1349 */     if (c1 != null && !(c1 instanceof b) && paramb
/* 1350 */       .b()) {
/* 1351 */       c1.k = paramb;
/* 1352 */       d((d)paramv, 0); return;
/* 1353 */     }  if ((int)paramh.v() != paramb.a()) {
/* 1354 */       d((d)paramv, paramb.a());
/*      */     }
/*      */   }
/*      */   
/*      */   protected c a(b paramb) {
/* 1359 */     c c1 = (c)T();
/* 1360 */     while (c1 != null) {
/* 1361 */       if (c1 instanceof b) {
/* 1362 */         ((b)c1).a(paramb
/* 1363 */             .a());
/*      */       }
/* 1365 */       if (c1.n())
/*      */       {
/*      */         
/* 1368 */         c1 = (c)c1.T();
/*      */       }
/*      */     } 
/* 1371 */     return c1;
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(v paramv, boolean paramBoolean, b paramb) {
/* 1376 */     if (!o()) {
/* 1377 */       if (!n()) {
/* 1378 */         k(paramv);
/* 1379 */         if (paramv.r() && a().ax())
/*      */         {
/* 1381 */           g(false);
/*      */         }
/* 1383 */         h h = n((d)paramv);
/* 1384 */         paramb.a((int)h.t());
/*      */         
/* 1386 */         if (!paramBoolean && (int)h.t() != 0) {
/* 1387 */           c((d)paramv, 0);
/*      */         }
/*      */         
/* 1390 */         if (k() && C(paramv)) {
/* 1391 */           l(paramv);
/* 1392 */           if (F() == 2) {
/* 1393 */             for (Iterator<f> iterator = W(); iterator.hasNext(); ) {
/*      */               c c1;
/* 1395 */               (c1 = (c)iterator.next()).a(paramv, false, paramb);
/*      */               
/* 1397 */               if (!c1.n()) {
/*      */                 break;
/*      */               }
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1407 */       a(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void b(v paramv, boolean paramBoolean, b paramb) {
/* 1413 */     if (!p()) {
/* 1414 */       if (!n()) {
/* 1415 */         k(paramv);
/* 1416 */         if (paramv.r() && a().ax())
/*      */         {
/* 1418 */           g(false);
/*      */         }
/* 1420 */         h h = n((d)paramv);
/* 1421 */         paramb.a((int)h.v());
/*      */         
/* 1423 */         if (!paramBoolean && (int)h.v() != 0) {
/* 1424 */           d((d)paramv, 0);
/*      */         }
/*      */         
/* 1427 */         if (k() && 
/* 1428 */           !a().q() && D(paramv)) {
/* 1429 */           l(paramv);
/* 1430 */           if (F() == 2) {
/* 1431 */             for (int i = V() - 1; i >= 0; i--) {
/*      */               c c1;
/*      */               
/* 1434 */               if (!(c1 = (c)k(i)).n()) {
/*      */ 
/*      */ 
/*      */                 
/* 1438 */                 c1.b(paramv, false, paramb);
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/* 1446 */       b(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean C(v paramv) {
/* 1451 */     h h = o((d)paramv);
/* 1452 */     com.d.c.f.a.a a1 = b((d)paramv);
/*      */     
/* 1454 */     return ((int)h.t() == 0 && (int)a1.t() == 0);
/*      */   }
/*      */   
/*      */   private boolean D(v paramv) {
/* 1458 */     h h = o((d)paramv);
/* 1459 */     com.d.c.f.a.a a1 = b((d)paramv);
/*      */     
/* 1461 */     return ((int)h.v() == 0 && (int)a1.v() == 0);
/*      */   }
/*      */   
/*      */   private void a(v paramv, b paramb) {
/* 1465 */     h h = n((d)paramv);
/* 1466 */     paramb.a((int)h.t());
/* 1467 */     paramb.a((int)h.v());
/*      */     
/* 1469 */     c((d)paramv, 0);
/* 1470 */     a(true);
/* 1471 */     d((d)paramv, 0);
/* 1472 */     b(true);
/*      */     
/* 1474 */     l(paramv);
/* 1475 */     if (F() == 2) {
/* 1476 */       for (Iterator<f> iterator = W(); iterator.hasNext();)
/*      */       {
/* 1478 */         (c1 = (c)iterator.next()).a(paramv, paramb);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean E(v paramv) {
/*      */     com.d.c.f.c c1;
/* 1486 */     com.d.c.f.a.a a1 = (c1 = a()).a((d)paramv);
/* 1487 */     h h = o((d)paramv);
/*      */ 
/*      */     
/*      */     boolean bool;
/*      */ 
/*      */     
/* 1493 */     if (bool = ((int)a1.t() != 0 || (int)a1.v() != 0 || (int)h.t() != 0 || (int)h.v() != 0) ? true : false) {
/* 1494 */       return false;
/*      */     }
/*      */     
/* 1497 */     l(paramv);
/* 1498 */     if (F() == 1)
/* 1499 */       return false; 
/* 1500 */     if (F() == 2) {
/* 1501 */       for (Iterator<f> iterator = W(); iterator.hasNext();) {
/*      */         
/* 1503 */         if ((c2 = (c)iterator.next()).n() || !c2.E(paramv)) {
/* 1504 */           return false;
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/* 1509 */     if (c1.b(com.d.c.a.a.Z) == 0.0F && (
/* 1510 */       b_() || c1.b(com.d.c.a.a.R) == 0.0F)) return true; 
/*      */     return false;
/*      */   }
/*      */   private boolean o() {
/* 1514 */     return this.i;
/*      */   }
/*      */   
/*      */   private void a(boolean paramBoolean) {
/* 1518 */     this.i = paramBoolean;
/*      */   }
/*      */   
/*      */   private boolean p() {
/* 1522 */     return this.j;
/*      */   }
/*      */   
/*      */   private void b(boolean paramBoolean) {
/* 1526 */     this.j = paramBoolean;
/*      */   }
/*      */   
/*      */   protected int a(d paramd) {
/* 1530 */     return a(paramd, false);
/*      */   }
/*      */   
/*      */   private int a(d paramd, boolean paramBoolean) {
/* 1534 */     if (!au() && 
/* 1535 */       !a().H()) {
/* 1536 */       if (paramBoolean && !a().I()) {
/* 1537 */         return -1;
/*      */       }
/*      */       
/*      */       int i;
/* 1541 */       return ((i = (int)a().b(com.d.c.a.a.ax, Y().d_(), paramd)) >= 0) ? i : -1;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1546 */     return -1;
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
/*      */   protected int h(d paramd) {
/* 1563 */     if (!au() && 
/* 1564 */       !b_()) {
/* 1565 */       if (a().d(com.d.c.a.a.R)) {
/* 1566 */         return (int)a().c(com.d.c.a.a.R, 0.0F, paramd);
/*      */       }
/* 1568 */       return (int)a().c(com.d.c.a.a.R, ((c)
/*      */           
/* 1570 */           Y()).h(paramd), paramd);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1576 */     return -1;
/*      */   }
/*      */   
/*      */   public boolean b_() {
/* 1580 */     if (a().J())
/* 1581 */       return true; 
/* 1582 */     if (a().d(com.d.c.a.a.R)) {
/* 1583 */       return false;
/*      */     }
/*      */     
/*      */     f f1;
/* 1587 */     if ((f1 = Y()).ac() && f1 instanceof c)
/* 1588 */       return ((c)f1).b_(); 
/* 1589 */     return (!(f1 instanceof c) || !f1.ax());
/*      */   }
/*      */ 
/*      */   
/*      */   private int u(d paramd) {
/* 1594 */     return a().a(paramd, aj());
/*      */   }
/*      */   
/*      */   private int v(d paramd) {
/* 1598 */     return a().b(paramd, aj());
/*      */   }
/*      */   
/*      */   private int w(d paramd) {
/* 1602 */     return a().c(paramd, y(paramd));
/*      */   }
/*      */   
/*      */   private int x(d paramd) {
/* 1606 */     return a().d(paramd, y(paramd));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int y(d paramd) {
/* 1613 */     if (!Y().ac() || 
/* 1614 */       Y().a().J()) {
/* 1615 */       return 0;
/*      */     }
/* 1617 */     if (Y().a().d(com.d.c.a.a.R)) {
/* 1618 */       return (int)Y().a().a(com.d.c.a.a.R, 0.0F, paramd);
/*      */     }
/*      */     
/* 1621 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int F(v paramv) {
/* 1627 */     a(paramv);
/*      */     
/* 1629 */     return Math.min(Math.max(I(), G(paramv)), H());
/*      */   }
/*      */   
/*      */   private int G(v paramv) {
/* 1633 */     if (!a().A()) {
/* 1634 */       return aj();
/*      */     }
/* 1636 */     int i = 0;
/* 1637 */     int j = 0;
/* 1638 */     if (!a().a(com.d.c.a.a.S, com.d.c.a.c.e))
/*      */     {
/* 1640 */       i = (int)a().a(com.d.c.a.a.S, 
/* 1641 */           Y().d_(), (d)paramv);
/*      */     }
/*      */     
/* 1644 */     if (!a().a(com.d.c.a.a.aj, com.d.c.a.c.e))
/*      */     {
/* 1646 */       j = (int)a().a(com.d.c.a.a.aj, 
/* 1647 */           Y().d_(), (d)paramv);
/*      */     }
/*      */     
/* 1650 */     return Y().l((d)paramv) - i - j;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean c_() {
/* 1655 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void H(v paramv) {
/* 1660 */     if (o() && p()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*      */     g g1;
/*      */     
/* 1667 */     boolean bool1 = (g1 = a().i(com.d.c.a.a.aS) instanceof com.d.c.f.a.e && !g1.g()) ? true : false;
/*      */     
/*      */     g g2;
/* 1670 */     boolean bool2 = (g2 = a().i(com.d.c.a.a.aU) instanceof com.d.c.f.a.e && !g2.g()) ? true : false;
/*      */     
/* 1672 */     if (!bool1 && !bool2) {
/*      */       return;
/*      */     }
/*      */     
/* 1676 */     h h1 = b((d)paramv, false);
/* 1677 */     h h2 = n((d)paramv);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1683 */     if (!o() && h1
/* 1684 */       .t() != h2.t()) {
/* 1685 */       c((d)paramv, (int)h1.t());
/*      */     }
/*      */     
/* 1688 */     if (!p() && h1
/* 1689 */       .v() != h2.v()) {
/* 1690 */       d((d)paramv, (int)h1.v());
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(v paramv) {
/* 1695 */     if (!J()) {
/* 1696 */       h h1 = n((d)paramv);
/* 1697 */       com.d.c.f.a.a a1 = b((d)paramv);
/* 1698 */       h h2 = o((d)paramv);
/*      */       
/* 1700 */       int i = a((d)paramv, true);
/*      */       
/* 1702 */       v(paramv);
/* 1703 */       if (A() && i == -1)
/*      */       {
/* 1705 */         i = d_();
/*      */       }
/*      */       
/* 1708 */       if (i != -1 && !c_()) {
/* 1709 */         this
/*      */ 
/*      */           
/* 1712 */           .l = this.m = (int)h1.w() + (int)a1.w() + (int)h2.w() + i + (int)h1.u() + (int)a1.u() + (int)h2.u();
/*      */       } else {
/* 1714 */         int j = -1;
/* 1715 */         if (i != -1) {
/*      */ 
/*      */ 
/*      */           
/* 1719 */           j = d_();
/* 1720 */           u(i);
/*      */         } 
/*      */         
/* 1723 */         this
/*      */           
/* 1725 */           .l = this.m = (int)h1.w() + (int)a1.w() + (int)h2.w() + (int)h1.u() + (int)a1.u() + (int)h2.u();
/*      */         
/* 1727 */         int k = this.m;
/* 1728 */         if (i != -1) {
/* 1729 */           k += i;
/*      */         }
/*      */         
/* 1732 */         l(paramv);
/*      */         
/* 1734 */         if (F() == 2 || 
/* 1735 */           F() == 1) {
/* 1736 */           switch (F()) {
/*      */             case 2:
/* 1738 */               I(paramv);
/*      */               break;
/*      */             case 1:
/* 1741 */               J(paramv);
/*      */               break;
/*      */           } 
/*      */         
/*      */         }
/* 1746 */         if (k > this.m) {
/* 1747 */           this.m = k;
/*      */         }
/*      */         
/* 1750 */         if (j != -1) {
/* 1751 */           u(j);
/*      */         }
/*      */       } 
/*      */       
/* 1755 */       if (!A()) {
/* 1756 */         a(paramv, h1, a1, h2);
/*      */       }
/* 1758 */       f(true);
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
/*      */   private void a(v paramv, h paramh1, com.d.c.f.a.a parama, h paramh2) {
/*      */     int i;
/* 1781 */     if ((i = u((d)paramv)) > 0) {
/* 1782 */       i += 
/* 1783 */         (int)paramh1.w() + (int)parama.w() + (int)paramh2.w() + 
/* 1784 */         (int)paramh1.u() + (int)parama.u() + (int)paramh2.u();
/* 1785 */       if (this.l < i) {
/* 1786 */         this.l = i;
/*      */       }
/*      */     } 
/* 1789 */     if (!a().aj()) {
/*      */ 
/*      */ 
/*      */       
/* 1793 */       int j = (j = v((d)paramv)) + (int)paramh1.w() + (int)parama.w() + (int)paramh2.w() + (int)paramh1.u() + (int)parama.u() + (int)paramh2.u();
/* 1794 */       if (this.m > j) {
/* 1795 */         if (j > this.l) {
/* 1796 */           this.m = j; return;
/*      */         } 
/* 1798 */         this.m = this.l;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void I(v paramv) {
/* 1805 */     int i = 0;
/* 1806 */     int j = 0;
/*      */     
/* 1808 */     for (Iterator<f> iterator = W(); iterator.hasNext(); ) {
/*      */       c c1;
/* 1810 */       (c1 = (c)iterator.next()).a(paramv);
/* 1811 */       if (c1.I() > i) {
/* 1812 */         i = c1.I();
/*      */       }
/* 1814 */       if (c1.H() > j) {
/* 1815 */         j = c1.H();
/*      */       }
/*      */     } 
/*      */     
/* 1819 */     this.l += i;
/* 1820 */     this.m += j;
/*      */   }
/*      */   
/*      */   private void J(v paramv) {
/* 1824 */     int i = (int)a().b(com.d.c.a.a.ap, 
/* 1825 */         d_(), (d)paramv);
/*      */     
/* 1827 */     if (a().X() && a().au()) {
/* 1828 */       f(paramv);
/* 1829 */       i += w().e();
/*      */     } 
/*      */     
/* 1832 */     int j = 0;
/* 1833 */     int k = 0;
/* 1834 */     int m = 0;
/*      */     
/* 1836 */     ac ac = null;
/*      */     
/* 1838 */     for (Iterator<ac> iterator = this.h.iterator(); iterator.hasNext();) {
/* 1839 */       if (!(ac1 = iterator.next()).a().A() && !ac1.a().B() && !ac1.a().P()) {
/*      */ 
/*      */ 
/*      */         
/* 1843 */         if (ac1.a().C() || ac1.a().p() || ac1
/* 1844 */           .a().r()) {
/* 1845 */           if (ac1.a().C() && ac1.a().m()) {
/* 1846 */             if (ac != null) {
/* 1847 */               m -= ac.a(paramv);
/*      */             }
/* 1849 */             if (m > k) {
/* 1850 */               k = m;
/*      */             }
/* 1852 */             m = 0;
/*      */           } 
/* 1854 */           ac = null;
/*      */           
/* 1856 */           (ac1 = ac1).a(paramv);
/* 1857 */           m += ac1.H();
/* 1858 */           if (ac1.I() > j) {
/* 1859 */             j = ac1.I();
/*      */           }
/*      */           continue;
/*      */         } 
/* 1863 */         com.d.c.a.c c1 = (ac1 = ac1).a().i();
/*      */         
/* 1865 */         ac1.a(paramv, d_(), (m == 0));
/*      */         
/* 1867 */         if (c1 == com.d.c.a.c.ar) {
/* 1868 */           m += i + ac1.k();
/* 1869 */           if (ac1.l() > j) {
/* 1870 */             j = ac1.l();
/*      */           }
/* 1872 */           ac = ac1;
/* 1873 */         } else if (c1 == com.d.c.a.c.aB) {
/* 1874 */           if (ac != null) {
/* 1875 */             m -= ac.a(paramv);
/*      */           }
/* 1877 */           ac = null;
/* 1878 */           if (m > k) {
/* 1879 */             k = m;
/*      */           }
/*      */           
/* 1882 */           if ((m = i + ac1.m()) > j) {
/* 1883 */             j = m;
/*      */           }
/*      */           
/* 1886 */           if ((m = ac1.k()) > j) {
/* 1887 */             j = m;
/*      */           }
/* 1889 */           if (j > k) {
/* 1890 */             k = j;
/*      */           }
/* 1892 */           m = 0;
/* 1893 */         } else if (c1 == com.d.c.a.c.aD || c1 == com.d.c.a.c.aC) {
/* 1894 */           m += i + ac1.m();
/* 1895 */           if (ac != null) {
/* 1896 */             m -= ac.a(paramv);
/*      */           }
/* 1898 */           if (m > k) {
/* 1899 */             k = m;
/*      */           }
/*      */           
/* 1902 */           if (ac1.k() > k) {
/* 1903 */             k = ac1.k();
/*      */           }
/* 1905 */           if (ac1.l() > j) {
/* 1906 */             j = ac1.l();
/*      */           }
/* 1908 */           if (c1 == com.d.c.a.c.aC) {
/* 1909 */             ac = ac1;
/*      */           } else {
/* 1911 */             ac = null;
/*      */           } 
/* 1913 */           m = 0;
/*      */         } else {
/* 1915 */           m += i + ac1.k();
/* 1916 */           if (ac1.l() > j) {
/* 1917 */             j = i + ac1.l();
/*      */           }
/* 1919 */           ac = ac1;
/*      */         } 
/*      */         
/* 1922 */         if (i > 0) {
/* 1923 */           i = 0;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1928 */     if (ac != null) {
/* 1929 */       m -= ac.a(paramv);
/*      */     }
/* 1931 */     if (m > k) {
/* 1932 */       k = m;
/*      */     }
/*      */     
/* 1935 */     this.l += j;
/* 1936 */     this.m += k;
/*      */   }
/*      */   
/*      */   public final int H() {
/* 1940 */     return this.m;
/*      */   }
/*      */   
/*      */   protected final void h(int paramInt) {
/* 1944 */     this.m = paramInt;
/*      */   }
/*      */   
/*      */   public final int I() {
/* 1948 */     return this.l;
/*      */   }
/*      */   
/*      */   protected final void i(int paramInt) {
/* 1952 */     this.l = paramInt;
/*      */   }
/*      */   
/*      */   public void a_(v paramv) {
/* 1956 */     a(paramv, a());
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(v paramv, com.d.c.f.c paramc) {
/* 1961 */     if (F() == 1) {
/*      */       LinkedList<com.d.c.f.c> linkedList;
/* 1963 */       (linkedList = new LinkedList<>()).add(paramc);
/* 1964 */       for (Iterator<ac> iterator = this.h.iterator(); iterator.hasNext();) {
/*      */         
/* 1966 */         if (ac = (ac)(ac = (ac)iterator.next()) instanceof q) {
/*      */ 
/*      */           
/* 1969 */           if ((ac = ac).g())
/*      */           {
/* 1971 */             if (ac.h() != null) {
/* 1972 */               com.d.c.c.a a1; if (ac.n() == null) {
/* 1973 */                 a1 = paramv.c().a(ac.h(), false);
/*      */               } else {
/* 1975 */                 a1 = paramv.c().a(ac
/* 1976 */                     .h(), ac.n());
/*      */               } 
/* 1978 */               linkedList.add(((com.d.c.f.c)linkedList.getLast()).a(a1));
/*      */             } else {
/* 1980 */               linkedList.add(paramc.a(com.d.c.a.c.R));
/*      */             } 
/*      */           }
/*      */           
/* 1984 */           ac.a(linkedList.getLast());
/* 1985 */           ac.d();
/*      */           
/* 1987 */           if (ac.f()) {
/* 1988 */             linkedList.removeLast();
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void a(d paramd, y paramy, boolean paramBoolean) {
/* 1998 */     if (x() != null) {
/* 1999 */       x().a().a(new d(this, paramd, paramBoolean, paramy));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2009 */     super.a(paramd, paramy, paramBoolean);
/*      */   }
/*      */   
/*      */   private com.d.c.c.a q() {
/* 2013 */     return this.r;
/*      */   }
/*      */   
/*      */   public final void a(com.d.c.c.a parama) {
/* 2017 */     this.r = parama;
/*      */   }
/*      */   
/*      */   private com.d.c.c.a r() {
/* 2021 */     return this.q;
/*      */   }
/*      */   
/*      */   public final void b(com.d.c.c.a parama) {
/* 2025 */     this.q = parama;
/*      */   }
/*      */   
/*      */   protected final boolean J() {
/* 2029 */     return this.n;
/*      */   }
/*      */   
/*      */   protected final void f(boolean paramBoolean) {
/* 2033 */     this.n = paramBoolean;
/*      */   }
/*      */   
/*      */   protected final void g(boolean paramBoolean) {
/* 2037 */     this.o = paramBoolean;
/*      */   }
/*      */   
/*      */   private boolean s() {
/* 2041 */     return this.o;
/*      */   }
/*      */   
/*      */   private void c(boolean paramBoolean) {
/* 2045 */     this.p = paramBoolean;
/*      */   }
/*      */   
/*      */   private boolean t() {
/* 2049 */     return this.p;
/*      */   }
/*      */   
/*      */   public void a(v paramv, c paramc, int paramInt) {
/* 2053 */     n(0);
/* 2054 */     o(paramInt);
/*      */   }
/*      */   
/*      */   public int d(v paramv) {
/* 2058 */     for (byte b1 = 0; b1 < V(); b1++) {
/*      */       f f1;
/* 2060 */       if (f1 = k(b1) instanceof u) {
/* 2061 */         return f1.aa() + ((u)f1).j();
/*      */       }
/* 2063 */       if (f1 instanceof i) {
/* 2064 */         return f1.aa() + ((i)f1).d();
/*      */       }
/*      */       int i;
/* 2067 */       if ((i = ((c)f1).d(paramv)) != Integer.MIN_VALUE) {
/* 2068 */         return i;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2074 */     return Integer.MIN_VALUE;
/*      */   }
/*      */   
/*      */   protected final int m(v paramv) {
/*      */     i i;
/* 2079 */     if ((i = paramv.I()) != null && i.a() == this) {
/* 2080 */       return i.b();
/*      */     }
/* 2082 */     return 0;
/*      */   }
/*      */   
/*      */   public final boolean n(v paramv) {
/*      */     i i;
/* 2087 */     if ((i = paramv.I()) != null && i.a() == this) return true;  return false;
/*      */   }
/*      */   
/*      */   public final i o(v paramv) {
/* 2091 */     if (!paramv.r() || !a().av()) {
/* 2092 */       return null;
/*      */     }
/*      */     
/*      */     u u;
/* 2096 */     if ((u = a((int)a().b(com.d.c.a.a.aw))) != null) {
/* 2097 */       aa aa2 = paramv.p().b((d)paramv, u);
/* 2098 */       aa aa1 = paramv.p().b((d)paramv, this);
/* 2099 */       if (aa2 != null && aa1 != null && aa2.i() + 1 == aa1.i()) {
/* 2100 */         c c1 = (c)u.U();
/* 2101 */         return new i(c1, c1.h(u));
/*      */       } 
/*      */     } 
/*      */     
/* 2105 */     return null;
/*      */   }
/*      */   
/*      */   public int d(d paramd) {
/* 2109 */     if (A()) E();
/*      */ 
/*      */     
/*      */     u u;
/*      */     
/* 2114 */     if ((u = ay()) == null) {
/* 2115 */       return as();
/*      */     }
/* 2117 */     return u.aa() + u.j() - aa();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int h(f paramf) {
/* 2123 */     int i = V();
/* 2124 */     for (byte b1 = 0; b1 < i; b1++) {
/* 2125 */       if (k(b1) == paramf) {
/* 2126 */         return b1;
/*      */       }
/*      */     } 
/* 2129 */     return -1;
/*      */   }
/*      */   
/*      */   private u a(int paramInt) {
/* 2133 */     a a1 = new a(paramInt);
/* 2134 */     a(a1);
/* 2135 */     return a1.b;
/*      */   }
/*      */   
/*      */   static class a {
/*      */     public int a;
/*      */     public u b;
/*      */     
/*      */     public a(int param1Int) {
/* 2143 */       this.a = param1Int;
/*      */     }
/*      */   }
/*      */   
/*      */   private void a(a parama) {
/* 2148 */     int i = F();
/*      */     int j;
/* 2150 */     if ((j = V()) > 0) {
/* 2151 */       u u; if (i == 1) {
/* 2152 */         for (i = j - 1; i >= 0; i--) {
/*      */ 
/*      */           
/* 2155 */           parama.b = u;
/* 2156 */           if ((u = (u)k(i)).as() > 0 && --parama.a == 0)
/*      */             return; 
/*      */         } 
/*      */         return;
/*      */       } 
/* 2161 */       if (i == 2) {
/* 2162 */         for (i = u - 1; i >= 0; ) {
/* 2163 */           ((c)k(i)).a(parama);
/* 2164 */           if (parama.a != 0) {
/*      */             i--;
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private u ay() {
/* 2173 */     int i = F();
/*      */     int j;
/* 2175 */     if ((j = V()) > 0) {
/* 2176 */       u u; if (i == 1) {
/* 2177 */         for (i = j - 1; i >= 0; i--) {
/*      */           
/* 2179 */           if ((u = (u)k(i)).as() > 0) {
/* 2180 */             return u;
/*      */           }
/*      */         } 
/* 2183 */       } else if (i == 2) {
/* 2184 */         for (i = u - 1; i >= 0; i--) {
/*      */           
/* 2186 */           if ((u = ((c)k(i)).ay()) != null) {
/* 2187 */             return u;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2193 */     return null;
/*      */   }
/*      */   
/*      */   private u az() {
/* 2197 */     int i = F();
/*      */     int j;
/* 2199 */     if ((j = V()) > 0) {
/* 2200 */       if (i == 1) {
/* 2201 */         for (i = 0; i < j; i++) {
/*      */           u u;
/* 2203 */           if ((u = (u)k(i)).as() > 0) {
/* 2204 */             return u;
/*      */           }
/*      */         } 
/* 2207 */       } else if (i == 2) {
/* 2208 */         for (i = 0; i < j; i++) {
/*      */           u u;
/* 2210 */           if ((u = ((c)k(i)).az()) != null) {
/* 2211 */             return u;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 2217 */     return null;
/*      */   }
/*      */   public final boolean p(v paramv) {
/*      */     u u;
/* 2221 */     if (paramv.r() && a().av() && (
/*      */       
/* 2223 */       u = az()) != null) {
/* 2224 */       aa aa2 = paramv.p().a((d)paramv, u);
/* 2225 */       aa aa1 = paramv.p().a((d)paramv, this);
/* 2226 */       return (aa2 != null && aa1 != null && aa2.i() == aa1.i() + 1);
/*      */     } 
/*      */ 
/*      */     
/* 2230 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean K() {
/* 2234 */     return (this.s != null);
/*      */   }
/*      */   
/*      */   public final n L() {
/* 2238 */     return this.s;
/*      */   }
/*      */   
/*      */   public final void a(n paramn) {
/* 2242 */     this.s = paramn;
/*      */   }
/*      */   
/*      */   public final int M() {
/* 2246 */     return this.t;
/*      */   }
/*      */   
/*      */   private void b(int paramInt) {
/* 2250 */     this.t = paramInt;
/*      */   }
/*      */   
/*      */   private boolean aA() {
/* 2254 */     return this.u;
/*      */   }
/*      */   
/*      */   public final void h(boolean paramBoolean) {
/* 2258 */     this.u = true;
/*      */   }
/*      */   
/*      */   protected final boolean N() {
/* 2262 */     return v();
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
/*      */   public final f O() {
/*      */     f f1;
/* 2277 */     if ((f1 = y()) != null) {
/* 2278 */       return f1;
/*      */     }
/* 2280 */     return U();
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean K(v paramv) {
/* 2285 */     l(paramv);
/* 2286 */     switch (F()) {
/*      */       case 1:
/* 2288 */         return true;
/*      */       case 4:
/* 2290 */         return false;
/*      */       case 2:
/* 2292 */         return X().stream().anyMatch(paramf -> ((c)paramf).K(paramv));
/*      */     } 
/*      */     
/* 2295 */     throw new RuntimeException("internal error: no children");
/*      */   }
/*      */   
/*      */   public final boolean q(v paramv) {
/* 2299 */     if (!a().a(com.d.c.a.a.ad, com.d.c.a.c.e)) {
/*      */       String str;
/* 2301 */       if (!(str = a().f(com.d.c.a.a.ad)).equals(paramv.B()) && 
/* 2302 */         aw() && (
/* 2303 */         z() || K(paramv))) {
/* 2304 */         paramv.c(str);
/* 2305 */         return true;
/*      */       } 
/* 2307 */     } else if (paramv.B() != null && aw()) {
/* 2308 */       paramv.c(null);
/* 2309 */       return true;
/*      */     } 
/*      */     
/* 2312 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean P() {
/* 2316 */     if (!A() && 
/* 2317 */       a().a(com.d.c.a.a.ac, com.d.c.a.c.P) && 
/* 2318 */       a().R()) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static void a(v paramv, j paramj1, j paramj2, int paramInt1, int paramInt2) {
/* 2326 */     int i = paramj2.a();
/* 2327 */     int k = paramj2.b();
/* 2328 */     int m = i;
/*      */     
/* 2330 */     while (m <= k) {
/*      */       
/* 2332 */       i i1 = paramj2.a(m);
/*      */       int i2;
/* 2334 */       if (m != i && (
/*      */         
/* 2336 */         i2 = i1.a()) != -1) {
/* 2337 */         paramj1.a(paramv, i2 - paramInt1);
/*      */       }
/*      */ 
/*      */       
/* 2341 */       if (m != k && (
/*      */         
/* 2343 */         i2 = i1.b()) != -1) {
/* 2344 */         paramj1.b(paramv, i2 + paramInt2);
/*      */       }
/*      */ 
/*      */       
/* 2348 */       m++;
/*      */     } 
/*      */   }
/*      */   
/*      */   public static class b {
/*      */     private int a;
/*      */     private int b;
/*      */     
/*      */     public final void a(int param1Int) {
/* 2357 */       if (param1Int < 0 && param1Int < this.b) {
/* 2358 */         this.b = param1Int;
/*      */       }
/*      */       
/* 2361 */       if (param1Int > 0 && param1Int > this.a) {
/* 2362 */         this.a = param1Int;
/*      */       }
/*      */     }
/*      */     
/*      */     public final int a() {
/* 2367 */       return this.a + this.b;
/*      */     }
/*      */     
/*      */     public final boolean b() {
/* 2371 */       return (this.a != 0 || this.b != 0);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */