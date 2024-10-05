package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.BlockTracker;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

public interface ParserState extends BlockParserTracker, BlockTracker {
  BasedSequence getLine();
  
  BasedSequence getLineWithEOL();
  
  int getIndex();
  
  int getNextNonSpaceIndex();
  
  int getColumn();
  
  int getIndent();
  
  boolean isBlank();
  
  boolean isBlankLine();
  
  BlockParser getActiveBlockParser();
  
  List<BlockParser> getActiveBlockParsers();
  
  BlockParser getActiveBlockParser(Block paramBlock);
  
  InlineParser getInlineParser();
  
  int getLineNumber();
  
  int getLineStart();
  
  int getLineEolLength();
  
  int getLineEndIndex();
  
  boolean endsWithBlankLine(Node paramNode);
  
  boolean isLastLineBlank(Node paramNode);
  
  MutableDataHolder getProperties();
  
  ParserPhase getParserPhase();
  
  Parsing getParsing();
  
  List<BasedSequence> getLineSegments();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\ParserState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */