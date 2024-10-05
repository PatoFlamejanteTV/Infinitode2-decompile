/*    */ package com.vladsch.flexmark.ext.tables;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.BlankLineBreakNode;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TableBlock
/*    */   extends Block
/*    */   implements BlankLineBreakNode
/*    */ {
/*    */   public TableBlock() {}
/*    */   
/*    */   public TableBlock(BasedSequence paramBasedSequence) {
/* 20 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public TableBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 24 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public TableBlock(List<BasedSequence> paramList) {
/* 28 */     super(paramList);
/*    */   }
/*    */   
/*    */   public TableBlock(BlockContent paramBlockContent) {
/* 32 */     super(paramBlockContent);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 38 */     return new BasedSequence[0];
/*    */   }
/*    */   
/*    */   TableCaption getCaption() {
/*    */     Node node;
/* 43 */     return (node = getLastChild() instanceof TableCaption) ? (TableCaption)node : null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */