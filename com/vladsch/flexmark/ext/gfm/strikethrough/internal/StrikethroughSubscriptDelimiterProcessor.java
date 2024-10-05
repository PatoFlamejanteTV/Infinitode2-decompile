/*    */ package com.vladsch.flexmark.ext.gfm.strikethrough.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.Strikethrough;
/*    */ import com.vladsch.flexmark.ext.gfm.strikethrough.Subscript;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterRun;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ public class StrikethroughSubscriptDelimiterProcessor
/*    */   implements DelimiterProcessor
/*    */ {
/*    */   public char getOpeningCharacter() {
/* 17 */     return '~';
/*    */   }
/*    */ 
/*    */   
/*    */   public char getClosingCharacter() {
/* 22 */     return '~';
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMinLength() {
/* 27 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeOpener(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 32 */     return paramBoolean1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeCloser(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 37 */     return paramBoolean2;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean skipNonOpenerCloser() {
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDelimiterUse(DelimiterRun paramDelimiterRun1, DelimiterRun paramDelimiterRun2) {
/* 48 */     if ((paramDelimiterRun1.canClose() || paramDelimiterRun2.canOpen()) && (paramDelimiterRun1.length() + paramDelimiterRun2.length()) % 3 == 0) {
/* 49 */       return 0;
/*    */     }
/*    */     
/* 52 */     if (paramDelimiterRun1.length() < 3 || paramDelimiterRun2.length() < 3) {
/* 53 */       if (paramDelimiterRun2.length() <= paramDelimiterRun1.length())
/* 54 */         return paramDelimiterRun2.length();  return paramDelimiterRun1.length();
/*    */     } 
/* 56 */     return (paramDelimiterRun2.length() % 2 == 0) ? 2 : 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Node unmatchedDelimiterNode(InlineParser paramInlineParser, DelimiterRun paramDelimiterRun) {
/* 62 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(Delimiter paramDelimiter1, Delimiter paramDelimiter2, int paramInt) {
/* 70 */     paramInt = (paramInt == 1) ? new Subscript(paramDelimiter1.getTailChars(paramInt), BasedSequence.NULL, paramDelimiter2.getLeadChars(paramInt)) : new Strikethrough(paramDelimiter1.getTailChars(paramInt), BasedSequence.NULL, paramDelimiter2.getLeadChars(paramInt));
/*    */     
/* 72 */     paramDelimiter1.moveNodesBetweenDelimitersTo(paramInt, paramDelimiter2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\strikethrough\internal\StrikethroughSubscriptDelimiterProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */