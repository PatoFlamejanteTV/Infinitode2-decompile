/*     */ package com.a.a.c.m.a;
/*     */ 
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.Collection;
/*     */ import java.util.Deque;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class b<E extends a<E>>
/*     */   extends AbstractCollection<E>
/*     */   implements Deque<E>
/*     */ {
/*     */   private E a;
/*     */   private E b;
/*     */   
/*     */   private void e(E paramE) {
/*  76 */     E e = this.a;
/*  77 */     this.a = paramE;
/*     */     
/*  79 */     if (e == null) {
/*  80 */       this.b = paramE; return;
/*     */     } 
/*  82 */     e.a(paramE);
/*  83 */     paramE.b(e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void f(E paramE) {
/*  94 */     E e = this.b;
/*  95 */     this.b = paramE;
/*     */     
/*  97 */     if (e == null) {
/*  98 */       this.a = paramE; return;
/*     */     } 
/* 100 */     e.b(paramE);
/* 101 */     paramE.a(e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private E b() {
/* 108 */     E e1, e2 = (E)(e1 = this.a).b();
/* 109 */     e1.b(null);
/*     */     
/* 111 */     this.a = e2;
/* 112 */     if (e2 == null) {
/* 113 */       this.b = null;
/*     */     } else {
/* 115 */       e2.a(null);
/*     */     } 
/* 117 */     return e1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private E c() {
/* 123 */     E e1, e2 = (E)(e1 = this.b).a();
/* 124 */     e1.a(null);
/* 125 */     this.b = e2;
/* 126 */     if (e2 == null) {
/* 127 */       this.a = null;
/*     */     } else {
/* 129 */       e2.b(null);
/*     */     } 
/* 131 */     return e1;
/*     */   }
/*     */ 
/*     */   
/*     */   private void g(E paramE) {
/* 136 */     a<E> a1 = (a<E>)paramE.a();
/* 137 */     E e = (E)paramE.b();
/*     */     
/* 139 */     if (a1 == null) {
/* 140 */       this.a = e;
/*     */     } else {
/* 142 */       a1.b(e);
/* 143 */       paramE.a(null);
/*     */     } 
/*     */     
/* 146 */     if (e == null) {
/* 147 */       this.b = (E)a1; return;
/*     */     } 
/* 149 */     e.a(a1);
/* 150 */     paramE.b(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isEmpty() {
/* 156 */     return (this.a == null);
/*     */   }
/*     */   
/*     */   private void d() {
/* 160 */     if (isEmpty()) {
/* 161 */       throw new NoSuchElementException();
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
/*     */   public final int size() {
/* 173 */     byte b1 = 0;
/* 174 */     for (E e = this.a; e != null; e = e.b()) {
/* 175 */       b1++;
/*     */     }
/* 177 */     return b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void clear() {
/* 182 */     for (E e = this.a; e != null; ) {
/* 183 */       E e1 = (E)e.b();
/* 184 */       e.a(null);
/* 185 */       e.b(null);
/* 186 */       e = e1;
/*     */     } 
/* 188 */     this.a = this.b = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean contains(Object paramObject) {
/* 193 */     return (paramObject instanceof a && a((a)paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean a(a<?> parama) {
/* 198 */     if (parama.a() != null || parama
/* 199 */       .b() != null || parama == this.a) return true;
/*     */     
/*     */     return false;
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
/*     */   public final void b(E paramE) {
/* 223 */     if (paramE != this.b) {
/* 224 */       g(paramE);
/* 225 */       f(paramE);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private E e() {
/* 231 */     return f();
/*     */   }
/*     */ 
/*     */   
/*     */   private E f() {
/* 236 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   private E g() {
/* 241 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   private E h() {
/* 246 */     d();
/* 247 */     return f();
/*     */   }
/*     */ 
/*     */   
/*     */   private E i() {
/* 252 */     d();
/* 253 */     return g();
/*     */   }
/*     */ 
/*     */   
/*     */   private E j() {
/* 258 */     return h();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean h(E paramE) {
/* 263 */     return j(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean i(E paramE) {
/* 268 */     if (a((a<?>)paramE)) {
/* 269 */       return false;
/*     */     }
/* 271 */     e(paramE);
/* 272 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean j(E paramE) {
/* 277 */     if (a((a<?>)paramE)) {
/* 278 */       return false;
/*     */     }
/* 280 */     f(paramE);
/* 281 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean c(E paramE) {
/* 286 */     return j(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void k(E paramE) {
/* 292 */     if (!i(paramE)) {
/* 293 */       throw new IllegalArgumentException();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void l(E paramE) {
/* 299 */     if (!j(paramE)) {
/* 300 */       throw new IllegalArgumentException();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final E a() {
/* 306 */     return k();
/*     */   }
/*     */ 
/*     */   
/*     */   private E k() {
/* 311 */     return isEmpty() ? null : b();
/*     */   }
/*     */ 
/*     */   
/*     */   private E l() {
/* 316 */     return isEmpty() ? null : c();
/*     */   }
/*     */ 
/*     */   
/*     */   private E m() {
/* 321 */     return n();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean remove(Object paramObject) {
/* 327 */     return (paramObject instanceof a && d((E)paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean d(E paramE) {
/* 332 */     if (a((a<?>)paramE)) {
/* 333 */       g(paramE);
/* 334 */       return true;
/*     */     } 
/* 336 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private E n() {
/* 341 */     d();
/* 342 */     return k();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean removeFirstOccurrence(Object paramObject) {
/* 347 */     return remove(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   private E o() {
/* 352 */     d();
/* 353 */     return l();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean removeLastOccurrence(Object paramObject) {
/* 358 */     return remove(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean removeAll(Collection<?> paramCollection) {
/* 363 */     boolean bool = false;
/* 364 */     for (Object object : paramCollection) {
/* 365 */       bool |= remove(object);
/*     */     }
/* 367 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   private void m(E paramE) {
/* 372 */     k(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   private E p() {
/* 377 */     return n();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Iterator<E> iterator() {
/* 382 */     return new c(this, (a)this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Iterator<E> descendingIterator() {
/* 391 */     return new d(this, (a)this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract class a
/*     */     implements Iterator<E>
/*     */   {
/*     */     E a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(b this$0, E param1E) {
/* 407 */       this.a = param1E;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 412 */       return (this.a != null);
/*     */     }
/*     */ 
/*     */     
/*     */     private E b() {
/* 417 */       if (!hasNext()) {
/* 418 */         throw new NoSuchElementException();
/*     */       }
/* 420 */       E e = this.a;
/* 421 */       this.a = a();
/* 422 */       return e;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 427 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     abstract E a();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */