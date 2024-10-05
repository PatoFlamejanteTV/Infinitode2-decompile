/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = RarityBoostItem.Serializer.class)
/*     */ public class RarityBoostItem
/*     */   extends Item
/*     */   implements Item.UsableItem {
/*     */   public static final int PERCENTAGE_BONUS = 50;
/*     */   
/*     */   public static class Serializer
/*     */     extends SingletonSerializer<RarityBoostItem> {
/*     */     public RarityBoostItem read() {
/*  27 */       return Item.D.RARITY_BOOST;
/*     */     }
/*     */   }
/*     */   
/*     */   private RarityBoostItem() {}
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  34 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  39 */     return ItemType.RARITY_BOOST;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  44 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  49 */     return ItemSubcategoryType.M_TOKENS;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  54 */     return Game.i.localeManager.i18n.get("item_title_RARITY_BOOST");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  59 */     return Game.i.localeManager.i18n.format("item_description_RARITY_BOOST", new Object[] { Integer.valueOf(50) });
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  64 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  69 */     return "rarity_boost";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  79 */     if (paramBoolean) {
/*     */       Group group;
/*  81 */       (group = new Group()).setTransform(false);
/*  82 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  85 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("rarity-token"))).setSize(paramFloat, paramFloat);
/*  86 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  87 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  88 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  91 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("rarity-token"))).setSize(paramFloat, paramFloat);
/*  92 */       group.addActor((Actor)image1);
/*     */       
/*  94 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  97 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("rarity-token"))).setSize(paramFloat, paramFloat);
/*  98 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoUseWhenAdded() {
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItem() {
/* 109 */     Dialog.i().showAlert(Game.i.localeManager.i18n.get("rarity_boost_use_hint"));
/*     */     
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItemNeedsConfirmation() {
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RarityBoostItemFactory
/*     */     implements Item.Factory<RarityBoostItem>
/*     */   {
/* 123 */     private final RarityBoostItem a = new RarityBoostItem((byte)0);
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public RarityBoostItem create() {
/* 132 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public RarityBoostItem fromJson(JsonValue param1JsonValue) {
/* 137 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public RarityBoostItem createDefault() {
/* 142 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\RarityBoostItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */