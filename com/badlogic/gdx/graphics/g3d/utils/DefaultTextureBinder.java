/*     */ package com.badlogic.gdx.graphics.g3d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.GLTexture;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public final class DefaultTextureBinder
/*     */   implements TextureBinder
/*     */ {
/*     */   public static final int ROUNDROBIN = 0;
/*     */   public static final int LRU = 1;
/*     */   public static final int MAX_GLES_UNITS = 32;
/*     */   private final int offset;
/*     */   private final int count;
/*     */   private final GLTexture[] textures;
/*     */   private int[] unitsLRU;
/*     */   private final int method;
/*     */   private boolean reused;
/*  48 */   private int reuseCount = 0;
/*  49 */   private int bindCount = 0; private final TextureDescriptor tempDesc;
/*     */   private int currentTexture;
/*     */   
/*     */   public DefaultTextureBinder(int paramInt) {
/*  53 */     this(paramInt, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultTextureBinder(int paramInt1, int paramInt2) {
/*  58 */     this(paramInt1, paramInt2, -1);
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
/*     */ 
/*     */   
/*     */   private static int getMaxTextureUnits() {
/*  73 */     IntBuffer intBuffer = BufferUtils.newIntBuffer(16);
/*  74 */     Gdx.gl.glGetIntegerv(34930, intBuffer);
/*  75 */     return intBuffer.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void begin() {
/*  80 */     for (byte b = 0; b < this.count; b++) {
/*  81 */       this.textures[b] = null;
/*  82 */       if (this.unitsLRU != null) this.unitsLRU[b] = b;
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void end() {
/*  93 */     Gdx.gl.glActiveTexture(33984);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int bind(TextureDescriptor paramTextureDescriptor) {
/*  98 */     return bindTexture(paramTextureDescriptor, false);
/*     */   }
/*     */   
/* 101 */   public DefaultTextureBinder(int paramInt1, int paramInt2, int paramInt3) { this.tempDesc = new TextureDescriptor<>();
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
/* 138 */     this.currentTexture = 0; int i = Math.min(getMaxTextureUnits(), 32); if (paramInt3 < 0)
/*     */       paramInt3 = i - paramInt2;  if (paramInt2 < 0 || paramInt3 < 0 || paramInt2 + paramInt3 > i)
/*     */       throw new GdxRuntimeException("Illegal arguments");  this.method = paramInt1; this.offset = paramInt2; this.count = paramInt3; this.textures = new GLTexture[paramInt3]; this.unitsLRU = (paramInt1 == 1) ? new int[paramInt3] : null; }
/* 141 */   public final int bind(GLTexture paramGLTexture) { this.tempDesc.set(paramGLTexture, null, null, null, null); return bindTexture(this.tempDesc, false); } private final int bindTextureRoundRobin(GLTexture paramGLTexture) { for (byte b = 0; b < this.count; b++) {
/* 142 */       int i = (this.currentTexture + b) % this.count;
/* 143 */       if (this.textures[i] == paramGLTexture) {
/* 144 */         this.reused = true;
/* 145 */         return i;
/*     */       } 
/*     */     } 
/* 148 */     this.currentTexture = (this.currentTexture + 1) % this.count;
/* 149 */     this.textures[this.currentTexture] = paramGLTexture;
/* 150 */     paramGLTexture.bind(this.offset + this.currentTexture);
/* 151 */     return this.currentTexture; }
/*     */   private final int bindTexture(TextureDescriptor paramTextureDescriptor, boolean paramBoolean) { int i; T t = paramTextureDescriptor.texture; this.reused = false; switch (this.method) { case 0: i = this.offset + bindTextureRoundRobin((GLTexture)t); break;
/*     */       case 1:
/*     */         i = this.offset + bindTextureLRU((GLTexture)t); break;
/*     */       default:
/* 156 */         return -1; }  if (this.reused) { this.reuseCount++; if (paramBoolean) { t.bind(i); } else { Gdx.gl.glActiveTexture(i + 33984); }  } else { this.bindCount++; }  t.unsafeSetWrap(paramTextureDescriptor.uWrap, paramTextureDescriptor.vWrap); t.unsafeSetFilter(paramTextureDescriptor.minFilter, paramTextureDescriptor.magFilter); return i; } private final int bindTextureLRU(GLTexture paramGLTexture) { int i; for (i = 0; i < this.count; ) {
/* 157 */       int k = this.unitsLRU[i];
/* 158 */       if (this.textures[k] == paramGLTexture) {
/* 159 */         this.reused = true;
/*     */         break;
/*     */       } 
/* 162 */       if (this.textures[k] != null) {
/*     */         i++;
/*     */       }
/*     */     } 
/* 166 */     if (i >= this.count) i = this.count - 1; 
/* 167 */     int j = this.unitsLRU[i];
/* 168 */     while (i > 0) {
/* 169 */       this.unitsLRU[i] = this.unitsLRU[i - 1];
/* 170 */       i--;
/*     */     } 
/* 172 */     this.unitsLRU[0] = j;
/* 173 */     if (!this.reused) {
/* 174 */       this.textures[j] = paramGLTexture;
/* 175 */       paramGLTexture.bind(this.offset + j);
/*     */     } 
/* 177 */     return j; }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getBindCount() {
/* 182 */     return this.bindCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getReuseCount() {
/* 187 */     return this.reuseCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void resetCounts() {
/* 192 */     this.bindCount = this.reuseCount = 0;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\DefaultTextureBinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */