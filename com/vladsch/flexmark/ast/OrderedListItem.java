/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ public class OrderedListItem
/*    */   extends ListItem
/*    */ {
/*    */   public OrderedListItem() {}
/*    */   
/*    */   public OrderedListItem(BasedSequence paramBasedSequence) {
/* 13 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public OrderedListItem(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 17 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public OrderedListItem(BlockContent paramBlockContent) {
/* 21 */     super(paramBlockContent);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrderedItem() {
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\OrderedListItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */