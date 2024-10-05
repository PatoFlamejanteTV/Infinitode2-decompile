/*     */ package com.d.i;
/*     */ 
/*     */ import com.a.a.c.k.b.ak;
/*     */ import com.d.a.a;
/*     */ import com.d.c.f.d;
/*     */ import com.d.c.g.a;
/*     */ import com.d.d.j;
/*     */ import com.d.d.m;
/*     */ import com.d.d.r;
/*     */ import com.d.d.s;
/*     */ import com.d.e.a;
/*     */ import com.d.e.aa;
/*     */ import com.d.e.t;
/*     */ import java.awt.Rectangle;
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
/*     */ public final class ab
/*     */   implements d, Cloneable
/*     */ {
/*     */   private aa a;
/*     */   private m b;
/*     */   private j c;
/*     */   private int d;
/*     */   private int e;
/*     */   private aa f;
/*     */   private int g;
/*     */   private t h;
/*     */   private int i;
/*     */   private boolean j = false;
/*     */   private boolean k = false;
/*     */   private a l;
/*     */   
/*     */   public final boolean d() {
/*  65 */     return this.j;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/*  69 */     this.j = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final s e() {
/*  77 */     return this.a.m();
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
/*     */   public final float a() {
/*  89 */     return this.a.o();
/*     */   }
/*     */   
/*     */   public final int b() {
/*  93 */     return this.a.s();
/*     */   }
/*     */   
/*     */   public final float a(a parama) {
/*  97 */     return this.a.a(parama).a();
/*     */   }
/*     */   
/*     */   public final float b(a parama) {
/* 101 */     return this.a.a(q(), parama);
/*     */   }
/*     */   
/*     */   public final r f() {
/* 105 */     return this.a.e();
/*     */   }
/*     */   public ab(aa paramaa) {
/* 108 */     this.l = (a)new ak();
/*     */     this.a = paramaa;
/*     */   } public final void a(a parama) {
/* 111 */     this.l = parama;
/*     */   }
/*     */   
/*     */   public final a g() {
/* 115 */     return this.l;
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
/*     */   public final k c(a parama) {
/* 136 */     return this.a.a(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Rectangle h() {
/*     */     Rectangle rectangle;
/* 145 */     if (!o()) {
/* 146 */       rectangle = this.a.k();
/*     */     }
/*     */     else {
/*     */       
/* 150 */       rectangle = new Rectangle(0, -this.f.b(), this.f.d(this), this.f.c(this) - 1);
/*     */     } 
/* 152 */     rectangle.translate(-1, -1);
/* 153 */     return rectangle;
/*     */   }
/*     */   
/*     */   public final Rectangle i() {
/*     */     Rectangle rectangle;
/* 158 */     (rectangle = new Rectangle(h())).y = -(rectangle = new Rectangle(h())).y;
/*     */     
/* 160 */     return rectangle;
/*     */   }
/*     */   
/*     */   public final boolean j() {
/* 164 */     return this.a.f();
/*     */   }
/*     */   
/*     */   public final boolean k() {
/* 168 */     return this.a.g();
/*     */   }
/*     */   
/*     */   public final boolean l() {
/* 172 */     return this.a.h();
/*     */   }
/*     */   
/*     */   public final boolean m() {
/* 176 */     return this.a.i();
/*     */   }
/*     */   
/*     */   public final boolean n() {
/* 180 */     return this.a.q();
/*     */   }
/*     */   
/*     */   public final boolean o() {
/* 184 */     return this.a.r();
/*     */   }
/*     */   
/*     */   public final m p() {
/* 188 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void a(m paramm) {
/* 192 */     this.b = paramm;
/*     */   }
/*     */   
/*     */   public final j q() {
/* 196 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(j paramj) {
/* 200 */     this.c = paramj;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt, aa paramaa) {
/* 204 */     this.e = paramInt;
/* 205 */     this.f = paramaa;
/*     */   }
/*     */   
/*     */   public final int r() {
/* 209 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/* 213 */     this.d = paramInt;
/*     */   }
/*     */   
/*     */   public final aa s() {
/* 217 */     return this.f;
/*     */   }
/*     */   
/*     */   public final int t() {
/* 221 */     return this.e;
/*     */   }
/*     */   
/*     */   public final a c() {
/* 225 */     return this.a.j();
/*     */   }
/*     */   
/*     */   public final l a(k paramk) {
/* 229 */     q(); return f().a(paramk);
/*     */   }
/*     */   
/*     */   public final t u() {
/* 233 */     return this.h;
/*     */   }
/*     */   
/*     */   public final void a(t paramt) {
/* 237 */     this.h = paramt;
/*     */   }
/*     */   
/*     */   public final int v() {
/* 241 */     return this.i;
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/* 245 */     this.i = paramInt;
/*     */   }
/*     */   
/*     */   public final f a(String paramString) {
/* 249 */     return this.a.a(paramString);
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 253 */     this.g = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int w() {
/* 260 */     return this.g;
/*     */   }
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 264 */     this.k = paramBoolean;
/*     */   }
/*     */   
/*     */   public final boolean x() {
/* 268 */     return this.k;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object clone() {
/*     */     try {
/* 274 */       return super.clone();
/* 275 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 276 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\ab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */