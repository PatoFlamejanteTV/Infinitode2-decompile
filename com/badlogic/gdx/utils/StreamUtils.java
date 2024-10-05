/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.StringWriter;
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
/*     */ public final class StreamUtils
/*     */ {
/*     */   public static final int DEFAULT_BUFFER_SIZE = 4096;
/*  32 */   public static final byte[] EMPTY_BYTES = new byte[0];
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream) {
/*  37 */     copyStream(paramInputStream, paramOutputStream, new byte[4096]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt) {
/*  43 */     copyStream(paramInputStream, paramOutputStream, new byte[paramInt]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfbyte) {
/*     */     int i;
/*  50 */     while ((i = paramInputStream.read(paramArrayOfbyte)) != -1) {
/*  51 */       paramOutputStream.write(paramArrayOfbyte, 0, i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyStream(InputStream paramInputStream, ByteBuffer paramByteBuffer) {
/*  58 */     copyStream(paramInputStream, paramByteBuffer, new byte[4096]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copyStream(InputStream paramInputStream, ByteBuffer paramByteBuffer, int paramInt) {
/*  64 */     copyStream(paramInputStream, paramByteBuffer, new byte[paramInt]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int copyStream(InputStream paramInputStream, ByteBuffer paramByteBuffer, byte[] paramArrayOfbyte) {
/*  73 */     int i = paramByteBuffer.position(), j = 0; int k;
/*  74 */     while ((k = paramInputStream.read(paramArrayOfbyte)) != -1) {
/*  75 */       BufferUtils.copy(paramArrayOfbyte, 0, paramByteBuffer, k);
/*  76 */       j += k;
/*  77 */       paramByteBuffer.position(i + j);
/*     */     } 
/*  79 */     paramByteBuffer.position(i);
/*  80 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] copyStreamToByteArray(InputStream paramInputStream) {
/*  85 */     return copyStreamToByteArray(paramInputStream, paramInputStream.available());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] copyStreamToByteArray(InputStream paramInputStream, int paramInt) {
/*  91 */     OptimizedByteArrayOutputStream optimizedByteArrayOutputStream = new OptimizedByteArrayOutputStream(Math.max(0, paramInt));
/*  92 */     copyStream(paramInputStream, optimizedByteArrayOutputStream);
/*  93 */     return optimizedByteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String copyStreamToString(InputStream paramInputStream) {
/*  99 */     return copyStreamToString(paramInputStream, paramInputStream.available(), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String copyStreamToString(InputStream paramInputStream, int paramInt) {
/* 104 */     return copyStreamToString(paramInputStream, paramInt, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String copyStreamToString(InputStream paramInputStream, int paramInt, @Null String paramString) {
/* 111 */     InputStreamReader inputStreamReader = (paramString == null) ? new InputStreamReader(paramInputStream) : new InputStreamReader(paramInputStream, paramString);
/* 112 */     StringWriter stringWriter = new StringWriter(Math.max(0, paramInt));
/* 113 */     char[] arrayOfChar = new char[4096];
/*     */     int i;
/* 115 */     while ((i = inputStreamReader.read(arrayOfChar)) != -1) {
/* 116 */       stringWriter.write(arrayOfChar, 0, i);
/*     */     }
/* 118 */     return stringWriter.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void closeQuietly(Closeable paramCloseable) {
/* 123 */     if (paramCloseable != null) {
/*     */       try {
/* 125 */         paramCloseable.close(); return;
/* 126 */       } catch (Throwable throwable) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public static class OptimizedByteArrayOutputStream
/*     */     extends ByteArrayOutputStream
/*     */   {
/*     */     public OptimizedByteArrayOutputStream(int param1Int) {
/* 134 */       super(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public synchronized byte[] toByteArray() {
/* 139 */       if (this.count == this.buf.length) return this.buf; 
/* 140 */       return super.toByteArray();
/*     */     }
/*     */     
/*     */     public byte[] getBuffer() {
/* 144 */       return this.buf;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\StreamUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */