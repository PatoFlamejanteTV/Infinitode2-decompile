package com.vladsch.flexmark.util.collection.iteration;

public interface Indexed<E> {
  E get(int paramInt);
  
  void set(int paramInt, E paramE);
  
  void removeAt(int paramInt);
  
  int size();
  
  int modificationCount();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\Indexed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */