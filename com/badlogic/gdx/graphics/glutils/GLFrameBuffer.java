/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.graphics.GLTexture;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GLFrameBuffer<T extends GLTexture>
/*     */   implements Disposable
/*     */ {
/*  59 */   protected static final Map<Application, Array<GLFrameBuffer>> buffers = new HashMap<>();
/*     */ 
/*     */   
/*     */   protected static final int GL_DEPTH24_STENCIL8_OES = 35056;
/*     */   
/*  64 */   protected Array<T> textureAttachments = new Array();
/*     */ 
/*     */   
/*     */   protected static int defaultFramebufferHandle;
/*     */ 
/*     */   
/*     */   protected static boolean defaultFramebufferHandleInitialized = false;
/*     */   
/*     */   protected int framebufferHandle;
/*     */   
/*     */   protected int depthbufferHandle;
/*     */   
/*     */   protected int stencilbufferHandle;
/*     */   
/*     */   protected int depthStencilPackedBufferHandle;
/*     */   
/*     */   protected boolean hasDepthStencilPackedBuffer;
/*     */   
/*  82 */   protected final IntArray colorBufferHandles = new IntArray();
/*     */ 
/*     */   
/*     */   protected boolean isMRT;
/*     */   
/*     */   protected GLFrameBufferBuilder<? extends GLFrameBuffer<T>> bufferBuilder;
/*     */   
/*     */   private IntBuffer defaultDrawBuffers;
/*     */ 
/*     */   
/*     */   GLFrameBuffer() {}
/*     */ 
/*     */   
/*     */   protected GLFrameBuffer(GLFrameBufferBuilder<? extends GLFrameBuffer<T>> paramGLFrameBufferBuilder) {
/*  96 */     this.bufferBuilder = paramGLFrameBufferBuilder;
/*  97 */     build();
/*     */   }
/*     */ 
/*     */   
/*     */   public T getColorBufferTexture() {
/* 102 */     return (T)this.textureAttachments.first();
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<T> getTextureAttachments() {
/* 107 */     return this.textureAttachments;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract T createTexture(FrameBufferTextureAttachmentSpec paramFrameBufferTextureAttachmentSpec);
/*     */ 
/*     */   
/*     */   protected abstract void disposeColorTexture(T paramT);
/*     */ 
/*     */   
/*     */   protected abstract void attachFrameBufferColorTexture(T paramT);
/*     */   
/*     */   protected void build() {
/* 120 */     GL20 gL20 = Gdx.gl20;
/*     */     
/* 122 */     checkValidBuilder();
/*     */ 
/*     */     
/* 125 */     if (!defaultFramebufferHandleInitialized) {
/* 126 */       defaultFramebufferHandleInitialized = true;
/* 127 */       if (Gdx.app.getType() == Application.ApplicationType.iOS) {
/* 128 */         IntBuffer intBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
/* 129 */         gL20.glGetIntegerv(36006, intBuffer);
/* 130 */         defaultFramebufferHandle = intBuffer.get(0);
/*     */       } else {
/* 132 */         defaultFramebufferHandle = 0;
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     this.framebufferHandle = gL20.glGenFramebuffer();
/* 137 */     gL20.glBindFramebuffer(36160, this.framebufferHandle);
/*     */     
/* 139 */     int i = this.bufferBuilder.width;
/* 140 */     int j = this.bufferBuilder.height;
/*     */     
/* 142 */     if (this.bufferBuilder.hasDepthRenderBuffer) {
/* 143 */       this.depthbufferHandle = gL20.glGenRenderbuffer();
/* 144 */       gL20.glBindRenderbuffer(36161, this.depthbufferHandle);
/* 145 */       if (this.bufferBuilder.samples > 0) {
/* 146 */         Gdx.gl31.glRenderbufferStorageMultisample(36161, this.bufferBuilder.samples, this.bufferBuilder.depthRenderBufferSpec.internalFormat, i, j);
/*     */       } else {
/*     */         
/* 149 */         gL20.glRenderbufferStorage(36161, this.bufferBuilder.depthRenderBufferSpec.internalFormat, i, j);
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     if (this.bufferBuilder.hasStencilRenderBuffer) {
/* 154 */       this.stencilbufferHandle = gL20.glGenRenderbuffer();
/* 155 */       gL20.glBindRenderbuffer(36161, this.stencilbufferHandle);
/* 156 */       if (this.bufferBuilder.samples > 0) {
/* 157 */         Gdx.gl31.glRenderbufferStorageMultisample(36161, this.bufferBuilder.samples, this.bufferBuilder.stencilRenderBufferSpec.internalFormat, i, j);
/*     */       } else {
/*     */         
/* 160 */         gL20.glRenderbufferStorage(36161, this.bufferBuilder.stencilRenderBufferSpec.internalFormat, i, j);
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
/* 165 */       this.depthStencilPackedBufferHandle = gL20.glGenRenderbuffer();
/* 166 */       gL20.glBindRenderbuffer(36161, this.depthStencilPackedBufferHandle);
/* 167 */       if (this.bufferBuilder.samples > 0) {
/* 168 */         Gdx.gl31.glRenderbufferStorageMultisample(36161, this.bufferBuilder.samples, this.bufferBuilder.packedStencilDepthRenderBufferSpec.internalFormat, i, j);
/*     */       } else {
/*     */         
/* 171 */         gL20.glRenderbufferStorage(36161, this.bufferBuilder.packedStencilDepthRenderBufferSpec.internalFormat, i, j);
/*     */       } 
/*     */       
/* 174 */       this.hasDepthStencilPackedBuffer = true;
/*     */     } 
/*     */     
/* 177 */     this.isMRT = (this.bufferBuilder.textureAttachmentSpecs.size > 1);
/* 178 */     byte b = 0;
/* 179 */     if (this.isMRT) {
/* 180 */       for (Array.ArrayIterator<FrameBufferTextureAttachmentSpec> arrayIterator1 = this.bufferBuilder.textureAttachmentSpecs.iterator(); arrayIterator1.hasNext(); ) { FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = arrayIterator1.next();
/* 181 */         T t = createTexture(frameBufferTextureAttachmentSpec);
/* 182 */         this.textureAttachments.add(t);
/* 183 */         if (frameBufferTextureAttachmentSpec.isColorTexture()) {
/* 184 */           gL20.glFramebufferTexture2D(36160, b + 36064, 3553, t
/* 185 */               .getTextureObjectHandle(), 0);
/* 186 */           b++; continue;
/* 187 */         }  if (frameBufferTextureAttachmentSpec.isDepth) {
/* 188 */           gL20.glFramebufferTexture2D(36160, 36096, 3553, t
/* 189 */               .getTextureObjectHandle(), 0); continue;
/* 190 */         }  if (frameBufferTextureAttachmentSpec.isStencil) {
/* 191 */           gL20.glFramebufferTexture2D(36160, 36128, 3553, t
/* 192 */               .getTextureObjectHandle(), 0);
/*     */         } }
/*     */     
/* 195 */     } else if (this.bufferBuilder.textureAttachmentSpecs.size > 0) {
/* 196 */       T t = createTexture((FrameBufferTextureAttachmentSpec)this.bufferBuilder.textureAttachmentSpecs.first());
/* 197 */       this.textureAttachments.add(t);
/* 198 */       gL20.glBindTexture(((GLTexture)t).glTarget, t.getTextureObjectHandle());
/*     */     } 
/*     */     Array.ArrayIterator<FrameBufferRenderBufferAttachmentSpec> arrayIterator;
/* 201 */     for (arrayIterator = this.bufferBuilder.colorRenderBufferSpecs.iterator(); arrayIterator.hasNext(); ) { FrameBufferRenderBufferAttachmentSpec frameBufferRenderBufferAttachmentSpec = arrayIterator.next();
/* 202 */       int m = gL20.glGenRenderbuffer();
/* 203 */       gL20.glBindRenderbuffer(36161, m);
/* 204 */       if (this.bufferBuilder.samples > 0) {
/* 205 */         Gdx.gl31.glRenderbufferStorageMultisample(36161, this.bufferBuilder.samples, frameBufferRenderBufferAttachmentSpec.internalFormat, i, j);
/*     */       } else {
/*     */         
/* 208 */         gL20.glRenderbufferStorage(36161, frameBufferRenderBufferAttachmentSpec.internalFormat, i, j);
/*     */       } 
/* 210 */       Gdx.gl.glFramebufferRenderbuffer(36160, b + 36064, 36161, m);
/*     */       
/* 212 */       this.colorBufferHandles.add(m);
/* 213 */       b++; }
/*     */ 
/*     */     
/* 216 */     if (this.isMRT || this.bufferBuilder.samples > 0) {
/* 217 */       this.defaultDrawBuffers = BufferUtils.newIntBuffer(b);
/* 218 */       for (byte b1 = 0; b1 < b; b1++) {
/* 219 */         this.defaultDrawBuffers.put(b1 + 36064);
/*     */       }
/* 221 */       this.defaultDrawBuffers.position(0);
/* 222 */       Gdx.gl30.glDrawBuffers(b, this.defaultDrawBuffers);
/* 223 */     } else if (this.bufferBuilder.textureAttachmentSpecs.size > 0) {
/* 224 */       attachFrameBufferColorTexture((T)this.textureAttachments.first());
/*     */     } 
/*     */     
/* 227 */     if (this.bufferBuilder.hasDepthRenderBuffer) {
/* 228 */       gL20.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthbufferHandle);
/*     */     }
/*     */     
/* 231 */     if (this.bufferBuilder.hasStencilRenderBuffer) {
/* 232 */       gL20.glFramebufferRenderbuffer(36160, 36128, 36161, this.stencilbufferHandle);
/*     */     }
/*     */     
/* 235 */     if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
/* 236 */       gL20.glFramebufferRenderbuffer(36160, 33306, 36161, this.depthStencilPackedBufferHandle);
/*     */     }
/*     */ 
/*     */     
/* 240 */     gL20.glBindRenderbuffer(36161, 0);
/* 241 */     for (arrayIterator = this.textureAttachments.iterator(); arrayIterator.hasNext(); ) { GLTexture gLTexture = (GLTexture)arrayIterator.next();
/* 242 */       gL20.glBindTexture(gLTexture.glTarget, 0); }
/*     */ 
/*     */     
/*     */     int k;
/*     */     
/* 247 */     if ((k = gL20.glCheckFramebufferStatus(36160)) == 36061 && this.bufferBuilder.hasDepthRenderBuffer && this.bufferBuilder.hasStencilRenderBuffer && (Gdx.graphics
/* 248 */       .supportsExtension("GL_OES_packed_depth_stencil") || Gdx.graphics
/* 249 */       .supportsExtension("GL_EXT_packed_depth_stencil"))) {
/* 250 */       if (this.bufferBuilder.hasDepthRenderBuffer) {
/* 251 */         gL20.glDeleteRenderbuffer(this.depthbufferHandle);
/* 252 */         this.depthbufferHandle = 0;
/*     */       } 
/* 254 */       if (this.bufferBuilder.hasStencilRenderBuffer) {
/* 255 */         gL20.glDeleteRenderbuffer(this.stencilbufferHandle);
/* 256 */         this.stencilbufferHandle = 0;
/*     */       } 
/* 258 */       if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
/* 259 */         gL20.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
/* 260 */         this.depthStencilPackedBufferHandle = 0;
/*     */       } 
/*     */       
/* 263 */       this.depthStencilPackedBufferHandle = gL20.glGenRenderbuffer();
/* 264 */       this.hasDepthStencilPackedBuffer = true;
/* 265 */       gL20.glBindRenderbuffer(36161, this.depthStencilPackedBufferHandle);
/* 266 */       if (this.bufferBuilder.samples > 0) {
/* 267 */         Gdx.gl31.glRenderbufferStorageMultisample(36161, this.bufferBuilder.samples, 35056, i, j);
/*     */       } else {
/*     */         
/* 270 */         gL20.glRenderbufferStorage(36161, 35056, i, j);
/*     */       } 
/* 272 */       gL20.glBindRenderbuffer(36161, 0);
/*     */       
/* 274 */       gL20.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthStencilPackedBufferHandle);
/*     */       
/* 276 */       gL20.glFramebufferRenderbuffer(36160, 36128, 36161, this.depthStencilPackedBufferHandle);
/*     */       
/* 278 */       k = gL20.glCheckFramebufferStatus(36160);
/*     */     } 
/*     */     
/* 281 */     gL20.glBindFramebuffer(36160, defaultFramebufferHandle);
/*     */     
/* 283 */     if (k != 36053) {
/* 284 */       for (Array.ArrayIterator<GLTexture> arrayIterator1 = this.textureAttachments.iterator(); arrayIterator1.hasNext(); ) { GLTexture gLTexture = arrayIterator1.next();
/* 285 */         disposeColorTexture((T)gLTexture); }
/*     */ 
/*     */       
/* 288 */       if (this.hasDepthStencilPackedBuffer) {
/* 289 */         gL20.glDeleteBuffer(this.depthStencilPackedBufferHandle);
/*     */       } else {
/* 291 */         if (this.bufferBuilder.hasDepthRenderBuffer) gL20.glDeleteRenderbuffer(this.depthbufferHandle); 
/* 292 */         if (this.bufferBuilder.hasStencilRenderBuffer) gL20.glDeleteRenderbuffer(this.stencilbufferHandle);
/*     */       
/*     */       } 
/* 295 */       gL20.glDeleteFramebuffer(this.framebufferHandle);
/*     */       
/* 297 */       if (k == 36054)
/* 298 */         throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment"); 
/* 299 */       if (k == 36057)
/* 300 */         throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions"); 
/* 301 */       if (k == 36055)
/* 302 */         throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment"); 
/* 303 */       if (k == 36061)
/* 304 */         throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats"); 
/* 305 */       if (k == 36182)
/* 306 */         throw new IllegalStateException("Frame buffer couldn't be constructed: multisample mismatch"); 
/* 307 */       throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + k);
/*     */     } 
/*     */     
/* 310 */     addManagedFrameBuffer(Gdx.app, this);
/*     */   }
/*     */ 
/*     */   
/*     */   private void checkValidBuilder() {
/* 315 */     if (this.bufferBuilder.samples > 0 && !Gdx.graphics.isGL31Available()) {
/* 316 */       throw new GdxRuntimeException("Framebuffer multisample requires GLES 3.1+");
/*     */     }
/* 318 */     if (this.bufferBuilder.samples > 0 && this.bufferBuilder.textureAttachmentSpecs.size > 0) {
/* 319 */       throw new GdxRuntimeException("Framebuffer multisample with texture attachments not yet supported");
/*     */     }
/*     */     
/*     */     boolean bool;
/*     */     
/* 324 */     if (!(bool = Gdx.graphics.isGL30Available())) {
/*     */       
/* 326 */       bool = (Gdx.graphics.supportsExtension("GL_OES_packed_depth_stencil") || Gdx.graphics.supportsExtension("GL_EXT_packed_depth_stencil"));
/*     */       
/* 328 */       if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer && !bool) {
/* 329 */         throw new GdxRuntimeException("Packed Stencil/Render render buffers are not available on GLES 2.0");
/*     */       }
/* 331 */       if (this.bufferBuilder.textureAttachmentSpecs.size > 1) {
/* 332 */         throw new GdxRuntimeException("Multiple render targets not available on GLES 2.0");
/*     */       }
/* 334 */       for (Array.ArrayIterator<FrameBufferTextureAttachmentSpec> arrayIterator = this.bufferBuilder.textureAttachmentSpecs.iterator(); arrayIterator.hasNext(); ) {
/* 335 */         FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec; if ((frameBufferTextureAttachmentSpec = arrayIterator.next()).isDepth) throw new GdxRuntimeException("Depth texture FrameBuffer Attachment not available on GLES 2.0"); 
/* 336 */         if (frameBufferTextureAttachmentSpec.isStencil) throw new GdxRuntimeException("Stencil texture FrameBuffer Attachment not available on GLES 2.0"); 
/* 337 */         if (frameBufferTextureAttachmentSpec.isFloat && 
/* 338 */           !Gdx.graphics.supportsExtension("OES_texture_float")) {
/* 339 */           throw new GdxRuntimeException("Float texture FrameBuffer Attachment not available on GLES 2.0");
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 345 */     if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer && (
/* 346 */       this.bufferBuilder.hasDepthRenderBuffer || this.bufferBuilder.hasStencilRenderBuffer)) throw new GdxRuntimeException("Frame buffer couldn't be constructed: packed stencil depth buffer cannot be specified together with separated depth or stencil buffer");
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 354 */     GL20 gL20 = Gdx.gl20;
/*     */     
/* 356 */     for (Array.ArrayIterator<GLTexture> arrayIterator = this.textureAttachments.iterator(); arrayIterator.hasNext(); ) { GLTexture gLTexture = arrayIterator.next();
/* 357 */       disposeColorTexture((T)gLTexture); }
/*     */ 
/*     */     
/* 360 */     gL20.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
/* 361 */     gL20.glDeleteRenderbuffer(this.depthbufferHandle);
/* 362 */     gL20.glDeleteRenderbuffer(this.stencilbufferHandle);
/*     */     
/* 364 */     gL20.glDeleteFramebuffer(this.framebufferHandle);
/*     */     
/* 366 */     if (buffers.get(Gdx.app) != null) ((Array)buffers.get(Gdx.app)).removeValue(this, true);
/*     */   
/*     */   }
/*     */   
/*     */   public void bind() {
/* 371 */     Gdx.gl20.glBindFramebuffer(36160, this.framebufferHandle);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void unbind() {
/* 376 */     Gdx.gl20.glBindFramebuffer(36160, defaultFramebufferHandle);
/*     */   }
/*     */ 
/*     */   
/*     */   public void begin() {
/* 381 */     bind();
/* 382 */     setFrameBufferViewport();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setFrameBufferViewport() {
/* 387 */     Gdx.gl20.glViewport(0, 0, this.bufferBuilder.width, this.bufferBuilder.height);
/*     */   }
/*     */ 
/*     */   
/*     */   public void end() {
/* 392 */     end(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 402 */     unbind();
/* 403 */     Gdx.gl20.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/* 406 */   static final IntBuffer singleInt = BufferUtils.newIntBuffer(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void transfer(GLFrameBuffer<T> paramGLFrameBuffer) {
/* 414 */     int i = 0;
/* 415 */     for (Array.ArrayIterator<FrameBufferTextureAttachmentSpec> arrayIterator = paramGLFrameBuffer.bufferBuilder.textureAttachmentSpecs.iterator(); arrayIterator.hasNext(); ) {
/* 416 */       FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec; if ((frameBufferTextureAttachmentSpec = arrayIterator.next()).isDepth && (this.bufferBuilder.hasDepthRenderBuffer || this.bufferBuilder.hasPackedStencilDepthRenderBuffer)) {
/* 417 */         i |= 0x100; continue;
/* 418 */       }  if (frameBufferTextureAttachmentSpec.isStencil && (this.bufferBuilder.hasStencilRenderBuffer || this.bufferBuilder.hasPackedStencilDepthRenderBuffer)) {
/*     */         
/* 420 */         i |= 0x400; continue;
/* 421 */       }  if (this.colorBufferHandles.size > 0) {
/* 422 */         i |= 0x4000;
/*     */       }
/*     */     } 
/*     */     
/* 426 */     transfer(paramGLFrameBuffer, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void transfer(GLFrameBuffer<T> paramGLFrameBuffer, int paramInt) {
/* 437 */     if (paramGLFrameBuffer.getWidth() != getWidth() || paramGLFrameBuffer.getHeight() != getHeight()) {
/* 438 */       throw new IllegalArgumentException("source and destination frame buffers must have same size.");
/*     */     }
/*     */     
/* 441 */     Gdx.gl.glBindFramebuffer(36008, this.framebufferHandle);
/* 442 */     Gdx.gl.glBindFramebuffer(36009, paramGLFrameBuffer.framebufferHandle);
/*     */     
/* 444 */     byte b1 = 0;
/* 445 */     byte b2 = 0;
/* 446 */     for (Array.ArrayIterator<FrameBufferTextureAttachmentSpec> arrayIterator = paramGLFrameBuffer.bufferBuilder.textureAttachmentSpecs.iterator(); arrayIterator.hasNext(); ) {
/* 447 */       FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec; if ((frameBufferTextureAttachmentSpec = arrayIterator.next()).isColorTexture()) {
/* 448 */         Gdx.gl30.glReadBuffer(b1 + 36064);
/*     */         
/* 450 */         singleInt.clear();
/* 451 */         singleInt.put(b2 + 36064);
/* 452 */         singleInt.flip();
/* 453 */         Gdx.gl30.glDrawBuffers(1, singleInt);
/*     */         
/* 455 */         Gdx.gl30.glBlitFramebuffer(0, 0, getWidth(), getHeight(), 0, 0, paramGLFrameBuffer.getWidth(), paramGLFrameBuffer.getHeight(), paramInt, 9728);
/*     */ 
/*     */         
/* 458 */         paramInt = 16384;
/* 459 */         b1++;
/*     */       } 
/* 461 */       b2++;
/*     */     } 
/*     */     
/* 464 */     if (paramInt != 16384) {
/* 465 */       Gdx.gl30.glBlitFramebuffer(0, 0, getWidth(), getHeight(), 0, 0, paramGLFrameBuffer.getWidth(), paramGLFrameBuffer.getHeight(), paramInt, 9728);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 470 */     if (paramGLFrameBuffer.defaultDrawBuffers != null) {
/* 471 */       Gdx.gl30.glDrawBuffers(paramGLFrameBuffer.defaultDrawBuffers.limit(), paramGLFrameBuffer.defaultDrawBuffers);
/*     */     }
/*     */     
/* 474 */     Gdx.gl.glBindFramebuffer(36008, 0);
/* 475 */     Gdx.gl.glBindFramebuffer(36009, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFramebufferHandle() {
/* 480 */     return this.framebufferHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDepthBufferHandle() {
/* 486 */     return this.depthbufferHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColorBufferHandle(int paramInt) {
/* 492 */     return this.colorBufferHandles.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStencilBufferHandle() {
/* 498 */     return this.stencilbufferHandle;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDepthStencilPackedBuffer() {
/* 503 */     return this.depthStencilPackedBufferHandle;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 508 */     return this.bufferBuilder.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 513 */     return this.bufferBuilder.width;
/*     */   }
/*     */   
/*     */   private static void addManagedFrameBuffer(Application paramApplication, GLFrameBuffer paramGLFrameBuffer) {
/*     */     Array<GLFrameBuffer> array;
/* 518 */     if ((array = buffers.get(paramApplication)) == null) array = new Array(); 
/* 519 */     array.add(paramGLFrameBuffer);
/* 520 */     buffers.put(paramApplication, array);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void invalidateAllFrameBuffers(Application paramApplication) {
/* 526 */     if (Gdx.gl20 == null)
/*     */       return; 
/*     */     Array array;
/* 529 */     if ((array = buffers.get(paramApplication)) == null)
/* 530 */       return;  for (byte b = 0; b < array.size; b++) {
/* 531 */       ((GLFrameBuffer)array.get(b)).build();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void clearAllFrameBuffers(Application paramApplication) {
/* 536 */     buffers.remove(paramApplication);
/*     */   }
/*     */   
/*     */   public static StringBuilder getManagedStatus(StringBuilder paramStringBuilder) {
/* 540 */     paramStringBuilder.append("Managed buffers/app: { ");
/* 541 */     for (Application application : buffers.keySet()) {
/* 542 */       paramStringBuilder.append(((Array)buffers.get(application)).size);
/* 543 */       paramStringBuilder.append(" ");
/*     */     } 
/* 545 */     paramStringBuilder.append("}");
/* 546 */     return paramStringBuilder;
/*     */   }
/*     */   
/*     */   public static String getManagedStatus() {
/* 550 */     return getManagedStatus(new StringBuilder()).toString();
/*     */   }
/*     */   
/*     */   protected static class FrameBufferTextureAttachmentSpec
/*     */   {
/*     */     int internalFormat;
/*     */     int format;
/*     */     int type;
/*     */     
/*     */     public FrameBufferTextureAttachmentSpec(int param1Int1, int param1Int2, int param1Int3) {
/* 560 */       this.internalFormat = param1Int1;
/* 561 */       this.format = param1Int2;
/* 562 */       this.type = param1Int3;
/*     */     }
/*     */     boolean isFloat; boolean isGpuOnly; boolean isDepth; boolean isStencil;
/*     */     public boolean isColorTexture() {
/* 566 */       return (!this.isDepth && !this.isStencil);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static class FrameBufferRenderBufferAttachmentSpec {
/*     */     int internalFormat;
/*     */     
/*     */     public FrameBufferRenderBufferAttachmentSpec(int param1Int) {
/* 574 */       this.internalFormat = param1Int;
/*     */     } }
/*     */   
/*     */   public static abstract class GLFrameBufferBuilder<U extends GLFrameBuffer<? extends GLTexture>> {
/*     */     protected int width;
/*     */     protected int height;
/*     */     protected int samples;
/* 581 */     protected Array<GLFrameBuffer.FrameBufferTextureAttachmentSpec> textureAttachmentSpecs = new Array();
/* 582 */     protected Array<GLFrameBuffer.FrameBufferRenderBufferAttachmentSpec> colorRenderBufferSpecs = new Array();
/*     */     
/*     */     protected GLFrameBuffer.FrameBufferRenderBufferAttachmentSpec stencilRenderBufferSpec;
/*     */     
/*     */     protected GLFrameBuffer.FrameBufferRenderBufferAttachmentSpec depthRenderBufferSpec;
/*     */     protected GLFrameBuffer.FrameBufferRenderBufferAttachmentSpec packedStencilDepthRenderBufferSpec;
/*     */     protected boolean hasStencilRenderBuffer;
/*     */     protected boolean hasDepthRenderBuffer;
/*     */     protected boolean hasPackedStencilDepthRenderBuffer;
/*     */     
/*     */     public GLFrameBufferBuilder(int param1Int1, int param1Int2) {
/* 593 */       this(param1Int1, param1Int2, 0);
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder(int param1Int1, int param1Int2, int param1Int3) {
/* 597 */       this.width = param1Int1;
/* 598 */       this.height = param1Int2;
/* 599 */       this.samples = param1Int3;
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addColorTextureAttachment(int param1Int1, int param1Int2, int param1Int3) {
/* 603 */       this.textureAttachmentSpecs.add(new GLFrameBuffer.FrameBufferTextureAttachmentSpec(param1Int1, param1Int2, param1Int3));
/* 604 */       return this;
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addBasicColorTextureAttachment(Pixmap.Format param1Format) {
/* 608 */       int j = Pixmap.Format.toGlFormat(param1Format);
/* 609 */       int i = Pixmap.Format.toGlType(param1Format);
/* 610 */       return addColorTextureAttachment(j, j, i);
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addFloatAttachment(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
/*     */       GLFrameBuffer.FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec;
/* 615 */       (frameBufferTextureAttachmentSpec = new GLFrameBuffer.FrameBufferTextureAttachmentSpec(param1Int1, param1Int2, param1Int3)).isFloat = true;
/* 616 */       frameBufferTextureAttachmentSpec.isGpuOnly = param1Boolean;
/* 617 */       this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
/* 618 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public GLFrameBufferBuilder<U> addDepthTextureAttachment(int param1Int1, int param1Int2) {
/*     */       GLFrameBuffer.FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec;
/* 624 */       (frameBufferTextureAttachmentSpec = new GLFrameBuffer.FrameBufferTextureAttachmentSpec(param1Int1, 6402, param1Int2)).isDepth = true;
/* 625 */       this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
/* 626 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public GLFrameBufferBuilder<U> addStencilTextureAttachment(int param1Int1, int param1Int2) {
/*     */       GLFrameBuffer.FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec;
/* 632 */       (frameBufferTextureAttachmentSpec = new GLFrameBuffer.FrameBufferTextureAttachmentSpec(param1Int1, 36128, param1Int2)).isStencil = true;
/* 633 */       this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
/* 634 */       return this;
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addDepthRenderBuffer(int param1Int) {
/* 638 */       this.depthRenderBufferSpec = new GLFrameBuffer.FrameBufferRenderBufferAttachmentSpec(param1Int);
/* 639 */       this.hasDepthRenderBuffer = true;
/* 640 */       return this;
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addColorRenderBuffer(int param1Int) {
/* 644 */       this.colorRenderBufferSpecs.add(new GLFrameBuffer.FrameBufferRenderBufferAttachmentSpec(param1Int));
/* 645 */       return this;
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addStencilRenderBuffer(int param1Int) {
/* 649 */       this.stencilRenderBufferSpec = new GLFrameBuffer.FrameBufferRenderBufferAttachmentSpec(param1Int);
/* 650 */       this.hasStencilRenderBuffer = true;
/* 651 */       return this;
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addStencilDepthPackedRenderBuffer(int param1Int) {
/* 655 */       this.packedStencilDepthRenderBufferSpec = new GLFrameBuffer.FrameBufferRenderBufferAttachmentSpec(param1Int);
/* 656 */       this.hasPackedStencilDepthRenderBuffer = true;
/* 657 */       return this;
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addBasicDepthRenderBuffer() {
/* 661 */       return addDepthRenderBuffer(33189);
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addBasicStencilRenderBuffer() {
/* 665 */       return addStencilRenderBuffer(36168);
/*     */     }
/*     */     
/*     */     public GLFrameBufferBuilder<U> addBasicStencilDepthPackedRenderBuffer() {
/* 669 */       return addStencilDepthPackedRenderBuffer(35056);
/*     */     }
/*     */     
/*     */     public abstract U build();
/*     */   }
/*     */   
/*     */   public static class FrameBufferBuilder extends GLFrameBufferBuilder<FrameBuffer> {
/*     */     public FrameBufferBuilder(int param1Int1, int param1Int2) {
/* 677 */       super(param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     public FrameBufferBuilder(int param1Int1, int param1Int2, int param1Int3) {
/* 681 */       super(param1Int1, param1Int2, param1Int3);
/*     */     }
/*     */ 
/*     */     
/*     */     public FrameBuffer build() {
/* 686 */       return new FrameBuffer(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FloatFrameBufferBuilder extends GLFrameBufferBuilder<FloatFrameBuffer> {
/*     */     public FloatFrameBufferBuilder(int param1Int1, int param1Int2) {
/* 692 */       super(param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     public FloatFrameBufferBuilder(int param1Int1, int param1Int2, int param1Int3) {
/* 696 */       super(param1Int1, param1Int2, param1Int3);
/*     */     }
/*     */ 
/*     */     
/*     */     public FloatFrameBuffer build() {
/* 701 */       return new FloatFrameBuffer(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FrameBufferCubemapBuilder extends GLFrameBufferBuilder<FrameBufferCubemap> {
/*     */     public FrameBufferCubemapBuilder(int param1Int1, int param1Int2) {
/* 707 */       super(param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     public FrameBufferCubemapBuilder(int param1Int1, int param1Int2, int param1Int3) {
/* 711 */       super(param1Int1, param1Int2, param1Int3);
/*     */     }
/*     */ 
/*     */     
/*     */     public FrameBufferCubemap build() {
/* 716 */       return new FrameBufferCubemap(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\GLFrameBuffer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */