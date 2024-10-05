/*     */ package com.vladsch.flexmark.ext.macros;
/*     */ import com.vladsch.flexmark.ext.macros.internal.MacroDefinitionRepository;
/*     */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*     */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public class MacroReference extends Node implements DelimitedNode, DoNotDecorate, ReferencingNode<MacroDefinitionRepository, MacroDefinitionBlock> {
/*  12 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  13 */   protected BasedSequence text = BasedSequence.NULL;
/*  14 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*     */   
/*     */   protected MacroDefinitionBlock myMacroDefinitionBlock;
/*     */   
/*     */   public boolean isDefined() {
/*  19 */     return (this.myMacroDefinitionBlock != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getReference() {
/*  25 */     return this.text;
/*     */   }
/*     */ 
/*     */   
/*     */   public MacroDefinitionBlock getReferenceNode(Document paramDocument) {
/*  30 */     if (this.myMacroDefinitionBlock != null || this.text.isEmpty()) return this.myMacroDefinitionBlock; 
/*  31 */     this.myMacroDefinitionBlock = getMacroDefinitionBlock((MacroDefinitionRepository)MacrosExtension.MACRO_DEFINITIONS.get((DataHolder)paramDocument));
/*  32 */     return this.myMacroDefinitionBlock;
/*     */   }
/*     */ 
/*     */   
/*     */   public MacroDefinitionBlock getReferenceNode(MacroDefinitionRepository paramMacroDefinitionRepository) {
/*  37 */     if (this.myMacroDefinitionBlock != null || this.text.isEmpty()) return this.myMacroDefinitionBlock; 
/*  38 */     this.myMacroDefinitionBlock = getMacroDefinitionBlock(paramMacroDefinitionRepository);
/*  39 */     return this.myMacroDefinitionBlock;
/*     */   }
/*     */   
/*     */   public MacroDefinitionBlock getMacroDefinitionBlock(MacroDefinitionRepository paramMacroDefinitionRepository) {
/*  43 */     return this.text.isEmpty() ? null : (MacroDefinitionBlock)paramMacroDefinitionRepository.get(this.text.toString());
/*     */   }
/*     */   
/*     */   public MacroDefinitionBlock getMacroDefinitionBlock() {
/*  47 */     return this.myMacroDefinitionBlock;
/*     */   }
/*     */   
/*     */   public void setMacroDefinitionBlock(MacroDefinitionBlock paramMacroDefinitionBlock) {
/*  51 */     this.myMacroDefinitionBlock = paramMacroDefinitionBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  58 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  63 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MacroReference(BasedSequence paramBasedSequence) {
/*  70 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public MacroReference(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/*  74 */     super(paramBasedSequence1.baseSubSequence(paramBasedSequence1.getStartOffset(), paramBasedSequence3.getEndOffset()));
/*  75 */     this.openingMarker = paramBasedSequence1;
/*  76 */     this.text = paramBasedSequence2;
/*  77 */     this.closingMarker = paramBasedSequence3;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  81 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  85 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getText() {
/*  89 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/*  93 */     this.text = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/*  97 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 101 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public MacroReference() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\MacroReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */