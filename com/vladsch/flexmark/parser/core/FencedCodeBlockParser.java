/*     */ package com.vladsch.flexmark.parser.core;
/*     */ import com.vladsch.flexmark.ast.CodeBlock;
/*     */ import com.vladsch.flexmark.ast.FencedCodeBlock;
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class FencedCodeBlockParser extends AbstractBlockParser {
/*  25 */   private static final Pattern OPENING_FENCE = Pattern.compile("^`{3,}(?!.*`)|^~{3,}(?!.*~)");
/*  26 */   private static final Pattern CLOSING_FENCE = Pattern.compile("^(?:`{3,}|~{3,})(?=[ \t]*$)");
/*     */   
/*  28 */   private final FencedCodeBlock block = new FencedCodeBlock();
/*  29 */   private BlockContent content = new BlockContent();
/*     */   private final char fenceChar;
/*     */   private final int fenceLength;
/*     */   private final int fenceIndent;
/*     */   private final int fenceMarkerIndent;
/*     */   private final boolean matchingCloser;
/*     */   private final boolean codeContentBlock;
/*     */   
/*     */   public FencedCodeBlockParser(DataHolder paramDataHolder, char paramChar, int paramInt1, int paramInt2, int paramInt3) {
/*  38 */     this.fenceChar = paramChar;
/*  39 */     this.fenceLength = paramInt1;
/*  40 */     this.fenceIndent = paramInt2;
/*  41 */     this.fenceMarkerIndent = paramInt2 + paramInt3;
/*  42 */     this.matchingCloser = ((Boolean)Parser.MATCH_CLOSING_FENCE_CHARACTERS.get(paramDataHolder)).booleanValue();
/*  43 */     this.codeContentBlock = ((Boolean)Parser.FENCED_CODE_CONTENT_BLOCK.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  48 */     return (Block)this.block;
/*     */   }
/*     */   
/*     */   public int getFenceIndent() {
/*  52 */     return this.fenceIndent;
/*     */   }
/*     */   
/*     */   public int getFenceMarkerIndent() {
/*  56 */     return this.fenceMarkerIndent;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*  61 */     int k = paramParserState.getNextNonSpaceIndex();
/*  62 */     int m = paramParserState.getIndex();
/*  63 */     BasedSequence basedSequence2 = paramParserState.getLine();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     BasedSequence basedSequence1 = basedSequence2.subSequence(k, basedSequence2.length()); int i; Matcher matcher;
/*     */     boolean bool;
/*  72 */     if ((bool = (paramParserState.getIndent() <= 3 && k < basedSequence2.length() && (!this.matchingCloser || basedSequence2.charAt(k) == this.fenceChar)) ? true : false) && (matcher = CLOSING_FENCE.matcher((CharSequence)basedSequence1)).find() && (
/*     */ 
/*     */       
/*  75 */       i = matcher.group(0).length()) >= this.fenceLength) {
/*     */       
/*  77 */       this.block.setClosingMarker(basedSequence1.subSequence(0, i));
/*  78 */       return BlockContinue.finished();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  83 */     int j = this.fenceIndent;
/*  84 */     while (j > 0 && m < basedSequence2.length() && basedSequence2.charAt(m) == ' ') {
/*  85 */       m++;
/*  86 */       j--;
/*     */     } 
/*  88 */     return BlockContinue.atIndex(m);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/*  93 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPropagatingLastBlankLine(BlockParser paramBlockParser) {
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*     */     List<?> list;
/* 105 */     if ((list = this.content.getLines()).size() > 0) {
/*     */       BasedSequence basedSequence1;
/* 107 */       if (!(basedSequence1 = (BasedSequence)list.get(0)).isBlank()) {
/* 108 */         this.block.setInfo((BasedSequence)basedSequence1.trim());
/*     */       }
/*     */ 
/*     */       
/* 112 */       BasedSequence basedSequence2 = (basedSequence1 = this.content.getSpanningChars()).baseSubSequence(basedSequence1.getStartOffset(), ((BasedSequence)list.get(0)).getEndOffset());
/*     */       
/* 114 */       if (list.size() > 1) {
/*     */         CodeBlock codeBlock;
/* 116 */         list = list.subList(1, list.size());
/* 117 */         this.block.setContent(basedSequence2, list);
/* 118 */         if (this.codeContentBlock) {
/*     */           
/* 120 */           (codeBlock = new CodeBlock()).setContent(list);
/* 121 */           codeBlock.setCharsFromContent();
/* 122 */           this.block.appendChild((Node)codeBlock);
/*     */         } else {
/* 124 */           Text text = new Text(SegmentedSequence.create((BasedSequence)codeBlock, list));
/* 125 */           this.block.appendChild((Node)text);
/*     */         } 
/*     */       } else {
/* 128 */         this.block.setContent(basedSequence2, BasedSequence.EMPTY_LIST);
/*     */       } 
/*     */     } else {
/* 131 */       this.block.setContent(this.content);
/*     */     } 
/*     */     
/* 134 */     this.block.setCharsFromContent();
/* 135 */     this.content = null;
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 142 */       return new HashSet<>(Arrays.asList(new Class[] { BlockQuoteParser.Factory.class, HeadingParser.Factory.class }));
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
/* 156 */       return new HashSet<>(Arrays.asList(new Class[] { HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class }));
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
/* 169 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 175 */       return (BlockParserFactory)new FencedCodeBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private BlockFactory(DataHolder param1DataHolder) {
/* 181 */       super(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 186 */       int i = param1ParserState.getNextNonSpaceIndex();
/* 187 */       BasedSequence basedSequence1 = param1ParserState.getLine();
/*     */ 
/*     */       
/* 190 */       BasedSequence basedSequence2 = basedSequence1.subSequence(i, basedSequence1.length()); Matcher matcher;
/* 191 */       if (param1ParserState.getIndent() < 4 && (matcher = FencedCodeBlockParser.OPENING_FENCE.matcher((CharSequence)basedSequence2)).find()) {
/* 192 */         int j = matcher.group(0).length();
/* 193 */         char c = matcher.group(0).charAt(0);
/*     */         FencedCodeBlockParser fencedCodeBlockParser;
/* 195 */         (fencedCodeBlockParser = new FencedCodeBlockParser((DataHolder)param1ParserState.getProperties(), c, j, param1ParserState.getIndent(), i)).block.setOpeningMarker(basedSequence2.subSequence(0, j));
/* 196 */         return BlockStart.of(new BlockParser[] { (BlockParser)fencedCodeBlockParser }).atIndex(i + j);
/*     */       } 
/*     */       
/* 199 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\FencedCodeBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */