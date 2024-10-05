/*      */ package com.badlogic.gdx.graphics.profiling;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.GL20;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
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
/*      */ public class GL20Interceptor
/*      */   extends GLInterceptor
/*      */   implements GL20
/*      */ {
/*      */   protected final GL20 gl20;
/*      */   
/*      */   protected GL20Interceptor(GLProfiler paramGLProfiler, GL20 paramGL20) {
/*   32 */     super(paramGLProfiler);
/*   33 */     this.gl20 = paramGL20;
/*      */   }
/*      */   
/*      */   private void check() {
/*   37 */     int i = this.gl20.glGetError();
/*   38 */     while (i != 0) {
/*   39 */       this.glProfiler.getListener().onError(i);
/*   40 */       i = this.gl20.glGetError();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void glActiveTexture(int paramInt) {
/*   46 */     this.calls++;
/*   47 */     this.gl20.glActiveTexture(paramInt);
/*   48 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindTexture(int paramInt1, int paramInt2) {
/*   53 */     this.textureBindings++;
/*   54 */     this.calls++;
/*   55 */     this.gl20.glBindTexture(paramInt1, paramInt2);
/*   56 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendFunc(int paramInt1, int paramInt2) {
/*   61 */     this.calls++;
/*   62 */     this.gl20.glBlendFunc(paramInt1, paramInt2);
/*   63 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClear(int paramInt) {
/*   68 */     this.calls++;
/*   69 */     this.gl20.glClear(paramInt);
/*   70 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*   75 */     this.calls++;
/*   76 */     this.gl20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*   77 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearDepthf(float paramFloat) {
/*   82 */     this.calls++;
/*   83 */     this.gl20.glClearDepthf(paramFloat);
/*   84 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glClearStencil(int paramInt) {
/*   89 */     this.calls++;
/*   90 */     this.gl20.glClearStencil(paramInt);
/*   91 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glColorMask(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*   96 */     this.calls++;
/*   97 */     this.gl20.glColorMask(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*   98 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer) {
/*  104 */     this.calls++;
/*  105 */     this.gl20.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBuffer);
/*  106 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glCompressedTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/*  112 */     this.calls++;
/*  113 */     this.gl20.glCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
/*  114 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCopyTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/*  119 */     this.calls++;
/*  120 */     this.gl20.glCopyTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*  121 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCopyTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/*  126 */     this.calls++;
/*  127 */     this.gl20.glCopyTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*  128 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCullFace(int paramInt) {
/*  133 */     this.calls++;
/*  134 */     this.gl20.glCullFace(paramInt);
/*  135 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteTextures(int paramInt, IntBuffer paramIntBuffer) {
/*  140 */     this.calls++;
/*  141 */     this.gl20.glDeleteTextures(paramInt, paramIntBuffer);
/*  142 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteTexture(int paramInt) {
/*  147 */     this.calls++;
/*  148 */     this.gl20.glDeleteTexture(paramInt);
/*  149 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDepthFunc(int paramInt) {
/*  154 */     this.calls++;
/*  155 */     this.gl20.glDepthFunc(paramInt);
/*  156 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDepthMask(boolean paramBoolean) {
/*  161 */     this.calls++;
/*  162 */     this.gl20.glDepthMask(paramBoolean);
/*  163 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDepthRangef(float paramFloat1, float paramFloat2) {
/*  168 */     this.calls++;
/*  169 */     this.gl20.glDepthRangef(paramFloat1, paramFloat2);
/*  170 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDisable(int paramInt) {
/*  175 */     this.calls++;
/*  176 */     this.gl20.glDisable(paramInt);
/*  177 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawArrays(int paramInt1, int paramInt2, int paramInt3) {
/*  182 */     this.vertexCount.put(paramInt3);
/*  183 */     this.drawCalls++;
/*  184 */     this.calls++;
/*  185 */     this.gl20.glDrawArrays(paramInt1, paramInt2, paramInt3);
/*  186 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer) {
/*  191 */     this.vertexCount.put(paramInt2);
/*  192 */     this.drawCalls++;
/*  193 */     this.calls++;
/*  194 */     this.gl20.glDrawElements(paramInt1, paramInt2, paramInt3, paramBuffer);
/*  195 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glEnable(int paramInt) {
/*  200 */     this.calls++;
/*  201 */     this.gl20.glEnable(paramInt);
/*  202 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFinish() {
/*  207 */     this.calls++;
/*  208 */     this.gl20.glFinish();
/*  209 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFlush() {
/*  214 */     this.calls++;
/*  215 */     this.gl20.glFlush();
/*  216 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFrontFace(int paramInt) {
/*  221 */     this.calls++;
/*  222 */     this.gl20.glFrontFace(paramInt);
/*  223 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenTextures(int paramInt, IntBuffer paramIntBuffer) {
/*  228 */     this.calls++;
/*  229 */     this.gl20.glGenTextures(paramInt, paramIntBuffer);
/*  230 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGenTexture() {
/*  235 */     this.calls++;
/*  236 */     int i = this.gl20.glGenTexture();
/*  237 */     check();
/*  238 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGetError() {
/*  243 */     this.calls++;
/*      */     
/*  245 */     return this.gl20.glGetError();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetIntegerv(int paramInt, IntBuffer paramIntBuffer) {
/*  250 */     this.calls++;
/*  251 */     this.gl20.glGetIntegerv(paramInt, paramIntBuffer);
/*  252 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetString(int paramInt) {
/*  257 */     this.calls++;
/*  258 */     String str = this.gl20.glGetString(paramInt);
/*  259 */     check();
/*  260 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glHint(int paramInt1, int paramInt2) {
/*  265 */     this.calls++;
/*  266 */     this.gl20.glHint(paramInt1, paramInt2);
/*  267 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glLineWidth(float paramFloat) {
/*  272 */     this.calls++;
/*  273 */     this.gl20.glLineWidth(paramFloat);
/*  274 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glPixelStorei(int paramInt1, int paramInt2) {
/*  279 */     this.calls++;
/*  280 */     this.gl20.glPixelStorei(paramInt1, paramInt2);
/*  281 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glPolygonOffset(float paramFloat1, float paramFloat2) {
/*  286 */     this.calls++;
/*  287 */     this.gl20.glPolygonOffset(paramFloat1, paramFloat2);
/*  288 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glReadPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Buffer paramBuffer) {
/*  293 */     this.calls++;
/*  294 */     this.gl20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBuffer);
/*  295 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glScissor(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  300 */     this.calls++;
/*  301 */     this.gl20.glScissor(paramInt1, paramInt2, paramInt3, paramInt4);
/*  302 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilFunc(int paramInt1, int paramInt2, int paramInt3) {
/*  307 */     this.calls++;
/*  308 */     this.gl20.glStencilFunc(paramInt1, paramInt2, paramInt3);
/*  309 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilMask(int paramInt) {
/*  314 */     this.calls++;
/*  315 */     this.gl20.glStencilMask(paramInt);
/*  316 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilOp(int paramInt1, int paramInt2, int paramInt3) {
/*  321 */     this.calls++;
/*  322 */     this.gl20.glStencilOp(paramInt1, paramInt2, paramInt3);
/*  323 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/*  329 */     this.calls++;
/*  330 */     this.gl20.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
/*  331 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTexParameterf(int paramInt1, int paramInt2, float paramFloat) {
/*  336 */     this.calls++;
/*  337 */     this.gl20.glTexParameterf(paramInt1, paramInt2, paramFloat);
/*  338 */     check();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void glTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer) {
/*  344 */     this.calls++;
/*  345 */     this.gl20.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
/*  346 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  351 */     this.calls++;
/*  352 */     this.gl20.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
/*  353 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glAttachShader(int paramInt1, int paramInt2) {
/*  358 */     this.calls++;
/*  359 */     this.gl20.glAttachShader(paramInt1, paramInt2);
/*  360 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindAttribLocation(int paramInt1, int paramInt2, String paramString) {
/*  365 */     this.calls++;
/*  366 */     this.gl20.glBindAttribLocation(paramInt1, paramInt2, paramString);
/*  367 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindBuffer(int paramInt1, int paramInt2) {
/*  372 */     this.calls++;
/*  373 */     this.gl20.glBindBuffer(paramInt1, paramInt2);
/*  374 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindFramebuffer(int paramInt1, int paramInt2) {
/*  379 */     this.calls++;
/*  380 */     this.gl20.glBindFramebuffer(paramInt1, paramInt2);
/*  381 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBindRenderbuffer(int paramInt1, int paramInt2) {
/*  386 */     this.calls++;
/*  387 */     this.gl20.glBindRenderbuffer(paramInt1, paramInt2);
/*  388 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  393 */     this.calls++;
/*  394 */     this.gl20.glBlendColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  395 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendEquation(int paramInt) {
/*  400 */     this.calls++;
/*  401 */     this.gl20.glBlendEquation(paramInt);
/*  402 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendEquationSeparate(int paramInt1, int paramInt2) {
/*  407 */     this.calls++;
/*  408 */     this.gl20.glBlendEquationSeparate(paramInt1, paramInt2);
/*  409 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBlendFuncSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  414 */     this.calls++;
/*  415 */     this.gl20.glBlendFuncSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*  416 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBufferData(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3) {
/*  421 */     this.calls++;
/*  422 */     this.gl20.glBufferData(paramInt1, paramInt2, paramBuffer, paramInt3);
/*  423 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glBufferSubData(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer) {
/*  428 */     this.calls++;
/*  429 */     this.gl20.glBufferSubData(paramInt1, paramInt2, paramInt3, paramBuffer);
/*  430 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glCheckFramebufferStatus(int paramInt) {
/*  435 */     this.calls++;
/*  436 */     paramInt = this.gl20.glCheckFramebufferStatus(paramInt);
/*  437 */     check();
/*  438 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glCompileShader(int paramInt) {
/*  443 */     this.calls++;
/*  444 */     this.gl20.glCompileShader(paramInt);
/*  445 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glCreateProgram() {
/*  450 */     this.calls++;
/*  451 */     int i = this.gl20.glCreateProgram();
/*  452 */     check();
/*  453 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public int glCreateShader(int paramInt) {
/*  458 */     this.calls++;
/*  459 */     paramInt = this.gl20.glCreateShader(paramInt);
/*  460 */     check();
/*  461 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteBuffer(int paramInt) {
/*  466 */     this.calls++;
/*  467 */     this.gl20.glDeleteBuffer(paramInt);
/*  468 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteBuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  473 */     this.calls++;
/*  474 */     this.gl20.glDeleteBuffers(paramInt, paramIntBuffer);
/*  475 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteFramebuffer(int paramInt) {
/*  480 */     this.calls++;
/*  481 */     this.gl20.glDeleteFramebuffer(paramInt);
/*  482 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteFramebuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  487 */     this.calls++;
/*  488 */     this.gl20.glDeleteFramebuffers(paramInt, paramIntBuffer);
/*  489 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteProgram(int paramInt) {
/*  494 */     this.calls++;
/*  495 */     this.gl20.glDeleteProgram(paramInt);
/*  496 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteRenderbuffer(int paramInt) {
/*  501 */     this.calls++;
/*  502 */     this.gl20.glDeleteRenderbuffer(paramInt);
/*  503 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteRenderbuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  508 */     this.calls++;
/*  509 */     this.gl20.glDeleteRenderbuffers(paramInt, paramIntBuffer);
/*  510 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDeleteShader(int paramInt) {
/*  515 */     this.calls++;
/*  516 */     this.gl20.glDeleteShader(paramInt);
/*  517 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDetachShader(int paramInt1, int paramInt2) {
/*  522 */     this.calls++;
/*  523 */     this.gl20.glDetachShader(paramInt1, paramInt2);
/*  524 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDisableVertexAttribArray(int paramInt) {
/*  529 */     this.calls++;
/*  530 */     this.gl20.glDisableVertexAttribArray(paramInt);
/*  531 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  536 */     this.vertexCount.put(paramInt2);
/*  537 */     this.drawCalls++;
/*  538 */     this.calls++;
/*  539 */     this.gl20.glDrawElements(paramInt1, paramInt2, paramInt3, paramInt4);
/*  540 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glEnableVertexAttribArray(int paramInt) {
/*  545 */     this.calls++;
/*  546 */     this.gl20.glEnableVertexAttribArray(paramInt);
/*  547 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFramebufferRenderbuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  552 */     this.calls++;
/*  553 */     this.gl20.glFramebufferRenderbuffer(paramInt1, paramInt2, paramInt3, paramInt4);
/*  554 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glFramebufferTexture2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/*  559 */     this.calls++;
/*  560 */     this.gl20.glFramebufferTexture2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*  561 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGenBuffer() {
/*  566 */     this.calls++;
/*  567 */     int i = this.gl20.glGenBuffer();
/*  568 */     check();
/*  569 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenBuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  574 */     this.calls++;
/*  575 */     this.gl20.glGenBuffers(paramInt, paramIntBuffer);
/*  576 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenerateMipmap(int paramInt) {
/*  581 */     this.calls++;
/*  582 */     this.gl20.glGenerateMipmap(paramInt);
/*  583 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGenFramebuffer() {
/*  588 */     this.calls++;
/*  589 */     int i = this.gl20.glGenFramebuffer();
/*  590 */     check();
/*  591 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenFramebuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  596 */     this.calls++;
/*  597 */     this.gl20.glGenFramebuffers(paramInt, paramIntBuffer);
/*  598 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGenRenderbuffer() {
/*  603 */     this.calls++;
/*  604 */     int i = this.gl20.glGenRenderbuffer();
/*  605 */     check();
/*  606 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGenRenderbuffers(int paramInt, IntBuffer paramIntBuffer) {
/*  611 */     this.calls++;
/*  612 */     this.gl20.glGenRenderbuffers(paramInt, paramIntBuffer);
/*  613 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetActiveAttrib(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/*  618 */     this.calls++;
/*  619 */     String str = this.gl20.glGetActiveAttrib(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2);
/*  620 */     check();
/*  621 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetActiveUniform(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/*  626 */     this.calls++;
/*  627 */     String str = this.gl20.glGetActiveUniform(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2);
/*  628 */     check();
/*  629 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetAttachedShaders(int paramInt1, int paramInt2, Buffer paramBuffer, IntBuffer paramIntBuffer) {
/*  634 */     this.calls++;
/*  635 */     this.gl20.glGetAttachedShaders(paramInt1, paramInt2, paramBuffer, paramIntBuffer);
/*  636 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGetAttribLocation(int paramInt, String paramString) {
/*  641 */     this.calls++;
/*  642 */     paramInt = this.gl20.glGetAttribLocation(paramInt, paramString);
/*  643 */     check();
/*  644 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetBooleanv(int paramInt, Buffer paramBuffer) {
/*  649 */     this.calls++;
/*  650 */     this.gl20.glGetBooleanv(paramInt, paramBuffer);
/*  651 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetBufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  656 */     this.calls++;
/*  657 */     this.gl20.glGetBufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  658 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetFloatv(int paramInt, FloatBuffer paramFloatBuffer) {
/*  663 */     this.calls++;
/*  664 */     this.gl20.glGetFloatv(paramInt, paramFloatBuffer);
/*  665 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer) {
/*  670 */     this.calls++;
/*  671 */     this.gl20.glGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*  672 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetProgramiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  677 */     this.calls++;
/*  678 */     this.gl20.glGetProgramiv(paramInt1, paramInt2, paramIntBuffer);
/*  679 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetProgramInfoLog(int paramInt) {
/*  684 */     this.calls++;
/*  685 */     String str = this.gl20.glGetProgramInfoLog(paramInt);
/*  686 */     check();
/*  687 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetRenderbufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  692 */     this.calls++;
/*  693 */     this.gl20.glGetRenderbufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  694 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetShaderiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  699 */     this.calls++;
/*  700 */     this.gl20.glGetShaderiv(paramInt1, paramInt2, paramIntBuffer);
/*  701 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public String glGetShaderInfoLog(int paramInt) {
/*  706 */     this.calls++;
/*  707 */     String str = this.gl20.glGetShaderInfoLog(paramInt);
/*  708 */     check();
/*  709 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetShaderPrecisionFormat(int paramInt1, int paramInt2, IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) {
/*  714 */     this.calls++;
/*  715 */     this.gl20.glGetShaderPrecisionFormat(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2);
/*  716 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  721 */     this.calls++;
/*  722 */     this.gl20.glGetTexParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*  723 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  728 */     this.calls++;
/*  729 */     this.gl20.glGetTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  730 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetUniformfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  735 */     this.calls++;
/*  736 */     this.gl20.glGetUniformfv(paramInt1, paramInt2, paramFloatBuffer);
/*  737 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetUniformiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  742 */     this.calls++;
/*  743 */     this.gl20.glGetUniformiv(paramInt1, paramInt2, paramIntBuffer);
/*  744 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public int glGetUniformLocation(int paramInt, String paramString) {
/*  749 */     this.calls++;
/*  750 */     paramInt = this.gl20.glGetUniformLocation(paramInt, paramString);
/*  751 */     check();
/*  752 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetVertexAttribfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  757 */     this.calls++;
/*  758 */     this.gl20.glGetVertexAttribfv(paramInt1, paramInt2, paramFloatBuffer);
/*  759 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetVertexAttribiv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  764 */     this.calls++;
/*  765 */     this.gl20.glGetVertexAttribiv(paramInt1, paramInt2, paramIntBuffer);
/*  766 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glGetVertexAttribPointerv(int paramInt1, int paramInt2, Buffer paramBuffer) {
/*  771 */     this.calls++;
/*  772 */     this.gl20.glGetVertexAttribPointerv(paramInt1, paramInt2, paramBuffer);
/*  773 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsBuffer(int paramInt) {
/*  778 */     this.calls++;
/*  779 */     boolean bool = this.gl20.glIsBuffer(paramInt);
/*  780 */     check();
/*  781 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsEnabled(int paramInt) {
/*  786 */     this.calls++;
/*  787 */     boolean bool = this.gl20.glIsEnabled(paramInt);
/*  788 */     check();
/*  789 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsFramebuffer(int paramInt) {
/*  794 */     this.calls++;
/*  795 */     boolean bool = this.gl20.glIsFramebuffer(paramInt);
/*  796 */     check();
/*  797 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsProgram(int paramInt) {
/*  802 */     this.calls++;
/*  803 */     boolean bool = this.gl20.glIsProgram(paramInt);
/*  804 */     check();
/*  805 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsRenderbuffer(int paramInt) {
/*  810 */     this.calls++;
/*  811 */     boolean bool = this.gl20.glIsRenderbuffer(paramInt);
/*  812 */     check();
/*  813 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsShader(int paramInt) {
/*  818 */     this.calls++;
/*  819 */     boolean bool = this.gl20.glIsShader(paramInt);
/*  820 */     check();
/*  821 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean glIsTexture(int paramInt) {
/*  826 */     this.calls++;
/*  827 */     boolean bool = this.gl20.glIsTexture(paramInt);
/*  828 */     check();
/*  829 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   public void glLinkProgram(int paramInt) {
/*  834 */     this.calls++;
/*  835 */     this.gl20.glLinkProgram(paramInt);
/*  836 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glReleaseShaderCompiler() {
/*  841 */     this.calls++;
/*  842 */     this.gl20.glReleaseShaderCompiler();
/*  843 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glRenderbufferStorage(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  848 */     this.calls++;
/*  849 */     this.gl20.glRenderbufferStorage(paramInt1, paramInt2, paramInt3, paramInt4);
/*  850 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glSampleCoverage(float paramFloat, boolean paramBoolean) {
/*  855 */     this.calls++;
/*  856 */     this.gl20.glSampleCoverage(paramFloat, paramBoolean);
/*  857 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glShaderBinary(int paramInt1, IntBuffer paramIntBuffer, int paramInt2, Buffer paramBuffer, int paramInt3) {
/*  862 */     this.calls++;
/*  863 */     this.gl20.glShaderBinary(paramInt1, paramIntBuffer, paramInt2, paramBuffer, paramInt3);
/*  864 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glShaderSource(int paramInt, String paramString) {
/*  869 */     this.calls++;
/*  870 */     this.gl20.glShaderSource(paramInt, paramString);
/*  871 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilFuncSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  876 */     this.calls++;
/*  877 */     this.gl20.glStencilFuncSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*  878 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilMaskSeparate(int paramInt1, int paramInt2) {
/*  883 */     this.calls++;
/*  884 */     this.gl20.glStencilMaskSeparate(paramInt1, paramInt2);
/*  885 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glStencilOpSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  890 */     this.calls++;
/*  891 */     this.gl20.glStencilOpSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*  892 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  897 */     this.calls++;
/*  898 */     this.gl20.glTexParameterfv(paramInt1, paramInt2, paramFloatBuffer);
/*  899 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTexParameteri(int paramInt1, int paramInt2, int paramInt3) {
/*  904 */     this.calls++;
/*  905 */     this.gl20.glTexParameteri(paramInt1, paramInt2, paramInt3);
/*  906 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  911 */     this.calls++;
/*  912 */     this.gl20.glTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*  913 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1f(int paramInt, float paramFloat) {
/*  918 */     this.calls++;
/*  919 */     this.gl20.glUniform1f(paramInt, paramFloat);
/*  920 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  925 */     this.calls++;
/*  926 */     this.gl20.glUniform1fv(paramInt1, paramInt2, paramFloatBuffer);
/*  927 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/*  932 */     this.calls++;
/*  933 */     this.gl20.glUniform1fv(paramInt1, paramInt2, paramArrayOffloat, paramInt3);
/*  934 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1i(int paramInt1, int paramInt2) {
/*  939 */     this.calls++;
/*  940 */     this.gl20.glUniform1i(paramInt1, paramInt2);
/*  941 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  946 */     this.calls++;
/*  947 */     this.gl20.glUniform1iv(paramInt1, paramInt2, paramIntBuffer);
/*  948 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform1iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/*  953 */     this.calls++;
/*  954 */     this.gl20.glUniform1iv(paramInt1, paramInt2, paramArrayOfint, paramInt3);
/*  955 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2f(int paramInt, float paramFloat1, float paramFloat2) {
/*  960 */     this.calls++;
/*  961 */     this.gl20.glUniform2f(paramInt, paramFloat1, paramFloat2);
/*  962 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/*  967 */     this.calls++;
/*  968 */     this.gl20.glUniform2fv(paramInt1, paramInt2, paramFloatBuffer);
/*  969 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/*  974 */     this.calls++;
/*  975 */     this.gl20.glUniform2fv(paramInt1, paramInt2, paramArrayOffloat, paramInt3);
/*  976 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2i(int paramInt1, int paramInt2, int paramInt3) {
/*  981 */     this.calls++;
/*  982 */     this.gl20.glUniform2i(paramInt1, paramInt2, paramInt3);
/*  983 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/*  988 */     this.calls++;
/*  989 */     this.gl20.glUniform2iv(paramInt1, paramInt2, paramIntBuffer);
/*  990 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform2iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/*  995 */     this.calls++;
/*  996 */     this.gl20.glUniform2iv(paramInt1, paramInt2, paramArrayOfint, paramInt3);
/*  997 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1002 */     this.calls++;
/* 1003 */     this.gl20.glUniform3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
/* 1004 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 1009 */     this.calls++;
/* 1010 */     this.gl20.glUniform3fv(paramInt1, paramInt2, paramFloatBuffer);
/* 1011 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/* 1016 */     this.calls++;
/* 1017 */     this.gl20.glUniform3fv(paramInt1, paramInt2, paramArrayOffloat, paramInt3);
/* 1018 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3i(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1023 */     this.calls++;
/* 1024 */     this.gl20.glUniform3i(paramInt1, paramInt2, paramInt3, paramInt4);
/* 1025 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1030 */     this.calls++;
/* 1031 */     this.gl20.glUniform3iv(paramInt1, paramInt2, paramIntBuffer);
/* 1032 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform3iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 1037 */     this.calls++;
/* 1038 */     this.gl20.glUniform3iv(paramInt1, paramInt2, paramArrayOfint, paramInt3);
/* 1039 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1044 */     this.calls++;
/* 1045 */     this.gl20.glUniform4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1046 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4fv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer) {
/* 1051 */     this.calls++;
/* 1052 */     this.gl20.glUniform4fv(paramInt1, paramInt2, paramFloatBuffer);
/* 1053 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4fv(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3) {
/* 1058 */     this.calls++;
/* 1059 */     this.gl20.glUniform4fv(paramInt1, paramInt2, paramArrayOffloat, paramInt3);
/* 1060 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1065 */     this.calls++;
/* 1066 */     this.gl20.glUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/* 1067 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4iv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer) {
/* 1072 */     this.calls++;
/* 1073 */     this.gl20.glUniform4iv(paramInt1, paramInt2, paramIntBuffer);
/* 1074 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniform4iv(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/* 1079 */     this.calls++;
/* 1080 */     this.gl20.glUniform4iv(paramInt1, paramInt2, paramArrayOfint, paramInt3);
/* 1081 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1086 */     this.calls++;
/* 1087 */     this.gl20.glUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1088 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 1093 */     this.calls++;
/* 1094 */     this.gl20.glUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat, paramInt3);
/* 1095 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1100 */     this.calls++;
/* 1101 */     this.gl20.glUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1102 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 1107 */     this.calls++;
/* 1108 */     this.gl20.glUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat, paramInt3);
/* 1109 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, FloatBuffer paramFloatBuffer) {
/* 1114 */     this.calls++;
/* 1115 */     this.gl20.glUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/* 1116 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, int paramInt3) {
/* 1121 */     this.calls++;
/* 1122 */     this.gl20.glUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat, paramInt3);
/* 1123 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glUseProgram(int paramInt) {
/* 1128 */     this.shaderSwitches++;
/* 1129 */     this.calls++;
/* 1130 */     this.gl20.glUseProgram(paramInt);
/* 1131 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glValidateProgram(int paramInt) {
/* 1136 */     this.calls++;
/* 1137 */     this.gl20.glValidateProgram(paramInt);
/* 1138 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib1f(int paramInt, float paramFloat) {
/* 1143 */     this.calls++;
/* 1144 */     this.gl20.glVertexAttrib1f(paramInt, paramFloat);
/* 1145 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib1fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 1150 */     this.calls++;
/* 1151 */     this.gl20.glVertexAttrib1fv(paramInt, paramFloatBuffer);
/* 1152 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib2f(int paramInt, float paramFloat1, float paramFloat2) {
/* 1157 */     this.calls++;
/* 1158 */     this.gl20.glVertexAttrib2f(paramInt, paramFloat1, paramFloat2);
/* 1159 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib2fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 1164 */     this.calls++;
/* 1165 */     this.gl20.glVertexAttrib2fv(paramInt, paramFloatBuffer);
/* 1166 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib3f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1171 */     this.calls++;
/* 1172 */     this.gl20.glVertexAttrib3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
/* 1173 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib3fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 1178 */     this.calls++;
/* 1179 */     this.gl20.glVertexAttrib3fv(paramInt, paramFloatBuffer);
/* 1180 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib4f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1185 */     this.calls++;
/* 1186 */     this.gl20.glVertexAttrib4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1187 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttrib4fv(int paramInt, FloatBuffer paramFloatBuffer) {
/* 1192 */     this.calls++;
/* 1193 */     this.gl20.glVertexAttrib4fv(paramInt, paramFloatBuffer);
/* 1194 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, Buffer paramBuffer) {
/* 1199 */     this.calls++;
/* 1200 */     this.gl20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramBuffer);
/* 1201 */     check();
/*      */   }
/*      */ 
/*      */   
/*      */   public void glVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5) {
/* 1206 */     this.calls++;
/* 1207 */     this.gl20.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5);
/* 1208 */     check();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\profiling\GL20Interceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */