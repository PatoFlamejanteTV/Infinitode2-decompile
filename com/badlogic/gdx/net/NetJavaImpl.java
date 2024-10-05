/*     */ package com.badlogic.gdx.net;
/*     */ 
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.SynchronousQueue;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
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
/*     */ public class NetJavaImpl
/*     */ {
/*     */   private final ThreadPoolExecutor executorService;
/*     */   final ObjectMap<Net.HttpRequest, HttpURLConnection> connections;
/*     */   final ObjectMap<Net.HttpRequest, Net.HttpResponseListener> listeners;
/*     */   final ObjectMap<Net.HttpRequest, Future<?>> tasks;
/*     */   
/*     */   static class HttpClientResponse
/*     */     implements Net.HttpResponse
/*     */   {
/*     */     private final HttpURLConnection connection;
/*     */     private HttpStatus status;
/*     */     
/*     */     public HttpClientResponse(HttpURLConnection param1HttpURLConnection) {
/*  54 */       this.connection = param1HttpURLConnection;
/*     */       try {
/*  56 */         this.status = new HttpStatus(param1HttpURLConnection.getResponseCode()); return;
/*  57 */       } catch (IOException iOException) {
/*  58 */         this.status = new HttpStatus(-1);
/*     */         return;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public byte[] getResult() {
/*     */       InputStream inputStream;
/*  67 */       if ((inputStream = getInputStream()) == null) {
/*  68 */         return StreamUtils.EMPTY_BYTES;
/*     */       }
/*     */       
/*     */       try {
/*  72 */         return StreamUtils.copyStreamToByteArray(inputStream, this.connection.getContentLength());
/*  73 */       } catch (IOException iOException) {
/*  74 */         return StreamUtils.EMPTY_BYTES;
/*     */       } finally {
/*  76 */         StreamUtils.closeQuietly(inputStream);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getResultAsString() {
/*     */       InputStream inputStream;
/*  85 */       if ((inputStream = getInputStream()) == null) {
/*  86 */         return "";
/*     */       }
/*     */       
/*     */       try {
/*  90 */         return StreamUtils.copyStreamToString(inputStream, this.connection.getContentLength(), "UTF8");
/*  91 */       } catch (IOException iOException) {
/*  92 */         return "";
/*     */       } finally {
/*  94 */         StreamUtils.closeQuietly(inputStream);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream getResultAsStream() {
/* 100 */       return getInputStream();
/*     */     }
/*     */ 
/*     */     
/*     */     public HttpStatus getStatus() {
/* 105 */       return this.status;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getHeader(String param1String) {
/* 110 */       return this.connection.getHeaderField(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public Map<String, List<String>> getHeaders() {
/* 115 */       return this.connection.getHeaderFields();
/*     */     }
/*     */     
/*     */     private InputStream getInputStream() {
/*     */       try {
/* 120 */         return this.connection.getInputStream();
/* 121 */       } catch (IOException iOException) {
/* 122 */         return this.connection.getErrorStream();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NetJavaImpl() {
/* 133 */     this(2147483647);
/*     */   }
/*     */   
/*     */   public NetJavaImpl(int paramInt) {
/* 137 */     boolean bool = (paramInt == Integer.MAX_VALUE) ? true : false;
/* 138 */     this
/* 139 */       .executorService = new ThreadPoolExecutor(bool ? 0 : paramInt, paramInt, 60L, TimeUnit.SECONDS, bool ? new SynchronousQueue<>() : new LinkedBlockingQueue<>(), new ThreadFactory() {
/* 140 */           AtomicInteger threadID = new AtomicInteger();
/*     */ 
/*     */ 
/*     */           
/*     */           public Thread newThread(Runnable param1Runnable) {
/* 145 */             (param1Runnable = new Thread(param1Runnable, "NetThread" + this.threadID.getAndIncrement())).setDaemon(true);
/* 146 */             return (Thread)param1Runnable;
/*     */           }
/*     */         });
/* 149 */     this.executorService.allowCoreThreadTimeOut(!bool);
/* 150 */     this.connections = new ObjectMap();
/* 151 */     this.listeners = new ObjectMap();
/* 152 */     this.tasks = new ObjectMap();
/*     */   }
/*     */   
/*     */   public void sendHttpRequest(final Net.HttpRequest httpRequest, final Net.HttpResponseListener httpResponseListener) {
/* 156 */     if (httpRequest.getUrl() == null) {
/* 157 */       httpResponseListener.failed((Throwable)new GdxRuntimeException("can't process a HTTP request without URL set"));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/*     */       URL uRL;
/*     */       String str;
/* 165 */       boolean bool1 = !(str = httpRequest.getMethod()).equalsIgnoreCase("HEAD") ? true : false;
/*     */ 
/*     */       
/* 168 */       final boolean doingOutPut = (str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("PATCH")) ? true : false;
/*     */       
/* 170 */       if (str.equalsIgnoreCase("GET") || str.equalsIgnoreCase("HEAD")) {
/* 171 */         String str1 = "";
/*     */         String str2;
/* 173 */         if ((str2 = httpRequest.getContent()) != null && !"".equals(str2)) str1 = "?" + str2; 
/* 174 */         uRL = new URL(httpRequest.getUrl() + str1);
/*     */       } else {
/* 176 */         uRL = new URL(httpRequest.getUrl());
/*     */       } 
/*     */       
/*     */       final HttpURLConnection connection;
/* 180 */       (httpURLConnection = (HttpURLConnection)uRL.openConnection()).setDoOutput(bool2);
/* 181 */       httpURLConnection.setDoInput(bool1);
/* 182 */       httpURLConnection.setRequestMethod(str);
/* 183 */       HttpURLConnection.setFollowRedirects(httpRequest.getFollowRedirects());
/*     */       
/* 185 */       putIntoConnectionsAndListeners(httpRequest, httpResponseListener, httpURLConnection);
/*     */ 
/*     */       
/* 188 */       for (Map.Entry entry : httpRequest.getHeaders().entrySet()) {
/* 189 */         httpURLConnection.addRequestProperty((String)entry.getKey(), (String)entry.getValue());
/*     */       }
/*     */       
/* 192 */       httpURLConnection.setConnectTimeout(httpRequest.getTimeOut());
/* 193 */       httpURLConnection.setReadTimeout(httpRequest.getTimeOut());
/*     */       
/* 195 */       this.tasks.put(httpRequest, this.executorService.submit(new Runnable()
/*     */             {
/*     */               public void run()
/*     */               {
/*     */                 try {
/* 200 */                   if (doingOutPut) {
/*     */                     String str;
/*     */                     
/* 203 */                     if ((str = httpRequest.getContent()) != null) {
/* 204 */                       OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), "UTF8");
/*     */                       try {
/* 206 */                         outputStreamWriter.write(str);
/*     */                       } finally {
/* 208 */                         StreamUtils.closeQuietly(outputStreamWriter);
/*     */                       } 
/*     */                     } else {
/*     */                       InputStream inputStream;
/* 212 */                       if ((inputStream = httpRequest.getContentStream()) != null) {
/* 213 */                         OutputStream outputStream = connection.getOutputStream();
/*     */                         try {
/* 215 */                           StreamUtils.copyStream(inputStream, outputStream);
/*     */                         } finally {
/* 217 */                           StreamUtils.closeQuietly(outputStream);
/*     */                         } 
/*     */                       } 
/*     */                     } 
/*     */                   } 
/*     */                   
/* 223 */                   connection.connect();
/*     */                   
/* 225 */                   null = new NetJavaImpl.HttpClientResponse(connection);
/*     */                   
/*     */                   try {
/*     */                     Net.HttpResponseListener httpResponseListener;
/* 229 */                     if ((httpResponseListener = NetJavaImpl.this.getFromListeners(httpRequest)) != null) {
/* 230 */                       httpResponseListener.handleHttpResponse(null);
/*     */                     }
/*     */                   } finally {
/* 233 */                     NetJavaImpl.this.removeFromConnectionsAndListeners(httpRequest);
/* 234 */                     connection.disconnect();
/*     */                   } 
/* 236 */                 } catch (Exception null) {
/* 237 */                   connection.disconnect();
/*     */                   try {
/* 239 */                     httpResponseListener.failed(null); return;
/*     */                   } finally {
/* 241 */                     NetJavaImpl.this.removeFromConnectionsAndListeners(httpRequest);
/*     */                   } 
/*     */                 }  }
/*     */             }));
/*     */       return;
/* 246 */     } catch (Exception exception) {
/*     */       try {
/* 248 */         httpResponseListener.failed(exception); return;
/*     */       } finally {
/* 250 */         removeFromConnectionsAndListeners(httpRequest);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelHttpRequest(Net.HttpRequest paramHttpRequest) {
/*     */     Net.HttpResponseListener httpResponseListener;
/* 259 */     if ((httpResponseListener = getFromListeners(paramHttpRequest)) != null) {
/* 260 */       httpResponseListener.cancelled();
/* 261 */       cancelTask(paramHttpRequest);
/* 262 */       removeFromConnectionsAndListeners(paramHttpRequest);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isHttpRequestPending(Net.HttpRequest paramHttpRequest) {
/* 267 */     return (getFromListeners(paramHttpRequest) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   private void cancelTask(Net.HttpRequest paramHttpRequest) {
/*     */     Future future;
/* 273 */     if ((future = (Future)this.tasks.get(paramHttpRequest)) != null) {
/* 274 */       future.cancel(false);
/*     */     }
/*     */   }
/*     */   
/*     */   synchronized void removeFromConnectionsAndListeners(Net.HttpRequest paramHttpRequest) {
/* 279 */     this.connections.remove(paramHttpRequest);
/* 280 */     this.listeners.remove(paramHttpRequest);
/* 281 */     this.tasks.remove(paramHttpRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   synchronized void putIntoConnectionsAndListeners(Net.HttpRequest paramHttpRequest, Net.HttpResponseListener paramHttpResponseListener, HttpURLConnection paramHttpURLConnection) {
/* 286 */     this.connections.put(paramHttpRequest, paramHttpURLConnection);
/* 287 */     this.listeners.put(paramHttpRequest, paramHttpResponseListener);
/*     */   }
/*     */   
/*     */   synchronized Net.HttpResponseListener getFromListeners(Net.HttpRequest paramHttpRequest) {
/*     */     Net.HttpResponseListener httpResponseListener;
/* 292 */     return httpResponseListener = (Net.HttpResponseListener)this.listeners.get(paramHttpRequest);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\NetJavaImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */