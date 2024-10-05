/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.GL31;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL32;
/*     */ import org.lwjgl.opengl.GL40;
/*     */ import org.lwjgl.opengl.GL41;
/*     */ import org.lwjgl.opengl.GL42;
/*     */ import org.lwjgl.opengl.GL43;
/*     */ import org.lwjgl.opengl.GL46;
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
/*     */ public class Lwjgl3GL31
/*     */   extends Lwjgl3GL30
/*     */   implements GL31
/*     */ {
/*  36 */   private static final ByteBuffer tmpByteBuffer = BufferUtils.newByteBuffer(16);
/*     */ 
/*     */   
/*     */   public void glDispatchCompute(int paramInt1, int paramInt2, int paramInt3) {
/*  40 */     GL43.glDispatchCompute(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDispatchComputeIndirect(long paramLong) {
/*  45 */     GL43.glDispatchComputeIndirect(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawArraysIndirect(int paramInt, long paramLong) {
/*  50 */     GL40.glDrawArraysIndirect(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong) {
/*  55 */     GL40.glDrawElementsIndirect(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glFramebufferParameteri(int paramInt1, int paramInt2, int paramInt3) {
/*  60 */     GL43.glFramebufferParameteri(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetFramebufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  65 */     GL43.glGetFramebufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetProgramInterfaceiv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/*  70 */     GL43.glGetProgramInterfaceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glGetProgramResourceIndex(int paramInt1, int paramInt2, String paramString) {
/*  75 */     return GL43.glGetProgramResourceIndex(paramInt1, paramInt2, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String glGetProgramResourceName(int paramInt1, int paramInt2, int paramInt3) {
/*  80 */     return GL43.glGetProgramResourceName(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glGetProgramResourceiv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, IntBuffer paramIntBuffer3) {
/*  86 */     GL43.glGetProgramResourceiv(paramInt1, paramInt2, paramInt3, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glGetProgramResourceLocation(int paramInt1, int paramInt2, String paramString) {
/*  91 */     return GL43.glGetProgramResourceLocation(paramInt1, paramInt2, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glUseProgramStages(int paramInt1, int paramInt2, int paramInt3) {
/*  96 */     GL41.glUseProgramStages(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glActiveShaderProgram(int paramInt1, int paramInt2) {
/* 101 */     GL41.glActiveShaderProgram(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int glCreateShaderProgramv(int paramInt, String[] paramArrayOfString) {
/* 106 */     return GL41.glCreateShaderProgramv(paramInt, (CharSequence[])paramArrayOfString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindProgramPipeline(int paramInt) {
/* 111 */     GL41.glBindProgramPipeline(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDeleteProgramPipelines(int paramInt, IntBuffer paramIntBuffer) {
/* 116 */     int i = paramIntBuffer.limit();
/* 117 */     paramIntBuffer.limit(paramInt);
/* 118 */     GL41.glDeleteProgramPipelines(paramIntBuffer);
/* 119 */     paramIntBuffer.limit(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGenProgramPipelines(int paramInt, IntBuffer paramIntBuffer) {
/* 124 */     int i = paramIntBuffer.limit();
/* 125 */     paramIntBuffer.limit(paramInt);
/* 126 */     GL41.glGenProgramPipelines(paramIntBuffer);
/* 127 */     paramIntBuffer.limit(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean glIsProgramPipeline(int paramInt) {
/* 132 */     return GL41.glIsProgramPipeline(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetProgramPipelineiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 137 */     GL41.glGetProgramPipelineiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform1i(int paramInt1, int paramInt2, int paramInt3) {
/* 142 */     GL41.glProgramUniform1i(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform2i(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 147 */     GL41.glProgramUniform2i(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform3i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 152 */     GL41.glProgramUniform3i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform4i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 157 */     GL41.glProgramUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform1ui(int paramInt1, int paramInt2, int paramInt3) {
/* 162 */     GL41.glProgramUniform1ui(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform2ui(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 167 */     GL41.glProgramUniform2ui(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform3ui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 172 */     GL41.glProgramUniform3ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform4ui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 177 */     GL41.glProgramUniform4ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform1f(int paramInt1, int paramInt2, float paramFloat) {
/* 182 */     GL41.glProgramUniform1f(paramInt1, paramInt2, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform2f(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2) {
/* 187 */     GL41.glProgramUniform2f(paramInt1, paramInt2, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform3f(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 192 */     GL41.glProgramUniform3f(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform4f(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 197 */     GL41.glProgramUniform4f(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform1iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 202 */     GL41.glProgramUniform1iv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform2iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 207 */     GL41.glProgramUniform2iv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform3iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 212 */     GL41.glProgramUniform3iv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform4iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 217 */     GL41.glProgramUniform4iv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform1uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 222 */     GL41.glProgramUniform1uiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform2uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 227 */     GL41.glProgramUniform2uiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform3uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 232 */     GL41.glProgramUniform3uiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform4uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 237 */     GL41.glProgramUniform4uiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform1fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 242 */     GL41.glProgramUniform1fv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform2fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 247 */     GL41.glProgramUniform2fv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform3fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 252 */     GL41.glProgramUniform3fv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniform4fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 257 */     GL41.glProgramUniform4fv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 262 */     GL41.glProgramUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 267 */     GL41.glProgramUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 272 */     GL41.glProgramUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix2x3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 277 */     GL41.glProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix3x2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 282 */     GL41.glProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix2x4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 287 */     GL41.glProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix4x2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 292 */     GL41.glProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix3x4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 297 */     GL41.glProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glProgramUniformMatrix4x3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 302 */     GL41.glProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glValidateProgramPipeline(int paramInt) {
/* 307 */     GL41.glValidateProgramPipeline(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public String glGetProgramPipelineInfoLog(int paramInt) {
/* 312 */     return GL41.glGetProgramPipelineInfoLog(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindImageTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6) {
/* 317 */     GL42.glBindImageTexture(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetBooleani_v(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 322 */     GL46.glGetBooleani_v(paramInt1, paramInt2, tmpByteBuffer);
/* 323 */     paramIntBuffer.put(tmpByteBuffer.asIntBuffer());
/*     */   }
/*     */ 
/*     */   
/*     */   public void glMemoryBarrier(int paramInt) {
/* 328 */     GL42.glMemoryBarrier(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glMemoryBarrierByRegion(int paramInt) {
/* 333 */     GL46.glMemoryBarrierByRegion(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void glTexStorage2DMultisample(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
/* 339 */     GL43.glTexStorage2DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetMultisamplefv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 344 */     GL32.glGetMultisamplefv(paramInt1, paramInt2, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glSampleMaski(int paramInt1, int paramInt2) {
/* 349 */     GL32.glSampleMaski(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetTexLevelParameteriv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/* 354 */     GL11.glGetTexLevelParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glGetTexLevelParameterfv(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer) {
/* 359 */     GL11.glGetTexLevelParameterfv(paramInt1, paramInt2, paramInt3, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glBindVertexBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3) {
/* 364 */     GL43.glBindVertexBuffer(paramInt1, paramInt2, paramLong, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glVertexAttribFormat(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4) {
/* 369 */     GL43.glVertexAttribFormat(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glVertexAttribIFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 374 */     GL43.glVertexAttribIFormat(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glVertexAttribBinding(int paramInt1, int paramInt2) {
/* 379 */     GL43.glVertexAttribBinding(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void glVertexBindingDivisor(int paramInt1, int paramInt2) {
/* 384 */     GL43.glVertexBindingDivisor(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3GL31.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */