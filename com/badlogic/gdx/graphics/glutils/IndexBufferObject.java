/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IndexBufferObject
/*     */   implements IndexData
/*     */ {
/*     */   final ShortBuffer buffer;
/*     */   final ByteBuffer byteBuffer;
/*     */   final boolean ownsBuffer;
/*     */   int bufferHandle;
/*     */   final boolean isDirect;
/*     */   boolean isDirty = true;
/*     */   boolean isBound = false;
/*     */   final int usage;
/*     */   private final boolean empty;
/*     */   
/*     */   public IndexBufferObject(int paramInt) {
/*  66 */     this(true, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexBufferObject(boolean paramBoolean, int paramInt) {
/*  75 */     this.empty = (paramInt == 0);
/*  76 */     if (this.empty) {
/*  77 */       paramInt = 1;
/*     */     }
/*     */     
/*  80 */     this.byteBuffer = BufferUtils.newUnsafeByteBuffer(paramInt << 1);
/*  81 */     this.isDirect = true;
/*     */     
/*  83 */     this.buffer = this.byteBuffer.asShortBuffer();
/*  84 */     this.ownsBuffer = true;
/*  85 */     this.buffer.flip();
/*  86 */     this.byteBuffer.flip();
/*  87 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/*  88 */     this.usage = paramBoolean ? 35044 : 35048;
/*     */   }
/*     */ 
/*     */   
/*     */   public IndexBufferObject(boolean paramBoolean, ByteBuffer paramByteBuffer) {
/*  93 */     this.empty = (paramByteBuffer.limit() == 0);
/*  94 */     this.byteBuffer = paramByteBuffer;
/*  95 */     this.isDirect = true;
/*     */     
/*  97 */     this.buffer = this.byteBuffer.asShortBuffer();
/*  98 */     this.ownsBuffer = false;
/*  99 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/* 100 */     this.usage = paramBoolean ? 35044 : 35048;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumIndices() {
/* 105 */     return this.empty ? 0 : this.buffer.limit();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumMaxIndices() {
/* 110 */     return this.empty ? 0 : this.buffer.capacity();
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
/* 127 */     this.isDirty = true;
/* 128 */     this.buffer.clear();
/* 129 */     this.buffer.put(paramArrayOfshort, paramInt1, paramInt2);
/* 130 */     this.buffer.flip();
/* 131 */     this.byteBuffer.position(0);
/* 132 */     this.byteBuffer.limit(paramInt2 << 1);
/*     */     
/* 134 */     if (this.isBound) {
/* 135 */       Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 136 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setIndices(ShortBuffer paramShortBuffer) {
/* 141 */     this.isDirty = true;
/* 142 */     int i = paramShortBuffer.position();
/* 143 */     this.buffer.clear();
/* 144 */     this.buffer.put(paramShortBuffer);
/* 145 */     this.buffer.flip();
/* 146 */     paramShortBuffer.position(i);
/* 147 */     this.byteBuffer.position(0);
/* 148 */     this.byteBuffer.limit(this.buffer.limit() << 1);
/*     */     
/* 150 */     if (this.isBound) {
/* 151 */       Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 152 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateIndices(int paramInt1, short[] paramArrayOfshort, int paramInt2, int paramInt3) {
/* 158 */     this.isDirty = true;
/* 159 */     int i = this.byteBuffer.position();
/* 160 */     this.byteBuffer.position(paramInt1 << 1);
/* 161 */     BufferUtils.copy(paramArrayOfshort, paramInt2, this.byteBuffer, paramInt3);
/* 162 */     this.byteBuffer.position(i);
/* 163 */     this.buffer.position(0);
/*     */     
/* 165 */     if (this.isBound) {
/* 166 */       Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 167 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ShortBuffer getBuffer() {
/* 175 */     this.isDirty = true;
/* 176 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShortBuffer getBuffer(boolean paramBoolean) {
/* 181 */     this.isDirty |= paramBoolean;
/* 182 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind() {
/* 187 */     if (this.bufferHandle == 0) throw new GdxRuntimeException("No buffer allocated!");
/*     */     
/* 189 */     Gdx.gl20.glBindBuffer(34963, this.bufferHandle);
/* 190 */     if (this.isDirty) {
/* 191 */       this.byteBuffer.limit(this.buffer.limit() << 1);
/* 192 */       Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 193 */       this.isDirty = false;
/*     */     } 
/* 195 */     this.isBound = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void unbind() {
/* 200 */     Gdx.gl20.glBindBuffer(34963, 0);
/* 201 */     this.isBound = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidate() {
/* 206 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/* 207 */     this.isDirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 212 */     Gdx.gl20.glBindBuffer(34963, 0);
/* 213 */     Gdx.gl20.glDeleteBuffer(this.bufferHandle);
/* 214 */     this.bufferHandle = 0;
/*     */     
/* 216 */     if (this.ownsBuffer)
/* 217 */       BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\IndexBufferObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */