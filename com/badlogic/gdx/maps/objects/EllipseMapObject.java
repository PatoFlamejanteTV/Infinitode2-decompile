/*    */ package com.badlogic.gdx.maps.objects;
/*    */ 
/*    */ import com.badlogic.gdx.maps.MapObject;
/*    */ import com.badlogic.gdx.math.Ellipse;
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
/*    */ public class EllipseMapObject
/*    */   extends MapObject
/*    */ {
/*    */   private Ellipse ellipse;
/*    */   
/*    */   public Ellipse getEllipse() {
/* 29 */     return this.ellipse;
/*    */   }
/*    */ 
/*    */   
/*    */   public EllipseMapObject() {
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
/*    */   public EllipseMapObject(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 45 */     this.ellipse = new Ellipse(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\objects\EllipseMapObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */