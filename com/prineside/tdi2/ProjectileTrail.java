package com.prineside.tdi2;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface ProjectileTrail {
  void update(float paramFloat);
  
  void draw(Batch paramBatch);
  
  boolean isFinished();
  
  void free();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ProjectileTrail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */