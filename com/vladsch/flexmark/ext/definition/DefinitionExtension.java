/*    */ package com.vladsch.flexmark.ext.definition;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.definition.internal.DefinitionItemBlockParser;
/*    */ import com.vladsch.flexmark.ext.definition.internal.DefinitionListBlockPreProcessor;
/*    */ import com.vladsch.flexmark.ext.definition.internal.DefinitionListItemBlockPreProcessor;
/*    */ import com.vladsch.flexmark.ext.definition.internal.DefinitionNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.definition.internal.DefinitionNodeRenderer;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.BlockPreProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.DefinitionMarker;
/*    */ 
/*    */ public class DefinitionExtension implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension {
/* 20 */   public static final DataKey<Boolean> COLON_MARKER = new DataKey("COLON_MARKER", Boolean.TRUE);
/* 21 */   public static final DataKey<Integer> MARKER_SPACES = new DataKey("MARKER_SPACE", Integer.valueOf(1));
/* 22 */   public static final DataKey<Boolean> TILDE_MARKER = new DataKey("TILDE_MARKER", Boolean.TRUE);
/* 23 */   public static final DataKey<Boolean> DOUBLE_BLANK_LINE_BREAKS_LIST = new DataKey("DOUBLE_BLANK_LINE_BREAKS_LIST", Boolean.FALSE);
/*    */   
/* 25 */   public static final DataKey<Integer> FORMAT_MARKER_SPACES = new DataKey("MARKER_SPACE", Integer.valueOf(3));
/* 26 */   public static final DataKey<DefinitionMarker> FORMAT_MARKER_TYPE = new DataKey("FORMAT_MARKER_TYPE", DefinitionMarker.ANY);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DefinitionExtension create() {
/* 32 */     return new DefinitionExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 37 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new DefinitionNodeFormatter.Factory());
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
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 52 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new DefinitionItemBlockParser.Factory());
/* 53 */     paramBuilder.blockPreProcessorFactory((BlockPreProcessorFactory)new DefinitionListItemBlockPreProcessor.Factory());
/* 54 */     paramBuilder.blockPreProcessorFactory((BlockPreProcessorFactory)new DefinitionListBlockPreProcessor.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 59 */     if (paramBuilder.isRendererType("HTML")) {
/* 60 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new DefinitionNodeRenderer.Factory()); return;
/* 61 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\DefinitionExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */