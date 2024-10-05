package com.vladsch.flexmark.util.options;

import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

public interface OptionParser<T> {
  String getOptionName();
  
  Pair<T, List<ParsedOption<T>>> parseOption(BasedSequence paramBasedSequence, T paramT, MessageProvider paramMessageProvider);
  
  String getOptionText(T paramT1, T paramT2);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\options\OptionParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */