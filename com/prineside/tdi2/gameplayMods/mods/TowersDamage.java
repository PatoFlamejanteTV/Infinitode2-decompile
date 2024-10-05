/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameValueSystem;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class TowersDamage
/*     */   extends GenericGameplayMod {
/*  28 */   private float a = 0.0F;
/*  29 */   private float b = 15.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   private GameSystemProvider c;
/*     */ 
/*     */   
/*     */   private GameValueSystem.GlobalTowerStatMutator d;
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  41 */     super.write(paramKryo, paramOutput);
/*  42 */     paramOutput.writeFloat(this.a);
/*  43 */     paramOutput.writeFloat(this.b);
/*  44 */     paramKryo.writeObjectOrNull(paramOutput, this.c, GameSystemProvider.class);
/*  45 */     paramKryo.writeObjectOrNull(paramOutput, this.d, GameValueSystem.GlobalTowerStatMutator.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  50 */     super.read(paramKryo, paramInput);
/*  51 */     this.a = paramInput.readFloat();
/*  52 */     this.b = paramInput.readFloat();
/*  53 */     this.c = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  54 */     this.d = (GameValueSystem.GlobalTowerStatMutator)paramKryo.readObjectOrNull(paramInput, GameValueSystem.GlobalTowerStatMutator.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  59 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.TowersDamage");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  64 */     String str = StringFormatter.compactNumberWithPrecisionTrimZeros((this.a + this.b * this.power), 1, true).toString();
/*  65 */     return Game.i.localeManager.i18n.format("gmod_descr_towers_damage", new Object[] { str });
/*     */   }
/*     */ 
/*     */   
/*     */   public final TowersDamage cpy() {
/*  70 */     TowersDamage towersDamage = new TowersDamage();
/*  71 */     a(towersDamage);
/*  72 */     towersDamage.a = this.a;
/*  73 */     towersDamage.b = this.b;
/*  74 */     return towersDamage;
/*     */   }
/*     */   
/*     */   public final float getStatMultiplier() {
/*  78 */     return 1.0F + (this.a + this.b * this.power) * 0.01F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/*  84 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(TowersDamage.class, paramString)) == null) {
/*     */       
/*  86 */       this.c = paramGameSystemProvider;
/*  87 */       a();
/*  88 */       return true;
/*     */     } 
/*     */     
/*  91 */     activeMod.getMod().setRegisteredPower(this.power);
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  98 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final TowersDamage applyConfig(JsonValue paramJsonValue) {
/* 103 */     super.applyConfig(paramJsonValue);
/* 104 */     this.a = paramJsonValue.getFloat("baseValue", this.a);
/* 105 */     this.b = paramJsonValue.getFloat("valuePerPower", this.b);
/* 106 */     return this;
/*     */   }
/*     */   
/*     */   private void a() {
/* 110 */     float f = getStatMultiplier();
/* 111 */     if (this.d == null) {
/* 112 */       this.d = new GameValueSystem.GlobalTowerStatMutator("TowersDamageGMOD", f);
/* 113 */       this.c.gameValue.addGlobalTowerStatMutator(TowerStatType.DAMAGE, this.d); return;
/*     */     } 
/* 115 */     this.d.setMultiplier(f);
/* 116 */     this.c.gameValue.recalculateGlobalTowerStatMultipliers();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setRegisteredPower(int paramInt) {
/* 122 */     super.setRegisteredPower(paramInt);
/* 123 */     a();
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 130 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 133 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 138 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("TowersDamage");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 147 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new TowersDamage()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 148 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\TowersDamage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */