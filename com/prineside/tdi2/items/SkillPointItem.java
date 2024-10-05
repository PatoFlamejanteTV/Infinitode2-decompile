/*    */ package com.prineside.tdi2.items;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Item;
/*    */ import com.prineside.tdi2.enums.ItemCategoryType;
/*    */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*    */ import com.prineside.tdi2.enums.ItemType;
/*    */ import com.prineside.tdi2.enums.RarityType;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = SkillPointItem.Serializer.class)
/*    */ public class SkillPointItem extends Item {
/*    */   public static class Serializer extends SingletonSerializer<SkillPointItem> {
/*    */     public SkillPointItem read() {
/* 20 */       return Item.D.SKILL_POINT;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private SkillPointItem() {}
/*    */ 
/*    */   
/*    */   public ItemType getType() {
/* 29 */     return ItemType.SKILL_POINT;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemCategoryType getCategory() {
/* 34 */     return ItemCategoryType.OTHER;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemSubcategoryType getSubcategory() {
/* 39 */     return ItemSubcategoryType.O_OTHER;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence getTitle() {
/* 44 */     return Game.i.localeManager.i18n.get("item_title_SKILL_POINT");
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence getDescription() {
/* 49 */     return Game.i.localeManager.i18n.get("item_description_SKILL_POINT");
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAnalyticName() {
/* 54 */     return "skill_point";
/*    */   }
/*    */ 
/*    */   
/*    */   public RarityType getRarity() {
/* 59 */     return RarityType.LEGENDARY;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCountable() {
/* 64 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*    */     Image image;
/* 70 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-skill-point"))).setSize(paramFloat, paramFloat);
/* 71 */     image.setColor(MaterialColor.CYAN.P500);
/*    */     
/* 73 */     return (Actor)image;
/*    */   }
/*    */ 
/*    */   
/*    */   public static class SkillPointItemFactory
/*    */     implements Item.Factory<SkillPointItem>
/*    */   {
/* 80 */     private final SkillPointItem a = new SkillPointItem((byte)0);
/*    */ 
/*    */ 
/*    */     
/*    */     public void setup() {}
/*    */ 
/*    */ 
/*    */     
/*    */     public SkillPointItem create() {
/* 89 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public SkillPointItem fromJson(JsonValue param1JsonValue) {
/* 94 */       return create();
/*    */     }
/*    */ 
/*    */     
/*    */     public SkillPointItem createDefault() {
/* 99 */       return create();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\SkillPointItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */