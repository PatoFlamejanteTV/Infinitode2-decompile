/*     */ package nonapi.io.github.classgraph.fileslice.reader;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
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
/*     */ 
/*     */ public class RandomAccessByteBufferReader
/*     */   implements RandomAccessReader
/*     */ {
/*     */   private final ByteBuffer byteBuffer;
/*     */   private final int sliceStartPos;
/*     */   private final int sliceLength;
/*     */   
/*     */   public RandomAccessByteBufferReader(ByteBuffer paramByteBuffer, long paramLong1, long paramLong2) {
/*  66 */     this.byteBuffer = paramByteBuffer.duplicate();
/*  67 */     this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
/*  68 */     this.sliceStartPos = (int)paramLong1;
/*  69 */     this.sliceLength = (int)paramLong2;
/*  70 */     this.byteBuffer.position(this.sliceStartPos);
/*  71 */     this.byteBuffer.limit(this.sliceStartPos + this.sliceLength);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  77 */     if (paramInt2 == 0) {
/*  78 */       return 0;
/*     */     }
/*  80 */     if (paramLong < 0L || paramInt2 < 0 || paramInt2 > this.sliceLength - paramLong) {
/*  81 */       throw new IOException("Read index out of bounds");
/*     */     }
/*     */     
/*     */     try {
/*  85 */       if ((paramInt2 = Math.max(Math.min(paramInt2, paramArrayOfbyte.length - paramInt1), 0)) == 0) {
/*  86 */         return -1;
/*     */       }
/*  88 */       int i = (int)paramLong;
/*  89 */       this.byteBuffer.position(this.sliceStartPos + i);
/*  90 */       this.byteBuffer.get(paramArrayOfbyte, paramInt1, paramInt2);
/*  91 */       this.byteBuffer.position(this.sliceStartPos);
/*  92 */       return paramInt2;
/*  93 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*  94 */       throw new IOException("Read index out of bounds");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 101 */     if (paramInt2 == 0) {
/* 102 */       return 0;
/*     */     }
/* 104 */     if (paramLong < 0L || paramInt2 < 0 || paramInt2 > this.sliceLength - paramLong) {
/* 105 */       throw new IOException("Read index out of bounds");
/*     */     }
/*     */     
/*     */     try {
/* 109 */       if ((paramInt2 = Math.max(Math.min(paramInt2, paramByteBuffer.capacity() - paramInt1), 0)) == 0) {
/* 110 */         return -1;
/*     */       }
/* 112 */       int i = (int)(this.sliceStartPos + paramLong);
/* 113 */       this.byteBuffer.position(i);
/* 114 */       paramByteBuffer.position(paramInt1);
/* 115 */       paramByteBuffer.limit(paramInt1 + paramInt2);
/* 116 */       paramByteBuffer.put(this.byteBuffer);
/* 117 */       this.byteBuffer.limit(this.sliceStartPos + this.sliceLength);
/* 118 */       this.byteBuffer.position(this.sliceStartPos);
/* 119 */       return paramInt2;
/* 120 */     } catch (BufferUnderflowException|IndexOutOfBoundsException|java.nio.ReadOnlyBufferException bufferUnderflowException) {
/* 121 */       throw new IOException("Read index out of bounds");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte readByte(long paramLong) {
/* 127 */     int i = (int)(this.sliceStartPos + paramLong);
/* 128 */     return this.byteBuffer.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedByte(long paramLong) {
/* 133 */     int i = (int)(this.sliceStartPos + paramLong);
/* 134 */     return this.byteBuffer.get(i) & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedShort(long paramLong) {
/* 139 */     int i = (int)(this.sliceStartPos + paramLong);
/* 140 */     return this.byteBuffer.getShort(i) & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort(long paramLong) {
/* 145 */     return (short)readUnsignedShort(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readInt(long paramLong) {
/* 150 */     int i = (int)(this.sliceStartPos + paramLong);
/* 151 */     return this.byteBuffer.getInt(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public long readUnsignedInt(long paramLong) {
/* 156 */     return readInt(paramLong) & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */   
/*     */   public long readLong(long paramLong) {
/* 161 */     int i = (int)(this.sliceStartPos + paramLong);
/* 162 */     return this.byteBuffer.getLong(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 168 */     int i = (int)(this.sliceStartPos + paramLong);
/* 169 */     byte[] arrayOfByte = new byte[paramInt];
/* 170 */     if (read(paramLong, arrayOfByte, 0, paramInt) < paramInt) {
/* 171 */       throw new IOException("Premature EOF while reading string");
/*     */     }
/* 173 */     return StringUtils.readString(arrayOfByte, i, paramInt, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String readString(long paramLong, int paramInt) {
/* 178 */     return readString(paramLong, paramInt, false, false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\reader\RandomAccessByteBufferReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */