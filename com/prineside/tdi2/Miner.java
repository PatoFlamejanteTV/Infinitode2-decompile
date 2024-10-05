/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.abilities.LoopAbility;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.shapes.PieChart;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public abstract class Miner
/*     */   extends Registrable {
/*  40 */   private static final TLog a = TLog.forClass(Miner.class);
/*     */   
/*     */   public static final int MAX_UPGRADE_LEVEL = 10;
/*     */   
/*  44 */   private static Color b = new Color(0.56F, 0.56F, 0.56F, 1.0F);
/*     */   
/*     */   public int id;
/*     */   public MinerType type;
/*     */   private SourceTile c;
/*  49 */   public int moneySpentOn = 0;
/*     */   public float existsTime;
/*     */   public long totalScoreGained;
/*  52 */   public int[] minedResources = new int[ResourceType.values.length];
/*     */   public float lastMinedItemTime;
/*     */   private int d;
/*  55 */   public DelayedRemovalArray<Modifier> nearbyModifiers = new DelayedRemovalArray(Modifier.class);
/*     */ 
/*     */   
/*  58 */   private float e = 0.0F;
/*  59 */   private float f = 0.0F;
/*     */   
/*     */   public ResourceType nextMinedResourceType;
/*     */   public float miningTime;
/*  63 */   public float doubleSpeedTimeLeft = 0.0F;
/*     */   
/*     */   public int loopAbilityResourceBuffer;
/*     */   
/*     */   @Null
/*     */   public LoopAbility affectedByLoopAbility;
/*     */   
/*     */   @NAGS
/*  71 */   private final Array<PieChart.ChartEntryConfig> h = new Array(); @NAGS
/*     */   public ParticleEffectPool.PooledEffect doubleSpeedParticle; @NAGS
/*  73 */   private PieChart g; private static StringBuilder i = new StringBuilder();
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  77 */     super.write(paramKryo, paramOutput);
/*  78 */     paramOutput.writeVarInt(this.id, true);
/*  79 */     paramKryo.writeObjectOrNull(paramOutput, this.type, MinerType.class);
/*  80 */     paramKryo.writeObjectOrNull(paramOutput, this.c, SourceTile.class);
/*  81 */     paramOutput.writeVarInt(this.moneySpentOn, true);
/*  82 */     paramOutput.writeFloat(this.existsTime);
/*  83 */     paramOutput.writeVarLong(this.totalScoreGained, true);
/*  84 */     paramKryo.writeObjectOrNull(paramOutput, this.c, SourceTile.class);
/*  85 */     paramKryo.writeObject(paramOutput, this.minedResources);
/*  86 */     paramOutput.writeFloat(this.lastMinedItemTime);
/*  87 */     paramOutput.writeVarInt(this.d, true);
/*  88 */     paramKryo.writeObject(paramOutput, this.nearbyModifiers);
/*  89 */     paramOutput.writeFloat(this.e);
/*  90 */     paramOutput.writeFloat(this.f);
/*  91 */     paramKryo.writeObjectOrNull(paramOutput, this.nextMinedResourceType, ResourceType.class);
/*  92 */     paramOutput.writeFloat(this.miningTime);
/*  93 */     paramOutput.writeFloat(this.doubleSpeedTimeLeft);
/*  94 */     paramOutput.writeVarInt(this.loopAbilityResourceBuffer, true);
/*  95 */     paramKryo.writeClassAndObject(paramOutput, this.affectedByLoopAbility);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/* 100 */     super.read(paramKryo, paramInput);
/* 101 */     this.id = paramInput.readVarInt(true);
/* 102 */     this.type = (MinerType)paramKryo.readObjectOrNull(paramInput, MinerType.class);
/* 103 */     this.c = (SourceTile)paramKryo.readObjectOrNull(paramInput, SourceTile.class);
/* 104 */     this.moneySpentOn = paramInput.readVarInt(true);
/* 105 */     this.existsTime = paramInput.readFloat();
/* 106 */     this.totalScoreGained = paramInput.readVarLong(true);
/* 107 */     this.c = (SourceTile)paramKryo.readObjectOrNull(paramInput, SourceTile.class);
/* 108 */     this.minedResources = (int[])paramKryo.readObject(paramInput, int[].class);
/* 109 */     this.lastMinedItemTime = paramInput.readFloat();
/* 110 */     this.d = paramInput.readVarInt(true);
/* 111 */     this.nearbyModifiers = (DelayedRemovalArray<Modifier>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/* 112 */     this.e = paramInput.readFloat();
/* 113 */     this.f = paramInput.readFloat();
/* 114 */     this.nextMinedResourceType = (ResourceType)paramKryo.readObjectOrNull(paramInput, ResourceType.class);
/* 115 */     this.miningTime = paramInput.readFloat();
/* 116 */     this.doubleSpeedTimeLeft = paramInput.readFloat();
/* 117 */     this.loopAbilityResourceBuffer = paramInput.readVarInt(true);
/* 118 */     this.affectedByLoopAbility = (LoopAbility)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Miner(MinerType paramMinerType) {
/* 124 */     this.type = paramMinerType;
/*     */     
/* 126 */     for (byte b = 0; b < ResourceType.values.length; b++) {
/* 127 */       this.minedResources[b] = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 132 */     paramJson.writeValue("type", this.type.name());
/* 133 */     paramJson.writeValue("ul", Integer.valueOf(this.d));
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBase(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {}
/*     */   
/*     */   public void updateCache() {
/* 140 */     this.nearbyModifiers.clear();
/* 141 */     this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */           PlatformTile platformTile;
/*     */           if (paramTile instanceof PlatformTile && (platformTile = (PlatformTile)paramTile).building instanceof Modifier) {
/*     */             this.nearbyModifiers.add(platformTile.building);
/*     */           }
/*     */           return true;
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUpgradeLevel(int paramInt) {
/* 155 */     this.d = paramInt;
/*     */   }
/*     */   
/*     */   public int getUpgradeLevel() {
/* 159 */     return this.d;
/*     */   }
/*     */   
/*     */   public float getCurrentMiningSpeedFromSystem() {
/* 163 */     return (this.nextMinedResourceType == null || this.S == null) ? 0.0F : this.S.miner.getMiningSpeed(this, getUpgradeLevel());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInstallDuration() {
/*     */     int i;
/* 171 */     if ((i = this.S.gameValue.getIntValueSum(GameValueType.MINERS_INSTALL_DURATION, Game.i.minerManager.getInstallDurationGameValueType(this.type))) <= 0) i = 1;
/*     */     
/* 173 */     return i;
/*     */   }
/*     */   
/*     */   public int getSellPrice() {
/* 177 */     return (int)(this.moneySpentOn * 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/* 184 */     return (this.f <= 0.0F);
/*     */   }
/*     */   
/*     */   public float getPreparationProgress() {
/* 188 */     if (this.f <= 0.0F) return 1.0F;
/*     */     
/* 190 */     return 1.0F - this.f / this.e;
/*     */   }
/*     */   
/*     */   public void setInstallTime(float paramFloat) {
/* 194 */     if (paramFloat <= 0.0F || paramFloat > 1000.0F) throw new IllegalArgumentException("time is " + paramFloat);
/*     */     
/* 196 */     this.e = paramFloat;
/* 197 */     this.f = paramFloat;
/*     */   }
/*     */   
/*     */   public void reduceInstallTime(float paramFloat) {
/* 201 */     if (paramFloat <= 0.0F || paramFloat > 1000.0F) throw new IllegalArgumentException("time is " + paramFloat);
/*     */     
/* 203 */     this.f -= paramFloat;
/* 204 */     if (this.f < 0.0F) this.f = 0.0F; 
/*     */   }
/*     */   
/*     */   public float getInstallTimeLeft() {
/* 208 */     return this.f;
/*     */   }
/*     */   
/*     */   public float getVisualMiningProgress() {
/* 212 */     if (isPrepared()) {
/*     */       float f;
/* 214 */       if ((f = getCurrentMiningSpeedFromSystem()) == 0.0F) return 0.0F;
/*     */       
/* 216 */       f = 1.0F / f;
/* 217 */       return MathUtils.clamp(this.miningTime / f, 0.0F, 1.0F);
/*     */     } 
/* 219 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public SourceTile getTile() {
/* 224 */     return this.c;
/*     */   }
/*     */   
/*     */   public void setTile(SourceTile paramSourceTile) {
/* 228 */     this.c = paramSourceTile;
/*     */   }
/*     */   
/*     */   public void updatePieChart(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 232 */     if (this.g == null)
/*     */       return; 
/* 234 */     this.h.clear();
/* 235 */     SourceTile sourceTile = getTile();
/*     */     
/* 237 */     byte b = 0;
/* 238 */     int i = 0;
/*     */     
/* 240 */     if (sourceTile != null) {
/* 241 */       for (byte b1 = 0; b1 < ResourceType.values.length; b1++) {
/* 242 */         ResourceType resourceType = ResourceType.values[b1];
/*     */         int j;
/* 244 */         if ((j = sourceTile.getResourcesCount(resourceType)) > 0) {
/* 245 */           PieChart.ChartEntryConfig chartEntryConfig; i += j;
/*     */ 
/*     */           
/* 248 */           if (this.h.size < b + 1) {
/* 249 */             chartEntryConfig = new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.0F), 0.0F, 0.0F);
/* 250 */             this.h.add(chartEntryConfig);
/*     */           } else {
/* 252 */             chartEntryConfig = (PieChart.ChartEntryConfig)this.h.get(b);
/*     */           } 
/* 254 */           chartEntryConfig.setValue(j);
/* 255 */           chartEntryConfig.color = Game.i.resourceManager.getColor(resourceType);
/*     */           
/* 257 */           b++;
/*     */         } 
/*     */       } 
/* 260 */       if (sourceTile.getResourceDensity() < 1.0F) {
/*     */         PieChart.ChartEntryConfig chartEntryConfig;
/*     */         
/* 263 */         if (this.h.size < b + 1) {
/* 264 */           chartEntryConfig = new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.0F), 0.0F, 0.0F);
/* 265 */           this.h.add(chartEntryConfig);
/*     */         } else {
/* 267 */           chartEntryConfig = (PieChart.ChartEntryConfig)this.h.get(b);
/*     */         } 
/* 269 */         chartEntryConfig.setValue(i / sourceTile.getResourceDensity() * (1.0F - sourceTile.getResourceDensity()));
/* 270 */         chartEntryConfig.color = MaterialColor.GREY.P700;
/*     */         
/* 272 */         b++;
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     if (i == 0) {
/*     */       PieChart.ChartEntryConfig chartEntryConfig;
/*     */       
/* 279 */       if (this.h.size < b + 1) {
/* 280 */         chartEntryConfig = new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.0F), 0.0F, 0.0F);
/* 281 */         this.h.add(chartEntryConfig);
/*     */       } else {
/* 283 */         chartEntryConfig = (PieChart.ChartEntryConfig)this.h.get(b);
/*     */       } 
/* 285 */       chartEntryConfig.setValue(1.0F);
/* 286 */       chartEntryConfig.color = MaterialColor.GREY.P700;
/*     */       
/* 288 */       b++;
/*     */     } 
/*     */     
/* 291 */     this.h.size = b;
/*     */     
/* 293 */     this.g.setup(paramFloat1, paramFloat2, 22.0F * paramFloat3, 20, this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, MapRenderingSystem.DrawMode paramDrawMode) {
/* 298 */     if (paramDrawMode == MapRenderingSystem.DrawMode.DEFAULT) {
/* 299 */       if (this.g == null || this.g.getX() != paramFloat1 || this.g.getY() != paramFloat2) {
/* 300 */         this.g = Game.i.shapeManager.getFactory(ShapeType.PIE_CHART).obtain();
/* 301 */         updatePieChart(paramFloat1, paramFloat2, paramFloat3);
/*     */       } 
/*     */       
/* 304 */       this.g.draw(paramBatch);
/*     */       return;
/*     */     } 
/* 307 */     paramBatch.setColor(Config.BACKGROUND_COLOR);
/* 308 */     paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), paramFloat1 - 22.0F * paramFloat3, paramFloat2 - 22.0F * paramFloat3, 44.0F * paramFloat3, 44.0F * paramFloat3);
/* 309 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void b(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, MapRenderingSystem.DrawMode paramDrawMode) {
/* 314 */     paramFloat3 /= 128.0F;
/*     */     
/* 316 */     if (paramDrawMode == MapRenderingSystem.DrawMode.DETAILED || paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/* 317 */       paramBatch.setColor(b);
/*     */     }
/* 319 */     paramBatch.draw(Game.i.minerManager.getFactory(this.type).getTexture(), paramFloat1, paramFloat2, 128.0F, 128.0F);
/* 320 */     paramBatch.setColor(Color.WHITE);
/*     */     
/* 322 */     if (getTile() != null && 
/* 323 */       getTile().isDepleted()) {
/* 324 */       paramBatch.setColor(Color.BLACK);
/* 325 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).smallCircle, (paramFloat1 + 64.0F - 12.0F) * paramFloat3, (paramFloat2 + 64.0F - 12.0F) * paramFloat3, 24.0F * paramFloat3, 24.0F * paramFloat3);
/* 326 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */ 
/*     */     
/* 330 */     if (paramDrawMode == MapRenderingSystem.DrawMode.DETAILED || paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/*     */       
/* 332 */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont = Game.i.assetManager.getFont(36);
/* 333 */       i.setLength(0);
/* 334 */       i.append(this.d);
/*     */       
/* 336 */       resourcePackBitmapFont.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*     */       try {
/* 338 */         resourcePackBitmapFont.draw(paramBatch, (CharSequence)i, paramFloat1 + 3.0F * paramFloat3, paramFloat2 + 71.0F * paramFloat3, 128.0F * paramFloat3, 1, false);
/* 339 */       } catch (Exception exception) {
/* 340 */         throw new RuntimeException("Failed to draw font, content: '" + i + "'", exception);
/*     */       } 
/*     */       
/* 343 */       resourcePackBitmapFont.setColor(Color.WHITE);
/* 344 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)i, exception, paramFloat2 + 74.0F * paramFloat3, 128.0F * paramFloat3, 1, false);
/*     */     } 
/* 346 */     if (paramDrawMode == MapRenderingSystem.DrawMode.DETAILED && this.affectedByLoopAbility != null) {
/*     */       
/* 348 */       float f2 = exception + 7.0F * paramFloat3;
/* 349 */       float f1 = paramFloat2 + 85.0F * paramFloat3;
/* 350 */       paramBatch.setColor(Config.BACKGROUND_COLOR);
/* 351 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).roundedSmallRect, f2, f1, 36.0F * paramFloat3, 36.0F * paramFloat3);
/* 352 */       paramBatch.setColor(MaterialColor.GREEN.P900);
/* 353 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).iconLoop, f2, f1, 36.0F * paramFloat3, 36.0F * paramFloat3);
/* 354 */       paramBatch.setColor(Color.WHITE);
/*     */       
/* 356 */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont = Game.i.assetManager.getFont(18);
/* 357 */       StringBuilder stringBuilder = StringFormatter.compactNumber(this.loopAbilityResourceBuffer, false);
/* 358 */       resourcePackBitmapFont.setColor(Config.BACKGROUND_COLOR);
/* 359 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, f2, f1 + 25.5F * paramFloat3, 36.0F * paramFloat3, 1, false);
/* 360 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, f2, f1 + 22.5F * paramFloat3, 36.0F * paramFloat3, 1, false);
/* 361 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, f2 - 1.5F * paramFloat3, f1 + 24.0F * paramFloat3, 36.0F * paramFloat3, 1, false);
/* 362 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, f2 + 1.5F * paramFloat3, f1 + 24.0F * paramFloat3, 36.0F * paramFloat3, 1, false);
/* 363 */       resourcePackBitmapFont.setColor(MaterialColor.GREEN.P200);
/* 364 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, f2, f1 + 24.0F * paramFloat3, 36.0F * paramFloat3, 1, false);
/* 365 */       resourcePackBitmapFont.setColor(Color.WHITE);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void placedOnMap() {
/* 370 */     updatePieChart((getTile()).center.x, (getTile()).center.y, 1.0F);
/*     */   }
/*     */   
/*     */   public void removedFromMap() {}
/*     */   
/*     */   public void drawBatch(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {}
/*     */   
/*     */   public void loadFromJson(JsonValue paramJsonValue) {
/*     */     try {
/* 379 */       this.d = paramJsonValue.getInt("ul", 0); return;
/* 380 */     } catch (Exception exception) {
/* 381 */       a.e("failed to load miner from json", new Object[] { exception });
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public Miner cloneMiner() {
/*     */     Miner miner;
/* 387 */     ((Miner)(miner = (Miner)Game.i.minerManager.getFactory(this.type).create())).d = this.d;
/* 388 */     return miner;
/*     */   }
/*     */   
/*     */   public boolean sameAs(Miner paramMiner) {
/* 392 */     if (paramMiner == null) return false; 
/* 393 */     if (paramMiner.type != this.type) return false; 
/* 394 */     if (paramMiner.d != this.d) return false; 
/* 395 */     return true;
/*     */   }
/*     */   
/*     */   private Miner() {}
/*     */   
/*     */   public abstract int getBaseUpgradePrice(int paramInt);
/*     */   
/*     */   public static abstract class Factory<T extends Miner> implements Disposable { protected Factory(MinerType param1MinerType, String param1String) {
/* 403 */       this.b = param1MinerType;
/* 404 */       this.a = param1String;
/*     */     }
/*     */     
/*     */     private String a;
/*     */     private MinerType b;
/*     */     
/*     */     public abstract T create();
/*     */     
/*     */     public abstract boolean canMineResource(ResourceType param1ResourceType);
/*     */     
/*     */     public abstract int getBaseBuildPrice(GameValueProvider param1GameValueProvider);
/*     */     
/*     */     public abstract TextureRegion getTexture();
/*     */     
/*     */     public abstract float getBaseMiningSpeed(GameValueProvider param1GameValueProvider);
/*     */     
/*     */     public void setup() {
/* 421 */       if (Game.i.assetManager != null) {
/* 422 */         setupAssets();
/*     */       }
/*     */     }
/*     */     
/*     */     public String getTitle() {
/* 427 */       return Game.i.minerManager.getTitle(this.b);
/*     */     }
/*     */     
/*     */     public String getDescription() {
/* 431 */       return Game.i.localeManager.i18n.get("digs_resources_from_sources");
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {}
/*     */     
/*     */     public void dispose() {}
/*     */     
/*     */     public Actor createIconActor(float param1Float) {
/*     */       Image image;
/* 441 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable(this.a))).setSize(param1Float, param1Float);
/*     */       
/* 443 */       return (Actor)image;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Miner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */