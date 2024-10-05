package com.badlogic.gdx.controllers;

public interface ControllerListener {
  void connected(Controller paramController);
  
  void disconnected(Controller paramController);
  
  boolean buttonDown(Controller paramController, int paramInt);
  
  boolean buttonUp(Controller paramController, int paramInt);
  
  boolean axisMoved(Controller paramController, int paramInt, float paramFloat);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\ControllerListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */