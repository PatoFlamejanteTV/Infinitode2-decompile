/*     */ package com.badlogic.gdx.maps.tiled.renderers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteCache;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.MapLayer;
/*     */ import com.badlogic.gdx.maps.MapLayers;
/*     */ import com.badlogic.gdx.maps.MapObject;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMap;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTile;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.utils.Disposable;
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
/*     */ public class OrthoCachedTiledMapRenderer
/*     */   implements TiledMapRenderer, Disposable
/*     */ {
/*     */   private static final float tolerance = 1.0E-5F;
/*     */   protected static final int NUM_VERTICES = 20;
/*     */   protected final TiledMap map;
/*     */   protected final SpriteCache spriteCache;
/*  55 */   protected final float[] vertices = new float[20];
/*     */   
/*     */   protected boolean blending;
/*     */   protected float unitScale;
/*  59 */   protected final Rectangle viewBounds = new Rectangle();
/*  60 */   protected final Rectangle cacheBounds = new Rectangle();
/*     */   
/*  62 */   protected float overCache = 0.5F;
/*     */   
/*     */   protected float maxTileWidth;
/*     */   protected float maxTileHeight;
/*     */   protected boolean cached;
/*     */   protected int count;
/*     */   
/*     */   public OrthoCachedTiledMapRenderer(TiledMap paramTiledMap) {
/*  70 */     this(paramTiledMap, 1.0F, 2000);
/*     */   }
/*     */   protected boolean canCacheMoreN; protected boolean canCacheMoreE; protected boolean canCacheMoreW; protected boolean canCacheMoreS;
/*     */   
/*     */   public OrthoCachedTiledMapRenderer(TiledMap paramTiledMap, float paramFloat) {
/*  75 */     this(paramTiledMap, paramFloat, 2000);
/*     */   }
/*     */ 
/*     */   
/*     */   public OrthoCachedTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, int paramInt) {
/*  80 */     this.map = paramTiledMap;
/*  81 */     this.unitScale = paramFloat;
/*  82 */     this.spriteCache = new SpriteCache(paramInt, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setView(OrthographicCamera paramOrthographicCamera) {
/*  87 */     this.spriteCache.setProjectionMatrix(paramOrthographicCamera.combined);
/*  88 */     float f1 = paramOrthographicCamera.viewportWidth * paramOrthographicCamera.zoom + this.maxTileWidth * 2.0F * this.unitScale;
/*  89 */     float f2 = paramOrthographicCamera.viewportHeight * paramOrthographicCamera.zoom + this.maxTileHeight * 2.0F * this.unitScale;
/*  90 */     this.viewBounds.set(paramOrthographicCamera.position.x - f1 / 2.0F, paramOrthographicCamera.position.y - f2 / 2.0F, f1, f2);
/*     */     
/*  92 */     if ((this.canCacheMoreW && this.viewBounds.x < this.cacheBounds.x - 1.0E-5F) || (this.canCacheMoreS && this.viewBounds.y < this.cacheBounds.y - 1.0E-5F) || (this.canCacheMoreE && this.viewBounds.x + this.viewBounds.width > this.cacheBounds.x + this.cacheBounds.width + 1.0E-5F) || (this.canCacheMoreN && this.viewBounds.y + this.viewBounds.height > this.cacheBounds.y + this.cacheBounds.height + 1.0E-5F))
/*     */     {
/*     */ 
/*     */       
/*  96 */       this.cached = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setView(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 101 */     this.spriteCache.setProjectionMatrix(paramMatrix4);
/* 102 */     paramFloat1 -= this.maxTileWidth * this.unitScale;
/* 103 */     paramFloat2 -= this.maxTileHeight * this.unitScale;
/* 104 */     paramFloat3 += this.maxTileWidth * 2.0F * this.unitScale;
/* 105 */     paramFloat4 += this.maxTileHeight * 2.0F * this.unitScale;
/* 106 */     this.viewBounds.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     
/* 108 */     if ((this.canCacheMoreW && this.viewBounds.x < this.cacheBounds.x - 1.0E-5F) || (this.canCacheMoreS && this.viewBounds.y < this.cacheBounds.y - 1.0E-5F) || (this.canCacheMoreE && this.viewBounds.x + this.viewBounds.width > this.cacheBounds.x + this.cacheBounds.width + 1.0E-5F) || (this.canCacheMoreN && this.viewBounds.y + this.viewBounds.height > this.cacheBounds.y + this.cacheBounds.height + 1.0E-5F))
/*     */     {
/*     */ 
/*     */       
/* 112 */       this.cached = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public void render() {
/* 117 */     if (!this.cached) {
/* 118 */       this.cached = true;
/* 119 */       this.count = 0;
/* 120 */       this.spriteCache.clear();
/*     */       
/* 122 */       float f1 = this.viewBounds.width * this.overCache;
/* 123 */       float f2 = this.viewBounds.height * this.overCache;
/* 124 */       this.viewBounds.x -= f1;
/* 125 */       this.viewBounds.y -= f2;
/* 126 */       this.viewBounds.width += f1 * 2.0F;
/* 127 */       this.viewBounds.height += f2 * 2.0F;
/*     */       
/* 129 */       for (MapLayer mapLayer : this.map.getLayers()) {
/* 130 */         this.spriteCache.beginCache();
/* 131 */         if (mapLayer instanceof TiledMapTileLayer) {
/* 132 */           renderTileLayer((TiledMapTileLayer)mapLayer);
/* 133 */         } else if (mapLayer instanceof TiledMapImageLayer) {
/* 134 */           renderImageLayer((TiledMapImageLayer)mapLayer);
/*     */         } 
/* 136 */         this.spriteCache.endCache();
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     if (this.blending) {
/* 141 */       Gdx.gl.glEnable(3042);
/* 142 */       Gdx.gl.glBlendFunc(770, 771);
/*     */     } 
/* 144 */     this.spriteCache.begin();
/* 145 */     MapLayers mapLayers = this.map.getLayers(); byte b; int i;
/* 146 */     for (b = 0, i = mapLayers.getCount(); b < i; b++) {
/*     */       MapLayer mapLayer;
/* 148 */       if ((mapLayer = mapLayers.get(b)).isVisible()) {
/* 149 */         this.spriteCache.draw(b);
/* 150 */         renderObjects(mapLayer);
/*     */       } 
/*     */     } 
/* 153 */     this.spriteCache.end();
/* 154 */     if (this.blending) Gdx.gl.glDisable(3042);
/*     */   
/*     */   }
/*     */   
/*     */   public void render(int[] paramArrayOfint) {
/* 159 */     if (!this.cached) {
/* 160 */       this.cached = true;
/* 161 */       this.count = 0;
/* 162 */       this.spriteCache.clear();
/*     */       
/* 164 */       float f1 = this.viewBounds.width * this.overCache;
/* 165 */       float f2 = this.viewBounds.height * this.overCache;
/* 166 */       this.viewBounds.x -= f1;
/* 167 */       this.viewBounds.y -= f2;
/* 168 */       this.viewBounds.width += f1 * 2.0F;
/* 169 */       this.viewBounds.height += f2 * 2.0F;
/*     */       
/* 171 */       for (MapLayer mapLayer : this.map.getLayers()) {
/* 172 */         this.spriteCache.beginCache();
/* 173 */         if (mapLayer instanceof TiledMapTileLayer) {
/* 174 */           renderTileLayer((TiledMapTileLayer)mapLayer);
/* 175 */         } else if (mapLayer instanceof TiledMapImageLayer) {
/* 176 */           renderImageLayer((TiledMapImageLayer)mapLayer);
/*     */         } 
/* 178 */         this.spriteCache.endCache();
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     if (this.blending) {
/* 183 */       Gdx.gl.glEnable(3042);
/* 184 */       Gdx.gl.glBlendFunc(770, 771);
/*     */     } 
/* 186 */     this.spriteCache.begin();
/* 187 */     MapLayers mapLayers = this.map.getLayers(); int arrayOfInt[], i; byte b;
/* 188 */     for (i = (arrayOfInt = paramArrayOfint).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*     */       MapLayer mapLayer;
/* 190 */       if ((mapLayer = mapLayers.get(j)).isVisible()) {
/* 191 */         this.spriteCache.draw(j);
/* 192 */         renderObjects(mapLayer);
/*     */       }  b++; }
/*     */     
/* 195 */     this.spriteCache.end();
/* 196 */     if (this.blending) Gdx.gl.glDisable(3042);
/*     */   
/*     */   }
/*     */   
/*     */   public void renderObjects(MapLayer paramMapLayer) {
/* 201 */     for (MapObject mapObject : paramMapLayer.getObjects()) {
/* 202 */       renderObject(mapObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderObject(MapObject paramMapObject) {}
/*     */ 
/*     */   
/*     */   public void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer) {
/* 212 */     float f1 = Color.toFloatBits(1.0F, 1.0F, 1.0F, paramTiledMapTileLayer.getOpacity());
/*     */     
/* 214 */     int i = paramTiledMapTileLayer.getWidth();
/* 215 */     int j = paramTiledMapTileLayer.getHeight();
/*     */     
/* 217 */     float f2 = paramTiledMapTileLayer.getTileWidth() * this.unitScale;
/* 218 */     float f3 = paramTiledMapTileLayer.getTileHeight() * this.unitScale;
/*     */     
/* 220 */     float f4 = paramTiledMapTileLayer.getRenderOffsetX() * this.unitScale - this.viewBounds.x * (paramTiledMapTileLayer.getParallaxX() - 1.0F);
/*     */     
/* 222 */     float f5 = -paramTiledMapTileLayer.getRenderOffsetY() * this.unitScale - this.viewBounds.y * (paramTiledMapTileLayer.getParallaxY() - 1.0F);
/*     */     
/* 224 */     int k = Math.max(0, (int)((this.cacheBounds.x - f4) / f2));
/* 225 */     int m = Math.min(i, (int)((this.cacheBounds.x + this.cacheBounds.width + f2 - f4) / f2));
/*     */ 
/*     */     
/* 228 */     int n = Math.max(0, (int)((this.cacheBounds.y - f5) / f3));
/* 229 */     int i1 = Math.min(j, (int)((this.cacheBounds.y + this.cacheBounds.height + f3 - f5) / f3));
/*     */ 
/*     */     
/* 232 */     this.canCacheMoreN = (i1 < j);
/* 233 */     this.canCacheMoreE = (m < i);
/* 234 */     this.canCacheMoreW = (k > 0);
/* 235 */     this.canCacheMoreS = (n > 0);
/*     */     
/* 237 */     float[] arrayOfFloat = this.vertices;
/* 238 */     for (j = i1; j >= n; j--) {
/* 239 */       for (i1 = k; i1 < m; i1++) {
/*     */         TiledMapTileLayer.Cell cell;
/* 241 */         if ((cell = paramTiledMapTileLayer.getCell(i1, j)) != null) {
/*     */           TiledMapTile tiledMapTile;
/*     */           
/* 244 */           if ((tiledMapTile = cell.getTile()) != null) {
/*     */             
/* 246 */             this.count++;
/* 247 */             boolean bool1 = cell.getFlipHorizontally();
/* 248 */             boolean bool2 = cell.getFlipVertically();
/* 249 */             int i2 = cell.getRotation();
/*     */             
/*     */             TextureRegion textureRegion;
/* 252 */             Texture texture = (textureRegion = tiledMapTile.getTextureRegion()).getTexture();
/*     */             
/* 254 */             float f8 = i1 * f2 + tiledMapTile.getOffsetX() * this.unitScale + f4;
/* 255 */             float f6 = j * f3 + tiledMapTile.getOffsetY() * this.unitScale + f5;
/* 256 */             float f9 = f8 + textureRegion.getRegionWidth() * this.unitScale;
/* 257 */             float f10 = f6 + textureRegion.getRegionHeight() * this.unitScale;
/*     */             
/* 259 */             float f11 = 0.5F / texture.getWidth();
/* 260 */             float f12 = 0.5F / texture.getHeight();
/* 261 */             float f13 = textureRegion.getU() + f11;
/* 262 */             float f14 = textureRegion.getV2() - f12;
/* 263 */             f11 = textureRegion.getU2() - f11;
/* 264 */             float f7 = textureRegion.getV() + f12;
/*     */             
/* 266 */             arrayOfFloat[0] = f8;
/* 267 */             arrayOfFloat[1] = f6;
/* 268 */             arrayOfFloat[2] = f1;
/* 269 */             arrayOfFloat[3] = f13;
/* 270 */             arrayOfFloat[4] = f14;
/*     */             
/* 272 */             arrayOfFloat[5] = f8;
/* 273 */             arrayOfFloat[6] = f10;
/* 274 */             arrayOfFloat[7] = f1;
/* 275 */             arrayOfFloat[8] = f13;
/* 276 */             arrayOfFloat[9] = f7;
/*     */             
/* 278 */             arrayOfFloat[10] = f9;
/* 279 */             arrayOfFloat[11] = f10;
/* 280 */             arrayOfFloat[12] = f1;
/* 281 */             arrayOfFloat[13] = f11;
/* 282 */             arrayOfFloat[14] = f7;
/*     */             
/* 284 */             arrayOfFloat[15] = f9;
/* 285 */             arrayOfFloat[16] = f6;
/* 286 */             arrayOfFloat[17] = f1;
/* 287 */             arrayOfFloat[18] = f11;
/* 288 */             arrayOfFloat[19] = f14;
/*     */             
/* 290 */             if (bool1) {
/* 291 */               f6 = arrayOfFloat[3];
/* 292 */               arrayOfFloat[3] = arrayOfFloat[13];
/* 293 */               arrayOfFloat[13] = f6;
/* 294 */               f6 = arrayOfFloat[8];
/* 295 */               arrayOfFloat[8] = arrayOfFloat[18];
/* 296 */               arrayOfFloat[18] = f6;
/*     */             } 
/* 298 */             if (bool2) {
/* 299 */               f6 = arrayOfFloat[4];
/* 300 */               arrayOfFloat[4] = arrayOfFloat[14];
/* 301 */               arrayOfFloat[14] = f6;
/* 302 */               f6 = arrayOfFloat[9];
/* 303 */               arrayOfFloat[9] = arrayOfFloat[19];
/* 304 */               arrayOfFloat[19] = f6;
/*     */             } 
/* 306 */             if (i2 != 0) {
/* 307 */               float f; switch (i2) {
/*     */                 case 1:
/* 309 */                   f6 = arrayOfFloat[4];
/* 310 */                   arrayOfFloat[4] = arrayOfFloat[9];
/* 311 */                   arrayOfFloat[9] = arrayOfFloat[14];
/* 312 */                   arrayOfFloat[14] = arrayOfFloat[19];
/* 313 */                   arrayOfFloat[19] = f6;
/*     */                   
/* 315 */                   f = arrayOfFloat[3];
/* 316 */                   arrayOfFloat[3] = arrayOfFloat[8];
/* 317 */                   arrayOfFloat[8] = arrayOfFloat[13];
/* 318 */                   arrayOfFloat[13] = arrayOfFloat[18];
/* 319 */                   arrayOfFloat[18] = f;
/*     */                   break;
/*     */                 
/*     */                 case 2:
/* 323 */                   f6 = arrayOfFloat[3];
/* 324 */                   arrayOfFloat[3] = arrayOfFloat[13];
/* 325 */                   arrayOfFloat[13] = f6;
/* 326 */                   f6 = arrayOfFloat[8];
/* 327 */                   arrayOfFloat[8] = arrayOfFloat[18];
/* 328 */                   arrayOfFloat[18] = f6;
/* 329 */                   f = arrayOfFloat[4];
/* 330 */                   arrayOfFloat[4] = arrayOfFloat[14];
/* 331 */                   arrayOfFloat[14] = f;
/* 332 */                   f = arrayOfFloat[9];
/* 333 */                   arrayOfFloat[9] = arrayOfFloat[19];
/* 334 */                   arrayOfFloat[19] = f;
/*     */                   break;
/*     */                 
/*     */                 case 3:
/* 338 */                   f6 = arrayOfFloat[4];
/* 339 */                   arrayOfFloat[4] = arrayOfFloat[19];
/* 340 */                   arrayOfFloat[19] = arrayOfFloat[14];
/* 341 */                   arrayOfFloat[14] = arrayOfFloat[9];
/* 342 */                   arrayOfFloat[9] = f6;
/*     */                   
/* 344 */                   f = arrayOfFloat[3];
/* 345 */                   arrayOfFloat[3] = arrayOfFloat[18];
/* 346 */                   arrayOfFloat[18] = arrayOfFloat[13];
/* 347 */                   arrayOfFloat[13] = arrayOfFloat[8];
/* 348 */                   arrayOfFloat[8] = f;
/*     */                   break;
/*     */               } 
/*     */             
/*     */             } 
/* 353 */             this.spriteCache.add(texture, arrayOfFloat, 0, 20);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void renderImageLayer(TiledMapImageLayer paramTiledMapImageLayer) {
/* 360 */     float f2 = Color.toFloatBits(1.0F, 1.0F, 1.0F, paramTiledMapImageLayer.getOpacity());
/* 361 */     float[] arrayOfFloat = this.vertices;
/*     */     
/*     */     TextureRegion textureRegion;
/*     */     
/* 365 */     if ((textureRegion = paramTiledMapImageLayer.getTextureRegion()) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 369 */     float f3 = paramTiledMapImageLayer.getX();
/* 370 */     float f4 = paramTiledMapImageLayer.getY();
/* 371 */     f3 = f3 * this.unitScale - this.viewBounds.x * (paramTiledMapImageLayer.getParallaxX() - 1.0F);
/* 372 */     float f1 = f4 * this.unitScale - this.viewBounds.y * (paramTiledMapImageLayer.getParallaxY() - 1.0F);
/* 373 */     f4 = f3 + textureRegion.getRegionWidth() * this.unitScale;
/* 374 */     float f5 = f1 + textureRegion.getRegionHeight() * this.unitScale;
/*     */     
/* 376 */     float f6 = textureRegion.getU();
/* 377 */     float f7 = textureRegion.getV2();
/* 378 */     float f8 = textureRegion.getU2();
/* 379 */     float f9 = textureRegion.getV();
/*     */     
/* 381 */     arrayOfFloat[0] = f3;
/* 382 */     arrayOfFloat[1] = f1;
/* 383 */     arrayOfFloat[2] = f2;
/* 384 */     arrayOfFloat[3] = f6;
/* 385 */     arrayOfFloat[4] = f7;
/*     */     
/* 387 */     arrayOfFloat[5] = f3;
/* 388 */     arrayOfFloat[6] = f5;
/* 389 */     arrayOfFloat[7] = f2;
/* 390 */     arrayOfFloat[8] = f6;
/* 391 */     arrayOfFloat[9] = f9;
/*     */     
/* 393 */     arrayOfFloat[10] = f4;
/* 394 */     arrayOfFloat[11] = f5;
/* 395 */     arrayOfFloat[12] = f2;
/* 396 */     arrayOfFloat[13] = f8;
/* 397 */     arrayOfFloat[14] = f9;
/*     */     
/* 399 */     arrayOfFloat[15] = f4;
/* 400 */     arrayOfFloat[16] = f1;
/* 401 */     arrayOfFloat[17] = f2;
/* 402 */     arrayOfFloat[18] = f8;
/* 403 */     arrayOfFloat[19] = f7;
/*     */     
/* 405 */     this.spriteCache.add(textureRegion.getTexture(), arrayOfFloat, 0, 20);
/*     */   }
/*     */ 
/*     */   
/*     */   public void invalidateCache() {
/* 410 */     this.cached = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCached() {
/* 415 */     return this.cached;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOverCache(float paramFloat) {
/* 423 */     this.overCache = paramFloat;
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
/*     */   public void setMaxTileSize(float paramFloat1, float paramFloat2) {
/* 435 */     this.maxTileWidth = paramFloat1;
/* 436 */     this.maxTileHeight = paramFloat2;
/*     */   }
/*     */   
/*     */   public void setBlending(boolean paramBoolean) {
/* 440 */     this.blending = paramBoolean;
/*     */   }
/*     */   
/*     */   public SpriteCache getSpriteCache() {
/* 444 */     return this.spriteCache;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 449 */     this.spriteCache.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\renderers\OrthoCachedTiledMapRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */