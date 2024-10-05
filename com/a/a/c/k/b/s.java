/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ @a
/*     */ public final class s
/*     */   extends b<Iterable<?>>
/*     */ {
/*     */   public s(j paramj, boolean paramBoolean, i parami) {
/*  19 */     super(Iterable.class, paramj, paramBoolean, parami, (o)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private s(s params, c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  25 */     super(params, paramc, parami, paramo, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final j<?> b(i parami) {
/*  30 */     return new s(this, this.b, parami, this.e, this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private s b(c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  37 */     return new s(this, paramc, parami, paramo, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(Iterable<?> paramIterable) {
/*  43 */     return !paramIterable.iterator().hasNext();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean b(Iterable<?> paramIterable) {
/*     */     Iterator<?> iterator;
/*  49 */     if (paramIterable != null && (
/*     */       
/*  51 */       iterator = paramIterable.iterator()).hasNext()) {
/*  52 */       iterator.next();
/*  53 */       if (!iterator.hasNext()) {
/*  54 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  58 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Iterable<?> paramIterable, h paramh, aa paramaa) {
/*  65 */     if ((this.c == null && paramaa
/*  66 */       .a(z.r)) || this.c == Boolean.TRUE)
/*     */     {
/*  68 */       if (b(paramIterable)) {
/*  69 */         b(paramIterable, paramh, paramaa);
/*     */         return;
/*     */       } 
/*     */     }
/*  73 */     paramh.b(paramIterable);
/*  74 */     b(paramIterable, paramh, paramaa);
/*  75 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(Iterable<?> paramIterable, h paramh, aa paramaa) {
/*     */     Iterator<?> iterator;
/*  83 */     if ((iterator = paramIterable.iterator()).hasNext()) {
/*  84 */       i i = this.d;
/*  85 */       o o = null;
/*  86 */       Class<?> clazz = null;
/*     */       
/*     */       do {
/*     */         Object object;
/*  90 */         if ((object = iterator.next()) == null) {
/*  91 */           paramaa.a(paramh);
/*     */         } else {
/*     */           o o1;
/*     */           
/*  95 */           if ((o1 = this.e) == null) {
/*     */             Class<?> clazz1;
/*     */             
/*  98 */             if ((clazz1 = object.getClass()) == clazz) {
/*  99 */               o1 = o;
/*     */             } else {
/*     */               
/* 102 */               o = o1 = paramaa.a(clazz1, this.b);
/* 103 */               clazz = clazz1;
/*     */             } 
/*     */           } 
/* 106 */           if (i == null)
/* 107 */           { o1.a(object, paramh, paramaa); }
/*     */           else
/* 109 */           { o1.a(object, paramh, paramaa, i); } 
/*     */         } 
/* 111 */       } while (iterator.hasNext());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */