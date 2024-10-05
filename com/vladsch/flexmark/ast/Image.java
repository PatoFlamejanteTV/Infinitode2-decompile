/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class Image
/*    */   extends InlineLinkNode {
/*  7 */   private BasedSequence urlContent = BasedSequence.NULL;
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 12 */     return new BasedSequence[] { this.textOpeningMarker, this.text, this.textClosingMarker, this.linkOpeningMarker, this.urlOpeningMarker, this.url, this.pageRef, this.anchorMarker, this.anchorRef, this.urlClosingMarker, this.urlContent, this.titleOpeningMarker, this.titleOpeningMarker, this.title, this.titleClosingMarker, this.linkClosingMarker };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 34 */     delimitedSegmentSpanChars(paramStringBuilder, this.textOpeningMarker, this.text, this.textClosingMarker, "text");
/* 35 */     segmentSpanChars(paramStringBuilder, this.linkOpeningMarker, "linkOpen");
/* 36 */     delimitedSegmentSpanChars(paramStringBuilder, this.urlOpeningMarker, this.url, this.urlClosingMarker, "url");
/* 37 */     if (this.pageRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.pageRef, "pageRef"); 
/* 38 */     if (this.anchorMarker.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorMarker, "anchorMarker"); 
/* 39 */     if (this.anchorRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorRef, "anchorRef"); 
/* 40 */     if (this.urlContent.isNotNull()) segmentSpanChars(paramStringBuilder, this.urlContent, "urlContent"); 
/* 41 */     delimitedSegmentSpanChars(paramStringBuilder, this.titleOpeningMarker, this.title, this.titleClosingMarker, "title");
/* 42 */     segmentSpanChars(paramStringBuilder, this.linkClosingMarker, "linkClose");
/*    */   }
/*    */ 
/*    */   
/*    */   public Image() {}
/*    */   
/*    */   public Image(BasedSequence paramBasedSequence) {
/* 49 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public Image(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7, BasedSequence paramBasedSequence8, BasedSequence paramBasedSequence9) {
/* 53 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6, paramBasedSequence7, paramBasedSequence8, paramBasedSequence9);
/*    */   }
/*    */   
/*    */   public Image(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7, BasedSequence paramBasedSequence8, BasedSequence paramBasedSequence9, BasedSequence paramBasedSequence10) {
/* 57 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6, paramBasedSequence7, paramBasedSequence8, paramBasedSequence9, paramBasedSequence10);
/*    */   }
/*    */   
/*    */   public Image(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6) {
/* 61 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6);
/*    */   }
/*    */   
/*    */   public Image(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7) {
/* 65 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6, paramBasedSequence7);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTextChars(BasedSequence paramBasedSequence) {
/* 70 */     int i = paramBasedSequence.length();
/* 71 */     this.textOpeningMarker = paramBasedSequence.subSequence(0, 2);
/* 72 */     this.text = (BasedSequence)paramBasedSequence.subSequence(2, i - 1).trim();
/* 73 */     this.textClosingMarker = paramBasedSequence.subSequence(i - 1, i);
/*    */   }
/*    */   
/*    */   public void setUrlContent(BasedSequence paramBasedSequence) {
/* 77 */     this.urlContent = paramBasedSequence;
/*    */   }
/*    */   
/*    */   public BasedSequence getUrlContent() {
/* 81 */     return this.urlContent;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\Image.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */