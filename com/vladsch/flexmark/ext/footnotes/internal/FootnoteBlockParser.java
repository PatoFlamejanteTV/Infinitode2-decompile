/*     */ package com.vladsch.flexmark.ext.footnotes.internal;
/*     */ import com.vladsch.flexmark.ext.footnotes.FootnoteBlock;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class FootnoteBlockParser extends AbstractBlockParser {
/*  18 */   static String FOOTNOTE_ID = ".*";
/*  19 */   static Pattern FOOTNOTE_ID_PATTERN = Pattern.compile("\\[\\^\\s*(" + FOOTNOTE_ID + ")\\s*\\]");
/*  20 */   static Pattern FOOTNOTE_DEF_PATTERN = Pattern.compile("^\\[\\^\\s*(" + FOOTNOTE_ID + ")\\s*\\]:");
/*     */   
/*  22 */   private final FootnoteBlock block = new FootnoteBlock();
/*     */   private final FootnoteOptions options;
/*     */   private final int contentOffset;
/*  25 */   private BlockContent content = new BlockContent();
/*     */   
/*     */   public FootnoteBlockParser(FootnoteOptions paramFootnoteOptions, int paramInt) {
/*  28 */     this.options = paramFootnoteOptions;
/*  29 */     this.contentOffset = paramInt;
/*     */   }
/*     */   
/*     */   public BlockContent getBlockContent() {
/*  33 */     return this.content;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  38 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  43 */     int i = paramParserState.getNextNonSpaceIndex();
/*  44 */     if (paramParserState.isBlank()) {
/*  45 */       if (this.block.getFirstChild() == null)
/*     */       {
/*  47 */         return BlockContinue.none();
/*     */       }
/*  49 */       return BlockContinue.atIndex(i);
/*     */     } 
/*     */ 
/*     */     
/*  53 */     if (paramParserState.getIndent() >= this.options.contentIndent) {
/*     */       int j;
/*  55 */       return BlockContinue.atIndex(j = paramParserState.getIndex() + this.options.contentIndent);
/*     */     } 
/*  57 */     return BlockContinue.none();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  63 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  69 */     this.block.setCharsFromContent();
/*  70 */     this.block.setFootnote((BasedSequence)((BasedSequence)this.block.getChars().subSequence(this.block.getClosingMarker().getEndOffset() - this.block.getStartOffset())).trimStart());
/*     */     
/*     */     FootnoteRepository footnoteRepository;
/*  73 */     (footnoteRepository = (FootnoteRepository)FootnoteExtension.FOOTNOTES.get((DataHolder)paramParserState.getProperties())).put(footnoteRepository.normalizeKey((CharSequence)this.block.getText()), this.block);
/*  74 */     this.content = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/*  91 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Class<?>> getBeforeDependents() {
/*  97 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 102 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 108 */       return (BlockParserFactory)new FootnoteBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final FootnoteOptions options;
/*     */     
/*     */     private BlockFactory(DataHolder param1DataHolder) {
/* 116 */       super(param1DataHolder);
/* 117 */       this.options = new FootnoteOptions(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 122 */       if (param1ParserState.getIndent() >= 4) {
/* 123 */         return BlockStart.none();
/*     */       }
/*     */       
/* 126 */       BasedSequence basedSequence1 = param1ParserState.getLine();
/* 127 */       int i = param1ParserState.getNextNonSpaceIndex();
/*     */       
/* 129 */       BasedSequence basedSequence2 = basedSequence1.subSequence(i, basedSequence1.length());
/*     */       Matcher matcher;
/* 131 */       if ((matcher = FootnoteBlockParser.FOOTNOTE_DEF_PATTERN.matcher((CharSequence)basedSequence2)).find()) {
/*     */         
/* 133 */         int j = i + matcher.start();
/* 134 */         i += matcher.end();
/* 135 */         BasedSequence basedSequence3 = basedSequence1.subSequence(j, j + 2);
/* 136 */         BasedSequence basedSequence4 = (BasedSequence)basedSequence1.subSequence(j + 2, i - 2).trim();
/* 137 */         basedSequence1 = basedSequence1.subSequence(i - 2, i);
/*     */         
/* 139 */         int k = this.options.contentIndent;
/*     */         
/*     */         FootnoteBlockParser footnoteBlockParser;
/* 142 */         (footnoteBlockParser = new FootnoteBlockParser(this.options, k)).block.setOpeningMarker(basedSequence3);
/* 143 */         footnoteBlockParser.block.setText(basedSequence4);
/* 144 */         footnoteBlockParser.block.setClosingMarker(basedSequence1);
/*     */         
/* 146 */         return BlockStart.of(new BlockParser[] { (BlockParser)footnoteBlockParser
/* 147 */             }).atIndex(i);
/*     */       } 
/* 149 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\internal\FootnoteBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */