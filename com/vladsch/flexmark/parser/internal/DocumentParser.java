/*      */ package com.vladsch.flexmark.parser.internal;
/*      */ import com.vladsch.flexmark.ast.Paragraph;
/*      */ import com.vladsch.flexmark.ast.util.Parsing;
/*      */ import com.vladsch.flexmark.parser.InlineParser;
/*      */ import com.vladsch.flexmark.parser.InlineParserFactory;
/*      */ import com.vladsch.flexmark.parser.Parser;
/*      */ import com.vladsch.flexmark.parser.block.BlockParser;
/*      */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*      */ import com.vladsch.flexmark.parser.block.BlockPreProcessorFactory;
/*      */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*      */ import com.vladsch.flexmark.parser.block.ParagraphPreProcessor;
/*      */ import com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory;
/*      */ import com.vladsch.flexmark.parser.block.ParserPhase;
/*      */ import com.vladsch.flexmark.parser.block.ParserState;
/*      */ import com.vladsch.flexmark.util.ast.BlankLine;
/*      */ import com.vladsch.flexmark.util.ast.Block;
/*      */ import com.vladsch.flexmark.util.ast.Document;
/*      */ import com.vladsch.flexmark.util.ast.Node;
/*      */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
/*      */ import com.vladsch.flexmark.util.data.DataHolder;
/*      */ import com.vladsch.flexmark.util.data.DataKey;
/*      */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*      */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*      */ import java.io.Reader;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class DocumentParser implements ParserState {
/*   33 */   public static final InlineParserFactory INLINE_PARSER_FACTORY = CommonmarkInlineParser::new; private static final HashMap<CustomBlockParserFactory, DataKey<Boolean>> CORE_FACTORIES_DATA_KEYS; private static final HashMap<DataKey<Boolean>, ParagraphPreProcessorFactory> CORE_PARAGRAPH_PRE_PROCESSORS; private BasedSequence line;
/*      */   private BasedSequence lineWithEOL;
/*      */   
/*      */   static {
/*   37 */     (CORE_FACTORIES_DATA_KEYS = new HashMap<>()).put(new BlockQuoteParser.Factory(), Parser.BLOCK_QUOTE_PARSER);
/*   38 */     CORE_FACTORIES_DATA_KEYS.put(new HeadingParser.Factory(), Parser.HEADING_PARSER);
/*   39 */     CORE_FACTORIES_DATA_KEYS.put(new FencedCodeBlockParser.Factory(), Parser.FENCED_CODE_BLOCK_PARSER);
/*   40 */     CORE_FACTORIES_DATA_KEYS.put(new HtmlBlockParser.Factory(), Parser.HTML_BLOCK_PARSER);
/*   41 */     CORE_FACTORIES_DATA_KEYS.put(new ThematicBreakParser.Factory(), Parser.THEMATIC_BREAK_PARSER);
/*   42 */     CORE_FACTORIES_DATA_KEYS.put(new ListBlockParser.Factory(), Parser.LIST_BLOCK_PARSER);
/*   43 */     CORE_FACTORIES_DATA_KEYS.put(new IndentedCodeBlockParser.Factory(), Parser.INDENTED_CODE_BLOCK_PARSER);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   59 */     (CORE_PARAGRAPH_PRE_PROCESSORS = new HashMap<>()).put(Parser.REFERENCE_PARAGRAPH_PRE_PROCESSOR, new ReferencePreProcessorFactory());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   73 */   private int lineNumber = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   78 */   private int lineStart = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   83 */   private int lineEOLIndex = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   88 */   private int lineEndIndex = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   93 */   private int index = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   98 */   private int column = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean columnIsInTab;
/*      */ 
/*      */   
/*  105 */   private int nextNonSpace = 0;
/*  106 */   private int nextNonSpaceColumn = 0;
/*  107 */   private int indent = 0;
/*      */   
/*      */   private boolean blank;
/*      */   private boolean isBlankLine;
/*      */   private final List<BlockParserFactory> blockParserFactories;
/*      */   private final List<List<ParagraphPreProcessorFactory>> paragraphPreProcessorDependencies;
/*      */   private final List<List<BlockPreProcessorFactory>> blockPreProcessorDependencies;
/*      */   private final InlineParser inlineParser;
/*      */   private final DocumentBlockParser documentBlockParser;
/*      */   private final boolean blankLinesInAst;
/*      */   private final boolean trackDocumentLines;
/*  118 */   private final List<BasedSequence> lineSegments = new ArrayList<>();
/*  119 */   private final List<BlockParser> activeBlockParsers = new ArrayList<>();
/*  120 */   private final ClassifyingBlockTracker blockTracker = new ClassifyingBlockTracker();
/*      */ 
/*      */   
/*      */   public List<BasedSequence> getLineSegments() {
/*  124 */     return this.lineSegments;
/*      */   }
/*      */   
/*      */   public void blockParserAdded(BlockParser paramBlockParser) {
/*  128 */     this.blockTracker.blockParserAdded(paramBlockParser);
/*      */   }
/*      */   
/*      */   public void blockParserRemoved(BlockParser paramBlockParser) {
/*  132 */     this.blockTracker.blockParserRemoved(paramBlockParser);
/*      */   }
/*      */   
/*      */   public void blockAdded(Block paramBlock) {
/*  136 */     this.blockTracker.blockAdded(paramBlock);
/*      */   }
/*      */   
/*      */   public void blockAddedWithChildren(Block paramBlock) {
/*  140 */     this.blockTracker.blockAddedWithChildren(paramBlock);
/*      */   }
/*      */   
/*      */   public void blockAddedWithDescendants(Block paramBlock) {
/*  144 */     this.blockTracker.blockAddedWithDescendants(paramBlock);
/*      */   }
/*      */   
/*      */   public void blockRemoved(Block paramBlock) {
/*  148 */     this.blockTracker.blockRemoved(paramBlock);
/*      */   }
/*      */   
/*      */   public void blockRemovedWithChildren(Block paramBlock) {
/*  152 */     this.blockTracker.blockRemovedWithChildren(paramBlock);
/*      */   }
/*      */   
/*      */   public void blockRemovedWithDescendants(Block paramBlock) {
/*  156 */     this.blockTracker.blockRemovedWithDescendants(paramBlock);
/*      */   }
/*      */   
/*  159 */   private final Map<Node, Boolean> lastLineBlank = new HashMap<>();
/*      */   private final DataHolder options;
/*      */   private ParserPhase currentPhase;
/*      */   private final Parsing myParsing;
/*      */   
/*      */   public ParserPhase getParserPhase() {
/*  165 */     return this.currentPhase;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentParser(DataHolder paramDataHolder, List<CustomBlockParserFactory> paramList, List<List<ParagraphPreProcessorFactory>> paramList1, List<List<BlockPreProcessorFactory>> paramList2, InlineParser paramInlineParser) {
/*  177 */     this.options = paramDataHolder;
/*  178 */     this.myParsing = paramInlineParser.getParsing();
/*      */     
/*  180 */     ArrayList<BlockParserFactory> arrayList = new ArrayList(paramList.size());
/*  181 */     for (CustomBlockParserFactory customBlockParserFactory : paramList) {
/*  182 */       arrayList.add(customBlockParserFactory.apply(paramDataHolder));
/*      */     }
/*      */     
/*  185 */     this.blockParserFactories = arrayList;
/*  186 */     this.paragraphPreProcessorDependencies = paramList1;
/*  187 */     this.blockPreProcessorDependencies = paramList2;
/*  188 */     this.inlineParser = paramInlineParser;
/*      */     
/*  190 */     this.documentBlockParser = new DocumentBlockParser();
/*  191 */     activateBlockParser((BlockParser)this.documentBlockParser);
/*  192 */     this.currentPhase = ParserPhase.STARTING;
/*  193 */     this.blankLinesInAst = ((Boolean)Parser.BLANK_LINES_IN_AST.get(paramDataHolder)).booleanValue();
/*  194 */     this.trackDocumentLines = ((Boolean)Parser.TRACK_DOCUMENT_LINES.get(paramDataHolder)).booleanValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public Parsing getParsing() {
/*  199 */     return this.myParsing;
/*      */   }
/*      */ 
/*      */   
/*      */   public MutableDataHolder getProperties() {
/*  204 */     return (MutableDataHolder)this.documentBlockParser.getBlock();
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<CustomBlockParserFactory> calculateBlockParserFactories(DataHolder paramDataHolder, List<CustomBlockParserFactory> paramList) {
/*  209 */     paramList = new ArrayList<>(paramList);
/*      */ 
/*      */     
/*  212 */     for (Iterator<Map.Entry> iterator = CORE_FACTORIES_DATA_KEYS.entrySet().iterator(); iterator.hasNext();) {
/*  213 */       if (((Boolean)((DataKey)(entry = iterator.next()).getValue()).get(paramDataHolder)).booleanValue()) {
/*  214 */         paramList.add((CustomBlockParserFactory)entry.getKey());
/*      */       }
/*      */     } 
/*      */     
/*  218 */     return DependencyResolver.resolveFlatDependencies(paramList, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<List<ParagraphPreProcessorFactory>> calculateParagraphPreProcessors(DataHolder paramDataHolder, List<ParagraphPreProcessorFactory> paramList, InlineParserFactory paramInlineParserFactory) {
/*  227 */     paramList = new ArrayList<>(paramList);
/*      */     
/*  229 */     if (paramInlineParserFactory == INLINE_PARSER_FACTORY)
/*      */     {
/*  231 */       for (Iterator<DataKey> iterator = CORE_PARAGRAPH_PRE_PROCESSORS.keySet().iterator(); iterator.hasNext();) {
/*  232 */         if (((Boolean)(dataKey = iterator.next()).get(paramDataHolder)).booleanValue()) {
/*  233 */           ParagraphPreProcessorFactory paragraphPreProcessorFactory = CORE_PARAGRAPH_PRE_PROCESSORS.get(dataKey);
/*  234 */           paramList.add(paragraphPreProcessorFactory);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  239 */     return DependencyResolver.resolveDependencies(paramList, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<List<BlockPreProcessorFactory>> calculateBlockPreProcessors(DataHolder paramDataHolder, List<BlockPreProcessorFactory> paramList) {
/*  258 */     return DependencyResolver.resolveDependencies(paramList, null, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public InlineParser getInlineParser() {
/*  263 */     return this.inlineParser;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Document parse(CharSequence paramCharSequence) {
/*  273 */     BasedSequence basedSequence = BasedSequence.of(paramCharSequence);
/*  274 */     int i = 0;
/*      */ 
/*      */ 
/*      */     
/*  278 */     this.lineNumber = 0;
/*      */     
/*  280 */     this.documentBlockParser.initializeDocument(this.options, basedSequence);
/*  281 */     this.inlineParser.initializeDocument(this.documentBlockParser.getBlock());
/*      */     
/*  283 */     this.currentPhase = ParserPhase.PARSE_BLOCKS;
/*      */     int j;
/*  285 */     while ((j = Parsing.findLineBreak((CharSequence)basedSequence, i)) != -1) {
/*  286 */       BasedSequence basedSequence1 = basedSequence.subSequence(i, j);
/*  287 */       int k = j;
/*  288 */       if (j + 1 < basedSequence.length() && basedSequence.charAt(j) == '\r' && basedSequence.charAt(j + 1) == '\n') {
/*  289 */         j += 2;
/*      */       } else {
/*  291 */         j++;
/*      */       } 
/*      */       
/*  294 */       this.lineWithEOL = basedSequence.subSequence(i, j);
/*  295 */       this.lineStart = i;
/*  296 */       this.lineEOLIndex = k;
/*  297 */       this.lineEndIndex = j;
/*  298 */       incorporateLine(basedSequence1);
/*  299 */       this.lineNumber++;
/*  300 */       i = j;
/*      */     } 
/*      */     
/*  303 */     if (basedSequence.length() > 0 && (i == 0 || i < basedSequence.length())) {
/*  304 */       this.lineWithEOL = basedSequence.subSequence(i, basedSequence.length());
/*  305 */       this.lineStart = i;
/*  306 */       this.lineEOLIndex = basedSequence.length();
/*  307 */       this.lineEndIndex = this.lineEOLIndex;
/*  308 */       incorporateLine(this.lineWithEOL);
/*  309 */       this.lineNumber++;
/*      */     } 
/*      */     
/*  312 */     return finalizeAndProcess();
/*      */   }
/*      */ 
/*      */   
/*      */   public Document parse(Reader paramReader) {
/*  317 */     if (paramReader instanceof BufferedReader) {
/*  318 */       paramReader = paramReader;
/*      */     } else {
/*  320 */       paramReader = new BufferedReader(paramReader);
/*      */     } 
/*      */     
/*  323 */     StringBuilder stringBuilder = new StringBuilder();
/*  324 */     char[] arrayOfChar = new char[16384];
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/*  329 */     while ((i = paramReader.read(arrayOfChar)) >= 0) {
/*  330 */       stringBuilder.append(arrayOfChar, 0, i);
/*      */     }
/*      */     
/*  333 */     BasedSequence basedSequence = BasedSequence.of(stringBuilder.toString());
/*  334 */     return parse((CharSequence)basedSequence);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getLineNumber() {
/*  339 */     return this.lineNumber;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getLineStart() {
/*  344 */     return this.lineStart;
/*      */   }
/*      */   
/*      */   public int getLineEndIndex() {
/*  348 */     return this.lineEndIndex;
/*      */   }
/*      */ 
/*      */   
/*      */   public BasedSequence getLine() {
/*  353 */     return this.line;
/*      */   }
/*      */ 
/*      */   
/*      */   public BasedSequence getLineWithEOL() {
/*  358 */     return this.lineWithEOL;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getLineEolLength() {
/*  363 */     return this.lineEndIndex - this.lineEOLIndex;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getIndex() {
/*  368 */     return this.index;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNextNonSpaceIndex() {
/*  373 */     return this.nextNonSpace;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getColumn() {
/*  378 */     return this.column;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getIndent() {
/*  383 */     return this.indent;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBlank() {
/*  388 */     return this.blank;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBlankLine() {
/*  393 */     return this.isBlankLine;
/*      */   }
/*      */ 
/*      */   
/*      */   public BlockParser getActiveBlockParser() {
/*  398 */     return this.activeBlockParsers.get(this.activeBlockParsers.size() - 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public BlockParser getActiveBlockParser(Block paramBlock) {
/*      */     BlockParser blockParser;
/*  404 */     if ((blockParser = this.blockTracker.getKey(paramBlock)) == null || blockParser.isClosed()) return null;  return blockParser;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<BlockParser> getActiveBlockParsers() {
/*  409 */     return this.activeBlockParsers;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void incorporateLine(BasedSequence paramBasedSequence) {
/*  419 */     this.line = paramBasedSequence;
/*  420 */     this.index = 0;
/*  421 */     this.column = 0;
/*  422 */     this.columnIsInTab = false;
/*      */ 
/*      */     
/*  425 */     if (this.trackDocumentLines) this.lineSegments.add(this.lineWithEOL);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  431 */     byte b = 1;
/*  432 */     BlankLine blankLine = null;
/*      */     
/*  434 */     findNextNonSpace();
/*      */     
/*  436 */     if (this.blank && 
/*  437 */       this.blankLinesInAst) {
/*      */       
/*  439 */       blankLine = new BlankLine(this.lineWithEOL);
/*  440 */       this.documentBlockParser.getBlock().appendChild((Node)blankLine);
/*      */     } 
/*      */ 
/*      */     
/*  444 */     for (BlockParser blockParser : this.activeBlockParsers.subList(1, this.activeBlockParsers.size())) {
/*  445 */       boolean bool2 = this.blank;
/*      */       
/*  447 */       findNextNonSpace();
/*      */       
/*  449 */       if (this.blank && 
/*  450 */         this.blankLinesInAst) {
/*  451 */         if (blankLine == null) {
/*      */           
/*  453 */           blankLine = new BlankLine(this.lineWithEOL);
/*  454 */           this.documentBlockParser.getBlock().appendChild((Node)blankLine);
/*      */         } 
/*      */         
/*  457 */         if (!bool2 && blockParser.getBlock() instanceof com.vladsch.flexmark.util.ast.BlankLineContainer) {
/*  458 */           blankLine.setClaimedBlankLine(blockParser.getBlock());
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  464 */       this.isBlankLine = bool2;
/*      */       
/*      */       BlockContinue blockContinue;
/*  467 */       if (blockContinue = blockParser.tryContinue(this) instanceof BlockContinueImpl) {
/*      */         BlockContinueImpl blockContinueImpl;
/*  469 */         if ((blockContinueImpl = (BlockContinueImpl)blockContinue).isFinalize()) {
/*  470 */           finalize(blockParser);
/*      */           return;
/*      */         } 
/*  473 */         if (blockContinueImpl.getNewIndex() != -1) {
/*  474 */           setNewIndex(blockContinueImpl.getNewIndex());
/*  475 */           if (!this.blank && blockParser.getBlock() instanceof com.vladsch.flexmark.util.ast.BlankLineContainer) {
/*  476 */             findNextNonSpace();
/*  477 */             if (this.blank) {
/*  478 */               blankLine = new BlankLine(this.lineWithEOL, blockParser.getBlock());
/*  479 */               blockParser.getBlock().appendChild((Node)blankLine);
/*      */             } 
/*      */           } 
/*  482 */         } else if (blockContinueImpl.getNewColumn() != -1) {
/*  483 */           setNewColumn(blockContinueImpl.getNewColumn());
/*  484 */           if (!this.blank && blockParser.getBlock() instanceof com.vladsch.flexmark.util.ast.BlankLineContainer) {
/*  485 */             findNextNonSpace();
/*  486 */             if (this.blank) {
/*  487 */               blankLine = new BlankLine(this.lineWithEOL, blockParser.getBlock());
/*  488 */               blockParser.getBlock().appendChild((Node)blankLine);
/*      */             } 
/*      */           } 
/*      */         } 
/*  492 */         b++;
/*      */         
/*  494 */         if (blankLine != null && (this.blankLinesInAst || blankLine.getClaimedBlankLine() == blockParser.getBlock()) && 
/*  495 */           blockParser.getBlock() instanceof com.vladsch.flexmark.util.ast.BlankLineContainer) {
/*  496 */           blockParser.getBlock().appendChild((Node)blankLine);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  505 */     ArrayList<BlockParser> arrayList = new ArrayList(this.activeBlockParsers.subList(b, this.activeBlockParsers.size()));
/*      */     
/*  507 */     BlockParser blockParser2 = this.activeBlockParsers.get(b - 1), blockParser3 = blockParser2;
/*  508 */     boolean bool = arrayList.isEmpty();
/*      */ 
/*      */     
/*  511 */     if (this.blank && isLastLineBlank((Node)blockParser3.getBlock())) {
/*  512 */       ArrayList<BlockParser> arrayList1 = new ArrayList(this.activeBlockParsers.subList(0, b));
/*  513 */       breakOutOfLists(arrayList1);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  518 */     boolean bool1 = (blockParser3.isInterruptible() || blockParser3.isContainer()) ? true : false;
/*  519 */     BlockParser blockParser1 = null;
/*      */     
/*  521 */     while (bool1) {
/*  522 */       boolean bool2 = this.blank;
/*  523 */       findNextNonSpace();
/*      */       
/*  525 */       if (this.blank && !bool2) blockParser1 = blockParser3;
/*      */ 
/*      */       
/*  528 */       if (this.blank || (this.indent < this.myParsing.CODE_BLOCK_INDENT && Parsing.isLetter((CharSequence)this.line, this.nextNonSpace))) {
/*  529 */         setNewIndex(this.nextNonSpace);
/*      */         
/*      */         break;
/*      */       } 
/*      */       BlockStartImpl blockStartImpl;
/*  534 */       if ((blockStartImpl = findBlockStart(blockParser3)) == null) {
/*  535 */         if (!blockParser3.isRawText() || !blockParser3.isInterruptible()) setNewIndex(this.nextNonSpace);
/*      */         
/*      */         break;
/*      */       } 
/*  539 */       if (!bool) {
/*  540 */         finalizeBlocks(arrayList);
/*  541 */         bool = true;
/*      */       } 
/*      */       
/*  544 */       if (blockStartImpl.getNewIndex() != -1) {
/*  545 */         setNewIndex(blockStartImpl.getNewIndex());
/*  546 */       } else if (blockStartImpl.getNewColumn() != -1) {
/*  547 */         setNewColumn(blockStartImpl.getNewColumn());
/*      */       } 
/*      */       
/*  550 */       if (blockStartImpl.isReplaceActiveBlockParser())
/*  551 */         removeActiveBlockParser();  BlockParser[] arrayOfBlockParser;
/*      */       int i;
/*      */       byte b1;
/*  554 */       for (i = (arrayOfBlockParser = blockStartImpl.getBlockParsers()).length, b1 = 0; b1 < i; ) { BlockParser blockParser = arrayOfBlockParser[b1];
/*  555 */         blockParser3 = addChild(blockParser);
/*  556 */         boolean bool3 = blockParser.isContainer();
/*      */ 
/*      */         
/*      */         b1++; }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*  564 */     if (!bool && !this.blank && getActiveBlockParser().isParagraphParser()) {
/*      */       
/*  566 */       addLine();
/*      */       return;
/*      */     } 
/*  569 */     if (!bool) {
/*  570 */       finalizeBlocks(arrayList);
/*      */     }
/*      */     
/*  573 */     propagateLastLineBlank(blockParser3, blockParser2);
/*      */     
/*  575 */     if (this.blank && 
/*  576 */       blockParser3.getBlock() instanceof com.vladsch.flexmark.util.ast.KeepTrailingBlankLineContainer) {
/*  577 */       if (blankLine != null) {
/*  578 */         blockParser3.getBlock().appendChild((Node)blankLine);
/*      */       }
/*  580 */       else if (blockParser3.isContainer() && blockParser1 == blockParser3) {
/*      */         
/*  582 */         blankLine = new BlankLine(this.lineWithEOL, blockParser3.getBlock());
/*  583 */         blockParser3.getBlock().appendChild((Node)blankLine);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  589 */     if (!blockParser3.isContainer()) {
/*  590 */       addLine(); return;
/*  591 */     }  if (!this.blank) {
/*      */       
/*  593 */       addChild(new ParagraphParser());
/*  594 */       addLine();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void findNextNonSpace() {
/*  600 */     int i = this.index;
/*  601 */     int j = this.column;
/*      */     
/*  603 */     this.blank = true; while (true)
/*  604 */     { if (i < this.line.length()) {
/*      */         char c;
/*  606 */         switch (c = this.line.charAt(i)) {
/*      */           case ' ':
/*  608 */             i++;
/*  609 */             j++;
/*      */             continue;
/*      */           case '\t':
/*  612 */             i++;
/*  613 */             j += 4 - j % 4;
/*      */             continue;
/*      */         } 
/*  616 */         this.blank = false;
/*      */       } else {
/*      */         break;
/*      */       } 
/*  620 */       this.nextNonSpace = i;
/*  621 */       this.nextNonSpaceColumn = j;
/*  622 */       this.indent = this.nextNonSpaceColumn - this.column; return; }  this.nextNonSpace = i; this.nextNonSpaceColumn = j; this.indent = this.nextNonSpaceColumn - this.column;
/*      */   }
/*      */   
/*      */   private void setNewIndex(int paramInt) {
/*  626 */     if (paramInt >= this.nextNonSpace) {
/*      */       
/*  628 */       this.index = this.nextNonSpace;
/*  629 */       this.column = this.nextNonSpaceColumn;
/*      */     } 
/*  631 */     while (this.index < paramInt && this.index != this.line.length()) {
/*  632 */       advance();
/*      */     }
/*      */     
/*  635 */     this.columnIsInTab = false;
/*      */   }
/*      */   
/*      */   private void setNewColumn(int paramInt) {
/*  639 */     if (paramInt >= this.nextNonSpaceColumn) {
/*      */       
/*  641 */       this.index = this.nextNonSpace;
/*  642 */       this.column = this.nextNonSpaceColumn;
/*      */     } 
/*  644 */     while (this.column < paramInt && this.index != this.line.length()) {
/*  645 */       advance();
/*      */     }
/*  647 */     if (this.column > paramInt) {
/*      */       
/*  649 */       this.index--;
/*  650 */       this.column = paramInt;
/*  651 */       this.columnIsInTab = true; return;
/*      */     } 
/*  653 */     this.columnIsInTab = false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void advance() {
/*      */     char c;
/*  659 */     if ((c = this.line.charAt(this.index)) == '\t') {
/*  660 */       this.index++;
/*  661 */       this.column += Parsing.columnsToNextTabStop(this.column); return;
/*      */     } 
/*  663 */     this.index++;
/*  664 */     this.column++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addLine() {
/*      */     PrefixedSubSequence prefixedSubSequence;
/*  673 */     BasedSequence basedSequence = (BasedSequence)this.lineWithEOL.subSequence(this.index);
/*  674 */     if (this.columnIsInTab) {
/*      */       
/*  676 */       basedSequence = (BasedSequence)basedSequence.subSequence(1);
/*  677 */       int i = Parsing.columnsToNextTabStop(this.column);
/*  678 */       StringBuilder stringBuilder = new StringBuilder(i + basedSequence.length());
/*  679 */       for (byte b = 0; b < i; b++) {
/*  680 */         stringBuilder.append(' ');
/*      */       }
/*      */       
/*  683 */       prefixedSubSequence = PrefixedSubSequence.prefixOf(stringBuilder.toString(), basedSequence);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  688 */     getActiveBlockParser().addLine(this, (BasedSequence)prefixedSubSequence);
/*      */   }
/*      */   
/*      */   private BlockStartImpl findBlockStart(BlockParser paramBlockParser) {
/*  692 */     MatchedBlockParserImpl matchedBlockParserImpl = new MatchedBlockParserImpl(paramBlockParser);
/*  693 */     for (BlockParserFactory blockParserFactory : this.blockParserFactories) {
/*  694 */       BlockStart blockStart; if (paramBlockParser.canInterruptBy(blockParserFactory) && 
/*      */         
/*  696 */         blockStart = blockParserFactory.tryStart(this, matchedBlockParserImpl) instanceof BlockStartImpl) {
/*  697 */         return (BlockStartImpl)blockStart;
/*      */       }
/*      */     } 
/*      */     
/*  701 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void finalize(BlockParser paramBlockParser) {
/*  712 */     if (getActiveBlockParser() == paramBlockParser) {
/*  713 */       deactivateBlockParser();
/*      */     }
/*      */     
/*      */     Block block;
/*      */     
/*      */     Node node;
/*  719 */     if ((block = paramBlockParser.getBlock()).getParent() != null && 
/*      */       
/*  721 */       node = block.getLastChild() instanceof BlankLine && (
/*  722 */       (BlankLine)node).getClaimedBlankLine() != block) {
/*      */       
/*  724 */       node = node.getFirstInChain();
/*  725 */       block.insertChainAfter(node);
/*  726 */       block.setCharsFromContentOnly();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  731 */     paramBlockParser.closeBlock(this);
/*  732 */     paramBlockParser.finalizeClosedBlock();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  737 */     while (node = block.getNext() instanceof BlankLine && node.getEndOffset() <= block.getEndOffset()) {
/*  738 */       node.unlink();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processInlines() {
/*  749 */     for (ReversibleIndexedIterator<BlockParser> reversibleIndexedIterator = this.blockTracker.allBlockParsers().iterator(); reversibleIndexedIterator.hasNext();) {
/*  750 */       (blockParser = reversibleIndexedIterator.next()).parseInlines(this.inlineParser);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean endsWithBlankLine(Node paramNode) {
/*  756 */     while (paramNode != null) {
/*  757 */       if (isLastLineBlank(paramNode)) {
/*  758 */         return true;
/*      */       }
/*  760 */       paramNode = paramNode.getLastBlankLineChild();
/*      */     } 
/*  762 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void breakOutOfLists(List<BlockParser> paramList) {
/*  772 */     int i = -1;
/*  773 */     for (int j = paramList.size() - 1; j >= 0; j--) {
/*      */       BlockParser blockParser;
/*  775 */       if ((blockParser = paramList.get(j)).breakOutOnDoubleBlankLine()) {
/*  776 */         i = j;
/*      */       }
/*      */     } 
/*      */     
/*  780 */     if (i != -1) {
/*  781 */       finalizeBlocks(paramList.subList(i, paramList.size()));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private <T extends BlockParser> T addChild(T paramT) {
/*  794 */     while (!getActiveBlockParser().canContain(this, (BlockParser)paramT, paramT.getBlock())) {
/*  795 */       finalize(getActiveBlockParser());
/*      */     }
/*      */     
/*  798 */     getActiveBlockParser().getBlock().appendChild((Node)paramT.getBlock());
/*  799 */     activateBlockParser((BlockParser)paramT);
/*      */     
/*  801 */     return paramT;
/*      */   }
/*      */   
/*      */   private void activateBlockParser(BlockParser paramBlockParser) {
/*  805 */     this.activeBlockParsers.add(paramBlockParser);
/*  806 */     if (!this.blockTracker.containsKey(paramBlockParser)) {
/*  807 */       blockParserAdded(paramBlockParser);
/*      */     }
/*      */   }
/*      */   
/*      */   private void deactivateBlockParser() {
/*  812 */     this.activeBlockParsers.remove(this.activeBlockParsers.size() - 1);
/*      */   }
/*      */   
/*      */   private void removeActiveBlockParser() {
/*  816 */     BlockParser blockParser = getActiveBlockParser();
/*  817 */     deactivateBlockParser();
/*      */     
/*  819 */     blockParserRemoved(blockParser);
/*  820 */     blockParser.getBlock().unlink();
/*      */   }
/*      */   private void propagateLastLineBlank(BlockParser paramBlockParser1, BlockParser paramBlockParser2) {
/*      */     Node node;
/*  824 */     if (this.blank && (
/*      */       
/*  826 */       node = paramBlockParser1.getBlock().getLastChild()) != null) setLastLineBlank(node, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  834 */     boolean bool = (this.blank && paramBlockParser1.isPropagatingLastBlankLine(paramBlockParser2)) ? true : false;
/*      */ 
/*      */     
/*  837 */     Block block = paramBlockParser1.getBlock();
/*  838 */     while (block != null) {
/*  839 */       setLastLineBlank((Node)block, bool);
/*  840 */       Node node1 = block.getParent();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void setLastLineBlank(Node paramNode, boolean paramBoolean) {
/*  845 */     this.lastLineBlank.put(paramNode, Boolean.valueOf(paramBoolean));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isLastLineBlank(Node paramNode) {
/*      */     Boolean bool;
/*  851 */     if ((bool = this.lastLineBlank.get(paramNode)) != null && bool.booleanValue()) return true;  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean finalizeBlocks(List<BlockParser> paramList) {
/*  860 */     for (int i = paramList.size() - 1; i >= 0; i--) {
/*  861 */       BlockParser blockParser = paramList.get(i);
/*  862 */       finalize(blockParser);
/*      */     } 
/*  864 */     return true;
/*      */   }
/*      */   
/*      */   private static class ParagraphPreProcessorCache extends ItemFactoryMap<ParagraphPreProcessor, ParserState> {
/*      */     ParagraphPreProcessorCache(ParserState param1ParserState) {
/*  869 */       super(param1ParserState);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void preProcessParagraph(Paragraph paramParagraph, List<ParagraphPreProcessorFactory> paramList, ParagraphPreProcessorCache paramParagraphPreProcessorCache) {
/*      */     while (true) {
/*  882 */       boolean bool = false;
/*      */       
/*  884 */       for (ParagraphPreProcessorFactory paragraphPreProcessorFactory : paramList) {
/*      */         int i;
/*      */         
/*      */         ParagraphPreProcessor paragraphPreProcessor;
/*      */         
/*  889 */         if ((i = (paragraphPreProcessor = (ParagraphPreProcessor)paramParagraphPreProcessorCache.getItem((Function)paragraphPreProcessorFactory)).preProcessBlock(paramParagraph, this)) > 0) {
/*  890 */           bool = true;
/*      */ 
/*      */           
/*      */           BasedSequence basedSequence1, basedSequence2;
/*      */ 
/*      */           
/*  896 */           if ((basedSequence1 = (BasedSequence)(basedSequence2 = paramParagraph.getChars()).subSequence(i + basedSequence2.countLeading(CharPredicate.WHITESPACE, i, basedSequence2.length()))).isBlank()) {
/*      */             
/*  898 */             paramParagraph.unlink();
/*  899 */             blockRemoved((Block)paramParagraph);
/*      */             
/*      */             return;
/*      */           } 
/*  903 */           int j = paramParagraph.getLineCount();
/*      */           byte b;
/*  905 */           for (b = 0; b < j && 
/*  906 */             paramParagraph.getLineChars(b).getEndOffset() <= basedSequence1.getStartOffset(); b++);
/*      */ 
/*      */           
/*  909 */           if (b >= j) {
/*      */             
/*  911 */             paramParagraph.unlink();
/*  912 */             blockRemoved((Block)paramParagraph); return;
/*      */           } 
/*  914 */           if (paramParagraph.getLineChars(b).getEndOffset() == basedSequence1.getStartOffset()) {
/*      */             
/*  916 */             paramParagraph.setContent(paramParagraph, b, j);
/*      */             continue;
/*      */           } 
/*      */           ArrayList<?> arrayList;
/*  920 */           (arrayList = new ArrayList(j - b)).addAll(paramParagraph.getContentLines().subList(b, j));
/*      */           int k;
/*  922 */           if ((k = basedSequence1.getStartOffset() - ((BasedSequence)arrayList.get(0)).getStartOffset()) > 0 && k < ((BasedSequence)arrayList.get(0)).length()) {
/*  923 */             arrayList.set(0, ((BasedSequence)arrayList.get(0)).subSequence(k));
/*      */           }
/*      */ 
/*      */           
/*  927 */           int[] arrayOfInt = new int[j - b];
/*  928 */           System.arraycopy(paramParagraph.getLineIndents(), b, arrayOfInt, 0, arrayOfInt.length);
/*  929 */           paramParagraph.setContentLines(arrayList);
/*  930 */           paramParagraph.setLineIndents(arrayOfInt);
/*  931 */           paramParagraph.setChars(basedSequence1);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  937 */       if (bool && paramList.size() >= 2)
/*      */         continue; 
/*      */       break;
/*      */     } 
/*      */   }
/*      */   private void preProcessParagraphs() {
/*  943 */     if (this.blockTracker.getNodeClassifier().containsCategory(Paragraph.class)) {
/*  944 */       ParagraphPreProcessorCache paragraphPreProcessorCache = new ParagraphPreProcessorCache(this);
/*  945 */       for (List<ParagraphPreProcessorFactory> list : this.paragraphPreProcessorDependencies) {
/*      */         
/*  947 */         for (ReversibleIterator<Paragraph> reversibleIterator = this.blockTracker.getNodeClassifier().getCategoryItems(Paragraph.class, (Object[])new Class[] { Paragraph.class }).iterator(); reversibleIterator.hasNext(); ) { Paragraph paragraph = reversibleIterator.next();
/*  948 */           preProcessParagraph(paragraph, list, paragraphPreProcessorCache); }
/*      */       
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void preProcessBlocks() {
/*  956 */     HashSet hashSet = new HashSet();
/*  957 */     for (Iterator<List<BlockPreProcessorFactory>> iterator = this.blockPreProcessorDependencies.iterator(); iterator.hasNext();) {
/*  958 */       for (BlockPreProcessorFactory blockPreProcessorFactory : list = iterator.next()) {
/*  959 */         hashSet.addAll(blockPreProcessorFactory.getBlockTypes());
/*      */       }
/*      */     } 
/*      */     
/*      */     BitSet bitSet;
/*      */     
/*  965 */     if (!(bitSet = this.blockTracker.getNodeClassifier().categoriesBitSet(hashSet)).isEmpty()) {
/*  966 */       for (Iterator<List<BlockPreProcessorFactory>> iterator1 = this.blockPreProcessorDependencies.iterator(); iterator1.hasNext();) {
/*  967 */         for (BlockPreProcessorFactory blockPreProcessorFactory : list = iterator1.next()) {
/*  968 */           ReversibleIterable reversibleIterable = this.blockTracker.getNodeClassifier().getCategoryItems(Block.class, blockPreProcessorFactory.getBlockTypes());
/*  969 */           BlockPreProcessor blockPreProcessor = blockPreProcessorFactory.apply(this);
/*      */           
/*  971 */           for (ReversibleIterator<Block> reversibleIterator = reversibleIterable.iterator(); reversibleIterator.hasNext(); ) { Block block = reversibleIterator.next();
/*  972 */             blockPreProcessor.preProcess(this, block); }
/*      */         
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private Document finalizeAndProcess() {
/*  982 */     finalizeBlocks(this.activeBlockParsers);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  989 */     this.currentPhase = ParserPhase.PRE_PROCESS_PARAGRAPHS;
/*  990 */     preProcessParagraphs();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  996 */     this.currentPhase = ParserPhase.PRE_PROCESS_BLOCKS;
/*  997 */     preProcessBlocks();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1004 */     this.currentPhase = ParserPhase.PARSE_INLINES;
/* 1005 */     processInlines();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1011 */     this.currentPhase = ParserPhase.DONE;
/* 1012 */     Document document = this.documentBlockParser.getBlock();
/* 1013 */     this.inlineParser.finalizeDocument(document);
/*      */     
/* 1015 */     return document;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\DocumentParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */