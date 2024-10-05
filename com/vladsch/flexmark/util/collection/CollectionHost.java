package com.vladsch.flexmark.util.collection;

public interface CollectionHost<K> {
  void adding(int paramInt, K paramK, Object paramObject);
  
  Object removing(int paramInt, K paramK);
  
  void clearing();
  
  void addingNulls(int paramInt);
  
  boolean skipHostUpdate();
  
  int getIteratorModificationCount();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\CollectionHost.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */