/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Cubemap;
/*     */ import com.badlogic.gdx.graphics.GL20;
/*     */ import com.badlogic.gdx.graphics.GLTexture;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class FrameBufferCubemap
/*     */   extends GLFrameBuffer<Cubemap>
/*     */ {
/*     */   private int currentSide;
/*  69 */   private static final Cubemap.CubemapSide[] cubemapSides = Cubemap.CubemapSide.values();
/*     */ 
/*     */ 
/*     */   
/*     */   FrameBufferCubemap() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected FrameBufferCubemap(GLFrameBuffer.GLFrameBufferBuilder<? extends GLFrameBuffer<Cubemap>> paramGLFrameBufferBuilder) {
/*  78 */     super(paramGLFrameBufferBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FrameBufferCubemap(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  88 */     this(paramFormat, paramInt1, paramInt2, paramBoolean, false);
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
/*     */   
/*     */   public FrameBufferCubemap(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     GLFrameBuffer.FrameBufferCubemapBuilder frameBufferCubemapBuilder;
/* 102 */     (frameBufferCubemapBuilder = new GLFrameBuffer.FrameBufferCubemapBuilder(paramInt1, paramInt2)).addBasicColorTextureAttachment(paramFormat);
/* 103 */     if (paramBoolean1) frameBufferCubemapBuilder.addBasicDepthRenderBuffer(); 
/* 104 */     if (paramBoolean2) frameBufferCubemapBuilder.addBasicStencilRenderBuffer(); 
/* 105 */     this.bufferBuilder = frameBufferCubemapBuilder;
/*     */     
/* 107 */     build();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Cubemap createTexture(GLFrameBuffer.FrameBufferTextureAttachmentSpec paramFrameBufferTextureAttachmentSpec) {
/* 112 */     GLOnlyTextureData gLOnlyTextureData = new GLOnlyTextureData(this.bufferBuilder.width, this.bufferBuilder.height, 0, paramFrameBufferTextureAttachmentSpec.internalFormat, paramFrameBufferTextureAttachmentSpec.format, paramFrameBufferTextureAttachmentSpec.type);
/*     */     
/*     */     Cubemap cubemap;
/* 115 */     (cubemap = new Cubemap(gLOnlyTextureData, gLOnlyTextureData, gLOnlyTextureData, gLOnlyTextureData, gLOnlyTextureData, gLOnlyTextureData)).setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/* 116 */     cubemap.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
/* 117 */     return cubemap;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void disposeColorTexture(Cubemap paramCubemap) {
/* 122 */     paramCubemap.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void attachFrameBufferColorTexture(Cubemap paramCubemap) {
/* 127 */     GL20 gL20 = Gdx.gl20;
/* 128 */     int i = paramCubemap.getTextureObjectHandle(); Cubemap.CubemapSide[] arrayOfCubemapSide; int j;
/*     */     byte b;
/* 130 */     for (j = (arrayOfCubemapSide = arrayOfCubemapSide = Cubemap.CubemapSide.values()).length, b = 0; b < j; ) { Cubemap.CubemapSide cubemapSide = arrayOfCubemapSide[b];
/* 131 */       gL20.glFramebufferTexture2D(36160, 36064, cubemapSide.glEnum, i, 0);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind() {
/* 139 */     this.currentSide = -1;
/* 140 */     super.bind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean nextSide() {
/* 146 */     if (this.currentSide > 5)
/* 147 */       throw new GdxRuntimeException("No remaining sides."); 
/* 148 */     if (this.currentSide == 5) {
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     this.currentSide++;
/* 153 */     bindSide(getSide());
/* 154 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void bindSide(Cubemap.CubemapSide paramCubemapSide) {
/* 160 */     Gdx.gl20.glFramebufferTexture2D(36160, 36064, paramCubemapSide.glEnum, 
/* 161 */         getColorBufferTexture().getTextureObjectHandle(), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Cubemap.CubemapSide getSide() {
/* 166 */     return (this.currentSide < 0) ? null : cubemapSides[this.currentSide];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\FrameBufferCubemap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */