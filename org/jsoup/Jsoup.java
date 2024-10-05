/*     */ package org.jsoup;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import org.jsoup.helper.DataUtil;
/*     */ import org.jsoup.helper.HttpConnection;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.parser.Parser;
/*     */ import org.jsoup.safety.Cleaner;
/*     */ import org.jsoup.safety.Safelist;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Jsoup
/*     */ {
/*     */   public static Document parse(String paramString1, String paramString2) {
/*  34 */     return Parser.parse(paramString1, paramString2);
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
/*     */   public static Document parse(String paramString1, String paramString2, Parser paramParser) {
/*  48 */     return paramParser.parseInput(paramString1, paramString2);
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
/*     */   public static Document parse(String paramString, Parser paramParser) {
/*  62 */     return paramParser.parseInput(paramString, "");
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
/*     */   public static Document parse(String paramString) {
/*  75 */     return Parser.parse(paramString, "");
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
/*     */   public static Connection connect(String paramString) {
/*  92 */     return HttpConnection.connect(paramString);
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
/*     */   public static Connection newSession() {
/* 119 */     return (Connection)new HttpConnection();
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
/*     */   public static Document parse(File paramFile, String paramString1, String paramString2) {
/* 134 */     return DataUtil.load(paramFile, paramString1, paramString2);
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
/*     */   public static Document parse(File paramFile, String paramString) {
/* 149 */     return DataUtil.load(paramFile, paramString, paramFile.getAbsolutePath());
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
/*     */   public static Document parse(File paramFile) {
/* 166 */     return DataUtil.load(paramFile, null, paramFile.getAbsolutePath());
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
/*     */   public static Document parse(File paramFile, String paramString1, String paramString2, Parser paramParser) {
/* 183 */     return DataUtil.load(paramFile, paramString1, paramString2, paramParser);
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
/*     */   public static Document parse(InputStream paramInputStream, String paramString1, String paramString2) {
/* 198 */     return DataUtil.load(paramInputStream, paramString1, paramString2);
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
/*     */   public static Document parse(InputStream paramInputStream, String paramString1, String paramString2, Parser paramParser) {
/* 215 */     return DataUtil.load(paramInputStream, paramString1, paramString2, paramParser);
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
/*     */   public static Document parseBodyFragment(String paramString1, String paramString2) {
/* 228 */     return Parser.parseBodyFragment(paramString1, paramString2);
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
/*     */   public static Document parseBodyFragment(String paramString) {
/* 240 */     return Parser.parseBodyFragment(paramString, "");
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
/*     */   public static Document parse(URL paramURL, int paramInt) {
/*     */     Connection connection;
/* 262 */     (connection = HttpConnection.connect(paramURL)).timeout(paramInt);
/* 263 */     return connection.get();
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
/*     */   public static String clean(String paramString1, String paramString2, Safelist paramSafelist) {
/* 278 */     Document document = parseBodyFragment(paramString1, paramString2);
/*     */     
/*     */     Cleaner cleaner;
/* 281 */     return (document = (cleaner = new Cleaner(paramSafelist)).clean(document)).body().html();
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
/*     */   public static String clean(String paramString, Safelist paramSafelist) {
/* 315 */     return clean(paramString, "", paramSafelist);
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
/*     */   public static String clean(String paramString1, String paramString2, Safelist paramSafelist, Document.OutputSettings paramOutputSettings) {
/* 333 */     Document document = parseBodyFragment(paramString1, paramString2);
/*     */     
/*     */     Cleaner cleaner;
/* 336 */     (document = (cleaner = new Cleaner(paramSafelist)).clean(document)).outputSettings(paramOutputSettings);
/* 337 */     return document.body().html();
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
/*     */   public static boolean isValid(String paramString, Safelist paramSafelist) {
/* 362 */     return (new Cleaner(paramSafelist)).isValidBodyHtml(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\Jsoup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */