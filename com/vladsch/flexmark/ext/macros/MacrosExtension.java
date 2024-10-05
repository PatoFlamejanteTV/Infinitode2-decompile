/*    */ package com.vladsch.flexmark.ext.macros;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.macros.internal.MacroDefinitionBlockParser;
/*    */ import com.vladsch.flexmark.ext.macros.internal.MacroDefinitionRepository;
/*    */ import com.vladsch.flexmark.ext.macros.internal.MacrosInlineParserExtension;
/*    */ import com.vladsch.flexmark.ext.macros.internal.MacrosNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.macros.internal.MacrosNodeRenderer;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
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
/*    */ public class MacrosExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension, Parser.ReferenceHoldingExtension {
/* 27 */   public static final DataKey<KeepType> MACRO_DEFINITIONS_KEEP = new DataKey("MACRO_DEFINITIONS_KEEP", KeepType.FIRST);
/* 28 */   public static final DataKey<MacroDefinitionRepository> MACRO_DEFINITIONS = new DataKey("MACRO_DEFINITIONS", new MacroDefinitionRepository(null), MacroDefinitionRepository::new);
/*    */ 
/*    */   
/* 31 */   public static final DataKey<ElementPlacement> MACRO_DEFINITIONS_PLACEMENT = new DataKey("MACRO_DEFINITIONS_PLACEMENT", ElementPlacement.AS_IS);
/* 32 */   public static final DataKey<ElementPlacementSort> MACRO_DEFINITIONS_SORT = new DataKey("MACRO_DEFINITIONS_SORT", ElementPlacementSort.AS_IS);
/* 33 */   public static final DataKey<Boolean> SOURCE_WRAP_MACRO_REFERENCES = new DataKey("SOURCE_WRAP_MACRO_REFERENCES", Boolean.FALSE);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static MacrosExtension create() {
/* 39 */     return new MacrosExtension();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean transferReferences(MutableDataHolder paramMutableDataHolder, DataHolder paramDataHolder) {
/* 55 */     if (paramDataHolder.contains((DataKeyBase)MACRO_DEFINITIONS)) {
/* 56 */       return Parser.transferReferences((NodeRepository)MACRO_DEFINITIONS.get((DataHolder)paramMutableDataHolder), (NodeRepository)MACRO_DEFINITIONS.get(paramDataHolder), (MACRO_DEFINITIONS_KEEP.get((DataHolder)paramMutableDataHolder) == KeepType.FIRST));
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 63 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new MacrosNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 68 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new MacroDefinitionBlockParser.Factory());
/* 69 */     paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new MacrosInlineParserExtension.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 74 */     if (paramBuilder.isRendererType("HTML")) {
/* 75 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new MacrosNodeRenderer.Factory()); return;
/* 76 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\MacrosExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */