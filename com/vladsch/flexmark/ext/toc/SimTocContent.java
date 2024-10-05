/*    */ package com.vladsch.flexmark.ext.toc;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimTocContent
/*    */   extends Block
/*    */   implements DoNotDecorate
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 19 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {}
/*    */ 
/*    */   
/*    */   public SimTocContent() {}
/*    */ 
/*    */   
/*    */   public SimTocContent(BasedSequence paramBasedSequence) {
/* 30 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public SimTocContent(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 34 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public SimTocContent(List<BasedSequence> paramList) {
/* 38 */     super(paramList);
/*    */   }
/*    */   
/*    */   public SimTocContent(BlockContent paramBlockContent) {
/* 42 */     super(paramBlockContent);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\SimTocContent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */