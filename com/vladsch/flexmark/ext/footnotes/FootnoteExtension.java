/*    */ package com.vladsch.flexmark.ext.footnotes;
/*    */ import com.vladsch.flexmark.ext.footnotes.internal.FootnoteBlockParser;
/*    */ import com.vladsch.flexmark.ext.footnotes.internal.FootnoteNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.footnotes.internal.FootnoteNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.footnotes.internal.FootnoteRepository;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.ast.NodeRepository;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*    */ import com.vladsch.flexmark.util.data.DataNotNullValueFactory;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*    */ 
/*    */ public class FootnoteExtension implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension, Parser.ReferenceHoldingExtension {
/* 24 */   public static final DataKey<KeepType> FOOTNOTES_KEEP = new DataKey("FOOTNOTES_KEEP", KeepType.FIRST);
/*    */   
/* 26 */   public static final DataKey<FootnoteRepository> FOOTNOTES = new DataKey("FOOTNOTES", new FootnoteRepository(null), FootnoteRepository::new);
/* 27 */   public static final DataKey<String> FOOTNOTE_REF_PREFIX = new DataKey("FOOTNOTE_REF_PREFIX", "");
/* 28 */   public static final DataKey<String> FOOTNOTE_REF_SUFFIX = new DataKey("FOOTNOTE_REF_SUFFIX", "");
/* 29 */   public static final DataKey<String> FOOTNOTE_BACK_REF_STRING = new DataKey("FOOTNOTE_BACK_REF_STRING", "&#8617;");
/* 30 */   public static final DataKey<String> FOOTNOTE_LINK_REF_CLASS = new DataKey("FOOTNOTE_LINK_REF_CLASS", "footnote-ref");
/* 31 */   public static final DataKey<String> FOOTNOTE_BACK_LINK_REF_CLASS = new DataKey("FOOTNOTE_BACK_LINK_REF_CLASS", "footnote-backref");
/*    */ 
/*    */   
/* 34 */   public static final DataKey<ElementPlacement> FOOTNOTE_PLACEMENT = new DataKey("FOOTNOTE_PLACEMENT", ElementPlacement.AS_IS);
/* 35 */   public static final DataKey<ElementPlacementSort> FOOTNOTE_SORT = new DataKey("FOOTNOTE_SORT", ElementPlacementSort.AS_IS);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FootnoteExtension create() {
/* 41 */     return new FootnoteExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 46 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new FootnoteNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean transferReferences(MutableDataHolder paramMutableDataHolder, DataHolder paramDataHolder) {
/* 61 */     if (paramMutableDataHolder.contains((DataKeyBase)FOOTNOTES) && paramDataHolder.contains((DataKeyBase)FOOTNOTES)) {
/* 62 */       return Parser.transferReferences((NodeRepository)FOOTNOTES.get((DataHolder)paramMutableDataHolder), (NodeRepository)FOOTNOTES.get(paramDataHolder), (FOOTNOTES_KEEP.get((DataHolder)paramMutableDataHolder) == KeepType.FIRST));
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 69 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new FootnoteBlockParser.Factory());
/* 70 */     paramBuilder.linkRefProcessorFactory((LinkRefProcessorFactory)new FootnoteLinkRefProcessor.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 75 */     if (paramBuilder.isRendererType("HTML")) {
/* 76 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new FootnoteNodeRenderer.Factory()); return;
/* 77 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\FootnoteExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */