/*    */ package com.a.a.c.m;
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
/*    */ public final class w
/*    */ {
/* 15 */   private static final boolean a = (System.getProperty("org.graalvm.nativeimage.imagecode") != null);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean a() {
/* 26 */     return (a && "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode")));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean a(Throwable paramThrowable) {
/* 33 */     if (!a()) {
/* 34 */       return false;
/*    */     }
/* 36 */     if (paramThrowable instanceof java.lang.reflect.InvocationTargetException) {
/* 37 */       paramThrowable = paramThrowable.getCause();
/*    */     }
/* 39 */     return paramThrowable.getClass().getName().equals("com.oracle.svm.core.jdk.UnsupportedFeatureError");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean a(Class<?> paramClass) {
/* 47 */     if (!a()) {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (((paramClass.getDeclaredFields()).length == 0 || i.f(paramClass)) && (paramClass
/* 52 */       .getDeclaredMethods()).length == 0 && (paramClass
/* 53 */       .getDeclaredConstructors()).length == 0) return true; 
/*    */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */