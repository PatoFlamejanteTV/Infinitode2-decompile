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
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = GreenPaperItem.Serializer.class)
/*     */ public class GreenPaperItem extends Item {
/*     */   public static class Serializer extends SingletonSerializer<GreenPaperItem> {
/*     */     public GreenPaperItem read() {
/*  22 */       return Item.D.GREEN_PAPER;
/*     */     }
/*     */   }
/*     */   
/*     */   private GreenPaperItem() {}
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  29 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  34 */     return ItemType.GREEN_PAPER;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  39 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  44 */     return ItemSubcategoryType.M_CURRENCY;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  49 */     return Game.i.localeManager.i18n.get("item_title_GREEN_PAPER");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  54 */     return Game.i.localeManager.i18n.get("item_description_GREEN_PAPER");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  59 */     return "green_paper";
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPriceInAcceleratorsForResearchReset(int paramInt) {
/*  64 */     return Math.sqrt(paramInt * 5.0E-4D);
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  69 */     return RarityType.COMMON;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Drawable getIconDrawable() {
/*  79 */     return GreenPaperItemFactory.a(Item.D.F_GREEN_PAPER);
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  84 */     if (paramBoolean) {
/*     */       Group group;
/*  86 */       (group = new Group()).setTransform(false);
/*  87 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  90 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"))).setSize(paramFloat, paramFloat);
/*  91 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  92 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  93 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  96 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"))).setSize(paramFloat, paramFloat);
/*  97 */       image1.setColor(MaterialColor.GREEN.P500);
/*  98 */       group.addActor((Actor)image1);
/*     */       
/* 100 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/* 103 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-money"))).setSize(paramFloat, paramFloat);
/* 104 */     image.setColor(MaterialColor.GREEN.P500);
/*     */     
/* 106 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class GreenPaperItemFactory
/*     */     implements Item.Factory<GreenPaperItem>
/*     */   {
/* 115 */     private final GreenPaperItem a = new GreenPaperItem((byte)0);
/*     */     
/*     */     private Drawable b;
/*     */     
/*     */     public void setup() {
/* 120 */       if (Game.i.assetManager != null) {
/* 121 */         this.b = Game.i.assetManager.getDrawable("icon-money").tint(MaterialColor.LIGHT_GREEN.P500);
/*     */       }
/*     */     }
/*     */     
/*     */     public GreenPaperItem create() {
/* 126 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public GreenPaperItem fromJson(JsonValue param1JsonValue) {
/* 131 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public GreenPaperItem createDefault() {
/* 136 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\GreenPaperItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */