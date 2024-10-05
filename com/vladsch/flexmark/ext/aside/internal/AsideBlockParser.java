/*     */ package com.vladsch.flexmark.ext.aside.internal;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.ext.aside.AsideBlock;
/*     */ import com.vladsch.flexmark.ext.aside.AsideExtension;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.parser.core.IndentedCodeBlockParser;
/*     */ import com.vladsch.flexmark.parser.core.ThematicBreakParser;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInStartsWithCharsHandler;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class AsideBlockParser extends AbstractBlockParser {
/*  26 */   private final AsideBlock block = new AsideBlock(); public static final char MARKER_CHAR = '|';
/*     */   private final boolean allowLeadingSpace;
/*     */   private final boolean continueToBlankLine;
/*     */   private final boolean ignoreBlankLine;
/*     */   private final boolean interruptsParagraph;
/*     */   private final boolean interruptsItemParagraph;
/*     */   private final boolean withLeadSpacesInterruptsItemParagraph;
/*  33 */   private int lastWasBlankLine = 0;
/*     */   
/*     */   public AsideBlockParser(DataHolder paramDataHolder, BasedSequence paramBasedSequence) {
/*  36 */     this.block.setOpeningMarker(paramBasedSequence);
/*  37 */     this.continueToBlankLine = ((Boolean)AsideExtension.EXTEND_TO_BLANK_LINE.get(paramDataHolder)).booleanValue();
/*  38 */     this.allowLeadingSpace = ((Boolean)AsideExtension.ALLOW_LEADING_SPACE.get(paramDataHolder)).booleanValue();
/*  39 */     this.ignoreBlankLine = ((Boolean)AsideExtension.IGNORE_BLANK_LINE.get(paramDataHolder)).booleanValue();
/*  40 */     this.interruptsParagraph = ((Boolean)AsideExtension.INTERRUPTS_PARAGRAPH.get(paramDataHolder)).booleanValue();
/*  41 */     this.interruptsItemParagraph = ((Boolean)AsideExtension.INTERRUPTS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/*  42 */     this.withLeadSpacesInterruptsItemParagraph = ((Boolean)AsideExtension.WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  47 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPropagatingLastBlankLine(BlockParser paramBlockParser) {
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  57 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AsideBlock getBlock() {
/*  62 */     return this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  67 */     this.block.setCharsFromContent();
/*     */     
/*  69 */     if (!((Boolean)Parser.BLANK_LINES_IN_AST.get((DataHolder)paramParserState.getProperties())).booleanValue()) {
/*  70 */       removeBlankLines();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  76 */     int i = paramParserState.getNextNonSpaceIndex();
/*     */     boolean bool;
/*  78 */     if (!paramParserState.isBlank() && ((bool = isMarker(paramParserState, i, false, false, this.allowLeadingSpace, this.interruptsParagraph, this.interruptsItemParagraph, this.withLeadSpacesInterruptsItemParagraph)) || (this.continueToBlankLine && this.lastWasBlankLine == 0))) {
/*  79 */       int j = paramParserState.getColumn() + paramParserState.getIndent();
/*  80 */       this.lastWasBlankLine = 0;
/*     */       
/*  82 */       if (bool) {
/*  83 */         j++;
/*     */         
/*  85 */         if (Parsing.isSpaceOrTab((CharSequence)paramParserState.getLine(), i + 1)) {
/*  86 */           j++;
/*     */         }
/*     */       } 
/*  89 */       return BlockContinue.atColumn(j);
/*     */     } 
/*  91 */     if (this.ignoreBlankLine && paramParserState.isBlank()) {
/*  92 */       this.lastWasBlankLine++;
/*     */       int j;
/*  94 */       return BlockContinue.atColumn(j = paramParserState.getColumn() + paramParserState.getIndent());
/*     */     } 
/*  96 */     return BlockContinue.none();
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
/* 110 */     BasedSequence basedSequence = paramParserState.getLine();
/* 111 */     if ((!paramBoolean1 || paramBoolean4) && paramInt < basedSequence.length() && basedSequence.charAt(paramInt) == '|' && (
/* 112 */       paramBoolean3 || paramParserState.getIndent() == 0) && (!paramBoolean2 || paramBoolean5)) {
/* 113 */       if (paramBoolean2 && !paramBoolean6) {
/* 114 */         return (paramParserState.getIndent() == 0);
/*     */       }
/* 116 */       return (paramParserState.getIndent() < (paramParserState.getParsing()).CODE_BLOCK_INDENT);
/*     */     } 
/*     */ 
/*     */     
/* 120 */     return false;
/*     */   }
/*     */   
/*     */   static boolean endsWithMarker(BasedSequence paramBasedSequence) {
/*     */     int i;
/* 125 */     if ((i = paramBasedSequence.countTrailing(CharPredicate.WHITESPACE_NBSP)) + 1 < paramBasedSequence.length() && paramBasedSequence.charAt(paramBasedSequence.length() - i - 1) == '|') return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*     */       HashSet<Class<?>> hashSet;
/* 135 */       return hashSet = new HashSet<>();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 141 */       return new HashSet<>(Arrays.asList(new Class[] { HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class }));
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
/* 154 */       return AsideBlockParser.AsideLeadInHandler.HANDLER;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 159 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 165 */       return (BlockParserFactory)new AsideBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   static class AsideLeadInHandler {
/* 170 */     static final SpecialLeadInHandler HANDLER = (SpecialLeadInHandler)SpecialLeadInStartsWithCharsHandler.create('|');
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final boolean allowLeadingSpace;
/*     */     private final boolean interruptsParagraph;
/*     */     private final boolean interruptsItemParagraph;
/*     */     private final boolean withLeadSpacesInterruptsItemParagraph;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 180 */       super(param1DataHolder);
/* 181 */       this.allowLeadingSpace = ((Boolean)AsideExtension.ALLOW_LEADING_SPACE.get(param1DataHolder)).booleanValue();
/* 182 */       this.interruptsParagraph = ((Boolean)AsideExtension.INTERRUPTS_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 183 */       this.interruptsItemParagraph = ((Boolean)AsideExtension.INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 184 */       this.withLeadSpacesInterruptsItemParagraph = ((Boolean)AsideExtension.WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/*     */     }
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 188 */       int j = param1ParserState.getNextNonSpaceIndex();
/*     */       BlockParser blockParser;
/*     */       boolean bool;
/* 191 */       int i = ((bool = (blockParser = param1MatchedBlockParser.getBlockParser()).isParagraphParser()) && blockParser.getBlock().getParent() instanceof com.vladsch.flexmark.ast.ListItem && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild()) ? 1 : 0;
/*     */       
/* 193 */       if (!AsideBlockParser.endsWithMarker(param1ParserState.getLine()) && AsideBlockParser.isMarker(param1ParserState, j, bool, i, this.allowLeadingSpace, this.interruptsParagraph, this.interruptsItemParagraph, this.withLeadSpacesInterruptsItemParagraph)) {
/* 194 */         i = param1ParserState.getColumn() + param1ParserState.getIndent() + 1;
/*     */         
/* 196 */         if (Parsing.isSpaceOrTab((CharSequence)param1ParserState.getLine(), j + 1)) {
/* 197 */           i++;
/*     */         }
/* 199 */         return BlockStart.of(new BlockParser[] { (BlockParser)new AsideBlockParser((DataHolder)param1ParserState.getProperties(), param1ParserState.getLine().subSequence(j, j + 1)) }).atColumn(i);
/*     */       } 
/* 201 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\aside\internal\AsideBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */