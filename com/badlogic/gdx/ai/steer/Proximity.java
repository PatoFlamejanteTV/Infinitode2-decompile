package com.badlogic.gdx.ai.steer;

public interface Proximity<T extends com.badlogic.gdx.math.Vector<T>> {
  Steerable<T> getOwner();
  
  void setOwner(Steerable<T> paramSteerable);
  
  int findNeighbors(ProximityCallback<T> paramProximityCallback);
  
  public static interface ProximityCallback<T extends com.badlogic.gdx.math.Vector<T>> {
    boolean reportNeighbor(Steerable<T> param1Steerable);
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\Proximity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */