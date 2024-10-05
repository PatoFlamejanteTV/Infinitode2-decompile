/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ 
/*    */ public final class FancyButton
/*    */   extends TableButton
/*    */ {
/*    */   @Null
/*    */   public LabelWithShadow label;
/*    */   
/*    */   public FancyButton(String paramString, Runnable paramRunnable) {
/* 17 */     super(paramRunnable);
/* 18 */     setFlavor(paramString);
/*    */   }
/*    */   
/*    */   public FancyButton(String paramString, Runnable paramRunnable1, Runnable paramRunnable2) {
/* 22 */     super(paramRunnable1, paramRunnable2);
/* 23 */     setFlavor(paramString);
/*    */     
/* 25 */     if (paramRunnable2 != null) {
/*    */       Image image;
/* 27 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("button-hold-mark"))).setSize(20.0F, 20.0F);
/* 28 */       image.setPosition(12.0F, 12.0F);
/* 29 */       addActor((Actor)image);
/*    */     } 
/*    */   }
/*    */   
/*    */   public final FancyButton setFlavor(String paramString) {
/* 34 */     setBackgroundDrawables((Drawable)Game.i.assetManager
/* 35 */         .getQuad("ui." + paramString + ".normal"), (Drawable)Game.i.assetManager
/* 36 */         .getQuad("ui." + paramString + ".active"), (Drawable)Game.i.assetManager
/* 37 */         .getQuad("ui." + paramString + ".hover"), (Drawable)Game.i.assetManager
/* 38 */         .getQuad("ui." + paramString + ".disabled"));
/*    */     
/* 40 */     return this;
/*    */   }
/*    */   
/*    */   public final FancyButton withLabel(int paramInt, CharSequence paramCharSequence) {
/* 44 */     this.label = (new LabelWithShadow(paramCharSequence, Game.i.assetManager.getLabelStyle(paramInt))).setShadowShift(0.0F, 1.0F).setShadowColor(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 45 */     add((Actor)this.label);
/* 46 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\FancyButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */