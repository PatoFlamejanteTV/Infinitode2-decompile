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
/*     */ @REGS(serializer = DatPaperItem.Serializer.class)
/*     */ public class DatPaperItem extends Item {
/*     */   public static class Serializer extends SingletonSerializer<DatPaperItem> {
/*     */     public DatPaperItem read() {
/*  20 */       return Item.D.DAT_PAPER;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private DatPaperItem() {}
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  29 */     return ItemType.DAT_PAPER;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  34 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  39 */     return ItemSubcategoryType.M_CURRENCY;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  44 */     return Game.i.localeManager.i18n.get("item_title_DAT_PAPER");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  49 */     return Game.i.localeManager.i18n.get("item_description_DAT_PAPER");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  54 */     return "dat_paper";
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  59 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  69 */     if (paramBoolean) {
/*     */       Group group;
/*  71 */       (group = new Group()).setTransform(false);
/*  72 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  75 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-dat-paper"))).setSize(paramFloat, paramFloat);
/*  76 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  77 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  78 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  81 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-dat-paper"))).setSize(paramFloat, paramFloat);
/*  82 */       group.addActor((Actor)image1);
/*     */       
/*  84 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  87 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-dat-paper"))).setSize(paramFloat, paramFloat);
/*     */     
/*  89 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DatPaperItemFactory
/*     */     implements Item.Factory<DatPaperItem>
/*     */   {
/*  97 */     private final DatPaperItem a = new DatPaperItem((byte)0);
/*     */ 
/*     */ 
/*     */     
/*     */     public void setup() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public DatPaperItem create() {
/* 106 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public DatPaperItem fromJson(JsonValue param1JsonValue) {
/* 111 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public DatPaperItem createDefault() {
/* 116 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\DatPaperItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */