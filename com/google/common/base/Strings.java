/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Strings
/*     */ {
/*     */   public static String nullToEmpty(String paramString) {
/*  45 */     return Platform.nullToEmpty(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String emptyToNull(String paramString) {
/*  56 */     return Platform.emptyToNull(paramString);
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
/*     */   public static boolean isNullOrEmpty(String paramString) {
/*  71 */     return Platform.stringIsNullOrEmpty(paramString);
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
/*     */   public static String padStart(String paramString, int paramInt, char paramChar) {
/*  93 */     Preconditions.checkNotNull(paramString);
/*  94 */     if (paramString.length() >= paramInt) {
/*  95 */       return paramString;
/*     */     }
/*  97 */     StringBuilder stringBuilder = new StringBuilder(paramInt);
/*  98 */     for (int i = paramString.length(); i < paramInt; i++) {
/*  99 */       stringBuilder.append(paramChar);
/*     */     }
/* 101 */     stringBuilder.append(paramString);
/* 102 */     return stringBuilder.toString();
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
/*     */   public static String padEnd(String paramString, int paramInt, char paramChar) {
/* 124 */     Preconditions.checkNotNull(paramString);
/* 125 */     if (paramString.length() >= paramInt) {
/* 126 */       return paramString;
/*     */     }
/*     */     StringBuilder stringBuilder;
/* 129 */     (stringBuilder = new StringBuilder(paramInt)).append(paramString);
/* 130 */     for (int i = paramString.length(); i < paramInt; i++) {
/* 131 */       stringBuilder.append(paramChar);
/*     */     }
/* 133 */     return stringBuilder.toString();
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
/*     */   public static String repeat(String paramString, int paramInt) {
/* 147 */     Preconditions.checkNotNull(paramString);
/*     */     
/* 149 */     if (paramInt <= 1) {
/* 150 */       Preconditions.checkArgument((paramInt >= 0), "invalid count: %s", paramInt);
/* 151 */       return (paramInt == 0) ? "" : paramString;
/*     */     } 
/*     */     
/*     */     int j;
/*     */     
/*     */     long l;
/*     */     
/* 158 */     if ((paramInt = (int)(l = (j = paramString.length()) * paramInt)) != l) {
/* 159 */       throw new ArrayIndexOutOfBoundsException((new StringBuilder(51)).append("Required array size too large: ").append(l).toString());
/*     */     }
/*     */     
/* 162 */     char[] arrayOfChar = new char[paramInt];
/* 163 */     paramString.getChars(0, j, arrayOfChar, 0);
/*     */     int i;
/* 165 */     for (i = j; i < paramInt - i; i <<= 1) {
/* 166 */       System.arraycopy(arrayOfChar, 0, arrayOfChar, i, i);
/*     */     }
/* 168 */     System.arraycopy(arrayOfChar, 0, arrayOfChar, i, paramInt - i);
/* 169 */     return new String(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String commonPrefix(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 180 */     Preconditions.checkNotNull(paramCharSequence1);
/* 181 */     Preconditions.checkNotNull(paramCharSequence2);
/*     */     
/* 183 */     int i = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
/* 184 */     byte b = 0;
/* 185 */     while (b < i && paramCharSequence1.charAt(b) == paramCharSequence2.charAt(b)) {
/* 186 */       b++;
/*     */     }
/* 188 */     if (validSurrogatePairAt(paramCharSequence1, b - 1) || validSurrogatePairAt(paramCharSequence2, b - 1)) {
/* 189 */       b--;
/*     */     }
/* 191 */     return paramCharSequence1.subSequence(0, b).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String commonSuffix(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 202 */     Preconditions.checkNotNull(paramCharSequence1);
/* 203 */     Preconditions.checkNotNull(paramCharSequence2);
/*     */     
/* 205 */     int i = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
/* 206 */     byte b = 0;
/* 207 */     while (b < i && paramCharSequence1.charAt(paramCharSequence1.length() - b - 1) == paramCharSequence2.charAt(paramCharSequence2.length() - b - 1)) {
/* 208 */       b++;
/*     */     }
/* 210 */     if (validSurrogatePairAt(paramCharSequence1, paramCharSequence1.length() - b - 1) || 
/* 211 */       validSurrogatePairAt(paramCharSequence2, paramCharSequence2.length() - b - 1)) {
/* 212 */       b--;
/*     */     }
/* 214 */     return paramCharSequence1.subSequence(paramCharSequence1.length() - b, paramCharSequence1.length()).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean validSurrogatePairAt(CharSequence paramCharSequence, int paramInt) {
/* 223 */     if (paramInt >= 0 && paramInt <= paramCharSequence
/* 224 */       .length() - 2 && 
/* 225 */       Character.isHighSurrogate(paramCharSequence.charAt(paramInt)) && 
/* 226 */       Character.isLowSurrogate(paramCharSequence.charAt(paramInt + 1))) return true;
/*     */     
/*     */     return false;
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
/*     */   public static String lenientFormat(String paramString, Object... paramVarArgs) {
/* 264 */     paramString = String.valueOf(paramString);
/*     */     
/* 266 */     if (paramVarArgs == null) {
/* 267 */       paramVarArgs = new Object[] { "(Object[])null" };
/*     */     } else {
/* 269 */       for (byte b1 = 0; b1 < paramVarArgs.length; b1++) {
/* 270 */         paramVarArgs[b1] = lenientToString(paramVarArgs[b1]);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 275 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() + 16 * paramVarArgs.length);
/* 276 */     int i = 0;
/* 277 */     byte b = 0; int j;
/* 278 */     while (b < paramVarArgs.length && (
/*     */       
/* 280 */       j = paramString.indexOf("%s", i)) != -1) {
/*     */ 
/*     */       
/* 283 */       stringBuilder.append(paramString, i, j);
/* 284 */       stringBuilder.append(paramVarArgs[b++]);
/* 285 */       i = j + 2;
/*     */     } 
/* 287 */     stringBuilder.append(paramString, i, paramString.length());
/*     */ 
/*     */     
/* 290 */     if (b < paramVarArgs.length) {
/* 291 */       stringBuilder.append(" [");
/* 292 */       stringBuilder.append(paramVarArgs[b++]);
/* 293 */       while (b < paramVarArgs.length) {
/* 294 */         stringBuilder.append(", ");
/* 295 */         stringBuilder.append(paramVarArgs[b++]);
/*     */       } 
/* 297 */       stringBuilder.append(']');
/*     */     } 
/*     */     
/* 300 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static String lenientToString(Object paramObject) {
/* 304 */     if (paramObject == null) {
/* 305 */       return "null";
/*     */     }
/*     */     try {
/* 308 */       return paramObject.toString();
/* 309 */     } catch (Exception exception) {
/*     */ 
/*     */       
/* 312 */       String str = paramObject.getClass().getName(); paramObject = Integer.toHexString(System.identityHashCode(paramObject)); paramObject = (new StringBuilder(1 + String.valueOf(str).length() + String.valueOf(paramObject).length())).append(str).append('@').append((String)paramObject).toString();
/*     */       
/* 314 */       String.valueOf(paramObject); Logger.getLogger("com.google.common.base.Strings")
/* 315 */         .log(Level.WARNING, (String.valueOf(paramObject).length() != 0) ? "Exception during lenientFormat for ".concat(String.valueOf(paramObject)) : new String("Exception during lenientFormat for "), exception);
/* 316 */       str = exception.getClass().getName(); return (new StringBuilder(9 + String.valueOf(paramObject).length() + String.valueOf(str).length())).append("<").append((String)paramObject).append(" threw ").append(str).append(">").toString();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Strings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */