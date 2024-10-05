/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class BlankLine
/*    */   extends Block
/*    */ {
/*  8 */   private Block claimedBlankLine = null;
/*    */   
/*    */   public boolean isClaimed() {
/* 11 */     return (this.claimedBlankLine != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public Block getClaimedBlankLine() {
/* 16 */     return this.claimedBlankLine;
/*    */   }
/*    */ 
/*    */   
/*    */   public BlankLine setClaimedBlankLine(Block paramBlock) {
/* 21 */     this.claimedBlankLine = paramBlock;
/* 22 */     return this;
/*    */   }
/*    */   
/*    */   public BlankLine(BasedSequence paramBasedSequence) {
/* 26 */     super(paramBasedSequence);
/* 27 */     setCharsFromContent();
/*    */   }
/*    */   
/*    */   public BlankLine(BasedSequence paramBasedSequence, Block paramBlock) {
/* 31 */     super(paramBasedSequence);
/* 32 */     setCharsFromContent();
/* 33 */     this.claimedBlankLine = paramBlock;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 39 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\BlankLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */