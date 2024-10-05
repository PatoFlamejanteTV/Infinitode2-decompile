/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.JsonHandler;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.QuadRegion;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ import java.util.Locale;
/*     */ 
/*     */ @REGS
/*     */ public final class IncreasedTowerToEnemyEfficiency extends GenericGameplayMod {
/*  40 */   private static final TLog a = TLog.forClass(IncreasedTowerToEnemyEfficiency.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public static final ObjectPair<TowerType, EnemyType>[] DEFAULT_PAIRS = new ObjectPair[] { new ObjectPair(TowerType.BASIC, EnemyType.ICY), new ObjectPair(TowerType.BASIC, EnemyType.HEALER), new ObjectPair(TowerType.BASIC, EnemyType.ARMORED), new ObjectPair(TowerType.BASIC, EnemyType.FIGHTER), new ObjectPair(TowerType.SNIPER, EnemyType.FAST), new ObjectPair(TowerType.SNIPER, EnemyType.TOXIC), new ObjectPair(TowerType.SNIPER, EnemyType.HELI), new ObjectPair(TowerType.CANNON, EnemyType.STRONG), new ObjectPair(TowerType.CANNON, EnemyType.TOXIC), new ObjectPair(TowerType.CANNON, EnemyType.ARMORED), new ObjectPair(TowerType.CANNON, EnemyType.HELI), new ObjectPair(TowerType.FREEZING, EnemyType.ARMORED), new ObjectPair(TowerType.FREEZING, EnemyType.ICY), new ObjectPair(TowerType.FREEZING, EnemyType.FAST), new ObjectPair(TowerType.VENOM, EnemyType.ICY), new ObjectPair(TowerType.VENOM, EnemyType.FAST), new ObjectPair(TowerType.VENOM, EnemyType.TOXIC), new ObjectPair(TowerType.SPLASH, EnemyType.REGULAR), new ObjectPair(TowerType.SPLASH, EnemyType.JET), new ObjectPair(TowerType.SPLASH, EnemyType.ARMORED), new ObjectPair(TowerType.BLAST, EnemyType.STRONG), new ObjectPair(TowerType.BLAST, EnemyType.LIGHT), new ObjectPair(TowerType.BLAST, EnemyType.ICY), new ObjectPair(TowerType.MULTISHOT, EnemyType.HEALER), new ObjectPair(TowerType.MULTISHOT, EnemyType.FIGHTER), new ObjectPair(TowerType.MULTISHOT, EnemyType.ARMORED), new ObjectPair(TowerType.MINIGUN, EnemyType.STRONG), new ObjectPair(TowerType.MINIGUN, EnemyType.BOSS), new ObjectPair(TowerType.MINIGUN, EnemyType.LIGHT), new ObjectPair(TowerType.AIR, EnemyType.ARMORED), new ObjectPair(TowerType.AIR, EnemyType.HEALER), new ObjectPair(TowerType.AIR, EnemyType.BOSS), new ObjectPair(TowerType.AIR, EnemyType.HELI), new ObjectPair(TowerType.TESLA, EnemyType.FAST), new ObjectPair(TowerType.TESLA, EnemyType.HELI), new ObjectPair(TowerType.TESLA, EnemyType.ARMORED), new ObjectPair(TowerType.MISSILE, EnemyType.REGULAR), new ObjectPair(TowerType.MISSILE, EnemyType.FAST), new ObjectPair(TowerType.MISSILE, EnemyType.TOXIC), new ObjectPair(TowerType.FLAMETHROWER, EnemyType.HEALER), new ObjectPair(TowerType.FLAMETHROWER, EnemyType.ARMORED), new ObjectPair(TowerType.FLAMETHROWER, EnemyType.FAST), new ObjectPair(TowerType.LASER, EnemyType.HEALER), new ObjectPair(TowerType.LASER, EnemyType.REGULAR), new ObjectPair(TowerType.LASER, EnemyType.ICY), new ObjectPair(TowerType.GAUSS, EnemyType.FAST), new ObjectPair(TowerType.GAUSS, EnemyType.JET), new ObjectPair(TowerType.GAUSS, EnemyType.TOXIC), new ObjectPair(TowerType.CRUSHER, EnemyType.HELI), new ObjectPair(TowerType.CRUSHER, EnemyType.JET), new ObjectPair(TowerType.CRUSHER, EnemyType.STRONG) };
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
/*     */   @NAGS
/*     */   private String b;
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
/* 120 */   private float c = 0.0F;
/* 121 */   private float d = 50.0F;
/* 122 */   private TowerType e = TowerType.BASIC;
/* 123 */   private EnemyType f = EnemyType.REGULAR;
/*     */ 
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider g;
/*     */ 
/*     */   
/*     */   private float h;
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 135 */     super.write(paramKryo, paramOutput);
/* 136 */     paramOutput.writeFloat(this.c);
/* 137 */     paramOutput.writeFloat(this.d);
/* 138 */     paramKryo.writeObject(paramOutput, this.e);
/* 139 */     paramKryo.writeObject(paramOutput, this.f);
/* 140 */     paramKryo.writeObjectOrNull(paramOutput, this.g, GameSystemProvider.class);
/* 141 */     paramOutput.writeFloat(this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 146 */     super.read(paramKryo, paramInput);
/* 147 */     this.c = paramInput.readFloat();
/* 148 */     this.d = paramInput.readFloat();
/* 149 */     this.e = (TowerType)paramKryo.readObject(paramInput, TowerType.class);
/* 150 */     this.f = (EnemyType)paramKryo.readObject(paramInput, EnemyType.class);
/* 151 */     this.g = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/* 152 */     this.h = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getId() {
/* 157 */     if (this.b == null) {
/* 158 */       this.b = getClass().getSimpleName() + "_" + this.e.name() + "_" + this.f;
/*     */     }
/*     */     
/* 161 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IncreasedTowerToEnemyEfficiency(TowerType paramTowerType, EnemyType paramEnemyType) {
/* 169 */     Preconditions.checkNotNull(paramTowerType, "towerType can not be null");
/* 170 */     Preconditions.checkNotNull(paramEnemyType, "enemyType can not be null");
/* 171 */     this.e = paramTowerType;
/* 172 */     this.f = paramEnemyType;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*     */     Quad quad;
/* 178 */     (quad = new Quad(64.0F, 64.0F)).addRegion(new QuadRegion((ResourcePack.AtlasTextureRegion)Game.i.towerManager
/* 179 */           .getFactory(this.e).getIconTexture(), -9.0F, -3.0F, 82.0F, 82.0F, new Color(0.0F, 0.0F, 0.0F, 0.56F)));
/*     */ 
/*     */     
/* 182 */     quad.addRegion(new QuadRegion((ResourcePack.AtlasTextureRegion)Game.i.towerManager
/* 183 */           .getFactory(this.e).getIconTexture(), -6.0F, 0.0F, 76.0F, 76.0F));
/*     */ 
/*     */     
/* 186 */     quad.addRegion(new QuadRegion((ResourcePack.AtlasTextureRegion)Game.i.enemyManager
/* 187 */           .getFactory(this.f).getTexture(), 30.0F, -2.0F, 36.0F, 36.0F, new Color(0.0F, 0.0F, 0.0F, 0.4F)));
/*     */ 
/*     */     
/* 190 */     quad.addRegion(new QuadRegion((ResourcePack.AtlasTextureRegion)Game.i.enemyManager
/* 191 */           .getFactory(this.f).getTexture(), 32.0F, 0.0F, 32.0F, 32.0F));
/*     */ 
/*     */ 
/*     */     
/* 195 */     return (Drawable)quad;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 200 */     boolean bool = Game.i.towerManager.canTowerAttackEnemy[this.f.ordinal()][this.e.ordinal()];
/*     */     
/* 202 */     String str1 = "<@tower-" + this.e.name().toLowerCase(Locale.US) + ">[#" + Game.i.towerManager.getFactory(this.e).getColor() + "]" + Game.i.towerManager.getTitle(this.e) + "[]";
/* 203 */     String str2 = "<@enemy-type-" + this.f.name().toLowerCase(Locale.US) + ">[#FFFFFF88](" + Game.i.enemyManager.getFactory(this.f).getTitle() + ")[]";
/* 204 */     str1 = Game.i.localeManager.i18n.format("gmod_descr_increased_tower_to_enemy_efficiency", new Object[] { str1, StringFormatter.compactNumberWithPrecisionTrimZeros((this.c + getPower() * this.d), 1, true), str2 });
/*     */     
/* 206 */     if (!bool) {
/* 207 */       str1 = str1 + " " + Game.i.localeManager.i18n.get("gmod_descr_increased_tower_to_enemy_efficiency_abble_to_attack_sfx");
/*     */     }
/* 209 */     return str1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setRegisteredPower(int paramInt) {
/* 214 */     super.setRegisteredPower(paramInt);
/* 215 */     a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/* 220 */     IncreasedTowerToEnemyEfficiency increasedTowerToEnemyEfficiency = new IncreasedTowerToEnemyEfficiency();
/* 221 */     a(increasedTowerToEnemyEfficiency);
/* 222 */     increasedTowerToEnemyEfficiency.d = this.d;
/* 223 */     increasedTowerToEnemyEfficiency.c = this.c;
/* 224 */     increasedTowerToEnemyEfficiency.e = this.e;
/* 225 */     increasedTowerToEnemyEfficiency.f = this.f;
/*     */     
/* 227 */     return (GameplayMod)increasedTowerToEnemyEfficiency;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 232 */     return super.toString() + " {tower: " + this.e + ", enemy: " + this.f + "}";
/*     */   }
/*     */   
/*     */   private void a() {
/* 236 */     if (this.g == null) {
/* 237 */       throw new IllegalStateException("Bonus not registered");
/*     */     }
/*     */     
/* 240 */     EnemyType[] arrayOfEnemyType1 = { this.f };
/* 241 */     if (this.f == EnemyType.BOSS)
/*     */     {
/* 243 */       arrayOfEnemyType1 = new EnemyType[] { EnemyType.BOSS, EnemyType.SNAKE_BOSS_HEAD, EnemyType.SNAKE_BOSS_BODY, EnemyType.SNAKE_BOSS_TAIL, EnemyType.BROOT_BOSS, EnemyType.CONSTRUCTOR_BOSS, EnemyType.MOBCHAIN_BOSS_HEAD, EnemyType.MOBCHAIN_BOSS_BODY, EnemyType.MOBCHAIN_BOSS_CREEP, EnemyType.METAPHOR_BOSS, EnemyType.METAPHOR_BOSS_CREEP };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     EnemyType[] arrayOfEnemyType2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     byte b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     for (i = (arrayOfEnemyType2 = arrayOfEnemyType1).length, b = 0; b < i; ) { EnemyType enemyType = arrayOfEnemyType2[b];
/* 265 */       this.g.tower.canTowerAttackEnemy[enemyType.ordinal()][this.e.ordinal()] = true;
/* 266 */       this.g.tower.towerEnemyDamageMultiplier[enemyType.ordinal()][this.e.ordinal()] = this.g.tower.towerEnemyDamageMultiplier[enemyType.ordinal()][this.e.ordinal()] - this.h;
/*     */       
/*     */       b++; }
/*     */     
/* 270 */     this.h = (this.c + getPower() * this.d) * 0.01F;
/* 271 */     for (i = (arrayOfEnemyType2 = arrayOfEnemyType1).length, b = 0; b < i; ) { EnemyType enemyType = arrayOfEnemyType2[b];
/* 272 */       this.g.tower.towerEnemyDamageMultiplier[enemyType.ordinal()][this.e.ordinal()] = this.g.tower.towerEnemyDamageMultiplier[enemyType.ordinal()][this.e.ordinal()] + this.h;
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 278 */     if (paramGameSystemProvider.map.getMap().getAllowedEnemiesSet().contains(this.f) && Game.i.towerManager.getFactory(this.e).isAvailable((GameValueProvider)paramGameSystemProvider.gameValue)) {
/* 279 */       return false;
/*     */     }
/* 281 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 286 */     if (paramGameSystemProvider.map.getMap().getAllowedEnemiesSet().contains(this.f) && Game.i.towerManager.getFactory(this.e).isAvailable((GameValueProvider)paramGameSystemProvider.gameValue)) {
/* 287 */       return null;
/*     */     }
/* 289 */     return () -> Game.i.localeManager.i18n.get("gpmod_precondition_increased_tower_to_enemy_efficiency");
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 294 */     IncreasedTowerToEnemyEfficiency increasedTowerToEnemyEfficiency = null;
/* 295 */     for (byte b = 0; b < (paramGameSystemProvider.gameplayMod.getActiveMods()).size; b++) {
/*     */       GameplayModSystem.ActiveMod activeMod; IncreasedTowerToEnemyEfficiency increasedTowerToEnemyEfficiency1;
/*     */       GameplayMod gameplayMod;
/* 298 */       if (gameplayMod = (activeMod = (GameplayModSystem.ActiveMod)paramGameSystemProvider.gameplayMod.getActiveMods().get(b)).getMod() instanceof IncreasedTowerToEnemyEfficiency && activeMod.getSource().equals(paramString) && 
/*     */         
/* 300 */         (increasedTowerToEnemyEfficiency1 = (IncreasedTowerToEnemyEfficiency)gameplayMod).e == this.e && increasedTowerToEnemyEfficiency1.f == this.f) {
/* 301 */         increasedTowerToEnemyEfficiency = increasedTowerToEnemyEfficiency1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 307 */     if (increasedTowerToEnemyEfficiency == null) {
/*     */       
/* 309 */       this.g = paramGameSystemProvider;
/* 310 */       a();
/* 311 */       return true;
/*     */     } 
/*     */     
/* 314 */     increasedTowerToEnemyEfficiency.setRegisteredPower(this.power);
/* 315 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 321 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   private IncreasedTowerToEnemyEfficiency() {}
/*     */ 
/*     */   
/*     */   public final IncreasedTowerToEnemyEfficiency applyConfig(JsonValue paramJsonValue) {
/* 329 */     super.applyConfig(paramJsonValue);
/* 330 */     this.d = paramJsonValue.getFloat("damagePerPwr", this.d);
/* 331 */     this.c = paramJsonValue.getFloat("baseDamage", this.c);
/*     */     String str;
/* 333 */     if ((str = paramJsonValue.getString("tower", null)) != null) {
/*     */       try {
/* 335 */         this.e = TowerType.valueOf(str);
/* 336 */       } catch (Exception exception) {
/* 337 */         a.e("failed to read tower type cfg", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/* 341 */     if ((str = paramJsonValue.getString("enemy", null)) != null) {
/*     */       try {
/* 343 */         this.f = EnemyType.valueOf(str);
/* 344 */       } catch (Exception exception) {
/* 345 */         a.e("failed to read enemy type cfg", new Object[] { exception });
/*     */       } 
/*     */     }
/* 348 */     this.b = null;
/* 349 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 356 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 359 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 364 */       JsonValue jsonValue1 = param1BonusStagesConfig.getBonusConfig("IncreasedTowerToEnemyEfficiency");
/*     */ 
/*     */ 
/*     */       
/* 368 */       ProbableBonusesProvider.BonusProviderConfig bonusProviderConfig = (new ProbableBonusesProvider.BonusProviderConfig(0.03F)).setPowerUpProbabilityMultiplier(0.9F).applyConfig(jsonValue1);
/*     */ 
/*     */       
/* 371 */       Array array = new Array(true, 1, IncreasedTowerToEnemyEfficiency.class);
/* 372 */       if (jsonValue1.getBoolean("useDefaultTowerEnemyCombos", true)) {
/*     */         ObjectPair<TowerType, EnemyType>[] arrayOfObjectPair; int i; byte b;
/* 374 */         for (i = (arrayOfObjectPair = IncreasedTowerToEnemyEfficiency.DEFAULT_PAIRS).length, b = 0; b < i; ) { ObjectPair<TowerType, EnemyType> objectPair = arrayOfObjectPair[b];
/* 375 */           array.add(new IncreasedTowerToEnemyEfficiency((TowerType)objectPair.first, (EnemyType)objectPair.second));
/*     */           
/*     */           b++; }
/*     */       
/*     */       } 
/*     */       JsonValue jsonValue2;
/* 381 */       if ((jsonValue2 = jsonValue1.get("towerEnemyCombos")) != null) {
/* 382 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/*     */           try {
/* 384 */             TowerType towerType = TowerType.valueOf(jsonValue.getString("tower"));
/* 385 */             EnemyType enemyType = EnemyType.valueOf(jsonValue.getString("enemy"));
/*     */ 
/*     */             
/* 388 */             IncreasedTowerToEnemyEfficiency increasedTowerToEnemyEfficiency = null;
/* 389 */             for (byte b = 0; b < array.size; b++) {
/*     */               IncreasedTowerToEnemyEfficiency increasedTowerToEnemyEfficiency1;
/* 391 */               if (IncreasedTowerToEnemyEfficiency.a(increasedTowerToEnemyEfficiency1 = ((IncreasedTowerToEnemyEfficiency[])array.items)[b]) == towerType && IncreasedTowerToEnemyEfficiency.b(increasedTowerToEnemyEfficiency1) == enemyType) {
/* 392 */                 increasedTowerToEnemyEfficiency = increasedTowerToEnemyEfficiency1;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 396 */             if (increasedTowerToEnemyEfficiency == null)
/*     */             {
/* 398 */               array.add(new IncreasedTowerToEnemyEfficiency(towerType, enemyType));
/*     */             }
/* 400 */           } catch (Exception exception) {
/* 401 */             logger.e("failed to read combo: " + jsonValue, new Object[] { exception });
/*     */           }  }
/*     */       
/*     */       }
/*     */       
/* 406 */       if (array.size == 0) {
/*     */         return;
/*     */       }
/*     */       
/* 410 */       logger.i("variant list: " + array, new Object[0]);
/*     */ 
/*     */       
/* 413 */       for (Array.ArrayIterator<IncreasedTowerToEnemyEfficiency> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { IncreasedTowerToEnemyEfficiency increasedTowerToEnemyEfficiency = arrayIterator.next();
/*     */         
/* 415 */         JsonValue jsonValue = JsonHandler.EMPTY_JSON_OBJECT;
/* 416 */         if (jsonValue2 != null) {
/* 417 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue3 = jsonIterator.next();
/*     */             try {
/* 419 */               TowerType towerType = TowerType.valueOf(jsonValue3.getString("tower"));
/* 420 */               EnemyType enemyType = EnemyType.valueOf(jsonValue3.getString("enemy"));
/* 421 */               if (towerType == IncreasedTowerToEnemyEfficiency.a(increasedTowerToEnemyEfficiency) && enemyType == IncreasedTowerToEnemyEfficiency.b(increasedTowerToEnemyEfficiency)) {
/* 422 */                 jsonValue = jsonValue3;
/*     */                 break;
/*     */               } 
/* 425 */             } catch (Exception exception) {
/* 426 */               logger.e("failed to read combo: " + jsonValue3, new Object[] { exception });
/*     */             }  }
/*     */         
/*     */         }
/* 430 */         increasedTowerToEnemyEfficiency.applyConfig(jsonValue1);
/* 431 */         increasedTowerToEnemyEfficiency.applyConfig(jsonValue);
/*     */ 
/*     */ 
/*     */         
/*     */         ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */         
/* 439 */         if ((probableBonus = ProbableBonusesProvider.addOrModify(increasedTowerToEnemyEfficiency, param1Int, param1Array, bonusProviderConfig.cpy().applyConfig(jsonValue))) != null)
/* 440 */           param1Array1.add(probableBonus);  }
/*     */     
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\IncreasedTowerToEnemyEfficiency.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */