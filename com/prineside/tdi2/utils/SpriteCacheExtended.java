/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteCache;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.math.Affine2;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.RenderingManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SpriteCacheExtended
/*     */   extends SpriteCache
/*     */   implements Batch
/*     */ {
/*     */   public final boolean useIndices;
/*     */   public final int vertexPerAdd;
/*     */   public final int size;
/*     */   public final int maxAdds;
/*     */   public int addCount;
/*  31 */   public int lastCacheId = Integer.MIN_VALUE;
/*     */   
/*     */   private Batch a;
/*  34 */   private float b = 1.0F;
/*     */   
/*     */   public SpriteCacheExtended(String paramString, int paramInt, ShaderProgram paramShaderProgram, boolean paramBoolean) {
/*  37 */     super(paramInt, (paramShaderProgram == null) ? createDefaultShader() : paramShaderProgram, paramBoolean);
/*     */     
/*  39 */     this.useIndices = paramBoolean;
/*  40 */     this.vertexPerAdd = paramBoolean ? 4 : 6;
/*  41 */     this.size = paramInt;
/*  42 */     this.maxAdds = (int)(paramInt * 0.67F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setOutputToBatch(Batch paramBatch) {
/*  52 */     if (!this.useIndices) throw new IllegalStateException("Can not be used without indices"); 
/*  53 */     this.a = paramBatch;
/*     */   }
/*     */   
/*     */   public final void setAlphaMultiplier(float paramFloat) {
/*  57 */     this.b = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ShaderProgram createDefaultShader() {
/*  64 */     return RenderingManager.createShader("SpriteCacheExtended");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void add(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  69 */     if (this.a == null) {
/*  70 */       if (paramInt2 % this.vertexPerAdd * 5 != 0) {
/*  71 */         throw new IllegalArgumentException("vertices array must be %" + (this.vertexPerAdd * 5) + " floats in length, " + paramInt2 + " given. Check if useIndices match");
/*     */       }
/*     */       try {
/*  74 */         super.add(paramTexture, paramArrayOffloat, paramInt1, paramInt2);
/*  75 */       } catch (Exception exception) {
/*  76 */         throw new IllegalStateException("failed to add vertices to cache, ac " + this.addCount + " size " + this.size + " vpa " + this.vertexPerAdd + " ma " + this.maxAdds, exception);
/*     */       } 
/*  78 */       this.addCount++; return;
/*     */     } 
/*  80 */     if (paramInt2 % 20 != 0) {
/*  81 */       throw new IllegalArgumentException("this cache uses indices and requires float[%20] as an input, float[" + paramInt2 + "] given");
/*     */     }
/*     */     
/*  84 */     if (this.b < 1.0F) {
/*  85 */       int i = MathUtils.round(MathUtils.clamp(this.b, 0.0F, 1.0F) * 255.0F) << 24;
/*  86 */       for (int j = paramInt1; j < paramInt2; j += 5) {
/*     */         
/*  88 */         int k = (k = NumberUtils.floatToIntColor(paramArrayOffloat[j + 2])) & 0xFFFFFF | i;
/*  89 */         paramArrayOffloat[j + 2] = NumberUtils.intToFloatColor(k);
/*     */       } 
/*     */     } 
/*  92 */     this.a.draw(paramTexture, paramArrayOffloat, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void beginCache() {
/*  98 */     super.beginCache();
/*  99 */     this.addCount = 0;
/*     */   }
/*     */   
/*     */   public final boolean isFull() {
/* 103 */     return (this.addCount >= this.maxAdds);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int endCache() {
/* 108 */     return this.lastCacheId = super.endCache();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void clear() {
/* 113 */     super.clear();
/* 114 */     this.lastCacheId = Integer.MIN_VALUE;
/* 115 */     this.addCount = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/* 125 */     add(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
/* 133 */     add(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 139 */     add(paramTexture, paramFloat1, paramFloat2, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/* 149 */     add(paramTexture, paramFloat1, paramFloat2, (int)paramFloat3, (int)paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, getPackedColor());
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2) {
/* 155 */     add(paramTexture, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 161 */     add(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0, 0, paramTexture.getWidth(), paramTexture.getHeight(), false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(Texture paramTexture, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 167 */     add(paramTexture, paramArrayOffloat, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2) {
/* 173 */     add(paramTextureRegion, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 179 */     add(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 185 */     add(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean) {
/* 191 */     add(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9 + (paramBoolean ? 90.0F : -90.0F));
/*     */   }
/*     */   
/* 194 */   private static final float[] c = new float[20];
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2) {
/* 198 */     float f2 = paramAffine2.m02;
/* 199 */     float f3 = paramAffine2.m12;
/* 200 */     float f4 = paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/* 201 */     float f5 = paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/* 202 */     float f6 = paramAffine2.m00 * paramFloat1 + paramAffine2.m01 * paramFloat2 + paramAffine2.m02;
/* 203 */     paramFloat2 = paramAffine2.m10 * paramFloat1 + paramAffine2.m11 * paramFloat2 + paramAffine2.m12;
/* 204 */     float f7 = paramAffine2.m00 * paramFloat1 + paramAffine2.m02;
/* 205 */     paramFloat1 = paramAffine2.m10 * paramFloat1 + paramAffine2.m12;
/*     */     
/* 207 */     float f1 = paramTextureRegion.getU();
/* 208 */     float f8 = paramTextureRegion.getV2();
/* 209 */     float f9 = paramTextureRegion.getU2();
/* 210 */     float f10 = paramTextureRegion.getV();
/*     */     
/* 212 */     float f11 = getPackedColor();
/*     */     float[] arrayOfFloat;
/* 214 */     (arrayOfFloat = c)[0] = f2;
/* 215 */     arrayOfFloat[1] = f3;
/* 216 */     arrayOfFloat[2] = f11;
/* 217 */     arrayOfFloat[3] = f1;
/* 218 */     arrayOfFloat[4] = f8;
/*     */     
/* 220 */     arrayOfFloat[5] = f4;
/* 221 */     arrayOfFloat[6] = f5;
/* 222 */     arrayOfFloat[7] = f11;
/* 223 */     arrayOfFloat[8] = f1;
/* 224 */     arrayOfFloat[9] = f10;
/*     */     
/* 226 */     arrayOfFloat[10] = f6;
/* 227 */     arrayOfFloat[11] = paramFloat2;
/* 228 */     arrayOfFloat[12] = f11;
/* 229 */     arrayOfFloat[13] = f9;
/* 230 */     arrayOfFloat[14] = f10;
/*     */     
/* 232 */     arrayOfFloat[15] = f7;
/* 233 */     arrayOfFloat[16] = paramFloat1;
/* 234 */     arrayOfFloat[17] = f11;
/* 235 */     arrayOfFloat[18] = f9;
/* 236 */     arrayOfFloat[19] = f8;
/*     */     
/* 238 */     add(paramTextureRegion.getTexture(), arrayOfFloat, 0, 20);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void flush() {
/* 243 */     if (this.a != null) {
/* 244 */       this.a.flush();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void disableBlending() {
/* 250 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void enableBlending() {
/* 255 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setBlendFunction(int paramInt1, int paramInt2) {
/* 260 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setBlendFunctionSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 265 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getBlendSrcFunc() {
/* 270 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getBlendDstFunc() {
/* 275 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getBlendSrcFuncAlpha() {
/* 280 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getBlendDstFuncAlpha() {
/* 285 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */ 
/*     */   
/*     */   public final ShaderProgram getShader() {
/* 290 */     return getShader();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBlendingEnabled() {
/* 295 */     throw new IllegalStateException("SpriteCache does not allow to change blending");
/*     */   }
/*     */   
/*     */   public static final class CacheArray implements Disposable {
/* 299 */     private final Array<SpriteCacheExtended> a = new Array(true, 1, SpriteCacheExtended.class);
/*     */     
/*     */     public boolean dirty;
/*     */     
/*     */     private final String b;
/*     */     
/*     */     private final String c;
/*     */     
/*     */     private final int d;
/*     */     
/*     */     private final boolean e;
/*     */     private final ShaderProgram f;
/*     */     private int g;
/* 312 */     private static final Array<SpriteCacheExtended> h = new Array(true, 1, SpriteCacheExtended.class);
/*     */     
/*     */     public CacheArray(String param1String, int param1Int, ShaderProgram param1ShaderProgram, boolean param1Boolean) {
/* 315 */       this.b = param1String;
/* 316 */       this.c = "SC_" + param1String;
/* 317 */       this.d = param1Int;
/* 318 */       this.e = param1Boolean;
/* 319 */       this.f = param1ShaderProgram;
/* 320 */       a();
/*     */     }
/*     */     
/*     */     public final int getSizePerCache() {
/* 324 */       return this.d;
/*     */     }
/*     */     
/*     */     public final boolean isUseIndices() {
/* 328 */       return this.e;
/*     */     }
/*     */     
/*     */     public final ShaderProgram getShaderProgram() {
/* 332 */       return this.f;
/*     */     }
/*     */     
/*     */     private void a(int param1Int) {
/* 336 */       while (this.a.size < param1Int) {
/* 337 */         this.a.add(new SpriteCacheExtended(this.b + " SC" + this.a.size, this.d, this.f, this.e));
/* 338 */         a();
/*     */       } 
/*     */     }
/*     */     
/*     */     public final SpriteCacheExtended start() {
/* 343 */       for (byte b = 0; b < this.a.size; b++) {
/*     */         SpriteCacheExtended spriteCacheExtended1;
/* 345 */         (spriteCacheExtended1 = ((SpriteCacheExtended[])this.a.items)[b]).clear();
/*     */       } 
/*     */       
/* 348 */       this.g = 0;
/* 349 */       a(this.g + 1);
/*     */       
/*     */       SpriteCacheExtended spriteCacheExtended;
/* 352 */       (spriteCacheExtended = ((SpriteCacheExtended[])this.a.items)[this.g]).beginCache();
/*     */       
/* 354 */       a();
/*     */       
/* 356 */       return spriteCacheExtended;
/*     */     }
/*     */     
/*     */     public final void end() {
/*     */       SpriteCacheExtended spriteCacheExtended;
/* 361 */       (spriteCacheExtended = ((SpriteCacheExtended[])this.a.items)[this.g]).endCache();
/*     */       
/* 363 */       a();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final SpriteCacheExtended swapCachesIfFull() {
/*     */       SpriteCacheExtended spriteCacheExtended;
/* 371 */       if ((spriteCacheExtended = ((SpriteCacheExtended[])this.a.items)[this.g]).isFull()) {
/* 372 */         spriteCacheExtended.endCache();
/*     */         
/* 374 */         this.g++;
/* 375 */         a(this.g + 1);
/*     */         
/*     */         SpriteCacheExtended spriteCacheExtended1;
/* 378 */         (spriteCacheExtended1 = ((SpriteCacheExtended[])this.a.items)[this.g]).setColor(spriteCacheExtended.getColor());
/* 379 */         spriteCacheExtended1.beginCache();
/*     */         
/* 381 */         a();
/*     */         
/* 383 */         return spriteCacheExtended1;
/*     */       } 
/* 385 */       return spriteCacheExtended;
/*     */     }
/*     */ 
/*     */     
/*     */     public final Array<SpriteCacheExtended> getPreparedCaches() {
/* 390 */       a();
/*     */       
/* 392 */       h.clear();
/* 393 */       for (byte b = 0; b < this.a.size; b++) {
/*     */         SpriteCacheExtended spriteCacheExtended;
/* 395 */         if ((spriteCacheExtended = ((SpriteCacheExtended[])this.a.items)[b]).lastCacheId != Integer.MIN_VALUE && spriteCacheExtended.addCount != 0) {
/* 396 */           h.add(spriteCacheExtended);
/*     */         }
/*     */       } 
/*     */       
/* 400 */       return h;
/*     */     }
/*     */     
/*     */     private void a() {
/* 404 */       if (Game.i.debugManager.isEnabled()) {
/*     */         StringBuilder stringBuilder;
/* 406 */         (stringBuilder = Game.i.debugManager.registerValue(this.c)).append("s ").append(this.d).append(" ci ").append(this.g);
/* 407 */         for (byte b = 0; b < this.a.size; b++) {
/* 408 */           SpriteCacheExtended spriteCacheExtended = ((SpriteCacheExtended[])this.a.items)[b];
/* 409 */           stringBuilder.append(" / #").append(b).append(": ").append((spriteCacheExtended.lastCacheId == Integer.MIN_VALUE) ? "N" : Integer.valueOf(spriteCacheExtended.lastCacheId)).append(",").append(spriteCacheExtended.addCount).append(",").append(spriteCacheExtended.totalRenderCalls);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public final void dispose() {
/* 416 */       for (byte b = 0; b < this.a.size; b++) {
/* 417 */         ((SpriteCacheExtended[])this.a.items)[b].dispose();
/*     */       }
/* 419 */       this.a.clear();
/*     */       
/* 421 */       if (Game.i.debugManager.isEnabled())
/* 422 */         Game.i.debugManager.unregisterValue(this.c); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\SpriteCacheExtended.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */