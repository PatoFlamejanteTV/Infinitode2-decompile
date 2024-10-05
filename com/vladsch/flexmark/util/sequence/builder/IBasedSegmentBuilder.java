package com.vladsch.flexmark.util.sequence.builder;

import com.vladsch.flexmark.util.sequence.BasedSequence;

public interface IBasedSegmentBuilder<S extends IBasedSegmentBuilder<S>> extends ISegmentBuilder<S> {
  BasedSequence getBaseSequence();
  
  String toStringWithRangesVisibleWhitespace();
  
  String toStringWithRanges();
  
  String toStringChars();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\IBasedSegmentBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */