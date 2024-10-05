/*    */ package com.vladsch.flexmark.ext.toc;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TocBlock
/*    */   extends TocBlockBase
/*    */ {
/* 10 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 11 */   protected BasedSequence tocKeyword = BasedSequence.NULL;
/* 12 */   protected BasedSequence style = BasedSequence.NULL;
/* 13 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 17 */     segmentSpan(paramStringBuilder, this.openingMarker, "openingMarker");
/* 18 */     segmentSpan(paramStringBuilder, this.tocKeyword, "tocKeyword");
/* 19 */     segmentSpan(paramStringBuilder, this.style, "style");
/* 20 */     segmentSpan(paramStringBuilder, this.closingMarker, "closingMarker");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 26 */     BasedSequence[] arrayOfBasedSequence = { this.openingMarker, this.tocKeyword, this.style, this.closingMarker };
/* 27 */     if (this.lineSegments.size() == 0) return arrayOfBasedSequence; 
/* 28 */     arrayOfBasedSequence = new BasedSequence[this.lineSegments.size() + 4];
/* 29 */     this.lineSegments.toArray((Object[])arrayOfBasedSequence);
/* 30 */     System.arraycopy(arrayOfBasedSequence, 0, arrayOfBasedSequence, 4, this.lineSegments.size());
/* 31 */     return arrayOfBasedSequence;
/*    */   }
/*    */   
/*    */   public TocBlock(BasedSequence paramBasedSequence) {
/* 35 */     this(paramBasedSequence, false);
/*    */   }
/*    */   
/*    */   public TocBlock(BasedSequence paramBasedSequence, boolean paramBoolean) {
/* 39 */     this(paramBasedSequence, (BasedSequence)null, paramBoolean);
/*    */   }
/*    */   
/*    */   public TocBlock(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2) {
/* 43 */     this(paramBasedSequence1, paramBasedSequence2, false);
/*    */   }
/*    */   
/*    */   public TocBlock(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, boolean paramBoolean) {
/* 47 */     super(paramBasedSequence1);
/* 48 */     this.openingMarker = paramBasedSequence1.subSequence(0, 1);
/* 49 */     this.tocKeyword = paramBasedSequence1.subSequence(1, 4);
/* 50 */     if (paramBasedSequence2 != null) {
/* 51 */       this.style = paramBasedSequence2;
/*    */     }
/* 53 */     int i = paramBasedSequence1.indexOf(']', 4);
/* 54 */     if (paramBoolean && (i == -1 || i + 1 >= paramBasedSequence1.length() || paramBasedSequence1.charAt(i + 1) != ':')) {
/* 55 */       throw new IllegalStateException("Invalid TOC block sequence");
/*    */     }
/* 57 */     this.closingMarker = paramBasedSequence1.subSequence(i, i + (paramBoolean ? 2 : 1));
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 61 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public BasedSequence getTocKeyword() {
/* 65 */     return this.tocKeyword;
/*    */   }
/*    */   
/*    */   public BasedSequence getStyle() {
/* 69 */     return this.style;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 73 */     return this.closingMarker;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\TocBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */