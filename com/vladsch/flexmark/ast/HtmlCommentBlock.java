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
/*    */ public class HtmlCommentBlock
/*    */   extends HtmlBlockBase
/*    */ {
/*    */   public HtmlCommentBlock() {}
/*    */   
/*    */   public HtmlCommentBlock(BasedSequence paramBasedSequence) {
/* 18 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public HtmlCommentBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 22 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public HtmlCommentBlock(BlockContent paramBlockContent) {
/* 26 */     super(paramBlockContent);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\HtmlCommentBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */