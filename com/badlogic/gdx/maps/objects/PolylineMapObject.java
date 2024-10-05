/*    */ package com.badlogic.gdx.maps.objects;
/*    */ 
/*    */ import com.badlogic.gdx.maps.MapObject;
/*    */ import com.badlogic.gdx.math.Polyline;
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
/*    */ public class PolylineMapObject
/*    */   extends MapObject
/*    */ {
/*    */   private Polyline polyline;
/*    */   
/*    */   public Polyline getPolyline() {
/* 29 */     return this.polyline;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setPolyline(Polyline paramPolyline) {
/* 34 */     this.polyline = paramPolyline;
/*    */   }
/*    */ 
/*    */   
/*    */   public PolylineMapObject() {
/* 39 */     this(new float[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public PolylineMapObject(float[] paramArrayOffloat) {
/* 44 */     this.polyline = new Polyline(paramArrayOffloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public PolylineMapObject(Polyline paramPolyline) {
/* 49 */     this.polyline = paramPolyline;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\objects\PolylineMapObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */