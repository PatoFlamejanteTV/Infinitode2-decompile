/*    */ package com.vladsch.flexmark.parser.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.block.BlockParser;
/*    */ import com.vladsch.flexmark.parser.block.BlockStart;
/*    */ 
/*    */ public class BlockStartImpl
/*    */   extends BlockStart {
/*    */   private final BlockParser[] blockParsers;
/*  9 */   private int newIndex = -1;
/* 10 */   private int newColumn = -1;
/*    */   private boolean replaceActiveBlockParser = false;
/*    */   
/*    */   public BlockStartImpl(BlockParser... paramVarArgs) {
/* 14 */     this.blockParsers = paramVarArgs;
/*    */   }
/*    */   
/*    */   public BlockParser[] getBlockParsers() {
/* 18 */     return this.blockParsers;
/*    */   }
/*    */   
/*    */   public int getNewIndex() {
/* 22 */     return this.newIndex;
/*    */   }
/*    */   
/*    */   public int getNewColumn() {
/* 26 */     return this.newColumn;
/*    */   }
/*    */   
/*    */   public boolean isReplaceActiveBlockParser() {
/* 30 */     return this.replaceActiveBlockParser;
/*    */   }
/*    */ 
/*    */   
/*    */   public BlockStart atIndex(int paramInt) {
/* 35 */     this.newIndex = paramInt;
/* 36 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public BlockStart atColumn(int paramInt) {
/* 41 */     this.newColumn = paramInt;
/* 42 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public BlockStart replaceActiveBlockParser() {
/* 47 */     this.replaceActiveBlockParser = true;
/* 48 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\BlockStartImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */