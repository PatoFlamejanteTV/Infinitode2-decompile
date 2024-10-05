/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.MinerMineItem;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class MinedItemsTurnIntoDust extends GenericGameplayMod implements Listener<MinerMineItem> {
/*  38 */   private static final TLog a = TLog.forClass(MinedItemsTurnIntoDust.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   public float baseBonus = 0.0F;
/*  46 */   public float bonusPerPower = 0.2F;
/*  47 */   public int stackSize = 500;
/*  48 */   public int stackSizePerPower = 250;
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider b;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  55 */     super.write(paramKryo, paramOutput);
/*  56 */     paramOutput.writeFloat(this.baseBonus);
/*  57 */     paramOutput.writeFloat(this.bonusPerPower);
/*  58 */     paramOutput.writeInt(this.stackSize);
/*  59 */     paramOutput.writeInt(this.stackSizePerPower);
/*  60 */     paramKryo.writeObjectOrNull(paramOutput, this.b, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  65 */     super.read(paramKryo, paramInput);
/*  66 */     this.baseBonus = paramInput.readFloat();
/*  67 */     this.bonusPerPower = paramInput.readFloat();
/*  68 */     this.stackSize = paramInput.readInt();
/*  69 */     this.stackSizePerPower = paramInput.readInt();
/*  70 */     this.b = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  75 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  80 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.MinedItemsTurnIntoDust");
/*     */   }
/*     */   
/*     */   public final float getBonusMultiplier() {
/*  84 */     return this.baseBonus + this.bonusPerPower * this.power;
/*     */   }
/*     */   
/*     */   public final int getStackSize() {
/*  88 */     return MathUtils.round((this.stackSize + this.stackSizePerPower * this.power));
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  93 */     String str1 = StringFormatter.compactNumberWithPrecisionTrimZeros((getBonusMultiplier() * 100.0F), 1, true).toString();
/*  94 */     String str2 = StringFormatter.commaSeparatedNumber(getStackSize()).toString();
/*  95 */     return Game.i.localeManager.i18n.format("gmod_descr_mined_items_turn_into_dust", new Object[] { str1, str2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public final MinedItemsTurnIntoDust cpy() {
/* 100 */     MinedItemsTurnIntoDust minedItemsTurnIntoDust = new MinedItemsTurnIntoDust();
/* 101 */     a(minedItemsTurnIntoDust);
/* 102 */     minedItemsTurnIntoDust.baseBonus = this.baseBonus;
/* 103 */     minedItemsTurnIntoDust.bonusPerPower = this.bonusPerPower;
/* 104 */     minedItemsTurnIntoDust.stackSize = this.stackSize;
/* 105 */     minedItemsTurnIntoDust.stackSizePerPower = this.stackSizePerPower;
/* 106 */     return minedItemsTurnIntoDust;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 111 */     return ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 116 */     if ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0) {
/* 117 */       return () -> Game.i.localeManager.i18n.get("gpmod_precondition_no_source_tiles_on_map");
/*     */     }
/* 119 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 125 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(MinedItemsTurnIntoDust.class, paramString)) == null) {
/*     */       
/* 127 */       this.b = paramGameSystemProvider;
/* 128 */       paramGameSystemProvider.events.getListeners(MinerMineItem.class).addStateAffectingWithPriority(this, 1000);
/*     */     } else {
/*     */       
/* 131 */       activeMod.getMod().setRegisteredPower(this.power);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     return (activeMod == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final MinedItemsTurnIntoDust applyConfig(JsonValue paramJsonValue) {
/* 142 */     super.applyConfig(paramJsonValue);
/* 143 */     this.baseBonus = paramJsonValue.getFloat("baseBonus", this.baseBonus);
/* 144 */     this.bonusPerPower = paramJsonValue.getFloat("bonusPerPower", this.bonusPerPower);
/* 145 */     this.stackSize = paramJsonValue.getInt("stackSize", this.stackSize);
/* 146 */     this.stackSizePerPower = paramJsonValue.getInt("stackSizePerPower", this.stackSizePerPower);
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void handleEvent(MinerMineItem paramMinerMineItem) {
/* 157 */     Miner miner = paramMinerMineItem.getMiner();
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/*     */     TileItem tileItem;
/*     */ 
/*     */     
/* 166 */     if (paramMinerMineItem.getItemStack().getItem() instanceof TileItem && (i = (int)((tileItem = (TileItem)paramMinerMineItem.getItemStack().getItem()).tile.getPrestigeScore() * 0.25D * 1000.0D * this.b.gameValue.getPercentValueAsMultiplier(GameValueType.PRESTIGE_DUST_DROP_RATE) * (1.0F + getBonusMultiplier()))) > 0) {
/* 167 */       a.i("turning " + paramMinerMineItem.getItemStack() + " into " + i + " dust", new Object[0]);
/* 168 */       Array array = this.b.loot.getOrCreateSourceMinedItems(miner.getTile().getX(), miner.getTile().getY());
/* 169 */       int j = getStackSize();
/*     */       
/* 171 */       int k = 0;
/*     */       
/*     */       int m;
/* 174 */       for (m = 0; m < array.size; m++) {
/*     */         ItemStack itemStack; int n;
/* 176 */         if ((itemStack = (ItemStack)array.get(m)).getItem() instanceof com.prineside.tdi2.items.PrestigeDustItem && (
/*     */           
/* 178 */           n = j - itemStack.getCount()) > 0) {
/* 179 */           n = Math.min(i, n);
/* 180 */           i -= n;
/* 181 */           k += n;
/* 182 */           itemStack.setCount(itemStack.getCount() + n);
/* 183 */           if (i != 0)
/*     */             continue; 
/*     */           break;
/*     */         } 
/*     */         continue;
/*     */       } 
/* 189 */       if (i > 0) {
/*     */         
/* 191 */         m = this.b.loot.getLootSlots(miner.type);
/* 192 */         while (i > 0 && 
/* 193 */           array.size < m) {
/*     */           
/* 195 */           int n = Math.min(i, j);
/* 196 */           i -= n;
/* 197 */           k += n;
/* 198 */           array.add(new ItemStack((Item)Item.D.PRESTIGE_DUST, n));
/* 199 */           if (i != 0);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       if (k > 0) {
/* 210 */         paramMinerMineItem.setCancelled(false);
/* 211 */         paramMinerMineItem.setItemStack(new ItemStack((Item)Item.D.PRESTIGE_DUST, k));
/* 212 */         paramMinerMineItem.setAddToEmptyItemSlot(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 222 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 225 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 230 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("MinedItemsTurnIntoDust");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 239 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new MinedItemsTurnIntoDust()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 240 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\MinedItemsTurnIntoDust.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */