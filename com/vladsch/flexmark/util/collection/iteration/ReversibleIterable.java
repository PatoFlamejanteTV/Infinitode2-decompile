package com.vladsch.flexmark.util.collection.iteration;

import java.util.Iterator;

public interface ReversibleIterable<E> extends Iterable<E> {
  ReversibleIterator<E> iterator();
  
  ReversibleIterable<E> reversed();
  
  boolean isReversed();
  
  ReversibleIterator<E> reversedIterator();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\ReversibleIterable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */