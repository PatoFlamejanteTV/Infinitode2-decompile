/*     */ package com.vladsch.flexmark.parser.core;
/*     */ import com.vladsch.flexmark.ast.HtmlBlockBase;
/*     */ import com.vladsch.flexmark.ast.HtmlInnerBlock;
/*     */ import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.parser.internal.HtmlDeepParser;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class HtmlBlockParser extends AbstractBlockParser {
/*     */   public static final String HTML_COMMENT_OPEN = "<!--";
/*     */   public static final String HTML_COMMENT_CLOSE = "-->";
/*     */   private final HtmlBlockBase block;
/*     */   private final Pattern closingPattern;
/*     */   private final HtmlDeepParser deepParser;
/*     */   
/*     */   private static class Patterns {
/*  34 */     public final int COMMENT_PATTERN_INDEX = 2; public final Pattern[][] BLOCK_PATTERNS;
/*     */     
/*     */     public Patterns(Parsing param1Parsing, DataHolder param1DataHolder) {
/*  37 */       StringBuilder stringBuilder = new StringBuilder();
/*  38 */       String str1 = "";
/*  39 */       for (String str : Parser.HTML_BLOCK_TAGS.get(param1DataHolder)) {
/*  40 */         stringBuilder.append(str1)
/*  41 */           .append("\\Q")
/*  42 */           .append(str)
/*  43 */           .append("\\E");
/*  44 */         str1 = "|";
/*     */       } 
/*     */       
/*     */       boolean bool;
/*  48 */       if (bool = ((Boolean)Parser.HTML_FOR_TRANSLATOR.get(param1DataHolder)).booleanValue()) {
/*  49 */         stringBuilder.append(str1)
/*  50 */           .append((String)Parser.TRANSLATION_HTML_BLOCK_TAG_PATTERN.get(param1DataHolder));
/*     */       }
/*     */ 
/*     */       
/*  54 */       String str2 = stringBuilder.toString();
/*     */       
/*  56 */       this
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
/*     */ 
/*     */         
/*  83 */         .BLOCK_PATTERNS = new Pattern[][] { { null, null }, { Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2) }, { Pattern.compile("^<!--"), Pattern.compile("-->") }, { Pattern.compile("^<[?]"), Pattern.compile("\\?>") }, { Pattern.compile("^<![A-Z]"), Pattern.compile(">") }, { Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>") }, { Pattern.compile("^</?(?:" + str2 + ")(?:\\s|[/]?[>]|$)", 2), null }, { Pattern.compile("^(?:" + param1Parsing.OPENTAG + '|' + param1Parsing.CLOSETAG + ")\\s*$", 2), null } };
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean finished = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   private BlockContent content = new BlockContent();
/*     */   private final boolean parseInnerHtmlComments;
/*     */   private final boolean myHtmlBlockDeepParseNonBlock;
/*     */   private final boolean myHtmlBlockDeepParseBlankLineInterrupts;
/*     */   private final boolean myHtmlBlockDeepParseMarkdownInterruptsClosed;
/*     */   private final boolean myHtmlBlockDeepParseBlankLineInterruptsPartialTag;
/*     */   private final boolean myHtmlBlockDeepParseIndentedCodeInterrupts;
/*     */   
/*     */   HtmlBlockParser(DataHolder paramDataHolder, Pattern paramPattern, boolean paramBoolean, HtmlDeepParser paramHtmlDeepParser) {
/* 104 */     this.closingPattern = paramPattern;
/* 105 */     this.block = paramBoolean ? (HtmlBlockBase)new HtmlCommentBlock() : (HtmlBlockBase)new HtmlBlock();
/* 106 */     this.deepParser = paramHtmlDeepParser;
/* 107 */     this.parseInnerHtmlComments = ((Boolean)Parser.PARSE_INNER_HTML_COMMENTS.get(paramDataHolder)).booleanValue();
/*     */     
/* 109 */     this.myHtmlBlockDeepParseNonBlock = ((Boolean)Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK.get(paramDataHolder)).booleanValue();
/* 110 */     this.myHtmlBlockDeepParseBlankLineInterrupts = ((Boolean)Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS.get(paramDataHolder)).booleanValue();
/* 111 */     this.myHtmlBlockDeepParseMarkdownInterruptsClosed = ((Boolean)Parser.HTML_BLOCK_DEEP_PARSE_MARKDOWN_INTERRUPTS_CLOSED.get(paramDataHolder)).booleanValue();
/* 112 */     this.myHtmlBlockDeepParseBlankLineInterruptsPartialTag = ((Boolean)Parser.HTML_BLOCK_DEEP_PARSE_BLANK_LINE_INTERRUPTS_PARTIAL_TAG.get(paramDataHolder)).booleanValue();
/* 113 */     this.myHtmlBlockDeepParseIndentedCodeInterrupts = ((Boolean)Parser.HTML_BLOCK_DEEP_PARSE_INDENTED_CODE_INTERRUPTS.get(paramDataHolder)).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/* 119 */     return (Block)this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/* 124 */     if (this.deepParser != null) {
/* 125 */       if (paramParserState.isBlank() && (
/* 126 */         this.deepParser.isHtmlClosed() || (this.myHtmlBlockDeepParseBlankLineInterrupts && !this.deepParser.haveOpenRawTag()) || (this.myHtmlBlockDeepParseBlankLineInterruptsPartialTag && this.deepParser.isBlankLineInterruptible()))) {
/* 127 */         return BlockContinue.none();
/*     */       }
/*     */ 
/*     */       
/* 131 */       return BlockContinue.atIndex(paramParserState.getIndex());
/*     */     } 
/* 133 */     if (this.finished) {
/* 134 */       return BlockContinue.none();
/*     */     }
/*     */ 
/*     */     
/* 138 */     if (paramParserState.isBlank() && this.closingPattern == null) {
/* 139 */       return BlockContinue.none();
/*     */     }
/* 141 */     return BlockContinue.atIndex(paramParserState.getIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {
/* 148 */     if (this.deepParser != null) {
/* 149 */       if (this.content.getLineCount() > 0)
/*     */       {
/* 151 */         this.deepParser.parseHtmlChunk((CharSequence)paramBasedSequence, false, this.myHtmlBlockDeepParseNonBlock, false);
/*     */       }
/*     */     }
/* 154 */     else if (this.closingPattern != null && this.closingPattern.matcher((CharSequence)paramBasedSequence).find()) {
/* 155 */       this.finished = true;
/*     */     } 
/*     */ 
/*     */     
/* 159 */     this.content.add(paramBasedSequence, paramParserState.getIndent());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canInterruptBy(BlockParserFactory paramBlockParserFactory) {
/* 164 */     if (this.myHtmlBlockDeepParseMarkdownInterruptsClosed && this.deepParser != null && !(paramBlockParserFactory instanceof Factory) && (this.myHtmlBlockDeepParseIndentedCodeInterrupts || !(paramBlockParserFactory instanceof IndentedCodeBlockParser.BlockFactory)) && this.deepParser
/*     */ 
/*     */ 
/*     */       
/* 168 */       .isHtmlClosed()) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/* 173 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInterruptible() {
/* 178 */     return (this.myHtmlBlockDeepParseMarkdownInterruptsClosed && this.deepParser != null && this.deepParser.isHtmlClosed());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRawText() {
/* 183 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/* 188 */     this.block.setContent(this.content);
/* 189 */     this.content = null;
/*     */ 
/*     */     
/* 192 */     if (!(this.block instanceof HtmlCommentBlock) && this.parseInnerHtmlComments) {
/*     */       
/* 194 */       int i = 0;
/*     */       BasedSequence basedSequence;
/* 196 */       if ((basedSequence = this.block.getContentChars()).eolEndLength() > 0) basedSequence = (BasedSequence)basedSequence.midSequence(0, -1);
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
/*     */       
/* 210 */       int j = basedSequence.length();
/* 211 */       while (i < j) {
/*     */         int k;
/*     */         
/* 214 */         if ((k = basedSequence.indexOf("<!--", i)) >= 0) {
/*     */           int m;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 220 */           if ((m = basedSequence.indexOf("-->", k + 4)) >= 0) {
/*     */             
/* 222 */             if (i < k) {
/* 223 */               HtmlInnerBlock htmlInnerBlock = new HtmlInnerBlock(basedSequence.subSequence(i, k));
/* 224 */               this.block.appendChild((Node)htmlInnerBlock);
/*     */             } 
/*     */             
/* 227 */             i = m + 3;
/* 228 */             HtmlInnerBlockComment htmlInnerBlockComment = new HtmlInnerBlockComment(basedSequence.subSequence(k, i));
/* 229 */             this.block.appendChild((Node)htmlInnerBlockComment);
/*     */           } 
/*     */         } 
/* 232 */       }  if (i > 0 && 
/* 233 */         i < basedSequence.length()) {
/* 234 */         HtmlInnerBlock htmlInnerBlock = new HtmlInnerBlock(basedSequence.subSequence(i, basedSequence.length()));
/* 235 */         this.block.appendChild((Node)htmlInnerBlock);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 245 */       return new HashSet<>(Arrays.asList(new Class[] { BlockQuoteParser.Factory.class, HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class }));
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
/* 259 */       return new HashSet<>(Arrays.asList(new Class[] { ThematicBreakParser.Factory.class, ListBlockParser.Factory.class, IndentedCodeBlockParser.Factory.class }));
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
/* 272 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 278 */       return (BlockParserFactory)new HtmlBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/* 283 */     private HtmlBlockParser.Patterns myPatterns = null;
/*     */     private final boolean myHtmlCommentBlocksInterruptParagraph;
/*     */     private final boolean myHtmlBlockDeepParser;
/*     */     private final boolean myHtmlBlockDeepParseNonBlock;
/*     */     private final boolean myHtmlBlockDeepParseFirstOpenTagOnOneLine;
/*     */     private final boolean myHtmlBlockCommentOnlyFullLine;
/*     */     private final boolean myHtmlBlockStartOnlyOnBlockTags;
/*     */     
/*     */     private BlockFactory(DataHolder param1DataHolder) {
/* 292 */       super(param1DataHolder);
/* 293 */       this.myHtmlCommentBlocksInterruptParagraph = ((Boolean)Parser.HTML_COMMENT_BLOCKS_INTERRUPT_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 294 */       this.myHtmlBlockDeepParser = ((Boolean)Parser.HTML_BLOCK_DEEP_PARSER.get(param1DataHolder)).booleanValue();
/* 295 */       this.myHtmlBlockDeepParseNonBlock = ((Boolean)Parser.HTML_BLOCK_DEEP_PARSE_NON_BLOCK.get(param1DataHolder)).booleanValue();
/* 296 */       this.myHtmlBlockDeepParseFirstOpenTagOnOneLine = ((Boolean)Parser.HTML_BLOCK_DEEP_PARSE_FIRST_OPEN_TAG_ON_ONE_LINE.get(param1DataHolder)).booleanValue();
/* 297 */       this.myHtmlBlockCommentOnlyFullLine = ((Boolean)Parser.HTML_BLOCK_COMMENT_ONLY_FULL_LINE.get(param1DataHolder)).booleanValue();
/* 298 */       this.myHtmlBlockStartOnlyOnBlockTags = ((Boolean)Parser.HTML_BLOCK_START_ONLY_ON_BLOCK_TAGS.get(param1DataHolder)).booleanValue();
/*     */     }
/*     */ 
/*     */     
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/* 303 */       int i = param1ParserState.getNextNonSpaceIndex();
/* 304 */       BasedSequence basedSequence = param1ParserState.getLine();
/*     */       
/* 306 */       if (param1ParserState.getIndent() < 4 && basedSequence.charAt(i) == '<' && !(param1MatchedBlockParser.getBlockParser() instanceof HtmlBlockParser))
/* 307 */         if (this.myHtmlBlockDeepParser) {
/*     */           HtmlDeepParser htmlDeepParser;
/* 309 */           (htmlDeepParser = new HtmlDeepParser((List)Parser.HTML_BLOCK_TAGS.get((DataHolder)param1ParserState.getProperties()))).parseHtmlChunk((CharSequence)basedSequence.subSequence(i, basedSequence.length()), this.myHtmlBlockStartOnlyOnBlockTags, this.myHtmlBlockDeepParseNonBlock, this.myHtmlBlockDeepParseFirstOpenTagOnOneLine);
/* 310 */           if (htmlDeepParser.hadHtml())
/*     */           {
/* 312 */             if ((htmlDeepParser.getHtmlMatch() != HtmlDeepParser.HtmlMatch.OPEN_TAG && (this.myHtmlCommentBlocksInterruptParagraph || htmlDeepParser.getHtmlMatch() != HtmlDeepParser.HtmlMatch.COMMENT)) || htmlDeepParser
/* 313 */               .isFirstBlockTag() || !(param1MatchedBlockParser.getBlockParser().getBlock() instanceof com.vladsch.flexmark.ast.Paragraph))
/*     */             {
/*     */               
/* 316 */               return BlockStart.of(new BlockParser[] { (BlockParser)new HtmlBlockParser((DataHolder)param1ParserState.getProperties(), null, (htmlDeepParser.getHtmlMatch() == HtmlDeepParser.HtmlMatch.COMMENT), htmlDeepParser) }).atIndex(param1ParserState.getIndex());
/*     */             }
/*     */           }
/*     */         } else {
/* 320 */           for (byte b = 1; b <= 7; b++) {
/*     */             
/* 322 */             if (b != 7 || (!this.myHtmlBlockStartOnlyOnBlockTags && !(param1MatchedBlockParser.getBlockParser().getBlock() instanceof com.vladsch.flexmark.ast.Paragraph))) {
/*     */ 
/*     */ 
/*     */               
/* 326 */               if (this.myPatterns == null) {
/* 327 */                 this.myPatterns = new HtmlBlockParser.Patterns(param1ParserState.getParsing(), (DataHolder)param1ParserState.getProperties());
/*     */               }
/*     */               
/* 330 */               Pattern pattern1 = this.myPatterns.BLOCK_PATTERNS[b][0];
/* 331 */               Pattern pattern2 = this.myPatterns.BLOCK_PATTERNS[b][1];
/*     */               
/*     */               Matcher matcher;
/*     */               
/*     */               boolean bool;
/* 336 */               if ((bool = (matcher = pattern1.matcher((CharSequence)basedSequence.subSequence(i, basedSequence.length()))).find()) && (this.myHtmlCommentBlocksInterruptParagraph || b != this.myPatterns.COMMENT_PATTERN_INDEX || !(param1MatchedBlockParser.getBlockParser() instanceof ParagraphParser))) {
/*     */                 Matcher matcher1;
/* 338 */                 if (b == this.myPatterns.COMMENT_PATTERN_INDEX && this.myHtmlBlockCommentOnlyFullLine && (
/*     */                   
/* 340 */                   matcher1 = this.myPatterns.BLOCK_PATTERNS[this.myPatterns.COMMENT_PATTERN_INDEX][1].matcher((CharSequence)basedSequence.subSequence(matcher.end(), basedSequence.length()))).find()) {
/*     */                   BasedSequence basedSequence1;
/*     */                   
/* 343 */                   if (!(basedSequence1 = (BasedSequence)basedSequence.subSequence(matcher1.end(), basedSequence.length()).trim()).equals("-->")) {
/* 344 */                     return BlockStart.none();
/*     */                   }
/*     */                 } 
/*     */                 
/* 348 */                 return BlockStart.of(new BlockParser[] { (BlockParser)new HtmlBlockParser((DataHolder)param1ParserState.getProperties(), pattern2, (b == this.myPatterns.COMMENT_PATTERN_INDEX), null) }).atIndex(param1ParserState.getIndex());
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }  
/* 353 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\HtmlBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */