/*    */ package com.prineside.tdi2.ui.shared;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.UiManager;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Group;
/*    */ import com.prineside.tdi2.scene2d.Touchable;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.scene2d.ui.Table;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.ui.actors.Label;
/*    */ 
/*    */ public final class ScreenTitle extends UiManager.UiComponent.Adapter {
/*    */   public static ScreenTitle i() {
/* 16 */     return (ScreenTitle)Game.i.uiManager.getComponent(ScreenTitle.class);
/*    */   }
/*    */   
/*    */   private final UiManager.UiLayer a;
/*    */   private final Image b;
/*    */   private final Label c;
/*    */   
/*    */   public ScreenTitle() {
/* 24 */     Label.LabelStyle labelStyle = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE);
/*    */     
/* 26 */     this.a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 100, "ScreenTitle");
/* 27 */     Table table = this.a.getTable();
/*    */     
/*    */     Group group;
/* 30 */     (group = new Group()).setTouchable(Touchable.disabled);
/* 31 */     table.add((Actor)group).expand().top().left().size(300.0F, 64.0F).padTop(48.0F).padLeft(40.0F);
/*    */     
/* 33 */     this.b = new Image();
/* 34 */     this.b.setSize(64.0F, 64.0F);
/* 35 */     group.addActor((Actor)this.b);
/*    */     
/* 37 */     this.c = new Label("", labelStyle);
/* 38 */     this.c.setSize(204.0F, 64.0F);
/* 39 */     this.c.setPosition(96.0F, 0.0F);
/* 40 */     group.addActor((Actor)this.c);
/*    */     
/* 42 */     setVisible(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void hide() {
/* 47 */     setVisible(false);
/*    */   }
/*    */   
/*    */   public final ScreenTitle setVisible(boolean paramBoolean) {
/* 51 */     this.a.getTable().setVisible(paramBoolean);
/*    */     
/* 53 */     return this;
/*    */   }
/*    */   
/*    */   public final ScreenTitle setText(CharSequence paramCharSequence) {
/* 57 */     this.c.setText(paramCharSequence);
/*    */     
/* 59 */     return this;
/*    */   }
/*    */   
/*    */   public final ScreenTitle setIcon(Drawable paramDrawable) {
/* 63 */     this.b.setDrawable(paramDrawable);
/*    */     
/* 65 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\ScreenTitle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */