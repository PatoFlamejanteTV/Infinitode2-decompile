/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.Buffer;
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
/*     */ public class InstanceBufferObject
/*     */   implements InstanceData
/*     */ {
/*     */   private VertexAttributes attributes;
/*     */   private FloatBuffer buffer;
/*     */   private ByteBuffer byteBuffer;
/*     */   private boolean ownsBuffer;
/*     */   private int bufferHandle;
/*     */   private int usage;
/*     */   boolean isDirty = false;
/*     */   boolean isBound = false;
/*     */   
/*     */   public InstanceBufferObject(boolean paramBoolean, int paramInt, VertexAttribute... paramVarArgs) {
/*  46 */     this(paramBoolean, paramInt, new VertexAttributes(paramVarArgs));
/*     */   }
/*     */   
/*     */   public InstanceBufferObject(boolean paramBoolean, int paramInt, VertexAttributes paramVertexAttributes) {
/*  50 */     if (Gdx.gl30 == null) {
/*  51 */       throw new GdxRuntimeException("InstanceBufferObject requires a device running with GLES 3.0 compatibilty");
/*     */     }
/*  53 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/*     */     
/*     */     ByteBuffer byteBuffer;
/*  56 */     (byteBuffer = BufferUtils.newUnsafeByteBuffer(paramVertexAttributes.vertexSize * paramInt)).limit(0);
/*  57 */     setBuffer(byteBuffer, true, paramVertexAttributes);
/*  58 */     setUsage(paramBoolean ? 35044 : 35048);
/*     */   }
/*     */ 
/*     */   
/*     */   public VertexAttributes getAttributes() {
/*  63 */     return this.attributes;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumInstances() {
/*  68 */     return (this.buffer.limit() << 2) / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumMaxInstances() {
/*  73 */     return this.byteBuffer.capacity() / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FloatBuffer getBuffer() {
/*  80 */     this.isDirty = true;
/*  81 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatBuffer getBuffer(boolean paramBoolean) {
/*  86 */     this.isDirty |= paramBoolean;
/*  87 */     return this.buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setBuffer(Buffer paramBuffer, boolean paramBoolean, VertexAttributes paramVertexAttributes) {
/*  96 */     if (this.isBound) throw new GdxRuntimeException("Cannot change attributes while VBO is bound"); 
/*  97 */     if (this.ownsBuffer && this.byteBuffer != null) BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer); 
/*  98 */     this.attributes = paramVertexAttributes;
/*  99 */     if (paramBuffer instanceof ByteBuffer) {
/* 100 */       this.byteBuffer = (ByteBuffer)paramBuffer;
/*     */     } else {
/* 102 */       throw new GdxRuntimeException("Only ByteBuffer is currently supported");
/* 103 */     }  this.ownsBuffer = paramBoolean;
/*     */     
/* 105 */     int i = this.byteBuffer.limit();
/* 106 */     this.byteBuffer.limit(this.byteBuffer.capacity());
/* 107 */     this.buffer = this.byteBuffer.asFloatBuffer();
/* 108 */     this.byteBuffer.limit(i);
/* 109 */     this.buffer.limit(i / 4);
/*     */   }
/*     */   
/*     */   private void bufferChanged() {
/* 113 */     if (this.isBound) {
/* 114 */       Gdx.gl20.glBufferData(34962, this.byteBuffer.limit(), null, this.usage);
/* 115 */       Gdx.gl20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 116 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInstanceData(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 122 */     this.isDirty = true;
/* 123 */     BufferUtils.copy(paramArrayOffloat, this.byteBuffer, paramInt2, paramInt1);
/* 124 */     this.buffer.position(0);
/* 125 */     this.buffer.limit(paramInt2);
/* 126 */     bufferChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInstanceData(FloatBuffer paramFloatBuffer, int paramInt) {
/* 131 */     this.isDirty = true;
/* 132 */     BufferUtils.copy(paramFloatBuffer, this.byteBuffer, paramInt);
/* 133 */     this.buffer.position(0);
/* 134 */     this.buffer.limit(paramInt);
/* 135 */     bufferChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateInstanceData(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
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
/*     */   public void updateInstanceData(int paramInt1, FloatBuffer paramFloatBuffer, int paramInt2, int paramInt3) {
/* 151 */     this.isDirty = true;
/* 152 */     int i = this.byteBuffer.position();
/* 153 */     this.byteBuffer.position(paramInt1 << 2);
/* 154 */     paramFloatBuffer.position(paramInt2 << 2);
/* 155 */     BufferUtils.copy(paramFloatBuffer, this.byteBuffer, paramInt3);
/* 156 */     this.byteBuffer.position(i);
/* 157 */     this.buffer.position(0);
/* 158 */     bufferChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getUsage() {
/* 164 */     return this.usage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setUsage(int paramInt) {
/* 170 */     if (this.isBound) throw new GdxRuntimeException("Cannot change usage while VBO is bound"); 
/* 171 */     this.usage = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram) {
/* 179 */     bind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/*     */     GL20 gL20;
/* 186 */     (gL20 = Gdx.gl20).glBindBuffer(34962, this.bufferHandle);
/* 187 */     if (this.isDirty) {
/* 188 */       this.byteBuffer.limit(this.buffer.limit() << 2);
/* 189 */       gL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 190 */       this.isDirty = false;
/*     */     } 
/*     */     
/* 193 */     int i = this.attributes.size();
/* 194 */     if (paramArrayOfint == null) {
/* 195 */       for (byte b = 0; b < i; b++) {
/* 196 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 198 */         if ((j = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) {
/* 199 */           int k = vertexAttribute.unit;
/* 200 */           paramShaderProgram.enableVertexAttribute(j + k);
/*     */           
/* 202 */           paramShaderProgram.setVertexAttribute(j + k, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */           
/* 204 */           Gdx.gl30.glVertexAttribDivisor(j + k, 1);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 208 */       for (byte b = 0; b < i; b++) {
/* 209 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 211 */         if ((j = paramArrayOfint[b]) >= 0) {
/* 212 */           int k = vertexAttribute.unit;
/* 213 */           paramShaderProgram.enableVertexAttribute(j + k);
/*     */           
/* 215 */           paramShaderProgram.setVertexAttribute(j + k, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */           
/* 217 */           Gdx.gl30.glVertexAttribDivisor(j + k, 1);
/*     */         } 
/*     */       } 
/* 220 */     }  this.isBound = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram) {
/* 228 */     unbind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/* 233 */     GL20 gL20 = Gdx.gl20;
/* 234 */     int i = this.attributes.size();
/* 235 */     if (paramArrayOfint == null)
/* 236 */     { for (byte b = 0; b < i; b++) {
/* 237 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 239 */         if ((j = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) {
/* 240 */           int k = vertexAttribute.unit;
/* 241 */           paramShaderProgram.disableVertexAttribute(j + k);
/*     */         } 
/*     */       }  }
/* 244 */     else { for (byte b = 0; b < i; b++) {
/* 245 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 247 */         if ((j = paramArrayOfint[b]) >= 0) {
/* 248 */           int k = vertexAttribute.unit;
/* 249 */           paramShaderProgram.disableVertexAttribute(j + k);
/*     */         } 
/*     */       }  }
/* 252 */      gL20.glBindBuffer(34962, 0);
/* 253 */     this.isBound = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void invalidate() {
/* 259 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/* 260 */     this.isDirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     GL20 gL20;
/* 267 */     (gL20 = Gdx.gl20).glBindBuffer(34962, 0);
/* 268 */     gL20.glDeleteBuffer(this.bufferHandle);
/* 269 */     this.bufferHandle = 0;
/* 270 */     if (this.ownsBuffer) BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\InstanceBufferObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */