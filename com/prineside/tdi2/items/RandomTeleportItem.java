/*     */ package com.prineside.tdi2.items;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = RandomTeleportItem.Serializer.class)
/*     */ public class RandomTeleportItem extends Item {
/*     */   public static class Serializer extends SingletonSerializer<RandomTeleportItem> {
/*     */     public RandomTeleportItem read() {
/*  24 */       return Item.D.RANDOM_TELEPORT;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private RandomTeleportItem() {}
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  33 */     return ItemType.RANDOM_TELEPORT;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  38 */     return ItemCategoryType.PACKS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  43 */     return ItemSubcategoryType.P_DECRYPTED;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  48 */     return "random_teleport";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeUnpacked() {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<ItemStack> openPack(ProgressManager.InventoryStatistics paramInventoryStatistics) {
/*  58 */     Array<ItemStack> array = new Array(false, 1, ItemStack.class);
/*     */     
/*  60 */     GateItem gateItem = Item.D.F_GATE.create(Game.i.gateManager
/*  61 */         .createRandomGate(GateType.TELEPORT, 1.0F, (ProgressPrefs.i()).progress.getOtherItemsRandom()));
/*     */     
/*  63 */     array.add(new ItemStack(gateItem, 1));
/*  64 */     ProgressPrefs.i().requireSave();
/*     */     
/*  66 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  71 */     return Game.i.localeManager.i18n.get("random_teleport");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  76 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  81 */     return RarityType.VERY_RARE;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*     */     Image image;
/*  92 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("random-teleport"))).setSize(paramFloat, paramFloat);
/*     */     
/*  94 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RandomTeleportItemFactory
/*     */     implements Item.Factory<RandomTeleportItem>
/*     */   {
/*     */     private RandomTeleportItem a;
/*     */     
/*     */     public void setup() {}
/*     */     
/*     */     public RandomTeleportItem create() {
/* 106 */       if (this.a == null) this.a = new RandomTeleportItem((byte)0);
/*     */       
/* 108 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public RandomTeleportItem fromJson(JsonValue param1JsonValue) {
/* 113 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public RandomTeleportItem createDefault() {
/* 118 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\RandomTeleportItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */