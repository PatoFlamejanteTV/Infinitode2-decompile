/*    */ package com.badlogic.gdx.maps;
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
/*    */ public class MapGroupLayer
/*    */   extends MapLayer
/*    */ {
/* 22 */   private MapLayers layers = new MapLayers();
/*    */ 
/*    */   
/*    */   public MapLayers getLayers() {
/* 26 */     return this.layers;
/*    */   }
/*    */ 
/*    */   
/*    */   public void invalidateRenderOffset() {
/* 31 */     super.invalidateRenderOffset();
/* 32 */     for (byte b = 0; b < this.layers.size(); b++) {
/*    */       MapLayer mapLayer;
/* 34 */       (mapLayer = this.layers.get(b)).invalidateRenderOffset();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\MapGroupLayer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */