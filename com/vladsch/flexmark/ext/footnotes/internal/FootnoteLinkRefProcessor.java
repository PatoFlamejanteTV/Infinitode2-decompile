/*    */ package com.vladsch.flexmark.ext.footnotes.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.footnotes.Footnote;
/*    */ import com.vladsch.flexmark.ext.footnotes.FootnoteBlock;
/*    */ import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
/*    */ import com.vladsch.flexmark.parser.LinkRefProcessor;
/*    */ import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class FootnoteLinkRefProcessor
/*    */   implements LinkRefProcessor
/*    */ {
/*    */   static final boolean WANT_EXCLAMATION_PREFIX = false;
/*    */   static final int BRACKET_NESTING_LEVEL = 0;
/*    */   private final FootnoteRepository footnoteRepository;
/*    */   
/*    */   public FootnoteLinkRefProcessor(Document paramDocument) {
/* 21 */     this.footnoteRepository = (FootnoteRepository)FootnoteExtension.FOOTNOTES.get((DataHolder)paramDocument);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getWantExclamationPrefix() {
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getBracketNestingLevel() {
/* 31 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isMatch(BasedSequence paramBasedSequence) {
/* 36 */     return (paramBasedSequence.length() >= 3 && paramBasedSequence.charAt(0) == '[' && paramBasedSequence.charAt(1) == '^' && paramBasedSequence.endCharAt(1) == ']');
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Node createNode(BasedSequence paramBasedSequence) {
/*    */     BasedSequence basedSequence;
/* 43 */     FootnoteBlock footnoteBlock = ((basedSequence = (BasedSequence)((BasedSequence)paramBasedSequence.midSequence(2, -1)).trim()).length() > 0) ? (FootnoteBlock)this.footnoteRepository.get(basedSequence.toString()) : null;
/*    */     
/*    */     Footnote footnote;
/* 46 */     (footnote = new Footnote(paramBasedSequence.subSequence(0, 2), basedSequence, (BasedSequence)paramBasedSequence.endSequence(1))).setFootnoteBlock(footnoteBlock);
/*    */     
/* 48 */     if (footnoteBlock != null) {
/* 49 */       this.footnoteRepository.addFootnoteReference(footnoteBlock, footnote);
/*    */     }
/* 51 */     return (Node)footnote;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence adjustInlineText(Document paramDocument, Node paramNode) {
/* 57 */     assert paramNode instanceof Footnote;
/* 58 */     return ((Footnote)paramNode).getText();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean allowDelimiters(BasedSequence paramBasedSequence, Document paramDocument, Node paramNode) {
/* 63 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateNodeElements(Document paramDocument, Node paramNode) {}
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements LinkRefProcessorFactory
/*    */   {
/*    */     public LinkRefProcessor apply(Document param1Document) {
/* 75 */       return new FootnoteLinkRefProcessor(param1Document);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean getWantExclamationPrefix(DataHolder param1DataHolder) {
/* 80 */       return false;
/*    */     }
/*    */ 
/*    */     
/*    */     public int getBracketNestingLevel(DataHolder param1DataHolder) {
/* 85 */       return 0;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\internal\FootnoteLinkRefProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */