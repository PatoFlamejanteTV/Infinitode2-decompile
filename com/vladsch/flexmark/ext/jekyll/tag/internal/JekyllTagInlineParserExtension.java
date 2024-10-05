/*    */ package com.vladsch.flexmark.ext.jekyll.tag.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTag;
/*    */ import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.LightInlineParser;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.regex.Matcher;
/*    */ 
/*    */ public class JekyllTagInlineParserExtension
/*    */   implements InlineParserExtension {
/*    */   private final JekyllTagParsing parsing;
/*    */   private final boolean listIncludesOnly;
/*    */   
/*    */   public JekyllTagInlineParserExtension(LightInlineParser paramLightInlineParser) {
/* 22 */     this.parsing = new JekyllTagParsing(paramLightInlineParser.getParsing());
/* 23 */     this.listIncludesOnly = ((Boolean)JekyllTagExtension.LIST_INCLUDES_ONLY.get((DataHolder)paramLightInlineParser.getDocument())).booleanValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void finalizeDocument(InlineParser paramInlineParser) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void finalizeBlock(InlineParser paramInlineParser) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean parse(LightInlineParser paramLightInlineParser) {
/* 38 */     BasedSequence basedSequence = paramLightInlineParser.getInput();
/*    */     Matcher matcher;
/* 40 */     if (paramLightInlineParser.peek(1) == '%' && (paramLightInlineParser.peek(2) == ' ' || paramLightInlineParser.peek(2) == '\t') && (matcher = paramLightInlineParser.matcher(this.parsing.MACRO_TAG)) != null) {
/* 41 */       BasedSequence basedSequence1 = basedSequence.subSequence(matcher.start(), matcher.end());
/* 42 */       BasedSequence basedSequence2 = basedSequence.subSequence(matcher.start(1), matcher.end(1));
/* 43 */       basedSequence = (BasedSequence)basedSequence.subSequence(matcher.end(1), matcher.end() - 2).trim();
/*    */       JekyllTag jekyllTag;
/* 45 */       (jekyllTag = new JekyllTag(basedSequence1.subSequence(0, 2), basedSequence2, basedSequence, (BasedSequence)basedSequence1.endSequence(2))).setCharsFromContent();
/*    */ 
/*    */       
/* 48 */       if (!this.listIncludesOnly || basedSequence2.equals("include")) {
/*    */         List<JekyllTag> list;
/* 50 */         (list = (List<JekyllTag>)JekyllTagExtension.TAG_LIST.get((DataHolder)paramLightInlineParser.getDocument())).add(jekyllTag);
/*    */       } 
/*    */       
/* 53 */       paramLightInlineParser.flushTextNode();
/* 54 */       paramLightInlineParser.getBlock().appendChild((Node)jekyllTag);
/* 55 */       return true;
/*    */     } 
/*    */     
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements InlineParserExtensionFactory
/*    */   {
/*    */     public Set<Class<?>> getAfterDependents() {
/* 65 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public CharSequence getCharacters() {
/* 71 */       return "{";
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 77 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 83 */       return new JekyllTagInlineParserExtension(param1LightInlineParser);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 88 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\internal\JekyllTagInlineParserExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */