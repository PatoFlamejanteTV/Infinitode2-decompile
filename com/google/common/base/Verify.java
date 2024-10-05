/*     */ package com.google.common.base;
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
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public final class Verify
/*     */ {
/*     */   public static void verify(boolean paramBoolean) {
/* 101 */     if (!paramBoolean) {
/* 102 */       throw new VerifyException();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void verify(boolean paramBoolean, String paramString, Object... paramVarArgs) {
/* 125 */     if (!paramBoolean) {
/* 126 */       throw new VerifyException(Strings.lenientFormat(paramString, paramVarArgs));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, char paramChar) {
/* 139 */     if (!paramBoolean) {
/* 140 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, int paramInt) {
/* 153 */     if (!paramBoolean) {
/* 154 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, long paramLong) {
/* 167 */     if (!paramBoolean) {
/* 168 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, Object paramObject) {
/* 182 */     if (!paramBoolean) {
/* 183 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { paramObject }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, char paramChar1, char paramChar2) {
/* 196 */     if (!paramBoolean) {
/* 197 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, int paramInt, char paramChar) {
/* 210 */     if (!paramBoolean) {
/* 211 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, long paramLong, char paramChar) {
/* 224 */     if (!paramBoolean) {
/* 225 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, Object paramObject, char paramChar) {
/* 239 */     if (!paramBoolean) {
/* 240 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, char paramChar, int paramInt) {
/* 253 */     if (!paramBoolean) {
/* 254 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {
/* 267 */     if (!paramBoolean) {
/* 268 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, long paramLong, int paramInt) {
/* 281 */     if (!paramBoolean) {
/* 282 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, Object paramObject, int paramInt) {
/* 296 */     if (!paramBoolean) {
/* 297 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, char paramChar, long paramLong) {
/* 310 */     if (!paramBoolean) {
/* 311 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, int paramInt, long paramLong) {
/* 324 */     if (!paramBoolean) {
/* 325 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {
/* 338 */     if (!paramBoolean) {
/* 339 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, Object paramObject, long paramLong) {
/* 353 */     if (!paramBoolean) {
/* 354 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, char paramChar, Object paramObject) {
/* 368 */     if (!paramBoolean) {
/* 369 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, int paramInt, Object paramObject) {
/* 383 */     if (!paramBoolean) {
/* 384 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, long paramLong, Object paramObject) {
/* 398 */     if (!paramBoolean) {
/* 399 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2) {
/* 416 */     if (!paramBoolean) {
/* 417 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2 }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
/* 435 */     if (!paramBoolean) {
/* 436 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
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
/*     */   public static void verify(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/* 455 */     if (!paramBoolean) {
/* 456 */       throw new VerifyException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T verifyNotNull(T paramT) {
/* 479 */     return verifyNotNull(paramT, "expected a non-null reference", new Object[0]);
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
/*     */   public static <T> T verifyNotNull(T paramT, String paramString, Object... paramVarArgs) {
/* 502 */     if (paramT == null) {
/* 503 */       throw new VerifyException(Strings.lenientFormat(paramString, paramVarArgs));
/*     */     }
/* 505 */     return paramT;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Verify.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */