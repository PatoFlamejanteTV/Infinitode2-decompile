/*    */ package org.a.c.h.c;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.security.Provider;
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
/*    */ public final class m
/*    */ {
/* 29 */   private static Provider a = null;
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
/*    */   public static Provider a() {
/* 45 */     if (a == null) {
/*    */       try {
/*    */         Class<?> clazz;
/*    */ 
/*    */ 
/*    */         
/* 51 */         a = (clazz = Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider")).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/*    */       }
/* 53 */       catch (ClassNotFoundException classNotFoundException) {
/*    */         
/* 55 */         throw new IOException(classNotFoundException);
/*    */       }
/* 57 */       catch (InstantiationException instantiationException) {
/*    */         
/* 59 */         throw new IOException(instantiationException);
/*    */       }
/* 61 */       catch (IllegalAccessException illegalAccessException) {
/*    */         
/* 63 */         throw new IOException(illegalAccessException);
/*    */       }
/* 65 */       catch (NoSuchMethodException noSuchMethodException) {
/*    */         
/* 67 */         throw new IOException(noSuchMethodException);
/*    */       }
/* 69 */       catch (InvocationTargetException invocationTargetException) {
/*    */         
/* 71 */         throw new IOException(invocationTargetException);
/*    */       } 
/*    */     }
/* 74 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */