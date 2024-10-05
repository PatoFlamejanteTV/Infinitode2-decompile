/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.buffs.NoDamageBuff;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class LastEnemiesInWaveDealNoDamage
/*     */   extends GenericGameplayMod
/*     */   implements Listener<EnemySpawn>
/*     */ {
/*  35 */   public int baseEnemyCount = 0;
/*  36 */   public int enemyCountPerPower = 1;
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider a;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  43 */     super.write(paramKryo, paramOutput);
/*  44 */     paramOutput.writeInt(this.baseEnemyCount);
/*  45 */     paramOutput.writeInt(this.enemyCountPerPower);
/*  46 */     paramKryo.writeObjectOrNull(paramOutput, this.a, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  51 */     super.read(paramKryo, paramInput);
/*  52 */     this.baseEnemyCount = paramInput.readInt();
/*  53 */     this.enemyCountPerPower = paramInput.readInt();
/*  54 */     this.a = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */   
/*     */   public final int getEnemyCount() {
/*  58 */     return MathUtils.round((this.baseEnemyCount + this.enemyCountPerPower * this.power));
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  63 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.LastEnemiesInWaveDealNoDamage");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  68 */     return Game.i.localeManager.i18n.format("gmod_descr_last_enemies_in_wave_deal_no_damage", new Object[] { Integer.valueOf(getEnemyCount()) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final LastEnemiesInWaveDealNoDamage cpy() {
/*  73 */     LastEnemiesInWaveDealNoDamage lastEnemiesInWaveDealNoDamage = new LastEnemiesInWaveDealNoDamage();
/*  74 */     a(lastEnemiesInWaveDealNoDamage);
/*  75 */     lastEnemiesInWaveDealNoDamage.baseEnemyCount = this.baseEnemyCount;
/*  76 */     lastEnemiesInWaveDealNoDamage.enemyCountPerPower = this.enemyCountPerPower;
/*  77 */     return lastEnemiesInWaveDealNoDamage;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/*  83 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(LastEnemiesInWaveDealNoDamage.class, paramString)) == null) {
/*     */       
/*  85 */       this.a = paramGameSystemProvider;
/*  86 */       paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Applies the mod");
/*  87 */       return true;
/*     */     } 
/*     */     
/*  90 */     activeMod.getMod().setRegisteredPower(this.power);
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  97 */     return GameplayModCategory.DEFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final LastEnemiesInWaveDealNoDamage applyConfig(JsonValue paramJsonValue) {
/* 102 */     super.applyConfig(paramJsonValue);
/* 103 */     this.baseEnemyCount = paramJsonValue.getInt("baseEnemyCount", this.baseEnemyCount);
/* 104 */     this.enemyCountPerPower = paramJsonValue.getInt("enemyCountPerPower", this.enemyCountPerPower);
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void handleEvent(EnemySpawn paramEnemySpawn) {
/*     */     Enemy enemy;
/* 111 */     if (!(enemy = paramEnemySpawn.getEnemy()).notAffectsWaveKillCounter.isTrue() && enemy.wave != null) {
/* 112 */       if (enemy.wave.getSpawnedEnemyCount() <= 1)
/*     */         return; 
/*     */       int i;
/* 115 */       if ((i = enemy.wave.totalEnemiesCount - enemy.wave.getSpawnedEnemyCount()) < getEnemyCount()) {
/*     */         NoDamageBuff noDamageBuff;
/* 117 */         (noDamageBuff = new NoDamageBuff()).setup(3600.0F, 3600.0F);
/* 118 */         this.a.buff.P_NO_DAMAGE.addBuff(enemy, noDamageBuff);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     static {
/* 127 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     } private static final BonusProvider a;
/*     */     public static BonusProvider getInstance() {
/* 130 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 135 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("LastEnemiesInWaveDealNoDamage");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new LastEnemiesInWaveDealNoDamage()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 146 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\LastEnemiesInWaveDealNoDamage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */