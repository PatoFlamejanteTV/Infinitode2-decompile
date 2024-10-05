package com.badlogic.gdx.ai.utils;

public interface NonBlockingSemaphore {
  boolean acquire();
  
  boolean acquire(int paramInt);
  
  boolean release();
  
  boolean release(int paramInt);
  
  public static interface Factory {
    NonBlockingSemaphore createSemaphore(String param1String, int param1Int);
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\NonBlockingSemaphore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */