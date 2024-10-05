/*     */ package com.badlogic.gdx.maps.tiled.renderers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.maps.MapGroupLayer;
/*     */ import com.badlogic.gdx.maps.MapLayer;
/*     */ import com.badlogic.gdx.maps.MapLayers;
/*     */ import com.badlogic.gdx.maps.MapObject;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMap;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
/*     */ import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
/*     */ import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
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
/*     */ public abstract class BatchTiledMapRenderer
/*     */   implements TiledMapRenderer, Disposable
/*     */ {
/*     */   protected static final int NUM_VERTICES = 20;
/*     */   protected TiledMap map;
/*     */   protected float unitScale;
/*     */   protected Batch batch;
/*     */   protected Rectangle viewBounds;
/*  68 */   protected Rectangle imageBounds = new Rectangle();
/*     */   
/*     */   protected boolean ownsBatch;
/*     */   
/*  72 */   protected float[] vertices = new float[20];
/*     */   
/*     */   public TiledMap getMap() {
/*  75 */     return this.map;
/*     */   }
/*     */   
/*     */   public void setMap(TiledMap paramTiledMap) {
/*  79 */     this.map = paramTiledMap;
/*     */   }
/*     */   
/*     */   public float getUnitScale() {
/*  83 */     return this.unitScale;
/*     */   }
/*     */   
/*     */   public Batch getBatch() {
/*  87 */     return this.batch;
/*     */   }
/*     */   
/*     */   public Rectangle getViewBounds() {
/*  91 */     return this.viewBounds;
/*     */   }
/*     */   
/*     */   public BatchTiledMapRenderer(TiledMap paramTiledMap) {
/*  95 */     this(paramTiledMap, 1.0F);
/*     */   }
/*     */   
/*     */   public BatchTiledMapRenderer(TiledMap paramTiledMap, float paramFloat) {
/*  99 */     this.map = paramTiledMap;
/* 100 */     this.unitScale = paramFloat;
/* 101 */     this.viewBounds = new Rectangle();
/* 102 */     this.batch = (Batch)new SpriteBatch();
/* 103 */     this.ownsBatch = true;
/*     */   }
/*     */   
/*     */   public BatchTiledMapRenderer(TiledMap paramTiledMap, Batch paramBatch) {
/* 107 */     this(paramTiledMap, 1.0F, paramBatch);
/*     */   }
/*     */   
/*     */   public BatchTiledMapRenderer(TiledMap paramTiledMap, float paramFloat, Batch paramBatch) {
/* 111 */     this.map = paramTiledMap;
/* 112 */     this.unitScale = paramFloat;
/* 113 */     this.viewBounds = new Rectangle();
/* 114 */     this.batch = paramBatch;
/* 115 */     this.ownsBatch = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setView(OrthographicCamera paramOrthographicCamera) {
/* 120 */     this.batch.setProjectionMatrix(paramOrthographicCamera.combined);
/* 121 */     float f1 = paramOrthographicCamera.viewportWidth * paramOrthographicCamera.zoom;
/* 122 */     float f2 = paramOrthographicCamera.viewportHeight * paramOrthographicCamera.zoom;
/* 123 */     float f3 = f1 * Math.abs(paramOrthographicCamera.up.y) + f2 * Math.abs(paramOrthographicCamera.up.x);
/* 124 */     f1 = f2 * Math.abs(paramOrthographicCamera.up.y) + f1 * Math.abs(paramOrthographicCamera.up.x);
/* 125 */     this.viewBounds.set(paramOrthographicCamera.position.x - f3 / 2.0F, paramOrthographicCamera.position.y - f1 / 2.0F, f3, f1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setView(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 130 */     this.batch.setProjectionMatrix(paramMatrix4);
/* 131 */     this.viewBounds.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render() {
/* 136 */     beginRender();
/* 137 */     for (MapLayer mapLayer : this.map.getLayers()) {
/* 138 */       renderMapLayer(mapLayer);
/*     */     }
/* 140 */     endRender();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(int[] paramArrayOfint) {
/* 145 */     beginRender(); int i; byte b;
/* 146 */     for (i = (paramArrayOfint = paramArrayOfint).length, b = 0; b < i; ) { int j = paramArrayOfint[b];
/* 147 */       MapLayer mapLayer = this.map.getLayers().get(j);
/* 148 */       renderMapLayer(mapLayer); b++; }
/*     */     
/* 150 */     endRender();
/*     */   }
/*     */   protected void renderMapLayer(MapLayer paramMapLayer) {
/*     */     MapLayers mapLayers;
/* 154 */     if (!paramMapLayer.isVisible())
/* 155 */       return;  if (paramMapLayer instanceof MapGroupLayer) {
/* 156 */       mapLayers = ((MapGroupLayer)paramMapLayer).getLayers();
/* 157 */       for (byte b = 0; b < mapLayers.size(); b++) {
/*     */         MapLayer mapLayer;
/* 159 */         if ((mapLayer = mapLayers.get(b)).isVisible())
/* 160 */           renderMapLayer(mapLayer); 
/*     */       }  return;
/*     */     } 
/* 163 */     if (mapLayers instanceof TiledMapTileLayer) {
/* 164 */       renderTileLayer((TiledMapTileLayer)mapLayers); return;
/* 165 */     }  if (mapLayers instanceof TiledMapImageLayer) {
/* 166 */       renderImageLayer((TiledMapImageLayer)mapLayers); return;
/*     */     } 
/* 168 */     renderObjects((MapLayer)mapLayers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderObjects(MapLayer paramMapLayer) {
/* 175 */     for (MapObject mapObject : paramMapLayer.getObjects()) {
/* 176 */       renderObject(mapObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderObject(MapObject paramMapObject) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderImageLayer(TiledMapImageLayer paramTiledMapImageLayer) {
/*     */     Color color;
/* 188 */     float f2 = Color.toFloatBits((color = this.batch.getColor()).r, color.g, color.b, color.a * paramTiledMapImageLayer.getOpacity());
/*     */     
/* 190 */     float[] arrayOfFloat = this.vertices;
/*     */     
/*     */     TextureRegion textureRegion;
/*     */     
/* 194 */     if ((textureRegion = paramTiledMapImageLayer.getTextureRegion()) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 198 */     float f3 = paramTiledMapImageLayer.getX();
/* 199 */     float f4 = paramTiledMapImageLayer.getY();
/* 200 */     f3 = f3 * this.unitScale - this.viewBounds.x * (paramTiledMapImageLayer.getParallaxX() - 1.0F);
/* 201 */     float f1 = f4 * this.unitScale - this.viewBounds.y * (paramTiledMapImageLayer.getParallaxY() - 1.0F);
/* 202 */     f4 = f3 + textureRegion.getRegionWidth() * this.unitScale;
/* 203 */     float f5 = f1 + textureRegion.getRegionHeight() * this.unitScale;
/*     */     
/* 205 */     this.imageBounds.set(f3, f1, f4 - f3, f5 - f1);
/*     */     
/* 207 */     if (this.viewBounds.contains(this.imageBounds) || this.viewBounds.overlaps(this.imageBounds)) {
/* 208 */       float f6 = textureRegion.getU();
/* 209 */       float f7 = textureRegion.getV2();
/* 210 */       float f8 = textureRegion.getU2();
/* 211 */       float f9 = textureRegion.getV();
/*     */       
/* 213 */       arrayOfFloat[0] = f3;
/* 214 */       arrayOfFloat[1] = f1;
/* 215 */       arrayOfFloat[2] = f2;
/* 216 */       arrayOfFloat[3] = f6;
/* 217 */       arrayOfFloat[4] = f7;
/*     */       
/* 219 */       arrayOfFloat[5] = f3;
/* 220 */       arrayOfFloat[6] = f5;
/* 221 */       arrayOfFloat[7] = f2;
/* 222 */       arrayOfFloat[8] = f6;
/* 223 */       arrayOfFloat[9] = f9;
/*     */       
/* 225 */       arrayOfFloat[10] = f4;
/* 226 */       arrayOfFloat[11] = f5;
/* 227 */       arrayOfFloat[12] = f2;
/* 228 */       arrayOfFloat[13] = f8;
/* 229 */       arrayOfFloat[14] = f9;
/*     */       
/* 231 */       arrayOfFloat[15] = f4;
/* 232 */       arrayOfFloat[16] = f1;
/* 233 */       arrayOfFloat[17] = f2;
/* 234 */       arrayOfFloat[18] = f8;
/* 235 */       arrayOfFloat[19] = f7;
/*     */       
/* 237 */       this.batch.draw(textureRegion.getTexture(), arrayOfFloat, 0, 20);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void beginRender() {
/* 243 */     AnimatedTiledMapTile.updateAnimationBaseTime();
/* 244 */     this.batch.begin();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void endRender() {
/* 249 */     this.batch.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 254 */     if (this.ownsBatch)
/* 255 */       this.batch.dispose(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\renderers\BatchTiledMapRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */