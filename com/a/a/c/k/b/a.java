/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.i.i;
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
/*     */ public abstract class a<T>
/*     */   extends j<T>
/*     */   implements k
/*     */ {
/*     */   protected final c b;
/*     */   protected final Boolean c;
/*     */   
/*     */   protected a(Class<T> paramClass) {
/*  39 */     super(paramClass);
/*  40 */     this.b = null;
/*  41 */     this.c = null;
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
/*     */   protected a(a<?> parama, c paramc, Boolean paramBoolean) {
/*  71 */     super(parama.h, false);
/*  72 */     this.b = paramc;
/*  73 */     this.c = paramBoolean;
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
/*     */   public abstract o<?> a(c paramc, Boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public o<?> a(aa paramaa, c paramc) {
/*     */     l.d d;
/*     */     Boolean bool;
/* 100 */     if (paramc != null && (
/*     */       
/* 102 */       d = a(paramaa, paramc, a())) != null && 
/*     */       
/* 104 */       !Objects.equals(bool = d.a(l.a.c), this.c)) {
/* 105 */       return a(paramc, bool);
/*     */     }
/*     */ 
/*     */     
/* 109 */     return (o<?>)this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(T paramT, h paramh, aa paramaa) {
/* 118 */     if (a(paramaa) && 
/* 119 */       a(paramT)) {
/* 120 */       b(paramT, paramh, paramaa);
/*     */       
/*     */       return;
/*     */     } 
/* 124 */     paramh.b(paramT);
/* 125 */     b(paramT, paramh, paramaa);
/* 126 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(T paramT, h paramh, aa paramaa, i parami) {
/* 134 */     com.a.a.b.f.a a1 = parami.a(paramh, parami
/* 135 */         .a(paramT, o.d));
/*     */     
/* 137 */     paramh.a(paramT);
/* 138 */     b(paramT, paramh, paramaa);
/* 139 */     parami.b(paramh, a1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void b(T paramT, h paramh, aa paramaa);
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean a(aa paramaa) {
/* 149 */     if (this.c == null) {
/* 150 */       return paramaa.a(z.r);
/*     */     }
/* 152 */     return this.c.booleanValue();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */