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
/*     */ @REGS(serializer = AbilityTokenItem.Serializer.class)
/*     */ public class AbilityTokenItem
/*     */   extends Item {
/*     */   public static class Serializer extends SingletonSerializer<AbilityTokenItem> {
/*     */     public AbilityTokenItem read() {
/*  22 */       return Item.D.ABILITY_TOKEN;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private AbilityTokenItem() {}
/*     */ 
/*     */   
/*     */   public boolean isAffectedByDoubleGain() {
/*  31 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemType getType() {
/*  36 */     return ItemType.ABILITY_TOKEN;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCategoryType getCategory() {
/*  41 */     return ItemCategoryType.MATERIALS;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemSubcategoryType getSubcategory() {
/*  46 */     return ItemSubcategoryType.M_TOKENS;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getTitle() {
/*  51 */     return Game.i.localeManager.i18n.get("item_title_ABILITY_TOKEN");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getDescription() {
/*  56 */     return Game.i.localeManager.i18n.get("item_description_ABILITY_TOKEN");
/*     */   }
/*     */ 
/*     */   
/*     */   public RarityType getRarity() {
/*  61 */     return RarityType.EPIC;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnalyticName() {
/*  66 */     return "ability_token";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCountable() {
/*  71 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*  76 */     if (paramBoolean) {
/*     */       Group group;
/*  78 */       (group = new Group()).setTransform(false);
/*  79 */       group.setSize(paramFloat, paramFloat);
/*     */       
/*     */       Image image1;
/*  82 */       (image1 = new Image(AbilityTokenItemFactory.a(Item.D.F_ABILITY_TOKEN))).setSize(paramFloat, paramFloat);
/*  83 */       image1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  84 */       image1.setPosition(a(paramFloat), -a(paramFloat));
/*  85 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/*  88 */       (image1 = new Image(AbilityTokenItemFactory.a(Item.D.F_ABILITY_TOKEN))).setSize(paramFloat, paramFloat);
/*  89 */       group.addActor((Actor)image1);
/*     */       
/*  91 */       return (Actor)group;
/*     */     } 
/*     */     Image image;
/*  94 */     (image = new Image(AbilityTokenItemFactory.a(Item.D.F_ABILITY_TOKEN))).setSize(paramFloat, paramFloat);
/*     */     
/*  96 */     return (Actor)image;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AbilityTokenItemFactory
/*     */     implements Item.Factory<AbilityTokenItem>
/*     */   {
/* 106 */     private final AbilityTokenItem a = new AbilityTokenItem((byte)0);
/*     */     
/*     */     private Drawable b;
/*     */     
/*     */     public void setup() {
/* 111 */       if (Game.i.assetManager != null) {
/* 112 */         this.b = (Drawable)Game.i.assetManager.getDrawable("ability-token");
/*     */       }
/*     */     }
/*     */     
/*     */     public AbilityTokenItem create() {
/* 117 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public AbilityTokenItem fromJson(JsonValue param1JsonValue) {
/* 122 */       return create();
/*     */     }
/*     */ 
/*     */     
/*     */     public AbilityTokenItem createDefault() {
/* 127 */       return create();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\AbilityTokenItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */