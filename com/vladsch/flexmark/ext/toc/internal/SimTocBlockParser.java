/*     */ package com.vladsch.flexmark.ext.toc.internal;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.ext.toc.SimTocBlock;
/*     */ import com.vladsch.flexmark.ext.toc.SimTocContent;
/*     */ import com.vladsch.flexmark.ext.toc.SimTocOption;
/*     */ import com.vladsch.flexmark.ext.toc.SimTocOptionList;
/*     */ import com.vladsch.flexmark.ext.toc.TocExtension;
/*     */ import com.vladsch.flexmark.parser.InlineParser;
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
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.options.ParsedOption;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class SimTocBlockParser
/*     */   extends AbstractBlockParser {
/*     */   static class TocParsing extends Parsing {
/*     */     final Pattern TOC_BLOCK_START;
/*     */     
/*     */     public TocParsing(DataHolder param1DataHolder) {
/*  36 */       super(param1DataHolder);
/*  37 */       if (((Boolean)TocExtension.CASE_SENSITIVE_TOC_TAG.get(param1DataHolder)).booleanValue()) {
/*  38 */         this.TOC_BLOCK_START = Pattern.compile("^\\[TOC(?:\\s+([^\\]]+))?]:\\s*#(?:\\s+(" + this.LINK_TITLE_STRING + "))?\\s*$"); return;
/*     */       } 
/*  40 */       this.TOC_BLOCK_START = Pattern.compile("^\\[(?i:TOC)(?:\\s+([^\\]]+))?]:\\s*#(?:\\s+(" + this.LINK_TITLE_STRING + "))?\\s*$");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  45 */   static int HAVE_HTML = 1;
/*  46 */   static int HAVE_HEADING = 2;
/*  47 */   static int HAVE_LIST = 4;
/*  48 */   static int HAVE_BLANK_LINE = 8;
/*     */   
/*     */   private final SimTocBlock block;
/*     */   private final TocOptions options;
/*  52 */   private int haveChildren = 0;
/*  53 */   private BasedSequence blankLineSpacer = BasedSequence.NULL;
/*     */   
/*     */   SimTocBlockParser(DataHolder paramDataHolder, BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/*  56 */     this.options = new TocOptions(paramDataHolder, true);
/*  57 */     this.block = new SimTocBlock(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  62 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  68 */     if ((!this.options.isBlankLineSpacer || this.haveChildren != 0) && paramParserState.isBlank()) {
/*  69 */       return BlockContinue.none();
/*     */     }
/*  71 */     if (paramParserState.isBlank()) {
/*  72 */       this.haveChildren |= HAVE_BLANK_LINE;
/*  73 */       this.blankLineSpacer = paramParserState.getLine();
/*     */     } 
/*  75 */     return BlockContinue.atIndex(paramParserState.getIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  81 */     if (paramBlock instanceof com.vladsch.flexmark.ast.HtmlBlock) {
/*  82 */       if ((this.haveChildren & (HAVE_BLANK_LINE ^ 0xFFFFFFFF)) == 0) {
/*  83 */         this.haveChildren |= HAVE_HTML;
/*  84 */         return true;
/*     */       } 
/*  86 */     } else if (paramBlock instanceof com.vladsch.flexmark.ast.Heading) {
/*  87 */       if ((this.haveChildren & (HAVE_BLANK_LINE ^ 0xFFFFFFFF)) == 0) {
/*  88 */         this.haveChildren |= HAVE_HEADING;
/*  89 */         return true;
/*     */       } 
/*  91 */     } else if (paramBlock instanceof com.vladsch.flexmark.ast.ListBlock && (
/*  92 */       this.haveChildren & (HAVE_HTML | HAVE_LIST)) == 0) {
/*  93 */       this.haveChildren |= HAVE_LIST;
/*  94 */       return true;
/*     */     } 
/*     */     
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/* 112 */     if (this.block.hasChildren()) {
/*     */       SimTocContent simTocContent;
/*     */       
/* 115 */       (simTocContent = new SimTocContent()).takeChildren((Node)this.block);
/* 116 */       simTocContent.setCharsFromContent();
/*     */       
/* 118 */       if (this.blankLineSpacer.isNotNull())
/*     */       {
/* 120 */         simTocContent.setChars(Node.spanningChars(new BasedSequence[] { this.blankLineSpacer, simTocContent.getChars() }));
/*     */       }
/*     */       
/* 123 */       this.block.appendChild((Node)simTocContent);
/* 124 */       this.block.setCharsFromContent();
/* 125 */       paramParserState.blockAddedWithChildren((Block)simTocContent);
/*     */     } 
/*     */     List<?> list;
/*     */     Pair pair;
/*     */     SimTocOptionsParser simTocOptionsParser;
/* 130 */     if (this.options.isAstAddOptions && !this.block.getStyle().isEmpty() && 
/*     */ 
/*     */ 
/*     */       
/* 134 */       !(list = (List)(pair = (simTocOptionsParser = new SimTocOptionsParser()).parseOption(this.block.getStyle(), TocOptions.DEFAULT, null)).getSecond()).isEmpty()) {
/*     */       
/* 136 */       SimTocOptionList simTocOptionList = new SimTocOptionList();
/* 137 */       for (ParsedOption parsedOption : list) {
/* 138 */         SimTocOption simTocOption = new SimTocOption(parsedOption.getSource());
/* 139 */         simTocOptionList.appendChild((Node)simTocOption);
/*     */       } 
/*     */       
/* 142 */       simTocOptionList.setCharsFromContent();
/* 143 */       this.block.prependChild((Node)simTocOptionList);
/*     */     } 
/*     */ 
/*     */     
/* 147 */     this.block.setCharsFromContent();
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
/* 158 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/* 164 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 169 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 175 */       return (BlockParserFactory)new SimTocBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final SimTocBlockParser.TocParsing myParsing;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 183 */       super(param1DataHolder);
/* 184 */       this.myParsing = new SimTocBlockParser.TocParsing(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 189 */       if (param1ParserState.getIndent() >= 4) {
/* 190 */         return BlockStart.none();
/*     */       }
/* 192 */       BasedSequence basedSequence1 = param1ParserState.getLine();
/* 193 */       int i = param1ParserState.getNextNonSpaceIndex();
/* 194 */       BasedSequence basedSequence2 = basedSequence1.subSequence(i, basedSequence1.length());
/*     */       Matcher matcher;
/* 196 */       if ((matcher = this.myParsing.TOC_BLOCK_START.matcher((CharSequence)basedSequence1)).matches()) {
/* 197 */         BasedSequence basedSequence3 = param1ParserState.getLineWithEOL();
/* 198 */         BasedSequence basedSequence4 = null;
/* 199 */         BasedSequence basedSequence5 = null;
/* 200 */         if (matcher.start(1) != -1) {
/* 201 */           basedSequence4 = basedSequence2.subSequence(matcher.start(1), matcher.end(1));
/*     */         }
/*     */         
/* 204 */         if (matcher.start(2) != -1) {
/* 205 */           basedSequence5 = basedSequence2.subSequence(matcher.start(2), matcher.end(2));
/*     */         }
/*     */         
/* 208 */         SimTocBlockParser simTocBlockParser = new SimTocBlockParser((DataHolder)param1ParserState.getProperties(), basedSequence3, basedSequence4, basedSequence5);
/* 209 */         return BlockStart.of(new BlockParser[] { (BlockParser)simTocBlockParser
/* 210 */             }).atIndex(param1ParserState.getLineEndIndex() + param1ParserState.getLineEolLength());
/*     */       } 
/*     */ 
/*     */       
/* 214 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\SimTocBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */