/*    */ package com.vladsch.flexmark.parser.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.BitSet;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonmarkInlineParser
/*    */   extends InlineParserImpl
/*    */ {
/*    */   public CommonmarkInlineParser(DataHolder paramDataHolder, BitSet paramBitSet1, BitSet paramBitSet2, Map<Character, DelimiterProcessor> paramMap, LinkRefProcessorData paramLinkRefProcessorData, List<InlineParserExtensionFactory> paramList) {
/* 18 */     super(paramDataHolder, paramBitSet1, paramBitSet2, paramMap, paramLinkRefProcessorData, paramList);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initializeDocument(Document paramDocument) {
/* 23 */     super.initializeDocument(paramDocument);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\CommonmarkInlineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */