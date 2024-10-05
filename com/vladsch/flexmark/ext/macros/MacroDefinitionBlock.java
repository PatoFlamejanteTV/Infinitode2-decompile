/*     */ package com.vladsch.flexmark.ext.macros;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.macros.internal.MacroDefinitionRepository;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MacroDefinitionBlock
/*     */   extends Block
/*     */   implements ReferenceNode<MacroDefinitionRepository, MacroDefinitionBlock, MacroReference>
/*     */ {
/*  19 */   private BasedSequence openingMarker = BasedSequence.NULL;
/*  20 */   private BasedSequence name = BasedSequence.NULL;
/*  21 */   private BasedSequence openingTrailing = BasedSequence.NULL;
/*  22 */   private BasedSequence closingMarker = BasedSequence.NULL;
/*  23 */   private BasedSequence closingTrailing = BasedSequence.NULL;
/*  24 */   private int ordinal = 0;
/*  25 */   private int firstReferenceOffset = Integer.MAX_VALUE;
/*  26 */   private int footnoteReferences = 0;
/*     */   private boolean inExpansion = false;
/*     */   
/*     */   public int getFootnoteReferences() {
/*  30 */     return this.footnoteReferences;
/*     */   }
/*     */   
/*     */   public void setFootnoteReferences(int paramInt) {
/*  34 */     this.footnoteReferences = paramInt;
/*     */   }
/*     */   
/*     */   public int getFirstReferenceOffset() {
/*  38 */     return this.firstReferenceOffset;
/*     */   }
/*     */   
/*     */   public void setFirstReferenceOffset(int paramInt) {
/*  42 */     this.firstReferenceOffset = paramInt;
/*     */   }
/*     */   
/*     */   public void addFirstReferenceOffset(int paramInt) {
/*  46 */     if (this.firstReferenceOffset < paramInt) this.firstReferenceOffset = paramInt; 
/*     */   }
/*     */   
/*     */   public boolean isReferenced() {
/*  50 */     return (this.firstReferenceOffset < Integer.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public int getOrdinal() {
/*  54 */     return this.ordinal;
/*     */   }
/*     */   
/*     */   public void setOrdinal(int paramInt) {
/*  58 */     this.ordinal = paramInt;
/*     */   }
/*     */   
/*     */   public boolean isInExpansion() {
/*  62 */     return this.inExpansion;
/*     */   }
/*     */   
/*     */   public void setInExpansion(boolean paramBoolean) {
/*  66 */     this.inExpansion = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  71 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "open");
/*  72 */     segmentSpanChars(paramStringBuilder, this.name, "name");
/*  73 */     segmentSpanChars(paramStringBuilder, this.openingTrailing, "openTrail");
/*  74 */     segmentSpanChars(paramStringBuilder, this.closingMarker, "close");
/*  75 */     segmentSpanChars(paramStringBuilder, this.closingTrailing, "closeTrail");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  81 */     return new BasedSequence[] { this.openingMarker, this.name, this.openingTrailing, this.closingMarker, this.closingTrailing };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MacroReference getReferencingNode(Node paramNode) {
/*  87 */     return (paramNode instanceof MacroReference) ? (MacroReference)paramNode : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(MacroDefinitionBlock paramMacroDefinitionBlock) {
/*  92 */     return SequenceUtils.compare((CharSequence)this.name, (CharSequence)paramMacroDefinitionBlock.name, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MacroDefinitionBlock(BasedSequence paramBasedSequence) {
/*  99 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public MacroDefinitionBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 103 */     super(paramBasedSequence, paramList);
/*     */   }
/*     */   
/*     */   public MacroDefinitionBlock(BlockContent paramBlockContent) {
/* 107 */     super(paramBlockContent);
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/* 111 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 115 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getName() {
/* 119 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(BasedSequence paramBasedSequence) {
/* 123 */     this.name = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/* 127 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 131 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningTrailing() {
/* 135 */     return this.openingTrailing;
/*     */   }
/*     */   
/*     */   public void setOpeningTrailing(BasedSequence paramBasedSequence) {
/* 139 */     this.openingTrailing = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingTrailing() {
/* 143 */     return this.closingTrailing;
/*     */   }
/*     */   
/*     */   public void setClosingTrailing(BasedSequence paramBasedSequence) {
/* 147 */     this.closingTrailing = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public MacroDefinitionBlock() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\MacroDefinitionBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */