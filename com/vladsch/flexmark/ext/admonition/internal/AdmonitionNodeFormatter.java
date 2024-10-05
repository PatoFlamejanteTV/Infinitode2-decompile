/*    */ package com.vladsch.flexmark.ext.admonition.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.admonition.AdmonitionBlock;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.RepeatedSequence;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class AdmonitionNodeFormatter implements NodeFormatter {
/*    */   public AdmonitionNodeFormatter(DataHolder paramDataHolder) {
/* 18 */     this.options = new AdmonitionOptions(paramDataHolder);
/*    */   }
/*    */   
/*    */   private final AdmonitionOptions options;
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 24 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/* 30 */     return new HashSet<>(Collections.singletonList(new NodeFormattingHandler(AdmonitionBlock.class, this::render)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(AdmonitionBlock paramAdmonitionBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 36 */     paramMarkdownWriter.blankLine();
/* 37 */     ((MarkdownWriter)paramMarkdownWriter.append((CharSequence)paramAdmonitionBlock.getOpeningMarker())).append(' ');
/* 38 */     paramMarkdownWriter.appendNonTranslating((CharSequence)paramAdmonitionBlock.getInfo());
/* 39 */     if (paramAdmonitionBlock.getTitle().isNotNull()) {
/* 40 */       ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.append(' ')).append('"')).appendTranslating((CharSequence)paramAdmonitionBlock.getTitle()).append('"');
/*    */     }
/* 42 */     paramMarkdownWriter.line();
/* 43 */     ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix(RepeatedSequence.repeatOf(" ", this.options.contentIndent).toString());
/* 44 */     paramNodeFormatterContext.renderChildren((Node)paramAdmonitionBlock);
/* 45 */     paramMarkdownWriter.blankLine();
/* 46 */     paramMarkdownWriter.popPrefix();
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 53 */       return new AdmonitionNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\admonition\internal\AdmonitionNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */