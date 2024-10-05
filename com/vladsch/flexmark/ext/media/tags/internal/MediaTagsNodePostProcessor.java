/*    */ package com.vladsch.flexmark.ext.media.tags.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Link;
/*    */ import com.vladsch.flexmark.ext.media.tags.AudioLink;
/*    */ import com.vladsch.flexmark.ext.media.tags.EmbedLink;
/*    */ import com.vladsch.flexmark.ext.media.tags.PictureLink;
/*    */ import com.vladsch.flexmark.ext.media.tags.VideoLink;
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
/*    */ public class MediaTagsNodePostProcessor
/*    */   extends NodePostProcessor {
/*    */   public MediaTagsNodePostProcessor(DataHolder paramDataHolder) {}
/*    */   
/*    */   public void process(NodeTracker paramNodeTracker, Node paramNode) {
/*    */     Node node;
/*    */     BasedSequence basedSequence;
/* 25 */     if (paramNode instanceof Link && 
/*    */ 
/*    */       
/* 28 */       node = paramNode.getPrevious() instanceof com.vladsch.flexmark.ast.Text && (
/*    */       
/* 30 */       basedSequence = node.getChars()).isContinuedBy(paramNode.getChars())) {
/*    */       VideoLink videoLink;
/* 32 */       if (basedSequence.endsWith("!A") && !isEscaped(basedSequence, "!A")) {
/* 33 */         AudioLink audioLink = new AudioLink((Link)paramNode);
/* 34 */       } else if (basedSequence.endsWith("!E") && !isEscaped(basedSequence, "!E")) {
/* 35 */         EmbedLink embedLink = new EmbedLink((Link)paramNode);
/* 36 */       } else if (basedSequence.endsWith("!P") && !isEscaped(basedSequence, "!P")) {
/* 37 */         PictureLink pictureLink = new PictureLink((Link)paramNode);
/* 38 */       } else if (basedSequence.endsWith("!V") && !isEscaped(basedSequence, "!V")) {
/* 39 */         videoLink = new VideoLink((Link)paramNode);
/*    */       } else {
/*    */         return;
/*    */       } 
/*    */       
/* 44 */       videoLink.takeChildren(paramNode);
/* 45 */       paramNode.unlink();
/* 46 */       paramNodeTracker.nodeRemoved(paramNode);
/* 47 */       node.insertAfter((Node)videoLink);
/* 48 */       paramNodeTracker.nodeAddedWithChildren((Node)videoLink);
/* 49 */       node.setChars(basedSequence.subSequence(0, basedSequence.length() - videoLink.getPrefix().length()));
/* 50 */       if (node.getChars().length() == 0) {
/* 51 */         node.unlink();
/* 52 */         paramNodeTracker.nodeRemoved(node);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean isEscaped(BasedSequence paramBasedSequence, String paramString) {
/*    */     int i;
/* 61 */     return (((i = paramBasedSequence.subSequence(0, paramBasedSequence.length() - paramString.length()).countTrailing(CharPredicate.BACKSLASH)) & 0x1) != 0);
/*    */   }
/*    */   
/*    */   public static class Factory extends NodePostProcessorFactory {
/*    */     public Factory(DataHolder param1DataHolder) {
/* 66 */       super(false);
/*    */       
/* 68 */       addNodes(new Class[] { Link.class });
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public NodePostProcessor apply(Document param1Document) {
/* 74 */       return new MediaTagsNodePostProcessor((DataHolder)param1Document);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\media\tags\internal\MediaTagsNodePostProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */