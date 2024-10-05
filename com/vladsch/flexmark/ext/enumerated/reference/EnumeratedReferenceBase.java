/*    */ package com.vladsch.flexmark.ext.enumerated.reference;
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*    */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*    */ import com.vladsch.flexmark.util.ast.ReferencingNode;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class EnumeratedReferenceBase extends Node implements DelimitedNode, DoNotDecorate, ReferencingNode<EnumeratedReferenceRepository, EnumeratedReferenceBlock> {
/* 11 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 12 */   protected BasedSequence text = BasedSequence.NULL;
/* 13 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */   
/*    */   protected EnumeratedReferenceBlock enumeratedReferenceBlock;
/*    */ 
/*    */   
/*    */   public BasedSequence getReference() {
/* 19 */     return this.text;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumeratedReferenceBlock getReferenceNode(Document paramDocument) {
/* 24 */     return this.enumeratedReferenceBlock;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumeratedReferenceBlock getReferenceNode(EnumeratedReferenceRepository paramEnumeratedReferenceRepository) {
/* 29 */     if (this.enumeratedReferenceBlock != null || this.text.isEmpty()) return this.enumeratedReferenceBlock; 
/* 30 */     this.enumeratedReferenceBlock = getEnumeratedReferenceBlock(paramEnumeratedReferenceRepository);
/* 31 */     return this.enumeratedReferenceBlock;
/*    */   }
/*    */   
/*    */   public boolean isDefined() {
/* 35 */     return (this.enumeratedReferenceBlock != null);
/*    */   }
/*    */   
/*    */   public EnumeratedReferenceBlock getEnumeratedReferenceBlock(EnumeratedReferenceRepository paramEnumeratedReferenceRepository) {
/* 39 */     return this.text.isEmpty() ? null : (EnumeratedReferenceBlock)paramEnumeratedReferenceRepository.get(EnumeratedReferenceRepository.getType(this.text.toString()));
/*    */   }
/*    */   
/*    */   public EnumeratedReferenceBlock getEnumeratedReferenceBlock() {
/* 43 */     return this.enumeratedReferenceBlock;
/*    */   }
/*    */   
/*    */   public void setEnumeratedReferenceBlock(EnumeratedReferenceBlock paramEnumeratedReferenceBlock) {
/* 47 */     this.enumeratedReferenceBlock = paramEnumeratedReferenceBlock;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 53 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 58 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumeratedReferenceBase(BasedSequence paramBasedSequence) {
/* 65 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public EnumeratedReferenceBase(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 69 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/* 70 */     this.openingMarker = paramBasedSequence1;
/* 71 */     this.text = paramBasedSequence2;
/* 72 */     this.closingMarker = paramBasedSequence3;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 76 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 80 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getText() {
/* 84 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(BasedSequence paramBasedSequence) {
/* 88 */     this.text = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 92 */     return this.closingMarker;
/*    */   }
/*    */   
/*    */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 96 */     this.closingMarker = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public EnumeratedReferenceBase() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\EnumeratedReferenceBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */