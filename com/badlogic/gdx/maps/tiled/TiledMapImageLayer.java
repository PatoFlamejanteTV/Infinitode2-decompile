/*    */ package com.badlogic.gdx.maps.tiled;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.maps.MapLayer;
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
/*    */ public class TiledMapImageLayer
/*    */   extends MapLayer
/*    */ {
/*    */   private TextureRegion region;
/*    */   private float x;
/*    */   private float y;
/*    */   
/*    */   public TiledMapImageLayer(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2) {
/* 30 */     this.region = paramTextureRegion;
/* 31 */     this.x = paramFloat1;
/* 32 */     this.y = paramFloat2;
/*    */   }
/*    */   
/*    */   public TextureRegion getTextureRegion() {
/* 36 */     return this.region;
/*    */   }
/*    */   
/*    */   public void setTextureRegion(TextureRegion paramTextureRegion) {
/* 40 */     this.region = paramTextureRegion;
/*    */   }
/*    */   
/*    */   public float getX() {
/* 44 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(float paramFloat) {
/* 48 */     this.x = paramFloat;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 52 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(float paramFloat) {
/* 56 */     this.y = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TiledMapImageLayer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */