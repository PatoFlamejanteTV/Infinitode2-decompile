/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*     */ import com.prineside.tdi2.explosions.GenericExplosion;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.TargetTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class BaseExplodesOnEnemyPass
/*     */   extends GenericGameplayMod
/*     */   implements Listener<EnemyReachTarget>
/*     */ {
/*  38 */   public float baseCooldown = 60.0F;
/*  39 */   public float cooldownPerPower = 0.0F;
/*  40 */   public float baseDamage = 150.0F;
/*  41 */   public float damagePerPower = 50.0F;
/*  42 */   public float baseRange = 2.5F;
/*  43 */   public float rangePerPower = 0.5F;
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider a;
/*  47 */   private float b = -1.0F;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  51 */     super.write(paramKryo, paramOutput);
/*  52 */     paramOutput.writeFloat(this.baseCooldown);
/*  53 */     paramOutput.writeFloat(this.cooldownPerPower);
/*  54 */     paramOutput.writeFloat(this.baseDamage);
/*  55 */     paramOutput.writeFloat(this.damagePerPower);
/*  56 */     paramOutput.writeFloat(this.baseRange);
/*  57 */     paramOutput.writeFloat(this.rangePerPower);
/*  58 */     paramKryo.writeObjectOrNull(paramOutput, this.a, GameSystemProvider.class);
/*  59 */     paramOutput.writeFloat(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  64 */     super.read(paramKryo, paramInput);
/*  65 */     this.baseCooldown = paramInput.readFloat();
/*  66 */     this.cooldownPerPower = paramInput.readFloat();
/*  67 */     this.baseDamage = paramInput.readFloat();
/*  68 */     this.damagePerPower = paramInput.readFloat();
/*  69 */     this.baseRange = paramInput.readFloat();
/*  70 */     this.rangePerPower = paramInput.readFloat();
/*  71 */     this.a = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  72 */     this.b = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  77 */     return GameplayModCategory.DEFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getAdditionalCategory() {
/*  82 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */   
/*     */   public final float getDamage() {
/*  86 */     return this.baseDamage + this.damagePerPower * this.power;
/*     */   }
/*     */   
/*     */   public final int getCooldown() {
/*  90 */     return MathUtils.round(this.baseCooldown + this.cooldownPerPower * this.power);
/*     */   }
/*     */   
/*     */   public final float getRange() {
/*  94 */     return this.baseRange + this.rangePerPower * this.power;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  99 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.BaseExplodesOnEnemyPass");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 104 */     String str1 = StringFormatter.compactNumberWithPrecisionTrimZeros(getDamage(), 1, true).toString();
/* 105 */     String str2 = StringFormatter.timePassed(getCooldown(), false, false);
/* 106 */     return Game.i.localeManager.i18n.format("gmod_descr_base_explodes_on_enemy_pass", new Object[] { Float.valueOf(getRange()), str1, str2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public final BaseExplodesOnEnemyPass cpy() {
/* 111 */     BaseExplodesOnEnemyPass baseExplodesOnEnemyPass = new BaseExplodesOnEnemyPass();
/* 112 */     a(baseExplodesOnEnemyPass);
/* 113 */     baseExplodesOnEnemyPass.baseCooldown = this.baseCooldown;
/* 114 */     baseExplodesOnEnemyPass.cooldownPerPower = this.cooldownPerPower;
/* 115 */     baseExplodesOnEnemyPass.baseDamage = this.baseDamage;
/* 116 */     baseExplodesOnEnemyPass.damagePerPower = this.damagePerPower;
/* 117 */     baseExplodesOnEnemyPass.baseRange = this.baseRange;
/* 118 */     baseExplodesOnEnemyPass.rangePerPower = this.rangePerPower;
/* 119 */     return baseExplodesOnEnemyPass;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 125 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(BaseExplodesOnEnemyPass.class, paramString)) == null) {
/*     */       
/* 127 */       this.a = paramGameSystemProvider;
/* 128 */       paramGameSystemProvider.events.getListeners(EnemyReachTarget.class).addStateAffecting(this);
/* 129 */       return true;
/*     */     } 
/*     */     
/* 132 */     activeMod.getMod().setRegisteredPower(this.power);
/* 133 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BaseExplodesOnEnemyPass applyConfig(JsonValue paramJsonValue) {
/* 139 */     super.applyConfig(paramJsonValue);
/* 140 */     this.baseCooldown = paramJsonValue.getFloat("baseCooldown", this.baseCooldown);
/* 141 */     this.cooldownPerPower = paramJsonValue.getFloat("cooldownPerPower", this.cooldownPerPower);
/* 142 */     this.baseDamage = paramJsonValue.getFloat("baseDamage", this.baseDamage);
/* 143 */     this.damagePerPower = paramJsonValue.getFloat("damagePerPower", this.damagePerPower);
/* 144 */     this.baseRange = paramJsonValue.getFloat("baseRange", this.baseRange);
/* 145 */     this.rangePerPower = paramJsonValue.getFloat("rangePerPower", this.rangePerPower);
/* 146 */     return this;
/*     */   }
/*     */   
/*     */   public final void handleEvent(EnemyReachTarget paramEnemyReachTarget) {
/*     */     Tile tile;
/* 151 */     if ((this.b <= 0.0F || this.a.statistics.getStatistic(StatisticsType.PT) - this.b >= getCooldown()) && 
/*     */       
/* 153 */       tile = paramEnemyReachTarget.getEnemy().getCurrentTile() instanceof TargetTile) {
/*     */       GenericExplosion genericExplosion;
/* 155 */       (genericExplosion = (GenericExplosion)this.a.explosion.F.GENERIC.obtain()).setup(null, tile.center.x, tile.center.y, 
/*     */ 
/*     */ 
/*     */           
/* 159 */           (paramEnemyReachTarget.getEnemy()).maxHealth * getDamage() * 0.01F, 
/* 160 */           getRange(), 0, 0.0F, 0.0F, ((TargetTile)tile)
/* 161 */           .getCoreColor(), null);
/*     */       
/* 163 */       this.a.explosion.register((Explosion)genericExplosion);
/* 164 */       genericExplosion.explode();
/*     */       
/* 166 */       this.b = (float)this.a.statistics.getStatistic(StatisticsType.PT);
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 175 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 178 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 183 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("BaseExplodesOnEnemyPass");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new BaseExplodesOnEnemyPass()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 194 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\BaseExplodesOnEnemyPass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */