/*     */ package com.vladsch.flexmark.ext.attributes.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ext.attributes.AttributeNode;
/*     */ import com.vladsch.flexmark.ext.attributes.AttributesDelimiter;
/*     */ import com.vladsch.flexmark.ext.attributes.AttributesNode;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.parser.InlineParserExtension;
/*     */ import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
/*     */ import com.vladsch.flexmark.parser.LightInlineParser;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ 
/*     */ public class AttributesInlineParserExtension
/*     */   implements InlineParserExtension
/*     */ {
/*     */   private final AttributeParsing parsing;
/*     */   
/*     */   public AttributesInlineParserExtension(LightInlineParser paramLightInlineParser) {
/*  21 */     this.parsing = new AttributeParsing(paramLightInlineParser.getParsing());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void finalizeDocument(InlineParser paramInlineParser) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void finalizeBlock(InlineParser paramInlineParser) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean parse(LightInlineParser paramLightInlineParser) {
/*  36 */     int i = paramLightInlineParser.getIndex();
/*  37 */     BasedSequence basedSequence = paramLightInlineParser.getInput();
/*     */     Matcher matcher;
/*  39 */     if (paramLightInlineParser.peek(1) != '{' && (matcher = paramLightInlineParser.matcher(this.parsing.ATTRIBUTES_TAG)) != null) {
/*  40 */       Matcher matcher1; AttributeNode attributeNode; BasedSequence basedSequence1 = basedSequence.subSequence(matcher.start(), matcher.end());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  48 */       (matcher = ((basedSequence = basedSequence.subSequence(matcher.start(1), matcher.end(1))).equals("#") || basedSequence.equals(".")) ? (Matcher)new AttributesDelimiter(basedSequence1.subSequence(0, 1), basedSequence, (BasedSequence)basedSequence1.endSequence(1)) : (Matcher)new AttributesNode(basedSequence1.subSequence(0, 1), basedSequence, (BasedSequence)basedSequence1.endSequence(1))).setCharsFromContent();
/*     */       
/*  50 */       paramLightInlineParser.flushTextNode();
/*  51 */       paramLightInlineParser.getBlock().appendChild((Node)matcher);
/*     */ 
/*     */       
/*  54 */       if (!(basedSequence = (BasedSequence)basedSequence.trim()).isEmpty()) {
/*     */ 
/*     */         
/*  57 */         matcher1 = this.parsing.ATTRIBUTE.matcher((CharSequence)basedSequence);
/*  58 */         while (matcher1.find()) {
/*  59 */           BasedSequence basedSequence2 = basedSequence.subSequence(matcher1.start(1), matcher1.end(1));
/*  60 */           basedSequence1 = (matcher1.groupCount() == 1 || matcher1.start(2) == -1) ? BasedSequence.NULL : (BasedSequence)basedSequence.subSequence(matcher1.end(1), matcher1.start(2)).trim();
/*     */           BasedSequence basedSequence3;
/*     */           boolean bool;
/*  63 */           BasedSequence basedSequence4 = !(bool = ((basedSequence3 = (matcher1.groupCount() == 1 || matcher1.start(2) == -1) ? BasedSequence.NULL : basedSequence.subSequence(matcher1.start(2), matcher1.end(2))).length() >= 2 && ((basedSequence3.charAt(0) == '"' && basedSequence3.endCharAt(1) == '"') || (basedSequence3.charAt(0) == '\'' && basedSequence3.endCharAt(1) == '\''))) ? true : false) ? BasedSequence.NULL : basedSequence3.subSequence(0, 1);
/*  64 */           BasedSequence basedSequence5 = !bool ? BasedSequence.NULL : (BasedSequence)basedSequence3.endSequence(1, 0);
/*     */           
/*  66 */           if (bool) {
/*  67 */             basedSequence3 = (BasedSequence)basedSequence3.midSequence(1, -1);
/*     */           }
/*     */ 
/*     */           
/*  71 */           if (basedSequence1.isNull() && basedSequence3.isNull() && AttributeNode.isImplicitName((CharSequence)basedSequence2)) {
/*  72 */             attributeNode = new AttributeNode(basedSequence2.subSequence(0, 1), basedSequence1, basedSequence4, (BasedSequence)basedSequence2.subSequence(1), basedSequence5);
/*     */           } else {
/*  74 */             attributeNode = new AttributeNode((BasedSequence)attributeNode, basedSequence1, basedSequence4, basedSequence3, basedSequence5);
/*     */           } 
/*  76 */           matcher.appendChild((Node)attributeNode);
/*     */         } 
/*     */         
/*  79 */         return true;
/*     */       } 
/*     */ 
/*     */       
/*  83 */       matcher1.setIndex(attributeNode);
/*     */     } 
/*     */     
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements InlineParserExtensionFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  93 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence getCharacters() {
/*  99 */       return "{";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 105 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public InlineParserExtension apply(LightInlineParser param1LightInlineParser) {
/* 111 */       return new AttributesInlineParserExtension(param1LightInlineParser);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 116 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\attributes\internal\AttributesInlineParserExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */