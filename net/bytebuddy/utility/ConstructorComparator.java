/*    */ package net.bytebuddy.utility;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
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
/*    */ public enum ConstructorComparator
/*    */   implements Comparator<Constructor<?>>
/*    */ {
/* 29 */   INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int compare(Constructor<?> paramConstructor1, Constructor<?> paramConstructor2) {
/* 35 */     if (paramConstructor1 == paramConstructor2) {
/* 36 */       return 0;
/*    */     }
/*    */     int i;
/* 39 */     if ((i = paramConstructor1.getName().compareTo(paramConstructor2.getName())) == 0) {
/* 40 */       Class[] arrayOfClass1 = paramConstructor1.getParameterTypes(), arrayOfClass2 = paramConstructor2.getParameterTypes();
/* 41 */       if (arrayOfClass1.length < arrayOfClass2.length)
/* 42 */         return -1; 
/* 43 */       if (arrayOfClass1.length > arrayOfClass2.length) {
/* 44 */         return 1;
/*    */       }
/* 46 */       for (i = 0; i < arrayOfClass1.length; i++) {
/*    */         int j;
/* 48 */         if ((j = arrayOfClass1[i].getName().compareTo(arrayOfClass2[i].getName())) != 0) {
/* 49 */           return j;
/*    */         }
/*    */       } 
/* 52 */       return 0;
/*    */     } 
/*    */     
/* 55 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\ConstructorComparator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */