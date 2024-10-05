package com.vladsch.flexmark.ext.footnotes;

public interface FootnoteVisitor {
  void visit(FootnoteBlock paramFootnoteBlock);
  
  void visit(Footnote paramFootnote);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\FootnoteVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */