package com.badlogic.gdx.graphics;

public interface CubemapData {
  boolean isPrepared();
  
  void prepare();
  
  void consumeCubemapData();
  
  int getWidth();
  
  int getHeight();
  
  boolean isManaged();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\CubemapData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */