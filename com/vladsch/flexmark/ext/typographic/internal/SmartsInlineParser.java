/*    */ package com.vladsch.flexmark.ext.typographic.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.typographic.TypographicSmarts;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.LightInlineParser;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class SmartsInlineParser
/*    */   implements InlineParserExtension
/*    */ {
/*    */   private final SmartsParsing parsing;
/*    */   
/*    */   public SmartsInlineParser(LightInlineParser paramLightInlineParser) {
/* 18 */     this.parsing = new SmartsParsing(paramLightInlineParser.getParsing());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void finalizeDocument(InlineParser paramInlineParser) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void finalizeBlock(InlineParser paramInlineParser) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean parse(LightInlineParser paramLightInlineParser) {
/* 34 */     BasedSequence basedSequence1 = paramLightInlineParser.getInput();
/* 35 */     String str = null;
/* 36 */     BasedSequence basedSequence2 = null;
/*    */     
/* 38 */     int i = paramLightInlineParser.getIndex();
/*    */     
/*    */     char c;
/* 41 */     if ((c = basedSequence1.charAt(i)) == '.') {
/* 42 */       if (basedSequence1.matchChars(this.parsing.ELIPSIS, i)) {
/* 43 */         basedSequence2 = basedSequence1.subSequence(i, i + this.parsing.ELIPSIS.length());
/* 44 */         str = "&hellip;";
/* 45 */       } else if (basedSequence1.matchChars(this.parsing.ELIPSIS_SPACED, i)) {
/* 46 */         basedSequence2 = basedSequence1.subSequence(i, i + this.parsing.ELIPSIS_SPACED.length());
/* 47 */         str = "&hellip;";
/*    */       } 
/* 49 */     } else if (c == '-') {
/* 50 */       if (basedSequence1.matchChars(this.parsing.EM_DASH, i)) {
/* 51 */         basedSequence2 = basedSequence1.subSequence(i, i + this.parsing.EM_DASH.length());
/* 52 */         str = "&mdash;";
/* 53 */       } else if (basedSequence1.matchChars(this.parsing.EN_DASH, i)) {
/* 54 */         basedSequence2 = basedSequence1.subSequence(i, i + this.parsing.EN_DASH.length());
/* 55 */         str = "&ndash;";
/*    */       } 
/*    */     } 
/*    */     
/* 59 */     if (basedSequence2 != null) {
/* 60 */       paramLightInlineParser.flushTextNode();
/* 61 */       paramLightInlineParser.setIndex(i + basedSequence2.length());
/* 62 */       TypographicSmarts typographicSmarts = new TypographicSmarts(basedSequence2, str);
/* 63 */       paramLightInlineParser.getBlock().appendChild((Node)typographicSmarts);
/* 64 */       return true;
/*    */     } 
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements InlineParserExtensionFactory
/*    */   {
/*    */     public Set<Class<?>> getAfterDependents() {
/* 73 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public CharSequence getCharacters() {
/* 79 */       return ".-";
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 85 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 91 */       return new SmartsInlineParser(param1LightInlineParser);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 96 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\internal\SmartsInlineParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */