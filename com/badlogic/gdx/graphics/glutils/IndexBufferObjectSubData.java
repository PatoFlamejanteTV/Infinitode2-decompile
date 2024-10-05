/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class IndexBufferObjectSubData
/*     */   implements IndexData
/*     */ {
/*     */   final ShortBuffer buffer;
/*     */   final ByteBuffer byteBuffer;
/*     */   int bufferHandle;
/*     */   final boolean isDirect;
/*     */   boolean isDirty = true;
/*     */   boolean isBound = false;
/*     */   final int usage;
/*     */   
/*     */   public IndexBufferObjectSubData(boolean paramBoolean, int paramInt) {
/*  58 */     this.byteBuffer = BufferUtils.newByteBuffer(paramInt << 1);
/*  59 */     this.isDirect = true;
/*     */     
/*  61 */     this.usage = paramBoolean ? 35044 : 35048;
/*  62 */     this.buffer = this.byteBuffer.asShortBuffer();
/*  63 */     this.buffer.flip();
/*  64 */     this.byteBuffer.flip();
/*  65 */     this.bufferHandle = createBufferObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexBufferObjectSubData(int paramInt) {
/*  72 */     this.byteBuffer = BufferUtils.newByteBuffer(paramInt << 1);
/*  73 */     this.isDirect = true;
/*     */     
/*  75 */     this.usage = 35044;
/*  76 */     this.buffer = this.byteBuffer.asShortBuffer();
/*  77 */     this.buffer.flip();
/*  78 */     this.byteBuffer.flip();
/*  79 */     this.bufferHandle = createBufferObject();
/*     */   }
/*     */   
/*     */   private int createBufferObject() {
/*  83 */     int i = Gdx.gl20.glGenBuffer();
/*  84 */     Gdx.gl20.glBindBuffer(34963, i);
/*  85 */     Gdx.gl20.glBufferData(34963, this.byteBuffer.capacity(), null, this.usage);
/*  86 */     Gdx.gl20.glBindBuffer(34963, 0);
/*  87 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumIndices() {
/*  92 */     return this.buffer.limit();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumMaxIndices() {
/*  97 */     return this.buffer.capacity();
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
/* 114 */     this.isDirty = true;
/* 115 */     this.buffer.clear();
/* 116 */     this.buffer.put(paramArrayOfshort, paramInt1, paramInt2);
/* 117 */     this.buffer.flip();
/* 118 */     this.byteBuffer.position(0);
/* 119 */     this.byteBuffer.limit(paramInt2 << 1);
/*     */     
/* 121 */     if (this.isBound) {
/* 122 */       Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
/* 123 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setIndices(ShortBuffer paramShortBuffer) {
/* 128 */     int i = paramShortBuffer.position();
/* 129 */     this.isDirty = true;
/* 130 */     this.buffer.clear();
/* 131 */     this.buffer.put(paramShortBuffer);
/* 132 */     this.buffer.flip();
/* 133 */     paramShortBuffer.position(i);
/* 134 */     this.byteBuffer.position(0);
/* 135 */     this.byteBuffer.limit(this.buffer.limit() << 1);
/*     */     
/* 137 */     if (this.isBound) {
/* 138 */       Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
/* 139 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateIndices(int paramInt1, short[] paramArrayOfshort, int paramInt2, int paramInt3) {
/* 145 */     this.isDirty = true;
/* 146 */     int i = this.byteBuffer.position();
/* 147 */     this.byteBuffer.position(paramInt1 << 1);
/* 148 */     BufferUtils.copy(paramArrayOfshort, paramInt2, this.byteBuffer, paramInt3);
/* 149 */     this.byteBuffer.position(i);
/* 150 */     this.buffer.position(0);
/*     */     
/* 152 */     if (this.isBound) {
/* 153 */       Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
/* 154 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ShortBuffer getBuffer() {
/* 162 */     this.isDirty = true;
/* 163 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShortBuffer getBuffer(boolean paramBoolean) {
/* 168 */     this.isDirty |= paramBoolean;
/* 169 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind() {
/* 174 */     if (this.bufferHandle == 0) throw new GdxRuntimeException("IndexBufferObject cannot be used after it has been disposed.");
/*     */     
/* 176 */     Gdx.gl20.glBindBuffer(34963, this.bufferHandle);
/* 177 */     if (this.isDirty) {
/* 178 */       this.byteBuffer.limit(this.buffer.limit() << 1);
/* 179 */       Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
/* 180 */       this.isDirty = false;
/*     */     } 
/* 182 */     this.isBound = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void unbind() {
/* 187 */     Gdx.gl20.glBindBuffer(34963, 0);
/* 188 */     this.isBound = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidate() {
/* 193 */     this.bufferHandle = createBufferObject();
/* 194 */     this.isDirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     GL20 gL20;
/* 200 */     (gL20 = Gdx.gl20).glBindBuffer(34963, 0);
/* 201 */     gL20.glDeleteBuffer(this.bufferHandle);
/* 202 */     this.bufferHandle = 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\IndexBufferObjectSubData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */