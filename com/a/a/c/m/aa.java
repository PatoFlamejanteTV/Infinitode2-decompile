/*     */ package com.a.a.c.m;
/*     */ 
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.f.h;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.f.n;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.v;
/*     */ import com.a.a.c.w;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends s
/*     */ {
/*     */   private a b;
/*     */   private j c;
/*     */   private v d;
/*     */   private w e;
/*     */   private s.b f;
/*     */   
/*     */   private aa(a parama, j paramj, w paramw, v paramv, s.b paramb) {
/*  61 */     this.b = parama;
/*  62 */     this.c = paramj;
/*  63 */     this.e = paramw;
/*  64 */     this.d = (paramv == null) ? v.b : paramv;
/*  65 */     this.f = paramb;
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
/*     */   public static aa a(q<?> paramq, j paramj, w paramw) {
/*  83 */     return a(paramq, paramj, paramw, (v)null, a);
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
/*     */   public static aa a(q<?> paramq, j paramj, w paramw, v paramv, s.a parama) {
/*  97 */     s.b b1 = (parama == null || parama == s.a.g) ? a : s.b.a(parama, null);
/*  98 */     return new aa(paramq.j(), paramj, paramw, paramv, b1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static aa a(q<?> paramq, j paramj, w paramw, v paramv, s.b paramb) {
/* 108 */     return new aa(paramq.j(), paramj, paramw, paramv, paramb);
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
/*     */   public final String a() {
/* 165 */     return this.e.b();
/*     */   }
/*     */   public final w b() {
/* 168 */     return this.e;
/*     */   }
/*     */   
/*     */   public final boolean a(w paramw) {
/* 172 */     return this.e.equals(paramw);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final w c() {
/* 180 */     if (this.b == null || this.c == null) {
/* 181 */       return null;
/*     */     }
/* 183 */     return a.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean d() {
/* 188 */     return false; } public final boolean e() {
/* 189 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final v h() {
/* 197 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j f() {
/* 202 */     if (this.c == null) {
/* 203 */       return o.b();
/*     */     }
/* 205 */     return this.c.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class<?> g() {
/* 210 */     if (this.c == null) {
/* 211 */       return Object.class;
/*     */     }
/* 213 */     return this.c.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public final s.b B() {
/* 218 */     return this.f;
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
/*     */   public final boolean k() {
/* 231 */     return (o() != null);
/*     */   }
/*     */   public final boolean l() {
/* 234 */     return this.c instanceof h;
/*     */   }
/*     */   public final boolean m() {
/* 237 */     return this.c instanceof n;
/*     */   }
/*     */   
/*     */   public final k n() {
/* 241 */     if (this.c instanceof k && ((k)this.c)
/* 242 */       .f() == 0) {
/* 243 */       return (k)this.c;
/*     */     }
/* 245 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final k o() {
/* 250 */     if (this.c instanceof k && ((k)this.c)
/* 251 */       .f() == 1) {
/* 252 */       return (k)this.c;
/*     */     }
/* 254 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final h p() {
/* 259 */     return (this.c instanceof h) ? (h)this.c : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final n q() {
/* 264 */     return (this.c instanceof n) ? (n)this.c : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Iterator<n> r() {
/*     */     n n;
/* 270 */     if ((n = q()) == null) {
/* 271 */       return i.a();
/*     */     }
/* 273 */     return Collections.<n>singleton(n).iterator();
/*     */   }
/*     */   
/*     */   public final j v() {
/* 277 */     return this.c;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\aa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */