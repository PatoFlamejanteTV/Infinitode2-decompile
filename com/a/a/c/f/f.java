/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends o
/*     */ {
/*     */   private Constructor<?> d;
/*     */   
/*     */   public f(an paraman, Constructor<?> paramConstructor, aa paramaa, aa[] paramArrayOfaa) {
/*  34 */     super(paraman, paramaa, paramArrayOfaa);
/*  35 */     if (paramConstructor == null) {
/*  36 */       throw new IllegalArgumentException("Null constructor not allowed");
/*     */     }
/*  38 */     this.d = paramConstructor;
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
/*     */   private f b(aa paramaa) {
/*  54 */     return new f(this.a, this.d, paramaa, this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Constructor<?> e() {
/*  64 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/*  70 */     return this.d.getName();
/*     */   }
/*     */   
/*     */   public final j c() {
/*  74 */     return this.a.a(d());
/*     */   }
/*     */ 
/*     */   
/*     */   public final Class<?> d() {
/*  79 */     return this.d.getDeclaringClass();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int f() {
/*  90 */     return this.d.getParameterCount();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> a(int paramInt) {
/*  96 */     Class[] arrayOfClass = this.d.getParameterTypes();
/*  97 */     return (paramInt >= arrayOfClass.length) ? null : arrayOfClass[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public final j b(int paramInt) {
/* 102 */     Type[] arrayOfType = this.d.getGenericParameterTypes();
/* 103 */     if (paramInt >= arrayOfType.length) {
/* 104 */       return null;
/*     */     }
/* 106 */     return this.a.a(arrayOfType[paramInt]);
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
/*     */   public final Object g() {
/* 123 */     return this.d.newInstance((Object[])null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object a(Object[] paramArrayOfObject) {
/* 128 */     return this.d.newInstance(paramArrayOfObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object a(Object paramObject) {
/* 133 */     return this.d.newInstance(new Object[] { paramObject });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> h() {
/* 143 */     return this.d.getDeclaringClass();
/*     */   }
/*     */   public final Member i() {
/* 146 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/* 152 */     throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + 
/* 153 */         h().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject) {
/* 160 */     throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + 
/* 161 */         h().getName());
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
/* 172 */     int i = this.d.getParameterCount();
/* 173 */     return String.format("[constructor for %s (%d arg%s), annotations: %s", new Object[] {
/* 174 */           i.g(this.d.getDeclaringClass()), Integer.valueOf(i), (i == 1) ? "" : "s", this.b
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 180 */     return this.d.getName().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 185 */     if (paramObject == this) return true; 
/* 186 */     if (!i.a(paramObject, getClass())) {
/* 187 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 191 */     if (((f)(paramObject = paramObject)).d == null) {
/* 192 */       return (this.d == null);
/*     */     }
/* 194 */     return ((f)paramObject).d.equals(this.d);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */