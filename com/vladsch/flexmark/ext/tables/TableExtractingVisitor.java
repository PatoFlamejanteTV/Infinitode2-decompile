/*    */ package com.vladsch.flexmark.ext.tables;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.format.MarkdownTable;
/*    */ import com.vladsch.flexmark.util.format.TableCell;
/*    */ import com.vladsch.flexmark.util.format.TableFormatOptions;
/*    */ import com.vladsch.flexmark.util.html.CellAlignment;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class TableExtractingVisitor
/*    */ {
/*    */   private final TableFormatOptions options;
/* 18 */   private final NodeVisitor myVisitor = new NodeVisitor(new VisitHandler[] { new VisitHandler(TableBlock.class, this::visit), new VisitHandler(TableHead.class, this::visit), new VisitHandler(TableSeparator.class, this::visit), new VisitHandler(TableBody.class, this::visit), new VisitHandler(TableRow.class, this::visit), new VisitHandler(TableCell.class, this::visit), new VisitHandler(TableCaption.class, this::visit) });
/*    */ 
/*    */ 
/*    */   
/*    */   private MarkdownTable myTable;
/*    */ 
/*    */ 
/*    */   
/*    */   private final List<MarkdownTable> myTables;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TableExtractingVisitor(DataHolder paramDataHolder) {
/* 32 */     this.options = new TableFormatOptions(paramDataHolder);
/* 33 */     this.myTables = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public MarkdownTable[] getTables(Node paramNode) {
/* 37 */     this.myTable = null;
/* 38 */     this.myVisitor.visit(paramNode);
/* 39 */     return this.myTables.<MarkdownTable>toArray(new MarkdownTable[0]);
/*    */   }
/*    */   
/*    */   private void visit(TableBlock paramTableBlock) {
/* 43 */     this.myTable = new MarkdownTable((CharSequence)paramTableBlock.getChars(), this.options);
/* 44 */     this.myVisitor.visitChildren((Node)paramTableBlock);
/* 45 */     this.myTables.add(this.myTable);
/*    */     
/* 47 */     this.myTable = null;
/*    */   }
/*    */   
/*    */   private void visit(TableHead paramTableHead) {
/* 51 */     this.myTable.setSeparator(false);
/* 52 */     this.myTable.setHeader(true);
/* 53 */     this.myVisitor.visitChildren(paramTableHead);
/*    */   }
/*    */   
/*    */   private void visit(TableSeparator paramTableSeparator) {
/* 57 */     this.myTable.setSeparator(true);
/* 58 */     this.myVisitor.visitChildren(paramTableSeparator);
/*    */   }
/*    */   
/*    */   private void visit(TableBody paramTableBody) {
/* 62 */     this.myTable.setSeparator(false);
/* 63 */     this.myTable.setHeader(false);
/* 64 */     this.myVisitor.visitChildren(paramTableBody);
/*    */   }
/*    */   
/*    */   private void visit(TableRow paramTableRow) {
/* 68 */     this.myVisitor.visitChildren(paramTableRow);
/* 69 */     if (!this.myTable.isSeparator()) this.myTable.nextRow(); 
/*    */   }
/*    */   
/*    */   private void visit(TableCaption paramTableCaption) {
/* 73 */     this.myTable.setCaptionWithMarkers(paramTableCaption, (CharSequence)paramTableCaption.getOpeningMarker(), (CharSequence)paramTableCaption.getText(), (CharSequence)paramTableCaption.getClosingMarker());
/*    */   }
/*    */   
/*    */   private void visit(TableCell paramTableCell) {
/* 77 */     BasedSequence basedSequence = paramTableCell.getText();
/* 78 */     if (this.options.trimCellWhitespace) {
/* 79 */       if (basedSequence.isBlank() && !basedSequence.isEmpty()) {
/* 80 */         basedSequence = basedSequence.subSequence(0, 1);
/*    */       } else {
/* 82 */         basedSequence = (BasedSequence)basedSequence.trim();
/*    */       } 
/*    */     }
/* 85 */     this.myTable.addCell(new TableCell(paramTableCell, (CharSequence)paramTableCell.getOpeningMarker(), (CharSequence)basedSequence, (CharSequence)paramTableCell.getClosingMarker(), 1, paramTableCell.getSpan(), (paramTableCell.getAlignment() == null) ? CellAlignment.NONE : paramTableCell.getAlignment().cellAlignment()));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableExtractingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */