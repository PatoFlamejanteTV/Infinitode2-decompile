/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Member;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class n
/*     */   extends j
/*     */ {
/*     */   private o c;
/*     */   private j d;
/*     */   private int e;
/*     */   
/*     */   public n(o paramo, j paramj, an paraman, aa paramaa, int paramInt) {
/*  45 */     super(paraman, paramaa);
/*  46 */     this.c = paramo;
/*  47 */     this.d = paramj;
/*  48 */     this.e = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private n b(aa paramaa) {
/*  53 */     if (paramaa == this.b) {
/*  54 */       return this;
/*     */     }
/*  56 */     return this.c.a(this.e, paramaa);
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
/*     */   public final AnnotatedElement a() {
/*  70 */     return null;
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
/*     */   public final String b() {
/*  84 */     return "";
/*     */   }
/*     */   
/*     */   public final Class<?> d() {
/*  88 */     return this.d.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final j c() {
/*  93 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> h() {
/* 104 */     return this.c.h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Member i() {
/* 111 */     return this.c.i();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/* 117 */     throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + 
/* 118 */         h().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject) {
/* 124 */     throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + 
/* 125 */         h().getName());
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
/*     */   public final o e() {
/* 142 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int f() {
/* 149 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 159 */     return this.c.hashCode() + this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 164 */     if (paramObject == this) return true; 
/* 165 */     if (!i.a(paramObject, getClass())) {
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     if (((n)(paramObject = paramObject)).c.equals(this.c) && ((n)paramObject).e == this.e) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 174 */     return "[parameter #" + f() + ", annotations: " + this.b + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */