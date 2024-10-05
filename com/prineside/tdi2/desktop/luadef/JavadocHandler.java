/*     */ package com.prineside.tdi2.desktop.luadef;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.CharArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
/*     */ import com.prineside.tdi2.desktop.LuaDefinitionsGenerator;
/*     */ import com.prineside.tdi2.desktop.luadef.javadoc.ParserGdx;
/*     */ import com.prineside.tdi2.desktop.luadef.javadoc.ParserInfinitode;
/*     */ import com.prineside.tdi2.desktop.luadef.javadoc.ParserJava8;
/*     */ import com.prineside.tdi2.desktop.luadef.javadoc.ParserVariant;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.nio.file.Files;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class JavadocHandler {
/*  43 */   private static final TLog a = TLog.forClass(JavadocHandler.class);
/*     */ 
/*     */   
/*  46 */   public final Set<Class<?>> classesToFetchFor = new HashSet<>();
/*     */ 
/*     */   
/*     */   private static DataHolder b;
/*     */   
/*  51 */   public static final FlexmarkHtmlConverter htmlMarkdownConverter = FlexmarkHtmlConverter.builder(b = (DataHolder)(new MutableDataSet()).toImmutable()).build();
/*     */ 
/*     */ 
/*     */   
/*  55 */   public static ParserVariant[] PARSERS = new ParserVariant[] { (ParserVariant)new ParserGdx(), (ParserVariant)new ParserInfinitode(), (ParserVariant)new ParserJava8() };
/*     */ 
/*     */   
/*     */   private final ConcurrentHashMap<Class<?>, String> c;
/*     */ 
/*     */   
/*     */   public JavadocHandler() {
/*  62 */     this.c = new ConcurrentHashMap<>();
/*     */   }
/*     */   public static void main(String[] paramArrayOfString) {
/*  65 */     (new JavadocHandler()).run();
/*     */   }
/*     */   
/*     */   public ClassJD getForClass(Class<?> paramClass) {
/*     */     ClassJD classJD;
/*  70 */     if ((classJD = a(paramClass)) == null) {
/*     */       
/*  72 */       if (LuaDefinitionsGenerator.verbose) {
/*  73 */         a.w("No JD for " + paramClass, new Object[0]);
/*     */       }
/*  75 */       return ClassJD.EMPTY;
/*     */     } 
/*  77 */     return classJD;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  82 */     b();
/*  83 */     c();
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
/*     */   private void b() {
/* 107 */     long l = TimeUtils.millis();
/*     */ 
/*     */     
/* 110 */     ArrayList<JavadocSite> arrayList = new ArrayList();
/* 111 */     FileReader fileReader = new FileReader("res/luaj/javadoc-sources.txt"); 
/* 112 */     try { BufferedReader bufferedReader = new BufferedReader(fileReader);
/*     */       
/*     */       String str;
/* 115 */       while ((str = bufferedReader.readLine()) != null) {
/*     */ 
/*     */ 
/*     */         
/* 119 */         if ((str = str.trim()).length() != 0) {
/* 120 */           arrayList.add(new JavadocSite(str));
/*     */         }
/*     */       } 
/* 123 */       fileReader.close(); } catch (Throwable throwable) { try { fileReader.close(); }
/*     */       catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }
/*     */        throw throwable; }
/* 126 */      this.c.clear();
/* 127 */     arrayList.parallelStream().forEach(paramJavadocSite -> {
/*     */           paramJavadocSite.fetchClassUrls();
/*     */           
/*     */           Array.ArrayIterator<String> arrayIterator = paramJavadocSite.classUrls.iterator();
/*     */           
/*     */           while (arrayIterator.hasNext()) {
/*     */             String str = arrayIterator.next();
/*     */             
/*     */             Class<?> clazz;
/*     */             if ((clazz = paramJavadocSite.getClassFromClassUrl(str)) != null && (this.classesToFetchFor.size() == 0 || this.classesToFetchFor.contains(clazz))) {
/*     */               this.c.put(clazz, paramJavadocSite.rootUrl + str);
/*     */             }
/*     */           } 
/*     */         });
/* 141 */     int i = this.c.size();
/* 142 */     a.i("found javadoc class URLs for " + i + " classes in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   private void c() {
/* 147 */     long l = TimeUtils.millis();
/* 148 */     LuaDefUtils.createDirs("cache/javadoc-cache/index.html");
/*     */     
/* 150 */     AtomicInteger atomicInteger = new AtomicInteger();
/* 151 */     this.c.entrySet().parallelStream().forEach(paramEntry -> {
/*     */           try {
/*     */             a((Class)paramEntry.getKey(), (String)paramEntry.getValue());
/* 154 */           } catch (Exception exception) {
/*     */             a.e("failed to cache class page " + (String)paramEntry.getValue(), new Object[] { exception });
/*     */           } 
/*     */           
/*     */           int i;
/*     */           if ((i = paramAtomicInteger.incrementAndGet()) % 200 == 0) {
/*     */             a.i("- " + i + " / " + this.c.size(), new Object[0]);
/*     */           }
/*     */         });
/* 163 */     a.i("cached all class javadoc pages locally in " + (TimeUtils.millis() - l) + "ms", new Object[0]);
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
/*     */   private ClassJD a(Class<?> paramClass) {
/*     */     Document document;
/* 184 */     if (ParserVariant.verbose) a.i("----- parse " + paramClass, new Object[0]); 
/*     */     File file;
/* 186 */     if (!(file = new File(getJavadocPageCacheFilePath(paramClass))).exists()) {
/* 187 */       a.w("cache file not found for " + paramClass + ", its javadoc will be skipped", new Object[0]);
/* 188 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 194 */       document = Jsoup.parse(file);
/* 195 */     } catch (IOException iOException) {
/* 196 */       a.e("failed to parse class page for " + paramClass, new Object[] { iOException });
/* 197 */       return null;
/*     */     } 
/*     */     
/* 200 */     int i = -1;
/* 201 */     ParserVariant parserVariant = null;
/* 202 */     byte b1 = 0; ParserVariant[] arrayOfParserVariant; int j; byte b2;
/* 203 */     for (j = (arrayOfParserVariant = PARSERS).length, b2 = 0; b2 < j; b2++) {
/*     */       ParserVariant parserVariant1; int k;
/* 205 */       if ((k = (parserVariant1 = arrayOfParserVariant[b2]).getScore(document)) > 0) {
/* 206 */         if (k > i) {
/* 207 */           i = k;
/* 208 */           parserVariant = parserVariant1;
/* 209 */           b1 = 0;
/* 210 */         } else if (k == i) {
/* 211 */           b1++;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 216 */     if (parserVariant == null) {
/* 217 */       throw new IllegalStateException("failed to find a parser for " + paramClass + " - all parsers gave zero score");
/*     */     }
/* 219 */     if (b1 > 0) {
/* 220 */       throw new IllegalStateException("multiple parsers (" + (b1 + 1) + ") have same score");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     if (ParserVariant.verbose) a.i("- using parser '" + parserVariant.getName() + "' with score " + i, new Object[0]);
/*     */     
/*     */     ClassJD classJD;
/* 230 */     (classJD = new ClassJD()).javadocUrl = this.c.get(paramClass);
/* 231 */     classJD.description = parserVariant.getClassDescription(document);
/* 232 */     classJD.genericsString = parserVariant.getClassGenericsString(document); Array.ArrayIterator<ConstructorJD> arrayIterator;
/* 233 */     for (arrayIterator = parserVariant.getConstructors(document, paramClass).iterator(); arrayIterator.hasNext(); ) { ConstructorJD constructorJD = arrayIterator.next();
/* 234 */       classJD.constructors.put(constructorJD.ctor, constructorJD); }
/*     */     
/* 236 */     for (arrayIterator = parserVariant.getFields(document, paramClass).iterator(); arrayIterator.hasNext(); ) { FieldJD fieldJD = (FieldJD)arrayIterator.next();
/* 237 */       classJD.fields.put(fieldJD.field, fieldJD); }
/*     */     
/* 239 */     for (arrayIterator = parserVariant.getMethods(document, paramClass).iterator(); arrayIterator.hasNext(); ) { MethodJD methodJD = (MethodJD)arrayIterator.next();
/* 240 */       classJD.methods.put(methodJD.method, methodJD); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 251 */     return classJD;
/*     */   }
/*     */   
/*     */   public static String getJavadocPageCacheFilePath(Class<?> paramClass) {
/* 255 */     String str = paramClass.getName().replaceAll("\\$", "_");
/* 256 */     return "cache/javadoc-cache/" + str + ".html";
/*     */   }
/*     */   
/*     */   private static void a(Class<?> paramClass, String paramString) {
/* 260 */     String str = getJavadocPageCacheFilePath(paramClass);
/*     */     File file;
/* 262 */     if (!(file = new File(str)).exists()) {
/* 263 */       a.i("fetching " + paramString, new Object[0]);
/*     */       URL uRL;
/* 265 */       InputStream inputStream = (uRL = new URL(paramString)).openStream(); try {
/* 266 */         OutputStream outputStream = Files.newOutputStream(file.toPath(), new java.nio.file.OpenOption[0]); 
/* 267 */         try { byte[] arrayOfByte = new byte[8192];
/*     */           int i;
/* 269 */           while ((i = inputStream.read(arrayOfByte)) != -1) {
/* 270 */             outputStream.write(arrayOfByte, 0, i);
/*     */           }
/* 272 */           outputStream.flush();
/* 273 */           if (outputStream != null) outputStream.close();  } catch (Throwable throwable) { if (outputStream != null)
/* 274 */             try { outputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  if (inputStream != null) { inputStream.close();
/*     */           return; }
/*     */       
/*     */       } catch (Throwable throwable) {
/*     */         if (inputStream != null)
/*     */           try {
/*     */             inputStream.close();
/*     */           } catch (Throwable throwable1) {
/*     */             throwable.addSuppressed(throwable1);
/*     */           }  
/*     */         throw throwable;
/*     */       } 
/*     */     } 
/* 287 */   } public static class ClassJavadoc {} public static class JavadocSite { public final String allClassesUrl; public final String rootUrl; public final Array<String> classUrls = new Array();
/*     */     
/*     */     public JavadocSite(String param1String) {
/* 290 */       this.allClassesUrl = param1String;
/* 291 */       String[] arrayOfString = param1String.split("/");
/* 292 */       StringBuilder stringBuilder = new StringBuilder();
/* 293 */       for (byte b = 0; b < arrayOfString.length - 1; b++) {
/* 294 */         stringBuilder.append(arrayOfString[b]).append("/");
/*     */       }
/* 296 */       this.rootUrl = stringBuilder.toString();
/*     */       
/* 298 */       if (LuaDefinitionsGenerator.verbose)
/* 299 */         JavadocHandler.a().i("Javadoc: " + this.rootUrl, new Object[0]); 
/*     */     }
/*     */     
/*     */     public void fetchClassUrls() {
/*     */       Document document;
/* 304 */       this.classUrls.clear();
/*     */       
/* 306 */       JavadocHandler.a().i("fetching class list from " + this.allClassesUrl, new Object[0]);
/*     */       
/*     */       try {
/* 309 */         document = Jsoup.connect(this.allClassesUrl).get();
/* 310 */       } catch (Exception exception) {
/* 311 */         JavadocHandler.a().e("failed to fetch " + this.allClassesUrl, new Object[0]);
/* 312 */         System.exit(1);
/*     */         
/*     */         return;
/*     */       } 
/* 316 */       JavadocHandler.a().i("got response from " + this.allClassesUrl, new Object[0]);
/*     */       Elements elements;
/* 318 */       for (Iterator<Element> iterator = (elements = document.select("a")).iterator(); iterator.hasNext(); ) {
/*     */         String str; Element element;
/* 320 */         if (!(str = (element = iterator.next()).attr("href")).contains("/") || str.contains("://") || str.contains("-") || str.contains("#") || !str.endsWith(".html")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 327 */           if (LuaDefinitionsGenerator.verbose) {
/* 328 */             JavadocHandler.a().i("skip href: " + str, new Object[0]);
/*     */           }
/*     */           continue;
/*     */         } 
/* 332 */         this.classUrls.add(str);
/*     */       } 
/* 334 */       if (LuaDefinitionsGenerator.verbose) {
/* 335 */         JavadocHandler.a().i("found " + this.classUrls.size + " class URLs", new Object[0]);
/*     */       }
/*     */     }
/*     */     
/*     */     @Null
/*     */     public Class<?> getClassFromClassUrl(String param1String) {
/*     */       String str;
/* 342 */       if ((str = param1String).endsWith(".html")) {
/* 343 */         str = str.substring(0, str.length() - 5);
/*     */       } else {
/* 345 */         if (LuaDefinitionsGenerator.verbose) {
/* 346 */           JavadocHandler.a().i("can't parse " + param1String + " which does not end with .html", new Object[0]);
/*     */         }
/* 348 */         return null;
/*     */       } 
/* 350 */       param1String = str.replaceAll("\\.", "\\$").replaceAll("/", "\\.");
/*     */       try {
/* 352 */         return Class.forName(param1String);
/* 353 */       } catch (Exception exception) {
/* 354 */         if (LuaDefinitionsGenerator.verbose) {
/* 355 */           JavadocHandler.a().i("can't get runtime class from " + param1String + " - its javadoc will be skipped", new Object[0]);
/*     */         }
/* 357 */         return null;
/*     */       } 
/*     */     } }
/*     */ 
/*     */   
/*     */   public static String formatDocumentation(String paramString, int paramInt) {
/* 363 */     StringBuilder stringBuilder2 = new StringBuilder();
/* 364 */     for (byte b1 = 0; b1 < paramInt; b1++) {
/* 365 */       stringBuilder2.append(" ");
/*     */     }
/* 367 */     String str = stringBuilder2.toString();
/*     */     
/* 369 */     StringBuilder stringBuilder1 = new StringBuilder();
/* 370 */     paramString = htmlMarkdownConverter.convert(paramString);
/*     */     Parser parser;
/* 372 */     (parser = Parser.builder().build()).parse(paramString); String[] arrayOfString; int i; byte b2;
/* 373 */     for (i = (arrayOfString = paramString.split("\n")).length, b2 = 0; b2 < i; b2++) {
/*     */       String str1, str2;
/*     */ 
/*     */ 
/*     */       
/* 378 */       byte b = ((str2 = (str1 = (str1 = arrayOfString[b2]).replaceAll("\\[([^]]+)]\\(([^)]+)\\)", "$1")).trim()).length() == 0) ? 88 : str2.charAt(0);
/* 379 */       if (str1.length() <= 77 || b == 62 || b == 124 || b == 42) {
/* 380 */         stringBuilder1.append(str).append("--- ").append(str1).append("\n");
/*     */       } else {
/*     */         
/* 383 */         stringBuilder1.append(str).append("--- ");
/* 384 */         b = 4;
/* 385 */         CharArray charArray = new CharArray();
/* 386 */         for (byte b3 = 0; b3 < str1.length(); b3++) {
/* 387 */           char c = str1.charAt(b3);
/* 388 */           stringBuilder1.append(c);
/* 389 */           b++;
/*     */           
/* 391 */           switch (c) {
/*     */             case '`':
/* 393 */               if (charArray.contains('`')) {
/* 394 */                 charArray.removeValue('`'); break;
/*     */               } 
/* 396 */               charArray.add('`');
/*     */               break;
/*     */ 
/*     */             
/*     */             case '(':
/*     */             case '[':
/* 402 */               charArray.add(c);
/*     */               break;
/*     */             
/*     */             case ']':
/* 406 */               charArray.removeValue('[');
/*     */               break;
/*     */             
/*     */             case ')':
/* 410 */               charArray.removeValue('(');
/*     */               break;
/*     */             
/*     */             case '/':
/* 414 */               if (str1.length() > b3 + 1 && str1.charAt(b3 + 1) == '/')
/*     */               {
/* 416 */                 charArray.add('/');
/*     */               }
/*     */               break;
/*     */           } 
/*     */ 
/*     */           
/* 422 */           if (b >= 80 && c == ' ' && charArray.size == 0) {
/* 423 */             stringBuilder1.append("\n").append(str).append("--- ");
/* 424 */             b = 4;
/*     */           } 
/*     */         } 
/* 427 */         if (b > 4) {
/* 428 */           stringBuilder1.append("\n");
/*     */         }
/*     */       } 
/*     */     } 
/* 432 */     return stringBuilder1.toString();
/*     */   }
/*     */   
/*     */   public static class ClassJD
/*     */   {
/* 437 */     public static final ClassJD EMPTY = new ClassJD(); @Null
/*     */     public String javadocUrl; @Null
/*     */     public String description;
/*     */     @Null
/*     */     public String genericsString;
/* 442 */     public HashMap<Constructor<?>, JavadocHandler.ConstructorJD> constructors = new HashMap<>();
/* 443 */     public HashMap<Method, JavadocHandler.MethodJD> methods = new HashMap<>();
/* 444 */     public HashMap<Field, JavadocHandler.FieldJD> fields = new HashMap<>(); }
/*     */   public static class ConstructorJD { public Constructor<?> ctor; @Null
/*     */     public String description;
/*     */     public Array<JavadocHandler.ParamJD> params;
/*     */     
/*     */     public ConstructorJD() {
/* 450 */       this.params = new Array();
/*     */     } }
/*     */   public static class MethodJD { public Method method; @Null
/*     */     public String description; public Array<JavadocHandler.ParamJD> params; @Null
/*     */     public String returnDescription; public boolean specifiedByInterface; public boolean overridesSuperMethod;
/*     */     public MethodJD() {
/* 456 */       this.params = new Array();
/*     */     } }
/*     */ 
/*     */   
/*     */   public static class ParamJD {
/*     */     public String name;
/*     */     @Null
/*     */     public String description;
/*     */   }
/*     */   
/*     */   public static class FieldJD {
/*     */     public Field field;
/*     */     @Null
/*     */     public String description;
/*     */     @Null
/*     */     public String generics;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\luadef\JavadocHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */