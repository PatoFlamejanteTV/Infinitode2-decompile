package com.vladsch.flexmark.util.html;

import com.vladsch.flexmark.util.sequence.LineAppendable;
import java.util.List;
import java.util.Stack;

public interface HtmlAppendable extends LineAppendable {
  Attributes getAttributes();
  
  HtmlAppendable setAttributes(Attributes paramAttributes);
  
  boolean inPre();
  
  HtmlAppendable openPre();
  
  HtmlAppendable closePre();
  
  HtmlAppendable raw(CharSequence paramCharSequence);
  
  HtmlAppendable raw(CharSequence paramCharSequence, int paramInt);
  
  HtmlAppendable rawPre(CharSequence paramCharSequence);
  
  HtmlAppendable rawIndentedPre(CharSequence paramCharSequence);
  
  HtmlAppendable text(CharSequence paramCharSequence);
  
  HtmlAppendable attr(CharSequence paramCharSequence1, CharSequence paramCharSequence2);
  
  HtmlAppendable attr(Attribute... paramVarArgs);
  
  HtmlAppendable attr(Attributes paramAttributes);
  
  HtmlAppendable withAttr();
  
  Stack<String> getOpenTags();
  
  List<String> getOpenTagsAfterLast(CharSequence paramCharSequence);
  
  HtmlAppendable withCondLineOnChildText();
  
  HtmlAppendable withCondIndent();
  
  HtmlAppendable tagVoid(CharSequence paramCharSequence);
  
  HtmlAppendable tag(CharSequence paramCharSequence);
  
  HtmlAppendable tag(CharSequence paramCharSequence, Runnable paramRunnable);
  
  HtmlAppendable tag(CharSequence paramCharSequence, boolean paramBoolean);
  
  HtmlAppendable tag(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, Runnable paramRunnable);
  
  HtmlAppendable tagVoidLine(CharSequence paramCharSequence);
  
  HtmlAppendable tagLine(CharSequence paramCharSequence);
  
  HtmlAppendable tagLine(CharSequence paramCharSequence, boolean paramBoolean);
  
  HtmlAppendable tagLine(CharSequence paramCharSequence, Runnable paramRunnable);
  
  HtmlAppendable tagIndent(CharSequence paramCharSequence, Runnable paramRunnable);
  
  HtmlAppendable tagLineIndent(CharSequence paramCharSequence, Runnable paramRunnable);
  
  HtmlAppendable closeTag(CharSequence paramCharSequence);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\HtmlAppendable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */