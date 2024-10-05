/*    */ package com.vladsch.flexmark.ext.tables;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.LineBreakNode;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TableRow
/*    */   extends Node
/*    */   implements LineBreakNode
/*    */ {
/*    */   private int rowNumber;
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 19 */     super.getAstExtra(paramStringBuilder);
/* 20 */     if (this.rowNumber != 0) paramStringBuilder.append(" rowNumber=").append(this.rowNumber);
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 26 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public TableRow() {}
/*    */   
/*    */   public TableRow(BasedSequence paramBasedSequence) {
/* 33 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public int getRowNumber() {
/* 37 */     return this.rowNumber;
/*    */   }
/*    */   
/*    */   public void setRowNumber(int paramInt) {
/* 41 */     this.rowNumber = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableRow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */