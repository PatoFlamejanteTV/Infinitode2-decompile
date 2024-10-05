/*    */ package com.vladsch.flexmark.ext.toc.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Heading;
/*    */ import com.vladsch.flexmark.ast.util.HeadingCollectingVisitor;
/*    */ import com.vladsch.flexmark.ext.toc.SimTocBlock;
/*    */ import com.vladsch.flexmark.ext.toc.SimTocContent;
/*    */ import com.vladsch.flexmark.ext.toc.SimTocGenerateOnFormat;
/*    */ import com.vladsch.flexmark.ext.toc.TocUtils;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.format.MarkdownTable;
/*    */ import com.vladsch.flexmark.util.misc.Pair;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class SimTocNodeFormatter
/*    */   implements NodeFormatter {
/*    */   public SimTocNodeFormatter(DataHolder paramDataHolder) {
/* 27 */     this.options = new TocOptions(paramDataHolder, true);
/* 28 */     this.formatOptions = new TocFormatOptions(paramDataHolder);
/*    */   }
/*    */   private final TocOptions options; private final TocFormatOptions formatOptions;
/*    */   private MarkdownTable myTable;
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/* 40 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(SimTocBlock.class, this::render), new NodeFormattingHandler(SimTocContent.class, this::render) }));
/*    */   }
/*    */   private void render(SimTocBlock paramSimTocBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*    */     String str1;
/*    */     ArrayList<Heading> arrayList;
/*    */     String str2;
/*    */     HeadingCollectingVisitor headingCollectingVisitor;
/* 47 */     switch (this.formatOptions.updateOnFormat) {
/*    */       case REMOVE:
/* 49 */         str2 = TocUtils.getSimTocPrefix(this.options, this.options);
/* 50 */         paramMarkdownWriter.append(str2);
/* 51 */         if (this.options.isBlankLineSpacer) { paramMarkdownWriter.blankLine();
/*    */           return; }
/*    */         
/*    */         return;
/*    */ 
/*    */       
/*    */       case UPDATE:
/* 58 */         if ((arrayList = (headingCollectingVisitor = new HeadingCollectingVisitor()).collectAndGetHeadings((Node)paramNodeFormatterContext.getDocument())) != null) {
/*    */           SimTocOptionsParser simTocOptionsParser;
/* 60 */           TocOptions tocOptions = (TocOptions)(simTocOptionsParser = new SimTocOptionsParser()).parseOption(paramSimTocBlock.getStyle(), this.options, null).getFirst();
/*    */           
/* 62 */           if (paramSimTocBlock.getTitle().isNotNull()) {
/* 63 */             tocOptions = tocOptions.withTitle(paramSimTocBlock.getTitle().unescape());
/*    */           }
/*    */           
/* 66 */           str1 = TocUtils.getSimTocPrefix(tocOptions, this.options);
/* 67 */           paramMarkdownWriter.append(str1);
/* 68 */           if (tocOptions.isBlankLineSpacer) paramMarkdownWriter.blankLine();
/*    */           
/* 70 */           renderTocHeaders(paramMarkdownWriter, arrayList, tocOptions);
/*    */           return;
/*    */         } 
/*    */         return;
/*    */       
/*    */       case AS_IS:
/* 76 */         ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.openPreFormatted(false)).append((CharSequence)str1.getChars())).closePreFormatted();
/*    */         return;
/*    */     } 
/*    */     
/* 80 */     throw new IllegalStateException(this.formatOptions.updateOnFormat.toString() + " is not implemented");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void renderTocHeaders(MarkdownWriter paramMarkdownWriter, List<Heading> paramList, TocOptions paramTocOptions) {
/* 86 */     Pair pair = TocUtils.markdownHeaderTexts(paramList = TocUtils.filteredHeadings(paramList, paramTocOptions), paramTocOptions);
/* 87 */     TocUtils.renderTocContent(paramMarkdownWriter, paramTocOptions, this.options, (List)pair.getFirst(), (List)pair.getSecond());
/*    */   }
/*    */ 
/*    */   
/*    */   private void render(SimTocContent paramSimTocContent, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {}
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 98 */       return new SimTocNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\SimTocNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */