/*    */ package com.badlogic.gdx.net;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.net.URLEncoder;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
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
/*    */ public final class HttpParametersUtils
/*    */ {
/* 32 */   public static String defaultEncoding = "UTF-8";
/* 33 */   public static String nameValueSeparator = "=";
/* 34 */   public static String parameterSeparator = "&";
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String convertHttpParameters(Map<String, String> paramMap) {
/* 40 */     Set<String> set = paramMap.keySet();
/* 41 */     StringBuilder stringBuilder = new StringBuilder();
/* 42 */     for (String str : set) {
/* 43 */       stringBuilder.append(encode(str, defaultEncoding));
/* 44 */       stringBuilder.append(nameValueSeparator);
/* 45 */       stringBuilder.append(encode(paramMap.get(str), defaultEncoding));
/* 46 */       stringBuilder.append(parameterSeparator);
/*    */     } 
/* 48 */     if (stringBuilder.length() > 0) stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
/* 49 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   private static String encode(String paramString1, String paramString2) {
/*    */     try {
/* 54 */       return URLEncoder.encode(paramString1, paramString2);
/* 55 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 56 */       throw new IllegalArgumentException(unsupportedEncodingException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\HttpParametersUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */