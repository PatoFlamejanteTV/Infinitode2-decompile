/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.a.i;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.c.r;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.c;
/*     */ import com.a.a.c.f.f;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.l;
/*     */ import com.a.a.c.p;
/*     */ import com.a.a.c.q;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ah
/*     */   implements r, Serializable
/*     */ {
/*     */   public static p a(l paraml) {
/*  39 */     return new ag.b(paraml, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static p a(l paraml, k paramk) {
/*  44 */     return new ag.b(paraml, paramk);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static p a(j paramj, k<?> paramk) {
/*  50 */     return new ag.a(paramj.b(), paramk);
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
/*     */   public static p a(f paramf, j paramj) {
/*     */     b b;
/*     */     c<f, i.a> c;
/*  72 */     if ((c = a(b = paramf.b(paramj))) != null && c.b != null) {
/*  73 */       return a(paramf, (j)c.a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     List<?> list;
/*     */ 
/*     */ 
/*     */     
/*  83 */     (list = b.n()).removeIf(paramc -> 
/*  84 */         (((k)paramc.a).f() != 1 || ((k)paramc.a).a(0) != String.class || paramc.b == i.a.c));
/*     */ 
/*     */ 
/*     */     
/*     */     k k;
/*     */ 
/*     */     
/*  91 */     if ((k = a((List)list)) != null) {
/*  92 */       return a(paramf, (j)k);
/*     */     }
/*     */     
/*  95 */     if (c != null) {
/*  96 */       return a(paramf, (j)c.a);
/*     */     }
/*     */ 
/*     */     
/* 100 */     if (!list.isEmpty())
/*     */     {
/*     */       
/* 103 */       return a(paramf, (j)((c)list.get(0)).a);
/*     */     }
/* 105 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static p a(f paramf, j paramj) {
/*     */     Constructor<?> constructor;
/* 111 */     if (paramj instanceof f) {
/* 112 */       constructor = ((f)paramj).e();
/* 113 */       if (paramf.g()) {
/* 114 */         i.a(constructor, paramf.a(q.o));
/*     */       }
/* 116 */       return new ag.c(constructor);
/*     */     } 
/* 118 */     Method method = ((k)constructor).e();
/* 119 */     if (paramf.g()) {
/* 120 */       i.a(method, paramf.a(q.o));
/*     */     }
/* 122 */     return new ag.d(method);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static c<f, i.a> a(b paramb) {
/* 130 */     for (Iterator<c> iterator = paramb.l().iterator(); iterator.hasNext();) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       if ((f = (f)(c = iterator.next()).a).f() == 1 && String.class == f
/* 136 */         .a(0)) {
/* 137 */         return c;
/*     */       }
/*     */     } 
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static k a(List<c<k, i.a>> paramList) {
/* 147 */     k k = null;
/* 148 */     for (Iterator<c<k, i.a>> iterator = paramList.iterator(); iterator.hasNext();) {
/*     */       
/* 150 */       if ((c = iterator.next()).b != null) {
/* 151 */         if (k == null) {
/* 152 */           k = (k)c.a;
/*     */           
/*     */           continue;
/*     */         } 
/* 156 */         Class clazz = ((k)c.a).h();
/* 157 */         throw new IllegalArgumentException("Multiple suitable annotated Creator factory methods to be used as the Key deserializer for type " + 
/*     */             
/* 159 */             i.g(clazz));
/*     */       } 
/*     */     } 
/*     */     
/* 163 */     return k;
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
/*     */   public final p a(j paramj) {
/*     */     Class<?> clazz;
/* 178 */     if ((clazz = paramj.b()).isPrimitive()) {
/* 179 */       clazz = i.i(clazz);
/*     */     }
/* 181 */     return ag.a(clazz);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ah.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */