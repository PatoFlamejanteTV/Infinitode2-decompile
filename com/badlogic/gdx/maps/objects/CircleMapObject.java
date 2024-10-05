/*    */ package com.badlogic.gdx.maps.objects;
/*    */ 
/*    */ import com.badlogic.gdx.maps.MapObject;
/*    */ import com.badlogic.gdx.math.Circle;
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
/*    */ public class CircleMapObject
/*    */   extends MapObject
/*    */ {
/*    */   private Circle circle;
/*    */   
/*    */   public Circle getCircle() {
/* 29 */     return this.circle;
/*    */   }
/*    */ 
/*    */   
/*    */   public CircleMapObject() {
/* 34 */     this(0.0F, 0.0F, 1.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CircleMapObject(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 44 */     this.circle = new Circle(paramFloat1, paramFloat2, paramFloat3);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\objects\CircleMapObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */