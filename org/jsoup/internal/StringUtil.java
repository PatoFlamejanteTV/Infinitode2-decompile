/*     */ package org.jsoup.internal;
/*     */ 
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Stack;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.regex.Pattern;
/*     */ import org.jsoup.helper.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StringUtil
/*     */ {
/*  20 */   static final String[] padding = new String[] { "", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    " };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String join(Collection<?> paramCollection, String paramString) {
/*  31 */     return join(paramCollection.iterator(), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String join(Iterator<?> paramIterator, String paramString) {
/*  41 */     if (!paramIterator.hasNext()) {
/*  42 */       return "";
/*     */     }
/*  44 */     String str = paramIterator.next().toString();
/*  45 */     if (!paramIterator.hasNext()) {
/*  46 */       return str;
/*     */     }
/*     */     StringJoiner stringJoiner;
/*  49 */     (stringJoiner = new StringJoiner(paramString)).add(str);
/*  50 */     while (paramIterator.hasNext()) {
/*  51 */       stringJoiner.add(paramIterator.next());
/*     */     }
/*  53 */     return stringJoiner.complete();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String join(String[] paramArrayOfString, String paramString) {
/*  63 */     return join(Arrays.asList((Object[])paramArrayOfString), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class StringJoiner
/*     */   {
/*  71 */     StringBuilder sb = StringUtil.borrowBuilder();
/*     */ 
/*     */     
/*     */     final String separator;
/*     */ 
/*     */     
/*     */     boolean first = true;
/*     */ 
/*     */ 
/*     */     
/*     */     public StringJoiner(String param1String) {
/*  82 */       this.separator = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StringJoiner add(Object param1Object) {
/*  89 */       Validate.notNull(this.sb);
/*  90 */       if (!this.first)
/*  91 */         this.sb.append(this.separator); 
/*  92 */       this.sb.append(param1Object);
/*  93 */       this.first = false;
/*  94 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StringJoiner append(Object param1Object) {
/* 101 */       Validate.notNull(this.sb);
/* 102 */       this.sb.append(param1Object);
/* 103 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String complete() {
/* 110 */       String str = StringUtil.releaseBuilder(this.sb);
/* 111 */       this.sb = null;
/* 112 */       return str;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String padding(int paramInt) {
/* 123 */     return padding(paramInt, 30);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String padding(int paramInt1, int paramInt2) {
/* 133 */     Validate.isTrue((paramInt1 >= 0), "width must be >= 0");
/* 134 */     Validate.isTrue((paramInt2 >= -1));
/* 135 */     if (paramInt2 != -1)
/* 136 */       paramInt1 = Math.min(paramInt1, paramInt2); 
/* 137 */     if (paramInt1 < padding.length)
/* 138 */       return padding[paramInt1]; 
/* 139 */     char[] arrayOfChar = new char[paramInt1];
/* 140 */     for (byte b = 0; b < paramInt1; b++)
/* 141 */       arrayOfChar[b] = ' '; 
/* 142 */     return String.valueOf(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isBlank(String paramString) {
/* 151 */     if (paramString == null || paramString.length() == 0) {
/* 152 */       return true;
/*     */     }
/* 154 */     int i = paramString.length();
/* 155 */     for (byte b = 0; b < i; b++) {
/* 156 */       if (!isWhitespace(paramString.codePointAt(b)))
/* 157 */         return false; 
/*     */     } 
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean startsWithNewline(String paramString) {
/* 168 */     if (paramString == null || paramString.length() == 0)
/* 169 */       return false; 
/* 170 */     return (paramString.charAt(0) == '\n');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isNumeric(String paramString) {
/* 179 */     if (paramString == null || paramString.length() == 0) {
/* 180 */       return false;
/*     */     }
/* 182 */     int i = paramString.length();
/* 183 */     for (byte b = 0; b < i; b++) {
/* 184 */       if (!Character.isDigit(paramString.codePointAt(b)))
/* 185 */         return false; 
/*     */     } 
/* 187 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isWhitespace(int paramInt) {
/* 197 */     return (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 12 || paramInt == 13);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isActuallyWhitespace(int paramInt) {
/* 206 */     return (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 12 || paramInt == 13 || paramInt == 160);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isInvisibleChar(int paramInt) {
/* 211 */     return (paramInt == 8203 || paramInt == 173);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String normaliseWhitespace(String paramString) {
/*     */     StringBuilder stringBuilder;
/* 223 */     appendNormalisedWhitespace(stringBuilder = borrowBuilder(), paramString, false);
/* 224 */     return releaseBuilder(stringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void appendNormalisedWhitespace(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean) {
/* 234 */     boolean bool1 = false;
/* 235 */     boolean bool2 = false;
/*     */     
/* 237 */     int i = paramString.length();
/*     */     int j;
/* 239 */     for (j = 0; j < i; j += Character.charCount(k)) {
/*     */       int k;
/* 241 */       if (isActuallyWhitespace(k = paramString.codePointAt(j))) {
/* 242 */         if ((!paramBoolean || bool2) && !bool1) {
/*     */           
/* 244 */           paramStringBuilder.append(' ');
/* 245 */           bool1 = true;
/*     */         } 
/* 247 */       } else if (!isInvisibleChar(k)) {
/* 248 */         paramStringBuilder.appendCodePoint(k);
/* 249 */         bool1 = false;
/* 250 */         bool2 = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean in(String paramString, String... paramVarArgs) {
/* 256 */     int i = paramVarArgs.length;
/* 257 */     for (byte b = 0; b < i; b++) {
/* 258 */       if (paramVarArgs[b].equals(paramString))
/* 259 */         return true; 
/*     */     } 
/* 261 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean inSorted(String paramString, String[] paramArrayOfString) {
/* 265 */     return (Arrays.binarySearch((Object[])paramArrayOfString, paramString) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAscii(String paramString) {
/* 274 */     Validate.notNull(paramString);
/* 275 */     for (byte b = 0; b < paramString.length(); b++) {
/*     */       char c;
/* 277 */       if ((c = paramString.charAt(b)) > '') {
/* 278 */         return false;
/*     */       }
/*     */     } 
/* 281 */     return true;
/*     */   }
/*     */   
/* 284 */   private static final Pattern extraDotSegmentsPattern = Pattern.compile("^/((\\.{1,2}/)+)");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static URL resolve(URL paramURL, String paramString) {
/* 295 */     if ((paramString = stripControlChars(paramString)).startsWith("?")) {
/* 296 */       paramString = paramURL.getPath() + paramString;
/*     */     }
/* 298 */     paramURL = new URL(paramURL, paramString);
/* 299 */     paramString = extraDotSegmentsPattern.matcher(paramURL.getFile()).replaceFirst("/");
/* 300 */     if (paramURL.getRef() != null) {
/* 301 */       paramString = paramString + "#" + paramURL.getRef();
/*     */     }
/* 303 */     return new URL(paramURL.getProtocol(), paramURL.getHost(), paramURL.getPort(), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String resolve(String paramString1, String paramString2) {
/* 314 */     paramString1 = stripControlChars(paramString1); paramString2 = stripControlChars(paramString2);
/*     */     try {
/*     */       URL uRL;
/*     */       try {
/* 318 */         uRL = new URL(paramString1);
/* 319 */       } catch (MalformedURLException malformedURLException) {
/*     */ 
/*     */         
/* 322 */         return (uRL = new URL(paramString2)).toExternalForm();
/*     */       } 
/* 324 */       return resolve(uRL, paramString2).toExternalForm();
/* 325 */     } catch (MalformedURLException malformedURLException) {
/*     */ 
/*     */       
/* 328 */       return validUriScheme.matcher(paramString2).find() ? paramString2 : "";
/*     */     } 
/*     */   }
/* 331 */   private static final Pattern validUriScheme = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+-.]*:");
/*     */   
/* 333 */   private static final Pattern controlChars = Pattern.compile("[\\x00-\\x1f]*");
/*     */   private static String stripControlChars(String paramString) {
/* 335 */     return controlChars.matcher(paramString).replaceAll("");
/*     */   }
/*     */   
/* 338 */   private static final ThreadLocal<Stack<StringBuilder>> threadLocalBuilders = ThreadLocal.withInitial(Stack::new);
/*     */ 
/*     */   
/*     */   private static final int MaxCachedBuilderSize = 8192;
/*     */ 
/*     */   
/*     */   private static final int MaxIdleBuilders = 8;
/*     */ 
/*     */   
/*     */   public static StringBuilder borrowBuilder() {
/*     */     Stack<?> stack;
/* 349 */     if ((stack = threadLocalBuilders.get()).empty())
/* 350 */       return new StringBuilder(8192); 
/* 351 */     return (StringBuilder)stack.pop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String releaseBuilder(StringBuilder paramStringBuilder) {
/* 361 */     Validate.notNull(paramStringBuilder);
/* 362 */     String str = paramStringBuilder.toString();
/*     */     
/* 364 */     if (paramStringBuilder.length() > 8192) {
/* 365 */       paramStringBuilder = new StringBuilder(8192);
/*     */     } else {
/* 367 */       paramStringBuilder.delete(0, paramStringBuilder.length());
/*     */     } 
/*     */     Stack<StringBuilder> stack;
/* 370 */     (stack = threadLocalBuilders.get()).push(paramStringBuilder);
/*     */     
/* 372 */     while (stack.size() > 8) {
/* 373 */       stack.pop();
/*     */     }
/* 375 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\internal\StringUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */