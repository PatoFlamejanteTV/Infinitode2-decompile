/*    */ package net.bytebuddy.utility;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Comparator;
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
/*    */ public enum MethodComparator
/*    */   implements Comparator<Method>
/*    */ {
/* 29 */   INSTANCE;
/*    */ 
/*    */ 
/*    */   
/*    */   public final int compare(Method paramMethod1, Method paramMethod2) {
/*    */     Class[] arrayOfClass;
/* 35 */     if (paramMethod1 == paramMethod2) {
/* 36 */       return 0;
/*    */     }
/*    */     int i;
/* 39 */     if ((i = paramMethod1.getName().compareTo(paramMethod2.getName())) == 0) {
/* 40 */       arrayOfClass = paramMethod1.getParameterTypes(); Class[] arrayOfClass1 = paramMethod2.getParameterTypes();
/* 41 */       if (arrayOfClass.length < arrayOfClass1.length)
/* 42 */         return -1; 
/* 43 */       if (arrayOfClass.length > arrayOfClass1.length) {
/* 44 */         return 1;
/*    */       }
/* 46 */       for (byte b = 0; b < arrayOfClass.length; b++) {
/*    */         int j;
/* 48 */         if ((j = arrayOfClass[b].getName().compareTo(arrayOfClass1[b].getName())) != 0) {
/* 49 */           return j;
/*    */         }
/*    */       } 
/* 52 */       return paramMethod1.getReturnType().getName().compareTo(paramMethod2.getReturnType().getName());
/*    */     } 
/*    */     
/* 55 */     return arrayOfClass;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\MethodComparator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */