/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.AddBuffToEnemy;
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
/*     */ 
/*     */ @REGS
/*     */ public final class DebuffsLastLonger
/*     */   extends GenericGameplayMod
/*     */   implements Listener<AddBuffToEnemy>
/*     */ {
/*  35 */   public float baseDuration = 0.0F;
/*  36 */   public float durationPerPower = 0.2F;
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider a;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  43 */     super.write(paramKryo, paramOutput);
/*  44 */     paramOutput.writeFloat(this.baseDuration);
/*  45 */     paramOutput.writeFloat(this.durationPerPower);
/*  46 */     paramKryo.writeObjectOrNull(paramOutput, this.a, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  51 */     super.read(paramKryo, paramInput);
/*  52 */     this.baseDuration = paramInput.readFloat();
/*  53 */     this.durationPerPower = paramInput.readFloat();
/*  54 */     this.a = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  59 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  64 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.DebuffsLastLonger");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  69 */     return Game.i.localeManager.i18n.format("gmod_descr_debuffs_last_longer", new Object[] { StringFormatter.compactNumberWithPrecisionTrimZeros((this.durationPerPower * this.power * 100.0F), 1, true) });
/*     */   }
/*     */   
/*     */   public final float getDurationMultiplier() {
/*  73 */     return 1.0F + this.baseDuration + this.durationPerPower * this.power;
/*     */   }
/*     */ 
/*     */   
/*     */   public final DebuffsLastLonger cpy() {
/*  78 */     DebuffsLastLonger debuffsLastLonger = new DebuffsLastLonger();
/*  79 */     a(debuffsLastLonger);
/*  80 */     debuffsLastLonger.baseDuration = this.baseDuration;
/*  81 */     debuffsLastLonger.durationPerPower = this.durationPerPower;
/*  82 */     return debuffsLastLonger;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/*  88 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(DebuffsLastLonger.class, paramString)) == null) {
/*     */       
/*  90 */       this.a = paramGameSystemProvider;
/*  91 */       paramGameSystemProvider.events.getListeners(AddBuffToEnemy.class).addStateAffectingWithPriority(this, 1000);
/*  92 */       return true;
/*     */     } 
/*     */     
/*  95 */     activeMod.getMod().setRegisteredPower(this.power);
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final DebuffsLastLonger applyConfig(JsonValue paramJsonValue) {
/* 102 */     super.applyConfig(paramJsonValue);
/* 103 */     this.durationPerPower = paramJsonValue.getFloat("durationPerPower", this.durationPerPower);
/* 104 */     this.baseDuration = paramJsonValue.getFloat("baseDuration", this.baseDuration);
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void handleEvent(AddBuffToEnemy paramAddBuffToEnemy) {
/* 110 */     Buff buff = paramAddBuffToEnemy.getBuff();
/* 111 */     if (this.a.buff.getProcessor(buff.getType()).isDebuff()) {
/* 112 */       float f = Math.min(buff.maxDuration, buff.duration * getDurationMultiplier());
/*     */       
/* 114 */       buff.duration = f;
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     static {
/* 122 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     } private static final BonusProvider a;
/*     */     public static BonusProvider getInstance() {
/* 125 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 130 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("DebuffsLastLonger");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new DebuffsLastLonger()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 141 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\DebuffsLastLonger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */