package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.html.HtmlRendererOptions;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.html.MutableAttributes;

public interface NodeRendererContext extends LinkResolverContext {
  MutableAttributes extendRenderingNodeAttributes(AttributablePart paramAttributablePart, Attributes paramAttributes);
  
  MutableAttributes extendRenderingNodeAttributes(Node paramNode, AttributablePart paramAttributablePart, Attributes paramAttributes);
  
  HtmlWriter getHtmlWriter();
  
  NodeRendererContext getSubContext(boolean paramBoolean);
  
  NodeRendererContext getDelegatedSubContext(boolean paramBoolean);
  
  void delegateRender();
  
  String getNodeId(Node paramNode);
  
  boolean isDoNotRenderLinks();
  
  void doNotRenderLinks(boolean paramBoolean);
  
  void doNotRenderLinks();
  
  void doRenderLinks();
  
  RenderingPhase getRenderingPhase();
  
  HtmlRendererOptions getHtmlOptions();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\NodeRendererContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */