/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import java.util.zip.GZIPOutputStream;
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
/*     */ public class ETC1
/*     */ {
/*  40 */   public static int PKM_HEADER_SIZE = 16;
/*  41 */   public static int ETC1_RGB8_OES = 36196;
/*     */ 
/*     */   
/*     */   public static final class ETC1Data
/*     */     implements Disposable
/*     */   {
/*     */     public final int width;
/*     */     
/*     */     public final int height;
/*     */     
/*     */     public final ByteBuffer compressedData;
/*     */     
/*     */     public final int dataOffset;
/*     */     
/*     */     public ETC1Data(int param1Int1, int param1Int2, ByteBuffer param1ByteBuffer, int param1Int3) {
/*  56 */       this.width = param1Int1;
/*  57 */       this.height = param1Int2;
/*  58 */       this.compressedData = param1ByteBuffer;
/*  59 */       this.dataOffset = param1Int3;
/*  60 */       checkNPOT();
/*     */     }
/*     */     
/*     */     public ETC1Data(FileHandle param1FileHandle) {
/*  64 */       byte[] arrayOfByte = new byte[10240];
/*  65 */       DataInputStream dataInputStream = null;
/*     */       
/*     */       try {
/*  68 */         int i = (dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(param1FileHandle.read())))).readInt();
/*  69 */         this.compressedData = BufferUtils.newUnsafeByteBuffer(i);
/*     */         
/*  71 */         while ((i = dataInputStream.read(arrayOfByte)) != -1) {
/*  72 */           this.compressedData.put(arrayOfByte, 0, i);
/*     */         }
/*  74 */         this.compressedData.position(0);
/*  75 */         this.compressedData.limit(this.compressedData.capacity());
/*  76 */       } catch (Exception exception) {
/*  77 */         throw new GdxRuntimeException("Couldn't load pkm file '" + param1FileHandle + "'", exception);
/*     */       } finally {
/*  79 */         StreamUtils.closeQuietly(dataInputStream);
/*     */       } 
/*     */       
/*  82 */       this.width = ETC1.getWidthPKM(this.compressedData, 0);
/*  83 */       this.height = ETC1.getHeightPKM(this.compressedData, 0);
/*  84 */       this.dataOffset = ETC1.PKM_HEADER_SIZE;
/*  85 */       this.compressedData.position(this.dataOffset);
/*  86 */       checkNPOT();
/*     */     }
/*     */     
/*     */     private void checkNPOT() {
/*  90 */       if (!MathUtils.isPowerOfTwo(this.width) || !MathUtils.isPowerOfTwo(this.height)) {
/*  91 */         System.out.println("ETC1Data warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean hasPKMHeader() {
/*  97 */       return (this.dataOffset == 16);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void write(FileHandle param1FileHandle) {
/* 103 */       DataOutputStream dataOutputStream = null;
/* 104 */       byte[] arrayOfByte = new byte[10240];
/* 105 */       int i = 0;
/* 106 */       this.compressedData.position(0);
/* 107 */       this.compressedData.limit(this.compressedData.capacity());
/*     */       
/*     */       try {
/* 110 */         (dataOutputStream = new DataOutputStream(new GZIPOutputStream(param1FileHandle.write(false)))).writeInt(this.compressedData.capacity());
/* 111 */         while (i != this.compressedData.capacity()) {
/* 112 */           int j = Math.min(this.compressedData.remaining(), 10240);
/* 113 */           this.compressedData.get(arrayOfByte, 0, j);
/* 114 */           dataOutputStream.write(arrayOfByte, 0, j);
/* 115 */           i += j;
/*     */         } 
/* 117 */       } catch (Exception exception) {
/* 118 */         throw new GdxRuntimeException("Couldn't write PKM file to '" + param1FileHandle + "'", exception);
/*     */       } finally {
/* 120 */         StreamUtils.closeQuietly(dataOutputStream);
/*     */       } 
/* 122 */       this.compressedData.position(this.dataOffset);
/* 123 */       this.compressedData.limit(this.compressedData.capacity());
/*     */     }
/*     */ 
/*     */     
/*     */     public final void dispose() {
/* 128 */       BufferUtils.disposeUnsafeByteBuffer(this.compressedData);
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 132 */       if (hasPKMHeader()) {
/* 133 */         return (ETC1.isValidPKM(this.compressedData, 0) ? "valid" : "invalid") + " pkm [" + ETC1.getWidthPKM(this.compressedData, 0) + "x" + 
/* 134 */           ETC1.getHeightPKM(this.compressedData, 0) + "], compressed: " + (this.compressedData
/* 135 */           .capacity() - ETC1.PKM_HEADER_SIZE);
/*     */       }
/* 137 */       return "raw [" + this.width + "x" + this.height + "], compressed: " + (this.compressedData.capacity() - ETC1.PKM_HEADER_SIZE);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getPixelSize(Pixmap.Format paramFormat) {
/* 143 */     if (paramFormat == Pixmap.Format.RGB565) return 2; 
/* 144 */     if (paramFormat == Pixmap.Format.RGB888) return 3; 
/* 145 */     throw new GdxRuntimeException("Can only handle RGB565 or RGB888 images");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ETC1Data encodeImage(Pixmap paramPixmap) {
/* 152 */     int i = getPixelSize(paramPixmap.getFormat());
/*     */     ByteBuffer byteBuffer;
/* 154 */     BufferUtils.newUnsafeByteBuffer(byteBuffer = encodeImage(paramPixmap.getPixels(), 0, paramPixmap.getWidth(), paramPixmap.getHeight(), i));
/* 155 */     return new ETC1Data(paramPixmap.getWidth(), paramPixmap.getHeight(), byteBuffer, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ETC1Data encodeImagePKM(Pixmap paramPixmap) {
/* 163 */     int i = getPixelSize(paramPixmap.getFormat());
/*     */     ByteBuffer byteBuffer;
/* 165 */     BufferUtils.newUnsafeByteBuffer(byteBuffer = encodeImagePKM(paramPixmap.getPixels(), 0, paramPixmap.getWidth(), paramPixmap.getHeight(), i));
/* 166 */     return new ETC1Data(paramPixmap.getWidth(), paramPixmap.getHeight(), byteBuffer, 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pixmap decodeImage(ETC1Data paramETC1Data, Pixmap.Format paramFormat) {
/*     */     boolean bool;
/*     */     int i, j;
/* 179 */     if (paramETC1Data.hasPKMHeader()) {
/* 180 */       bool = true;
/* 181 */       i = getWidthPKM(paramETC1Data.compressedData, 0);
/* 182 */       j = getHeightPKM(paramETC1Data.compressedData, 0);
/*     */     } else {
/* 184 */       bool = false;
/* 185 */       i = paramETC1Data.width;
/* 186 */       j = paramETC1Data.height;
/*     */     } 
/*     */     
/* 189 */     int k = getPixelSize(paramFormat);
/* 190 */     Pixmap pixmap = new Pixmap(i, j, paramFormat);
/* 191 */     decodeImage(paramETC1Data.compressedData, bool, pixmap.getPixels(), 0, i, j, k);
/* 192 */     return pixmap;
/*     */   }
/*     */   
/*     */   public static native int getCompressedDataSize(int paramInt1, int paramInt2);
/*     */   
/*     */   public static native void formatHeader(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   static native int getWidthPKM(ByteBuffer paramByteBuffer, int paramInt);
/*     */   
/*     */   static native int getHeightPKM(ByteBuffer paramByteBuffer, int paramInt);
/*     */   
/*     */   static native boolean isValidPKM(ByteBuffer paramByteBuffer, int paramInt);
/*     */   
/*     */   private static native void decodeImage(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */   
/*     */   private static native ByteBuffer encodeImage(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   private static native ByteBuffer encodeImagePKM(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\ETC1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */