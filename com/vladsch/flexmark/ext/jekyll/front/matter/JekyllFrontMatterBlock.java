/*    */ package com.vladsch.flexmark.ext.jekyll.front.matter;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JekyllFrontMatterBlock
/*    */   extends Block
/*    */ {
/* 12 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 13 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 17 */     segmentSpan(paramStringBuilder, this.openingMarker, "open");
/* 18 */     segmentSpan(paramStringBuilder, getContent(), "content");
/* 19 */     segmentSpan(paramStringBuilder, this.closingMarker, "close");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 25 */     return new BasedSequence[] { this.openingMarker, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public JekyllFrontMatterBlock() {}
/*    */   
/*    */   public JekyllFrontMatterBlock(BasedSequence paramBasedSequence) {
/* 32 */     super(paramBasedSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public JekyllFrontMatterBlock(Node paramNode) {
/* 37 */     appendChild(paramNode);
/* 38 */     setCharsFromContent();
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
/*    */   public BasedSequence getContent() {
/* 50 */     return getContentChars();
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 54 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 58 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public void accept(JekyllFrontMatterVisitor paramJekyllFrontMatterVisitor) {
/* 62 */     paramJekyllFrontMatterVisitor.visit(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\front\matter\JekyllFrontMatterBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */