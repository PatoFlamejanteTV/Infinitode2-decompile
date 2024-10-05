/*     */ package com.esotericsoftware.kryo.unsafe;
/*     */ 
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnsafeInput
/*     */   extends Input
/*     */ {
/*     */   public UnsafeInput() {}
/*     */   
/*     */   public UnsafeInput(int paramInt) {
/*  48 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsafeInput(byte[] paramArrayOfbyte) {
/*  55 */     super(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsafeInput(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  62 */     super(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeInput(InputStream paramInputStream) {
/*  67 */     super(paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeInput(InputStream paramInputStream, int paramInt) {
/*  72 */     super(paramInputStream, paramInt);
/*     */   }
/*     */   
/*     */   public int read() {
/*  76 */     if (optional(1) <= 0) return -1; 
/*  77 */     return UnsafeUtil.unsafe.getByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position++) & 0xFF;
/*     */   }
/*     */   
/*     */   public byte readByte() {
/*  81 */     if (this.position == this.limit) require(1); 
/*  82 */     return UnsafeUtil.unsafe.getByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position++);
/*     */   }
/*     */   
/*     */   public int readByteUnsigned() {
/*  86 */     if (this.position == this.limit) require(1); 
/*  87 */     return UnsafeUtil.unsafe.getByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position++) & 0xFF;
/*     */   }
/*     */   
/*     */   public int readInt() {
/*  91 */     require(4);
/*  92 */     int i = UnsafeUtil.unsafe.getInt(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
/*  93 */     this.position += 4;
/*  94 */     return i;
/*     */   }
/*     */   
/*     */   public long readLong() {
/*  98 */     require(8);
/*  99 */     long l = UnsafeUtil.unsafe.getLong(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
/* 100 */     this.position += 8;
/* 101 */     return l;
/*     */   }
/*     */   
/*     */   public float readFloat() {
/* 105 */     require(4);
/* 106 */     float f = UnsafeUtil.unsafe.getFloat(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
/* 107 */     this.position += 4;
/* 108 */     return f;
/*     */   }
/*     */   
/*     */   public double readDouble() {
/* 112 */     require(8);
/* 113 */     double d = UnsafeUtil.unsafe.getDouble(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
/* 114 */     this.position += 8;
/* 115 */     return d;
/*     */   }
/*     */   
/*     */   public short readShort() {
/* 119 */     require(2);
/* 120 */     short s = UnsafeUtil.unsafe.getShort(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
/* 121 */     this.position += 2;
/* 122 */     return s;
/*     */   }
/*     */   
/*     */   public char readChar() {
/* 126 */     require(2);
/* 127 */     char c = UnsafeUtil.unsafe.getChar(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position);
/* 128 */     this.position += 2;
/* 129 */     return c;
/*     */   }
/*     */   
/*     */   public boolean readBoolean() {
/* 133 */     if (this.position == this.limit) require(1); 
/*     */     boolean bool;
/* 135 */     return bool = (UnsafeUtil.unsafe.getByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position++) != 0) ? true : false;
/*     */   }
/*     */   
/*     */   public int[] readInts(int paramInt) {
/* 139 */     int[] arrayOfInt = new int[paramInt];
/* 140 */     readBytes(arrayOfInt, UnsafeUtil.intArrayBaseOffset, paramInt << 2);
/* 141 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public long[] readLongs(int paramInt) {
/* 145 */     long[] arrayOfLong = new long[paramInt];
/* 146 */     readBytes(arrayOfLong, UnsafeUtil.longArrayBaseOffset, paramInt << 3);
/* 147 */     return arrayOfLong;
/*     */   }
/*     */   
/*     */   public float[] readFloats(int paramInt) {
/* 151 */     float[] arrayOfFloat = new float[paramInt];
/* 152 */     readBytes(arrayOfFloat, UnsafeUtil.floatArrayBaseOffset, paramInt << 2);
/* 153 */     return arrayOfFloat;
/*     */   }
/*     */   
/*     */   public double[] readDoubles(int paramInt) {
/* 157 */     double[] arrayOfDouble = new double[paramInt];
/* 158 */     readBytes(arrayOfDouble, UnsafeUtil.doubleArrayBaseOffset, paramInt << 3);
/* 159 */     return arrayOfDouble;
/*     */   }
/*     */   
/*     */   public short[] readShorts(int paramInt) {
/* 163 */     short[] arrayOfShort = new short[paramInt];
/* 164 */     readBytes(arrayOfShort, UnsafeUtil.shortArrayBaseOffset, paramInt << 1);
/* 165 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public char[] readChars(int paramInt) {
/* 169 */     char[] arrayOfChar = new char[paramInt];
/* 170 */     readBytes(arrayOfChar, UnsafeUtil.charArrayBaseOffset, paramInt << 1);
/* 171 */     return arrayOfChar;
/*     */   }
/*     */   
/*     */   public boolean[] readBooleans(int paramInt) {
/* 175 */     boolean[] arrayOfBoolean = new boolean[paramInt];
/* 176 */     readBytes(arrayOfBoolean, UnsafeUtil.booleanArrayBaseOffset, paramInt);
/* 177 */     return arrayOfBoolean;
/*     */   }
/*     */   
/*     */   public void readBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 181 */     readBytes(paramArrayOfbyte, UnsafeUtil.byteArrayBaseOffset + paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readBytes(Object paramObject, long paramLong, int paramInt) {
/* 186 */     int i = Math.min(this.limit - this.position, paramInt);
/*     */     
/* 188 */     UnsafeUtil.unsafe.copyMemory(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramObject, paramLong, i);
/* 189 */     this.position += i;
/*     */     
/* 191 */     while ((paramInt = paramInt - i) != 0) {
/* 192 */       paramLong += i;
/* 193 */       i = Math.min(paramInt, this.capacity);
/* 194 */       require(i);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\unsafe\UnsafeInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */