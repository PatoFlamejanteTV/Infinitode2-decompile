/*    */ package com.vladsch.flexmark.parser.core.delimiter;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Emphasis;
/*    */ import com.vladsch.flexmark.ast.StrongEmphasis;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterRun;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.misc.Utils;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public abstract class EmphasisDelimiterProcessor
/*    */   implements DelimiterProcessor {
/*    */   private final char delimiterChar;
/*    */   private final int multipleUse;
/*    */   
/*    */   protected EmphasisDelimiterProcessor(char paramChar, boolean paramBoolean) {
/* 18 */     this.delimiterChar = paramChar;
/* 19 */     this.multipleUse = paramBoolean ? 1 : 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public char getOpeningCharacter() {
/* 24 */     return this.delimiterChar;
/*    */   }
/*    */ 
/*    */   
/*    */   public char getClosingCharacter() {
/* 29 */     return this.delimiterChar;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMinLength() {
/* 34 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeOpener(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 39 */     return paramBoolean1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeCloser(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 44 */     return paramBoolean2;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean skipNonOpenerCloser() {
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public Node unmatchedDelimiterNode(InlineParser paramInlineParser, DelimiterRun paramDelimiterRun) {
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDelimiterUse(DelimiterRun paramDelimiterRun1, DelimiterRun paramDelimiterRun2) {
/* 60 */     if ((paramDelimiterRun1.canClose() || paramDelimiterRun2.canOpen()) && (paramDelimiterRun1.length() + paramDelimiterRun2.length()) % 3 == 0) {
/* 61 */       return 0;
/*    */     }
/*    */ 
/*    */     
/* 65 */     if (paramDelimiterRun1.length() < 3 || paramDelimiterRun2.length() < 3) {
/* 66 */       return Utils.min(paramDelimiterRun2.length(), new int[] { paramDelimiterRun1.length() });
/*    */     }
/*    */     
/* 69 */     return (paramDelimiterRun2.length() % 2 == 0) ? 2 : this.multipleUse;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(Delimiter paramDelimiter1, Delimiter paramDelimiter2, int paramInt) {
/* 77 */     paramInt = (paramInt == 1) ? new Emphasis(paramDelimiter1.getTailChars(paramInt), BasedSequence.NULL, paramDelimiter2.getLeadChars(paramInt)) : new StrongEmphasis(paramDelimiter1.getTailChars(paramInt), BasedSequence.NULL, paramDelimiter2.getLeadChars(paramInt));
/*    */     
/* 79 */     paramDelimiter1.moveNodesBetweenDelimitersTo(paramInt, paramDelimiter2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\delimiter\EmphasisDelimiterProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */