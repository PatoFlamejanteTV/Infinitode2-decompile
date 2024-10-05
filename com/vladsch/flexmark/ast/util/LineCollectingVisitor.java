/*    */ package com.vladsch.flexmark.ast.util;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.HardLineBreak;
/*    */ import com.vladsch.flexmark.ast.HtmlEntity;
/*    */ import com.vladsch.flexmark.ast.HtmlInline;
/*    */ import com.vladsch.flexmark.ast.SoftLineBreak;
/*    */ import com.vladsch.flexmark.ast.Text;
/*    */ import com.vladsch.flexmark.ast.TextBase;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeVisitor;
/*    */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*    */ import com.vladsch.flexmark.util.sequence.Range;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LineCollectingVisitor
/*    */ {
/* 22 */   private final NodeVisitor myVisitor = new NodeVisitor(new VisitHandler[] { new VisitHandler(Text.class, this::visit), new VisitHandler(TextBase.class, this::visit), new VisitHandler(HtmlEntity.class, this::visit), new VisitHandler(HtmlInline.class, this::visit), new VisitHandler(SoftLineBreak.class, this::visit), new VisitHandler(HardLineBreak.class, this::visit) });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 31 */   private List<Range> myLines = Collections.EMPTY_LIST;
/*    */   private List<Integer> myEOLs;
/*    */   
/*    */   private void finalizeLines() {
/* 35 */     if (this.myStartOffset < this.myEndOffset) {
/* 36 */       Range range = Range.of(this.myStartOffset, this.myEndOffset);
/* 37 */       this.myLines.add(range);
/* 38 */       this.myEOLs.add(Integer.valueOf(0));
/* 39 */       this.myStartOffset = this.myEndOffset;
/*    */     } 
/*    */   }
/*    */   private int myStartOffset; private int myEndOffset;
/*    */   public List<Range> getLines() {
/* 44 */     finalizeLines();
/* 45 */     return this.myLines;
/*    */   }
/*    */   
/*    */   public List<Integer> getEOLs() {
/* 49 */     finalizeLines();
/* 50 */     return this.myEOLs;
/*    */   }
/*    */   
/*    */   public void collect(Node paramNode) {
/* 54 */     this.myLines = new ArrayList<>();
/* 55 */     this.myEOLs = new ArrayList<>();
/* 56 */     this.myStartOffset = paramNode.getStartOffset();
/* 57 */     this.myEndOffset = paramNode.getEndOffset();
/* 58 */     this.myVisitor.visit(paramNode);
/*    */   }
/*    */   
/*    */   public List<Range> collectAndGetRanges(Node paramNode) {
/* 62 */     collect(paramNode);
/* 63 */     return getLines();
/*    */   }
/*    */   
/*    */   private void visit(SoftLineBreak paramSoftLineBreak) {
/* 67 */     Range range = Range.of(this.myStartOffset, paramSoftLineBreak.getEndOffset());
/* 68 */     this.myLines.add(range);
/* 69 */     this.myEOLs.add(Integer.valueOf(paramSoftLineBreak.getTextLength()));
/* 70 */     this.myStartOffset = paramSoftLineBreak.getEndOffset();
/*    */   }
/*    */   
/*    */   private void visit(HardLineBreak paramHardLineBreak) {
/* 74 */     Range range = Range.of(this.myStartOffset, paramHardLineBreak.getEndOffset());
/* 75 */     this.myLines.add(range);
/* 76 */     this.myEOLs.add(Integer.valueOf(paramHardLineBreak.getTextLength()));
/* 77 */     this.myStartOffset = paramHardLineBreak.getEndOffset();
/*    */   }
/*    */   
/*    */   private void visit(HtmlEntity paramHtmlEntity) {
/* 81 */     this.myEndOffset = paramHtmlEntity.getEndOffset();
/*    */   }
/*    */   
/*    */   private void visit(HtmlInline paramHtmlInline) {
/* 85 */     this.myEndOffset = paramHtmlInline.getEndOffset();
/*    */   }
/*    */   
/*    */   private void visit(Text paramText) {
/* 89 */     this.myEndOffset = paramText.getEndOffset();
/*    */   }
/*    */   
/*    */   private void visit(TextBase paramTextBase) {
/* 93 */     this.myEndOffset = paramTextBase.getEndOffset();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\LineCollectingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */