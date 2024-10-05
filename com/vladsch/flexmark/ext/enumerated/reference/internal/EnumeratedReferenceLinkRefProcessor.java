/*    */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceBase;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceBlock;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceExtension;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceLink;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceRepository;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceText;
/*    */ import com.vladsch.flexmark.parser.LinkRefProcessor;
/*    */ import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class EnumeratedReferenceLinkRefProcessor implements LinkRefProcessor {
/*    */   static final boolean WANT_EXCLAMATION_PREFIX = false;
/*    */   
/*    */   public EnumeratedReferenceLinkRefProcessor(Document paramDocument) {
/* 19 */     this.enumeratedReferenceRepository = (EnumeratedReferenceRepository)EnumeratedReferenceExtension.ENUMERATED_REFERENCES.get((DataHolder)paramDocument);
/*    */   }
/*    */   static final int BRACKET_NESTING_LEVEL = 0; private final EnumeratedReferenceRepository enumeratedReferenceRepository;
/*    */   
/*    */   public boolean getWantExclamationPrefix() {
/* 24 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getBracketNestingLevel() {
/* 29 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isMatch(BasedSequence paramBasedSequence) {
/* 34 */     return (paramBasedSequence.length() >= 3 && paramBasedSequence.charAt(0) == '[' && (paramBasedSequence.charAt(1) == '@' || paramBasedSequence.charAt(1) == '#') && paramBasedSequence.endCharAt(1) == ']' && (paramBasedSequence.length() == 3 || !Character.isDigit(paramBasedSequence.charAt(2))));
/*    */   }
/*    */ 
/*    */   
/*    */   public Node createNode(BasedSequence paramBasedSequence) {
/*    */     EnumeratedReferenceLink enumeratedReferenceLink;
/*    */     BasedSequence basedSequence;
/* 41 */     EnumeratedReferenceBlock enumeratedReferenceBlock = ((basedSequence = (BasedSequence)((BasedSequence)paramBasedSequence.midSequence(2, -1)).trim()).length() > 0) ? (EnumeratedReferenceBlock)this.enumeratedReferenceRepository.get(basedSequence.toString()) : null;
/*    */     
/* 43 */     if (paramBasedSequence.charAt(1) == '@') {
/*    */ 
/*    */       
/* 46 */       (enumeratedReferenceLink = new EnumeratedReferenceLink(paramBasedSequence.subSequence(0, 2), basedSequence, (BasedSequence)paramBasedSequence.endSequence(1))).setEnumeratedReferenceBlock(enumeratedReferenceBlock);
/* 47 */       return (Node)enumeratedReferenceLink;
/*    */     } 
/*    */     
/*    */     EnumeratedReferenceText enumeratedReferenceText;
/* 51 */     (enumeratedReferenceText = new EnumeratedReferenceText(enumeratedReferenceLink.subSequence(0, 2), basedSequence, (BasedSequence)enumeratedReferenceLink.endSequence(1))).setEnumeratedReferenceBlock(enumeratedReferenceBlock);
/* 52 */     return (Node)enumeratedReferenceText;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence adjustInlineText(Document paramDocument, Node paramNode) {
/* 59 */     assert paramNode instanceof EnumeratedReferenceBase;
/* 60 */     return ((EnumeratedReferenceBase)paramNode).getText();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean allowDelimiters(BasedSequence paramBasedSequence, Document paramDocument, Node paramNode) {
/* 65 */     return true;
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
/* 77 */       return new EnumeratedReferenceLinkRefProcessor(param1Document);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean getWantExclamationPrefix(DataHolder param1DataHolder) {
/* 82 */       return false;
/*    */     }
/*    */ 
/*    */     
/*    */     public int getBracketNestingLevel(DataHolder param1DataHolder) {
/* 87 */       return 0;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumeratedReferenceLinkRefProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */