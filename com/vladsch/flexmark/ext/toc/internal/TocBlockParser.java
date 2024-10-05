/*     */ package com.vladsch.flexmark.ext.toc.internal;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.ext.toc.TocBlock;
/*     */ import com.vladsch.flexmark.ext.toc.TocExtension;
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
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class TocBlockParser extends AbstractBlockParser {
/*     */   private final TocBlock block;
/*     */   
/*     */   static class TocParsing extends Parsing {
/*     */     public TocParsing(DataHolder param1DataHolder) {
/*  26 */       super(param1DataHolder);
/*  27 */       if (((Boolean)TocExtension.CASE_SENSITIVE_TOC_TAG.get(param1DataHolder)).booleanValue()) {
/*  28 */         this.TOC_BLOCK_START = Pattern.compile("^\\[TOC(?:\\s+([^\\]]+))?]\\s*$");
/*     */         return;
/*     */       } 
/*  31 */       this.TOC_BLOCK_START = Pattern.compile("^\\[(?i:TOC)(?:\\s+([^\\]]+))?]\\s*$");
/*     */     }
/*     */ 
/*     */     
/*     */     final Pattern TOC_BLOCK_START;
/*     */   }
/*     */   
/*     */   TocBlockParser(DataHolder paramDataHolder, BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2) {
/*  39 */     this.block = new TocBlock(paramBasedSequence1, paramBasedSequence2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  44 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  49 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  71 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  77 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/*  82 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/*  88 */       return (BlockParserFactory)new TocBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final TocBlockParser.TocParsing myParsing;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/*  96 */       super(param1DataHolder);
/*  97 */       this.myParsing = new TocBlockParser.TocParsing(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 102 */       if (param1ParserState.getIndent() >= 4) {
/* 103 */         return BlockStart.none();
/*     */       }
/* 105 */       BasedSequence basedSequence1 = param1ParserState.getLine();
/* 106 */       int i = param1ParserState.getNextNonSpaceIndex();
/* 107 */       BasedSequence basedSequence2 = basedSequence1.subSequence(i, basedSequence1.length());
/*     */       Matcher matcher;
/* 109 */       if ((matcher = this.myParsing.TOC_BLOCK_START.matcher((CharSequence)basedSequence1)).matches()) {
/* 110 */         BasedSequence basedSequence3 = param1ParserState.getLineWithEOL();
/* 111 */         BasedSequence basedSequence4 = null;
/* 112 */         if (matcher.start(1) != -1) {
/* 113 */           int k = matcher.start(1);
/* 114 */           int j = matcher.end(1);
/* 115 */           basedSequence4 = basedSequence2.subSequence(k, j);
/*     */         } 
/*     */         
/* 118 */         TocBlockParser tocBlockParser = new TocBlockParser((DataHolder)param1ParserState.getProperties(), basedSequence3, basedSequence4);
/* 119 */         return BlockStart.of(new BlockParser[] { (BlockParser)tocBlockParser
/* 120 */             }).atIndex(param1ParserState.getIndex());
/*     */       } 
/*     */ 
/*     */       
/* 124 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\internal\TocBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */