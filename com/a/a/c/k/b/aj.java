/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.k.q;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.k;
/*     */ import com.a.a.c.o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class aj
/*     */   extends ao<Object>
/*     */   implements k, q
/*     */ {
/*     */   private k<Object, ?> a;
/*     */   private j b;
/*     */   private o<Object> c;
/*     */   
/*     */   public aj(k<Object, ?> paramk, j paramj, o<?> paramo) {
/*  74 */     super(paramj);
/*  75 */     this.a = paramk;
/*  76 */     this.b = paramj;
/*  77 */     this.c = (o)paramo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private aj a(k<Object, ?> paramk, j paramj, o<?> paramo) {
/*  87 */     i.a(aj.class, this, "withDelegate");
/*  88 */     return new aj(paramk, paramj, paramo);
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
/*     */   public final void a(aa paramaa) {
/* 100 */     if (this.c != null && this.c instanceof q)
/*     */     {
/* 102 */       ((q)this.c).a(paramaa);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/* 110 */     o<Object> o1 = this.c;
/* 111 */     j j1 = this.b;
/*     */     
/* 113 */     if (o1 == null) {
/*     */       
/* 115 */       if (j1 == null) {
/* 116 */         paramaa.b(); j1 = this.a.b();
/*     */       } 
/*     */ 
/*     */       
/* 120 */       if (!j1.q()) {
/* 121 */         o1 = paramaa.a(j1);
/*     */       }
/*     */     } 
/* 124 */     if (o1 instanceof k) {
/* 125 */       o1 = paramaa.b(o1, paramc);
/*     */     }
/* 127 */     if (o1 == this.c && j1 == this.b) {
/* 128 */       return this;
/*     */     }
/* 130 */     return a(this.a, j1, o1);
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
/*     */   public final void a(Object paramObject, h paramh, aa paramaa) {
/* 159 */     if ((paramObject = a(paramObject)) == null) {
/* 160 */       paramaa.a(paramh);
/*     */       
/*     */       return;
/*     */     } 
/*     */     o<Object> o1;
/* 165 */     if ((o1 = this.c) == null) {
/* 166 */       o1 = a(paramObject, paramaa);
/*     */     }
/* 168 */     o1.a(paramObject, paramh, paramaa);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject, h paramh, aa paramaa, i parami) {
/* 177 */     Object object = a(paramObject);
/*     */     o<Object> o1;
/* 179 */     if ((o1 = this.c) == null) {
/* 180 */       o1 = a(paramObject, paramaa);
/*     */     }
/* 182 */     o1.a(object, paramh, paramaa, parami);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(aa paramaa, Object paramObject) {
/*     */     Object object;
/* 189 */     if ((object = a(paramObject)) == null) {
/* 190 */       return true;
/*     */     }
/* 192 */     if (this.c == null) {
/* 193 */       return (paramObject == null);
/*     */     }
/* 195 */     return this.c.a(paramaa, object);
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
/*     */   private Object a(Object paramObject) {
/* 255 */     return this.a.a(paramObject);
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
/*     */   private static o<Object> a(Object paramObject, aa paramaa) {
/* 270 */     return paramaa.c(paramObject.getClass());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\aj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */