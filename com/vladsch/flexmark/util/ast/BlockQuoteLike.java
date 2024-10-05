package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.sequence.BasedSequence;

public interface BlockQuoteLike {
  BasedSequence getOpeningMarker();
  
  Node getFirstChild();
  
  BasedSequence getChars();
  
  Document getDocument();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\BlockQuoteLike.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */