/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.f.a;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.k;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class b<T>
/*     */   extends j<T>
/*     */   implements k
/*     */ {
/*     */   protected final j a;
/*     */   protected final c b;
/*     */   private boolean g;
/*     */   protected final Boolean c;
/*     */   protected final i d;
/*     */   protected final o<Object> e;
/*     */   protected k f;
/*     */   
/*     */   protected b(Class<?> paramClass, j paramj, boolean paramBoolean, i parami, o<Object> paramo) {
/*  81 */     this(paramClass, paramj, paramBoolean, parami, (c)null, paramo, (Boolean)null);
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
/*     */   private b(Class<?> paramClass, j paramj, boolean paramBoolean, i parami, c paramc, o<?> paramo, Boolean paramBoolean1) {
/* 106 */     super(paramClass, false);
/* 107 */     this.a = paramj;
/*     */     
/* 109 */     this.g = (paramBoolean || (paramj != null && paramj.m()));
/* 110 */     this.d = parami;
/* 111 */     this.b = paramc;
/* 112 */     this.e = (o)paramo;
/* 113 */     this.f = k.a();
/* 114 */     this.c = paramBoolean1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected b(b<?> paramb, c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/* 122 */     super(paramb);
/* 123 */     this.a = paramb.a;
/* 124 */     this.g = paramb.g;
/* 125 */     this.d = parami;
/* 126 */     this.b = paramc;
/* 127 */     this.e = (o)paramo;
/*     */     
/* 129 */     this.f = k.a();
/* 130 */     this.c = paramBoolean;
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
/*     */   public abstract b<T> a(c paramc, i parami, o<?> paramo, Boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*     */     i i1;
/* 177 */     if ((i1 = this.d) != null) {
/* 178 */       i1 = i1.a(paramc);
/*     */     }
/* 180 */     o<Object> o1 = null;
/* 181 */     Boolean bool = null;
/*     */ 
/*     */ 
/*     */     
/* 185 */     a a = paramaa.d(); Object object;
/*     */     j j1;
/* 187 */     if (paramc != null && (j1 = paramc.e()) != null && (
/*     */       
/* 189 */       object = a.p((com.a.a.c.f.b)j1)) != null) {
/* 190 */       o1 = paramaa.b((com.a.a.c.f.b)j1, object);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 195 */     if ((object = a(paramaa, paramc, a())) != null) {
/* 196 */       bool = object.a(l.a.c);
/*     */     }
/* 198 */     if (o1 == null) {
/* 199 */       o1 = this.e;
/*     */     }
/*     */ 
/*     */     
/* 203 */     if ((o1 = a(paramaa, paramc, o1)) == null)
/*     */     {
/*     */       
/* 206 */       if (this.a != null && 
/* 207 */         this.g && !this.a.q()) {
/* 208 */         o1 = paramaa.c(this.a, paramc);
/*     */       }
/*     */     }
/*     */     
/* 212 */     if (o1 != this.e || paramc != this.b || this.d != i1 || 
/*     */ 
/*     */       
/* 215 */       !Objects.equals(this.c, bool)) {
/* 216 */       return (o<?>)a(paramc, i1, o1, bool);
/*     */     }
/* 218 */     return (o<?>)this;
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
/*     */   public void a(T paramT, h paramh, aa paramaa) {
/* 249 */     if (paramaa.a(z.r) && 
/* 250 */       a(paramT)) {
/* 251 */       b(paramT, paramh, paramaa);
/*     */       return;
/*     */     } 
/* 254 */     paramh.b(paramT);
/* 255 */     b(paramT, paramh, paramaa);
/* 256 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(T paramT, h paramh, aa paramaa, i parami) {
/* 263 */     a a = parami.a(paramh, parami
/* 264 */         .a(paramT, o.d));
/*     */     
/* 266 */     paramh.a(paramT);
/* 267 */     b(paramT, paramh, paramaa);
/* 268 */     parami.b(paramh, a);
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
/*     */   protected abstract void b(T paramT, h paramh, aa paramaa);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final o<Object> a(k paramk, Class<?> paramClass, aa paramaa) {
/* 311 */     k.d d = paramk.b(paramClass, paramaa, this.b);
/*     */     
/* 313 */     if (paramk != d.b) {
/* 314 */       this.f = d.b;
/*     */     }
/* 316 */     return d.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final o<Object> a(k paramk, j paramj, aa paramaa) {
/* 322 */     k.d d = paramk.b(paramj, paramaa, this.b);
/* 323 */     if (paramk != d.b) {
/* 324 */       this.f = d.b;
/*     */     }
/* 326 */     return d.a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */