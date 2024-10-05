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
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = BitDustItem.Serializer.class)
/*     */ public class BitDustItem extends Item {
/*     */   public static class Serializer extends SingletonSerializer<BitDustItem> {
/*     */     public BitDustItem read() {
/*  21 */       return Item.D.BIT_DUST;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private BitDustItem() {}
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  30 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  35 */     return ItemType.BIT_DUST;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  40 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  45 */     return ItemSubcategoryType.M_DUST;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  50 */     return Game.i.localeManager.i18n.get("item_title_BIT_DUST");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  55 */     return Game.i.localeManager.i18n.get("item_description_BIT_DUST");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  60 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  65 */     return "bit_dust";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  70 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPriceInAcceleratorsForResearchReset(int paramInt) {
/*  75 */     return Math.pow(paramInt * 0.05D, 0.8D);
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable getIconDrawable() {
/*  80 */     return BitDustItemFactory.a(Item.D.F_BIT_DUST);
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  85 */     if (paramBoolean) {
/*     */       Group group;
/*  87 */       (group = new Group()).setTransform(false);
/*  88 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  91 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("dust-item"))).setSize(paramFloat, paramFloat);
/*  92 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  93 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  94 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  97 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("dust-item"))).setSize(paramFloat, paramFloat);
/*  98 */       group.addActor((Actor)image1);
/*     */       
/* 100 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/* 103 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("dust-item"))).setSize(paramFloat, paramFloat);
/*     */     
/* 105 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class BitDustItemFactory
/*     */     implements Item.Factory<BitDustItem>
/*     */   {
/* 114 */     private final BitDustItem a = new BitDustItem((byte)0);
/*     */     
/*     */     private Drawable b;
/*     */     
/*     */     public void setup() {
/* 119 */       if (Game.i.assetManager != null) {
/* 120 */         this.b = (Drawable)Game.i.assetManager.getDrawable("dust-item");
/*     */       }
/*     */     }
/*     */     
/*     */     public BitDustItem create() {
/* 125 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public BitDustItem fromJson(JsonValue param1JsonValue) {
/* 130 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public BitDustItem createDefault() {
/* 135 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\BitDustItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */