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
/*     */ @REGS(serializer = ResearchTokenItem.Serializer.class)
/*     */ public class ResearchTokenItem extends Item implements Item.UsableItem {
/*     */   public static class Serializer extends SingletonSerializer<ResearchTokenItem> {
/*     */     public ResearchTokenItem read() {
/*  21 */       return Item.D.RESEARCH_TOKEN;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private ResearchTokenItem() {}
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  30 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  35 */     return ItemType.RESEARCH_TOKEN;
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
/*  50 */     return Game.i.localeManager.i18n.get("item_title_RESEARCH_TOKEN");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  55 */     return Game.i.localeManager.i18n.get("item_description_RESEARCH_TOKEN");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  60 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  65 */     return "research_token";
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
/*  81 */       (image1 = new Image(ResearchTokenItemFactory.a(Item.D.F_RESEARCH_TOKEN))).setSize(paramFloat, paramFloat);
/*  82 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  83 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  84 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  87 */       (image1 = new Image(ResearchTokenItemFactory.a(Item.D.F_RESEARCH_TOKEN))).setSize(paramFloat, paramFloat);
/*  88 */       group.addActor((Actor)image1);
/*     */       
/*  90 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  93 */     (image = new Image(ResearchTokenItemFactory.a(Item.D.F_RESEARCH_TOKEN))).setSize(paramFloat, paramFloat);
/*     */     
/*  95 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoUseWhenAdded() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItem() {
/* 106 */     Game.i.screenManager.goToResearchesScreen();
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItemNeedsConfirmation() {
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ResearchTokenItemFactory
/*     */     implements Item.Factory<ResearchTokenItem>
/*     */   {
/* 121 */     private final ResearchTokenItem a = new ResearchTokenItem((byte)0);
/*     */     
/*     */     private Drawable b;
/*     */     
/*     */     public void setup() {
/* 126 */       if (Game.i.assetManager != null) {
/* 127 */         this.b = (Drawable)Game.i.assetManager.getDrawable("research-token");
/*     */       }
/*     */     }
/*     */     
/*     */     public ResearchTokenItem create() {
/* 132 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public ResearchTokenItem fromJson(JsonValue param1JsonValue) {
/* 137 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public ResearchTokenItem createDefault() {
/* 142 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\ResearchTokenItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */