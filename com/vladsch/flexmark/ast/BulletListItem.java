/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class BulletListItem
/*    */   extends ListItem
/*    */ {
/*    */   public BulletListItem() {}
/*    */   
/*    */   public BulletListItem(BasedSequence paramBasedSequence) {
/* 14 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public BulletListItem(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 18 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public BulletListItem(BlockContent paramBlockContent) {
/* 22 */     super(paramBlockContent);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\BulletListItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */