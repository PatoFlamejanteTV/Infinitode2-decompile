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
/*     */ public class VertexBufferObject
/*     */   implements VertexData
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
/*     */   public VertexBufferObject(boolean paramBoolean, int paramInt, VertexAttribute... paramVarArgs) {
/*  58 */     this(paramBoolean, paramInt, new VertexAttributes(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VertexBufferObject(boolean paramBoolean, int paramInt, VertexAttributes paramVertexAttributes) {
/*  67 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/*     */     
/*     */     ByteBuffer byteBuffer;
/*  70 */     (byteBuffer = BufferUtils.newUnsafeByteBuffer(paramVertexAttributes.vertexSize * paramInt)).limit(0);
/*  71 */     setBuffer(byteBuffer, true, paramVertexAttributes);
/*  72 */     setUsage(paramBoolean ? 35044 : 35048);
/*     */   }
/*     */   
/*     */   protected VertexBufferObject(int paramInt, ByteBuffer paramByteBuffer, boolean paramBoolean, VertexAttributes paramVertexAttributes) {
/*  76 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/*     */     
/*  78 */     setBuffer(paramByteBuffer, paramBoolean, paramVertexAttributes);
/*  79 */     setUsage(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public VertexAttributes getAttributes() {
/*  84 */     return this.attributes;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumVertices() {
/*  89 */     return (this.buffer.limit() << 2) / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumMaxVertices() {
/*  94 */     return this.byteBuffer.capacity() / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FloatBuffer getBuffer() {
/* 101 */     this.isDirty = true;
/* 102 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatBuffer getBuffer(boolean paramBoolean) {
/* 107 */     this.isDirty |= paramBoolean;
/* 108 */     return this.buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setBuffer(Buffer paramBuffer, boolean paramBoolean, VertexAttributes paramVertexAttributes) {
/* 116 */     if (this.isBound) throw new GdxRuntimeException("Cannot change attributes while VBO is bound"); 
/* 117 */     if (this.ownsBuffer && this.byteBuffer != null) BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer); 
/* 118 */     this.attributes = paramVertexAttributes;
/* 119 */     if (paramBuffer instanceof ByteBuffer) {
/* 120 */       this.byteBuffer = (ByteBuffer)paramBuffer;
/*     */     } else {
/* 122 */       throw new GdxRuntimeException("Only ByteBuffer is currently supported");
/* 123 */     }  this.ownsBuffer = paramBoolean;
/*     */     
/* 125 */     int i = this.byteBuffer.limit();
/* 126 */     this.byteBuffer.limit(this.byteBuffer.capacity());
/* 127 */     this.buffer = this.byteBuffer.asFloatBuffer();
/* 128 */     this.byteBuffer.limit(i);
/* 129 */     this.buffer.limit(i / 4);
/*     */   }
/*     */   
/*     */   private void bufferChanged() {
/* 133 */     if (this.isBound) {
/* 134 */       Gdx.gl20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 135 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVertices(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 141 */     this.isDirty = true;
/* 142 */     BufferUtils.copy(paramArrayOffloat, this.byteBuffer, paramInt2, paramInt1);
/* 143 */     this.buffer.position(0);
/* 144 */     this.buffer.limit(paramInt2);
/* 145 */     bufferChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateVertices(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 150 */     this.isDirty = true;
/* 151 */     int i = this.byteBuffer.position();
/* 152 */     this.byteBuffer.position(paramInt1 << 2);
/* 153 */     BufferUtils.copy(paramArrayOffloat, paramInt2, paramInt3, this.byteBuffer);
/* 154 */     this.byteBuffer.position(i);
/* 155 */     this.buffer.position(0);
/* 156 */     bufferChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getUsage() {
/* 162 */     return this.usage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setUsage(int paramInt) {
/* 168 */     if (this.isBound) throw new GdxRuntimeException("Cannot change usage while VBO is bound"); 
/* 169 */     this.usage = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram) {
/* 176 */     bind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/*     */     GL20 gL20;
/* 183 */     (gL20 = Gdx.gl20).glBindBuffer(34962, this.bufferHandle);
/* 184 */     if (this.isDirty) {
/* 185 */       this.byteBuffer.limit(this.buffer.limit() << 2);
/* 186 */       gL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 187 */       this.isDirty = false;
/*     */     } 
/*     */     
/* 190 */     int i = this.attributes.size();
/* 191 */     if (paramArrayOfint == null) {
/* 192 */       for (byte b = 0; b < i; b++) {
/* 193 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 195 */         if ((j = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) {
/* 196 */           paramShaderProgram.enableVertexAttribute(j);
/*     */           
/* 198 */           paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 203 */       for (byte b = 0; b < i; b++) {
/* 204 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 206 */         if ((j = paramArrayOfint[b]) >= 0) {
/* 207 */           paramShaderProgram.enableVertexAttribute(j);
/*     */           
/* 209 */           paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */         } 
/*     */       } 
/*     */     } 
/* 213 */     this.isBound = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram) {
/* 221 */     unbind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/* 226 */     GL20 gL20 = Gdx.gl20;
/* 227 */     int i = this.attributes.size();
/* 228 */     if (paramArrayOfint == null) {
/* 229 */       for (byte b = 0; b < i; b++) {
/* 230 */         paramShaderProgram.disableVertexAttribute((this.attributes.get(b)).alias);
/*     */       }
/*     */     } else {
/* 233 */       for (byte b = 0; b < i; b++) {
/*     */         int j;
/* 235 */         if ((j = paramArrayOfint[b]) >= 0) paramShaderProgram.disableVertexAttribute(j); 
/*     */       } 
/*     */     } 
/* 238 */     gL20.glBindBuffer(34962, 0);
/* 239 */     this.isBound = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void invalidate() {
/* 245 */     this.bufferHandle = Gdx.gl20.glGenBuffer();
/* 246 */     this.isDirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     GL20 gL20;
/* 253 */     (gL20 = Gdx.gl20).glBindBuffer(34962, 0);
/* 254 */     gL20.glDeleteBuffer(this.bufferHandle);
/* 255 */     this.bufferHandle = 0;
/* 256 */     if (this.ownsBuffer) BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\VertexBufferObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */