/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Block
/*    */   extends ContentNode
/*    */ {
/*    */   public Block() {}
/*    */   
/*    */   public Block(BasedSequence paramBasedSequence) {
/* 14 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public Block(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 18 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public Block(List<BasedSequence> paramList) {
/* 22 */     super(paramList);
/*    */   }
/*    */   
/*    */   public Block(BlockContent paramBlockContent) {
/* 26 */     super(paramBlockContent);
/*    */   }
/*    */ 
/*    */   
/*    */   public Block getParent() {
/* 31 */     return (Block)super.getParent();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setParent(Node paramNode) {
/* 36 */     if (paramNode != null && !(paramNode instanceof Block)) {
/* 37 */       throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
/*    */     }
/* 39 */     super.setParent(paramNode);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\Block.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */