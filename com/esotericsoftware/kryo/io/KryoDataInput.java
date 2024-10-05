/*     */ package com.esotericsoftware.kryo.io;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import java.io.DataInput;
/*     */ import java.io.EOFException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KryoDataInput
/*     */   implements DataInput, AutoCloseable
/*     */ {
/*     */   protected Input input;
/*     */   
/*     */   public KryoDataInput(Input paramInput) {
/*  35 */     this.input = paramInput;
/*     */   }
/*     */   
/*     */   public void setInput(Input paramInput) {
/*  39 */     this.input = paramInput;
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/*  43 */     readFully(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     try {
/*  48 */       this.input.readBytes(paramArrayOfbyte, paramInt1, paramInt2); return;
/*  49 */     } catch (KryoException kryoException) {
/*  50 */       throw new EOFException(kryoException.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public int skipBytes(int paramInt) {
/*  55 */     return (int)this.input.skip(paramInt);
/*     */   }
/*     */   
/*     */   public boolean readBoolean() {
/*  59 */     return this.input.readBoolean();
/*     */   }
/*     */   
/*     */   public byte readByte() {
/*  63 */     return this.input.readByte();
/*     */   }
/*     */   
/*     */   public int readUnsignedByte() {
/*  67 */     return this.input.readByteUnsigned();
/*     */   }
/*     */   
/*     */   public short readShort() {
/*  71 */     return this.input.readShort();
/*     */   }
/*     */   
/*     */   public int readUnsignedShort() {
/*  75 */     return this.input.readShortUnsigned();
/*     */   }
/*     */   
/*     */   public char readChar() {
/*  79 */     return this.input.readChar();
/*     */   }
/*     */   
/*     */   public int readInt() {
/*  83 */     return this.input.readInt();
/*     */   }
/*     */   
/*     */   public long readLong() {
/*  87 */     return this.input.readLong();
/*     */   }
/*     */   
/*     */   public float readFloat() {
/*  91 */     return this.input.readFloat();
/*     */   }
/*     */   
/*     */   public double readDouble() {
/*  95 */     return this.input.readDouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readLine() {
/* 102 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readUTF() {
/* 110 */     return this.input.readString();
/*     */   }
/*     */   
/*     */   public void close() {
/* 114 */     this.input.close();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\KryoDataInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */