/*    */ package com.vladsch.flexmark.ext.toc;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimTocOptionList
/*    */   extends Node
/*    */   implements DoNotDecorate
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 16 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public SimTocOptionList() {}
/*    */   
/*    */   public SimTocOptionList(BasedSequence paramBasedSequence) {
/* 23 */     super(paramBasedSequence);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\SimTocOptionList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */