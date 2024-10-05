/*    */ package com.d.m;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class e
/*    */ {
/*    */   static {
/*    */   
/*    */   }
/*    */   
/*    */   public static void a(Exception paramException) {
/*    */     String str;
/* 49 */     if ((str = paramException.getMessage()) == null || str.trim().equals("null")) {
/* 50 */       str = "{no ex. message}";
/*    */     }
/* 52 */     System.out.println(str + ", " + paramException.getClass());
/* 53 */     StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
/* 54 */     for (byte b = 0; b < arrayOfStackTraceElement.length && b < 5; b++) {
/* 55 */       StackTraceElement stackTraceElement = arrayOfStackTraceElement[b];
/* 56 */       System.out.println("  " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(ln " + stackTraceElement.getLineNumber() + ")");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\m\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */