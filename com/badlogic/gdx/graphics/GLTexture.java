/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.glutils.MipMapGenerator;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import java.nio.FloatBuffer;
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
/*     */ public abstract class GLTexture
/*     */   implements Disposable
/*     */ {
/*     */   public final int glTarget;
/*     */   protected int glHandle;
/*  39 */   protected Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
/*  40 */   protected Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
/*  41 */   protected Texture.TextureWrap uWrap = Texture.TextureWrap.ClampToEdge;
/*  42 */   protected Texture.TextureWrap vWrap = Texture.TextureWrap.ClampToEdge;
/*  43 */   protected float anisotropicFilterLevel = 1.0F;
/*  44 */   private static float maxAnisotropicFilterLevel = 0.0F;
/*     */ 
/*     */   
/*     */   public abstract int getWidth();
/*     */ 
/*     */   
/*     */   public abstract int getHeight();
/*     */ 
/*     */   
/*     */   public abstract int getDepth();
/*     */ 
/*     */   
/*     */   public GLTexture(int paramInt) {
/*  57 */     this(paramInt, Gdx.gl.glGenTexture());
/*     */   }
/*     */   
/*     */   public GLTexture(int paramInt1, int paramInt2) {
/*  61 */     this.glTarget = paramInt1;
/*  62 */     this.glHandle = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract boolean isManaged();
/*     */ 
/*     */   
/*     */   protected abstract void reload();
/*     */ 
/*     */   
/*     */   public void bind() {
/*  73 */     Gdx.gl.glBindTexture(this.glTarget, this.glHandle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(int paramInt) {
/*  79 */     Gdx.gl.glActiveTexture(paramInt + 33984);
/*  80 */     Gdx.gl.glBindTexture(this.glTarget, this.glHandle);
/*     */   }
/*     */ 
/*     */   
/*     */   public Texture.TextureFilter getMinFilter() {
/*  85 */     return this.minFilter;
/*     */   }
/*     */ 
/*     */   
/*     */   public Texture.TextureFilter getMagFilter() {
/*  90 */     return this.magFilter;
/*     */   }
/*     */ 
/*     */   
/*     */   public Texture.TextureWrap getUWrap() {
/*  95 */     return this.uWrap;
/*     */   }
/*     */ 
/*     */   
/*     */   public Texture.TextureWrap getVWrap() {
/* 100 */     return this.vWrap;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTextureObjectHandle() {
/* 105 */     return this.glHandle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsafeSetWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2) {
/* 112 */     unsafeSetWrap(paramTextureWrap1, paramTextureWrap2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsafeSetWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2, boolean paramBoolean) {
/* 120 */     if (paramTextureWrap1 != null && (paramBoolean || this.uWrap != paramTextureWrap1)) {
/* 121 */       Gdx.gl.glTexParameteri(this.glTarget, 10242, paramTextureWrap1.getGLEnum());
/* 122 */       this.uWrap = paramTextureWrap1;
/*     */     } 
/* 124 */     if (paramTextureWrap2 != null && (paramBoolean || this.vWrap != paramTextureWrap2)) {
/* 125 */       Gdx.gl.glTexParameteri(this.glTarget, 10243, paramTextureWrap2.getGLEnum());
/* 126 */       this.vWrap = paramTextureWrap2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2) {
/* 134 */     this.uWrap = paramTextureWrap1;
/* 135 */     this.vWrap = paramTextureWrap2;
/* 136 */     bind();
/* 137 */     Gdx.gl.glTexParameteri(this.glTarget, 10242, paramTextureWrap1.getGLEnum());
/* 138 */     Gdx.gl.glTexParameteri(this.glTarget, 10243, paramTextureWrap2.getGLEnum());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsafeSetFilter(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2) {
/* 146 */     unsafeSetFilter(paramTextureFilter1, paramTextureFilter2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsafeSetFilter(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean) {
/* 155 */     if (paramTextureFilter1 != null && (paramBoolean || this.minFilter != paramTextureFilter1)) {
/* 156 */       Gdx.gl.glTexParameteri(this.glTarget, 10241, paramTextureFilter1.getGLEnum());
/* 157 */       this.minFilter = paramTextureFilter1;
/*     */     } 
/* 159 */     if (paramTextureFilter2 != null && (paramBoolean || this.magFilter != paramTextureFilter2)) {
/* 160 */       Gdx.gl.glTexParameteri(this.glTarget, 10240, paramTextureFilter2.getGLEnum());
/* 161 */       this.magFilter = paramTextureFilter2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilter(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2) {
/* 169 */     this.minFilter = paramTextureFilter1;
/* 170 */     this.magFilter = paramTextureFilter2;
/* 171 */     bind();
/* 172 */     Gdx.gl.glTexParameteri(this.glTarget, 10241, paramTextureFilter1.getGLEnum());
/* 173 */     Gdx.gl.glTexParameteri(this.glTarget, 10240, paramTextureFilter2.getGLEnum());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float unsafeSetAnisotropicFilter(float paramFloat) {
/* 181 */     return unsafeSetAnisotropicFilter(paramFloat, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float unsafeSetAnisotropicFilter(float paramFloat, boolean paramBoolean) {
/*     */     float f;
/* 191 */     if ((f = getMaxAnisotropicFilterLevel()) == 1.0F) return 1.0F; 
/* 192 */     paramFloat = Math.min(paramFloat, f);
/* 193 */     if (!paramBoolean && MathUtils.isEqual(paramFloat, this.anisotropicFilterLevel, 0.1F)) return this.anisotropicFilterLevel; 
/* 194 */     Gdx.gl20.glTexParameterf(3553, 34046, paramFloat);
/* 195 */     return this.anisotropicFilterLevel = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float setAnisotropicFilter(float paramFloat) {
/*     */     float f;
/* 204 */     if ((f = getMaxAnisotropicFilterLevel()) == 1.0F) return 1.0F;
/*     */     
/* 206 */     if (MathUtils.isEqual(paramFloat = Math.min(paramFloat, f), this.anisotropicFilterLevel, 0.1F)) return paramFloat; 
/* 207 */     bind();
/* 208 */     Gdx.gl20.glTexParameterf(3553, 34046, paramFloat);
/* 209 */     return this.anisotropicFilterLevel = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAnisotropicFilter() {
/* 214 */     return this.anisotropicFilterLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getMaxAnisotropicFilterLevel() {
/* 219 */     if (maxAnisotropicFilterLevel > 0.0F) return maxAnisotropicFilterLevel; 
/* 220 */     if (Gdx.graphics.supportsExtension("GL_EXT_texture_filter_anisotropic")) {
/*     */       FloatBuffer floatBuffer;
/* 222 */       (floatBuffer = BufferUtils.newFloatBuffer(16)).position(0);
/* 223 */       floatBuffer.limit(floatBuffer.capacity());
/* 224 */       Gdx.gl20.glGetFloatv(34047, floatBuffer);
/* 225 */       return maxAnisotropicFilterLevel = floatBuffer.get(0);
/*     */     } 
/* 227 */     return maxAnisotropicFilterLevel = 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void delete() {
/* 232 */     if (this.glHandle != 0) {
/* 233 */       Gdx.gl.glDeleteTexture(this.glHandle);
/* 234 */       this.glHandle = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 240 */     delete();
/*     */   }
/*     */   
/*     */   protected static void uploadImageData(int paramInt, TextureData paramTextureData) {
/* 244 */     uploadImageData(paramInt, paramTextureData, 0);
/*     */   }
/*     */   
/*     */   public static void uploadImageData(int paramInt1, TextureData paramTextureData, int paramInt2) {
/* 248 */     if (paramTextureData == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 253 */     if (!paramTextureData.isPrepared()) paramTextureData.prepare();
/*     */     
/*     */     TextureData.TextureDataType textureDataType;
/* 256 */     if ((textureDataType = paramTextureData.getType()) == TextureData.TextureDataType.Custom) {
/* 257 */       paramTextureData.consumeCustomData(paramInt1);
/*     */       
/*     */       return;
/*     */     } 
/* 261 */     Pixmap pixmap = paramTextureData.consumePixmap();
/* 262 */     boolean bool = paramTextureData.disposePixmap();
/* 263 */     if (paramTextureData.getFormat() != pixmap.getFormat()) {
/*     */       Pixmap pixmap1;
/* 265 */       (pixmap1 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), paramTextureData.getFormat())).setBlending(Pixmap.Blending.None);
/* 266 */       pixmap1.drawPixmap(pixmap, 0, 0, 0, 0, pixmap.getWidth(), pixmap.getHeight());
/* 267 */       if (paramTextureData.disposePixmap()) {
/* 268 */         pixmap.dispose();
/*     */       }
/* 270 */       pixmap = pixmap1;
/* 271 */       bool = true;
/*     */     } 
/*     */     
/* 274 */     Gdx.gl.glPixelStorei(3317, 1);
/* 275 */     if (paramTextureData.useMipMaps()) {
/* 276 */       MipMapGenerator.generateMipMap(paramInt1, pixmap, pixmap.getWidth(), pixmap.getHeight());
/*     */     } else {
/* 278 */       Gdx.gl.glTexImage2D(paramInt1, paramInt2, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap
/* 279 */           .getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
/*     */     } 
/* 281 */     if (bool) pixmap.dispose(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\GLTexture.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */