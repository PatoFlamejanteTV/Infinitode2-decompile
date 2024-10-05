/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.buffs.NoDamageBuff;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyReachTarget;
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
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class LowHpEnemiesDealNoDamage extends GenericGameplayMod {
/*  31 */   private static final TLog a = TLog.forClass(LowHpEnemiesDealNoDamage.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   public float baseHp = 0.0F;
/*  39 */   public float hpPerPower = 5.0F;
/*     */ 
/*     */   
/*  42 */   private OnEnemyReachTarget b = new OnEnemyReachTarget(this, (byte)0);
/*     */   @Null
/*     */   private GameSystemProvider c;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  47 */     super.write(paramKryo, paramOutput);
/*  48 */     paramOutput.writeFloat(this.baseHp);
/*  49 */     paramOutput.writeFloat(this.hpPerPower);
/*  50 */     paramKryo.writeObjectOrNull(paramOutput, this.b, OnEnemyReachTarget.class);
/*  51 */     paramKryo.writeObjectOrNull(paramOutput, this.c, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  56 */     super.read(paramKryo, paramInput);
/*  57 */     this.baseHp = paramInput.readFloat();
/*  58 */     this.hpPerPower = paramInput.readFloat();
/*  59 */     this.b = (OnEnemyReachTarget)paramKryo.readObjectOrNull(paramInput, OnEnemyReachTarget.class);
/*  60 */     this.c = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */   
/*     */   public final float getHpThreshold() {
/*  64 */     return this.baseHp + this.hpPerPower * this.power;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  69 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.LowHpEnemiesDealNoDamage");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  74 */     return Game.i.localeManager.i18n.format("gmod_descr_low_hp_enemies_deal_no_damage", new Object[] { StringFormatter.compactNumberWithPrecisionTrimZeros(getHpThreshold(), 1, true) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final LowHpEnemiesDealNoDamage cpy() {
/*  79 */     LowHpEnemiesDealNoDamage lowHpEnemiesDealNoDamage = new LowHpEnemiesDealNoDamage();
/*  80 */     a(lowHpEnemiesDealNoDamage);
/*  81 */     lowHpEnemiesDealNoDamage.hpPerPower = this.hpPerPower;
/*  82 */     lowHpEnemiesDealNoDamage.baseHp = this.baseHp;
/*  83 */     return lowHpEnemiesDealNoDamage;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/*  89 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(LowHpEnemiesDealNoDamage.class, paramString)) == null) {
/*     */       
/*  91 */       this.c = paramGameSystemProvider;
/*  92 */       paramGameSystemProvider.events.getListeners(EnemyReachTarget.class).addStateAffectingWithPriority(this.b, 2000);
/*  93 */       return true;
/*     */     } 
/*     */     
/*  96 */     activeMod.getMod().setRegisteredPower(this.power);
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 103 */     return GameplayModCategory.DEFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final LowHpEnemiesDealNoDamage applyConfig(JsonValue paramJsonValue) {
/* 108 */     super.applyConfig(paramJsonValue);
/* 109 */     this.hpPerPower = paramJsonValue.getFloat("hpPerPower", this.hpPerPower);
/* 110 */     this.baseHp = paramJsonValue.getFloat("baseHp", this.baseHp);
/* 111 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyReachTarget
/*     */     implements KryoSerializable, Listener<EnemyReachTarget> {
/*     */     private LowHpEnemiesDealNoDamage a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 120 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 125 */       this.a = (LowHpEnemiesDealNoDamage)param1Kryo.readObject(param1Input, LowHpEnemiesDealNoDamage.class);
/*     */     }
/*     */     
/*     */     private OnEnemyReachTarget() {}
/*     */     
/*     */     private OnEnemyReachTarget(LowHpEnemiesDealNoDamage param1LowHpEnemiesDealNoDamage) {
/* 131 */       this.a = param1LowHpEnemiesDealNoDamage;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyReachTarget param1EnemyReachTarget) {
/* 136 */       LowHpEnemiesDealNoDamage.a().i("EnemyReachTarget event", new Object[0]);
/*     */       float f;
/* 138 */       if ((f = param1EnemyReachTarget.getEnemy().getHealth() / (param1EnemyReachTarget.getEnemy()).maxHealth) * 100.0F <= this.a.getHpThreshold()) {
/* 139 */         LowHpEnemiesDealNoDamage.a().i("enemy is low on hp, no damage to the base", new Object[0]);
/*     */         NoDamageBuff noDamageBuff;
/* 141 */         (noDamageBuff = new NoDamageBuff()).setup(3600.0F, 3600.0F);
/* 142 */         (LowHpEnemiesDealNoDamage.a(this.a)).buff.P_NO_DAMAGE.addBuff(param1EnemyReachTarget.getEnemy(), noDamageBuff);
/*     */       } 
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 151 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 154 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 159 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("LowHpEnemiesDealNoDamage");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new LowHpEnemiesDealNoDamage()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 170 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\LowHpEnemiesDealNoDamage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */