/*     */ package com.vladsch.flexmark.util.misc;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.BiFunction;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ public class Utils {
/*     */   public static <T> T ifNull(T paramT1, T paramT2) {
/*  17 */     return (paramT1 == null) ? paramT2 : paramT1;
/*     */   }
/*     */   
/*     */   public static <T> T ifNullOr(T paramT1, boolean paramBoolean, T paramT2) {
/*  21 */     return (paramT1 == null || paramBoolean) ? paramT2 : paramT1;
/*     */   }
/*     */   
/*     */   public static <T> T ifNullOrNot(T paramT1, boolean paramBoolean, T paramT2) {
/*  25 */     return (paramT1 == null || !paramBoolean) ? paramT2 : paramT1;
/*     */   }
/*     */   
/*     */   public static <T> T ifNullOr(T paramT1, Function<T, Boolean> paramFunction, T paramT2) {
/*  29 */     return (paramT1 == null || ((Boolean)paramFunction.apply(paramT1)).booleanValue()) ? paramT2 : paramT1;
/*     */   }
/*     */   
/*     */   public static <T> T ifNullOrNot(T paramT1, Function<T, Boolean> paramFunction, T paramT2) {
/*  33 */     return (paramT1 == null || !((Boolean)paramFunction.apply(paramT1)).booleanValue()) ? paramT2 : paramT1;
/*     */   }
/*     */   
/*     */   public static String ifNullOrEmpty(String paramString1, String paramString2) {
/*  37 */     return (paramString1 == null || paramString1.isEmpty()) ? paramString2 : paramString1;
/*     */   }
/*     */   
/*     */   public static String ifNullOrBlank(String paramString1, String paramString2) {
/*  41 */     return (paramString1 == null || isBlank(paramString1)) ? paramString2 : paramString1;
/*     */   }
/*     */   
/*     */   public static String ifEmpty(String paramString1, String paramString2) {
/*  45 */     if (paramString1 != null && !paramString1.isEmpty()) return paramString1; 
/*  46 */     return paramString2;
/*     */   }
/*     */   
/*     */   public static String ifEmpty(String paramString1, String paramString2, String paramString3) {
/*  50 */     return (paramString1 == null || paramString1.isEmpty()) ? paramString2 : paramString3;
/*     */   }
/*     */   
/*     */   public static String ifEmptyNullArgs(String paramString1, String paramString2, String paramString3) {
/*  54 */     return (paramString1 == null || paramString1.isEmpty()) ? paramString2 : paramString3;
/*     */   }
/*     */   
/*     */   public static String ifEmpty(String paramString, Supplier<String> paramSupplier) {
/*  58 */     if (paramString != null && !paramString.isEmpty()) return paramString; 
/*  59 */     return paramSupplier.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String ifEmpty(String paramString, Supplier<String> paramSupplier1, Supplier<String> paramSupplier2) {
/*  67 */     return (paramString == null || paramString.isEmpty()) ? paramSupplier1.get() : paramSupplier2.get();
/*     */   }
/*     */   
/*     */   public static boolean isBlank(String paramString) {
/*  71 */     return (paramString == null || paramString.trim().isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isWhiteSpaceNoEOL(String paramString) {
/*  76 */     int i = paramString.length();
/*  77 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/*  79 */       if ((c = paramString.charAt(b)) != ' ' && c != '\t') return false; 
/*     */     } 
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   public static String orEmpty(String paramString) {
/*  85 */     return (paramString == null) ? "" : paramString;
/*     */   }
/*     */   
/*     */   public static String wrapWith(String paramString, char paramChar) {
/*  89 */     return wrapWith(paramString, paramChar, paramChar);
/*     */   }
/*     */   
/*     */   public static String wrapWith(String paramString, char paramChar1, char paramChar2) {
/*  93 */     return (paramString == null || paramString.isEmpty()) ? "" : (paramChar1 + paramString + paramChar2);
/*     */   }
/*     */   
/*     */   public static String wrapWith(String paramString1, String paramString2) {
/*  97 */     return wrapWith(paramString1, paramString2, paramString2);
/*     */   }
/*     */   
/*     */   public static String wrapWith(String paramString1, String paramString2, String paramString3) {
/* 101 */     return (paramString1 == null || paramString1.isEmpty()) ? "" : prefixWith(suffixWith(paramString1, paramString3), paramString2);
/*     */   }
/*     */   
/*     */   public static String suffixWith(String paramString, char paramChar) {
/* 105 */     return suffixWith(paramString, paramChar, false);
/*     */   }
/*     */   
/*     */   public static String suffixWithEol(String paramString) {
/* 109 */     return suffixWith(paramString, '\n', false);
/*     */   }
/*     */   
/*     */   public static String suffixWith(String paramString, char paramChar, boolean paramBoolean) {
/* 113 */     if (paramString != null && !paramString.isEmpty() && !endsWith(paramString, String.valueOf(paramChar), paramBoolean)) {
/* 114 */       return paramString + paramChar;
/*     */     }
/* 116 */     return orEmpty(paramString);
/*     */   }
/*     */   
/*     */   public static String suffixWith(String paramString1, String paramString2) {
/* 120 */     return suffixWith(paramString1, paramString2, false);
/*     */   }
/*     */   
/*     */   public static String suffixWith(String paramString1, String paramString2, boolean paramBoolean) {
/* 124 */     if (paramString1 != null && !paramString1.isEmpty() && paramString2 != null && !paramString2.isEmpty() && !endsWith(paramString1, paramString2, paramBoolean)) {
/* 125 */       return paramString1 + paramString2;
/*     */     }
/* 127 */     return orEmpty(paramString1);
/*     */   }
/*     */   
/*     */   public static String prefixWith(String paramString, char paramChar) {
/* 131 */     return prefixWith(paramString, paramChar, false);
/*     */   }
/*     */   
/*     */   public static String prefixWith(String paramString, char paramChar, boolean paramBoolean) {
/* 135 */     if (paramString != null && !paramString.isEmpty() && !startsWith(paramString, String.valueOf(paramChar), paramBoolean)) {
/* 136 */       return paramChar + paramString;
/*     */     }
/* 138 */     return orEmpty(paramString);
/*     */   }
/*     */   
/*     */   public static String prefixWith(String paramString1, String paramString2) {
/* 142 */     return prefixWith(paramString1, paramString2, false);
/*     */   }
/*     */   
/*     */   public static String prefixWith(String paramString1, String paramString2, boolean paramBoolean) {
/* 146 */     if (paramString1 != null && !paramString1.isEmpty() && paramString2 != null && !paramString2.isEmpty() && !startsWith(paramString1, paramString2, paramBoolean))
/* 147 */       return paramString2 + paramString1; 
/* 148 */     return orEmpty(paramString1);
/*     */   }
/*     */   
/*     */   public static boolean isIn(String paramString, String... paramVarArgs) {
/* 152 */     if (paramString == null) return false;  int i; byte b;
/* 153 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/* 154 */       if (paramString.equals(str)) return true;  b++; }
/*     */     
/* 156 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean endsWith(String paramString, String... paramVarArgs) {
/* 160 */     return endsWith(paramString, false, paramVarArgs);
/*     */   }
/*     */   public static boolean endsWith(String paramString, boolean paramBoolean, String... paramVarArgs) {
/*     */     int i;
/* 164 */     if (paramString == null) return false;
/*     */     
/* 166 */     if (paramBoolean) {
/* 167 */       String[] arrayOfString; byte b; for (i = (arrayOfString = paramVarArgs).length, b = 0; b < i; ) { String str = arrayOfString[b];
/* 168 */         if (paramString.length() >= str.length() && paramString.substring(paramString.length() - str.length()).equalsIgnoreCase(str))
/* 169 */           return true;  b++; }
/*     */     
/*     */     } else {
/*     */       int j; byte b;
/* 173 */       for (i = (j = i).length, b = 0; b < i; ) { int k = j[b];
/* 174 */         if (paramString.endsWith(k))
/* 175 */           return true; 
/*     */         b++; }
/*     */     
/*     */     } 
/* 179 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean startsWith(String paramString, String... paramVarArgs) {
/* 183 */     return startsWith(paramString, false, paramVarArgs);
/*     */   }
/*     */   public static boolean startsWith(String paramString, boolean paramBoolean, String... paramVarArgs) {
/*     */     int i;
/* 187 */     if (paramString == null) return false;
/*     */     
/* 189 */     if (paramBoolean) {
/* 190 */       String[] arrayOfString; byte b; for (i = (arrayOfString = paramVarArgs).length, b = 0; b < i; ) { String str = arrayOfString[b];
/* 191 */         if (paramString.length() >= str.length() && paramString.substring(0, str.length()).equalsIgnoreCase(str))
/* 192 */           return true;  b++; }
/*     */     
/*     */     } else {
/*     */       int j; byte b;
/* 196 */       for (i = (j = i).length, b = 0; b < i; ) { int k = j[b];
/* 197 */         if (paramString.startsWith(k))
/* 198 */           return true; 
/*     */         b++; }
/*     */     
/*     */     } 
/* 202 */     return false;
/*     */   }
/*     */   
/*     */   public static int count(String paramString, char paramChar, int paramInt1, int paramInt2) {
/* 206 */     if (paramString == null) return 0;
/*     */     
/* 208 */     byte b = 0;
/* 209 */     paramInt1 = paramInt1;
/* 210 */     paramInt2 = Math.min(paramString.length(), paramInt2);
/* 211 */     while (paramInt1 >= 0 && paramInt1 <= paramInt2 && (
/*     */       
/* 213 */       paramInt1 = paramString.indexOf(paramChar, paramInt1)) >= 0) {
/* 214 */       b++;
/* 215 */       paramInt1++;
/*     */     } 
/* 217 */     return b;
/*     */   }
/*     */   
/*     */   public static int count(String paramString1, String paramString2, int paramInt1, int paramInt2) {
/* 221 */     if (paramString1 == null) return 0;
/*     */     
/* 223 */     byte b = 0;
/* 224 */     paramInt1 = paramInt1;
/* 225 */     paramInt2 = Math.min(paramString1.length(), paramInt2);
/* 226 */     while (paramInt1 >= 0 && paramInt1 <= paramInt2 && (
/*     */       
/* 228 */       paramInt1 = paramString1.indexOf(paramString2, paramInt1)) >= 0 && paramInt1 <= paramInt2) {
/* 229 */       b++;
/* 230 */       paramInt1++;
/*     */     } 
/* 232 */     return b;
/*     */   }
/*     */   
/*     */   public static String urlDecode(String paramString1, String paramString2) {
/*     */     try {
/* 237 */       return URLDecoder.decode(paramString1, (paramString2 != null) ? paramString2 : "UTF-8");
/* 238 */     } catch (UnsupportedEncodingException|IllegalArgumentException unsupportedEncodingException) {
/*     */       
/* 240 */       return orEmpty(paramString1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String urlEncode(String paramString1, String paramString2) {
/*     */     try {
/* 246 */       return URLEncoder.encode(paramString1, (paramString2 != null) ? paramString2 : "UTF-8");
/* 247 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */       
/* 249 */       return orEmpty(paramString1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String removePrefix(String paramString, char paramChar) {
/* 254 */     if (paramString != null) {
/* 255 */       if (paramString.startsWith(String.valueOf(paramChar))) {
/* 256 */         return paramString.substring(1);
/*     */       }
/* 258 */       return paramString;
/*     */     } 
/* 260 */     return "";
/*     */   }
/*     */   
/*     */   public static String removePrefix(String paramString1, String paramString2) {
/* 264 */     if (paramString1 != null) {
/* 265 */       if (paramString1.startsWith(String.valueOf(paramString2))) {
/* 266 */         return paramString1.substring(paramString2.length());
/*     */       }
/* 268 */       return paramString1;
/*     */     } 
/* 270 */     return "";
/*     */   }
/*     */   
/*     */   public static String removeAnyPrefix(String paramString, String... paramVarArgs) {
/* 274 */     if (paramString != null) {
/* 275 */       int i; byte b; for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/* 276 */         if (paramString.startsWith(String.valueOf(str)))
/* 277 */           return paramString.substring(str.length()); 
/*     */         b++; }
/*     */       
/* 280 */       return paramString;
/*     */     } 
/* 282 */     return "";
/*     */   }
/*     */   
/*     */   public static String removePrefixIncluding(String paramString1, String paramString2) {
/* 286 */     if (paramString1 != null) {
/*     */       int i;
/* 288 */       if ((i = paramString1.indexOf(paramString2)) != -1) {
/* 289 */         return paramString1.substring(i + paramString2.length());
/*     */       }
/* 291 */       return paramString1;
/*     */     } 
/* 293 */     return "";
/*     */   }
/*     */   
/*     */   public static String removeSuffix(String paramString, char paramChar) {
/* 297 */     if (paramString != null) {
/* 298 */       if (paramString.endsWith(String.valueOf(paramChar))) {
/* 299 */         return paramString.substring(0, paramString.length() - 1);
/*     */       }
/* 301 */       return paramString;
/*     */     } 
/* 303 */     return "";
/*     */   }
/*     */   
/*     */   public static String removeSuffix(String paramString1, String paramString2) {
/* 307 */     if (paramString1 != null) {
/* 308 */       if (paramString1.endsWith(String.valueOf(paramString2))) {
/* 309 */         return paramString1.substring(0, paramString1.length() - paramString2.length());
/*     */       }
/* 311 */       return paramString1;
/*     */     } 
/* 313 */     return "";
/*     */   }
/*     */   
/*     */   public static String removeAnySuffix(String paramString, String... paramVarArgs) {
/* 317 */     if (paramString != null) {
/* 318 */       int i; byte b; for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/* 319 */         if (paramString.endsWith(String.valueOf(str)))
/* 320 */           return paramString.substring(0, paramString.length() - str.length()); 
/*     */         b++; }
/*     */       
/* 323 */       return paramString;
/*     */     } 
/* 325 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> List<? extends T> stringSorted(Collection<? extends T> paramCollection, Function<T, String> paramFunction) {
/* 330 */     (paramCollection = new ArrayList<>(paramCollection)).sort(Comparator.comparing(paramFunction));
/* 331 */     return (List<? extends T>)paramCollection;
/*     */   }
/*     */   
/*     */   public static String regexGroup(String paramString) {
/* 335 */     return "(?:" + orEmpty(paramString) + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean regionMatches(CharSequence paramCharSequence, int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 346 */     if (paramBoolean) {
/* 347 */       for (paramBoolean = false; paramBoolean < paramInt3; paramBoolean++) {
/* 348 */         if (Character.toLowerCase(paramCharSequence.charAt(paramBoolean + paramInt1)) != Character.toLowerCase(paramString.charAt(paramBoolean + paramInt2)))
/* 349 */           return false; 
/*     */       } 
/*     */     } else {
/* 352 */       for (paramBoolean = false; paramBoolean < paramInt3; paramBoolean++) {
/* 353 */         if (paramCharSequence.charAt(paramBoolean + paramInt1) != paramString.charAt(paramBoolean + paramInt2)) return false; 
/*     */       } 
/*     */     } 
/* 356 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean endsWith(CharSequence paramCharSequence, String paramString, boolean paramBoolean) {
/* 360 */     return (paramCharSequence.length() >= paramString.length() && regionMatches(paramCharSequence, paramCharSequence.length() - paramString.length(), paramString, 0, paramString.length(), paramBoolean));
/*     */   }
/*     */   
/*     */   public static boolean startsWith(CharSequence paramCharSequence, String paramString, boolean paramBoolean) {
/* 364 */     return (paramCharSequence.length() >= paramString.length() && regionMatches(paramCharSequence, 0, paramString, 0, paramString.length(), paramBoolean));
/*     */   }
/*     */   
/*     */   public static String splice(String[] paramArrayOfString, String paramString) {
/* 368 */     StringBuilder stringBuilder = new StringBuilder(paramArrayOfString.length * (paramString.length() + 10));
/* 369 */     String str = ""; int i; byte b;
/* 370 */     for (i = (paramArrayOfString = paramArrayOfString).length, b = 0; b < i; ) { String str1 = paramArrayOfString[b];
/* 371 */       stringBuilder.append(str);
/* 372 */       str = paramString;
/* 373 */       stringBuilder.append(str1); b++; }
/*     */     
/* 375 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLongestCommonPrefix(String... paramVarArgs) {
/* 385 */     if (paramVarArgs == null || paramVarArgs.length == 0) return ""; 
/* 386 */     if (paramVarArgs.length == 1) return paramVarArgs[0];
/*     */     
/*     */     String str;
/* 389 */     int i = (str = paramVarArgs[0]).length();
/* 390 */     int j = paramVarArgs.length;
/*     */     byte b;
/* 392 */     for (b = 1; b < j; b++) {
/* 393 */       i = Math.min(paramVarArgs[b].length(), i);
/*     */     }
/*     */     
/* 396 */     for (b = 0; b < i; b++) {
/* 397 */       char c = str.charAt(b);
/* 398 */       for (byte b1 = 1; b1 < j; b1++) {
/* 399 */         if (paramVarArgs[b1].charAt(b) != c) return str.substring(0, b); 
/*     */       } 
/*     */     } 
/* 402 */     return str.substring(0, i);
/*     */   }
/*     */   
/*     */   public static String getAbbreviatedText(String paramString, int paramInt) {
/* 406 */     if (paramString == null) return ""; 
/* 407 */     if (paramString.length() <= paramInt || paramInt < 6) return paramString;
/*     */     
/* 409 */     int i = paramInt / 2;
/* 410 */     paramInt = paramInt - 3 - i;
/* 411 */     return paramString.substring(0, i) + " … " + paramString.substring(paramString.length() - paramInt);
/*     */   }
/*     */   
/*     */   public static String splice(Collection<String> paramCollection, String paramString, boolean paramBoolean) {
/* 415 */     StringBuilder stringBuilder = new StringBuilder(paramCollection.size() * (paramString.length() + 10));
/* 416 */     String str = "";
/* 417 */     for (Iterator<String> iterator = paramCollection.iterator(); iterator.hasNext();) {
/* 418 */       if (((str1 = iterator.next()) != null && !str1.isEmpty()) || !paramBoolean) {
/* 419 */         if (!paramBoolean || (!str1.startsWith(paramString) && !endsWith(stringBuilder.toString(), new String[] { paramString })))
/* 420 */           stringBuilder.append(str); 
/* 421 */         str = paramString;
/* 422 */         stringBuilder.append(orEmpty(str1));
/*     */       } 
/*     */     } 
/* 425 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static String join(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4) {
/*     */     StringBuilder stringBuilder;
/* 430 */     (stringBuilder = new StringBuilder()).append(paramString1); int i; byte b;
/* 431 */     for (i = (paramArrayOfString = paramArrayOfString).length, b = 0; b < i; ) { String str = paramArrayOfString[b];
/* 432 */       stringBuilder.append(paramString3).append(str).append(paramString4); b++; }
/*     */     
/* 434 */     stringBuilder.append(paramString2);
/* 435 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String join(Collection<String> paramCollection, String paramString1, String paramString2, String paramString3, String paramString4) {
/*     */     StringBuilder stringBuilder;
/* 446 */     (stringBuilder = new StringBuilder()).append(paramString1);
/* 447 */     for (String paramString1 : paramCollection) {
/* 448 */       stringBuilder.append(paramString3).append(paramString1).append(paramString4);
/*     */     }
/* 450 */     stringBuilder.append(paramString2);
/* 451 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static String repeat(String paramString, int paramInt) {
/* 455 */     if (paramInt > 0) {
/* 456 */       StringBuilder stringBuilder = new StringBuilder(paramString.length() * paramInt);
/* 457 */       while (paramInt-- > 0) {
/* 458 */         stringBuilder.append(paramString);
/*     */       }
/* 460 */       return stringBuilder.toString();
/*     */     } 
/* 462 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int max(int paramInt, int... paramVarArgs) {
/* 470 */     paramInt = paramInt; int i; byte b;
/* 471 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { int j = paramVarArgs[b];
/* 472 */       if (paramInt < j) paramInt = j;  b++; }
/*     */     
/* 474 */     return paramInt;
/*     */   }
/*     */   
/*     */   public static int min(int paramInt, int... paramVarArgs) {
/* 478 */     paramInt = paramInt; int i; byte b;
/* 479 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { int j = paramVarArgs[b];
/* 480 */       if (paramInt > j) paramInt = j;  b++; }
/*     */     
/* 482 */     return paramInt;
/*     */   }
/*     */   
/*     */   public static int minLimit(int paramInt, int... paramVarArgs) {
/* 486 */     return max(paramInt, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static int maxLimit(int paramInt, int... paramVarArgs) {
/* 490 */     return min(paramInt, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static int rangeLimit(int paramInt1, int paramInt2, int paramInt3) {
/* 494 */     return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
/*     */   }
/*     */   
/*     */   public static float max(float paramFloat, float... paramVarArgs) {
/* 498 */     paramFloat = paramFloat; int i; byte b;
/* 499 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { float f = paramVarArgs[b];
/* 500 */       if (paramFloat < f) paramFloat = f;  b++; }
/*     */     
/* 502 */     return paramFloat;
/*     */   }
/*     */   
/*     */   public static float min(float paramFloat, float... paramVarArgs) {
/* 506 */     paramFloat = paramFloat; int i; byte b;
/* 507 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { float f = paramVarArgs[b];
/* 508 */       if (paramFloat > f) paramFloat = f;  b++; }
/*     */     
/* 510 */     return paramFloat;
/*     */   }
/*     */   
/*     */   public static float minLimit(float paramFloat, float... paramVarArgs) {
/* 514 */     return max(paramFloat, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static float maxLimit(float paramFloat, float... paramVarArgs) {
/* 518 */     return min(paramFloat, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static float rangeLimit(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 522 */     return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
/*     */   }
/*     */   
/*     */   public static int compare(Number paramNumber1, Number paramNumber2) {
/* 526 */     if (paramNumber1 == null && paramNumber2 == null) return 0; 
/* 527 */     if (paramNumber1 == null) return -1; 
/* 528 */     if (paramNumber2 == null) return 1; 
/* 529 */     if (paramNumber1 instanceof Double || paramNumber2 instanceof Double || paramNumber1 instanceof Float || paramNumber2 instanceof Float) return Double.compare(paramNumber1.doubleValue(), paramNumber2.doubleValue()); 
/* 530 */     return Long.compare(paramNumber1.longValue(), paramNumber2.longValue());
/*     */   }
/*     */   
/*     */   public static <T extends Comparable<T>> int compareNullable(T paramT1, T paramT2) {
/* 534 */     if (paramT1 == null || paramT2 == null) return 0; 
/* 535 */     return paramT1.compareTo(paramT2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K, V> V putIfMissing(Map<K, V> paramMap, K paramK, Supplier<V> paramSupplier) {
/*     */     V v;
/* 541 */     if ((v = paramMap.get(paramK)) == null) {
/* 542 */       v = paramSupplier.get();
/* 543 */       paramMap.put(paramK, v);
/*     */     } 
/* 545 */     return v;
/*     */   }
/*     */   
/*     */   public static <K, V> Map<K, V> withDefaults(Map<K, V> paramMap1, Map<K, V> paramMap2) {
/* 549 */     paramMap1 = new HashMap<>(paramMap1);
/* 550 */     for (Map.Entry<K, V> entry : paramMap2.entrySet()) {
/* 551 */       putIfMissing(paramMap1, (K)entry.getKey(), entry::getValue);
/*     */     }
/* 553 */     return paramMap1;
/*     */   }
/*     */   
/*     */   public static <K, V> void removeIf(Map<K, V> paramMap, Function<Map.Entry<K, V>, Boolean> paramFunction) {
/* 557 */     ArrayList arrayList = new ArrayList();
/* 558 */     for (Map.Entry<K, V> entry : paramMap.entrySet()) {
/* 559 */       if (((Boolean)paramFunction.apply(entry)).booleanValue()) {
/* 560 */         arrayList.add(entry.getKey());
/*     */       }
/*     */     } 
/*     */     
/* 564 */     for (Object object : arrayList) {
/* 565 */       paramMap.remove(object);
/*     */     }
/*     */   }
/*     */   
/*     */   public static <K, V> void removeIf(Map<K, V> paramMap, BiFunction<K, V, Boolean> paramBiFunction) {
/* 570 */     removeIf(paramMap, paramEntry -> (Boolean)paramBiFunction.apply(paramEntry.getKey(), paramEntry.getValue()));
/*     */   }
/*     */   
/*     */   public static void streamAppend(StringBuilder paramStringBuilder, InputStream paramInputStream) {
/* 574 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
/*     */     
/*     */     try {
/*     */       String str;
/* 578 */       while ((str = bufferedReader.readLine()) != null)
/*     */       {
/*     */ 
/*     */         
/* 582 */         paramStringBuilder.append(str).append('\n');
/*     */       }
/* 584 */     } catch (IOException iOException2) {
/* 585 */       IOException iOException1; (iOException1 = null).printStackTrace();
/*     */     } finally {
/*     */       try {
/* 588 */         bufferedReader.close();
/* 589 */       } catch (IOException iOException) {
/* 590 */         (bufferedReader = null).printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getResourceAsString(Class<?> paramClass, String paramString) {
/* 596 */     InputStream inputStream = paramClass.getResourceAsStream(paramString);
/*     */     StringBuilder stringBuilder;
/* 598 */     streamAppend(stringBuilder = new StringBuilder(), inputStream);
/* 599 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String escapeJavaString(CharSequence paramCharSequence) {
/* 604 */     if (paramCharSequence == null) return "null"; 
/*     */     StringBuilder stringBuilder;
/* 606 */     escapeJavaString(stringBuilder = new StringBuilder(), paramCharSequence);
/* 607 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String quoteJavaString(CharSequence paramCharSequence) {
/* 612 */     if (paramCharSequence == null) return "null"; 
/*     */     StringBuilder stringBuilder;
/* 614 */     (stringBuilder = new StringBuilder()).append("\"");
/* 615 */     escapeJavaString(stringBuilder, paramCharSequence);
/* 616 */     stringBuilder.append("\"");
/* 617 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static void escapeJavaString(StringBuilder paramStringBuilder, CharSequence paramCharSequence) {
/* 621 */     int i = paramCharSequence.length();
/* 622 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/* 624 */       switch (c = paramCharSequence.charAt(b)) {
/*     */         case '"':
/* 626 */           paramStringBuilder.append("\\\"");
/*     */           break;
/*     */         case '\n':
/* 629 */           paramStringBuilder.append("\\n");
/*     */           break;
/*     */         case '\r':
/* 632 */           paramStringBuilder.append("\\r");
/*     */           break;
/*     */         case '\t':
/* 635 */           paramStringBuilder.append("\\t");
/*     */           break;
/*     */         case '\b':
/* 638 */           paramStringBuilder.append("\\b");
/*     */           break;
/*     */         case '\f':
/* 641 */           paramStringBuilder.append("\\f");
/*     */           break;
/*     */         case '\000':
/* 644 */           paramStringBuilder.append("\\0");
/*     */           break;
/*     */         default:
/* 647 */           if (c < ' ') {
/* 648 */             paramStringBuilder.append('%').append(String.format("%02x", new Object[] { Integer.valueOf(c) })); break;
/*     */           } 
/* 650 */           paramStringBuilder.append(c);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> T getOrNull(List<T> paramList, int paramInt) {
/* 658 */     if (paramInt >= 0 && paramInt < paramList.size()) {
/* 659 */       return paramList.get(paramInt);
/*     */     }
/* 661 */     return null;
/*     */   }
/*     */   
/*     */   public static <T, S extends T> S getOrNull(List<T> paramList, int paramInt, Class<S> paramClass) {
/* 665 */     if (paramInt >= 0 && paramInt < paramList.size()) {
/* 666 */       paramList = (List<T>)paramList.get(paramInt);
/*     */       
/* 668 */       return (S)(paramClass.isInstance(paramList) ? paramList : null);
/*     */     } 
/* 670 */     return null;
/*     */   }
/*     */   
/*     */   public static <T> T setOrAdd(List<T> paramList, int paramInt, T paramT) {
/* 674 */     if (paramInt == paramList.size()) {
/* 675 */       paramList.add(paramT);
/* 676 */       return null;
/*     */     } 
/* 678 */     return paramList.set(paramInt, paramT);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */