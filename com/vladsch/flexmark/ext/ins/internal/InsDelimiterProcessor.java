/*    */ package com.vladsch.flexmark.ext.ins.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.ins.Ins;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterRun;
/*    */ import com.vladsch.flexmark.util.ast.DelimitedNode;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class InsDelimiterProcessor
/*    */   implements DelimiterProcessor {
/*    */   public char getOpeningCharacter() {
/* 15 */     return '+';
/*    */   }
/*    */ 
/*    */   
/*    */   public char getClosingCharacter() {
/* 20 */     return '+';
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMinLength() {
/* 25 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeOpener(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 30 */     return paramBoolean1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeCloser(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 35 */     return paramBoolean2;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean skipNonOpenerCloser() {
/* 40 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getDelimiterUse(DelimiterRun paramDelimiterRun1, DelimiterRun paramDelimiterRun2) {
/* 45 */     if (paramDelimiterRun1.length() >= 2 && paramDelimiterRun2.length() >= 2) {
/* 46 */       return 2;
/*    */     }
/* 48 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Node unmatchedDelimiterNode(InlineParser paramInlineParser, DelimiterRun paramDelimiterRun) {
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(Delimiter paramDelimiter1, Delimiter paramDelimiter2, int paramInt) {
/* 60 */     Ins ins = new Ins(paramDelimiter1.getTailChars(paramInt), BasedSequence.NULL, paramDelimiter2.getLeadChars(paramInt));
/* 61 */     paramDelimiter1.moveNodesBetweenDelimitersTo((DelimitedNode)ins, paramDelimiter2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\ins\internal\InsDelimiterProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */