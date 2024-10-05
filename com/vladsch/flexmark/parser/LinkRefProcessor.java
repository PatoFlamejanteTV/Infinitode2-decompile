package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;

public interface LinkRefProcessor {
  boolean getWantExclamationPrefix();
  
  int getBracketNestingLevel();
  
  boolean isMatch(BasedSequence paramBasedSequence);
  
  Node createNode(BasedSequence paramBasedSequence);
  
  BasedSequence adjustInlineText(Document paramDocument, Node paramNode);
  
  boolean allowDelimiters(BasedSequence paramBasedSequence, Document paramDocument, Node paramNode);
  
  void updateNodeElements(Document paramDocument, Node paramNode);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\LinkRefProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */