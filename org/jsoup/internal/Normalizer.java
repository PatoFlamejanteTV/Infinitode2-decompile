/*    */ package org.jsoup.internal;
/*    */ 
/*    */ import java.util.Locale;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Normalizer
/*    */ {
/*    */   public static String lowerCase(String paramString) {
/* 12 */     return (paramString != null) ? paramString.toLowerCase(Locale.ENGLISH) : "";
/*    */   }
/*    */ 
/*    */   
/*    */   public static String normalize(String paramString) {
/* 17 */     return lowerCase(paramString).trim();
/*    */   }
/*    */ 
/*    */   
/*    */   public static String normalize(String paramString, boolean paramBoolean) {
/* 22 */     return paramBoolean ? lowerCase(paramString) : normalize(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\internal\Normalizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */