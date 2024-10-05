package com.badlogic.gdx.ai.pfa;

public interface PathFinder<N> {
  boolean searchConnectionPath(N paramN1, N paramN2, Heuristic<N> paramHeuristic, GraphPath<Connection<N>> paramGraphPath);
  
  boolean searchNodePath(N paramN1, N paramN2, Heuristic<N> paramHeuristic, GraphPath<N> paramGraphPath);
  
  boolean search(PathFinderRequest<N> paramPathFinderRequest, long paramLong);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\PathFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */