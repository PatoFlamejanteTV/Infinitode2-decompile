/*     */ package com.vladsch.flexmark.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.parser.ListOptions;
/*     */ import com.vladsch.flexmark.util.ast.BlankLineContainer;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.List;
/*     */ 
/*     */ public abstract class ListItem
/*     */   extends Block
/*     */   implements ParagraphContainer, ParagraphItemContainer, BlankLineContainer {
/*  15 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  16 */   protected BasedSequence markerSuffix = BasedSequence.NULL;
/*     */   private boolean tight = true;
/*     */   private boolean hadBlankAfterItemParagraph = false;
/*     */   private boolean containsBlankLine = false;
/*  20 */   private int priority = Integer.MIN_VALUE;
/*     */ 
/*     */   
/*     */   public ListItem() {}
/*     */   
/*     */   public ListItem(ListItem paramListItem) {
/*  26 */     this.openingMarker = paramListItem.openingMarker;
/*  27 */     this.markerSuffix = paramListItem.markerSuffix;
/*  28 */     this.tight = paramListItem.tight;
/*  29 */     this.hadBlankAfterItemParagraph = paramListItem.hadBlankAfterItemParagraph;
/*  30 */     this.containsBlankLine = paramListItem.containsBlankLine;
/*  31 */     this.priority = paramListItem.priority;
/*     */     
/*  33 */     takeChildren((Node)paramListItem);
/*  34 */     setCharsFromContent();
/*     */   }
/*     */   
/*     */   public ListItem(BasedSequence paramBasedSequence) {
/*  38 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public ListItem(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/*  42 */     super(paramBasedSequence, paramList);
/*     */   }
/*     */   
/*     */   public ListItem(BlockContent paramBlockContent) {
/*  46 */     super(paramBlockContent);
/*     */   }
/*     */   
/*     */   public boolean isOrderedItem() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  55 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "open");
/*  56 */     segmentSpanChars(paramStringBuilder, this.markerSuffix, "openSuffix");
/*  57 */     if (isTight()) { paramStringBuilder.append(" isTight"); }
/*  58 */     else { paramStringBuilder.append(" isLoose"); }
/*  59 */      if (isHadBlankAfterItemParagraph()) { paramStringBuilder.append(" hadBlankLineAfter"); return; }
/*  60 */      if (isContainsBlankLine()) paramStringBuilder.append(" hadBlankLine");
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  66 */     return new BasedSequence[] { this.openingMarker, this.markerSuffix };
/*     */   }
/*     */   
/*     */   public boolean canChangeMarker() {
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   public int getPriority() {
/*  74 */     return this.priority;
/*     */   }
/*     */   
/*     */   public void setPriority(int paramInt) {
/*  78 */     this.priority = paramInt;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  82 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  86 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getMarkerSuffix() {
/*  90 */     return this.markerSuffix;
/*     */   }
/*     */   
/*     */   public void setMarkerSuffix(BasedSequence paramBasedSequence) {
/*  94 */     assert paramBasedSequence.isNull() || this.openingMarker.getBase() == paramBasedSequence.getBase();
/*     */     
/*  96 */     this.markerSuffix = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setTight(boolean paramBoolean) {
/* 100 */     this.tight = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setLoose(boolean paramBoolean) {
/* 104 */     this.tight = !paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isTight() {
/* 108 */     return (this.tight && isInTightList());
/*     */   }
/*     */   
/*     */   public boolean isOwnTight() {
/* 112 */     return this.tight;
/*     */   }
/*     */   
/*     */   public boolean isLoose() {
/* 116 */     return !isTight();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphEndWrappingDisabled(Paragraph paramParagraph) {
/* 121 */     return ((getFirstChild() != paramParagraph && getLastChild() == paramParagraph) || (getFirstChild() == paramParagraph && (getParent() == null || getParent().getLastChildAny(new Class[] { ListItem.class }) == this)));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphStartWrappingDisabled(Paragraph paramParagraph) {
/* 126 */     return isItemParagraph(paramParagraph);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphInTightListItem(Paragraph paramParagraph) {
/* 131 */     if (!isTight()) return false;
/*     */ 
/*     */     
/* 134 */     return isItemParagraph(paramParagraph);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isItemParagraph(Paragraph paramParagraph) {
/* 139 */     Node node = getFirstChild();
/* 140 */     for (; node != null && !(node instanceof Paragraph); node = node.getNext());
/* 141 */     return (node == paramParagraph);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphWrappingDisabled(Paragraph paramParagraph, ListOptions paramListOptions, DataHolder paramDataHolder) {
/* 146 */     assert paramParagraph.getParent() == this;
/* 147 */     return paramListOptions.isInTightListItem(paramParagraph);
/*     */   }
/*     */   
/*     */   public boolean isInTightList() {
/* 151 */     return (!(getParent() instanceof ListBlock) || ((ListBlock)getParent()).isTight());
/*     */   }
/*     */   
/*     */   public boolean isHadBlankAfterItemParagraph() {
/* 155 */     return this.hadBlankAfterItemParagraph;
/*     */   }
/*     */   
/*     */   public boolean isContainsBlankLine() {
/* 159 */     return this.containsBlankLine;
/*     */   }
/*     */   
/*     */   public void setContainsBlankLine(boolean paramBoolean) {
/* 163 */     this.containsBlankLine = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHadBlankAfterItemParagraph(boolean paramBoolean) {
/* 168 */     this.hadBlankAfterItemParagraph = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Node getLastBlankLineChild() {
/* 173 */     return getLastChild();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\ListItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */