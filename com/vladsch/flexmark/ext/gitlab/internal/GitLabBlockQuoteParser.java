/*     */ package com.vladsch.flexmark.ext.gitlab.internal;
/*     */ import com.vladsch.flexmark.ext.gitlab.GitLabBlockQuote;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class GitLabBlockQuoteParser extends AbstractBlockParser {
/*  20 */   static Pattern GIT_LAB_BLOCK_START = Pattern.compile(">>>(\\s*$)");
/*  21 */   static Pattern GIT_LAB_BLOCK_END = Pattern.compile(">>>(\\s*$)");
/*     */   
/*  23 */   private final GitLabBlockQuote block = new GitLabBlockQuote();
/*  24 */   private BlockContent content = new BlockContent();
/*     */   private boolean hadClose = false;
/*     */   
/*     */   GitLabBlockQuoteParser(DataHolder paramDataHolder, BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2) {
/*  28 */     this.block.setOpeningMarker(paramBasedSequence1);
/*  29 */     this.block.setOpeningTrailing(paramBasedSequence2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  34 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  39 */     if (this.hadClose) {
/*  40 */       return BlockContinue.none();
/*     */     }
/*     */     
/*  43 */     int i = paramParserState.getIndex();
/*     */     
/*  45 */     BasedSequence basedSequence = paramParserState.getLineWithEOL();
/*     */     Matcher matcher;
/*  47 */     if (!(matcher = GIT_LAB_BLOCK_END.matcher((CharSequence)basedSequence.subSequence(i))).matches()) {
/*  48 */       return BlockContinue.atIndex(i);
/*     */     }
/*     */     Node node;
/*     */     BlockParser blockParser;
/*  52 */     if (node = this.block.getLastChild() instanceof GitLabBlockQuote && 
/*     */       
/*  54 */       blockParser = paramParserState.getActiveBlockParser((Block)node) instanceof GitLabBlockQuoteParser && !((GitLabBlockQuoteParser)blockParser).hadClose)
/*     */     {
/*  56 */       return BlockContinue.atIndex(i);
/*     */     }
/*     */     
/*  59 */     this.hadClose = true;
/*  60 */     this.block.setClosingMarker(paramParserState.getLine().subSequence(i, i + 3));
/*  61 */     this.block.setClosingTrailing(paramParserState.getLineWithEOL().subSequence(matcher.start(1), matcher.end(1)));
/*  62 */     return BlockContinue.atIndex(paramParserState.getLineEndIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  68 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  73 */     this.block.setContent(this.content);
/*  74 */     this.block.setCharsFromContent();
/*  75 */     this.content = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  80 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  85 */     return true;
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
/*  96 */       return null;
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
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 111 */       return null;
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
/* 125 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 131 */       return (BlockParserFactory)new GitLabBlockQuoteParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final GitLabOptions options;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 139 */       super(param1DataHolder);
/* 140 */       this.options = new GitLabOptions(param1DataHolder);
/*     */     }
/*     */     
/*     */     boolean haveBlockQuoteParser(ParserState param1ParserState) {
/*     */       List<?> list;
/* 145 */       int i = (list = param1ParserState.getActiveBlockParsers()).size();
/* 146 */       while (i-- > 0) {
/* 147 */         if (list.get(i) instanceof GitLabBlockQuoteParser) return true; 
/*     */       } 
/* 149 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 155 */       BasedSequence basedSequence = param1ParserState.getLineWithEOL();
/*     */       Matcher matcher;
/* 157 */       if ((this.options.nestedBlockQuotes || !haveBlockQuoteParser(param1ParserState)) && (matcher = GitLabBlockQuoteParser.GIT_LAB_BLOCK_START.matcher((CharSequence)basedSequence)).matches()) {
/* 158 */         return BlockStart.of(new BlockParser[] { (BlockParser)new GitLabBlockQuoteParser((DataHolder)param1ParserState.getProperties(), basedSequence.subSequence(0, 3), basedSequence.subSequence(matcher.start(1), matcher.end(1)))
/* 159 */             }).atIndex(param1ParserState.getLineEndIndex());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 164 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\internal\GitLabBlockQuoteParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */