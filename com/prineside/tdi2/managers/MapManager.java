/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.glutils.FrameBuffer;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.CameraController;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.IntRectangle;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ @REGS(serializer = MapManager.Serializer.class)
/*     */ public class MapManager extends Manager.ManagerAdapter {
/*     */   public static final int PREVIEW_WIDTH = 310;
/*     */   public static final int PREVIEW_HEIGHT = 230;
/*  39 */   private static final TLog a = TLog.forClass(MapManager.class); private OrthographicCamera b; private CameraController c; private FrameBuffer d; private Pixmap e; public ParticleEffectPool highlightParticlesPool; public ParticleEffectPool coreHighlightParticlesPool;
/*     */   public ParticleEffectPool tileWarningParticlePool;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<MapManager> { public MapManager read() {
/*  43 */       return Game.i.mapManager;
/*     */     } }
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
/*  58 */   private final Array<WeakReference<MapPreview>> f = new Array(false, 1, WeakReference.class);
/*  59 */   private final Array<MapPreview> g = new Array(MapPreview.class);
/*     */   
/*     */   public MapManager() {
/*  62 */     if (Game.i.assetManager != null) {
/*  63 */       this.highlightParticlesPool = Game.i.assetManager.getParticleEffectPool("highlight.prt");
/*  64 */       this.coreHighlightParticlesPool = Game.i.assetManager.getParticleEffectPool("core-highlight.prt");
/*  65 */       this.tileWarningParticlePool = Game.i.assetManager.getParticleEffectPool("tile-warning.prt");
/*     */     } 
/*     */   }
/*     */   
/*     */   public MapPreview generatePreview(Map paramMap) {
/*  70 */     Preconditions.checkNotNull(paramMap, "Map can not be null");
/*     */     
/*  72 */     MapPreview mapPreview = new MapPreview(paramMap, (byte)0);
/*  73 */     this.g.add(mapPreview);
/*  74 */     return mapPreview;
/*     */   }
/*     */   
/*     */   public void unloadMapPreviews() {
/*  78 */     this.g.clear();
/*     */     
/*  80 */     for (byte b = 0; b < this.f.size; b++) {
/*     */       MapPreview mapPreview;
/*  82 */       if ((mapPreview = ((WeakReference<MapPreview>)this.f.get(b)).get()) != null) {
/*  83 */         mapPreview.dispose();
/*     */       }
/*     */     } 
/*  86 */     this.f.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void postRender(float paramFloat) {
/*  91 */     if (this.g.size != 0) {
/*  92 */       MapPreview mapPreview = (MapPreview)this.g.removeIndex(0);
/*     */       try {
/*  94 */         mapPreview.generate();
/*  95 */       } catch (Exception exception) {
/*  96 */         a.e("failed to generate map preview", new Object[] { exception });
/*     */       } 
/*  98 */       this.f.add(new WeakReference<>(mapPreview));
/*     */     } 
/*     */   }
/*     */   
/*     */   public class MapPreview implements Disposable {
/*     */     private final TextureRegion a;
/*     */     private Texture b;
/*     */     private Map c;
/*     */     private boolean d;
/*     */     
/*     */     private MapPreview(MapManager this$0, Map param1Map) {
/* 109 */       Preconditions.checkNotNull(param1Map, "Map can not be null");
/* 110 */       this.c = param1Map;
/*     */       
/* 112 */       this.a = new TextureRegion((TextureRegion)Game.i.assetManager.getTextureRegion("map-preview-placeholder"));
/*     */     }
/*     */     
/*     */     public boolean isDisposed() {
/* 116 */       return this.d;
/*     */     }
/*     */     
/*     */     public TextureRegion getTextureRegion() {
/* 120 */       return this.a;
/*     */     }
/*     */     
/*     */     public void generate() {
/* 124 */       if (this.c == null)
/*     */         return; 
/* 126 */       long l = Game.getRealTickCount();
/*     */       
/* 128 */       if (MapManager.a(this.e) == null) {
/* 129 */         MapManager.a(this.e, new FrameBuffer(Pixmap.Format.RGBA8888, 310, 230, false));
/*     */       }
/*     */       
/*     */       IntRectangle intRectangle;
/* 133 */       int i = (intRectangle = this.c.getTrimBounds()).maxX - intRectangle.minX + 1;
/* 134 */       int j = intRectangle.maxY - intRectangle.minY + 1;
/*     */       
/* 136 */       if (MapManager.b(this.e) == null) {
/* 137 */         MapManager.a(this.e, new OrthographicCamera(310.0F, 230.0F));
/* 138 */         MapManager.a(this.e, new CameraController(MapManager.b(this.e), 1, 1));
/*     */       } 
/*     */       
/* 141 */       SpriteBatch spriteBatch = Game.i.renderingManager.batch;
/* 142 */       MapManager.c(this.e).setScreenSize(310, 230);
/* 143 */       MapManager.c(this.e).setMapSize(i << 7, j << 7);
/*     */       
/* 145 */       MapManager.c(this.e).setZoomBoundaries(0.001F, 1000.0F);
/* 146 */       MapManager.c(this.e).fitMapToScreen(10.0F);
/*     */       
/* 148 */       MapManager.a(this.e).begin();
/* 149 */       Gdx.gl.glBlendFunc(770, 771);
/* 150 */       Gdx.gl.glClearColor(Config.BACKGROUND_COLOR.r, Config.BACKGROUND_COLOR.g, Config.BACKGROUND_COLOR.b, Config.BACKGROUND_COLOR.a);
/* 151 */       Gdx.gl.glClear(16384);
/* 152 */       Gdx.gl.glEnable(3042);
/*     */       
/* 154 */       spriteBatch.begin();
/* 155 */       spriteBatch.setProjectionMatrix((MapManager.b(this.e)).combined);
/*     */ 
/*     */       
/* 158 */       for (Array.ArrayIterator<Tile> arrayIterator2 = this.c.getAllTiles().iterator(); arrayIterator2.hasNext(); ) { Tile tile = arrayIterator2.next();
/* 159 */         spriteBatch.setColor(Color.WHITE);
/* 160 */         tile.drawStatic((Batch)spriteBatch, (tile.getX() - intRectangle.minX << 7), (tile.getY() - intRectangle.minY << 7), 128.0F, 128.0F, this.c, MapRenderingSystem.DrawMode.DETAILED);
/* 161 */         spriteBatch.setColor(Color.WHITE);
/* 162 */         tile.drawExtras((Batch)spriteBatch, (tile.getX() - intRectangle.minX << 7), (tile.getY() - intRectangle.minY << 7), 128.0F, 128.0F, MapRenderingSystem.DrawMode.DETAILED);
/*     */         PlatformTile platformTile;
/* 164 */         if (tile.type == TileType.PLATFORM && 
/*     */           
/* 166 */           (platformTile = (PlatformTile)tile).building != null) {
/* 167 */           spriteBatch.setColor(Color.WHITE);
/* 168 */           platformTile.building.drawBase((Batch)spriteBatch, (tile.getX() - intRectangle.minX << 7), (tile.getY() - intRectangle.minY << 7), 128.0F, 128.0F, MapRenderingSystem.DrawMode.DEFAULT);
/*     */         }  }
/*     */ 
/*     */       
/*     */       byte b2;
/*     */       
/* 174 */       label89: for (b2 = 0; b2 <= this.c.getHeight(); exception++) {
/* 175 */         for (j = 0; j <= this.c.getWidth(); j++) {
/* 176 */           boolean[] arrayOfBoolean; byte b; for (arrayOfBoolean = new boolean[] { false, true }, b = 0; b < 2; ) { boolean bool = arrayOfBoolean[b];
/*     */             Gate gate;
/* 178 */             if ((gate = this.c.getGate(j, b2, bool)) != null) {
/*     */               
/*     */               try {
/* 181 */                 spriteBatch.setColor(Color.WHITE);
/* 182 */                 gate.drawStatic((Batch)spriteBatch, (j - intRectangle.minX << 7), (b2 - intRectangle.minY << 7), 128.0F, 128.0F);
/* 183 */               } catch (Exception exception) {
/* 184 */                 MapManager.a().e("stopped preview generation", new Object[] { exception });
/*     */                 break label89;
/*     */               } 
/*     */             }
/*     */             b++; }
/*     */         
/*     */         } 
/*     */       } 
/* 192 */       for (Array.ArrayIterator<Tile> arrayIterator1 = this.c.getAllTiles().iterator(); arrayIterator1.hasNext(); ) { Tile tile = arrayIterator1.next();
/* 193 */         spriteBatch.setColor(Color.WHITE);
/* 194 */         tile.drawBatch((Batch)spriteBatch, 0.0F, (tile.getX() - intRectangle.minX << 7), (tile.getY() - intRectangle.minY << 7), 128.0F, 128.0F, MapRenderingSystem.DrawMode.DETAILED);
/* 195 */         tile.postDrawBatch((Batch)spriteBatch, 0.0F, (tile.getX() - intRectangle.minX << 7), (tile.getY() - intRectangle.minY << 7), 128.0F, 128.0F, MapRenderingSystem.DrawMode.DETAILED);
/*     */         
/* 197 */         if (tile.type == TileType.PLATFORM) {
/*     */           PlatformTile platformTile;
/* 199 */           if ((platformTile = (PlatformTile)tile).building != null && 
/* 200 */             platformTile.building.buildingType == BuildingType.TOWER) {
/*     */             Tower tower;
/* 202 */             (tower = (Tower)platformTile.building).drawWeapon((Batch)spriteBatch, (tile.getX() - intRectangle.minX << 7), (tile.getY() - intRectangle.minY << 7), 128.0F, 0.0F);
/*     */           }  continue;
/*     */         }  SourceTile sourceTile;
/* 205 */         if (tile.type == TileType.SOURCE && 
/*     */           
/* 207 */           (sourceTile = (SourceTile)tile).miner != null) {
/* 208 */           sourceTile.miner.drawBatch((Batch)spriteBatch, (tile.getX() - intRectangle.minX << 7), (tile.getY() - intRectangle.minY << 7), 128.0F, 0.0F, MapRenderingSystem.DrawMode.DEFAULT);
/*     */         } }
/*     */ 
/*     */       
/* 212 */       for (byte b1 = 0; b1 <= this.c.getHeight(); b1++) {
/* 213 */         for (j = 0; j <= this.c.getWidth(); j++) {
/* 214 */           boolean[] arrayOfBoolean; byte b; for (arrayOfBoolean = new boolean[] { false, true }, b = 0; b < 2; ) { boolean bool = arrayOfBoolean[b];
/*     */             Gate gate;
/* 216 */             if ((gate = this.c.getGate(j, b1, bool)) != null)
/*     */             {
/* 218 */               gate.drawBatch((Batch)spriteBatch, 0.0F, (j - intRectangle.minX << 7), (b1 - intRectangle.minY << 7), 128.0F, 128.0F); }  b++; }
/*     */         
/*     */         } 
/*     */       } 
/* 222 */       spriteBatch.end();
/*     */       
/* 224 */       this.c.hashCode();
/* 225 */       this.c = null;
/*     */       
/*     */       try {
/* 228 */         Gdx.gl.glPixelStorei(3333, 1);
/*     */         
/* 230 */         if (MapManager.d(this.e) == null) {
/* 231 */           MapManager.a(this.e, new Pixmap(310, 230, Pixmap.Format.RGBA8888));
/*     */         }
/* 233 */         ByteBuffer byteBuffer = MapManager.d(this.e).getPixels();
/* 234 */         Gdx.gl.glReadPixels(0, 0, 310, 230, 6408, 5121, byteBuffer);
/*     */       
/*     */       }
/* 237 */       catch (Exception exception) {}
/*     */ 
/*     */       
/* 240 */       MapManager.a(this.e).end();
/*     */       
/* 242 */       if (MapManager.d(this.e) != null) {
/* 243 */         if (this.b != null) {
/* 244 */           this.b.dispose();
/*     */         }
/* 246 */         this.b = new Texture(this, MapManager.d(this.e))
/*     */           {
/*     */             private boolean a = false;
/*     */             
/*     */             public void finalize() {
/* 251 */               super.finalize();
/*     */               
/* 253 */               MapManager.MapPreview.a(this.b, true);
/* 254 */               if (this.a) {
/*     */                 return;
/*     */               }
/*     */               try {
/* 258 */                 if (Game.i.isInMainThread()) {
/*     */                   
/* 260 */                   MapManager.MapPreview.a(this.b).dispose();
/* 261 */                   MapManager.MapPreview.a(this.b, (Texture)null);
/*     */                 } else {
/*     */                   
/* 264 */                   null  = this;
/* 265 */                   this.a = true;
/* 266 */                   MapManager.MapPreview.a(this.b, (Texture)null);
/*     */                   
/* 268 */                   Gdx.app.postRunnable(() -> {
/*     */                         try {
/*     */                           param2Texture.dispose();
/*     */                           return;
/* 272 */                         } catch (Exception exception) {
/*     */                           MapManager.a().e("failed to dispose texture in runnable", new Object[] { exception }); return;
/*     */                         } 
/*     */                       });
/*     */                 } 
/* 277 */                 MapManager.MapPreview.b(this.b).setRegion((TextureRegion)Game.i.assetManager.getTextureRegion("map-preview-placeholder")); return;
/* 278 */               } catch (Exception exception) {
/* 279 */                 MapManager.a().e("failed to finalize map preview texture", new Object[] { exception });
/*     */                 return;
/*     */               }  }
/*     */           };
/* 283 */         this.b.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/*     */         
/* 285 */         this.a.setU(0.002F);
/* 286 */         this.a.setV(0.998F);
/* 287 */         this.a.setU2(0.998F);
/* 288 */         this.a.setV2(0.002F);
/* 289 */         this.a.setTexture(this.b);
/*     */         
/* 291 */         if (Game.i.debugManager != null) Game.i.debugManager.registerFrameJob("MapManager-generatePreview", Game.getRealTickCount() - l); 
/*     */       } 
/*     */     }
/*     */     
/*     */     public void dispose() {
/* 296 */       if (this.b != null) {
/* 297 */         this.b.dispose();
/* 298 */         this.b = null;
/*     */       } 
/* 300 */       this.d = true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\MapManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */