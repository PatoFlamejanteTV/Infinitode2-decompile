package com.badlogic.gdx.ai.sched;

public interface Scheduler extends Schedulable {
  void addWithAutomaticPhasing(Schedulable paramSchedulable, int paramInt);
  
  void add(Schedulable paramSchedulable, int paramInt1, int paramInt2);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\sched\Scheduler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */