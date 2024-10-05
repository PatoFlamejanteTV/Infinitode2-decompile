/*    */ package com.vladsch.flexmark.ext.definition.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionItem;
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionList;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.BlockPreProcessor;
/*    */ import com.vladsch.flexmark.parser.block.BlockPreProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.block.ParserState;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ public class DefinitionListBlockPreProcessor
/*    */   implements BlockPreProcessor
/*    */ {
/*    */   private final DefinitionOptions options;
/*    */   
/*    */   public DefinitionListBlockPreProcessor(DataHolder paramDataHolder) {
/* 23 */     this.options = new DefinitionOptions(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void preProcess(ParserState paramParserState, Block paramBlock) {
/* 28 */     Boolean bool = (Boolean)Parser.BLANK_LINES_IN_AST.get((DataHolder)paramParserState.getProperties());
/*    */     
/* 30 */     if (paramBlock instanceof DefinitionList) {
/*    */       DefinitionList definitionList;
/*    */       
/* 33 */       boolean bool1 = (definitionList = (DefinitionList)paramBlock).isTight();
/* 34 */       if (this.options.autoLoose && bool1) {
/* 35 */         ReversiblePeekingIterator<Node> reversiblePeekingIterator = definitionList.getChildren().iterator(); label20: while (true) { Node node; while (true) { if (reversiblePeekingIterator.hasNext()) {
/* 36 */               if (node = reversiblePeekingIterator.next() instanceof DefinitionItem)
/* 37 */               { if (((DefinitionItem)node).isLoose())
/* 38 */                 { bool1 = false;
/* 39 */                   if (bool.booleanValue())
/*    */                     break;  break label20; }  break; }  continue;
/*    */             }  break label20; }
/* 42 */            if (bool.booleanValue())
/*    */           {
/* 44 */             node.moveTrailingBlankLines();
/*    */           } }
/*    */ 
/*    */ 
/*    */         
/* 49 */         definitionList.setTight(bool1);
/*    */       } 
/*    */       
/* 52 */       if (bool.booleanValue()) {
/* 53 */         definitionList.moveTrailingBlankLines();
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements BlockPreProcessorFactory
/*    */   {
/*    */     public Set<Class<? extends Block>> getBlockTypes() {
/*    */       HashSet<Class<DefinitionList>> hashSet;
/* 63 */       (hashSet = new HashSet<>()).add(DefinitionList.class);
/* 64 */       return (Set)hashSet;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getAfterDependents() {
/*    */       HashSet<Class<DefinitionListItemBlockPreProcessor.Factory>> hashSet;
/* 71 */       (hashSet = new HashSet<>()).add(DefinitionListItemBlockPreProcessor.Factory.class);
/* 72 */       return hashSet;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 78 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 83 */       return true;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public BlockPreProcessor apply(ParserState param1ParserState) {
/* 89 */       return new DefinitionListBlockPreProcessor((DataHolder)param1ParserState.getProperties());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\internal\DefinitionListBlockPreProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */