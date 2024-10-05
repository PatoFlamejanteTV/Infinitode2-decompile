/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.graphics.GL30;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ public class VertexBufferObjectWithVAO
/*     */   implements VertexData
/*     */ {
/*  36 */   static final IntBuffer tmpHandle = BufferUtils.newIntBuffer(1);
/*     */   
/*     */   final VertexAttributes attributes;
/*     */   final FloatBuffer buffer;
/*     */   final ByteBuffer byteBuffer;
/*     */   final boolean ownsBuffer;
/*     */   int bufferHandle;
/*     */   final boolean isStatic;
/*     */   final int usage;
/*     */   boolean isDirty = false;
/*     */   boolean isBound = false;
/*  47 */   int vaoHandle = -1;
/*  48 */   IntArray cachedLocations = new IntArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VertexBufferObjectWithVAO(boolean paramBoolean, int paramInt, VertexAttribute... paramVarArgs) {
/*  56 */     this(paramBoolean, paramInt, new VertexAttributes(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VertexBufferObjectWithVAO(boolean paramBoolean, int paramInt, VertexAttributes paramVertexAttributes) {
/*  65 */     this.isStatic = paramBoolean;
/*  66 */     this.attributes = paramVertexAttributes;
/*     */     
/*  68 */     this.byteBuffer = BufferUtils.newUnsafeByteBuffer(this.attributes.vertexSize * paramInt);
/*  69 */     this.buffer = this.byteBuffer.asFloatBuffer();
/*  70 */     this.ownsBuffer = true;
/*  71 */     this.buffer.flip();
/*  72 */     this.byteBuffer.flip();
/*  73 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/*  74 */     this.usage = paramBoolean ? 35044 : 35048;
/*  75 */     createVAO();
/*     */   }
/*     */   
/*     */   public VertexBufferObjectWithVAO(boolean paramBoolean, ByteBuffer paramByteBuffer, VertexAttributes paramVertexAttributes) {
/*  79 */     this.isStatic = paramBoolean;
/*  80 */     this.attributes = paramVertexAttributes;
/*     */     
/*  82 */     this.byteBuffer = paramByteBuffer;
/*  83 */     this.ownsBuffer = false;
/*  84 */     this.buffer = this.byteBuffer.asFloatBuffer();
/*  85 */     this.buffer.flip();
/*  86 */     this.byteBuffer.flip();
/*  87 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/*  88 */     this.usage = paramBoolean ? 35044 : 35048;
/*  89 */     createVAO();
/*     */   }
/*     */ 
/*     */   
/*     */   public VertexAttributes getAttributes() {
/*  94 */     return this.attributes;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumVertices() {
/*  99 */     return (this.buffer.limit() << 2) / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumMaxVertices() {
/* 104 */     return this.byteBuffer.capacity() / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FloatBuffer getBuffer() {
/* 111 */     this.isDirty = true;
/* 112 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatBuffer getBuffer(boolean paramBoolean) {
/* 117 */     this.isDirty |= paramBoolean;
/* 118 */     return this.buffer;
/*     */   }
/*     */   
/*     */   private void bufferChanged() {
/* 122 */     if (this.isBound) {
/* 123 */       Gdx.gl20.glBindBuffer(34962, this.bufferHandle);
/* 124 */       Gdx.gl20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 125 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVertices(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 131 */     this.isDirty = true;
/* 132 */     BufferUtils.copy(paramArrayOffloat, this.byteBuffer, paramInt2, paramInt1);
/* 133 */     this.buffer.position(0);
/* 134 */     this.buffer.limit(paramInt2);
/* 135 */     bufferChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateVertices(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 140 */     this.isDirty = true;
/* 141 */     int i = this.byteBuffer.position();
/* 142 */     this.byteBuffer.position(paramInt1 << 2);
/* 143 */     BufferUtils.copy(paramArrayOffloat, paramInt2, paramInt3, this.byteBuffer);
/* 144 */     this.byteBuffer.position(i);
/* 145 */     this.buffer.position(0);
/* 146 */     bufferChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram) {
/* 154 */     bind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/*     */     GL30 gL30;
/* 161 */     (gL30 = Gdx.gl30).glBindVertexArray(this.vaoHandle);
/*     */     
/* 163 */     bindAttributes(paramShaderProgram, paramArrayOfint);
/*     */ 
/*     */     
/* 166 */     bindData((GL20)gL30);
/*     */     
/* 168 */     this.isBound = true;
/*     */   }
/*     */   
/*     */   private void bindAttributes(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/* 172 */     boolean bool = (this.cachedLocations.size != 0) ? true : false;
/* 173 */     int i = this.attributes.size();
/*     */     
/* 175 */     if (bool) {
/* 176 */       if (paramArrayOfint == null) {
/* 177 */         for (byte b = 0; bool && b < i; b++) {
/* 178 */           VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */           int j;
/* 180 */           boolean bool1 = ((j = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) == this.cachedLocations.get(b)) ? true : false;
/*     */         } 
/*     */       } else {
/* 183 */         bool = (paramArrayOfint.length == this.cachedLocations.size) ? true : false;
/* 184 */         for (byte b = 0; bool && b < i; b++) {
/* 185 */           bool = (paramArrayOfint[b] == this.cachedLocations.get(b)) ? true : false;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 190 */     if (!bool) {
/* 191 */       Gdx.gl.glBindBuffer(34962, this.bufferHandle);
/* 192 */       unbindAttributes(paramShaderProgram);
/* 193 */       this.cachedLocations.clear();
/*     */       
/* 195 */       for (byte b = 0; b < i; b++) {
/* 196 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/* 197 */         if (paramArrayOfint == null) {
/* 198 */           this.cachedLocations.add(paramShaderProgram.getAttributeLocation(vertexAttribute.alias));
/*     */         } else {
/* 200 */           this.cachedLocations.add(paramArrayOfint[b]);
/*     */         } 
/*     */         
/*     */         int j;
/* 204 */         if ((j = this.cachedLocations.get(b)) >= 0) {
/*     */ 
/*     */ 
/*     */           
/* 208 */           paramShaderProgram.enableVertexAttribute(j);
/* 209 */           paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void unbindAttributes(ShaderProgram paramShaderProgram) {
/* 216 */     if (this.cachedLocations.size == 0) {
/*     */       return;
/*     */     }
/* 219 */     int i = this.attributes.size();
/* 220 */     for (byte b = 0; b < i; b++) {
/*     */       int j;
/* 222 */       if ((j = this.cachedLocations.get(b)) >= 0)
/*     */       {
/*     */         
/* 225 */         paramShaderProgram.disableVertexAttribute(j); } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bindData(GL20 paramGL20) {
/* 230 */     if (this.isDirty) {
/* 231 */       paramGL20.glBindBuffer(34962, this.bufferHandle);
/* 232 */       this.byteBuffer.limit(this.buffer.limit() << 2);
/* 233 */       paramGL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 234 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram) {
/* 243 */     unbind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/*     */     GL30 gL30;
/* 249 */     (gL30 = Gdx.gl30).glBindVertexArray(0);
/* 250 */     this.isBound = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void invalidate() {
/* 256 */     this.bufferHandle = Gdx.gl30.glGenBuffer();
/* 257 */     createVAO();
/* 258 */     this.isDirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     GL30 gL30;
/* 266 */     (gL30 = Gdx.gl30).glBindBuffer(34962, 0);
/* 267 */     gL30.glDeleteBuffer(this.bufferHandle);
/* 268 */     this.bufferHandle = 0;
/* 269 */     if (this.ownsBuffer) {
/* 270 */       BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
/*     */     }
/* 272 */     deleteVAO();
/*     */   }
/*     */   
/*     */   private void createVAO() {
/* 276 */     tmpHandle.clear();
/* 277 */     Gdx.gl30.glGenVertexArrays(1, tmpHandle);
/* 278 */     this.vaoHandle = tmpHandle.get();
/*     */   }
/*     */   
/*     */   private void deleteVAO() {
/* 282 */     if (this.vaoHandle != -1) {
/* 283 */       tmpHandle.clear();
/* 284 */       tmpHandle.put(this.vaoHandle);
/* 285 */       tmpHandle.flip();
/* 286 */       Gdx.gl30.glDeleteVertexArrays(1, tmpHandle);
/* 287 */       this.vaoHandle = -1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\VertexBufferObjectWithVAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */