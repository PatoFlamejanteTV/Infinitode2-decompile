/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Field;
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
/*     */ public final class ao
/*     */   extends j
/*     */   implements Serializable
/*     */ {
/*     */   private Class<?> c;
/*     */   private j d;
/*     */   private String e;
/*     */   
/*     */   public ao(an paraman, Class<?> paramClass, String paramString, j paramj) {
/*  37 */     super(paraman, null);
/*  38 */     this.c = paramClass;
/*  39 */     this.d = paramj;
/*  40 */     this.e = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final b a(aa paramaa) {
/*  45 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Field e() {
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/*  61 */     return this.e;
/*     */   }
/*     */   
/*     */   public final Class<?> d() {
/*  65 */     return this.d.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final j c() {
/*  70 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> h() {
/*  80 */     return this.c;
/*     */   }
/*     */   public final Member i() {
/*  83 */     return null;
/*     */   }
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/*  87 */     throw new IllegalArgumentException("Cannot set virtual property '" + this.e + "'");
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject) {
/*  92 */     throw new IllegalArgumentException("Cannot get virtual property '" + this.e + "'");
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
/*     */   public final int hashCode() {
/* 105 */     return this.e.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 110 */     if (paramObject == this) return true; 
/* 111 */     if (!i.a(paramObject, getClass())) {
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     if (((ao)(paramObject = paramObject)).c == this.c && ((ao)paramObject).e
/* 116 */       .equals(this.e)) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 121 */     return "[virtual " + j() + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\ao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */