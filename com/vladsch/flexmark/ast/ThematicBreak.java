/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThematicBreak
/*    */   extends Block
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 14 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public ThematicBreak() {}
/*    */   
/*    */   public ThematicBreak(BasedSequence paramBasedSequence) {
/* 21 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public ThematicBreak(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 25 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public ThematicBreak(BlockContent paramBlockContent) {
/* 29 */     super(paramBlockContent);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\ThematicBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */