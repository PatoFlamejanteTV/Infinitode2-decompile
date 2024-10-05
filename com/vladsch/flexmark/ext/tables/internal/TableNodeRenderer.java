/*    */ package com.vladsch.flexmark.ext.tables.internal;
/*    */ import com.vladsch.flexmark.ext.tables.TableBlock;
/*    */ import com.vladsch.flexmark.ext.tables.TableBody;
/*    */ import com.vladsch.flexmark.ext.tables.TableCaption;
/*    */ import com.vladsch.flexmark.ext.tables.TableCell;
/*    */ import com.vladsch.flexmark.ext.tables.TableHead;
/*    */ import com.vladsch.flexmark.ext.tables.TableRow;
/*    */ import com.vladsch.flexmark.ext.tables.TableSeparator;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Arrays;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class TableNodeRenderer implements NodeRenderer {
/*    */   public TableNodeRenderer(DataHolder paramDataHolder) {
/* 21 */     this.options = new TableParserOptions(paramDataHolder);
/*    */   }
/*    */   private final TableParserOptions options;
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/* 26 */     return new HashSet<>(Arrays.asList((NodeRenderingHandler<?>[])new NodeRenderingHandler[] { new NodeRenderingHandler(TableBlock.class, this::render), new NodeRenderingHandler(TableHead.class, this::render), new NodeRenderingHandler(TableSeparator.class, this::render), new NodeRenderingHandler(TableBody.class, this::render), new NodeRenderingHandler(TableRow.class, this::render), new NodeRenderingHandler(TableCell.class, this::render), new NodeRenderingHandler(TableCaption.class, this::render) }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(TableBlock paramTableBlock, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 38 */     if (!this.options.className.isEmpty()) {
/* 39 */       paramHtmlWriter.attr("class", this.options.className);
/*    */     }
/*    */     
/* 42 */     ((HtmlWriter)paramHtmlWriter.srcPosWithEOL(paramTableBlock.getChars()).withAttr().tagLineIndent("table", () -> paramNodeRendererContext.renderChildren((Node)paramTableBlock))).line();
/*    */   }
/*    */   
/*    */   private void render(TableHead paramTableHead, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 46 */     ((HtmlWriter)paramHtmlWriter.withAttr().withCondIndent()).tagLine("thead", () -> paramNodeRendererContext.renderChildren((Node)paramTableHead));
/*    */   }
/*    */ 
/*    */   
/*    */   private void render(TableSeparator paramTableSeparator, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {}
/*    */ 
/*    */   
/*    */   private void render(TableBody paramTableBody, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 54 */     ((HtmlWriter)paramHtmlWriter.withAttr().withCondIndent()).tagLine("tbody", () -> paramNodeRendererContext.renderChildren((Node)paramTableBody));
/*    */   }
/*    */   
/*    */   private void render(TableRow paramTableRow, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 58 */     paramHtmlWriter.srcPos((BasedSequence)paramTableRow.getChars().trimStart()).withAttr().tagLine("tr", () -> paramNodeRendererContext.renderChildren((Node)paramTableRow));
/*    */   }
/*    */   
/*    */   private void render(TableCaption paramTableCaption, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 62 */     paramHtmlWriter.srcPos((BasedSequence)paramTableCaption.getChars().trimStart()).withAttr().tagLine("caption", () -> paramNodeRendererContext.renderChildren((Node)paramTableCaption));
/*    */   }
/*    */   
/*    */   private void render(TableCell paramTableCell, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 66 */     String str = paramTableCell.isHeader() ? "th" : "td";
/* 67 */     if (paramTableCell.getAlignment() != null) {
/* 68 */       paramHtmlWriter.attr("align", getAlignValue(paramTableCell.getAlignment()));
/*    */     }
/*    */     
/* 71 */     if (this.options.columnSpans && paramTableCell.getSpan() > 1) {
/* 72 */       paramHtmlWriter.attr("colspan", String.valueOf(paramTableCell.getSpan()));
/*    */     }
/*    */     
/* 75 */     paramHtmlWriter.srcPos(paramTableCell.getText()).withAttr().tag(str);
/* 76 */     paramNodeRendererContext.renderChildren((Node)paramTableCell);
/* 77 */     paramHtmlWriter.tag("/" + str);
/*    */   }
/*    */   
/*    */   private static String getAlignValue(TableCell.Alignment paramAlignment) {
/* 81 */     switch (paramAlignment) {
/*    */       case LEFT:
/* 83 */         return "left";
/*    */       case CENTER:
/* 85 */         return "center";
/*    */       case RIGHT:
/* 87 */         return "right";
/*    */     } 
/* 89 */     throw new IllegalStateException("Unknown alignment: " + paramAlignment);
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 96 */       return new TableNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\internal\TableNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */