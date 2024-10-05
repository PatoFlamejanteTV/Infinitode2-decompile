package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;

public interface NodeContext<N, C extends NodeContext<N, C>> {
  C getSubContext();
  
  C getSubContext(DataHolder paramDataHolder);
  
  C getSubContext(DataHolder paramDataHolder, ISequenceBuilder<?, ?> paramISequenceBuilder);
  
  N getCurrentNode();
  
  DataHolder getOptions();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\NodeContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */