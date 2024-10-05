package com.badlogic.gdx.math;

public interface Path<T> {
  T derivativeAt(T paramT, float paramFloat);
  
  T valueAt(T paramT, float paramFloat);
  
  float approximate(T paramT);
  
  float locate(T paramT);
  
  float approxLength(int paramInt);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Path.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */