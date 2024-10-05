/*    */ package com.vladsch.flexmark.ext.gitlab.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gitlab.GitLabInlineMath;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.LightInlineParser;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Set;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class GitLabInlineMathParser
/*    */   implements InlineParserExtension
/*    */ {
/* 17 */   Pattern MATH_PATTERN = Pattern.compile("\\$`((?:.|\n)*?)`\\$");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public GitLabInlineMathParser(LightInlineParser paramLightInlineParser) {}
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
/* 35 */     BasedSequence basedSequence = paramLightInlineParser.getInput();
/*    */     Matcher matcher;
/* 37 */     if (paramLightInlineParser.peek(1) == '`' && (matcher = paramLightInlineParser.matcher(this.MATH_PATTERN)) != null) {
/* 38 */       paramLightInlineParser.flushTextNode();
/*    */       
/* 40 */       BasedSequence basedSequence1 = basedSequence.subSequence(matcher.start(), matcher.start(1));
/* 41 */       basedSequence = basedSequence.subSequence(matcher.end(1), matcher.end());
/* 42 */       GitLabInlineMath gitLabInlineMath = new GitLabInlineMath(basedSequence1, basedSequence1.baseSubSequence(basedSequence1.getEndOffset(), basedSequence.getStartOffset()), basedSequence);
/* 43 */       paramLightInlineParser.getBlock().appendChild((Node)gitLabInlineMath);
/* 44 */       return true;
/*    */     } 
/*    */     
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements InlineParserExtensionFactory
/*    */   {
/*    */     public Set<Class<?>> getAfterDependents() {
/* 54 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public CharSequence getCharacters() {
/* 60 */       return "$";
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 66 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 72 */       return new GitLabInlineMathParser(param1LightInlineParser);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 77 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\internal\GitLabInlineMathParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */