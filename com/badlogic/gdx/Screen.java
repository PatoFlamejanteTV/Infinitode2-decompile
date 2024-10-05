package com.badlogic.gdx;

import com.badlogic.gdx.utils.Disposable;

public interface Screen extends Disposable {
  void show();
  
  void render(float paramFloat);
  
  void resize(int paramInt1, int paramInt2);
  
  void pause();
  
  void resume();
  
  void hide();
  
  void dispose();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Screen.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */