/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ 
/*    */ public class ImageWithParentColor extends Image {
/* 10 */   private Color j = new Color();
/*    */   
/*    */   public ImageWithParentColor() {
/* 13 */     this((Drawable)null);
/*    */   }
/*    */   
/*    */   public ImageWithParentColor(Drawable paramDrawable) {
/* 17 */     super(paramDrawable);
/*    */   }
/*    */   
/*    */   public ImageWithParentColor(TextureRegion paramTextureRegion) {
/* 21 */     super(paramTextureRegion);
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch, float paramFloat) {
/* 26 */     this.j.set(getColor());
/*    */     
/* 28 */     Color color1 = getColor();
/* 29 */     Color color2 = getParent().getColor();
/*    */     
/* 31 */     setColor(color1.r * color2.r, color1.g * color2.g, color1.b * color2.b, color1.a);
/*    */     
/* 33 */     super.draw(paramBatch, paramFloat);
/*    */     
/* 35 */     setColor(this.j);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\ImageWithParentColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */