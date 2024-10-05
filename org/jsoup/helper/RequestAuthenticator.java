/*    */ package org.jsoup.helper;
/*    */ 
/*    */ import java.net.Authenticator;
/*    */ import java.net.PasswordAuthentication;
/*    */ import java.net.URL;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface RequestAuthenticator
/*    */ {
/*    */   PasswordAuthentication authenticate(Context paramContext);
/*    */   
/*    */   public static class Context
/*    */   {
/*    */     private final URL url;
/*    */     private final Authenticator.RequestorType type;
/*    */     private final String realm;
/*    */     
/*    */     Context(URL param1URL, Authenticator.RequestorType param1RequestorType, String param1String) {
/* 35 */       this.url = param1URL;
/* 36 */       this.type = param1RequestorType;
/* 37 */       this.realm = param1String;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public URL url() {
/* 45 */       return this.url;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Authenticator.RequestorType type() {
/* 54 */       return this.type;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public String realm() {
/* 62 */       return this.realm;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean isProxy() {
/* 70 */       return (this.type == Authenticator.RequestorType.PROXY);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean isServer() {
/* 78 */       return (this.type == Authenticator.RequestorType.SERVER);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public PasswordAuthentication credentials(String param1String1, String param1String2) {
/* 88 */       return new PasswordAuthentication(param1String1, param1String2.toCharArray());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\RequestAuthenticator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */