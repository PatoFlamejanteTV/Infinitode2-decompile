/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.PredefinedCoreTileType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.CoreTile;
/*     */ import com.prineside.tdi2.utils.IntPair;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class AddRandomCoreTile extends GenericGameplayMod {
/*  36 */   private static final TLog a = TLog.forClass(AddRandomCoreTile.class);
/*     */ 
/*     */   
/*  39 */   private float b = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  50 */     super.write(paramKryo, paramOutput);
/*  51 */     paramOutput.writeFloat(this.b);
/*  52 */     paramOutput.writeVarInt(this.c, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  57 */     super.read(paramKryo, paramInput);
/*  58 */     this.b = paramInput.readFloat();
/*  59 */     this.c = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  69 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.AddRandomCoreTile");
/*     */   }
/*     */   
/*     */   public final RarityType getRarityType() {
/*  73 */     if (this.b < 1.0F)
/*  74 */       return RarityType.VERY_RARE; 
/*  75 */     if (this.b < 2.0F) {
/*  76 */       return RarityType.EPIC;
/*     */     }
/*  78 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  85 */     RarityType rarityType = getRarityType();
/*  86 */     String str = "[#" + Game.i.progressManager.getRarityColor(rarityType).toString() + "]" + Game.i.progressManager.getRarityName(rarityType) + "[]";
/*  87 */     return Game.i.localeManager.i18n.format("gmod_descr_add_random_core_tile", new Object[] { str });
/*     */   }
/*     */ 
/*     */   
/*     */   public final AddRandomCoreTile cpy() {
/*  92 */     AddRandomCoreTile addRandomCoreTile = new AddRandomCoreTile();
/*  93 */     a(addRandomCoreTile);
/*  94 */     addRandomCoreTile.b = this.b;
/*  95 */     addRandomCoreTile.c = this.c;
/*  96 */     return addRandomCoreTile;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 102 */     int j = paramGameSystemProvider.map.getMap().getWidth();
/* 103 */     int k = paramGameSystemProvider.map.getMap().getHeight();
/* 104 */     if ((paramGameSystemProvider.map.getMap().getAllTiles()).size >= j * k)
/*     */     {
/* 106 */       return true;
/*     */     }
/*     */     
/*     */     int i;
/* 110 */     if ((i = (paramGameSystemProvider.map.getMap().getTilesByType(CoreTile.class)).size) + 1 <= this.c) {
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 121 */     int j = paramGameSystemProvider.map.getMap().getWidth();
/* 122 */     int k = paramGameSystemProvider.map.getMap().getHeight();
/* 123 */     if ((paramGameSystemProvider.map.getMap().getAllTiles()).size >= j * k) {
/* 124 */       return () -> Game.i.localeManager.i18n.get("gpmod_precondition_no_empty_space_on_map");
/*     */     }
/*     */     
/*     */     int i;
/* 128 */     if ((i = (paramGameSystemProvider.map.getMap().getTilesByType(CoreTile.class)).size) + 1 <= this.c) {
/* 129 */       return null;
/*     */     }
/*     */     
/* 132 */     return () -> Game.i.localeManager.i18n.format("gpmod_precondition_add_random_core_tile", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     PredefinedCoreTileType predefinedCoreTileType;
/*     */     ObjectPair objectPair2;
/* 138 */     a.i("register rarity " + this.b, new Object[0]);
/*     */     
/* 140 */     RandomXS128 randomXS128 = paramGameSystemProvider.gameplayMod.getModRandom(9615);
/* 141 */     RarityType rarityType = getRarityType();
/*     */     
/* 143 */     switch (null.a[rarityType.ordinal()]) {
/*     */       case 1:
/* 145 */         if (randomXS128.nextFloat() >= 0.5F) {
/*     */ 
/*     */           
/* 148 */           PredefinedCoreTileType predefinedCoreTileType1 = PredefinedCoreTileType.BETA;
/*     */           break;
/*     */         } 
/*     */       
/*     */       case 2:
/* 153 */         if (randomXS128.nextFloat() < 0.5F) {
/* 154 */           PredefinedCoreTileType predefinedCoreTileType1 = PredefinedCoreTileType.DELTA; break;
/*     */         } 
/* 156 */         predefinedCoreTileType = PredefinedCoreTileType.THETA;
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/* 161 */         if (randomXS128.nextFloat() < 0.5F) {
/* 162 */           predefinedCoreTileType = PredefinedCoreTileType.ZETA; break;
/*     */         } 
/* 164 */         predefinedCoreTileType = PredefinedCoreTileType.XI;
/*     */         break;
/*     */       
/*     */       default:
/* 168 */         predefinedCoreTileType = PredefinedCoreTileType.ALPHA;
/*     */         break;
/*     */     } 
/*     */     
/* 172 */     Map map = paramGameSystemProvider.map.getMap();
/* 173 */     Array array = new Array(true, 1, ObjectPair.class);
/* 174 */     DelayedRemovalArray delayedRemovalArray = map.getAllTiles();
/* 175 */     for (byte b = 0; b < map.getHeight(); b++) {
/* 176 */       for (byte b1 = 0; b1 < map.getWidth(); b1++) {
/* 177 */         if (map.getTile(b1, b) == null) {
/*     */           
/* 179 */           float f1 = Float.MAX_VALUE;
/* 180 */           float f2 = Float.MAX_VALUE;
/* 181 */           for (byte b2 = 0; b2 < ((Array)delayedRemovalArray).size; b2++) {
/*     */             float f; Tile tile;
/* 183 */             if ((tile = ((Tile[])((Array)delayedRemovalArray).items)[b2]).type == TileType.PLATFORM) {
/* 184 */               f = PMath.getSquareDistanceBetweenPoints(b1, b, tile.getX(), tile.getY());
/* 185 */               if (f1 > f) {
/* 186 */                 f1 = f;
/*     */               }
/* 188 */             } else if (f.type == TileType.CORE) {
/* 189 */               f = PMath.getSquareDistanceBetweenPoints(b1, b, f.getX(), f.getY());
/* 190 */               if (f2 > f) {
/* 191 */                 f2 = f;
/*     */               }
/*     */             } 
/*     */           } 
/* 195 */           if (f1 > 9.61F) {
/* 196 */             if (f1 > 26.009998F) {
/*     */               
/* 198 */               f1 = 0.0F;
/*     */             } else {
/*     */               
/* 201 */               f1 = 9.61F;
/*     */             } 
/*     */           }
/* 204 */           if (f2 != Float.MAX_VALUE)
/*     */           {
/* 206 */             f1 += 1.0F / f2;
/*     */           }
/* 208 */           array.add(new ObjectPair(new IntPair(b1, b), Float.valueOf(f1)));
/*     */         } 
/*     */       } 
/*     */     } 
/* 212 */     if (array.size == 0) {
/* 213 */       a.e("registration skipped - no empty space on map", new Object[0]);
/* 214 */       return false;
/*     */     } 
/*     */     
/* 217 */     paramGameSystemProvider.TSH.sort.sort(array, (paramObjectPair1, paramObjectPair2) -> Float.compare(((Float)paramObjectPair2.second).floatValue(), ((Float)paramObjectPair1.second).floatValue()));
/*     */     
/* 219 */     ObjectPair objectPair1 = (ObjectPair)array.first();
/*     */ 
/*     */     
/* 222 */     if (array.size > 1) {
/* 223 */       for (byte b1 = 1; b1 < array.size; b1++) {
/*     */         ObjectPair objectPair;
/* 225 */         if (!((Float)(objectPair = ((ObjectPair[])array.items)[b1]).second).equals(objectPair1.second)) {
/* 226 */           array.setSize(b1);
/*     */           break;
/*     */         } 
/*     */       } 
/* 230 */       objectPair2 = (ObjectPair)array.get(randomXS128.nextInt(array.size));
/*     */     } else {
/* 232 */       objectPair2 = objectPair1;
/*     */     } 
/*     */     CoreTile coreTile;
/* 235 */     (coreTile = Game.i.tileManager.F.CORE.create()).predefinedType = predefinedCoreTileType;
/* 236 */     paramGameSystemProvider.map.getMap().setTile(((IntPair)objectPair2.first).a, ((IntPair)objectPair2.first).b, (Tile)coreTile);
/* 237 */     paramGameSystemProvider.map.registerTile((Tile)coreTile);
/* 238 */     if (paramGameSystemProvider._mapRendering != null) {
/* 239 */       paramGameSystemProvider._mapRendering.forceTilesRedraw(true);
/*     */     }
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 243 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(AddRandomCoreTile.class, paramString)) != null) {
/* 244 */       activeMod.getMod().setRegisteredPower(this.power);
/* 245 */       return false;
/*     */     } 
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 253 */     return GameplayModCategory.OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public final AddRandomCoreTile applyConfig(JsonValue paramJsonValue) {
/* 258 */     super.applyConfig(paramJsonValue);
/* 259 */     a.i("applyConfig " + this.b + " => " + paramJsonValue.getFloat("coreRarity", this.b), new Object[0]);
/* 260 */     this.b = paramJsonValue.getFloat("coreRarity", this.b);
/* 261 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 268 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 271 */       return a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/*     */       JsonValue jsonValue;
/* 278 */       float f1 = (jsonValue = param1BonusStagesConfig.getBonusConfig("AddRandomCoreTile")).getFloat("coreRarityPerStage", 0.2F);
/*     */       
/* 280 */       AddRandomCoreTile addRandomCoreTile = new AddRandomCoreTile();
/*     */ 
/*     */       
/* 283 */       float f2 = jsonValue.getFloat("maxCoresOnMap", 2.0F);
/* 284 */       float f3 = jsonValue.getFloat("maxCoresOnMapPerStage", 0.0F);
/* 285 */       AddRandomCoreTile.a(addRandomCoreTile, MathUtils.floor(f2 + f3 * (param1Int - 1) + 0.001F));
/*     */ 
/*     */       
/* 288 */       AddRandomCoreTile.a(addRandomCoreTile, jsonValue.getFloat("coreRarity", AddRandomCoreTile.a(addRandomCoreTile)));
/* 289 */       addRandomCoreTile.applyConfig(jsonValue);
/*     */       
/* 291 */       AddRandomCoreTile.a(addRandomCoreTile, AddRandomCoreTile.a(addRandomCoreTile) + f1 * (param1Int - 1));
/* 292 */       logger.i("must be rarity " + AddRandomCoreTile.a(addRandomCoreTile), new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 301 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(addRandomCoreTile, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.4F)).setPowerUpProbabilityMultiplier(0.1F).applyConfig(jsonValue))) != null)
/* 302 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\AddRandomCoreTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */