/*    */ package com.badlogic.gdx.maps.objects;
/*    */ 
/*    */ import com.badlogic.gdx.maps.MapObject;
/*    */ import com.badlogic.gdx.math.Polygon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PolygonMapObject
/*    */   extends MapObject
/*    */ {
/*    */   private Polygon polygon;
/*    */   
/*    */   public Polygon getPolygon() {
/* 17 */     return this.polygon;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setPolygon(Polygon paramPolygon) {
/* 22 */     this.polygon = paramPolygon;
/*    */   }
/*    */ 
/*    */   
/*    */   public PolygonMapObject() {
/* 27 */     this(new float[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public PolygonMapObject(float[] paramArrayOffloat) {
/* 32 */     this.polygon = new Polygon(paramArrayOffloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public PolygonMapObject(Polygon paramPolygon) {
/* 37 */     this.polygon = paramPolygon;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\objects\PolygonMapObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */