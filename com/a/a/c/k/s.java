/*     */ package com.a.a.c.k;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.r;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.k;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.o;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class s
/*     */   extends e
/*     */   implements Serializable
/*     */ {
/*     */   protected s() {}
/*     */   
/*     */   protected s(com.a.a.c.f.s params, b paramb, j paramj1, o<?> paramo, i parami, j paramj2, com.a.a.a.s.b paramb1, Class<?>[] paramArrayOfClass) {
/*  57 */     super(params, params.v(), paramb, paramj1, paramo, parami, paramj2, 
/*     */         
/*  59 */         a(paramb1), b(paramb1), paramArrayOfClass);
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
/*     */   private static boolean a(com.a.a.a.s.b paramb) {
/*  81 */     if (paramb == null) {
/*  82 */       return false;
/*     */     }
/*     */     com.a.a.a.s.a a;
/*  85 */     if ((a = paramb.b()) != com.a.a.a.s.a.a && a != com.a.a.a.s.a.g) return true;  return false;
/*     */   }
/*     */   
/*     */   private static Object b(com.a.a.a.s.b paramb) {
/*  89 */     if (paramb == null) {
/*  90 */       return Boolean.FALSE;
/*     */     }
/*     */     com.a.a.a.s.a a;
/*  93 */     if ((a = paramb.b()) == com.a.a.a.s.a.a || a == com.a.a.a.s.a.b || a == com.a.a.a.s.a.g)
/*     */     {
/*     */       
/*  96 */       return null;
/*     */     }
/*  98 */     return b;
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
/*     */   protected abstract Object a(aa paramaa);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract s l();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     Object object;
/* 153 */     if ((object = a(paramaa)) == null) {
/* 154 */       if (this.f != null) {
/* 155 */         paramh.b((r)this.c);
/* 156 */         this.f.a(null, paramh, paramaa);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 162 */     Class<?> clazz = object.getClass();
/*     */     o<Object> o;
/*     */     k k;
/* 165 */     if ((o = this.e) == null && (o = (k = this.h).a(clazz)) == null) {
/* 166 */       o = a(k, clazz, paramaa);
/*     */     }
/*     */     
/* 169 */     if (this.i != null) {
/* 170 */       if (b == this.i) {
/* 171 */         if (o.a(paramaa, object)) {
/*     */           return;
/*     */         }
/* 174 */       } else if (this.i.equals(object)) {
/*     */         return;
/*     */       } 
/*     */     }
/* 178 */     if (object == paramObject)
/*     */     {
/* 180 */       if (a(paramh, paramaa, o)) {
/*     */         return;
/*     */       }
/*     */     }
/* 184 */     paramh.b((r)this.c);
/* 185 */     if (this.g == null) {
/* 186 */       o.a(object, paramh, paramaa); return;
/*     */     } 
/* 188 */     o.a(object, paramh, paramaa, this.g);
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
/*     */   public final void b(Object paramObject, h paramh, aa paramaa) {
/*     */     Object object;
/* 202 */     if ((object = a(paramaa)) == null) {
/* 203 */       if (this.f != null) {
/* 204 */         this.f.a(null, paramh, paramaa); return;
/*     */       } 
/* 206 */       paramh.k();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 212 */     Class<?> clazz = object.getClass();
/*     */     o<Object> o;
/*     */     k k;
/* 215 */     if ((o = this.e) == null && (o = (k = this.h).a(clazz)) == null) {
/* 216 */       o = a(k, clazz, paramaa);
/*     */     }
/*     */     
/* 219 */     if (this.i != null) {
/* 220 */       if (b == this.i) {
/* 221 */         if (o.a(paramaa, object)) {
/* 222 */           a(paramh, paramaa);
/*     */           return;
/*     */         } 
/* 225 */       } else if (this.i.equals(object)) {
/* 226 */         a(paramh, paramaa);
/*     */         return;
/*     */       } 
/*     */     }
/* 230 */     if (object == paramObject && 
/* 231 */       a(paramh, paramaa, o)) {
/*     */       return;
/*     */     }
/*     */     
/* 235 */     if (this.g == null) {
/* 236 */       o.a(object, paramh, paramaa); return;
/*     */     } 
/* 238 */     o.a(object, paramh, paramaa, this.g);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */