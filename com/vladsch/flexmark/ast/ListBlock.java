/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.BlankLineContainer;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public abstract class ListBlock
/*    */   extends Block
/*    */   implements BlankLineContainer
/*    */ {
/*    */   private boolean tight;
/*    */   
/*    */   public ListBlock() {}
/*    */   
/*    */   public ListBlock(BasedSequence paramBasedSequence) {
/* 20 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public ListBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 24 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public ListBlock(BlockContent paramBlockContent) {
/* 28 */     super(paramBlockContent);
/*    */   }
/*    */   
/*    */   public boolean isTight() {
/* 32 */     return this.tight;
/*    */   }
/*    */   
/*    */   public boolean isLoose() {
/* 36 */     return !this.tight;
/*    */   }
/*    */   
/*    */   public void setTight(boolean paramBoolean) {
/* 40 */     this.tight = paramBoolean;
/*    */   }
/*    */   
/*    */   public void setLoose(boolean paramBoolean) {
/* 44 */     this.tight = !paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public Node getLastBlankLineChild() {
/* 49 */     return getLastChild();
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 54 */     super.getAstExtra(paramStringBuilder);
/* 55 */     if (isTight()) { paramStringBuilder.append(" isTight"); return; }
/* 56 */      paramStringBuilder.append(" isLoose");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\ListBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */