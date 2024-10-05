/*     */ package com.vladsch.flexmark.ext.definition.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.ext.definition.DefinitionItem;
/*     */ import com.vladsch.flexmark.ext.definition.DefinitionList;
/*     */ import com.vladsch.flexmark.ext.definition.DefinitionTerm;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockPreProcessor;
/*     */ import com.vladsch.flexmark.parser.block.BlockPreProcessorFactory;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.parser.core.ParagraphParser;
/*     */ import com.vladsch.flexmark.util.ast.BlankLine;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class DefinitionListItemBlockPreProcessor
/*     */   implements BlockPreProcessor
/*     */ {
/*     */   private final DefinitionOptions options;
/*     */   Boolean blankLinesInAst;
/*     */   
/*     */   public DefinitionListItemBlockPreProcessor(DataHolder paramDataHolder) {
/*  32 */     this.options = new DefinitionOptions(paramDataHolder);
/*  33 */     this.blankLinesInAst = (Boolean)Parser.BLANK_LINES_IN_AST.get(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void preProcess(ParserState paramParserState, Block paramBlock) {
/*  38 */     if (paramBlock instanceof DefinitionItem) {
/*     */ 
/*     */       
/*  41 */       DefinitionItem definitionItem = (DefinitionItem)paramBlock;
/*  42 */       Node node1 = paramBlock.getPreviousAnyNot(new Class[] { BlankLine.class });
/*     */       
/*  44 */       DefinitionList definitionList = new DefinitionList();
/*     */       
/*     */       Node node2;
/*  47 */       if (node2 = definitionItem.getNext() instanceof BlankLine) {
/*  48 */         node2.extractChainTo((Node)definitionList);
/*     */       }
/*     */       
/*  51 */       if (node1 instanceof Paragraph) {
/*  52 */         boolean bool; Paragraph paragraph = (Paragraph)node1;
/*  53 */         node1 = node1.getNext();
/*     */         
/*  55 */         Node node3 = paragraph.getPreviousAnyNot(new Class[] { BlankLine.class });
/*  56 */         Node node4 = paragraph.getPrevious();
/*  57 */         Block block = paragraph.getParent();
/*     */         
/*  59 */         definitionItem.unlink();
/*  60 */         paragraph.unlink();
/*  61 */         paramParserState.blockRemovedWithChildren((Block)paragraph);
/*     */ 
/*     */         
/*  64 */         if (this.options.doubleBlankLineBreaksList) {
/*     */ 
/*     */           
/*  67 */           BasedSequence basedSequence = (node3 == null) ? BasedSequence.NULL : BasedSequence.of(node3.baseSubSequence(node3.getEndOffset(), paragraph.getStartOffset()).normalizeEOL());
/*  68 */           bool = (node3 instanceof DefinitionList && basedSequence.countLeading(CharPredicate.EOL) < 2);
/*     */         } else {
/*  70 */           bool = node3 instanceof DefinitionList;
/*     */         } 
/*     */         
/*     */         DefinitionList definitionList1;
/*  74 */         (definitionList1 = new DefinitionList()).setTight(true);
/*     */         
/*  76 */         List list = paragraph.getContentLines();
/*     */ 
/*     */         
/*  79 */         byte b = 0;
/*  80 */         for (BasedSequence basedSequence : list) {
/*  81 */           DefinitionTerm definitionTerm = new DefinitionTerm();
/*     */           
/*  83 */           ParagraphParser paragraphParser = new ParagraphParser();
/*     */           BlockContent blockContent;
/*  85 */           (blockContent = new BlockContent()).add(basedSequence, paragraph.getLineIndent(b++));
/*  86 */           paragraphParser.getBlock().setContent(blockContent);
/*  87 */           paragraphParser.getBlock().setCharsFromContent();
/*     */           
/*  89 */           definitionTerm.appendChild((Node)paragraphParser.getBlock());
/*  90 */           definitionTerm.setCharsFromContent();
/*     */           
/*  92 */           paramParserState.blockParserAdded((BlockParser)paragraphParser);
/*     */           
/*  94 */           definitionList1.appendChild((Node)definitionTerm);
/*  95 */           paramParserState.blockAdded((Block)definitionTerm);
/*     */         } 
/*     */ 
/*     */         
/*  99 */         if (this.blankLinesInAst.booleanValue() && node1 instanceof BlankLine) {
/* 100 */           while (node1 instanceof BlankLine) {
/* 101 */             Node node = node1.getNext();
/* 102 */             node1.unlink();
/* 103 */             definitionList1.appendChild(node1);
/* 104 */             node1 = node;
/*     */           } 
/*     */         }
/*     */         
/* 108 */         definitionList1.appendChild((Node)definitionItem);
/* 109 */         definitionList1.takeChildren((Node)definitionList);
/*     */         
/* 111 */         if (bool) {
/*     */           DefinitionList definitionList2;
/* 113 */           (definitionList2 = (DefinitionList)node3).takeChildren((Node)definitionList1);
/* 114 */           for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = definitionList1.getChildren().iterator(); reversiblePeekingIterator.hasNext(); ) {
/* 115 */             Node node; (node = reversiblePeekingIterator.next()).unlink();
/* 116 */             definitionList2.appendChild(node);
/* 117 */             paramParserState.blockAddedWithChildren((Block)node);
/*     */           } 
/*     */           
/* 120 */           definitionList2.setCharsFromContent();
/*     */         } else {
/*     */           
/* 123 */           if (node3 != null) {
/* 124 */             node4.insertAfter((Node)definitionList1);
/*     */           }
/* 126 */           else if (block.getFirstChild() != null) {
/* 127 */             block.getFirstChild().insertBefore((Node)definitionList1);
/*     */           } else {
/* 129 */             block.appendChild((Node)definitionList1);
/*     */           } 
/*     */ 
/*     */           
/* 133 */           definitionList1.setCharsFromContent();
/* 134 */           paramParserState.blockAddedWithChildren((Block)definitionList1); return;
/*     */         } 
/* 136 */       } else if (node1 instanceof DefinitionList) {
/* 137 */         DefinitionList definitionList1 = (DefinitionList)node1;
/* 138 */         definitionItem.unlink();
/*     */         
/* 140 */         definitionList1.appendChild((Node)definitionItem);
/* 141 */         definitionList1.takeChildren((Node)definitionList);
/* 142 */         definitionList1.setCharsFromContent();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements BlockPreProcessorFactory
/*     */   {
/*     */     public Set<Class<? extends Block>> getBlockTypes() {
/*     */       HashSet<Class<DefinitionItem>> hashSet;
/* 152 */       (hashSet = new HashSet<>()).add(DefinitionItem.class);
/* 153 */       return (Set)hashSet;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getAfterDependents() {
/* 159 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 165 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 170 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockPreProcessor apply(ParserState param1ParserState) {
/* 176 */       return new DefinitionListItemBlockPreProcessor((DataHolder)param1ParserState.getProperties());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\internal\DefinitionListItemBlockPreProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */