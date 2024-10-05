/*    */ package com.vladsch.flexmark.ext.toc;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class TocBlockBase
/*    */   extends Block
/*    */ {
/* 11 */   protected BasedSequence openingMarker = BasedSequence.NULL;
/* 12 */   protected BasedSequence tocKeyword = BasedSequence.NULL;
/* 13 */   protected BasedSequence style = BasedSequence.NULL;
/* 14 */   protected BasedSequence closingMarker = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 18 */     segmentSpan(paramStringBuilder, this.openingMarker, "openingMarker");
/* 19 */     segmentSpan(paramStringBuilder, this.tocKeyword, "tocKeyword");
/* 20 */     segmentSpan(paramStringBuilder, this.style, "style");
/* 21 */     segmentSpan(paramStringBuilder, this.closingMarker, "closingMarker");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 27 */     BasedSequence[] arrayOfBasedSequence = { this.openingMarker, this.tocKeyword, this.style, this.closingMarker };
/* 28 */     if (this.lineSegments.size() == 0) return arrayOfBasedSequence; 
/* 29 */     arrayOfBasedSequence = new BasedSequence[this.lineSegments.size() + 4];
/* 30 */     this.lineSegments.toArray((Object[])arrayOfBasedSequence);
/* 31 */     System.arraycopy(arrayOfBasedSequence, 0, arrayOfBasedSequence, 4, this.lineSegments.size());
/* 32 */     return arrayOfBasedSequence;
/*    */   }
/*    */   
/*    */   public TocBlockBase(BasedSequence paramBasedSequence) {
/* 36 */     this(paramBasedSequence, false);
/*    */   }
/*    */   
/*    */   public TocBlockBase(BasedSequence paramBasedSequence, boolean paramBoolean) {
/* 40 */     this(paramBasedSequence, (BasedSequence)null, paramBoolean);
/*    */   }
/*    */   
/*    */   public TocBlockBase(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2) {
/* 44 */     this(paramBasedSequence1, paramBasedSequence2, false);
/*    */   }
/*    */   
/*    */   public TocBlockBase(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, boolean paramBoolean) {
/* 48 */     super(paramBasedSequence1);
/* 49 */     this.openingMarker = paramBasedSequence1.subSequence(0, 1);
/* 50 */     this.tocKeyword = paramBasedSequence1.subSequence(1, 4);
/* 51 */     if (paramBasedSequence2 != null) {
/* 52 */       this.style = paramBasedSequence2;
/*    */     }
/* 54 */     int i = paramBasedSequence1.indexOf(']', 4);
/* 55 */     if (paramBoolean && (i == -1 || i + 1 >= paramBasedSequence1.length() || paramBasedSequence1.charAt(i + 1) != ':')) {
/* 56 */       throw new IllegalStateException("Invalid TOC block sequence");
/*    */     }
/* 58 */     this.closingMarker = paramBasedSequence1.subSequence(i, i + (paramBoolean ? 2 : 1));
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 62 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public BasedSequence getTocKeyword() {
/* 66 */     return this.tocKeyword;
/*    */   }
/*    */   
/*    */   public BasedSequence getStyle() {
/* 70 */     return this.style;
/*    */   }
/*    */   
/*    */   public BasedSequence getClosingMarker() {
/* 74 */     return this.closingMarker;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\TocBlockBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */