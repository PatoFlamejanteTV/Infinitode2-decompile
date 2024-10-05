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
/*     */ @REGS(serializer = AcceleratorItem.Serializer.class)
/*     */ public class AcceleratorItem extends Item {
/*     */   public static class Serializer extends SingletonSerializer<AcceleratorItem> {
/*     */     public AcceleratorItem read() {
/*  21 */       return Item.D.ACCELERATOR;
/*     */     }
/*     */   }
/*     */   
/*     */   private AcceleratorItem() {}
/*     */   
/*     */   public ItemType getType() {
/*  28 */     return ItemType.ACCELERATOR;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  33 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  38 */     return ItemSubcategoryType.M_CURRENCY;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  43 */     if (paramBoolean) {
/*     */       Group group;
/*  45 */       (group = new Group()).setTransform(false);
/*  46 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  49 */       (image1 = new Image(Item.D.F_ACCELERATOR.a)).setSize(paramFloat, paramFloat);
/*  50 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  51 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  52 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  55 */       (image1 = new Image(Item.D.F_ACCELERATOR.a)).setSize(paramFloat, paramFloat);
/*  56 */       group.addActor((Actor)image1);
/*     */       
/*  58 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  61 */     (image = new Image(Item.D.F_ACCELERATOR.a)).setSize(paramFloat, paramFloat);
/*     */     
/*  63 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  69 */     return Game.i.localeManager.i18n.get("item_title_ACCELERATOR");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  74 */     return Game.i.localeManager.i18n.get("item_description_ACCELERATOR");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  79 */     return RarityType.VERY_RARE;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  84 */     return "accelerator";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AcceleratorItemFactory
/*     */     implements Item.Factory<AcceleratorItem>
/*     */   {
/*  98 */     private final AcceleratorItem b = new AcceleratorItem((byte)0);
/*     */     
/*     */     Drawable a;
/*     */     
/*     */     public void setup() {
/* 103 */       if (Game.i.assetManager != null) {
/* 104 */         this.a = (Drawable)Game.i.assetManager.getDrawable("time-accelerator");
/*     */       }
/*     */     }
/*     */     
/*     */     public AcceleratorItem create() {
/* 109 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public AcceleratorItem fromJson(JsonValue param1JsonValue) {
/* 114 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public AcceleratorItem createDefault() {
/* 119 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\AcceleratorItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */