package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.util.ast.Document;
import java.util.Set;

public interface PhasedNodeFormatter extends NodeFormatter {
  Set<FormattingPhase> getFormattingPhases();
  
  void renderDocument(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Document paramDocument, FormattingPhase paramFormattingPhase);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\PhasedNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */