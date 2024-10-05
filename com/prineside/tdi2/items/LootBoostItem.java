/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.shared.ResourcesAndMoney;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = LootBoostItem.Serializer.class)
/*     */ public class LootBoostItem
/*     */   extends Item implements Item.UsableItem {
/*     */   public static final float EFFECT_DURATION = 7200.0F;
/*     */   public static final int PERCENTAGE_BONUS = 50;
/*  27 */   private static final TLog a = TLog.forClass(LootBoostItem.class);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<LootBoostItem> {
/*     */     public LootBoostItem read() {
/*  31 */       return Item.D.LOOT_BOOST;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LootBoostItem() {}
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  41 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  46 */     return ItemType.LOOT_BOOST;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  51 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  56 */     return ItemSubcategoryType.M_TOKENS;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  61 */     return Game.i.localeManager.i18n.get("item_title_LOOT_BOOST");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  66 */     return Game.i.localeManager.i18n.format("item_description_LOOT_BOOST", new Object[] { Integer.valueOf(50), StringFormatter.timePassed(MathUtils.round(7200.0F), false, true) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  71 */     return "loot_boost";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoUseWhenAdded() {
/*  76 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItem() {
/*  81 */     if (Game.i.progressManager.removeItems(this, 1)) {
/*  82 */       Game.i.analyticsManager.logCurrencySpent("used", "loot_boost", 1);
/*  83 */       (ProgressPrefs.i()).progress.setLootBoostTimeLeft((ProgressPrefs.i()).progress.getLootBoostTimeLeft() + 7200.0F);
/*  84 */       ProgressPrefs.i().requireSave();
/*     */       
/*  86 */       if (Game.i.uiManager != null) ResourcesAndMoney.i().updateBoosts();
/*     */       
/*  88 */       return true;
/*     */     } 
/*  90 */     a.e("failed to remove item on usage", new Object[0]);
/*     */     
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean useItemNeedsConfirmation() {
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/* 103 */     return RarityType.EPIC;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/* 113 */     if (paramBoolean) {
/*     */       Group group;
/* 115 */       (group = new Group()).setTransform(false);
/* 116 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/* 119 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("loot-token"))).setSize(paramFloat, paramFloat);
/* 120 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 121 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/* 122 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/* 125 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("loot-token"))).setSize(paramFloat, paramFloat);
/* 126 */       group.addActor((Actor)image1);
/*     */       
/* 128 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/* 131 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("loot-token"))).setSize(paramFloat, paramFloat);
/*     */     
/* 133 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class LootBoostItemFactory
/*     */     implements Item.Factory<LootBoostItem>
/*     */   {
/* 141 */     private final LootBoostItem a = new LootBoostItem((byte)0);
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public LootBoostItem create() {
/* 150 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public LootBoostItem fromJson(JsonValue param1JsonValue) {
/* 155 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public LootBoostItem createDefault() {
/* 160 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\LootBoostItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */