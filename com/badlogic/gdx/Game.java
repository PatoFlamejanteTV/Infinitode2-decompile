/*    */ package com.badlogic.gdx;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Game
/*    */   implements ApplicationListener
/*    */ {
/*    */   protected Screen screen;
/*    */   
/*    */   public void dispose() {
/* 33 */     if (this.screen != null) this.screen.hide();
/*    */   
/*    */   }
/*    */   
/*    */   public void pause() {
/* 38 */     if (this.screen != null) this.screen.pause();
/*    */   
/*    */   }
/*    */   
/*    */   public void resume() {
/* 43 */     if (this.screen != null) this.screen.resume();
/*    */   
/*    */   }
/*    */   
/*    */   public void render() {
/* 48 */     if (this.screen != null) this.screen.render(Gdx.graphics.getDeltaTime());
/*    */   
/*    */   }
/*    */   
/*    */   public void resize(int paramInt1, int paramInt2) {
/* 53 */     if (this.screen != null) this.screen.resize(paramInt1, paramInt2);
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setScreen(Screen paramScreen) {
/* 60 */     if (this.screen != null) this.screen.hide(); 
/* 61 */     this.screen = paramScreen;
/* 62 */     if (this.screen != null) {
/* 63 */       this.screen.show();
/* 64 */       this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Screen getScreen() {
/* 70 */     return this.screen;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */