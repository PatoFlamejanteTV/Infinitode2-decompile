/*     */ package com.a.a.c.k;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.k.b.v;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.y;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private c a;
/*     */   private j b;
/*     */   private o<Object> c;
/*     */   private v d;
/*     */   
/*     */   public a(c paramc, j paramj, o<?> paramo) {
/*  32 */     this.b = paramj;
/*  33 */     this.a = paramc;
/*  34 */     this.c = (o)paramo;
/*  35 */     if (paramo instanceof v) {
/*  36 */       this.d = (v)paramo;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(y paramy) {
/*  44 */     this.b.a(paramy
/*  45 */         .a(q.o));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject, h paramh, aa paramaa) {
/*  52 */     if ((paramObject = this.b.b(paramObject)) == null) {
/*     */       return;
/*     */     }
/*  55 */     if (!(paramObject instanceof Map)) {
/*  56 */       paramaa.a(this.a.c(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", new Object[] { this.b
/*     */               
/*  58 */               .b(), paramObject.getClass().getName() }));
/*     */     }
/*     */     
/*  61 */     if (this.d != null) {
/*  62 */       this.d.a((Map)paramObject, paramh, paramaa);
/*     */       return;
/*     */     } 
/*  65 */     this.c.a(paramObject, paramh, paramaa);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject, h paramh, aa paramaa, o paramo) {
/*     */     Object object;
/*  76 */     if ((object = this.b.b(paramObject)) == null) {
/*     */       return;
/*     */     }
/*  79 */     if (!(object instanceof Map)) {
/*  80 */       paramaa.a(this.a.c(), 
/*  81 */           String.format("Value returned by 'any-getter' (%s()) not java.util.Map but %s", new Object[] {
/*  82 */               this.b.b(), object.getClass().getName()
/*     */             }));
/*     */     }
/*  85 */     if (this.d != null) {
/*  86 */       this.d.a(paramaa, paramh, paramObject, (Map)object, paramo, null);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  91 */     this.c.a(object, paramh, paramaa);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(aa paramaa) {
/*  99 */     if (this.c instanceof k) {
/* 100 */       o<Object> o1 = paramaa.a(this.c, this.a);
/* 101 */       this.c = o1;
/* 102 */       if (o1 instanceof v)
/* 103 */         this.d = (v)o1; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */