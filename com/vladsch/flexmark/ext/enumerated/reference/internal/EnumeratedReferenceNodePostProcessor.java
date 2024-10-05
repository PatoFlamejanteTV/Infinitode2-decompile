/*    */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*    */ import com.vladsch.flexmark.ast.Heading;
/*    */ import com.vladsch.flexmark.ext.attributes.AttributeNode;
/*    */ import com.vladsch.flexmark.ext.attributes.AttributesNode;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceExtension;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceRepository;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceText;
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferences;
/*    */ import com.vladsch.flexmark.html.renderer.HeaderIdGenerator;
/*    */ import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
/*    */ import com.vladsch.flexmark.parser.PostProcessor;
/*    */ import com.vladsch.flexmark.parser.block.NodePostProcessor;
/*    */ import com.vladsch.flexmark.parser.block.NodePostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeTracker;
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class EnumeratedReferenceNodePostProcessor extends NodePostProcessor {
/*    */   private final EnumeratedReferences enumeratedReferences;
/*    */   
/*    */   public EnumeratedReferenceNodePostProcessor(Document paramDocument) {
/* 25 */     this.enumeratedReferences = (EnumeratedReferences)EnumeratedReferenceExtension.ENUMERATED_REFERENCE_ORDINALS.get((DataHolder)paramDocument);
/* 26 */     this.headerIdGenerator = (HtmlIdGenerator)(new HeaderIdGenerator.Factory()).create();
/* 27 */     this.headerIdGenerator.generateIds(paramDocument);
/*    */   }
/*    */   private final HtmlIdGenerator headerIdGenerator;
/*    */   
/*    */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/* 32 */     if (paramNode instanceof AttributesNode) {
/*    */       AttributesNode attributesNode;
/*    */       
/* 35 */       for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = (attributesNode = (AttributesNode)paramNode).getChildren().iterator(); reversiblePeekingIterator.hasNext();) {
/* 36 */         if (node = reversiblePeekingIterator.next() instanceof AttributeNode && (
/* 37 */           (AttributeNode)node).isId()) {
/* 38 */           String str = ((AttributeNode)node).getValue().toString();
/* 39 */           this.enumeratedReferences.add(str); return;
/*    */         } 
/*    */       } 
/*    */       return;
/*    */     } 
/* 44 */     if (paramNode instanceof Heading)
/*    */     {
/* 46 */       for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramNode.getChildren().iterator(); reversiblePeekingIterator.hasNext();) {
/* 47 */         if (node = reversiblePeekingIterator.next() instanceof EnumeratedReferenceText && ((
/*    */ 
/*    */           
/* 50 */           str = EnumeratedReferenceRepository.getType((basedSequence = ((EnumeratedReferenceText)node).getText()).toString())).isEmpty() || basedSequence.equals(str + ":"))) {
/* 51 */           str = (str.isEmpty() ? (String)basedSequence : str) + ":" + this.headerIdGenerator.getId(paramNode);
/* 52 */           this.enumeratedReferences.add(str);
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     extends NodePostProcessorFactory {
/*    */     public Factory() {
/* 61 */       super(false);
/* 62 */       addNodes(new Class[] { AttributesNode.class, Heading.class });
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public NodePostProcessor apply(Document param1Document) {
/* 68 */       return new EnumeratedReferenceNodePostProcessor(param1Document);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumeratedReferenceNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */