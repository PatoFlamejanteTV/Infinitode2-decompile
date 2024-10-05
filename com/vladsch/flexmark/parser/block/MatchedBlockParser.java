package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

public interface MatchedBlockParser {
  BlockParser getBlockParser();
  
  BasedSequence getParagraphContent();
  
  List<BasedSequence> getParagraphLines();
  
  List<Integer> getParagraphEolLengths();
  
  MutableDataHolder getParagraphDataHolder();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\MatchedBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */