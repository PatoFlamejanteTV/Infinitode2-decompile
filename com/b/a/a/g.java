/*    */ package com.b.a.a;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.security.AccessControlException;
/*    */ import java.security.AccessController;
/*    */ import java.util.MissingResourceException;
/*    */ import java.util.Properties;
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
/*    */ public final class g
/*    */ {
/* 27 */   private static final Properties a = new Properties(); static {
/*    */     try {
/*    */       InputStream inputStream;
/* 30 */       if ((inputStream = i.a("/com/ibm/icu/ICUConfig.properties")) != null)
/*    */       { 
/* 32 */         try { a.load(inputStream); }
/*    */         finally
/* 34 */         { inputStream.close(); }  }
/*    */       else { return; }
/*    */     
/* 37 */     } catch (MissingResourceException missingResourceException) {
/*    */       return;
/* 39 */     } catch (IOException iOException) {}
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String a(String paramString) {
/* 50 */     return a(paramString, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static String a(String paramString1, String paramString2) {
/* 61 */     String str1 = null;
/* 62 */     String str2 = paramString1;
/* 63 */     if (System.getSecurityManager() != null) {
/*    */       try {
/* 65 */         str1 = AccessController.<String>doPrivileged(new h(str2));
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       }
/* 71 */       catch (AccessControlException accessControlException) {}
/*    */     
/*    */     }
/*    */     else {
/*    */       
/* 76 */       str1 = System.getProperty(paramString1);
/*    */     } 
/*    */     
/* 79 */     if (str1 == null) {
/* 80 */       str1 = a.getProperty(paramString1, paramString2);
/*    */     }
/* 82 */     return str1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */