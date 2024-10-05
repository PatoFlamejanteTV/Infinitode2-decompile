package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Disposable;

public interface Lwjgl3Input extends Input, Disposable {
  void windowHandleChanged(long paramLong);
  
  void update();
  
  void prepareNext();
  
  void resetPollingStates();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3Input.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */