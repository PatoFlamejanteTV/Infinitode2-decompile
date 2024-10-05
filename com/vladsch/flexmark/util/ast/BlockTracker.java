package com.vladsch.flexmark.util.ast;

public interface BlockTracker {
  void blockAdded(Block paramBlock);
  
  void blockAddedWithChildren(Block paramBlock);
  
  void blockAddedWithDescendants(Block paramBlock);
  
  void blockRemoved(Block paramBlock);
  
  void blockRemovedWithChildren(Block paramBlock);
  
  void blockRemovedWithDescendants(Block paramBlock);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\BlockTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */