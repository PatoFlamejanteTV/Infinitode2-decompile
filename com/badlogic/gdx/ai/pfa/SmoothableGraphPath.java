package com.badlogic.gdx.ai.pfa;

public interface SmoothableGraphPath<N, V extends com.badlogic.gdx.math.Vector<V>> extends GraphPath<N> {
  V getNodePosition(int paramInt);
  
  void swapNodes(int paramInt1, int paramInt2);
  
  void truncatePath(int paramInt);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\SmoothableGraphPath.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */