/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = TileItem.Serializer.class)
/*     */ public class TileItem extends Item {
/*     */   public final Tile tile;
/*     */   
/*     */   public static class Serializer extends com.esotericsoftware.kryo.Serializer<TileItem> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, TileItem param1TileItem) {
/*  35 */       param1Kryo.writeClassAndObject(param1Output, param1TileItem.tile);
/*     */     }
/*     */ 
/*     */     
/*     */     public TileItem read(Kryo param1Kryo, Input param1Input, Class<? extends TileItem> param1Class) {
/*  40 */       return Item.D.F_TILE.create((Tile)param1Kryo.readClassAndObject(param1Input));
/*     */     }
/*     */   }
/*     */   
/*     */   private TileItem(Tile paramTile) {
/*  45 */     if (paramTile == null) throw new IllegalArgumentException("Tile is null");
/*     */     
/*  47 */     this.tile = paramTile;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IntArray getData() {
/*     */     IntArray intArray;
/*  54 */     (intArray = super.getData()).add(ItemDataType.TYPE.ordinal(), this.tile.type.ordinal());
/*  55 */     this.tile.getData(intArray);
/*     */     
/*  57 */     return intArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  62 */     return "tile_" + this.tile.type;
/*     */   }
/*     */   
/*     */   public boolean affectedByLuckyWheelMultiplier() {
/*  66 */     return this.tile.affectedByLuckyWheelMultiplier();
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillWithInfo(Table paramTable, float paramFloat) {
/*  71 */     this.tile.fillInventoryWithInfo(paramTable, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  76 */     this.tile.from(((TileItem)paramItem).tile);
/*  77 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  82 */     return Item.D.F_TILE.create(this.tile.cloneTile());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemCategoryType getCategory() {
/*  87 */     return ItemCategoryType.MAP_EDITOR;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  92 */     return this.tile.getInventorySubcategory();
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  97 */     return ItemType.TILE;
/*     */   }
/*     */   
/*     */   public boolean canBeSold() {
/* 101 */     return this.tile.canBeSold();
/*     */   }
/*     */   
/*     */   public RarityType getRarity() {
/* 105 */     return this.tile.getRarity();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSellItems(Array<ItemStack> paramArray) {
/* 110 */     this.tile.addSellItems(paramArray);
/*     */   }
/*     */   
/*     */   public int getSortingScore(ItemSortingType paramItemSortingType) {
/* 114 */     return this.tile.getSortingScore(paramItemSortingType);
/*     */   }
/*     */   
/*     */   public CharSequence getTitle() {
/* 118 */     return this.tile.getTitle();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 123 */     return this.tile.getDescription();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 133 */     if (!super.sameAs(paramItem)) return false;
/*     */     
/* 135 */     return ((TileItem)paramItem).tile.sameAs(this.tile);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 140 */     super.toJson(paramJson);
/*     */     
/* 142 */     paramJson.writeObjectStart("tile");
/* 143 */     this.tile.toJson(paramJson);
/* 144 */     paramJson.writeObjectEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 149 */     return (Actor)this.tile.generateUiIcon(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 154 */     paramItemCreationOverlay.label("Tile type");
/*     */     SelectBox selectBox;
/* 156 */     (selectBox = new SelectBox(paramItemCreationOverlay.selectBoxStyle)).setItems((Object[])TileType.values);
/* 157 */     selectBox.setSelected(this.tile.type);
/* 158 */     selectBox.addListener((EventListener)new ChangeListener(this, paramItemCreationOverlay, selectBox)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 161 */             this.a.currentItem = Item.D.F_TILE.create(Game.i.tileManager
/* 162 */                 .getFactory((TileType)this.b.getSelected()).create());
/*     */             
/* 164 */             this.a.updateForm();
/*     */           }
/*     */         });
/* 167 */     paramItemCreationOverlay.selectBox(selectBox);
/*     */     
/* 169 */     this.tile.fillItemCreationForm(paramItemCreationOverlay);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (tile: " + String.valueOf(this.tile) + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public static class TileItemFactory
/*     */     implements Item.Factory<TileItem>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     public TileItem create(Tile param1Tile) {
/* 184 */       return new TileItem(param1Tile, (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public TileItem fromJson(JsonValue param1JsonValue) {
/* 189 */       return create(Game.i.tileManager.createTileFromJson(param1JsonValue.get("tile")));
/*     */     }
/*     */ 
/*     */     
/*     */     public TileItem createDefault() {
/* 194 */       return create(Game.i.tileManager.getFactory(TileType.values[0]).create());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\TileItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */