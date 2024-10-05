/*     */ package com.vladsch.flexmark.parser.core;
/*     */ import com.vladsch.flexmark.ast.BlockQuote;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
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
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInStartsWithCharsHandler;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class BlockQuoteParser extends AbstractBlockParser {
/*  24 */   private final BlockQuote block = new BlockQuote(); public static final char MARKER_CHAR = '>';
/*     */   private final boolean allowLeadingSpace;
/*     */   private final boolean continueToBlankLine;
/*     */   private final boolean ignoreBlankLine;
/*     */   private final boolean interruptsParagraph;
/*     */   private final boolean interruptsItemParagraph;
/*     */   private final boolean withLeadSpacesInterruptsItemParagraph;
/*  31 */   private int lastWasBlankLine = 0;
/*     */   
/*     */   public BlockQuoteParser(DataHolder paramDataHolder, BasedSequence paramBasedSequence) {
/*  34 */     this.block.setOpeningMarker(paramBasedSequence);
/*  35 */     this.continueToBlankLine = ((Boolean)Parser.BLOCK_QUOTE_EXTEND_TO_BLANK_LINE.get(paramDataHolder)).booleanValue();
/*  36 */     this.allowLeadingSpace = ((Boolean)Parser.BLOCK_QUOTE_ALLOW_LEADING_SPACE.get(paramDataHolder)).booleanValue();
/*  37 */     this.ignoreBlankLine = ((Boolean)Parser.BLOCK_QUOTE_IGNORE_BLANK_LINE.get(paramDataHolder)).booleanValue();
/*  38 */     this.interruptsParagraph = ((Boolean)Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH.get(paramDataHolder)).booleanValue();
/*  39 */     this.interruptsItemParagraph = ((Boolean)Parser.BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/*  40 */     this.withLeadSpacesInterruptsItemParagraph = ((Boolean)Parser.BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  45 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPropagatingLastBlankLine(BlockParser paramBlockParser) {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockQuote getBlock() {
/*  60 */     return this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  65 */     this.block.setCharsFromContent();
/*     */     
/*  67 */     if (!((Boolean)Parser.BLANK_LINES_IN_AST.get((DataHolder)paramParserState.getProperties())).booleanValue()) {
/*  68 */       removeBlankLines();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  74 */     int i = paramParserState.getNextNonSpaceIndex();
/*     */     boolean bool;
/*  76 */     if (!paramParserState.isBlank() && ((bool = isMarker(paramParserState, i, false, false, this.allowLeadingSpace, this.interruptsParagraph, this.interruptsItemParagraph, this.withLeadSpacesInterruptsItemParagraph)) || (this.continueToBlankLine && this.lastWasBlankLine == 0))) {
/*  77 */       int j = paramParserState.getColumn() + paramParserState.getIndent();
/*  78 */       this.lastWasBlankLine = 0;
/*     */       
/*  80 */       if (bool) {
/*  81 */         j++;
/*     */         
/*  83 */         if (Parsing.isSpaceOrTab((CharSequence)paramParserState.getLine(), i + 1)) {
/*  84 */           j++;
/*     */         }
/*     */       } 
/*  87 */       return BlockContinue.atColumn(j);
/*     */     } 
/*  89 */     if (this.ignoreBlankLine && paramParserState.isBlank()) {
/*  90 */       this.lastWasBlankLine++;
/*     */       int j;
/*  92 */       return BlockContinue.atColumn(j = paramParserState.getColumn() + paramParserState.getIndent());
/*     */     } 
/*  94 */     return BlockContinue.none();
/*     */   }
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
/*     */   static boolean isMarker(ParserState paramParserState, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 108 */     BasedSequence basedSequence = paramParserState.getLine();
/* 109 */     if ((!paramBoolean1 || paramBoolean4) && paramInt < basedSequence.length() && basedSequence.charAt(paramInt) == '>' && (
/* 110 */       paramBoolean3 || paramParserState.getIndent() == 0) && (!paramBoolean2 || paramBoolean5)) {
/* 111 */       if (paramBoolean2 && !paramBoolean6) {
/* 112 */         return (paramParserState.getIndent() == 0);
/*     */       }
/* 114 */       return (paramParserState.getIndent() < (paramParserState.getParsing()).CODE_BLOCK_INDENT);
/*     */     } 
/*     */ 
/*     */     
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 125 */       return Collections.emptySet();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 131 */       return new HashSet<>(Arrays.asList(new Class[] { HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class }));
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
/*     */     public SpecialLeadInHandler getLeadInHandler(DataHolder param1DataHolder) {
/* 144 */       return BlockQuoteParser.BlockQuoteLeadInHandler.HANDLER;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 149 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 155 */       return (BlockParserFactory)new BlockQuoteParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   static class BlockQuoteLeadInHandler {
/* 160 */     static final SpecialLeadInHandler HANDLER = (SpecialLeadInHandler)SpecialLeadInStartsWithCharsHandler.create('>');
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final boolean allowLeadingSpace;
/*     */     private final boolean interruptsParagraph;
/*     */     private final boolean interruptsItemParagraph;
/*     */     private final boolean withLeadSpacesInterruptsItemParagraph;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 170 */       super(param1DataHolder);
/* 171 */       this.allowLeadingSpace = ((Boolean)Parser.BLOCK_QUOTE_ALLOW_LEADING_SPACE.get(param1DataHolder)).booleanValue();
/* 172 */       this.interruptsParagraph = ((Boolean)Parser.BLOCK_QUOTE_INTERRUPTS_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 173 */       this.interruptsItemParagraph = ((Boolean)Parser.BLOCK_QUOTE_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 174 */       this.withLeadSpacesInterruptsItemParagraph = ((Boolean)Parser.BLOCK_QUOTE_WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/*     */     }
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 178 */       int j = param1ParserState.getNextNonSpaceIndex();
/*     */       BlockParser blockParser;
/*     */       boolean bool;
/* 181 */       int i = ((bool = (blockParser = param1MatchedBlockParser.getBlockParser()).isParagraphParser()) && blockParser.getBlock().getParent() instanceof com.vladsch.flexmark.ast.ListItem && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild()) ? 1 : 0;
/*     */       
/* 183 */       if (BlockQuoteParser.isMarker(param1ParserState, j, bool, i, this.allowLeadingSpace, this.interruptsParagraph, this.interruptsItemParagraph, this.withLeadSpacesInterruptsItemParagraph)) {
/* 184 */         i = param1ParserState.getColumn() + param1ParserState.getIndent() + 1;
/*     */         
/* 186 */         if (Parsing.isSpaceOrTab((CharSequence)param1ParserState.getLine(), j + 1)) {
/* 187 */           i++;
/*     */         }
/* 189 */         return BlockStart.of(new BlockParser[] { (BlockParser)new BlockQuoteParser((DataHolder)param1ParserState.getProperties(), param1ParserState.getLine().subSequence(j, j + 1)) }).atColumn(i);
/*     */       } 
/* 191 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\BlockQuoteParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */