/*    */ package com.vladsch.flexmark.parser.block;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.internal.BlockStartImpl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BlockStart
/*    */ {
/*    */   public static BlockStart none() {
/* 14 */     return null;
/*    */   }
/*    */   
/*    */   public static BlockStart of(BlockParser... paramVarArgs) {
/* 18 */     return (BlockStart)new BlockStartImpl(paramVarArgs);
/*    */   }
/*    */   
/*    */   public abstract BlockStart atIndex(int paramInt);
/*    */   
/*    */   public abstract BlockStart atColumn(int paramInt);
/*    */   
/*    */   public abstract BlockStart replaceActiveBlockParser();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\BlockStart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */