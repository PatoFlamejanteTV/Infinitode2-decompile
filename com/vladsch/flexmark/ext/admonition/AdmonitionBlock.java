/*     */ package com.vladsch.flexmark.ext.admonition;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ast.ParagraphContainer;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AdmonitionBlock
/*     */   extends Block
/*     */   implements ParagraphContainer
/*     */ {
/*  15 */   private BasedSequence openingMarker = BasedSequence.NULL;
/*  16 */   private BasedSequence info = BasedSequence.NULL;
/*  17 */   protected BasedSequence titleOpeningMarker = BasedSequence.NULL;
/*  18 */   protected BasedSequence title = BasedSequence.NULL;
/*  19 */   protected BasedSequence titleClosingMarker = BasedSequence.NULL;
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  24 */     return new BasedSequence[] { this.openingMarker, this.info, this.titleOpeningMarker, this.title, this.titleClosingMarker };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegmentsForChars() {
/*  36 */     return new BasedSequence[] { this.openingMarker, this.info, this.titleOpeningMarker, this.title, this.titleClosingMarker };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  47 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "open");
/*  48 */     segmentSpanChars(paramStringBuilder, this.info, "info");
/*  49 */     delimitedSegmentSpanChars(paramStringBuilder, this.titleOpeningMarker, this.title, this.titleClosingMarker, "title");
/*     */   }
/*     */ 
/*     */   
/*     */   public AdmonitionBlock() {}
/*     */   
/*     */   public AdmonitionBlock(BasedSequence paramBasedSequence) {
/*  56 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public AdmonitionBlock(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, List<BasedSequence> paramList) {
/*  60 */     super(paramBasedSequence1, paramList);
/*  61 */     this.openingMarker = paramBasedSequence2;
/*  62 */     this.info = paramBasedSequence3;
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  66 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  70 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setInfo(BasedSequence paramBasedSequence) {
/*  74 */     this.info = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getInfo() {
/*  78 */     return this.info;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitle() {
/*  82 */     return this.title;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitleOpeningMarker() {
/*  86 */     return this.titleOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setTitleOpeningMarker(BasedSequence paramBasedSequence) {
/*  90 */     this.titleOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setTitle(BasedSequence paramBasedSequence) {
/*  94 */     this.title = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitleClosingMarker() {
/*  98 */     return this.titleClosingMarker;
/*     */   }
/*     */   
/*     */   public void setTitleClosingMarker(BasedSequence paramBasedSequence) {
/* 102 */     this.titleClosingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitleChars() {
/* 106 */     return spanningChars(new BasedSequence[] { this.titleOpeningMarker, this.title, this.titleClosingMarker });
/*     */   }
/*     */   
/*     */   public void setTitleChars(BasedSequence paramBasedSequence) {
/* 110 */     if (paramBasedSequence != null && paramBasedSequence != BasedSequence.NULL) {
/* 111 */       int i = paramBasedSequence.length();
/* 112 */       this.titleOpeningMarker = paramBasedSequence.subSequence(0, 1);
/* 113 */       this.title = paramBasedSequence.subSequence(1, i - 1);
/* 114 */       this.titleClosingMarker = paramBasedSequence.subSequence(i - 1, i); return;
/*     */     } 
/* 116 */     this.titleOpeningMarker = BasedSequence.NULL;
/* 117 */     this.title = BasedSequence.NULL;
/* 118 */     this.titleClosingMarker = BasedSequence.NULL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isParagraphEndWrappingDisabled(Paragraph paramParagraph) {
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphStartWrappingDisabled(Paragraph paramParagraph) {
/* 129 */     if (paramParagraph == getFirstChild()) {
/*     */       
/* 131 */       int j = getChars().getBaseSequence().endOfLine(getChars().getStartOffset());
/* 132 */       int i = paramParagraph.getStartOfLine();
/* 133 */       return (j + 1 == i);
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\admonition\AdmonitionBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */