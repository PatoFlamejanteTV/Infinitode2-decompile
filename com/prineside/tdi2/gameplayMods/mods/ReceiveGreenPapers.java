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
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.ItemType;
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
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class ReceiveGreenPapers
/*     */   extends GenericGameplayMod
/*     */ {
/*  34 */   private static final TLog a = TLog.forClass(ReceiveGreenPapers.class);
/*     */ 
/*     */   
/*  37 */   private int b = 100;
/*     */ 
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */   
/*     */   private float d;
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  49 */     super.write(paramKryo, paramOutput);
/*  50 */     paramOutput.writeInt(this.b);
/*  51 */     paramOutput.writeVarInt(this.c, true);
/*  52 */     paramOutput.writeFloat(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  57 */     super.read(paramKryo, paramInput);
/*  58 */     this.b = paramInput.readInt();
/*  59 */     this.c = paramInput.readVarInt(true);
/*  60 */     this.d = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  70 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.ReceiveGreenPapers");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  75 */     return Game.i.localeManager.i18n.format("gmod_descr_receive_green_papers", new Object[] { Integer.valueOf(this.b) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final ReceiveGreenPapers cpy() {
/*  80 */     ReceiveGreenPapers receiveGreenPapers = new ReceiveGreenPapers();
/*  81 */     a(receiveGreenPapers);
/*  82 */     receiveGreenPapers.b = this.b;
/*  83 */     receiveGreenPapers.c = this.c;
/*  84 */     receiveGreenPapers.d = this.d;
/*  85 */     return receiveGreenPapers;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void configure(GameSystemProvider paramGameSystemProvider) {
/*  90 */     int i = paramGameSystemProvider.gameState.calculatePrizeGreenPapers();
/*  91 */     Array array = (paramGameSystemProvider.gameState.getGameLootIssuedItems()).items;
/*  92 */     for (byte b = 0; b < array.size; b++) {
/*     */       ItemStack itemStack;
/*  94 */       if ((itemStack = (ItemStack)array.get(b)).getItem().getType() == ItemType.GREEN_PAPER) {
/*  95 */         i += itemStack.getCount();
/*     */       }
/*     */     } 
/*  98 */     a.i("sum this game: " + i, new Object[0]);
/*     */     
/* 100 */     if ((i = MathUtils.round(i * this.d / 100.0F)) < 500) {
/* 101 */       i = 500;
/*     */     }
/* 103 */     if (this.c > 0 && i > this.c) {
/* 104 */       i = this.c;
/*     */     }
/*     */     
/* 107 */     this.b = i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 112 */     float f = 0.0F;
/* 113 */     if (paramGameSystemProvider._gameUi != null) {
/* 114 */       f = Game.i.uiManager.stage.getWidth();
/*     */     }
/* 116 */     ItemStack itemStack = new ItemStack((Item)Item.D.GREEN_PAPER, this.b);
/* 117 */     f *= 0.5F;
/*     */     
/* 119 */     paramGameSystemProvider.gameState.addLootIssuedPrizes(itemStack, f, 80.0F, 2);
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 122 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(ReceiveGreenPapers.class, paramString)) != null) {
/* 123 */       activeMod.getMod().setRegisteredPower(this.power);
/* 124 */       return false;
/*     */     } 
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 132 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ReceiveGreenPapers applyConfig(JsonValue paramJsonValue) {
/* 137 */     super.applyConfig(paramJsonValue);
/* 138 */     this.b = paramJsonValue.getInt("amount", this.b);
/* 139 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     static {
/* 146 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     } private static final BonusProvider a;
/*     */     public static BonusProvider getInstance() {
/* 149 */       return a;
/*     */     }
/*     */     public final ReceiveGreenPapers provideFallback(BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array) {
/*     */       ReceiveGreenPapers receiveGreenPapers1;
/* 153 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("ReceiveGreenPapers");
/*     */       
/*     */       ReceiveGreenPapers receiveGreenPapers2;
/* 156 */       ReceiveGreenPapers.a(receiveGreenPapers2 = (new ReceiveGreenPapers()).applyConfig(jsonValue), jsonValue.getFloat("amountPercentage", 1.0F));
/* 157 */       ReceiveGreenPapers.a(receiveGreenPapers2, jsonValue.getInt("maxAmount", 100000));
/*     */       
/* 159 */       jsonValue = null; int i;
/* 160 */       for (i = 0; i < param1Array.size; i++) {
/*     */         GameplayModSystem.ActiveMod activeMod;
/* 162 */         if ((activeMod = ((GameplayModSystem.ActiveMod[])param1Array.items)[i]).getMod().getId().equals(receiveGreenPapers2.getId()) && activeMod.getSource().equals("BonusSystem")) {
/*     */           
/* 164 */           receiveGreenPapers1 = (ReceiveGreenPapers)activeMod.getMod();
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 169 */       if (receiveGreenPapers1 != null) {
/*     */         
/* 171 */         i = Math.min(receiveGreenPapers1.getMaxPower(), receiveGreenPapers1.getPower() + 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 177 */         logger.i("found existing for proto (proto: " + receiveGreenPapers2 + ", existing: " + receiveGreenPapers1 + ")", new Object[0]);
/*     */         ReceiveGreenPapers receiveGreenPapers;
/* 179 */         (receiveGreenPapers = receiveGreenPapers2.cpy()).power = i;
/* 180 */         return receiveGreenPapers;
/*     */       } 
/*     */ 
/*     */       
/* 184 */       return receiveGreenPapers2.cpy();
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 189 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("ReceiveGreenPapers");
/*     */       
/*     */       ReceiveGreenPapers receiveGreenPapers;
/* 192 */       ReceiveGreenPapers.a(receiveGreenPapers = (new ReceiveGreenPapers()).applyConfig(jsonValue), jsonValue.getFloat("amountPercentage", 1.0F));
/* 193 */       ReceiveGreenPapers.a(receiveGreenPapers, jsonValue.getInt("maxAmount", 100000));
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 201 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(receiveGreenPapers, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.0F)).applyConfig(jsonValue))) != null)
/* 202 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\ReceiveGreenPapers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */