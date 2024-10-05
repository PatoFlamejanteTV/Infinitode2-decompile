package com.badlogic.gdx.ai.pfa;

import com.badlogic.gdx.utils.Array;

public interface Graph<N> {
  Array<Connection<N>> getConnections(N paramN);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\Graph.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */