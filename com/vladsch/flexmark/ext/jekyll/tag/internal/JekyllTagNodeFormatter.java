/*     */ package com.vladsch.flexmark.ext.jekyll.tag.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTag;
/*     */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagBlock;
/*     */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
/*     */ import com.vladsch.flexmark.formatter.FormattingPhase;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*     */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*     */ import com.vladsch.flexmark.formatter.PhasedNodeFormatter;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class JekyllTagNodeFormatter
/*     */   implements PhasedNodeFormatter {
/*     */   private boolean embedIncludedContent;
/*     */   
/*     */   public Set<FormattingPhase> getFormattingPhases() {
/*  27 */     return Collections.singleton(FormattingPhase.COLLECT);
/*     */   }
/*     */   public JekyllTagNodeFormatter(DataHolder paramDataHolder) {}
/*     */   
/*     */   public void renderDocument(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Document paramDocument, FormattingPhase paramFormattingPhase) {
/*  32 */     this.embedIncludedContent = ((Boolean)JekyllTagExtension.EMBED_INCLUDED_CONTENT.get((DataHolder)paramDocument)).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Class<?>> getNodeClasses() {
/*  38 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*  44 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(JekyllTagBlock.class, this::render), new NodeFormattingHandler(JekyllTag.class, this::render) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(JekyllTagBlock paramJekyllTagBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  70 */     paramNodeFormatterContext.renderChildren((Node)paramJekyllTagBlock);
/*     */   }
/*     */   
/*     */   private void render(JekyllTag paramJekyllTag, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  74 */     if (this.embedIncludedContent) {
/*     */       
/*  76 */       paramNodeFormatterContext.renderChildren((Node)paramJekyllTag); return;
/*     */     } 
/*  78 */     if (!(paramJekyllTag.getParent() instanceof JekyllTagBlock)) {
/*     */       Node node;
/*  80 */       if ((node = paramJekyllTag.getPrevious()) != null) {
/*  81 */         BasedSequence basedSequence = node.getChars();
/*  82 */         ((MarkdownWriter)paramMarkdownWriter.pushOptions()).preserveSpaces()
/*  83 */           .append((CharSequence)basedSequence.baseSubSequence(basedSequence.getEndOffset(), paramJekyllTag.getStartOffset()))
/*  84 */           .popOptions();
/*     */       } else {
/*     */         int i;
/*  87 */         if ((i = paramJekyllTag.getBaseSequence().startOfLine(paramJekyllTag.getStartOffset())) < paramJekyllTag.getStartOffset()) {
/*  88 */           BasedSequence basedSequence = paramJekyllTag.baseSubSequence(i, paramJekyllTag.getStartOffset());
/*  89 */           ((MarkdownWriter)paramMarkdownWriter.pushOptions()).preserveSpaces()
/*  90 */             .append((CharSequence)basedSequence)
/*  91 */             .popOptions();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     paramMarkdownWriter.append((CharSequence)paramJekyllTag.getChars());
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements NodeFormatterFactory
/*     */   {
/*     */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 104 */       return (NodeFormatter)new JekyllTagNodeFormatter(param1DataHolder);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\internal\JekyllTagNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */