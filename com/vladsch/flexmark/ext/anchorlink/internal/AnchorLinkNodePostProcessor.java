/*    */ package com.vladsch.flexmark.ext.anchorlink.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.BlockQuote;
/*    */ import com.vladsch.flexmark.ast.Heading;
/*    */ import com.vladsch.flexmark.ext.anchorlink.AnchorLink;
/*    */ import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension;
/*    */ import com.vladsch.flexmark.parser.PostProcessor;
/*    */ import com.vladsch.flexmark.parser.block.NodePostProcessor;
/*    */ import com.vladsch.flexmark.parser.block.NodePostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeTracker;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ public class AnchorLinkNodePostProcessor
/*    */   extends NodePostProcessor {
/*    */   private final AnchorLinkOptions options;
/*    */   
/*    */   public AnchorLinkNodePostProcessor(DataHolder paramDataHolder) {
/* 20 */     this.options = new AnchorLinkOptions(paramDataHolder);
/*    */   }
/*    */   
/*    */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/*    */     Heading heading;
/* 25 */     if (paramNode instanceof Heading && (
/*    */       
/* 27 */       heading = (Heading)paramNode).getText().isNotNull()) {
/* 28 */       AnchorLink anchorLink = new AnchorLink();
/*    */       
/* 30 */       if (!this.options.wrapText) {
/* 31 */         if (heading.getFirstChild() == null) {
/* 32 */           anchorLink.setChars(heading.getText().subSequence(0, 0));
/* 33 */           heading.appendChild((Node)anchorLink);
/*    */         } else {
/* 35 */           anchorLink.setChars(heading.getFirstChild().getChars().subSequence(0, 0));
/* 36 */           heading.getFirstChild().insertBefore((Node)anchorLink);
/*    */         } 
/*    */       } else {
/* 39 */         anchorLink.takeChildren((Node)heading);
/* 40 */         heading.appendChild((Node)anchorLink);
/*    */       } 
/*    */       
/* 43 */       anchorLink.setCharsFromContent();
/* 44 */       paramNodeTracker.nodeAdded((Node)anchorLink);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     extends NodePostProcessorFactory {
/*    */     public Factory(DataHolder param1DataHolder) {
/* 51 */       super(false);
/*    */       
/* 53 */       if (((Boolean)AnchorLinkExtension.ANCHORLINKS_NO_BLOCK_QUOTE.get(param1DataHolder)).booleanValue()) {
/* 54 */         addNodeWithExclusions(Heading.class, new Class[] { BlockQuote.class }); return;
/*    */       } 
/* 56 */       addNodes(new Class[] { Heading.class });
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public NodePostProcessor apply(Document param1Document) {
/* 63 */       return new AnchorLinkNodePostProcessor((DataHolder)param1Document);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\anchorlink\internal\AnchorLinkNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */