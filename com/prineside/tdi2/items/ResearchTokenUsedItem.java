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
/*     */ @REGS(serializer = ResearchTokenUsedItem.Serializer.class)
/*     */ public class ResearchTokenUsedItem extends Item {
/*     */   public static class Serializer extends SingletonSerializer<ResearchTokenUsedItem> {
/*     */     public ResearchTokenUsedItem read() {
/*  21 */       return Item.D.RESEARCH_TOKEN_USED;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private ResearchTokenUsedItem() {}
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  30 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  35 */     return ItemType.RESEARCH_TOKEN_USED;
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
/*  50 */     return Game.i.localeManager.i18n.get("item_title_RESEARCH_TOKEN_USED");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  55 */     return Game.i.localeManager.i18n.get("item_description_RESEARCH_TOKEN_USED");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  60 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  65 */     return "research_token_used";
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
/*  81 */       (image1 = new Image(ResearchTokenUsedItemFactory.a(Item.D.F_RESEARCH_TOKEN_USED))).setSize(paramFloat, paramFloat);
/*  82 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  83 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  84 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  87 */       (image1 = new Image(ResearchTokenUsedItemFactory.a(Item.D.F_RESEARCH_TOKEN_USED))).setSize(paramFloat, paramFloat);
/*  88 */       group.addActor((Actor)image1);
/*     */       
/*  90 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  93 */     (image = new Image(ResearchTokenUsedItemFactory.a(Item.D.F_RESEARCH_TOKEN_USED))).setSize(paramFloat, paramFloat);
/*     */     
/*  95 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ResearchTokenUsedItemFactory
/*     */     implements Item.Factory<ResearchTokenUsedItem>
/*     */   {
/* 105 */     private final ResearchTokenUsedItem a = new ResearchTokenUsedItem((byte)0);
/*     */     
/*     */     private Drawable b;
/*     */     
/*     */     public void setup() {
/* 110 */       if (Game.i.assetManager != null) {
/* 111 */         this.b = (Drawable)Game.i.assetManager.getDrawable("research-token-used");
/*     */       }
/*     */     }
/*     */     
/*     */     public ResearchTokenUsedItem create() {
/* 116 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public ResearchTokenUsedItem fromJson(JsonValue param1JsonValue) {
/* 121 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public ResearchTokenUsedItem createDefault() {
/* 126 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\ResearchTokenUsedItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */