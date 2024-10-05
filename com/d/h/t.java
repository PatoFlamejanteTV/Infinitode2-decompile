/*      */ package com.d.h;
/*      */ 
/*      */ import com.a.a.a.am;
/*      */ import com.a.a.c.k.b.ak;
/*      */ import com.d.c.d.f;
/*      */ import com.d.c.d.g;
/*      */ import com.d.c.d.h;
/*      */ import com.d.c.f.d;
/*      */ import com.d.d.n;
/*      */ import com.d.d.q;
/*      */ import com.d.e.aa;
/*      */ import com.d.i.a;
/*      */ import com.d.i.aa;
/*      */ import com.d.i.ab;
/*      */ import com.d.i.f;
/*      */ import com.d.i.k;
/*      */ import com.d.i.r;
/*      */ import com.d.m.l;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Shape;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.awt.geom.Area;
/*      */ import java.awt.geom.Ellipse2D;
/*      */ import java.awt.geom.Line2D;
/*      */ import java.awt.geom.NoninvertibleTransformException;
/*      */ import java.awt.geom.PathIterator;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.util.ArrayDeque;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Deque;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.logging.Level;
/*      */ import javax.imageio.ImageIO;
/*      */ import org.a.c.b.j;
/*      */ import org.a.c.h.e;
/*      */ import org.a.c.h.e.u;
/*      */ import org.a.c.h.g;
/*      */ import org.a.c.h.g.d.a.d;
/*      */ import org.w3c.dom.Document;
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
/*      */ public class t
/*      */   extends a
/*      */   implements m
/*      */ {
/*      */   static {
/*   93 */     a = new AffineTransform();
/*   94 */     b = new BasicStroke(1.0F);
/*      */     
/*   96 */     c = com.d.m.b.a("xr.pdf.round.rect.dimensions.down", false);
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
/*  116 */   private AffineTransform h = new AffineTransform();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  122 */   private final Deque<AffineTransform> i = new ArrayDeque<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  129 */   private float k = 0.0F;
/*  130 */   private float l = 0.0F;
/*      */ 
/*      */ 
/*      */   
/*  134 */   private g m = (g)h.e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  144 */   private Stroke p = null;
/*      */ 
/*      */   
/*  147 */   private Stroke q = null;
/*      */ 
/*      */ 
/*      */   
/*  151 */   private Stroke r = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  170 */   private final List<a> x = new ArrayList<>();
/*      */ 
/*      */   
/*  173 */   private final List<c> y = new ArrayList<>();
/*      */ 
/*      */   
/*  176 */   private final o z = new o();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  199 */   private com.d.a.a E = (com.d.a.a)new ak(); private static final AffineTransform a; private static final BasicStroke b; private static final boolean c; private e d; private w e; private float f; private b g;
/*      */   private int j;
/*      */   private g n;
/*      */   private g o;
/*      */   
/*      */   public t(float paramFloat, boolean paramBoolean) {
/*  205 */     this.u = 26.666666F;
/*      */   }
/*      */   private Area s; private aa t; private float u; private org.a.c.h.b v; private org.a.c.h.g.d.a.a w; private f A; private int B; private k C; private ab D; private a.a.a.a.a F;
/*      */   
/*      */   public final void a(org.a.c.h.b paramb) {
/*  210 */     this.v = paramb;
/*      */   }
/*      */   
/*      */   public final org.a.c.h.b j() {
/*  214 */     return this.v;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(g paramg, e parame, float paramFloat) {
/*  222 */     this.e = new w(paramg);
/*  223 */     this.d = parame;
/*  224 */     this.f = paramFloat;
/*      */     
/*  226 */     if (!i())
/*      */     {
/*      */       
/*  229 */       this.e.i();
/*      */     }
/*      */     
/*  232 */     this.h = new AffineTransform();
/*  233 */     this.h.scale(1.0D / this.u, 1.0D / this.u);
/*      */     
/*  235 */     this.k = 0.0F;
/*  236 */     this.l += paramFloat * this.u;
/*      */     
/*  238 */     this.p = b(b);
/*  239 */     this.q = this.p;
/*  240 */     this.r = this.p;
/*      */     
/*  242 */     a(this.p, (Stroke)null);
/*      */     
/*  244 */     if (this.w == null) {
/*      */       org.a.c.h.g.d.a.c c;
/*      */       
/*  247 */       (c = new org.a.c.h.g.d.a.c()).a(parame);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void k() {
/*  252 */     if (!i()) {
/*  253 */       this.e.h();
/*      */     }
/*      */     
/*  256 */     this.e.b();
/*      */   }
/*      */   
/*      */   public final void a(ab paramab, com.d.i.c paramc) {
/*      */     n n;
/*  261 */     (n = paramc.E()).a(paramab, this, paramc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void b(ab paramab, f paramf) {
/*  269 */     super.b(paramab, paramf);
/*      */ 
/*      */     
/*  272 */     this.C.a(paramab, paramf, this.d, this.f, this.h);
/*      */     
/*  274 */     if (paramf.ai() != null && paramf.ai().getNodeName().equals("form")) {
/*  275 */       this.z.a(paramf, this); return;
/*  276 */     }  if (paramf.ai() != null && 
/*  277 */       com.d.m.a.a(paramf.ai().getNodeName(), (Object[])new String[] { "input", "textarea", "button", "select", "openhtmltopdf-combo"
/*      */         }))
/*      */     {
/*  280 */       this.z.a(paramf, this.d, this.h, paramab, this.f);
/*      */     }
/*      */   }
/*      */   
/*      */   private void p() {
/*  285 */     this.z.a(this.t, this.v, this.A);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final float a(float paramFloat) {
/*  294 */     return paramFloat / this.u;
/*      */   }
/*      */   
/*      */   public final void a(Shape paramShape) {
/*  298 */     b(paramShape);
/*      */   }
/*      */   
/*      */   public final void a(g paramg) {
/*  302 */     if (paramg instanceof h) {
/*  303 */       this.m = paramg; return;
/*  304 */     }  if (paramg instanceof f) {
/*  305 */       this.m = paramg; return;
/*      */     } 
/*  307 */     if (!G && !(this.m instanceof h) && !(this.m instanceof f)) throw new AssertionError();
/*      */   
/*      */   }
/*      */   
/*      */   public final void b(Shape paramShape) {
/*  312 */     a(paramShape, 2);
/*      */   }
/*      */   
/*      */   protected final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  316 */     Line2D.Double double_ = new Line2D.Double(paramInt1, paramInt2, paramInt3, paramInt4);
/*  317 */     b(double_);
/*      */   }
/*      */   
/*      */   public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  321 */     b(new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4));
/*      */   }
/*      */   
/*      */   public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  325 */     Ellipse2D.Float float_ = new Ellipse2D.Float(paramInt1, paramInt2, paramInt3, paramInt4);
/*  326 */     b(float_);
/*      */   }
/*      */   
/*      */   public final void c(Shape paramShape) {
/*  330 */     a(paramShape, 1);
/*      */   }
/*      */   
/*      */   public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  334 */     if (c) {
/*  335 */       c(new Rectangle(paramInt1, paramInt2, paramInt3 - 1, paramInt4 - 1)); return;
/*      */     } 
/*  337 */     c(new Rectangle(paramInt1, paramInt2, paramInt3, paramInt4));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  342 */     Ellipse2D.Float float_ = new Ellipse2D.Float(paramInt1, paramInt2, paramInt3, paramInt4);
/*  343 */     c(float_);
/*      */   }
/*      */   
/*      */   public final void a(double paramDouble1, double paramDouble2) {
/*  347 */     this.h.translate(paramDouble1, paramDouble2);
/*      */   }
/*      */   
/*      */   public final Object e() {
/*  351 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(k paramk) {
/*  358 */     this.g = (b)paramk;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private AffineTransform b(AffineTransform paramAffineTransform) {
/*  365 */     double[] arrayOfDouble = new double[6];
/*      */     AffineTransform affineTransform;
/*  367 */     (affineTransform = new AffineTransform()).getMatrix(arrayOfDouble);
/*  368 */     arrayOfDouble[3] = -1.0D;
/*  369 */     arrayOfDouble[5] = this.f;
/*      */     
/*  371 */     (affineTransform = new AffineTransform(arrayOfDouble)).concatenate(paramAffineTransform);
/*  372 */     return affineTransform;
/*      */   }
/*      */   
/*      */   public final void a(String paramString, float paramFloat1, float paramFloat2, com.d.i.t paramt) {
/*  376 */     u u = ((f.b)this.g.b().get(0)).c();
/*      */ 
/*      */     
/*      */     try {
/*  380 */       u.b(paramString);
/*      */       
/*  382 */       a(paramString, paramFloat1, paramFloat2, paramt, this.g.b().get(0), this.g.a());
/*      */       
/*      */       return;
/*  385 */     } catch (Exception exception) {
/*      */ 
/*      */ 
/*      */       
/*  389 */       List<b> list = u.a(this.g, paramString, this.E);
/*      */       
/*  391 */       float f1 = 0.0F;
/*  392 */       for (b b1 : list) {
/*  393 */         a(b1.a, paramFloat1 + f1, paramFloat2, paramt, b1.b, this.g.a());
/*      */         try {
/*  395 */           f1 += b1.b.c().b(b1.a) / 1000.0F * this.g.a();
/*  396 */         } catch (Exception exception1) {
/*  397 */           l.g(Level.WARNING, "BUG. Font didn't contain expected character.", exception1);
/*      */         } 
/*      */       } 
/*      */       return;
/*      */     } 
/*      */   } private void a(String paramString, float paramFloat1, float paramFloat2, com.d.i.t paramt, f.b paramb, float paramFloat3) {
/*  403 */     if (paramString.length() == 0) {
/*      */       return;
/*      */     }
/*  406 */     r();
/*      */     AffineTransform affineTransform3;
/*  408 */     (affineTransform3 = (AffineTransform)q().clone()).translate(paramFloat1, paramFloat2);
/*  409 */     AffineTransform affineTransform1 = b(affineTransform3);
/*  410 */     AffineTransform affineTransform2 = AffineTransform.getScaleInstance(1.0D, -1.0D);
/*  411 */     affineTransform1.concatenate(affineTransform2);
/*  412 */     affineTransform1.scale(this.u, this.u);
/*  413 */     double[] arrayOfDouble = new double[6];
/*  414 */     affineTransform1.getMatrix(arrayOfDouble);
/*      */     
/*  416 */     float f1 = (float)arrayOfDouble[1];
/*  417 */     float f2 = (float)arrayOfDouble[2];
/*      */     
/*  419 */     paramFloat3 /= this.u;
/*      */     
/*  421 */     boolean bool = false;
/*      */     com.d.c.g.a a1;
/*  423 */     if ((a1 = o()) != null) {
/*  424 */       int i = com.a.a.b.c.a.a(a1.b);
/*  425 */       int j = paramb.a();
/*  426 */       if (i > j) {
/*  427 */         this.e.a(org.a.c.h.f.e.a.b);
/*  428 */         float f3 = paramFloat3 * 0.04F;
/*  429 */         this.e.a(f3);
/*  430 */         bool = true;
/*  431 */         s();
/*      */       } 
/*  433 */       if (a1.d == com.d.c.a.c.W && paramb.b() != com.d.c.a.c.W) {
/*  434 */         f1 = 0.0F;
/*  435 */         f2 = 0.21256F;
/*      */       } 
/*      */     } 
/*      */     
/*  439 */     this.e.j();
/*      */     
/*  441 */     this.e.a(paramb.c(), paramFloat3);
/*  442 */     this.e.b((float)arrayOfDouble[0], f1, f2, (float)arrayOfDouble[3], (float)arrayOfDouble[4], (float)arrayOfDouble[5]);
/*      */     
/*  444 */     if (paramt != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  449 */       Object[] arrayOfObject = a(paramString, paramt);
/*  450 */       this.e.a(arrayOfObject);
/*      */     } else {
/*  452 */       this.e.a(paramString);
/*      */     } 
/*      */     
/*  455 */     this.e.k();
/*      */     
/*  457 */     if (bool) {
/*  458 */       this.e.a(org.a.c.h.f.e.a.a);
/*  459 */       this.e.a(1.0F);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static class b {
/*      */     String a;
/*      */     f.b b;
/*      */     int c;
/*      */     int d;
/*      */   }
/*      */   
/*      */   private Object[] a(String paramString, com.d.i.t paramt) {
/*  471 */     ArrayList<String> arrayList = new ArrayList(paramString.length() << 1);
/*      */     
/*  473 */     int i = paramString.length();
/*  474 */     for (byte b1 = 0; b1 < i; b1++) {
/*  475 */       char c = paramString.charAt(b1);
/*  476 */       arrayList.add(Character.toString(c));
/*  477 */       if (b1 != i - 1) {
/*      */         float f1;
/*  479 */         if (c == ' ' || c == ' ' || c == '　') {
/*  480 */           f1 = paramt.b();
/*      */         } else {
/*  482 */           f1 = paramt.a();
/*      */         } 
/*  484 */         arrayList.add(Float.valueOf(-f1 / this.u * 1000.0F / this.g.a() / this.u));
/*      */       } 
/*      */     } 
/*  487 */     return arrayList.toArray();
/*      */   }
/*      */   
/*      */   private AffineTransform q() {
/*  491 */     return this.h;
/*      */   }
/*      */   
/*      */   private void r() {
/*  495 */     if (!this.m.equals(this.n)) {
/*  496 */       this.n = this.m;
/*      */       
/*  498 */       if (this.n instanceof h) {
/*  499 */         h h = (h)this.n;
/*  500 */         this.e.b(h.c(), h.b(), h.a()); return;
/*  501 */       }  if (this.n instanceof f) {
/*  502 */         f f1 = (f)this.n;
/*  503 */         this.e.d(f1.a(), f1.b(), f1.c(), f1.d());
/*      */         return;
/*      */       } 
/*  506 */       if (!G && !(this.n instanceof h) && !(this.n instanceof f)) throw new AssertionError();
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   private void s() {
/*  512 */     if (!this.m.equals(this.o)) {
/*  513 */       this.o = this.m;
/*      */       
/*  515 */       if (this.o instanceof h) {
/*  516 */         h h = (h)this.o;
/*  517 */         this.e.a(h.c(), h.b(), h.a()); return;
/*  518 */       }  if (this.o instanceof f) {
/*  519 */         f f1 = (f)this.o;
/*  520 */         this.e.c(f1.a(), f1.b(), f1.c(), f1.d());
/*      */         return;
/*      */       } 
/*  523 */       if (!G && !(this.o instanceof h) && !(this.o instanceof f)) throw new AssertionError();
/*      */     
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
/*      */   private void a(Shape paramShape, int paramInt) {
/*      */     PathIterator pathIterator;
/*  537 */     if (paramShape == null) {
/*      */       return;
/*      */     }
/*  540 */     if (paramInt == 2 && 
/*  541 */       !(this.p instanceof BasicStroke)) {
/*  542 */       paramShape = this.p.createStrokedShape(paramShape);
/*  543 */       a(paramShape, 1);
/*      */       
/*      */       return;
/*      */     } 
/*  547 */     if (paramInt == 2) {
/*  548 */       a(this.p, this.r);
/*  549 */       this.r = this.p;
/*  550 */       s();
/*  551 */     } else if (paramInt == 1) {
/*  552 */       r();
/*      */     } 
/*      */ 
/*      */     
/*  556 */     if (paramInt == 3) {
/*  557 */       pathIterator = paramShape.getPathIterator(a);
/*      */     } else {
/*  559 */       pathIterator = pathIterator.getPathIterator(this.h);
/*      */     } 
/*  561 */     float[] arrayOfFloat = new float[6];
/*  562 */     byte b1 = 0;
/*  563 */     while (!pathIterator.isDone()) {
/*  564 */       b1++;
/*  565 */       int i = pathIterator.currentSegment(arrayOfFloat);
/*  566 */       a(arrayOfFloat);
/*  567 */       switch (i) {
/*      */         case 4:
/*  569 */           this.e.a();
/*      */           break;
/*      */         
/*      */         case 3:
/*  573 */           this.e.a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], arrayOfFloat[4], arrayOfFloat[5]);
/*      */           break;
/*      */         
/*      */         case 1:
/*  577 */           this.e.a(arrayOfFloat[0], arrayOfFloat[1]);
/*      */           break;
/*      */         
/*      */         case 0:
/*  581 */           this.e.b(arrayOfFloat[0], arrayOfFloat[1]);
/*      */           break;
/*      */         
/*      */         case 2:
/*  585 */           this.e.b(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
/*      */           break;
/*      */       } 
/*  588 */       pathIterator.next();
/*      */     } 
/*      */     
/*  591 */     switch (paramInt) {
/*      */       case 1:
/*  593 */         if (b1 > 0) {
/*  594 */           if (pathIterator.getWindingRule() == 0) {
/*  595 */             this.e.c(); return;
/*      */           } 
/*  597 */           this.e.d(); return;
/*      */         } 
/*      */         return;
/*      */       case 2:
/*  601 */         if (b1 > 0) {
/*  602 */           this.e.e(); return;
/*      */         }  return;
/*      */     } 
/*  605 */     if (b1 == 0)
/*  606 */       this.e.a(0.0F, 0.0F, 0.0F, 0.0F); 
/*  607 */     if (pathIterator.getWindingRule() == 0) {
/*  608 */       this.e.g(); return;
/*      */     } 
/*  610 */     this.e.f();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private float b(float paramFloat) {
/*  619 */     return this.f - paramFloat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final float a(float paramFloat1, float paramFloat2) {
/*  626 */     return paramFloat2 - paramFloat1;
/*      */   }
/*      */   
/*      */   private void a(float[] paramArrayOffloat) {
/*  630 */     paramArrayOffloat[1] = b(paramArrayOffloat[1]);
/*  631 */     paramArrayOffloat[3] = b(paramArrayOffloat[3]);
/*  632 */     paramArrayOffloat[5] = b(paramArrayOffloat[5]);
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
/*      */   private void a(Stroke paramStroke1, Stroke paramStroke2) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: aload_2
/*      */     //   2: if_acmpne -> 6
/*      */     //   5: return
/*      */     //   6: aload_1
/*      */     //   7: instanceof java/awt/BasicStroke
/*      */     //   10: ifne -> 14
/*      */     //   13: return
/*      */     //   14: aload_1
/*      */     //   15: checkcast java/awt/BasicStroke
/*      */     //   18: astore_1
/*      */     //   19: aload_2
/*      */     //   20: instanceof java/awt/BasicStroke
/*      */     //   23: istore_3
/*      */     //   24: aconst_null
/*      */     //   25: astore #4
/*      */     //   27: iload_3
/*      */     //   28: ifeq -> 37
/*      */     //   31: aload_2
/*      */     //   32: checkcast java/awt/BasicStroke
/*      */     //   35: astore #4
/*      */     //   37: iload_3
/*      */     //   38: ifeq -> 54
/*      */     //   41: aload_1
/*      */     //   42: invokevirtual getLineWidth : ()F
/*      */     //   45: aload #4
/*      */     //   47: invokevirtual getLineWidth : ()F
/*      */     //   50: fcmpl
/*      */     //   51: ifeq -> 65
/*      */     //   54: aload_0
/*      */     //   55: getfield e : Lcom/d/h/w;
/*      */     //   58: aload_1
/*      */     //   59: invokevirtual getLineWidth : ()F
/*      */     //   62: invokevirtual a : (F)V
/*      */     //   65: iload_3
/*      */     //   66: ifeq -> 81
/*      */     //   69: aload_1
/*      */     //   70: invokevirtual getEndCap : ()I
/*      */     //   73: aload #4
/*      */     //   75: invokevirtual getEndCap : ()I
/*      */     //   78: if_icmpeq -> 142
/*      */     //   81: aload_1
/*      */     //   82: invokevirtual getEndCap : ()I
/*      */     //   85: lookupswitch default -> 134, 0 -> 112, 2 -> 123
/*      */     //   112: aload_0
/*      */     //   113: getfield e : Lcom/d/h/w;
/*      */     //   116: iconst_0
/*      */     //   117: invokevirtual a : (I)V
/*      */     //   120: goto -> 142
/*      */     //   123: aload_0
/*      */     //   124: getfield e : Lcom/d/h/w;
/*      */     //   127: iconst_2
/*      */     //   128: invokevirtual a : (I)V
/*      */     //   131: goto -> 142
/*      */     //   134: aload_0
/*      */     //   135: getfield e : Lcom/d/h/w;
/*      */     //   138: iconst_1
/*      */     //   139: invokevirtual a : (I)V
/*      */     //   142: iload_3
/*      */     //   143: ifeq -> 158
/*      */     //   146: aload_1
/*      */     //   147: invokevirtual getLineJoin : ()I
/*      */     //   150: aload #4
/*      */     //   152: invokevirtual getLineJoin : ()I
/*      */     //   155: if_icmpeq -> 218
/*      */     //   158: aload_1
/*      */     //   159: invokevirtual getLineJoin : ()I
/*      */     //   162: lookupswitch default -> 210, 0 -> 188, 2 -> 199
/*      */     //   188: aload_0
/*      */     //   189: getfield e : Lcom/d/h/w;
/*      */     //   192: iconst_0
/*      */     //   193: invokevirtual b : (I)V
/*      */     //   196: goto -> 218
/*      */     //   199: aload_0
/*      */     //   200: getfield e : Lcom/d/h/w;
/*      */     //   203: iconst_2
/*      */     //   204: invokevirtual b : (I)V
/*      */     //   207: goto -> 218
/*      */     //   210: aload_0
/*      */     //   211: getfield e : Lcom/d/h/w;
/*      */     //   214: iconst_1
/*      */     //   215: invokevirtual b : (I)V
/*      */     //   218: iload_3
/*      */     //   219: ifeq -> 235
/*      */     //   222: aload_1
/*      */     //   223: invokevirtual getMiterLimit : ()F
/*      */     //   226: aload #4
/*      */     //   228: invokevirtual getMiterLimit : ()F
/*      */     //   231: fcmpl
/*      */     //   232: ifeq -> 246
/*      */     //   235: aload_0
/*      */     //   236: getfield e : Lcom/d/h/w;
/*      */     //   239: aload_1
/*      */     //   240: invokevirtual getMiterLimit : ()F
/*      */     //   243: invokevirtual b : (F)V
/*      */     //   246: iload_3
/*      */     //   247: ifeq -> 303
/*      */     //   250: aload_1
/*      */     //   251: invokevirtual getDashArray : ()[F
/*      */     //   254: ifnull -> 290
/*      */     //   257: aload_1
/*      */     //   258: invokevirtual getDashPhase : ()F
/*      */     //   261: aload #4
/*      */     //   263: invokevirtual getDashPhase : ()F
/*      */     //   266: fcmpl
/*      */     //   267: ifne -> 303
/*      */     //   270: aload_1
/*      */     //   271: invokevirtual getDashArray : ()[F
/*      */     //   274: aload #4
/*      */     //   276: invokevirtual getDashArray : ()[F
/*      */     //   279: invokestatic equals : ([F[F)Z
/*      */     //   282: ifeq -> 303
/*      */     //   285: iconst_0
/*      */     //   286: istore_2
/*      */     //   287: goto -> 305
/*      */     //   290: aload #4
/*      */     //   292: invokevirtual getDashArray : ()[F
/*      */     //   295: ifnonnull -> 303
/*      */     //   298: iconst_0
/*      */     //   299: istore_2
/*      */     //   300: goto -> 305
/*      */     //   303: iconst_1
/*      */     //   304: istore_2
/*      */     //   305: iload_2
/*      */     //   306: ifeq -> 342
/*      */     //   309: aload_1
/*      */     //   310: invokevirtual getDashArray : ()[F
/*      */     //   313: dup
/*      */     //   314: astore_2
/*      */     //   315: ifnonnull -> 330
/*      */     //   318: aload_0
/*      */     //   319: getfield e : Lcom/d/h/w;
/*      */     //   322: iconst_0
/*      */     //   323: newarray float
/*      */     //   325: fconst_0
/*      */     //   326: invokevirtual a : ([FF)V
/*      */     //   329: return
/*      */     //   330: aload_0
/*      */     //   331: getfield e : Lcom/d/h/w;
/*      */     //   334: aload_2
/*      */     //   335: aload_1
/*      */     //   336: invokevirtual getDashPhase : ()F
/*      */     //   339: invokevirtual a : ([FF)V
/*      */     //   342: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #636	-> 0
/*      */     //   #637	-> 5
/*      */     //   #638	-> 6
/*      */     //   #639	-> 13
/*      */     //   #640	-> 14
/*      */     //   #641	-> 19
/*      */     //   #642	-> 24
/*      */     //   #643	-> 27
/*      */     //   #644	-> 31
/*      */     //   #645	-> 37
/*      */     //   #646	-> 54
/*      */     //   #647	-> 65
/*      */     //   #648	-> 81
/*      */     //   #650	-> 112
/*      */     //   #651	-> 120
/*      */     //   #653	-> 123
/*      */     //   #654	-> 131
/*      */     //   #656	-> 134
/*      */     //   #659	-> 142
/*      */     //   #660	-> 158
/*      */     //   #662	-> 188
/*      */     //   #663	-> 196
/*      */     //   #665	-> 199
/*      */     //   #666	-> 207
/*      */     //   #668	-> 210
/*      */     //   #671	-> 218
/*      */     //   #672	-> 235
/*      */     //   #674	-> 246
/*      */     //   #675	-> 250
/*      */     //   #676	-> 257
/*      */     //   #678	-> 270
/*      */     //   #681	-> 285
/*      */     //   #682	-> 290
/*      */     //   #685	-> 298
/*      */     //   #687	-> 303
/*      */     //   #689	-> 305
/*      */     //   #690	-> 309
/*      */     //   #691	-> 314
/*      */     //   #692	-> 318
/*      */     //   #694	-> 330
/*      */     //   #697	-> 342
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
/*      */   public final void a(Stroke paramStroke) {
/*  700 */     this.q = paramStroke;
/*  701 */     this.p = b(paramStroke);
/*      */   }
/*      */   
/*      */   private Stroke b(Stroke paramStroke) {
/*  705 */     if (!(paramStroke instanceof BasicStroke))
/*  706 */       return paramStroke; 
/*  707 */     paramStroke = paramStroke;
/*  708 */     float f1 = (float)Math.sqrt(Math.abs(this.h.getDeterminant()));
/*      */     float[] arrayOfFloat;
/*  710 */     if ((arrayOfFloat = paramStroke.getDashArray()) != null)
/*  711 */       for (byte b1 = 0; b1 < arrayOfFloat.length; b1++) {
/*  712 */         arrayOfFloat[b1] = arrayOfFloat[b1] * f1;
/*      */       } 
/*  714 */     return new BasicStroke(paramStroke.getLineWidth() * f1, paramStroke.getEndCap(), paramStroke.getLineJoin(), paramStroke.getMiterLimit(), arrayOfFloat, paramStroke.getDashPhase() * f1);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void d(Shape paramShape) {
/*  719 */     if (i()) {
/*  720 */       l.h(Level.SEVERE, "clip MUST not be used by the fast renderer. Please consider reporting this bug.");
/*      */       
/*      */       return;
/*      */     } 
/*  724 */     if (paramShape != null) {
/*  725 */       paramShape = this.h.createTransformedShape(paramShape);
/*  726 */       if (this.s == null) {
/*  727 */         this.s = new Area(paramShape);
/*      */       } else {
/*  729 */         this.s.intersect(new Area(paramShape));
/*  730 */       }  a(paramShape, 3); return;
/*      */     } 
/*  732 */     if (!G && paramShape == null) throw new AssertionError();
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public final Shape c() {
/*  738 */     if (i()) {
/*  739 */       l.h(Level.SEVERE, "getClip MUST not be used by the fast renderer. Please consider reporting this bug.");
/*  740 */       return null;
/*      */     } 
/*      */     
/*      */     try {
/*  744 */       return this.h.createInverse().createTransformedShape(this.s);
/*  745 */     } catch (NoninvertibleTransformException noninvertibleTransformException) {
/*  746 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void h() {
/*  752 */     this.e.h();
/*  753 */     u();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void f(Shape paramShape) {
/*  758 */     this.e.i();
/*  759 */     if (paramShape != null) {
/*  760 */       paramShape = this.h.createTransformedShape(paramShape);
/*  761 */       a(paramShape, 3);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void e(Shape paramShape) {
/*  767 */     if (i()) {
/*  768 */       l.h(Level.SEVERE, "setClip MUST not be used by the fast renderer. Please consider reporting this bug.");
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  773 */     this.e.h();
/*      */ 
/*      */     
/*  776 */     t();
/*      */ 
/*      */     
/*  779 */     this.e.i();
/*      */ 
/*      */ 
/*      */     
/*  783 */     this.j = this.i.size();
/*      */     
/*  785 */     if (paramShape != null)
/*  786 */       paramShape = this.h.createTransformedShape(paramShape); 
/*  787 */     if (paramShape == null) {
/*  788 */       this.s = null;
/*      */     } else {
/*  790 */       this.s = new Area(paramShape);
/*  791 */       a(paramShape, 3);
/*      */     } 
/*      */     
/*  794 */     u();
/*      */   }
/*      */   
/*      */   public final Stroke d() {
/*  798 */     return this.q;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(i parami) {
/*      */     try {
/*  804 */       if (parami.g()) {
/*  805 */         org.a.c.h.f.c.b b1 = am.a(this.v, new ByteArrayInputStream(parami
/*  806 */               .c()));
/*      */       } else {
/*  808 */         BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(parami
/*  809 */               .c()));
/*      */         
/*  811 */         org.a.c.h.f.c.b b1 = org.a.c.h.f.c.a.a(this.v, bufferedImage);
/*      */       } 
/*  813 */     } catch (IOException iOException) {
/*  814 */       throw new w.a("realizeImage", iOException);
/*      */     } 
/*  816 */     parami.d();
/*  817 */     parami.a((org.a.c.h.f.c.b)iOException);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(com.d.d.c paramc, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  823 */     org.a.c.h.f.c.b b1 = (paramc = paramc).e();
/*  824 */     if (paramBoolean) {
/*  825 */       b1.a(true);
/*      */     } else {
/*      */ 
/*      */       
/*      */       try {
/*      */ 
/*      */         
/*  832 */         InputStream inputStream = b1.c().a().j();
/*      */         
/*      */         org.a.c.h.f.c.b b2;
/*      */         
/*  836 */         (b2 = new org.a.c.h.f.c.b(this.v, inputStream, (org.a.c.b.b)j.bc, b1.h(), b1.g(), b1.d(), b1.e())).a(false);
/*  837 */         if (b1.a() != null)
/*  838 */           b2.b().a(j.ds, (org.a.c.h.a.c)b1.a()); 
/*  839 */         inputStream.close();
/*  840 */         b1 = b2;
/*  841 */       } catch (IOException iOException) {
/*  842 */         throw new RuntimeException(iOException);
/*      */       } 
/*      */     } 
/*      */     
/*      */     AffineTransform affineTransform1;
/*      */     
/*  848 */     (affineTransform1 = (AffineTransform)q().clone()).translate(paramInt1, paramInt2);
/*  849 */     affineTransform1.translate(0.0D, paramc.b());
/*      */     AffineTransform affineTransform2;
/*  851 */     (affineTransform2 = b(affineTransform1)).scale(paramc.a(), -paramc.b());
/*      */     
/*  853 */     double[] arrayOfDouble = new double[6];
/*  854 */     affineTransform2.getMatrix(arrayOfDouble);
/*      */     
/*  856 */     this.e.a(b1, (float)arrayOfDouble[4], (float)arrayOfDouble[5], (float)arrayOfDouble[0], (float)arrayOfDouble[3]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(org.a.c.h.f.b.a parama, Rectangle paramRectangle, float paramFloat1, float paramFloat2) {
/*  862 */     throw new UnsupportedOperationException("Use the fast mode!");
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
/*      */   public final void a(Document paramDocument) {
/*  911 */     this.C = new k(this.t, this.u, this.A, this);
/*  912 */     b(paramDocument);
/*  913 */     c(paramDocument);
/*      */   }
/*      */   
/*      */   public final void c(ab paramab, f paramf) {
/*  917 */     p();
/*  918 */     this.C.a();
/*  919 */     d(paramab, paramf);
/*      */   }
/*      */   
/*      */   private void d(ab paramab, f paramf) {
/*  923 */     if (this.x.size() > 0) {
/*      */       org.a.c.h.g.d.b.a a1;
/*      */ 
/*      */       
/*  927 */       if ((a1 = this.v.c().c()) == null) {
/*  928 */         a1 = new org.a.c.h.g.d.b.a();
/*  929 */         this.v.c().a(a1);
/*      */       } 
/*      */       
/*  932 */       a(paramab, paramf, (org.a.c.h.g.d.b.c)a1, this.x);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(ab paramab, f paramf, org.a.c.h.g.d.b.c paramc, List<a> paramList) {
/*  937 */     for (a a1 : paramList)
/*  938 */       a(paramab, paramf, paramc, a1); 
/*      */   }
/*      */   
/*      */   public final int b(f paramf) {
/*      */     r r;
/*  943 */     if (paramf instanceof r)
/*      */     {
/*  945 */       return (r = (r)paramf).aa() + r.c();
/*      */     }
/*  947 */     return r.aa();
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(ab paramab, f paramf, org.a.c.h.g.d.b.c paramc, a parama) {
/*  952 */     String str = parama.a();
/*  953 */     d d = null; f f1;
/*  954 */     if (str.length() > 0 && str.charAt(0) == '#' && (
/*      */       
/*  956 */       f1 = this.t.a(str.substring(1))) != null) {
/*      */       aa aa1;
/*      */       
/*  959 */       int i = (i = (aa1 = paramf.Z().a((d)paramab, b(f1))).d((d)paramab, 3)) + f1.aa() - aa1.b();
/*      */ 
/*      */       
/*  962 */       (d = new d()).a((int)b(i / this.u));
/*  963 */       d.a(this.v.a(this.B + aa1.i()));
/*      */     } 
/*      */     
/*      */     org.a.c.h.g.d.b.b b1;
/*      */     
/*  968 */     (b1 = new org.a.c.h.g.d.b.b()).a((d == null) ? this.w : (org.a.c.h.g.d.a.a)d);
/*  969 */     b1.a(parama.b());
/*  970 */     paramc.a(b1);
/*  971 */     a(paramab, paramf, (org.a.c.h.g.d.b.c)b1, parama.c());
/*      */   }
/*      */   private void b(Document paramDocument) {
/*      */     Element element;
/*      */     List list;
/*  976 */     if ((element = com.a.a.b.c.a.a(paramDocument.getDocumentElement(), "head")) != null && (
/*      */       
/*  978 */       element = com.a.a.b.c.a.a(element, "bookmarks")) != null && (
/*      */       
/*  980 */       list = com.a.a.b.c.a.b(element, "bookmark")) != null) {
/*  981 */       for (Element element1 : list) {
/*  982 */         a((a)null, element1);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(a parama, Element paramElement) {
/*  990 */     a a1 = new a(paramElement.getAttribute("name"), paramElement.getAttribute("href"));
/*  991 */     if (parama == null) {
/*  992 */       this.x.add(a1);
/*      */     } else {
/*  994 */       parama.a(a1);
/*      */     } 
/*      */     List list;
/*  997 */     if ((list = com.a.a.b.c.a.b(paramElement, "bookmark")) != null) {
/*  998 */       for (Element paramElement : list) {
/*  999 */         a(a1, paramElement);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static class a
/*      */   {
/*      */     private final String a;
/*      */     private final String b;
/*      */     private List<a> c;
/*      */     
/*      */     public a(String param1String1, String param1String2) {
/* 1011 */       this.a = param1String1;
/* 1012 */       this.b = param1String2;
/*      */     }
/*      */     
/*      */     public final String a() {
/* 1016 */       return this.b;
/*      */     }
/*      */     
/*      */     public final String b() {
/* 1020 */       return this.a;
/*      */     }
/*      */     
/*      */     public final void a(a param1a) {
/* 1024 */       if (this.c == null) {
/* 1025 */         this.c = new ArrayList<>();
/*      */       }
/* 1027 */       this.c.add(param1a);
/*      */     }
/*      */     
/*      */     public final List<a> c() {
/* 1031 */       return (this.c == null) ? Collections.emptyList() : this.c;
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
/*      */   public final String a(String paramString) {
/* 1065 */     for (Iterator<c> iterator = this.y.iterator(); iterator.hasNext();) {
/* 1066 */       if ((c = iterator.next()) != null && c.b().equalsIgnoreCase(paramString)) {
/* 1067 */         return c.a();
/*      */       }
/*      */     } 
/*      */     
/* 1071 */     return null;
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
/*      */   private void c(Document paramDocument) {
/*      */     Element element;
/* 1106 */     if ((element = com.a.a.b.c.a.a(paramDocument.getDocumentElement(), "head")) != null) {
/*      */       List list;
/* 1108 */       if ((list = com.a.a.b.c.a.b(element, "meta")) != null) {
/* 1109 */         for (Iterator<Element> iterator = list.iterator(); iterator.hasNext();) {
/*      */           
/* 1111 */           if ((str1 = (element2 = iterator.next()).getAttribute("name")) != null) {
/* 1112 */             String str2 = element2.getAttribute("content");
/* 1113 */             c c = new c(str1, str2);
/* 1114 */             this.y.add(c);
/*      */           } 
/*      */         } 
/*      */       }
/*      */       String str;
/*      */       Element element1;
/* 1120 */       if ((str = a("title")) == null && (
/*      */         
/* 1122 */         element1 = com.a.a.b.c.a.a(element, "title")) != null) {
/* 1123 */         str = com.a.a.b.c.a.a(element1).trim();
/* 1124 */         c c = new c("title", str);
/* 1125 */         this.y.add(c);
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
/*      */   static class c
/*      */   {
/*      */     private String a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     c(String param1String1, String param1String2) {
/* 1177 */       this.a = param1String1;
/* 1178 */       this.b = param1String2;
/*      */     }
/*      */     
/*      */     public final String a() {
/* 1182 */       return this.b;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final String b() {
/* 1190 */       return this.a;
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
/*      */   public final List<c> n() {
/* 1205 */     return this.y;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(aa paramaa) {
/* 1213 */     this.t = paramaa;
/* 1214 */     paramaa.j().a(true);
/*      */   }
/*      */   
/*      */   public final void a(f paramf) {
/* 1218 */     this.A = paramf;
/*      */   }
/*      */   
/*      */   public final int l() {
/* 1222 */     return this.B;
/*      */   }
/*      */   
/*      */   public final void a(int paramInt) {
/* 1226 */     this.B = paramInt;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(ab paramab) {
/* 1379 */     this.D = paramab;
/*      */   }
/*      */   
/*      */   public final void a(com.d.a.a parama) {
/* 1383 */     this.E = parama;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void b(List<AffineTransform> paramList) {
/* 1388 */     Collections.reverse(paramList);
/* 1389 */     for (AffineTransform affineTransform : paramList) {
/* 1390 */       this.i.pop();
/* 1391 */       this.e.a(affineTransform);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final List<AffineTransform> a(List<AffineTransform> paramList) {
/* 1397 */     if (paramList.size() == 0) {
/* 1398 */       return Collections.emptyList();
/*      */     }
/* 1400 */     ArrayList<AffineTransform> arrayList = new ArrayList(paramList.size());
/*      */     try {
/* 1402 */       for (AffineTransform affineTransform : paramList) {
/* 1403 */         double[] arrayOfDouble = new double[6];
/* 1404 */         affineTransform.getMatrix(arrayOfDouble);
/* 1405 */         arrayOfDouble[4] = arrayOfDouble[4] / this.u;
/* 1406 */         arrayOfDouble[5] = arrayOfDouble[5] / this.u;
/* 1407 */         arrayOfDouble[5] = -arrayOfDouble[5];
/*      */         
/* 1409 */         affineTransform = new AffineTransform(arrayOfDouble);
/* 1410 */         arrayList.add(affineTransform.createInverse());
/* 1411 */         this.i.push(affineTransform);
/* 1412 */         this.e.a(affineTransform);
/*      */       } 
/* 1414 */     } catch (NoninvertibleTransformException noninvertibleTransformException) {
/* 1415 */       l.h(Level.WARNING, "Tried to set a non-invertible CSS transform. Ignored.");
/*      */     } 
/* 1417 */     return arrayList;
/*      */   }
/*      */ 
/*      */   
/*      */   private void t() {
/* 1422 */     byte b1 = 0;
/*      */     
/* 1424 */     for (Iterator<AffineTransform> iterator = this.i.descendingIterator(); iterator.hasNext(); ) {
/* 1425 */       AffineTransform affineTransform = iterator.next();
/* 1426 */       if (b1 >= this.j) {
/* 1427 */         this.e.a(affineTransform);
/*      */       }
/* 1429 */       b1++;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final float a() {
/* 1435 */     return 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public final float b() {
/* 1440 */     return this.l;
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
/*      */   public final boolean f() {
/* 1457 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void m() {
/* 1464 */     if (this.F != null) {
/* 1465 */       throw null;
/*      */     }
/*      */   }
/*      */   
/*      */   private AffineTransform c(AffineTransform paramAffineTransform) {
/* 1470 */     double[] arrayOfDouble = new double[6];
/* 1471 */     paramAffineTransform.getMatrix(arrayOfDouble);
/* 1472 */     arrayOfDouble[4] = arrayOfDouble[4] / this.u;
/* 1473 */     arrayOfDouble[5] = arrayOfDouble[5] / this.u;
/* 1474 */     return new AffineTransform(arrayOfDouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(AffineTransform paramAffineTransform) {
/* 1479 */     this.e.i();
/* 1480 */     paramAffineTransform = c(paramAffineTransform);
/* 1481 */     this.e.a(paramAffineTransform);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void g() {
/* 1486 */     this.e.h();
/* 1487 */     u();
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean i() {
/* 1492 */     return this.D.d();
/*      */   }
/*      */   
/*      */   private void u() {
/* 1496 */     this.n = null;
/* 1497 */     this.o = null;
/* 1498 */     this.r = null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(q paramq, f paramf) {
/* 1504 */     return null;
/*      */   }
/*      */   
/*      */   public final void a(Object paramObject) {}
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */