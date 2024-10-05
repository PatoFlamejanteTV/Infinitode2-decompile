/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.k.b.d;
/*     */ import com.a.a.c.k.e;
/*     */ import com.a.a.c.m.r;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.io.Serializable;
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
/*     */ public final class u
/*     */   extends d
/*     */   implements Serializable
/*     */ {
/*     */   protected final r a;
/*     */   
/*     */   public u(d paramd, r paramr) {
/*  37 */     super(paramd, paramr);
/*  38 */     this.a = paramr;
/*     */   }
/*     */ 
/*     */   
/*     */   private u(u paramu, m paramm) {
/*  43 */     super(paramu, paramm);
/*  44 */     this.a = paramu.a;
/*     */   }
/*     */ 
/*     */   
/*     */   private u(u paramu, m paramm, Object paramObject) {
/*  49 */     super(paramu, paramm, paramObject);
/*  50 */     this.a = paramu.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private u(u paramu, Set<String> paramSet1, Set<String> paramSet2) {
/*  58 */     super(paramu, paramSet1, paramSet2);
/*  59 */     this.a = paramu.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private u(u paramu, e[] paramArrayOfe1, e[] paramArrayOfe2) {
/*  65 */     super(paramu, paramArrayOfe1, paramArrayOfe2);
/*  66 */     this.a = paramu.a;
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
/*     */   public final o<Object> a(r paramr) {
/*  78 */     return (o<Object>)new u(this, paramr);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean c() {
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final d a(m paramm) {
/*  88 */     return new u(this, paramm);
/*     */   }
/*     */ 
/*     */   
/*     */   public final d a(Object paramObject) {
/*  93 */     return new u(this, this.g, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final d a(Set<String> paramSet1, Set<String> paramSet2) {
/*  98 */     return new u(this, paramSet1, paramSet2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final d a(e[] paramArrayOfe1, e[] paramArrayOfe2) {
/* 104 */     return new u(this, paramArrayOfe1, paramArrayOfe2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final d d() {
/* 113 */     return this;
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
/*     */   public final void a(Object paramObject, h paramh, aa paramaa) {
/* 130 */     paramh.a(paramObject);
/* 131 */     if (this.g != null) {
/* 132 */       a(paramObject, paramh, paramaa, false);
/*     */       return;
/*     */     } 
/* 135 */     if (this.f != null) {
/* 136 */       c(paramObject, paramh, paramaa); return;
/*     */     } 
/* 138 */     b(paramObject, paramh, paramaa);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject, h paramh, aa paramaa, i parami) {
/* 146 */     if (paramaa.a(z.f)) {
/* 147 */       paramaa.a(a(), "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
/*     */     }
/*     */     
/* 150 */     paramh.a(paramObject);
/* 151 */     if (this.g != null) {
/* 152 */       b(paramObject, paramh, paramaa, parami);
/*     */       return;
/*     */     } 
/* 155 */     if (this.f != null) {
/* 156 */       c(paramObject, paramh, paramaa); return;
/*     */     } 
/* 158 */     b(paramObject, paramh, paramaa);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 169 */     return "UnwrappingBeanSerializer for " + a().getName();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */