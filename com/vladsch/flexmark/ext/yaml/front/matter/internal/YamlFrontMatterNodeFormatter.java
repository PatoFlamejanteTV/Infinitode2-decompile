/*    */ package com.vladsch.flexmark.ext.yaml.front.matter.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.yaml.front.matter.YamlFrontMatterBlock;
/*    */ import com.vladsch.flexmark.formatter.FormattingPhase;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.formatter.PhasedNodeFormatter;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class YamlFrontMatterNodeFormatter implements PhasedNodeFormatter {
/*    */   public YamlFrontMatterNodeFormatter(DataHolder paramDataHolder) {}
/*    */   
/*    */   public Set<FormattingPhase> getFormattingPhases() {
/* 22 */     return new HashSet<>(Collections.singleton(FormattingPhase.DOCUMENT_FIRST));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   public void renderDocument(NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter, Document paramDocument, FormattingPhase paramFormattingPhase) {
/*    */     Node node;
/* 33 */     if (paramFormattingPhase == FormattingPhase.DOCUMENT_FIRST && 
/*    */       
/* 35 */       node = paramDocument.getFirstChild() instanceof YamlFrontMatterBlock) {
/* 36 */       paramMarkdownWriter.openPreFormatted(false);
/* 37 */       ((MarkdownWriter)paramMarkdownWriter.append((CharSequence)node.getChars())).blankLine();
/* 38 */       paramMarkdownWriter.closePreFormatted();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/* 46 */     return new HashSet<>(Collections.singletonList(new NodeFormattingHandler(YamlFrontMatterBlock.class, this::render)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(YamlFrontMatterBlock paramYamlFrontMatterBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 59 */       return (NodeFormatter)new YamlFrontMatterNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\yaml\front\matter\internal\YamlFrontMatterNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */