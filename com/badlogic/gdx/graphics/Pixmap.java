/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Net;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
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
/*     */ public class Pixmap
/*     */   implements Disposable
/*     */ {
/*     */   public enum Format
/*     */   {
/*  48 */     Alpha, Intensity, LuminanceAlpha, RGB565, RGBA4444, RGB888, RGBA8888;
/*     */     
/*     */     public static int toGdx2DPixmapFormat(Format param1Format) {
/*  51 */       if (param1Format == Alpha) return 1; 
/*  52 */       if (param1Format == Intensity) return 1; 
/*  53 */       if (param1Format == LuminanceAlpha) return 2; 
/*  54 */       if (param1Format == RGB565) return 5; 
/*  55 */       if (param1Format == RGBA4444) return 6; 
/*  56 */       if (param1Format == RGB888) return 3; 
/*  57 */       if (param1Format == RGBA8888) return 4; 
/*  58 */       throw new GdxRuntimeException("Unknown Format: " + param1Format);
/*     */     }
/*     */     
/*     */     public static Format fromGdx2DPixmapFormat(int param1Int) {
/*  62 */       if (param1Int == 1) return Alpha; 
/*  63 */       if (param1Int == 2) return LuminanceAlpha; 
/*  64 */       if (param1Int == 5) return RGB565; 
/*  65 */       if (param1Int == 6) return RGBA4444; 
/*  66 */       if (param1Int == 3) return RGB888; 
/*  67 */       if (param1Int == 4) return RGBA8888; 
/*  68 */       throw new GdxRuntimeException("Unknown Gdx2DPixmap Format: " + param1Int);
/*     */     }
/*     */     
/*     */     public static int toGlFormat(Format param1Format) {
/*  72 */       return Gdx2DPixmap.toGlFormat(toGdx2DPixmapFormat(param1Format));
/*     */     }
/*     */     
/*     */     public static int toGlType(Format param1Format) {
/*  76 */       return Gdx2DPixmap.toGlType(toGdx2DPixmapFormat(param1Format));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public enum Blending
/*     */   {
/*  83 */     None, SourceOver;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Filter
/*     */   {
/*  90 */     NearestNeighbour, BiLinear;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pixmap createFromFrameBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 100 */     Gdx.gl.glPixelStorei(3333, 1);
/*     */     
/*     */     Pixmap pixmap;
/* 103 */     ByteBuffer byteBuffer = (pixmap = new Pixmap(paramInt3, paramInt4, Format.RGBA8888)).getPixels();
/* 104 */     Gdx.gl.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, byteBuffer);
/*     */     
/* 106 */     return pixmap;
/*     */   }
/*     */   
/* 109 */   private Blending blending = Blending.SourceOver;
/* 110 */   private Filter filter = Filter.BiLinear;
/*     */   
/*     */   final Gdx2DPixmap pixmap;
/* 113 */   int color = 0;
/*     */ 
/*     */   
/*     */   private boolean disposed;
/*     */ 
/*     */   
/*     */   public void setBlending(Blending paramBlending) {
/* 120 */     this.blending = paramBlending;
/* 121 */     this.pixmap.setBlend((paramBlending == Blending.None) ? 0 : 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilter(Filter paramFilter) {
/* 128 */     this.filter = paramFilter;
/* 129 */     this.pixmap.setScale((paramFilter == Filter.NearestNeighbour) ? 0 : 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pixmap(int paramInt1, int paramInt2, Format paramFormat) {
/* 137 */     this.pixmap = new Gdx2DPixmap(paramInt1, paramInt2, Format.toGdx2DPixmapFormat(paramFormat));
/* 138 */     setColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 139 */     fill();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pixmap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     try {
/* 150 */       this.pixmap = new Gdx2DPixmap(paramArrayOfbyte, paramInt1, paramInt2, 0); return;
/* 151 */     } catch (IOException iOException) {
/* 152 */       throw new GdxRuntimeException("Couldn't load pixmap from image data", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pixmap(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 163 */     if (!paramByteBuffer.isDirect()) throw new GdxRuntimeException("Couldn't load pixmap from non-direct ByteBuffer"); 
/*     */     try {
/* 165 */       this.pixmap = new Gdx2DPixmap(paramByteBuffer, paramInt1, paramInt2, 0); return;
/* 166 */     } catch (IOException iOException) {
/* 167 */       throw new GdxRuntimeException("Couldn't load pixmap from image data", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pixmap(ByteBuffer paramByteBuffer) {
/* 178 */     this(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pixmap(FileHandle paramFileHandle) {
/*     */     try {
/* 187 */       byte[] arrayOfByte = paramFileHandle.readBytes();
/* 188 */       this.pixmap = new Gdx2DPixmap(arrayOfByte, 0, arrayOfByte.length, 0); return;
/* 189 */     } catch (Exception exception) {
/* 190 */       throw new GdxRuntimeException("Couldn't load file: " + paramFileHandle, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pixmap(Gdx2DPixmap paramGdx2DPixmap) {
/* 197 */     this.pixmap = paramGdx2DPixmap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void downloadFromUrl(String paramString, final DownloadPixmapResponseListener responseListener) {
/*     */     Net.HttpRequest httpRequest;
/* 207 */     (httpRequest = new Net.HttpRequest("GET")).setUrl(paramString);
/* 208 */     Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener()
/*     */         {
/*     */           public void handleHttpResponse(Net.HttpResponse param1HttpResponse) {
/* 211 */             final byte[] result = param1HttpResponse.getResult();
/* 212 */             Gdx.app.postRunnable(new Runnable()
/*     */                 {
/*     */                   public void run() {
/*     */                     try {
/* 216 */                       Pixmap pixmap = new Pixmap(result, 0, result.length);
/* 217 */                       responseListener.downloadComplete(pixmap); return;
/* 218 */                     } catch (Throwable throwable) {
/* 219 */                       Pixmap.null.this.failed(throwable);
/*     */                       return;
/*     */                     } 
/*     */                   }
/*     */                 });
/*     */           }
/*     */           
/*     */           public void failed(Throwable param1Throwable) {
/* 227 */             responseListener.downloadFailed(param1Throwable);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void cancelled() {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(int paramInt) {
/* 240 */     this.color = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 250 */     this.color = Color.rgba8888(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 256 */     this.color = Color.rgba8888(paramColor.r, paramColor.g, paramColor.b, paramColor.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill() {
/* 261 */     this.pixmap.clear(this.color);
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
/*     */   public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 278 */     this.pixmap.drawLine(paramInt1, paramInt2, paramInt3, paramInt4, this.color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawRectangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 289 */     this.pixmap.drawRect(paramInt1, paramInt2, paramInt3, paramInt4, this.color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawPixmap(Pixmap paramPixmap, int paramInt1, int paramInt2) {
/* 298 */     drawPixmap(paramPixmap, paramInt1, paramInt2, 0, 0, paramPixmap.getWidth(), paramPixmap.getHeight());
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
/*     */   public void drawPixmap(Pixmap paramPixmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 311 */     this.pixmap.drawPixmap(paramPixmap.pixmap, paramInt3, paramInt4, paramInt1, paramInt2, paramInt5, paramInt6);
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
/*     */   public void drawPixmap(Pixmap paramPixmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/* 329 */     this.pixmap.drawPixmap(paramPixmap.pixmap, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillRectangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 340 */     this.pixmap.fillRect(paramInt1, paramInt2, paramInt3, paramInt4, this.color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawCircle(int paramInt1, int paramInt2, int paramInt3) {
/* 349 */     this.pixmap.drawCircle(paramInt1, paramInt2, paramInt3, this.color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillCircle(int paramInt1, int paramInt2, int paramInt3) {
/* 358 */     this.pixmap.fillCircle(paramInt1, paramInt2, paramInt3, this.color);
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
/*     */   public void fillTriangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 370 */     this.pixmap.fillTriangle(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, this.color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPixel(int paramInt1, int paramInt2) {
/* 379 */     return this.pixmap.getPixel(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 384 */     return this.pixmap.getWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 389 */     return this.pixmap.getHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 394 */     if (this.disposed) {
/* 395 */       Gdx.app.error("Pixmap", "Pixmap already disposed!");
/*     */       return;
/*     */     } 
/* 398 */     this.pixmap.dispose();
/* 399 */     this.disposed = true;
/*     */   }
/*     */   
/*     */   public boolean isDisposed() {
/* 403 */     return this.disposed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawPixel(int paramInt1, int paramInt2) {
/* 411 */     this.pixmap.setPixel(paramInt1, paramInt2, this.color);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawPixel(int paramInt1, int paramInt2, int paramInt3) {
/* 420 */     this.pixmap.setPixel(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGLFormat() {
/* 427 */     return this.pixmap.getGLFormat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGLInternalFormat() {
/* 434 */     return this.pixmap.getGLInternalFormat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGLType() {
/* 441 */     return this.pixmap.getGLType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer getPixels() {
/* 450 */     if (this.disposed) throw new GdxRuntimeException("Pixmap already disposed"); 
/* 451 */     return this.pixmap.getPixels();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPixels(ByteBuffer paramByteBuffer) {
/* 457 */     if (!paramByteBuffer.isDirect()) throw new GdxRuntimeException("Couldn't setPixels from non-direct ByteBuffer"); 
/* 458 */     ByteBuffer byteBuffer = this.pixmap.getPixels();
/* 459 */     BufferUtils.copy(paramByteBuffer, byteBuffer, byteBuffer.limit());
/*     */   }
/*     */ 
/*     */   
/*     */   public Format getFormat() {
/* 464 */     return Format.fromGdx2DPixmapFormat(this.pixmap.getFormat());
/*     */   }
/*     */ 
/*     */   
/*     */   public Blending getBlending() {
/* 469 */     return this.blending;
/*     */   }
/*     */ 
/*     */   
/*     */   public Filter getFilter() {
/* 474 */     return this.filter;
/*     */   }
/*     */   
/*     */   public static interface DownloadPixmapResponseListener {
/*     */     void downloadComplete(Pixmap param1Pixmap);
/*     */     
/*     */     void downloadFailed(Throwable param1Throwable);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Pixmap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */