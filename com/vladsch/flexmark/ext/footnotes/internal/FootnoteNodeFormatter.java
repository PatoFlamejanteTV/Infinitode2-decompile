/*    */ package com.vladsch.flexmark.ext.footnotes.internal;
/*    */ import com.vladsch.flexmark.ext.footnotes.Footnote;
/*    */ import com.vladsch.flexmark.ext.footnotes.FootnoteBlock;
/*    */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*    */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class FootnoteNodeFormatter extends NodeRepositoryFormatter<FootnoteRepository, FootnoteBlock, Footnote> {
/* 17 */   public static final DataKey<Map<String, String>> FOOTNOTE_TRANSLATION_MAP = new DataKey("FOOTNOTE_TRANSLATION_MAP", new HashMap<>());
/* 18 */   public static final DataKey<Map<String, String>> FOOTNOTE_UNIQUIFICATION_MAP = new DataKey("FOOTNOTE_UNIQUIFICATION_MAP", new HashMap<>());
/*    */   private final FootnoteFormatOptions options;
/*    */   
/*    */   public FootnoteNodeFormatter(DataHolder paramDataHolder) {
/* 22 */     super(paramDataHolder, FOOTNOTE_TRANSLATION_MAP, FOOTNOTE_UNIQUIFICATION_MAP);
/* 23 */     this.options = new FootnoteFormatOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public FootnoteRepository getRepository(DataHolder paramDataHolder) {
/* 28 */     return (FootnoteRepository)FootnoteExtension.FOOTNOTES.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public ElementPlacement getReferencePlacement() {
/* 33 */     return this.options.footnotePlacement;
/*    */   }
/*    */ 
/*    */   
/*    */   public ElementPlacementSort getReferenceSort() {
/* 38 */     return this.options.footnoteSort;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderReferenceBlock(FootnoteBlock paramFootnoteBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 43 */     ((MarkdownWriter)paramMarkdownWriter.blankLine()).append("[^");
/* 44 */     paramMarkdownWriter.append(transformReferenceId(paramFootnoteBlock.getText().toString(), paramNodeFormatterContext));
/* 45 */     paramMarkdownWriter.append("]: ");
/* 46 */     ((MarkdownWriter)paramMarkdownWriter.pushPrefix()).addPrefix("    ");
/* 47 */     paramNodeFormatterContext.renderChildren((Node)paramFootnoteBlock);
/* 48 */     paramMarkdownWriter.popPrefix();
/* 49 */     paramMarkdownWriter.blankLine();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/* 55 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(Footnote.class, this::render), new NodeFormattingHandler(FootnoteBlock.class, this::render) }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getNodeClasses() {
/* 64 */     if (this.options.footnotePlacement.isNoChange() || !this.options.footnoteSort.isUnused()) return null;
/*    */     
/* 66 */     return new HashSet<>(Arrays.asList(new Class[] { Footnote.class }));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void render(FootnoteBlock paramFootnoteBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 72 */     renderReference((Node)paramFootnoteBlock, paramNodeFormatterContext, paramMarkdownWriter);
/*    */   }
/*    */   private void render(Footnote paramFootnote, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*    */     String str;
/* 76 */     paramMarkdownWriter.append("[^");
/* 77 */     if (paramNodeFormatterContext.isTransformingText()) {
/* 78 */       str = transformReferenceId(paramFootnote.getText().toString(), paramNodeFormatterContext);
/* 79 */       paramNodeFormatterContext.nonTranslatingSpan((paramNodeFormatterContext, paramMarkdownWriter) -> paramMarkdownWriter.append(paramString));
/*    */     } else {
/* 81 */       paramMarkdownWriter.append((CharSequence)str.getText());
/*    */     } 
/* 83 */     paramMarkdownWriter.append("]");
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements NodeFormatterFactory
/*    */   {
/*    */     public NodeFormatter create(DataHolder param1DataHolder) {
/* 90 */       return (NodeFormatter)new FootnoteNodeFormatter(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\internal\FootnoteNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */