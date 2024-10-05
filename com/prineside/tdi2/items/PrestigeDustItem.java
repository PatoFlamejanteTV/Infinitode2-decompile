/*     */ package com.prineside.tdi2.items;
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
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = PrestigeDustItem.Serializer.class)
/*     */ public class PrestigeDustItem extends Item {
/*     */   public static final double RAW_PRESTIGE_COUNT_MULTIPLIER = 0.25D;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<PrestigeDustItem> {
/*     */     public PrestigeDustItem read() {
/*  22 */       return Item.D.PRESTIGE_DUST;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private PrestigeDustItem() {}
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  31 */     return ItemType.PRESTIGE_DUST;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  36 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  41 */     return ItemSubcategoryType.M_DUST;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  46 */     return Game.i.localeManager.i18n.get("item_title_PRESTIGE_DUST");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  51 */     return Game.i.localeManager.i18n.get("item_description_PRESTIGE_DUST");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  56 */     return RarityType.EPIC;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  61 */     return "prestige_dust";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  66 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  71 */     if (paramBoolean) {
/*     */       Group group;
/*  73 */       (group = new Group()).setTransform(false);
/*  74 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  77 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("dust-item-prestige"))).setSize(paramFloat, paramFloat);
/*  78 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  79 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  80 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  83 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("dust-item-prestige"))).setSize(paramFloat, paramFloat);
/*  84 */       group.addActor((Actor)image1);
/*     */       
/*  86 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  89 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("dust-item-prestige"))).setSize(paramFloat, paramFloat);
/*     */     
/*  91 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PrestigeDustItemFactory
/*     */     implements Item.Factory<PrestigeDustItem>
/*     */   {
/*  99 */     private final PrestigeDustItem a = new PrestigeDustItem((byte)0);
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public PrestigeDustItem create() {
/* 108 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public PrestigeDustItem fromJson(JsonValue param1JsonValue) {
/* 113 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public PrestigeDustItem createDefault() {
/* 118 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\PrestigeDustItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */