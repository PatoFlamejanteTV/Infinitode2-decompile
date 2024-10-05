/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.DataInput;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.FilterInputStream;
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
/*     */ public class LittleEndianInputStream
/*     */   extends FilterInputStream
/*     */   implements DataInput
/*     */ {
/*     */   private DataInputStream din;
/*     */   
/*     */   public LittleEndianInputStream(InputStream paramInputStream) {
/*  32 */     super(paramInputStream);
/*  33 */     this.din = new DataInputStream(paramInputStream);
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/*  37 */     this.din.readFully(paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  41 */     this.din.readFully(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public int skipBytes(int paramInt) {
/*  45 */     return this.din.skipBytes(paramInt);
/*     */   }
/*     */   
/*     */   public boolean readBoolean() {
/*  49 */     return this.din.readBoolean();
/*     */   }
/*     */   
/*     */   public byte readByte() {
/*  53 */     return this.din.readByte();
/*     */   }
/*     */   
/*     */   public int readUnsignedByte() {
/*  57 */     return this.din.readUnsignedByte();
/*     */   }
/*     */   
/*     */   public short readShort() {
/*  61 */     int i = this.din.read();
/*     */     int j;
/*  63 */     return (short)((j = this.din.read()) << 8 | i & 0xFF);
/*     */   }
/*     */   
/*     */   public int readUnsignedShort() {
/*  67 */     int i = this.din.read();
/*     */     int j;
/*  69 */     return ((j = this.din.read()) & 0xFF) << 8 | i & 0xFF;
/*     */   }
/*     */   
/*     */   public char readChar() {
/*  73 */     return this.din.readChar();
/*     */   }
/*     */   
/*     */   public int readInt() {
/*  77 */     int[] arrayOfInt = new int[4];
/*  78 */     for (byte b = 3; b >= 0; b--) {
/*  79 */       arrayOfInt[b] = this.din.read();
/*     */     }
/*  81 */     return (arrayOfInt[0] & 0xFF) << 24 | (arrayOfInt[1] & 0xFF) << 16 | (arrayOfInt[2] & 0xFF) << 8 | arrayOfInt[3] & 0xFF;
/*     */   }
/*     */   
/*     */   public long readLong() {
/*  85 */     int[] arrayOfInt = new int[8];
/*  86 */     for (byte b = 7; b >= 0; b--) {
/*  87 */       arrayOfInt[b] = this.din.read();
/*     */     }
/*  89 */     return (arrayOfInt[0] & 0xFF) << 56L | (arrayOfInt[1] & 0xFF) << 48L | (arrayOfInt[2] & 0xFF) << 40L | (arrayOfInt[3] & 0xFF) << 32L | (arrayOfInt[4] & 0xFF) << 24L | (arrayOfInt[5] & 0xFF) << 16L | (arrayOfInt[6] & 0xFF) << 8L | (arrayOfInt[7] & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float readFloat() {
/*  95 */     return Float.intBitsToFloat(readInt());
/*     */   }
/*     */   
/*     */   public double readDouble() {
/*  99 */     return Double.longBitsToDouble(readLong());
/*     */   }
/*     */   
/*     */   public final String readLine() {
/* 103 */     return this.din.readLine();
/*     */   }
/*     */   
/*     */   public String readUTF() {
/* 107 */     return this.din.readUTF();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\LittleEndianInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */