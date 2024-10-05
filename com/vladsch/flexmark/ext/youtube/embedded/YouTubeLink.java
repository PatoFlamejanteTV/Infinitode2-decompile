/*    */ package com.vladsch.flexmark.ext.youtube.embedded;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.InlineLinkNode;
/*    */ import com.vladsch.flexmark.ast.Link;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class YouTubeLink
/*    */   extends InlineLinkNode {
/*    */   public YouTubeLink() {}
/*    */   
/*    */   public YouTubeLink(Link paramLink) {
/* 12 */     super(paramLink.baseSubSequence(paramLink.getStartOffset() - 1, paramLink.getEndOffset()), paramLink
/* 13 */         .baseSubSequence(paramLink.getStartOffset() - 1, paramLink.getTextOpeningMarker().getEndOffset()), paramLink
/* 14 */         .getText(), paramLink
/* 15 */         .getTextClosingMarker(), paramLink
/* 16 */         .getLinkOpeningMarker(), paramLink
/* 17 */         .getUrl(), paramLink
/* 18 */         .getTitleOpeningMarker(), paramLink
/* 19 */         .getTitle(), paramLink
/* 20 */         .getTitleClosingMarker(), paramLink
/* 21 */         .getLinkClosingMarker());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTextChars(BasedSequence paramBasedSequence) {
/* 27 */     int i = paramBasedSequence.length();
/* 28 */     this.textOpeningMarker = paramBasedSequence.subSequence(0, 1);
/* 29 */     this.text = (BasedSequence)paramBasedSequence.subSequence(1, i - 1).trim();
/* 30 */     this.textClosingMarker = paramBasedSequence.subSequence(i - 1, i);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\youtube\embedded\YouTubeLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */