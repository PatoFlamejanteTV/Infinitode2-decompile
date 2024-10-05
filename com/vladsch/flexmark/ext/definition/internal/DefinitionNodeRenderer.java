/*    */ package com.vladsch.flexmark.ext.definition.internal;
/*    */ import com.vladsch.flexmark.ast.ListItem;
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionItem;
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionList;
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionTerm;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.CoreNodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.parser.ListOptions;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class DefinitionNodeRenderer implements NodeRenderer {
/*    */   public DefinitionNodeRenderer(DataHolder paramDataHolder) {
/* 20 */     this.listOptions = ListOptions.get(paramDataHolder);
/*    */   }
/*    */   private final ListOptions listOptions;
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 26 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(DefinitionList.class, this::render));
/* 27 */     hashSet.add(new NodeRenderingHandler(DefinitionTerm.class, this::render));
/* 28 */     hashSet.add(new NodeRenderingHandler(DefinitionItem.class, this::render));
/*    */     
/* 30 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   private void render(DefinitionList paramDefinitionList, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 34 */     ((HtmlWriter)paramHtmlWriter.withAttr().tag("dl")).indent();
/* 35 */     paramNodeRendererContext.renderChildren((Node)paramDefinitionList);
/* 36 */     ((HtmlWriter)paramHtmlWriter.unIndent()).tag("/dl");
/*    */   }
/*    */   
/*    */   private void render(DefinitionTerm paramDefinitionTerm, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*    */     Node node;
/* 41 */     if ((node = paramDefinitionTerm.getFirstChild()) != null) {
/* 42 */       ((HtmlWriter)paramHtmlWriter.srcPosWithEOL(paramDefinitionTerm.getChars()).withAttr(CoreNodeRenderer.TIGHT_LIST_ITEM).withCondIndent()).tagLine("dt", () -> {
/*    */             paramHtmlWriter.text(paramDefinitionTerm.getMarkerSuffix().unescape());
/*    */             paramNodeRendererContext.renderChildren((Node)paramDefinitionTerm);
/*    */           });
/*    */     }
/*    */   }
/*    */   
/*    */   private void render(DefinitionItem paramDefinitionItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 50 */     if (this.listOptions.isTightListItem((ListItem)paramDefinitionItem)) {
/* 51 */       ((HtmlWriter)paramHtmlWriter.srcPosWithEOL(paramDefinitionItem.getChars()).withAttr(CoreNodeRenderer.TIGHT_LIST_ITEM).withCondIndent()).tagLine("dd", () -> {
/*    */             paramHtmlWriter.text(paramDefinitionItem.getMarkerSuffix().unescape()); paramNodeRendererContext.renderChildren((Node)paramDefinitionItem);
/*    */           });
/*    */       return;
/*    */     } 
/* 56 */     paramHtmlWriter.srcPosWithEOL(paramDefinitionItem.getChars()).withAttr(CoreNodeRenderer.LOOSE_LIST_ITEM).tagIndent("dd", () -> {
/*    */           paramHtmlWriter.text(paramDefinitionItem.getMarkerSuffix().unescape());
/*    */           paramNodeRendererContext.renderChildren((Node)paramDefinitionItem);
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 67 */       return new DefinitionNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\internal\DefinitionNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */