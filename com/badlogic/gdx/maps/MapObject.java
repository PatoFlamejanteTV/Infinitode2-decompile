/*    */ package com.badlogic.gdx.maps;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapObject
/*    */ {
/* 23 */   private String name = "";
/* 24 */   private float opacity = 1.0F;
/*    */   private boolean visible = true;
/* 26 */   private MapProperties properties = new MapProperties();
/* 27 */   private Color color = Color.WHITE.cpy();
/*    */ 
/*    */   
/*    */   public String getName() {
/* 31 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setName(String paramString) {
/* 36 */     this.name = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public Color getColor() {
/* 41 */     return this.color;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setColor(Color paramColor) {
/* 46 */     this.color = paramColor;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getOpacity() {
/* 51 */     return this.opacity;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setOpacity(float paramFloat) {
/* 56 */     this.opacity = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isVisible() {
/* 61 */     return this.visible;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setVisible(boolean paramBoolean) {
/* 66 */     this.visible = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public MapProperties getProperties() {
/* 71 */     return this.properties;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\MapObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */