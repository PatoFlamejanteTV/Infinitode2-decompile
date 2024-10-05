/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.BuffType;
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
/*     */ @REGS
/*     */ public final class ExtraDamagePerBuff
/*     */   extends GenericGameplayMod
/*     */   implements Listener<GiveDamageToEnemy> {
/*  33 */   private float a = 5.0F;
/*  34 */   private float b = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  41 */     super.write(paramKryo, paramOutput);
/*  42 */     paramOutput.writeFloat(this.a);
/*  43 */     paramOutput.writeFloat(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  48 */     super.read(paramKryo, paramInput);
/*  49 */     this.a = paramInput.readFloat();
/*  50 */     this.b = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  55 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  60 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.ExtraDamagePerBuff");
/*     */   }
/*     */   
/*     */   public final float getDamage() {
/*  64 */     return this.b + this.a * this.power;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  69 */     return Game.i.localeManager.i18n.format("gmod_descr_extra_damage_per_buff", new Object[] { StringFormatter.compactNumberWithPrecisionTrimZeros(getDamage(), 1, true) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/*  74 */     ExtraDamagePerBuff extraDamagePerBuff = new ExtraDamagePerBuff();
/*  75 */     a(extraDamagePerBuff);
/*  76 */     extraDamagePerBuff.a = this.a;
/*     */     
/*  78 */     return (GameplayMod)extraDamagePerBuff;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/*  84 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(ExtraDamagePerBuff.class, paramString)) == null) {
/*     */       
/*  86 */       paramGameSystemProvider.events.getListeners(GiveDamageToEnemy.class).addWithFlags(this, 3);
/*  87 */       return true;
/*     */     } 
/*     */     
/*  90 */     activeMod.getMod().setRegisteredPower(this.power);
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final ExtraDamagePerBuff applyConfig(JsonValue paramJsonValue) {
/*  97 */     super.applyConfig(paramJsonValue);
/*  98 */     this.a = paramJsonValue.getFloat("damagePerPwr", this.a);
/*  99 */     this.b = paramJsonValue.getFloat("baseDamage", this.b);
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void handleEvent(GiveDamageToEnemy paramGiveDamageToEnemy) {
/*     */     DamageRecord damageRecord;
/*     */     Enemy enemy;
/* 107 */     if ((enemy = (damageRecord = paramGiveDamageToEnemy.getRecord()).getEnemy()).buffsByType != null) {
/* 108 */       byte b1 = 0; BuffType[] arrayOfBuffType; int i; byte b2;
/* 109 */       for (i = (arrayOfBuffType = BuffType.values).length, b2 = 0; b2 < i; ) { BuffType buffType = arrayOfBuffType[b2];
/* 110 */         if ((enemy.buffsByType[buffType.ordinal()]).size != 0)
/* 111 */           b1++; 
/*     */         b2++; }
/*     */       
/* 114 */       if (b1 != 0) {
/*     */         
/* 116 */         float f = b1 * getDamage() * 0.01F * damageRecord.getDamage();
/* 117 */         damageRecord.setDamage(damageRecord.getDamage() + f);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable
/*     */   {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 129 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 132 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 137 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("ExtraDamagePerBuff");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 146 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new ExtraDamagePerBuff()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 147 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\ExtraDamagePerBuff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */