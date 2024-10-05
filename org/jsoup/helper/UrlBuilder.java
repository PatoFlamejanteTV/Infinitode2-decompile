/*    */ package org.jsoup.helper;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.net.IDN;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URI;
/*    */ import java.net.URL;
/*    */ import java.net.URLDecoder;
/*    */ import java.net.URLEncoder;
/*    */ import org.jsoup.Connection;
/*    */ import org.jsoup.internal.StringUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class UrlBuilder
/*    */ {
/*    */   URL u;
/*    */   StringBuilder q;
/*    */   
/*    */   UrlBuilder(URL paramURL) {
/* 28 */     this.u = paramURL;
/* 29 */     if (this.u.getQuery() != null) {
/* 30 */       this.q = StringUtil.borrowBuilder().append(this.u.getQuery());
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   final URL build() {
/*    */     try {
/* 40 */       URI uRI = new URI(this.u.getProtocol(), this.u.getUserInfo(), IDN.toASCII(decodePart(this.u.getHost())), this.u.getPort(), null, null, null);
/*    */ 
/*    */ 
/*    */       
/* 44 */       StringBuilder stringBuilder = StringUtil.borrowBuilder().append(uRI.toASCIIString());
/* 45 */       appendToAscii(this.u.getPath(), false, stringBuilder);
/* 46 */       if (this.q != null) {
/* 47 */         stringBuilder.append('?');
/* 48 */         appendToAscii(StringUtil.releaseBuilder(this.q), true, stringBuilder);
/*    */       } 
/* 50 */       if (this.u.getRef() != null) {
/* 51 */         stringBuilder.append('#');
/* 52 */         appendToAscii(this.u.getRef(), false, stringBuilder);
/*    */       } 
/* 54 */       this.u = new URL(StringUtil.releaseBuilder(stringBuilder));
/* 55 */       return this.u;
/* 56 */     } catch (MalformedURLException|java.net.URISyntaxException|UnsupportedEncodingException malformedURLException) {
/*    */ 
/*    */ 
/*    */       
/* 60 */       assert Validate.assertFail(malformedURLException.toString());
/* 61 */       return this.u;
/*    */     } 
/*    */   }
/*    */   
/*    */   final void appendKeyVal(Connection.KeyVal paramKeyVal) {
/* 66 */     if (this.q == null) {
/* 67 */       this.q = StringUtil.borrowBuilder();
/*    */     } else {
/* 69 */       this.q.append('&');
/* 70 */     }  this.q
/* 71 */       .append(URLEncoder.encode(paramKeyVal.key(), DataUtil.UTF_8.name()))
/* 72 */       .append('=')
/* 73 */       .append(URLEncoder.encode(paramKeyVal.value(), DataUtil.UTF_8.name()));
/*    */   }
/*    */   
/*    */   private static String decodePart(String paramString) {
/*    */     try {
/* 78 */       return URLDecoder.decode(paramString, DataUtil.UTF_8.name());
/* 79 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 80 */       throw new RuntimeException(unsupportedEncodingException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static void appendToAscii(String paramString, boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 86 */     for (byte b = 0; b < paramString.length(); b++) {
/*    */       int i;
/* 88 */       if ((i = paramString.codePointAt(b)) == 32) {
/* 89 */         paramStringBuilder.append(paramBoolean ? Character.valueOf('+') : "%20");
/* 90 */       } else if (i > 127) {
/* 91 */         paramStringBuilder.append(URLEncoder.encode(new String(Character.toChars(i)), DataUtil.UTF_8.name()));
/*    */         
/* 93 */         if (Character.charCount(i) == 2) b++; 
/*    */       } else {
/* 95 */         paramStringBuilder.append((char)i);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\UrlBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */