/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = RandomTileItem.Serializer.class)
/*     */ public class RandomTileItem
/*     */   extends Item {
/*     */   public float quality;
/*     */   
/*     */   public static class Serializer extends com.esotericsoftware.kryo.Serializer<RandomTileItem> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, RandomTileItem param1RandomTileItem) {
/*  34 */       param1Output.writeFloat(param1RandomTileItem.quality);
/*     */     }
/*     */ 
/*     */     
/*     */     public RandomTileItem read(Kryo param1Kryo, Input param1Input, Class<? extends RandomTileItem> param1Class) {
/*  39 */       return Item.D.F_RANDOM_TILE.create(param1Input.readFloat());
/*     */     }
/*     */   }
/*     */   
/*     */   private RandomTileItem(float paramFloat) {
/*  44 */     if (paramFloat < 0.0F) paramFloat = 0.0F; 
/*  45 */     if (paramFloat > 1.0F) paramFloat = 1.0F;
/*     */     
/*  47 */     int i = MathUtils.round(paramFloat * 100.0F);
/*     */     
/*  49 */     this.quality = i * 0.01F;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  54 */     return Item.D.F_RANDOM_TILE.create(((RandomTileItem)paramItem).quality);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  59 */     return "random_tile_" + (MathUtils.round(this.quality * 10.0F) * 10);
/*     */   }
/*     */   
/*     */   public boolean canBeSold() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/*  67 */     float f = (float)Game.i.gameValueManager.getSnapshot().getPercentValueAsMultiplier(GameValueType.PRESTIGE_DUST_DROP_RATE);
/*     */     
/*  69 */     paramArray.add(new ItemStack(Item.D.PRESTIGE_DUST, MathUtils.ceil((199.0F * this.quality + 1.0F) * f)));
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  74 */     return Item.D.F_RANDOM_TILE.create(this.quality);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  79 */     return ItemType.RANDOM_TILE;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  84 */     return ItemCategoryType.PACKS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  89 */     return ItemSubcategoryType.P_DECRYPTED;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeUnpacked() {
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<ItemStack> openPack(ProgressManager.InventoryStatistics paramInventoryStatistics) {
/*  99 */     Array<ItemStack> array = new Array(false, 1, ItemStack.class);
/*     */     
/* 101 */     TileItem tileItem = Item.D.F_TILE.create(Game.i.tileManager
/* 102 */         .createRandomTile(this.quality, (ProgressPrefs.i()).progress.getOtherItemsRandom(), paramInventoryStatistics));
/*     */     
/* 104 */     ProgressPrefs.i().requireSave();
/* 105 */     array.add(new ItemStack(tileItem, 1));
/*     */     
/* 107 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/* 112 */     return Game.i.localeManager.i18n.get("random_tile");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 117 */     return Game.i.localeManager.i18n.get("quality") + ": " + MathUtils.round(this.quality * 100.0F) + "/100";
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 122 */     return ProgressManager.getRarityFromQuality(this.quality);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 132 */     if (!super.sameAs(paramItem)) return false;
/*     */ 
/*     */ 
/*     */     
/* 136 */     if (((RandomTileItem)(paramItem = paramItem)).quality != this.quality) return false;
/*     */     
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 143 */     super.toJson(paramJson);
/*     */     
/* 145 */     paramJson.writeValue("quality", Float.valueOf(this.quality));
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 150 */     float f = paramFloat / 128.0F;
/*     */     
/*     */     Group group;
/* 153 */     (group = new Group()).setTransform(false);
/*     */     
/*     */     Image image;
/* 156 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("random-tile"))).setSize(paramFloat, paramFloat);
/* 157 */     group.addActor((Actor)image);
/*     */     
/*     */     Label label;
/* 160 */     (label = new Label(MathUtils.round(this.quality * 100.0F) + "%", Game.i.assetManager.getLabelStyle(MathUtils.round(21.0F * f)))).setPosition(34.0F * f, 73.0F * f);
/* 161 */     group.addActor((Actor)label);
/*     */     
/* 163 */     return (Actor)group;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RandomTileItemFactory
/*     */     implements Item.Factory<RandomTileItem>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     public RandomTileItem create(float param1Float) {
/* 173 */       return new RandomTileItem(param1Float, (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public RandomTileItem fromJson(JsonValue param1JsonValue) {
/* 178 */       return create(param1JsonValue.getFloat("quality"));
/*     */     }
/*     */ 
/*     */     
/*     */     public RandomTileItem createDefault() {
/* 183 */       return create(0.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\RandomTileItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */