/*     */ package nonapi.io.github.classgraph.fileslice.reader;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import nonapi.io.github.classgraph.utils.StringUtils;
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
/*     */ public class RandomAccessArrayReader
/*     */   implements RandomAccessReader
/*     */ {
/*     */   private final byte[] arr;
/*     */   private final int sliceStartPos;
/*     */   private final int sliceLength;
/*     */   
/*     */   public RandomAccessArrayReader(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  64 */     this.arr = paramArrayOfbyte;
/*  65 */     this.sliceStartPos = paramInt1;
/*  66 */     this.sliceLength = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  72 */     if (paramInt2 == 0) {
/*  73 */       return 0;
/*     */     }
/*  75 */     if (paramLong < 0L || paramInt2 < 0 || paramInt2 > this.sliceLength - paramLong) {
/*  76 */       throw new IOException("Read index out of bounds");
/*     */     }
/*     */     
/*     */     try {
/*  80 */       if ((paramInt2 = Math.max(Math.min(paramInt2, paramArrayOfbyte.length - paramInt1), 0)) == 0) {
/*  81 */         return -1;
/*     */       }
/*  83 */       int i = (int)(this.sliceStartPos + paramLong);
/*  84 */       System.arraycopy(this.arr, i, paramArrayOfbyte, paramInt1, paramInt2);
/*  85 */       return paramInt2;
/*  86 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*  87 */       throw new IOException("Read index out of bounds");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/*  94 */     if (paramInt2 == 0) {
/*  95 */       return 0;
/*     */     }
/*  97 */     if (paramLong < 0L || paramInt2 < 0 || paramInt2 > this.sliceLength - paramLong) {
/*  98 */       throw new IOException("Read index out of bounds");
/*     */     }
/*     */     
/*     */     try {
/* 102 */       if ((paramInt2 = Math.max(Math.min(paramInt2, paramByteBuffer.capacity() - paramInt1), 0)) == 0) {
/* 103 */         return -1;
/*     */       }
/* 105 */       int i = (int)(this.sliceStartPos + paramLong);
/* 106 */       paramByteBuffer.position(paramInt1);
/* 107 */       paramByteBuffer.limit(paramInt1 + paramInt2);
/* 108 */       paramByteBuffer.put(this.arr, i, paramInt2);
/* 109 */       return paramInt2;
/* 110 */     } catch (BufferUnderflowException|IndexOutOfBoundsException|java.nio.ReadOnlyBufferException bufferUnderflowException) {
/* 111 */       throw new IOException("Read index out of bounds");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte readByte(long paramLong) {
/* 117 */     int i = this.sliceStartPos + (int)paramLong;
/* 118 */     return this.arr[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedByte(long paramLong) {
/* 123 */     int i = this.sliceStartPos + (int)paramLong;
/* 124 */     return this.arr[i] & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort(long paramLong) {
/* 129 */     return (short)readUnsignedShort(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedShort(long paramLong) {
/* 134 */     int i = this.sliceStartPos + (int)paramLong;
/* 135 */     return (this.arr[i + 1] & 0xFF) << 8 | this.arr[i] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int readInt(long paramLong) {
/* 141 */     int i = this.sliceStartPos + (int)paramLong;
/* 142 */     return (this.arr[i + 3] & 0xFF) << 24 | (this.arr[i + 2] & 0xFF) << 16 | (this.arr[i + 1] & 0xFF) << 8 | this.arr[i] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readUnsignedInt(long paramLong) {
/* 150 */     return readInt(paramLong) & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */   
/*     */   public long readLong(long paramLong) {
/* 155 */     int i = this.sliceStartPos + (int)paramLong;
/* 156 */     return (this.arr[i + 7] & 0xFFL) << 56L | (this.arr[i + 6] & 0xFFL) << 48L | (this.arr[i + 5] & 0xFFL) << 40L | (this.arr[i + 4] & 0xFFL) << 32L | (this.arr[i + 3] & 0xFFL) << 24L | (this.arr[i + 2] & 0xFFL) << 16L | (this.arr[i + 1] & 0xFFL) << 8L | this.arr[i] & 0xFFL;
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
/*     */   public String readString(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 169 */     int i = this.sliceStartPos + (int)paramLong;
/* 170 */     return StringUtils.readString(this.arr, i, paramInt, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String readString(long paramLong, int paramInt) {
/* 175 */     return readString(paramLong, paramInt, false, false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\reader\RandomAccessArrayReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */