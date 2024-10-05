/*    */ package com.prineside.tdi2.ui.actors;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.scene2d.ui.Table;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ 
/*    */ public class EffectTooltip extends Table {
/*    */   private final Image k;
/*    */   private final Label l;
/*    */   private final Label n;
/*    */   
/*    */   public EffectTooltip(Drawable paramDrawable, CharSequence paramCharSequence) {
/* 17 */     this.k = new Image();
/* 18 */     add((Actor)this.k).size(64.0F, 64.0F);
/*    */     
/* 20 */     Table table = new Table();
/* 21 */     add((Actor)table).padLeft(8.0F);
/*    */     
/* 23 */     this.l = new Label("Title", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/* 24 */     this.l.setAlignment(8);
/* 25 */     table.add((Actor)this.l).fillX().row();
/*    */     
/* 27 */     this.n = new Label("Hint", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE));
/* 28 */     this.n.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 29 */     this.n.setVisible(false);
/* 30 */     this.n.setAlignment(8);
/* 31 */     table.add((Actor)this.n).fillX();
/*    */     
/* 33 */     setIcon(paramDrawable);
/* 34 */     setTitle(paramCharSequence);
/*    */   }
/*    */   
/*    */   public EffectTooltip setIcon(Drawable paramDrawable) {
/* 38 */     this.k.setDrawable(paramDrawable);
/*    */     
/* 40 */     return this;
/*    */   }
/*    */   
/*    */   public EffectTooltip setTitle(CharSequence paramCharSequence) {
/* 44 */     this.l.setText(paramCharSequence);
/*    */     
/* 46 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setColor(Color paramColor) {
/* 51 */     super.setColor(paramColor);
/*    */     
/* 53 */     this.k.setColor(paramColor);
/* 54 */     this.l.setColor(paramColor);
/* 55 */     this.n.setColor(paramColor.r, paramColor.g, paramColor.b, paramColor.a * 0.56F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EffectTooltip setHint(CharSequence paramCharSequence) {
/* 63 */     if (paramCharSequence == null) {
/* 64 */       this.n.setVisible(false);
/*    */     } else {
/* 66 */       this.n.setText(paramCharSequence);
/* 67 */       this.n.setVisible(true);
/*    */     } 
/* 69 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\EffectTooltip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */