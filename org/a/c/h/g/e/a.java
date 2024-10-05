/*     */ package org.a.c.h.g.e;
/*     */ 
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.f.g;
/*     */ import org.a.c.g.d;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.e.u;
/*     */ import org.a.c.h.f.a.e;
/*     */ import org.a.c.h.g;
/*     */ import org.a.c.h.g.a.p;
/*     */ import org.a.c.h.g.b.m;
/*     */ import org.a.c.h.g.b.n;
/*     */ import org.a.c.h.g.b.o;
/*     */ import org.a.c.h.g.b.p;
/*     */ import org.a.c.h.g.b.q;
/*     */ import org.a.c.h.g.b.r;
/*     */ import org.a.c.h.j;
/*     */ import org.a.c.i.d;
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
/*     */ class a
/*     */ {
/*  55 */   private static final org.a.a.a.a a = c.a(a.class);
/*     */   
/*  57 */   private static final org.a.c.a.a.a b = org.a.c.a.a.a.a("BMC");
/*  58 */   private static final org.a.c.a.a.a c = org.a.c.a.a.a.a("EMC");
/*     */ 
/*     */ 
/*     */   
/*     */   private final r d;
/*     */ 
/*     */ 
/*     */   
/*     */   private i e;
/*     */ 
/*     */   
/*     */   private String f;
/*     */ 
/*     */   
/*  72 */   private static final int[] g = new int[] { 153, 193, 215 };
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
/*     */   a(r paramr) {
/*  97 */     this.d = paramr;
/*  98 */     a();
/*     */     
/* 100 */     this.e = paramr.n();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/* 111 */     if (this.d.h().e() == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 116 */     j j = this.d.h().e();
/*     */     
/* 118 */     for (Iterator<m> iterator = this.d.l().iterator(); iterator.hasNext();) {
/*     */       
/* 120 */       if ((m = iterator.next()).d() != null && m.d().e() != null) {
/*     */         j j1;
/*     */         
/* 123 */         for (j j2 : (j1 = m.d().e()).a()) {
/*     */ 
/*     */           
/*     */           try {
/* 127 */             if (j.a(j2) == null)
/*     */             {
/* 129 */               (new StringBuilder("Adding font resource ")).append(j2).append(" from widget to AcroForm");
/* 130 */               j.a(j2, j1.a(j2));
/*     */             }
/*     */           
/* 133 */           } catch (IOException iOException) {}
/*     */         } 
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
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/* 150 */     this.f = paramString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     if (this.d instanceof q && !((q)this.d).a())
/*     */     {
/* 160 */       this.f = paramString.replaceAll("\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]", " ");
/*     */     }
/*     */     
/* 163 */     for (m m : this.d.l()) {
/*     */ 
/*     */ 
/*     */       
/* 167 */       i i1 = this.e;
/*     */       
/* 169 */       if (m.b().a(j.an) != null)
/*     */       {
/* 171 */         this.e = b(m);
/*     */       }
/*     */       
/*     */       h h;
/* 175 */       if ((h = m.a()) == null) {
/*     */         
/* 177 */         m.b().m(j.j);
/* 178 */         (new StringBuilder("widget of field ")).append(this.d.j()).append(" has no rectangle, no appearance stream created");
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*     */       p p;
/*     */       
/* 186 */       if ((p = this.d.g()) == null || p.a() == null || m
/* 187 */         .b().a(j.j) != null) {
/*     */         q q;
/*     */         o o;
/* 190 */         if ((o = m.c()) == null) {
/*     */           
/* 192 */           o = new o();
/* 193 */           m.a(o);
/*     */         } 
/*     */ 
/*     */         
/*     */         p p1;
/*     */ 
/*     */         
/* 200 */         if ((p1 = o.b()) != null && p1.b()) {
/*     */           
/* 202 */           q = p1.c();
/*     */         }
/*     */         else {
/*     */           
/* 206 */           q = a(m);
/*     */           
/* 208 */           o.a(q);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 218 */         if (m.h() != null || q.d().d() == 0)
/*     */         {
/* 220 */           a(m, q);
/*     */         }
/*     */         
/* 223 */         b(m, q);
/*     */       } 
/*     */ 
/*     */       
/* 227 */       this.e = i1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private q a(m paramm) {
/* 233 */     q q = new q(this.d.h().a());
/*     */ 
/*     */ 
/*     */     
/* 237 */     int j = c(paramm);
/* 238 */     h h2 = paramm.a();
/*     */     d d;
/* 240 */     Point2D.Float float_ = (d = d.a(Math.toRadians(j), 0.0F, 0.0F)).a(h2.h(), h2.i());
/*     */     
/* 242 */     h h1 = new h(Math.abs((float)float_.getX()), Math.abs((float)float_.getY()));
/* 243 */     q.a(h1);
/*     */     
/*     */     AffineTransform affineTransform;
/* 246 */     if (!(affineTransform = a(h1, j)).isIdentity())
/*     */     {
/* 248 */       q.a(affineTransform);
/*     */     }
/* 250 */     q.a(1);
/* 251 */     q.a(new j());
/* 252 */     return q;
/*     */   }
/*     */ 
/*     */   
/*     */   private i b(m paramm) {
/* 257 */     s s = (s)paramm.b().a(j.an);
/* 258 */     j j = this.d.h().e();
/* 259 */     return new i(s, j);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int c(m paramm) {
/*     */     n n;
/* 265 */     if ((n = paramm.h()) != null)
/*     */     {
/*     */       
/* 268 */       return n.a();
/*     */     }
/* 270 */     return 0;
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
/*     */   private void a(m paramm, q paramq) {
/* 286 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 287 */     g g = new g(this.d.h().a(), paramq, byteArrayOutputStream);
/*     */ 
/*     */     
/*     */     n n;
/*     */     
/* 292 */     if ((n = paramm.h()) != null) {
/*     */       e e2;
/*     */       
/* 295 */       if ((e2 = n.c()) != null) {
/*     */         
/* 297 */         g.b(e2);
/* 298 */         h h = c(paramm, paramq);
/* 299 */         g.c(h.c(), h.d(), h.h(), h.i());
/* 300 */         g.g();
/*     */       } 
/*     */       
/* 303 */       float f = 0.0F;
/*     */       e e1;
/* 305 */       if ((e1 = n.b()) != null) {
/*     */         
/* 307 */         g.a(e1);
/* 308 */         f = 1.0F;
/*     */       } 
/*     */       r r1;
/* 311 */       if ((r1 = paramm.i()) != null && r1.a() > 0.0F)
/*     */       {
/* 313 */         f = r1.a();
/*     */       }
/*     */       
/* 316 */       if (f > 0.0F && e1 != null) {
/*     */         
/* 318 */         if (f != 1.0F)
/*     */         {
/* 320 */           g.a(f);
/*     */         }
/*     */         
/* 323 */         h h = a(h = c(paramm, paramq), Math.max(0.5F, f / 2.0F));
/* 324 */         g.c(h.c(), h.d(), h.h(), h.i());
/* 325 */         g.f();
/*     */       } 
/*     */     } 
/*     */     
/* 329 */     g.close();
/* 330 */     byteArrayOutputStream.close();
/* 331 */     a(byteArrayOutputStream.toByteArray(), paramq);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<Object> a(q paramq) {
/*     */     g g;
/* 340 */     (g = new g((org.a.c.a.a)paramq)).p();
/* 341 */     return g.q();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(m paramm, q paramq) {
/* 352 */     this.e.a(paramq);
/*     */ 
/*     */ 
/*     */     
/* 356 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 357 */     d d = new d(byteArrayOutputStream);
/*     */     
/*     */     List<Object> list;
/*     */     int k;
/* 361 */     if ((k = (list = a(paramq)).indexOf(b)) == -1) {
/*     */ 
/*     */       
/* 364 */       d.a(list);
/* 365 */       d.a(new Object[] { j.dM, b });
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 370 */       d.a(list.subList(0, k + 1));
/*     */     } 
/*     */ 
/*     */     
/* 374 */     a(paramm, paramq, byteArrayOutputStream);
/*     */     
/*     */     int j;
/* 377 */     if ((j = list.indexOf(c)) == -1) {
/*     */ 
/*     */       
/* 380 */       d.a(new Object[] { c });
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 385 */       d.a(list.subList(j, list.size()));
/*     */     } 
/*     */     
/* 388 */     byteArrayOutputStream.close();
/* 389 */     a(byteArrayOutputStream.toByteArray(), paramq);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(m paramm, q paramq, OutputStream paramOutputStream) {
/* 399 */     g g = new g(this.d.h().a(), paramq, paramOutputStream);
/*     */ 
/*     */     
/* 402 */     h h2 = c(paramm, paramq);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 407 */     float f2 = 0.0F;
/* 408 */     if (paramm.i() != null)
/*     */     {
/* 410 */       f2 = paramm.i().a();
/*     */     }
/*     */     h h1;
/* 413 */     h2 = a(h1 = a(h2, Math.max(1.0F, f2)), Math.max(1.0F, f2));
/*     */     
/* 415 */     g.c();
/*     */ 
/*     */     
/* 418 */     g.c(h1.c(), h1.d(), h1
/* 419 */         .h(), h1.i());
/* 420 */     g.j();
/*     */     
/*     */     u u;
/*     */     
/* 424 */     if ((u = this.e.b()) == null)
/*     */     {
/* 426 */       throw new IllegalArgumentException("font is null, check whether /DA entry is incomplete or incorrect");
/*     */     }
/* 428 */     if (u.d().contains("+")) {
/*     */       
/* 430 */       (new StringBuilder("Font '")).append(this.e.a().a()).append("' of field '")
/* 431 */         .append(this.d.j()).append("' contains subsetted font '")
/* 432 */         .append(u.d()).append("'");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 437 */       (new StringBuilder("acroForm.getDefaultResources().put(COSName.getPDFName(\""))
/* 438 */         .append(this.e.a().a()).append("\", font);");
/*     */     } 
/*     */ 
/*     */     
/*     */     float f3;
/*     */     
/* 444 */     if ((f3 = this.e.c()) == 0.0F)
/*     */     {
/* 446 */       f3 = a(u, h2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 451 */     if (this.d instanceof k)
/*     */     {
/* 453 */       b(g, paramq, u, f3);
/*     */     }
/*     */ 
/*     */     
/* 457 */     g.a();
/*     */ 
/*     */     
/* 460 */     this.e.a(g, f3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 466 */     float f5 = f3 / 1000.0F;
/* 467 */     float f4 = u.e().e() * f5;
/* 468 */     float f6 = u.b().m() * f5;
/* 469 */     float f7 = u.b().l() * f5;
/*     */     
/* 471 */     if (this.d instanceof q && ((q)this.d).a()) {
/*     */       
/* 473 */       f4 = h2.g() - f4;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 478 */     else if (f6 > h1.i()) {
/*     */       
/* 480 */       f4 = h1.d() - f7;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 488 */     else if ((f4 = h1.d() + (h1.i() - f6) / 2.0F) - h1.d() < -f7) {
/*     */       
/* 490 */       float f = -f7 + h2.d();
/* 491 */       f6 = h2.i() - h2.d() - f6;
/*     */       
/* 493 */       f4 = Math.min(f, Math.max(f4, f6));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 499 */     float f1 = h2.c();
/*     */ 
/*     */ 
/*     */     
/* 503 */     if (c()) {
/*     */       
/* 505 */       a(g, paramq, u, f3);
/*     */     }
/* 507 */     else if (this.d instanceof k) {
/*     */       
/* 509 */       a(g, paramq, h2, u, f3);
/*     */     }
/*     */     else {
/*     */       
/* 513 */       s s = new s(this.f);
/*     */       b b;
/* 515 */       (b = new b()).a(u);
/* 516 */       b.a(f3);
/*     */ 
/*     */       
/* 519 */       b.b(u.e().e() * f5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       t t;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 530 */       (t = (new t.a(g)).a(b).a(s).a(h2.h()).a(b()).a(f1, f4).a(this.d.o()).a()).a();
/*     */     } 
/*     */     
/* 533 */     g.b();
/* 534 */     g.d();
/* 535 */     g.close();
/*     */   }
/*     */ 
/*     */   
/*     */   private static AffineTransform a(h paramh, int paramInt) {
/* 540 */     if (paramInt == 0)
/*     */     {
/* 542 */       return new AffineTransform();
/*     */     }
/* 544 */     float f1 = 0.0F, f2 = 0.0F;
/* 545 */     switch (paramInt) {
/*     */       
/*     */       case 90:
/* 548 */         f1 = paramh.g();
/*     */         break;
/*     */       case 180:
/* 551 */         f1 = paramh.g();
/*     */ 
/*     */       
/*     */       case 270:
/* 555 */         f2 = paramh.e();
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/*     */     d d;
/* 561 */     return (d = d.a(Math.toRadians(paramInt), f1, f2)).a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b() {
/* 568 */     return (this.d instanceof q && ((q)this.d).a());
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
/*     */   private boolean c() {
/* 585 */     if (this.d instanceof q && ((q)this.d)
/* 586 */       .e() && 
/* 587 */       !((q)this.d).a() && 
/* 588 */       !((q)this.d).b() && 
/* 589 */       !((q)this.d).d()) return true;
/*     */     
/*     */     return false;
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
/*     */   private void a(g paramg, q paramq, u paramu, float paramFloat) {
/* 608 */     int j = ((q)this.d).k();
/* 609 */     int k = Math.min(this.f.length(), j);
/*     */     
/* 611 */     h h = a(paramq.g(), 1.0F);
/*     */     
/* 613 */     float f2 = paramq.g().h() / j;
/* 614 */     float f4 = paramu.b().k() / 1000.0F * paramFloat;
/*     */     
/* 616 */     float f1 = h.d() + (paramq.g().i() - f4) / 2.0F;
/*     */     
/* 618 */     float f3 = 0.0F;
/*     */     
/* 620 */     f4 = f2 / 2.0F;
/*     */     
/* 622 */     for (byte b = 0; b < k; b++) {
/*     */       
/* 624 */       String str = this.f.substring(b, b + 1);
/* 625 */       float f = paramu.b(str) / 1000.0F * paramFloat / 2.0F;
/*     */       
/* 627 */       f4 = f4 + f3 / 2.0F - f / 2.0F;
/*     */       
/* 629 */       paramg.a(f4, f1);
/* 630 */       paramg.a(str);
/*     */       
/* 632 */       f1 = 0.0F;
/* 633 */       f3 = f;
/* 634 */       f4 = f2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(g paramg, q paramq, u paramu, float paramFloat) {
/* 641 */     List<Integer> list = ((k)this.d).d();
/* 642 */     List<String> list1 = ((k)this.d).e();
/* 643 */     List<String> list2 = ((k)this.d).b();
/*     */     
/* 645 */     if (!list1.isEmpty() && !list2.isEmpty() && list.isEmpty()) {
/*     */ 
/*     */       
/* 648 */       list = new ArrayList<Integer>();
/* 649 */       for (String str : list1)
/*     */       {
/* 651 */         list.add(Integer.valueOf(list2.indexOf(str)));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 658 */     int j = ((k)this.d).k();
/*     */     
/* 660 */     float f = paramu.e().e() * paramFloat / 1000.0F;
/*     */ 
/*     */     
/* 663 */     h h = a(paramq.g(), 1.0F);
/*     */     
/* 665 */     for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) { int k = ((Integer)iterator.next()).intValue();
/*     */       
/* 667 */       paramg.b(g[0], g[1], g[2]);
/*     */       
/* 669 */       paramg.c(h.c(), h
/* 670 */           .g() - f * (k - j + 1) + 2.0F, h
/* 671 */           .h(), f);
/*     */       
/* 673 */       paramg.g(); }
/*     */     
/* 675 */     paramg.a(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(g paramg, q paramq, h paramh, u paramu, float paramFloat) {
/* 682 */     paramg.a(0);
/*     */     
/*     */     int j;
/*     */     
/* 686 */     if ((j = this.d.o()) == 1 || j == 2) {
/*     */       
/* 688 */       float f1 = paramq.g().h();
/* 689 */       float f2 = paramu.b(this.f) / 1000.0F * paramFloat;
/* 690 */       float f3 = f1 - f2 - 4.0F;
/*     */       
/* 692 */       if (j == 1)
/*     */       {
/* 694 */         f3 /= 2.0F;
/*     */       }
/*     */       
/* 697 */       paramg.a(f3, 0.0F);
/*     */     }
/* 699 */     else if (j != 0) {
/*     */       
/* 701 */       throw new IOException("Error: Unknown justification value:" + j);
/*     */     } 
/*     */     
/*     */     List<String> list;
/* 705 */     int k = (list = ((k)this.d).a()).size();
/*     */     
/* 707 */     float f = paramh.g();
/*     */ 
/*     */ 
/*     */     
/* 711 */     for (int m = j = ((k)this.d).k(); m < k; m++) {
/*     */ 
/*     */       
/* 714 */       if (m == j) {
/*     */         
/* 716 */         f -= paramu.b().k() / 1000.0F * paramFloat;
/*     */       }
/*     */       else {
/*     */         
/* 720 */         f -= paramu.e().e() / 1000.0F * paramFloat;
/* 721 */         paramg.a();
/*     */       } 
/*     */       
/* 724 */       paramg.a(paramh.c(), f);
/* 725 */       paramg.a(list.get(m));
/*     */       
/* 727 */       if (m != k - 1)
/*     */       {
/* 729 */         paramg.b();
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
/*     */   private static void a(byte[] paramArrayOfbyte, q paramq) {
/*     */     OutputStream outputStream;
/* 742 */     (outputStream = paramq.b().l()).write(paramArrayOfbyte);
/* 743 */     outputStream.close();
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
/*     */   private float a(u paramu, h paramh) {
/*     */     float f;
/* 758 */     if ((f = this.e.c()) == 0.0F) {
/*     */       
/* 760 */       if (b())
/*     */       {
/*     */         
/* 763 */         return 12.0F;
/*     */       }
/*     */ 
/*     */       
/* 767 */       f = 1000.0F * paramu.h().c();
/* 768 */       float f2 = 1000.0F * paramu.h().b();
/*     */ 
/*     */       
/* 771 */       float f3 = paramu.b(this.f) * paramu.h().b();
/* 772 */       f2 = paramh.h() / f3 * f2;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 777 */       if ((f3 = (paramu.b().m() - paramu.b().l()) * paramu.h().c()) <= 0.0F)
/*     */       {
/* 779 */         f3 = paramu.e().e() * paramu.h().c();
/*     */       }
/*     */       
/*     */       float f1;
/*     */       
/* 784 */       return Math.min(f1 = paramh.i() / f3 * f, f2);
/*     */     } 
/*     */     
/* 787 */     return f;
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
/*     */   private static h c(m paramm, q paramq) {
/*     */     h h;
/* 801 */     if ((h = paramq.g()) == null)
/*     */     {
/* 803 */       h = paramm.a().a();
/*     */     }
/* 805 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static h a(h paramh, float paramFloat) {
/* 816 */     return new h(paramh.c() + paramFloat, paramh
/* 817 */         .d() + paramFloat, paramh
/* 818 */         .h() - paramFloat * 2.0F, paramh
/* 819 */         .i() - paramFloat * 2.0F);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\g\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */