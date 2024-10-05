/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
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
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class DoubleMiningSpeed
/*     */   extends GenericGameplayMod
/*     */ {
/*  29 */   private int a = 300;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  41 */     super.write(paramKryo, paramOutput);
/*  42 */     paramOutput.writeFloat(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  47 */     super.read(paramKryo, paramInput);
/*  48 */     this.b = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  58 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  63 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.DoubleMiningSpeed");
/*     */   }
/*     */   
/*     */   public final int getDuration() {
/*  67 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  72 */     String str = StringFormatter.timePassed(getDuration(), false, false);
/*  73 */     return Game.i.localeManager.i18n.format("gmod_descr_double_mining_speed", new Object[] { str });
/*     */   }
/*     */ 
/*     */   
/*     */   public final DoubleMiningSpeed cpy() {
/*  78 */     DoubleMiningSpeed doubleMiningSpeed = new DoubleMiningSpeed();
/*  79 */     a(doubleMiningSpeed);
/*  80 */     doubleMiningSpeed.a = this.a;
/*  81 */     doubleMiningSpeed.b = this.b;
/*  82 */     return doubleMiningSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/*  88 */     return ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*  93 */     if (paramGameSystemProvider.miner.miners.size == 0) {
/*  94 */       return () -> Game.i.localeManager.i18n.get("gpmod_precondition_no_miners_on_map");
/*     */     }
/*     */     
/*  97 */     if (paramGameSystemProvider.miner.bonusDoubleMiningSpeedTimeLeft >= this.b) {
/*     */       String str;
/*  99 */       return () -> Game.i.localeManager.i18n.format("gpmod_precondition_double_mining_speed_still_active", new Object[] { paramString });
/*     */     } 
/* 101 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 107 */     paramGameSystemProvider.miner.bonusDoubleMiningSpeedTimeLeft += getDuration();
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 110 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(DoubleMiningSpeed.class, paramString)) != null) {
/* 111 */       activeMod.getMod().setRegisteredPower(this.power);
/* 112 */       return false;
/*     */     } 
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final DoubleMiningSpeed applyConfig(JsonValue paramJsonValue) {
/* 120 */     super.applyConfig(paramJsonValue);
/* 121 */     this.a = paramJsonValue.getInt("duration", this.a);
/* 122 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     static {
/* 129 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     } private static final BonusProvider a;
/*     */     public static BonusProvider getInstance() {
/* 132 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 137 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("DoubleMiningSpeed");
/*     */       DoubleMiningSpeed doubleMiningSpeed;
/* 139 */       DoubleMiningSpeed.a(doubleMiningSpeed = (new DoubleMiningSpeed()).applyConfig(jsonValue), jsonValue.getFloat("zeroProbabilityOnDuration", 300.0F));
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */       
/* 146 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(doubleMiningSpeed, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).applyConfig(jsonValue))) != null)
/* 147 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\DoubleMiningSpeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */