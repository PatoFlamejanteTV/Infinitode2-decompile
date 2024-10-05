/*     */ package nonapi.io.github.classgraph.utils;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JarUtils
/*     */ {
/*  50 */   public static final Pattern URL_SCHEME_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+[:].*");
/*     */ 
/*     */   
/*  53 */   private static final Pattern DASH_VERSION = Pattern.compile("-(\\d+(\\.|$))");
/*     */ 
/*     */   
/*  56 */   private static final Pattern NON_ALPHANUM = Pattern.compile("[^A-Za-z0-9]");
/*     */ 
/*     */   
/*  59 */   private static final Pattern REPEATING_DOTS = Pattern.compile("(\\.)(\\1)+");
/*     */ 
/*     */   
/*  62 */   private static final Pattern LEADING_DOTS = Pattern.compile("^\\.");
/*     */ 
/*     */   
/*  65 */   private static final Pattern TRAILING_DOTS = Pattern.compile("\\.$");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private static final String[] UNIX_NON_PATH_SEPARATORS = new String[] { "jar:", "file:", "http://", "https://", "\\:" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   private static final int[] UNIX_NON_PATH_SEPARATOR_COLON_POSITIONS = new int[(new String[5]).length]; static {
/*  86 */     for (byte b = 0; b < UNIX_NON_PATH_SEPARATORS.length; b++) {
/*  87 */       UNIX_NON_PATH_SEPARATOR_COLON_POSITIONS[b] = UNIX_NON_PATH_SEPARATORS[b].indexOf(':');
/*  88 */       if (UNIX_NON_PATH_SEPARATOR_COLON_POSITIONS[b] < 0) {
/*  89 */         throw new RuntimeException("Could not find ':' in \"" + UNIX_NON_PATH_SEPARATORS[b] + "\"");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String[] smartPathSplit(String paramString, ScanSpec paramScanSpec) {
/* 112 */     return smartPathSplit(paramString, File.pathSeparatorChar, paramScanSpec);
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
/*     */   public static String[] smartPathSplit(String paramString, char paramChar, ScanSpec paramScanSpec) {
/* 128 */     if (paramString == null || paramString.isEmpty()) {
/* 129 */       return new String[0];
/*     */     }
/* 131 */     if (paramChar != ':') {
/*     */       
/* 133 */       ArrayList<String> arrayList2 = new ArrayList(); String[] arrayOfString; int j; byte b1;
/* 134 */       for (j = (arrayOfString = paramString.split(String.valueOf(paramChar))).length, b1 = 0; b1 < j; b1++) {
/*     */         String str1; String str2;
/* 136 */         if (!(str2 = (str1 = arrayOfString[b1]).trim()).isEmpty()) {
/* 137 */           arrayList2.add(str2);
/*     */         }
/*     */       } 
/* 140 */       return arrayList2.<String>toArray(new String[0]);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 145 */     HashSet<Integer> hashSet = new HashSet();
/* 146 */     int i = -1; do {
/* 147 */       boolean bool = false;
/* 148 */       for (byte b1 = 0; b1 < UNIX_NON_PATH_SEPARATORS.length; b1++) {
/*     */         
/* 150 */         int j = i - UNIX_NON_PATH_SEPARATOR_COLON_POSITIONS[b1];
/* 151 */         if (paramString.regionMatches(true, j, UNIX_NON_PATH_SEPARATORS[b1], 0, UNIX_NON_PATH_SEPARATORS[b1]
/* 152 */             .length()) && (j == 0 || paramString
/* 153 */           .charAt(j - 1) == ':')) {
/*     */           
/* 155 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 159 */       if (!bool && paramScanSpec != null && paramScanSpec.allowedURLSchemes != null && 
/* 160 */         !paramScanSpec.allowedURLSchemes.isEmpty())
/*     */       {
/* 162 */         for (Iterator<String> iterator = paramScanSpec.allowedURLSchemes.iterator(); iterator.hasNext();) {
/*     */           
/* 164 */           if (!(str = iterator.next()).equals("http") && !str.equals("https") && !str.equals("jar") && 
/* 165 */             !str.equals("file")) {
/* 166 */             int j = str.length();
/* 167 */             int k = i - j;
/* 168 */             if (paramString.regionMatches(true, k, str, 0, j) && (k == 0 || paramString
/* 169 */               .charAt(k - 1) == ':')) {
/* 170 */               bool = true;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/* 176 */       if (bool)
/*     */         continue; 
/* 178 */       hashSet.add(Integer.valueOf(i));
/*     */ 
/*     */     
/*     */     }
/* 182 */     while ((i = paramString.indexOf(':', i + 1)) >= 0);
/*     */     
/* 184 */     hashSet.add(Integer.valueOf(paramString.length()));
/*     */ 
/*     */     
/*     */     ArrayList<Integer> arrayList;
/*     */     
/* 189 */     CollectionUtils.sortIfNotEmpty(arrayList = new ArrayList<>(hashSet));
/* 190 */     ArrayList<String> arrayList1 = new ArrayList();
/* 191 */     for (byte b = 1; b < arrayList.size(); b++) {
/* 192 */       int j = ((Integer)arrayList.get(b - 1)).intValue();
/* 193 */       int k = ((Integer)arrayList.get(b)).intValue();
/*     */ 
/*     */       
/*     */       String str;
/*     */       
/* 198 */       if (!(str = (str = paramString.substring(j + 1, k).trim()).replaceAll("\\\\:", ":")).isEmpty()) {
/* 199 */         arrayList1.add(str);
/*     */       }
/*     */     } 
/* 202 */     return arrayList1.<String>toArray(new String[0]);
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
/*     */   private static void appendPathElt(Object paramObject, StringBuilder paramStringBuilder) {
/* 217 */     if (paramStringBuilder.length() > 0) {
/* 218 */       paramStringBuilder.append(File.pathSeparatorChar);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     paramObject = (File.separatorChar == '\\') ? paramObject.toString() : paramObject.toString().replaceAll(File.pathSeparator, "\\" + File.pathSeparator);
/* 225 */     paramStringBuilder.append((String)paramObject);
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
/*     */   public static String pathElementsToPathStr(Object... paramVarArgs) {
/* 238 */     StringBuilder stringBuilder = new StringBuilder(); int i; byte b;
/* 239 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 240 */       Object object; appendPathElt(object = paramVarArgs[b], stringBuilder);
/*     */     } 
/* 242 */     return stringBuilder.toString();
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
/*     */   public static String pathElementsToPathStr(Iterable<?> paramIterable) {
/* 255 */     StringBuilder stringBuilder = new StringBuilder();
/* 256 */     for (Iterator<?> iterator = paramIterable.iterator(); iterator.hasNext();) {
/* 257 */       appendPathElt(object = iterator.next(), stringBuilder);
/*     */     }
/* 259 */     return stringBuilder.toString();
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
/*     */   public static String leafName(String paramString) {
/* 273 */     int i = ((i = paramString.indexOf('!')) >= 0) ? i : paramString.length();
/*     */     
/* 275 */     int j = 1 + ((File.separatorChar == '/') ? paramString.lastIndexOf('/', i) : Math.max(paramString.lastIndexOf('/', i), paramString.lastIndexOf(File.separatorChar, i)));
/*     */     
/*     */     int k;
/*     */     
/* 279 */     if ((k = paramString.indexOf("---")) >= 0) {
/* 280 */       k += 3;
/*     */     }
/*     */     
/* 283 */     j = Math.min(j = Math.max(j, k), i);
/* 284 */     return paramString.substring(j, i);
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
/*     */   public static String classfilePathToClassName(String paramString) {
/* 297 */     if (!paramString.endsWith(".class")) {
/* 298 */       throw new IllegalArgumentException("Classfile path does not end with \".class\": " + paramString);
/*     */     }
/* 300 */     return paramString.substring(0, paramString.length() - 6).replace('/', '.');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String classNameToClassfilePath(String paramString) {
/* 311 */     return paramString.replace('.', '/') + ".class";
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
/*     */   public static String derivedAutomaticModuleName(String paramString) {
/* 328 */     int j = paramString.length();
/*     */     int k;
/* 330 */     if ((k = paramString.lastIndexOf('!')) > 0 && paramString
/*     */       
/* 332 */       .lastIndexOf('.') <= Math.max(k, paramString.lastIndexOf('/')))
/*     */     {
/* 334 */       j = k;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 339 */     k = Math.max(k = (j == 0) ? -1 : paramString.lastIndexOf("!", j - 1), paramString.lastIndexOf('/', j - 1)) + 1;
/*     */     
/*     */     int m;
/* 342 */     if ((m = paramString.lastIndexOf('.', j - 1)) > k)
/*     */     {
/* 344 */       j = m;
/*     */     }
/*     */ 
/*     */     
/* 348 */     paramString = paramString.substring(k, j);
/*     */     
/*     */     Matcher matcher;
/*     */     
/* 352 */     if ((matcher = DASH_VERSION.matcher(paramString)).find()) {
/* 353 */       paramString = paramString.substring(0, matcher.start());
/*     */     }
/*     */ 
/*     */     
/* 357 */     paramString = NON_ALPHANUM.matcher(paramString).replaceAll(".");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     if ((paramString = REPEATING_DOTS.matcher(paramString).replaceAll(".")).length() > 0 && paramString.charAt(0) == '.') {
/* 364 */       paramString = LEADING_DOTS.matcher(paramString).replaceAll("");
/*     */     }
/*     */     
/*     */     int i;
/*     */     
/* 369 */     if ((i = paramString.length()) > 0 && paramString.charAt(i - 1) == '.') {
/* 370 */       paramString = TRAILING_DOTS.matcher(paramString).replaceAll("");
/*     */     }
/* 372 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\JarUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */