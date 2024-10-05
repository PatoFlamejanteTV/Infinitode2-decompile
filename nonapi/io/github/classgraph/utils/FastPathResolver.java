/*     */ package nonapi.io.github.classgraph.utils;
/*     */ 
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FastPathResolver
/*     */ {
/*  44 */   private static final Pattern percentMatcher = Pattern.compile("([%][0-9a-fA-F][0-9a-fA-F])+");
/*     */ 
/*     */   
/*  47 */   private static final Pattern schemeTwoSlashMatcher = Pattern.compile("^[a-zA-Z+\\-.]+://");
/*     */ 
/*     */   
/*  50 */   private static final Pattern schemeOneSlashMatcher = Pattern.compile("^[a-zA-Z+\\-.]+:/");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void translateSeparator(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, StringBuilder paramStringBuilder) {
/*  75 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*     */       char c;
/*  77 */       if ((c = paramString.charAt(paramInt1)) == '\\' || c == '/') {
/*     */         
/*  79 */         if (paramInt1 < paramInt2 - 1 || !paramBoolean)
/*     */         {
/*     */           
/*  82 */           if ((c = (paramStringBuilder.length() == 0) ? Character.MIN_VALUE : paramStringBuilder.charAt(paramStringBuilder.length() - 1)) != '/') {
/*  83 */             paramStringBuilder.append('/');
/*     */           }
/*     */         }
/*     */       } else {
/*  87 */         paramStringBuilder.append(c);
/*     */       } 
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
/*     */   private static int hexCharToInt(char paramChar) {
/* 100 */     return (paramChar >= '0' && paramChar <= '9') ? (paramChar - 48) : ((paramChar >= 'a' && paramChar <= 'f') ? (paramChar - 97 + 10) : (paramChar - 65 + 10));
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
/*     */   private static void unescapePercentEncoding(String paramString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) {
/* 119 */     if (paramInt2 - paramInt1 == 3 && paramString.charAt(paramInt1 + 1) == '2' && paramString.charAt(paramInt1 + 2) == '0') {
/*     */       
/* 121 */       paramStringBuilder.append(' '); return;
/*     */     } 
/* 123 */     byte[] arrayOfByte = new byte[(paramInt2 - paramInt1) / 3]; byte b;
/* 124 */     for (paramInt1 = paramInt1, b = 0; paramInt1 < paramInt2; paramInt1 += 3, b++) {
/* 125 */       char c1 = paramString.charAt(paramInt1 + 1);
/* 126 */       char c2 = paramString.charAt(paramInt1 + 2);
/* 127 */       int i = hexCharToInt(c1);
/* 128 */       int j = hexCharToInt(c2);
/* 129 */       arrayOfByte[b] = (byte)(i << 4 | j);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 134 */     String str = (str = new String(arrayOfByte, StandardCharsets.UTF_8)).replace("/", "%2F").replace("\\", "%5C");
/* 135 */     paramStringBuilder.append(str);
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
/*     */   public static String normalizePath(String paramString, boolean paramBoolean) {
/*     */     boolean bool;
/* 151 */     if (!(bool = (paramString.indexOf('%') >= 0) ? true : false) && paramString.indexOf('\\') < 0 && !paramString.endsWith("/")) {
/* 152 */       return paramString;
/*     */     }
/* 154 */     int i = paramString.length();
/* 155 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 157 */     if (bool && paramBoolean) {
/*     */       int j;
/* 159 */       paramBoolean = false;
/* 160 */       Matcher matcher = percentMatcher.matcher(paramString);
/* 161 */       while (matcher.find()) {
/* 162 */         int k = matcher.start();
/* 163 */         int m = matcher.end();
/* 164 */         translateSeparator(paramString, paramBoolean, k, false, stringBuilder);
/*     */         
/* 166 */         unescapePercentEncoding(paramString, k, m, stringBuilder);
/* 167 */         j = m;
/*     */       } 
/* 169 */       translateSeparator(paramString, j, i, true, stringBuilder);
/*     */     } else {
/*     */       
/* 172 */       translateSeparator(paramString, 0, i, true, stringBuilder);
/* 173 */       return stringBuilder.toString();
/*     */     } 
/* 175 */     return stringBuilder.toString();
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
/*     */   public static String resolve(String paramString1, String paramString2) {
/*     */     boolean bool3;
/*     */     String str3;
/* 193 */     if (paramString2 == null || paramString2.isEmpty()) {
/* 194 */       return (paramString1 == null) ? "" : paramString1;
/*     */     }
/*     */     
/* 197 */     String str1 = "";
/* 198 */     boolean bool1 = false;
/* 199 */     boolean bool2 = false;
/* 200 */     int i = 0;
/*     */     
/*     */     do {
/* 203 */       bool3 = false;
/* 204 */       if (paramString2.regionMatches(true, i, "jar:", 0, 4)) {
/*     */         
/* 206 */         bool3 = true;
/* 207 */         i = 4;
/* 208 */         bool2 = true;
/* 209 */       } else if (paramString2.regionMatches(true, i, "http://", 0, 7)) {
/*     */         
/* 211 */         bool3 = true;
/* 212 */         i += 7;
/*     */         
/* 214 */         str1 = str1 + "http://";
/*     */ 
/*     */         
/* 217 */         bool1 = true;
/*     */       }
/* 219 */       else if (paramString2.regionMatches(true, i, "https://", 0, 8)) {
/*     */         
/* 221 */         bool3 = true;
/* 222 */         i += 8;
/* 223 */         str1 = str1 + "https://";
/* 224 */         bool1 = true;
/* 225 */       } else if (paramString2.regionMatches(true, i, "jrt:", 0, 5)) {
/*     */         
/* 227 */         bool3 = true;
/* 228 */         i += 4;
/* 229 */         str1 = str1 + "jrt:";
/* 230 */         bool1 = true;
/* 231 */       } else if (paramString2.regionMatches(true, i, "file:", 0, 5)) {
/*     */         
/* 233 */         bool3 = true;
/* 234 */         i += 5;
/* 235 */         bool2 = true;
/*     */       } else {
/*     */         
/* 238 */         String str = (i == 0) ? paramString2 : paramString2.substring(i);
/*     */         Matcher matcher;
/* 240 */         if ((matcher = schemeTwoSlashMatcher.matcher(str)).find()) {
/* 241 */           bool3 = true;
/* 242 */           str = matcher.group();
/* 243 */           i += str.length();
/* 244 */           str1 = str1 + str;
/*     */ 
/*     */           
/* 247 */           bool1 = true;
/*     */         } else {
/*     */           Matcher matcher1;
/* 250 */           if ((matcher1 = schemeOneSlashMatcher.matcher(str)).find()) {
/* 251 */             bool3 = true;
/* 252 */             String str4 = matcher1.group();
/* 253 */             i += str4.length();
/* 254 */             str1 = str1 + str4;
/* 255 */             boolean bool = true;
/*     */           } 
/*     */         } 
/*     */       } 
/* 259 */     } while (bool3);
/*     */ 
/*     */     
/* 262 */     if (VersionFinder.OS == VersionFinder.OperatingSystem.Windows) {
/* 263 */       if (paramString2.startsWith("//", i) || paramString2.startsWith("\\\\", i)) {
/*     */         
/* 265 */         i += 2;
/* 266 */         str1 = str1 + "//";
/* 267 */         bool1 = true;
/* 268 */       } else if (paramString2.length() - i > 2 && Character.isLetter(paramString2.charAt(i)) && paramString2
/* 269 */         .charAt(i + 1) == ':') {
/*     */         
/* 271 */         bool1 = true;
/* 272 */       } else if (paramString2.length() - i > 3 && (paramString2
/* 273 */         .charAt(i) == '/' || paramString2.charAt(i) == '\\') && 
/* 274 */         Character.isLetter(paramString2.charAt(i + 1)) && paramString2
/* 275 */         .charAt(i + 2) == ':') {
/*     */         
/* 277 */         bool1 = true;
/* 278 */         i++;
/*     */       } 
/*     */     }
/*     */     
/* 282 */     if (paramString2.length() - i > 1 && (paramString2
/* 283 */       .charAt(i) == '/' || paramString2.charAt(i) == '\\')) {
/* 284 */       bool1 = true;
/*     */     }
/*     */ 
/*     */     
/*     */     String str2;
/*     */     
/* 290 */     if (!(str2 = normalizePath((i == 0) ? paramString2 : paramString2.substring(i), bool2)).equals("/")) {
/*     */       
/* 292 */       if (str2.endsWith("/")) {
/* 293 */         str2 = str2.substring(0, str2.length() - 1);
/*     */       }
/* 295 */       if (str2.endsWith("!")) {
/* 296 */         str2 = str2.substring(0, str2.length() - 1);
/*     */       }
/* 298 */       if (str2.endsWith("/")) {
/* 299 */         str2 = str2.substring(0, str2.length() - 1);
/*     */       }
/* 301 */       if (str2.isEmpty()) {
/* 302 */         str2 = "/";
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 308 */     if (bool1 || paramString1 == null || paramString1.isEmpty()) {
/*     */ 
/*     */       
/* 311 */       str3 = FileUtils.sanitizeEntryPath(str2, false, true);
/*     */     }
/*     */     else {
/*     */       
/* 315 */       str3 = FileUtils.sanitizeEntryPath(paramString1 + (
/* 316 */           paramString1.endsWith("/") ? "" : "/") + str2, false, true);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 321 */     return str1.isEmpty() ? str3 : (str1 + str3);
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
/*     */   public static String resolve(String paramString) {
/* 333 */     return resolve(null, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\FastPathResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */