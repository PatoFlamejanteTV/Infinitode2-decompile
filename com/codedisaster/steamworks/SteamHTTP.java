/*     */ package com.codedisaster.steamworks;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ public class SteamHTTP extends SteamInterface {
/*     */   private final boolean isServer;
/*     */   
/*     */   public enum HTTPMethod {
/*   9 */     Invalid,
/*  10 */     GET,
/*  11 */     HEAD,
/*  12 */     POST,
/*  13 */     PUT,
/*  14 */     DELETE,
/*  15 */     OPTIONS;
/*     */   }
/*     */   
/*     */   public enum HTTPStatusCode {
/*  19 */     Invalid(0),
/*     */     
/*  21 */     Continue(100),
/*  22 */     SwitchingProtocols(101),
/*     */     
/*  24 */     OK(200),
/*  25 */     Created(201),
/*  26 */     Accepted(202),
/*  27 */     NonAuthoritative(203),
/*  28 */     NoContent(204),
/*  29 */     ResetContent(205),
/*  30 */     PartialContent(206),
/*     */     
/*  32 */     MultipleChoices(300),
/*  33 */     MovedPermanently(301),
/*  34 */     Found(302),
/*  35 */     SeeOther(303),
/*  36 */     NotModified(304),
/*  37 */     UseProxy(305),
/*  38 */     TemporaryRedirect(307),
/*     */     
/*  40 */     BadRequest(400),
/*  41 */     Unauthorized(401),
/*  42 */     PaymentRequired(402),
/*  43 */     Forbidden(403),
/*  44 */     NotFound(404),
/*  45 */     MethodNotAllowed(405),
/*  46 */     NotAcceptable(406),
/*  47 */     ProxyAuthRequired(407),
/*  48 */     RequestTimeout(408),
/*  49 */     Conflict(409),
/*  50 */     Gone(410),
/*  51 */     LengthRequired(411),
/*  52 */     PreconditionFailed(412),
/*  53 */     RequestEntityTooLarge(413),
/*  54 */     RequestURITooLong(414),
/*  55 */     UnsupportedMediaType(415),
/*  56 */     RequestedRangeNotSatisfiable(416),
/*  57 */     ExpectationFailed(417),
/*  58 */     Unknown4xx(418),
/*  59 */     TooManyRequests(429),
/*     */     
/*  61 */     InternalServerError(500),
/*  62 */     NotImplemented(501),
/*  63 */     BadGateway(502),
/*  64 */     ServiceUnavailable(503),
/*  65 */     GatewayTimeout(504),
/*  66 */     HTTPVersionNotSupported(505),
/*  67 */     Unknown5xx(599);
/*     */     
/*     */     private final int code;
/*  70 */     private static final HTTPStatusCode[] values = values();
/*     */     
/*     */     HTTPStatusCode(int param1Int1) {
/*  73 */       this.code = param1Int1;
/*     */     }
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */     
/*     */     static HTTPStatusCode byValue(int param1Int) {
/*  82 */       int i = 0;
/*  83 */       int j = values.length - 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  89 */       while (i <= j) {
/*  90 */         int k = (i + j) / 2;
/*  91 */         HTTPStatusCode hTTPStatusCode = values[k];
/*  92 */         if (param1Int < hTTPStatusCode.code) {
/*  93 */           j = k - 1; continue;
/*  94 */         }  if (param1Int > hTTPStatusCode.code) {
/*  95 */           i = k + 1; continue;
/*     */         } 
/*  97 */         return hTTPStatusCode;
/*     */       } 
/*     */ 
/*     */       
/* 101 */       return Invalid;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteamHTTP(SteamHTTPCallback paramSteamHTTPCallback) {
/* 108 */     this(false, SteamHTTPNative.createCallback(new SteamHTTPCallbackAdapter(paramSteamHTTPCallback)));
/*     */   }
/*     */   
/*     */   SteamHTTP(boolean paramBoolean, long paramLong) {
/* 112 */     super(paramLong);
/* 113 */     this.isServer = paramBoolean;
/*     */   }
/*     */   
/*     */   public SteamHTTPRequestHandle createHTTPRequest(HTTPMethod paramHTTPMethod, String paramString) {
/* 117 */     return new SteamHTTPRequestHandle(SteamHTTPNative.createHTTPRequest(this.isServer, paramHTTPMethod.ordinal(), paramString));
/*     */   }
/*     */   
/*     */   public boolean setHTTPRequestContextValue(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, long paramLong) {
/* 121 */     return SteamHTTPNative.setHTTPRequestContextValue(this.isServer, paramSteamHTTPRequestHandle.handle, paramLong);
/*     */   }
/*     */   
/*     */   public boolean setHTTPRequestNetworkActivityTimeout(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, int paramInt) {
/* 125 */     return SteamHTTPNative.setHTTPRequestNetworkActivityTimeout(this.isServer, paramSteamHTTPRequestHandle.handle, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHTTPRequestHeaderValue(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, String paramString1, String paramString2) {
/* 131 */     return SteamHTTPNative.setHTTPRequestHeaderValue(this.isServer, paramSteamHTTPRequestHandle.handle, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setHTTPRequestGetOrPostParameter(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, String paramString1, String paramString2) {
/* 137 */     return SteamHTTPNative.setHTTPRequestGetOrPostParameter(this.isServer, paramSteamHTTPRequestHandle.handle, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public SteamAPICall sendHTTPRequest(SteamHTTPRequestHandle paramSteamHTTPRequestHandle) {
/* 141 */     return new SteamAPICall(SteamHTTPNative.sendHTTPRequest(this.isServer, this.callback, paramSteamHTTPRequestHandle.handle));
/*     */   }
/*     */   
/*     */   public SteamAPICall sendHTTPRequestAndStreamResponse(SteamHTTPRequestHandle paramSteamHTTPRequestHandle) {
/* 145 */     return new SteamAPICall(SteamHTTPNative.sendHTTPRequestAndStreamResponse(this.isServer, paramSteamHTTPRequestHandle.handle));
/*     */   }
/*     */   
/*     */   public int getHTTPResponseHeaderSize(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, String paramString) {
/* 149 */     return SteamHTTPNative.getHTTPResponseHeaderSize(this.isServer, paramSteamHTTPRequestHandle.handle, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHTTPResponseHeaderValue(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, String paramString, ByteBuffer paramByteBuffer) {
/* 155 */     if (!paramByteBuffer.isDirect()) {
/* 156 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/* 159 */     return SteamHTTPNative.getHTTPResponseHeaderValue(this.isServer, paramSteamHTTPRequestHandle.handle, paramString, paramByteBuffer, paramByteBuffer
/* 160 */         .position(), paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public int getHTTPResponseBodySize(SteamHTTPRequestHandle paramSteamHTTPRequestHandle) {
/* 164 */     return SteamHTTPNative.getHTTPResponseBodySize(this.isServer, paramSteamHTTPRequestHandle.handle);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getHTTPResponseBodyData(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, ByteBuffer paramByteBuffer) {
/* 169 */     if (!paramByteBuffer.isDirect()) {
/* 170 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/* 173 */     return SteamHTTPNative.getHTTPResponseBodyData(this.isServer, paramSteamHTTPRequestHandle.handle, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHTTPStreamingResponseBodyData(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, int paramInt, ByteBuffer paramByteBuffer) {
/* 179 */     if (!paramByteBuffer.isDirect()) {
/* 180 */       throw new SteamException("Direct buffer required!");
/*     */     }
/*     */     
/* 183 */     return SteamHTTPNative.getHTTPStreamingResponseBodyData(this.isServer, paramSteamHTTPRequestHandle.handle, paramInt, paramByteBuffer, paramByteBuffer
/* 184 */         .position(), paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public boolean releaseHTTPRequest(SteamHTTPRequestHandle paramSteamHTTPRequestHandle) {
/* 188 */     return SteamHTTPNative.releaseHTTPRequest(this.isServer, paramSteamHTTPRequestHandle.handle);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamHTTP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */