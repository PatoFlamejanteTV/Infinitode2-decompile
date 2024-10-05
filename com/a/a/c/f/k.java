/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Method;
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
/*     */ public final class k
/*     */   extends o
/*     */   implements Serializable
/*     */ {
/*     */   private transient Method d;
/*     */   private Class<?>[] e;
/*     */   
/*     */   public k(an paraman, Method paramMethod, aa paramaa, aa[] paramArrayOfaa) {
/*  37 */     super(paraman, paramaa, paramArrayOfaa);
/*  38 */     if (paramMethod == null) {
/*  39 */       throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
/*     */     }
/*  41 */     this.d = paramMethod;
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
/*     */   private k b(aa paramaa) {
/*  57 */     return new k(this.a, this.d, paramaa, this.c);
/*     */   }
/*     */   
/*     */   public final Method e() {
/*  61 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/*  67 */     return this.d.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j c() {
/*  76 */     return this.a.a(this.d.getGenericReturnType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> d() {
/*  86 */     return this.d.getReturnType();
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
/*     */   public final Object g() {
/*  99 */     return this.d.invoke(null, new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object a(Object[] paramArrayOfObject) {
/* 104 */     return this.d.invoke(null, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Object a(Object paramObject) {
/* 109 */     return this.d.invoke(null, new Object[] { paramObject });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(Object paramObject, Object... paramVarArgs) {
/* 117 */     return this.d.invoke(paramObject, paramVarArgs);
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
/* 128 */     return this.d.getParameterCount();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> a(int paramInt) {
/* 134 */     Class[] arrayOfClass = n();
/* 135 */     return (paramInt >= arrayOfClass.length) ? null : arrayOfClass[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public final j b(int paramInt) {
/* 140 */     Type[] arrayOfType = this.d.getGenericParameterTypes();
/* 141 */     if (paramInt >= arrayOfType.length) {
/* 142 */       return null;
/*     */     }
/* 144 */     return this.a.a(arrayOfType[paramInt]);
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
/*     */   public final Class<?> h() {
/* 158 */     return this.d.getDeclaringClass();
/*     */   }
/*     */   public final Method l() {
/* 161 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2) {
/*     */     try {
/* 167 */       this.d.invoke(paramObject1, new Object[] { paramObject2 }); return;
/* 168 */     } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
/* 169 */       throw new IllegalArgumentException("Failed to setValue() with method " + 
/* 170 */           j() + ": " + i.g(illegalAccessException), illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object b(Object paramObject) {
/*     */     try {
/* 178 */       return this.d.invoke(paramObject, (Object[])null);
/* 179 */     } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
/* 180 */       throw new IllegalArgumentException("Failed to getValue() with method " + 
/* 181 */           j() + ": " + i.g(illegalAccessException), illegalAccessException);
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
/*     */   public final String j() {
/* 193 */     String str = super.j();
/* 194 */     switch (f()) {
/*     */       case 0:
/* 196 */         return str + "()";
/*     */       case 1:
/* 198 */         return str + "(" + a(0).getName() + ")";
/*     */     } 
/*     */     
/* 201 */     return String.format("%s(%d params)", new Object[] { super.j(), Integer.valueOf(f()) });
/*     */   }
/*     */ 
/*     */   
/*     */   private Class<?>[] n() {
/* 206 */     if (this.e == null) {
/* 207 */       this.e = this.d.getParameterTypes();
/*     */     }
/* 209 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> m() {
/* 218 */     return this.d.getReturnType();
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
/*     */   public final String toString() {
/* 245 */     return "[method " + j() + "]";
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 250 */     return this.d.getName().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 255 */     if (paramObject == this) return true; 
/* 256 */     if (!i.a(paramObject, getClass())) {
/* 257 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 261 */     if (((k)(paramObject = paramObject)).d == null) {
/* 262 */       return (this.d == null);
/*     */     }
/* 264 */     return ((k)paramObject).d.equals(this.d);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */