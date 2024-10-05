package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.AutoLink;
import com.vladsch.flexmark.ast.Code;
import com.vladsch.flexmark.ast.Emphasis;
import com.vladsch.flexmark.ast.HardLineBreak;
import com.vladsch.flexmark.ast.HtmlEntity;
import com.vladsch.flexmark.ast.HtmlInline;
import com.vladsch.flexmark.ast.HtmlInlineComment;
import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.ast.ImageRef;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.ast.LinkRef;
import com.vladsch.flexmark.ast.MailLink;
import com.vladsch.flexmark.ast.SoftLineBreak;
import com.vladsch.flexmark.ast.StrongEmphasis;
import com.vladsch.flexmark.ast.Text;

public interface InlineVisitor {
  void visit(AutoLink paramAutoLink);
  
  void visit(Code paramCode);
  
  void visit(Emphasis paramEmphasis);
  
  void visit(HardLineBreak paramHardLineBreak);
  
  void visit(HtmlEntity paramHtmlEntity);
  
  void visit(HtmlInline paramHtmlInline);
  
  void visit(HtmlInlineComment paramHtmlInlineComment);
  
  void visit(Image paramImage);
  
  void visit(ImageRef paramImageRef);
  
  void visit(Link paramLink);
  
  void visit(LinkRef paramLinkRef);
  
  void visit(MailLink paramMailLink);
  
  void visit(SoftLineBreak paramSoftLineBreak);
  
  void visit(StrongEmphasis paramStrongEmphasis);
  
  void visit(Text paramText);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\InlineVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */