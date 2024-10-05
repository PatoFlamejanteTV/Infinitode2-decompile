package com.vladsch.flexmark.util.misc;

public interface Mutable<M extends Mutable<M, I>, I extends Immutable<I, M>> {
  I toImmutable();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\Mutable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */