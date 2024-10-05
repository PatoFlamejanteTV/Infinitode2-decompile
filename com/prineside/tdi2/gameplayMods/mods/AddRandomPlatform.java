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
/*     */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
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
/*     */ public final class AddRandomPlatform extends GenericGameplayMod {
/*  35 */   private static final TLog a = TLog.forClass(AddRandomPlatform.class);
/*     */ 
/*     */   
/*  38 */   private int b = 2;
/*  39 */   private int c = 3;
/*  40 */   private int d = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  48 */     super.write(paramKryo, paramOutput);
/*  49 */     paramOutput.writeInt(this.b);
/*  50 */     paramOutput.writeInt(this.c);
/*  51 */     paramOutput.writeInt(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  56 */     super.read(paramKryo, paramInput);
/*  57 */     this.b = paramInput.readInt();
/*  58 */     this.c = paramInput.readInt();
/*  59 */     this.d = paramInput.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  69 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.AddRandomPlatform");
/*     */   }
/*     */   
/*     */   public final int getPlatformCount() {
/*  73 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  78 */     return Game.i.localeManager.i18n.format("gmod_descr_add_random_platform", new Object[] { Integer.valueOf(getPlatformCount()) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final AddRandomPlatform cpy() {
/*  83 */     AddRandomPlatform addRandomPlatform = new AddRandomPlatform();
/*  84 */     a(addRandomPlatform);
/*  85 */     addRandomPlatform.b = this.b;
/*  86 */     addRandomPlatform.c = this.c;
/*  87 */     addRandomPlatform.d = this.d;
/*  88 */     return addRandomPlatform;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/*  94 */     int i = paramGameSystemProvider.map.getMap().getWidth();
/*  95 */     int j = paramGameSystemProvider.map.getMap().getHeight();
/*  96 */     return ((paramGameSystemProvider.map.getMap().getAllTiles()).size >= i * j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 102 */     int i = paramGameSystemProvider.map.getMap().getWidth();
/* 103 */     int j = paramGameSystemProvider.map.getMap().getHeight();
/* 104 */     if ((paramGameSystemProvider.map.getMap().getAllTiles()).size < i * j) {
/* 105 */       return null;
/*     */     }
/* 107 */     return () -> Game.i.localeManager.i18n.get("gpmod_precondition_no_empty_space_on_map");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 113 */     RandomXS128 randomXS128 = paramGameSystemProvider.gameplayMod.getModRandom(1430);
/*     */ 
/*     */     
/* 116 */     Map map = paramGameSystemProvider.map.getMap();
/* 117 */     Array array = new Array(true, 1, ObjectPair.class);
/* 118 */     DelayedRemovalArray delayedRemovalArray = map.getAllTiles(); byte b;
/* 119 */     for (b = 0; b < map.getHeight(); b++) {
/* 120 */       for (byte b1 = 0; b1 < map.getWidth(); b1++) {
/* 121 */         if (map.getTile(b1, b) == null) {
/*     */           
/* 123 */           float f = Float.MAX_VALUE;
/* 124 */           for (byte b2 = 0; b2 < ((Array)delayedRemovalArray).size; b2++) {
/*     */             Tile tile;
/* 126 */             if ((tile = ((Tile[])((Array)delayedRemovalArray).items)[b2]).type == TileType.ROAD || tile.type == TileType.SPAWN || tile.type == TileType.TARGET) {
/* 127 */               float f1 = PMath.getSquareDistanceBetweenPoints(b1, b, tile.getX(), tile.getY());
/* 128 */               if (f > f1) {
/* 129 */                 f = f1;
/*     */               }
/*     */             } 
/*     */           } 
/* 133 */           array.add(new ObjectPair(new IntPair(b1, b), Float.valueOf(f)));
/*     */         } 
/*     */       } 
/*     */     } 
/* 137 */     if (array.size == 0) {
/* 138 */       a.e("registration skipped - no empty space on map", new Object[0]);
/* 139 */       return false;
/*     */     } 
/*     */     
/* 142 */     paramGameSystemProvider.TSH.sort.sort(array, (paramObjectPair1, paramObjectPair2) -> Float.compare(((Float)paramObjectPair1.second).floatValue(), ((Float)paramObjectPair2.second).floatValue()));
/*     */     
/* 144 */     for (b = 0; b < this.b; b++) {
/* 145 */       ObjectPair objectPair2; if (array.size == 0) {
/* 146 */         a.i("skipped platform idx " + b + " - no space left", new Object[0]);
/*     */         
/*     */         break;
/*     */       } 
/* 150 */       ObjectPair objectPair1 = (ObjectPair)array.first();
/*     */ 
/*     */       
/* 153 */       if (array.size > 1) {
/* 154 */         int i = array.size;
/* 155 */         for (byte b1 = 1; b1 < array.size; b1++) {
/*     */           ObjectPair objectPair;
/* 157 */           if (!((Float)(objectPair = ((ObjectPair[])array.items)[b1]).second).equals(objectPair1.second)) {
/* 158 */             i = b1;
/*     */             break;
/*     */           } 
/*     */         } 
/* 162 */         objectPair2 = (ObjectPair)array.removeIndex(randomXS128.nextInt(i));
/*     */       } else {
/* 164 */         objectPair2 = objectPair1;
/* 165 */         array.setSize(0);
/*     */       } 
/*     */       PlatformTile platformTile;
/* 168 */       (platformTile = Game.i.tileManager.F.PLATFORM.create()).bonusType = SpaceTileBonusType.values[randomXS128.nextInt(SpaceTileBonusType.values.length)];
/* 169 */       platformTile.bonusLevel = randomXS128.nextInt(this.d - this.c) + this.c;
/* 170 */       if (platformTile.bonusLevel > 5) {
/* 171 */         platformTile.bonusLevel = 5;
/*     */       }
/* 173 */       paramGameSystemProvider.map.getMap().setTile(((IntPair)objectPair2.first).a, ((IntPair)objectPair2.first).b, (Tile)platformTile);
/* 174 */       paramGameSystemProvider.map.registerTile((Tile)platformTile);
/*     */       
/* 176 */       paramGameSystemProvider.map.showTileWarningParticle(((IntPair)objectPair2.first).a, ((IntPair)objectPair2.first).b);
/* 177 */       if (paramGameSystemProvider._mapRendering != null) {
/* 178 */         paramGameSystemProvider._mapRendering.forceTilesRedraw(true);
/*     */       }
/*     */     } 
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 183 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(AddRandomPlatform.class, paramString)) != null) {
/* 184 */       activeMod.getMod().setRegisteredPower(this.power);
/* 185 */       return false;
/*     */     } 
/* 187 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 193 */     return GameplayModCategory.OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public final AddRandomPlatform applyConfig(JsonValue paramJsonValue) {
/* 198 */     super.applyConfig(paramJsonValue);
/* 199 */     this.b = paramJsonValue.getInt("platformCount", this.b);
/* 200 */     this.c = paramJsonValue.getInt("minBonusLevel", this.c);
/* 201 */     this.d = paramJsonValue.getInt("maxBonusLevel", this.d);
/* 202 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 209 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 212 */       return a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/*     */       JsonValue jsonValue;
/* 219 */       float f = (jsonValue = param1BonusStagesConfig.getBonusConfig("AddRandomPlatform")).getFloat("countPerStage", 0.2F);
/*     */       
/*     */       AddRandomPlatform addRandomPlatform;
/* 222 */       AddRandomPlatform.a(addRandomPlatform = (new AddRandomPlatform()).applyConfig(jsonValue), MathUtils.round(AddRandomPlatform.a(addRandomPlatform) + f * (param1Int - 1)));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 232 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(addRandomPlatform, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.5F).applyConfig(jsonValue))) != null)
/* 233 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\AddRandomPlatform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */