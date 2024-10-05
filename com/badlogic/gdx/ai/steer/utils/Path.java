package com.badlogic.gdx.ai.steer.utils;

public interface Path<T extends com.badlogic.gdx.math.Vector<T>, P extends Path.PathParam> {
  P createParam();
  
  boolean isOpen();
  
  float getLength();
  
  T getStartPoint();
  
  T getEndPoint();
  
  float calculateDistance(T paramT, P paramP);
  
  void calculateTargetPosition(T paramT, P paramP, float paramFloat);
  
  public static interface PathParam {
    float getDistance();
    
    void setDistance(float param1Float);
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\stee\\utils\Path.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */