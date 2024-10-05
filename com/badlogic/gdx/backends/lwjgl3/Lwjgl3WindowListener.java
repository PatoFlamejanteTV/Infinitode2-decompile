package com.badlogic.gdx.backends.lwjgl3;

public interface Lwjgl3WindowListener {
  void created(Lwjgl3Window paramLwjgl3Window);
  
  void iconified(boolean paramBoolean);
  
  void maximized(boolean paramBoolean);
  
  void focusLost();
  
  void focusGained();
  
  boolean closeRequested();
  
  void filesDropped(String[] paramArrayOfString);
  
  void refreshRequested();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3WindowListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */