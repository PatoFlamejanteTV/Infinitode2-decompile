package com.prineside.tdi2.utils.simulation;

public interface Simulation {
  CharSequence getName();
  
  void setSimLogListener(SimLogListener paramSimLogListener);
  
  void setSimFinishListener(Runnable paramRunnable);
  
  float getProgress();
  
  void start();
  
  boolean isRunning();
  
  boolean isReadyToStart();
  
  boolean isSuccessful();
  
  void stop();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\Simulation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */