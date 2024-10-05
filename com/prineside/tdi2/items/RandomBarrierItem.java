/*     */ package com.prineside.tdi2.items;
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
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = RandomBarrierItem.Serializer.class)
/*     */ public class RandomBarrierItem extends Item {
/*  28 */   private static final TLog a = TLog.forClass(RandomBarrierItem.class);
/*     */   public float quality;
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<RandomBarrierItem> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, RandomBarrierItem param1RandomBarrierItem) {
/*  34 */       param1Output.writeFloat(param1RandomBarrierItem.quality);
/*     */     }
/*     */ 
/*     */     
/*     */     public RandomBarrierItem read(Kryo param1Kryo, Input param1Input, Class<? extends RandomBarrierItem> param1Class) {
/*  39 */       return Item.D.F_RANDOM_BARRIER.create(param1Input.readFloat());
/*     */     }
/*     */   }
/*     */   
/*     */   private RandomBarrierItem(float paramFloat) {
/*  44 */     if (paramFloat < 0.0F || paramFloat > 1.0F) throw new IllegalArgumentException("Quality is " + paramFloat); 
/*  45 */     this.quality = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item cpy() {
/*  50 */     return Item.D.F_RANDOM_BARRIER.create(this.quality);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item from(Item paramItem) {
/*  55 */     return Item.D.F_RANDOM_BARRIER.create(((RandomBarrierItem)paramItem).quality);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  60 */     return ItemType.RANDOM_BARRIER;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  65 */     return ItemCategoryType.PACKS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  70 */     return ItemSubcategoryType.P_DECRYPTED;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  75 */     return "random_barrier";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeUnpacked() {
/*  80 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<ItemStack> openPack(ProgressManager.InventoryStatistics paramInventoryStatistics) {
/*  85 */     Array<ItemStack> array = new Array(false, 1, ItemStack.class);
/*     */     
/*  87 */     GateItem gateItem = Item.D.F_GATE.create(Game.i.gateManager
/*  88 */         .createRandomGate(GateType.BARRIER_TYPE, this.quality, (ProgressPrefs.i()).progress.getOtherItemsRandom()));
/*     */     
/*  90 */     ProgressPrefs.i().requireSave();
/*  91 */     array.add(new ItemStack(gateItem, 1));
/*     */     
/*  93 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  98 */     return Game.i.localeManager.i18n.get("item_title_RANDOM_BARRIER");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/* 103 */     return Game.i.localeManager.i18n.get("quality") + ": " + MathUtils.round(this.quality * 100.0F) + "/100";
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 108 */     return ProgressManager.getRarityFromQuality(this.quality);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sameAs(Item paramItem) {
/* 118 */     if (!super.sameAs(paramItem)) return false;
/*     */ 
/*     */ 
/*     */     
/* 122 */     if (((RandomBarrierItem)(paramItem = paramItem)).quality != this.quality) return false;
/*     */     
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 129 */     super.toJson(paramJson);
/*     */     
/* 131 */     paramJson.writeValue("quality", Float.valueOf(this.quality));
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*     */     Image image;
/* 137 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("random-barrier"))).setSize(paramFloat, paramFloat);
/*     */     
/* 139 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillItemCreationForm(ItemCreationOverlay paramItemCreationOverlay) {
/* 144 */     paramItemCreationOverlay.label("Quality");
/*     */     
/* 146 */     paramItemCreationOverlay.textField(String.valueOf(this.quality), paramString -> {
/*     */           try {
/*     */             paramItemCreationOverlay.currentItem = Item.D.F_RANDOM_BARRIER.create(Float.parseFloat(paramString)); paramItemCreationOverlay.updateItemIcon();
/*     */             return;
/* 150 */           } catch (Exception exception) {
/*     */             a.e("fillItemCreationForm - bad value: " + paramString, new Object[0]);
/*     */             return;
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public static class RandomBarrierItemFactory
/*     */     implements Item.Factory<RandomBarrierItem>
/*     */   {
/*     */     public void setup() {}
/*     */     
/*     */     public RandomBarrierItem create(float param1Float) {
/* 163 */       return new RandomBarrierItem(param1Float, (byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public RandomBarrierItem fromJson(JsonValue param1JsonValue) {
/* 168 */       return create(param1JsonValue.getFloat("quality"));
/*     */     }
/*     */ 
/*     */     
/*     */     public RandomBarrierItem createDefault() {
/* 173 */       return create(0.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\RandomBarrierItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */