/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.ByteArray;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.zip.CRC32;
/*     */ import java.util.zip.CheckedOutputStream;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.DeflaterOutputStream;
/*     */ import java.util.zip.InflaterInputStream;
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
/*     */ public class PixmapIO
/*     */ {
/*     */   public static void writeCIM(FileHandle paramFileHandle, Pixmap paramPixmap) {
/*  49 */     CIM.write(paramFileHandle, paramPixmap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pixmap readCIM(FileHandle paramFileHandle) {
/*  56 */     return CIM.read(paramFileHandle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writePNG(FileHandle paramFileHandle, Pixmap paramPixmap, int paramInt, boolean paramBoolean) {
/*     */     try {
/*  64 */       PNG pNG = new PNG((int)((paramPixmap.getWidth() * paramPixmap.getHeight()) * 1.5F));
/*     */       try {
/*  66 */         pNG.setFlipY(paramBoolean);
/*  67 */         pNG.setCompression(paramInt);
/*  68 */         pNG.write(paramFileHandle, paramPixmap);
/*     */       } finally {
/*  70 */         pNG.dispose();
/*     */       } 
/*  72 */     } catch (IOException iOException) {
/*  73 */       throw new GdxRuntimeException("Error writing PNG: " + paramFileHandle, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writePNG(FileHandle paramFileHandle, Pixmap paramPixmap) {
/*  80 */     writePNG(paramFileHandle, paramPixmap, -1, false);
/*     */   }
/*     */   
/*     */   private static class CIM
/*     */   {
/*     */     private static final int BUFFER_SIZE = 32000;
/*  86 */     private static final byte[] writeBuffer = new byte[32000];
/*  87 */     private static final byte[] readBuffer = new byte[32000];
/*     */     
/*     */     public static void write(FileHandle param1FileHandle, Pixmap param1Pixmap) {
/*  90 */       DataOutputStream dataOutputStream = null;
/*     */       
/*     */       try {
/*  93 */         DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(param1FileHandle.write(false));
/*     */         
/*  95 */         (dataOutputStream = new DataOutputStream(deflaterOutputStream)).writeInt(param1Pixmap.getWidth());
/*  96 */         dataOutputStream.writeInt(param1Pixmap.getHeight());
/*  97 */         dataOutputStream.writeInt(Pixmap.Format.toGdx2DPixmapFormat(param1Pixmap.getFormat()));
/*     */ 
/*     */         
/* 100 */         (null = param1Pixmap.getPixels()).position(0);
/* 101 */         null.limit(null.capacity());
/*     */         
/* 103 */         int i = null.capacity() % 32000;
/* 104 */         int j = null.capacity() / 32000;
/*     */         
/* 106 */         synchronized (writeBuffer) {
/* 107 */           for (byte b = 0; b < j; b++) {
/* 108 */             null.get(writeBuffer);
/* 109 */             dataOutputStream.write(writeBuffer);
/*     */           } 
/*     */           
/* 112 */           null.get(writeBuffer, 0, i);
/* 113 */           dataOutputStream.write(writeBuffer, 0, i);
/*     */         } 
/*     */         
/* 116 */         param1Pixmap.position(0);
/* 117 */         param1Pixmap.limit(param1Pixmap.capacity()); return;
/* 118 */       } catch (Exception exception) {
/* 119 */         throw new GdxRuntimeException("Couldn't write Pixmap to file '" + param1FileHandle + "'", exception);
/*     */       } finally {
/* 121 */         StreamUtils.closeQuietly(dataOutputStream);
/*     */       } 
/*     */     }
/*     */     
/*     */     public static Pixmap read(FileHandle param1FileHandle) {
/* 126 */       DataInputStream dataInputStream = null;
/*     */ 
/*     */       
/*     */       try {
/* 130 */         int i = (dataInputStream = new DataInputStream(new InflaterInputStream(new BufferedInputStream(param1FileHandle.read())))).readInt();
/* 131 */         int j = dataInputStream.readInt();
/* 132 */         Pixmap.Format format = Pixmap.Format.fromGdx2DPixmapFormat(dataInputStream.readInt());
/*     */         
/*     */         ByteBuffer byteBuffer;
/*     */         
/* 136 */         (byteBuffer = (null = new Pixmap(i, j, format)).getPixels()).position(0);
/* 137 */         byteBuffer.limit(byteBuffer.capacity());
/*     */         
/* 139 */         synchronized (readBuffer) {
/*     */           int k;
/* 141 */           while ((k = dataInputStream.read(readBuffer)) > 0) {
/* 142 */             byteBuffer.put(readBuffer, 0, k);
/*     */           }
/*     */         } 
/*     */         
/* 146 */         byteBuffer.position(0);
/* 147 */         byteBuffer.limit(byteBuffer.capacity());
/* 148 */         return i;
/* 149 */       } catch (Exception exception) {
/* 150 */         throw new GdxRuntimeException("Couldn't read Pixmap from file '" + param1FileHandle + "'", exception);
/*     */       } finally {
/* 152 */         StreamUtils.closeQuietly(dataInputStream);
/*     */       } 
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
/*     */   public static class PNG
/*     */     implements Disposable
/*     */   {
/* 185 */     private static final byte[] SIGNATURE = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
/*     */     
/*     */     private static final int IHDR = 1229472850;
/*     */     
/*     */     private static final int IDAT = 1229209940;
/*     */     
/*     */     private static final int IEND = 1229278788;
/*     */     
/*     */     private static final byte COLOR_ARGB = 6;
/*     */     
/*     */     private static final byte COMPRESSION_DEFLATE = 0;
/*     */     private static final byte FILTER_NONE = 0;
/*     */     private static final byte INTERLACE_NONE = 0;
/*     */     
/*     */     public PNG() {
/* 200 */       this(16384);
/*     */     }
/*     */     private static final byte PAETH = 4; private final ChunkBuffer buffer; private final Deflater deflater; private ByteArray lineOutBytes; private ByteArray curLineBytes; private ByteArray prevLineBytes; private boolean flipY = true; private int lastLineLen;
/*     */     public PNG(int param1Int) {
/* 204 */       this.buffer = new ChunkBuffer(param1Int);
/* 205 */       this.deflater = new Deflater();
/*     */     }
/*     */ 
/*     */     
/*     */     public void setFlipY(boolean param1Boolean) {
/* 210 */       this.flipY = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCompression(int param1Int) {
/* 215 */       this.deflater.setLevel(param1Int);
/*     */     }
/*     */     
/*     */     public void write(FileHandle param1FileHandle, Pixmap param1Pixmap) {
/* 219 */       OutputStream outputStream = param1FileHandle.write(false);
/*     */       try {
/* 221 */         write(outputStream, param1Pixmap); return;
/*     */       } finally {
/* 223 */         StreamUtils.closeQuietly(outputStream);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void write(OutputStream param1OutputStream, Pixmap param1Pixmap) {
/*     */       byte[] arrayOfByte1, arrayOfByte2, arrayOfByte3;
/* 229 */       DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(this.buffer, this.deflater);
/*     */       DataOutputStream dataOutputStream;
/* 231 */       (dataOutputStream = new DataOutputStream(param1OutputStream)).write(SIGNATURE);
/*     */       
/* 233 */       this.buffer.writeInt(1229472850);
/* 234 */       this.buffer.writeInt(param1Pixmap.getWidth());
/* 235 */       this.buffer.writeInt(param1Pixmap.getHeight());
/* 236 */       this.buffer.writeByte(8);
/* 237 */       this.buffer.writeByte(6);
/* 238 */       this.buffer.writeByte(0);
/* 239 */       this.buffer.writeByte(0);
/* 240 */       this.buffer.writeByte(0);
/* 241 */       this.buffer.endChunk(dataOutputStream);
/*     */       
/* 243 */       this.buffer.writeInt(1229209940);
/* 244 */       this.deflater.reset();
/*     */       
/* 246 */       int i = param1Pixmap.getWidth() << 2;
/*     */       
/* 248 */       if (this.lineOutBytes == null) {
/* 249 */         arrayOfByte1 = (this.lineOutBytes = new ByteArray(i)).items;
/* 250 */         arrayOfByte2 = (this.curLineBytes = new ByteArray(i)).items;
/* 251 */         arrayOfByte3 = (this.prevLineBytes = new ByteArray(i)).items;
/*     */       } else {
/* 253 */         arrayOfByte1 = this.lineOutBytes.ensureCapacity(i);
/* 254 */         arrayOfByte2 = this.curLineBytes.ensureCapacity(i);
/* 255 */         arrayOfByte3 = this.prevLineBytes.ensureCapacity(i); byte b1; int m;
/* 256 */         for (b1 = 0, m = this.lastLineLen; b1 < m; b1++)
/* 257 */           arrayOfByte3[b1] = 0; 
/*     */       } 
/* 259 */       this.lastLineLen = i;
/*     */       
/*     */       ByteBuffer byteBuffer;
/* 262 */       int j = (byteBuffer = param1Pixmap.getPixels()).position();
/* 263 */       boolean bool = (param1Pixmap.getFormat() == Pixmap.Format.RGBA8888) ? true : false; byte b; int k;
/* 264 */       for (b = 0, k = param1Pixmap.getHeight(); b < k; b++) {
/* 265 */         int m = this.flipY ? (k - b - 1) : b;
/* 266 */         if (bool) {
/* 267 */           byteBuffer.position(m * i);
/* 268 */           byteBuffer.get(arrayOfByte2, 0, i);
/*     */         } else {
/* 270 */           for (byte b2 = 0, b3 = 0; b2 < param1Pixmap.getWidth(); b2++) {
/* 271 */             int n = param1Pixmap.getPixel(b2, m);
/* 272 */             arrayOfByte2[b3++] = (byte)(n >>> 24);
/* 273 */             arrayOfByte2[b3++] = (byte)(n >> 16);
/* 274 */             arrayOfByte2[b3++] = (byte)(n >> 8);
/* 275 */             arrayOfByte2[b3++] = (byte)n;
/*     */           } 
/*     */         } 
/*     */         
/* 279 */         arrayOfByte1[0] = (byte)(arrayOfByte2[0] - arrayOfByte3[0]);
/* 280 */         arrayOfByte1[1] = (byte)(arrayOfByte2[1] - arrayOfByte3[1]);
/* 281 */         arrayOfByte1[2] = (byte)(arrayOfByte2[2] - arrayOfByte3[2]);
/* 282 */         arrayOfByte1[3] = (byte)(arrayOfByte2[3] - arrayOfByte3[3]);
/*     */         
/* 284 */         for (byte b1 = 4; b1 < i; b1++) {
/* 285 */           int n = arrayOfByte2[b1 - 4] & 0xFF;
/* 286 */           int i1 = arrayOfByte3[b1] & 0xFF;
/* 287 */           m = arrayOfByte3[b1 - 4] & 0xFF;
/*     */           
/*     */           int i2, i3;
/* 290 */           if ((i3 = (i2 = n + i1 - m) - n) < 0) i3 = -i3; 
/*     */           int i4;
/* 292 */           if ((i4 = i2 - i1) < 0) i4 = -i4;
/*     */           
/* 294 */           if ((i2 = i2 - m) < 0) i2 = -i2; 
/* 295 */           if (i3 <= i4 && i3 <= i2) {
/* 296 */             m = n;
/* 297 */           } else if (i4 <= i2) {
/* 298 */             m = i1;
/* 299 */           }  arrayOfByte1[b1] = (byte)(arrayOfByte2[b1] - m);
/*     */         } 
/*     */         
/* 302 */         deflaterOutputStream.write(4);
/* 303 */         deflaterOutputStream.write(arrayOfByte1, 0, i);
/*     */         
/* 305 */         byte[] arrayOfByte = arrayOfByte2;
/* 306 */         arrayOfByte2 = arrayOfByte3;
/* 307 */         arrayOfByte3 = arrayOfByte;
/*     */       } 
/* 309 */       byteBuffer.position(j);
/* 310 */       deflaterOutputStream.finish();
/* 311 */       this.buffer.endChunk(dataOutputStream);
/*     */       
/* 313 */       this.buffer.writeInt(1229278788);
/* 314 */       this.buffer.endChunk(dataOutputStream);
/*     */       
/* 316 */       param1OutputStream.flush();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void dispose() {
/* 322 */       this.deflater.end();
/*     */     }
/*     */     
/*     */     static class ChunkBuffer extends DataOutputStream {
/*     */       final ByteArrayOutputStream buffer;
/*     */       final CRC32 crc;
/*     */       
/*     */       ChunkBuffer(int param2Int) {
/* 330 */         this(new ByteArrayOutputStream(param2Int), new CRC32());
/*     */       }
/*     */       
/*     */       private ChunkBuffer(ByteArrayOutputStream param2ByteArrayOutputStream, CRC32 param2CRC32) {
/* 334 */         super(new CheckedOutputStream(param2ByteArrayOutputStream, param2CRC32));
/* 335 */         this.buffer = param2ByteArrayOutputStream;
/* 336 */         this.crc = param2CRC32;
/*     */       }
/*     */       
/*     */       public void endChunk(DataOutputStream param2DataOutputStream) {
/* 340 */         flush();
/* 341 */         param2DataOutputStream.writeInt(this.buffer.size() - 4);
/* 342 */         this.buffer.writeTo(param2DataOutputStream);
/* 343 */         param2DataOutputStream.writeInt((int)this.crc.getValue());
/* 344 */         this.buffer.reset();
/* 345 */         this.crc.reset();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\PixmapIO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */