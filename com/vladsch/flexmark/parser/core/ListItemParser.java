/*     */ package com.vladsch.flexmark.parser.core;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.BulletListItem;
/*     */ import com.vladsch.flexmark.ast.ListItem;
/*     */ import com.vladsch.flexmark.ast.OrderedListItem;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.parser.ListOptions;
/*     */ import com.vladsch.flexmark.parser.Parser;
/*     */ import com.vladsch.flexmark.parser.ParserEmulationProfile;
/*     */ import com.vladsch.flexmark.parser.block.AbstractBlockParser;
/*     */ import com.vladsch.flexmark.parser.block.BlockContinue;
/*     */ import com.vladsch.flexmark.parser.block.BlockParser;
/*     */ import com.vladsch.flexmark.parser.block.ParserState;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ 
/*     */ public class ListItemParser
/*     */   extends AbstractBlockParser
/*     */ {
/*     */   private final ListItem myBlock;
/*     */   private final ListOptions myOptions;
/*     */   private final ListBlockParser.ListData myListData;
/*     */   
/*     */   ListItemParser(ListOptions paramListOptions, Parsing paramParsing, ListBlockParser.ListData paramListData) {
/*  27 */     this.myOptions = paramListOptions;
/*  28 */     this.myListData = paramListData;
/*  29 */     this.myParsing = paramParsing;
/*  30 */     this.myBlock = this.myListData.isNumberedList ? (ListItem)new OrderedListItem() : (ListItem)new BulletListItem();
/*  31 */     this.myBlock.setOpeningMarker(this.myListData.listMarker);
/*  32 */     this.myBlock.setMarkerSuffix(this.myListData.markerSuffix);
/*     */   }
/*     */   private final Parsing myParsing; private boolean myHadBlankLine = false; private boolean myIsEmpty = false;
/*     */   
/*     */   int getContentColumn() {
/*  37 */     return this.myListData.markerColumn + this.myListData.listMarker.length() + (this.myOptions.isItemContentAfterSuffix() ? this.myListData.contentOffset : this.myListData.markerSuffixOffset);
/*     */   }
/*     */ 
/*     */   
/*     */   int getContentIndent() {
/*  42 */     return this.myListData.markerIndent + this.myListData.listMarker.length() + (this.myOptions.isItemContentAfterSuffix() ? this.myListData.contentOffset : this.myListData.markerSuffixOffset);
/*     */   }
/*     */   
/*     */   int getMarkerContentIndent() {
/*  46 */     return this.myListData.markerIndent + this.myListData.listMarker.length() + 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  57 */     if (paramBlock instanceof com.vladsch.flexmark.ast.FencedCodeBlock)
/*     */     {
/*  59 */       if (Parser.PARSER_EMULATION_PROFILE.get((DataHolder)paramParserState.getProperties()) == ParserEmulationProfile.GITHUB_DOC) {
/*     */         
/*  61 */         FencedCodeBlockParser fencedCodeBlockParser = (FencedCodeBlockParser)paramBlockParser;
/*  62 */         return (this.myListData.markerIndent < fencedCodeBlockParser.getFenceMarkerIndent());
/*     */       } 
/*     */     }
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPropagatingLastBlankLine(BlockParser paramBlockParser) {
/*  70 */     return (this.myBlock.getFirstChild() != null || this == paramBlockParser);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  75 */     return (Block)this.myBlock;
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeBlock(ParserState paramParserState) {
/*  80 */     this.myBlock.setCharsFromContent();
/*     */   }
/*     */ 
/*     */   
/*     */   private BlockContinue continueAtColumn(int paramInt) {
/*  85 */     if (this.myHadBlankLine) {
/*  86 */       this.myBlock.setContainsBlankLine(true);
/*     */     }
/*  88 */     this.myIsEmpty = false;
/*  89 */     return BlockContinue.atColumn(paramInt);
/*     */   }
/*     */   
/*     */   public BlockContinue tryContinue(ParserState paramParserState) {
/*     */     boolean bool;
/*  94 */     if (paramParserState.isBlank()) {
/*     */       
/*  96 */       Node node = this.myBlock.getFirstChild();
/*  97 */       this.myIsEmpty = (node == null);
/*  98 */       if (this.myIsEmpty || node.getNext() == null) {
/*  99 */         this.myBlock.setHadBlankAfterItemParagraph(true);
/*     */       }
/* 101 */       this.myHadBlankLine = true;
/* 102 */       return BlockContinue.atIndex(paramParserState.getNextNonSpaceIndex());
/*     */     } 
/*     */     
/* 105 */     assert this.myBlock.getParent() instanceof com.vladsch.flexmark.ast.ListBlock;
/*     */     
/* 107 */     ListBlockParser listBlockParser = (ListBlockParser)paramParserState.getActiveBlockParser(this.myBlock.getParent());
/*     */ 
/*     */     
/* 110 */     ParserEmulationProfile parserEmulationProfile1, parserEmulationProfile2 = (parserEmulationProfile1 = this.myOptions.getParserEmulationProfile()).family;
/* 111 */     int i = getContentIndent();
/* 112 */     if (parserEmulationProfile2 == ParserEmulationProfile.COMMONMARK) {
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
/* 126 */       int j = paramParserState.getIndent();
/* 127 */       int k = paramParserState.getColumn() + i;
/*     */       
/* 129 */       if (j >= i + this.myOptions.getCodeIndent()) {
/*     */         
/* 131 */         listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 132 */         return continueAtColumn(k);
/*     */       } 
/* 134 */       ListBlockParser.ListData listData = ListBlockParser.parseListMarker(this.myOptions, this.myOptions.getCodeIndent(), paramParserState);
/*     */       
/* 136 */       if (j >= i) {
/* 137 */         if (listData != null) {
/*     */           BlockParser blockParser;
/*     */           
/*     */           boolean bool1;
/*     */           boolean bool2;
/* 142 */           if ((bool2 = ((bool1 = (blockParser = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser.getBlock().getParent() instanceof ListItem && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild()) ? true : false) && (
/* 143 */             !this.myOptions.canInterrupt(listData.listBlock, listData.isEmpty, true) || 
/* 144 */             !this.myOptions.canStartSubList(listData.listBlock, listData.isEmpty))) {
/*     */             
/* 146 */             listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 147 */             return continueAtColumn(k);
/*     */           } 
/*     */           
/* 150 */           listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 151 */           return continueAtColumn(k);
/*     */         } 
/*     */         
/* 154 */         if (this.myIsEmpty) {
/*     */           
/* 156 */           listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 157 */           return BlockContinue.none();
/*     */         } 
/* 159 */         listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 160 */         return continueAtColumn(k);
/*     */       } 
/*     */       
/* 163 */       if (listData != null) {
/* 164 */         if (!this.myHadBlankLine && !this.myOptions.canInterrupt(listData.listBlock, listData.isEmpty, true)) {
/*     */           
/* 166 */           listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 167 */           return continueAtColumn(paramParserState.getColumn() + j);
/*     */         } 
/*     */ 
/*     */         
/* 171 */         if (!(bool = (this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) ? true : false) && this.myOptions.startSubList(listBlockParser.getBlock(), listData.listBlock)) {
/*     */           
/* 173 */           listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 174 */           return continueAtColumn(paramParserState.getColumn() + j);
/*     */         } 
/* 176 */         if (this.myOptions.startNewList(listBlockParser.getBlock(), listData.listBlock)) {
/*     */           
/* 178 */           listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 179 */           return BlockContinue.none();
/*     */         } 
/*     */         
/* 182 */         listBlockParser.setItemHandledNewItemLine(paramParserState.getLine());
/* 183 */         return BlockContinue.none();
/*     */       } 
/*     */     } else {
/*     */       ListBlockParser.ListData listData;
/*     */ 
/*     */ 
/*     */       
/* 190 */       int j = this.myOptions.getItemIndent();
/*     */       
/* 192 */       if (bool == ParserEmulationProfile.FIXED_INDENT) {
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
/* 205 */         int m = paramParserState.getIndent();
/*     */ 
/*     */         
/* 208 */         int k = paramParserState.getColumn() + j;
/*     */         
/* 210 */         if (m >= this.myOptions.getCodeIndent()) {
/*     */           BlockParser blockParser;
/* 212 */           if (this.myBlock.getFirstChild() != null && this.myBlock.getFirstChild() == this.myBlock.getLastChild() && (
/*     */             
/* 214 */             blockParser = paramParserState.getActiveBlockParser()).isParagraphParser() && blockParser.getBlock() == this.myBlock.getFirstChild()) {
/*     */             
/* 216 */             listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 217 */             return continueAtColumn(k);
/*     */           } 
/*     */ 
/*     */           
/* 221 */           listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 222 */           return continueAtColumn(k);
/*     */         } 
/* 224 */         listData = ListBlockParser.parseListMarker(this.myOptions, -1, paramParserState);
/*     */         
/* 226 */         if (m >= j) {
/* 227 */           if (listData != null) {
/*     */             BlockParser blockParser;
/*     */             
/*     */             boolean bool1;
/*     */             
/* 232 */             if ((i = ((bool1 = (blockParser = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser.getBlock().getParent() instanceof ListItem && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild()) ? 1 : 0) != 0 && (!this.myOptions.canInterrupt(listData.listBlock, listData.isEmpty, true) || 
/* 233 */               !this.myOptions.canStartSubList(listData.listBlock, listData.isEmpty))) {
/*     */               
/* 235 */               listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 236 */               return continueAtColumn(paramParserState.getColumn() + m);
/*     */             } 
/*     */             
/* 239 */             listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 240 */             return continueAtColumn(k);
/*     */           } 
/*     */ 
/*     */           
/* 244 */           if (this.myIsEmpty) {
/* 245 */             listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 246 */             return BlockContinue.none();
/*     */           } 
/* 248 */           listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 249 */           return continueAtColumn(k);
/*     */         } 
/*     */         
/* 252 */         if (listData != null) {
/* 253 */           if (!this.myHadBlankLine && !this.myOptions.canInterrupt(listData.listBlock, listData.isEmpty, true)) {
/*     */             
/* 255 */             listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 256 */             return continueAtColumn(paramParserState.getColumn() + m);
/*     */           } 
/*     */           
/*     */           boolean bool1;
/* 260 */           if (!(bool1 = (this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) ? true : false) && this.myOptions.startSubList(listBlockParser.getBlock(), listData.listBlock)) {
/*     */             
/* 262 */             listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 263 */             return continueAtColumn(paramParserState.getColumn() + m);
/*     */           } 
/* 265 */           if (this.myOptions.startNewList(listBlockParser.getBlock(), listData.listBlock)) {
/*     */             
/* 267 */             listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 268 */             return BlockContinue.none();
/*     */           } 
/*     */           
/* 271 */           listBlockParser.setItemHandledNewItemLine(paramParserState.getLine());
/* 272 */           return BlockContinue.none();
/*     */         } 
/*     */       } else {
/*     */         int k;
/*     */         
/*     */         boolean bool1;
/*     */         
/* 279 */         int m = (listBlockParser.getListData()).markerIndent;
/* 280 */         if (listData == ParserEmulationProfile.KRAMDOWN) {
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
/* 296 */           k = paramParserState.getIndent();
/*     */           
/* 298 */           int n = paramParserState.getColumn() + i;
/*     */           
/* 300 */           ListBlockParser.ListData listData1 = ListBlockParser.parseListMarker(this.myOptions, -1, paramParserState);
/*     */           
/* 302 */           if (k >= i) {
/*     */             
/* 304 */             if (listData1 != null) {
/*     */               BlockParser blockParser;
/*     */ 
/*     */ 
/*     */               
/* 309 */               if ((m = ((bool1 = (blockParser = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser.getBlock().getParent() instanceof ListItem && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild()) ? 1 : 0) != 0 && (
/* 310 */                 !this.myOptions.canInterrupt(listData1.listBlock, listData1.isEmpty, true) || 
/* 311 */                 !this.myOptions.canStartSubList(listData1.listBlock, listData1.isEmpty))) {
/*     */                 
/* 313 */                 listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 314 */                 return continueAtColumn(n);
/*     */               } 
/*     */               
/* 317 */               listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 318 */               return continueAtColumn(n);
/*     */             } 
/*     */ 
/*     */             
/* 322 */             if (this.myIsEmpty) {
/* 323 */               listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 324 */               return BlockContinue.none();
/*     */             } 
/* 326 */             listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 327 */             return continueAtColumn(n);
/*     */           } 
/*     */ 
/*     */           
/* 331 */           if (k >= m + bool1) {
/* 332 */             if (this.myHadBlankLine) {
/*     */               
/* 334 */               if (this.myBlock.isHadBlankAfterItemParagraph()) this.myBlock.setLoose(true); 
/* 335 */               listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 336 */               return BlockContinue.none();
/*     */             } 
/*     */             
/* 339 */             listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 340 */             return continueAtColumn(paramParserState.getColumn() + k);
/*     */           } 
/* 342 */           if (listData1 != null && 
/* 343 */             k >= m) {
/*     */ 
/*     */             
/* 346 */             if ((i = (this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) ? 1 : 0) == 0 && this.myOptions.startSubList(listBlockParser.getBlock(), listData1.listBlock)) {
/*     */               
/* 348 */               listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 349 */               return continueAtColumn(paramParserState.getColumn() + k);
/*     */             } 
/* 351 */             if (this.myOptions.startNewList(listBlockParser.getBlock(), listData1.listBlock)) {
/*     */               
/* 353 */               listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 354 */               return BlockContinue.none();
/*     */             } 
/*     */             
/* 357 */             listBlockParser.setItemHandledNewItemLine(paramParserState.getLine());
/* 358 */             return BlockContinue.none();
/*     */           } 
/*     */         } else {
/*     */           boolean bool2;
/*     */           
/*     */           BlockParser blockParser;
/* 364 */           if (k == ParserEmulationProfile.GITHUB_DOC) {
/*     */             boolean bool3;
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
/* 378 */             k = paramParserState.getIndent();
/* 379 */             paramParserState.getIndex();
/*     */             
/* 381 */             int n = Utils.maxLimit(k, new int[] { i, m + 4 });
/*     */             
/* 383 */             if (k >= this.myOptions.getCodeIndent()) {
/*     */               
/* 385 */               listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 386 */               return continueAtColumn(paramParserState.getColumn() + Utils.maxLimit(i, new int[] { bool1 }));
/*     */             } 
/* 388 */             ListBlockParser.ListData listData1 = ListBlockParser.parseListMarker(this.myOptions, -1, paramParserState);
/*     */             
/* 390 */             if (k > bool1) {
/* 391 */               BlockParser blockParser1; if (listData1 != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 397 */                 if ((bool2 = ((bool3 = (blockParser1 = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser1.getBlock().getParent() instanceof ListItem && blockParser1.getBlock() == blockParser1.getBlock().getParent().getFirstChild())) && (
/* 398 */                   !this.myOptions.canInterrupt(listData1.listBlock, listData1.isEmpty, true) || 
/* 399 */                   !this.myOptions.canStartSubList(listData1.listBlock, listData1.isEmpty))) {
/*     */                   
/* 401 */                   listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 402 */                   return continueAtColumn(paramParserState.getColumn() + k);
/*     */                 } 
/*     */                 
/* 405 */                 listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 406 */                 return continueAtColumn(paramParserState.getColumn() + n);
/*     */               } 
/*     */ 
/*     */               
/* 410 */               listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 411 */               return continueAtColumn(paramParserState.getColumn() + blockParser1);
/*     */             } 
/*     */             
/* 414 */             if (k > bool3) {
/* 415 */               if (listData1 != null) {
/*     */                 BlockParser blockParser1;
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 421 */                 if ((bool2 = ((bool3 = (blockParser1 = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser1.getBlock().getParent() instanceof ListItem && blockParser1.getBlock() == blockParser1.getBlock().getParent().getFirstChild())) && (
/* 422 */                   !this.myOptions.canInterrupt(listData1.listBlock, listData1.isEmpty, true) || 
/* 423 */                   !this.myOptions.canStartSubList(listData1.listBlock, listData1.isEmpty))) {
/*     */                   
/* 425 */                   listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 426 */                   return continueAtColumn(paramParserState.getColumn() + k);
/*     */                 } 
/*     */                 
/* 429 */                 listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 430 */                 return continueAtColumn(paramParserState.getColumn() + n);
/*     */               } 
/*     */ 
/*     */               
/* 434 */               listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 435 */               return continueAtColumn(paramParserState.getColumn() + n);
/*     */             } 
/*     */             
/* 438 */             if (listData1 != null) {
/*     */ 
/*     */ 
/*     */               
/* 442 */               if (!(bool1 = (this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine)) && this.myOptions.startSubList(listBlockParser.getBlock(), listData1.listBlock)) {
/*     */                 
/* 444 */                 listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 445 */                 return continueAtColumn(paramParserState.getColumn() + n);
/*     */               } 
/* 447 */               if (this.myOptions.startNewList(listBlockParser.getBlock(), listData1.listBlock)) {
/*     */                 
/* 449 */                 listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 450 */                 return BlockContinue.none();
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 456 */               if ((bool2 = ((bool2 = (blockParser = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser.getBlock().getParent() instanceof ListItem && blockParser.getBlock() == blockParser.getBlock().getParent().getFirstChild())) && (
/* 457 */                 !this.myOptions.canInterrupt(listData1.listBlock, listData1.isEmpty, true) || 
/* 458 */                 !this.myOptions.canStartSubList(listData1.listBlock, listData1.isEmpty))) {
/*     */                 
/* 460 */                 listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 461 */                 return continueAtColumn(paramParserState.getColumn() + k);
/*     */               } 
/*     */               
/* 464 */               listBlockParser.setItemHandledNewItemLine(paramParserState.getLine());
/* 465 */               return BlockContinue.none();
/*     */             } 
/*     */ 
/*     */             
/* 469 */             if (!this.myHadBlankLine || paramParserState.getActiveBlockParser() instanceof FencedCodeBlockParser)
/*     */             {
/*     */               
/* 472 */               listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 473 */               return continueAtColumn(paramParserState.getColumn() + k);
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 478 */           else if (bool2 == ParserEmulationProfile.MARKDOWN) {
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
/* 494 */             if ((k = paramParserState.getIndent()) >= this.myOptions.getCodeIndent()) {
/*     */               
/* 496 */               listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 497 */               return continueAtColumn(paramParserState.getColumn() + bool1);
/*     */             } 
/* 499 */             ListBlockParser.ListData listData1 = ListBlockParser.parseListMarker(this.myOptions, -1, paramParserState);
/*     */             
/* 501 */             if (k > bool1) {
/* 502 */               if (listData1 != null) {
/*     */                 BlockParser blockParser1;
/*     */ 
/*     */                 
/*     */                 boolean bool3;
/*     */                 
/* 508 */                 if ((i = ((bool3 = (blockParser1 = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser1.getBlock().getParent() instanceof ListItem && blockParser1.getBlock() == blockParser1.getBlock().getParent().getFirstChild()) ? 1 : 0) != 0 && (
/* 509 */                   !this.myOptions.canInterrupt(listData1.listBlock, listData1.isEmpty, true) || 
/* 510 */                   !this.myOptions.canStartSubList(listData1.listBlock, listData1.isEmpty))) {
/*     */                   
/* 512 */                   listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 513 */                   return continueAtColumn(paramParserState.getColumn() + k);
/*     */                 } 
/*     */                 
/* 516 */                 listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 517 */                 return continueAtColumn(paramParserState.getColumn() + bool1);
/*     */               } 
/*     */ 
/*     */               
/* 521 */               listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 522 */               return continueAtColumn(paramParserState.getColumn() + bool1);
/*     */             } 
/*     */ 
/*     */             
/* 526 */             if (k > blockParser) {
/* 527 */               if (listData1 != null) {
/*     */                 boolean bool3;
/*     */ 
/*     */                 
/*     */                 BlockParser blockParser1;
/*     */                 
/* 533 */                 if ((bool1 = ((bool3 = (blockParser1 = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser1.getBlock().getParent() instanceof ListItem && blockParser1.getBlock() == blockParser1.getBlock().getParent().getFirstChild())) && (
/* 534 */                   !this.myOptions.canInterrupt(listData1.listBlock, listData1.isEmpty, true) || 
/* 535 */                   !this.myOptions.canStartSubList(listData1.listBlock, listData1.isEmpty))) {
/*     */                   
/* 537 */                   listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 538 */                   return continueAtColumn(paramParserState.getColumn() + k);
/*     */                 } 
/*     */                 
/* 541 */                 listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 542 */                 return continueAtColumn(paramParserState.getColumn() + k);
/*     */               } 
/*     */ 
/*     */               
/* 546 */               listBlockParser.setItemHandledLine(paramParserState.getLine());
/* 547 */               return continueAtColumn(paramParserState.getColumn() + k);
/*     */             } 
/* 549 */             if (listData1 != null) {
/*     */               boolean bool4;
/*     */ 
/*     */               
/* 553 */               if (!(bool4 = (this.myOptions.isItemTypeMismatchToNewList() && this.myOptions.isItemTypeMismatchToSubList() && this.myHadBlankLine) ? true : false) && this.myOptions.startSubList(listBlockParser.getBlock(), listData1.listBlock)) {
/*     */                 
/* 555 */                 listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 556 */                 return continueAtColumn(paramParserState.getColumn() + k);
/*     */               } 
/* 558 */               if (this.myOptions.startNewList(listBlockParser.getBlock(), listData1.listBlock)) {
/*     */                 
/* 560 */                 listBlockParser.setItemHandledNewListLine(paramParserState.getLine());
/* 561 */                 return BlockContinue.none();
/*     */               } 
/*     */               
/*     */               BlockParser blockParser1;
/*     */               
/*     */               boolean bool3;
/* 567 */               if ((bool3 = ((bool1 = (blockParser1 = paramParserState.getActiveBlockParser()).isParagraphParser()) && blockParser1.getBlock().getParent() instanceof ListItem && blockParser1.getBlock() == blockParser1.getBlock().getParent().getFirstChild()) ? true : false) && (
/* 568 */                 !this.myOptions.canInterrupt(listData1.listBlock, listData1.isEmpty, true) || 
/* 569 */                 !this.myOptions.canStartSubList(listData1.listBlock, listData1.isEmpty))) {
/*     */                 
/* 571 */                 listBlockParser.setItemHandledLineSkipActive(paramParserState.getLine());
/* 572 */                 return continueAtColumn(paramParserState.getColumn() + k);
/*     */               } 
/*     */               
/* 575 */               listBlockParser.setItemHandledNewItemLine(paramParserState.getLine());
/* 576 */               return BlockContinue.none();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 586 */     return BlockContinue.none();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\core\ListItemParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */