package com.badlogic.gdx.controllers;

import com.badlogic.gdx.utils.Array;

public interface ControllerManager {
  Array<Controller> getControllers();
  
  Controller getCurrentController();
  
  void addListener(ControllerListener paramControllerListener);
  
  void removeListener(ControllerListener paramControllerListener);
  
  Array<ControllerListener> getListeners();
  
  void clearListeners();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\ControllerManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */