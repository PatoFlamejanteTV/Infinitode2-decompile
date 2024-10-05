/*     */ package com.vladsch.flexmark.parser.core;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.BulletList;
/*     */ import com.vladsch.flexmark.ast.ListBlock;
/*     */ import com.vladsch.flexmark.ast.ListItem;
/*     */ import com.vladsch.flexmark.ast.OrderedList;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.parser.ListOptions;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.ParserEmulationProfile;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.BlockStart;
/*     */ import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
/*     */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.BlankLine;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.SharedDataKeys;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInCharsHandler;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.regex.Matcher;
/*     */ 
/*     */ public class ListBlockParser extends AbstractBlockParser {
/*     */   private final ListBlock myBlock;
/*  39 */   ListItemParser myLastChild = null; private final ListOptions myOptions; private final ListData myListData;
/*  40 */   BasedSequence myItemHandledLine = null;
/*     */   boolean myItemHandledNewListLine;
/*     */   boolean myItemHandledNewItemLine;
/*     */   boolean myItemHandledSkipActiveLine;
/*     */   
/*     */   public ListBlockParser(ListOptions paramListOptions, ListData paramListData, ListItemParser paramListItemParser) {
/*  46 */     this.myOptions = paramListOptions;
/*  47 */     this.myListData = paramListData;
/*  48 */     this.myBlock = paramListData.listBlock;
/*  49 */     this.myBlock.setTight(true);
/*  50 */     this.myLastChild = paramListItemParser;
/*  51 */     this.myItemHandledNewListLine = false;
/*  52 */     this.myItemHandledNewItemLine = false;
/*  53 */     this.myItemHandledSkipActiveLine = false;
/*     */   }
/*     */   
/*     */   BasedSequence getItemHandledLine() {
/*  57 */     return this.myItemHandledLine;
/*     */   }
/*     */   
/*     */   void setItemHandledLine(BasedSequence paramBasedSequence) {
/*  61 */     this.myItemHandledLine = paramBasedSequence;
/*  62 */     this.myItemHandledNewListLine = false;
/*  63 */     this.myItemHandledNewItemLine = false;
/*  64 */     this.myItemHandledSkipActiveLine = false;
/*     */   }
/*     */   
/*     */   void setItemHandledNewListLine(BasedSequence paramBasedSequence) {
/*  68 */     this.myItemHandledLine = paramBasedSequence;
/*  69 */     this.myItemHandledNewListLine = true;
/*  70 */     this.myItemHandledNewItemLine = false;
/*  71 */     this.myItemHandledSkipActiveLine = false;
/*     */   }
/*     */   
/*     */   void setItemHandledNewItemLine(BasedSequence paramBasedSequence) {
/*  75 */     this.myItemHandledLine = paramBasedSequence;
/*  76 */     this.myItemHandledNewListLine = false;
/*  77 */     this.myItemHandledNewItemLine = true;
/*  78 */     this.myItemHandledSkipActiveLine = false;
/*     */   }
/*     */   
/*     */   void setItemHandledLineSkipActive(BasedSequence paramBasedSequence) {
/*  82 */     this.myItemHandledLine = paramBasedSequence;
/*  83 */     this.myItemHandledNewListLine = false;
/*  84 */     this.myItemHandledNewItemLine = false;
/*  85 */     this.myItemHandledSkipActiveLine = true;
/*     */   }
/*     */   
/*     */   public ListItemParser getLastChild() {
/*  89 */     return this.myLastChild;
/*     */   }
/*     */   
/*     */   public void setLastChild(ListItemParser paramListItemParser) {
/*  93 */     this.myLastChild = paramListItemParser;
/*     */   }
/*     */   
/*     */   public ListOptions getOptions() {
/*  97 */     return this.myOptions;
/*     */   }
/*     */   
/*     */   public ListData getListData() {
/* 101 */     return this.myListData;
/*     */   }
/*     */   
/*     */   int getContentIndent() {
/* 105 */     return this.myListData.markerIndent + this.myListData.listMarker.length() + this.myListData.contentOffset;
/*     */   }
/*     */   
/*     */   int getLastContentIndent() {
/* 109 */     return this.myLastChild.getContentIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/* 119 */     return paramBlock instanceof ListItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public ListBlock getBlock() {
/* 124 */     return this.myBlock;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setTight(boolean paramBoolean) {
/* 129 */     this.myBlock.setTight(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/* 134 */     finalizeListTight(paramParserState);
/*     */     
/* 136 */     if (((Boolean)Parser.BLANK_LINES_IN_AST.get((DataHolder)paramParserState.getProperties())).booleanValue()) {
/*     */       ListBlock listBlock;
/*     */ 
/*     */       
/* 140 */       Node node = (listBlock = getBlock()).getFirstChildAnyNot(new Class[] { BlankLine.class });
/*     */       
/* 142 */       while (node instanceof ListItem) {
/*     */         
/* 144 */         node.moveTrailingBlankLines();
/* 145 */         node = node.getNextAnyNot(new Class[] { BlankLine.class });
/*     */       } 
/*     */     } 
/*     */     
/* 149 */     this.myBlock.setCharsFromContentOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean breakOutOnDoubleBlankLine() {
/* 154 */     return this.myOptions.isEndOnDoubleBlank();
/*     */   }
/*     */   
/*     */   private static boolean hasNonItemChildren(ListItem paramListItem) {
/* 158 */     if (paramListItem.hasChildren()) {
/* 159 */       byte b = 0;
/* 160 */       for (ReversiblePeekingIterator<Node> reversiblePeekingIterator = paramListItem.getChildren().iterator(); reversiblePeekingIterator.hasNext();) {
/* 161 */         if (!(node = reversiblePeekingIterator.next() instanceof ListBlock)) {
/*     */           
/* 163 */           b++;
/* 164 */           if (b >= 2) return true; 
/*     */         } 
/*     */       } 
/* 167 */     }  return false;
/*     */   }
/*     */   
/*     */   private void finalizeListTight(ParserState paramParserState) {
/* 171 */     Node node = getBlock().getFirstChild();
/* 172 */     boolean bool1 = true;
/* 173 */     boolean bool2 = false;
/* 174 */     boolean bool3 = false;
/*     */     
/* 176 */     while (node != null) {
/*     */       
/* 178 */       boolean bool4 = false;
/* 179 */       boolean bool5 = false;
/*     */       
/* 181 */       boolean bool6 = false;
/* 182 */       boolean bool7 = false;
/* 183 */       boolean bool8 = false;
/*     */       
/* 185 */       if (node instanceof ListItem) {
/* 186 */         if (((ListItem)node).isHadBlankAfterItemParagraph())
/*     */         {
/* 188 */           if (node.getNext() != null || (node.getFirstChild() != null && node.getFirstChild().getNext() != null))
/*     */           {
/*     */             
/* 191 */             bool4 = true;
/*     */           }
/*     */         }
/*     */         
/* 195 */         if (((ListItem)node).isContainsBlankLine()) {
/* 196 */           bool5 = true;
/*     */         }
/*     */         
/* 199 */         if (paramParserState.endsWithBlankLine(node) && node.getNext() != null) {
/* 200 */           bool6 = true;
/*     */         }
/*     */         
/* 203 */         if (hasNonItemChildren((ListItem)node)) {
/* 204 */           bool7 = true;
/*     */         }
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
/* 217 */         if (bool8 = ((bool6 && this.myOptions.isLooseWhenHasTrailingBlankLine()) || (bool4 && this.myOptions.isLooseWhenBlankLineFollowsItemParagraph()) || (bool5 && this.myOptions.isLooseWhenContainsBlankLine()) || (bool7 && this.myOptions.isLooseWhenHasNonListChildren()) || (((bool6 && node.getPrevious() == null) || bool2) && (this.myOptions.isLooseWhenPrevHasTrailingBlankLine() || (this.myOptions.isLooseWhenLastItemPrevHasTrailingBlankLine() && node.getNext() == null)))) ? true : false) {
/* 218 */           ((ListItem)node).setLoose(true);
/* 219 */           bool1 = false;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 225 */       Node node1 = node.getFirstChild();
/* 226 */       while (node1 != null) {
/* 227 */         if (paramParserState.endsWithBlankLine(node1) && (node.getNext() != null || node1.getNext() != null)) {
/*     */           
/* 229 */           if (node1 == node.getLastChild()) bool6 = true;
/*     */           
/* 231 */           if (!bool8) {
/* 232 */             if (this.myOptions.isLooseWhenHasTrailingBlankLine()) {
/* 233 */               bool1 = false;
/*     */             }
/*     */             
/* 236 */             if (bool6 && node.getPrevious() == null && this.myOptions.isLooseWhenPrevHasTrailingBlankLine()) {
/* 237 */               bool1 = false;
/* 238 */               bool8 = true;
/* 239 */               ((ListItem)node).setLoose(true);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 244 */         if (node1 instanceof ListBlock) {
/* 245 */           bool3 = true;
/* 246 */           if (!bool8 && this.myOptions.isLooseWhenHasLooseSubItem()) {
/* 247 */             ReversiblePeekingIterator reversiblePeekingIterator = node1.getChildIterator();
/* 248 */             while (reversiblePeekingIterator.hasNext()) {
/*     */               ListItem listItem;
/* 250 */               if (!(listItem = (ListItem)reversiblePeekingIterator.next()).isTight()) {
/* 251 */                 bool8 = true;
/* 252 */                 bool1 = false;
/* 253 */                 ((ListItem)node).setLoose(true);
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 260 */         if (this.myOptions.isLooseWhenHasLooseSubItem() ? (
/* 261 */           bool8 && (bool3 || !this.myOptions.isAutoLooseOneLevelLists())) : (
/*     */           
/* 263 */           !bool1 && (bool3 || !this.myOptions.isAutoLooseOneLevelLists())))
/*     */           break; 
/* 265 */         node1 = node1.getNext();
/*     */       } 
/*     */       
/* 268 */       if (node instanceof ListItem) {
/* 269 */         bool2 = bool6;
/*     */       }
/*     */       
/* 272 */       node = node.getNext();
/*     */     } 
/*     */     
/* 275 */     if (this.myOptions.isAutoLoose() && this.myOptions.isAutoLooseOneLevelLists()) {
/* 276 */       if (!bool3 && getBlock().getAncestorOfType(new Class[] { ListBlock.class }) == null && !bool1) {
/* 277 */         setTight(false);
/*     */         return;
/*     */       } 
/* 280 */     } else if (this.myOptions.isAutoLoose() && !bool1) {
/* 281 */       setTight(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static ListData parseListMarker(ListOptions paramListOptions, int paramInt, ParserState paramParserState) {
/* 291 */     Parsing parsing = paramParserState.getParsing();
/* 292 */     BasedSequence basedSequence1 = paramParserState.getLine();
/* 293 */     int j = paramParserState.getNextNonSpaceIndex();
/* 294 */     int k = paramParserState.getColumn() + paramParserState.getIndent();
/* 295 */     int i = paramParserState.getIndent();
/*     */     
/* 297 */     BasedSequence basedSequence2 = basedSequence1.subSequence(j, basedSequence1.length());
/*     */     Matcher matcher;
/* 299 */     if (!(matcher = parsing.LIST_ITEM_MARKER.matcher((CharSequence)basedSequence2)).find()) {
/* 300 */       return null;
/*     */     }
/*     */     
/* 303 */     ListBlock listBlock = createListBlock(matcher);
/*     */     
/* 305 */     int m = matcher.end() - matcher.start();
/* 306 */     boolean bool1 = !"+-*".contains(matcher.group()) ? true : false;
/* 307 */     int n = j + m;
/*     */ 
/*     */     
/* 310 */     m = k + m;
/*     */ 
/*     */     
/* 313 */     int i1 = 0;
/*     */ 
/*     */     
/* 316 */     boolean bool2 = false;
/* 317 */     int i2 = n;
/* 318 */     for (n = n; n < basedSequence1.length(); n++) {
/*     */       char c;
/* 320 */       if ((c = basedSequence1.charAt(n)) == '\t') {
/* 321 */         i1 += Parsing.columnsToNextTabStop(m + i1);
/* 322 */         i2++;
/* 323 */       } else if (c == ' ') {
/* 324 */         i1++;
/* 325 */         i2++;
/*     */       } else {
/* 327 */         bool2 = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 332 */     BasedSequence basedSequence3 = BasedSequence.NULL;
/* 333 */     int i3 = i1;
/*     */     
/* 335 */     if (!bool2 || i1 > paramInt) {
/*     */       
/* 337 */       i3 = i1 = 1;
/* 338 */     } else if (!bool1 || paramListOptions.isNumberedItemMarkerSuffixed()) {
/*     */       String[] arrayOfString; int i4;
/*     */       byte b;
/* 341 */       for (i4 = (arrayOfString = arrayOfString = paramListOptions.getItemMarkerSuffixes()).length, b = 0; b < i4; ) {
/*     */         String str; char c; int i5;
/* 343 */         if ((i5 = (str = arrayOfString[b]).length()) > 0 && basedSequence1.matchChars(str, i2) && (
/* 344 */           !paramListOptions.isItemMarkerSpace() || (
/*     */           
/* 346 */           c = basedSequence1.midCharAt(i2 + i5)) == ' ' || c == '\t')) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 352 */           basedSequence3 = basedSequence1.subSequence(i2, i2 + i5);
/* 353 */           i1 += i5;
/* 354 */           i2 += i5;
/* 355 */           m += i5;
/*     */           
/* 357 */           bool2 = false;
/* 358 */           int i7 = i1;
/*     */           
/* 360 */           for (int i6 = i2; i6 < basedSequence1.length(); i6++) {
/*     */             
/* 362 */             if ((i2 = basedSequence1.charAt(i6)) == 9) {
/* 363 */               i1 += Parsing.columnsToNextTabStop(m + i1);
/* 364 */             } else if (i2 == 32) {
/* 365 */               i1++;
/*     */             } else {
/* 367 */               bool2 = true;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 372 */           if (!bool2 || i1 - i7 > paramInt)
/*     */           {
/* 374 */             i1 = i7 + 1;
/*     */           }
/*     */           break;
/*     */         } 
/*     */         b++;
/*     */       } 
/*     */     } 
/* 381 */     return new ListData(listBlock, !bool2, j, k, i, i1, basedSequence2.subSequence(matcher.start(), matcher.end()), bool1, basedSequence3, i3);
/*     */   }
/*     */   
/*     */   private static ListBlock createListBlock(Matcher paramMatcher) {
/*     */     String str2;
/* 386 */     if ((str2 = paramMatcher.group(1)) != null) {
/*     */       BulletList bulletList;
/* 388 */       (bulletList = new BulletList()).setOpeningMarker(str2.charAt(0));
/* 389 */       return (ListBlock)bulletList;
/*     */     } 
/* 391 */     String str3 = paramMatcher.group(2);
/* 392 */     String str1 = paramMatcher.group(3);
/*     */     OrderedList orderedList;
/* 394 */     (orderedList = new OrderedList()).setStartNumber(Integer.parseInt(str3));
/* 395 */     orderedList.setDelimiter(str1.charAt(0));
/* 396 */     return (ListBlock)orderedList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/* 404 */     return BlockContinue.atIndex(paramParserState.getIndex());
/*     */   }
/*     */   
/*     */   public static class Factory
/*     */     implements CustomBlockParserFactory
/*     */   {
/*     */     public Set<Class<?>> getAfterDependents() {
/* 411 */       return new HashSet<>(Arrays.asList(new Class[] { BlockQuoteParser.Factory.class, HeadingParser.Factory.class, FencedCodeBlockParser.Factory.class, HtmlBlockParser.Factory.class, ThematicBreakParser.Factory.class }));
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
/*     */     public Set<Class<?>> getBeforeDependents() {
/*     */       HashSet<Class<IndentedCodeBlockParser.Factory>> hashSet;
/* 424 */       (hashSet = new HashSet<>()).add(IndentedCodeBlockParser.Factory.class);
/* 425 */       return hashSet;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean affectsGlobalScope() {
/* 430 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockParserFactory apply(DataHolder param1DataHolder) {
/* 436 */       return (BlockParserFactory)new ListBlockParser.BlockFactory(param1DataHolder);
/*     */     }
/*     */ 
/*     */     
/*     */     public SpecialLeadInHandler getLeadInHandler(DataHolder param1DataHolder) {
/* 441 */       return ListBlockParser.ListItemLeadInHandler.create((CharSequence)Parser.LISTS_ITEM_PREFIX_CHARS.get(param1DataHolder), ((Boolean)Parser.LISTS_ORDERED_ITEM_DOT_ONLY.get(param1DataHolder)).booleanValue());
/*     */     }
/*     */   }
/*     */   
/*     */   static class ListItemLeadInHandler extends SpecialLeadInCharsHandler {
/* 446 */     static final CharPredicate ORDERED_DELIM_DOT = CharPredicate.anyOf(new char[] { '.' });
/* 447 */     static final CharPredicate ORDERED_DELIM_DOT_PARENS = CharPredicate.anyOf(".)");
/* 448 */     static final SpecialLeadInHandler ORDERED_DELIM_DOT_HANDLER = (SpecialLeadInHandler)new ListItemLeadInHandler((CharSequence)Parser.LISTS_ITEM_PREFIX_CHARS.getDefaultValue(), true);
/* 449 */     static final SpecialLeadInHandler ORDERED_DELIM_DOT_PARENS_HANDLER = (SpecialLeadInHandler)new ListItemLeadInHandler((CharSequence)Parser.LISTS_ITEM_PREFIX_CHARS.getDefaultValue(), false);
/*     */     final CharPredicate orderedDelims;
/*     */     
/*     */     static SpecialLeadInHandler create(CharSequence param1CharSequence, boolean param1Boolean) {
/* 453 */       return (SpecialLeadInHandler)(SequenceUtils.equals((CharSequence)Parser.LISTS_ITEM_PREFIX_CHARS.getDefaultValue(), param1CharSequence) ? (param1Boolean ? ORDERED_DELIM_DOT_HANDLER : ORDERED_DELIM_DOT_PARENS_HANDLER) : new ListItemLeadInHandler(param1CharSequence, param1Boolean));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ListItemLeadInHandler(CharSequence param1CharSequence, boolean param1Boolean) {
/* 461 */       super(CharPredicate.anyOf(param1CharSequence));
/* 462 */       this.orderedDelims = param1Boolean ? ORDERED_DELIM_DOT : ORDERED_DELIM_DOT_PARENS;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean escape(BasedSequence param1BasedSequence, DataHolder param1DataHolder, Consumer<CharSequence> param1Consumer) {
/* 467 */       if (super.escape(param1BasedSequence, param1DataHolder, param1Consumer)) return true;  int i;
/* 468 */       if (((Boolean)SharedDataKeys.ESCAPE_NUMBERED_LEAD_IN.get(param1DataHolder)).booleanValue() && (
/*     */         
/* 470 */         i = param1BasedSequence.indexOfAnyNot(CharPredicate.DECIMAL_DIGITS)) > 0 && i + 1 == param1BasedSequence.length() && this.orderedDelims.test(param1BasedSequence.charAt(i))) {
/* 471 */         param1Consumer.accept(param1BasedSequence.subSequence(0, i));
/* 472 */         param1Consumer.accept("\\");
/* 473 */         param1Consumer.accept(param1BasedSequence.subSequence(i));
/* 474 */         return true;
/*     */       } 
/*     */       
/* 477 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean unEscape(BasedSequence param1BasedSequence, DataHolder param1DataHolder, Consumer<CharSequence> param1Consumer) {
/* 482 */       if (super.unEscape(param1BasedSequence, param1DataHolder, param1Consumer)) return true; 
/*     */       int i;
/* 484 */       if ((i = param1BasedSequence.indexOfAnyNot(CharPredicate.DECIMAL_DIGITS)) > 0 && i + 2 == param1BasedSequence.length() && param1BasedSequence.charAt(i) == '\\' && this.orderedDelims.test(param1BasedSequence.charAt(i + 1))) {
/* 485 */         param1Consumer.accept(param1BasedSequence.subSequence(0, i));
/* 486 */         param1Consumer.accept(param1BasedSequence.subSequence(i + 1));
/* 487 */         return true;
/*     */       } 
/* 489 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class BlockFactory extends AbstractBlockParserFactory {
/*     */     private final ListOptions myOptions;
/*     */     
/*     */     BlockFactory(DataHolder param1DataHolder) {
/* 497 */       super(param1DataHolder);
/* 498 */       this.myOptions = ListOptions.get(param1DataHolder);
/*     */     }
/*     */     public BlockStart tryStart(ParserState param1ParserState, MatchedBlockParser param1MatchedBlockParser) {
/*     */       int i;
/*     */       ListItemParser listItemParser;
/* 503 */       BlockParser blockParser = param1MatchedBlockParser.getBlockParser();
/* 504 */       ParserEmulationProfile parserEmulationProfile = (this.myOptions.getParserEmulationProfile()).family;
/* 505 */       int j = this.myOptions.getNewItemCodeIndent();
/*     */       
/* 507 */       if (blockParser instanceof ListBlockParser) {
/*     */         
/* 509 */         ListBlockParser listBlockParser1 = (ListBlockParser)blockParser;
/*     */         
/* 511 */         if (param1ParserState.getLine() == listBlockParser1.myItemHandledLine) {
/* 512 */           if (listBlockParser1.myItemHandledNewListLine) {
/*     */             
/* 514 */             ListBlockParser.ListData listData1 = ListBlockParser.parseListMarker(this.myOptions, j, param1ParserState);
/* 515 */             listItemParser = new ListItemParser(this.myOptions, param1ParserState.getParsing(), listData1);
/*     */             
/* 517 */             assert listData1 != null;
/*     */             
/* 519 */             i = listData1.markerColumn + listData1.listMarker.length() + listData1.contentOffset;
/* 520 */             listBlockParser1 = new ListBlockParser(this.myOptions, listData1, listItemParser);
/* 521 */             return BlockStart.of(new BlockParser[] { (BlockParser)listBlockParser1, (BlockParser)listItemParser }).atColumn(i);
/* 522 */           }  if (listBlockParser1.myItemHandledNewItemLine) {
/*     */             
/* 524 */             ListBlockParser.ListData listData1 = ListBlockParser.parseListMarker(this.myOptions, j, param1ParserState);
/* 525 */             listItemParser = new ListItemParser(this.myOptions, param1ParserState.getParsing(), listData1);
/*     */             
/* 527 */             assert listData1 != null;
/*     */             
/* 529 */             i = listData1.markerColumn + listData1.listMarker.length() + listData1.contentOffset;
/* 530 */             listBlockParser1.myLastChild = listItemParser;
/*     */             
/* 532 */             return BlockStart.of(new BlockParser[] { (BlockParser)listItemParser }).atColumn(i);
/*     */           } 
/*     */ 
/*     */           
/* 536 */           listBlockParser1.myItemHandledLine = null;
/* 537 */           return BlockStart.none();
/*     */         } 
/*     */ 
/*     */         
/* 541 */         return BlockStart.none();
/*     */       } 
/*     */       ListBlock listBlock;
/*     */       ListBlockParser listBlockParser;
/* 545 */       if ((listBlock = (ListBlock)i.getBlock().getAncestorOfType(new Class[] { ListBlock.class })) != null && 
/*     */         
/* 547 */         (listBlockParser = (ListBlockParser)param1ParserState.getActiveBlockParser((Block)listBlock)).myItemHandledLine == param1ParserState.getLine() && listBlockParser.myItemHandledSkipActiveLine) {
/* 548 */         listBlockParser.myItemHandledLine = null;
/* 549 */         return BlockStart.none();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 559 */       if (listItemParser == ParserEmulationProfile.COMMONMARK) {
/*     */         int k;
/* 561 */         if ((k = param1ParserState.getIndent()) >= this.myOptions.getCodeIndent()) {
/* 562 */           return BlockStart.none();
/*     */         }
/* 564 */       } else if (listItemParser == ParserEmulationProfile.FIXED_INDENT) {
/*     */         int k;
/* 566 */         if ((k = param1ParserState.getIndent()) >= this.myOptions.getItemIndent()) {
/* 567 */           return BlockStart.none();
/*     */         }
/* 569 */       } else if (listItemParser == ParserEmulationProfile.KRAMDOWN) {
/*     */         int k;
/* 571 */         if ((k = param1ParserState.getIndent()) >= this.myOptions.getItemIndent())
/* 572 */           return BlockStart.none(); 
/*     */       } else {
/* 574 */         int k; if (listItemParser == ParserEmulationProfile.MARKDOWN && (
/*     */           
/* 576 */           k = param1ParserState.getIndent()) >= this.myOptions.getItemIndent()) {
/* 577 */           return BlockStart.none();
/*     */         }
/*     */       } 
/*     */       
/*     */       ListBlockParser.ListData listData;
/*     */       
/* 583 */       if ((listData = ListBlockParser.parseListMarker(this.myOptions, j, param1ParserState)) != null) {
/* 584 */         int k = listData.markerColumn + listData.listMarker.length() + listData.contentOffset;
/*     */         
/*     */         boolean bool;
/* 587 */         i = ((bool = i.isParagraphParser()) && i.getBlock().getParent() instanceof ListItem && i.getBlock() == i.getBlock().getParent().getFirstChild()) ? 1 : 0;
/*     */         
/* 589 */         if (bool && !this.myOptions.canInterrupt(listData.listBlock, listData.isEmpty, i)) {
/* 590 */           return BlockStart.none();
/*     */         }
/*     */         
/* 593 */         ListItemParser listItemParser1 = new ListItemParser(this.myOptions, param1ParserState.getParsing(), listData);
/*     */ 
/*     */         
/* 596 */         ListBlockParser listBlockParser1 = new ListBlockParser(this.myOptions, listData, listItemParser1);
/* 597 */         return BlockStart.of(new BlockParser[] { (BlockParser)listBlockParser1, (BlockParser)listItemParser1 }).atColumn(k);
/*     */       } 
/*     */       
/* 600 */       return BlockStart.none();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class ListData
/*     */   {
/*     */     final ListBlock listBlock;
/*     */     
/*     */     final boolean isEmpty;
/*     */     
/*     */     final int markerIndex;
/*     */     
/*     */     final int markerColumn;
/*     */     
/*     */     final int markerIndent;
/*     */     
/*     */     final int contentOffset;
/*     */     
/*     */     final BasedSequence listMarker;
/*     */     
/*     */     final boolean isNumberedList;
/*     */     
/*     */     final BasedSequence markerSuffix;
/*     */     
/*     */     final int markerSuffixOffset;
/*     */     
/*     */     ListData(ListBlock param1ListBlock, boolean param1Boolean1, int param1Int1, int param1Int2, int param1Int3, int param1Int4, BasedSequence param1BasedSequence1, boolean param1Boolean2, BasedSequence param1BasedSequence2, int param1Int5) {
/* 628 */       this.listBlock = param1ListBlock;
/* 629 */       this.isEmpty = param1Boolean1;
/* 630 */       this.markerIndex = param1Int1;
/* 631 */       this.markerColumn = param1Int2;
/* 632 */       this.markerIndent = param1Int3;
/* 633 */       this.contentOffset = param1Int4;
/* 634 */       this.listMarker = param1BasedSequence1;
/* 635 */       this.isNumberedList = param1Boolean2;
/* 636 */       this.markerSuffix = param1BasedSequence2;
/* 637 */       this.markerSuffixOffset = param1Int5;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\ListBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */