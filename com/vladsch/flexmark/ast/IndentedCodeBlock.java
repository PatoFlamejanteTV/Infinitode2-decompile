/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IndentedCodeBlock
/*    */   extends Block
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 15 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public IndentedCodeBlock() {}
/*    */   
/*    */   public IndentedCodeBlock(BasedSequence paramBasedSequence) {
/* 22 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public IndentedCodeBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 26 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public IndentedCodeBlock(BlockContent paramBlockContent) {
/* 30 */     super(paramBlockContent);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\IndentedCodeBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */