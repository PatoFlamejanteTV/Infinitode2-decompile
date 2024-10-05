/*     */ package nonapi.io.github.classgraph.fileslice.reader;
/*     */ 
/*     */ import io.github.classgraph.Resource;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Arrays;
/*     */ import nonapi.io.github.classgraph.fileslice.ArraySlice;
/*     */ import nonapi.io.github.classgraph.fileslice.Slice;
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
/*     */ public class ClassfileReader
/*     */   implements Closeable, RandomAccessReader, SequentialReader
/*     */ {
/*     */   private Resource resourceToClose;
/*     */   private InputStream inflaterInputStream;
/*     */   private RandomAccessReader randomAccessReader;
/*     */   private byte[] arr;
/*     */   private int arrUsed;
/*     */   private int currIdx;
/*     */   private int classfileLengthHint;
/*     */   private static final int INITIAL_BUF_SIZE = 16384;
/*     */   private static final int BUF_CHUNK_SIZE = 8184;
/*     */   
/*     */   public ClassfileReader(Slice paramSlice, Resource paramResource) {
/*     */     ArraySlice arraySlice;
/*  78 */     this.classfileLengthHint = -1;
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
/* 106 */     this.classfileLengthHint = (int)paramSlice.sliceLength;
/* 107 */     this.resourceToClose = paramResource;
/* 108 */     if (paramSlice.isDeflatedZipEntry) {
/*     */       
/* 110 */       this.inflaterInputStream = paramSlice.open();
/* 111 */       this.arr = new byte[16384];
/* 112 */       this.classfileLengthHint = (int)Math.min(paramSlice.inflatedLengthHint, 2147483639L); return;
/*     */     } 
/* 114 */     if (paramSlice instanceof ArraySlice) {
/*     */ 
/*     */ 
/*     */       
/* 118 */       if ((arraySlice = (ArraySlice)paramSlice).sliceStartPos == 0L && arraySlice.sliceLength == arraySlice.arr.length) {
/*     */         
/* 120 */         this.arr = arraySlice.arr;
/*     */       }
/*     */       else {
/*     */         
/* 124 */         this.arr = Arrays.copyOfRange(arraySlice.arr, (int)arraySlice.sliceStartPos, (int)(arraySlice.sliceStartPos + arraySlice.sliceLength));
/*     */       } 
/*     */       
/* 127 */       this.arrUsed = this.arr.length;
/* 128 */       this.classfileLengthHint = this.arr.length;
/*     */       return;
/*     */     } 
/* 131 */     this.randomAccessReader = arraySlice.randomAccessReader();
/* 132 */     this.arr = new byte[16384];
/* 133 */     this.classfileLengthHint = (int)Math.min(((Slice)arraySlice).sliceLength, 2147483639L);
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
/*     */   public ClassfileReader(InputStream paramInputStream, Resource paramResource) {
/*     */     this.classfileLengthHint = -1;
/* 149 */     this.inflaterInputStream = paramInputStream;
/* 150 */     this.arr = new byte[16384];
/* 151 */     this.resourceToClose = paramResource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int currPos() {
/* 160 */     return this.currIdx;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] buf() {
/* 169 */     return this.arr;
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
/*     */   private void readTo(int paramInt) {
/* 184 */     int i = (this.classfileLengthHint == -1) ? 2147483639 : this.classfileLengthHint;
/* 185 */     if (this.inflaterInputStream == null && this.randomAccessReader == null)
/*     */     {
/*     */       
/* 188 */       throw new IOException("Tried to read past end of fixed array buffer");
/*     */     }
/* 190 */     if (paramInt > 2147483639 || paramInt < 0 || this.arrUsed == i) {
/* 191 */       throw new IOException("Hit 2GB limit while trying to grow buffer array");
/*     */     }
/*     */ 
/*     */     
/* 195 */     int j = (int)Math.min(Math.max(paramInt, (this.arrUsed + 8184)), i);
/*     */ 
/*     */ 
/*     */     
/* 199 */     long l = this.arr.length;
/* 200 */     while (l < j) {
/* 201 */       l = Math.min(j, l << 1L);
/*     */     }
/* 203 */     if (l > 2147483639L) {
/* 204 */       throw new IOException("Hit 2GB limit while trying to grow buffer array");
/*     */     }
/* 206 */     this.arr = Arrays.copyOf(this.arr, (int)Math.min(l, i));
/*     */ 
/*     */     
/* 209 */     j = this.arr.length - this.arrUsed;
/*     */ 
/*     */     
/* 212 */     if (this.inflaterInputStream != null) {
/*     */ 
/*     */       
/* 215 */       if ((i = this.inflaterInputStream.read(this.arr, this.arrUsed, j)) > 0) {
/* 216 */         this.arrUsed += i;
/*     */       }
/*     */     } else {
/*     */       
/* 220 */       i = Math.min(j, i - this.arrUsed);
/*     */ 
/*     */ 
/*     */       
/* 224 */       if ((i = this.randomAccessReader.read(this.arrUsed, this.arr, this.arrUsed, i)) > 0) {
/* 225 */         this.arrUsed += i;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 230 */     if (this.arrUsed < paramInt) {
/* 231 */       throw new IOException("Buffer underflow");
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
/*     */   public void bufferTo(int paramInt) {
/* 244 */     if (paramInt > this.arrUsed) {
/* 245 */       readTo(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 252 */     if (paramInt2 == 0) {
/* 253 */       return 0;
/*     */     }
/*     */     int i;
/* 256 */     if ((i = (int)paramLong) + paramInt2 > this.arrUsed) {
/* 257 */       readTo(i + paramInt2);
/*     */     }
/*     */     int j;
/* 260 */     if ((j = Math.max(Math.min(paramInt2, paramArrayOfbyte.length - paramInt1), 0)) == 0) {
/* 261 */       return -1;
/*     */     }
/*     */     try {
/* 264 */       System.arraycopy(this.arr, i, paramArrayOfbyte, paramInt1, j);
/* 265 */       return j;
/* 266 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/* 267 */       throw new IOException("Read index out of bounds");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 274 */     if (paramInt2 == 0) {
/* 275 */       return 0;
/*     */     }
/*     */     int i;
/* 278 */     if ((i = (int)paramLong) + paramInt2 > this.arrUsed) {
/* 279 */       readTo(i + paramInt2);
/*     */     }
/*     */     int j;
/* 282 */     if ((j = Math.max(Math.min(paramInt2, paramByteBuffer.capacity() - paramInt1), 0)) == 0) {
/* 283 */       return -1;
/*     */     }
/*     */     try {
/* 286 */       paramByteBuffer.position(paramInt1);
/* 287 */       paramByteBuffer.limit(paramInt1 + j);
/* 288 */       paramByteBuffer.put(this.arr, i, j);
/* 289 */       return j;
/* 290 */     } catch (BufferUnderflowException|IndexOutOfBoundsException|java.nio.ReadOnlyBufferException bufferUnderflowException) {
/* 291 */       throw new IOException("Read index out of bounds");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte readByte(long paramLong) {
/*     */     int i;
/* 298 */     if ((i = (int)paramLong) + 1 > this.arrUsed) {
/* 299 */       readTo(i + 1);
/*     */     }
/* 301 */     return this.arr[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedByte(long paramLong) {
/*     */     int i;
/* 307 */     if ((i = (int)paramLong) + 1 > this.arrUsed) {
/* 308 */       readTo(i + 1);
/*     */     }
/* 310 */     return this.arr[i] & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort(long paramLong) {
/* 315 */     return (short)readUnsignedShort(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedShort(long paramLong) {
/*     */     int i;
/* 321 */     if ((i = (int)paramLong) + 2 > this.arrUsed) {
/* 322 */       readTo(i + 2);
/*     */     }
/* 324 */     return (this.arr[i] & 0xFF) << 8 | this.arr[i + 1] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int readInt(long paramLong) {
/*     */     int i;
/* 331 */     if ((i = (int)paramLong) + 4 > this.arrUsed) {
/* 332 */       readTo(i + 4);
/*     */     }
/* 334 */     return (this.arr[i] & 0xFF) << 24 | (this.arr[i + 1] & 0xFF) << 16 | (this.arr[i + 2] & 0xFF) << 8 | this.arr[i + 3] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readUnsignedInt(long paramLong) {
/* 342 */     return readInt(paramLong) & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */   
/*     */   public long readLong(long paramLong) {
/*     */     int i;
/* 348 */     if ((i = (int)paramLong) + 8 > this.arrUsed) {
/* 349 */       readTo(i + 8);
/*     */     }
/* 351 */     return (this.arr[i] & 0xFFL) << 56L | (this.arr[i + 1] & 0xFFL) << 48L | (this.arr[i + 2] & 0xFFL) << 40L | (this.arr[i + 3] & 0xFFL) << 32L | (this.arr[i + 4] & 0xFFL) << 24L | (this.arr[i + 5] & 0xFFL) << 16L | (this.arr[i + 6] & 0xFFL) << 8L | this.arr[i + 7] & 0xFFL;
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
/*     */   public byte readByte() {
/* 363 */     byte b = readByte(this.currIdx);
/* 364 */     this.currIdx++;
/* 365 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedByte() {
/* 370 */     int i = readUnsignedByte(this.currIdx);
/* 371 */     this.currIdx++;
/* 372 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort() {
/* 377 */     short s = readShort(this.currIdx);
/* 378 */     this.currIdx += 2;
/* 379 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedShort() {
/* 384 */     int i = readUnsignedShort(this.currIdx);
/* 385 */     this.currIdx += 2;
/* 386 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int readInt() {
/* 391 */     int i = readInt(this.currIdx);
/* 392 */     this.currIdx += 4;
/* 393 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public long readUnsignedInt() {
/* 398 */     long l = readUnsignedInt(this.currIdx);
/* 399 */     this.currIdx += 4;
/* 400 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public long readLong() {
/* 405 */     long l = readLong(this.currIdx);
/* 406 */     this.currIdx += 8;
/* 407 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public void skip(int paramInt) {
/* 412 */     if (paramInt < 0) {
/* 413 */       throw new IllegalArgumentException("Tried to skip a negative number of bytes");
/*     */     }
/*     */     int i;
/* 416 */     if ((i = this.currIdx) + paramInt > this.arrUsed) {
/* 417 */       readTo(i + paramInt);
/*     */     }
/* 419 */     this.currIdx += paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     int i;
/* 426 */     if ((i = (int)paramLong) + paramInt > this.arrUsed) {
/* 427 */       readTo(i + paramInt);
/*     */     }
/* 429 */     return StringUtils.readString(this.arr, i, paramInt, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 435 */     String str = StringUtils.readString(this.arr, this.currIdx, paramInt, paramBoolean1, paramBoolean2);
/* 436 */     this.currIdx += paramInt;
/* 437 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public String readString(long paramLong, int paramInt) {
/* 442 */     return readString(paramLong, paramInt, false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public String readString(int paramInt) {
/* 447 */     return readString(paramInt, false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/* 453 */       if (this.inflaterInputStream != null) {
/* 454 */         this.inflaterInputStream.close();
/* 455 */         this.inflaterInputStream = null;
/*     */       } 
/* 457 */       if (this.resourceToClose != null) {
/* 458 */         this.resourceToClose.close();
/* 459 */         this.resourceToClose = null;
/*     */       }  return;
/* 461 */     } catch (Exception exception) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\reader\ClassfileReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */