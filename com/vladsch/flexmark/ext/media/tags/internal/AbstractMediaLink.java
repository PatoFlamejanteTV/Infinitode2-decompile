/*    */ package com.vladsch.flexmark.ext.media.tags.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.InlineLinkNode;
/*    */ import com.vladsch.flexmark.ast.Link;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public abstract class AbstractMediaLink
/*    */   extends InlineLinkNode
/*    */ {
/*    */   private static final String INVALID_SEQUENCE = "%s Link's CharSequence MUST start with an '%s'!";
/*    */   private final String PREFIX;
/*    */   private final String TYPE;
/*    */   
/*    */   public AbstractMediaLink(String paramString1, String paramString2) {
/* 15 */     this.PREFIX = paramString1;
/* 16 */     this.TYPE = paramString2;
/*    */   }
/*    */   
/*    */   public AbstractMediaLink(String paramString1, String paramString2, Link paramLink) {
/* 20 */     super(paramLink.baseSubSequence(paramLink.getStartOffset() - paramString1.length(), paramLink.getEndOffset()), paramLink
/* 21 */         .baseSubSequence(paramLink.getStartOffset() - paramString1.length(), paramLink.getTextOpeningMarker().getEndOffset()), paramLink
/* 22 */         .getText(), paramLink
/* 23 */         .getTextClosingMarker(), paramLink
/* 24 */         .getLinkOpeningMarker(), paramLink
/* 25 */         .getUrl(), paramLink
/* 26 */         .getTitleOpeningMarker(), paramLink
/* 27 */         .getTitle(), paramLink
/* 28 */         .getTitleClosingMarker(), paramLink
/* 29 */         .getLinkClosingMarker());
/*    */ 
/*    */     
/* 32 */     this.PREFIX = paramString1;
/* 33 */     this.TYPE = paramString2;
/*    */     
/* 35 */     verifyBasedSequence(paramLink.getChars(), paramLink.getStartOffset() - paramString1.length());
/*    */   }
/*    */   
/*    */   public final String getPrefix() {
/* 39 */     return this.PREFIX;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTextChars(BasedSequence paramBasedSequence) {
/* 44 */     verifyBasedSequence(paramBasedSequence, 0);
/*    */     
/* 46 */     int i = paramBasedSequence.length();
/* 47 */     this.textOpeningMarker = paramBasedSequence.subSequence(0, this.PREFIX.length() + 1);
/* 48 */     this.text = (BasedSequence)paramBasedSequence.subSequence(this.PREFIX.length() + 2, i - 1).trim();
/* 49 */     this.textClosingMarker = paramBasedSequence.subSequence(i - 1, i);
/*    */   }
/*    */   
/*    */   protected final void verifyBasedSequence(BasedSequence paramBasedSequence, int paramInt) {
/* 53 */     if (!paramBasedSequence.baseSubSequence(paramInt, paramInt + this.PREFIX.length()).matches(this.PREFIX))
/* 54 */       throw new IllegalArgumentException(String.format("%s Link's CharSequence MUST start with an '%s'!", new Object[] { this.TYPE, this.PREFIX })); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\internal\AbstractMediaLink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */