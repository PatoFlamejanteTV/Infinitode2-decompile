/*    */ package com.vladsch.flexmark.ext.toc.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Heading;
/*    */ import com.vladsch.flexmark.ast.util.HeadingCollectingVisitor;
/*    */ import com.vladsch.flexmark.ext.toc.TocBlock;
/*    */ import com.vladsch.flexmark.ext.toc.TocExtension;
/*    */ import com.vladsch.flexmark.ext.toc.TocUtils;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*    */ import com.vladsch.flexmark.util.misc.Paired;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.stream.Collectors;
/*    */ 
/*    */ public class TocNodeRenderer implements NodeRenderer {
/*    */   private final TocOptions options;
/*    */   private final boolean haveTitle;
/*    */   
/*    */   public TocNodeRenderer(DataHolder paramDataHolder) {
/* 29 */     this.haveTitle = (paramDataHolder != null && paramDataHolder.contains((DataKeyBase)TocExtension.TITLE));
/* 30 */     this.options = new TocOptions(paramDataHolder, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 36 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(TocBlock.class, this::render));
/* 37 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(TocBlock paramTocBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*    */     ArrayList<Heading> arrayList;
/*    */     HeadingCollectingVisitor headingCollectingVisitor;
/* 43 */     if ((arrayList = (headingCollectingVisitor = new HeadingCollectingVisitor()).collectAndGetHeadings((Node)paramNodeRendererContext.getDocument())) != null) {
/* 44 */       TocOptionsParser tocOptionsParser = new TocOptionsParser();
/* 45 */       TocOptions tocOptions2 = this.haveTitle ? this.options : this.options.withTitle("");
/* 46 */       TocOptions tocOptions1 = (TocOptions)tocOptionsParser.parseOption(paramTocBlock.getStyle(), tocOptions2, null).getFirst();
/* 47 */       renderTocHeaders(paramNodeRendererContext, paramHtmlWriter, (Node)paramTocBlock, arrayList, tocOptions1);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void renderTocHeaders(NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter, Node paramNode, List<Heading> paramList, TocOptions paramTocOptions) {
/* 52 */     paramList = TocUtils.filteredHeadings(paramList, paramTocOptions);
/*    */     Paired paired;
/* 54 */     List list1 = (List)((List)(paired = TocUtils.htmlHeadingTexts(paramNodeRendererContext, paramList, paramTocOptions)).getFirst()).stream().map(Heading::getLevel).collect(Collectors.toList());
/* 55 */     List list2 = (List)((List)paired.getFirst()).stream().map(Heading::getAnchorRefId).collect(Collectors.toList());
/* 56 */     TocUtils.renderHtmlToc(paramHtmlWriter, (paramNodeRendererContext.getHtmlOptions()).sourcePositionAttribute.isEmpty() ? BasedSequence.NULL : paramNode.getChars(), list1, (List)paired.getSecond(), list2, paramTocOptions);
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 63 */       return new TocNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\TocNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */