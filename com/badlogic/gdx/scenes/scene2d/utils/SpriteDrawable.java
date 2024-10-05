/*    */ package com.badlogic.gdx.scenes.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
/*    */ public class SpriteDrawable
/*    */   extends BaseDrawable
/*    */   implements TransformDrawable
/*    */ {
/*    */   private Sprite sprite;
/*    */   
/*    */   public SpriteDrawable() {}
/*    */   
/*    */   public SpriteDrawable(Sprite paramSprite) {
/* 34 */     setSprite(paramSprite);
/*    */   }
/*    */   
/*    */   public SpriteDrawable(SpriteDrawable paramSpriteDrawable) {
/* 38 */     super(paramSpriteDrawable);
/* 39 */     setSprite(paramSpriteDrawable.sprite);
/*    */   }
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 43 */     Color color = this.sprite.getColor();
/* 44 */     float f = this.sprite.getPackedColor();
/* 45 */     this.sprite.setColor(color.mul(paramBatch.getColor()));
/*    */     
/* 47 */     this.sprite.setRotation(0.0F);
/* 48 */     this.sprite.setScale(1.0F, 1.0F);
/* 49 */     this.sprite.setBounds(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 50 */     this.sprite.draw(paramBatch);
/*    */     
/* 52 */     this.sprite.setPackedColor(f);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/* 58 */     Color color = this.sprite.getColor();
/* 59 */     float f = this.sprite.getPackedColor();
/* 60 */     this.sprite.setColor(color.mul(paramBatch.getColor()));
/*    */     
/* 62 */     this.sprite.setOrigin(paramFloat3, paramFloat4);
/* 63 */     this.sprite.setRotation(paramFloat9);
/* 64 */     this.sprite.setScale(paramFloat7, paramFloat8);
/* 65 */     this.sprite.setBounds(paramFloat1, paramFloat2, paramFloat5, paramFloat6);
/* 66 */     this.sprite.draw(paramBatch);
/*    */     
/* 68 */     this.sprite.setPackedColor(f);
/*    */   }
/*    */   
/*    */   public void setSprite(Sprite paramSprite) {
/* 72 */     this.sprite = paramSprite;
/* 73 */     setMinWidth(paramSprite.getWidth());
/* 74 */     setMinHeight(paramSprite.getHeight());
/*    */   }
/*    */   
/*    */   public Sprite getSprite() {
/* 78 */     return this.sprite;
/*    */   }
/*    */ 
/*    */   
/*    */   public SpriteDrawable tint(Color paramColor) {
/*    */     Sprite sprite;
/* 84 */     if (this.sprite instanceof TextureAtlas.AtlasSprite) {
/* 85 */       TextureAtlas.AtlasSprite atlasSprite = new TextureAtlas.AtlasSprite((TextureAtlas.AtlasSprite)this.sprite);
/*    */     } else {
/* 87 */       sprite = new Sprite(this.sprite);
/* 88 */     }  sprite.setColor(paramColor);
/* 89 */     sprite.setSize(getMinWidth(), getMinHeight());
/*    */     SpriteDrawable spriteDrawable;
/* 91 */     (spriteDrawable = new SpriteDrawable(sprite)).setLeftWidth(getLeftWidth());
/* 92 */     spriteDrawable.setRightWidth(getRightWidth());
/* 93 */     spriteDrawable.setTopHeight(getTopHeight());
/* 94 */     spriteDrawable.setBottomHeight(getBottomHeight());
/* 95 */     return spriteDrawable;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\SpriteDrawable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */