package com.vladsch.flexmark.html2md.converter;

import com.vladsch.flexmark.util.sequence.LineAppendable;
import java.util.Set;
import org.jsoup.nodes.Document;

public interface PhasedHtmlNodeRenderer extends HtmlNodeRenderer {
  Set<HtmlConverterPhase> getHtmlConverterPhases();
  
  void renderDocument(HtmlNodeConverterContext paramHtmlNodeConverterContext, LineAppendable paramLineAppendable, Document paramDocument, HtmlConverterPhase paramHtmlConverterPhase);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\PhasedHtmlNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */