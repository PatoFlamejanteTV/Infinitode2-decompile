package com.vladsch.flexmark.util.collection.iteration;

import java.util.Iterator;

public interface ReversibleIndexedIterable<E> extends ReversibleIterable<E> {
  ReversibleIndexedIterator<E> iterator();
  
  ReversibleIndexedIterable<E> reversed();
  
  ReversibleIndexedIterator<E> reversedIterator();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\ReversibleIndexedIterable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */