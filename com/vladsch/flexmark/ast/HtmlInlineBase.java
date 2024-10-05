/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class HtmlInlineBase
/*    */   extends Node
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 16 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 21 */     astExtraChars(paramStringBuilder);
/*    */   }
/*    */ 
/*    */   
/*    */   public HtmlInlineBase() {}
/*    */   
/*    */   public HtmlInlineBase(BasedSequence paramBasedSequence) {
/* 28 */     super(paramBasedSequence);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\HtmlInlineBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */