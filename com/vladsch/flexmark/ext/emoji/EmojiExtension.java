/*    */ package com.vladsch.flexmark.ext.emoji;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.emoji.internal.EmojiDelimiterProcessor;
/*    */ import com.vladsch.flexmark.ext.emoji.internal.EmojiJiraRenderer;
/*    */ import com.vladsch.flexmark.ext.emoji.internal.EmojiNodeFormatter;
/*    */ import com.vladsch.flexmark.ext.emoji.internal.EmojiNodeRenderer;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmojiExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/* 22 */   public static final DataKey<String> ATTR_ALIGN = new DataKey("ATTR_ALIGN", "absmiddle");
/* 23 */   public static final DataKey<String> ATTR_IMAGE_SIZE = new DataKey("ATTR_IMAGE_SIZE", "20");
/* 24 */   public static final DataKey<String> ATTR_IMAGE_CLASS = new DataKey("ATTR_IMAGE_CLASS", "");
/* 25 */   public static final DataKey<String> ROOT_IMAGE_PATH = new DataKey("ROOT_IMAGE_PATH", "/img/");
/* 26 */   public static final DataKey<EmojiShortcutType> USE_SHORTCUT_TYPE = new DataKey("USE_SHORTCUT_TYPE", EmojiShortcutType.EMOJI_CHEAT_SHEET);
/* 27 */   public static final DataKey<EmojiImageType> USE_IMAGE_TYPE = new DataKey("USE_IMAGE_TYPE", EmojiImageType.IMAGE_ONLY);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static EmojiExtension create() {
/* 33 */     return new EmojiExtension();
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
/* 48 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new EmojiNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 53 */     paramBuilder.customDelimiterProcessor((DelimiterProcessor)new EmojiDelimiterProcessor());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 58 */     if (paramBuilder.isRendererType("HTML")) {
/* 59 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new EmojiNodeRenderer.Factory()); return;
/* 60 */     }  if (paramBuilder.isRendererType("JIRA"))
/* 61 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new EmojiJiraRenderer.Factory()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\emoji\EmojiExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */