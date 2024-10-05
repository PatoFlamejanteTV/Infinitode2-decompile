/*    */ package com.vladsch.flexmark.parser.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*    */ 
/*    */ public class BlockContinueImpl
/*    */   extends BlockContinue {
/*    */   private final int newIndex;
/*    */   private final int newColumn;
/*    */   private final boolean finalize;
/*    */   
/*    */   public BlockContinueImpl(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 12 */     this.newIndex = paramInt1;
/* 13 */     this.newColumn = paramInt2;
/* 14 */     this.finalize = paramBoolean;
/*    */   }
/*    */   
/*    */   public int getNewIndex() {
/* 18 */     return this.newIndex;
/*    */   }
/*    */   
/*    */   public int getNewColumn() {
/* 22 */     return this.newColumn;
/*    */   }
/*    */   
/*    */   public boolean isFinalize() {
/* 26 */     return this.finalize;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\BlockContinueImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */