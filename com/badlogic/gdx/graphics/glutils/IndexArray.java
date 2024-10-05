/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ public class IndexArray
/*     */   implements IndexData
/*     */ {
/*     */   final ShortBuffer buffer;
/*     */   final ByteBuffer byteBuffer;
/*     */   private final boolean empty;
/*     */   
/*     */   public IndexArray(int paramInt) {
/*  37 */     this.empty = (paramInt == 0);
/*  38 */     if (this.empty) {
/*  39 */       paramInt = 1;
/*     */     }
/*     */     
/*  42 */     this.byteBuffer = BufferUtils.newUnsafeByteBuffer(paramInt << 1);
/*  43 */     this.buffer = this.byteBuffer.asShortBuffer();
/*  44 */     this.buffer.flip();
/*  45 */     this.byteBuffer.flip();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumIndices() {
/*  50 */     return this.empty ? 0 : this.buffer.limit();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumMaxIndices() {
/*  55 */     return this.empty ? 0 : this.buffer.capacity();
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
/*     */ 
/*     */   
/*     */   public void setIndices(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/*  72 */     this.buffer.clear();
/*  73 */     this.buffer.put(paramArrayOfshort, paramInt1, paramInt2);
/*  74 */     this.buffer.flip();
/*  75 */     this.byteBuffer.position(0);
/*  76 */     this.byteBuffer.limit(paramInt2 << 1);
/*     */   }
/*     */   
/*     */   public void setIndices(ShortBuffer paramShortBuffer) {
/*  80 */     int i = paramShortBuffer.position();
/*  81 */     this.buffer.clear();
/*  82 */     this.buffer.limit(paramShortBuffer.remaining());
/*  83 */     this.buffer.put(paramShortBuffer);
/*  84 */     this.buffer.flip();
/*  85 */     paramShortBuffer.position(i);
/*  86 */     this.byteBuffer.position(0);
/*  87 */     this.byteBuffer.limit(this.buffer.limit() << 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateIndices(int paramInt1, short[] paramArrayOfshort, int paramInt2, int paramInt3) {
/*  92 */     int i = this.byteBuffer.position();
/*  93 */     this.byteBuffer.position(paramInt1 << 1);
/*  94 */     BufferUtils.copy(paramArrayOfshort, paramInt2, this.byteBuffer, paramInt3);
/*  95 */     this.byteBuffer.position(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ShortBuffer getBuffer() {
/* 102 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShortBuffer getBuffer(boolean paramBoolean) {
/* 107 */     return this.buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void unbind() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void invalidate() {}
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 124 */     BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\IndexArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */