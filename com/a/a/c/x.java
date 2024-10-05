/*     */ package com.a.a.c;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class x
/*     */   implements Serializable
/*     */ {
/*     */   @Deprecated
/*  59 */   private static x a = new f();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*  68 */   private static x b = new e();
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
/*     */   public String a(String paramString) {
/* 119 */     return paramString;
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
/*     */   public String b(String paramString) {
/* 140 */     return paramString;
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
/*     */   public String c(String paramString) {
/* 160 */     return paramString;
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
/*     */   public String d(String paramString) {
/* 178 */     return paramString;
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
/*     */   @Deprecated
/*     */   public static abstract class d
/*     */     extends x
/*     */   {
/*     */     public final String a(String param1String) {
/* 198 */       return e(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String b(String param1String) {
/* 204 */       return e(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String c(String param1String) {
/* 210 */       return e(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String d(String param1String) {
/* 217 */       return e(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract String e(String param1String);
/*     */ 
/*     */ 
/*     */     
/*     */     protected static String a(String param1String, char param1Char) {
/* 227 */       if (param1String == null) {
/* 228 */         return param1String;
/*     */       }
/*     */       int i;
/* 231 */       if ((i = param1String.length()) == 0) {
/* 232 */         return param1String;
/*     */       }
/*     */       
/* 235 */       StringBuilder stringBuilder = new StringBuilder(i + (i >> 1));
/* 236 */       byte b1 = 0;
/* 237 */       for (byte b2 = 0; b2 < i; b2++) {
/*     */         char c1;
/*     */         
/*     */         char c2;
/* 241 */         if ((c2 = Character.toLowerCase(c1 = param1String.charAt(b2))) == c1) {
/*     */ 
/*     */           
/* 244 */           if (b1 > 1)
/*     */           {
/* 246 */             stringBuilder.insert(stringBuilder.length() - 1, param1Char);
/*     */           }
/* 248 */           b1 = 0;
/*     */         } else {
/*     */           
/* 251 */           if (b1 == 0 && b2 > 0) {
/* 252 */             stringBuilder.append(param1Char);
/*     */           }
/* 254 */           b1++;
/*     */         } 
/* 256 */         stringBuilder.append(c2);
/*     */       } 
/* 258 */       return stringBuilder.toString();
/*     */     }
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
/*     */   @Deprecated
/*     */   public static class e
/*     */     extends d
/*     */   {
/*     */     public final String e(String param1String) {
/* 280 */       if (param1String == null) return param1String; 
/* 281 */       int i = param1String.length();
/* 282 */       StringBuilder stringBuilder = new StringBuilder(i << 1);
/* 283 */       byte b1 = 0;
/* 284 */       boolean bool = false;
/* 285 */       for (byte b2 = 0; b2 < i; b2++) {
/*     */         
/* 287 */         char c = param1String.charAt(b2);
/* 288 */         if (b2 > 0 || c != '_') {
/*     */           
/* 290 */           if (Character.isUpperCase(c)) {
/*     */             
/* 292 */             if (!bool && b1 && stringBuilder.charAt(b1 - 1) != '_') {
/*     */               
/* 294 */               stringBuilder.append('_');
/* 295 */               b1++;
/*     */             } 
/* 297 */             c = Character.toLowerCase(c);
/* 298 */             bool = true;
/*     */           }
/*     */           else {
/*     */             
/* 302 */             bool = false;
/*     */           } 
/* 304 */           stringBuilder.append(c);
/* 305 */           b1++;
/*     */         } 
/*     */       } 
/* 308 */       return (b1 > 0) ? stringBuilder.toString() : param1String;
/*     */     }
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
/*     */   @Deprecated
/*     */   public static class f
/*     */     extends d
/*     */   {
/*     */     public final String e(String param1String) {
/* 332 */       if (param1String == null || param1String.isEmpty()) {
/* 333 */         return param1String;
/*     */       }
/*     */ 
/*     */       
/* 337 */       char c1, c2 = Character.toUpperCase(c1 = param1String.charAt(0));
/* 338 */       if (c1 == c2) {
/* 339 */         return param1String;
/*     */       }
/*     */       StringBuilder stringBuilder;
/* 342 */       (stringBuilder = new StringBuilder(param1String)).setCharAt(0, c2);
/* 343 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static class b
/*     */     extends d
/*     */   {
/*     */     public final String e(String param1String) {
/* 358 */       return param1String.toLowerCase();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static class a
/*     */     extends d
/*     */   {
/*     */     public final String e(String param1String) {
/* 373 */       return a(param1String, '-');
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static class c
/*     */     extends d
/*     */   {
/*     */     public final String e(String param1String) {
/* 387 */       return a(param1String, '.');
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */