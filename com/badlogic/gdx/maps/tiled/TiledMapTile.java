/*    */ package com.badlogic.gdx.maps.tiled;public interface TiledMapTile {
/*    */   int getId();
/*    */   
/*    */   void setId(int paramInt);
/*    */   
/*    */   BlendMode getBlendMode();
/*    */   
/*    */   void setBlendMode(BlendMode paramBlendMode);
/*    */   
/*    */   TextureRegion getTextureRegion();
/*    */   
/*    */   void setTextureRegion(TextureRegion paramTextureRegion);
/*    */   
/*    */   float getOffsetX();
/*    */   
/*    */   void setOffsetX(float paramFloat);
/*    */   
/*    */   float getOffsetY();
/*    */   
/*    */   void setOffsetY(float paramFloat);
/*    */   
/*    */   MapProperties getProperties();
/*    */   
/*    */   MapObjects getObjects();
/*    */   
/*    */   public enum BlendMode {
/* 27 */     NONE, ALPHA;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TiledMapTile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */