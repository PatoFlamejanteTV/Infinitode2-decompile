package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.sequence.mappers.CharMapper;

public interface MappedSequence<T extends CharSequence> extends CharSequence {
  CharMapper getCharMapper();
  
  T getCharSequence();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\MappedSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */