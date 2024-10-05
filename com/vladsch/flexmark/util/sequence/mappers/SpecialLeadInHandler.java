package com.vladsch.flexmark.util.sequence.mappers;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.function.Consumer;

public interface SpecialLeadInHandler {
  boolean escape(BasedSequence paramBasedSequence, DataHolder paramDataHolder, Consumer<CharSequence> paramConsumer);
  
  boolean unEscape(BasedSequence paramBasedSequence, DataHolder paramDataHolder, Consumer<CharSequence> paramConsumer);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\mappers\SpecialLeadInHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */