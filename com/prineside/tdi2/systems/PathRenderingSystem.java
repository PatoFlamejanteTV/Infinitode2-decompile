/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.events.game.GameResumed;
/*     */ import com.prineside.tdi2.events.game.PathfindingRebuild;
/*     */ import com.prineside.tdi2.events.game.WaveStatusChange;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.pathfinding.Path;
/*     */ import com.prineside.tdi2.pathfinding.PathSegmentForRendering;
/*     */ import com.prineside.tdi2.pathfinding.SideShift;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NAGS
/*     */ public final class PathRenderingSystem
/*     */   extends GameSystem
/*     */ {
/*     */   public boolean dontDrawOverPlatforms = false;
/*     */   private float a;
/*     */   private boolean b;
/*  41 */   private final Array<PathConfig> c = new Array(PathConfig.class);
/*  42 */   private final Pool<PathConfig> d = new Pool<PathConfig>(this, 1, 512)
/*     */     {
/*     */       private static PathRenderingSystem.PathConfig a() {
/*  45 */         return new PathRenderingSystem.PathConfig((byte)0);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private boolean e = false;
/*     */   private boolean f = false;
/*  52 */   private final TextureRegion[] g = new TextureRegion[4];
/*     */   
/*  54 */   private static final Vector2 h = new Vector2();
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  58 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  63 */     this.g[PathSegmentForRendering.Direction.TOP.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("path-arrow-up");
/*  64 */     this.g[PathSegmentForRendering.Direction.LEFT.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("path-arrow-left");
/*  65 */     this.g[PathSegmentForRendering.Direction.RIGHT.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("path-arrow-right");
/*  66 */     this.g[PathSegmentForRendering.Direction.BOTTOM.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("path-arrow-bottom");
/*     */     
/*  68 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.PATH_RENDERING_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramBatch, paramFloat2)))
/*     */ 
/*     */         
/*  71 */         .setName("PathRendering-draw"));
/*     */     
/*  73 */     this.S.events.getListeners(GameResumed.class).add(paramGameResumed -> this.e = false).setDescription("PathRenderingSystem - updates path traces rendering");
/*  74 */     this.S.events.getListeners(WaveStatusChange.class).add(paramWaveStatusChange -> this.e = false).setDescription("PathRenderingSystem - updates path traces rendering");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/*  79 */     this.S.events.getListeners(PathfindingRebuild.class).add(paramPathfindingRebuild -> { if (paramPathfindingRebuild.isDefaultPathsAffected())
/*     */             this.e = false; 
/*  81 */         }).setDescription("PathRenderingSystem");
/*     */   }
/*     */   
/*     */   public final boolean profileUpdate() {
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public final String getSystemName() {
/*  89 */     return "PathRendering";
/*     */   }
/*     */   
/*     */   public final void showAllPathTraces(boolean paramBoolean) {
/*  93 */     this.f = paramBoolean;
/*  94 */     this.e = false;
/*     */   }
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/*  98 */     if (!this.e) updatePathTracesRendering();
/*     */     
/* 100 */     if (this.c.size == 0 || Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DISABLE_PATH_RENDERING) == 1.0D) {
/* 101 */       this.a = 0.0F;
/*     */       
/*     */       return;
/*     */     } 
/* 105 */     if (this.b) {
/* 106 */       this.a -= paramFloat;
/* 107 */       if (this.a <= 0.0F) {
/* 108 */         this.b = false;
/* 109 */         this.a = 0.0F;
/*     */         
/* 111 */         for (b1 = 0; b1 < this.c.size; b1++) {
/* 112 */           this.d.free(((PathConfig[])this.c.items)[b1]);
/*     */         }
/* 114 */         this.c.clear();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } else {
/* 119 */       this.a += b1;
/* 120 */       if (this.a > 0.66F) this.a = 0.66F;
/*     */     
/*     */     } 
/* 123 */     byte b1 = b1;
/*     */     
/* 125 */     paramBatch.setColor(1.0F, 1.0F, 1.0F, this.a);
/*     */     
/* 127 */     boolean bool = false;
/* 128 */     for (byte b2 = 0; b2 < this.c.size; b2++) {
/*     */       PathConfig pathConfig;
/*     */       
/* 131 */       if ((pathConfig = ((PathConfig[])this.c.items)[b2]).e != null)
/*     */       {
/* 133 */         if (!bool) {
/*     */ 
/*     */           
/* 136 */           pathConfig.f = pathConfig.e.getPositionSimpleSegmentsForGraphics(pathConfig.d, pathConfig.g);
/* 137 */           pathConfig.h = pathConfig.e.passesThroughTileType(this.S.map.getMap(), TileType.PLATFORM);
/* 138 */           pathConfig.e = null;
/* 139 */           bool = true;
/*     */         } else {
/*     */           continue;
/* 142 */         }  }  if (!this.dontDrawOverPlatforms || !pathConfig.h) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 149 */         pathConfig.a += b1;
/* 150 */         if (pathConfig.a >= 1.0F) {
/* 151 */           pathConfig.a--;
/* 152 */           pathConfig.b++;
/*     */         } 
/*     */         
/* 155 */         float f = pathConfig.a * 32.0F;
/* 156 */         byte b = 0;
/* 157 */         int i = pathConfig.b;
/* 158 */         while (f < pathConfig.f) {
/* 159 */           PathSegmentForRendering pathSegmentForRendering = ((PathSegmentForRendering[])pathConfig.g.items)[0];
/* 160 */           for (byte b3 = b; b3 < pathConfig.g.size; f2++) {
/* 161 */             float f2; pathSegmentForRendering = ((PathSegmentForRendering[])pathConfig.g.items)[b3];
/*     */             float f3;
/* 163 */             if ((f3 = f - pathSegmentForRendering.distanceFromStart) < pathSegmentForRendering.length) {
/*     */               
/* 165 */               f2 = f3 / pathSegmentForRendering.length;
/* 166 */               h.x = pathSegmentForRendering.x1 + (pathSegmentForRendering.x2 - pathSegmentForRendering.x1) * f2;
/* 167 */               h.y = pathSegmentForRendering.y1 + (pathSegmentForRendering.y2 - pathSegmentForRendering.y1) * f2;
/*     */               
/*     */               break;
/*     */             } 
/*     */             
/* 172 */             float f1 = f2;
/*     */           } 
/*     */ 
/*     */           
/* 176 */           if (i % 4 == 0) {
/* 177 */             paramBatch.draw(pathConfig.c, h.x - 11.2F, h.y - 11.2F, 22.4F, 22.4F);
/*     */           } else {
/* 179 */             paramBatch.draw(this.g[pathSegmentForRendering.direction.ordinal()], h.x - 6.0F, h.y - 6.0F, 12.0F, 12.0F);
/*     */           } 
/* 181 */           f += 32.0F;
/* 182 */           i--;
/*     */         } 
/*     */       }  continue;
/* 185 */     }  paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */   
/*     */   public final void setPaths(Array<PathEnemyPair> paramArray) {
/* 189 */     if (paramArray.size == 0) {
/* 190 */       removePaths();
/*     */       
/*     */       return;
/*     */     } 
/* 194 */     this.b = false; int i;
/* 195 */     for (i = 0; i < this.c.size; i++) {
/* 196 */       this.d.free(((PathConfig[])this.c.items)[i]);
/*     */     }
/* 198 */     this.c.clear();
/*     */     
/* 200 */     i = StrictMath.min(paramArray.size, 11);
/* 201 */     int[] arrayOfInt = SideShift.SIDE_SHIFT_BY_COUNT[i];
/* 202 */     for (byte b = 0; b < i; b++) {
/* 203 */       PathEnemyPair pathEnemyPair = ((PathEnemyPair[])paramArray.items)[b];
/* 204 */       PathConfig pathConfig = (PathConfig)this.d.obtain();
/*     */ 
/*     */       
/* 207 */       float f = b / paramArray.size;
/* 208 */       pathConfig.b = FastRandom.getInt(4);
/* 209 */       pathConfig.a = f;
/*     */       
/* 211 */       pathConfig.c = (this.S.enemy == null) ? Game.i.enemyManager.getFactory(pathEnemyPair.enemyType).getTexture() : this.S.enemy.getTexture(pathEnemyPair.enemyType);
/* 212 */       pathConfig.e = pathEnemyPair.path;
/* 213 */       pathConfig.d = arrayOfInt[b];
/*     */       
/* 215 */       this.c.add(pathConfig);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void updatePathTracesRendering() {
/* 220 */     if (this.S.gameState != null && this.S.gameState.canSkipMediaUpdate())
/*     */       return; 
/* 222 */     removePaths();
/*     */     
/* 224 */     if (this.f) {
/* 225 */       Map map = this.S.map.getMap();
/* 226 */       Array<PathEnemyPair> array = new Array(PathEnemyPair.class);
/* 227 */       Array array1 = map.getTilesByType(SpawnTile.class);
/* 228 */       for (byte b = 0; b < array1.size; b++) {
/* 229 */         SpawnTile spawnTile = (SpawnTile)array1.get(b);
/* 230 */         for (byte b1 = 0; b1 < (spawnTile.getAllowedEnemies()).size; b1++) {
/* 231 */           EnemyType enemyType = ((SpawnTile.AllowedEnemyConfig)spawnTile.getAllowedEnemies().get(b1)).enemyType;
/*     */           Path path;
/* 233 */           if ((path = this.S.pathfinding.getDefaultPathWithoutStateChanges(enemyType, spawnTile)) != null) {
/*     */             PathEnemyPair pathEnemyPair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 240 */             (pathEnemyPair = new PathEnemyPair()).path = path;
/* 241 */             pathEnemyPair.enemyType = enemyType;
/* 242 */             array.add(pathEnemyPair);
/*     */           } 
/*     */         } 
/* 245 */       }  setPaths(array);
/*     */     }
/* 247 */     else if (this.S.wave != null && (
/* 248 */       this.S.wave.status == WaveSystem.Status.SPAWNED || this.S.wave.status == WaveSystem.Status.NOT_STARTED)) {
/*     */       
/* 250 */       Array<PathEnemyPair> array = new Array(PathEnemyPair.class);
/*     */       
/*     */       Map map;
/* 253 */       Array array1 = (map = this.S.map.getMap()).getTilesByType(SpawnTile.class);
/* 254 */       for (byte b = 0; b < array1.size; b++) {
/*     */         SpawnTile spawnTile;
/*     */         Array array2;
/* 257 */         if ((array2 = (Array)(spawnTile = (SpawnTile)array1.get(b)).enemySpawnQueues.get(1)).size != 0)
/*     */         {
/* 259 */           for (byte b1 = 0; b1 < array2.size; b1++) {
/* 260 */             EnemyGroup enemyGroup = (EnemyGroup)array2.get(b1);
/*     */             Path path;
/* 262 */             if ((path = this.S.pathfinding.getDefaultPath(enemyGroup.getEnemyType(), spawnTile)) == null) {
/* 263 */               throw new RuntimeException("Path is null for " + enemyGroup.getEnemyType().name() + " " + spawnTile.getX() + ":" + spawnTile.getY());
/*     */             }
/*     */             
/*     */             PathEnemyPair pathEnemyPair;
/* 267 */             (pathEnemyPair = new PathEnemyPair()).path = path;
/* 268 */             pathEnemyPair.enemyType = enemyGroup.getEnemyType();
/* 269 */             array.add(pathEnemyPair);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 274 */       setPaths(array);
/*     */     } 
/*     */ 
/*     */     
/* 278 */     this.e = true;
/*     */   }
/*     */   
/*     */   public final void removePaths() {
/* 282 */     if (this.c.size != 0) {
/* 283 */       this.b = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 289 */     this.c.clear();
/* 290 */     this.d.clear();
/*     */     
/* 292 */     super.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class PathConfig
/*     */     implements Pool.Poolable
/*     */   {
/*     */     float a;
/*     */     int b;
/*     */     TextureRegion c;
/*     */     int d;
/*     */     Path e;
/*     */     float f;
/* 305 */     Array<PathSegmentForRendering> g = new Array(PathSegmentForRendering.class);
/*     */     
/*     */     boolean h;
/*     */     
/*     */     public void reset() {
/* 310 */       this.e = null;
/* 311 */       this.h = false;
/* 312 */       this.d = 0;
/* 313 */       this.b = 0;
/* 314 */       this.c = null;
/* 315 */       this.a = 0.0F;
/* 316 */       this.g.clear();
/*     */     }
/*     */     
/*     */     private PathConfig() {}
/*     */   }
/*     */   
/*     */   public static class PathEnemyPair {
/*     */     public Path path;
/*     */     public EnemyType enemyType;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\PathRenderingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */