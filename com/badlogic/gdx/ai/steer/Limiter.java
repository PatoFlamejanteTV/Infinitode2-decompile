package com.badlogic.gdx.ai.steer;

public interface Limiter {
  float getZeroLinearSpeedThreshold();
  
  void setZeroLinearSpeedThreshold(float paramFloat);
  
  float getMaxLinearSpeed();
  
  void setMaxLinearSpeed(float paramFloat);
  
  float getMaxLinearAcceleration();
  
  void setMaxLinearAcceleration(float paramFloat);
  
  float getMaxAngularSpeed();
  
  void setMaxAngularSpeed(float paramFloat);
  
  float getMaxAngularAcceleration();
  
  void setMaxAngularAcceleration(float paramFloat);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\Limiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */