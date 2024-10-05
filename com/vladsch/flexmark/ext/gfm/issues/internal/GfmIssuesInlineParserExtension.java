/*    */ package com.vladsch.flexmark.ext.gfm.issues.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.issues.GfmIssue;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.LightInlineParser;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Set;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class GfmIssuesInlineParserExtension
/*    */   implements InlineParserExtension
/*    */ {
/* 16 */   public static final Pattern GITHUB_ISSUE = Pattern.compile("^(#)(\\d+)\\b");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public GfmIssuesInlineParserExtension(LightInlineParser paramLightInlineParser) {}
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
/*    */     BasedSequence[] arrayOfBasedSequence;
/* 35 */     if ((arrayOfBasedSequence = paramLightInlineParser.matchWithGroups(GITHUB_ISSUE)) != null) {
/* 36 */       paramLightInlineParser.flushTextNode();
/*    */       
/* 38 */       BasedSequence basedSequence2 = arrayOfBasedSequence[1];
/* 39 */       BasedSequence basedSequence1 = arrayOfBasedSequence[2];
/*    */       
/* 41 */       GfmIssue gfmIssue = new GfmIssue(basedSequence2, basedSequence1);
/* 42 */       paramLightInlineParser.getBlock().appendChild((Node)gfmIssue);
/* 43 */       return true;
/*    */     } 
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements InlineParserExtensionFactory
/*    */   {
/*    */     public Set<Class<?>> getAfterDependents() {
/* 52 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public CharSequence getCharacters() {
/* 58 */       return "#";
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 64 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 70 */       return new GfmIssuesInlineParserExtension(param1LightInlineParser);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 75 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\issues\internal\GfmIssuesInlineParserExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */