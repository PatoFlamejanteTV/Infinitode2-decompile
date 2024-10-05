/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.a.f;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ap<T extends ap<T>>
/*     */ {
/*     */   T a(f paramf);
/*     */   
/*     */   T a(f.a parama);
/*     */   
/*     */   T a(f.b paramb);
/*     */   
/*     */   T b(f.b paramb);
/*     */   
/*     */   T c(f.b paramb);
/*     */   
/*     */   T d(f.b paramb);
/*     */   
/*     */   T e(f.b paramb);
/*     */   
/*     */   boolean a(k paramk);
/*     */   
/*     */   boolean b(k paramk);
/*     */   
/*     */   boolean c(k paramk);
/*     */   
/*     */   boolean a(j paramj);
/*     */   
/*     */   boolean a(h paramh);
/*     */   
/*     */   public static class a
/*     */     implements ap<a>, Serializable
/*     */   {
/* 164 */     private static a a = new a(f.b.d, f.b.d, f.b.a, f.b.a, f.b.d);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     private static a b = new a(f.b.d, f.b.d, f.b.d, f.b.d, f.b.d);
/*     */ 
/*     */     
/*     */     private f.b c;
/*     */ 
/*     */     
/*     */     private f.b d;
/*     */ 
/*     */     
/*     */     private f.b e;
/*     */ 
/*     */     
/*     */     private f.b f;
/*     */     
/*     */     private f.b g;
/*     */ 
/*     */     
/*     */     public static a a() {
/* 196 */       return a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static a b() {
/* 203 */       return b;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(f.b param1b1, f.b param1b2, f.b param1b3, f.b param1b4, f.b param1b5) {
/* 227 */       this.c = param1b1;
/* 228 */       this.d = param1b2;
/* 229 */       this.e = param1b3;
/* 230 */       this.f = param1b4;
/* 231 */       this.g = param1b5;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a a(f.b param1b1, f.b param1b2, f.b param1b3, f.b param1b4, f.b param1b5) {
/* 274 */       if (param1b1 == this.c && param1b2 == this.d && param1b3 == this.e && param1b4 == this.f && param1b5 == this.g)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 280 */         return this;
/*     */       }
/* 282 */       return new a(param1b1, param1b2, param1b3, param1b4, param1b5);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private a b(f param1f) {
/* 288 */       a a1 = this;
/* 289 */       if (param1f != null) {
/* 290 */         return a(
/* 291 */             a(this.c, param1f.a()), 
/* 292 */             a(this.d, param1f.b()), 
/* 293 */             a(this.e, param1f.c()), 
/* 294 */             a(this.f, param1f.d()), 
/* 295 */             a(this.g, param1f.e()));
/*     */       }
/*     */       
/* 298 */       return a1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private a b(f.a param1a) {
/* 304 */       a a1 = this;
/* 305 */       if (param1a != null) {
/* 306 */         return a(
/* 307 */             a(this.c, param1a.b()), 
/* 308 */             a(this.d, param1a.c()), 
/* 309 */             a(this.e, param1a.d()), 
/* 310 */             a(this.f, param1a.e()), 
/* 311 */             a(this.g, param1a.a()));
/*     */       }
/*     */       
/* 314 */       return a1;
/*     */     }
/*     */     
/*     */     private static f.b a(f.b param1b1, f.b param1b2) {
/* 318 */       if (param1b2 == f.b.f) {
/* 319 */         return param1b1;
/*     */       }
/* 321 */       return param1b2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a f(f.b param1b) {
/* 358 */       if (param1b == f.b.f) param1b = a.c; 
/* 359 */       if (this.c == param1b) return this; 
/* 360 */       return new a(param1b, this.d, this.e, this.f, this.g);
/*     */     }
/*     */ 
/*     */     
/*     */     private a g(f.b param1b) {
/* 365 */       if (param1b == f.b.f) param1b = a.d; 
/* 366 */       if (this.d == param1b) return this; 
/* 367 */       return new a(this.c, param1b, this.e, this.f, this.g);
/*     */     }
/*     */ 
/*     */     
/*     */     private a h(f.b param1b) {
/* 372 */       if (param1b == f.b.f) param1b = a.e; 
/* 373 */       if (this.e == param1b) return this; 
/* 374 */       return new a(this.c, this.d, param1b, this.f, this.g);
/*     */     }
/*     */ 
/*     */     
/*     */     private a i(f.b param1b) {
/* 379 */       if (param1b == f.b.f) param1b = a.f; 
/* 380 */       if (this.f == param1b) return this; 
/* 381 */       return new a(this.c, this.d, this.e, param1b, this.g);
/*     */     }
/*     */ 
/*     */     
/*     */     private a j(f.b param1b) {
/* 386 */       if (param1b == f.b.f) param1b = a.g; 
/* 387 */       if (this.g == param1b) return this; 
/* 388 */       return new a(this.c, this.d, this.e, this.f, param1b);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean a(Member param1Member) {
/* 399 */       return this.f.a(param1Member);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(j param1j) {
/* 404 */       return a(param1j.i());
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean a(Field param1Field) {
/* 409 */       return this.g.a(param1Field);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(h param1h) {
/* 414 */       return a(param1h.e());
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean a(Method param1Method) {
/* 419 */       return this.c.a(param1Method);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(k param1k) {
/* 424 */       return a(param1k.e());
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean b(Method param1Method) {
/* 429 */       return this.d.a(param1Method);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean b(k param1k) {
/* 434 */       return b(param1k.e());
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean c(Method param1Method) {
/* 439 */       return this.e.a(param1Method);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean c(k param1k) {
/* 444 */       return c(param1k.e());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 455 */       return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", new Object[] { this.c, this.d, this.e, this.f, this.g });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\ap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */