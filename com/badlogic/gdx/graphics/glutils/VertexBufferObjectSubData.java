/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
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
/*     */ public class VertexBufferObjectSubData
/*     */   implements VertexData
/*     */ {
/*     */   final VertexAttributes attributes;
/*     */   final FloatBuffer buffer;
/*     */   final ByteBuffer byteBuffer;
/*     */   int bufferHandle;
/*     */   final boolean isDirect;
/*     */   final boolean isStatic;
/*     */   final int usage;
/*     */   boolean isDirty = false;
/*     */   boolean isBound = false;
/*     */   
/*     */   public VertexBufferObjectSubData(boolean paramBoolean, int paramInt, VertexAttribute... paramVarArgs) {
/*  59 */     this(paramBoolean, paramInt, new VertexAttributes(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VertexBufferObjectSubData(boolean paramBoolean, int paramInt, VertexAttributes paramVertexAttributes) {
/*  68 */     this.isStatic = paramBoolean;
/*  69 */     this.attributes = paramVertexAttributes;
/*  70 */     this.byteBuffer = BufferUtils.newByteBuffer(this.attributes.vertexSize * paramInt);
/*  71 */     this.isDirect = true;
/*     */     
/*  73 */     this.usage = paramBoolean ? 35044 : 35048;
/*  74 */     this.buffer = this.byteBuffer.asFloatBuffer();
/*  75 */     this.bufferHandle = createBufferObject();
/*  76 */     this.buffer.flip();
/*  77 */     this.byteBuffer.flip();
/*     */   }
/*     */   
/*     */   private int createBufferObject() {
/*  81 */     int i = Gdx.gl20.glGenBuffer();
/*  82 */     Gdx.gl20.glBindBuffer(34962, i);
/*  83 */     Gdx.gl20.glBufferData(34962, this.byteBuffer.capacity(), null, this.usage);
/*  84 */     Gdx.gl20.glBindBuffer(34962, 0);
/*  85 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public VertexAttributes getAttributes() {
/*  90 */     return this.attributes;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumVertices() {
/*  95 */     return (this.buffer.limit() << 2) / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumMaxVertices() {
/* 100 */     return this.byteBuffer.capacity() / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FloatBuffer getBuffer() {
/* 107 */     this.isDirty = true;
/* 108 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatBuffer getBuffer(boolean paramBoolean) {
/* 113 */     this.isDirty |= paramBoolean;
/* 114 */     return this.buffer;
/*     */   }
/*     */   
/*     */   private void bufferChanged() {
/* 118 */     if (this.isBound) {
/* 119 */       Gdx.gl20.glBufferSubData(34962, 0, this.byteBuffer.limit(), this.byteBuffer);
/* 120 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVertices(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 126 */     this.isDirty = true;
/* 127 */     if (this.isDirect) {
/* 128 */       BufferUtils.copy(paramArrayOffloat, this.byteBuffer, paramInt2, paramInt1);
/* 129 */       this.buffer.position(0);
/* 130 */       this.buffer.limit(paramInt2);
/*     */     } else {
/* 132 */       this.buffer.clear();
/* 133 */       this.buffer.put(paramArrayOffloat, paramInt1, paramInt2);
/* 134 */       this.buffer.flip();
/* 135 */       this.byteBuffer.position(0);
/* 136 */       this.byteBuffer.limit(this.buffer.limit() << 2);
/*     */     } 
/*     */     
/* 139 */     bufferChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateVertices(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 144 */     this.isDirty = true;
/* 145 */     if (this.isDirect) {
/* 146 */       int i = this.byteBuffer.position();
/* 147 */       this.byteBuffer.position(paramInt1 << 2);
/* 148 */       BufferUtils.copy(paramArrayOffloat, paramInt2, paramInt3, this.byteBuffer);
/* 149 */       this.byteBuffer.position(i);
/*     */     } else {
/* 151 */       throw new GdxRuntimeException("Buffer must be allocated direct.");
/*     */     } 
/* 153 */     bufferChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram) {
/* 161 */     bind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/*     */     GL20 gL20;
/* 168 */     (gL20 = Gdx.gl20).glBindBuffer(34962, this.bufferHandle);
/* 169 */     if (this.isDirty) {
/* 170 */       this.byteBuffer.limit(this.buffer.limit() << 2);
/* 171 */       gL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 172 */       this.isDirty = false;
/*     */     } 
/*     */     
/* 175 */     int i = this.attributes.size();
/* 176 */     if (paramArrayOfint == null) {
/* 177 */       for (byte b = 0; b < i; b++) {
/* 178 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 180 */         if ((j = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) {
/* 181 */           paramShaderProgram.enableVertexAttribute(j);
/*     */           
/* 183 */           paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 187 */       for (byte b = 0; b < i; b++) {
/* 188 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 190 */         if ((j = paramArrayOfint[b]) >= 0) {
/* 191 */           paramShaderProgram.enableVertexAttribute(j);
/*     */           
/* 193 */           paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */         } 
/*     */       } 
/*     */     } 
/* 197 */     this.isBound = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram) {
/* 205 */     unbind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/* 210 */     GL20 gL20 = Gdx.gl20;
/* 211 */     int i = this.attributes.size();
/* 212 */     if (paramArrayOfint == null) {
/* 213 */       for (byte b = 0; b < i; b++) {
/* 214 */         paramShaderProgram.disableVertexAttribute((this.attributes.get(b)).alias);
/*     */       }
/*     */     } else {
/* 217 */       for (byte b = 0; b < i; b++) {
/*     */         int j;
/* 219 */         if ((j = paramArrayOfint[b]) >= 0) paramShaderProgram.disableVertexAttribute(j); 
/*     */       } 
/*     */     } 
/* 222 */     gL20.glBindBuffer(34962, 0);
/* 223 */     this.isBound = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidate() {
/* 228 */     this.bufferHandle = createBufferObject();
/* 229 */     this.isDirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     GL20 gL20;
/* 236 */     (gL20 = Gdx.gl20).glBindBuffer(34962, 0);
/* 237 */     gL20.glDeleteBuffer(this.bufferHandle);
/* 238 */     this.bufferHandle = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBufferHandle() {
/* 244 */     return this.bufferHandle;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\VertexBufferObjectSubData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */