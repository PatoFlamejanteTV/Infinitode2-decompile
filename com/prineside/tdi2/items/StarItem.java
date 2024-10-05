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
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = StarItem.Serializer.class)
/*    */ public class StarItem extends Item {
/*    */   public static class Serializer extends SingletonSerializer<StarItem> {
/*    */     public StarItem read() {
/* 19 */       return Item.D.STAR;
/*    */     }
/*    */   }
/*    */   
/*    */   private StarItem() {}
/*    */   
/*    */   public ItemType getType() {
/* 26 */     return ItemType.STAR;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemCategoryType getCategory() {
/* 31 */     return ItemCategoryType.OTHER;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemSubcategoryType getSubcategory() {
/* 36 */     return ItemSubcategoryType.O_OTHER;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence getTitle() {
/* 41 */     return Game.i.localeManager.i18n.get("item_title_STAR");
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence getDescription() {
/* 46 */     return Game.i.localeManager.i18n.get("item_description_STAR");
/*    */   }
/*    */ 
/*    */   
/*    */   public RarityType getRarity() {
/* 51 */     return RarityType.EPIC;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAnalyticName() {
/* 56 */     return "star";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCountable() {
/* 61 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public Actor generateIcon(float paramFloat, boolean paramBoolean) {
/*    */     Image image;
/* 67 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setSize(paramFloat, paramFloat);
/*    */     
/* 69 */     return (Actor)image;
/*    */   }
/*    */ 
/*    */   
/*    */   public static class StarItemFactory
/*    */     implements Item.Factory<StarItem>
/*    */   {
/* 76 */     private final StarItem a = new StarItem((byte)0);
/*    */ 
/*    */ 
/*    */     
/*    */     public void setup() {}
/*    */ 
/*    */ 
/*    */     
/*    */     public StarItem create() {
/* 85 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public StarItem fromJson(JsonValue param1JsonValue) {
/* 90 */       return create();
/*    */     }
/*    */ 
/*    */     
/*    */     public StarItem createDefault() {
/* 95 */       return create();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\items\StarItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */