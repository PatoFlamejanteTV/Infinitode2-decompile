/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.VertexAttribute;
/*     */ import com.badlogic.gdx.graphics.VertexAttributes;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
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
/*     */ public class VertexArray
/*     */   implements VertexData
/*     */ {
/*     */   final VertexAttributes attributes;
/*     */   final FloatBuffer buffer;
/*     */   final ByteBuffer byteBuffer;
/*     */   boolean isBound = false;
/*     */   
/*     */   public VertexArray(int paramInt, VertexAttribute... paramVarArgs) {
/*  50 */     this(paramInt, new VertexAttributes(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VertexArray(int paramInt, VertexAttributes paramVertexAttributes) {
/*  58 */     this.attributes = paramVertexAttributes;
/*  59 */     this.byteBuffer = BufferUtils.newUnsafeByteBuffer(this.attributes.vertexSize * paramInt);
/*  60 */     this.buffer = this.byteBuffer.asFloatBuffer();
/*  61 */     this.buffer.flip();
/*  62 */     this.byteBuffer.flip();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  67 */     BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FloatBuffer getBuffer() {
/*  74 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloatBuffer getBuffer(boolean paramBoolean) {
/*  79 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumVertices() {
/*  84 */     return (this.buffer.limit() << 2) / this.attributes.vertexSize;
/*     */   }
/*     */   
/*     */   public int getNumMaxVertices() {
/*  88 */     return this.byteBuffer.capacity() / this.attributes.vertexSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVertices(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  93 */     BufferUtils.copy(paramArrayOffloat, this.byteBuffer, paramInt2, paramInt1);
/*  94 */     this.buffer.position(0);
/*  95 */     this.buffer.limit(paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateVertices(int paramInt1, float[] paramArrayOffloat, int paramInt2, int paramInt3) {
/* 100 */     int i = this.byteBuffer.position();
/* 101 */     this.byteBuffer.position(paramInt1 << 2);
/* 102 */     BufferUtils.copy(paramArrayOffloat, paramInt2, paramInt3, this.byteBuffer);
/* 103 */     this.byteBuffer.position(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram) {
/* 108 */     bind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/* 113 */     int i = this.attributes.size();
/* 114 */     this.byteBuffer.limit(this.buffer.limit() << 2);
/* 115 */     if (paramArrayOfint == null) {
/* 116 */       for (byte b = 0; b < i; b++) {
/* 117 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 119 */         if ((j = paramShaderProgram.getAttributeLocation(vertexAttribute.alias)) >= 0) {
/* 120 */           paramShaderProgram.enableVertexAttribute(j);
/*     */           
/* 122 */           if (vertexAttribute.type == 5126) {
/* 123 */             this.buffer.position(vertexAttribute.offset / 4);
/* 124 */             paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, this.buffer);
/*     */           } else {
/*     */             
/* 127 */             this.byteBuffer.position(vertexAttribute.offset);
/* 128 */             paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, this.byteBuffer);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/* 133 */       for (byte b = 0; b < i; b++) {
/* 134 */         VertexAttribute vertexAttribute = this.attributes.get(b);
/*     */         int j;
/* 136 */         if ((j = paramArrayOfint[b]) >= 0) {
/* 137 */           paramShaderProgram.enableVertexAttribute(j);
/*     */           
/* 139 */           if (vertexAttribute.type == 5126) {
/* 140 */             this.buffer.position(vertexAttribute.offset / 4);
/* 141 */             paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, this.buffer);
/*     */           } else {
/*     */             
/* 144 */             this.byteBuffer.position(vertexAttribute.offset);
/* 145 */             paramShaderProgram.setVertexAttribute(j, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, this.byteBuffer);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 150 */     this.isBound = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram) {
/* 158 */     unbind(paramShaderProgram, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfint) {
/* 163 */     int i = this.attributes.size();
/* 164 */     if (paramArrayOfint == null) {
/* 165 */       for (byte b = 0; b < i; b++) {
/* 166 */         paramShaderProgram.disableVertexAttribute((this.attributes.get(b)).alias);
/*     */       }
/*     */     } else {
/* 169 */       for (byte b = 0; b < i; b++) {
/*     */         int j;
/* 171 */         if ((j = paramArrayOfint[b]) >= 0) paramShaderProgram.disableVertexAttribute(j); 
/*     */       } 
/*     */     } 
/* 174 */     this.isBound = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public VertexAttributes getAttributes() {
/* 179 */     return this.attributes;
/*     */   }
/*     */   
/*     */   public void invalidate() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\VertexArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */