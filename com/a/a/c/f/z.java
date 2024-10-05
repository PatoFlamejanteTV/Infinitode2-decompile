/*    */ package com.a.a.c.f;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class z
/*    */ {
/* 13 */   private static Class<?>[] a = new Class[0];
/*    */   
/*    */   private String b;
/*    */   
/*    */   private Class<?>[] c;
/*    */   
/*    */   public z(Method paramMethod) {
/* 20 */     this(paramMethod.getName(), paramMethod.getParameterTypes());
/*    */   }
/*    */ 
/*    */   
/*    */   public z(Constructor<?> paramConstructor) {
/* 25 */     this("", paramConstructor.getParameterTypes());
/*    */   }
/*    */ 
/*    */   
/*    */   public z(String paramString, Class<?>[] paramArrayOfClass) {
/* 30 */     this.b = paramString;
/* 31 */     this.c = (paramArrayOfClass == null) ? a : paramArrayOfClass;
/*    */   }
/*    */   
/*    */   public final String a() {
/* 35 */     return this.b;
/*    */   }
/*    */   
/*    */   public final int b() {
/* 39 */     return this.c.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 44 */     return this.b + "(" + this.c.length + "-args)";
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 49 */     return this.b.hashCode() + this.c.length;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 55 */     if (paramObject == this) return true; 
/* 56 */     if (paramObject == null) return false; 
/* 57 */     if (paramObject.getClass() != getClass()) {
/* 58 */       return false;
/*    */     }
/* 60 */     paramObject = paramObject;
/* 61 */     if (!this.b.equals(((z)paramObject).b)) {
/* 62 */       return false;
/*    */     }
/* 64 */     paramObject = ((z)paramObject).c;
/* 65 */     int i = this.c.length;
/* 66 */     if (paramObject.length != i) {
/* 67 */       return false;
/*    */     }
/* 69 */     for (byte b = 0; b < i; b++) {
/* 70 */       Object object = paramObject[b];
/* 71 */       Class<?> clazz = this.c[b];
/* 72 */       if (object != clazz)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 92 */         return false; } 
/*    */     } 
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */