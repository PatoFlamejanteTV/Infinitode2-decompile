package com.badlogic.gdx.ai.btree;

public interface TaskCloner {
  <T> Task<T> cloneTask(Task<T> paramTask);
  
  <T> void freeTask(Task<T> paramTask);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\TaskCloner.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */