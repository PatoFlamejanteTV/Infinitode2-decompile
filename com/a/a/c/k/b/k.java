/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.util.Collection;
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
/*     */ public final class k
/*     */   extends b<Collection<?>>
/*     */ {
/*     */   public k(j paramj, boolean paramBoolean, i parami, o<Object> paramo) {
/*  41 */     super(Collection.class, paramj, paramBoolean, parami, paramo);
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
/*     */   private k(k paramk, c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  57 */     super(paramk, paramc, parami, paramo, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final j<?> b(i parami) {
/*  62 */     return new k(this, this.b, parami, this.e, this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private k b(c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  69 */     return new k(this, paramc, parami, paramo, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean b(Collection<?> paramCollection) {
/*  80 */     return paramCollection.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean c(Collection<?> paramCollection) {
/*  85 */     return (paramCollection.size() == 1);
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
/*     */   private void a(Collection<?> paramCollection, h paramh, aa paramaa) {
/*     */     int i;
/*  98 */     if ((i = paramCollection.size()) == 1 && ((
/*  99 */       this.c == null && paramaa
/* 100 */       .a(z.r)) || this.c == Boolean.TRUE)) {
/*     */       
/* 102 */       b(paramCollection, paramh, paramaa);
/*     */       
/*     */       return;
/*     */     } 
/* 106 */     paramh.a(paramCollection, i);
/* 107 */     b(paramCollection, paramh, paramaa);
/* 108 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(Collection<?> paramCollection, h paramh, aa paramaa) {
/* 114 */     paramh.a(paramCollection);
/* 115 */     if (this.e != null) {
/* 116 */       a(paramCollection, paramh, paramaa, this.e);
/*     */       return;
/*     */     } 
/*     */     Iterator<?> iterator;
/* 120 */     if (!(iterator = paramCollection.iterator()).hasNext()) {
/*     */       return;
/*     */     }
/* 123 */     com.a.a.c.k.a.k k1 = this.f;
/* 124 */     i i = this.d;
/*     */     
/* 126 */     byte b1 = 0;
/*     */     try {
/*     */       do {
/*     */         Object object;
/* 130 */         if ((object = iterator.next()) == null) {
/* 131 */           paramaa.a(paramh);
/*     */         } else {
/* 133 */           Class<?> clazz = object.getClass();
/*     */           o o;
/* 135 */           if ((o = k1.a(clazz)) == null) {
/* 136 */             if (this.a.s()) {
/* 137 */               o = a(k1, paramaa
/* 138 */                   .a(this.a, clazz), paramaa);
/*     */             } else {
/* 140 */               o = a(k1, clazz, paramaa);
/*     */             } 
/* 142 */             k1 = this.f;
/*     */           } 
/* 144 */           if (i == null) {
/* 145 */             o.a(object, paramh, paramaa);
/*     */           } else {
/* 147 */             o.a(object, paramh, paramaa, i);
/*     */           } 
/*     */         } 
/* 150 */         b1++;
/* 151 */       } while (iterator.hasNext()); return;
/* 152 */     } catch (Exception exception) {
/* 153 */       a(paramaa, exception, paramCollection, b1);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Collection<?> paramCollection, h paramh, aa paramaa, o<Object> paramo) {
/*     */     Iterator<?> iterator;
/* 161 */     if ((iterator = paramCollection.iterator()).hasNext()) {
/* 162 */       i i = this.d;
/* 163 */       byte b1 = 0;
/*     */       do {
/* 165 */         Object object = iterator.next();
/*     */         try {
/* 167 */           if (object == null) {
/* 168 */             paramaa.a(paramh);
/*     */           }
/* 170 */           else if (i == null) {
/* 171 */             paramo.a(object, paramh, paramaa);
/*     */           } else {
/* 173 */             paramo.a(object, paramh, paramaa, i);
/*     */           } 
/*     */           
/* 176 */           b1++;
/* 177 */         } catch (Exception exception) {
/* 178 */           a(paramaa, exception, paramCollection, b1);
/*     */         } 
/* 180 */       } while (iterator.hasNext());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */