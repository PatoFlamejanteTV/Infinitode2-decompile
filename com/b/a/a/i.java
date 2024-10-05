/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.security.AccessController;
/*     */ import java.util.MissingResourceException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */ {
/*     */   private static InputStream a(Class<?> paramClass, String paramString, boolean paramBoolean) {
/*     */     InputStream inputStream;
/* 109 */     if (System.getSecurityManager() != null) {
/* 110 */       inputStream = AccessController.<InputStream>doPrivileged(new j(paramClass, paramString));
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 117 */       inputStream = inputStream.getResourceAsStream(paramString);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     return inputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static InputStream a(ClassLoader paramClassLoader, String paramString, boolean paramBoolean) {
/*     */     InputStream inputStream;
/* 132 */     if (System.getSecurityManager() != null) {
/* 133 */       inputStream = AccessController.<InputStream>doPrivileged(new k(paramClassLoader, paramString));
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 140 */       inputStream = paramClassLoader.getResourceAsStream(paramString);
/*     */     } 
/* 142 */     if (inputStream == null && paramBoolean) {
/* 143 */       throw new MissingResourceException("could not locate data", paramClassLoader.toString(), paramString);
/*     */     }
/*     */     
/* 146 */     return inputStream;
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
/*     */   public static InputStream a(String paramString) {
/* 184 */     return a(i.class, paramString, false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */