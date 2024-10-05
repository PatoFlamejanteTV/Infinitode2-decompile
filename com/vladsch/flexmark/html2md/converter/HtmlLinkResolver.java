package com.vladsch.flexmark.html2md.converter;

import com.vladsch.flexmark.html.renderer.ResolvedLink;
import org.jsoup.nodes.Node;

public interface HtmlLinkResolver {
  ResolvedLink resolveLink(Node paramNode, HtmlNodeConverterContext paramHtmlNodeConverterContext, ResolvedLink paramResolvedLink);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlLinkResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */