/*     */ package com.esotericsoftware.kryo.unsafe;
/*     */ 
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnsafeOutput
/*     */   extends Output
/*     */ {
/*     */   public UnsafeOutput() {}
/*     */   
/*     */   public UnsafeOutput(int paramInt) {
/*  48 */     this(paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsafeOutput(int paramInt1, int paramInt2) {
/*  56 */     super(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsafeOutput(byte[] paramArrayOfbyte) {
/*  62 */     this(paramArrayOfbyte, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UnsafeOutput(byte[] paramArrayOfbyte, int paramInt) {
/*  68 */     super(paramArrayOfbyte, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeOutput(OutputStream paramOutputStream) {
/*  73 */     super(paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public UnsafeOutput(OutputStream paramOutputStream, int paramInt) {
/*  78 */     super(paramOutputStream, paramInt);
/*     */   }
/*     */   
/*     */   public void write(int paramInt) {
/*  82 */     if (this.position == this.capacity) require(1); 
/*  83 */     UnsafeUtil.unsafe.putByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position++, (byte)paramInt);
/*     */   }
/*     */   
/*     */   public void writeByte(byte paramByte) {
/*  87 */     if (this.position == this.capacity) require(1); 
/*  88 */     UnsafeUtil.unsafe.putByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position++, paramByte);
/*     */   }
/*     */   
/*     */   public void writeByte(int paramInt) {
/*  92 */     if (this.position == this.capacity) require(1); 
/*  93 */     UnsafeUtil.unsafe.putByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position++, (byte)paramInt);
/*     */   }
/*     */   
/*     */   public void writeInt(int paramInt) {
/*  97 */     require(4);
/*  98 */     UnsafeUtil.unsafe.putInt(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramInt);
/*  99 */     this.position += 4;
/*     */   }
/*     */   
/*     */   public void writeLong(long paramLong) {
/* 103 */     require(8);
/* 104 */     UnsafeUtil.unsafe.putLong(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramLong);
/* 105 */     this.position += 8;
/*     */   }
/*     */   
/*     */   public void writeFloat(float paramFloat) {
/* 109 */     require(4);
/* 110 */     UnsafeUtil.unsafe.putFloat(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramFloat);
/* 111 */     this.position += 4;
/*     */   }
/*     */   
/*     */   public void writeDouble(double paramDouble) {
/* 115 */     require(8);
/* 116 */     UnsafeUtil.unsafe.putDouble(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramDouble);
/* 117 */     this.position += 8;
/*     */   }
/*     */   
/*     */   public void writeShort(int paramInt) {
/* 121 */     require(2);
/* 122 */     UnsafeUtil.unsafe.putShort(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, (short)paramInt);
/* 123 */     this.position += 2;
/*     */   }
/*     */   
/*     */   public void writeChar(char paramChar) {
/* 127 */     require(2);
/* 128 */     UnsafeUtil.unsafe.putChar(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, paramChar);
/* 129 */     this.position += 2;
/*     */   }
/*     */   
/*     */   public void writeBoolean(boolean paramBoolean) {
/* 133 */     if (this.position == this.capacity) require(1); 
/* 134 */     UnsafeUtil.unsafe.putByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position++, paramBoolean ? 1 : 0);
/*     */   }
/*     */   
/*     */   public void writeInts(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 138 */     writeBytes(paramArrayOfint, UnsafeUtil.intArrayBaseOffset, paramArrayOfint.length << 2);
/*     */   }
/*     */   
/*     */   public void writeLongs(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 142 */     writeBytes(paramArrayOflong, UnsafeUtil.longArrayBaseOffset, paramArrayOflong.length << 3);
/*     */   }
/*     */   
/*     */   public void writeFloats(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 146 */     writeBytes(paramArrayOffloat, UnsafeUtil.floatArrayBaseOffset, paramArrayOffloat.length << 2);
/*     */   }
/*     */   
/*     */   public void writeDoubles(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 150 */     writeBytes(paramArrayOfdouble, UnsafeUtil.doubleArrayBaseOffset, paramArrayOfdouble.length << 3);
/*     */   }
/*     */   
/*     */   public void writeShorts(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 154 */     writeBytes(paramArrayOfshort, UnsafeUtil.shortArrayBaseOffset, paramArrayOfshort.length << 1);
/*     */   }
/*     */   
/*     */   public void writeChars(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 158 */     writeBytes(paramArrayOfchar, UnsafeUtil.charArrayBaseOffset, paramArrayOfchar.length << 1);
/*     */   }
/*     */   
/*     */   public void writeBooleans(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 162 */     writeBytes(paramArrayOfboolean, UnsafeUtil.booleanArrayBaseOffset, paramArrayOfboolean.length);
/*     */   }
/*     */   
/*     */   public void writeBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 166 */     writeBytes(paramArrayOfbyte, UnsafeUtil.byteArrayBaseOffset + paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeBytes(Object paramObject, long paramLong, int paramInt) {
/* 171 */     int i = Math.min(this.capacity - this.position, paramInt);
/*     */     
/* 173 */     UnsafeUtil.unsafe.copyMemory(paramObject, paramLong, this.buffer, UnsafeUtil.byteArrayBaseOffset + this.position, i);
/* 174 */     this.position += i;
/*     */     
/* 176 */     while ((paramInt = paramInt - i) != 0) {
/* 177 */       paramLong += i;
/* 178 */       i = Math.min(this.capacity, paramInt);
/* 179 */       require(i);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\unsafe\UnsafeOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */