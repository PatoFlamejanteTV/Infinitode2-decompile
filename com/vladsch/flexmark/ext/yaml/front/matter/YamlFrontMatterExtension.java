/*    */ package com.vladsch.flexmark.ext.yaml.front.matter;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.yaml.front.matter.internal.YamlFrontMatterBlockParser;
/*    */ import com.vladsch.flexmark.ext.yaml.front.matter.internal.YamlFrontMatterNodeFormatter;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class YamlFrontMatterExtension
/*    */   implements Formatter.FormatterExtension, Parser.ParserExtension
/*    */ {
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 27 */     paramBuilder.nodeFormatterFactory((NodeFormatterFactory)new YamlFrontMatterNodeFormatter.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 32 */     paramBuilder.customBlockParserFactory((CustomBlockParserFactory)new YamlFrontMatterBlockParser.Factory());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */   
/*    */   public static YamlFrontMatterExtension create() {
/* 41 */     return new YamlFrontMatterExtension();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\yaml\front\matter\YamlFrontMatterExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */