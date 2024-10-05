/*    */ package com.vladsch.flexmark.ext.toc;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimTocBlock
/*    */   extends TocBlockBase
/*    */ {
/* 10 */   protected BasedSequence anchorMarker = BasedSequence.NULL;
/* 11 */   protected BasedSequence openingTitleMarker = BasedSequence.NULL;
/* 12 */   protected BasedSequence title = BasedSequence.NULL;
/* 13 */   protected BasedSequence closingTitleMarker = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 17 */     super.getAstExtra(paramStringBuilder);
/* 18 */     segmentSpanChars(paramStringBuilder, this.anchorMarker, "anchorMarker");
/* 19 */     segmentSpanChars(paramStringBuilder, this.openingTitleMarker, "openingTitleMarker");
/* 20 */     segmentSpanChars(paramStringBuilder, this.title, "title");
/* 21 */     segmentSpanChars(paramStringBuilder, this.closingTitleMarker, "closingTitleMarker");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 27 */     BasedSequence[] arrayOfBasedSequence = { this.openingMarker, this.tocKeyword, this.style, this.closingMarker, this.anchorMarker, this.openingTitleMarker, this.title, this.closingTitleMarker };
/* 28 */     if (this.lineSegments.size() == 0) return arrayOfBasedSequence; 
/* 29 */     arrayOfBasedSequence = new BasedSequence[this.lineSegments.size() + 8];
/* 30 */     this.lineSegments.toArray((Object[])arrayOfBasedSequence);
/* 31 */     System.arraycopy(arrayOfBasedSequence, 0, arrayOfBasedSequence, 8, this.lineSegments.size());
/* 32 */     return arrayOfBasedSequence;
/*    */   }
/*    */   
/*    */   public SimTocBlock(BasedSequence paramBasedSequence) {
/* 36 */     this(paramBasedSequence, (BasedSequence)null, (BasedSequence)null);
/*    */   }
/*    */   
/*    */   public SimTocBlock(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 40 */     super(paramBasedSequence1, paramBasedSequence2, true);
/*    */     int i;
/* 42 */     if ((i = paramBasedSequence1.indexOf('#', this.closingMarker.getEndOffset() - paramBasedSequence1.getStartOffset())) == -1) {
/* 43 */       throw new IllegalStateException("Invalid TOC block sequence");
/*    */     }
/* 45 */     this.anchorMarker = paramBasedSequence1.subSequence(i, i + 1);
/*    */     
/* 47 */     if (paramBasedSequence3 != null) {
/* 48 */       if (paramBasedSequence3.length() < 2) {
/* 49 */         throw new IllegalStateException("Invalid TOC block title sequence");
/*    */       }
/*    */       
/* 52 */       this.openingTitleMarker = paramBasedSequence3.subSequence(0, 1);
/* 53 */       this.title = (BasedSequence)paramBasedSequence3.midSequence(1, -1);
/* 54 */       this.closingTitleMarker = (BasedSequence)paramBasedSequence3.endSequence(1);
/*    */     } 
/*    */   }
/*    */   
/*    */   public BasedSequence getAnchorMarker() {
/* 59 */     return this.anchorMarker;
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningTitleMarker() {
/* 63 */     return this.openingTitleMarker;
/*    */   }
/*    */   
/*    */   public BasedSequence getTitle() {
/* 67 */     return this.title;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingTitleMarker() {
/* 71 */     return this.closingTitleMarker;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\SimTocBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */