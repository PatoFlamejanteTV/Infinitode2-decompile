/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.game.BuildingRemove;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.MapDrawModeChange;
/*     */ import com.prineside.tdi2.events.game.MapSizeChange;
/*     */ import com.prineside.tdi2.events.game.MinerPlace;
/*     */ import com.prineside.tdi2.events.game.MinerRemove;
/*     */ import com.prineside.tdi2.events.game.ModifierPlace;
/*     */ import com.prineside.tdi2.events.game.TileChange;
/*     */ import com.prineside.tdi2.events.game.TowerAbilityChange;
/*     */ import com.prineside.tdi2.events.game.TowerAimStrategyChange;
/*     */ import com.prineside.tdi2.events.game.TowerLevelUp;
/*     */ import com.prineside.tdi2.events.game.TowerPlace;
/*     */ import com.prineside.tdi2.events.game.TowerUpgrade;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.SpriteCacheExtended;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @NAGS
/*     */ public final class MapRenderingSystem extends GameSystem {
/*  47 */   private static final TLog a = TLog.forClass(MapRenderingSystem.class);
/*     */   
/*     */   public static final String CACHED_GFX_LAYER_TILES = "MapRenderingSystem_Tiles";
/*     */   
/*     */   public static final String CACHED_GFX_LAYER_TILE_EXTRAS = "MapRenderingSystem_TileExtras";
/*     */   
/*     */   public static final String CACHED_GFX_LAYER_BUILDINGS = "MapRenderingSystem_Buildings";
/*     */ 
/*     */   
/*     */   public enum DrawMode
/*     */   {
/*  58 */     DEFAULT,
/*  59 */     DETAILED,
/*  60 */     MAP_EDITOR,
/*  61 */     FULL; static {
/*     */     
/*  63 */     } public static final DrawMode[] values = values();
/*     */   }
/*     */ 
/*     */   
/*  67 */   public final ObjectSet<SpaceTileBonusType> spaceTileBonusesToDrawColoredOnFreeTiles = new ObjectSet();
/*     */ 
/*     */   
/*     */   private boolean b;
/*     */ 
/*     */   
/*     */   private DrawMode c;
/*     */   
/*     */   public boolean drawMapGrid = false;
/*     */   
/*  77 */   private SplatConfig[] d = new SplatConfig[1024];
/*  78 */   private SplatConfig[] e = new SplatConfig[256];
/*  79 */   private int f = 0;
/*  80 */   private int g = 0;
/*     */   private TextureRegion[] h;
/*     */   private int i;
/*  83 */   private Color j = new Color();
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean profileUpdate() {
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public final String getSystemName() {
/*  95 */     return "MapRendering";
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 100 */     this.S.events.getListeners(EnemyDie.class).add(paramEnemyDie -> {
/*     */           if (Game.i.settingsManager.isStainsEnabled()) {
/*     */             SplatConfig splatConfig;
/*     */ 
/*     */             
/*     */             if ((splatConfig = this.d[this.g]) == null) {
/*     */               splatConfig = new SplatConfig((byte)0);
/*     */               
/*     */               this.d[this.g] = splatConfig;
/*     */             } 
/*     */             
/*     */             Enemy enemy = paramEnemyDie.getLastDamage().getEnemy();
/*     */             
/*     */             this.j.set(enemy.getColor());
/*     */             
/*     */             this.j.lerp(0.0F, 0.0F, 0.0F, 1.0F, FastRandom.getFloat() * 0.14F);
/*     */             
/*     */             this.j.a = 0.5F;
/*     */             
/*     */             SplatConfig.a(splatConfig, this.j.toFloatBits());
/*     */             
/*     */             SplatConfig.b(splatConfig, (enemy.getPosition()).x);
/*     */             
/*     */             SplatConfig.c(splatConfig, (enemy.getPosition()).y);
/*     */             
/*     */             SplatConfig.a(splatConfig, this.h[this.i++]);
/*     */             
/*     */             if (this.i == this.h.length) {
/*     */               this.i = 0;
/*     */             }
/*     */             
/*     */             this.g++;
/*     */             
/*     */             if (this.g == 1024) {
/*     */               if (1024 - this.f >= 0) {
/*     */                 System.arraycopy(this.d, 0, this.e, 0, this.e.length);
/*     */                 
/*     */                 System.arraycopy(this.d, this.f + 1, this.d, 0, 768);
/*     */                 
/*     */                 System.arraycopy(this.e, 0, this.d, 768, this.e.length);
/*     */               } 
/*     */               
/*     */               this.g = 768;
/*     */               
/*     */               this.f = 0;
/*     */             } 
/*     */             
/*     */             if (this.g - this.f == 769) {
/*     */               this.f++;
/*     */             }
/*     */           } 
/*     */         });
/*     */     
/* 153 */     if (Game.i.assetManager != null) {
/* 154 */       this.h = new TextureRegion[3];
/* 155 */       this.h[0] = (TextureRegion)Game.i.assetManager.getTextureRegion("splatter-1");
/* 156 */       this.h[1] = (TextureRegion)Game.i.assetManager.getTextureRegion("splatter-2");
/* 157 */       this.h[2] = (TextureRegion)Game.i.assetManager.getTextureRegion("splatter-3");
/*     */     } 
/*     */     
/* 160 */     this.c = (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.UI_DETAILED_MODE_ENABLED) == 0.0D) ? DrawMode.DEFAULT : DrawMode.DETAILED;
/* 161 */     a.i("setting draw mode to " + this.c, new Object[0]);
/*     */     
/* 163 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MAP_DRAW_TILES, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawTiles(this.S._render.getCamera())))
/*     */ 
/*     */         
/* 166 */         .setName("MapRendering-drawTiles"));
/*     */     
/* 168 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MAP_DRAW_BUILDINGS_CACHE, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawBuildings(this.S._render.getCamera())))
/*     */ 
/*     */         
/* 171 */         .setName("MapRendering-drawBuildings"));
/*     */     
/* 173 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MAP_DRAW_STAINS, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */ 
/*     */ 
/*     */             
/*     */             if (Game.i.settingsManager.isStainsEnabled()) {
/*     */               drawStains(paramBatch);
/*     */             }
/* 180 */           })).setName("MapRendering-drawStains"));
/*     */     
/* 182 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MAP_DRAW_TILE_EXTRAS, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawTilesExtras(this.S._render.getCamera())))
/*     */ 
/*     */         
/* 185 */         .setName("MapRendering-drawTilesExtras"));
/*     */     
/* 187 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MAP_DRAW_BATCH, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawBatch(paramBatch, paramFloat2)))
/*     */ 
/*     */         
/* 190 */         .setName("MapRendering-drawBatch"));
/*     */     
/* 192 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MAP_RENDERING_POST_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> postDrawBatch(paramBatch, paramFloat2)))
/*     */ 
/*     */         
/* 195 */         .setName("MapRendering-postDrawBatch"));
/*     */     
/* 197 */     this.S.events.getListeners(TowerPlace.class).add(paramTowerPlace -> {
/*     */           forceTilesRedraw(false);
/*     */           forceBuildingsRedraw();
/* 200 */         }).setDescription("MapRenderingSystem - forces tiles redraw");
/*     */     
/* 202 */     this.S.events.getListeners(TowerAimStrategyChange.class).add(paramTowerAimStrategyChange -> forceBuildingsRedraw())
/*     */       
/* 204 */       .setDescription("MapRenderingSystem - forces towers redraw");
/*     */     
/* 206 */     this.S.events.getListeners(ModifierPlace.class).add(paramModifierPlace -> {
/*     */           forceTilesRedraw(false);
/*     */           forceBuildingsRedraw();
/* 209 */         }).setDescription("MapRenderingSystem - forces tiles redraw");
/*     */     
/* 211 */     this.S.events.getListeners(MinerPlace.class).add(paramMinerPlace -> {
/*     */           forceTilesRedraw(false);
/*     */           forceBuildingsRedraw();
/* 214 */         }).setDescription("MapRenderingSystem - forces tiles redraw");
/*     */     
/* 216 */     this.S.events.getListeners(MinerRemove.class).add(paramMinerRemove -> {
/*     */           forceTilesRedraw(false);
/*     */           forceBuildingsRedraw();
/* 219 */         }).setDescription("MapRenderingSystem - forces tiles redraw");
/*     */     
/* 221 */     this.S.events.getListeners(BuildingRemove.class).add(paramBuildingRemove -> {
/*     */           forceTilesRedraw(false);
/*     */           forceBuildingsRedraw();
/* 224 */         }).setDescription("MapRenderingSystem - forces tiles redraw");
/*     */     
/* 226 */     this.S.events.getListeners(TileChange.class).add(paramTileChange -> {
/*     */           forceTilesRedraw(true);
/*     */           forceBuildingsRedraw();
/* 229 */         }).setDescription("MapRenderingSystem - forces redraw");
/*     */     
/* 231 */     this.S.events.getListeners(MapSizeChange.class).add(paramMapSizeChange -> {
/*     */           forceTilesRedraw(true);
/*     */           forceBuildingsRedraw();
/* 234 */         }).setDescription("MapRenderingSystem - forces redraw");
/*     */     
/* 236 */     this.S.events.getListeners(TowerUpgrade.class).add(paramTowerUpgrade -> forceBuildingsRedraw())
/*     */       
/* 238 */       .setDescription("MapRenderingSystem");
/*     */     
/* 240 */     this.S.events.getListeners(TowerLevelUp.class).add(paramTowerLevelUp -> forceBuildingsRedraw())
/*     */       
/* 242 */       .setDescription("MapRenderingSystem");
/*     */     
/* 244 */     this.S.events.getListeners(TowerAbilityChange.class).add(paramTowerAbilityChange -> forceBuildingsRedraw())
/*     */       
/* 246 */       .setDescription("MapRenderingSystem");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void switchMapDrawMode() {
/* 253 */     if (this.c == DrawMode.DEFAULT) {
/* 254 */       setDrawMode(DrawMode.DETAILED);
/*     */     } else {
/* 256 */       setDrawMode(DrawMode.DEFAULT);
/*     */     } 
/* 258 */     Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.UI_DETAILED_MODE_ENABLED, (this.c == DrawMode.DETAILED) ? 1.0D : 0.0D);
/*     */   }
/*     */   
/*     */   public final DrawMode getDrawMode() {
/* 262 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void forceBuildingsRedraw() {
/* 266 */     this.S._cachedRendering.setLayerDirty("MapRenderingSystem_Buildings");
/*     */   }
/*     */   
/*     */   public final void forceTilesRedraw(boolean paramBoolean) {
/* 270 */     if (paramBoolean) this.S._cachedRendering.setLayerDirty("MapRenderingSystem_Tiles"); 
/* 271 */     this.S._cachedRendering.setLayerDirty("MapRenderingSystem_TileExtras");
/*     */   }
/*     */   
/*     */   public final void setDrawMode(DrawMode paramDrawMode) {
/* 275 */     this.c = paramDrawMode;
/* 276 */     if (this.S._cachedRendering != null) {
/* 277 */       forceTilesRedraw(true);
/* 278 */       forceBuildingsRedraw();
/*     */     } 
/* 280 */     this.S.events.trigger((Event)new MapDrawModeChange());
/*     */   }
/*     */   
/*     */   private void a() {
/*     */     SpriteCacheExtended.CacheArray cacheArray;
/* 285 */     SpriteCacheExtended spriteCacheExtended = (cacheArray = this.S._cachedRendering.getOrAddLayer("MapRenderingSystem_Buildings", 8191, null, true)).start();
/*     */     
/*     */     Map map;
/*     */     
/*     */     Array.ArrayIterator<PlatformTile> arrayIterator;
/* 290 */     for (arrayIterator = (map = this.S.map.getMap()).getTilesByType(PlatformTile.class).iterator(); arrayIterator.hasNext();) {
/* 291 */       if ((platformTile = arrayIterator.next()).building != null) {
/* 292 */         platformTile.building.drawBase((Batch)spriteCacheExtended, (platformTile.getX() << 7), (platformTile.getY() << 7), 128.0F, 128.0F, this.c);
/* 293 */         spriteCacheExtended = cacheArray.swapCachesIfFull();
/*     */       } 
/*     */     } 
/* 296 */     for (arrayIterator = map.getTilesByType(SourceTile.class).iterator(); arrayIterator.hasNext();) {
/* 297 */       if ((sourceTile = (SourceTile)arrayIterator.next()).miner != null) {
/* 298 */         sourceTile.miner.drawBase((Batch)spriteCacheExtended, (sourceTile.getX() << 7), (sourceTile.getY() << 7), 128.0F, 128.0F, this.c);
/* 299 */         spriteCacheExtended = cacheArray.swapCachesIfFull();
/*     */       } 
/*     */     } 
/* 302 */     cacheArray.end();
/* 303 */     cacheArray.dirty = false;
/*     */   }
/*     */   
/*     */   private void b() {
/* 307 */     long l = Game.getRealTickCount();
/*     */     
/*     */     SpriteCacheExtended.CacheArray cacheArray;
/* 310 */     SpriteCacheExtended spriteCacheExtended = (cacheArray = this.S._cachedRendering.getOrAddLayer("MapRenderingSystem_Tiles", 8191, null, true)).start();
/*     */     
/* 312 */     Map map = this.S.map.getMap();
/* 313 */     if (this.drawMapGrid) {
/* 314 */       ResourcePack.AtlasTextureRegion atlasTextureRegion = (AssetManager.TextureRegions.i()).blank;
/*     */       byte b;
/*     */       int i;
/* 317 */       for (b = 1, i = map.getHeight(); b < i; b++) {
/* 318 */         if (b % 10 == 0) {
/* 319 */           spriteCacheExtended.setColor(MaterialColor.BLUE_GREY.P800);
/*     */         } else {
/* 321 */           spriteCacheExtended.setColor(MaterialColor.BLUE_GREY.P900);
/*     */         } 
/* 323 */         spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, 0.0F, (b << 7) - 2.0F, (map.getWidth() << 7), 4.0F);
/*     */       } 
/*     */       
/* 326 */       for (b = 1, i = map.getWidth(); b < i; b++) {
/* 327 */         if (b % 10 == 0) {
/* 328 */           spriteCacheExtended.setColor(MaterialColor.BLUE_GREY.P800);
/*     */         } else {
/* 330 */           spriteCacheExtended.setColor(MaterialColor.BLUE_GREY.P900);
/*     */         } 
/* 332 */         spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, (b << 7) - 2.0F, 0.0F, 4.0F, (map.getHeight() << 7));
/*     */       } 
/*     */ 
/*     */       
/* 336 */       spriteCacheExtended.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 337 */       spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, -16.0F, -16.0F, 16.0F, (map.getHeight() << 7) + 32.0F);
/* 338 */       spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, (map.getWidth() << 7), -16.0F, 16.0F, (map.getHeight() << 7) + 32.0F);
/* 339 */       spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, 0.0F, -16.0F, (map.getWidth() << 7), 16.0F);
/* 340 */       spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, 0.0F, (map.getHeight() << 7), (map.getWidth() << 7), 16.0F);
/*     */       
/* 342 */       spriteCacheExtended.setColor(MaterialColor.BLUE_GREY.P800);
/* 343 */       spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, -8.0F, -8.0F, 8.0F, (map.getHeight() << 7) + 16.0F);
/* 344 */       spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, (map.getWidth() << 7), -8.0F, 8.0F, (map.getHeight() << 7) + 16.0F);
/* 345 */       spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, 0.0F, -8.0F, (map.getWidth() << 7), 8.0F);
/* 346 */       spriteCacheExtended.draw((TextureRegion)atlasTextureRegion, 0.0F, (map.getHeight() << 7), (map.getWidth() << 7), 8.0F);
/*     */       
/* 348 */       spriteCacheExtended.setColor(Color.WHITE);
/*     */ 
/*     */       
/* 351 */       Game.i.assetManager.getFont(24).draw((Batch)spriteCacheExtended, map.getWidth() + " x " + map.getHeight(), (map.getWidth() << 7) + 16.0F, (map.getHeight() << 7) + 32.0F, 100.0F, 12, false);
/*     */     } 
/* 353 */     spriteCacheExtended = cacheArray.swapCachesIfFull();
/*     */ 
/*     */     
/* 356 */     for (Array.ArrayIterator<Tile> arrayIterator = map.getAllTiles().iterator(); arrayIterator.hasNext(); ) {
/* 357 */       Tile tile; (tile = arrayIterator.next()).drawStatic((Batch)spriteCacheExtended, (tile.getX() << 7), (tile.getY() << 7), 128.0F, 128.0F, map, this.c);
/* 358 */       spriteCacheExtended = cacheArray.swapCachesIfFull();
/*     */     } 
/* 360 */     cacheArray.end();
/*     */     
/* 362 */     cacheArray.dirty = false;
/*     */     
/* 364 */     if (Game.i.debugManager != null) Game.i.debugManager.registerFrameJob("MapRendering-updateTilesCachedLayer", Game.getRealTickCount() - l); 
/*     */   }
/*     */   
/*     */   public final void drawTiles(OrthographicCamera paramOrthographicCamera) {
/* 368 */     if (this.b) throw new IllegalStateException("System is already disposed"); 
/* 369 */     Game.i.renderingManager.stopAnyBatchDrawing();
/*     */     
/* 371 */     if (this.S._cachedRendering.isDirty("MapRenderingSystem_Tiles")) {
/* 372 */       b();
/*     */     }
/*     */     
/*     */     SpriteCacheExtended.CacheArray cacheArray;
/* 376 */     if ((cacheArray = this.S._cachedRendering.getLayer("MapRenderingSystem_Tiles")) != null) {
/* 377 */       for (Array.ArrayIterator<SpriteCacheExtended> arrayIterator = cacheArray.getPreparedCaches().iterator(); arrayIterator.hasNext(); ) {
/* 378 */         SpriteCacheExtended spriteCacheExtended; (spriteCacheExtended = arrayIterator.next()).setProjectionMatrix(paramOrthographicCamera.combined);
/* 379 */         spriteCacheExtended.begin();
/* 380 */         Gdx.gl.glEnable(3042);
/* 381 */         spriteCacheExtended.draw(spriteCacheExtended.lastCacheId);
/* 382 */         spriteCacheExtended.end();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public final void drawBuildings(OrthographicCamera paramOrthographicCamera) {
/* 388 */     if (this.b) throw new IllegalStateException("System is already disposed"); 
/* 389 */     Game.i.renderingManager.stopAnyBatchDrawing();
/*     */     
/* 391 */     if (this.S._cachedRendering.isDirty("MapRenderingSystem_Buildings")) {
/* 392 */       a();
/*     */     }
/*     */     
/*     */     SpriteCacheExtended.CacheArray cacheArray;
/* 396 */     if ((cacheArray = this.S._cachedRendering.getLayer("MapRenderingSystem_Buildings")) != null) {
/* 397 */       for (Array.ArrayIterator<SpriteCacheExtended> arrayIterator = cacheArray.getPreparedCaches().iterator(); arrayIterator.hasNext(); ) {
/* 398 */         SpriteCacheExtended spriteCacheExtended; (spriteCacheExtended = arrayIterator.next()).setProjectionMatrix(paramOrthographicCamera.combined);
/* 399 */         spriteCacheExtended.begin();
/* 400 */         Gdx.gl.glEnable(3042);
/* 401 */         spriteCacheExtended.draw(spriteCacheExtended.lastCacheId);
/* 402 */         spriteCacheExtended.end();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public final void drawStains(Batch paramBatch) {
/* 408 */     for (int i = this.f; i < this.g; i++) {
/* 409 */       SplatConfig splatConfig = this.d[i];
/* 410 */       paramBatch.setPackedColor(SplatConfig.a(splatConfig));
/* 411 */       paramBatch.draw(SplatConfig.b(splatConfig), SplatConfig.c(splatConfig) - 20.0F, SplatConfig.d(splatConfig) - 20.0F, 40.0F, 40.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 416 */     if (this.b) throw new IllegalStateException("System is already disposed");
/*     */     
/* 418 */     if (paramFloat < 0.0F) {
/* 419 */       throw new IllegalArgumentException("deltaTime is " + paramFloat);
/*     */     }
/*     */     
/*     */     Map map;
/*     */     
/* 424 */     DelayedRemovalArray delayedRemovalArray1 = (map = this.S.map.getMap()).getAllTiles();
/* 425 */     DelayedRemovalArray delayedRemovalArray2 = map.getAllGates(); byte b; int i;
/* 426 */     for (b = 0, i = ((Array)delayedRemovalArray1).size; b < i; b++) {
/*     */       Tile tile;
/* 428 */       (tile = ((Tile[])((Array)delayedRemovalArray1).items)[b]).drawBatch(paramBatch, paramFloat, (tile.getX() << 7), (tile.getY() << 7), 128.0F, 128.0F, this.c);
/*     */     } 
/* 430 */     for (b = 0; b < ((Array)delayedRemovalArray2).size; b++) {
/*     */       Gate gate;
/* 432 */       (gate = ((Gate[])((Array)delayedRemovalArray2).items)[b]).drawBatch(paramBatch, paramFloat, (gate.getX() << 7), (gate.getY() << 7), 128.0F, 128.0F);
/*     */     } 
/*     */     
/* 435 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_TILE_POS) != 0.0D) {
/*     */       BitmapFont bitmapFont;
/*     */       
/* 438 */       (bitmapFont = Game.i.assetManager.getDebugFont(false)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 439 */       for (i = 0; i < map.getHeight(); i++) {
/* 440 */         for (byte b1 = 0; b1 < map.getWidth(); b1++) {
/*     */           Tile tile;
/* 442 */           if ((tile = map.getTile(b1, i)) != null) {
/* 443 */             bitmapFont.draw(paramBatch, tile.type.name(), (b1 << 7), (i << 7) + 20.0F + 64.0F, 128.0F, 1, false);
/*     */           }
/* 445 */           bitmapFont.draw(paramBatch, "xy " + b1 + ":" + i, (b1 << 7), (i << 7) + 10.0F + 64.0F, 128.0F, 1, false);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void postDrawBatch(Batch paramBatch, float paramFloat) {
/* 452 */     if (this.b) throw new IllegalStateException("System is already disposed");
/*     */ 
/*     */     
/*     */     Map map;
/* 456 */     DelayedRemovalArray delayedRemovalArray = (map = this.S.map.getMap()).getAllTiles(); byte b; int i;
/* 457 */     for (b = 0, i = ((Array)delayedRemovalArray).size; b < i; b++) {
/*     */       Tile tile;
/* 459 */       (tile = ((Tile[])((Array)delayedRemovalArray).items)[b]).postDrawBatch(paramBatch, paramFloat, (tile.getX() << 7), (tile.getY() << 7), 128.0F, 128.0F, this.c);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c() {
/* 464 */     Map map = this.S.map.getMap();
/*     */     
/*     */     SpriteCacheExtended.CacheArray cacheArray;
/* 467 */     SpriteCacheExtended spriteCacheExtended = (cacheArray = this.S._cachedRendering.getOrAddLayer("MapRenderingSystem_TileExtras", 8191, null, true)).start();
/*     */     
/*     */     DelayedRemovalArray delayedRemovalArray;
/*     */     
/* 471 */     for (Array.ArrayIterator<Tile> arrayIterator = (delayedRemovalArray = map.getAllTiles()).iterator(); arrayIterator.hasNext(); ) {
/* 472 */       Tile tile; (tile = arrayIterator.next()).drawExtras((Batch)spriteCacheExtended, (tile.getX() << 7), (tile.getY() << 7), 128.0F, 128.0F, this.c);
/* 473 */       spriteCacheExtended = cacheArray.swapCachesIfFull();
/*     */     } 
/*     */ 
/*     */     
/* 477 */     for (byte b = 0; b < map.getHeight() + 1; b++) {
/* 478 */       for (byte b1 = 0; b1 < map.getWidth() + 1; b1++) {
/*     */         Gate gate;
/*     */         
/* 481 */         if ((gate = map.getGate(b1, b, true)) != null)
/*     */         {
/* 483 */           gate.drawStatic((Batch)spriteCacheExtended, (b1 << 7), (b << 7), 128.0F, 128.0F);
/*     */         }
/*     */ 
/*     */         
/* 487 */         if ((gate = map.getGate(b1, b, false)) != null)
/*     */         {
/* 489 */           gate.drawStatic((Batch)spriteCacheExtended, (b1 << 7), (b << 7), 128.0F, 128.0F);
/*     */         }
/*     */         
/* 492 */         spriteCacheExtended = cacheArray.swapCachesIfFull();
/*     */       } 
/*     */     } 
/* 495 */     cacheArray.end();
/* 496 */     cacheArray.dirty = false;
/*     */   }
/*     */   
/*     */   public final void drawTilesExtras(OrthographicCamera paramOrthographicCamera) {
/* 500 */     if (this.b) throw new IllegalStateException("System is already disposed"); 
/* 501 */     Game.i.renderingManager.stopAnyBatchDrawing();
/*     */     
/* 503 */     if (this.S._cachedRendering.isDirty("MapRenderingSystem_TileExtras")) {
/* 504 */       c();
/*     */     }
/*     */     
/*     */     SpriteCacheExtended.CacheArray cacheArray;
/* 508 */     if ((cacheArray = this.S._cachedRendering.getLayer("MapRenderingSystem_TileExtras")) != null) {
/* 509 */       for (Array.ArrayIterator<SpriteCacheExtended> arrayIterator = cacheArray.getPreparedCaches().iterator(); arrayIterator.hasNext(); ) {
/* 510 */         SpriteCacheExtended spriteCacheExtended; (spriteCacheExtended = arrayIterator.next()).setProjectionMatrix(paramOrthographicCamera.combined);
/* 511 */         spriteCacheExtended.begin();
/* 512 */         Gdx.gl.glEnable(3042);
/* 513 */         spriteCacheExtended.draw(spriteCacheExtended.lastCacheId);
/* 514 */         spriteCacheExtended.end();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public final void dispose() {
/* 520 */     this.b = true;
/*     */ 
/*     */     
/* 523 */     Game.i.debugManager.unregisterValue("Tiles bake time");
/* 524 */     Game.i.debugManager.unregisterValue("Towers bake time");
/*     */     
/* 526 */     super.dispose();
/*     */   }
/*     */   
/*     */   private class SplatConfig {
/*     */     private TextureRegion a;
/*     */     private float b;
/*     */     private float c;
/*     */     private float d;
/*     */     
/*     */     private SplatConfig(MapRenderingSystem this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\MapRenderingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */