/*     */ package com.prineside.tdi2.items;
/*     */ 
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResearchType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = PrestigeTokenItem.Serializer.class)
/*     */ public class PrestigeTokenItem extends Item implements Item.UsableItem {
/*     */   public static class Serializer extends SingletonSerializer<PrestigeTokenItem> {
/*     */     public PrestigeTokenItem read() {
/*  22 */       return Item.D.PRESTIGE_TOKEN;
/*     */     }
/*     */   }
/*     */   
/*     */   private PrestigeTokenItem() {}
/*     */   
/*     */   public ItemType getType() {
/*  29 */     return ItemType.PRESTIGE_TOKEN;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  34 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  39 */     return ItemSubcategoryType.M_TOKENS;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  44 */     return Game.i.localeManager.i18n.get("item_title_PRESTIGE_TOKEN");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  49 */     return Game.i.localeManager.i18n.get("item_description_PRESTIGE_TOKEN");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  54 */     return "prestige_token";
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPriceInAcceleratorsForResearchReset(int paramInt) {
/*  59 */     return Math.pow(paramInt * 0.01D, 0.95D);
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  64 */     return RarityType.LEGENDARY;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  74 */     if (paramBoolean) {
/*     */       Group group;
/*  76 */       (group = new Group()).setTransform(false);
/*  77 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  80 */       (image1 = new Image(PrestigeTokenItemFactory.a(Item.D.F_PRESTIGE_TOKEN))).setSize(paramFloat, paramFloat);
/*  81 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  82 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  83 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  86 */       (image1 = new Image(PrestigeTokenItemFactory.a(Item.D.F_PRESTIGE_TOKEN))).setSize(paramFloat, paramFloat);
/*  87 */       group.addActor((Actor)image1);
/*     */       
/*  89 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  92 */     (image = new Image(PrestigeTokenItemFactory.a(Item.D.F_PRESTIGE_TOKEN))).setSize(paramFloat, paramFloat);
/*     */     
/*  94 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean autoUseWhenAdded() {
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItem() {
/* 105 */     Game.i.screenManager.goToResearchesScreenFocusOnResearch(ResearchType.PRESTIGE);
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useItemNeedsConfirmation() {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PrestigeTokenItemFactory
/*     */     implements Item.Factory<PrestigeTokenItem>
/*     */   {
/* 120 */     private final PrestigeTokenItem a = new PrestigeTokenItem((byte)0);
/*     */     
/*     */     private Drawable b;
/*     */     
/*     */     public void setup() {
/* 125 */       if (Game.i.assetManager != null) {
/* 126 */         this.b = (Drawable)Game.i.assetManager.getDrawable("prestige-token");
/*     */       }
/*     */     }
/*     */     
/*     */     public PrestigeTokenItem create() {
/* 131 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public PrestigeTokenItem fromJson(JsonValue param1JsonValue) {
/* 136 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public PrestigeTokenItem createDefault() {
/* 141 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\PrestigeTokenItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */