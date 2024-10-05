/*     */ package com.esotericsoftware.kryo.unsafe;
/*     */ 
/*     */ import com.esotericsoftware.kryo.io.ByteBufferOutput;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import sun.nio.ch.DirectBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnsafeByteBufferOutput
/*     */   extends ByteBufferOutput
/*     */ {
/*     */   private long bufferAddress;
/*     */   
/*     */   public UnsafeByteBufferOutput() {}
/*     */   
/*     */   public UnsafeByteBufferOutput(int paramInt) {
/*  56 */     super(paramInt);
/*  57 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferOutput(int paramInt1, int paramInt2) {
/*  65 */     super(paramInt1, paramInt2);
/*  66 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferOutput(OutputStream paramOutputStream) {
/*  71 */     super(paramOutputStream);
/*  72 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferOutput(OutputStream paramOutputStream, int paramInt) {
/*  77 */     super(paramOutputStream, paramInt);
/*  78 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferOutput(long paramLong, int paramInt) {
/*  84 */     super(UnsafeUtil.newDirectBuffer(paramLong, paramInt));
/*  85 */     updateBufferAddress();
/*     */   }
/*     */   
/*     */   public void setBuffer(ByteBuffer paramByteBuffer, int paramInt) {
/*  89 */     if (!(paramByteBuffer instanceof DirectBuffer)) throw new IllegalArgumentException("buffer must be direct."); 
/*  90 */     if (paramByteBuffer != this.byteBuffer) UnsafeUtil.dispose(this.byteBuffer); 
/*  91 */     super.setBuffer(paramByteBuffer, paramInt);
/*  92 */     updateBufferAddress();
/*     */   }
/*     */   
/*     */   private void updateBufferAddress() {
/*  96 */     this.bufferAddress = ((DirectBuffer)this.byteBuffer).address();
/*     */   }
/*     */   
/*     */   protected boolean require(int paramInt) {
/* 100 */     ByteBuffer byteBuffer = this.byteBuffer;
/* 101 */     boolean bool = super.require(paramInt);
/* 102 */     if (this.byteBuffer != byteBuffer) {
/* 103 */       UnsafeUtil.dispose(byteBuffer);
/* 104 */       updateBufferAddress();
/*     */     } 
/* 106 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 112 */     UnsafeUtil.dispose(this.byteBuffer);
/* 113 */     this.byteBuffer = null;
/* 114 */     this.bufferAddress = 0L;
/*     */   }
/*     */   
/*     */   private void setBufferPosition(Buffer paramBuffer, int paramInt) {
/* 118 */     paramBuffer.position(paramInt);
/*     */   }
/*     */   
/*     */   public void write(int paramInt) {
/* 122 */     if (this.position == this.capacity) require(1); 
/* 123 */     UnsafeUtil.unsafe.putByte(this.bufferAddress + this.position++, (byte)paramInt);
/* 124 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeByte(byte paramByte) {
/* 128 */     if (this.position == this.capacity) require(1); 
/* 129 */     UnsafeUtil.unsafe.putByte(this.bufferAddress + this.position++, paramByte);
/* 130 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeByte(int paramInt) {
/* 134 */     if (this.position == this.capacity) require(1); 
/* 135 */     UnsafeUtil.unsafe.putByte(this.bufferAddress + this.position++, (byte)paramInt);
/* 136 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeInt(int paramInt) {
/* 140 */     require(4);
/* 141 */     UnsafeUtil.unsafe.putInt(this.bufferAddress + this.position, paramInt);
/* 142 */     this.position += 4;
/* 143 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeLong(long paramLong) {
/* 147 */     require(8);
/* 148 */     UnsafeUtil.unsafe.putLong(this.bufferAddress + this.position, paramLong);
/* 149 */     this.position += 8;
/* 150 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeFloat(float paramFloat) {
/* 154 */     require(4);
/* 155 */     UnsafeUtil.unsafe.putFloat(this.bufferAddress + this.position, paramFloat);
/* 156 */     this.position += 4;
/* 157 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeDouble(double paramDouble) {
/* 161 */     require(8);
/* 162 */     UnsafeUtil.unsafe.putDouble(this.bufferAddress + this.position, paramDouble);
/* 163 */     this.position += 8;
/* 164 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeShort(int paramInt) {
/* 168 */     require(2);
/* 169 */     UnsafeUtil.unsafe.putShort(this.bufferAddress + this.position, (short)paramInt);
/* 170 */     this.position += 2;
/* 171 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeChar(char paramChar) {
/* 175 */     require(2);
/* 176 */     UnsafeUtil.unsafe.putChar(this.bufferAddress + this.position, paramChar);
/* 177 */     this.position += 2;
/* 178 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeBoolean(boolean paramBoolean) {
/* 182 */     if (this.position == this.capacity) require(1); 
/* 183 */     UnsafeUtil.unsafe.putByte(this.bufferAddress + this.position++, paramBoolean ? 1 : 0);
/* 184 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */   
/*     */   public void writeInts(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 188 */     writeBytes(paramArrayOfint, UnsafeUtil.intArrayBaseOffset, paramArrayOfint.length << 2);
/*     */   }
/*     */   
/*     */   public void writeLongs(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 192 */     writeBytes(paramArrayOflong, UnsafeUtil.longArrayBaseOffset, paramArrayOflong.length << 3);
/*     */   }
/*     */   
/*     */   public void writeFloats(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 196 */     writeBytes(paramArrayOffloat, UnsafeUtil.floatArrayBaseOffset, paramArrayOffloat.length << 2);
/*     */   }
/*     */   
/*     */   public void writeDoubles(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 200 */     writeBytes(paramArrayOfdouble, UnsafeUtil.doubleArrayBaseOffset, paramArrayOfdouble.length << 3);
/*     */   }
/*     */   
/*     */   public void writeShorts(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 204 */     writeBytes(paramArrayOfshort, UnsafeUtil.shortArrayBaseOffset, paramArrayOfshort.length << 1);
/*     */   }
/*     */   
/*     */   public void writeChars(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 208 */     writeBytes(paramArrayOfchar, UnsafeUtil.charArrayBaseOffset, paramArrayOfchar.length << 1);
/*     */   }
/*     */   
/*     */   public void writeBooleans(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 212 */     writeBytes(paramArrayOfboolean, UnsafeUtil.booleanArrayBaseOffset, paramArrayOfboolean.length);
/*     */   }
/*     */   
/*     */   public void writeBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 216 */     writeBytes(paramArrayOfbyte, UnsafeUtil.byteArrayBaseOffset + paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeBytes(Object paramObject, long paramLong, int paramInt) {
/* 221 */     int i = Math.min(this.capacity - this.position, paramInt);
/*     */     
/* 223 */     UnsafeUtil.unsafe.copyMemory(paramObject, paramLong, null, this.bufferAddress + this.position, i);
/* 224 */     this.position += i;
/*     */     
/* 226 */     while ((paramInt = paramInt - i) != 0) {
/* 227 */       paramLong += i;
/* 228 */       i = Math.min(this.capacity, paramInt);
/* 229 */       require(i);
/*     */     } 
/* 231 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\unsafe\UnsafeByteBufferOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */