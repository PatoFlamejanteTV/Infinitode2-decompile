/*    */ package com.vladsch.flexmark.ext.youtube.embedded.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Link;
/*    */ import com.vladsch.flexmark.ext.youtube.embedded.YouTubeLink;
/*    */ import com.vladsch.flexmark.parser.PostProcessor;
/*    */ import com.vladsch.flexmark.parser.block.NodePostProcessor;
/*    */ import com.vladsch.flexmark.parser.block.NodePostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.ast.NodeTracker;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class YouTubeLinkNodePostProcessor
/*    */   extends NodePostProcessor {
/*    */   public YouTubeLinkNodePostProcessor(DataHolder paramDataHolder) {}
/*    */   
/*    */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/*    */     Node node;
/*    */     BasedSequence basedSequence;
/*    */     int i;
/* 23 */     if (paramNode instanceof Link && 
/*    */ 
/*    */       
/* 26 */       node = paramNode.getPrevious() instanceof com.vladsch.flexmark.ast.Text && (
/*    */       
/* 28 */       basedSequence = node.getChars()).endsWith("@") && basedSequence.isContinuedBy(paramNode.getChars()) && ((
/*    */       
/* 30 */       i = basedSequence.subSequence(0, basedSequence.length() - 1).countTrailing(CharPredicate.BACKSLASH)) & 0x1) == 0) {
/*    */       
/* 32 */       node.setChars(basedSequence.subSequence(0, basedSequence.length() - 1));
/*    */       
/*    */       YouTubeLink youTubeLink;
/* 35 */       (youTubeLink = new YouTubeLink((Link)paramNode)).takeChildren(paramNode);
/* 36 */       paramNode.unlink();
/* 37 */       node.insertAfter((Node)youTubeLink);
/* 38 */       paramNodeTracker.nodeRemoved(paramNode);
/* 39 */       paramNodeTracker.nodeAddedWithChildren((Node)youTubeLink);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     extends NodePostProcessorFactory
/*    */   {
/*    */     public Factory(DataHolder param1DataHolder) {
/* 48 */       super(false);
/*    */       
/* 50 */       addNodes(new Class[] { Link.class });
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public NodePostProcessor apply(Document param1Document) {
/* 56 */       return new YouTubeLinkNodePostProcessor((DataHolder)param1Document);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\youtube\embedded\internal\YouTubeLinkNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */