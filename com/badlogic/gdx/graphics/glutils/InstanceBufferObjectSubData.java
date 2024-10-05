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
/*     */ public class InstanceBufferObjectSubData
/*     */   implements InstanceData
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
/*     */   public InstanceBufferObjectSubData(boolean paramBoolean, int paramInt, VertexAttribute... paramVarArgs) {
/*  52 */     this(paramBoolean, paramInt, new VertexAttributes(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InstanceBufferObjectSubData(boolean paramBoolean, int paramInt, VertexAttributes paramVertexAttributes) {
/*  61 */     this.isStatic = paramBoolean;
/*  62 */     this.attributes = paramVertexAttributes;
/*  63 */     this.byteBuffer = BufferUtils.newByteBuffer(this.attributes.vertexSize * paramInt);
/*  64 */     this.isDirect = true;
/*     */     
/*  66 */     this.usage = paramBoolean ? 35044 : 35048;
/*  67 */     this.buffer = this.byteBuffer.asFloatBuffer();
/*  68 */     this.bufferHandle = createBufferObject();
/*  69 */     this.buffer.flip();
/*  70 */     this.byteBuffer.flip();
/*     */   }
/*     */   
/*     */   private int createBufferObject() {
/*  74 */     int i = Gdx.gl20.glGenBuffer();
/*  75 */     Gdx.gl20.glBindBuffer(34962, i);
/*  76 */     Gdx.gl20.glBufferData(34962, this.byteBuffer.capacity(), null, this.usage);
/*  77 */     Gdx.gl20.glBindBuffer(34962, 0);
/*  78 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public VertexAttributes getAttributes() {
/*  83 */     return this.attributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumInstances() {
/*  91 */     return (this.buffer.limit() << 2) / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumMaxInstances() {
/*  99 */     return this.byteBuffer.capacity() / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FloatBuffer getBuffer() {
/* 106 */     this.isDirty = true;
/* 107 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatBuffer getBuffer(boolean paramBoolean) {
/* 112 */     this.isDirty |= paramBoolean;
/* 113 */     return this.buffer;
/*     */   }
/*     */   
/*     */   private void bufferChanged() {
/* 117 */     if (this.isBound) {
/* 118 */       Gdx.gl20.glBufferData(34962, this.byteBuffer.limit(), null, this.usage);
/* 119 */       Gdx.gl20.glBufferSubData(34962, 0, this.byteBuffer.limit(), this.byteBuffer);
/* 120 */       this.isDirty = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInstanceData(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
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
/*     */   public void setInstanceData(FloatBuffer paramFloatBuffer, int paramInt) {
/* 144 */     this.isDirty = true;
/* 145 */     if (this.isDirect) {
/* 146 */       BufferUtils.copy(paramFloatBuffer, this.byteBuffer, paramInt);
/* 147 */       this.buffer.position(0);
/* 148 */       this.buffer.limit(paramInt);
/*     */     } else {
/* 150 */       this.buffer.clear();
/* 151 */       this.buffer.put(paramFloatBuffer);
/* 152 */       this.buffer.flip();
/* 153 */       this.byteBuffer.position(0);
/* 154 */       this.byteBuffer.limit(this.buffer.limit() << 2);
/*     */     } 
/*     */     
/* 157 */     bufferChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateInstanceData(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 162 */     this.isDirty = true;
/* 163 */     if (this.isDirect) {
/* 164 */       int i = this.byteBuffer.position();
/* 165 */       this.byteBuffer.position(paramInt1 << 2);
/* 166 */       BufferUtils.copy(paramArrayOffloat, paramInt2, paramInt3, this.byteBuffer);
/* 167 */       this.byteBuffer.position(i);
/*     */     } else {
/* 169 */       throw new GdxRuntimeException("Buffer must be allocated direct.");
/*     */     } 
/* 171 */     bufferChanged();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateInstanceData(int paramInt1, FloatBuffer paramFloatBuffer, int paramInt2, int paramInt3) {
/* 176 */     this.isDirty = true;
/* 177 */     if (this.isDirect) {
/* 178 */       int i = this.byteBuffer.position();
/* 179 */       this.byteBuffer.position(paramInt1 << 2);
/* 180 */       paramFloatBuffer.position(paramInt2 << 2);
/* 181 */       BufferUtils.copy(paramFloatBuffer, this.byteBuffer, paramInt3);
/* 182 */       this.byteBuffer.position(i);
/*     */     } else {
/* 184 */       throw new GdxRuntimeException("Buffer must be allocated direct.");
/*     */     } 
/* 186 */     bufferChanged();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram) {
/* 194 */     bind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/*     */     GL20 gL20;
/* 201 */     (gL20 = Gdx.gl20).glBindBuffer(34962, this.bufferHandle);
/* 202 */     if (this.isDirty) {
/* 203 */       this.byteBuffer.limit(this.buffer.limit() << 2);
/* 204 */       gL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
/* 205 */       this.isDirty = false;
/*     */     } 
/*     */     
/* 208 */     int i = this.attributes.size();
/* 209 */     if (paramArrayOfint == null)
/* 210 */     { for (byte b = 0; b < i; b++) {
/* 211 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 213 */         if ((j = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) {
/* 214 */           int k = vertexAttribute.unit;
/* 215 */           paramShaderProgram.enableVertexAttribute(j + k);
/*     */           
/* 217 */           paramShaderProgram.setVertexAttribute(j + k, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */           
/* 219 */           Gdx.gl30.glVertexAttribDivisor(j + k, 1);
/*     */         } 
/*     */       }  }
/* 222 */     else { for (byte b = 0; b < i; b++) {
/* 223 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 225 */         if ((j = paramArrayOfint[b]) >= 0) {
/* 226 */           int k = vertexAttribute.unit;
/* 227 */           paramShaderProgram.enableVertexAttribute(j + k);
/*     */           
/* 229 */           paramShaderProgram.setVertexAttribute(j + k, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
/*     */           
/* 231 */           Gdx.gl30.glVertexAttribDivisor(j + k, 1);
/*     */         } 
/*     */       }  }
/* 234 */      this.isBound = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram) {
/* 242 */     unbind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/* 247 */     GL20 gL20 = Gdx.gl20;
/* 248 */     int i = this.attributes.size();
/* 249 */     if (paramArrayOfint == null)
/* 250 */     { for (byte b = 0; b < i; b++) {
/* 251 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 253 */         if ((j = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) {
/* 254 */           int k = vertexAttribute.unit;
/* 255 */           paramShaderProgram.disableVertexAttribute(j + k);
/*     */         } 
/*     */       }  }
/* 258 */     else { for (byte b = 0; b < i; b++) {
/* 259 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 261 */         if ((j = paramArrayOfint[b]) >= 0) {
/* 262 */           int k = vertexAttribute.unit;
/* 263 */           paramShaderProgram.enableVertexAttribute(j + k);
/*     */         } 
/*     */       }  }
/* 266 */      gL20.glBindBuffer(34962, 0);
/* 267 */     this.isBound = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidate() {
/* 272 */     this.bufferHandle = createBufferObject();
/* 273 */     this.isDirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     GL20 gL20;
/* 280 */     (gL20 = Gdx.gl20).glBindBuffer(34962, 0);
/* 281 */     gL20.glDeleteBuffer(this.bufferHandle);
/* 282 */     this.bufferHandle = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBufferHandle() {
/* 289 */     return this.bufferHandle;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\InstanceBufferObjectSubData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */