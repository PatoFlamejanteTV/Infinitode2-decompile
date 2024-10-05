/*     */ package com.esotericsoftware.kryo.io;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.io.IOException;
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
/*     */ public class OutputChunked
/*     */   extends Output
/*     */ {
/*     */   public OutputChunked() {}
/*     */   
/*     */   public OutputChunked(int paramInt) {
/*  40 */     super(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputChunked(OutputStream paramOutputStream) {
/*  45 */     super(paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputChunked(OutputStream paramOutputStream, int paramInt) {
/*  50 */     super(paramOutputStream, paramInt);
/*     */   }
/*     */   
/*     */   public void flush() {
/*  54 */     if (position() > 0) {
/*     */       try {
/*  56 */         writeChunkSize();
/*  57 */         super.flush(); return;
/*  58 */       } catch (IOException iOException) {
/*  59 */         throw new KryoException(iOException);
/*     */       } 
/*     */     }
/*  62 */     super.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeChunkSize() {
/*  67 */     int i = position();
/*  68 */     if (Log.TRACE) Log.trace("kryo", "Write chunk: " + i + Util.pos(i)); 
/*  69 */     OutputStream outputStream = getOutputStream();
/*  70 */     if ((i & 0xFFFFFF80) == 0) {
/*  71 */       outputStream.write(i);
/*     */       return;
/*     */     } 
/*  74 */     outputStream.write(i & 0x7F | 0x80);
/*     */     
/*  76 */     if (((i = i >>> 7) & 0xFFFFFF80) == 0) {
/*  77 */       outputStream.write(i);
/*     */       return;
/*     */     } 
/*  80 */     outputStream.write(i & 0x7F | 0x80);
/*     */     
/*  82 */     if (((i = i >>> 7) & 0xFFFFFF80) == 0) {
/*  83 */       outputStream.write(i);
/*     */       return;
/*     */     } 
/*  86 */     outputStream.write(i & 0x7F | 0x80);
/*     */     
/*  88 */     if (((i = i >>> 7) & 0xFFFFFF80) == 0) {
/*  89 */       outputStream.write(i);
/*     */       return;
/*     */     } 
/*  92 */     outputStream.write(i & 0x7F | 0x80);
/*  93 */     i >>>= 7;
/*  94 */     outputStream.write(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void endChunk() {
/*  99 */     flush();
/* 100 */     if (Log.TRACE) Log.trace("kryo", "End chunk."); 
/*     */     try {
/* 102 */       getOutputStream().write(0); return;
/* 103 */     } catch (IOException iOException) {
/* 104 */       throw new KryoException(iOException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\io\OutputChunked.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */