/*    */ package com.vladsch.flexmark.ext.toc.internal;
/*    */ import com.vladsch.flexmark.ast.Heading;
/*    */ import com.vladsch.flexmark.ast.util.HeadingCollectingVisitor;
/*    */ import com.vladsch.flexmark.ext.toc.SimTocBlock;
/*    */ import com.vladsch.flexmark.ext.toc.SimTocContent;
/*    */ import com.vladsch.flexmark.ext.toc.SimTocOption;
/*    */ import com.vladsch.flexmark.ext.toc.SimTocOptionList;
/*    */ import com.vladsch.flexmark.ext.toc.TocUtils;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.misc.Paired;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.stream.Collectors;
/*    */ 
/*    */ public class SimTocNodeRenderer implements NodeRenderer {
/*    */   public SimTocNodeRenderer(DataHolder paramDataHolder) {
/* 27 */     this.options = new TocOptions(paramDataHolder, true);
/*    */   }
/*    */   private final TocOptions options;
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/* 32 */     return new HashSet<>(Arrays.asList((NodeRenderingHandler<?>[])new NodeRenderingHandler[] { new NodeRenderingHandler(SimTocBlock.class, this::render), new NodeRenderingHandler(SimTocContent.class, this::render), new NodeRenderingHandler(SimTocOptionList.class, this::render), new NodeRenderingHandler(SimTocOption.class, this::render) }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(SimTocContent paramSimTocContent, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(SimTocOptionList paramSimTocOptionList, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(SimTocOption paramSimTocOption, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(SimTocBlock paramSimTocBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*    */     ArrayList<Heading> arrayList;
/*    */     HeadingCollectingVisitor headingCollectingVisitor;
/* 55 */     if ((arrayList = (headingCollectingVisitor = new HeadingCollectingVisitor()).collectAndGetHeadings((Node)paramNodeRendererContext.getDocument())) != null) {
/*    */       SimTocOptionsParser simTocOptionsParser;
/* 57 */       TocOptions tocOptions = (TocOptions)(simTocOptionsParser = new SimTocOptionsParser()).parseOption(paramSimTocBlock.getStyle(), this.options, null).getFirst();
/*    */       
/* 59 */       if (paramSimTocBlock.getTitle().isNotNull()) {
/* 60 */         tocOptions = tocOptions.withTitle(paramSimTocBlock.getTitle().unescape());
/*    */       }
/* 62 */       renderTocHeaders(paramNodeRendererContext, paramHtmlWriter, (Node)paramSimTocBlock, arrayList, tocOptions);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void renderTocHeaders(NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, Node paramNode, List<Heading> paramList, TocOptions paramTocOptions) {
/* 67 */     paramList = TocUtils.filteredHeadings(paramList, paramTocOptions);
/*    */     Paired paired;
/* 69 */     List list1 = (List)((List)(paired = TocUtils.htmlHeadingTexts(paramNodeRendererContext, paramList, paramTocOptions)).getFirst()).stream().map(Heading::getLevel).collect(Collectors.toList());
/* 70 */     List list2 = (List)((List)paired.getFirst()).stream().map(Heading::getAnchorRefId).collect(Collectors.toList());
/* 71 */     TocUtils.renderHtmlToc(paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).sourcePositionAttribute.isEmpty() ? BasedSequence.NULL : paramNode.getChars(), list1, (List)paired.getSecond(), list2, paramTocOptions);
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 78 */       return new SimTocNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\SimTocNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */