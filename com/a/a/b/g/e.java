/*     */ package com.a.a.b.g;
/*     */ 
/*     */ import com.a.a.b.c.k;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.q;
/*     */ import com.a.a.b.r;
/*     */ import java.io.Serializable;
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
/*     */ public class e
/*     */   implements f<e>, q, Serializable
/*     */ {
/*  31 */   public static final k c = new k(" ");
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
/*  55 */   private b d = a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private b e = d.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private r f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean g = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient int h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private n i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e() {
/* 104 */     this((r)c);
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
/*     */   private e(r paramr) {
/* 127 */     this.f = paramr;
/* 128 */     a(a);
/*     */   }
/*     */   
/*     */   private e(e parame) {
/* 132 */     this(parame, parame.f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e(e parame, r paramr) {
/* 138 */     this.d = parame.d;
/* 139 */     this.e = parame.e;
/* 140 */     this.g = parame.g;
/* 141 */     this.h = parame.h;
/*     */     
/* 143 */     this.i = parame.i;
/* 144 */     this.j = parame.j;
/*     */     
/* 146 */     this.f = paramr;
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
/*     */   private e a(n paramn) {
/* 251 */     this.i = paramn;
/* 252 */     this.j = " " + paramn.b() + " ";
/* 253 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e b() {
/* 264 */     if (getClass() != e.class) {
/* 265 */       throw new IllegalStateException("Failed `createInstance()`: " + getClass().getName() + " does not override method; it has to");
/*     */     }
/*     */     
/* 268 */     return new e(this);
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
/*     */   public final void a(h paramh) {
/* 280 */     if (this.f != null) {
/* 281 */       paramh.d(this.f);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(h paramh) {
/* 288 */     paramh.a('{');
/* 289 */     if (!this.e.a()) {
/* 290 */       this.h++;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void h(h paramh) {
/* 297 */     this.e.a(paramh, this.h);
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
/*     */   public final void d(h paramh) {
/* 312 */     if (this.g) {
/* 313 */       paramh.c(this.j); return;
/*     */     } 
/* 315 */     paramh.a(this.i.b());
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
/*     */   public final void c(h paramh) {
/* 331 */     paramh.a(this.i.c());
/* 332 */     this.e.a(paramh, this.h);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh, int paramInt) {
/* 338 */     if (!this.e.a()) {
/* 339 */       this.h--;
/*     */     }
/* 341 */     if (paramInt > 0) {
/* 342 */       this.e.a(paramh, this.h);
/*     */     } else {
/* 344 */       paramh.a(' ');
/*     */     } 
/* 346 */     paramh.a('}');
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void e(h paramh) {
/* 352 */     if (!this.d.a()) {
/* 353 */       this.h++;
/*     */     }
/* 355 */     paramh.a('[');
/*     */   }
/*     */ 
/*     */   
/*     */   public final void g(h paramh) {
/* 360 */     this.d.a(paramh, this.h);
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
/*     */   public final void f(h paramh) {
/* 375 */     paramh.a(this.i.d());
/* 376 */     this.d.a(paramh, this.h);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(h paramh, int paramInt) {
/* 382 */     if (!this.d.a()) {
/* 383 */       this.h--;
/*     */     }
/* 385 */     if (paramInt > 0) {
/* 386 */       this.d.a(paramh, this.h);
/*     */     } else {
/* 388 */       paramh.a(' ');
/*     */     } 
/* 390 */     paramh.a(']');
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface b
/*     */   {
/*     */     void a(h param1h, int param1Int);
/*     */     
/*     */     boolean a();
/*     */   }
/*     */   
/*     */   public static class c
/*     */     implements b, Serializable
/*     */   {
/*     */     static {
/*     */     
/*     */     }
/*     */     
/*     */     public void a(h param1h, int param1Int) {}
/*     */     
/*     */     public boolean a() {
/* 411 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */     extends c
/*     */   {
/* 421 */     public static final a a = new a();
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(h param1h, int param1Int) {
/* 426 */       param1h.a(' ');
/*     */     }
/*     */     
/*     */     public final boolean a() {
/* 430 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */