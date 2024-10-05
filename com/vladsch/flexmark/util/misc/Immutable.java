package com.vladsch.flexmark.util.misc;

public interface Immutable<I extends Immutable<I, M>, M extends Mutable<M, I>> {
  M toMutable();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\Immutable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */