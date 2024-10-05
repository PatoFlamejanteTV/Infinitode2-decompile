/*    */ package org.jsoup.helper;
/*    */ 
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URI;
/*    */ import java.net.URISyntaxException;
/*    */ import java.net.URL;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashSet;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.jsoup.Connection;
/*    */ import org.jsoup.internal.StringUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CookieUtil
/*    */ {
/* 26 */   private static final Map<String, List<String>> EmptyRequestHeaders = Collections.unmodifiableMap(new HashMap<>());
/*    */ 
/*    */   
/*    */   private static final String Sep = "; ";
/*    */   
/*    */   private static final String CookieName = "Cookie";
/*    */   
/*    */   private static final String Cookie2Name = "Cookie2";
/*    */ 
/*    */   
/*    */   static void applyCookiesToRequest(HttpConnection.Request paramRequest, HttpURLConnection paramHttpURLConnection) {
/* 37 */     LinkedHashSet<String> linkedHashSet = requestCookieSet(paramRequest);
/* 38 */     HashSet hashSet = null;
/*    */     
/*    */     Map<String, List<String>> map;
/*    */     
/* 42 */     for (Iterator<Map.Entry> iterator = (map = paramRequest.cookieManager().get(asUri(paramRequest.url), EmptyRequestHeaders)).entrySet().iterator(); iterator.hasNext();) {
/*    */ 
/*    */       
/* 45 */       if ((list = (entry = iterator.next()).getValue()) != null && list.size() != 0) {
/*    */         HashSet hashSet1;
/*    */         
/* 48 */         String str = (String)entry.getKey();
/*    */         
/* 50 */         if ("Cookie".equals(str)) {
/* 51 */           hashSet1 = linkedHashSet;
/* 52 */         } else if ("Cookie2".equals(hashSet1)) {
/*    */           
/* 54 */           hashSet = hashSet1 = new HashSet();
/*    */         } else {
/*    */           continue;
/*    */         } 
/* 58 */         hashSet1.addAll(list);
/*    */       } 
/*    */     } 
/* 61 */     if (linkedHashSet.size() > 0)
/* 62 */       paramHttpURLConnection.addRequestProperty("Cookie", StringUtil.join(linkedHashSet, "; ")); 
/* 63 */     if (hashSet != null && hashSet.size() > 0)
/* 64 */       paramHttpURLConnection.addRequestProperty("Cookie2", StringUtil.join(hashSet, "; ")); 
/*    */   }
/*    */   
/*    */   private static LinkedHashSet<String> requestCookieSet(Connection.Request paramRequest) {
/* 68 */     LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
/*    */     
/* 70 */     for (Map.Entry entry : paramRequest.cookies().entrySet()) {
/* 71 */       linkedHashSet.add((String)entry.getKey() + "=" + (String)entry.getValue());
/*    */     }
/* 73 */     return linkedHashSet;
/*    */   }
/*    */   
/*    */   static URI asUri(URL paramURL) {
/*    */     try {
/* 78 */       return paramURL.toURI();
/* 79 */     } catch (URISyntaxException uRISyntaxException) {
/*    */       MalformedURLException malformedURLException;
/* 81 */       (malformedURLException = new MalformedURLException(uRISyntaxException.getMessage())).initCause(uRISyntaxException);
/* 82 */       throw malformedURLException;
/*    */     } 
/*    */   }
/*    */   
/*    */   static void storeCookies(HttpConnection.Request paramRequest, URL paramURL, Map<String, List<String>> paramMap) {
/* 87 */     paramRequest.cookieManager().put(asUri(paramURL), paramMap);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\CookieUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */