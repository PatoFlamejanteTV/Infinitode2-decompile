/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.GiveDamageToEnemy;
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
/*     */ public final class CriticalDamage
/*     */   extends GenericGameplayMod
/*     */   implements Listener<GiveDamageToEnemy>
/*     */ {
/*  35 */   public float baseChance = 5.0F;
/*  36 */   public float chancePerPower = 5.0F;
/*  37 */   public float baseDamage = 200.0F;
/*  38 */   public float damagePerPower = 0.0F;
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider a;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  45 */     super.write(paramKryo, paramOutput);
/*  46 */     paramOutput.writeFloat(this.baseChance);
/*  47 */     paramOutput.writeFloat(this.chancePerPower);
/*  48 */     paramOutput.writeFloat(this.baseDamage);
/*  49 */     paramOutput.writeFloat(this.damagePerPower);
/*  50 */     paramKryo.writeObjectOrNull(paramOutput, this.a, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  55 */     super.read(paramKryo, paramInput);
/*  56 */     this.baseChance = paramInput.readFloat();
/*  57 */     this.chancePerPower = paramInput.readFloat();
/*  58 */     this.baseDamage = paramInput.readFloat();
/*  59 */     this.damagePerPower = paramInput.readFloat();
/*  60 */     this.a = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  65 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  70 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.CriticalDamage");
/*     */   }
/*     */   
/*     */   public final float getChanceMultiplier() {
/*  74 */     return (this.baseChance + this.chancePerPower * this.power) * 0.01F;
/*     */   }
/*     */   
/*     */   public final float getDamageMultiplier() {
/*  78 */     return (this.baseDamage + this.damagePerPower * this.power) * 0.01F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  83 */     String str1 = StringFormatter.compactNumberWithPrecisionTrimZeros((getChanceMultiplier() * 100.0F), 1, true).toString();
/*  84 */     String str2 = StringFormatter.compactNumberWithPrecisionTrimZeros((getDamageMultiplier() * 100.0F), 1, true).toString();
/*  85 */     return Game.i.localeManager.i18n.format("gmod_descr_critical_damage", new Object[] { str1, str2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public final CriticalDamage cpy() {
/*  90 */     CriticalDamage criticalDamage = new CriticalDamage();
/*  91 */     a(criticalDamage);
/*  92 */     criticalDamage.baseChance = this.baseChance;
/*  93 */     criticalDamage.chancePerPower = this.chancePerPower;
/*  94 */     criticalDamage.baseDamage = this.baseDamage;
/*  95 */     criticalDamage.damagePerPower = this.damagePerPower;
/*  96 */     return criticalDamage;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 102 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(CriticalDamage.class, paramString)) == null) {
/*     */       
/* 104 */       this.a = paramGameSystemProvider;
/* 105 */       paramGameSystemProvider.events.getListeners(GiveDamageToEnemy.class).addStateAffecting(this);
/* 106 */       return true;
/*     */     } 
/*     */     
/* 109 */     activeMod.getMod().setRegisteredPower(this.power);
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final CriticalDamage applyConfig(JsonValue paramJsonValue) {
/* 116 */     super.applyConfig(paramJsonValue);
/* 117 */     this.baseChance = paramJsonValue.getFloat("baseChance", this.baseChance);
/* 118 */     this.chancePerPower = paramJsonValue.getFloat("chancePerPower", this.chancePerPower);
/* 119 */     this.baseDamage = paramJsonValue.getFloat("baseDamage", this.baseDamage);
/* 120 */     this.damagePerPower = paramJsonValue.getFloat("damagePerPower", this.damagePerPower);
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void handleEvent(GiveDamageToEnemy paramGiveDamageToEnemy) {
/*     */     DamageRecord damageRecord;
/* 127 */     if (!DamageType.Efficiency.isCritical((damageRecord = paramGiveDamageToEnemy.getRecord()).getEfficiency()) && this.a.gameState.randomFloat() < getChanceMultiplier()) {
/* 128 */       damageRecord.setDamage(damageRecord.getDamage() * getDamageMultiplier());
/* 129 */       damageRecord.setEfficiency(damageRecord.getEfficiency() | 0x1);
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     static {
/* 137 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     } private static final BonusProvider a;
/*     */     public static BonusProvider getInstance() {
/* 140 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 145 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("CriticalDamage");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 155 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new CriticalDamage()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).setPowerUpProbabilityMultiplier(0.9F).applyConfig(jsonValue))) != null)
/* 156 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\CriticalDamage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */