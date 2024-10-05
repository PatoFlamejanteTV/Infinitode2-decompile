package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockContent;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;

public interface BlockParser {
  boolean isContainer();
  
  boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock);
  
  Block getBlock();
  
  BlockContinue tryContinue(ParserState paramParserState);
  
  void addLine(ParserState paramParserState, BasedSequence paramBasedSequence);
  
  void closeBlock(ParserState paramParserState);
  
  boolean isClosed();
  
  boolean isPropagatingLastBlankLine(BlockParser paramBlockParser);
  
  boolean breakOutOnDoubleBlankLine();
  
  boolean isParagraphParser();
  
  BlockContent getBlockContent();
  
  void finalizeClosedBlock();
  
  void parseInlines(InlineParser paramInlineParser);
  
  boolean isInterruptible();
  
  boolean isRawText();
  
  boolean canInterruptBy(BlockParserFactory paramBlockParserFactory);
  
  MutableDataHolder getDataHolder();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\BlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */