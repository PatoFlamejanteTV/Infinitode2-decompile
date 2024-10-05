/*      */ package com.d.h;
/*      */ 
/*      */ import com.a.a.c.f.w;
/*      */ import com.a.a.c.k.b.ak;
/*      */ import com.d.a.c;
/*      */ import com.d.c.a.c;
/*      */ import com.d.c.f.d;
/*      */ import com.d.d.j;
/*      */ import com.d.d.l;
/*      */ import com.d.d.p;
/*      */ import com.d.d.s;
/*      */ import com.d.d.t;
/*      */ import com.d.e.aa;
/*      */ import com.d.e.c;
/*      */ import com.d.e.t;
/*      */ import com.d.e.v;
/*      */ import com.d.g.a.g;
/*      */ import com.d.g.a.h;
/*      */ import com.d.i.a.b;
/*      */ import com.d.i.a.c;
/*      */ import com.d.i.a.d;
/*      */ import com.d.i.aa;
/*      */ import com.d.i.ab;
/*      */ import com.d.i.ae;
/*      */ import com.d.i.c;
/*      */ import com.d.i.f;
/*      */ import com.d.j.g;
/*      */ import com.d.k.a.b;
/*      */ import com.d.m.b;
/*      */ import com.d.m.i;
/*      */ import com.d.m.l;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Shape;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.OutputStream;
/*      */ import java.io.StringReader;
/*      */ import java.util.Calendar;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.logging.Level;
/*      */ import javax.xml.transform.TransformerException;
/*      */ import org.a.c.b.d;
/*      */ import org.a.c.h.a.f;
/*      */ import org.a.c.h.a.h;
/*      */ import org.a.c.h.b;
/*      */ import org.a.c.h.c;
/*      */ import org.a.c.h.c.d;
/*      */ import org.a.c.h.d;
/*      */ import org.a.c.h.e;
/*      */ import org.a.c.h.f.a.s;
/*      */ import org.a.c.h.g;
/*      */ import org.a.d.a.b;
/*      */ import org.a.d.a.e;
/*      */ import org.a.d.a.i;
/*      */ import org.a.d.a.l;
/*      */ import org.a.d.b;
/*      */ import org.a.d.b.b;
/*      */ import org.a.d.b.h;
/*      */ import org.w3c.dom.Document;
/*      */ import org.xml.sax.InputSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class q
/*      */   implements a, Closeable
/*      */ {
/*      */   private final aa a;
/*      */   private final m b;
/*      */   private final List<w.a> c;
/*      */   private Document d;
/*      */   private c e;
/*      */   private final float f;
/*      */   private b g;
/*      */   private d h;
/*      */   private String i;
/*      */   private x.c j;
/*      */   private boolean k;
/*      */   private byte[] l;
/*      */   private boolean m;
/*      */   private OutputStream n;
/*      */   private p o;
/*      */   private p p;
/*      */   private c q;
/*  127 */   private byte r = 0;
/*      */ 
/*      */   
/*      */   private com.d.a.a s;
/*      */ 
/*      */   
/*      */   private final boolean t;
/*      */   
/*      */   private a u;
/*      */ 
/*      */   
/*      */   q(com.d.g.a.a parama, h paramh, g paramg, y paramy) {
/*  139 */     this.g = (paramy.E != null) ? paramy.E : new b();
/*  140 */     this.g.a(paramy.C);
/*      */     
/*  142 */     this.i = paramy.D;
/*      */     
/*  144 */     this.u = (paramy.J != null) ? paramy.J : this;
/*      */     
/*  146 */     this.o = paramy.g;
/*  147 */     this.p = paramy.h;
/*      */     
/*  149 */     this.j = paramy.G;
/*  150 */     this.k = false;
/*  151 */     this.l = paramy.I;
/*      */     
/*  153 */     this.f = 26.666666F;
/*  154 */     this.m = false;
/*  155 */     this.t = false;
/*  156 */     this
/*      */ 
/*      */ 
/*      */       
/*  160 */       .b = new t(26.666666F, this.m);
/*  161 */     this.b.a(this.g);
/*  162 */     this.b.a(this.g.f());
/*      */     
/*      */     v v;
/*      */     
/*  166 */     (v = new v(this.b)).a(paramy.b);
/*      */     
/*  168 */     if (paramy.c != null) {
/*  169 */       v.a(paramy.c);
/*      */     }
/*      */     
/*  172 */     this.a = new aa();
/*  173 */     this.a.A();
/*      */     
/*  175 */     this.a.a = paramy.x;
/*  176 */     this.a.b = paramy.y;
/*      */     
/*  178 */     this.a.a((s)v);
/*  179 */     this.a.a(new com.d.e.a((s)v));
/*  180 */     v.a(this.a);
/*  181 */     this.b.a(this.a);
/*      */     
/*  183 */     f f = new f(this.a, this.g, paramy.F.get(x.b.a), paramy.G, false);
/*  184 */     this.a.a(f);
/*      */     
/*  186 */     r r = new r(this.b, paramy.g, paramy.w, paramy.h);
/*  187 */     this.a.a(r);
/*      */     
/*  189 */     this.a.a(new u());
/*  190 */     this.a.a(1920.0F);
/*  191 */     this.a.a(20);
/*  192 */     this.a.b(true);
/*  193 */     this.a.a(false);
/*      */     
/*  195 */     g().a(paramg.a, paramg.b, paramg.c);
/*      */     
/*  197 */     if (paramy.i != null) {
/*  198 */       g().d(paramy.i);
/*      */     }
/*      */     
/*  201 */     if (paramh.b != null) {
/*  202 */       this.q = paramh.b;
/*      */     }
/*      */     
/*  205 */     if (paramh.a != null) {
/*  206 */       this.s = paramh.a;
/*  207 */       this.b.a(this.s);
/*      */     } 
/*      */     
/*  210 */     if (paramh.c != null) {
/*  211 */       this.a.a(paramh.c);
/*      */     }
/*      */     
/*  214 */     if (paramh.d != null) {
/*  215 */       this.a.b(paramh.d);
/*      */     }
/*      */     
/*  218 */     if (paramh.e != null) {
/*  219 */       this.a.a(paramh.e);
/*      */     }
/*      */     
/*  222 */     if (paramh.f != null) {
/*  223 */       this.a.b(paramh.f);
/*      */     }
/*      */     
/*  226 */     if (paramh.g != null) {
/*  227 */       this.a.c(paramh.g);
/*      */     }
/*      */     
/*  230 */     this.r = paramh.h ? 1 : 0;
/*      */     
/*  232 */     this.c = paramy.a;
/*      */     
/*  234 */     if (parama.a != null) {
/*  235 */       a(parama.a, parama.e);
/*      */     }
/*  237 */     else if (parama.b != null) {
/*  238 */       a(parama.b, parama.e);
/*      */     }
/*  240 */     else if (parama.d != null) {
/*  241 */       b(parama.d);
/*      */     }
/*  243 */     else if (parama.c != null) {
/*      */       try {
/*  245 */         a(parama.c);
/*  246 */       } catch (IOException iOException) {
/*  247 */         l.a("Problem trying to read input XHTML file", iOException);
/*  248 */         throw new RuntimeException("File IO problem", iOException);
/*      */       } 
/*      */     } 
/*      */     
/*  252 */     this.n = paramy.B;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final b a() {
/*  263 */     return this.g;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final f b() {
/*  271 */     return (f)this.a.c();
/*      */   }
/*      */   
/*      */   private Document a(String paramString) {
/*  275 */     return this.a.n().c(paramString).d();
/*      */   }
/*      */   
/*      */   private void b(String paramString) {
/*  279 */     a(a(paramString), paramString);
/*      */   }
/*      */   
/*      */   private void a(Document paramDocument, String paramString) {
/*  283 */     a(paramDocument, paramString, (l)new b());
/*      */   }
/*      */   
/*      */   private void a(File paramFile) {
/*  287 */     File file = paramFile.getAbsoluteFile().getParentFile();
/*  288 */     a(a(paramFile.toURI().toURL().toExternalForm()), (file == null) ? "" : file.toURI().toURL().toExternalForm());
/*      */   }
/*      */   
/*      */   private void a(String paramString1, String paramString2) {
/*      */     InputSource inputSource;
/*  293 */     Document document = g.a(inputSource = new InputSource(new BufferedReader(new StringReader(paramString1)))).d();
/*  294 */     a(document, paramString2);
/*      */   }
/*      */   
/*      */   private void a(Document paramDocument, String paramString, l paraml) {
/*  298 */     this.d = paramDocument;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  303 */     for (Iterator<w.a> iterator = this.c.iterator(); iterator.hasNext(); iterator.next());
/*      */ 
/*      */     
/*  306 */     b().b();
/*      */     
/*  308 */     if (b.a("xr.cache.stylesheets", true)) {
/*  309 */       this.a.j().a();
/*      */     } else {
/*  311 */       this.a.j().b();
/*      */     } 
/*  313 */     this.a.c(paramString);
/*  314 */     this.a.a(paraml);
/*  315 */     this.a.j().a(this.a, this.a.l(), paramDocument, new a((byte)0));
/*  316 */     b().a(this.a.j().c());
/*      */     
/*  318 */     if (this.o != null) {
/*  319 */       this.a.j().c();
/*      */     }
/*      */     
/*  322 */     if (this.p != null) {
/*  323 */       this.a.j().c();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void c() {
/*      */     v v;
/*      */     c c1;
/*  334 */     (c1 = c.a(v = f(), this.d)).g((f)new ae(a(v)));
/*  335 */     c1.b(v);
/*  336 */     Dimension dimension = c1.Z().a(v);
/*  337 */     c1.Z().c(dimension.height);
/*  338 */     c1.Z().d(v);
/*  339 */     this.e = c1;
/*      */   }
/*      */   
/*      */   private static Rectangle a(v paramv) {
/*  343 */     aa aa1 = t.a((d)paramv, "first");
/*      */     
/*  345 */     return new Rectangle(0, 0, aa1.d((d)paramv), aa1.c((d)paramv));
/*      */   }
/*      */   
/*      */   private ab e() {
/*      */     ab ab;
/*  350 */     (ab = this.a.b()).a(new j());
/*      */     
/*  352 */     ab.a(this.b);
/*      */     
/*  354 */     if (this.s != null) {
/*  355 */       ab.a(this.s);
/*      */     }
/*  357 */     this.b.a(ab);
/*      */     
/*  359 */     this.a.e(); ab.q();
/*      */     
/*  361 */     ab.a(this.e.Z());
/*      */     
/*  363 */     return ab;
/*      */   }
/*      */   
/*      */   private v f() {
/*      */     v v;
/*  368 */     (v = this.a.a()).a(new j());
/*      */     
/*  370 */     if (this.q != null) {
/*  371 */       v.a(this.q);
/*      */     }
/*  373 */     if (this.s != null) {
/*  374 */       v.a(this.s);
/*      */     }
/*  376 */     v.a(this.r);
/*      */     
/*  378 */     v.w(); ((u)this.a.e()).a((this.s != null) ? this.s : (com.d.a.a)new ak());
/*      */     
/*  380 */     return v;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void d() {
/*  387 */     a(this.n);
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
/*      */   @Deprecated
/*      */   private void a(OutputStream paramOutputStream) {
/*  405 */     a(paramOutputStream, true, 0);
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
/*      */   @Deprecated
/*      */   private void a(OutputStream paramOutputStream, boolean paramBoolean, int paramInt) {
/*  467 */     if (this.t) {
/*  468 */       a(true);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  476 */       if (this.e == null) {
/*  477 */         c();
/*      */       }
/*      */       
/*  480 */       List<aa> list = this.e.Z().k();
/*      */       
/*      */       ab ab;
/*  483 */       (ab = e()).b(0);
/*      */       
/*  485 */       aa aa1 = list.get(0);
/*      */ 
/*      */       
/*  488 */       Rectangle2D.Float float_ = new Rectangle2D.Float(0.0F, 0.0F, aa1.a((d)ab) / 26.666666F, aa1.b((d)ab) / 26.666666F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  494 */       if (this.h != null) {
/*  495 */         this.g.a(this.h);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  500 */       b(list, ab, float_, this.g);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  507 */       this.g.a(paramOutputStream); return;
/*      */     } finally {
/*  509 */       this.g.close();
/*  510 */       this.g = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(boolean paramBoolean) {
/*  521 */     l.d(Level.INFO, "Using fast-mode renderer. Prepare to fly.");
/*      */ 
/*      */     
/*      */     try {
/*  525 */       if (this.e == null) {
/*  526 */         c();
/*      */       }
/*      */       
/*  529 */       List<aa> list = this.e.Z().k();
/*      */       
/*      */       ab ab;
/*  532 */       (ab = e()).b(0);
/*  533 */       ab.a(true);
/*      */       
/*  535 */       aa aa1 = list.get(0);
/*      */ 
/*      */       
/*  538 */       Rectangle2D.Float float_ = new Rectangle2D.Float(0.0F, 0.0F, aa1.a((d)ab) / 26.666666F, aa1.b((d)ab) / 26.666666F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  544 */       if (this.h != null) {
/*  545 */         this.g.a(this.h);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  550 */       a(list, ab, float_, this.g);
/*      */     }
/*      */     finally {
/*      */       
/*  554 */       if (paramBoolean) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  559 */         this.g.close();
/*  560 */         this.g = null;
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
/*      */   private void a(List<aa> paramList, ab paramab, Rectangle2D paramRectangle2D, b paramb) {
/*  584 */     this.b.a((f)this.e);
/*  585 */     this.b.a(this.d);
/*      */     
/*  587 */     e e = this.u.a(paramb, (float)paramRectangle2D.getWidth(), (float)paramRectangle2D.getHeight());
/*  588 */     g g = new g(paramb, e, g.a.a, !this.m);
/*      */     
/*  590 */     this.b.a(g, e, (float)paramRectangle2D.getHeight());
/*  591 */     this.e.Z().a((d)paramab, (short)2);
/*      */     
/*  593 */     int i = this.e.Z().k().size();
/*  594 */     paramab.a(i);
/*      */     
/*  596 */     b(paramb);
/*      */     
/*  598 */     if (this.k) {
/*  599 */       a(paramb);
/*  600 */     } else if (this.j != x.c.a) {
/*  601 */       a(paramb, this.j.b(), this.j.a());
/*      */     } 
/*      */     
/*      */     b b1;
/*  605 */     c c1 = (b1 = new b(this.e.Z().k())).a(paramab, this.e.Z());
/*      */     
/*  607 */     byte b2 = 0;
/*      */     
/*  609 */     for (byte b3 = 0; b3 < i; b3++) {
/*      */       aa aa1;
/*  611 */       (aa1 = paramList.get(b3)).a(b2);
/*  612 */       c.a a1 = c1.a(b3);
/*  613 */       paramab.a(b3, aa1);
/*  614 */       paramab.c(-1);
/*  615 */       a(paramab, aa1, a1, 0);
/*  616 */       this.b.k();
/*  617 */       b2++;
/*      */       
/*  619 */       if (!a1.a().isEmpty()) {
/*  620 */         a1.a().size();
/*      */         
/*  622 */         byte b4 = 0;
/*      */         
/*  624 */         int j, k = (j = aa1.d((d)paramab)) * ((aa1.g() == c.ak) ? 1 : -1);
/*      */         
/*  626 */         for (c.a a2 : a1.a()) {
/*      */           
/*  628 */           e e1 = this.u.a(paramb, aa1
/*      */               
/*  630 */               .a((d)paramab) / 26.666666F, aa1
/*  631 */               .b((d)paramab) / 26.666666F);
/*      */           
/*  633 */           g g1 = new g(paramb, e1, g.a.a, !this.m);
/*      */           
/*  635 */           this.b.a(g1, e1, aa1.b((d)paramab) / 26.666666F);
/*  636 */           paramab.c(b4);
/*  637 */           a(paramab, aa1, a2, -k);
/*  638 */           this.b.k();
/*  639 */           k += j * ((aa1.g() == c.ak) ? 1 : -1);
/*      */           
/*  641 */           b2++;
/*  642 */           b4++;
/*      */         } 
/*      */       } 
/*      */       
/*  646 */       if (b3 != i - 1) {
/*  647 */         aa aa2 = paramList.get(b3 + 1);
/*      */ 
/*      */ 
/*      */         
/*  651 */         Rectangle2D.Float float_ = new Rectangle2D.Float(0.0F, 0.0F, aa2.a((d)paramab) / 26.666666F, aa2.b((d)paramab) / 26.666666F);
/*      */ 
/*      */         
/*  654 */         e e1 = this.u.a(paramb, (float)float_.getWidth(), (float)float_.getHeight());
/*      */         
/*  656 */         g g1 = new g(paramb, e1, g.a.a, !this.m);
/*  657 */         this.b.a(g1, e1, (float)float_.getHeight());
/*      */       } 
/*      */     } 
/*      */     
/*  661 */     this.b.c(paramab, (f)this.e);
/*      */   }
/*      */   
/*      */   private void b(List<aa> paramList, ab paramab, Rectangle2D paramRectangle2D, b paramb) {
/*  665 */     this.b.a((f)this.e);
/*  666 */     this.b.a(this.d);
/*      */     
/*  668 */     e e = this.u.a(paramb, (float)paramRectangle2D.getWidth(), (float)paramRectangle2D.getHeight());
/*  669 */     g g = new g(paramb, e, g.a.a, !this.m);
/*      */     
/*  671 */     this.b.a(g, e, (float)paramRectangle2D.getHeight());
/*  672 */     this.e.Z().a((d)paramab, (short)2);
/*      */     
/*  674 */     int i = this.e.Z().k().size();
/*  675 */     paramab.a(i);
/*      */     
/*  677 */     b(paramb);
/*      */     
/*  679 */     if (this.j != x.c.a) {
/*  680 */       a(paramb, this.j.b(), this.j.a());
/*      */     }
/*      */     
/*  683 */     for (byte b1 = 0; b1 < i; b1++) {
/*  684 */       aa aa1 = paramList.get(b1);
/*      */       
/*  686 */       paramab.a(b1, aa1);
/*  687 */       a(paramab, aa1);
/*  688 */       this.b.k();
/*      */       
/*  690 */       if (b1 != i - 1) {
/*  691 */         aa1 = paramList.get(b1 + 1);
/*      */         
/*  693 */         Rectangle2D.Float float_ = new Rectangle2D.Float(0.0F, 0.0F, aa1.a((d)paramab) / 26.666666F, aa1.b((d)paramab) / 26.666666F);
/*      */         
/*  695 */         e e1 = this.u.a(paramb, (float)float_.getWidth(), (float)float_.getHeight());
/*  696 */         g g1 = new g(paramb, e1, g.a.a, !this.m);
/*  697 */         this.b.a(g1, e1, (float)float_.getHeight());
/*      */       } 
/*      */     } 
/*      */     
/*  701 */     this.b.c(paramab, (f)this.e);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(b paramb) {
/*      */     try {
/*  709 */       c c1 = paramb.c();
/*  710 */       String str2 = this.d.getDocumentElement().getAttribute("lang");
/*  711 */       c1.a(!str2.isEmpty() ? str2 : "EN-US");
/*  712 */       c1.a(new org.a.c.h.g.f.a(new d()));
/*  713 */       c1.b().a(true);
/*      */       
/*      */       org.a.c.h.b.a.a a2;
/*  716 */       (a2 = new org.a.c.h.b.a.a()).a(true);
/*  717 */       c1.a(a2);
/*      */       
/*      */       String str1;
/*      */       
/*      */       d d1;
/*  722 */       if ((str1 = ((d1 = paramb.b()).b() != null) ? d1.b() : "").isEmpty()) {
/*  723 */         l.d(Level.WARNING, "No document title provided. Document will not be PDF/UA compliant.");
/*      */       }
/*      */       
/*      */       b b1;
/*  727 */       (b1 = b.a()).j();
/*  728 */       b1.k().c(str1);
/*  729 */       String str3 = this.b.a("description");
/*  730 */       b1.k().b((str3 != null) ? str3 : str1);
/*  731 */       b1.g();
/*  732 */       b1.h().c("http://www.aiim.org/pdfa/ns/schema#", "pdfaSchema");
/*      */       
/*  734 */       b1.h().c("http://www.aiim.org/pdfa/ns/property#", "pdfaProperty");
/*      */       
/*  736 */       b1.h().c("http://www.aiim.org/pdfua/ns/id/", "pdfuaid");
/*      */       
/*      */       l l1;
/*      */       
/*  740 */       (l1 = new l(b.a(), "pdfaSchema", "pdfaSchema", "pdfaSchema")).a("schema", "PDF/UA Universal Accessibility Schema");
/*      */       
/*  742 */       l1.a("namespaceURI", "http://www.aiim.org/pdfua/ns/id/");
/*      */       
/*  744 */       l1.a("prefix", "pdfuaid");
/*      */       
/*      */       l l2;
/*  747 */       (l2 = new l(b.a(), "pdfaProperty", "pdfaProperty", "pdfaProperty")).a("name", "part");
/*  748 */       l2.a("valueType", "Integer");
/*  749 */       l2.a("category", "internal");
/*  750 */       l2.a("description", "Indicates, which part of ISO 14289 standard is followed");
/*      */       
/*  752 */       l1.b("property", (b)l2);
/*  753 */       b1.h().a("schemas", (b)l1);
/*  754 */       b1.h().f("pdfuaid");
/*  755 */       b1.h().a("part", "1");
/*  756 */       org.a.d.c.a a1 = new org.a.d.c.a();
/*  757 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  758 */       a1.a(b1, byteArrayOutputStream, true);
/*      */       f f;
/*  760 */       (f = new f(paramb)).a(byteArrayOutputStream.toByteArray());
/*  761 */       paramb.c().a(f); return;
/*  762 */     } catch (IOException|TransformerException iOException) {
/*  763 */       throw new RuntimeException(iOException);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(b paramb, int paramInt, String paramString) {
/*  768 */     d d1 = paramb.b();
/*  769 */     b b1 = b.a();
/*      */     
/*      */     try {
/*  772 */       String str2 = d1.b();
/*  773 */       String str3 = d1.c();
/*  774 */       String str4 = d1.d();
/*  775 */       String str5 = d1.e();
/*  776 */       String str6 = d1.g();
/*      */ 
/*      */       
/*      */       e e;
/*      */ 
/*      */       
/*  782 */       (e = b1.i()).a(paramString);
/*  783 */       e.a(Integer.valueOf(paramInt));
/*      */       
/*  785 */       org.a.d.a.a a1 = b1.m();
/*  786 */       if (str5 != null) {
/*  787 */         a1.a(str5);
/*      */       }
/*  789 */       if (str6 != null) {
/*  790 */         a1.b(str6);
/*      */       }
/*      */       
/*      */       i i;
/*  794 */       (i = b1.l()).a(d1.h());
/*      */       
/*  796 */       b b2 = b1.j();
/*  797 */       if (str3 != null) {
/*  798 */         b2.a(str3);
/*      */       }
/*  800 */       if (str2 != null) {
/*  801 */         b2.c(str2);
/*      */       }
/*  803 */       if (str4 != null) {
/*  804 */         b2.b(str4);
/*      */       }
/*      */       
/*  807 */       f f = new f(paramb);
/*      */       org.a.c.h.b.a.a a3;
/*  809 */       (a3 = new org.a.c.h.b.a.a()).a(true);
/*      */       
/*      */       c c1;
/*      */       
/*  813 */       (c1 = paramb.c()).a(f);
/*  814 */       c1.a(a3);
/*      */       
/*  816 */       String str1 = this.d.getDocumentElement().getAttribute("lang");
/*  817 */       c1.a(!str1.isEmpty() ? str1 : "EN-US");
/*  818 */       c1.a(new org.a.c.h.g.f.a(new d()));
/*  819 */       c1.b().a(true);
/*      */       
/*  821 */       org.a.d.c.a a2 = new org.a.d.c.a();
/*  822 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  823 */       a2.a(b1, byteArrayOutputStream, true);
/*  824 */       f.a(byteArrayOutputStream.toByteArray());
/*      */       
/*  826 */       if (this.l != null) {
/*  827 */         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.l);
/*      */         s s;
/*  829 */         (s = new s(paramb, byteArrayInputStream)).a("sRGB IEC61966-2.1");
/*  830 */         s.b("sRGB IEC61966-2.1");
/*  831 */         s.c("sRGB IEC61966-2.1");
/*  832 */         s.d("http://www.color.org");
/*  833 */         c1.a(s);
/*      */       }  return;
/*  835 */     } catch (h h) {
/*  836 */       throw new RuntimeException(h);
/*  837 */     } catch (IOException iOException) {
/*  838 */       throw new RuntimeException(iOException);
/*  839 */     } catch (TransformerException transformerException) {
/*  840 */       throw new RuntimeException(transformerException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(b paramb) {
/*      */     d d1;
/*  848 */     (d1 = new d()).a(Calendar.getInstance());
/*      */     
/*  850 */     if (this.i == null) {
/*  851 */       d1.e("openhtmltopdf.com");
/*      */     } else {
/*  853 */       d1.e(this.i);
/*      */     } 
/*      */     
/*  856 */     for (Iterator<t.c> iterator = this.b.n().iterator(); iterator.hasNext();) {
/*      */       
/*  858 */       if (!(str = (c1 = iterator.next()).b()).isEmpty()) {
/*      */         String str1;
/*      */         
/*  861 */         if ((str1 = c1.a()) != null) {
/*      */           
/*  863 */           if (str.equals("title")) {
/*  864 */             d1.a(str1); continue;
/*  865 */           }  if (str.equals("author")) {
/*  866 */             d1.b(str1); continue;
/*  867 */           }  if (str.equals("subject")) {
/*  868 */             d1.c(str1); continue;
/*  869 */           }  if (str.equals("keywords")) {
/*  870 */             d1.d(str1); continue;
/*      */           } 
/*  872 */           d1.a(str, str1);
/*      */         } 
/*      */       } 
/*  875 */     }  paramb.a(d1);
/*      */   }
/*      */   
/*      */   private void a(ab paramab, aa paramaa, c.a parama, int paramInt) {
/*  879 */     paramaa.b(paramab, 0, (short)2);
/*      */     
/*  881 */     paramab.b(true);
/*  882 */     paramaa.c(paramab, 0, (short)2);
/*  883 */     paramab.b(false);
/*      */     
/*  885 */     paramaa.a(paramab, 0, (short)2);
/*      */     
/*  887 */     Rectangle rectangle = paramaa.f((d)paramab);
/*  888 */     this.b.f(rectangle);
/*      */     
/*  890 */     int j = -paramaa.d() + paramaa.d((d)paramab, 3);
/*      */ 
/*      */ 
/*      */     
/*  894 */     int i = (i = paramaa.d((d)paramab, 1)) + paramInt;
/*      */     
/*  896 */     this.b.a(i, j);
/*      */     d d1;
/*  898 */     (d1 = new d()).a(paramab, parama);
/*  899 */     this.b.a(-i, -j);
/*      */     
/*  901 */     this.b.h();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(ab paramab, aa paramaa) {
/*  907 */     paramaa.b(paramab, 0, (short)2);
/*  908 */     paramaa.c(paramab, 0, (short)2);
/*  909 */     paramaa.a(paramab, 0, (short)2);
/*      */     
/*  911 */     Shape shape = this.b.c();
/*      */     
/*  913 */     Rectangle rectangle = paramaa.f((d)paramab);
/*  914 */     this.b.d(rectangle);
/*      */     
/*  916 */     int j = -paramaa.d() + paramaa.d((d)paramab, 3);
/*      */     
/*  918 */     int i = paramaa.d((d)paramab, 1);
/*      */     
/*  920 */     this.b.a(i, j);
/*  921 */     this.e.Z().a(paramab);
/*  922 */     this.b.a(-i, -j);
/*      */     
/*  924 */     this.b.e(shape);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private aa g() {
/*  994 */     return this.a;
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
/*      */   static final class a
/*      */     implements t
/*      */   {
/*      */     private a() {}
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
/*      */   @Deprecated
/*      */   private void h() {
/* 1048 */     this.b.m();
/* 1049 */     aa.B();
/* 1050 */     i.b();
/*      */ 
/*      */     
/* 1053 */     ((f)g().c()).a();
/*      */     
/* 1055 */     if (this.o != null) {
/*      */       try {
/* 1057 */         this.o.close();
/* 1058 */       } catch (IOException iOException) {}
/*      */     }
/*      */ 
/*      */     
/* 1062 */     if (this.p != null) {
/*      */       try {
/* 1064 */         this.p.close(); return;
/* 1065 */       } catch (IOException iOException) {}
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void close() {
/* 1075 */     h();
/*      */   }
/*      */ 
/*      */   
/*      */   public final e a(b paramb, float paramFloat1, float paramFloat2) {
/* 1080 */     e e = new e(new h(paramFloat1, paramFloat2));
/* 1081 */     paramb.a(e);
/* 1082 */     return e;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */