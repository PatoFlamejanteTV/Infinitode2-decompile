/*     */ package com.esotericsoftware.kryo.io;
/*     */ 
/*     */ import java.io.DataOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KryoDataOutput
/*     */   implements DataOutput, AutoCloseable
/*     */ {
/*     */   protected Output output;
/*     */   
/*     */   public KryoDataOutput(Output paramOutput) {
/*  31 */     this.output = paramOutput;
/*     */   }
/*     */   
/*     */   public void setOutput(Output paramOutput) {
/*  35 */     this.output = paramOutput;
/*     */   }
/*     */   
/*     */   public void write(int paramInt) {
/*  39 */     this.output.write(paramInt);
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) {
/*  43 */     this.output.write(paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  47 */     this.output.write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void writeBoolean(boolean paramBoolean) {
/*  51 */     this.output.writeBoolean(paramBoolean);
/*     */   }
/*     */   
/*     */   public void writeByte(int paramInt) {
/*  55 */     this.output.writeByte(paramInt);
/*     */   }
/*     */   
/*     */   public void writeShort(int paramInt) {
/*  59 */     this.output.writeShort(paramInt);
/*     */   }
/*     */   
/*     */   public void writeChar(int paramInt) {
/*  63 */     this.output.writeChar((char)paramInt);
/*     */   }
/*     */   
/*     */   public void writeInt(int paramInt) {
/*  67 */     this.output.writeInt(paramInt);
/*     */   }
/*     */   
/*     */   public void writeLong(long paramLong) {
/*  71 */     this.output.writeLong(paramLong);
/*     */   }
/*     */   
/*     */   public void writeFloat(float paramFloat) {
/*  75 */     this.output.writeFloat(paramFloat);
/*     */   }
/*     */   
/*     */   public void writeDouble(double paramDouble) {
/*  79 */     this.output.writeDouble(paramDouble);
/*     */   }
/*     */   
/*     */   public void writeBytes(String paramString) {
/*  83 */     int i = paramString.length();
/*  84 */     for (byte b = 0; b < i; b++) {
/*  85 */       this.output.write((byte)paramString.charAt(b));
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeChars(String paramString) {
/*  90 */     int i = paramString.length();
/*  91 */     for (byte b = 0; b < i; b++) {
/*  92 */       char c = paramString.charAt(b);
/*  93 */       this.output.write(c & 0xFF);
/*  94 */       this.output.write(c >>> 8 & 0xFF);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void writeUTF(String paramString) {
/*  99 */     this.output.writeString(paramString);
/*     */   }
/*     */   
/*     */   public void close() {
/* 103 */     this.output.close();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\KryoDataOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */