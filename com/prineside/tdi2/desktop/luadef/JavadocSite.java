/*    */ package com.prineside.tdi2.desktop.luadef;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.badlogic.gdx.utils.StringBuilder;
/*    */ import com.prineside.tdi2.desktop.LuaDefinitionsGenerator;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ import java.util.Iterator;
/*    */ import org.jsoup.Jsoup;
/*    */ import org.jsoup.nodes.Document;
/*    */ import org.jsoup.nodes.Element;
/*    */ import org.jsoup.select.Elements;
/*    */ 
/*    */ 
/*    */ public class JavadocSite
/*    */ {
/* 17 */   private static final TLog a = TLog.forClass(JavadocSite.class);
/*    */   
/*    */   public final String allClassesUrl;
/*    */   public final String rootUrl;
/* 21 */   public final Array<String> classUrls = new Array();
/*    */   
/*    */   public JavadocSite(String paramString) {
/* 24 */     this.allClassesUrl = paramString;
/* 25 */     String[] arrayOfString = paramString.split("/");
/* 26 */     StringBuilder stringBuilder = new StringBuilder();
/* 27 */     for (byte b = 0; b < arrayOfString.length - 1; b++) {
/* 28 */       stringBuilder.append(arrayOfString[b]).append("/");
/*    */     }
/* 30 */     this.rootUrl = stringBuilder.toString();
/*    */     
/* 32 */     if (LuaDefinitionsGenerator.verbose) {
/* 33 */       a.i("Javadoc: " + this.rootUrl, new Object[0]);
/*    */     }
/*    */   }
/*    */   
/*    */   public void getClassUrls() {
/* 38 */     this.classUrls.clear();
/*    */     
/*    */     Elements elements;
/*    */     Document document;
/* 42 */     for (Iterator<Element> iterator = (elements = (document = Jsoup.connect(this.allClassesUrl).get()).select("a")).iterator(); iterator.hasNext(); ) {
/*    */       Element element; String str;
/* 44 */       if (!(str = (element = iterator.next()).attr("href")).contains("/") || str.contains("://") || str.contains("-") || str.contains("#") || !str.endsWith(".html")) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 51 */         if (LuaDefinitionsGenerator.verbose) {
/* 52 */           a.i("skip href: " + str, new Object[0]);
/*    */         }
/*    */         continue;
/*    */       } 
/* 56 */       this.classUrls.add(str);
/*    */     } 
/* 58 */     if (LuaDefinitionsGenerator.verbose) {
/* 59 */       a.i("found " + this.classUrls.size + " class URLs", new Object[0]);
/*    */     }
/*    */   }
/*    */   
/*    */   @Null
/*    */   public Class<?> getClassFromClassUrl(String paramString) {
/*    */     String str;
/* 66 */     if ((str = paramString).endsWith(".html")) {
/* 67 */       str = str.substring(0, str.length() - 5);
/*    */     } else {
/* 69 */       if (LuaDefinitionsGenerator.verbose) {
/* 70 */         a.i("can't parse " + paramString + " which does not end with .html", new Object[0]);
/*    */       }
/* 72 */       return null;
/*    */     } 
/* 74 */     paramString = str.replaceAll("\\.", "\\$").replaceAll("/", "\\.");
/*    */     try {
/* 76 */       return Class.forName(paramString);
/* 77 */     } catch (Exception exception) {
/* 78 */       if (LuaDefinitionsGenerator.verbose) {
/* 79 */         a.i("can't get runtime class from " + paramString + " - its javadoc will be skipped", new Object[0]);
/*    */       }
/* 81 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\luadef\JavadocSite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */