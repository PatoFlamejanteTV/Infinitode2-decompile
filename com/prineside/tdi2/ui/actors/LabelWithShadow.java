/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
/*    */ 
/*    */ public final class LabelWithShadow extends Label {
/*  8 */   public Color shadowColor = new Color(0.0F, 0.0F, 0.0F, 0.56F);
/*  9 */   public float shiftX = 2.0F;
/* 10 */   public float shiftY = -2.0F;
/*    */   
/*    */   public LabelWithShadow(CharSequence paramCharSequence, Label.LabelStyle paramLabelStyle) {
/* 13 */     super(paramCharSequence, paramLabelStyle);
/*    */   }
/*    */   
/*    */   public final LabelWithShadow setShadowColor(Color paramColor) {
/* 17 */     this.shadowColor.set(paramColor);
/* 18 */     return this;
/*    */   }
/*    */   
/*    */   public final LabelWithShadow setShadowShift(float paramFloat1, float paramFloat2) {
/* 22 */     this.shiftX = paramFloat1;
/* 23 */     this.shiftY = paramFloat2;
/* 24 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void draw(Batch paramBatch, float paramFloat) {
/* 29 */     validate();
/*    */     
/*    */     BitmapFontCache bitmapFontCache;
/* 32 */     (bitmapFontCache = b()).tint(this.shadowColor);
/* 33 */     bitmapFontCache.setPosition(getX() + this.shiftX, getY() + this.shiftY);
/* 34 */     bitmapFontCache.draw(paramBatch);
/*    */     
/* 36 */     super.draw(paramBatch, paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\LabelWithShadow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */