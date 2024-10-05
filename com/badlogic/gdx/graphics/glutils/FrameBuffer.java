/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.GLTexture;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
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
/*     */ 
/*     */ public class FrameBuffer
/*     */   extends GLFrameBuffer<Texture>
/*     */ {
/*     */   FrameBuffer() {}
/*     */   
/*     */   protected FrameBuffer(GLFrameBuffer.GLFrameBufferBuilder<? extends GLFrameBuffer<Texture>> paramGLFrameBufferBuilder) {
/*  53 */     super(paramGLFrameBufferBuilder);
/*     */   }
/*     */ 
/*     */   
/*     */   public FrameBuffer(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  58 */     this(paramFormat, paramInt1, paramInt2, paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FrameBuffer(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     GLFrameBuffer.FrameBufferBuilder frameBufferBuilder;
/*  71 */     (frameBufferBuilder = new GLFrameBuffer.FrameBufferBuilder(paramInt1, paramInt2)).addBasicColorTextureAttachment(paramFormat);
/*  72 */     if (paramBoolean1) frameBufferBuilder.addBasicDepthRenderBuffer(); 
/*  73 */     if (paramBoolean2) frameBufferBuilder.addBasicStencilRenderBuffer(); 
/*  74 */     this.bufferBuilder = frameBufferBuilder;
/*     */     
/*  76 */     build();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Texture createTexture(GLFrameBuffer.FrameBufferTextureAttachmentSpec paramFrameBufferTextureAttachmentSpec) {
/*  81 */     GLOnlyTextureData gLOnlyTextureData = new GLOnlyTextureData(this.bufferBuilder.width, this.bufferBuilder.height, 0, paramFrameBufferTextureAttachmentSpec.internalFormat, paramFrameBufferTextureAttachmentSpec.format, paramFrameBufferTextureAttachmentSpec.type);
/*     */     
/*  83 */     Texture texture = new Texture(gLOnlyTextureData);
/*     */     
/*     */     boolean bool;
/*  86 */     if (!(bool = (paramFrameBufferTextureAttachmentSpec.isDepth && Gdx.app.getType() == Application.ApplicationType.WebGL) ? true : false)) {
/*  87 */       texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*     */     }
/*  89 */     texture.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
/*  90 */     return texture;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void disposeColorTexture(Texture paramTexture) {
/*  95 */     paramTexture.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void attachFrameBufferColorTexture(Texture paramTexture) {
/* 100 */     Gdx.gl20.glFramebufferTexture2D(36160, 36064, 3553, paramTexture
/* 101 */         .getTextureObjectHandle(), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void unbind() {
/* 106 */     GLFrameBuffer.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\FrameBuffer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */