/*    */ package com.prineside.tdi2.ui.actors;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Group;
/*    */ import com.prineside.tdi2.scene2d.Touchable;
/*    */ import com.prineside.tdi2.scene2d.actions.Actions;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ 
/*    */ public class AttentionRaysUnderlay extends Group {
/*    */   private Image k;
/*    */   private Image[] l;
/*    */   private Color m;
/*    */   public float size;
/*    */   
/*    */   public AttentionRaysUnderlay(float paramFloat, Color paramColor) {
/* 18 */     this.size = paramFloat;
/* 19 */     this.m = paramColor;
/*    */     
/* 21 */     setTransform(false);
/* 22 */     setTouchable(Touchable.disabled);
/*    */     
/* 24 */     this.k = new Image((TextureRegion)Game.i.assetManager.getTextureRegion("attention-rays-0"));
/* 25 */     Image image1 = new Image((TextureRegion)Game.i.assetManager.getTextureRegion("attention-rays-1"));
/* 26 */     Image image2 = new Image((TextureRegion)Game.i.assetManager.getTextureRegion("attention-rays-2"));
/* 27 */     Image image3 = new Image((TextureRegion)Game.i.assetManager.getTextureRegion("attention-rays-3"));
/* 28 */     this.l = new Image[] { this.k, image1, image2, image3 };
/*    */ 
/*    */ 
/*    */     
/* 32 */     restart();
/*    */   }
/*    */   
/*    */   public void restart() {
/*    */     Color color;
/* 37 */     (color = this.m.cpy()).a = 0.0F;
/*    */     
/* 39 */     setSize(this.size, this.size);
/*    */     
/* 41 */     byte b1 = 0; Image[] arrayOfImage; int i; byte b2;
/* 42 */     for (i = (arrayOfImage = this.l).length, b2 = 0; b2 < i; b2++) {
/* 43 */       Image image; (image = arrayOfImage[b2]).clearActions();
/*    */       
/* 45 */       image.setSize(this.size, this.size);
/* 46 */       image.setOrigin(this.size * 0.5F, this.size * 0.5F);
/* 47 */       image.setColor(color);
/*    */       
/* 49 */       if (image != this.k) {
/*    */         
/* 51 */         image.addAction(
/* 52 */             (Action)Actions.sequence(
/* 53 */               (Action)Actions.delay(b1), 
/* 54 */               (Action)Actions.forever(
/* 55 */                 (Action)Actions.parallel(
/* 56 */                   (Action)Actions.rotateBy(42.0F + b1 * 3.0F, 3.0F), 
/* 57 */                   (Action)Actions.sequence(
/* 58 */                     (Action)Actions.color(this.m, 1.5F), 
/* 59 */                     (Action)Actions.color(color, 1.5F))))));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 65 */         b1++;
/*    */       } 
/*    */       
/* 68 */       addActor((Actor)image);
/*    */     } 
/*    */     
/* 71 */     this.k.setColor(color);
/* 72 */     this.k.addAction(
/* 73 */         (Action)Actions.parallel(
/* 74 */           (Action)Actions.color(this.m, 1.5F), 
/* 75 */           (Action)Actions.forever(
/* 76 */             (Action)Actions.rotateBy(45.0F, 3.0F))));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setColor(Color paramColor) {
/* 84 */     this.m = paramColor;
/* 85 */     restart();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\AttentionRaysUnderlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */