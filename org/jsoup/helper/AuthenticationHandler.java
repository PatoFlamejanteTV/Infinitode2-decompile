/*    */ package org.jsoup.helper;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.net.Authenticator;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.PasswordAuthentication;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AuthenticationHandler
/*    */   extends Authenticator
/*    */ {
/*    */   static final int MaxAttempts = 5;
/*    */   static AuthShim handler;
/*    */   RequestAuthenticator auth;
/*    */   
/*    */   static {
/*    */     try {
/*    */       Class<?> clazz;
/*    */       Constructor<?> constructor;
/* 24 */       handler = (AuthShim)(constructor = (clazz = Class.forName("org.jsoup.helper.RequestAuthHandler")).getConstructor(new Class[0])).newInstance(new Object[0]); return;
/* 25 */     } catch (ClassNotFoundException classNotFoundException) {
/* 26 */       handler = new GlobalHandler(); return;
/* 27 */     } catch (Exception exception) {
/* 28 */       throw new IllegalStateException(exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 33 */   int attemptCount = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   AuthenticationHandler(RequestAuthenticator paramRequestAuthenticator) {
/* 38 */     this.auth = paramRequestAuthenticator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final PasswordAuthentication getPasswordAuthentication() {
/*    */     AuthenticationHandler authenticationHandler;
/* 47 */     if ((authenticationHandler = handler.get(this)) == null) return null; 
/* 48 */     authenticationHandler.attemptCount++;
/*    */ 
/*    */ 
/*    */     
/* 52 */     if (authenticationHandler.attemptCount > 5)
/* 53 */       return null; 
/* 54 */     if (authenticationHandler.auth == null) {
/* 55 */       return null;
/*    */     }
/*    */     
/* 58 */     RequestAuthenticator.Context context = new RequestAuthenticator.Context(getRequestingURL(), getRequestorType(), getRequestingPrompt());
/* 59 */     return authenticationHandler.auth.authenticate(context);
/*    */   }
/*    */   
/*    */   AuthenticationHandler() {}
/*    */   
/*    */   static interface AuthShim {
/*    */     void enable(RequestAuthenticator param1RequestAuthenticator, HttpURLConnection param1HttpURLConnection);
/*    */     
/*    */     void remove();
/*    */     
/*    */     AuthenticationHandler get(AuthenticationHandler param1AuthenticationHandler);
/*    */   }
/*    */   
/*    */   static class GlobalHandler
/*    */     implements AuthShim {
/* 74 */     static ThreadLocal<AuthenticationHandler> authenticators = new ThreadLocal<>();
/*    */     static {
/* 76 */       Authenticator.setDefault(new AuthenticationHandler());
/*    */     }
/*    */     
/*    */     public void enable(RequestAuthenticator param1RequestAuthenticator, HttpURLConnection param1HttpURLConnection) {
/* 80 */       authenticators.set(new AuthenticationHandler(param1RequestAuthenticator));
/*    */     }
/*    */     
/*    */     public void remove() {
/* 84 */       authenticators.remove();
/*    */     }
/*    */     
/*    */     public AuthenticationHandler get(AuthenticationHandler param1AuthenticationHandler) {
/* 88 */       return authenticators.get();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\AuthenticationHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */