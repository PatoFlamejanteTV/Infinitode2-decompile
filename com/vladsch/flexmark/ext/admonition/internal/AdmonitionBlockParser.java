/*     */ package com.vladsch.flexmark.ext.admonition.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.ext.admonition.AdmonitionBlock;
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
/*     */ import java.util.Set;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class AdmonitionBlockParser
/*     */   extends AbstractBlockParser {
/*     */   private static final String ADMONITION_START_FORMAT = "^(\\?{3}\\+|\\?{3}|!{3})\\s+(%s)(?:\\s+(%s))?\\s*$";
/*     */   final AdmonitionBlock block;
/*     */   
/*     */   AdmonitionBlockParser(AdmonitionOptions paramAdmonitionOptions, int paramInt) {
/*  29 */     this.options = paramAdmonitionOptions;
/*  30 */     this.contentIndent = paramInt;
/*  31 */     this.block = new AdmonitionBlock();
/*     */   }
/*     */   private final AdmonitionOptions options; private final int contentIndent; private boolean hadBlankLine;
/*     */   private int getContentIndent() {
/*  35 */     return this.contentIndent;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  40 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  45 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  50 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  55 */     int i = paramParserState.getNextNonSpaceIndex();
/*  56 */     if (paramParserState.isBlank()) {
/*  57 */       this.hadBlankLine = true;
/*  58 */       return BlockContinue.atIndex(i);
/*  59 */     }  if (!this.hadBlankLine && this.options.allowLazyContinuation)
/*  60 */       return BlockContinue.atIndex(i); 
/*  61 */     if (paramParserState.getIndent() >= this.options.contentIndent) {
/*     */       int j;
/*  63 */       return BlockContinue.atColumn(j = paramParserState.getColumn() + this.options.contentIndent);
/*     */     } 
/*  65 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  71 */     this.block.setCharsFromContent();
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  78 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  84 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public SpecialLeadInHandler getLeadInHandler(DataHolder param1DataHolder) {
/*  89 */       return AdmonitionBlockParser.AdmonitionLeadInHandler.HANDLER;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/*  94 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 100 */       return (BlockParserFactory)new AdmonitionBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   static class AdmonitionLeadInHandler implements SpecialLeadInHandler {
/* 105 */     static final SpecialLeadInHandler HANDLER = new AdmonitionLeadInHandler();
/*     */ 
/*     */     
/*     */     public boolean escape(BasedSequence param1BasedSequence, DataHolder param1DataHolder, Consumer<CharSequence> param1Consumer) {
/* 109 */       if ((param1BasedSequence.length() == 3 || (param1BasedSequence.length() == 4 && param1BasedSequence.charAt(3) == '+')) && (param1BasedSequence.startsWith("???") || param1BasedSequence.startsWith("!!!"))) {
/* 110 */         param1Consumer.accept("\\");
/* 111 */         param1Consumer.accept(param1BasedSequence);
/* 112 */         return true;
/*     */       } 
/* 114 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean unEscape(BasedSequence param1BasedSequence, DataHolder param1DataHolder, Consumer<CharSequence> param1Consumer) {
/* 119 */       if ((param1BasedSequence.length() == 4 || (param1BasedSequence.length() == 5 && param1BasedSequence.charAt(4) == '+')) && (param1BasedSequence.startsWith("\\???") || param1BasedSequence.startsWith("\\!!!"))) {
/* 120 */         param1Consumer.accept(param1BasedSequence.subSequence(1));
/* 121 */         return true;
/*     */       } 
/* 123 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isMarker(ParserState paramParserState, int paramInt, boolean paramBoolean1, boolean paramBoolean2, AdmonitionOptions paramAdmonitionOptions) {
/* 134 */     boolean bool1 = paramAdmonitionOptions.allowLeadingSpace;
/* 135 */     boolean bool3 = paramAdmonitionOptions.interruptsParagraph;
/* 136 */     boolean bool4 = paramAdmonitionOptions.interruptsItemParagraph;
/* 137 */     boolean bool2 = paramAdmonitionOptions.withSpacesInterruptsItemParagraph;
/* 138 */     paramParserState.getLine();
/* 139 */     if ((!paramBoolean1 || bool3) && (
/* 140 */       bool1 || paramParserState.getIndent() == 0) && (!paramBoolean2 || bool4)) {
/* 141 */       if (paramBoolean2 && !bool2) {
/* 142 */         return (paramParserState.getIndent() == 0);
/*     */       }
/* 144 */       return (paramParserState.getIndent() < (paramParserState.getParsing()).CODE_BLOCK_INDENT);
/*     */     } 
/*     */ 
/*     */     
/* 148 */     return false;
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final AdmonitionOptions options;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 155 */       super(param1DataHolder);
/* 156 */       this.options = new AdmonitionOptions(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 161 */       if (param1ParserState.getIndent() >= 4) {
/* 162 */         return BlockStart.none();
/*     */       }
/*     */       
/* 165 */       int i = param1ParserState.getNextNonSpaceIndex();
/*     */       BlockParser blockParser;
/*     */       boolean bool1;
/* 168 */       boolean bool = ((bool1 = (blockParser = param1MatchedBlockParser.getBlockParser()).isParagraphParser()) && blockParser.getBlock().getParent() instanceof com.vladsch.flexmark.ast.ListItem && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild()) ? true : false;
/*     */       
/* 170 */       if (AdmonitionBlockParser.isMarker(param1ParserState, i, bool1, bool, this.options)) {
/*     */         
/* 172 */         BasedSequence basedSequence1, basedSequence2 = (basedSequence1 = param1ParserState.getLine()).subSequence(i, basedSequence1.length());
/* 173 */         Parsing parsing = param1ParserState.getParsing();
/*     */         
/*     */         Matcher matcher;
/*     */         Pattern pattern;
/* 177 */         if ((matcher = (pattern = Pattern.compile(String.format("^(\\?{3}\\+|\\?{3}|!{3})\\s+(%s)(?:\\s+(%s))?\\s*$", new Object[] { parsing.ATTRIBUTENAME, parsing.LINK_TITLE_STRING }))).matcher((CharSequence)basedSequence2)).find()) {
/*     */           
/* 179 */           basedSequence2 = basedSequence1.subSequence(i + matcher.start(1), i + matcher.end(1));
/* 180 */           BasedSequence basedSequence4 = basedSequence1.subSequence(i + matcher.start(2), i + matcher.end(2));
/* 181 */           BasedSequence basedSequence3 = (matcher.group(3) == null) ? BasedSequence.NULL : basedSequence1.subSequence(i + matcher.start(3), i + matcher.end(3));
/*     */           
/* 183 */           i = this.options.contentIndent;
/*     */           
/*     */           AdmonitionBlockParser admonitionBlockParser;
/* 186 */           (admonitionBlockParser = new AdmonitionBlockParser(this.options, i)).block.setOpeningMarker(basedSequence2);
/* 187 */           admonitionBlockParser.block.setInfo(basedSequence4);
/* 188 */           admonitionBlockParser.block.setTitleChars(basedSequence3);
/*     */           
/* 190 */           return BlockStart.of(new BlockParser[] { (BlockParser)admonitionBlockParser
/* 191 */               }).atIndex(basedSequence1.length());
/*     */         } 
/* 193 */         return BlockStart.none();
/*     */       } 
/*     */       
/* 196 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\admonition\internal\AdmonitionBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */