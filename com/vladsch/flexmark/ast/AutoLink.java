/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AutoLink
/*    */   extends DelimitedLinkNode
/*    */ {
/*    */   public AutoLink() {}
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 13 */     return new BasedSequence[] { this.openingMarker, this.pageRef, this.anchorMarker, this.anchorRef, this.closingMarker };
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegmentsForChars() {
/* 19 */     return new BasedSequence[] { this.openingMarker, this.pageRef, this.anchorMarker, this.anchorRef, this.closingMarker };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 30 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "open");
/* 31 */     segmentSpanChars(paramStringBuilder, this.text, "text");
/* 32 */     if (this.pageRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.pageRef, "pageRef"); 
/* 33 */     if (this.anchorMarker.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorMarker, "anchorMarker"); 
/* 34 */     if (this.anchorRef.isNotNull()) segmentSpanChars(paramStringBuilder, this.anchorRef, "anchorRef"); 
/* 35 */     segmentSpanChars(paramStringBuilder, this.closingMarker, "close");
/*    */   }
/*    */   
/*    */   public AutoLink(BasedSequence paramBasedSequence) {
/* 39 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public AutoLink(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 43 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3);
/* 44 */     setUrlChars(paramBasedSequence2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\AutoLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */