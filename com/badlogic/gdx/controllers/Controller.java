package com.badlogic.gdx.controllers;

public interface Controller {
  public static final int PLAYER_IDX_UNSET = -1;
  
  boolean getButton(int paramInt);
  
  float getAxis(int paramInt);
  
  String getName();
  
  String getUniqueId();
  
  int getMinButtonIndex();
  
  int getMaxButtonIndex();
  
  int getAxisCount();
  
  boolean isConnected();
  
  boolean canVibrate();
  
  boolean isVibrating();
  
  void startVibration(int paramInt, float paramFloat);
  
  void cancelVibration();
  
  boolean supportsPlayerIndex();
  
  int getPlayerIndex();
  
  void setPlayerIndex(int paramInt);
  
  ControllerMapping getMapping();
  
  ControllerPowerLevel getPowerLevel();
  
  void addListener(ControllerListener paramControllerListener);
  
  void removeListener(ControllerListener paramControllerListener);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\Controller.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */