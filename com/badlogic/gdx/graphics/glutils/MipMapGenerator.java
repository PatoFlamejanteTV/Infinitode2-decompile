/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
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
/*     */ public class MipMapGenerator
/*     */ {
/*     */   private static boolean useHWMipMap = true;
/*     */   
/*     */   public static void setUseHardwareMipMap(boolean paramBoolean) {
/*  36 */     useHWMipMap = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void generateMipMap(Pixmap paramPixmap, int paramInt1, int paramInt2) {
/*  43 */     generateMipMap(3553, paramPixmap, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void generateMipMap(int paramInt1, Pixmap paramPixmap, int paramInt2, int paramInt3) {
/*  49 */     if (!useHWMipMap) {
/*  50 */       generateMipMapCPU(paramInt1, paramPixmap, paramInt2, paramInt3);
/*     */       
/*     */       return;
/*     */     } 
/*  54 */     if (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.WebGL || Gdx.app
/*  55 */       .getType() == Application.ApplicationType.iOS) {
/*  56 */       generateMipMapGLES20(paramInt1, paramPixmap); return;
/*     */     } 
/*  58 */     generateMipMapDesktop(paramInt1, paramPixmap, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void generateMipMapGLES20(int paramInt, Pixmap paramPixmap) {
/*  63 */     Gdx.gl.glTexImage2D(paramInt, 0, paramPixmap.getGLInternalFormat(), paramPixmap.getWidth(), paramPixmap.getHeight(), 0, paramPixmap.getGLFormat(), paramPixmap
/*  64 */         .getGLType(), paramPixmap.getPixels());
/*  65 */     Gdx.gl20.glGenerateMipmap(paramInt);
/*     */   }
/*     */   
/*     */   private static void generateMipMapDesktop(int paramInt1, Pixmap paramPixmap, int paramInt2, int paramInt3) {
/*  69 */     if (Gdx.graphics.supportsExtension("GL_ARB_framebuffer_object") || Gdx.graphics
/*  70 */       .supportsExtension("GL_EXT_framebuffer_object") || Gdx.gl20
/*  71 */       .getClass().getName().equals("com.badlogic.gdx.backends.lwjgl3.Lwjgl3GLES20") || Gdx.gl30 != null) {
/*     */       
/*  73 */       Gdx.gl.glTexImage2D(paramInt1, 0, paramPixmap.getGLInternalFormat(), paramPixmap.getWidth(), paramPixmap.getHeight(), 0, paramPixmap
/*  74 */           .getGLFormat(), paramPixmap.getGLType(), paramPixmap.getPixels());
/*  75 */       Gdx.gl20.glGenerateMipmap(paramInt1); return;
/*     */     } 
/*  77 */     generateMipMapCPU(paramInt1, paramPixmap, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void generateMipMapCPU(int paramInt1, Pixmap paramPixmap, int paramInt2, int paramInt3) {
/*  82 */     Gdx.gl.glTexImage2D(paramInt1, 0, paramPixmap.getGLInternalFormat(), paramPixmap.getWidth(), paramPixmap.getHeight(), 0, paramPixmap.getGLFormat(), paramPixmap
/*  83 */         .getGLType(), paramPixmap.getPixels());
/*  84 */     if (Gdx.gl20 == null && paramInt2 != paramInt3)
/*  85 */       throw new GdxRuntimeException("texture width and height must be square when using mipmapping."); 
/*  86 */     paramInt2 = paramPixmap.getWidth() / 2;
/*  87 */     paramInt3 = paramPixmap.getHeight() / 2;
/*  88 */     byte b = 1;
/*  89 */     while (paramInt2 > 0 && paramInt3 > 0) {
/*     */       Pixmap pixmap;
/*  91 */       (pixmap = new Pixmap(paramInt2, paramInt3, paramPixmap.getFormat())).setBlending(Pixmap.Blending.None);
/*  92 */       pixmap.drawPixmap(paramPixmap, 0, 0, paramPixmap.getWidth(), paramPixmap.getHeight(), 0, 0, paramInt2, paramInt3);
/*  93 */       if (b > 1) paramPixmap.dispose(); 
/*  94 */       paramPixmap = pixmap;
/*     */       
/*  96 */       Gdx.gl.glTexImage2D(paramInt1, b, paramPixmap.getGLInternalFormat(), paramPixmap.getWidth(), paramPixmap.getHeight(), 0, paramPixmap
/*  97 */           .getGLFormat(), paramPixmap.getGLType(), paramPixmap.getPixels());
/*     */       
/*  99 */       paramInt2 = paramPixmap.getWidth() / 2;
/* 100 */       paramInt3 = paramPixmap.getHeight() / 2;
/* 101 */       b++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\MipMapGenerator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */