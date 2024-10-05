/*     */ package com.badlogic.gdx.graphics.profiling;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.GL31;
/*     */ import com.badlogic.gdx.graphics.GL32;
/*     */ import java.nio.Buffer;
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
/*     */ public class GL32Interceptor
/*     */   extends GL31Interceptor
/*     */   implements GL32
/*     */ {
/*     */   final GL32 gl32;
/*     */   
/*     */   public GL32Interceptor(GLProfiler paramGLProfiler, GL32 paramGL32) {
/*  32 */     super(paramGLProfiler, (GL31)paramGL32);
/*  33 */     this.gl32 = paramGL32;
/*     */   }
/*     */   
/*     */   public void glBlendBarrier() {
/*  37 */     this.calls++;
/*  38 */     this.gl32.glBlendBarrier();
/*  39 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glCopyImageSubData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15) {
/*  44 */     this.calls++;
/*  45 */     this.gl32.glCopyImageSubData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15);
/*     */     
/*  47 */     check();
/*     */   }
/*     */   
/*     */   public void glDebugMessageControl(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer, boolean paramBoolean) {
/*  51 */     this.calls++;
/*  52 */     this.gl32.glDebugMessageControl(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramBoolean);
/*  53 */     check();
/*     */   }
/*     */   
/*     */   public void glDebugMessageInsert(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString) {
/*  57 */     this.calls++;
/*  58 */     this.gl32.glDebugMessageInsert(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
/*  59 */     check();
/*     */   }
/*     */   
/*     */   public void glDebugMessageCallback(GL32.DebugProc paramDebugProc) {
/*  63 */     this.calls++;
/*  64 */     this.gl32.glDebugMessageCallback(paramDebugProc);
/*  65 */     check();
/*  66 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   public int glGetDebugMessageLog(int paramInt, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, IntBuffer paramIntBuffer3, IntBuffer paramIntBuffer4, IntBuffer paramIntBuffer5, ByteBuffer paramByteBuffer) {
/*  71 */     this.calls++;
/*  72 */     paramInt = this.gl32.glGetDebugMessageLog(paramInt, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3, paramIntBuffer4, paramIntBuffer5, paramByteBuffer);
/*  73 */     check();
/*  74 */     return paramInt;
/*     */   }
/*     */   
/*     */   public void glPushDebugGroup(int paramInt1, int paramInt2, String paramString) {
/*  78 */     this.calls++;
/*  79 */     this.gl32.glPushDebugGroup(paramInt1, paramInt2, paramString);
/*  80 */     check();
/*     */   }
/*     */   
/*     */   public void glPopDebugGroup() {
/*  84 */     this.calls++;
/*  85 */     this.gl32.glPopDebugGroup();
/*  86 */     check();
/*     */   }
/*     */   
/*     */   public void glObjectLabel(int paramInt1, int paramInt2, String paramString) {
/*  90 */     this.calls++;
/*  91 */     this.gl32.glObjectLabel(paramInt1, paramInt2, paramString);
/*  92 */     check();
/*     */   }
/*     */   
/*     */   public String glGetObjectLabel(int paramInt1, int paramInt2) {
/*  96 */     this.calls++;
/*  97 */     String str = this.gl32.glGetObjectLabel(paramInt1, paramInt2);
/*  98 */     check();
/*  99 */     return str;
/*     */   }
/*     */   
/*     */   public long glGetPointerv(int paramInt) {
/* 103 */     this.calls++;
/* 104 */     long l = this.gl32.glGetPointerv(paramInt);
/* 105 */     check();
/* 106 */     return l;
/*     */   }
/*     */   
/*     */   public void glEnablei(int paramInt1, int paramInt2) {
/* 110 */     this.calls++;
/* 111 */     this.gl32.glEnablei(paramInt1, paramInt2);
/* 112 */     check();
/*     */   }
/*     */   
/*     */   public void glDisablei(int paramInt1, int paramInt2) {
/* 116 */     this.calls++;
/* 117 */     this.gl32.glDisablei(paramInt1, paramInt2);
/* 118 */     check();
/*     */   }
/*     */   
/*     */   public void glBlendEquationi(int paramInt1, int paramInt2) {
/* 122 */     this.calls++;
/* 123 */     this.gl32.glBlendEquationi(paramInt1, paramInt2);
/* 124 */     check();
/*     */   }
/*     */   
/*     */   public void glBlendEquationSeparatei(int paramInt1, int paramInt2, int paramInt3) {
/* 128 */     this.calls++;
/* 129 */     this.gl32.glBlendEquationSeparatei(paramInt1, paramInt2, paramInt3);
/* 130 */     check();
/*     */   }
/*     */   
/*     */   public void glBlendFunci(int paramInt1, int paramInt2, int paramInt3) {
/* 134 */     this.calls++;
/* 135 */     this.gl32.glBlendFunci(paramInt1, paramInt2, paramInt3);
/* 136 */     check();
/*     */   }
/*     */   
/*     */   public void glBlendFuncSeparatei(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 140 */     this.calls++;
/* 141 */     this.gl32.glBlendFuncSeparatei(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 142 */     check();
/*     */   }
/*     */   
/*     */   public void glColorMaski(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 146 */     this.calls++;
/* 147 */     this.gl32.glColorMaski(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/* 148 */     check();
/*     */   }
/*     */   
/*     */   public boolean glIsEnabledi(int paramInt1, int paramInt2) {
/* 152 */     this.calls++;
/* 153 */     boolean bool = this.gl32.glIsEnabledi(paramInt1, paramInt2);
/* 154 */     check();
/* 155 */     return bool;
/*     */   }
/*     */   
/*     */   public void glDrawElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer, int paramInt4) {
/* 159 */     this.vertexCount.put(paramInt2);
/* 160 */     this.drawCalls++;
/* 161 */     this.calls++;
/* 162 */     this.gl32.glDrawElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramBuffer, paramInt4);
/* 163 */     check();
/*     */   }
/*     */   
/*     */   public void glDrawRangeElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Buffer paramBuffer, int paramInt6) {
/* 167 */     this.vertexCount.put(paramInt4);
/* 168 */     this.drawCalls++;
/* 169 */     this.calls++;
/* 170 */     this.gl32.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBuffer, paramInt6);
/* 171 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer, int paramInt4, int paramInt5) {
/* 176 */     this.vertexCount.put(paramInt2);
/* 177 */     this.drawCalls++;
/* 178 */     this.calls++;
/* 179 */     this.gl32.glDrawElementsInstancedBaseVertex(paramInt1, paramInt2, paramInt3, paramBuffer, paramInt4, paramInt5);
/* 180 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 185 */     this.vertexCount.put(paramInt2);
/* 186 */     this.drawCalls++;
/* 187 */     this.calls++;
/* 188 */     this.gl32.glDrawElementsInstancedBaseVertex(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/* 189 */     check();
/*     */   }
/*     */   
/*     */   public void glFramebufferTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 193 */     this.calls++;
/* 194 */     this.gl32.glFramebufferTexture(paramInt1, paramInt2, paramInt3, paramInt4);
/* 195 */     check();
/*     */   }
/*     */   
/*     */   public int glGetGraphicsResetStatus() {
/* 199 */     this.calls++;
/* 200 */     int i = this.gl32.glGetGraphicsResetStatus();
/* 201 */     check();
/* 202 */     return i;
/*     */   }
/*     */   
/*     */   public void glReadnPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer) {
/* 206 */     this.calls++;
/* 207 */     this.gl32.glReadnPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBuffer);
/* 208 */     check();
/*     */   }
/*     */   
/*     */   public void glGetnUniformfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 212 */     this.calls++;
/* 213 */     this.gl32.glGetnUniformfv(paramInt1, paramInt2, paramFloatBuffer);
/* 214 */     check();
/*     */   }
/*     */   
/*     */   public void glGetnUniformiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 218 */     this.calls++;
/* 219 */     this.gl32.glGetnUniformiv(paramInt1, paramInt2, paramIntBuffer);
/* 220 */     check();
/*     */   }
/*     */   
/*     */   public void glGetnUniformuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 224 */     this.calls++;
/* 225 */     this.gl32.glGetnUniformuiv(paramInt1, paramInt2, paramIntBuffer);
/* 226 */     check();
/*     */   }
/*     */   
/*     */   public void glMinSampleShading(float paramFloat) {
/* 230 */     this.calls++;
/* 231 */     this.gl32.glMinSampleShading(paramFloat);
/* 232 */     check();
/*     */   }
/*     */   
/*     */   public void glPatchParameteri(int paramInt1, int paramInt2) {
/* 236 */     this.calls++;
/* 237 */     this.gl32.glPatchParameteri(paramInt1, paramInt2);
/* 238 */     check();
/*     */   }
/*     */   
/*     */   public void glTexParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 242 */     this.calls++;
/* 243 */     this.gl32.glTexParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/* 244 */     check();
/*     */   }
/*     */   
/*     */   public void glTexParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 248 */     this.calls++;
/* 249 */     this.gl32.glTexParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/* 250 */     check();
/*     */   }
/*     */   
/*     */   public void glGetTexParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 254 */     this.calls++;
/* 255 */     this.gl32.glGetTexParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/* 256 */     check();
/*     */   }
/*     */   
/*     */   public void glGetTexParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 260 */     this.calls++;
/* 261 */     this.gl32.glGetTexParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/* 262 */     check();
/*     */   }
/*     */   
/*     */   public void glSamplerParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 266 */     this.calls++;
/* 267 */     this.gl32.glSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/* 268 */     check();
/*     */   }
/*     */   
/*     */   public void glSamplerParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 272 */     this.calls++;
/* 273 */     this.gl32.glSamplerParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/* 274 */     check();
/*     */   }
/*     */   
/*     */   public void glGetSamplerParameterIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 278 */     this.calls++;
/* 279 */     this.gl32.glGetSamplerParameterIiv(paramInt1, paramInt2, paramIntBuffer);
/* 280 */     check();
/*     */   }
/*     */   
/*     */   public void glGetSamplerParameterIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 284 */     this.calls++;
/* 285 */     this.gl32.glGetSamplerParameterIuiv(paramInt1, paramInt2, paramIntBuffer);
/* 286 */     check();
/*     */   }
/*     */   
/*     */   public void glTexBuffer(int paramInt1, int paramInt2, int paramInt3) {
/* 290 */     this.calls++;
/* 291 */     this.gl32.glTexBuffer(paramInt1, paramInt2, paramInt3);
/* 292 */     check();
/*     */   }
/*     */   
/*     */   public void glTexBufferRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 296 */     this.calls++;
/* 297 */     this.gl32.glTexBufferRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 298 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   public void glTexStorage3DMultisample(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean) {
/* 303 */     this.calls++;
/* 304 */     this.gl32.glTexStorage3DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
/* 305 */     check();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\profiling\GL32Interceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */