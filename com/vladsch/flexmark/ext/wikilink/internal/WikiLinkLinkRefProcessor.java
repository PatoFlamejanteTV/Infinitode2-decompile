/*     */ package com.vladsch.flexmark.ext.wikilink.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiImage;
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiLink;
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
/*     */ import com.vladsch.flexmark.ext.wikilink.WikiNode;
/*     */ import com.vladsch.flexmark.parser.LinkRefProcessor;
/*     */ import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
/*     */ import com.vladsch.flexmark.util.ast.TextContainer;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.IRichSequence;
/*     */ 
/*     */ public class WikiLinkLinkRefProcessor
/*     */   implements LinkRefProcessor {
/*     */   static final int BRACKET_NESTING_LEVEL = 1;
/*     */   private final WikiLinkOptions options;
/*     */   
/*     */   public WikiLinkLinkRefProcessor(Document paramDocument) {
/*  23 */     this.options = new WikiLinkOptions((DataHolder)paramDocument);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getWantExclamationPrefix() {
/*  28 */     return this.options.imageLinks;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBracketNestingLevel() {
/*  33 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMatch(BasedSequence paramBasedSequence) {
/*  38 */     int i = paramBasedSequence.length();
/*  39 */     if (this.options.imageLinks) {
/*  40 */       if (i >= 5 && paramBasedSequence.charAt(0) == '!')
/*  41 */         return (paramBasedSequence.charAt(1) == '[' && paramBasedSequence.charAt(2) == '[' && paramBasedSequence.endCharAt(1) == ']' && paramBasedSequence.endCharAt(2) == ']'); 
/*  42 */       if (i >= 4) {
/*  43 */         return (paramBasedSequence.charAt(0) == '[' && paramBasedSequence.charAt(1) == '[' && paramBasedSequence.endCharAt(1) == ']' && paramBasedSequence.endCharAt(2) == ']');
/*     */       }
/*  45 */     } else if (i >= 4) {
/*  46 */       return (paramBasedSequence.charAt(0) == '[' && paramBasedSequence.charAt(1) == '[' && paramBasedSequence.endCharAt(1) == ']' && paramBasedSequence.endCharAt(2) == ']');
/*     */     } 
/*  48 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence adjustInlineText(Document paramDocument, Node paramNode) {
/*  55 */     assert paramNode instanceof WikiNode;
/*     */     WikiNode wikiNode;
/*  57 */     return (BasedSequence)(wikiNode = (WikiNode)paramNode).getText().ifNull((IRichSequence)wikiNode.getLink());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean allowDelimiters(BasedSequence paramBasedSequence, Document paramDocument, Node paramNode) {
/*  62 */     assert paramNode instanceof WikiNode;
/*  63 */     WikiNode wikiNode = (WikiNode)paramNode;
/*  64 */     return (paramNode instanceof WikiLink && ((Boolean)WikiLinkExtension.ALLOW_INLINES.get((DataHolder)paramDocument)).booleanValue() && ((BasedSequence)wikiNode.getText().ifNull((IRichSequence)wikiNode.getLink())).containsAllOf(paramBasedSequence));
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateNodeElements(Document paramDocument, Node paramNode) {
/*  69 */     assert paramNode instanceof WikiNode;
/*  70 */     WikiNode wikiNode = (WikiNode)paramNode;
/*  71 */     if (paramNode instanceof WikiLink && ((Boolean)WikiLinkExtension.ALLOW_INLINES.get((DataHolder)paramDocument)).booleanValue())
/*     */     {
/*  73 */       if (wikiNode.getText().isNull()) {
/*  74 */         BasedSequence basedSequence = (new TextCollectingVisitor()).collectAndGetSequence(paramNode, TextContainer.F_NODE_TEXT);
/*  75 */         wikiNode.setLink(basedSequence, ((Boolean)WikiLinkExtension.ALLOW_ANCHORS.get((DataHolder)paramDocument)).booleanValue(), ((Boolean)WikiLinkExtension.ALLOW_ANCHOR_ESCAPE.get((DataHolder)paramDocument)).booleanValue());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Node createNode(BasedSequence paramBasedSequence) {
/*  83 */     return (Node)((paramBasedSequence.firstChar() == '!') ? new WikiImage(paramBasedSequence, this.options.linkFirstSyntax, this.options.allowPipeEscape) : new WikiLink(paramBasedSequence, this.options.linkFirstSyntax, this.options.allowAnchors, this.options.allowPipeEscape, this.options.allowAnchorEscape));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements LinkRefProcessorFactory
/*     */   {
/*     */     public LinkRefProcessor apply(Document param1Document) {
/*  91 */       return new WikiLinkLinkRefProcessor(param1Document);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getWantExclamationPrefix(DataHolder param1DataHolder) {
/*  96 */       return ((Boolean)WikiLinkExtension.IMAGE_LINKS.get(param1DataHolder)).booleanValue();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBracketNestingLevel(DataHolder param1DataHolder) {
/* 101 */       return 1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\wikilink\internal\WikiLinkLinkRefProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */