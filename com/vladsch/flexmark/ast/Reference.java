/*     */ package com.vladsch.flexmark.ast;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.util.ReferenceRepository;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.ReferenceNode;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ 
/*     */ public class Reference
/*     */   extends LinkNodeBase
/*     */   implements ReferenceNode<ReferenceRepository, Reference, RefNode> {
/*  13 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/*  14 */   protected BasedSequence reference = BasedSequence.NULL;
/*  15 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] getSegments() {
/*  20 */     return new BasedSequence[] { this.openingMarker, this.reference, this.closingMarker, this.urlOpeningMarker, this.url, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker };
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
/*     */   public BasedSequence[] getSegmentsForChars() {
/*  39 */     return new BasedSequence[] { this.openingMarker, this.reference, this.closingMarker, 
/*     */ 
/*     */ 
/*     */         
/*  43 */         (BasedSequence)PrefixedSubSequence.prefixOf(" ", this.closingMarker.getEmptySuffix()), this.urlOpeningMarker, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker };
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
/*     */   public int compareTo(Reference paramReference) {
/*  57 */     return SequenceUtils.compare((CharSequence)getReference(), (CharSequence)paramReference.getReference(), true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RefNode getReferencingNode(Node paramNode) {
/*  63 */     return (paramNode instanceof RefNode) ? (RefNode)paramNode : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getAstExtra(StringBuilder paramStringBuilder) {
/*  68 */     delimitedSegmentSpanChars(paramStringBuilder, this.openingMarker, this.reference, this.closingMarker, "ref");
/*  69 */     delimitedSegmentSpanChars(paramStringBuilder, this.urlOpeningMarker, this.url, this.urlClosingMarker, "url");
/*  70 */     delimitedSegmentSpanChars(paramStringBuilder, this.titleOpeningMarker, this.title, this.titleClosingMarker, "title");
/*     */   }
/*     */   
/*     */   public Reference(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/*  74 */     super(BasedSequence.NULL);
/*     */     
/*  76 */     this.openingMarker = paramBasedSequence1.subSequence(0, 1);
/*  77 */     this.reference = (BasedSequence)paramBasedSequence1.subSequence(1, paramBasedSequence1.length() - 2).trim();
/*  78 */     this.closingMarker = paramBasedSequence1.subSequence(paramBasedSequence1.length() - 2, paramBasedSequence1.length());
/*     */     
/*  80 */     setUrlChars(paramBasedSequence2);
/*     */     
/*  82 */     if (paramBasedSequence3 != null) {
/*  83 */       this.titleOpeningMarker = paramBasedSequence3.subSequence(0, 1);
/*  84 */       this.title = paramBasedSequence3.subSequence(1, paramBasedSequence3.length() - 1);
/*  85 */       this.titleClosingMarker = paramBasedSequence3.subSequence(paramBasedSequence3.length() - 1, paramBasedSequence3.length());
/*     */     } 
/*  87 */     setCharsFromContent();
/*     */   }
/*     */   
/*     */   public BasedSequence getOpeningMarker() {
/*  91 */     return this.openingMarker;
/*     */   }
/*     */   
/*     */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/*  95 */     this.openingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getClosingMarker() {
/*  99 */     return this.closingMarker;
/*     */   }
/*     */   
/*     */   public void setClosingMarker(BasedSequence paramBasedSequence) {
/* 103 */     this.closingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getUrlOpeningMarker() {
/* 107 */     return this.urlOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setUrlOpeningMarker(BasedSequence paramBasedSequence) {
/* 111 */     this.urlOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getUrlClosingMarker() {
/* 115 */     return this.urlClosingMarker;
/*     */   }
/*     */   
/*     */   public void setUrlClosingMarker(BasedSequence paramBasedSequence) {
/* 119 */     this.urlClosingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitleOpeningMarker() {
/* 123 */     return this.titleOpeningMarker;
/*     */   }
/*     */   
/*     */   public void setTitleOpeningMarker(BasedSequence paramBasedSequence) {
/* 127 */     this.titleOpeningMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitleClosingMarker() {
/* 131 */     return this.titleClosingMarker;
/*     */   }
/*     */   
/*     */   public void setTitleClosingMarker(BasedSequence paramBasedSequence) {
/* 135 */     this.titleClosingMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getReference() {
/* 139 */     return this.reference;
/*     */   }
/*     */   
/*     */   public void setReference(BasedSequence paramBasedSequence) {
/* 143 */     this.reference = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getUrl() {
/* 147 */     return this.url;
/*     */   }
/*     */   
/*     */   public void setUrl(BasedSequence paramBasedSequence) {
/* 151 */     this.url = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getPageRef() {
/* 155 */     return this.pageRef;
/*     */   }
/*     */   
/*     */   public void setPageRef(BasedSequence paramBasedSequence) {
/* 159 */     this.pageRef = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getAnchorMarker() {
/* 163 */     return this.anchorMarker;
/*     */   }
/*     */   
/*     */   public void setAnchorMarker(BasedSequence paramBasedSequence) {
/* 167 */     this.anchorMarker = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getAnchorRef() {
/* 171 */     return this.anchorRef;
/*     */   }
/*     */   
/*     */   public void setAnchorRef(BasedSequence paramBasedSequence) {
/* 175 */     this.anchorRef = paramBasedSequence;
/*     */   }
/*     */   
/*     */   public BasedSequence getTitle() {
/* 179 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(BasedSequence paramBasedSequence) {
/* 183 */     this.title = paramBasedSequence;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String toStringAttributes() {
/* 189 */     return "reference=" + this.reference + ", url=" + this.url;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\Reference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */