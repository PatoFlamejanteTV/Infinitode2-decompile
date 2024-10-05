/*     */ package com.prineside.tdi2.tiles;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class RoadTile extends Tile {
/*     */   private RoadTile() {
/*  22 */     super(TileType.ROAD);
/*     */   }
/*     */   
/*     */   public final int getSortingScore(ItemSortingType paramItemSortingType) {
/*  26 */     if (paramItemSortingType == ItemSortingType.RARITY) {
/*  27 */       return getRarity().ordinal() * 1000;
/*     */     }
/*  29 */     return 10000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRoadType() {
/*  35 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RarityType getRarity() {
/*  40 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getWalkCost(boolean paramBoolean) {
/*  45 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ItemSubcategoryType getInventorySubcategory() {
/*  50 */     return ItemSubcategoryType.ME_ROADS;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Group generateUiIcon(float paramFloat) {
/*  55 */     TextureRegion textureRegion = Game.i.tileManager.getRoadTexture(null, null, null, null);
/*     */     
/*     */     Group group;
/*  58 */     (group = new Group()).setTransform(false);
/*     */     Image image;
/*  60 */     (image = new Image((Drawable)new TextureRegionDrawable(textureRegion))).setSize(paramFloat, paramFloat);
/*  61 */     group.addActor((Actor)image);
/*     */     
/*  63 */     return group;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void addSellItems(Array<ItemStack> paramArray) {
/*  68 */     paramArray.add(new ItemStack((Item)Item.D.GREEN_PAPER, 150));
/*     */   }
/*     */ 
/*     */   
/*     */   public final double getPrestigeScore() {
/*  73 */     return 0.05D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeUpgraded() {
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public static class RoadTileFactory extends Tile.Factory.AbstractFactory<RoadTile> {
/*     */     public RoadTileFactory() {
/*  83 */       super(TileType.ROAD);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getProbabilityForPrize(float param1Float, ProgressManager.InventoryStatistics param1InventoryStatistics) {
/*  88 */       if (param1Float >= 0.2F) return 0;
/*     */       
/*     */       int i;
/*  91 */       if ((i = param1InventoryStatistics.byTileType[TileType.ROAD.ordinal()]) < 5)
/*  92 */         return 250; 
/*  93 */       if (i < 15)
/*  94 */         return 150; 
/*  95 */       if (i < 50)
/*  96 */         return 100; 
/*  97 */       if (i < 150) {
/*  98 */         return 50;
/*     */       }
/* 100 */       return 10;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public RoadTile create() {
/* 106 */       return new RoadTile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\tiles\RoadTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */