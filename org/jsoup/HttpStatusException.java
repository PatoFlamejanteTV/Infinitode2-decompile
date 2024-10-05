/*    */ package org.jsoup;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ public class HttpStatusException
/*    */   extends IOException
/*    */ {
/*    */   private final int statusCode;
/*    */   private final String url;
/*    */   
/*    */   public HttpStatusException(String paramString1, int paramInt, String paramString2) {
/* 13 */     super(paramString1 + ". Status=" + paramInt + ", URL=[" + paramString2 + "]");
/* 14 */     this.statusCode = paramInt;
/* 15 */     this.url = paramString2;
/*    */   }
/*    */   
/*    */   public int getStatusCode() {
/* 19 */     return this.statusCode;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 23 */     return this.url;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\HttpStatusException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */