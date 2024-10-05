/*    */ package com.badlogic.gdx.maps.tiled.objects;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.maps.objects.TextureMapObject;
/*    */ import com.badlogic.gdx.maps.tiled.TiledMapTile;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TiledMapTileMapObject
/*    */   extends TextureMapObject
/*    */ {
/*    */   private boolean flipHorizontally;
/*    */   private boolean flipVertically;
/*    */   private TiledMapTile tile;
/*    */   
/*    */   public TiledMapTileMapObject(TiledMapTile paramTiledMapTile, boolean paramBoolean1, boolean paramBoolean2) {
/* 38 */     this.flipHorizontally = paramBoolean1;
/* 39 */     this.flipVertically = paramBoolean2;
/* 40 */     this.tile = paramTiledMapTile;
/*    */     
/*    */     TextureRegion textureRegion;
/* 43 */     (textureRegion = new TextureRegion(paramTiledMapTile.getTextureRegion())).flip(paramBoolean1, paramBoolean2);
/* 44 */     setTextureRegion(textureRegion);
/*    */   }
/*    */   
/*    */   public boolean isFlipHorizontally() {
/* 48 */     return this.flipHorizontally;
/*    */   }
/*    */   
/*    */   public void setFlipHorizontally(boolean paramBoolean) {
/* 52 */     this.flipHorizontally = paramBoolean;
/*    */   }
/*    */   
/*    */   public boolean isFlipVertically() {
/* 56 */     return this.flipVertically;
/*    */   }
/*    */   
/*    */   public void setFlipVertically(boolean paramBoolean) {
/* 60 */     this.flipVertically = paramBoolean;
/*    */   }
/*    */   
/*    */   public TiledMapTile getTile() {
/* 64 */     return this.tile;
/*    */   }
/*    */   
/*    */   public void setTile(TiledMapTile paramTiledMapTile) {
/* 68 */     this.tile = paramTiledMapTile;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\objects\TiledMapTileMapObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */