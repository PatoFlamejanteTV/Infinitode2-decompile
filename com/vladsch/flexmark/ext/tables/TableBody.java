/*    */ package com.vladsch.flexmark.ext.tables;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TableBody
/*    */   extends Node
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 14 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public TableBody() {}
/*    */   
/*    */   public TableBody(BasedSequence paramBasedSequence) {
/* 21 */     super(paramBasedSequence);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableBody.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */