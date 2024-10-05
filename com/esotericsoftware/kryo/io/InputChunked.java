/*     */ package com.esotericsoftware.kryo.io;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.IOException;
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
/*     */ public class InputChunked
/*     */   extends Input
/*     */ {
/*  32 */   private int chunkSize = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   public InputChunked() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public InputChunked(int paramInt) {
/*  41 */     super(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputChunked(InputStream paramInputStream) {
/*  46 */     super(paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputChunked(InputStream paramInputStream, int paramInt) {
/*  51 */     super(paramInputStream, paramInt);
/*     */   }
/*     */   
/*     */   public void setInputStream(InputStream paramInputStream) {
/*  55 */     super.setInputStream(paramInputStream);
/*  56 */     this.chunkSize = -1;
/*     */   }
/*     */   
/*     */   public void setBuffer(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  60 */     super.setBuffer(paramArrayOfbyte, paramInt1, paramInt2);
/*  61 */     this.chunkSize = -1;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  65 */     super.reset();
/*  66 */     this.chunkSize = -1;
/*     */   }
/*     */   
/*     */   protected int fill(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  70 */     if (this.chunkSize == -1) {
/*  71 */       if (!readChunkSize()) return -1; 
/*  72 */     } else if (this.chunkSize == 0) {
/*  73 */       return -1;
/*  74 */     }  int i = super.fill(paramArrayOfbyte, paramInt1, Math.min(this.chunkSize, paramInt2));
/*  75 */     this.chunkSize -= i;
/*  76 */     if (this.chunkSize == 0 && !readChunkSize()) return -1; 
/*  77 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean readChunkSize() {
/*     */     try {
/*  83 */       InputStream inputStream = getInputStream(); byte b; int i;
/*  84 */       for (b = 0, i = 0; b < 32; b += 7) {
/*     */         int j;
/*  86 */         if ((j = inputStream.read()) == -1) return false; 
/*  87 */         i |= (j & 0x7F) << b;
/*  88 */         if ((j & 0x80) == 0) {
/*  89 */           this.chunkSize = i;
/*  90 */           if (Log.TRACE && this.chunkSize > 0) Log.trace("kryo", "Read chunk: " + this.chunkSize); 
/*  91 */           return true;
/*     */         } 
/*     */       } 
/*  94 */     } catch (IOException iOException) {
/*  95 */       throw new KryoException("Unable to read chunk size.", iOException);
/*     */     } 
/*  97 */     throw new KryoException("Unable to read chunk size: malformed integer");
/*     */   }
/*     */ 
/*     */   
/*     */   public void nextChunk() {
/* 102 */     this.position = this.limit;
/* 103 */     if (this.chunkSize == -1) readChunkSize(); 
/* 104 */     while (this.chunkSize > 0)
/* 105 */       skip(this.chunkSize); 
/* 106 */     this.chunkSize = -1;
/* 107 */     if (Log.TRACE) Log.trace("kryo", "Next chunk."); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\InputChunked.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */