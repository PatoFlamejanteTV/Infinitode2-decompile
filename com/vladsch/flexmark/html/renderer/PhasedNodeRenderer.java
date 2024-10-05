package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.util.ast.Document;
import java.util.Set;

public interface PhasedNodeRenderer extends NodeRenderer {
  Set<RenderingPhase> getRenderingPhases();
  
  void renderDocument(NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, Document paramDocument, RenderingPhase paramRenderingPhase);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\PhasedNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */