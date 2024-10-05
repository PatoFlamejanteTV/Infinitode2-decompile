/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WhiteSpace
/*    */   extends Node
/*    */ {
/*    */   public WhiteSpace() {}
/*    */   
/*    */   public WhiteSpace(BasedSequence paramBasedSequence) {
/* 15 */     super(paramBasedSequence);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 21 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 26 */     astExtraChars(paramStringBuilder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String toStringAttributes() {
/* 32 */     return "text=" + getChars();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\WhiteSpace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */