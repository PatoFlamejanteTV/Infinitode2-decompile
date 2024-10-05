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
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.buffs.DeathExplosionBuff;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.explosions.GenericExplosion;
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
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class FirstEnemiesInWaveExplode
/*     */   extends GenericGameplayMod
/*     */   implements Listener<EnemySpawn>
/*     */ {
/*  38 */   public int baseEnemyCount = 0;
/*  39 */   public int enemyCountPerPower = 1;
/*  40 */   public float baseDamage = 20.0F;
/*  41 */   public float damagePerPower = 10.0F;
/*  42 */   public float explosionRange = 4.0F;
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider a;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  49 */     super.write(paramKryo, paramOutput);
/*  50 */     paramOutput.writeInt(this.baseEnemyCount);
/*  51 */     paramOutput.writeInt(this.enemyCountPerPower);
/*  52 */     paramOutput.writeFloat(this.baseDamage);
/*  53 */     paramOutput.writeFloat(this.damagePerPower);
/*  54 */     paramOutput.writeFloat(this.explosionRange);
/*  55 */     paramKryo.writeObjectOrNull(paramOutput, this.a, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  60 */     super.read(paramKryo, paramInput);
/*  61 */     this.baseEnemyCount = paramInput.readInt();
/*  62 */     this.enemyCountPerPower = paramInput.readInt();
/*  63 */     this.baseDamage = paramInput.readFloat();
/*  64 */     this.damagePerPower = paramInput.readFloat();
/*  65 */     this.explosionRange = paramInput.readFloat();
/*  66 */     this.a = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  71 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */   
/*     */   public final int getEnemyCount() {
/*  75 */     return MathUtils.round((this.baseEnemyCount + this.enemyCountPerPower * this.power));
/*     */   }
/*     */   
/*     */   public final float getDamage() {
/*  79 */     return this.baseDamage + this.damagePerPower * this.power;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  84 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.FirstEnemiesInWaveExplode");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  89 */     String str = StringFormatter.compactNumberWithPrecisionTrimZeros(getDamage(), 1, true).toString();
/*  90 */     return Game.i.localeManager.i18n.format("gmod_descr_first_enemies_in_wave_explode", new Object[] { Integer.valueOf(getEnemyCount()), str });
/*     */   }
/*     */ 
/*     */   
/*     */   public final FirstEnemiesInWaveExplode cpy() {
/*  95 */     FirstEnemiesInWaveExplode firstEnemiesInWaveExplode = new FirstEnemiesInWaveExplode();
/*  96 */     a(firstEnemiesInWaveExplode);
/*  97 */     firstEnemiesInWaveExplode.baseEnemyCount = this.baseEnemyCount;
/*  98 */     firstEnemiesInWaveExplode.enemyCountPerPower = this.enemyCountPerPower;
/*  99 */     firstEnemiesInWaveExplode.baseDamage = this.baseDamage;
/* 100 */     firstEnemiesInWaveExplode.damagePerPower = this.damagePerPower;
/* 101 */     firstEnemiesInWaveExplode.explosionRange = this.explosionRange;
/* 102 */     return firstEnemiesInWaveExplode;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 108 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(FirstEnemiesInWaveExplode.class, paramString)) == null) {
/*     */       
/* 110 */       this.a = paramGameSystemProvider;
/* 111 */       paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Applies the mod");
/* 112 */       return true;
/*     */     } 
/*     */     
/* 115 */     activeMod.getMod().setRegisteredPower(this.power);
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final FirstEnemiesInWaveExplode applyConfig(JsonValue paramJsonValue) {
/* 122 */     super.applyConfig(paramJsonValue);
/* 123 */     this.baseEnemyCount = paramJsonValue.getInt("baseEnemyCount", this.baseEnemyCount);
/* 124 */     this.enemyCountPerPower = paramJsonValue.getInt("enemyCountPerPower", this.enemyCountPerPower);
/* 125 */     this.baseDamage = paramJsonValue.getFloat("baseDamage", this.baseDamage);
/* 126 */     this.damagePerPower = paramJsonValue.getFloat("damagePerPower", this.damagePerPower);
/* 127 */     this.explosionRange = paramJsonValue.getFloat("explosionRange", this.explosionRange);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void handleEvent(EnemySpawn paramEnemySpawn) {
/*     */     Enemy enemy;
/* 134 */     if (!(enemy = paramEnemySpawn.getEnemy()).notAffectsWaveKillCounter.isTrue() && enemy.wave != null && 
/* 135 */       enemy.wave.getSpawnedEnemyCount() <= getEnemyCount()) {
/* 136 */       GenericExplosion genericExplosion = (GenericExplosion)this.a.explosion.F.GENERIC.obtain();
/* 137 */       float f = enemy.getSize() * 0.0078125F * this.explosionRange;
/* 138 */       genericExplosion.setup(null, 0.0F, 0.0F, enemy.maxHealth * getDamage() * 0.01F, f, 0, 0.0F, 0.0F, Game.i.enemyManager.getFactory(enemy.type).getColor(), null);
/*     */       
/* 140 */       this.a.buff.P_DEATH_EXPLOSION.addBuff(enemy, (new DeathExplosionBuff()).setup(60.0F, 180.0F, (Explosion)genericExplosion));
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 149 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 152 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 157 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("FirstEnemiesInWaveExplode");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 166 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new FirstEnemiesInWaveExplode()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 167 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\FirstEnemiesInWaveExplode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */