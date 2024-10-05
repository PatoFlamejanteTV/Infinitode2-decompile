/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.b.c.k;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.r;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.e;
/*     */ import com.a.a.c.m.r;
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
/*     */ public final class t
/*     */   extends e
/*     */   implements Serializable
/*     */ {
/*     */   private r j;
/*     */   
/*     */   public t(e parame, r paramr) {
/*  43 */     super(parame);
/*  44 */     this.j = paramr;
/*     */   }
/*     */ 
/*     */   
/*     */   private t(t paramt, r paramr, k paramk) {
/*  49 */     super(paramt, paramk);
/*  50 */     this.j = paramr;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private t c(r paramr) {
/*  56 */     String str = this.c.a();
/*  57 */     str = paramr.a(str);
/*     */ 
/*     */     
/*  60 */     paramr = r.a(paramr, this.j);
/*     */     
/*  62 */     return a(paramr, new k(str));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private t a(r paramr, k paramk) {
/*  72 */     return new t(this, paramr, paramk);
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
/*     */   public final void a(Object paramObject, h paramh, aa paramaa) {
/*     */     Object object;
/*  91 */     if ((object = a(paramObject)) == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     Class<?> clazz = object.getClass();
/*     */     o<Object> o;
/*     */     k k;
/* 101 */     if ((o = this.e) == null && (o = (k = this.h).a(clazz)) == null) {
/* 102 */       o = a(k, clazz, paramaa);
/*     */     }
/*     */     
/* 105 */     if (this.i != null) {
/* 106 */       if (b == this.i) {
/* 107 */         if (o.a(paramaa, object)) {
/*     */           return;
/*     */         }
/* 110 */       } else if (this.i.equals(object)) {
/*     */         return;
/*     */       } 
/*     */     }
/*     */     
/* 115 */     if (object == paramObject && 
/* 116 */       a(paramh, paramaa, o)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 122 */     if (!o.c()) {
/* 123 */       paramh.b((r)this.c);
/*     */     }
/*     */     
/* 126 */     if (this.g == null) {
/* 127 */       o.a(object, paramh, paramaa); return;
/*     */     } 
/* 129 */     o.a(object, paramh, paramaa, this.g);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(o<Object> paramo) {
/* 137 */     if (paramo != null) {
/* 138 */       r r1 = this.j;
/* 139 */       if (paramo.c() && paramo instanceof u)
/*     */       {
/*     */ 
/*     */         
/* 143 */         r1 = r.a(r1, ((u)paramo).a);
/*     */       }
/* 145 */       paramo = paramo.a(r1);
/*     */     } 
/* 147 */     super.a(paramo);
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
/*     */ 
/*     */   
/*     */   protected final o<Object> a(k paramk, Class<?> paramClass, aa paramaa) {
/* 209 */     if (this.d != null) {
/* 210 */       j j = paramaa.a(this.d, paramClass);
/* 211 */       o = paramaa.a(j, (c)this);
/*     */     } else {
/* 213 */       o = paramaa.a(paramClass, (c)this);
/*     */     } 
/* 215 */     r r1 = this.j;
/* 216 */     if (o.c() && o instanceof u)
/*     */     {
/*     */ 
/*     */       
/* 220 */       r1 = r.a(r1, ((u)o).a);
/*     */     }
/* 222 */     o<Object> o = o.a(r1);
/*     */     
/* 224 */     this.h = this.h.b(paramClass, o);
/* 225 */     return o;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */