/*     */ package com.vladsch.flexmark.ext.macros.internal;
/*     */ import com.vladsch.flexmark.ext.gitlab.internal.GitLabBlockQuoteParser;
/*     */ import com.vladsch.flexmark.ext.macros.MacroDefinitionBlock;
/*     */ import com.vladsch.flexmark.ext.macros.MacrosExtension;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class MacroDefinitionBlockParser extends AbstractBlockParser {
/*  25 */   static Pattern MACRO_BLOCK_START = Pattern.compile(">>>([\\w_-]+)(\\s*$)");
/*  26 */   static Pattern MACRO_BLOCK_START_INTELLIJ = Pattern.compile(">>>([\037\\w_-]+)(\\s*$)");
/*  27 */   static Pattern MACRO_BLOCK_END = Pattern.compile("<<<(\\s*$)");
/*     */   
/*  29 */   private final MacroDefinitionBlock block = new MacroDefinitionBlock();
/*  30 */   private BlockContent content = new BlockContent();
/*     */   private boolean hadClose = false;
/*     */   
/*     */   MacroDefinitionBlockParser(DataHolder paramDataHolder, BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/*  34 */     this.block.setOpeningMarker(paramBasedSequence1);
/*  35 */     this.block.setName(paramBasedSequence2);
/*  36 */     this.block.setOpeningTrailing(paramBasedSequence3);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  41 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  46 */     if (this.hadClose) {
/*  47 */       return BlockContinue.none();
/*     */     }
/*     */     
/*  50 */     int i = paramParserState.getIndex();
/*     */     
/*  52 */     BasedSequence basedSequence = paramParserState.getLineWithEOL();
/*     */     Matcher matcher;
/*  54 */     if (!(matcher = MACRO_BLOCK_END.matcher((CharSequence)basedSequence)).matches()) {
/*  55 */       return BlockContinue.atIndex(i);
/*     */     }
/*     */     
/*     */     Node node;
/*  59 */     if (node = this.block.getLastChild() instanceof GitLabBlockQuote)
/*     */     {
/*  61 */       if (((GitLabBlockQuote)node).getClosingMarker().isEmpty())
/*     */       {
/*  63 */         return BlockContinue.atIndex(i);
/*     */       }
/*     */     }
/*  66 */     this.hadClose = true;
/*  67 */     this.block.setClosingMarker(paramParserState.getLine().subSequence(i, i + 3));
/*  68 */     this.block.setClosingTrailing(paramParserState.getLineWithEOL().subSequence(matcher.start(1), matcher.end(1)));
/*  69 */     return BlockContinue.atIndex(paramParserState.getLineEndIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  75 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  80 */     this.block.setContent(this.content);
/*  81 */     this.block.setCharsFromContent();
/*  82 */     this.content = null;
/*     */ 
/*     */     
/*  85 */     this.block.setCharsFromContent();
/*     */     
/*     */     MacroDefinitionRepository macroDefinitionRepository;
/*     */     
/*  89 */     (macroDefinitionRepository = (MacroDefinitionRepository)MacrosExtension.MACRO_DEFINITIONS.get((DataHolder)paramParserState.getProperties())).put(macroDefinitionRepository.normalizeKey((CharSequence)this.block.getName()), this.block);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  99 */     return true;
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
/* 110 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 116 */       return new HashSet<>(Collections.singletonList(GitLabBlockQuoteParser.Factory.class));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 123 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 129 */       return (BlockParserFactory)new MacroDefinitionBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 135 */       super(param1DataHolder);
/*     */     }
/*     */     
/*     */     boolean haveBlockQuoteParser(ParserState param1ParserState) {
/*     */       List<?> list;
/* 140 */       int i = (list = param1ParserState.getActiveBlockParsers()).size();
/* 141 */       while (i-- > 0) {
/* 142 */         if (list.get(i) instanceof MacroDefinitionBlockParser) return true; 
/*     */       } 
/* 144 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 149 */       if (param1ParserState.getIndex() == 0 && !haveBlockQuoteParser(param1ParserState)) {
/* 150 */         BasedSequence basedSequence = param1ParserState.getLineWithEOL();
/*     */         Matcher matcher;
/* 152 */         if ((matcher = ((param1ParserState.getParsing()).intellijDummyIdentifier ? MacroDefinitionBlockParser.MACRO_BLOCK_START_INTELLIJ : MacroDefinitionBlockParser.MACRO_BLOCK_START).matcher((CharSequence)basedSequence)).matches()) {
/* 153 */           return BlockStart.of(new BlockParser[] { (BlockParser)new MacroDefinitionBlockParser((DataHolder)param1ParserState.getProperties(), basedSequence.subSequence(0, 3), basedSequence.subSequence(matcher.start(1), matcher.end(1)), basedSequence.subSequence(matcher.start(2), matcher.end(1)))
/* 154 */               }).atIndex(param1ParserState.getLineEndIndex());
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 159 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\internal\MacroDefinitionBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */