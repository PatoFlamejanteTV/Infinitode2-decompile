package com.badlogic.gdx.ai.pfa;

public interface GraphPath<N> extends Iterable<N> {
  int getCount();
  
  N get(int paramInt);
  
  void add(N paramN);
  
  void clear();
  
  void reverse();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\GraphPath.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */