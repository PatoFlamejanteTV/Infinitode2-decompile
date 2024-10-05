package com.vladsch.flexmark.html2md.converter;

import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.html.renderer.LinkType;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.NodeContext;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public interface HtmlNodeConverterContext extends NodeContext<Node, HtmlNodeConverterContext> {
  HtmlMarkdownWriter getMarkdown();
  
  void delegateRender();
  
  HtmlNodeConverterContext getSubContext();
  
  HtmlNodeConverterContext getSubContext(DataHolder paramDataHolder);
  
  HtmlNodeConverterContext getSubContext(DataHolder paramDataHolder, ISequenceBuilder<?, ?> paramISequenceBuilder);
  
  void render(Node paramNode);
  
  void renderChildren(Node paramNode, boolean paramBoolean, Runnable paramRunnable);
  
  HtmlConverterPhase getFormattingPhase();
  
  DataHolder getOptions();
  
  HtmlConverterOptions getHtmlConverterOptions();
  
  Document getDocument();
  
  Document getForDocument();
  
  HtmlConverterState getState();
  
  HashMap<String, Reference> getReferenceUrlToReferenceMap();
  
  HashSet<Reference> getExternalReferences();
  
  boolean isTrace();
  
  Stack<HtmlConverterState> getStateStack();
  
  void setTrace(boolean paramBoolean);
  
  Node parseMarkdown(String paramString);
  
  Reference getOrCreateReference(String paramString1, String paramString2, String paramString3);
  
  ResolvedLink resolveLink(LinkType paramLinkType, CharSequence paramCharSequence, Boolean paramBoolean);
  
  ResolvedLink resolveLink(LinkType paramLinkType, CharSequence paramCharSequence, Attributes paramAttributes, Boolean paramBoolean);
  
  Node getCurrentNode();
  
  void pushState(Node paramNode);
  
  void popState(LineAppendable paramLineAppendable);
  
  void excludeAttributes(String... paramVarArgs);
  
  void processAttributes(Node paramNode);
  
  int outputAttributes(LineAppendable paramLineAppendable, String paramString);
  
  void transferIdToParent();
  
  void transferToParentExcept(String... paramVarArgs);
  
  void transferToParentOnly(String... paramVarArgs);
  
  Node peek();
  
  Node peek(int paramInt);
  
  Node next();
  
  void skip();
  
  Node next(int paramInt);
  
  void skip(int paramInt);
  
  void processUnwrapped(Node paramNode);
  
  void processWrapped(Node paramNode, Boolean paramBoolean, boolean paramBoolean1);
  
  void processTextNodes(Node paramNode, boolean paramBoolean);
  
  void processTextNodes(Node paramNode, boolean paramBoolean, CharSequence paramCharSequence);
  
  void processTextNodes(Node paramNode, boolean paramBoolean, CharSequence paramCharSequence1, CharSequence paramCharSequence2);
  
  void wrapTextNodes(Node paramNode, CharSequence paramCharSequence, boolean paramBoolean);
  
  String processTextNodes(Node paramNode);
  
  void appendOuterHtml(Node paramNode);
  
  boolean isInlineCode();
  
  void setInlineCode(boolean paramBoolean);
  
  String escapeSpecialChars(String paramString);
  
  String prepareText(String paramString);
  
  String prepareText(String paramString, boolean paramBoolean);
  
  void inlineCode(Runnable paramRunnable);
  
  void processConditional(ExtensionConversion paramExtensionConversion, Node paramNode, Runnable paramRunnable);
  
  void renderDefault(Node paramNode);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlNodeConverterContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */