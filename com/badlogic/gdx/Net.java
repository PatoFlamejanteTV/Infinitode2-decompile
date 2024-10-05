/*     */ package com.badlogic.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.net.HttpStatus;
/*     */ import com.badlogic.gdx.net.ServerSocket;
/*     */ import com.badlogic.gdx.net.ServerSocketHints;
/*     */ import com.badlogic.gdx.net.Socket;
/*     */ import com.badlogic.gdx.net.SocketHints;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public interface Net
/*     */ {
/*     */   void sendHttpRequest(HttpRequest paramHttpRequest, @Null HttpResponseListener paramHttpResponseListener);
/*     */   
/*     */   void cancelHttpRequest(HttpRequest paramHttpRequest);
/*     */   
/*     */   boolean isHttpRequestPending(HttpRequest paramHttpRequest);
/*     */   
/*     */   ServerSocket newServerSocket(Protocol paramProtocol, String paramString, int paramInt, ServerSocketHints paramServerSocketHints);
/*     */   
/*     */   ServerSocket newServerSocket(Protocol paramProtocol, int paramInt, ServerSocketHints paramServerSocketHints);
/*     */   
/*     */   Socket newClientSocket(Protocol paramProtocol, String paramString, int paramInt, SocketHints paramSocketHints);
/*     */   
/*     */   boolean openURI(String paramString);
/*     */   
/*     */   public static interface HttpResponse
/*     */   {
/*     */     byte[] getResult();
/*     */     
/*     */     String getResultAsString();
/*     */     
/*     */     InputStream getResultAsStream();
/*     */     
/*     */     HttpStatus getStatus();
/*     */     
/*     */     String getHeader(String param1String);
/*     */     
/*     */     Map<String, List<String>> getHeaders();
/*     */   }
/*     */   
/*     */   public static interface HttpMethods
/*     */   {
/*     */     public static final String HEAD = "HEAD";
/*     */     public static final String GET = "GET";
/*     */     public static final String POST = "POST";
/*     */     public static final String PUT = "PUT";
/*     */     public static final String PATCH = "PATCH";
/*     */     public static final String DELETE = "DELETE";
/*     */   }
/*     */   
/*     */   public static class HttpRequest
/*     */     implements Pool.Poolable
/*     */   {
/*     */     private String httpMethod;
/*     */     private String url;
/*     */     private Map<String, String> headers;
/* 168 */     private int timeOut = 0;
/*     */     
/*     */     private String content;
/*     */     
/*     */     private InputStream contentStream;
/*     */     
/*     */     private long contentLength;
/*     */     private boolean followRedirects = true;
/*     */     private boolean includeCredentials = false;
/*     */     
/*     */     public HttpRequest() {
/* 179 */       this.headers = new HashMap<>();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public HttpRequest(String param1String) {
/* 185 */       this();
/* 186 */       this.httpMethod = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setUrl(String param1String) {
/* 192 */       this.url = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setHeader(String param1String1, String param1String2) {
/* 199 */       this.headers.put(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setContent(String param1String) {
/* 207 */       this.content = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setContent(InputStream param1InputStream, long param1Long) {
/* 213 */       this.contentStream = param1InputStream;
/* 214 */       this.contentLength = param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setTimeOut(int param1Int) {
/* 221 */       this.timeOut = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setFollowRedirects(boolean param1Boolean) {
/* 229 */       if (param1Boolean || Gdx.app.getType() != Application.ApplicationType.WebGL) {
/* 230 */         this.followRedirects = param1Boolean; return;
/*     */       } 
/* 232 */       throw new IllegalArgumentException("Following redirects can't be disabled using the GWT/WebGL backend!");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setIncludeCredentials(boolean param1Boolean) {
/* 239 */       this.includeCredentials = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setMethod(String param1String) {
/* 244 */       this.httpMethod = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTimeOut() {
/* 250 */       return this.timeOut;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getMethod() {
/* 255 */       return this.httpMethod;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getUrl() {
/* 260 */       return this.url;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getContent() {
/* 265 */       return this.content;
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream getContentStream() {
/* 270 */       return this.contentStream;
/*     */     }
/*     */ 
/*     */     
/*     */     public long getContentLength() {
/* 275 */       return this.contentLength;
/*     */     }
/*     */ 
/*     */     
/*     */     public Map<String, String> getHeaders() {
/* 280 */       return this.headers;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getFollowRedirects() {
/* 285 */       return this.followRedirects;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getIncludeCredentials() {
/* 290 */       return this.includeCredentials;
/*     */     }
/*     */ 
/*     */     
/*     */     public void reset() {
/* 295 */       this.httpMethod = null;
/* 296 */       this.url = null;
/* 297 */       this.headers.clear();
/* 298 */       this.timeOut = 0;
/*     */       
/* 300 */       this.content = null;
/* 301 */       this.contentStream = null;
/* 302 */       this.contentLength = 0L;
/*     */       
/* 304 */       this.followRedirects = true;
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
/*     */   public static interface HttpResponseListener
/*     */   {
/*     */     void handleHttpResponse(Net.HttpResponse param1HttpResponse);
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
/*     */     void failed(Throwable param1Throwable);
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
/*     */     void cancelled();
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
/*     */   public enum Protocol
/*     */   {
/* 357 */     TCP;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Net.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */