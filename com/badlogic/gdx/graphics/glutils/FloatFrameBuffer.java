/*    */ package com.badlogic.gdx.graphics.glutils;
/*    */ 
/*    */ import com.badlogic.gdx.Application;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.graphics.GLTexture;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FloatFrameBuffer
/*    */   extends FrameBuffer
/*    */ {
/*    */   FloatFrameBuffer() {
/* 31 */     checkExtensions();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected FloatFrameBuffer(GLFrameBuffer.GLFrameBufferBuilder<? extends GLFrameBuffer<Texture>> paramGLFrameBufferBuilder) {
/* 38 */     super(paramGLFrameBufferBuilder);
/* 39 */     checkExtensions();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FloatFrameBuffer(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 50 */     checkExtensions();
/*    */     GLFrameBuffer.FloatFrameBufferBuilder floatFrameBufferBuilder;
/* 52 */     (floatFrameBufferBuilder = new GLFrameBuffer.FloatFrameBufferBuilder(paramInt1, paramInt2)).addFloatAttachment(34836, 6408, 5126, false);
/* 53 */     if (paramBoolean) floatFrameBufferBuilder.addBasicDepthRenderBuffer(); 
/* 54 */     this.bufferBuilder = floatFrameBufferBuilder;
/*    */     
/* 56 */     build();
/*    */   }
/*    */ 
/*    */   
/*    */   protected Texture createTexture(GLFrameBuffer.FrameBufferTextureAttachmentSpec paramFrameBufferTextureAttachmentSpec) {
/* 61 */     FloatTextureData floatTextureData = new FloatTextureData(this.bufferBuilder.width, this.bufferBuilder.height, paramFrameBufferTextureAttachmentSpec.internalFormat, paramFrameBufferTextureAttachmentSpec.format, paramFrameBufferTextureAttachmentSpec.type, paramFrameBufferTextureAttachmentSpec.isGpuOnly);
/*    */     
/* 63 */     Texture texture = new Texture(floatTextureData);
/* 64 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop || Gdx.app.getType() == Application.ApplicationType.Applet) {
/* 65 */       texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*    */     } else {
/*    */       
/* 68 */       texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
/* 69 */     }  texture.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
/* 70 */     return texture;
/*    */   }
/*    */ 
/*    */   
/*    */   private void checkExtensions() {
/* 75 */     if (Gdx.graphics.isGL30Available() && Gdx.app.getType() == Application.ApplicationType.WebGL)
/*    */     {
/* 77 */       if (!Gdx.graphics.supportsExtension("EXT_color_buffer_float"))
/* 78 */         throw new GdxRuntimeException("Extension EXT_color_buffer_float not supported!"); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\FloatFrameBuffer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */