/*    */ package com.vladsch.flexmark.ext.macros.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.macros.MacroReference;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.LightInlineParser;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Set;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class MacrosInlineParserExtension
/*    */   implements InlineParserExtension
/*    */ {
/* 16 */   static Pattern MACRO_REFERENCE = Pattern.compile("<<<([\\w_-]+)>>>");
/* 17 */   static Pattern MACRO_REFERENCE_INTELLIJ = Pattern.compile("<<<([\037\\w_-]+)>>>");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MacrosInlineParserExtension(LightInlineParser paramLightInlineParser) {}
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
/*    */     BasedSequence basedSequence;
/* 37 */     if ((basedSequence = paramLightInlineParser.match((paramLightInlineParser.getParsing()).intellijDummyIdentifier ? MACRO_REFERENCE_INTELLIJ : MACRO_REFERENCE)) != null) {
/* 38 */       BasedSequence basedSequence1 = (BasedSequence)basedSequence.midSequence(3, -3);
/* 39 */       MacroReference macroReference = new MacroReference(basedSequence.subSequence(0, 3), basedSequence1, (BasedSequence)basedSequence.midSequence(-3));
/* 40 */       paramLightInlineParser.flushTextNode();
/* 41 */       paramLightInlineParser.getBlock().appendChild((Node)macroReference);
/* 42 */       return true;
/*    */     } 
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements InlineParserExtensionFactory
/*    */   {
/*    */     public Set<Class<?>> getAfterDependents() {
/* 51 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public CharSequence getCharacters() {
/* 57 */       return "<";
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 63 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 69 */       return new MacrosInlineParserExtension(param1LightInlineParser);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 74 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\internal\MacrosInlineParserExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */