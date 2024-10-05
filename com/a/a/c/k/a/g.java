/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.b.b;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.o;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ @a
/*     */ public final class g
/*     */   extends b<Iterator<?>>
/*     */ {
/*     */   public g(j paramj, boolean paramBoolean, i parami) {
/*  19 */     super(Iterator.class, paramj, paramBoolean, parami, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private g(g paramg, c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  25 */     super(paramg, paramc, parami, paramo, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(Iterator<?> paramIterator) {
/*  30 */     return !paramIterator.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j<?> b(i parami) {
/*  41 */     return (j<?>)new g(this, this.b, parami, this.e, this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private g b(c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  48 */     return new g(this, paramc, parami, paramo, paramBoolean);
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
/*     */   private void a(Iterator<?> paramIterator, h paramh, aa paramaa) {
/*  66 */     paramh.b(paramIterator);
/*  67 */     b(paramIterator, paramh, paramaa);
/*  68 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(Iterator<?> paramIterator, h paramh, aa paramaa) {
/*  75 */     if (!paramIterator.hasNext()) {
/*     */       return;
/*     */     }
/*     */     o o;
/*  79 */     if ((o = this.e) == null) {
/*  80 */       c(paramIterator, paramh, paramaa);
/*     */       return;
/*     */     } 
/*  83 */     i i = this.d;
/*     */     do {
/*     */       Object object;
/*  86 */       if ((object = paramIterator.next()) == null) {
/*  87 */         paramaa.a(paramh);
/*  88 */       } else if (i == null) {
/*  89 */         o.a(object, paramh, paramaa);
/*     */       } else {
/*  91 */         o.a(object, paramh, paramaa, i);
/*     */       } 
/*  93 */     } while (paramIterator.hasNext());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(Iterator<?> paramIterator, h paramh, aa paramaa) {
/*  99 */     i i = this.d;
/* 100 */     k k = this.f;
/*     */     do {
/*     */       Object object;
/* 103 */       if ((object = paramIterator.next()) == null) {
/* 104 */         paramaa.a(paramh);
/*     */       } else {
/*     */         
/* 107 */         Class<?> clazz = object.getClass();
/*     */         o<Object> o;
/* 109 */         if ((o = k.a(clazz)) == null) {
/* 110 */           if (this.a.s()) {
/* 111 */             o = a(k, paramaa
/* 112 */                 .a(this.a, clazz), paramaa);
/*     */           } else {
/* 114 */             o = a(k, clazz, paramaa);
/*     */           } 
/* 116 */           k = this.f;
/*     */         } 
/* 118 */         if (i == null)
/* 119 */         { o.a(object, paramh, paramaa); }
/*     */         else
/* 121 */         { o.a(object, paramh, paramaa, i); } 
/*     */       } 
/* 123 */     } while (paramIterator.hasNext());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */