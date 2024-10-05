/*     */ package com.d.c.f.a;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.g;
/*     */ import com.d.c.f.b;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.d;
/*     */ import java.awt.Rectangle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */   extends h
/*     */ {
/*  20 */   public static final a a = new a(0.0F, 0.0F, 0.0F, 0.0F);
/*     */   
/*     */   private c g;
/*     */   
/*     */   private c h;
/*     */   
/*     */   private c i;
/*     */   private c j;
/*     */   private g k;
/*     */   private g l;
/*     */   private g m;
/*     */   private g n;
/*     */   private b o;
/*     */   private b p;
/*     */   private b q;
/*     */   private b r;
/*     */   
/*     */   private a(a parama) {
/*  38 */     this(parama.t(), parama.u(), parama.v(), parama.w());
/*  39 */     this.g = parama.f();
/*  40 */     this.h = parama.g();
/*  41 */     this.i = parama.h();
/*  42 */     this.j = parama.i();
/*     */     
/*  44 */     this.k = parama.j();
/*  45 */     this.l = parama.k();
/*  46 */     this.m = parama.l();
/*  47 */     this.n = parama.m();
/*     */     
/*  49 */     this.o = parama.o;
/*  50 */     this.p = parama.p;
/*  51 */     this.r = parama.r;
/*  52 */     this.q = parama.q;
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
/*     */   private a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, b paramb1, b paramb2, b paramb3, b paramb4) {
/*  64 */     this.c = paramFloat1;
/*  65 */     this.d = paramFloat2;
/*  66 */     this.e = paramFloat3;
/*  67 */     this.f = paramFloat4;
/*     */     
/*  69 */     this.o = paramb1;
/*  70 */     this.p = paramb2;
/*  71 */     this.r = paramb4;
/*  72 */     this.q = paramb3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  81 */     this.c = paramFloat1;
/*  82 */     this.d = paramFloat2;
/*  83 */     this.e = paramFloat3;
/*  84 */     this.f = paramFloat4;
/*     */     
/*  86 */     this.o = new b();
/*  87 */     this.p = new b();
/*  88 */     this.r = new b();
/*  89 */     this.q = new b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(com.d.f.a parama1, com.d.f.a parama2, com.d.f.a parama3, com.d.f.a parama4) {
/*  98 */     this(parama1.c(), parama2
/*  99 */         .c(), parama3
/* 100 */         .c(), parama4
/* 101 */         .c());
/*     */     
/* 103 */     this.g = parama1.b();
/* 104 */     this.h = parama2.b();
/* 105 */     this.i = parama3.b();
/* 106 */     this.j = parama4.b();
/*     */     
/* 108 */     this.k = parama1.a();
/* 109 */     this.l = parama2.a();
/* 110 */     this.m = parama3.a();
/* 111 */     this.n = parama4.a();
/*     */     
/* 113 */     this.o = new b();
/* 114 */     this.p = new b();
/* 115 */     this.r = new b();
/* 116 */     this.q = new b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a(c paramc, d paramd) {
/* 123 */     this
/*     */ 
/*     */       
/* 126 */       .c = (paramc.a(com.d.c.a.a.aG, c.ap) || paramc.a(com.d.c.a.a.aG, c.P)) ? 0.0F : paramc.c(com.d.c.a.a.aK, 0.0F, paramd);
/* 127 */     this
/*     */ 
/*     */       
/* 130 */       .d = (paramc.a(com.d.c.a.a.aH, c.ap) || paramc.a(com.d.c.a.a.aH, c.P)) ? 0.0F : paramc.c(com.d.c.a.a.aL, 0.0F, paramd);
/* 131 */     this
/*     */ 
/*     */       
/* 134 */       .e = (paramc.a(com.d.c.a.a.aI, c.ap) || paramc.a(com.d.c.a.a.aI, c.P)) ? 0.0F : paramc.c(com.d.c.a.a.aM, 0.0F, paramd);
/* 135 */     this
/*     */ 
/*     */       
/* 138 */       .f = (paramc.a(com.d.c.a.a.aJ, c.ap) || paramc.a(com.d.c.a.a.aJ, c.P)) ? 0.0F : paramc.c(com.d.c.a.a.aN, 0.0F, paramd);
/*     */     
/* 140 */     this.k = paramc.a(com.d.c.a.a.aC);
/* 141 */     this.l = paramc.a(com.d.c.a.a.aD);
/* 142 */     this.m = paramc.a(com.d.c.a.a.aE);
/* 143 */     this.n = paramc.a(com.d.c.a.a.aF);
/*     */     
/* 145 */     this.g = paramc.e(com.d.c.a.a.aG);
/* 146 */     this.h = paramc.e(com.d.c.a.a.aH);
/* 147 */     this.i = paramc.e(com.d.c.a.a.aI);
/* 148 */     this.j = paramc.e(com.d.c.a.a.aJ);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     this.o = new b(com.d.c.a.a.aO, paramc, paramd);
/* 156 */     this.p = new b(com.d.c.a.a.aP, paramc, paramd);
/* 157 */     this.r = new b(com.d.c.a.a.aR, paramc, paramd);
/* 158 */     this.q = new b(com.d.c.a.a.aQ, paramc, paramd);
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
/*     */   public final a a() {
/*     */     a a1;
/* 184 */     (a1 = new a(this)).k = (this.k == null) ? null : this.k.e();
/* 185 */     a1.m = (this.m == null) ? null : this.m.e();
/* 186 */     a1.n = (this.n == null) ? null : this.n.e();
/* 187 */     a1.l = (this.l == null) ? null : this.l.e();
/* 188 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a(c paramc, d paramd) {
/* 195 */     return new a(paramc, paramd);
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 199 */     return "BorderPropertySet[top=" + this.c + ",right=" + this.d + ",bottom=" + this.e + ",left=" + this.f + "]";
/*     */   }
/*     */   
/*     */   public final boolean b() {
/* 203 */     return (this.g == c.ap || (int)this.c == 0);
/*     */   }
/*     */   
/*     */   public final boolean c() {
/* 207 */     return (this.h == c.ap || (int)this.d == 0);
/*     */   }
/*     */   
/*     */   public final boolean d() {
/* 211 */     return (this.i == c.ap || (int)this.e == 0);
/*     */   }
/*     */   
/*     */   public final boolean e() {
/* 215 */     return (this.j == c.ap || (int)this.f == 0);
/*     */   }
/*     */   
/*     */   public final c f() {
/* 219 */     return this.g;
/*     */   }
/*     */   
/*     */   public final c g() {
/* 223 */     return this.h;
/*     */   }
/*     */   
/*     */   public final c h() {
/* 227 */     return this.i;
/*     */   }
/*     */   
/*     */   public final c i() {
/* 231 */     return this.j;
/*     */   }
/*     */   
/*     */   public final g j() {
/* 235 */     return this.k;
/*     */   }
/*     */   
/*     */   public final g k() {
/* 239 */     return this.l;
/*     */   }
/*     */   
/*     */   public final g l() {
/* 243 */     return this.m;
/*     */   }
/*     */   
/*     */   public final g m() {
/* 247 */     return this.n;
/*     */   }
/*     */   
/*     */   public final boolean n() {
/* 251 */     return (this.g == c.P || this.h == c.P || this.i == c.P || this.j == c.P);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean o() {
/* 256 */     return (s().a() || r().a() || q().a() || p().a());
/*     */   }
/*     */   
/*     */   public final b p() {
/* 260 */     return this.q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b q() {
/* 268 */     return this.r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b r() {
/* 276 */     return this.p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b s() {
/* 284 */     return this.o;
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
/*     */   public final a a(Rectangle paramRectangle) {
/* 301 */     float f = Math.min(f = Math.min(f = Math.min(f = Math.min(1.0F, paramRectangle.width / a(this.o, this.p, paramRectangle.width)), paramRectangle.width / a(this.q, this.r, paramRectangle.width)), paramRectangle.height / a(this.p, this.q, paramRectangle.height)), paramRectangle.height / a(this.r, this.q, paramRectangle.height));
/*     */ 
/*     */ 
/*     */     
/*     */     a a1;
/*     */ 
/*     */ 
/*     */     
/* 309 */     (a1 = new a(this.c, this.d, this.e, this.f, new b(f * this.o.a(paramRectangle.height), f * this.o.b(paramRectangle.width)), new b(f * this.p.a(paramRectangle.width), f * this.p.b(paramRectangle.height)), new b(f * this.q.a(paramRectangle.height), f * this.q.b(paramRectangle.width)), new b(f * this.r.a(paramRectangle.width), f * this.r.b(paramRectangle.height)))).k = this.k;
/* 310 */     a1.l = this.l;
/* 311 */     a1.m = this.m;
/* 312 */     a1.n = this.n;
/*     */     
/* 314 */     a1.g = this.g;
/* 315 */     a1.h = this.h;
/* 316 */     a1.i = this.i;
/* 317 */     a1.j = this.j;
/*     */     
/* 319 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float a(b paramb1, b paramb2, float paramFloat) {
/* 330 */     return Math.max(paramFloat, paramb1.b(paramFloat) + paramb2.a(paramFloat));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */