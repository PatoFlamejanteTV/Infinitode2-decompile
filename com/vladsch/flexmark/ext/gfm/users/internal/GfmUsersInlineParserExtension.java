/*    */ package com.vladsch.flexmark.ext.gfm.users.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.users.GfmUser;
/*    */ import com.vladsch.flexmark.parser.InlineParser;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*    */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*    */ import com.vladsch.flexmark.parser.LightInlineParser;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.Set;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class GfmUsersInlineParserExtension
/*    */   implements InlineParserExtension
/*    */ {
/* 16 */   public static final Pattern GITHUB_USER = Pattern.compile("^(@)([a-z\\d](?:[a-z\\d]|-(?=[a-z\\d])){0,38})\\b", 2);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public GfmUsersInlineParserExtension(LightInlineParser paramLightInlineParser) {}
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
/*    */     int i;
/*    */     boolean bool;
/* 36 */     if (!(bool = ((i = paramLightInlineParser.getIndex()) == 0) ? true : false) && 
/*    */       
/* 38 */       !Character.isUnicodeIdentifierPart(i = paramLightInlineParser.getInput().charAt(i - 1)) && i != 45 && i != 46) {
/* 39 */       bool = true;
/*    */     }
/*    */     BasedSequence[] arrayOfBasedSequence;
/* 42 */     if (bool && (
/*    */       
/* 44 */       arrayOfBasedSequence = paramLightInlineParser.matchWithGroups(GITHUB_USER)) != null) {
/* 45 */       paramLightInlineParser.flushTextNode();
/*    */       
/* 47 */       BasedSequence basedSequence2 = arrayOfBasedSequence[1];
/* 48 */       BasedSequence basedSequence1 = arrayOfBasedSequence[2];
/*    */       
/* 50 */       GfmUser gfmUser = new GfmUser(basedSequence2, basedSequence1);
/* 51 */       paramLightInlineParser.getBlock().appendChild((Node)gfmUser);
/* 52 */       return true;
/*    */     } 
/*    */     
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements InlineParserExtensionFactory
/*    */   {
/*    */     public Set<Class<?>> getAfterDependents() {
/* 62 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public CharSequence getCharacters() {
/* 68 */       return "@";
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 74 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 80 */       return new GfmUsersInlineParserExtension(param1LightInlineParser);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 85 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gf\\users\internal\GfmUsersInlineParserExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */