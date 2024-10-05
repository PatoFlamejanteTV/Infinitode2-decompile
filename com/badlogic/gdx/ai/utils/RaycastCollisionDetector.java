package com.badlogic.gdx.ai.utils;

public interface RaycastCollisionDetector<T extends com.badlogic.gdx.math.Vector<T>> {
  boolean collides(Ray<T> paramRay);
  
  boolean findCollision(Collision<T> paramCollision, Ray<T> paramRay);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\RaycastCollisionDetector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */