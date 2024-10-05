package com.badlogic.gdx.ai.steer;

import com.badlogic.gdx.ai.utils.Location;

public interface Steerable<T extends com.badlogic.gdx.math.Vector<T>> extends Limiter, Location<T> {
  T getLinearVelocity();
  
  float getAngularVelocity();
  
  float getBoundingRadius();
  
  boolean isTagged();
  
  void setTagged(boolean paramBoolean);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\Steerable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */