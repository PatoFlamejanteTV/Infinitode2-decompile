package com.vladsch.flexmark.util.collection;

import java.util.Map;

public interface IndexedItemSetMap<M, S, K> extends Map<M, S> {
  M mapKey(K paramK);
  
  S newSet();
  
  boolean addSetItem(S paramS, int paramInt);
  
  boolean removeSetItem(S paramS, int paramInt);
  
  boolean containsSetItem(S paramS, int paramInt);
  
  boolean addItem(K paramK, int paramInt);
  
  boolean removeItem(K paramK, int paramInt);
  
  boolean containsItem(K paramK, int paramInt);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\IndexedItemSetMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */