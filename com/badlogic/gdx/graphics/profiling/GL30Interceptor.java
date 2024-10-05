/*      */ package com.badlogic.gdx.graphics.profiling;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.GL30;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GL30Interceptor
/*      */   extends GLInterceptor
/*      */   implements GL30
/*      */ {
/*      */   protected final GL30 gl30;
/*      */   
/*      */   protected GL30Interceptor(GLProfiler paramGLProfiler, GL30 paramGL30) {
/*   34 */     super(paramGLProfiler);
/*   35 */     this.gl30 = paramGL30;
/*      */   }
/*      */   
/*      */   private void check() {
/*   39 */     int i = this.gl30.glGetError();
/*   40 */     while (i != 0) {
/*   41 */       this.glProfiler.getListener().onError(i);
/*   42 */       i = this.gl30.glGetError();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void glActiveTexture(int paramInt) {
/*   48 */     this.calls++;
/*   49 */     this.gl30.glActiveTexture(paramInt);
/*   50 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindTexture(int paramInt1, int paramInt2) {
/*   55 */     this.textureBindings++;
/*   56 */     this.calls++;
/*   57 */     this.gl30.glBindTexture(paramInt1, paramInt2);
/*   58 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendFunc(int paramInt1, int paramInt2) {
/*   63 */     this.calls++;
/*   64 */     this.gl30.glBlendFunc(paramInt1, paramInt2);
/*   65 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClear(int paramInt) {
/*   70 */     this.calls++;
/*   71 */     this.gl30.glClear(paramInt);
/*   72 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*   77 */     this.calls++;
/*   78 */     this.gl30.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*   79 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearDepthf(float paramFloat) {
/*   84 */     this.calls++;
/*   85 */     this.gl30.glClearDepthf(paramFloat);
/*   86 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearStencil(int paramInt) {
/*   91 */     this.calls++;
/*   92 */     this.gl30.glClearStencil(paramInt);
/*   93 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glColorMask(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*   98 */     this.calls++;
/*   99 */     this.gl30.glColorMask(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*  100 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer) {
/*  106 */     this.calls++;
/*  107 */     this.gl30.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBuffer);
/*  108 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glCompressedTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/*  114 */     this.calls++;
/*  115 */     this.gl30.glCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
/*  116 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCopyTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/*  121 */     this.calls++;
/*  122 */     this.gl30.glCopyTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*  123 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCopyTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/*  128 */     this.calls++;
/*  129 */     this.gl30.glCopyTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*  130 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCullFace(int paramInt) {
/*  135 */     this.calls++;
/*  136 */     this.gl30.glCullFace(paramInt);
/*  137 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteTextures(int paramInt, IntBuffer paramIntBuffer) {
/*  142 */     this.calls++;
/*  143 */     this.gl30.glDeleteTextures(paramInt, paramIntBuffer);
/*  144 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteTexture(int paramInt) {
/*  149 */     this.calls++;
/*  150 */     this.gl30.glDeleteTexture(paramInt);
/*  151 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDepthFunc(int paramInt) {
/*  156 */     this.calls++;
/*  157 */     this.gl30.glDepthFunc(paramInt);
/*  158 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDepthMask(boolean paramBoolean) {
/*  163 */     this.calls++;
/*  164 */     this.gl30.glDepthMask(paramBoolean);
/*  165 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDepthRangef(float paramFloat1, float paramFloat2) {
/*  170 */     this.calls++;
/*  171 */     this.gl30.glDepthRangef(paramFloat1, paramFloat2);
/*  172 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDisable(int paramInt) {
/*  177 */     this.calls++;
/*  178 */     this.gl30.glDisable(paramInt);
/*  179 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawArrays(int paramInt1, int paramInt2, int paramInt3) {
/*  184 */     this.vertexCount.put(paramInt3);
/*  185 */     this.drawCalls++;
/*  186 */     this.calls++;
/*  187 */     this.gl30.glDrawArrays(paramInt1, paramInt2, paramInt3);
/*  188 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer) {
/*  193 */     this.vertexCount.put(paramInt2);
/*  194 */     this.drawCalls++;
/*  195 */     this.calls++;
/*  196 */     this.gl30.glDrawElements(paramInt1, paramInt2, paramInt3, paramBuffer);
/*  197 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glEnable(int paramInt) {
/*  202 */     this.calls++;
/*  203 */     this.gl30.glEnable(paramInt);
/*  204 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFinish() {
/*  209 */     this.calls++;
/*  210 */     this.gl30.glFinish();
/*  211 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFlush() {
/*  216 */     this.calls++;
/*  217 */     this.gl30.glFlush();
/*  218 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFrontFace(int paramInt) {
/*  223 */     this.calls++;
/*  224 */     this.gl30.glFrontFace(paramInt);
/*  225 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenTextures(int paramInt, IntBuffer paramIntBuffer) {
/*  230 */     this.calls++;
/*  231 */     this.gl30.glGenTextures(paramInt, paramIntBuffer);
/*  232 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGenTexture() {
/*  237 */     this.calls++;
/*  238 */     int i = this.gl30.glGenTexture();
/*  239 */     check();
/*  240 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGetError() {
/*  245 */     this.calls++;
/*      */     
/*  247 */     return this.gl30.glGetError();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetIntegerv(int paramInt, IntBuffer paramIntBuffer) {
/*  252 */     this.calls++;
/*  253 */     this.gl30.glGetIntegerv(paramInt, paramIntBuffer);
/*  254 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetString(int paramInt) {
/*  259 */     this.calls++;
/*  260 */     String str = this.gl30.glGetString(paramInt);
/*  261 */     check();
/*  262 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glHint(int paramInt1, int paramInt2) {
/*  267 */     this.calls++;
/*  268 */     this.gl30.glHint(paramInt1, paramInt2);
/*  269 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glLineWidth(float paramFloat) {
/*  274 */     this.calls++;
/*  275 */     this.gl30.glLineWidth(paramFloat);
/*  276 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glPixelStorei(int paramInt1, int paramInt2) {
/*  281 */     this.calls++;
/*  282 */     this.gl30.glPixelStorei(paramInt1, paramInt2);
/*  283 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glPolygonOffset(float paramFloat1, float paramFloat2) {
/*  288 */     this.calls++;
/*  289 */     this.gl30.glPolygonOffset(paramFloat1, paramFloat2);
/*  290 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glReadPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Buffer paramBuffer) {
/*  295 */     this.calls++;
/*  296 */     this.gl30.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBuffer);
/*  297 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glScissor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  302 */     this.calls++;
/*  303 */     this.gl30.glScissor(paramInt1, paramInt2, paramInt3, paramInt4);
/*  304 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilFunc(int paramInt1, int paramInt2, int paramInt3) {
/*  309 */     this.calls++;
/*  310 */     this.gl30.glStencilFunc(paramInt1, paramInt2, paramInt3);
/*  311 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilMask(int paramInt) {
/*  316 */     this.calls++;
/*  317 */     this.gl30.glStencilMask(paramInt);
/*  318 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilOp(int paramInt1, int paramInt2, int paramInt3) {
/*  323 */     this.calls++;
/*  324 */     this.gl30.glStencilOp(paramInt1, paramInt2, paramInt3);
/*  325 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/*  331 */     this.calls++;
/*  332 */     this.gl30.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
/*  333 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
/*  339 */     this.calls++;
/*  340 */     this.gl30.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9);
/*  341 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTexParameterf(int paramInt1, int paramInt2, float paramFloat) {
/*  346 */     this.calls++;
/*  347 */     this.gl30.glTexParameterf(paramInt1, paramInt2, paramFloat);
/*  348 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/*  354 */     this.calls++;
/*  355 */     this.gl30.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
/*  356 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
/*  362 */     this.calls++;
/*  363 */     this.gl30.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9);
/*  364 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  369 */     this.calls++;
/*  370 */     this.gl30.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
/*  371 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glAttachShader(int paramInt1, int paramInt2) {
/*  376 */     this.calls++;
/*  377 */     this.gl30.glAttachShader(paramInt1, paramInt2);
/*  378 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindAttribLocation(int paramInt1, int paramInt2, String paramString) {
/*  383 */     this.calls++;
/*  384 */     this.gl30.glBindAttribLocation(paramInt1, paramInt2, paramString);
/*  385 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindBuffer(int paramInt1, int paramInt2) {
/*  390 */     this.calls++;
/*  391 */     this.gl30.glBindBuffer(paramInt1, paramInt2);
/*  392 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindFramebuffer(int paramInt1, int paramInt2) {
/*  397 */     this.calls++;
/*  398 */     this.gl30.glBindFramebuffer(paramInt1, paramInt2);
/*  399 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindRenderbuffer(int paramInt1, int paramInt2) {
/*  404 */     this.calls++;
/*  405 */     this.gl30.glBindRenderbuffer(paramInt1, paramInt2);
/*  406 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  411 */     this.calls++;
/*  412 */     this.gl30.glBlendColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  413 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendEquation(int paramInt) {
/*  418 */     this.calls++;
/*  419 */     this.gl30.glBlendEquation(paramInt);
/*  420 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendEquationSeparate(int paramInt1, int paramInt2) {
/*  425 */     this.calls++;
/*  426 */     this.gl30.glBlendEquationSeparate(paramInt1, paramInt2);
/*  427 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendFuncSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  432 */     this.calls++;
/*  433 */     this.gl30.glBlendFuncSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*  434 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBufferData(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3) {
/*  439 */     this.calls++;
/*  440 */     this.gl30.glBufferData(paramInt1, paramInt2, paramBuffer, paramInt3);
/*  441 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBufferSubData(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer) {
/*  446 */     this.calls++;
/*  447 */     this.gl30.glBufferSubData(paramInt1, paramInt2, paramInt3, paramBuffer);
/*  448 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glCheckFramebufferStatus(int paramInt) {
/*  453 */     this.calls++;
/*  454 */     paramInt = this.gl30.glCheckFramebufferStatus(paramInt);
/*  455 */     check();
/*  456 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCompileShader(int paramInt) {
/*  461 */     this.calls++;
/*  462 */     this.gl30.glCompileShader(paramInt);
/*  463 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glCreateProgram() {
/*  468 */     this.calls++;
/*  469 */     int i = this.gl30.glCreateProgram();
/*  470 */     check();
/*  471 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public int glCreateShader(int paramInt) {
/*  476 */     this.calls++;
/*  477 */     paramInt = this.gl30.glCreateShader(paramInt);
/*  478 */     check();
/*  479 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteBuffer(int paramInt) {
/*  484 */     this.calls++;
/*  485 */     this.gl30.glDeleteBuffer(paramInt);
/*  486 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteBuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  491 */     this.calls++;
/*  492 */     this.gl30.glDeleteBuffers(paramInt, paramIntBuffer);
/*  493 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteFramebuffer(int paramInt) {
/*  498 */     this.calls++;
/*  499 */     this.gl30.glDeleteFramebuffer(paramInt);
/*  500 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteFramebuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  505 */     this.calls++;
/*  506 */     this.gl30.glDeleteFramebuffers(paramInt, paramIntBuffer);
/*  507 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteProgram(int paramInt) {
/*  512 */     this.calls++;
/*  513 */     this.gl30.glDeleteProgram(paramInt);
/*  514 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteRenderbuffer(int paramInt) {
/*  519 */     this.calls++;
/*  520 */     this.gl30.glDeleteRenderbuffer(paramInt);
/*  521 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteRenderbuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  526 */     this.calls++;
/*  527 */     this.gl30.glDeleteRenderbuffers(paramInt, paramIntBuffer);
/*  528 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteShader(int paramInt) {
/*  533 */     this.calls++;
/*  534 */     this.gl30.glDeleteShader(paramInt);
/*  535 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDetachShader(int paramInt1, int paramInt2) {
/*  540 */     this.calls++;
/*  541 */     this.gl30.glDetachShader(paramInt1, paramInt2);
/*  542 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDisableVertexAttribArray(int paramInt) {
/*  547 */     this.calls++;
/*  548 */     this.gl30.glDisableVertexAttribArray(paramInt);
/*  549 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  554 */     this.vertexCount.put(paramInt2);
/*  555 */     this.drawCalls++;
/*  556 */     this.calls++;
/*  557 */     this.gl30.glDrawElements(paramInt1, paramInt2, paramInt3, paramInt4);
/*  558 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glEnableVertexAttribArray(int paramInt) {
/*  563 */     this.calls++;
/*  564 */     this.gl30.glEnableVertexAttribArray(paramInt);
/*  565 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFramebufferRenderbuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  570 */     this.calls++;
/*  571 */     this.gl30.glFramebufferRenderbuffer(paramInt1, paramInt2, paramInt3, paramInt4);
/*  572 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFramebufferTexture2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/*  577 */     this.calls++;
/*  578 */     this.gl30.glFramebufferTexture2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*  579 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGenBuffer() {
/*  584 */     this.calls++;
/*  585 */     int i = this.gl30.glGenBuffer();
/*  586 */     check();
/*  587 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenBuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  592 */     this.calls++;
/*  593 */     this.gl30.glGenBuffers(paramInt, paramIntBuffer);
/*  594 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenerateMipmap(int paramInt) {
/*  599 */     this.calls++;
/*  600 */     this.gl30.glGenerateMipmap(paramInt);
/*  601 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGenFramebuffer() {
/*  606 */     this.calls++;
/*  607 */     int i = this.gl30.glGenFramebuffer();
/*  608 */     check();
/*  609 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenFramebuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  614 */     this.calls++;
/*  615 */     this.gl30.glGenFramebuffers(paramInt, paramIntBuffer);
/*  616 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGenRenderbuffer() {
/*  621 */     this.calls++;
/*  622 */     int i = this.gl30.glGenRenderbuffer();
/*  623 */     check();
/*  624 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenRenderbuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  629 */     this.calls++;
/*  630 */     this.gl30.glGenRenderbuffers(paramInt, paramIntBuffer);
/*  631 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetActiveAttrib(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/*  636 */     this.calls++;
/*  637 */     String str = this.gl30.glGetActiveAttrib(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2);
/*  638 */     check();
/*  639 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetActiveUniform(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/*  644 */     this.calls++;
/*  645 */     String str = this.gl30.glGetActiveUniform(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2);
/*  646 */     check();
/*  647 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetAttachedShaders(int paramInt1, int paramInt2, Buffer paramBuffer, IntBuffer paramIntBuffer) {
/*  652 */     this.calls++;
/*  653 */     this.gl30.glGetAttachedShaders(paramInt1, paramInt2, paramBuffer, paramIntBuffer);
/*  654 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGetAttribLocation(int paramInt, String paramString) {
/*  659 */     this.calls++;
/*  660 */     paramInt = this.gl30.glGetAttribLocation(paramInt, paramString);
/*  661 */     check();
/*  662 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetBooleanv(int paramInt, Buffer paramBuffer) {
/*  667 */     this.calls++;
/*  668 */     this.gl30.glGetBooleanv(paramInt, paramBuffer);
/*  669 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetBufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  674 */     this.calls++;
/*  675 */     this.gl30.glGetBufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  676 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetFloatv(int paramInt, FloatBuffer paramFloatBuffer) {
/*  681 */     this.calls++;
/*  682 */     this.gl30.glGetFloatv(paramInt, paramFloatBuffer);
/*  683 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/*  688 */     this.calls++;
/*  689 */     this.gl30.glGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*  690 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetProgramiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  695 */     this.calls++;
/*  696 */     this.gl30.glGetProgramiv(paramInt1, paramInt2, paramIntBuffer);
/*  697 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetProgramInfoLog(int paramInt) {
/*  702 */     this.calls++;
/*  703 */     String str = this.gl30.glGetProgramInfoLog(paramInt);
/*  704 */     check();
/*  705 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetRenderbufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  710 */     this.calls++;
/*  711 */     this.gl30.glGetRenderbufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  712 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetShaderiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  717 */     this.calls++;
/*  718 */     this.gl30.glGetShaderiv(paramInt1, paramInt2, paramIntBuffer);
/*  719 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetShaderInfoLog(int paramInt) {
/*  724 */     this.calls++;
/*  725 */     String str = this.gl30.glGetShaderInfoLog(paramInt);
/*  726 */     check();
/*  727 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetShaderPrecisionFormat(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/*  732 */     this.calls++;
/*  733 */     this.gl30.glGetShaderPrecisionFormat(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2);
/*  734 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  739 */     this.calls++;
/*  740 */     this.gl30.glGetTexParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*  741 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  746 */     this.calls++;
/*  747 */     this.gl30.glGetTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  748 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetUniformfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  753 */     this.calls++;
/*  754 */     this.gl30.glGetUniformfv(paramInt1, paramInt2, paramFloatBuffer);
/*  755 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetUniformiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  760 */     this.calls++;
/*  761 */     this.gl30.glGetUniformiv(paramInt1, paramInt2, paramIntBuffer);
/*  762 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGetUniformLocation(int paramInt, String paramString) {
/*  767 */     this.calls++;
/*  768 */     paramInt = this.gl30.glGetUniformLocation(paramInt, paramString);
/*  769 */     check();
/*  770 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetVertexAttribfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  775 */     this.calls++;
/*  776 */     this.gl30.glGetVertexAttribfv(paramInt1, paramInt2, paramFloatBuffer);
/*  777 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetVertexAttribiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  782 */     this.calls++;
/*  783 */     this.gl30.glGetVertexAttribiv(paramInt1, paramInt2, paramIntBuffer);
/*  784 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetVertexAttribPointerv(int paramInt1, int paramInt2, Buffer paramBuffer) {
/*  789 */     this.calls++;
/*  790 */     this.gl30.glGetVertexAttribPointerv(paramInt1, paramInt2, paramBuffer);
/*  791 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsBuffer(int paramInt) {
/*  796 */     this.calls++;
/*  797 */     boolean bool = this.gl30.glIsBuffer(paramInt);
/*  798 */     check();
/*  799 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsEnabled(int paramInt) {
/*  804 */     this.calls++;
/*  805 */     boolean bool = this.gl30.glIsEnabled(paramInt);
/*  806 */     check();
/*  807 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsFramebuffer(int paramInt) {
/*  812 */     this.calls++;
/*  813 */     boolean bool = this.gl30.glIsFramebuffer(paramInt);
/*  814 */     check();
/*  815 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsProgram(int paramInt) {
/*  820 */     this.calls++;
/*  821 */     boolean bool = this.gl30.glIsProgram(paramInt);
/*  822 */     check();
/*  823 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsRenderbuffer(int paramInt) {
/*  828 */     this.calls++;
/*  829 */     boolean bool = this.gl30.glIsRenderbuffer(paramInt);
/*  830 */     check();
/*  831 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsShader(int paramInt) {
/*  836 */     this.calls++;
/*  837 */     boolean bool = this.gl30.glIsShader(paramInt);
/*  838 */     check();
/*  839 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsTexture(int paramInt) {
/*  844 */     this.calls++;
/*  845 */     boolean bool = this.gl30.glIsTexture(paramInt);
/*  846 */     check();
/*  847 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glLinkProgram(int paramInt) {
/*  852 */     this.calls++;
/*  853 */     this.gl30.glLinkProgram(paramInt);
/*  854 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glReleaseShaderCompiler() {
/*  859 */     this.calls++;
/*  860 */     this.gl30.glReleaseShaderCompiler();
/*  861 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glRenderbufferStorage(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  866 */     this.calls++;
/*  867 */     this.gl30.glRenderbufferStorage(paramInt1, paramInt2, paramInt3, paramInt4);
/*  868 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glSampleCoverage(float paramFloat, boolean paramBoolean) {
/*  873 */     this.calls++;
/*  874 */     this.gl30.glSampleCoverage(paramFloat, paramBoolean);
/*  875 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glShaderBinary(int paramInt1, IntBuffer paramIntBuffer, int paramInt2, Buffer paramBuffer, int paramInt3) {
/*  880 */     this.calls++;
/*  881 */     this.gl30.glShaderBinary(paramInt1, paramIntBuffer, paramInt2, paramBuffer, paramInt3);
/*  882 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glShaderSource(int paramInt, String paramString) {
/*  887 */     this.calls++;
/*  888 */     this.gl30.glShaderSource(paramInt, paramString);
/*  889 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilFuncSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  894 */     this.calls++;
/*  895 */     this.gl30.glStencilFuncSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*  896 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilMaskSeparate(int paramInt1, int paramInt2) {
/*  901 */     this.calls++;
/*  902 */     this.gl30.glStencilMaskSeparate(paramInt1, paramInt2);
/*  903 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilOpSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  908 */     this.calls++;
/*  909 */     this.gl30.glStencilOpSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*  910 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  915 */     this.calls++;
/*  916 */     this.gl30.glTexParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*  917 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTexParameteri(int paramInt1, int paramInt2, int paramInt3) {
/*  922 */     this.calls++;
/*  923 */     this.gl30.glTexParameteri(paramInt1, paramInt2, paramInt3);
/*  924 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  929 */     this.calls++;
/*  930 */     this.gl30.glTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  931 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1f(int paramInt, float paramFloat) {
/*  936 */     this.calls++;
/*  937 */     this.gl30.glUniform1f(paramInt, paramFloat);
/*  938 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  943 */     this.calls++;
/*  944 */     this.gl30.glUniform1fv(paramInt1, paramInt2, paramFloatBuffer);
/*  945 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/*  950 */     this.calls++;
/*  951 */     this.gl30.glUniform1fv(paramInt1, paramInt2, paramArrayOffloat, paramInt3);
/*  952 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1i(int paramInt1, int paramInt2) {
/*  957 */     this.calls++;
/*  958 */     this.gl30.glUniform1i(paramInt1, paramInt2);
/*  959 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  964 */     this.calls++;
/*  965 */     this.gl30.glUniform1iv(paramInt1, paramInt2, paramIntBuffer);
/*  966 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/*  971 */     this.calls++;
/*  972 */     this.gl30.glUniform1iv(paramInt1, paramInt2, paramArrayOfint, paramInt3);
/*  973 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2f(int paramInt, float paramFloat1, float paramFloat2) {
/*  978 */     this.calls++;
/*  979 */     this.gl30.glUniform2f(paramInt, paramFloat1, paramFloat2);
/*  980 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  985 */     this.calls++;
/*  986 */     this.gl30.glUniform2fv(paramInt1, paramInt2, paramFloatBuffer);
/*  987 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/*  992 */     this.calls++;
/*  993 */     this.gl30.glUniform2fv(paramInt1, paramInt2, paramArrayOffloat, paramInt3);
/*  994 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2i(int paramInt1, int paramInt2, int paramInt3) {
/*  999 */     this.calls++;
/* 1000 */     this.gl30.glUniform2i(paramInt1, paramInt2, paramInt3);
/* 1001 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1006 */     this.calls++;
/* 1007 */     this.gl30.glUniform2iv(paramInt1, paramInt2, paramIntBuffer);
/* 1008 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 1013 */     this.calls++;
/* 1014 */     this.gl30.glUniform2iv(paramInt1, paramInt2, paramArrayOfint, paramInt3);
/* 1015 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1020 */     this.calls++;
/* 1021 */     this.gl30.glUniform3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
/* 1022 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 1027 */     this.calls++;
/* 1028 */     this.gl30.glUniform3fv(paramInt1, paramInt2, paramFloatBuffer);
/* 1029 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/* 1034 */     this.calls++;
/* 1035 */     this.gl30.glUniform3fv(paramInt1, paramInt2, paramArrayOffloat, paramInt3);
/* 1036 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3i(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1041 */     this.calls++;
/* 1042 */     this.gl30.glUniform3i(paramInt1, paramInt2, paramInt3, paramInt4);
/* 1043 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1048 */     this.calls++;
/* 1049 */     this.gl30.glUniform3iv(paramInt1, paramInt2, paramIntBuffer);
/* 1050 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 1055 */     this.calls++;
/* 1056 */     this.gl30.glUniform3iv(paramInt1, paramInt2, paramArrayOfint, paramInt3);
/* 1057 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1062 */     this.calls++;
/* 1063 */     this.gl30.glUniform4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1064 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 1069 */     this.calls++;
/* 1070 */     this.gl30.glUniform4fv(paramInt1, paramInt2, paramFloatBuffer);
/* 1071 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/* 1076 */     this.calls++;
/* 1077 */     this.gl30.glUniform4fv(paramInt1, paramInt2, paramArrayOffloat, paramInt3);
/* 1078 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1083 */     this.calls++;
/* 1084 */     this.gl30.glUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1085 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1090 */     this.calls++;
/* 1091 */     this.gl30.glUniform4iv(paramInt1, paramInt2, paramIntBuffer);
/* 1092 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 1097 */     this.calls++;
/* 1098 */     this.gl30.glUniform4iv(paramInt1, paramInt2, paramArrayOfint, paramInt3);
/* 1099 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1104 */     this.calls++;
/* 1105 */     this.gl30.glUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1106 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 1111 */     this.calls++;
/* 1112 */     this.gl30.glUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat, paramInt3);
/* 1113 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1118 */     this.calls++;
/* 1119 */     this.gl30.glUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1120 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 1125 */     this.calls++;
/* 1126 */     this.gl30.glUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat, paramInt3);
/* 1127 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1132 */     this.calls++;
/* 1133 */     this.gl30.glUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1134 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 1139 */     this.calls++;
/* 1140 */     this.gl30.glUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat, paramInt3);
/* 1141 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUseProgram(int paramInt) {
/* 1146 */     this.shaderSwitches++;
/* 1147 */     this.calls++;
/* 1148 */     this.gl30.glUseProgram(paramInt);
/* 1149 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glValidateProgram(int paramInt) {
/* 1154 */     this.calls++;
/* 1155 */     this.gl30.glValidateProgram(paramInt);
/* 1156 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib1f(int paramInt, float paramFloat) {
/* 1161 */     this.calls++;
/* 1162 */     this.gl30.glVertexAttrib1f(paramInt, paramFloat);
/* 1163 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib1fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 1168 */     this.calls++;
/* 1169 */     this.gl30.glVertexAttrib1fv(paramInt, paramFloatBuffer);
/* 1170 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib2f(int paramInt, float paramFloat1, float paramFloat2) {
/* 1175 */     this.calls++;
/* 1176 */     this.gl30.glVertexAttrib2f(paramInt, paramFloat1, paramFloat2);
/* 1177 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib2fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 1182 */     this.calls++;
/* 1183 */     this.gl30.glVertexAttrib2fv(paramInt, paramFloatBuffer);
/* 1184 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib3f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1189 */     this.calls++;
/* 1190 */     this.gl30.glVertexAttrib3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
/* 1191 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib3fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 1196 */     this.calls++;
/* 1197 */     this.gl30.glVertexAttrib3fv(paramInt, paramFloatBuffer);
/* 1198 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib4f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1203 */     this.calls++;
/* 1204 */     this.gl30.glVertexAttrib4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1205 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib4fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 1210 */     this.calls++;
/* 1211 */     this.gl30.glVertexAttrib4fv(paramInt, paramFloatBuffer);
/* 1212 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, Buffer paramBuffer) {
/* 1217 */     this.calls++;
/* 1218 */     this.gl30.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramBuffer);
/* 1219 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5) {
/* 1224 */     this.calls++;
/* 1225 */     this.gl30.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5);
/* 1226 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void glReadBuffer(int paramInt) {
/* 1233 */     this.calls++;
/* 1234 */     this.gl30.glReadBuffer(paramInt);
/* 1235 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawRangeElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Buffer paramBuffer) {
/* 1240 */     this.vertexCount.put(paramInt4);
/* 1241 */     this.drawCalls++;
/* 1242 */     this.calls++;
/* 1243 */     this.gl30.glDrawRangeElements(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBuffer);
/* 1244 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawRangeElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 1249 */     this.vertexCount.put(paramInt4);
/* 1250 */     this.drawCalls++;
/* 1251 */     this.calls++;
/* 1252 */     this.gl30.glDrawRangeElements(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/* 1253 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, Buffer paramBuffer) {
/* 1259 */     this.calls++;
/* 1260 */     this.gl30.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramBuffer);
/* 1261 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
/* 1267 */     this.calls++;
/* 1268 */     this.gl30.glTexImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
/* 1269 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, Buffer paramBuffer) {
/* 1275 */     this.calls++;
/* 1276 */     this.gl30.glTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramBuffer);
/* 1277 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11) {
/* 1283 */     this.calls++;
/* 1284 */     this.gl30.glTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11);
/* 1285 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glCopyTexSubImage3D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
/* 1291 */     this.calls++;
/* 1292 */     this.gl30.glCopyTexSubImage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9);
/* 1293 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenQueries(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 1298 */     this.calls++;
/* 1299 */     this.gl30.glGenQueries(paramInt1, paramArrayOfint, paramInt2);
/* 1300 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenQueries(int paramInt, IntBuffer paramIntBuffer) {
/* 1305 */     this.calls++;
/* 1306 */     this.gl30.glGenQueries(paramInt, paramIntBuffer);
/* 1307 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteQueries(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 1312 */     this.calls++;
/* 1313 */     this.gl30.glDeleteQueries(paramInt1, paramArrayOfint, paramInt2);
/* 1314 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteQueries(int paramInt, IntBuffer paramIntBuffer) {
/* 1319 */     this.calls++;
/* 1320 */     this.gl30.glDeleteQueries(paramInt, paramIntBuffer);
/* 1321 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsQuery(int paramInt) {
/* 1326 */     this.calls++;
/* 1327 */     boolean bool = this.gl30.glIsQuery(paramInt);
/* 1328 */     check();
/* 1329 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBeginQuery(int paramInt1, int paramInt2) {
/* 1334 */     this.calls++;
/* 1335 */     this.gl30.glBeginQuery(paramInt1, paramInt2);
/* 1336 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glEndQuery(int paramInt) {
/* 1341 */     this.calls++;
/* 1342 */     this.gl30.glEndQuery(paramInt);
/* 1343 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetQueryiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1348 */     this.calls++;
/* 1349 */     this.gl30.glGetQueryiv(paramInt1, paramInt2, paramIntBuffer);
/* 1350 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetQueryObjectuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1355 */     this.calls++;
/* 1356 */     this.gl30.glGetQueryObjectuiv(paramInt1, paramInt2, paramIntBuffer);
/* 1357 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glUnmapBuffer(int paramInt) {
/* 1362 */     this.calls++;
/* 1363 */     boolean bool = this.gl30.glUnmapBuffer(paramInt);
/* 1364 */     check();
/* 1365 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public Buffer glGetBufferPointerv(int paramInt1, int paramInt2) {
/* 1370 */     this.calls++;
/* 1371 */     Buffer buffer = this.gl30.glGetBufferPointerv(paramInt1, paramInt2);
/* 1372 */     check();
/* 1373 */     return buffer;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawBuffers(int paramInt, IntBuffer paramIntBuffer) {
/* 1378 */     this.drawCalls++;
/* 1379 */     this.calls++;
/* 1380 */     this.gl30.glDrawBuffers(paramInt, paramIntBuffer);
/* 1381 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix2x3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1386 */     this.calls++;
/* 1387 */     this.gl30.glUniformMatrix2x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1388 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix3x2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1393 */     this.calls++;
/* 1394 */     this.gl30.glUniformMatrix3x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1395 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix2x4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1400 */     this.calls++;
/* 1401 */     this.gl30.glUniformMatrix2x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1402 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix4x2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1407 */     this.calls++;
/* 1408 */     this.gl30.glUniformMatrix4x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1409 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix3x4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1414 */     this.calls++;
/* 1415 */     this.gl30.glUniformMatrix3x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1416 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix4x3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1421 */     this.calls++;
/* 1422 */     this.gl30.glUniformMatrix4x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1423 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glBlitFramebuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
/* 1429 */     this.calls++;
/* 1430 */     this.gl30.glBlitFramebuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
/* 1431 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glRenderbufferStorageMultisample(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1436 */     this.calls++;
/* 1437 */     this.gl30.glRenderbufferStorageMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1438 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFramebufferTextureLayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1443 */     this.calls++;
/* 1444 */     this.gl30.glFramebufferTextureLayer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1445 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public Buffer glMapBufferRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1450 */     this.calls++;
/* 1451 */     Buffer buffer = this.gl30.glMapBufferRange(paramInt1, paramInt2, paramInt3, paramInt4);
/* 1452 */     check();
/* 1453 */     return buffer;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFlushMappedBufferRange(int paramInt1, int paramInt2, int paramInt3) {
/* 1458 */     this.calls++;
/* 1459 */     this.gl30.glFlushMappedBufferRange(paramInt1, paramInt2, paramInt3);
/* 1460 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindVertexArray(int paramInt) {
/* 1465 */     this.calls++;
/* 1466 */     this.gl30.glBindVertexArray(paramInt);
/* 1467 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteVertexArrays(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 1472 */     this.calls++;
/* 1473 */     this.gl30.glDeleteVertexArrays(paramInt1, paramArrayOfint, paramInt2);
/* 1474 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteVertexArrays(int paramInt, IntBuffer paramIntBuffer) {
/* 1479 */     this.calls++;
/* 1480 */     this.gl30.glDeleteVertexArrays(paramInt, paramIntBuffer);
/* 1481 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenVertexArrays(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 1486 */     this.calls++;
/* 1487 */     this.gl30.glGenVertexArrays(paramInt1, paramArrayOfint, paramInt2);
/* 1488 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenVertexArrays(int paramInt, IntBuffer paramIntBuffer) {
/* 1493 */     this.calls++;
/* 1494 */     this.gl30.glGenVertexArrays(paramInt, paramIntBuffer);
/* 1495 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsVertexArray(int paramInt) {
/* 1500 */     this.calls++;
/* 1501 */     boolean bool = this.gl30.glIsVertexArray(paramInt);
/* 1502 */     check();
/* 1503 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBeginTransformFeedback(int paramInt) {
/* 1508 */     this.calls++;
/* 1509 */     this.gl30.glBeginTransformFeedback(paramInt);
/* 1510 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glEndTransformFeedback() {
/* 1515 */     this.calls++;
/* 1516 */     this.gl30.glEndTransformFeedback();
/* 1517 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindBufferRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1522 */     this.calls++;
/* 1523 */     this.gl30.glBindBufferRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1524 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindBufferBase(int paramInt1, int paramInt2, int paramInt3) {
/* 1529 */     this.calls++;
/* 1530 */     this.gl30.glBindBufferBase(paramInt1, paramInt2, paramInt3);
/* 1531 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTransformFeedbackVaryings(int paramInt1, String[] paramArrayOfString, int paramInt2) {
/* 1536 */     this.calls++;
/* 1537 */     this.gl30.glTransformFeedbackVaryings(paramInt1, paramArrayOfString, paramInt2);
/* 1538 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttribIPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1543 */     this.calls++;
/* 1544 */     this.gl30.glVertexAttribIPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1545 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetVertexAttribIiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1550 */     this.calls++;
/* 1551 */     this.gl30.glGetVertexAttribIiv(paramInt1, paramInt2, paramIntBuffer);
/* 1552 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetVertexAttribIuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1557 */     this.calls++;
/* 1558 */     this.gl30.glGetVertexAttribIuiv(paramInt1, paramInt2, paramIntBuffer);
/* 1559 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttribI4i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1564 */     this.calls++;
/* 1565 */     this.gl30.glVertexAttribI4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1566 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttribI4ui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1571 */     this.calls++;
/* 1572 */     this.gl30.glVertexAttribI4ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1573 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetUniformuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1578 */     this.calls++;
/* 1579 */     this.gl30.glGetUniformuiv(paramInt1, paramInt2, paramIntBuffer);
/* 1580 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGetFragDataLocation(int paramInt, String paramString) {
/* 1585 */     this.calls++;
/* 1586 */     paramInt = this.gl30.glGetFragDataLocation(paramInt, paramString);
/* 1587 */     check();
/* 1588 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1593 */     this.calls++;
/* 1594 */     this.gl30.glUniform1uiv(paramInt1, paramInt2, paramIntBuffer);
/* 1595 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1600 */     this.calls++;
/* 1601 */     this.gl30.glUniform3uiv(paramInt1, paramInt2, paramIntBuffer);
/* 1602 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4uiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1607 */     this.calls++;
/* 1608 */     this.gl30.glUniform4uiv(paramInt1, paramInt2, paramIntBuffer);
/* 1609 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearBufferiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1614 */     this.calls++;
/* 1615 */     this.gl30.glClearBufferiv(paramInt1, paramInt2, paramIntBuffer);
/* 1616 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearBufferuiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1621 */     this.calls++;
/* 1622 */     this.gl30.glClearBufferuiv(paramInt1, paramInt2, paramIntBuffer);
/* 1623 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearBufferfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 1628 */     this.calls++;
/* 1629 */     this.gl30.glClearBufferfv(paramInt1, paramInt2, paramFloatBuffer);
/* 1630 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearBufferfi(int paramInt1, int paramInt2, float paramFloat, int paramInt3) {
/* 1635 */     this.calls++;
/* 1636 */     this.gl30.glClearBufferfi(paramInt1, paramInt2, paramFloat, paramInt3);
/* 1637 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetStringi(int paramInt1, int paramInt2) {
/* 1642 */     this.calls++;
/* 1643 */     String str = this.gl30.glGetStringi(paramInt1, paramInt2);
/* 1644 */     check();
/* 1645 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCopyBufferSubData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1650 */     this.calls++;
/* 1651 */     this.gl30.glCopyBufferSubData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1652 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetUniformIndices(int paramInt, String[] paramArrayOfString, IntBuffer paramIntBuffer) {
/* 1657 */     this.calls++;
/* 1658 */     this.gl30.glGetUniformIndices(paramInt, paramArrayOfString, paramIntBuffer);
/* 1659 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetActiveUniformsiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, int paramInt3, IntBuffer paramIntBuffer2) {
/* 1664 */     this.calls++;
/* 1665 */     this.gl30.glGetActiveUniformsiv(paramInt1, paramInt2, paramIntBuffer1, paramInt3, paramIntBuffer2);
/* 1666 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGetUniformBlockIndex(int paramInt, String paramString) {
/* 1671 */     this.calls++;
/* 1672 */     paramInt = this.gl30.glGetUniformBlockIndex(paramInt, paramString);
/* 1673 */     check();
/* 1674 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetActiveUniformBlockiv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/* 1679 */     this.calls++;
/* 1680 */     this.gl30.glGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/* 1681 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetActiveUniformBlockName(int paramInt1, int paramInt2, Buffer paramBuffer1, Buffer paramBuffer2) {
/* 1686 */     this.calls++;
/* 1687 */     this.gl30.glGetActiveUniformBlockName(paramInt1, paramInt2, paramBuffer1, paramBuffer2);
/* 1688 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetActiveUniformBlockName(int paramInt1, int paramInt2) {
/* 1693 */     this.calls++;
/* 1694 */     String str = this.gl30.glGetActiveUniformBlockName(paramInt1, paramInt2);
/* 1695 */     check();
/* 1696 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformBlockBinding(int paramInt1, int paramInt2, int paramInt3) {
/* 1701 */     this.calls++;
/* 1702 */     this.gl30.glUniformBlockBinding(paramInt1, paramInt2, paramInt3);
/* 1703 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawArraysInstanced(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1708 */     this.vertexCount.put(paramInt3);
/* 1709 */     this.drawCalls++;
/* 1710 */     this.calls++;
/* 1711 */     this.gl30.glDrawArraysInstanced(paramInt1, paramInt2, paramInt3, paramInt4);
/* 1712 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawElementsInstanced(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1717 */     this.vertexCount.put(paramInt2);
/* 1718 */     this.drawCalls++;
/* 1719 */     this.calls++;
/* 1720 */     this.gl30.glDrawElementsInstanced(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1721 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetInteger64v(int paramInt, LongBuffer paramLongBuffer) {
/* 1726 */     this.calls++;
/* 1727 */     this.gl30.glGetInteger64v(paramInt, paramLongBuffer);
/* 1728 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetBufferParameteri64v(int paramInt1, int paramInt2, LongBuffer paramLongBuffer) {
/* 1733 */     this.calls++;
/* 1734 */     this.gl30.glGetBufferParameteri64v(paramInt1, paramInt2, paramLongBuffer);
/* 1735 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenSamplers(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 1740 */     this.calls++;
/* 1741 */     this.gl30.glGenSamplers(paramInt1, paramArrayOfint, paramInt2);
/* 1742 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenSamplers(int paramInt, IntBuffer paramIntBuffer) {
/* 1747 */     this.calls++;
/* 1748 */     this.gl30.glGenSamplers(paramInt, paramIntBuffer);
/* 1749 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteSamplers(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 1754 */     this.calls++;
/* 1755 */     this.gl30.glDeleteSamplers(paramInt1, paramArrayOfint, paramInt2);
/* 1756 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteSamplers(int paramInt, IntBuffer paramIntBuffer) {
/* 1761 */     this.calls++;
/* 1762 */     this.gl30.glDeleteSamplers(paramInt, paramIntBuffer);
/* 1763 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsSampler(int paramInt) {
/* 1768 */     this.calls++;
/* 1769 */     boolean bool = this.gl30.glIsSampler(paramInt);
/* 1770 */     check();
/* 1771 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindSampler(int paramInt1, int paramInt2) {
/* 1776 */     this.calls++;
/* 1777 */     this.gl30.glBindSampler(paramInt1, paramInt2);
/* 1778 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glSamplerParameteri(int paramInt1, int paramInt2, int paramInt3) {
/* 1783 */     this.calls++;
/* 1784 */     this.gl30.glSamplerParameteri(paramInt1, paramInt2, paramInt3);
/* 1785 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glSamplerParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1790 */     this.calls++;
/* 1791 */     this.gl30.glSamplerParameteriv(paramInt1, paramInt2, paramIntBuffer);
/* 1792 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glSamplerParameterf(int paramInt1, int paramInt2, float paramFloat) {
/* 1797 */     this.calls++;
/* 1798 */     this.gl30.glSamplerParameterf(paramInt1, paramInt2, paramFloat);
/* 1799 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glSamplerParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 1804 */     this.calls++;
/* 1805 */     this.gl30.glSamplerParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/* 1806 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetSamplerParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1811 */     this.calls++;
/* 1812 */     this.gl30.glGetSamplerParameteriv(paramInt1, paramInt2, paramIntBuffer);
/* 1813 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetSamplerParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 1818 */     this.calls++;
/* 1819 */     this.gl30.glGetSamplerParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/* 1820 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttribDivisor(int paramInt1, int paramInt2) {
/* 1825 */     this.calls++;
/* 1826 */     this.gl30.glVertexAttribDivisor(paramInt1, paramInt2);
/* 1827 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindTransformFeedback(int paramInt1, int paramInt2) {
/* 1832 */     this.calls++;
/* 1833 */     this.gl30.glBindTransformFeedback(paramInt1, paramInt2);
/* 1834 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteTransformFeedbacks(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 1839 */     this.calls++;
/* 1840 */     this.gl30.glDeleteTransformFeedbacks(paramInt1, paramArrayOfint, paramInt2);
/* 1841 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteTransformFeedbacks(int paramInt, IntBuffer paramIntBuffer) {
/* 1846 */     this.calls++;
/* 1847 */     this.gl30.glDeleteTransformFeedbacks(paramInt, paramIntBuffer);
/* 1848 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenTransformFeedbacks(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/* 1853 */     this.calls++;
/* 1854 */     this.gl30.glGenTransformFeedbacks(paramInt1, paramArrayOfint, paramInt2);
/* 1855 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenTransformFeedbacks(int paramInt, IntBuffer paramIntBuffer) {
/* 1860 */     this.calls++;
/* 1861 */     this.gl30.glGenTransformFeedbacks(paramInt, paramIntBuffer);
/* 1862 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsTransformFeedback(int paramInt) {
/* 1867 */     this.calls++;
/* 1868 */     boolean bool = this.gl30.glIsTransformFeedback(paramInt);
/* 1869 */     check();
/* 1870 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glPauseTransformFeedback() {
/* 1875 */     this.calls++;
/* 1876 */     this.gl30.glPauseTransformFeedback();
/* 1877 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glResumeTransformFeedback() {
/* 1882 */     this.calls++;
/* 1883 */     this.gl30.glResumeTransformFeedback();
/* 1884 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glProgramParameteri(int paramInt1, int paramInt2, int paramInt3) {
/* 1889 */     this.calls++;
/* 1890 */     this.gl30.glProgramParameteri(paramInt1, paramInt2, paramInt3);
/* 1891 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glInvalidateFramebuffer(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1896 */     this.calls++;
/* 1897 */     this.gl30.glInvalidateFramebuffer(paramInt1, paramInt2, paramIntBuffer);
/* 1898 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glInvalidateSubFramebuffer(int paramInt1, int paramInt2, IntBuffer paramIntBuffer, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 1904 */     this.calls++;
/* 1905 */     this.gl30.glInvalidateSubFramebuffer(paramInt1, paramInt2, paramIntBuffer, paramInt3, paramInt4, paramInt5, paramInt6);
/* 1906 */     check();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\profiling\GL30Interceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */