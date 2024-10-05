/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.BlueprintType;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.items.AbilityItem;
/*     */ import com.prineside.tdi2.items.AbilityTokenItem;
/*     */ import com.prineside.tdi2.items.AcceleratorItem;
/*     */ import com.prineside.tdi2.items.BitDustItem;
/*     */ import com.prineside.tdi2.items.BlueprintItem;
/*     */ import com.prineside.tdi2.items.CaseItem;
/*     */ import com.prineside.tdi2.items.CaseKeyItem;
/*     */ import com.prineside.tdi2.items.DatPaperItem;
/*     */ import com.prineside.tdi2.items.DoubleGainShardItem;
/*     */ import com.prineside.tdi2.items.GameValueGlobalItem;
/*     */ import com.prineside.tdi2.items.GameValueLevelItem;
/*     */ import com.prineside.tdi2.items.GateItem;
/*     */ import com.prineside.tdi2.items.GreenPaperItem;
/*     */ import com.prineside.tdi2.items.LootBoostItem;
/*     */ import com.prineside.tdi2.items.LuckyShotTokenItem;
/*     */ import com.prineside.tdi2.items.OpenedResearchItem;
/*     */ import com.prineside.tdi2.items.PrestigeDustItem;
/*     */ import com.prineside.tdi2.items.PrestigeTokenItem;
/*     */ import com.prineside.tdi2.items.RandomBarrierItem;
/*     */ import com.prineside.tdi2.items.RandomTeleportItem;
/*     */ import com.prineside.tdi2.items.RandomTileItem;
/*     */ import com.prineside.tdi2.items.RarityBoostItem;
/*     */ import com.prineside.tdi2.items.ResearchTokenItem;
/*     */ import com.prineside.tdi2.items.ResearchTokenUsedItem;
/*     */ import com.prineside.tdi2.items.ResourceItem;
/*     */ import com.prineside.tdi2.items.SkillPointItem;
/*     */ import com.prineside.tdi2.items.StarItem;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.items.TrophyItem;
/*     */ import com.prineside.tdi2.managers.ItemManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Item
/*     */   implements KryoSerializable
/*     */ {
/*     */   public static class D
/*     */   {
/*     */     public static GreenPaperItem GREEN_PAPER;
/*     */     public static ResourceItem RESOURCE_SCALAR;
/*     */     public static ResourceItem RESOURCE_VECTOR;
/*     */     public static ResourceItem RESOURCE_MATRIX;
/*     */     public static ResourceItem RESOURCE_TENSOR;
/*     */     public static ResourceItem RESOURCE_INFIAR;
/*     */     public static BitDustItem BIT_DUST;
/*     */     public static PrestigeDustItem PRESTIGE_DUST;
/*     */     public static DatPaperItem DAT_PAPER;
/*     */     public static BlueprintItem BLUEPRINT_AGILITY;
/*     */     public static BlueprintItem BLUEPRINT_EXPERIENCE;
/*     */     public static BlueprintItem BLUEPRINT_POWER;
/*     */     public static BlueprintItem BLUEPRINT_SPECIAL_I;
/*     */     public static BlueprintItem BLUEPRINT_SPECIAL_II;
/*     */     public static BlueprintItem BLUEPRINT_SPECIAL_III;
/*     */     public static BlueprintItem BLUEPRINT_SPECIAL_IV;
/*     */     public static CaseKeyItem CASE_KEY_BLUE;
/*     */     public static CaseKeyItem CASE_KEY_PURPLE;
/*     */     public static CaseKeyItem CASE_KEY_ORANGE;
/*     */     public static CaseKeyItem CASE_KEY_CYAN;
/*     */     public static RarityBoostItem RARITY_BOOST;
/*     */     public static AbilityTokenItem ABILITY_TOKEN;
/*     */     public static AcceleratorItem ACCELERATOR;
/*     */     public static LootBoostItem LOOT_BOOST;
/*     */     public static PrestigeTokenItem PRESTIGE_TOKEN;
/*     */     public static ResearchTokenItem RESEARCH_TOKEN;
/*     */     public static ResearchTokenUsedItem RESEARCH_TOKEN_USED;
/*     */     public static LuckyShotTokenItem LUCKY_SHOT_TOKEN;
/*     */     public static SkillPointItem SKILL_POINT;
/*     */     public static RandomTeleportItem RANDOM_TELEPORT;
/*     */     public static StarItem STAR;
/*     */     public static BlueprintItem.BlueprintItemFactory F_BLUEPRINT;
/*     */     public static AcceleratorItem.AcceleratorItemFactory F_ACCELERATOR;
/*     */     public static AbilityTokenItem.AbilityTokenItemFactory F_ABILITY_TOKEN;
/*     */     public static DoubleGainShardItem.DoubleGainShardItemFactory F_DOUBLE_GAIN_SHARD;
/*     */     public static CaseItem.CaseItemFactory F_CASE;
/*     */     public static GateItem.GateItemFactory F_GATE;
/*     */     public static TileItem.TileItemFactory F_TILE;
/*     */     public static ResourceItem.ResourceItemFactory F_RESOURCE;
/*     */     public static RandomTileItem.RandomTileItemFactory F_RANDOM_TILE;
/*     */     public static CaseKeyItem.CaseKeyItemFactory F_CASE_KEY;
/*     */     public static AbilityItem.AbilityItemFactory F_ABILITY;
/*     */     public static TrophyItem.TrophyItemFactory F_TROPHY;
/*     */     public static GameValueGlobalItem.GameValueGlobalItemFactory F_GAME_VALUE_GLOBAL;
/*     */     public static GameValueLevelItem.GameValueLevelItemFactory F_GAME_VALUE_LEVEL;
/*     */     public static RandomBarrierItem.RandomBarrierItemFactory F_RANDOM_BARRIER;
/*     */     public static PrestigeTokenItem.PrestigeTokenItemFactory F_PRESTIGE_TOKEN;
/*     */     public static ResearchTokenItem.ResearchTokenItemFactory F_RESEARCH_TOKEN;
/*     */     public static ResearchTokenUsedItem.ResearchTokenUsedItemFactory F_RESEARCH_TOKEN_USED;
/*     */     public static LuckyShotTokenItem.LuckyShotTokenItemFactory F_LUCKY_SHOT_TOKEN;
/*     */     public static OpenedResearchItem.OpenedResearchItemFactory F_OPENED_RESEARCH;
/*     */     public static BitDustItem.BitDustItemFactory F_BIT_DUST;
/*     */     public static GreenPaperItem.GreenPaperItemFactory F_GREEN_PAPER;
/*     */     
/*     */     public static void setup() {
/*     */       ItemManager itemManager;
/* 125 */       F_ABILITY_TOKEN = (AbilityTokenItem.AbilityTokenItemFactory)(itemManager = Game.i.itemManager).getFactory(ItemType.ABILITY_TOKEN);
/* 126 */       F_ACCELERATOR = (AcceleratorItem.AcceleratorItemFactory)itemManager.getFactory(ItemType.ACCELERATOR);
/* 127 */       F_BLUEPRINT = (BlueprintItem.BlueprintItemFactory)itemManager.getFactory(ItemType.BLUEPRINT);
/* 128 */       F_CASE = (CaseItem.CaseItemFactory)itemManager.getFactory(ItemType.CASE);
/* 129 */       F_GATE = (GateItem.GateItemFactory)itemManager.getFactory(ItemType.GATE);
/* 130 */       F_TILE = (TileItem.TileItemFactory)itemManager.getFactory(ItemType.TILE);
/* 131 */       F_RESOURCE = (ResourceItem.ResourceItemFactory)itemManager.getFactory(ItemType.RESOURCE);
/* 132 */       F_RANDOM_TILE = (RandomTileItem.RandomTileItemFactory)itemManager.getFactory(ItemType.RANDOM_TILE);
/* 133 */       F_CASE_KEY = (CaseKeyItem.CaseKeyItemFactory)itemManager.getFactory(ItemType.CASE_KEY);
/* 134 */       F_ABILITY = (AbilityItem.AbilityItemFactory)itemManager.getFactory(ItemType.ABILITY);
/* 135 */       F_TROPHY = (TrophyItem.TrophyItemFactory)itemManager.getFactory(ItemType.TROPHY);
/* 136 */       F_RANDOM_BARRIER = (RandomBarrierItem.RandomBarrierItemFactory)itemManager.getFactory(ItemType.RANDOM_BARRIER);
/* 137 */       F_DOUBLE_GAIN_SHARD = (DoubleGainShardItem.DoubleGainShardItemFactory)itemManager.getFactory(ItemType.DOUBLE_GAIN_SHARD);
/* 138 */       F_GAME_VALUE_GLOBAL = (GameValueGlobalItem.GameValueGlobalItemFactory)itemManager.getFactory(ItemType.GAME_VALUE_GLOBAL);
/* 139 */       F_GAME_VALUE_LEVEL = (GameValueLevelItem.GameValueLevelItemFactory)itemManager.getFactory(ItemType.GAME_VALUE_LEVEL);
/* 140 */       F_PRESTIGE_TOKEN = (PrestigeTokenItem.PrestigeTokenItemFactory)itemManager.getFactory(ItemType.PRESTIGE_TOKEN);
/* 141 */       F_RESEARCH_TOKEN = (ResearchTokenItem.ResearchTokenItemFactory)itemManager.getFactory(ItemType.RESEARCH_TOKEN);
/* 142 */       F_RESEARCH_TOKEN_USED = (ResearchTokenUsedItem.ResearchTokenUsedItemFactory)itemManager.getFactory(ItemType.RESEARCH_TOKEN_USED);
/* 143 */       F_LUCKY_SHOT_TOKEN = (LuckyShotTokenItem.LuckyShotTokenItemFactory)itemManager.getFactory(ItemType.LUCKY_SHOT_TOKEN);
/* 144 */       F_OPENED_RESEARCH = (OpenedResearchItem.OpenedResearchItemFactory)itemManager.getFactory(ItemType.OPENED_RESEARCH);
/* 145 */       F_BIT_DUST = (BitDustItem.BitDustItemFactory)itemManager.getFactory(ItemType.BIT_DUST);
/* 146 */       F_GREEN_PAPER = (GreenPaperItem.GreenPaperItemFactory)itemManager.getFactory(ItemType.GREEN_PAPER);
/*     */ 
/*     */       
/* 149 */       GREEN_PAPER = itemManager.getFactory(ItemType.GREEN_PAPER).createDefault();
/* 150 */       RESOURCE_SCALAR = F_RESOURCE.create(ResourceType.SCALAR);
/* 151 */       RESOURCE_VECTOR = F_RESOURCE.create(ResourceType.VECTOR);
/* 152 */       RESOURCE_MATRIX = F_RESOURCE.create(ResourceType.MATRIX);
/* 153 */       RESOURCE_TENSOR = F_RESOURCE.create(ResourceType.TENSOR);
/* 154 */       RESOURCE_INFIAR = F_RESOURCE.create(ResourceType.INFIAR);
/* 155 */       BIT_DUST = itemManager.getFactory(ItemType.BIT_DUST).createDefault();
/* 156 */       PRESTIGE_DUST = itemManager.getFactory(ItemType.PRESTIGE_DUST).createDefault();
/* 157 */       DAT_PAPER = itemManager.getFactory(ItemType.DAT_PAPER).createDefault();
/* 158 */       BLUEPRINT_AGILITY = F_BLUEPRINT.create(BlueprintType.AGILITY);
/* 159 */       BLUEPRINT_EXPERIENCE = F_BLUEPRINT.create(BlueprintType.EXPERIENCE);
/* 160 */       BLUEPRINT_POWER = F_BLUEPRINT.create(BlueprintType.POWER);
/* 161 */       BLUEPRINT_SPECIAL_I = F_BLUEPRINT.create(BlueprintType.SPECIAL_I);
/* 162 */       BLUEPRINT_SPECIAL_II = F_BLUEPRINT.create(BlueprintType.SPECIAL_II);
/* 163 */       BLUEPRINT_SPECIAL_III = F_BLUEPRINT.create(BlueprintType.SPECIAL_III);
/* 164 */       BLUEPRINT_SPECIAL_IV = F_BLUEPRINT.create(BlueprintType.SPECIAL_IV);
/* 165 */       CASE_KEY_BLUE = F_CASE_KEY.create(CaseType.BLUE);
/* 166 */       CASE_KEY_PURPLE = F_CASE_KEY.create(CaseType.PURPLE);
/* 167 */       CASE_KEY_ORANGE = F_CASE_KEY.create(CaseType.ORANGE);
/* 168 */       CASE_KEY_CYAN = F_CASE_KEY.create(CaseType.CYAN);
/* 169 */       RARITY_BOOST = itemManager.getFactory(ItemType.RARITY_BOOST).createDefault();
/* 170 */       ABILITY_TOKEN = itemManager.getFactory(ItemType.ABILITY_TOKEN).createDefault();
/* 171 */       ACCELERATOR = itemManager.getFactory(ItemType.ACCELERATOR).createDefault();
/* 172 */       LOOT_BOOST = itemManager.getFactory(ItemType.LOOT_BOOST).createDefault();
/* 173 */       PRESTIGE_TOKEN = itemManager.getFactory(ItemType.PRESTIGE_TOKEN).createDefault();
/* 174 */       RESEARCH_TOKEN = itemManager.getFactory(ItemType.RESEARCH_TOKEN).createDefault();
/* 175 */       RESEARCH_TOKEN_USED = itemManager.getFactory(ItemType.RESEARCH_TOKEN_USED).createDefault();
/* 176 */       LUCKY_SHOT_TOKEN = itemManager.getFactory(ItemType.LUCKY_SHOT_TOKEN).createDefault();
/* 177 */       SKILL_POINT = itemManager.getFactory(ItemType.SKILL_POINT).createDefault();
/* 178 */       RANDOM_TELEPORT = itemManager.getFactory(ItemType.RANDOM_TELEPORT).createDefault();
/* 179 */       STAR = itemManager.getFactory(ItemType.STAR).createDefault();
/*     */     }
/*     */   }
/*     */   
/* 183 */   private static final ThreadLocal<Array<ItemStack>> a = new ThreadLocal<Array<ItemStack>>()
/*     */     {
/*     */       private static Array<ItemStack> a() {
/* 186 */         return new Array(false, 1, ItemStack.class);
/*     */       }
/*     */     }; public static interface UsableItem {
/*     */     boolean autoUseWhenAdded(); boolean useItem(); boolean useItemNeedsConfirmation(); } public void write(Kryo paramKryo, Output paramOutput) {} public void read(Kryo paramKryo, Input paramInput) {} @NAGS
/* 190 */   private IntArray b = new IntArray();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ItemType getType();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ItemCategoryType getCategory();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ItemSubcategoryType getSubcategory();
/*     */ 
/*     */   
/*     */   public int getSortingScore(ItemSortingType paramItemSortingType) {
/* 206 */     if (paramItemSortingType == ItemSortingType.RARITY) {
/* 207 */       return getRarity().ordinal() * 1000;
/*     */     }
/* 209 */     return getType().ordinal() * 1000;
/*     */   }
/*     */   public abstract CharSequence getTitle();
/*     */   public abstract CharSequence getDescription();
/*     */   public abstract RarityType getRarity();
/*     */   public IntArray getData() {
/* 215 */     this.b.clear(); return this.b;
/*     */   }
/*     */   public String getAnalyticName() {
/* 218 */     return "unknown";
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPriceInAcceleratorsForResearchReset(int paramInt) {
/* 223 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getDataOfType(ItemDataType paramItemDataType) {
/* 229 */     int i = paramItemDataType.ordinal();
/*     */     
/* 231 */     IntArray intArray = getData();
/* 232 */     for (byte b = 0; b < intArray.size; b += 2) {
/* 233 */       if (intArray.items[b] == i) {
/* 234 */         return intArray.items[b + 1];
/*     */       }
/*     */     } 
/*     */     
/* 238 */     return Integer.MIN_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/* 245 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static float a(float paramFloat) {
/* 250 */     if ((paramFloat = paramFloat * 0.05F) < 2.0F) paramFloat = 2.0F;
/*     */     
/* 252 */     return paramFloat;
/*     */   }
/*     */   public abstract Actor generateIcon(float paramFloat, boolean paramBoolean);
/*     */   @Null
/*     */   public Drawable getIconDrawable() {
/* 257 */     return null;
/*     */   }
/*     */   public boolean canBeSold() {
/* 260 */     return false;
/*     */   } public void addSellItems(Array<ItemStack> paramArray) {}
/*     */   public void addSellItemsMultiplied(Array<ItemStack> paramArray, int paramInt) {
/*     */     Array<ItemStack> array;
/* 264 */     (array = a.get()).clear();
/* 265 */     addSellItems(array);
/* 266 */     for (byte b = 0; b < array.size; b++) {
/* 267 */       ((ItemStack[])array.items)[b].setCount(PMath.multiplyWithoutOverflow(((ItemStack[])array.items)[b].getCount(), paramInt));
/*     */     }
/* 269 */     paramArray.addAll(array);
/* 270 */     array.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isCountable();
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 283 */     paramJson.writeValue("type", getType().name());
/*     */   }
/*     */   
/*     */   public String toJsonString() {
/* 287 */     Json json = new Json(JsonWriter.OutputType.json);
/* 288 */     StringWriter stringWriter = new StringWriter();
/* 289 */     json.setWriter(stringWriter);
/* 290 */     json.writeObjectStart();
/* 291 */     toJson(json);
/* 292 */     json.writeObjectEnd();
/*     */     
/* 294 */     return stringWriter.toString();
/*     */   }
/*     */   
/*     */   public boolean affectedByLuckyWheelMultiplier() {
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item cpy() {
/* 304 */     return this;
/*     */   } public boolean canBeUnpacked() {
/* 306 */     return false;
/*     */   }
/*     */   
/*     */   public Array<ItemStack> openPack(ProgressManager.InventoryStatistics paramInventoryStatistics) {
/* 310 */     if (!canBeUnpacked()) throw new RuntimeException("Is not pack");
/*     */     
/* 312 */     throw new RuntimeException("Not implemented");
/*     */   }
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/* 316 */     return false;
/*     */   }
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 320 */     if (this == paramItem) return true; 
/* 321 */     if (getType() != paramItem.getType()) return false;
/*     */     
/* 323 */     return true;
/*     */   }
/*     */   
/*     */   public static Item fromJson(JsonValue paramJsonValue) {
/* 327 */     ItemType itemType = ItemType.valueOf(paramJsonValue.getString("type"));
/* 328 */     return Game.i.itemManager.getFactory(itemType).fromJson(paramJsonValue);
/*     */   }
/*     */   
/*     */   public void fillWithInfo(Table paramTable, float paramFloat) {}
/*     */   
/*     */   public static interface Factory<T extends Item> extends EntityFactory {
/*     */     void setup();
/*     */     
/*     */     T fromJson(JsonValue param1JsonValue);
/*     */     
/*     */     T createDefault();
/*     */     
/*     */     public static abstract class AbstractFactory<T extends Item> implements Factory<T> {
/*     */       public void setup() {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Item.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */