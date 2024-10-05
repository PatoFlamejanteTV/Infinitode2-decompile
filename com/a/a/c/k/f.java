/*     */ package com.a.a.c.k;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.b;
/*     */ import com.a.a.c.k.a.m;
/*     */ import com.a.a.c.k.a.u;
/*     */ import com.a.a.c.k.b.d;
/*     */ import com.a.a.c.m.r;
/*     */ import com.a.a.c.o;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class f
/*     */   extends d
/*     */ {
/*     */   public f(j paramj, g paramg, e[] paramArrayOfe1, e[] paramArrayOfe2) {
/*  45 */     super(paramj, paramg, paramArrayOfe1, paramArrayOfe2);
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
/*     */   private f(d paramd, m paramm, Object paramObject) {
/*  64 */     super(paramd, paramm, paramObject);
/*     */   }
/*     */   
/*     */   private f(d paramd, Set<String> paramSet1, Set<String> paramSet2) {
/*  68 */     super(paramd, paramSet1, paramSet2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private f(d paramd, e[] paramArrayOfe1, e[] paramArrayOfe2) {
/*  74 */     super(paramd, paramArrayOfe1, paramArrayOfe2);
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
/*     */   public static f a(j paramj, g paramg) {
/* 100 */     return new f(paramj, paramg, b, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final o<Object> a(r paramr) {
/* 105 */     return (o<Object>)new u(this, paramr);
/*     */   }
/*     */ 
/*     */   
/*     */   public final d a(m paramm) {
/* 110 */     return new f(this, paramm, this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public final d a(Object paramObject) {
/* 115 */     return new f(this, this.g, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final d a(Set<String> paramSet1, Set<String> paramSet2) {
/* 120 */     return new f(this, paramSet1, paramSet2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final d a(e[] paramArrayOfe1, e[] paramArrayOfe2) {
/* 126 */     return new f(this, paramArrayOfe1, paramArrayOfe2);
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
/*     */   protected final d d() {
/* 144 */     if (this.g == null && this.e == null && this.f == null)
/*     */     {
/*     */ 
/*     */       
/* 148 */       return (d)new b(this);
/*     */     }
/*     */     
/* 151 */     return this;
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
/* 169 */     if (this.g != null) {
/* 170 */       paramh.a(paramObject);
/* 171 */       a(paramObject, paramh, paramaa, true);
/*     */       return;
/*     */     } 
/* 174 */     paramh.c(paramObject);
/* 175 */     if (this.f != null) {
/* 176 */       c(paramObject, paramh, paramaa);
/*     */     } else {
/* 178 */       b(paramObject, paramh, paramaa);
/*     */     } 
/* 180 */     paramh.j();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 190 */     return "BeanSerializer for " + a().getName();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */