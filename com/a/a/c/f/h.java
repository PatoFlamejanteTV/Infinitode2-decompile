/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Modifier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */   extends j
/*     */   implements Serializable
/*     */ {
/*     */   private transient Field c;
/*     */   
/*     */   public h(an paraman, Field paramField, aa paramaa) {
/*  39 */     super(paraman, paramaa);
/*  40 */     this.c = paramField;
/*     */   }
/*     */ 
/*     */   
/*     */   private h b(aa paramaa) {
/*  45 */     return new h(this.a, this.c, paramaa);
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
/*     */   public final Field e() {
/*  65 */     return this.c;
/*     */   }
/*     */   public final int f() {
/*  68 */     return this.c.getModifiers();
/*     */   }
/*     */   public final String b() {
/*  71 */     return this.c.getName();
/*     */   }
/*     */   
/*     */   public final Class<?> d() {
/*  75 */     return this.c.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public final j c() {
/*  80 */     return this.a.a(this.c.getGenericType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> h() {
/*  90 */     return this.c.getDeclaringClass();
/*     */   }
/*     */   public final Member i() {
/*  93 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/*     */     try {
/*  99 */       this.c.set(paramObject1, paramObject2); return;
/* 100 */     } catch (IllegalAccessException illegalAccessException) {
/* 101 */       throw new IllegalArgumentException("Failed to setValue() for field " + 
/* 102 */           j() + ": " + illegalAccessException.getMessage(), illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject) {
/*     */     try {
/* 110 */       return this.c.get(paramObject);
/* 111 */     } catch (IllegalAccessException illegalAccessException) {
/* 112 */       throw new IllegalArgumentException("Failed to getValue() for field " + 
/* 113 */           j() + ": " + illegalAccessException.getMessage(), illegalAccessException);
/*     */     } 
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
/*     */   public final boolean g() {
/* 128 */     return Modifier.isTransient(f());
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 132 */     return this.c.getName().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 137 */     if (paramObject == this) return true; 
/* 138 */     if (!i.a(paramObject, getClass())) {
/* 139 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 143 */     if (((h)(paramObject = paramObject)).c == null) {
/* 144 */       return (this.c == null);
/*     */     }
/* 146 */     return ((h)paramObject).c.equals(this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 152 */     return "[field " + j() + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */