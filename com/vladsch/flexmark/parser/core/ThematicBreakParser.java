/*     */ package com.vladsch.flexmark.parser.core;
/*     */ import com.vladsch.flexmark.ast.ThematicBreak;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class ThematicBreakParser extends AbstractBlockParser {
/*  19 */   static Pattern PATTERN = Pattern.compile("^(?:(?:\\*[ \t]*){3,}|(?:_[ \t]*){3,}|(?:-[ \t]*){3,})[ \t]*$");
/*     */   
/*  21 */   private final ThematicBreak block = new ThematicBreak();
/*     */   
/*     */   public ThematicBreakParser(BasedSequence paramBasedSequence) {
/*  24 */     this.block.setChars(paramBasedSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  29 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  34 */     this.block.setCharsFromContent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  40 */     return BlockContinue.none();
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  47 */       return new HashSet<>(Arrays.asList(new Class[] { BlockQuoteParser.Factory.class, HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class }));
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
/*  61 */       return new HashSet<>(Arrays.asList(new Class[] { ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class }));
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
/*     */     public boolean affectsGlobalScope() {
/*  74 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/*  80 */       return (BlockParserFactory)new ThematicBreakParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final ThematicBreakParser.ThematicBreakOptions options;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/*  88 */       super(param1DataHolder);
/*  89 */       this.options = new ThematicBreakParser.ThematicBreakOptions(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/*  94 */       if (param1ParserState.getIndent() >= 4 || (param1MatchedBlockParser.getBlockParser().isParagraphParser() && !this.options.relaxedStart)) {
/*  95 */         return BlockStart.none();
/*     */       }
/*     */       
/*  98 */       BasedSequence basedSequence1, basedSequence2 = (basedSequence1 = param1ParserState.getLine()).subSequence(param1ParserState.getNextNonSpaceIndex(), basedSequence1.length());
/*  99 */       if (ThematicBreakParser.PATTERN.matcher((CharSequence)basedSequence2).matches()) {
/* 100 */         return BlockStart.of(new BlockParser[] { (BlockParser)new ThematicBreakParser((BasedSequence)basedSequence1.subSequence(param1ParserState.getIndex())) }).atIndex(basedSequence1.length());
/*     */       }
/* 102 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */   
/*     */   static class ThematicBreakOptions
/*     */   {
/*     */     final boolean relaxedStart;
/*     */     
/*     */     public ThematicBreakOptions(DataHolder param1DataHolder) {
/* 111 */       this.relaxedStart = ((Boolean)Parser.THEMATIC_BREAK_RELAXED_START.get(param1DataHolder)).booleanValue();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\ThematicBreakParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */