package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.HtmlInnerBlock;
import com.vladsch.flexmark.ast.HtmlInnerBlockComment;

public interface HtmlInnerVisitor {
  void visit(HtmlInnerBlock paramHtmlInnerBlock);
  
  void visit(HtmlInnerBlockComment paramHtmlInnerBlockComment);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\HtmlInnerVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */