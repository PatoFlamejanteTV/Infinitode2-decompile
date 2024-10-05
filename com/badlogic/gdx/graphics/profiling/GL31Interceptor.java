/*     */ package com.badlogic.gdx.graphics.profiling;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.GL30;
/*     */ import com.badlogic.gdx.graphics.GL31;
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
/*     */ public class GL31Interceptor
/*     */   extends GL30Interceptor
/*     */   implements GL31
/*     */ {
/*     */   final GL31 gl31;
/*     */   
/*     */   public GL31Interceptor(GLProfiler paramGLProfiler, GL31 paramGL31) {
/*  30 */     super(paramGLProfiler, (GL30)paramGL31);
/*  31 */     this.gl31 = paramGL31;
/*     */   }
/*     */   
/*     */   protected void check() {
/*  35 */     int i = this.gl30.glGetError();
/*  36 */     while (i != 0) {
/*  37 */       this.glProfiler.getListener().onError(i);
/*  38 */       i = this.gl30.glGetError();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void glDispatchCompute(int paramInt1, int paramInt2, int paramInt3) {
/*  43 */     this.calls++;
/*  44 */     this.gl31.glDispatchCompute(paramInt1, paramInt2, paramInt3);
/*  45 */     check();
/*     */   }
/*     */   
/*     */   public void glDispatchComputeIndirect(long paramLong) {
/*  49 */     this.calls++;
/*  50 */     this.gl31.glDispatchComputeIndirect(paramLong);
/*  51 */     check();
/*     */   }
/*     */   
/*     */   public void glDrawArraysIndirect(int paramInt, long paramLong) {
/*  55 */     this.drawCalls++;
/*  56 */     this.calls++;
/*  57 */     this.gl31.glDrawArraysIndirect(paramInt, paramLong);
/*  58 */     check();
/*     */   }
/*     */   
/*     */   public void glDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong) {
/*  62 */     this.drawCalls++;
/*  63 */     this.calls++;
/*  64 */     this.gl31.glDrawElementsIndirect(paramInt1, paramInt2, paramLong);
/*  65 */     check();
/*     */   }
/*     */   
/*     */   public void glFramebufferParameteri(int paramInt1, int paramInt2, int paramInt3) {
/*  69 */     this.calls++;
/*  70 */     this.gl31.glFramebufferParameteri(paramInt1, paramInt2, paramInt3);
/*  71 */     check();
/*     */   }
/*     */   
/*     */   public void glGetFramebufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  75 */     this.calls++;
/*  76 */     this.gl31.glGetFramebufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  77 */     check();
/*     */   }
/*     */   
/*     */   public void glGetProgramInterfaceiv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/*  81 */     this.calls++;
/*  82 */     this.gl31.glGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*  83 */     check();
/*     */   }
/*     */   
/*     */   public int glGetProgramResourceIndex(int paramInt1, int paramInt2, String paramString) {
/*  87 */     this.calls++;
/*  88 */     paramInt1 = this.gl31.glGetProgramResourceIndex(paramInt1, paramInt2, paramString);
/*  89 */     check();
/*  90 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public String glGetProgramResourceName(int paramInt1, int paramInt2, int paramInt3) {
/*  94 */     this.calls++;
/*  95 */     String str = this.gl31.glGetProgramResourceName(paramInt1, paramInt2, paramInt3);
/*  96 */     check();
/*  97 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetProgramResourceiv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, IntBuffer paramIntBuffer3) {
/* 102 */     this.calls++;
/* 103 */     this.gl31.glGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3);
/* 104 */     check();
/*     */   }
/*     */   
/*     */   public int glGetProgramResourceLocation(int paramInt1, int paramInt2, String paramString) {
/* 108 */     this.calls++;
/* 109 */     paramInt1 = this.gl31.glGetProgramResourceLocation(paramInt1, paramInt2, paramString);
/* 110 */     check();
/* 111 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public void glUseProgramStages(int paramInt1, int paramInt2, int paramInt3) {
/* 115 */     this.calls++;
/* 116 */     this.gl31.glUseProgramStages(paramInt1, paramInt2, paramInt3);
/* 117 */     check();
/*     */   }
/*     */   
/*     */   public void glActiveShaderProgram(int paramInt1, int paramInt2) {
/* 121 */     this.calls++;
/* 122 */     this.gl31.glActiveShaderProgram(paramInt1, paramInt2);
/* 123 */     check();
/*     */   }
/*     */   
/*     */   public int glCreateShaderProgramv(int paramInt, String[] paramArrayOfString) {
/* 127 */     this.calls++;
/* 128 */     paramInt = this.gl31.glCreateShaderProgramv(paramInt, paramArrayOfString);
/* 129 */     check();
/* 130 */     return paramInt;
/*     */   }
/*     */   
/*     */   public void glBindProgramPipeline(int paramInt) {
/* 134 */     this.calls++;
/* 135 */     this.gl31.glBindProgramPipeline(paramInt);
/* 136 */     check();
/*     */   }
/*     */   
/*     */   public void glDeleteProgramPipelines(int paramInt, IntBuffer paramIntBuffer) {
/* 140 */     this.calls++;
/* 141 */     this.gl31.glDeleteProgramPipelines(paramInt, paramIntBuffer);
/* 142 */     check();
/*     */   }
/*     */   
/*     */   public void glGenProgramPipelines(int paramInt, IntBuffer paramIntBuffer) {
/* 146 */     this.calls++;
/* 147 */     this.gl31.glGenProgramPipelines(paramInt, paramIntBuffer);
/* 148 */     check();
/*     */   }
/*     */   
/*     */   public boolean glIsProgramPipeline(int paramInt) {
/* 152 */     this.calls++;
/* 153 */     boolean bool = this.gl31.glIsProgramPipeline(paramInt);
/* 154 */     check();
/* 155 */     return bool;
/*     */   }
/*     */   
/*     */   public void glGetProgramPipelineiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 159 */     this.calls++;
/* 160 */     this.gl31.glGetProgramPipelineiv(paramInt1, paramInt2, paramIntBuffer);
/* 161 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform1i(int paramInt1, int paramInt2, int paramInt3) {
/* 165 */     this.calls++;
/* 166 */     this.gl31.glProgramUniform1i(paramInt1, paramInt2, paramInt3);
/* 167 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform2i(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 171 */     this.calls++;
/* 172 */     this.gl31.glProgramUniform2i(paramInt1, paramInt2, paramInt3, paramInt4);
/* 173 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform3i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 177 */     this.calls++;
/* 178 */     this.gl31.glProgramUniform3i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 179 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform4i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 183 */     this.calls++;
/* 184 */     this.gl31.glProgramUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/* 185 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform1ui(int paramInt1, int paramInt2, int paramInt3) {
/* 189 */     this.calls++;
/* 190 */     this.gl31.glProgramUniform1ui(paramInt1, paramInt2, paramInt3);
/* 191 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform2ui(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 195 */     this.calls++;
/* 196 */     this.gl31.glProgramUniform2ui(paramInt1, paramInt2, paramInt3, paramInt4);
/* 197 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform3ui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 201 */     this.calls++;
/* 202 */     this.gl31.glProgramUniform3ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 203 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform4ui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 207 */     this.calls++;
/* 208 */     this.gl31.glProgramUniform4ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/* 209 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform1f(int paramInt1, int paramInt2, float paramFloat) {
/* 213 */     this.calls++;
/* 214 */     this.gl31.glProgramUniform1f(paramInt1, paramInt2, paramFloat);
/* 215 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform2f(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2) {
/* 219 */     this.calls++;
/* 220 */     this.gl31.glProgramUniform2f(paramInt1, paramInt2, paramFloat1, paramFloat2);
/* 221 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform3f(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 225 */     this.calls++;
/* 226 */     this.gl31.glProgramUniform3f(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
/* 227 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform4f(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 231 */     this.calls++;
/* 232 */     this.gl31.glProgramUniform4f(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 233 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform1iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 237 */     this.calls++;
/* 238 */     this.gl31.glProgramUniform1iv(paramInt1, paramInt2, paramIntBuffer);
/* 239 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform2iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 243 */     this.calls++;
/* 244 */     this.gl31.glProgramUniform2iv(paramInt1, paramInt2, paramIntBuffer);
/* 245 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform3iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 249 */     this.calls++;
/* 250 */     this.gl31.glProgramUniform3iv(paramInt1, paramInt2, paramIntBuffer);
/* 251 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform4iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 255 */     this.calls++;
/* 256 */     this.gl31.glProgramUniform4iv(paramInt1, paramInt2, paramIntBuffer);
/* 257 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform1uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 261 */     this.calls++;
/* 262 */     this.gl31.glProgramUniform1uiv(paramInt1, paramInt2, paramIntBuffer);
/* 263 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform2uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 267 */     this.calls++;
/* 268 */     this.gl31.glProgramUniform2uiv(paramInt1, paramInt2, paramIntBuffer);
/* 269 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform3uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 273 */     this.calls++;
/* 274 */     this.gl31.glProgramUniform3uiv(paramInt1, paramInt2, paramIntBuffer);
/* 275 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform4uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 279 */     this.calls++;
/* 280 */     this.gl31.glProgramUniform4uiv(paramInt1, paramInt2, paramIntBuffer);
/* 281 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform1fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 285 */     this.calls++;
/* 286 */     this.gl31.glProgramUniform1fv(paramInt1, paramInt2, paramFloatBuffer);
/* 287 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform2fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 291 */     this.calls++;
/* 292 */     this.gl31.glProgramUniform2fv(paramInt1, paramInt2, paramFloatBuffer);
/* 293 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform3fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 297 */     this.calls++;
/* 298 */     this.gl31.glProgramUniform3fv(paramInt1, paramInt2, paramFloatBuffer);
/* 299 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniform4fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 303 */     this.calls++;
/* 304 */     this.gl31.glProgramUniform4fv(paramInt1, paramInt2, paramFloatBuffer);
/* 305 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 309 */     this.calls++;
/* 310 */     this.gl31.glProgramUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 311 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 315 */     this.calls++;
/* 316 */     this.gl31.glProgramUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 317 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 321 */     this.calls++;
/* 322 */     this.gl31.glProgramUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 323 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix2x3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 327 */     this.calls++;
/* 328 */     this.gl31.glProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 329 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix3x2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 333 */     this.calls++;
/* 334 */     this.gl31.glProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 335 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix2x4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 339 */     this.calls++;
/* 340 */     this.gl31.glProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 341 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix4x2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 345 */     this.calls++;
/* 346 */     this.gl31.glProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 347 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix3x4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 351 */     this.calls++;
/* 352 */     this.gl31.glProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 353 */     check();
/*     */   }
/*     */   
/*     */   public void glProgramUniformMatrix4x3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 357 */     this.calls++;
/* 358 */     this.gl31.glProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 359 */     check();
/*     */   }
/*     */   
/*     */   public void glValidateProgramPipeline(int paramInt) {
/* 363 */     this.calls++;
/* 364 */     this.gl31.glValidateProgramPipeline(paramInt);
/* 365 */     check();
/*     */   }
/*     */   
/*     */   public String glGetProgramPipelineInfoLog(int paramInt) {
/* 369 */     this.calls++;
/* 370 */     String str = this.gl31.glGetProgramPipelineInfoLog(paramInt);
/* 371 */     check();
/* 372 */     return str;
/*     */   }
/*     */   
/*     */   public void glBindImageTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6) {
/* 376 */     this.calls++;
/* 377 */     this.gl31.glBindImageTexture(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5, paramInt6);
/* 378 */     check();
/*     */   }
/*     */   
/*     */   public void glGetBooleani_v(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 382 */     this.calls++;
/* 383 */     this.gl31.glGetBooleani_v(paramInt1, paramInt2, paramIntBuffer);
/* 384 */     check();
/*     */   }
/*     */   
/*     */   public void glMemoryBarrier(int paramInt) {
/* 388 */     this.calls++;
/* 389 */     this.gl31.glMemoryBarrier(paramInt);
/* 390 */     check();
/*     */   }
/*     */   
/*     */   public void glMemoryBarrierByRegion(int paramInt) {
/* 394 */     this.calls++;
/* 395 */     this.gl31.glMemoryBarrierByRegion(paramInt);
/* 396 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexStorage2DMultisample(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
/* 401 */     this.calls++;
/* 402 */     this.gl31.glTexStorage2DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
/* 403 */     check();
/*     */   }
/*     */   
/*     */   public void glGetMultisamplefv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 407 */     this.calls++;
/* 408 */     this.gl31.glGetMultisamplefv(paramInt1, paramInt2, paramFloatBuffer);
/* 409 */     check();
/*     */   }
/*     */   
/*     */   public void glSampleMaski(int paramInt1, int paramInt2) {
/* 413 */     this.calls++;
/* 414 */     this.gl31.glSampleMaski(paramInt1, paramInt2);
/* 415 */     check();
/*     */   }
/*     */   
/*     */   public void glGetTexLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/* 419 */     this.calls++;
/* 420 */     this.gl31.glGetTexLevelParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/* 421 */     check();
/*     */   }
/*     */   
/*     */   public void glGetTexLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer) {
/* 425 */     this.calls++;
/* 426 */     this.gl31.glGetTexLevelParameterfv(paramInt1, paramInt2, paramInt3, paramFloatBuffer);
/* 427 */     check();
/*     */   }
/*     */   
/*     */   public void glBindVertexBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3) {
/* 431 */     this.calls++;
/* 432 */     this.gl31.glBindVertexBuffer(paramInt1, paramInt2, paramLong, paramInt3);
/* 433 */     check();
/*     */   }
/*     */   
/*     */   public void glVertexAttribFormat(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
/* 437 */     this.calls++;
/* 438 */     this.gl31.glVertexAttribFormat(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
/* 439 */     check();
/*     */   }
/*     */   
/*     */   public void glVertexAttribIFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 443 */     this.calls++;
/* 444 */     this.gl31.glVertexAttribIFormat(paramInt1, paramInt2, paramInt3, paramInt4);
/* 445 */     check();
/*     */   }
/*     */   
/*     */   public void glVertexAttribBinding(int paramInt1, int paramInt2) {
/* 449 */     this.calls++;
/* 450 */     this.gl31.glVertexAttribBinding(paramInt1, paramInt2);
/* 451 */     check();
/*     */   }
/*     */   
/*     */   public void glVertexBindingDivisor(int paramInt1, int paramInt2) {
/* 455 */     this.calls++;
/* 456 */     this.gl31.glVertexBindingDivisor(paramInt1, paramInt2);
/* 457 */     check();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\profiling\GL31Interceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */