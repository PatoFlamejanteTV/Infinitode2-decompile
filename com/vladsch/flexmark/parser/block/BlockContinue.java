/*    */ package com.vladsch.flexmark.parser.block;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.internal.BlockContinueImpl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockContinue
/*    */ {
/*    */   public static BlockContinue none() {
/* 14 */     return null;
/*    */   }
/*    */   
/*    */   public static BlockContinue atIndex(int paramInt) {
/* 18 */     return (BlockContinue)new BlockContinueImpl(paramInt, -1, false);
/*    */   }
/*    */   
/*    */   public static BlockContinue atColumn(int paramInt) {
/* 22 */     return (BlockContinue)new BlockContinueImpl(-1, paramInt, false);
/*    */   }
/*    */   
/*    */   public static BlockContinue finished() {
/* 26 */     return (BlockContinue)new BlockContinueImpl(-1, -1, true);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\BlockContinue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */