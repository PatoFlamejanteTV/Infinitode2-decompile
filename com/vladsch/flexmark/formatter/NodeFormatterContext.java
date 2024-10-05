package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.NodeContext;
import com.vladsch.flexmark.util.format.TrackedOffsetList;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Collection;

public interface NodeFormatterContext extends ExplicitAttributeIdProvider, TranslationContext, LinkResolverContext, NodeContext<Node, NodeFormatterContext> {
  MarkdownWriter getMarkdown();
  
  void render(Node paramNode);
  
  void renderChildren(Node paramNode);
  
  FormattingPhase getFormattingPhase();
  
  void delegateRender();
  
  DataHolder getOptions();
  
  FormatterOptions getFormatterOptions();
  
  Document getDocument();
  
  CharPredicate getBlockQuoteLikePrefixPredicate();
  
  BasedSequence getBlockQuoteLikePrefixChars();
  
  TrackedOffsetList getTrackedOffsets();
  
  boolean isRestoreTrackedSpaces();
  
  BasedSequence getTrackedSequence();
  
  Iterable<? extends Node> nodesOfType(Class<?>[] paramArrayOfClass);
  
  Iterable<? extends Node> nodesOfType(Collection<Class<?>> paramCollection);
  
  Iterable<? extends Node> reversedNodesOfType(Class<?>[] paramArrayOfClass);
  
  Iterable<? extends Node> reversedNodesOfType(Collection<Class<?>> paramCollection);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\NodeFormatterContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */