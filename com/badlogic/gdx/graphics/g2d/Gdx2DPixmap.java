/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
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
/*     */ public class Gdx2DPixmap
/*     */   implements Disposable
/*     */ {
/*     */   public static final int GDX2D_FORMAT_ALPHA = 1;
/*     */   public static final int GDX2D_FORMAT_LUMINANCE_ALPHA = 2;
/*     */   public static final int GDX2D_FORMAT_RGB888 = 3;
/*     */   public static final int GDX2D_FORMAT_RGBA8888 = 4;
/*     */   public static final int GDX2D_FORMAT_RGB565 = 5;
/*     */   public static final int GDX2D_FORMAT_RGBA4444 = 6;
/*     */   public static final int GDX2D_SCALE_NEAREST = 0;
/*     */   public static final int GDX2D_SCALE_LINEAR = 1;
/*     */   public static final int GDX2D_BLEND_NONE = 0;
/*     */   public static final int GDX2D_BLEND_SRC_OVER = 1;
/*     */   long basePtr;
/*     */   int width;
/*     */   int height;
/*     */   int format;
/*     */   ByteBuffer pixelPtr;
/*     */   
/*     */   public static int toGlFormat(int paramInt) {
/*  44 */     switch (paramInt) {
/*     */       case 1:
/*  46 */         return 6406;
/*     */       case 2:
/*  48 */         return 6410;
/*     */       case 3:
/*     */       case 5:
/*  51 */         return 6407;
/*     */       case 4:
/*     */       case 6:
/*  54 */         return 6408;
/*     */     } 
/*  56 */     throw new GdxRuntimeException("unknown format: " + paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int toGlType(int paramInt) {
/*  61 */     switch (paramInt) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*  66 */         return 5121;
/*     */       case 5:
/*  68 */         return 33635;
/*     */       case 6:
/*  70 */         return 32819;
/*     */     } 
/*  72 */     throw new GdxRuntimeException("unknown format: " + paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   long[] nativeData = new long[4];
/*     */   
/*     */   public Gdx2DPixmap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/*  84 */     this.pixelPtr = load(this.nativeData, paramArrayOfbyte, paramInt1, paramInt2);
/*  85 */     if (this.pixelPtr == null) throw new IOException("Error loading pixmap: " + getFailureReason());
/*     */     
/*  87 */     this.basePtr = this.nativeData[0];
/*  88 */     this.width = (int)this.nativeData[1];
/*  89 */     this.height = (int)this.nativeData[2];
/*  90 */     this.format = (int)this.nativeData[3];
/*     */     
/*  92 */     if (paramInt3 != 0 && paramInt3 != this.format) {
/*  93 */       convert(paramInt3);
/*     */     }
/*     */   }
/*     */   
/*     */   public Gdx2DPixmap(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3) {
/*  98 */     if (!paramByteBuffer.isDirect()) throw new IOException("Couldn't load pixmap from non-direct ByteBuffer"); 
/*  99 */     this.pixelPtr = loadByteBuffer(this.nativeData, paramByteBuffer, paramInt1, paramInt2);
/* 100 */     if (this.pixelPtr == null) throw new IOException("Error loading pixmap: " + getFailureReason());
/*     */     
/* 102 */     this.basePtr = this.nativeData[0];
/* 103 */     this.width = (int)this.nativeData[1];
/* 104 */     this.height = (int)this.nativeData[2];
/* 105 */     this.format = (int)this.nativeData[3];
/*     */     
/* 107 */     if (paramInt3 != 0 && paramInt3 != this.format) {
/* 108 */       convert(paramInt3);
/*     */     }
/*     */   }
/*     */   
/*     */   public Gdx2DPixmap(InputStream paramInputStream, int paramInt) {
/* 113 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
/* 114 */     byte[] arrayOfByte = new byte[1024];
/*     */     
/*     */     int i;
/* 117 */     while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/* 118 */       byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */     }
/*     */     
/* 121 */     arrayOfByte = byteArrayOutputStream.toByteArray();
/* 122 */     this.pixelPtr = load(this.nativeData, arrayOfByte, 0, arrayOfByte.length);
/* 123 */     if (this.pixelPtr == null) throw new IOException("Error loading pixmap: " + getFailureReason());
/*     */     
/* 125 */     this.basePtr = this.nativeData[0];
/* 126 */     this.width = (int)this.nativeData[1];
/* 127 */     this.height = (int)this.nativeData[2];
/* 128 */     this.format = (int)this.nativeData[3];
/*     */     
/* 130 */     if (paramInt != 0 && paramInt != this.format) {
/* 131 */       convert(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Gdx2DPixmap(int paramInt1, int paramInt2, int paramInt3) {
/* 137 */     this.pixelPtr = newPixmap(this.nativeData, paramInt1, paramInt2, paramInt3);
/* 138 */     if (this.pixelPtr == null) throw new GdxRuntimeException("Unable to allocate memory for pixmap: " + paramInt1 + "x" + paramInt2 + ", " + 
/* 139 */           getFormatString(paramInt3));
/*     */     
/* 141 */     this.basePtr = this.nativeData[0];
/* 142 */     this.width = (int)this.nativeData[1];
/* 143 */     this.height = (int)this.nativeData[2];
/* 144 */     this.format = (int)this.nativeData[3];
/*     */   }
/*     */   
/*     */   public Gdx2DPixmap(ByteBuffer paramByteBuffer, long[] paramArrayOflong) {
/* 148 */     this.pixelPtr = paramByteBuffer;
/* 149 */     this.basePtr = paramArrayOflong[0];
/* 150 */     this.width = (int)paramArrayOflong[1];
/* 151 */     this.height = (int)paramArrayOflong[2];
/* 152 */     this.format = (int)paramArrayOflong[3];
/*     */   }
/*     */   
/*     */   private void convert(int paramInt) {
/*     */     Gdx2DPixmap gdx2DPixmap;
/* 157 */     (gdx2DPixmap = new Gdx2DPixmap(this.width, this.height, paramInt)).setBlend(0);
/* 158 */     gdx2DPixmap.drawPixmap(this, 0, 0, 0, 0, this.width, this.height);
/* 159 */     dispose();
/* 160 */     this.basePtr = gdx2DPixmap.basePtr;
/* 161 */     this.format = gdx2DPixmap.format;
/* 162 */     this.height = gdx2DPixmap.height;
/* 163 */     this.nativeData = gdx2DPixmap.nativeData;
/* 164 */     this.pixelPtr = gdx2DPixmap.pixelPtr;
/* 165 */     this.width = gdx2DPixmap.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 170 */     free(this.basePtr);
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 174 */     clear(this.basePtr, paramInt);
/*     */   }
/*     */   
/*     */   public void setPixel(int paramInt1, int paramInt2, int paramInt3) {
/* 178 */     setPixel(this.basePtr, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public int getPixel(int paramInt1, int paramInt2) {
/* 182 */     return getPixel(this.basePtr, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 186 */     drawLine(this.basePtr, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */   
/*     */   public void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 190 */     drawRect(this.basePtr, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */   
/*     */   public void drawCircle(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 194 */     drawCircle(this.basePtr, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void fillRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 198 */     fillRect(this.basePtr, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */   
/*     */   public void fillCircle(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 202 */     fillCircle(this.basePtr, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void fillTriangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 206 */     fillTriangle(this.basePtr, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
/*     */   }
/*     */   
/*     */   public void drawPixmap(Gdx2DPixmap paramGdx2DPixmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 210 */     drawPixmap(paramGdx2DPixmap.basePtr, this.basePtr, paramInt1, paramInt2, paramInt5, paramInt6, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPixmap(Gdx2DPixmap paramGdx2DPixmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/* 215 */     drawPixmap(paramGdx2DPixmap.basePtr, this.basePtr, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*     */   }
/*     */   
/*     */   public void setBlend(int paramInt) {
/* 219 */     setBlend(this.basePtr, paramInt);
/*     */   }
/*     */   
/*     */   public void setScale(int paramInt) {
/* 223 */     setScale(this.basePtr, paramInt);
/*     */   }
/*     */   
/*     */   public static Gdx2DPixmap newPixmap(InputStream paramInputStream, int paramInt) {
/*     */     try {
/* 228 */       return new Gdx2DPixmap(paramInputStream, paramInt);
/* 229 */     } catch (IOException iOException) {
/* 230 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Gdx2DPixmap newPixmap(int paramInt1, int paramInt2, int paramInt3) {
/*     */     try {
/* 236 */       return new Gdx2DPixmap(paramInt1, paramInt2, paramInt3);
/* 237 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 238 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public ByteBuffer getPixels() {
/* 243 */     return this.pixelPtr;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 247 */     return this.height;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 251 */     return this.width;
/*     */   }
/*     */   
/*     */   public int getFormat() {
/* 255 */     return this.format;
/*     */   }
/*     */   
/*     */   public int getGLInternalFormat() {
/* 259 */     return toGlFormat(this.format);
/*     */   }
/*     */   
/*     */   public int getGLFormat() {
/* 263 */     return getGLInternalFormat();
/*     */   }
/*     */   
/*     */   public int getGLType() {
/* 267 */     return toGlType(this.format);
/*     */   }
/*     */   
/*     */   public String getFormatString() {
/* 271 */     return getFormatString(this.format);
/*     */   }
/*     */   
/*     */   private static String getFormatString(int paramInt) {
/* 275 */     switch (paramInt) {
/*     */       case 1:
/* 277 */         return "alpha";
/*     */       case 2:
/* 279 */         return "luminance alpha";
/*     */       case 3:
/* 281 */         return "rgb888";
/*     */       case 4:
/* 283 */         return "rgba8888";
/*     */       case 5:
/* 285 */         return "rgb565";
/*     */       case 6:
/* 287 */         return "rgba4444";
/*     */     } 
/* 289 */     return "unknown";
/*     */   }
/*     */   
/*     */   private static native ByteBuffer load(long[] paramArrayOflong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
/*     */   
/*     */   private static native ByteBuffer loadByteBuffer(long[] paramArrayOflong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
/*     */   
/*     */   private static native ByteBuffer newPixmap(long[] paramArrayOflong, int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void free(long paramLong);
/*     */   
/*     */   private static native void clear(long paramLong, int paramInt);
/*     */   
/*     */   private static native void setPixel(long paramLong, int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native int getPixel(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   private static native void drawLine(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */   
/*     */   private static native void drawRect(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */   
/*     */   private static native void drawCircle(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   private static native void fillRect(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */   
/*     */   private static native void fillCircle(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   private static native void fillTriangle(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
/*     */   
/*     */   private static native void drawPixmap(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
/*     */   
/*     */   private static native void setBlend(long paramLong, int paramInt);
/*     */   
/*     */   private static native void setScale(long paramLong, int paramInt);
/*     */   
/*     */   public static native String getFailureReason();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\Gdx2DPixmap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */