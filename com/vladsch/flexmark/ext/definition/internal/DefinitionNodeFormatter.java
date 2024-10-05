/*    */ package com.vladsch.flexmark.ext.definition.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.Paragraph;
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionItem;
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionList;
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionTerm;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.parser.ListOptions;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.DefinitionMarker;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.RepeatedSequence;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class DefinitionNodeFormatter implements NodeFormatter {
/*    */   private final DefinitionFormatOptions options;
/*    */   
/*    */   public DefinitionNodeFormatter(DataHolder paramDataHolder) {
/* 27 */     this.options = new DefinitionFormatOptions(paramDataHolder);
/* 28 */     this.listOptions = ListOptions.get(paramDataHolder);
/*    */   }
/*    */   
/*    */   private final ListOptions listOptions;
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/* 40 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(DefinitionList.class, this::render), new NodeFormattingHandler(DefinitionTerm.class, this::render), new NodeFormattingHandler(DefinitionItem.class, this::render) }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(DefinitionList paramDefinitionList, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 48 */     paramNodeFormatterContext.renderChildren((Node)paramDefinitionList);
/*    */   }
/*    */   
/*    */   private void render(DefinitionTerm paramDefinitionTerm, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 52 */     paramNodeFormatterContext.renderChildren((Node)paramDefinitionTerm);
/*    */   }
/*    */ 
/*    */   
/*    */   private void render(DefinitionItem paramDefinitionItem, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 57 */     BasedSequence basedSequence1, basedSequence2 = (basedSequence1 = paramDefinitionItem.getChars().prefixOf(paramDefinitionItem.getFirstChild().getChars())).subSequence(0, 1);
/* 58 */     basedSequence1 = (BasedSequence)basedSequence1.subSequence(1);
/*    */     
/* 60 */     if (this.options.markerSpaces > 0 && basedSequence1.length() != this.options.markerSpaces) {
/*    */       CharSequence charSequence1;
/* 62 */       basedSequence1 = BasedSequence.of(charSequence1 = RepeatedSequence.repeatOf(' ', this.options.markerSpaces));
/*    */     } 
/*    */     
/* 65 */     switch (this.options.markerType) {
/*    */ 
/*    */       
/*    */       case COLON:
/* 69 */         basedSequence2 = BasedSequence.of(":").subSequence(0, ":".length());
/*    */         break;
/*    */       case TILDE:
/* 72 */         basedSequence2 = BasedSequence.of("~").subSequence(0, "~".length());
/*    */         break;
/*    */     } 
/*    */     
/* 76 */     ((MarkdownWriter)((MarkdownWriter)paramMarkdownWriter.line()).append((CharSequence)basedSequence2)).append((CharSequence)basedSequence1);
/*    */     int i;
/* 78 */     CharSequence charSequence = RepeatedSequence.ofSpaces(i = (paramNodeFormatterContext.getFormatterOptions()).itemContentIndent ? (basedSequence2.length() + basedSequence1.length()) : this.listOptions.getItemIndent());
/* 79 */     ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix(charSequence);
/* 80 */     paramNodeFormatterContext.renderChildren((Node)paramDefinitionItem);
/* 81 */     paramMarkdownWriter.popPrefix();
/*    */     
/* 83 */     if (!((Boolean)Parser.BLANK_LINES_IN_AST.get(paramNodeFormatterContext.getOptions())).booleanValue()) {
/*    */       Node node;
/*    */       
/* 86 */       if (node = paramDefinitionItem.getLastChild() instanceof Paragraph && ((Paragraph)node).isTrailingBlankLine()) {
/* 87 */         paramMarkdownWriter.blankLine();
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 96 */       return new DefinitionNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\internal\DefinitionNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */