package com.vladsch.flexmark.parser.delimiter;

import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
import com.vladsch.flexmark.util.ast.Node;

public interface DelimiterProcessor {
  char getOpeningCharacter();
  
  char getClosingCharacter();
  
  int getMinLength();
  
  int getDelimiterUse(DelimiterRun paramDelimiterRun1, DelimiterRun paramDelimiterRun2);
  
  void process(Delimiter paramDelimiter1, Delimiter paramDelimiter2, int paramInt);
  
  Node unmatchedDelimiterNode(InlineParser paramInlineParser, DelimiterRun paramDelimiterRun);
  
  boolean canBeOpener(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6);
  
  boolean canBeCloser(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6);
  
  boolean skipNonOpenerCloser();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\delimiter\DelimiterProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */