/*    */ package com.a.a.c.m;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class af
/*    */   implements Serializable
/*    */ {
/* 11 */   private static af a = new af();
/*    */   public boolean a(Class<?> paramClass) {
/* 13 */     return false;
/*    */   }
/*    */   
/*    */   public static af a(Class<?>[] paramArrayOfClass) {
/* 17 */     if (paramArrayOfClass == null) {
/* 18 */       return a;
/*    */     }
/* 20 */     switch (paramArrayOfClass.length) {
/*    */       case 0:
/* 22 */         return a;
/*    */       case 1:
/* 24 */         return new b(paramArrayOfClass[0]);
/*    */     } 
/* 26 */     return new a(paramArrayOfClass);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static final class b
/*    */     extends af
/*    */   {
/*    */     private final Class<?> a;
/*    */ 
/*    */ 
/*    */     
/*    */     public b(Class<?> param1Class) {
/* 40 */       this.a = param1Class;
/*    */     }
/*    */     public final boolean a(Class<?> param1Class) {
/* 43 */       return (param1Class == this.a || this.a.isAssignableFrom(param1Class));
/*    */     }
/*    */   }
/*    */   
/*    */   static final class a
/*    */     extends af
/*    */     implements Serializable
/*    */   {
/*    */     private final Class<?>[] a;
/*    */     
/*    */     public a(Class<?>[] param1ArrayOfClass) {
/* 54 */       this.a = param1ArrayOfClass;
/*    */     }
/*    */     public final boolean a(Class<?> param1Class) {
/*    */       byte b;
/*    */       int i;
/* 59 */       for (b = 0, i = this.a.length; b < i; b++) {
/* 60 */         Class<?> clazz = this.a[b];
/* 61 */         if (param1Class == clazz || clazz.isAssignableFrom(param1Class)) {
/* 62 */           return true;
/*    */         }
/*    */       } 
/* 65 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\af.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */