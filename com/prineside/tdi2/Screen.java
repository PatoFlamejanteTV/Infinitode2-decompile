/*   */ package com.prineside.tdi2;
/*   */ 
/*   */ import com.badlogic.gdx.Screen;
/*   */ 
/*   */ public abstract class Screen
/*   */   implements Screen {
/*   */   public void render(float paramFloat) {
/* 8 */     draw(paramFloat);
/*   */   }
/*   */   
/*   */   public abstract void draw(float paramFloat);
/*   */   
/*   */   public void resize(int paramInt1, int paramInt2) {}
/*   */   
/*   */   public void pause() {}
/*   */   
/*   */   public void resume() {}
/*   */   
/*   */   public void show() {}
/*   */   
/*   */   public void hide() {}
/*   */   
/*   */   public void dispose() {}
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Screen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */