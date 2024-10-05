package com.badlogic.gdx.graphics;

public interface Texture3DData {
  boolean isPrepared();
  
  void prepare();
  
  int getWidth();
  
  int getHeight();
  
  int getDepth();
  
  int getInternalFormat();
  
  int getGLType();
  
  boolean useMipMaps();
  
  void consume3DData();
  
  boolean isManaged();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Texture3DData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */