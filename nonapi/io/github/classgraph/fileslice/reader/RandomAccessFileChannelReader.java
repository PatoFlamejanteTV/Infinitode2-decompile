/*     */ package nonapi.io.github.classgraph.fileslice.reader;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
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
/*     */ public class RandomAccessFileChannelReader
/*     */   implements RandomAccessReader
/*     */ {
/*     */   private final FileChannel fileChannel;
/*     */   private final long sliceStartPos;
/*     */   private final long sliceLength;
/*     */   private ByteBuffer reusableByteBuffer;
/*  59 */   private final byte[] scratchArr = new byte[8];
/*     */ 
/*     */   
/*  62 */   private final ByteBuffer scratchByteBuf = ByteBuffer.wrap(this.scratchArr);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] utf8Bytes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomAccessFileChannelReader(FileChannel paramFileChannel, long paramLong1, long paramLong2) {
/*  79 */     this.fileChannel = paramFileChannel;
/*  80 */     this.sliceStartPos = paramLong1;
/*  81 */     this.sliceLength = paramLong2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/*  87 */     if (paramInt2 == 0) {
/*  88 */       return 0;
/*     */     }
/*     */     try {
/*  91 */       if (paramLong < 0L || paramInt2 < 0 || paramInt2 > this.sliceLength - paramLong) {
/*  92 */         throw new IOException("Read index out of bounds");
/*     */       }
/*  94 */       long l = this.sliceStartPos + paramLong;
/*  95 */       paramByteBuffer.position(paramInt1);
/*  96 */       paramByteBuffer.limit(paramInt1 + paramInt2);
/*     */       int i;
/*  98 */       return ((i = this.fileChannel.read(paramByteBuffer, l)) == 0) ? -1 : i;
/*     */     }
/* 100 */     catch (BufferUnderflowException|IndexOutOfBoundsException bufferUnderflowException) {
/* 101 */       throw new IOException("Read index out of bounds");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 108 */     if (paramInt2 == 0) {
/* 109 */       return 0;
/*     */     }
/*     */     try {
/* 112 */       if (paramLong < 0L || paramInt2 < 0 || paramInt2 > this.sliceLength - paramLong) {
/* 113 */         throw new IOException("Read index out of bounds");
/*     */       }
/* 115 */       if (this.reusableByteBuffer == null || this.reusableByteBuffer.array() != paramArrayOfbyte)
/*     */       {
/*     */         
/* 118 */         this.reusableByteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
/*     */       }
/*     */       
/* 121 */       return read(paramLong, this.reusableByteBuffer, paramInt1, paramInt2);
/*     */     }
/* 123 */     catch (BufferUnderflowException|IndexOutOfBoundsException bufferUnderflowException) {
/* 124 */       throw new IOException("Read index out of bounds");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte readByte(long paramLong) {
/* 130 */     if (read(paramLong, this.scratchByteBuf, 0, 1) <= 0) {
/* 131 */       throw new IOException("Premature EOF");
/*     */     }
/* 133 */     return this.scratchArr[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedByte(long paramLong) {
/* 138 */     if (read(paramLong, this.scratchByteBuf, 0, 1) <= 0) {
/* 139 */       throw new IOException("Premature EOF");
/*     */     }
/* 141 */     return this.scratchArr[0] & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort(long paramLong) {
/* 146 */     return (short)readUnsignedShort(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedShort(long paramLong) {
/* 151 */     if (read(paramLong, this.scratchByteBuf, 0, 2) < 2) {
/* 152 */       throw new IOException("Premature EOF");
/*     */     }
/* 154 */     return (this.scratchArr[1] & 0xFF) << 8 | this.scratchArr[0] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int readInt(long paramLong) {
/* 160 */     if (read(paramLong, this.scratchByteBuf, 0, 4) < 4) {
/* 161 */       throw new IOException("Premature EOF");
/*     */     }
/* 163 */     return (this.scratchArr[3] & 0xFF) << 24 | (this.scratchArr[2] & 0xFF) << 16 | (this.scratchArr[1] & 0xFF) << 8 | this.scratchArr[0] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readUnsignedInt(long paramLong) {
/* 171 */     return readInt(paramLong) & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */   
/*     */   public long readLong(long paramLong) {
/* 176 */     if (read(paramLong, this.scratchByteBuf, 0, 8) < 8) {
/* 177 */       throw new IOException("Premature EOF");
/*     */     }
/* 179 */     return (this.scratchArr[7] & 0xFFL) << 56L | (this.scratchArr[6] & 0xFFL) << 48L | (this.scratchArr[5] & 0xFFL) << 40L | (this.scratchArr[4] & 0xFFL) << 32L | (this.scratchArr[3] & 0xFFL) << 24L | (this.scratchArr[2] & 0xFFL) << 16L | (this.scratchArr[1] & 0xFFL) << 8L | this.scratchArr[0] & 0xFFL;
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
/*     */   public String readString(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 193 */     if (this.utf8Bytes == null || this.utf8Bytes.length < paramInt) {
/* 194 */       this.utf8Bytes = new byte[paramInt];
/*     */     }
/* 196 */     if (read(paramLong, this.utf8Bytes, 0, paramInt) < paramInt) {
/* 197 */       throw new IOException("Premature EOF");
/*     */     }
/* 199 */     return StringUtils.readString(this.utf8Bytes, 0, paramInt, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String readString(long paramLong, int paramInt) {
/* 204 */     return readString(paramLong, paramInt, false, false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\reader\RandomAccessFileChannelReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */