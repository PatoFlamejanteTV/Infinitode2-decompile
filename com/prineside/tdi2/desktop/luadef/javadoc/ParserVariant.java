/*     */ package com.prineside.tdi2.desktop.luadef.javadoc;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.BooleanArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.desktop.luadef.JavadocHandler;
/*     */ import com.prineside.tdi2.desktop.luadef.LuaDefUtils;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ public abstract class ParserVariant
/*     */ {
/*  24 */   private static final TLog a = TLog.forClass(ParserVariant.class);
/*     */   public static boolean verbose = false;
/*     */   public static boolean verboseGenerics = false;
/*     */   public static boolean verboseParamMatch = false;
/*     */   
/*     */   public abstract int getScore(Document paramDocument);
/*     */   
/*     */   public String getName() {
/*  32 */     return getClass().getSimpleName();
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public abstract String getClassDescription(Document paramDocument);
/*     */ 
/*     */   
/*     */   public abstract Array<JavadocHandler.ConstructorJD> getConstructors(Document paramDocument, Class<?> paramClass);
/*     */ 
/*     */   
/*     */   public abstract Array<JavadocHandler.MethodJD> getMethods(Document paramDocument, Class<?> paramClass);
/*     */   
/*     */   public static String sanitizeHtmlString(String paramString) {
/*  46 */     return paramString.replaceAll("\\n", " ").replaceAll(" ", " ").replaceAll("\\s+", " ").trim();
/*     */   }
/*     */   public abstract Map<String, String> getClassGenerics(Document paramDocument, Class<?> paramClass);
/*     */   
/*     */   @Null
/*     */   public abstract String getClassGenericsString(Document paramDocument);
/*     */   
/*     */   public abstract Array<JavadocHandler.FieldJD> getFields(Document paramDocument, Class<?> paramClass);
/*     */   
/*     */   public static Map<String, String> parseGenerics(String paramString, Class<?> paramClass) {
/*  56 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */     
/*  59 */     if ((paramString = sanitizeHtmlString(paramString)).contains("<")) {
/*     */       
/*  61 */       if (verboseGenerics) a.i("//GEN// " + paramString, new Object[0]); 
/*  62 */       byte b1 = 0;
/*  63 */       StringBuilder stringBuilder = new StringBuilder();
/*  64 */       Array<String> array = new Array();
/*  65 */       for (byte b2 = 0; b2 < paramString.length(); b2++) {
/*     */         char c;
/*  67 */         if ((c = paramString.charAt(b2)) == '<') {
/*  68 */           b1++;
/*  69 */         } else if (c == '>') {
/*  70 */           if (b1 == 0) {
/*  71 */             a.w("incorrect generic declaration in page title \"" + paramString + "\" of " + paramClass, new Object[0]);
/*  72 */             return (Map)hashMap;
/*     */           } 
/*  74 */           if (b1 == 1 && 
/*  75 */             stringBuilder.length != 0) {
/*  76 */             array.add(stringBuilder.toString());
/*  77 */             stringBuilder.setLength(0);
/*     */           } 
/*     */           
/*  80 */           b1--;
/*  81 */         } else if (c == ',') {
/*  82 */           if (b1 == 1 && 
/*  83 */             stringBuilder.length != 0) {
/*  84 */             array.add(stringBuilder.toString());
/*  85 */             stringBuilder.setLength(0);
/*     */           }
/*     */         
/*     */         }
/*  89 */         else if (b1 == 1) {
/*  90 */           stringBuilder.append(c);
/*     */         } 
/*     */       } 
/*     */       
/*  94 */       if (verboseGenerics) a.i("parsed generics: " + array.toString("|"), new Object[0]); 
/*  95 */       splitParsedGenericsAndPutIntoMap(array, (Map)hashMap, paramClass);
/*     */     } 
/*     */     
/*  98 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public static String parseGenericsString(String paramString) {
/* 103 */     if ((paramString = sanitizeHtmlString(paramString)).contains("<") && paramString.contains(">")) {
/* 104 */       return paramString.substring(paramString.indexOf("<"), paramString.lastIndexOf(">") + 1);
/*     */     }
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void splitParsedGenericsAndPutIntoMap(Array<String> paramArray, Map<String, String> paramMap, Class<?> paramClass) {
/* 111 */     for (Array.ArrayIterator<String> arrayIterator = paramArray.iterator(); arrayIterator.hasNext(); ) {
/*     */       String str;
/* 113 */       if ((str = (str = arrayIterator.next()).trim()).contains(" extends ")) {
/*     */         String[] arrayOfString;
/* 115 */         if ((arrayOfString = str.split(" extends ")).length == 2) {
/* 116 */           if (verboseGenerics) a.i("- add generic " + Arrays.toString((Object[])arrayOfString), new Object[0]); 
/* 117 */           paramMap.put(arrayOfString[0].trim(), arrayOfString[1].trim()); continue;
/*     */         } 
/* 119 */         a.w("- skip generic " + str + " - can't split, in " + paramClass, new Object[0]);
/*     */         continue;
/*     */       } 
/* 122 */       if (str.length() == 1) {
/* 123 */         paramMap.put(str, "Object");
/* 124 */         paramMap.put(str, "java.lang.Object");
/* 125 */         if (verboseGenerics) a.i("- add generic " + str + " - just an Object", new Object[0]);  continue;
/*     */       } 
/* 127 */       a.w("- skip generic " + str + " - not 1 char long, in " + paramClass, new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Null
/*     */   public static JavadocHandler.MethodJD parseMethodSignature(String paramString1, String paramString2, Class<?> paramClass, Map<String, String> paramMap) {
/* 134 */     paramString2 = sanitizeHtmlString(paramString2);
/*     */     
/* 136 */     if (verbose) a.i("parseMethodSignature " + paramString1 + " | " + paramString2 + " | " + paramClass, new Object[0]);
/*     */ 
/*     */     
/* 139 */     if (paramString2.startsWith("@Deprecated")) {
/* 140 */       if (verbose) a.i("- skip - deprecated", new Object[0]); 
/* 141 */       return null;
/*     */     } 
/* 143 */     if (paramString2.startsWith("private")) {
/* 144 */       if (verbose) a.i("- skip - private", new Object[0]); 
/* 145 */       return null;
/*     */     } 
/* 147 */     if (paramString2.startsWith("protected")) {
/* 148 */       if (verbose) a.i("- skip - protected", new Object[0]); 
/* 149 */       return null;
/*     */     } 
/*     */     
/*     */     Array array1;
/* 153 */     if ((array1 = LuaDefUtils.gatherMethodsCached(paramClass)).size == 0) {
/* 154 */       if (verbose) a.i("- skip - no methods in this class are open to Lua", new Object[0]); 
/* 155 */       return null;
/*     */     } 
/*     */     
/* 158 */     Array array2 = new Array();
/* 159 */     for (byte b1 = 0; b1 < array1.size; b1++) {
/*     */       Method method;
/* 161 */       if ((method = ((Method[])array1.items)[b1]).getName().equals(paramString1)) {
/* 162 */         array2.add(method);
/*     */       }
/*     */     } 
/* 165 */     if (array2.size == 0) {
/* 166 */       if (verbose) a.i("- skip - no methods named '" + paramString1 + "' are open to Lua", new Object[0]); 
/* 167 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     String str = paramString2.split("\\(")[0];
/* 175 */     BooleanArray booleanArray = new BooleanArray();
/* 176 */     Array<String> array = new Array();
/* 177 */     StringBuilder stringBuilder1 = new StringBuilder();
/* 178 */     for (byte b2 = 0; b2 < str.length(); b2++) {
/*     */       boolean bool; boolean bool1; byte b; char c;
/* 180 */       switch (c = str.charAt(b2)) {
/*     */         case '<':
/* 182 */           bool = (b2 == 0 || str.charAt(b2 - 1) == ' ');
/* 183 */           booleanArray.add(bool);
/*     */ 
/*     */           
/* 186 */           if (stringBuilder1.length != 0) {
/*     */             
/* 188 */             array.add(stringBuilder1.toString());
/* 189 */             stringBuilder1.setLength(0);
/*     */           } 
/*     */           break;
/*     */         
/*     */         case '>':
/* 194 */           bool = booleanArray.pop();
/*     */           
/* 196 */           if (stringBuilder1.length != 0) {
/*     */             
/* 198 */             array.add(stringBuilder1.toString());
/* 199 */             stringBuilder1.setLength(0);
/*     */           } 
/* 201 */           bool1 = false;
/* 202 */           for (b = 0; b < booleanArray.size; b++) {
/* 203 */             if (booleanArray.items[b]) {
/* 204 */               bool1 = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 208 */           if (bool && !bool1) {
/*     */             break;
/*     */           }
/*     */           break;
/*     */ 
/*     */         
/*     */         default:
/* 215 */           if (booleanArray.size != 0 && booleanArray.peek()) {
/*     */ 
/*     */             
/* 218 */             if (c == ',') {
/* 219 */               if (stringBuilder1.length != 0) {
/* 220 */                 array.add(stringBuilder1.toString());
/* 221 */                 stringBuilder1.setLength(0);
/*     */               }  break;
/*     */             } 
/* 224 */             stringBuilder1.append(c);
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 230 */     HashMap<String, String> hashMap = new HashMap<>(paramMap);
/* 231 */     if (array.size != 0) {
/* 232 */       if (verbose) a.i("found " + array.size + " method generics:", new Object[0]); 
/* 233 */       splitParsedGenericsAndPutIntoMap(array, hashMap, paramClass);
/*     */     } 
/*     */     
/* 236 */     JavadocHandler.MethodJD methodJD = new JavadocHandler.MethodJD();
/* 237 */     Array<ObjectPair<String, String>> array3 = parseMethodParams(paramString2);
/*     */     
/* 239 */     StringBuilder stringBuilder2 = new StringBuilder();
/* 240 */     for (Array.ArrayIterator<ObjectPair> arrayIterator1 = array3.iterator(); arrayIterator1.hasNext(); ) { ObjectPair objectPair = arrayIterator1.next();
/* 241 */       if (stringBuilder2.length != 0) {
/* 242 */         stringBuilder2.append(",");
/*     */       }
/* 244 */       stringBuilder2.append((String)objectPair.first);
/*     */       
/*     */       JavadocHandler.ParamJD paramJD;
/* 247 */       (paramJD = new JavadocHandler.ParamJD()).name = (String)objectPair.second;
/* 248 */       methodJD.params.add(paramJD); }
/*     */ 
/*     */     
/* 251 */     if (verbose) a.i("\033[35m- searching for: \"" + stringBuilder2 + "\"\033[0m" + " in a list of " + array2.size + " methods", new Object[0]);
/*     */ 
/*     */     
/* 254 */     Array array4 = new Array(); Array.ArrayIterator<Method> arrayIterator;
/* 255 */     for (arrayIterator = array2.iterator(); arrayIterator.hasNext(); ) {
/*     */       Method method; Class[] arrayOfClass;
/* 257 */       if ((arrayOfClass = (method = arrayIterator.next()).getParameterTypes()).length != array3.size) {
/* 258 */         if (verbose) a.i("- skip \033[34m" + method + "\033[0m - parameter count mismatch (" + arrayOfClass.length + ", " + array3.size + ")", new Object[0]);
/*     */         
/*     */         continue;
/*     */       } 
/* 262 */       boolean bool = true;
/* 263 */       for (byte b = 0; b < arrayOfClass.length; b++) {
/* 264 */         Class<?> clazz = arrayOfClass[b];
/* 265 */         ObjectPair objectPair = (ObjectPair)array3.get(b);
/* 266 */         if (!a(clazz, (String)objectPair.first, hashMap)) {
/* 267 */           if (verbose) a.i("- skip \033[34m" + method + "\033[0m - parameter " + (b + 1) + " mismatch (\033[33m" + clazz.getSimpleName() + "\033[0m, " + "\033[36m" + (String)objectPair.first + "\033[0m)", new Object[0]); 
/* 268 */           bool = false;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 273 */       if (bool) {
/* 274 */         if (verbose) a.i("\033[32m- found exact match: " + method + " | " + stringBuilder2 + "\033[0m", new Object[0]); 
/* 275 */         array4.add(method);
/*     */       } 
/*     */     } 
/*     */     
/* 279 */     if (array4.size == 0) {
/* 280 */       a.w("- none of the methods match, sig: \"" + paramString2 + "\" in " + paramClass, new Object[0]);
/* 281 */       return null;
/*     */     } 
/* 283 */     if (array4.size != 1) {
/* 284 */       a.w("- multiple (" + array4.size + ") methods match, sig: \"" + paramString2 + "\" in " + paramClass + ":", new Object[0]);
/* 285 */       for (arrayIterator = array4.iterator(); arrayIterator.hasNext(); ) { Method method = arrayIterator.next();
/* 286 */         a.w("- " + method, new Object[0]); }
/*     */     
/*     */     } 
/*     */     
/* 290 */     methodJD.method = (Method)array4.first();
/* 291 */     return methodJD;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public static JavadocHandler.ConstructorJD parseConstructorSignature(String paramString, Class<?> paramClass, Map<String, String> paramMap) {
/* 299 */     paramString = sanitizeHtmlString(paramString);
/*     */     
/* 301 */     if (verbose) a.i("parseConstructorSignature " + paramString + " | " + paramClass, new Object[0]);
/*     */     
/* 303 */     if (paramString.startsWith("@Deprecated")) {
/* 304 */       if (verbose) a.i("- skip - deprecated", new Object[0]); 
/* 305 */       return null;
/*     */     } 
/* 307 */     if (paramString.startsWith("private")) {
/* 308 */       if (verbose) a.i("- skip - private", new Object[0]); 
/* 309 */       return null;
/*     */     } 
/* 311 */     if (paramString.startsWith("protected")) {
/* 312 */       if (verbose) a.i("- skip - protected", new Object[0]); 
/* 313 */       return null;
/*     */     } 
/*     */     
/*     */     Array array1;
/* 317 */     if ((array1 = LuaDefUtils.gatherConstructorsCached(paramClass)).size == 0) {
/* 318 */       if (verbose) a.i("- skip - no constructors in this class are open to Lua", new Object[0]); 
/* 319 */       return null;
/*     */     } 
/*     */     
/* 322 */     JavadocHandler.ConstructorJD constructorJD = new JavadocHandler.ConstructorJD();
/* 323 */     Array<ObjectPair<String, String>> array = parseMethodParams(paramString);
/*     */     
/* 325 */     StringBuilder stringBuilder = new StringBuilder();
/* 326 */     for (Array.ArrayIterator<ObjectPair> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { ObjectPair objectPair = arrayIterator.next();
/* 327 */       if (stringBuilder.length != 0) {
/* 328 */         stringBuilder.append(",");
/*     */       }
/* 330 */       stringBuilder.append((String)objectPair.first);
/*     */       
/*     */       JavadocHandler.ParamJD paramJD;
/* 333 */       (paramJD = new JavadocHandler.ParamJD()).name = (String)objectPair.second;
/* 334 */       constructorJD.params.add(paramJD); }
/*     */ 
/*     */     
/* 337 */     if (verbose) a.i("\033[35m- searching for: \"" + stringBuilder + "\"\033[0m" + " in a list of " + array1.size + " constructors", new Object[0]);
/*     */ 
/*     */     
/* 340 */     Array array2 = new Array();
/* 341 */     for (byte b = 0; b < array1.size; b++) {
/*     */       Constructor<?> constructor;
/*     */       Class[] arrayOfClass;
/* 344 */       if ((arrayOfClass = (constructor = ((Constructor[])array1.items)[b]).getParameterTypes()).length != array.size) {
/* 345 */         if (verbose) a.i("- skip \033[34m" + constructor + "\033[0m - parameter count mismatch (" + arrayOfClass.length + ", " + array.size + ")", new Object[0]);
/*     */       
/*     */       } else {
/*     */         
/* 349 */         boolean bool = true;
/* 350 */         for (byte b1 = 0; b1 < arrayOfClass.length; b1++) {
/* 351 */           Class<?> clazz = arrayOfClass[b1];
/* 352 */           ObjectPair objectPair = (ObjectPair)array.get(b1);
/* 353 */           if (!a(clazz, (String)objectPair.first, paramMap)) {
/* 354 */             if (verbose) a.i("- skip \033[34m" + constructor + "\033[0m - parameter " + (b1 + 1) + " mismatch (\033[33m" + clazz.getSimpleName() + "\033[0m, " + "\033[36m" + (String)objectPair.first + "\033[0m", new Object[0]); 
/* 355 */             bool = false;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 360 */         if (bool) {
/* 361 */           if (verbose) a.i("\033[32m- found exact match: " + constructor + " | " + stringBuilder + "\033[0m", new Object[0]); 
/* 362 */           array2.add(constructor);
/*     */         } 
/*     */       } 
/*     */     } 
/* 366 */     if (array2.size == 0) {
/* 367 */       a.w("- none of the constructors match, sig: \"" + paramString + "\" in " + paramClass, new Object[0]);
/* 368 */       return null;
/*     */     } 
/* 370 */     if (array2.size != 1) {
/* 371 */       a.w("- multiple (" + array2.size + ") constructors match, sig: \"" + paramString + "\" in " + paramClass + ":", new Object[0]);
/* 372 */       for (Array.ArrayIterator<Constructor> arrayIterator1 = array2.iterator(); arrayIterator1.hasNext(); ) { Constructor constructor = arrayIterator1.next();
/* 373 */         a.w("- " + constructor, new Object[0]); }
/*     */     
/*     */     } 
/*     */     
/* 377 */     constructorJD.ctor = (Constructor)array2.first();
/* 378 */     return constructorJD;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(Class<?> paramClass, String paramString, Map<String, String> paramMap) {
/* 383 */     if (verboseParamMatch) a.i("\033[30;1m  paramMatch " + paramClass.getSimpleName() + " <=> " + paramString + "\033[0m", new Object[0]);
/*     */ 
/*     */     
/* 386 */     if (paramString.endsWith("...")) {
/* 387 */       if (verboseParamMatch) a.i("  - turn ... into array and call recursively", new Object[0]); 
/* 388 */       if (a(paramClass, paramString.substring(0, paramString.length() - 3) + "[]", paramMap)) {
/* 389 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*     */     Array array;
/*     */     
/* 395 */     for (Array.ArrayIterator<String> arrayIterator = (array = new Array(paramMap.keySet().toArray((Object[])new String[0]))).iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 396 */       if (paramString.equals(str) || paramString.equals(str + "[]") || paramString.equals(str + "[][]") || paramString.equals(str + "[][][]")) {
/* 397 */         if (verboseParamMatch) a.i("  - turn generic '" + str + "' into class name and call recursively", new Object[0]);
/*     */         
/* 399 */         str = paramString.replace(str, paramMap.get(str));
/* 400 */         if (a(paramClass, str, paramMap)) {
/* 401 */           return true;
/*     */         }
/*     */       }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 411 */     if (verboseParamMatch) a.i("\033[30;1m    ...check " + paramClass.getSimpleName() + " <=> " + paramString + "\033[0m", new Object[0]); 
/* 412 */     if (paramClass.getSimpleName().equals(paramString)) {
/* 413 */       return true;
/*     */     }
/* 415 */     if (verboseParamMatch) a.i("\033[30;1m    ...check " + paramClass.getName() + " <=> " + paramString + "\033[0m", new Object[0]); 
/* 416 */     if (paramClass.getName().equals(paramString) || paramClass.getName().endsWith("." + paramString)) {
/* 417 */       return true;
/*     */     }
/* 419 */     if (verboseParamMatch) a.i("\033[30;1m    ...check " + paramClass.getCanonicalName() + " <=> " + paramString + "\033[0m", new Object[0]); 
/* 420 */     if (paramClass.getCanonicalName().equals(paramString) || paramClass.getCanonicalName().endsWith("." + paramString)) {
/* 421 */       return true;
/*     */     }
/*     */     
/*     */     Class<?> clazz;
/*     */     
/* 426 */     if ((clazz = paramClass.getEnclosingClass()) != null) {
/*     */ 
/*     */       
/* 429 */       String str = clazz.getSimpleName() + "." + paramClass.getSimpleName();
/* 430 */       if (verboseParamMatch) a.i("\033[30;1m    ...check " + str + " <=> " + paramString + "\033[0m", new Object[0]); 
/* 431 */       if (str.equals(paramString)) {
/* 432 */         return true;
/*     */       }
/*     */       
/* 435 */       str = clazz.getName() + "." + paramClass.getSimpleName();
/* 436 */       if (verboseParamMatch) a.i("\033[30;1m    ...check " + str + " <=> " + paramString + "\033[0m", new Object[0]); 
/* 437 */       if (str.equals(paramString) || str.endsWith("." + paramString)) {
/* 438 */         return true;
/*     */       }
/*     */       
/* 441 */       str = clazz.getCanonicalName() + "." + paramClass.getSimpleName();
/* 442 */       if (verboseParamMatch) a.i("\033[30;1m    ...check " + str + " <=> " + paramString + "\033[0m", new Object[0]); 
/* 443 */       if (str.equals(paramString) || str.endsWith("." + paramString)) {
/* 444 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 448 */     if (verboseParamMatch) a.i("\033[30;1m    no match\033[0m", new Object[0]); 
/* 449 */     return false;
/*     */   }
/*     */   
/*     */   public static Array<ObjectPair<String, String>> parseMethodParams(String paramString) {
/* 453 */     paramString = sanitizeHtmlString(paramString);
/*     */     
/* 455 */     boolean bool = false;
/* 456 */     byte b1 = 0;
/* 457 */     StringBuilder stringBuilder = new StringBuilder();
/* 458 */     Array array = new Array();
/* 459 */     for (byte b2 = 0; b2 < paramString.length(); b2++) {
/*     */       char c;
/* 461 */       if ((c = paramString.charAt(b2)) == '(') {
/* 462 */         if (bool) {
/* 463 */           throw new IllegalArgumentException("invalid sig, two (: \"" + paramString + "\"");
/*     */         }
/* 465 */         bool = true;
/* 466 */       } else if (c == ')') {
/* 467 */         if (!bool) {
/* 468 */           throw new IllegalArgumentException("invalid sig, ) closes nothing: \"" + paramString + "\"");
/*     */         }
/* 470 */         bool = false;
/* 471 */         if (stringBuilder.length != 0) {
/*     */           String str;
/* 473 */           if ((str = stringBuilder.toString().trim()).length() != 0) {
/* 474 */             array.add(str);
/*     */           }
/* 476 */           stringBuilder.setLength(0);
/*     */         } 
/* 478 */       } else if (c == '<') {
/* 479 */         b1++;
/* 480 */       } else if (c == '>') {
/* 481 */         if (b1 == 0) {
/* 482 */           throw new IllegalArgumentException("invalid sig, > closes no <: \"" + paramString + "\"");
/*     */         }
/* 484 */         b1--;
/* 485 */       } else if (c == ',') {
/* 486 */         if (b1 == 0 && 
/* 487 */           stringBuilder.length != 0) {
/*     */           String str;
/* 489 */           if ((str = stringBuilder.toString().trim()).length() != 0) {
/* 490 */             array.add(str);
/*     */           }
/* 492 */           stringBuilder.setLength(0);
/*     */         }
/*     */       
/*     */       }
/* 496 */       else if (b1 == 0 && 
/* 497 */         bool) {
/* 498 */         stringBuilder.append(c);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 504 */     Array<ObjectPair<String, String>> array1 = new Array();
/* 505 */     for (Array.ArrayIterator<String> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) {
/* 506 */       String str; if ((str = arrayIterator.next()).length() == 0) {
/* 507 */         array1.add(new ObjectPair("", "")); continue;
/*     */       } 
/*     */       String[] arrayOfString;
/* 510 */       if ((arrayOfString = str.split("\\s| ")).length < 2) {
/* 511 */         throw new IllegalArgumentException("invalid param sig, single, param sig: \"" + str + "\", full sig: \"" + paramString + "\"");
/*     */       }
/* 513 */       Array array2 = new Array(); int i; byte b;
/* 514 */       for (i = (arrayOfString = arrayOfString).length, b = 0; b < i; b++) {
/* 515 */         String str1; if (!(str1 = arrayOfString[b]).startsWith("@"))
/*     */         {
/* 517 */           array2.add(str1);
/*     */         }
/*     */       } 
/* 520 */       if (array2.size != 2) {
/* 521 */         throw new IllegalArgumentException("invalid param sig, " + array2.size + " parts, param sig: \"" + str + "\", full sig: \"" + paramString + "\"");
/*     */       }
/* 523 */       array1.add(new ObjectPair(array2.get(0), array2.get(1)));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 528 */     return array1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void parseConstructorParamDD(Element paramElement, JavadocHandler.ConstructorJD paramConstructorJD) {
/*     */     Element element;
/* 534 */     if ((element = paramElement.select("code").first()) != null) {
/* 535 */       String str = element.text().trim();
/*     */ 
/*     */       
/* 538 */       JavadocHandler.ParamJD paramJD = null; byte b;
/* 539 */       for (b = 0; b < paramConstructorJD.params.size; b++) {
/*     */         JavadocHandler.ParamJD paramJD1;
/* 541 */         if ((paramJD1 = (JavadocHandler.ParamJD)paramConstructorJD.params.get(b)).name.equals(str)) {
/*     */           
/* 543 */           paramJD = paramJD1;
/*     */           break;
/*     */         } 
/*     */       } 
/* 547 */       if (paramJD == null) {
/* 548 */         a.w("documented ctor param \"" + str + "\" not found in a list of " + paramConstructorJD.ctor + ":", new Object[0]);
/* 549 */         for (b = 0; b < paramConstructorJD.params.size; b++) {
/* 550 */           JavadocHandler.ParamJD paramJD1 = (JavadocHandler.ParamJD)paramConstructorJD.params.get(b);
/* 551 */           a.w("- " + paramJD1.name, new Object[0]);
/*     */         } 
/*     */       } else {
/*     */         String str1;
/*     */         
/* 556 */         if ((str1 = sanitizeHtmlString(paramElement.text().trim())).startsWith(str + " -")) {
/* 557 */           str1 = str1.substring(str.length() + 2);
/*     */         } else {
/* 559 */           a.w("can't remove ctor param name suffix from its description: \"" + str1 + "\" in " + paramConstructorJD.ctor, new Object[0]);
/*     */         } 
/*     */         
/* 562 */         if (str1.startsWith("-")) {
/* 563 */           str1 = str1.substring(1).trim();
/*     */         }
/* 565 */         paramJD.description = sanitizeHtmlString(str1);
/* 566 */         if (verbose) a.i("/+\\ add ctor param descr", new Object[0]); 
/*     */         return;
/*     */       } 
/*     */     } else {
/* 570 */       a.w("code block with parameter name not found in \"" + paramElement + "\" of " + paramConstructorJD.ctor, new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void parseMethodParamDD(Element paramElement, JavadocHandler.MethodJD paramMethodJD) {
/*     */     Element element;
/* 577 */     if ((element = paramElement.select("code").first()) != null) {
/* 578 */       String str = element.text().trim();
/*     */ 
/*     */       
/* 581 */       JavadocHandler.ParamJD paramJD = null; byte b;
/* 582 */       for (b = 0; b < paramMethodJD.params.size; b++) {
/*     */         JavadocHandler.ParamJD paramJD1;
/* 584 */         if ((paramJD1 = (JavadocHandler.ParamJD)paramMethodJD.params.get(b)).name.equals(str)) {
/*     */           
/* 586 */           paramJD = paramJD1;
/*     */           break;
/*     */         } 
/*     */       } 
/* 590 */       if (paramJD == null) {
/* 591 */         a.w("documented method param \"" + str + "\" not found in a list of " + paramMethodJD.method + ":", new Object[0]);
/* 592 */         for (b = 0; b < paramMethodJD.params.size; b++) {
/* 593 */           JavadocHandler.ParamJD paramJD1 = (JavadocHandler.ParamJD)paramMethodJD.params.get(b);
/* 594 */           a.w("- " + paramJD1.name, new Object[0]);
/*     */         } 
/*     */       } else {
/*     */         String str1;
/*     */         
/* 599 */         if ((str1 = sanitizeHtmlString(paramElement.text().trim())).startsWith(str + " -")) {
/* 600 */           str1 = str1.substring(str.length() + 2);
/*     */         } else {
/* 602 */           a.w("can't remove method param name suffix from its description: \"" + str1 + "\" in " + paramMethodJD.method, new Object[0]);
/*     */         } 
/*     */         
/* 605 */         if (str1.startsWith("-")) {
/* 606 */           str1 = str1.substring(1).trim();
/*     */         }
/* 608 */         paramJD.description = sanitizeHtmlString(str1);
/* 609 */         if (verbose) a.i("/+\\ add method param descr", new Object[0]); 
/*     */         return;
/*     */       } 
/*     */     } else {
/* 613 */       a.w("code block with parameter name not found in \"" + paramElement + "\" of " + paramMethodJD.method, new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JavadocHandler.MethodJD getMethodOldImpl(Element paramElement, Map<String, String> paramMap, Class<?> paramClass) {
/*     */     Iterator<Element> iterator;
/*     */     Element element;
/* 623 */     if ((element = (paramElement = paramElement).select("pre").first()) != null) {
/* 624 */       String str1 = element.text();
/* 625 */       String str2 = sanitizeHtmlString(paramElement.select("h4").first().text());
/*     */       try {
/*     */         JavadocHandler.MethodJD methodJD;
/* 628 */         if ((methodJD = parseMethodSignature(str2, str1, paramClass, paramMap)) != null) {
/*     */           Elements elements;
/*     */           
/* 631 */           for (Iterator<Element> iterator1 = (elements = paramElement.select(".block")).iterator(); iterator1.hasNext();) {
/*     */             
/* 633 */             if (!(str = sanitizeHtmlString((element2 = iterator1.next()).text())).contains("Description copied from")) {
/* 634 */               methodJD.description = JavadocHandler.formatDocumentation(element2.outerHtml(), 4);
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */           
/*     */           Element element1;
/*     */           
/* 642 */           if ((element1 = paramElement.select("dl").first()) != null)
/*     */           
/* 644 */           { boolean bool1 = false;
/* 645 */             boolean bool2 = false;
/* 646 */             for (iterator = element1.children().iterator(); iterator.hasNext(); ) {
/* 647 */               String str; boolean bool; if ((element1 = iterator.next()).tagName().equals("dt")) {
/*     */                 Element element2;
/*     */                 
/* 650 */                 bool = ((element2 = element1.select(".paramLabel").first()) != null && sanitizeHtmlString(element2.text()).equals("Parameters:")) ? true : false;
/* 651 */                 bool2 = (element1.select(".returnLabel").first() != null) ? true : false;
/*     */ 
/*     */                 
/* 654 */                 if ((element1 = element1.select(".overrideSpecifyLabel").first()) != null) {
/*     */                   
/* 656 */                   if ((str = sanitizeHtmlString(element1.text())).equals("Specified by:")) {
/* 657 */                     methodJD.specifiedByInterface = true; continue;
/* 658 */                   }  if (str.equals("Overrides:"))
/* 659 */                     methodJD.overridesSuperMethod = true; 
/*     */                 }  continue;
/*     */               } 
/* 662 */               if (str.tagName().equals("dd")) {
/* 663 */                 if (bool) {
/*     */                   
/* 665 */                   parseMethodParamDD((Element)str, methodJD); continue;
/* 666 */                 }  if (bool2)
/*     */                 {
/* 668 */                   if (methodJD.returnDescription == null) {
/* 669 */                     methodJD.returnDescription = sanitizeHtmlString(str.text()); continue;
/*     */                   } 
/* 671 */                   a.w("multiple \"Returns:\" <dd> elements in " + methodJD.method, new Object[0]);
/*     */                 }
/*     */               
/*     */               }
/*     */             
/*     */             }  }
/* 677 */           else if (verbose) { a.i("<dl> not found for " + methodJD.method + " - probably no parameter descriptions, will be skipped", new Object[0]); }
/*     */ 
/*     */           
/* 680 */           return methodJD;
/*     */         } 
/*     */         
/* 683 */         return null;
/*     */       }
/* 685 */       catch (Exception exception) {
/* 686 */         a.w("Exception while parsing method signature \"" + str1 + "\" of " + paramClass, new Object[] { exception });
/* 687 */         return null;
/*     */       } 
/*     */     } 
/* 690 */     a.w("ctor sig (pre) not found in \"" + sanitizeHtmlString(iterator.outerHtml()) + "\" of " + paramClass, new Object[0]);
/* 691 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\luadef\javadoc\ParserVariant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */