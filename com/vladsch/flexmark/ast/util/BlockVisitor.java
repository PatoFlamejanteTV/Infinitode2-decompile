package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.BlockQuote;
import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.BulletListItem;
import com.vladsch.flexmark.ast.FencedCodeBlock;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.HtmlBlock;
import com.vladsch.flexmark.ast.HtmlCommentBlock;
import com.vladsch.flexmark.ast.IndentedCodeBlock;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.OrderedListItem;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.ast.ThematicBreak;
import com.vladsch.flexmark.util.ast.Document;

public interface BlockVisitor {
  void visit(BlockQuote paramBlockQuote);
  
  void visit(BulletList paramBulletList);
  
  void visit(Document paramDocument);
  
  void visit(FencedCodeBlock paramFencedCodeBlock);
  
  void visit(Heading paramHeading);
  
  void visit(HtmlBlock paramHtmlBlock);
  
  void visit(HtmlCommentBlock paramHtmlCommentBlock);
  
  void visit(IndentedCodeBlock paramIndentedCodeBlock);
  
  void visit(BulletListItem paramBulletListItem);
  
  void visit(OrderedListItem paramOrderedListItem);
  
  void visit(OrderedList paramOrderedList);
  
  void visit(Paragraph paramParagraph);
  
  void visit(Reference paramReference);
  
  void visit(ThematicBreak paramThematicBreak);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\BlockVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */