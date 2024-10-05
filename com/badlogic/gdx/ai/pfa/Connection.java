package com.badlogic.gdx.ai.pfa;

public interface Connection<N> {
  float getCost();
  
  N getFromNode();
  
  N getToNode();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\Connection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */