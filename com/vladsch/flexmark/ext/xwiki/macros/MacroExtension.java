/*    */ package com.vladsch.flexmark.ext.xwiki.macros;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.xwiki.macros.internal.MacroBlockParser;
/*    */ import com.vladsch.flexmark.ext.xwiki.macros.internal.MacroInlineParser;
/*    */ import com.vladsch.flexmark.ext.xwiki.macros.internal.MacroNodeRenderer;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MacroExtension
/*    */   implements HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 22 */   public static final DataKey<Boolean> ENABLE_INLINE_MACROS = new DataKey("ENABLE_INLINE_MACROS", Boolean.TRUE);
/* 23 */   public static final DataKey<Boolean> ENABLE_BLOCK_MACROS = new DataKey("ENABLE_BLOCK_MACROS", Boolean.TRUE);
/* 24 */   public static final DataKey<Boolean> ENABLE_RENDERING = new DataKey("ENABLE_RENDERING", Boolean.FALSE);
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
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 36 */     paramBuilder.nodeRendererFactory((NodeRendererFactory)new MacroNodeRenderer.Factory());
/*    */   }
/*    */   
/*    */   public static MacroExtension create() {
/* 40 */     return new MacroExtension();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 50 */     if (((Boolean)ENABLE_BLOCK_MACROS.get((DataHolder)paramBuilder)).booleanValue()) paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new MacroBlockParser.Factory()); 
/* 51 */     if (((Boolean)ENABLE_INLINE_MACROS.get((DataHolder)paramBuilder)).booleanValue()) paramBuilder.customInlineParserExtensionFactory((InlineParserExtensionFactory)new MacroInlineParser.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\MacroExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */