/*     */ package com.vladsch.flexmark.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.html.HtmlRenderer;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
/*     */ import com.vladsch.flexmark.util.ast.TextContainer;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Heading extends Block implements AnchorRefTarget {
/*     */   protected int level;
/*  15 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  16 */   protected BasedSequence text = BasedSequence.NULL;
/*  17 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*  18 */   protected String anchorRefId = "";
/*     */   
/*     */   protected boolean explicitAnchorRefId = false;
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  23 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.text, this.closingMarker, "text");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  29 */     return new BasedSequence[] { this.openingMarker, this.text, this.closingMarker };
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnchorRefText() {
/*  34 */     boolean bool1 = ((Boolean)HtmlRenderer.HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES.get((DataHolder)getDocument())).booleanValue();
/*  35 */     boolean bool2 = ((Boolean)HtmlRenderer.HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES.get((DataHolder)getDocument())).booleanValue();
/*     */     
/*  37 */     return (new TextCollectingVisitor()).collectAndGetText((Node)this, TextContainer.F_FOR_HEADING_ID + (bool1 ? 0 : TextContainer.F_NO_TRIM_REF_TEXT_START) + (bool2 ? 0 : TextContainer.F_NO_TRIM_REF_TEXT_END));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAnchorRefId() {
/*  42 */     return this.anchorRefId;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnchorRefId(String paramString) {
/*  47 */     this.anchorRefId = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isExplicitAnchorRefId() {
/*  52 */     return this.explicitAnchorRefId;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setExplicitAnchorRefId(boolean paramBoolean) {
/*  57 */     this.explicitAnchorRefId = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Heading() {}
/*     */   
/*     */   public Heading(BasedSequence paramBasedSequence) {
/*  64 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public Heading(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/*  68 */     super(paramBasedSequence, paramList);
/*     */   }
/*     */   
/*     */   public Heading(BlockContent paramBlockContent) {
/*  72 */     super(paramBlockContent);
/*     */   }
/*     */   
/*     */   public boolean isAtxHeading() {
/*  76 */     return (this.openingMarker != BasedSequence.NULL);
/*     */   }
/*     */   
/*     */   public boolean isSetextHeading() {
/*  80 */     return (this.openingMarker == BasedSequence.NULL && this.closingMarker != BasedSequence.NULL);
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  84 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  88 */     this.openingMarker = (paramBasedSequence == null) ? BasedSequence.NULL : paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getText() {
/*  92 */     return this.text;
/*     */   }
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/*  96 */     this.text = (paramBasedSequence == null) ? BasedSequence.NULL : paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/* 100 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 104 */     this.closingMarker = (paramBasedSequence == null) ? BasedSequence.NULL : paramBasedSequence;
/*     */   }
/*     */   
/*     */   public int getLevel() {
/* 108 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(int paramInt) {
/* 112 */     this.level = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\Heading.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */