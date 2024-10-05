package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.MutableAttributes;

public interface AttributeProvider {
  void setAttributes(Node paramNode, AttributablePart paramAttributablePart, MutableAttributes paramMutableAttributes);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\AttributeProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */