/*     */ package com.d.e;
/*     */ 
/*     */ import com.a.a.c.k.b.ak;
/*     */ import com.d.a.c;
/*     */ import com.d.a.d;
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.a.c;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.d;
/*     */ import com.d.d.j;
/*     */ import com.d.d.l;
/*     */ import com.d.d.o;
/*     */ import com.d.d.r;
/*     */ import com.d.d.s;
/*     */ import com.d.i.aa;
/*     */ import com.d.i.f;
/*     */ import com.d.i.k;
/*     */ import com.d.i.l;
/*     */ import com.d.i.x;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
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
/*     */ public final class v
/*     */   implements d
/*     */ {
/*     */   private aa a;
/*     */   private t b;
/*     */   private ab c;
/*     */   private ab d;
/*     */   private x e;
/*     */   private LinkedList<b> f;
/*     */   private LinkedList<t> g;
/*     */   private j h;
/*  75 */   private final com.d.b.a i = new com.d.b.a();
/*     */   
/*     */   private int j;
/*     */   
/*     */   private int k;
/*  80 */   private final Map<c, a> l = new HashMap<>();
/*     */   
/*     */   private String m;
/*     */   
/*     */   private String n;
/*  85 */   private int o = 0;
/*     */   
/*     */   private t p;
/*     */   
/*     */   private aa q;
/*     */   
/*     */   private boolean r = true;
/*     */   
/*     */   private i s;
/*  94 */   private Boolean t = null;
/*     */   
/*     */   public final r d() {
/*  97 */     return this.a.e();
/*     */   }
/*     */   
/*     */   public final a c() {
/* 101 */     return this.a.j();
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
/*     */   public final l e() {
/* 113 */     return this.a.l();
/*     */   }
/*     */   
/* 116 */   private final d u = new d();
/* 117 */   private c v = (c)new c();
/* 118 */   private byte w = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d f() {
/* 125 */     return this.u;
/*     */   }
/*     */   
/* 128 */   private com.d.a.a x = (com.d.a.a)new ak();
/*     */   
/*     */   public final void a(com.d.a.a parama) {
/* 131 */     this.x = parama;
/*     */   }
/*     */   
/*     */   public final com.d.a.a g() {
/* 135 */     return this.x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c h() {
/* 142 */     return this.v;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(c paramc) {
/* 149 */     this.v = paramc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte i() {
/* 156 */     return this.w;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(byte paramByte) {
/* 163 */     this.w = paramByte;
/*     */   }
/*     */ 
/*     */   
/*     */   v(aa paramaa) {
/* 168 */     this.a = paramaa;
/*     */     
/* 170 */     this.f = new LinkedList<>();
/* 171 */     this.g = new LinkedList<>();
/*     */     
/* 173 */     this.c = new ab();
/* 174 */     this.d = new ab();
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/* 178 */     this.c = new ab();
/* 179 */     this.d = new ab();
/* 180 */     this.e = null;
/*     */     
/* 182 */     this.f = new LinkedList<>();
/*     */     
/* 184 */     if (!paramBoolean) {
/* 185 */       this.b = null;
/* 186 */       this.g = new LinkedList<>();
/*     */     } 
/*     */     
/* 189 */     this.j = 0;
/* 190 */     this.k = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final w j() {
/*     */     w w;
/* 196 */     (w = new w()).b(this.c);
/* 197 */     w.a(this.d);
/* 198 */     w.a(this.e);
/*     */     
/* 200 */     w.a(this.f);
/*     */     
/* 202 */     if (r()) {
/* 203 */       w.a(B());
/* 204 */       w.b(z());
/* 205 */       w.a(A());
/* 206 */       w.c(C());
/*     */     } 
/*     */     
/* 209 */     return w;
/*     */   }
/*     */   
/*     */   public final void a(w paramw) {
/* 213 */     this.c = paramw.d();
/* 214 */     this.d = paramw.c();
/*     */     
/* 216 */     this.e = paramw.b();
/*     */     
/* 218 */     this.f = paramw.a();
/*     */     
/* 220 */     if (r()) {
/* 221 */       b(paramw.e());
/* 222 */       a(paramw.g());
/* 223 */       b(paramw.f());
/* 224 */       c(paramw.h());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final w k() {
/*     */     w w;
/* 231 */     (w = new w()).a(this.d.d());
/* 232 */     w.b(this.c.d());
/* 233 */     w.a(this.e);
/*     */     
/* 235 */     if (r()) {
/* 236 */       w.a(B());
/*     */     }
/*     */     
/* 239 */     return w;
/*     */   }
/*     */   
/*     */   public final void b(w paramw) {
/* 243 */     this.c = paramw.d();
/* 244 */     this.d = paramw.c();
/*     */     
/* 246 */     this.e = paramw.b();
/*     */     
/* 248 */     if (r()) {
/* 249 */       b(paramw.e());
/*     */     }
/*     */   }
/*     */   
/*     */   public final b l() {
/* 254 */     return this.f.getLast();
/*     */   }
/*     */   
/*     */   public final void a(b paramb) {
/* 258 */     this.f.add(paramb);
/*     */   }
/*     */   
/*     */   public final void m() {
/* 262 */     this.f.removeLast();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(f paramf) {
/*     */     t t1;
/* 268 */     if (this.b == null) {
/* 269 */       t1 = new t(paramf, this);
/* 270 */       this.b = t1;
/*     */     } else {
/* 272 */       t t2 = o();
/*     */       
/* 274 */       t1 = new t(t2, (f)t1);
/*     */       
/* 276 */       t2.a(t1);
/*     */     } 
/*     */     
/* 279 */     b(t1);
/*     */   }
/*     */   
/*     */   private void b(t paramt) {
/* 283 */     this.g.add(paramt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void n() {
/*     */     t t1;
/* 289 */     (t1 = o()).c(this);
/*     */     
/* 291 */     this.g.removeLast();
/*     */   }
/*     */   
/*     */   public final t o() {
/* 295 */     return this.g.getLast();
/*     */   }
/*     */   
/*     */   public final t p() {
/* 299 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt1, int paramInt2) {
/* 303 */     l().a(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(String paramString, f paramf) {
/* 308 */     this.a.a(paramString, paramf);
/*     */   }
/*     */   
/*     */   public final void a(String paramString) {
/* 312 */     this.a.b(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float a() {
/* 320 */     return this.a.o();
/*     */   }
/*     */   
/*     */   public final int b() {
/* 324 */     return this.a.s();
/*     */   }
/*     */   
/*     */   public final float a(com.d.c.g.a parama) {
/* 328 */     return this.a.a(parama).a();
/*     */   }
/*     */   
/*     */   public final float b(com.d.c.g.a parama) {
/* 332 */     return this.a.a(w(), parama);
/*     */   }
/*     */   
/*     */   public final k c(com.d.c.g.a parama) {
/* 336 */     return this.a.a(parama);
/*     */   }
/*     */   
/*     */   public final s q() {
/* 340 */     return this.a.n();
/*     */   }
/*     */   
/*     */   public final boolean r() {
/* 344 */     if (this.t != null) {
/* 345 */       return this.t.booleanValue();
/*     */     }
/*     */     
/* 348 */     return this.a.r();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Boolean paramBoolean) {
/* 355 */     this.t = paramBoolean;
/*     */   }
/*     */   
/*     */   public final ab s() {
/* 359 */     return this.c;
/*     */   }
/*     */   
/*     */   public final ab t() {
/* 363 */     return this.d;
/*     */   }
/*     */   
/*     */   public final x u() {
/* 367 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void a(x paramx) {
/* 371 */     this.e = paramx;
/*     */   }
/*     */   
/*     */   public final o v() {
/* 375 */     return this.a.t();
/*     */   }
/*     */   
/*     */   public final j w() {
/* 379 */     return this.h;
/*     */   }
/*     */   
/*     */   public final void a(j paramj) {
/* 383 */     this.h = paramj;
/*     */   }
/*     */   
/*     */   public final com.d.b.a x() {
/* 387 */     return this.i;
/*     */   }
/*     */   
/*     */   public final aa y() {
/* 391 */     return this.a;
/*     */   }
/*     */   
/*     */   public final int z() {
/* 395 */     return this.k;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/* 399 */     this.k = paramInt;
/*     */   }
/*     */   
/*     */   public final int A() {
/* 403 */     return this.j;
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/* 407 */     this.j = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(c paramc, Integer paramInteger) {
/* 412 */     a a1 = new a(this, paramc, paramInteger);
/* 413 */     this.l.put(paramc, a1);
/*     */   }
/*     */   
/*     */   public final void a(c paramc) {
/* 417 */     a(paramc, (Integer)null);
/*     */   }
/*     */   
/*     */   public final a b(c paramc) {
/* 421 */     return this.l.get(paramc);
/*     */   }
/*     */   
/*     */   public final l a(k paramk) {
/* 425 */     w(); return d().a(paramk);
/*     */   }
/*     */   
/*     */   public class a {
/* 429 */     private Map<String, Integer> a = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(v this$0, c param1c, Integer param1Integer) {
/* 444 */       if (param1Integer != null) {
/* 445 */         this.a.put("list-item", param1Integer);
/*     */       }
/* 447 */       this.b = (a)v.a(this$0).get(param1c.a());
/* 448 */       if (this.b == null) this.b = new a(this$0);
/*     */       
/*     */       List list;
/* 451 */       if ((list = param1c.f()) != null) {
/* 452 */         Objects.requireNonNull(this.b); list.forEach(this.b::b);
/*     */       } 
/*     */ 
/*     */       
/* 456 */       if ((list = param1c.g()) != null) {
/* 457 */         for (ad ad : list) {
/* 458 */           if (!this.b.a(ad)) {
/* 459 */             this.b.b(new ad(ad.a(), 0));
/* 460 */             this.b.a(ad);
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 466 */       if (param1c.a(com.d.c.a.a.G, c.ae)) {
/*     */         
/* 468 */         if (param1Integer != null) {
/* 469 */           this.b.a.put("list-item", param1Integer);
/*     */         }
/* 471 */         this.b.a(1);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(v this$0) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean a(ad param1ad) {
/* 484 */       if ("list-item".equals(param1ad.a())) {
/* 485 */         a(param1ad.b());
/* 486 */         return true;
/*     */       } 
/*     */       Integer integer;
/* 489 */       if ((integer = this.a.get(param1ad.a())) == null) {
/* 490 */         if (this.b == null) return false; 
/* 491 */         return this.b.a(param1ad);
/*     */       } 
/* 493 */       this.a.put(param1ad.a(), new Integer(integer.intValue() + param1ad.b()));
/* 494 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(int param1Int) {
/*     */       Integer integer;
/* 501 */       if ((integer = this.a.get("list-item")) == null) {
/* 502 */         integer = Integer.valueOf(0);
/*     */       }
/* 504 */       this.a.put("list-item", new Integer(integer.intValue() + param1Int));
/*     */     }
/*     */     
/*     */     private void b(ad param1ad) {
/* 508 */       this.a.put(param1ad.a(), new Integer(param1ad.b()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int a(String param1String) {
/*     */       Integer integer;
/* 515 */       if ((integer = this.b.c(param1String)) == null) {
/* 516 */         this.b.b(new ad(param1String, 0));
/* 517 */         return 0;
/*     */       } 
/* 519 */       return integer.intValue();
/*     */     }
/*     */ 
/*     */     
/*     */     private Integer c(String param1String) {
/*     */       Integer integer;
/* 525 */       if ((integer = this.a.get(param1String)) != null) return integer; 
/* 526 */       if (this.b == null) return null; 
/* 527 */       return this.b.c(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final List<Integer> b(String param1String) {
/* 533 */       ArrayList<Integer> arrayList = new ArrayList();
/* 534 */       this.b.a(param1String, arrayList);
/* 535 */       if (arrayList.size() == 0) {
/* 536 */         this.b.b(new ad(param1String, 0));
/* 537 */         arrayList.add(Integer.valueOf(0));
/*     */       } 
/* 539 */       return arrayList;
/*     */     }
/*     */     
/*     */     private void a(String param1String, List<Integer> param1List) {
/* 543 */       if (this.b != null) this.b.a(param1String, param1List); 
/*     */       Integer integer;
/* 545 */       if ((integer = this.a.get(param1String)) != null) param1List.add(integer); 
/*     */     }
/*     */   }
/*     */   
/*     */   public final String B() {
/* 550 */     return this.n;
/*     */   }
/*     */   
/*     */   public final void b(String paramString) {
/* 554 */     this.n = paramString;
/*     */   }
/*     */   
/*     */   public final int C() {
/* 558 */     return this.o;
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 562 */     this.o = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean D() {
/* 566 */     return (this.o == 0);
/*     */   }
/*     */   
/*     */   public final String E() {
/* 570 */     return this.m;
/*     */   }
/*     */   
/*     */   public final void c(String paramString) {
/* 574 */     this.m = paramString;
/*     */   }
/*     */   
/*     */   public final t F() {
/* 578 */     return this.p;
/*     */   }
/*     */   
/*     */   public final void a(t paramt) {
/* 582 */     this.p = paramt;
/*     */   }
/*     */   
/*     */   public final aa G() {
/* 586 */     return this.q;
/*     */   }
/*     */   
/*     */   public final void a(aa paramaa) {
/* 590 */     this.q = paramaa;
/*     */   }
/*     */   
/*     */   public final boolean H() {
/* 594 */     return this.r;
/*     */   }
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 598 */     this.r = paramBoolean;
/*     */   }
/*     */   
/*     */   public final i I() {
/* 602 */     return this.s;
/*     */   }
/*     */   
/*     */   public final void a(i parami) {
/* 606 */     this.s = parami;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */