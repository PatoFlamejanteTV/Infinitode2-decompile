/*    */ package com.badlogic.gdx.scenes.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
/*    */ public class TextureRegionDrawable
/*    */   extends BaseDrawable
/*    */   implements TransformDrawable
/*    */ {
/*    */   private TextureRegion region;
/*    */   
/*    */   public TextureRegionDrawable() {}
/*    */   
/*    */   public TextureRegionDrawable(Texture paramTexture) {
/* 37 */     setRegion(new TextureRegion(paramTexture));
/*    */   }
/*    */   
/*    */   public TextureRegionDrawable(TextureRegion paramTextureRegion) {
/* 41 */     setRegion(paramTextureRegion);
/*    */   }
/*    */   
/*    */   public TextureRegionDrawable(TextureRegionDrawable paramTextureRegionDrawable) {
/* 45 */     super(paramTextureRegionDrawable);
/* 46 */     setRegion(paramTextureRegionDrawable.region);
/*    */   }
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 50 */     paramBatch.draw(this.region, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 55 */     paramBatch.draw(this.region, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
/*    */   }
/*    */   
/*    */   public void setRegion(TextureRegion paramTextureRegion) {
/* 59 */     this.region = paramTextureRegion;
/* 60 */     if (paramTextureRegion != null) {
/* 61 */       setMinWidth(paramTextureRegion.getRegionWidth());
/* 62 */       setMinHeight(paramTextureRegion.getRegionHeight());
/*    */     } 
/*    */   }
/*    */   
/*    */   public TextureRegion getRegion() {
/* 67 */     return this.region;
/*    */   }
/*    */ 
/*    */   
/*    */   public Drawable tint(Color paramColor) {
/*    */     Sprite sprite;
/* 73 */     if (this.region instanceof TextureAtlas.AtlasRegion) {
/* 74 */       TextureAtlas.AtlasSprite atlasSprite = new TextureAtlas.AtlasSprite((TextureAtlas.AtlasRegion)this.region);
/*    */     } else {
/* 76 */       sprite = new Sprite(this.region);
/* 77 */     }  sprite.setColor(paramColor);
/* 78 */     sprite.setSize(getMinWidth(), getMinHeight());
/*    */     SpriteDrawable spriteDrawable;
/* 80 */     (spriteDrawable = new SpriteDrawable(sprite)).setLeftWidth(getLeftWidth());
/* 81 */     spriteDrawable.setRightWidth(getRightWidth());
/* 82 */     spriteDrawable.setTopHeight(getTopHeight());
/* 83 */     spriteDrawable.setBottomHeight(getBottomHeight());
/* 84 */     return spriteDrawable;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\TextureRegionDrawable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */