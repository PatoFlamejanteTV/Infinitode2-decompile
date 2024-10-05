/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.GL30;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL12;
/*     */ import org.lwjgl.opengl.GL15;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import org.lwjgl.opengl.GL21;
/*     */ import org.lwjgl.opengl.GL30;
/*     */ import org.lwjgl.opengl.GL31;
/*     */ import org.lwjgl.opengl.GL32;
/*     */ import org.lwjgl.opengl.GL33;
/*     */ import org.lwjgl.opengl.GL40;
/*     */ import org.lwjgl.opengl.GL41;
/*     */ import org.lwjgl.opengl.GL43;
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
/*     */ class Lwjgl3GL30
/*     */   extends Lwjgl3GL20
/*     */   implements GL30
/*     */ {
/*     */   public void glReadBuffer(int paramInt) {
/*  45 */     GL11.glReadBuffer(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawRangeElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Buffer paramBuffer) {
/*  50 */     if (paramBuffer instanceof ByteBuffer) {
/*  51 */       GL12.glDrawRangeElements(paramInt1, paramInt2, paramInt3, (ByteBuffer)paramBuffer); return;
/*  52 */     }  if (paramBuffer instanceof ShortBuffer) {
/*  53 */       GL12.glDrawRangeElements(paramInt1, paramInt2, paramInt3, (ShortBuffer)paramBuffer); return;
/*  54 */     }  if (paramBuffer instanceof IntBuffer) {
/*  55 */       GL12.glDrawRangeElements(paramInt1, paramInt2, paramInt3, (IntBuffer)paramBuffer); return;
/*     */     } 
/*  57 */     throw new GdxRuntimeException("indices must be byte, short or int buffer");
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawRangeElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  62 */     GL12.glDrawRangeElements(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
/*  68 */     GL11.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glTexImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, Buffer paramBuffer) {
/*  74 */     if (paramBuffer == null) {
/*  75 */       GL12.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, (ByteBuffer)null); return;
/*  76 */     }  if (paramBuffer instanceof ByteBuffer) {
/*  77 */       GL12.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, (ByteBuffer)paramBuffer); return;
/*  78 */     }  if (paramBuffer instanceof ShortBuffer) {
/*  79 */       GL12.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, (ShortBuffer)paramBuffer); return;
/*  80 */     }  if (paramBuffer instanceof IntBuffer) {
/*  81 */       GL12.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, (IntBuffer)paramBuffer); return;
/*  82 */     }  if (paramBuffer instanceof FloatBuffer) {
/*  83 */       GL12.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, (FloatBuffer)paramBuffer); return;
/*  84 */     }  if (paramBuffer instanceof DoubleBuffer) {
/*  85 */       GL12.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, (DoubleBuffer)paramBuffer); return;
/*     */     } 
/*  87 */     throw new GdxRuntimeException("Can't use " + paramBuffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void glTexImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
/*  94 */     GL12.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
/* 100 */     GL11.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, Buffer paramBuffer) {
/* 106 */     if (paramBuffer instanceof ByteBuffer) {
/* 107 */       GL12.glTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, (ByteBuffer)paramBuffer); return;
/* 108 */     }  if (paramBuffer instanceof ShortBuffer) {
/* 109 */       GL12.glTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, (ShortBuffer)paramBuffer); return;
/* 110 */     }  if (paramBuffer instanceof IntBuffer) {
/* 111 */       GL12.glTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, (IntBuffer)paramBuffer); return;
/* 112 */     }  if (paramBuffer instanceof FloatBuffer) {
/* 113 */       GL12.glTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, (FloatBuffer)paramBuffer); return;
/* 114 */     }  if (paramBuffer instanceof DoubleBuffer) {
/* 115 */       GL12.glTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, (DoubleBuffer)paramBuffer); return;
/*     */     } 
/* 117 */     throw new GdxRuntimeException("Can't use " + paramBuffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void glTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11) {
/* 124 */     GL12.glTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glCopyTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
/* 130 */     GL12.glCopyTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenQueries(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 135 */     for (int i = paramInt2; i < paramInt2 + paramInt1; i++) {
/* 136 */       paramArrayOfint[i] = GL15.glGenQueries();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenQueries(int paramInt, IntBuffer paramIntBuffer) {
/* 142 */     for (byte b = 0; b < paramInt; b++) {
/* 143 */       paramIntBuffer.put(GL15.glGenQueries());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteQueries(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 149 */     for (int i = paramInt2; i < paramInt2 + paramInt1; i++) {
/* 150 */       GL15.glDeleteQueries(paramArrayOfint[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteQueries(int paramInt, IntBuffer paramIntBuffer) {
/* 156 */     for (byte b = 0; b < paramInt; b++) {
/* 157 */       GL15.glDeleteQueries(paramIntBuffer.get());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glIsQuery(int paramInt) {
/* 163 */     return GL15.glIsQuery(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBeginQuery(int paramInt1, int paramInt2) {
/* 168 */     GL15.glBeginQuery(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glEndQuery(int paramInt) {
/* 173 */     GL15.glEndQuery(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetQueryiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 178 */     GL15.glGetQueryiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetQueryObjectuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 183 */     GL15.glGetQueryObjectuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glUnmapBuffer(int paramInt) {
/* 188 */     return GL15.glUnmapBuffer(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Buffer glGetBufferPointerv(int paramInt1, int paramInt2) {
/* 195 */     throw new UnsupportedOperationException("Not implemented");
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawBuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 200 */     int i = paramIntBuffer.limit();
/* 201 */     paramIntBuffer.limit(paramInt);
/* 202 */     GL20.glDrawBuffers(paramIntBuffer);
/* 203 */     paramIntBuffer.limit(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniformMatrix2x3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 208 */     GL21.glUniformMatrix2x3fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniformMatrix3x2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 213 */     GL21.glUniformMatrix3x2fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniformMatrix2x4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 218 */     GL21.glUniformMatrix2x4fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniformMatrix4x2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 223 */     GL21.glUniformMatrix4x2fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniformMatrix3x4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 228 */     GL21.glUniformMatrix3x4fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniformMatrix4x3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 233 */     GL21.glUniformMatrix4x3fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glBlitFramebuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
/* 239 */     GL30.glBlitFramebuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindFramebuffer(int paramInt1, int paramInt2) {
/* 244 */     GL30.glBindFramebuffer(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindRenderbuffer(int paramInt1, int paramInt2) {
/* 249 */     GL30.glBindRenderbuffer(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glCheckFramebufferStatus(int paramInt) {
/* 254 */     return GL30.glCheckFramebufferStatus(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteFramebuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 259 */     GL30.glDeleteFramebuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteFramebuffer(int paramInt) {
/* 264 */     GL30.glDeleteFramebuffers(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteRenderbuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 269 */     GL30.glDeleteRenderbuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteRenderbuffer(int paramInt) {
/* 274 */     GL30.glDeleteRenderbuffers(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenerateMipmap(int paramInt) {
/* 279 */     GL30.glGenerateMipmap(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenFramebuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 284 */     GL30.glGenFramebuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glGenFramebuffer() {
/* 289 */     return GL30.glGenFramebuffers();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenRenderbuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 294 */     GL30.glGenRenderbuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glGenRenderbuffer() {
/* 299 */     return GL30.glGenRenderbuffers();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetRenderbufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 304 */     GL30.glGetRenderbufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glIsFramebuffer(int paramInt) {
/* 309 */     return GL30.glIsFramebuffer(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glIsRenderbuffer(int paramInt) {
/* 314 */     return GL30.glIsRenderbuffer(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glRenderbufferStorage(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 319 */     GL30.glRenderbufferStorage(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glRenderbufferStorageMultisample(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 324 */     GL30.glRenderbufferStorageMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glFramebufferTexture2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 329 */     GL30.glFramebufferTexture2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glFramebufferRenderbuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 334 */     GL30.glFramebufferRenderbuffer(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glFramebufferTextureLayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 339 */     GL30.glFramebufferTextureLayer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public Buffer glMapBufferRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 344 */     return GL30.glMapBufferRange(paramInt1, paramInt2, paramInt3, paramInt4, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glFlushMappedBufferRange(int paramInt1, int paramInt2, int paramInt3) {
/* 349 */     GL30.glFlushMappedBufferRange(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindVertexArray(int paramInt) {
/* 354 */     GL30.glBindVertexArray(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteVertexArrays(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 359 */     for (int i = paramInt2; i < paramInt2 + paramInt1; i++) {
/* 360 */       GL30.glDeleteVertexArrays(paramArrayOfint[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteVertexArrays(int paramInt, IntBuffer paramIntBuffer) {
/* 366 */     GL30.glDeleteVertexArrays(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenVertexArrays(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 371 */     for (int i = paramInt2; i < paramInt2 + paramInt1; i++) {
/* 372 */       paramArrayOfint[i] = GL30.glGenVertexArrays();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenVertexArrays(int paramInt, IntBuffer paramIntBuffer) {
/* 378 */     GL30.glGenVertexArrays(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glIsVertexArray(int paramInt) {
/* 383 */     return GL30.glIsVertexArray(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBeginTransformFeedback(int paramInt) {
/* 388 */     GL30.glBeginTransformFeedback(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glEndTransformFeedback() {
/* 393 */     GL30.glEndTransformFeedback();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindBufferRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 398 */     GL30.glBindBufferRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindBufferBase(int paramInt1, int paramInt2, int paramInt3) {
/* 403 */     GL30.glBindBufferBase(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTransformFeedbackVaryings(int paramInt1, String[] paramArrayOfString, int paramInt2) {
/* 408 */     GL30.glTransformFeedbackVaryings(paramInt1, (CharSequence[])paramArrayOfString, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glVertexAttribIPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 413 */     GL30.glVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetVertexAttribIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 418 */     GL30.glGetVertexAttribIiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetVertexAttribIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 423 */     GL30.glGetVertexAttribIuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glVertexAttribI4i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 428 */     GL30.glVertexAttribI4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glVertexAttribI4ui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 433 */     GL30.glVertexAttribI4ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetUniformuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 438 */     GL30.glGetUniformuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glGetFragDataLocation(int paramInt, String paramString) {
/* 443 */     return GL30.glGetFragDataLocation(paramInt, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniform1uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 448 */     GL30.glUniform1uiv(paramInt1, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniform3uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 453 */     GL30.glUniform3uiv(paramInt1, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniform4uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 458 */     GL30.glUniform4uiv(paramInt1, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glClearBufferiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 463 */     GL30.glClearBufferiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glClearBufferuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 468 */     GL30.glClearBufferuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glClearBufferfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 473 */     GL30.glClearBufferfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glClearBufferfi(int paramInt1, int paramInt2, float paramFloat, int paramInt3) {
/* 478 */     GL30.glClearBufferfi(paramInt1, paramInt2, paramFloat, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public String glGetStringi(int paramInt1, int paramInt2) {
/* 483 */     return GL30.glGetStringi(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glCopyBufferSubData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 488 */     GL31.glCopyBufferSubData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetUniformIndices(int paramInt, String[] paramArrayOfString, IntBuffer paramIntBuffer) {
/* 493 */     GL31.glGetUniformIndices(paramInt, (CharSequence[])paramArrayOfString, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetActiveUniformsiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, int paramInt3, IntBuffer paramIntBuffer2) {
/* 498 */     GL31.glGetActiveUniformsiv(paramInt1, paramIntBuffer1, paramInt3, paramIntBuffer2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glGetUniformBlockIndex(int paramInt, String paramString) {
/* 503 */     return GL31.glGetUniformBlockIndex(paramInt, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetActiveUniformBlockiv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/* 508 */     GL31.glGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetActiveUniformBlockName(int paramInt1, int paramInt2, Buffer paramBuffer1, Buffer paramBuffer2) {
/* 513 */     GL31.glGetActiveUniformBlockName(paramInt1, paramInt2, (IntBuffer)paramBuffer1, (ByteBuffer)paramBuffer2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String glGetActiveUniformBlockName(int paramInt1, int paramInt2) {
/* 518 */     return GL31.glGetActiveUniformBlockName(paramInt1, paramInt2, 1024);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniformBlockBinding(int paramInt1, int paramInt2, int paramInt3) {
/* 523 */     GL31.glUniformBlockBinding(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawArraysInstanced(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 528 */     GL31.glDrawArraysInstanced(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawElementsInstanced(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 533 */     GL31.glDrawElementsInstanced(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glGetInteger64v(int paramInt, LongBuffer paramLongBuffer) {
/* 539 */     GL32.glGetInteger64v(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetBufferParameteri64v(int paramInt1, int paramInt2, LongBuffer paramLongBuffer) {
/* 544 */     paramLongBuffer.put(GL32.glGetBufferParameteri64(paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenSamplers(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 549 */     for (int i = paramInt2; i < paramInt2 + paramInt1; i++) {
/* 550 */       paramArrayOfint[i] = GL33.glGenSamplers();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenSamplers(int paramInt, IntBuffer paramIntBuffer) {
/* 556 */     GL33.glGenSamplers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteSamplers(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 561 */     for (int i = paramInt2; i < paramInt2 + paramInt1; i++) {
/* 562 */       GL33.glDeleteSamplers(paramArrayOfint[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteSamplers(int paramInt, IntBuffer paramIntBuffer) {
/* 568 */     GL33.glDeleteSamplers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glIsSampler(int paramInt) {
/* 573 */     return GL33.glIsSampler(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindSampler(int paramInt1, int paramInt2) {
/* 578 */     GL33.glBindSampler(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glSamplerParameteri(int paramInt1, int paramInt2, int paramInt3) {
/* 583 */     GL33.glSamplerParameteri(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glSamplerParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 588 */     GL33.glSamplerParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glSamplerParameterf(int paramInt1, int paramInt2, float paramFloat) {
/* 593 */     GL33.glSamplerParameterf(paramInt1, paramInt2, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glSamplerParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 598 */     GL33.glSamplerParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetSamplerParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 603 */     GL33.glGetSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetSamplerParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 608 */     GL33.glGetSamplerParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glVertexAttribDivisor(int paramInt1, int paramInt2) {
/* 613 */     GL33.glVertexAttribDivisor(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindTransformFeedback(int paramInt1, int paramInt2) {
/* 618 */     GL40.glBindTransformFeedback(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteTransformFeedbacks(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 623 */     for (int i = paramInt2; i < paramInt2 + paramInt1; i++) {
/* 624 */       GL40.glDeleteTransformFeedbacks(paramArrayOfint[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteTransformFeedbacks(int paramInt, IntBuffer paramIntBuffer) {
/* 630 */     GL40.glDeleteTransformFeedbacks(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenTransformFeedbacks(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 635 */     for (int i = paramInt2; i < paramInt2 + paramInt1; i++) {
/* 636 */       paramArrayOfint[i] = GL40.glGenTransformFeedbacks();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenTransformFeedbacks(int paramInt, IntBuffer paramIntBuffer) {
/* 642 */     GL40.glGenTransformFeedbacks(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glIsTransformFeedback(int paramInt) {
/* 647 */     return GL40.glIsTransformFeedback(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glPauseTransformFeedback() {
/* 652 */     GL40.glPauseTransformFeedback();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glResumeTransformFeedback() {
/* 657 */     GL40.glResumeTransformFeedback();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramParameteri(int paramInt1, int paramInt2, int paramInt3) {
/* 662 */     GL41.glProgramParameteri(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glInvalidateFramebuffer(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 667 */     GL43.glInvalidateFramebuffer(paramInt1, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glInvalidateSubFramebuffer(int paramInt1, int paramInt2, IntBuffer paramIntBuffer, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 673 */     GL43.glInvalidateSubFramebuffer(paramInt1, paramIntBuffer, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3GL30.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */