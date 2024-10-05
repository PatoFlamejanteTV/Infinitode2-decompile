package com.badlogic.gdx.ai.utils;

public interface Location<T extends com.badlogic.gdx.math.Vector<T>> {
  T getPosition();
  
  float getOrientation();
  
  void setOrientation(float paramFloat);
  
  float vectorToAngle(T paramT);
  
  T angleToVector(T paramT, float paramFloat);
  
  Location<T> newLocation();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\Location.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */