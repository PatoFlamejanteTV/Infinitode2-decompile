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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class HtmlBlockBase
/*    */   extends Block
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 19 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public HtmlBlockBase() {}
/*    */   
/*    */   public HtmlBlockBase(BasedSequence paramBasedSequence) {
/* 26 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public HtmlBlockBase(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 30 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public HtmlBlockBase(BlockContent paramBlockContent) {
/* 34 */     super(paramBlockContent);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\HtmlBlockBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */