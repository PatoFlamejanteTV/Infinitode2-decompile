/*     */ package com.vladsch.flexmark.ext.tables.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.tables.TableBlock;
/*     */ import com.vladsch.flexmark.ext.tables.TableBody;
/*     */ import com.vladsch.flexmark.ext.tables.TableCell;
/*     */ import com.vladsch.flexmark.ext.tables.TableHead;
/*     */ import com.vladsch.flexmark.ext.tables.TableRow;
/*     */ import com.vladsch.flexmark.ext.tables.TableSeparator;
/*     */ import com.vladsch.flexmark.html.HtmlWriter;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class TableJiraRenderer
/*     */   implements NodeRenderer {
/*     */   public TableJiraRenderer(DataHolder paramDataHolder) {}
/*     */   
/*     */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*  26 */     return new HashSet<>(Arrays.asList((NodeRenderingHandler<?>[])new NodeRenderingHandler[] { new NodeRenderingHandler(TableBlock.class, this::render), new NodeRenderingHandler(TableHead.class, this::render), new NodeRenderingHandler(TableSeparator.class, this::render), new NodeRenderingHandler(TableBody.class, this::render), new NodeRenderingHandler(TableRow.class, this::render), new NodeRenderingHandler(TableCell.class, this::render) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HtmlWriter tailBlankLine(Node paramNode, HtmlWriter paramHtmlWriter) {
/*  37 */     return tailBlankLine(paramNode, 1, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   public boolean isLastBlockQuoteChild(Node paramNode) {
/*     */     Node node;
/*  42 */     if (node = paramNode.getParent() instanceof com.vladsch.flexmark.ast.BlockQuote && node.getLastChild() == paramNode) return true;  return false;
/*     */   }
/*     */   
/*     */   public HtmlWriter tailBlankLine(Node paramNode, int paramInt, HtmlWriter paramHtmlWriter) {
/*  46 */     if (isLastBlockQuoteChild(paramNode)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  53 */       BasedSequence basedSequence = paramHtmlWriter.getPrefix();
/*  54 */       paramHtmlWriter.popPrefix();
/*  55 */       paramHtmlWriter.blankLine(paramInt);
/*  56 */       paramHtmlWriter.pushPrefix();
/*  57 */       paramHtmlWriter.setPrefix((CharSequence)basedSequence, false);
/*     */     } else {
/*  59 */       paramHtmlWriter.blankLine(paramInt);
/*     */     } 
/*  61 */     return paramHtmlWriter;
/*     */   }
/*     */   
/*     */   private void render(TableBlock paramTableBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  65 */     paramNodeRendererContext.renderChildren((Node)paramTableBlock);
/*  66 */     tailBlankLine((Node)paramTableBlock, paramHtmlWriter);
/*     */   }
/*     */   
/*     */   private void render(TableHead paramTableHead, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  70 */     paramNodeRendererContext.renderChildren((Node)paramTableHead);
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(TableSeparator paramTableSeparator, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*     */ 
/*     */   
/*     */   private void render(TableBody paramTableBody, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  78 */     paramNodeRendererContext.renderChildren((Node)paramTableBody);
/*     */   }
/*     */   
/*     */   private void render(TableRow paramTableRow, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  82 */     if (paramTableRow.getParent() instanceof TableHead) {
/*  83 */       ((HtmlWriter)paramHtmlWriter.line()).raw("||");
/*  84 */     } else if (paramTableRow.getParent() instanceof TableBody) {
/*  85 */       ((HtmlWriter)paramHtmlWriter.line()).raw("|");
/*     */     } 
/*  87 */     paramNodeRendererContext.renderChildren((Node)paramTableRow);
/*  88 */     paramHtmlWriter.line();
/*     */   }
/*     */   
/*     */   private void render(TableCell paramTableCell, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/*  92 */     paramNodeRendererContext.renderChildren((Node)paramTableCell);
/*  93 */     if (paramTableCell.getGrandParent() instanceof TableHead) {
/*  94 */       paramHtmlWriter.raw("||"); return;
/*  95 */     }  if (paramTableCell.getGrandParent() instanceof TableBody) {
/*  96 */       paramHtmlWriter.raw("|");
/*     */     }
/*     */   }
/*     */   
/*     */   private static String getAlignValue(TableCell.Alignment paramAlignment) {
/* 101 */     switch (paramAlignment) {
/*     */       case LEFT:
/* 103 */         return "left";
/*     */       case CENTER:
/* 105 */         return "center";
/*     */       case RIGHT:
/* 107 */         return "right";
/*     */     } 
/* 109 */     throw new IllegalStateException("Unknown alignment: " + paramAlignment);
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements NodeRendererFactory
/*     */   {
/*     */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 116 */       return new TableJiraRenderer(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\internal\TableJiraRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */