/*    */ package com.vladsch.flexmark.ext.attributes;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.attributes.internal.AttributesAttributeProvider;
/*    */ import com.vladsch.flexmark.ext.attributes.internal.AttributesInlineParserExtension;
/*    */ import com.vladsch.flexmark.ext.attributes.internal.AttributesNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.attributes.internal.AttributesNodePostProcessor;
/*    */ import com.vladsch.flexmark.ext.attributes.internal.AttributesNodeRenderer;
/*    */ import com.vladsch.flexmark.ext.attributes.internal.NodeAttributeRepository;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.AttributeProviderFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.RendererBuilder;
/*    */ import com.vladsch.flexmark.html.RendererExtension;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.PostProcessorFactory;
/*    */ import com.vladsch.flexmark.util.ast.KeepType;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*    */ import com.vladsch.flexmark.util.data.DataNotNullValueFactory;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.DiscretionaryText;
/*    */ 
/*    */ public class AttributesExtension implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, RendererExtension, Parser.ParserExtension {
/* 28 */   public static final DataKey<NodeAttributeRepository> NODE_ATTRIBUTES = new DataKey("NODE_ATTRIBUTES", new NodeAttributeRepository(null), NodeAttributeRepository::new);
/* 29 */   public static final DataKey<KeepType> ATTRIBUTES_KEEP = new DataKey("ATTRIBUTES_KEEP", KeepType.FIRST);
/* 30 */   public static final DataKey<Boolean> ASSIGN_TEXT_ATTRIBUTES = new DataKey("ASSIGN_TEXT_ATTRIBUTES", Boolean.TRUE);
/* 31 */   public static final DataKey<Boolean> FENCED_CODE_INFO_ATTRIBUTES = new DataKey("FENCED_CODE_INFO_ATTRIBUTES", Boolean.FALSE);
/* 32 */   public static final DataKey<FencedCodeAddType> FENCED_CODE_ADD_ATTRIBUTES = new DataKey("FENCED_CODE_ADD_ATTRIBUTES", FencedCodeAddType.ADD_TO_PRE_CODE);
/* 33 */   public static final DataKey<Boolean> WRAP_NON_ATTRIBUTE_TEXT = new DataKey("WRAP_NON_ATTRIBUTE_TEXT", Boolean.TRUE);
/* 34 */   public static final DataKey<Boolean> USE_EMPTY_IMPLICIT_AS_SPAN_DELIMITER = new DataKey("USE_EMPTY_IMPLICIT_AS_SPAN_DELIMITER", Boolean.FALSE);
/*    */   
/* 36 */   public static final DataKey<Boolean> FORMAT_ATTRIBUTES_COMBINE_CONSECUTIVE = new DataKey("FORMAT_ATTRIBUTES_COMBINE_CONSECUTIVE", Boolean.FALSE);
/* 37 */   public static final DataKey<Boolean> FORMAT_ATTRIBUTES_SORT = new DataKey("FORMAT_ATTRIBUTES_SORT", Boolean.FALSE);
/* 38 */   public static final DataKey<DiscretionaryText> FORMAT_ATTRIBUTES_SPACES = new DataKey("FORMAT_ATTRIBUTES_SPACES", DiscretionaryText.AS_IS);
/* 39 */   public static final DataKey<DiscretionaryText> FORMAT_ATTRIBUTE_EQUAL_SPACE = new DataKey("FORMAT_ATTRIBUTE_EQUAL_SPACE", DiscretionaryText.AS_IS);
/* 40 */   public static final DataKey<AttributeValueQuotes> FORMAT_ATTRIBUTE_VALUE_QUOTES = new DataKey("FORMAT_ATTRIBUTE_VALUE_QUOTES", AttributeValueQuotes.AS_IS);
/* 41 */   public static final DataKey<AttributeImplicitName> FORMAT_ATTRIBUTE_ID = new DataKey("FORMAT_ATTRIBUTE_ID", AttributeImplicitName.AS_IS);
/* 42 */   public static final DataKey<AttributeImplicitName> FORMAT_ATTRIBUTE_CLASS = new DataKey("FORMAT_ATTRIBUTE_CLASS", AttributeImplicitName.AS_IS);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static AttributesExtension create() {
/* 48 */     return new AttributesExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {
/* 53 */     if (paramMutableDataHolder.contains((DataKeyBase)FENCED_CODE_INFO_ATTRIBUTES) && ((Boolean)FENCED_CODE_INFO_ATTRIBUTES.get((DataHolder)paramMutableDataHolder)).booleanValue() && !paramMutableDataHolder.contains((DataKeyBase)FENCED_CODE_ADD_ATTRIBUTES))
/*    */     {
/* 55 */       paramMutableDataHolder.set(FENCED_CODE_ADD_ATTRIBUTES, FencedCodeAddType.ADD_TO_PRE);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 61 */     paramBuilder.postProcessorFactory((PostProcessorFactory)new AttributesNodePostProcessor.Factory());
/* 62 */     paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new AttributesInlineParserExtension.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 67 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new AttributesNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 77 */     if (((Boolean)ASSIGN_TEXT_ATTRIBUTES.get((DataHolder)paramBuilder)).booleanValue()) {
/* 78 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new AttributesNodeRenderer.Factory());
/*    */     }
/* 80 */     paramBuilder.attributeProviderFactory((AttributeProviderFactory)new AttributesAttributeProvider.Factory());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(RendererBuilder paramRendererBuilder, String paramString) {
/* 86 */     paramRendererBuilder.attributeProviderFactory((AttributeProviderFactory)new AttributesAttributeProvider.Factory());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\AttributesExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */