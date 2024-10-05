/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.opengl.EXTFramebufferObject;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL13;
/*     */ import org.lwjgl.opengl.GL14;
/*     */ import org.lwjgl.opengl.GL15;
/*     */ import org.lwjgl.opengl.GL20;
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
/*     */ class Lwjgl3GL20
/*     */   implements GL20
/*     */ {
/*  37 */   private ByteBuffer buffer = null;
/*  38 */   private FloatBuffer floatBuffer = null;
/*  39 */   private IntBuffer intBuffer = null;
/*     */   
/*     */   private void ensureBufferCapacity(int paramInt) {
/*  42 */     if (this.buffer == null || this.buffer.capacity() < paramInt) {
/*  43 */       this.buffer = BufferUtils.newByteBuffer(paramInt);
/*  44 */       this.floatBuffer = this.buffer.asFloatBuffer();
/*  45 */       this.intBuffer = this.buffer.asIntBuffer();
/*     */     } 
/*     */   }
/*     */   
/*     */   private FloatBuffer toFloatBuffer(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  50 */     ensureBufferCapacity(paramInt2 << 2);
/*  51 */     this.floatBuffer.clear();
/*  52 */     this.floatBuffer.limit(paramInt2);
/*  53 */     this.floatBuffer.put(paramArrayOffloat, paramInt1, paramInt2);
/*  54 */     this.floatBuffer.position(0);
/*  55 */     return this.floatBuffer;
/*     */   }
/*     */   
/*     */   private IntBuffer toIntBuffer(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  59 */     ensureBufferCapacity(paramInt2 << 2);
/*  60 */     this.intBuffer.clear();
/*  61 */     this.intBuffer.limit(paramInt2);
/*  62 */     this.intBuffer.put(paramArrayOfint, paramInt1, paramInt2);
/*  63 */     this.intBuffer.position(0);
/*  64 */     return this.intBuffer;
/*     */   }
/*     */   
/*     */   public void glActiveTexture(int paramInt) {
/*  68 */     GL13.glActiveTexture(paramInt);
/*     */   }
/*     */   
/*     */   public void glAttachShader(int paramInt1, int paramInt2) {
/*  72 */     GL20.glAttachShader(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glBindAttribLocation(int paramInt1, int paramInt2, String paramString) {
/*  76 */     GL20.glBindAttribLocation(paramInt1, paramInt2, paramString);
/*     */   }
/*     */   
/*     */   public void glBindBuffer(int paramInt1, int paramInt2) {
/*  80 */     GL15.glBindBuffer(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glBindFramebuffer(int paramInt1, int paramInt2) {
/*  84 */     EXTFramebufferObject.glBindFramebufferEXT(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glBindRenderbuffer(int paramInt1, int paramInt2) {
/*  88 */     EXTFramebufferObject.glBindRenderbufferEXT(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glBindTexture(int paramInt1, int paramInt2) {
/*  92 */     GL11.glBindTexture(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glBlendColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  96 */     GL14.glBlendColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void glBlendEquation(int paramInt) {
/* 100 */     GL14.glBlendEquation(paramInt);
/*     */   }
/*     */   
/*     */   public void glBlendEquationSeparate(int paramInt1, int paramInt2) {
/* 104 */     GL20.glBlendEquationSeparate(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glBlendFunc(int paramInt1, int paramInt2) {
/* 108 */     GL11.glBlendFunc(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glBlendFuncSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 112 */     GL14.glBlendFuncSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void glBufferData(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3) {
/* 116 */     if (paramBuffer == null) {
/* 117 */       GL15.glBufferData(paramInt1, paramInt2, paramInt3); return;
/* 118 */     }  if (paramBuffer instanceof ByteBuffer) {
/* 119 */       GL15.glBufferData(paramInt1, (ByteBuffer)paramBuffer, paramInt3); return;
/* 120 */     }  if (paramBuffer instanceof IntBuffer) {
/* 121 */       GL15.glBufferData(paramInt1, (IntBuffer)paramBuffer, paramInt3); return;
/* 122 */     }  if (paramBuffer instanceof FloatBuffer) {
/* 123 */       GL15.glBufferData(paramInt1, (FloatBuffer)paramBuffer, paramInt3); return;
/* 124 */     }  if (paramBuffer instanceof DoubleBuffer) {
/* 125 */       GL15.glBufferData(paramInt1, (DoubleBuffer)paramBuffer, paramInt3); return;
/* 126 */     }  if (paramBuffer instanceof ShortBuffer)
/* 127 */       GL15.glBufferData(paramInt1, (ShortBuffer)paramBuffer, paramInt3); 
/*     */   }
/*     */   
/*     */   public void glBufferSubData(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer) {
/* 131 */     if (paramBuffer == null)
/* 132 */       throw new GdxRuntimeException("Using null for the data not possible, blame LWJGL"); 
/* 133 */     if (paramBuffer instanceof ByteBuffer) {
/* 134 */       GL15.glBufferSubData(paramInt1, paramInt2, (ByteBuffer)paramBuffer); return;
/* 135 */     }  if (paramBuffer instanceof IntBuffer) {
/* 136 */       GL15.glBufferSubData(paramInt1, paramInt2, (IntBuffer)paramBuffer); return;
/* 137 */     }  if (paramBuffer instanceof FloatBuffer) {
/* 138 */       GL15.glBufferSubData(paramInt1, paramInt2, (FloatBuffer)paramBuffer); return;
/* 139 */     }  if (paramBuffer instanceof DoubleBuffer) {
/* 140 */       GL15.glBufferSubData(paramInt1, paramInt2, (DoubleBuffer)paramBuffer); return;
/* 141 */     }  if (paramBuffer instanceof ShortBuffer)
/* 142 */       GL15.glBufferSubData(paramInt1, paramInt2, (ShortBuffer)paramBuffer); 
/*     */   }
/*     */   
/*     */   public int glCheckFramebufferStatus(int paramInt) {
/* 146 */     return EXTFramebufferObject.glCheckFramebufferStatusEXT(paramInt);
/*     */   }
/*     */   
/*     */   public void glClear(int paramInt) {
/* 150 */     GL11.glClear(paramInt);
/*     */   }
/*     */   
/*     */   public void glClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 154 */     GL11.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void glClearDepthf(float paramFloat) {
/* 158 */     GL11.glClearDepth(paramFloat);
/*     */   }
/*     */   
/*     */   public void glClearStencil(int paramInt) {
/* 162 */     GL11.glClearStencil(paramInt);
/*     */   }
/*     */   
/*     */   public void glColorMask(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 166 */     GL11.glColorMask(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*     */   }
/*     */   
/*     */   public void glCompileShader(int paramInt) {
/* 170 */     GL20.glCompileShader(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer) {
/* 175 */     if (paramBuffer instanceof ByteBuffer) {
/* 176 */       GL13.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (ByteBuffer)paramBuffer); return;
/*     */     } 
/* 178 */     throw new GdxRuntimeException("Can't use " + paramBuffer.getClass().getName() + " with this method. Use ByteBuffer instead.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glCompressedTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/* 184 */     throw new GdxRuntimeException("not implemented");
/*     */   }
/*     */   
/*     */   public void glCopyTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/* 188 */     GL11.glCopyTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*     */   }
/*     */   
/*     */   public void glCopyTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/* 192 */     GL11.glCopyTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*     */   }
/*     */   
/*     */   public int glCreateProgram() {
/* 196 */     return GL20.glCreateProgram();
/*     */   }
/*     */   
/*     */   public int glCreateShader(int paramInt) {
/* 200 */     return GL20.glCreateShader(paramInt);
/*     */   }
/*     */   
/*     */   public void glCullFace(int paramInt) {
/* 204 */     GL11.glCullFace(paramInt);
/*     */   }
/*     */   
/*     */   public void glDeleteBuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 208 */     GL15.glDeleteBuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteBuffer(int paramInt) {
/* 213 */     GL15.glDeleteBuffers(paramInt);
/*     */   }
/*     */   
/*     */   public void glDeleteFramebuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 217 */     EXTFramebufferObject.glDeleteFramebuffersEXT(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteFramebuffer(int paramInt) {
/* 222 */     EXTFramebufferObject.glDeleteFramebuffersEXT(paramInt);
/*     */   }
/*     */   
/*     */   public void glDeleteProgram(int paramInt) {
/* 226 */     GL20.glDeleteProgram(paramInt);
/*     */   }
/*     */   
/*     */   public void glDeleteRenderbuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 230 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(paramIntBuffer);
/*     */   }
/*     */   
/*     */   public void glDeleteRenderbuffer(int paramInt) {
/* 234 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(paramInt);
/*     */   }
/*     */   
/*     */   public void glDeleteShader(int paramInt) {
/* 238 */     GL20.glDeleteShader(paramInt);
/*     */   }
/*     */   
/*     */   public void glDeleteTextures(int paramInt, IntBuffer paramIntBuffer) {
/* 242 */     GL11.glDeleteTextures(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteTexture(int paramInt) {
/* 247 */     GL11.glDeleteTextures(paramInt);
/*     */   }
/*     */   
/*     */   public void glDepthFunc(int paramInt) {
/* 251 */     GL11.glDepthFunc(paramInt);
/*     */   }
/*     */   
/*     */   public void glDepthMask(boolean paramBoolean) {
/* 255 */     GL11.glDepthMask(paramBoolean);
/*     */   }
/*     */   
/*     */   public void glDepthRangef(float paramFloat1, float paramFloat2) {
/* 259 */     GL11.glDepthRange(paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void glDetachShader(int paramInt1, int paramInt2) {
/* 263 */     GL20.glDetachShader(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glDisable(int paramInt) {
/* 267 */     GL11.glDisable(paramInt);
/*     */   }
/*     */   
/*     */   public void glDisableVertexAttribArray(int paramInt) {
/* 271 */     GL20.glDisableVertexAttribArray(paramInt);
/*     */   }
/*     */   
/*     */   public void glDrawArrays(int paramInt1, int paramInt2, int paramInt3) {
/* 275 */     GL11.glDrawArrays(paramInt1, paramInt2, paramInt3);
/*     */   } public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer) {
/*     */     ShortBuffer shortBuffer;
/*     */     int i;
/* 279 */     if (paramBuffer instanceof ShortBuffer && paramInt3 == 5123) {
/*     */       
/* 281 */       i = (shortBuffer = (ShortBuffer)paramBuffer).position();
/* 282 */       int j = shortBuffer.limit();
/* 283 */       shortBuffer.limit(i + paramInt2);
/* 284 */       GL11.glDrawElements(paramInt1, shortBuffer);
/* 285 */       shortBuffer.limit(j); return;
/* 286 */     }  if (i instanceof ByteBuffer && shortBuffer == 'ᐃ') {
/*     */       
/* 288 */       i = (shortBuffer = ((ByteBuffer)i).asShortBuffer()).position();
/* 289 */       int j = shortBuffer.limit();
/* 290 */       shortBuffer.limit(i + paramInt2);
/* 291 */       GL11.glDrawElements(paramInt1, shortBuffer);
/* 292 */       shortBuffer.limit(j); return;
/* 293 */     }  if (i instanceof ByteBuffer && shortBuffer == 'ᐁ') {
/*     */       ByteBuffer byteBuffer;
/* 295 */       i = (byteBuffer = (ByteBuffer)i).position();
/* 296 */       int j = byteBuffer.limit();
/* 297 */       byteBuffer.limit(i + paramInt2);
/* 298 */       GL11.glDrawElements(paramInt1, byteBuffer);
/* 299 */       byteBuffer.limit(j); return;
/*     */     } 
/* 301 */     throw new GdxRuntimeException("Can't use " + i.getClass().getName() + " with this method. Use ShortBuffer or ByteBuffer instead. Blame LWJGL");
/*     */   }
/*     */ 
/*     */   
/*     */   public void glEnable(int paramInt) {
/* 306 */     GL11.glEnable(paramInt);
/*     */   }
/*     */   
/*     */   public void glEnableVertexAttribArray(int paramInt) {
/* 310 */     GL20.glEnableVertexAttribArray(paramInt);
/*     */   }
/*     */   
/*     */   public void glFinish() {
/* 314 */     GL11.glFinish();
/*     */   }
/*     */   
/*     */   public void glFlush() {
/* 318 */     GL11.glFlush();
/*     */   }
/*     */   
/*     */   public void glFramebufferRenderbuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 322 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void glFramebufferTexture2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 326 */     EXTFramebufferObject.glFramebufferTexture2DEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */   
/*     */   public void glFrontFace(int paramInt) {
/* 330 */     GL11.glFrontFace(paramInt);
/*     */   }
/*     */   
/*     */   public void glGenBuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 334 */     GL15.glGenBuffers(paramIntBuffer);
/*     */   }
/*     */   
/*     */   public int glGenBuffer() {
/* 338 */     return GL15.glGenBuffers();
/*     */   }
/*     */   
/*     */   public void glGenFramebuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 342 */     EXTFramebufferObject.glGenFramebuffersEXT(paramIntBuffer);
/*     */   }
/*     */   
/*     */   public int glGenFramebuffer() {
/* 346 */     return EXTFramebufferObject.glGenFramebuffersEXT();
/*     */   }
/*     */   
/*     */   public void glGenRenderbuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 350 */     EXTFramebufferObject.glGenRenderbuffersEXT(paramIntBuffer);
/*     */   }
/*     */   
/*     */   public int glGenRenderbuffer() {
/* 354 */     return EXTFramebufferObject.glGenRenderbuffersEXT();
/*     */   }
/*     */   
/*     */   public void glGenTextures(int paramInt, IntBuffer paramIntBuffer) {
/* 358 */     GL11.glGenTextures(paramIntBuffer);
/*     */   }
/*     */   
/*     */   public int glGenTexture() {
/* 362 */     return GL11.glGenTextures();
/*     */   }
/*     */   
/*     */   public void glGenerateMipmap(int paramInt) {
/* 366 */     EXTFramebufferObject.glGenerateMipmapEXT(paramInt);
/*     */   }
/*     */   
/*     */   public String glGetActiveAttrib(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/* 370 */     return GL20.glGetActiveAttrib(paramInt1, paramInt2, 256, paramIntBuffer1, paramIntBuffer2);
/*     */   }
/*     */   
/*     */   public String glGetActiveUniform(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/* 374 */     return GL20.glGetActiveUniform(paramInt1, paramInt2, 256, paramIntBuffer1, paramIntBuffer2);
/*     */   }
/*     */   
/*     */   public void glGetAttachedShaders(int paramInt1, int paramInt2, Buffer paramBuffer, IntBuffer paramIntBuffer) {
/* 378 */     GL20.glGetAttachedShaders(paramInt1, (IntBuffer)paramBuffer, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public int glGetAttribLocation(int paramInt, String paramString) {
/* 382 */     return GL20.glGetAttribLocation(paramInt, paramString);
/*     */   }
/*     */   
/*     */   public void glGetBooleanv(int paramInt, Buffer paramBuffer) {
/* 386 */     GL11.glGetBooleanv(paramInt, (ByteBuffer)paramBuffer);
/*     */   }
/*     */   
/*     */   public void glGetBufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 390 */     GL15.glGetBufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public int glGetError() {
/* 394 */     return GL11.glGetError();
/*     */   }
/*     */   
/*     */   public void glGetFloatv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 398 */     GL11.glGetFloatv(paramInt, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glGetFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/* 402 */     EXTFramebufferObject.glGetFramebufferAttachmentParameterivEXT(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public void glGetIntegerv(int paramInt, IntBuffer paramIntBuffer) {
/* 406 */     GL11.glGetIntegerv(paramInt, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public String glGetProgramInfoLog(int paramInt) {
/*     */     ByteBuffer byteBuffer1;
/* 411 */     (byteBuffer1 = ByteBuffer.allocateDirect(10240)).order(ByteOrder.nativeOrder());
/*     */     ByteBuffer byteBuffer2;
/* 413 */     (byteBuffer2 = ByteBuffer.allocateDirect(4)).order(ByteOrder.nativeOrder());
/* 414 */     IntBuffer intBuffer = byteBuffer2.asIntBuffer();
/*     */     
/* 416 */     GL20.glGetProgramInfoLog(paramInt, intBuffer, byteBuffer1);
/*     */     
/* 418 */     byte[] arrayOfByte = new byte[paramInt = intBuffer.get(0)];
/* 419 */     byteBuffer1.get(arrayOfByte);
/* 420 */     return new String(arrayOfByte);
/*     */   }
/*     */   
/*     */   public void glGetProgramiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 424 */     GL20.glGetProgramiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public void glGetRenderbufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 428 */     EXTFramebufferObject.glGetRenderbufferParameterivEXT(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public String glGetShaderInfoLog(int paramInt) {
/*     */     ByteBuffer byteBuffer1;
/* 433 */     (byteBuffer1 = ByteBuffer.allocateDirect(10240)).order(ByteOrder.nativeOrder());
/*     */     ByteBuffer byteBuffer2;
/* 435 */     (byteBuffer2 = ByteBuffer.allocateDirect(4)).order(ByteOrder.nativeOrder());
/* 436 */     IntBuffer intBuffer = byteBuffer2.asIntBuffer();
/*     */     
/* 438 */     GL20.glGetShaderInfoLog(paramInt, intBuffer, byteBuffer1);
/*     */     
/* 440 */     byte[] arrayOfByte = new byte[paramInt = intBuffer.get(0)];
/* 441 */     byteBuffer1.get(arrayOfByte);
/* 442 */     return new String(arrayOfByte);
/*     */   }
/*     */   
/*     */   public void glGetShaderPrecisionFormat(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/* 446 */     throw new UnsupportedOperationException("unsupported, won't implement");
/*     */   }
/*     */   
/*     */   public void glGetShaderiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 450 */     GL20.glGetShaderiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public String glGetString(int paramInt) {
/* 454 */     return GL11.glGetString(paramInt);
/*     */   }
/*     */   
/*     */   public void glGetTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 458 */     GL11.glGetTexParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glGetTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 462 */     GL11.glGetTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public int glGetUniformLocation(int paramInt, String paramString) {
/* 466 */     return GL20.glGetUniformLocation(paramInt, paramString);
/*     */   }
/*     */   
/*     */   public void glGetUniformfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 470 */     GL20.glGetUniformfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glGetUniformiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 474 */     GL20.glGetUniformiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public void glGetVertexAttribPointerv(int paramInt1, int paramInt2, Buffer paramBuffer) {
/* 478 */     throw new UnsupportedOperationException("unsupported, won't implement");
/*     */   }
/*     */   
/*     */   public void glGetVertexAttribfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 482 */     GL20.glGetVertexAttribfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glGetVertexAttribiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 486 */     GL20.glGetVertexAttribiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public void glHint(int paramInt1, int paramInt2) {
/* 490 */     GL11.glHint(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public boolean glIsBuffer(int paramInt) {
/* 494 */     return GL15.glIsBuffer(paramInt);
/*     */   }
/*     */   
/*     */   public boolean glIsEnabled(int paramInt) {
/* 498 */     return GL11.glIsEnabled(paramInt);
/*     */   }
/*     */   
/*     */   public boolean glIsFramebuffer(int paramInt) {
/* 502 */     return EXTFramebufferObject.glIsFramebufferEXT(paramInt);
/*     */   }
/*     */   
/*     */   public boolean glIsProgram(int paramInt) {
/* 506 */     return GL20.glIsProgram(paramInt);
/*     */   }
/*     */   
/*     */   public boolean glIsRenderbuffer(int paramInt) {
/* 510 */     return EXTFramebufferObject.glIsRenderbufferEXT(paramInt);
/*     */   }
/*     */   
/*     */   public boolean glIsShader(int paramInt) {
/* 514 */     return GL20.glIsShader(paramInt);
/*     */   }
/*     */   
/*     */   public boolean glIsTexture(int paramInt) {
/* 518 */     return GL11.glIsTexture(paramInt);
/*     */   }
/*     */   
/*     */   public void glLineWidth(float paramFloat) {
/* 522 */     GL11.glLineWidth(paramFloat);
/*     */   }
/*     */   
/*     */   public void glLinkProgram(int paramInt) {
/* 526 */     GL20.glLinkProgram(paramInt);
/*     */   }
/*     */   
/*     */   public void glPixelStorei(int paramInt1, int paramInt2) {
/* 530 */     GL11.glPixelStorei(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glPolygonOffset(float paramFloat1, float paramFloat2) {
/* 534 */     GL11.glPolygonOffset(paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void glReadPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Buffer paramBuffer) {
/* 538 */     if (paramBuffer instanceof ByteBuffer) {
/* 539 */       GL11.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (ByteBuffer)paramBuffer); return;
/* 540 */     }  if (paramBuffer instanceof ShortBuffer) {
/* 541 */       GL11.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (ShortBuffer)paramBuffer); return;
/* 542 */     }  if (paramBuffer instanceof IntBuffer) {
/* 543 */       GL11.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (IntBuffer)paramBuffer); return;
/* 544 */     }  if (paramBuffer instanceof FloatBuffer) {
/* 545 */       GL11.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, (FloatBuffer)paramBuffer); return;
/*     */     } 
/* 547 */     throw new GdxRuntimeException("Can't use " + paramBuffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer or FloatBuffer instead. Blame LWJGL");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glReleaseShaderCompiler() {}
/*     */ 
/*     */   
/*     */   public void glRenderbufferStorage(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 556 */     EXTFramebufferObject.glRenderbufferStorageEXT(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void glSampleCoverage(float paramFloat, boolean paramBoolean) {
/* 560 */     GL13.glSampleCoverage(paramFloat, paramBoolean);
/*     */   }
/*     */   
/*     */   public void glScissor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 564 */     GL11.glScissor(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void glShaderBinary(int paramInt1, IntBuffer paramIntBuffer, int paramInt2, Buffer paramBuffer, int paramInt3) {
/* 568 */     throw new UnsupportedOperationException("unsupported, won't implement");
/*     */   }
/*     */   
/*     */   public void glShaderSource(int paramInt, String paramString) {
/* 572 */     GL20.glShaderSource(paramInt, paramString);
/*     */   }
/*     */   
/*     */   public void glStencilFunc(int paramInt1, int paramInt2, int paramInt3) {
/* 576 */     GL11.glStencilFunc(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public void glStencilFuncSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 580 */     GL20.glStencilFuncSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void glStencilMask(int paramInt) {
/* 584 */     GL11.glStencilMask(paramInt);
/*     */   }
/*     */   
/*     */   public void glStencilMaskSeparate(int paramInt1, int paramInt2) {
/* 588 */     GL20.glStencilMaskSeparate(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glStencilOp(int paramInt1, int paramInt2, int paramInt3) {
/* 592 */     GL11.glStencilOp(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public void glStencilOpSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 596 */     GL20.glStencilOpSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/* 601 */     if (paramBuffer == null) {
/* 602 */       GL11.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (ByteBuffer)null); return;
/* 603 */     }  if (paramBuffer instanceof ByteBuffer) {
/* 604 */       GL11.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (ByteBuffer)paramBuffer); return;
/* 605 */     }  if (paramBuffer instanceof ShortBuffer) {
/* 606 */       GL11.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (ShortBuffer)paramBuffer); return;
/* 607 */     }  if (paramBuffer instanceof IntBuffer) {
/* 608 */       GL11.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (IntBuffer)paramBuffer); return;
/* 609 */     }  if (paramBuffer instanceof FloatBuffer) {
/* 610 */       GL11.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (FloatBuffer)paramBuffer); return;
/* 611 */     }  if (paramBuffer instanceof DoubleBuffer) {
/* 612 */       GL11.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (DoubleBuffer)paramBuffer); return;
/*     */     } 
/* 614 */     throw new GdxRuntimeException("Can't use " + paramBuffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexParameterf(int paramInt1, int paramInt2, float paramFloat) {
/* 619 */     GL11.glTexParameterf(paramInt1, paramInt2, paramFloat);
/*     */   }
/*     */   
/*     */   public void glTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 623 */     GL11.glTexParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glTexParameteri(int paramInt1, int paramInt2, int paramInt3) {
/* 627 */     GL11.glTexParameteri(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public void glTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 631 */     GL11.glTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/* 636 */     if (paramBuffer instanceof ByteBuffer) {
/* 637 */       GL11.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (ByteBuffer)paramBuffer); return;
/* 638 */     }  if (paramBuffer instanceof ShortBuffer) {
/* 639 */       GL11.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (ShortBuffer)paramBuffer); return;
/* 640 */     }  if (paramBuffer instanceof IntBuffer) {
/* 641 */       GL11.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (IntBuffer)paramBuffer); return;
/* 642 */     }  if (paramBuffer instanceof FloatBuffer) {
/* 643 */       GL11.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (FloatBuffer)paramBuffer); return;
/* 644 */     }  if (paramBuffer instanceof DoubleBuffer) {
/* 645 */       GL11.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, (DoubleBuffer)paramBuffer); return;
/*     */     } 
/* 647 */     throw new GdxRuntimeException("Can't use " + paramBuffer.getClass().getName() + " with this method. Use ByteBuffer, ShortBuffer, IntBuffer, FloatBuffer or DoubleBuffer instead. Blame LWJGL");
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniform1f(int paramInt, float paramFloat) {
/* 652 */     GL20.glUniform1f(paramInt, paramFloat);
/*     */   }
/*     */   
/*     */   public void glUniform1fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 656 */     GL20.glUniform1fv(paramInt1, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glUniform1fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/* 660 */     GL20.glUniform1fv(paramInt1, toFloatBuffer(paramArrayOffloat, paramInt3, paramInt2));
/*     */   }
/*     */   
/*     */   public void glUniform1i(int paramInt1, int paramInt2) {
/* 664 */     GL20.glUniform1i(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void glUniform1iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 668 */     GL20.glUniform1iv(paramInt1, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUniform1iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 673 */     GL20.glUniform1iv(paramInt1, toIntBuffer(paramArrayOfint, paramInt3, paramInt2));
/*     */   }
/*     */   
/*     */   public void glUniform2f(int paramInt, float paramFloat1, float paramFloat2) {
/* 677 */     GL20.glUniform2f(paramInt, paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void glUniform2fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 681 */     GL20.glUniform2fv(paramInt1, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glUniform2fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/* 685 */     GL20.glUniform2fv(paramInt1, toFloatBuffer(paramArrayOffloat, paramInt3, paramInt2 << 1));
/*     */   }
/*     */   
/*     */   public void glUniform2i(int paramInt1, int paramInt2, int paramInt3) {
/* 689 */     GL20.glUniform2i(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public void glUniform2iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 693 */     GL20.glUniform2iv(paramInt1, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public void glUniform2iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 697 */     GL20.glUniform2iv(paramInt1, toIntBuffer(paramArrayOfint, paramInt3, paramInt2 << 1));
/*     */   }
/*     */   
/*     */   public void glUniform3f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 701 */     GL20.glUniform3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */   
/*     */   public void glUniform3fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 705 */     GL20.glUniform3fv(paramInt1, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glUniform3fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/* 709 */     GL20.glUniform3fv(paramInt1, toFloatBuffer(paramArrayOffloat, paramInt3, paramInt2 * 3));
/*     */   }
/*     */   
/*     */   public void glUniform3i(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 713 */     GL20.glUniform3i(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void glUniform3iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 717 */     GL20.glUniform3iv(paramInt1, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public void glUniform3iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 721 */     GL20.glUniform3iv(paramInt1, toIntBuffer(paramArrayOfint, paramInt3, paramInt2 * 3));
/*     */   }
/*     */   
/*     */   public void glUniform4f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 725 */     GL20.glUniform4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void glUniform4fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 729 */     GL20.glUniform4fv(paramInt1, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glUniform4fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/* 733 */     GL20.glUniform4fv(paramInt1, toFloatBuffer(paramArrayOffloat, paramInt3, paramInt2 << 2));
/*     */   }
/*     */   
/*     */   public void glUniform4i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 737 */     GL20.glUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */   
/*     */   public void glUniform4iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 741 */     GL20.glUniform4iv(paramInt1, paramIntBuffer);
/*     */   }
/*     */   
/*     */   public void glUniform4iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 745 */     GL20.glUniform4iv(paramInt1, toIntBuffer(paramArrayOfint, paramInt3, paramInt2 << 2));
/*     */   }
/*     */   
/*     */   public void glUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 749 */     GL20.glUniformMatrix2fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 753 */     GL20.glUniformMatrix2fv(paramInt1, paramBoolean, toFloatBuffer(paramArrayOffloat, paramInt3, paramInt2 << 2));
/*     */   }
/*     */   
/*     */   public void glUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 757 */     GL20.glUniformMatrix3fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 761 */     GL20.glUniformMatrix3fv(paramInt1, paramBoolean, toFloatBuffer(paramArrayOffloat, paramInt3, paramInt2 * 9));
/*     */   }
/*     */   
/*     */   public void glUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 765 */     GL20.glUniformMatrix4fv(paramInt1, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */   
/*     */   public void glUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 769 */     GL20.glUniformMatrix4fv(paramInt1, paramBoolean, toFloatBuffer(paramArrayOffloat, paramInt3, paramInt2 << 4));
/*     */   }
/*     */   
/*     */   public void glUseProgram(int paramInt) {
/* 773 */     GL20.glUseProgram(paramInt);
/*     */   }
/*     */   
/*     */   public void glValidateProgram(int paramInt) {
/* 777 */     GL20.glValidateProgram(paramInt);
/*     */   }
/*     */   
/*     */   public void glVertexAttrib1f(int paramInt, float paramFloat) {
/* 781 */     GL20.glVertexAttrib1f(paramInt, paramFloat);
/*     */   }
/*     */   
/*     */   public void glVertexAttrib1fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 785 */     GL20.glVertexAttrib1f(paramInt, paramFloatBuffer.get());
/*     */   }
/*     */   
/*     */   public void glVertexAttrib2f(int paramInt, float paramFloat1, float paramFloat2) {
/* 789 */     GL20.glVertexAttrib2f(paramInt, paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public void glVertexAttrib2fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 793 */     GL20.glVertexAttrib2f(paramInt, paramFloatBuffer.get(), paramFloatBuffer.get());
/*     */   }
/*     */   
/*     */   public void glVertexAttrib3f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 797 */     GL20.glVertexAttrib3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */   
/*     */   public void glVertexAttrib3fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 801 */     GL20.glVertexAttrib3f(paramInt, paramFloatBuffer.get(), paramFloatBuffer.get(), paramFloatBuffer.get());
/*     */   }
/*     */   
/*     */   public void glVertexAttrib4f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 805 */     GL20.glVertexAttrib4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public void glVertexAttrib4fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 809 */     GL20.glVertexAttrib4f(paramInt, paramFloatBuffer.get(), paramFloatBuffer.get(), paramFloatBuffer.get(), paramFloatBuffer.get());
/*     */   }
/*     */   
/*     */   public void glVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, Buffer paramBuffer) {
/* 813 */     if (paramBuffer instanceof ByteBuffer) {
/* 814 */       if (paramInt3 == 5120) {
/* 815 */         GL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, (ByteBuffer)paramBuffer); return;
/* 816 */       }  if (paramInt3 == 5121) {
/* 817 */         GL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, (ByteBuffer)paramBuffer); return;
/* 818 */       }  if (paramInt3 == 5122) {
/* 819 */         GL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, ((ByteBuffer)paramBuffer).asShortBuffer()); return;
/* 820 */       }  if (paramInt3 == 5123) {
/* 821 */         GL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, ((ByteBuffer)paramBuffer).asShortBuffer()); return;
/* 822 */       }  if (paramInt3 == 5126) {
/* 823 */         GL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, ((ByteBuffer)paramBuffer).asFloatBuffer()); return;
/*     */       } 
/* 825 */       throw new GdxRuntimeException("Can't use " + paramBuffer.getClass().getName() + " with type " + paramInt3 + " with this method. Use ByteBuffer and one of GL_BYTE, GL_UNSIGNED_BYTE, GL_SHORT, GL_UNSIGNED_SHORT or GL_FLOAT for type. Blame LWJGL");
/*     */     } 
/* 827 */     if (paramBuffer instanceof FloatBuffer) {
/* 828 */       if (paramInt3 == 5126) {
/* 829 */         GL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, (FloatBuffer)paramBuffer); return;
/*     */       } 
/* 831 */       throw new GdxRuntimeException("Can't use " + paramBuffer
/* 832 */           .getClass().getName() + " with type " + paramInt3 + " with this method.");
/*     */     } 
/* 834 */     throw new GdxRuntimeException("Can't use " + paramBuffer
/* 835 */         .getClass().getName() + " with this method. Use ByteBuffer instead. Blame LWJGL");
/*     */   }
/*     */   
/*     */   public void glViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 839 */     GL11.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 843 */     GL11.glDrawElements(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   public void glVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5) {
/* 847 */     GL20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3GL20.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */