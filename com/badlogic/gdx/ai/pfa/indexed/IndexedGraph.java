package com.badlogic.gdx.ai.pfa.indexed;

import com.badlogic.gdx.ai.pfa.Graph;

public interface IndexedGraph<N> extends Graph<N> {
  int getIndex(N paramN);
  
  int getNodeCount();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\indexed\IndexedGraph.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */