/*    */ package com.vladsch.flexmark.ext.tables.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TableColumnSeparator
/*    */   extends Node
/*    */   implements DoNotDecorate
/*    */ {
/*    */   public TableColumnSeparator() {}
/*    */   
/*    */   public TableColumnSeparator(BasedSequence paramBasedSequence) {
/* 17 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public TableColumnSeparator(String paramString) {
/* 21 */     super(BasedSequence.of(paramString));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 27 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 32 */     astExtraChars(paramStringBuilder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String toStringAttributes() {
/* 38 */     return "text=" + getChars();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\internal\TableColumnSeparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */