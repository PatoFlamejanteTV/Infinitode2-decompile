package com.vladsch.flexmark.util.data;

import java.util.Set;

public interface DataKeyAggregator {
  DataHolder aggregate(DataHolder paramDataHolder);
  
  DataHolder aggregateActions(DataHolder paramDataHolder1, DataHolder paramDataHolder2, DataHolder paramDataHolder3);
  
  DataHolder clean(DataHolder paramDataHolder);
  
  Set<Class<?>> invokeAfterSet();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\DataKeyAggregator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */