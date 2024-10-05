package com.vladsch.flexmark.html2md.converter;

public interface CustomHtmlNodeRenderer<N extends org.jsoup.nodes.Node> {
  void render(N paramN, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\CustomHtmlNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */