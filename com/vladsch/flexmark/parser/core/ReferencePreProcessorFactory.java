/*    */ package com.vladsch.flexmark.parser.core;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.block.ParagraphPreProcessor;
/*    */ import com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.block.ParserState;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReferencePreProcessorFactory
/*    */   implements ParagraphPreProcessorFactory
/*    */ {
/*    */   public boolean affectsGlobalScope() {
/* 14 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getAfterDependents() {
/* 20 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<Class<?>> getBeforeDependents() {
/* 26 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public ParagraphPreProcessor apply(ParserState paramParserState) {
/* 31 */     return (ParagraphPreProcessor)paramParserState.getInlineParser();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\ReferencePreProcessorFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */