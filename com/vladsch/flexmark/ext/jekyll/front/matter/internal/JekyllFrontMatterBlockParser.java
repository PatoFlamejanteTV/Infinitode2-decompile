/*     */ package com.vladsch.flexmark.ext.jekyll.front.matter.internal;
/*     */ import com.vladsch.flexmark.ext.jekyll.front.matter.JekyllFrontMatterBlock;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class JekyllFrontMatterBlockParser extends AbstractBlockParser {
/*  19 */   static final Pattern JEKYLL_FRONT_MATTER_BLOCK_START = Pattern.compile("^-{3}(\\s.*)?");
/*  20 */   static final Pattern JEKYLL_FRONT_MATTER_BLOCK_END = Pattern.compile("^(-{3}|\\.{3})(\\s.*)?");
/*     */   
/*  22 */   private final JekyllFrontMatterBlock block = new JekyllFrontMatterBlock();
/*  23 */   private BlockContent content = new BlockContent();
/*     */   private boolean inYAMLBlock;
/*     */   
/*     */   JekyllFrontMatterBlockParser(DataHolder paramDataHolder, BasedSequence paramBasedSequence) {
/*  27 */     this.inYAMLBlock = true;
/*  28 */     this.block.setOpeningMarker(paramBasedSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  33 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  38 */     BasedSequence basedSequence = paramParserState.getLine();
/*  39 */     if (this.inYAMLBlock) {
/*     */       Matcher matcher;
/*  41 */       if ((matcher = JEKYLL_FRONT_MATTER_BLOCK_END.matcher((CharSequence)basedSequence)).matches()) {
/*  42 */         this.block.setClosingMarker(basedSequence.subSequence(matcher.start(1), matcher.end(1)));
/*  43 */         return BlockContinue.finished();
/*     */       } 
/*  45 */       return BlockContinue.atIndex(paramParserState.getIndex());
/*  46 */     }  if (JEKYLL_FRONT_MATTER_BLOCK_START.matcher((CharSequence)basedSequence).matches()) {
/*  47 */       this.inYAMLBlock = true;
/*  48 */       return BlockContinue.atIndex(paramParserState.getIndex());
/*     */     } 
/*  50 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  55 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  60 */     this.block.setContent(this.content.getLines().subList(1, this.content.getLineCount()));
/*  61 */     this.block.setCharsFromContent();
/*  62 */     this.content = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {}
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  73 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  79 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/*  84 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/*  90 */       return (BlockParserFactory)new JekyllFrontMatterBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     BlockFactory(DataHolder param1DataHolder) {
/*  96 */       super(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 101 */       BasedSequence basedSequence = param1ParserState.getLine(); BlockParser blockParser;
/*     */       Matcher matcher;
/* 103 */       if (blockParser = param1MatchedBlockParser.getBlockParser() instanceof com.vladsch.flexmark.parser.core.DocumentBlockParser && blockParser.getBlock().getFirstChild() == null && (
/*     */         
/* 105 */         matcher = JekyllFrontMatterBlockParser.JEKYLL_FRONT_MATTER_BLOCK_START.matcher((CharSequence)basedSequence)).matches()) {
/* 106 */         BasedSequence basedSequence1 = basedSequence.subSequence(0, 3);
/* 107 */         JekyllFrontMatterBlockParser jekyllFrontMatterBlockParser = new JekyllFrontMatterBlockParser((DataHolder)param1ParserState.getProperties(), basedSequence1);
/* 108 */         return BlockStart.of(new BlockParser[] { (BlockParser)jekyllFrontMatterBlockParser }).atIndex(-1);
/*     */       } 
/*     */ 
/*     */       
/* 112 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\front\matter\internal\JekyllFrontMatterBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */