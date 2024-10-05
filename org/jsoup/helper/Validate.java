/*     */ package org.jsoup.helper;
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
/*     */ public final class Validate
/*     */ {
/*     */   public static void notNull(Object paramObject) {
/*  18 */     if (paramObject == null) {
/*  19 */       throw new ValidationException("Object must not be null");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notNullParam(Object paramObject, String paramString) {
/*  30 */     if (paramObject == null) {
/*  31 */       throw new ValidationException(String.format("The parameter '%s' must not be null.", new Object[] { paramString }));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notNull(Object paramObject, String paramString) {
/*  41 */     if (paramObject == null) {
/*  42 */       throw new ValidationException(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object ensureNotNull(Object paramObject) {
/*  53 */     if (paramObject == null)
/*  54 */       throw new ValidationException("Object must not be null"); 
/*  55 */     return paramObject;
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
/*     */   public static Object ensureNotNull(Object paramObject, String paramString, Object... paramVarArgs) {
/*  68 */     if (paramObject == null)
/*  69 */       throw new ValidationException(String.format(paramString, paramVarArgs)); 
/*  70 */     return paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isTrue(boolean paramBoolean) {
/*  79 */     if (!paramBoolean) {
/*  80 */       throw new ValidationException("Must be true");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isTrue(boolean paramBoolean, String paramString) {
/*  90 */     if (!paramBoolean) {
/*  91 */       throw new ValidationException(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isFalse(boolean paramBoolean) {
/* 100 */     if (paramBoolean) {
/* 101 */       throw new ValidationException("Must be false");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isFalse(boolean paramBoolean, String paramString) {
/* 111 */     if (paramBoolean) {
/* 112 */       throw new ValidationException(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void noNullElements(Object[] paramArrayOfObject) {
/* 121 */     noNullElements(paramArrayOfObject, "Array must not contain any null objects");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void noNullElements(Object[] paramArrayOfObject, String paramString) {
/*     */     int i;
/*     */     byte b;
/* 131 */     for (i = (paramArrayOfObject = paramArrayOfObject).length, b = 0; b < i; b++) {
/* 132 */       Object object; if ((object = paramArrayOfObject[b]) == null) {
/* 133 */         throw new ValidationException(paramString);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(String paramString) {
/* 142 */     if (paramString == null || paramString.length() == 0) {
/* 143 */       throw new ValidationException("String must not be empty");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmptyParam(String paramString1, String paramString2) {
/* 153 */     if (paramString1 == null || paramString1.length() == 0) {
/* 154 */       throw new ValidationException(String.format("The '%s' parameter must not be empty.", new Object[] { paramString2 }));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(String paramString1, String paramString2) {
/* 164 */     if (paramString1 == null || paramString1.length() == 0) {
/* 165 */       throw new ValidationException(paramString2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void wtf(String paramString) {
/* 174 */     throw new IllegalStateException(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void fail(String paramString) {
/* 183 */     throw new ValidationException(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean assertFail(String paramString) {
/* 193 */     fail(paramString);
/* 194 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void fail(String paramString, Object... paramVarArgs) {
/* 204 */     throw new ValidationException(String.format(paramString, paramVarArgs));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\Validate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */