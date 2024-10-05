package com.vladsch.flexmark.util.ast;

public interface NodeTracker {
  void nodeAdded(Node paramNode);
  
  void nodeAddedWithChildren(Node paramNode);
  
  void nodeAddedWithDescendants(Node paramNode);
  
  void nodeRemoved(Node paramNode);
  
  void nodeRemovedWithChildren(Node paramNode);
  
  void nodeRemovedWithDescendants(Node paramNode);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */