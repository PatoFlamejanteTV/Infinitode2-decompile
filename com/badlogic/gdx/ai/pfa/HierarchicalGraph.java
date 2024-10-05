package com.badlogic.gdx.ai.pfa;

public interface HierarchicalGraph<N> extends Graph<N> {
  int getLevelCount();
  
  void setLevel(int paramInt);
  
  N convertNodeBetweenLevels(int paramInt1, N paramN, int paramInt2);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\HierarchicalGraph.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */