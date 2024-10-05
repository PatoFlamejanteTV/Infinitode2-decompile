/*    */ package com.badlogic.gdx.maps.objects;
/*    */ 
/*    */ import com.badlogic.gdx.maps.MapObject;
/*    */ import com.badlogic.gdx.math.Rectangle;
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
/*    */ 
/*    */ public class RectangleMapObject
/*    */   extends MapObject
/*    */ {
/*    */   private Rectangle rectangle;
/*    */   
/*    */   public Rectangle getRectangle() {
/* 29 */     return this.rectangle;
/*    */   }
/*    */ 
/*    */   
/*    */   public RectangleMapObject() {
/* 34 */     this(0.0F, 0.0F, 1.0F, 1.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RectangleMapObject(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 45 */     this.rectangle = new Rectangle(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\objects\RectangleMapObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */