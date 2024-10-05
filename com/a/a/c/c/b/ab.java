/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.k;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ab<T>
/*     */   extends ae<T>
/*     */   implements k
/*     */ {
/*     */   protected final j a;
/*     */   protected final x b;
/*     */   private e d;
/*     */   protected final k<Object> c;
/*     */   
/*     */   public ab(j paramj, x paramx, e parame, k<?> paramk) {
/*  50 */     super(paramj);
/*  51 */     this.b = paramx;
/*  52 */     this.a = paramj;
/*  53 */     this.c = (k)paramk;
/*  54 */     this.d = parame;
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
/*     */   public final k<?> a(g paramg, c paramc) {
/*     */     k<Object> k1;
/*  69 */     if ((k1 = this.c) == null) {
/*  70 */       k1 = paramg.a(this.a.v(), paramc);
/*     */     } else {
/*  72 */       k1 = paramg.b(k1, paramc, this.a.v());
/*     */     } 
/*     */     e e1;
/*  75 */     if ((e1 = this.d) != null) {
/*  76 */       e1 = e1.a(paramc);
/*     */     }
/*     */     
/*  79 */     if (k1 == this.c && e1 == this.d) {
/*  80 */       return this;
/*     */     }
/*  82 */     return a(e1, k1);
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
/*     */   public final a e() {
/* 102 */     return a.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract ab<T> a(e parame, k<?> paramk);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract T a(g paramg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object c(g paramg) {
/* 126 */     return a(paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract T b(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract T a(T paramT, Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Object a(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final x i() {
/* 164 */     return this.b;
/*     */   }
/*     */   public final j h() {
/* 167 */     return this.a;
/*     */   }
/*     */   
/*     */   public final f b() {
/* 171 */     if (this.c != null) {
/* 172 */       return this.c.b();
/*     */     }
/* 174 */     return super.b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean a(f paramf) {
/* 184 */     return (this.c == null) ? null : this.c
/* 185 */       .a(paramf);
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
/*     */   public final T a(l paraml, g paramg) {
/* 198 */     if (this.b != null) {
/*     */       
/* 200 */       Object object1 = this.b.a(paramg);
/* 201 */       return a(paraml, paramg, (T)object1);
/*     */     } 
/*     */ 
/*     */     
/* 205 */     Object object = (this.d == null) ? this.c.a(paraml, paramg) : this.c.a(paraml, paramg, this.d);
/* 206 */     return b(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T a(l paraml, g paramg, T paramT) {
/*     */     Object object;
/* 216 */     if ((object = this.c.a(paramg.c())).equals(Boolean.FALSE) || this.d != null) {
/*     */ 
/*     */       
/* 219 */       Object object1 = (this.d == null) ? this.c.a(paraml, paramg) : this.c.a(paraml, paramg, this.d);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 224 */       if ((object = a(paramT)) == null) {
/*     */ 
/*     */         
/* 227 */         object = (this.d == null) ? this.c.a(paraml, paramg) : this.c.a(paraml, paramg, this.d);
/* 228 */         return b(object);
/*     */       } 
/* 230 */       object = this.c.a(paraml, paramg, object);
/*     */     } 
/*     */     
/* 233 */     return a(paramT, object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg, e parame) {
/* 240 */     if (paraml.a(o.m)) {
/* 241 */       return a(paramg);
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
/* 255 */     if (this.d == null) {
/* 256 */       return a(paraml, paramg);
/*     */     }
/* 258 */     return b(this.d.d(paraml, paramg));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */