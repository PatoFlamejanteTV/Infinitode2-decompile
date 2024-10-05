/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.Animation;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*    */ 
/*    */ public class AnimatedImage extends Image {
/*    */   private Animation<? extends TextureRegion> j;
/* 10 */   private float k = 0.0F;
/*    */   
/*    */   public AnimatedImage(Animation<? extends TextureRegion> paramAnimation) {
/* 13 */     super((TextureRegion)paramAnimation.getKeyFrame(0.0F));
/* 14 */     this.j = paramAnimation;
/*    */   }
/*    */ 
/*    */   
/*    */   public void act(float paramFloat) {
/* 19 */     if (isVisible()) {
/* 20 */       if (paramFloat < 0.0F || Float.isNaN(paramFloat)) {
/* 21 */         paramFloat = 0.0F;
/*    */       }
/* 23 */       ((TextureRegionDrawable)getDrawable()).setRegion((TextureRegion)this.j.getKeyFrame(this.k += paramFloat, (this.j.getPlayMode() != Animation.PlayMode.NORMAL)));
/*    */     } 
/*    */     
/* 26 */     super.act(paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\AnimatedImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */