/*     */ package com.vladsch.flexmark.parser.core;
/*     */ import com.vladsch.flexmark.ast.CodeBlock;
/*     */ import com.vladsch.flexmark.ast.IndentedCodeBlock;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class IndentedCodeBlockParser extends AbstractBlockParser {
/*  20 */   private final IndentedCodeBlock block = new IndentedCodeBlock();
/*  21 */   private BlockContent content = new BlockContent();
/*     */   private final boolean trimTrailingBlankLines;
/*     */   private final boolean codeContentBlock;
/*     */   
/*     */   public IndentedCodeBlockParser(DataHolder paramDataHolder) {
/*  26 */     this.trimTrailingBlankLines = ((Boolean)Parser.INDENTED_CODE_NO_TRAILING_BLANK_LINES.get(paramDataHolder)).booleanValue();
/*  27 */     this.codeContentBlock = ((Boolean)Parser.FENCED_CODE_CONTENT_BLOCK.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  32 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  37 */     if (paramParserState.getIndent() >= (paramParserState.getParsing()).CODE_BLOCK_INDENT)
/*  38 */       return BlockContinue.atColumn(paramParserState.getColumn() + (paramParserState.getParsing()).CODE_BLOCK_INDENT); 
/*  39 */     if (paramParserState.isBlank()) {
/*  40 */       return BlockContinue.atIndex(paramParserState.getNextNonSpaceIndex());
/*     */     }
/*  42 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  48 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  54 */     if (this.trimTrailingBlankLines)
/*  55 */     { byte b = 0;
/*  56 */       List list = this.content.getLines(); BasedSequence basedSequence;
/*  57 */       for (ReversibleIterator<BasedSequence> reversibleIterator = (new Reverse(list)).iterator(); reversibleIterator.hasNext() && (
/*  58 */         basedSequence = reversibleIterator.next()).isBlank();) {
/*  59 */         b++;
/*     */       }
/*     */       
/*  62 */       if (b > 0) { this.block.setContent(list.subList(0, list.size() - b)); }
/*  63 */       else { this.block.setContent(this.content); }
/*     */        }
/*  65 */     else { this.block.setContent(this.content); }
/*     */ 
/*     */     
/*  68 */     if (this.codeContentBlock) {
/*  69 */       CodeBlock codeBlock = new CodeBlock(this.block.getChars(), this.block.getContentLines());
/*  70 */       this.block.appendChild((Node)codeBlock);
/*     */     } 
/*  72 */     this.content = null;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  79 */       return new HashSet<>(Arrays.asList(new Class[] { BlockQuoteParser.Factory.class, HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  93 */       return Collections.emptySet();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 107 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 113 */       return (BlockParserFactory)new IndentedCodeBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private BlockFactory(DataHolder param1DataHolder) {
/* 119 */       super(param1DataHolder);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 125 */       if (param1ParserState.getIndent() >= (param1ParserState.getParsing()).CODE_BLOCK_INDENT && !param1ParserState.isBlank() && !(param1ParserState.getActiveBlockParser().getBlock() instanceof com.vladsch.flexmark.ast.Paragraph)) {
/* 126 */         return BlockStart.of(new BlockParser[] { (BlockParser)new IndentedCodeBlockParser((DataHolder)param1ParserState.getProperties()) }).atColumn(param1ParserState.getColumn() + (param1ParserState.getParsing()).CODE_BLOCK_INDENT);
/*     */       }
/* 128 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\IndentedCodeBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */