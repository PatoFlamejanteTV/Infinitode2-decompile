/*    */ package com.vladsch.flexmark.ext.definition;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.ListBlock;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefinitionList
/*    */   extends ListBlock
/*    */ {
/*    */   public DefinitionList() {}
/*    */   
/*    */   public DefinitionList(BasedSequence paramBasedSequence) {
/* 18 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public DefinitionList(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 22 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public DefinitionList(BlockContent paramBlockContent) {
/* 26 */     super(paramBlockContent);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 32 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\DefinitionList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */