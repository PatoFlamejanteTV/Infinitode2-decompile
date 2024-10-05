/*     */ package com.a.a.c.k;
/*     */ 
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.k.a.m;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.y;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */ {
/*  19 */   private static final e[] a = new e[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private y c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   private List<e> d = Collections.emptyList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e[] e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private m i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(b paramb) {
/*  77 */     this.b = paramb;
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
/*     */   protected final void a(y paramy) {
/* 101 */     this.c = paramy;
/*     */   }
/*     */   
/*     */   public final void a(List<e> paramList) {
/* 105 */     this.d = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(e[] paramArrayOfe) {
/* 115 */     if (paramArrayOfe.length != this.d.size()) {
/* 116 */       throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", new Object[] {
/*     */               
/* 118 */               Integer.valueOf(paramArrayOfe.length), Integer.valueOf(this.d.size())
/*     */             }));
/*     */     }
/* 121 */     this.e = paramArrayOfe;
/*     */   }
/*     */   
/*     */   public final void a(a parama) {
/* 125 */     this.f = parama;
/*     */   }
/*     */   
/*     */   public final void a(Object paramObject) {
/* 129 */     this.g = paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(j paramj) {
/* 134 */     if (this.h != null) {
/* 135 */       throw new IllegalArgumentException("Multiple type ids specified with " + this.h + " and " + paramj);
/*     */     }
/* 137 */     this.h = paramj;
/*     */   }
/*     */   
/*     */   public final void a(m paramm) {
/* 141 */     this.i = paramm;
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
/*     */   public final b a() {
/* 154 */     return this.b;
/*     */   } public final List<e> b() {
/* 156 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a c() {
/* 163 */     return this.f;
/*     */   } public final Object d() {
/* 165 */     return this.g;
/*     */   } public final j e() {
/* 167 */     return this.h;
/*     */   } public final m f() {
/* 169 */     return this.i;
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
/*     */   public final o<?> g() {
/*     */     e[] arrayOfE;
/* 186 */     if (this.h != null && 
/* 187 */       this.c.a(q.n)) {
/* 188 */       this.h.a(this.c.a(q.o));
/*     */     }
/*     */     
/* 191 */     if (this.f != null) {
/* 192 */       this.f.a(this.c);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     if (this.d == null || this.d.isEmpty()) {
/* 199 */       if (this.f == null && this.i == null)
/*     */       {
/* 201 */         return null;
/*     */       }
/* 203 */       arrayOfE = a;
/*     */     } else {
/* 205 */       arrayOfE = this.d.<e>toArray(new e[this.d.size()]);
/* 206 */       if (this.c.a(q.n)) {
/* 207 */         byte b1; int i; for (b1 = 0, i = arrayOfE.length; b1 < i; b1++) {
/* 208 */           arrayOfE[b1].a(this.c);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 213 */     if (this.e != null && 
/* 214 */       this.e.length != this.d.size()) {
/* 215 */       throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", new Object[] {
/*     */               
/* 217 */               Integer.valueOf(this.d.size()), Integer.valueOf(this.e.length)
/*     */             }));
/*     */     }
/* 220 */     return (o<?>)new f(this.b.a(), this, arrayOfE, this.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f h() {
/* 231 */     return f.a(this.b.a(), this);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */