/*    */ package com.vladsch.flexmark.ext.abbreviation;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.abbreviation.internal.AbbreviationBlockParser;
/*    */ import com.vladsch.flexmark.ext.abbreviation.internal.AbbreviationNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.abbreviation.internal.AbbreviationNodePostProcessor;
/*    */ import com.vladsch.flexmark.ext.abbreviation.internal.AbbreviationNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.abbreviation.internal.AbbreviationRepository;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.DataNotNullValueFactory;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*    */ 
/*    */ public class AbbreviationExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension, Parser.ReferenceHoldingExtension
/*    */ {
/* 26 */   public static final DataKey<KeepType> ABBREVIATIONS_KEEP = new DataKey("ABBREVIATIONS_KEEP", KeepType.FIRST);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 31 */   public static final DataKey<AbbreviationRepository> ABBREVIATIONS = new DataKey("ABBREVIATIONS", new AbbreviationRepository(null), AbbreviationRepository::new);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   public static final DataKey<Boolean> USE_LINKS = new DataKey("USE_LINKS", Boolean.FALSE);
/*    */ 
/*    */   
/* 39 */   public static final DataKey<ElementPlacement> ABBREVIATIONS_PLACEMENT = new DataKey("ABBREVIATIONS_PLACEMENT", ElementPlacement.AS_IS);
/* 40 */   public static final DataKey<ElementPlacementSort> ABBREVIATIONS_SORT = new DataKey("ABBREVIATIONS_SORT", ElementPlacementSort.AS_IS);
/*    */   
/* 42 */   public static final DataKey<Boolean> MAKE_MERGED_ABBREVIATIONS_UNIQUE = new DataKey("MERGE_MAKE_ABBREVIATIONS_UNIQUE", Boolean.FALSE);
/*    */   
/*    */   public static AbbreviationExtension create() {
/* 45 */     return new AbbreviationExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 50 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new AbbreviationNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean transferReferences(MutableDataHolder paramMutableDataHolder, DataHolder paramDataHolder) {
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 77 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new AbbreviationBlockParser.Factory());
/*    */     
/* 79 */     paramBuilder.postProcessorFactory((PostProcessorFactory)new AbbreviationNodePostProcessor.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 84 */     if (paramBuilder.isRendererType("HTML")) {
/* 85 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new AbbreviationNodeRenderer.Factory()); return;
/* 86 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\AbbreviationExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */