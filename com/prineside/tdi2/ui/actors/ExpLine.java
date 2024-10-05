/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Group;
/*    */ import com.prineside.tdi2.scene2d.Touchable;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ 
/*    */ public class ExpLine extends Group {
/*    */   private final Image k;
/*    */   private final Image l;
/*    */   
/*    */   public ExpLine() {
/* 18 */     setTransform(false);
/* 19 */     setTouchable(Touchable.disabled);
/*    */     
/*    */     Image image;
/* 22 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(356.0F, 24.0F);
/* 23 */     image.setColor(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 24 */     addActor((Actor)image);
/*    */ 
/*    */     
/* 27 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("ui-exp-line-end"))).setSize(8.0F, 24.0F);
/* 28 */     image.setColor(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 29 */     image.setPosition(356.0F, 0.0F);
/* 30 */     addActor((Actor)image);
/*    */     
/* 32 */     this.k = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 33 */     this.k.setSize(356.0F, 24.0F);
/* 34 */     this.k.setColor(MaterialColor.AMBER.P700);
/* 35 */     addActor((Actor)this.k);
/*    */     
/* 37 */     this.l = new Image((Drawable)Game.i.assetManager.getDrawable("ui-exp-line-end"));
/* 38 */     this.l.setSize(8.0F, 24.0F);
/* 39 */     this.l.setColor(MaterialColor.AMBER.P700);
/* 40 */     this.l.setPosition(356.0F, 0.0F);
/* 41 */     addActor((Actor)this.l);
/*    */   }
/*    */   
/*    */   public void setColor(Color paramColor) {
/* 45 */     this.k.setColor(paramColor);
/* 46 */     this.l.setColor(paramColor);
/*    */   }
/*    */   
/*    */   public void setCoeff(float paramFloat) {
/* 50 */     paramFloat = MathUtils.clamp(paramFloat, 0.0F, 1.0F);
/*    */     
/* 52 */     paramFloat = 356.0F * paramFloat;
/* 53 */     this.k.setWidth(paramFloat);
/* 54 */     this.l.setX(paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\ExpLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */