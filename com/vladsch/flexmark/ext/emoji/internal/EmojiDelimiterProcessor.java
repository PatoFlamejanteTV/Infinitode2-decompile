/*    */ package com.vladsch.flexmark.ext.emoji.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.emoji.Emoji;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterRun;
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class EmojiDelimiterProcessor
/*    */   implements DelimiterProcessor {
/*    */   public char getOpeningCharacter() {
/* 16 */     return ':';
/*    */   }
/*    */ 
/*    */   
/*    */   public char getClosingCharacter() {
/* 21 */     return ':';
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMinLength() {
/* 26 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeOpener(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 31 */     return (paramBoolean1 && !"0123456789".contains(paramString1));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeCloser(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 36 */     return (paramBoolean2 && !"0123456789".contains(paramString2));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean skipNonOpenerCloser() {
/* 41 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getDelimiterUse(DelimiterRun paramDelimiterRun1, DelimiterRun paramDelimiterRun2) {
/* 46 */     if (paramDelimiterRun1.length() > 0 && paramDelimiterRun2.length() > 0) {
/* 47 */       return 1;
/*    */     }
/* 49 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Node unmatchedDelimiterNode(InlineParser paramInlineParser, DelimiterRun paramDelimiterRun) {
/* 55 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(Delimiter paramDelimiter1, Delimiter paramDelimiter2, int paramInt) {
/*    */     Emoji emoji;
/* 62 */     if (paramDelimiter1.getInput().subSequence(paramDelimiter1.getEndIndex(), paramDelimiter2.getStartIndex()).indexOfAny(CharPredicate.WHITESPACE) == -1) {
/* 63 */       emoji = new Emoji(paramDelimiter1.getTailChars(paramInt), BasedSequence.NULL, paramDelimiter2.getLeadChars(paramInt));
/* 64 */       paramDelimiter1.moveNodesBetweenDelimitersTo((DelimitedNode)emoji, paramDelimiter2); return;
/*    */     } 
/* 66 */     paramDelimiter1.convertDelimitersToText(emoji, paramDelimiter2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\internal\EmojiDelimiterProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */