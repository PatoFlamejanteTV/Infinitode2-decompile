package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.parser.block.CharacterNodeFactory;
import com.vladsch.flexmark.parser.core.delimiter.Bracket;
import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

public interface InlineParser extends LightInlineParser {
  void initializeDocument(Document paramDocument);
  
  void finalizeDocument(Document paramDocument);
  
  void parse(BasedSequence paramBasedSequence, Node paramNode);
  
  Delimiter getLastDelimiter();
  
  Bracket getLastBracket();
  
  List<Node> parseCustom(BasedSequence paramBasedSequence, Node paramNode, BitSet paramBitSet, Map<Character, CharacterNodeFactory> paramMap);
  
  void mergeTextNodes(Node paramNode1, Node paramNode2);
  
  void mergeIfNeeded(Text paramText1, Text paramText2);
  
  BasedSequence toEOL();
  
  boolean parseNewline();
  
  BasedSequence parseLinkDestination();
  
  BasedSequence parseLinkTitle();
  
  int parseLinkLabel();
  
  boolean parseAutolink();
  
  boolean parseHtmlInline();
  
  boolean parseEntity();
  
  void processDelimiters(Delimiter paramDelimiter);
  
  void removeDelimitersBetween(Delimiter paramDelimiter1, Delimiter paramDelimiter2);
  
  void removeDelimiterAndNode(Delimiter paramDelimiter);
  
  void removeDelimiterKeepNode(Delimiter paramDelimiter);
  
  void removeDelimiter(Delimiter paramDelimiter);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\InlineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */