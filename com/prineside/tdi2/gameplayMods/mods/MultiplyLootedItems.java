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
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
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
/*     */ public final class MultiplyLootedItems
/*     */   extends GenericGameplayMod {
/*  32 */   private float a = 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  40 */     super.write(paramKryo, paramOutput);
/*  41 */     paramOutput.writeFloat(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  46 */     super.read(paramKryo, paramInput);
/*  47 */     this.a = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  57 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.MultiplyLootedItems");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  62 */     return Game.i.localeManager.i18n.format("gmod_descr_multiply_looted_items", new Object[] { StringFormatter.compactNumberWithPrecisionTrimZeros(this.a, 1, true) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final MultiplyLootedItems cpy() {
/*  67 */     MultiplyLootedItems multiplyLootedItems = new MultiplyLootedItems();
/*  68 */     a(multiplyLootedItems);
/*  69 */     multiplyLootedItems.a = this.a;
/*  70 */     return multiplyLootedItems;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*  75 */     Array array = new Array(true, 1, ItemStack.class);
/*     */     
/*     */     float f;
/*  78 */     if ((f = this.a - 1.0F) > 0.0F) {
/*     */       int i;
/*     */       
/*  81 */       if ((i = (int)(paramGameSystemProvider.gameState.calculatePrizeGreenPapers() * f)) > 0)
/*  82 */         array.add(new ItemStack((Item)Item.D.GREEN_PAPER, i)); 
/*     */       ResourceType[] arrayOfResourceType;
/*     */       int j;
/*     */       byte b;
/*  86 */       for (j = (arrayOfResourceType = ResourceType.values).length, b = 0; b < j; ) { ResourceType resourceType = arrayOfResourceType[b];
/*     */         int k;
/*  88 */         if ((k = (int)(paramGameSystemProvider.gameState.getResources(resourceType) * f + 0.01F)) > 0) {
/*  89 */           array.add(new ItemStack((Item)Item.D.F_RESOURCE.create(resourceType), k));
/*     */         }
/*     */         
/*     */         b++; }
/*     */       
/*  94 */       IssuedItems issuedItems = paramGameSystemProvider.gameState.getGameLootIssuedItems();
/*  95 */       for (j = 0; j < issuedItems.items.size; j++) {
/*     */         ItemStack itemStack; int k;
/*  97 */         if (canMultiplyItem((itemStack = (ItemStack)issuedItems.items.get(j)).getItem()) && (
/*     */           
/*  99 */           k = (int)(itemStack.getCount() * f + 0.01F)) > 0) {
/* 100 */           array.add(new ItemStack(itemStack.getItem(), k));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 105 */       float f1 = 0.0F;
/* 106 */       if (paramGameSystemProvider._gameUi != null) {
/* 107 */         f1 = Game.i.uiManager.stage.getWidth();
/*     */       }
/* 109 */       for (b = 0; b < array.size; b++) {
/* 110 */         ItemStack itemStack = (ItemStack)array.get(b);
/* 111 */         float f3 = b / (array.size - 1.0F);
/* 112 */         f = f1 * 0.33F + f1 * f3 * 0.34F;
/* 113 */         float f2 = 80.0F + MathUtils.sin(f3 * 3.1415927F) * 40.0F;
/* 114 */         paramGameSystemProvider.gameState.addLootIssuedPrizes(itemStack, f, f2, 2);
/*     */       } 
/*     */     } 
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 119 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(MultiplyLootedItems.class, paramString)) != null) {
/* 120 */       activeMod.getMod().setRegisteredPower(this.power);
/* 121 */       return false;
/*     */     } 
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 129 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final MultiplyLootedItems applyConfig(JsonValue paramJsonValue) {
/* 134 */     super.applyConfig(paramJsonValue);
/* 135 */     this.a = paramJsonValue.getFloat("multiplier", this.a);
/* 136 */     return this;
/*     */   }
/*     */   
/*     */   public static boolean canMultiplyItem(Item paramItem) {
/* 140 */     switch (null.a[paramItem.getType().ordinal()]) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       case 9:
/*     */       case 10:
/*     */       case 11:
/*     */       case 12:
/*     */       case 13:
/* 154 */         return true;
/*     */     } 
/*     */     
/* 157 */     return false;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 164 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 167 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 172 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("MultiplyLootedItems");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 181 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new MultiplyLootedItems()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.1F)).setPowerUpProbabilityMultiplier(0.3F).applyConfig(jsonValue))) != null)
/* 182 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\MultiplyLootedItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */