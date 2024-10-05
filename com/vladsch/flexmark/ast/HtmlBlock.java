/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HtmlBlock
/*    */   extends HtmlBlockBase
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 18 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public HtmlBlock() {}
/*    */   
/*    */   public HtmlBlock(BasedSequence paramBasedSequence) {
/* 25 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public HtmlBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 29 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public HtmlBlock(BlockContent paramBlockContent) {
/* 33 */     super(paramBlockContent);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\HtmlBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */