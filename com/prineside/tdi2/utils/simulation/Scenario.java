package com.prineside.tdi2.utils.simulation;

import com.prineside.tdi2.GameSystemProvider;

public interface Scenario {
  void start(GameSystemProvider paramGameSystemProvider);
  
  void setGSP(GameSystemProvider paramGameSystemProvider);
  
  boolean isFinished();
  
  float getProgress();
  
  void onUpdate();
  
  Scenario cpy();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\Scenario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */