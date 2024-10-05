/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class BoostExistingEnemiesWithLoot
/*     */   extends GenericGameplayMod {
/*  28 */   private float a = 3.0F;
/*  29 */   private float b = 0.5F;
/*  30 */   private int c = 20;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  41 */     super.write(paramKryo, paramOutput);
/*  42 */     paramOutput.writeFloat(this.a);
/*  43 */     paramOutput.writeFloat(this.b);
/*  44 */     paramOutput.writeInt(this.c);
/*  45 */     paramOutput.writeVarInt(this.d, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  50 */     super.read(paramKryo, paramInput);
/*  51 */     this.a = paramInput.readFloat();
/*  52 */     this.b = paramInput.readFloat();
/*  53 */     this.c = paramInput.readInt();
/*  54 */     this.d = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  59 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getAdditionalCategory() {
/*  64 */     return GameplayModCategory.ECONOMICS;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  74 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.BoostExistingEnemiesWithLoot");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  79 */     String str1 = StringFormatter.compactNumberWithPrecisionTrimZeros(this.a, 1, true).toString();
/*  80 */     String str2 = StringFormatter.compactNumberWithPrecisionTrimZeros((this.b * 100.0F), 1, true).toString();
/*  81 */     return Game.i.localeManager.i18n.format("gmod_descr_boost_existing_enemies_with_loot", new Object[] { Integer.valueOf(this.c), str1, str2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public final BoostExistingEnemiesWithLoot cpy() {
/*  86 */     BoostExistingEnemiesWithLoot boostExistingEnemiesWithLoot = new BoostExistingEnemiesWithLoot();
/*  87 */     a(boostExistingEnemiesWithLoot);
/*  88 */     boostExistingEnemiesWithLoot.a = this.a;
/*  89 */     boostExistingEnemiesWithLoot.b = this.b;
/*  90 */     boostExistingEnemiesWithLoot.d = this.d;
/*  91 */     return boostExistingEnemiesWithLoot;
/*     */   }
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*     */     int i;
/*  96 */     if (paramGameSystemProvider.map.spawnedEnemies.size >= this.d) {
/*  97 */       return null;
/*     */     }
/*     */     
/* 100 */     return () -> Game.i.localeManager.i18n.format("gpmod_precondition_boost_existing_enemies", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 106 */     byte b1 = 0;
/* 107 */     for (byte b2 = 0; b2 < paramGameSystemProvider.map.spawnedEnemies.size; b2++) {
/*     */       Enemy enemy;
/* 109 */       if ((enemy = ((Enemy.EnemyReference)paramGameSystemProvider.map.spawnedEnemies.get(b2)).enemy) != null) {
/* 110 */         enemy.bounty *= this.a;
/* 111 */         if (this.b > 0.0F) {
/* 112 */           enemy.setHealth(Math.min(enemy.getHealth() + enemy.maxHealth * this.b, enemy.maxHealth));
/*     */         }
/* 114 */         paramGameSystemProvider.loot.forceFillWithLoot(enemy);
/* 115 */         b1++;
/* 116 */         if (b1 != this.c)
/*     */           continue;  break;
/*     */       } 
/*     */       continue;
/*     */     } 
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 122 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(BoostExistingEnemiesWithLoot.class, paramString)) != null) {
/* 123 */       activeMod.getMod().setRegisteredPower(this.power);
/* 124 */       return false;
/*     */     } 
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BoostExistingEnemiesWithLoot applyConfig(JsonValue paramJsonValue) {
/* 132 */     super.applyConfig(paramJsonValue);
/* 133 */     this.a = paramJsonValue.getFloat("coinMultiplier", this.a);
/* 134 */     this.b = paramJsonValue.getFloat("hpRestore", this.b);
/* 135 */     this.c = paramJsonValue.getInt("enemyCount", this.c);
/* 136 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 143 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 146 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 151 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("BoostExistingEnemiesWithLoot");
/*     */       BoostExistingEnemiesWithLoot boostExistingEnemiesWithLoot;
/* 153 */       BoostExistingEnemiesWithLoot.a(boostExistingEnemiesWithLoot = (new BoostExistingEnemiesWithLoot()).applyConfig(jsonValue), jsonValue.getInt("minEnemyCount", 5));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 162 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(boostExistingEnemiesWithLoot, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).setPowerUpProbabilityMultiplier(0.9F).applyConfig(jsonValue))) != null)
/* 163 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\BoostExistingEnemiesWithLoot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */