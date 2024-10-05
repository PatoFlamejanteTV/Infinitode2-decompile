/*    */ package com.vladsch.flexmark.ext.xwiki.macros;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MacroClose
/*    */   extends Node
/*    */ {
/* 11 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 12 */   protected BasedSequence name = BasedSequence.NULL;
/* 13 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 19 */     return new BasedSequence[] { this.openingMarker, this.name, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 24 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.name, this.closingMarker, "name");
/*    */   }
/*    */ 
/*    */   
/*    */   public MacroClose() {}
/*    */   
/*    */   public MacroClose(BasedSequence paramBasedSequence) {
/* 31 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public MacroClose(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 35 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/* 36 */     this.openingMarker = paramBasedSequence1;
/* 37 */     this.name = paramBasedSequence2;
/* 38 */     this.closingMarker = paramBasedSequence3;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 42 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 46 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getName() {
/* 50 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(BasedSequence paramBasedSequence) {
/* 54 */     this.name = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 58 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 62 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\MacroClose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */