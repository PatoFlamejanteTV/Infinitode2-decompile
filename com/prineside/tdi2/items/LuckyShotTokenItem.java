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
/*     */ @REGS(serializer = LuckyShotTokenItem.Serializer.class)
/*     */ public class LuckyShotTokenItem extends Item {
/*     */   public static class Serializer extends SingletonSerializer<LuckyShotTokenItem> {
/*     */     public LuckyShotTokenItem read() {
/*  21 */       return Item.D.LUCKY_SHOT_TOKEN;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private LuckyShotTokenItem() {}
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  30 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  35 */     return ItemType.LUCKY_SHOT_TOKEN;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  40 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  45 */     return ItemSubcategoryType.M_TOKENS;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  50 */     return Game.i.localeManager.i18n.get("item_title_LUCKY_SHOT_TOKEN");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  55 */     return Game.i.localeManager.i18n.get("item_description_LUCKY_SHOT_TOKEN");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  60 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  65 */     return "lucky_shot_token";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  70 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  75 */     if (paramBoolean) {
/*     */       Group group;
/*  77 */       (group = new Group()).setTransform(false);
/*  78 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  81 */       (image1 = new Image(LuckyShotTokenItemFactory.a(Item.D.F_LUCKY_SHOT_TOKEN))).setSize(paramFloat, paramFloat);
/*  82 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  83 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  84 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  87 */       (image1 = new Image(LuckyShotTokenItemFactory.a(Item.D.F_LUCKY_SHOT_TOKEN))).setSize(paramFloat, paramFloat);
/*  88 */       group.addActor((Actor)image1);
/*     */       
/*  90 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  93 */     (image = new Image(LuckyShotTokenItemFactory.a(Item.D.F_LUCKY_SHOT_TOKEN))).setSize(paramFloat, paramFloat);
/*     */     
/*  95 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class LuckyShotTokenItemFactory
/*     */     implements Item.Factory<LuckyShotTokenItem>
/*     */   {
/* 105 */     private final LuckyShotTokenItem a = new LuckyShotTokenItem((byte)0);
/*     */     
/*     */     private Drawable b;
/*     */     
/*     */     public void setup() {
/* 110 */       if (Game.i.assetManager != null) {
/* 111 */         this.b = (Drawable)Game.i.assetManager.getDrawable("lucky-shot-token");
/*     */       }
/*     */     }
/*     */     
/*     */     public LuckyShotTokenItem create() {
/* 116 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public LuckyShotTokenItem fromJson(JsonValue param1JsonValue) {
/* 121 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public LuckyShotTokenItem createDefault() {
/* 126 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\LuckyShotTokenItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */