/*     */ package com.vladsch.flexmark.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public abstract class InlineLinkNode
/*     */   extends LinkNode {
/*   7 */   protected BasedSequence textOpeningMarker = BasedSequence.NULL;
/*   8 */   protected BasedSequence text = BasedSequence.NULL;
/*   9 */   protected BasedSequence textClosingMarker = BasedSequence.NULL;
/*  10 */   protected BasedSequence linkOpeningMarker = BasedSequence.NULL;
/*  11 */   protected BasedSequence linkClosingMarker = BasedSequence.NULL;
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  16 */     return new BasedSequence[] { this.textOpeningMarker, this.text, this.textClosingMarker, this.linkOpeningMarker, this.urlOpeningMarker, this.url, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker, this.linkClosingMarker };
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
/*  37 */     return new BasedSequence[] { this.textOpeningMarker, this.text, this.textClosingMarker, this.linkOpeningMarker, this.urlOpeningMarker, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker, this.linkClosingMarker };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  56 */     delimitedSegmentSpanChars(paramStringBuilder, this.textOpeningMarker, this.text, this.textClosingMarker, "text");
/*  57 */     segmentSpanChars(paramStringBuilder, this.linkOpeningMarker, "linkOpen");
/*  58 */     delimitedSegmentSpanChars(paramStringBuilder, this.urlOpeningMarker, this.url, this.urlClosingMarker, "url");
/*  59 */     if (this.pageRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.pageRef, "pageRef"); 
/*  60 */     if (this.anchorMarker.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorMarker, "anchorMarker"); 
/*  61 */     if (this.anchorRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorRef, "anchorRef"); 
/*  62 */     delimitedSegmentSpanChars(paramStringBuilder, this.titleOpeningMarker, this.title, this.titleClosingMarker, "title");
/*  63 */     segmentSpanChars(paramStringBuilder, this.linkClosingMarker, "linkClose");
/*     */   }
/*     */ 
/*     */   
/*     */   public InlineLinkNode() {}
/*     */   
/*     */   public InlineLinkNode(BasedSequence paramBasedSequence) {
/*  70 */     super(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public InlineLinkNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7, BasedSequence paramBasedSequence8, BasedSequence paramBasedSequence9) {
/*  74 */     this.textOpeningMarker = paramBasedSequence1;
/*  75 */     this.text = (BasedSequence)paramBasedSequence2.trim();
/*  76 */     this.textClosingMarker = paramBasedSequence3;
/*  77 */     this.linkOpeningMarker = paramBasedSequence4;
/*  78 */     this.url = paramBasedSequence5;
/*  79 */     this.titleOpeningMarker = paramBasedSequence6;
/*  80 */     this.title = paramBasedSequence7;
/*  81 */     this.titleClosingMarker = paramBasedSequence8;
/*  82 */     this.linkClosingMarker = paramBasedSequence9;
/*     */   }
/*     */   
/*     */   public InlineLinkNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7, BasedSequence paramBasedSequence8, BasedSequence paramBasedSequence9, BasedSequence paramBasedSequence10) {
/*  86 */     super(paramBasedSequence1);
/*  87 */     this.textOpeningMarker = paramBasedSequence2;
/*  88 */     this.text = (BasedSequence)paramBasedSequence3.trim();
/*  89 */     this.textClosingMarker = paramBasedSequence4;
/*  90 */     this.linkOpeningMarker = paramBasedSequence5;
/*  91 */     this.url = paramBasedSequence6;
/*  92 */     this.titleOpeningMarker = paramBasedSequence7;
/*  93 */     this.title = paramBasedSequence8;
/*  94 */     this.titleClosingMarker = paramBasedSequence9;
/*  95 */     this.linkClosingMarker = paramBasedSequence10;
/*     */   }
/*     */   
/*     */   public InlineLinkNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6) {
/*  99 */     this.textOpeningMarker = paramBasedSequence1;
/* 100 */     this.text = (BasedSequence)paramBasedSequence2.trim();
/* 101 */     this.textClosingMarker = paramBasedSequence3;
/* 102 */     this.linkOpeningMarker = paramBasedSequence4;
/* 103 */     this.url = paramBasedSequence5;
/* 104 */     this.linkClosingMarker = paramBasedSequence6;
/*     */   }
/*     */   
/*     */   public InlineLinkNode(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7) {
/* 108 */     super(paramBasedSequence1);
/* 109 */     this.textOpeningMarker = paramBasedSequence2;
/* 110 */     this.text = (BasedSequence)paramBasedSequence3.trim();
/* 111 */     this.textClosingMarker = paramBasedSequence4;
/* 112 */     this.linkOpeningMarker = paramBasedSequence5;
/* 113 */     this.url = paramBasedSequence6;
/* 114 */     this.linkClosingMarker = paramBasedSequence7;
/*     */   }
/*     */   
/*     */   public void setUrl(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 118 */     this.linkOpeningMarker = paramBasedSequence1;
/* 119 */     setUrlChars(paramBasedSequence2);
/* 120 */     this.linkClosingMarker = paramBasedSequence3;
/*     */   }
/*     */   
/*     */   public abstract void setTextChars(BasedSequence paramBasedSequence);
/*     */   
/*     */   public BasedSequence getText() {
/* 126 */     return this.text;
/*     */   }
/*     */   
/*     */   public BasedSequence getTextOpeningMarker() {
/* 130 */     return this.textOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setTextOpeningMarker(BasedSequence paramBasedSequence) {
/* 134 */     this.textOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public void setText(BasedSequence paramBasedSequence) {
/* 138 */     this.text = (BasedSequence)paramBasedSequence.trim();
/*     */   }
/*     */   
/*     */   public BasedSequence getTextClosingMarker() {
/* 142 */     return this.textClosingMarker;
/*     */   }
/*     */   
/*     */   public void setTextClosingMarker(BasedSequence paramBasedSequence) {
/* 146 */     this.textClosingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getLinkOpeningMarker() {
/* 150 */     return this.linkOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setLinkOpeningMarker(BasedSequence paramBasedSequence) {
/* 154 */     this.linkOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getLinkClosingMarker() {
/* 158 */     return this.linkClosingMarker;
/*     */   }
/*     */   
/*     */   public void setLinkClosingMarker(BasedSequence paramBasedSequence) {
/* 162 */     this.linkClosingMarker = paramBasedSequence;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String toStringAttributes() {
/* 168 */     return "text=" + this.text + ", url=" + this.url + ", title=" + this.title;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\InlineLinkNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */