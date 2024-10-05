package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
import com.vladsch.flexmark.parser.internal.LinkRefProcessorData;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

public interface InlineParserFactory {
  InlineParser inlineParser(DataHolder paramDataHolder, BitSet paramBitSet1, BitSet paramBitSet2, Map<Character, DelimiterProcessor> paramMap, LinkRefProcessorData paramLinkRefProcessorData, List<InlineParserExtensionFactory> paramList);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\InlineParserFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */