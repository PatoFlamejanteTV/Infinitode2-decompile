/*     */ package com.vladsch.flexmark.ext.abbreviation.internal;
/*     */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationBlock;
/*     */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class AbbreviationBlockParser extends AbstractBlockParser {
/*  18 */   static Pattern ABBREVIATION_BLOCK = Pattern.compile("^\\*\\[\\s*.*\\s*\\]:");
/*     */   
/*  20 */   final AbbreviationBlock block = new AbbreviationBlock();
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  24 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  29 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  34 */     throw new IllegalStateException("Abbreviation Blocks hold a single line");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*     */     AbbreviationRepository abbreviationRepository;
/*  41 */     (abbreviationRepository = (AbbreviationRepository)AbbreviationExtension.ABBREVIATIONS.get((DataHolder)paramParserState.getProperties())).put(abbreviationRepository.normalizeKey((CharSequence)this.block.getText()), this.block);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  58 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  64 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/*  69 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/*  75 */       return (BlockParserFactory)new AbbreviationBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     BlockFactory(DataHolder param1DataHolder) {
/*  81 */       super(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/*  86 */       if (param1ParserState.getIndent() >= 4) {
/*  87 */         return BlockStart.none();
/*     */       }
/*     */       
/*  90 */       BasedSequence basedSequence1 = param1ParserState.getLine();
/*  91 */       int i = param1ParserState.getNextNonSpaceIndex();
/*     */       
/*  93 */       BasedSequence basedSequence2 = basedSequence1.subSequence(i, basedSequence1.length());
/*     */       Matcher matcher;
/*  95 */       if ((matcher = AbbreviationBlockParser.ABBREVIATION_BLOCK.matcher((CharSequence)basedSequence2)).find()) {
/*     */         
/*  97 */         int j = i + matcher.start();
/*  98 */         i += matcher.end();
/*  99 */         BasedSequence basedSequence5 = basedSequence2.subSequence(j, j + 2);
/* 100 */         BasedSequence basedSequence4 = (BasedSequence)basedSequence2.subSequence(j + 2, i - 2).trim();
/* 101 */         BasedSequence basedSequence3 = basedSequence2.subSequence(i - 2, i);
/*     */         
/*     */         AbbreviationBlockParser abbreviationBlockParser;
/* 104 */         (abbreviationBlockParser = new AbbreviationBlockParser()).block.setOpeningMarker(basedSequence5);
/* 105 */         abbreviationBlockParser.block.setText(basedSequence4);
/* 106 */         abbreviationBlockParser.block.setClosingMarker(basedSequence3);
/* 107 */         abbreviationBlockParser.block.setAbbreviation((BasedSequence)((BasedSequence)basedSequence2.subSequence(matcher.end())).trim());
/* 108 */         abbreviationBlockParser.block.setCharsFromContent();
/*     */         
/* 110 */         return BlockStart.of(new BlockParser[] { (BlockParser)abbreviationBlockParser
/* 111 */             }).atIndex(basedSequence1.length());
/*     */       } 
/* 113 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\internal\AbbreviationBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */