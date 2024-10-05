/*    */ package com.prineside.tdi2.scene2d.utils;
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
/*    */   private Sprite a;
/*    */   
/*    */   public SpriteDrawable() {}
/*    */   
/*    */   public SpriteDrawable(Sprite paramSprite) {
/* 34 */     setSprite(paramSprite);
/*    */   }
/*    */   
/*    */   public SpriteDrawable(SpriteDrawable paramSpriteDrawable) {
/* 38 */     super(paramSpriteDrawable);
/* 39 */     setSprite(paramSpriteDrawable.a);
/*    */   }
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*    */     Color color;
/* 44 */     float f = (color = this.a.getColor()).toFloatBits();
/* 45 */     this.a.setColor(color.mul(paramBatch.getColor()));
/*    */     
/* 47 */     this.a.setRotation(0.0F);
/* 48 */     this.a.setScale(1.0F, 1.0F);
/* 49 */     this.a.setBounds(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 50 */     this.a.draw(paramBatch);
/*    */     
/* 52 */     this.a.setPackedColor(f);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*    */     Color color;
/* 59 */     float f = (color = this.a.getColor()).toFloatBits();
/* 60 */     this.a.setColor(color.mul(paramBatch.getColor()));
/*    */     
/* 62 */     this.a.setOrigin(paramFloat3, paramFloat4);
/* 63 */     this.a.setRotation(paramFloat9);
/* 64 */     this.a.setScale(paramFloat7, paramFloat8);
/* 65 */     this.a.setBounds(paramFloat1, paramFloat2, paramFloat5, paramFloat6);
/* 66 */     this.a.draw(paramBatch);
/*    */     
/* 68 */     this.a.setPackedColor(f);
/*    */   }
/*    */   
/*    */   public void setSprite(Sprite paramSprite) {
/* 72 */     this.a = paramSprite;
/* 73 */     setMinWidth(paramSprite.getWidth());
/* 74 */     setMinHeight(paramSprite.getHeight());
/*    */   }
/*    */   
/*    */   public Sprite getSprite() {
/* 78 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public SpriteDrawable tint(Color paramColor) {
/*    */     Sprite sprite;
/* 84 */     if (this.a instanceof TextureAtlas.AtlasSprite) {
/* 85 */       TextureAtlas.AtlasSprite atlasSprite = new TextureAtlas.AtlasSprite((TextureAtlas.AtlasSprite)this.a);
/*    */     } else {
/* 87 */       sprite = new Sprite(this.a);
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


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\SpriteDrawable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */