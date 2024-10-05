/*    */ package com.vladsch.flexmark.ext.jekyll.tag;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.ast.Node;
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
/*    */ 
/*    */ public class JekyllTagBlock
/*    */   extends Block
/*    */ {
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {}
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 23 */     return Node.EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public JekyllTagBlock() {}
/*    */   
/*    */   public JekyllTagBlock(BasedSequence paramBasedSequence) {
/* 30 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public JekyllTagBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 34 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public JekyllTagBlock(List<BasedSequence> paramList) {
/* 38 */     super(paramList);
/*    */   }
/*    */   
/*    */   public JekyllTagBlock(BlockContent paramBlockContent) {
/* 42 */     super(paramBlockContent);
/*    */   }
/*    */ 
/*    */   
/*    */   public JekyllTagBlock(Node paramNode) {
/* 47 */     appendChild(paramNode);
/* 48 */     setCharsFromContent();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\JekyllTagBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */