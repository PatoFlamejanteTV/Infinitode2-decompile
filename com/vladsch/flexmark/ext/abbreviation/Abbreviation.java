/*    */ package com.vladsch.flexmark.ext.abbreviation;
/*    */ import com.vladsch.flexmark.ext.abbreviation.internal.AbbreviationRepository;
/*    */ import com.vladsch.flexmark.util.ast.DoNotDecorate;
/*    */ import com.vladsch.flexmark.util.ast.DoNotLinkDecorate;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*    */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*    */ import com.vladsch.flexmark.util.ast.ReferencingNode;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class Abbreviation extends Node implements DoNotDecorate, DoNotLinkDecorate, ReferencingNode<AbbreviationRepository, AbbreviationBlock> {
/*    */   public Abbreviation(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2) {
/* 15 */     super(paramBasedSequence1);
/* 16 */     this.abbreviation = paramBasedSequence2;
/*    */   }
/*    */   protected final BasedSequence abbreviation;
/*    */   public BasedSequence getAbbreviation() {
/* 20 */     return this.abbreviation;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 26 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 31 */     astExtraChars(paramStringBuilder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String toStringAttributes() {
/* 37 */     return "text=" + getChars();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDefined() {
/* 42 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence getReference() {
/* 48 */     return this.abbreviation;
/*    */   }
/*    */ 
/*    */   
/*    */   public AbbreviationBlock getReferenceNode(Document paramDocument) {
/* 53 */     return getReferenceNode((AbbreviationRepository)AbbreviationExtension.ABBREVIATIONS.get((DataHolder)paramDocument));
/*    */   }
/*    */ 
/*    */   
/*    */   public AbbreviationBlock getReferenceNode(AbbreviationRepository paramAbbreviationRepository) {
/* 58 */     return (AbbreviationBlock)paramAbbreviationRepository.get(getChars().toString());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\Abbreviation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */