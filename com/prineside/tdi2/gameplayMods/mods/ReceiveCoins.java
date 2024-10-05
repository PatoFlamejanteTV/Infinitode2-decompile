/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
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
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class ReceiveCoins
/*     */   extends GenericGameplayMod {
/*  26 */   private int a = 100;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float b;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  37 */     super.write(paramKryo, paramOutput);
/*  38 */     paramOutput.writeInt(this.a);
/*  39 */     paramOutput.writeFloat(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  44 */     super.read(paramKryo, paramInput);
/*  45 */     this.a = paramInput.readInt();
/*  46 */     this.b = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  56 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.ReceiveCoins");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  61 */     return Game.i.localeManager.i18n.format("gmod_descr_receive_coins", new Object[] { Integer.valueOf(this.a) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final ReceiveCoins cpy() {
/*  66 */     ReceiveCoins receiveCoins = new ReceiveCoins();
/*  67 */     a(receiveCoins);
/*  68 */     receiveCoins.a = this.a;
/*  69 */     receiveCoins.b = this.b;
/*  70 */     return receiveCoins;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void configure(GameSystemProvider paramGameSystemProvider) {
/*  75 */     if (this.b > 0.0F && paramGameSystemProvider.wave.wave != null) {
/*  76 */       this.a = MathUtils.round(paramGameSystemProvider.wave.wave.enemiesSumBounty * this.b);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*  82 */     paramGameSystemProvider.gameState.addMoney(this.a, true);
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/*  85 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(ReceiveCoins.class, paramString)) != null) {
/*  86 */       activeMod.getMod().setRegisteredPower(this.power);
/*  87 */       return false;
/*     */     } 
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  95 */     return GameplayModCategory.ECONOMICS;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ReceiveCoins applyConfig(JsonValue paramJsonValue) {
/* 100 */     super.applyConfig(paramJsonValue);
/* 101 */     this.a = paramJsonValue.getInt("amount", this.a);
/* 102 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     static {
/* 109 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     } private static final BonusProvider a;
/*     */     public static BonusProvider getInstance() {
/* 112 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 117 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("ReceiveCoins");
/*     */       
/*     */       ReceiveCoins receiveCoins;
/* 120 */       ReceiveCoins.a(receiveCoins = (new ReceiveCoins()).applyConfig(jsonValue), jsonValue.getFloat("waveCoinValue", 3.0F));
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 128 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(receiveCoins, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).applyConfig(jsonValue))) != null)
/* 129 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\ReceiveCoins.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */