/*     */ package com.d.e;
/*     */ 
/*     */ import com.a.a.c.f.w;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.f;
/*     */ import com.d.c.g.a;
/*     */ import com.d.d.g;
/*     */ import com.d.d.h;
/*     */ import com.d.d.j;
/*     */ import com.d.d.k;
/*     */ import com.d.d.l;
/*     */ import com.d.d.o;
/*     */ import com.d.d.r;
/*     */ import com.d.d.s;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.f;
/*     */ import com.d.i.k;
/*     */ import com.d.i.l;
/*     */ import com.d.m.i;
/*     */ import java.awt.Rectangle;
/*     */ import java.text.BreakIterator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class aa
/*     */ {
/*     */   private r c;
/*     */   private String d;
/*     */   private s e;
/*     */   private boolean f = true;
/*     */   private Map<String, f> g;
/*  87 */   private int h = 1;
/*     */ 
/*     */   
/*     */   private float i;
/*     */ 
/*     */   
/*     */   private boolean j;
/*     */ 
/*     */   
/*     */   private Map<Element, c> k;
/*     */   
/*     */   private o l;
/*     */   
/*     */   private Rectangle m;
/*     */   
/*     */   private k n;
/*     */   
/*     */   private a o;
/*     */   
/*     */   private w.a p;
/*     */   
/*     */   private l q;
/*     */   
/*     */   private Float r;
/*     */   
/*     */   private Float s;
/*     */   
/*     */   private boolean t;
/*     */   
/* 116 */   private String u = "#";
/* 117 */   private g v = new ae(BreakIterator.getLineInstance(Locale.US));
/* 118 */   private g w = new ad.a(BreakIterator.getCharacterInstance(Locale.US));
/*     */   
/* 120 */   private h x = new ad.b(Locale.US);
/* 121 */   private h y = new ad.d(Locale.US);
/* 122 */   private h z = new ad.c();
/*     */   
/* 124 */   public String a = null;
/* 125 */   public String b = null;
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
/*     */   public final v a() {
/*     */     v v;
/* 150 */     return v = new v(this);
/*     */   }
/*     */   
/*     */   public final ab b() {
/*     */     ab ab;
/* 155 */     return ab = new ab(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k c() {
/* 166 */     return this.n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String d() {
/* 173 */     return this.d;
/*     */   }
/*     */   
/*     */   public final r e() {
/* 177 */     return this.c;
/*     */   }
/*     */   
/*     */   public final boolean f() {
/* 181 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean g() {
/* 185 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean h() {
/* 189 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean i() {
/* 193 */     return false;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public final a j() {
/* 213 */     return this.o;
/*     */   }
/*     */   
/*     */   public final void a(a parama) {
/* 217 */     this.o = parama;
/*     */   }
/*     */   
/*     */   private w.a F() {
/* 221 */     return this.p;
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
/*     */   public final Rectangle k() {
/* 234 */     if (F() == null) {
/* 235 */       return this.m;
/*     */     }
/*     */     Rectangle rectangle;
/* 238 */     (rectangle = F().t()).translate(F().u(), F().v());
/* 239 */     return rectangle;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(l paraml) {
/* 244 */     this.q = paraml;
/*     */   }
/*     */   
/*     */   public final l l() {
/* 248 */     return this.q;
/*     */   }
/*     */   
/*     */   public final void a(String paramString, f paramf) {
/* 252 */     if (this.g == null) {
/* 253 */       this.g = new HashMap<>();
/*     */     }
/* 255 */     this.g.put(paramString, paramf);
/*     */   }
/*     */   
/*     */   public final f a(String paramString) {
/* 259 */     if (this.g == null) {
/* 260 */       this.g = new HashMap<>();
/*     */     }
/* 262 */     return this.g.get(paramString);
/*     */   }
/*     */   
/*     */   public final void b(String paramString) {
/* 266 */     if (this.g != null) {
/* 267 */       this.g.remove(paramString);
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
/*     */   public final void a(r paramr) {
/* 281 */     this.c = paramr;
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
/*     */   private void e(String paramString) {
/* 293 */     this.d = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final s m() {
/* 304 */     return this.e;
/*     */   }
/*     */   
/*     */   public final s n() {
/* 308 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void a(s params) {
/*     */     a a1;
/* 313 */     if ((a1 = j()) != null) {
/* 314 */       a1.a(params);
/*     */     }
/* 316 */     this.e = params;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(float paramFloat) {
/* 338 */     this.i = 25.4F / paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float o() {
/* 347 */     return this.i;
/*     */   }
/*     */   
/*     */   public final k a(a parama) {
/* 351 */     return c().a(this, parama);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float a(j paramj, a parama) {
/* 357 */     k k1 = c().a(this, parama);
/*     */     l l1;
/* 359 */     float f = (l1 = e().a(k1)).c();
/* 360 */     return l1.a() - 2.0F * Math.abs(f) + l1.d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String p() {
/* 369 */     return this.e.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(String paramString) {
/* 378 */     this.e.e(paramString);
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
/*     */   public final boolean q() {
/* 410 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 414 */     this.f = false;
/*     */   }
/*     */   
/*     */   public final boolean r() {
/* 418 */     return this.j;
/*     */   }
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 422 */     this.j = true;
/*     */     
/* 424 */     e("print");
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
/*     */   public final void a(k paramk) {
/* 462 */     this.n = paramk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int s() {
/* 470 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/* 478 */     this.h = 20;
/*     */   }
/*     */   
/*     */   public final c a(Element paramElement) {
/* 482 */     return a(paramElement, false);
/*     */   }
/*     */   
/*     */   private c a(Element paramElement, boolean paramBoolean) {
/* 486 */     if (this.k == null) {
/* 487 */       this.k = new HashMap<>(1024, 0.75F);
/*     */     }
/*     */     
/* 490 */     c c = null;
/*     */ 
/*     */ 
/*     */     
/* 494 */     if ((c = this.k.get(paramElement)) == null) {
/*     */       f f;
/*     */       Node node;
/* 497 */       if (node = paramElement.getParentNode() instanceof org.w3c.dom.Document) {
/* 498 */         f = new f();
/*     */       } else {
/* 500 */         c = a((Element)f, false);
/*     */       } 
/*     */       
/* 503 */       c = c.a(j().a(paramElement, false));
/*     */       
/* 505 */       this.k.put(paramElement, c);
/*     */     } 
/*     */     
/* 508 */     return c;
/*     */   }
/*     */   
/*     */   public final o t() {
/* 512 */     return this.l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(o paramo) {
/* 519 */     this.l = paramo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Float u() {
/* 528 */     return this.s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Float v() {
/* 537 */     return this.r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean w() {
/* 545 */     return this.t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String x() {
/* 554 */     return this.u;
/*     */   }
/*     */   
/*     */   public final void d(String paramString) {
/* 558 */     this.u = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Float paramFloat1, Float paramFloat2, boolean paramBoolean) {
/* 568 */     this.s = paramFloat1;
/* 569 */     this.r = paramFloat2;
/* 570 */     this.t = paramBoolean;
/*     */   }
/*     */   
/*     */   public final g y() {
/* 574 */     return this.v;
/*     */   }
/*     */   
/*     */   public final void a(g paramg) {
/* 578 */     this.v = paramg;
/*     */   }
/*     */   
/*     */   public final g z() {
/* 582 */     return this.w;
/*     */   }
/*     */   
/*     */   public final void b(g paramg) {
/* 586 */     this.w = paramg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void A() {
/* 596 */     i.a().a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void B() {
/* 603 */     i.a().a(null);
/*     */   }
/*     */   
/*     */   public final h C() {
/* 607 */     return this.x;
/*     */   }
/*     */   
/*     */   public final h D() {
/* 611 */     return this.y;
/*     */   }
/*     */   
/*     */   public final h E() {
/* 615 */     return this.z;
/*     */   }
/*     */   
/*     */   public final void a(h paramh) {
/* 619 */     this.x = paramh;
/*     */   }
/*     */   
/*     */   public final void b(h paramh) {
/* 623 */     this.y = paramh;
/*     */   }
/*     */   
/*     */   public final void c(h paramh) {
/* 627 */     this.z = paramh;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\aa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */