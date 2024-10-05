/*    */ package com.vladsch.flexmark.ext.aside;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.aside.internal.AsideBlockParser;
/*    */ import com.vladsch.flexmark.ext.aside.internal.AsideNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.aside.internal.AsideNodeRenderer;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AsideExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 21 */   public static final DataKey<Boolean> EXTEND_TO_BLANK_LINE = new DataKey("EXTEND_TO_BLANK_LINE", Parser.BLOCK_QUOTE_EXTEND_TO_BLANK_LINE);
/* 22 */   public static final DataKey<Boolean> IGNORE_BLANK_LINE = new DataKey("IGNORE_BLANK_LINE", Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE);
/* 23 */   public static final DataKey<Boolean> ALLOW_LEADING_SPACE = new DataKey("ALLOW_LEADING_SPACE", Parser.BLOCK_QUOTE_ALLOW_LEADING_SPACE);
/* 24 */   public static final DataKey<Boolean> INTERRUPTS_PARAGRAPH = new DataKey("INTERRUPTS_PARAGRAPH", Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH);
/* 25 */   public static final DataKey<Boolean> INTERRUPTS_ITEM_PARAGRAPH = new DataKey("INTERRUPTS_ITEM_PARAGRAPH", Parser.BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH);
/* 26 */   public static final DataKey<Boolean> WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH = new DataKey("WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH", Parser.BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static AsideExtension create() {
/* 32 */     return new AsideExtension();
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
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 47 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new AsideNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 52 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new AsideBlockParser.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 57 */     if (paramBuilder.isRendererType("HTML")) {
/* 58 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new AsideNodeRenderer.Factory()); return;
/* 59 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\aside\AsideExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */