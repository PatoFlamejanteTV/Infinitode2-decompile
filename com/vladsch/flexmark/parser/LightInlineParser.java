package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface LightInlineParser {
  ArrayList<BasedSequence> getCurrentText();
  
  BasedSequence getInput();
  
  void setInput(BasedSequence paramBasedSequence);
  
  int getIndex();
  
  void setIndex(int paramInt);
  
  Node getBlock();
  
  BasedSequence match(Pattern paramPattern);
  
  BasedSequence[] matchWithGroups(Pattern paramPattern);
  
  Matcher matcher(Pattern paramPattern);
  
  char peek();
  
  char peek(int paramInt);
  
  boolean flushTextNode();
  
  Document getDocument();
  
  void setDocument(Document paramDocument);
  
  InlineParserOptions getOptions();
  
  Parsing getParsing();
  
  void appendText(BasedSequence paramBasedSequence);
  
  void appendText(BasedSequence paramBasedSequence, int paramInt1, int paramInt2);
  
  void appendNode(Node paramNode);
  
  Text appendSeparateText(BasedSequence paramBasedSequence);
  
  void setBlock(Node paramNode);
  
  void moveNodes(Node paramNode1, Node paramNode2);
  
  boolean spnl();
  
  boolean nonIndentSp();
  
  boolean sp();
  
  boolean spnlUrl();
  
  BasedSequence toEOL();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\LightInlineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */