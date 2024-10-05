/*     */ package com.esotericsoftware.kryo.unsafe;
/*     */ 
/*     */ import com.esotericsoftware.kryo.io.ByteBufferInput;
/*     */ import java.io.InputStream;
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
/*     */ public class UnsafeByteBufferInput
/*     */   extends ByteBufferInput
/*     */ {
/*     */   private long bufferAddress;
/*     */   
/*     */   public UnsafeByteBufferInput() {}
/*     */   
/*     */   public UnsafeByteBufferInput(int paramInt) {
/*  55 */     super(paramInt);
/*  56 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferInput(byte[] paramArrayOfbyte) {
/*  61 */     super(paramArrayOfbyte);
/*  62 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferInput(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  67 */     super(paramArrayOfbyte, paramInt1, paramInt2);
/*  68 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferInput(ByteBuffer paramByteBuffer) {
/*  73 */     super(paramByteBuffer);
/*  74 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferInput(long paramLong, int paramInt) {
/*  80 */     super(UnsafeUtil.newDirectBuffer(paramLong, paramInt));
/*  81 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferInput(InputStream paramInputStream) {
/*  86 */     super(paramInputStream);
/*  87 */     updateBufferAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeByteBufferInput(InputStream paramInputStream, int paramInt) {
/*  92 */     super(paramInputStream, paramInt);
/*  93 */     updateBufferAddress();
/*     */   }
/*     */   
/*     */   public void setBuffer(ByteBuffer paramByteBuffer) {
/*  97 */     if (!(paramByteBuffer instanceof DirectBuffer)) throw new IllegalArgumentException("buffer must be direct."); 
/*  98 */     if (paramByteBuffer != this.byteBuffer) UnsafeUtil.dispose(this.byteBuffer); 
/*  99 */     super.setBuffer(paramByteBuffer);
/* 100 */     updateBufferAddress();
/*     */   }
/*     */   
/*     */   private void updateBufferAddress() {
/* 104 */     this.bufferAddress = ((DirectBuffer)this.byteBuffer).address();
/*     */   }
/*     */   
/*     */   private void setBufferPosition(Buffer paramBuffer, int paramInt) {
/* 108 */     paramBuffer.position(paramInt);
/*     */   }
/*     */   
/*     */   public int read() {
/* 112 */     if (optional(1) <= 0) return -1; 
/* 113 */     int i = UnsafeUtil.unsafe.getByte(this.bufferAddress + this.position++) & 0xFF;
/* 114 */     setBufferPosition(this.byteBuffer, this.position);
/* 115 */     return i;
/*     */   }
/*     */   
/*     */   public byte readByte() {
/* 119 */     if (this.position == this.limit) require(1); 
/* 120 */     byte b = UnsafeUtil.unsafe.getByte(this.bufferAddress + this.position++);
/* 121 */     setBufferPosition(this.byteBuffer, this.position);
/* 122 */     return b;
/*     */   }
/*     */   
/*     */   public int readByteUnsigned() {
/* 126 */     if (this.position == this.limit) require(1); 
/* 127 */     int i = UnsafeUtil.unsafe.getByte(this.bufferAddress + this.position++) & 0xFF;
/* 128 */     setBufferPosition(this.byteBuffer, this.position);
/* 129 */     return i;
/*     */   }
/*     */   
/*     */   public int readInt() {
/* 133 */     require(4);
/* 134 */     int i = UnsafeUtil.unsafe.getInt(this.bufferAddress + this.position);
/* 135 */     this.position += 4;
/* 136 */     setBufferPosition(this.byteBuffer, this.position);
/* 137 */     return i;
/*     */   }
/*     */   
/*     */   public long readLong() {
/* 141 */     require(8);
/* 142 */     long l = UnsafeUtil.unsafe.getLong(this.bufferAddress + this.position);
/* 143 */     this.position += 8;
/* 144 */     setBufferPosition(this.byteBuffer, this.position);
/* 145 */     return l;
/*     */   }
/*     */   
/*     */   public float readFloat() {
/* 149 */     require(4);
/* 150 */     float f = UnsafeUtil.unsafe.getFloat(this.bufferAddress + this.position);
/* 151 */     this.position += 4;
/* 152 */     setBufferPosition(this.byteBuffer, this.position);
/* 153 */     return f;
/*     */   }
/*     */   
/*     */   public double readDouble() {
/* 157 */     require(8);
/* 158 */     double d = UnsafeUtil.unsafe.getDouble(this.bufferAddress + this.position);
/* 159 */     this.position += 8;
/* 160 */     setBufferPosition(this.byteBuffer, this.position);
/* 161 */     return d;
/*     */   }
/*     */   
/*     */   public short readShort() {
/* 165 */     require(2);
/* 166 */     short s = UnsafeUtil.unsafe.getShort(this.bufferAddress + this.position);
/* 167 */     this.position += 2;
/* 168 */     setBufferPosition(this.byteBuffer, this.position);
/* 169 */     return s;
/*     */   }
/*     */   
/*     */   public char readChar() {
/* 173 */     require(2);
/* 174 */     char c = UnsafeUtil.unsafe.getChar(this.bufferAddress + this.position);
/* 175 */     this.position += 2;
/* 176 */     setBufferPosition(this.byteBuffer, this.position);
/* 177 */     return c;
/*     */   }
/*     */   
/*     */   public boolean readBoolean() {
/* 181 */     if (this.position == this.limit) require(1); 
/* 182 */     boolean bool = (UnsafeUtil.unsafe.getByte(this.bufferAddress + this.position++) != 0) ? true : false;
/* 183 */     setBufferPosition(this.byteBuffer, this.position);
/* 184 */     return bool;
/*     */   }
/*     */   
/*     */   public int[] readInts(int paramInt) {
/* 188 */     int[] arrayOfInt = new int[paramInt];
/* 189 */     readBytes(arrayOfInt, UnsafeUtil.intArrayBaseOffset, paramInt << 2);
/* 190 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public long[] readLongs(int paramInt) {
/* 194 */     long[] arrayOfLong = new long[paramInt];
/* 195 */     readBytes(arrayOfLong, UnsafeUtil.longArrayBaseOffset, paramInt << 3);
/* 196 */     return arrayOfLong;
/*     */   }
/*     */   
/*     */   public float[] readFloats(int paramInt) {
/* 200 */     float[] arrayOfFloat = new float[paramInt];
/* 201 */     readBytes(arrayOfFloat, UnsafeUtil.floatArrayBaseOffset, paramInt << 2);
/* 202 */     return arrayOfFloat;
/*     */   }
/*     */   
/*     */   public double[] readDoubles(int paramInt) {
/* 206 */     double[] arrayOfDouble = new double[paramInt];
/* 207 */     readBytes(arrayOfDouble, UnsafeUtil.doubleArrayBaseOffset, paramInt << 3);
/* 208 */     return arrayOfDouble;
/*     */   }
/*     */   
/*     */   public short[] readShorts(int paramInt) {
/* 212 */     short[] arrayOfShort = new short[paramInt];
/* 213 */     readBytes(arrayOfShort, UnsafeUtil.shortArrayBaseOffset, paramInt << 1);
/* 214 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public char[] readChars(int paramInt) {
/* 218 */     char[] arrayOfChar = new char[paramInt];
/* 219 */     readBytes(arrayOfChar, UnsafeUtil.charArrayBaseOffset, paramInt << 1);
/* 220 */     return arrayOfChar;
/*     */   }
/*     */   
/*     */   public boolean[] readBooleans(int paramInt) {
/* 224 */     boolean[] arrayOfBoolean = new boolean[paramInt];
/* 225 */     readBytes(arrayOfBoolean, UnsafeUtil.booleanArrayBaseOffset, paramInt);
/* 226 */     return arrayOfBoolean;
/*     */   }
/*     */   
/*     */   public void readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 230 */     readBytes(paramArrayOfbyte, UnsafeUtil.byteArrayBaseOffset + paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readBytes(Object paramObject, long paramLong, int paramInt) {
/* 235 */     int i = Math.min(this.limit - this.position, paramInt);
/*     */     
/* 237 */     UnsafeUtil.unsafe.copyMemory(null, this.bufferAddress + this.position, paramObject, paramLong, i);
/* 238 */     this.position += i;
/*     */     
/* 240 */     while ((paramInt = paramInt - i) != 0) {
/* 241 */       paramLong += i;
/* 242 */       i = Math.min(paramInt, this.capacity);
/* 243 */       require(i);
/*     */     } 
/* 245 */     setBufferPosition(this.byteBuffer, this.position);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\unsafe\UnsafeByteBufferInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */