/*    */ package com.prineside.tdi2.screens.account;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Screen;
/*    */ import com.prineside.tdi2.managers.UiManager;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.ui.shared.BackButton;
/*    */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*    */ 
/*    */ public abstract class GenericAccountScreen extends Screen {
/* 14 */   public final UiManager.UiLayer uiLayer = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "AccountScreen-" + getClass().getSimpleName());
/*    */ 
/*    */ 
/*    */   
/*    */   public GenericAccountScreen(@Null CharSequence paramCharSequence, Runnable paramRunnable) {
/* 19 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*    */     
/* 21 */     Game.i.uiManager.hideAllComponents();
/* 22 */     Game.i.uiManager.setAsInputHandler();
/*    */     
/* 24 */     ScreenTitle.i()
/* 25 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-user"))
/* 26 */       .setText(Game.i.localeManager.i18n.get("account_screen_title") + ((paramCharSequence == null) ? "" : (" - " + paramCharSequence)))
/* 27 */       .setVisible(true);
/*    */     
/* 29 */     BackButton.i()
/* 30 */       .setVisible(true)
/* 31 */       .setText(null)
/* 32 */       .setClickHandler(paramRunnable);
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(float paramFloat) {
/* 37 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 38 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 39 */     Gdx.gl.glClear(16640);
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 44 */     Game.i.uiManager.removeLayer(this.uiLayer);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\account\GenericAccountScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */