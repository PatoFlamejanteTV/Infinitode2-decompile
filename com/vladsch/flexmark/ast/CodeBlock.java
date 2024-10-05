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
/*    */ public class CodeBlock
/*    */   extends Block
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 15 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public CodeBlock() {}
/*    */   
/*    */   public CodeBlock(BasedSequence paramBasedSequence) {
/* 22 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public CodeBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 26 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public CodeBlock(BlockContent paramBlockContent) {
/* 30 */     super(paramBlockContent);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\CodeBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */