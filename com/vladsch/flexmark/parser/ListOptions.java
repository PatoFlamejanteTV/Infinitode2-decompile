/*     */ package com.vladsch.flexmark.parser;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.BulletList;
/*     */ import com.vladsch.flexmark.ast.ListBlock;
/*     */ import com.vladsch.flexmark.ast.ListItem;
/*     */ import com.vladsch.flexmark.ast.OrderedList;
/*     */ import com.vladsch.flexmark.ast.Paragraph;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class ListOptions implements MutableDataSetter {
/*     */   protected ParserEmulationProfile myParserEmulationProfile;
/*     */   protected ItemInterrupt itemInterrupt;
/*     */   protected boolean autoLoose;
/*     */   protected boolean autoLooseOneLevelLists;
/*     */   protected boolean delimiterMismatchToNewList;
/*     */   protected boolean endOnDoubleBlank;
/*     */   protected boolean itemMarkerSpace;
/*     */   protected boolean itemTypeMismatchToNewList;
/*     */   protected boolean itemTypeMismatchToSubList;
/*     */   protected boolean looseWhenPrevHasTrailingBlankLine;
/*     */   protected boolean looseWhenLastItemPrevHasTrailingBlankLine;
/*     */   protected boolean looseWhenHasNonListChildren;
/*     */   protected boolean looseWhenBlankLineFollowsItemParagraph;
/*     */   protected boolean looseWhenHasLooseSubItem;
/*     */   protected boolean looseWhenHasTrailingBlankLine;
/*     */   protected boolean looseWhenContainsBlankLine;
/*     */   protected boolean numberedItemMarkerSuffixed;
/*     */   protected boolean orderedItemDotOnly;
/*     */   protected boolean orderedListManualStart;
/*     */   protected boolean itemContentAfterSuffix;
/*     */   protected String itemPrefixChars;
/*     */   protected int codeIndent;
/*     */   protected int itemIndent;
/*     */   protected int newItemCodeIndent;
/*     */   protected String[] itemMarkerSuffixes;
/*     */   
/*     */   public ListOptions() {
/*  42 */     this((DataHolder)null);
/*     */   }
/*     */   
/*     */   private ListOptions(DataHolder paramDataHolder) {
/*  46 */     this.myParserEmulationProfile = (ParserEmulationProfile)Parser.PARSER_EMULATION_PROFILE.get(paramDataHolder);
/*  47 */     this.itemInterrupt = new ItemInterrupt(paramDataHolder);
/*     */     
/*  49 */     this.autoLoose = ((Boolean)Parser.LISTS_AUTO_LOOSE.get(paramDataHolder)).booleanValue();
/*  50 */     this.autoLooseOneLevelLists = ((Boolean)Parser.LISTS_AUTO_LOOSE_ONE_LEVEL_LISTS.get(paramDataHolder)).booleanValue();
/*  51 */     this.delimiterMismatchToNewList = ((Boolean)Parser.LISTS_DELIMITER_MISMATCH_TO_NEW_LIST.get(paramDataHolder)).booleanValue();
/*  52 */     this.endOnDoubleBlank = ((Boolean)Parser.LISTS_END_ON_DOUBLE_BLANK.get(paramDataHolder)).booleanValue();
/*  53 */     this.itemMarkerSpace = ((Boolean)Parser.LISTS_ITEM_MARKER_SPACE.get(paramDataHolder)).booleanValue();
/*  54 */     this.itemTypeMismatchToNewList = ((Boolean)Parser.LISTS_ITEM_TYPE_MISMATCH_TO_NEW_LIST.get(paramDataHolder)).booleanValue();
/*  55 */     this.itemTypeMismatchToSubList = ((Boolean)Parser.LISTS_ITEM_TYPE_MISMATCH_TO_SUB_LIST.get(paramDataHolder)).booleanValue();
/*  56 */     this.looseWhenPrevHasTrailingBlankLine = ((Boolean)Parser.LISTS_LOOSE_WHEN_PREV_HAS_TRAILING_BLANK_LINE.get(paramDataHolder)).booleanValue();
/*  57 */     this.looseWhenLastItemPrevHasTrailingBlankLine = ((Boolean)Parser.LISTS_LOOSE_WHEN_LAST_ITEM_PREV_HAS_TRAILING_BLANK_LINE.get(paramDataHolder)).booleanValue();
/*  58 */     this.looseWhenHasNonListChildren = ((Boolean)Parser.LISTS_LOOSE_WHEN_HAS_NON_LIST_CHILDREN.get(paramDataHolder)).booleanValue();
/*  59 */     this.looseWhenBlankLineFollowsItemParagraph = ((Boolean)Parser.LISTS_LOOSE_WHEN_BLANK_LINE_FOLLOWS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/*  60 */     this.looseWhenHasLooseSubItem = ((Boolean)Parser.LISTS_LOOSE_WHEN_HAS_LOOSE_SUB_ITEM.get(paramDataHolder)).booleanValue();
/*  61 */     this.looseWhenHasTrailingBlankLine = ((Boolean)Parser.LISTS_LOOSE_WHEN_HAS_TRAILING_BLANK_LINE.get(paramDataHolder)).booleanValue();
/*  62 */     this.looseWhenContainsBlankLine = ((Boolean)Parser.LISTS_LOOSE_WHEN_CONTAINS_BLANK_LINE.get(paramDataHolder)).booleanValue();
/*  63 */     this.numberedItemMarkerSuffixed = ((Boolean)Parser.LISTS_NUMBERED_ITEM_MARKER_SUFFIXED.get(paramDataHolder)).booleanValue();
/*  64 */     this.orderedItemDotOnly = ((Boolean)Parser.LISTS_ORDERED_ITEM_DOT_ONLY.get(paramDataHolder)).booleanValue();
/*  65 */     this.orderedListManualStart = ((Boolean)Parser.LISTS_ORDERED_LIST_MANUAL_START.get(paramDataHolder)).booleanValue();
/*  66 */     this.itemContentAfterSuffix = ((Boolean)Parser.LISTS_ITEM_CONTENT_AFTER_SUFFIX.get(paramDataHolder)).booleanValue();
/*  67 */     this.itemPrefixChars = (String)Parser.LISTS_ITEM_PREFIX_CHARS.get(paramDataHolder);
/*     */     
/*  69 */     this.codeIndent = ((Integer)Parser.LISTS_CODE_INDENT.get(paramDataHolder)).intValue();
/*  70 */     this.itemIndent = ((Integer)Parser.LISTS_ITEM_INDENT.get(paramDataHolder)).intValue();
/*  71 */     this.newItemCodeIndent = ((Integer)Parser.LISTS_NEW_ITEM_CODE_INDENT.get(paramDataHolder)).intValue();
/*  72 */     this.itemMarkerSuffixes = (String[])Parser.LISTS_ITEM_MARKER_SUFFIXES.get(paramDataHolder);
/*     */   }
/*     */   
/*     */   ListOptions(ListOptions paramListOptions) {
/*  76 */     this.myParserEmulationProfile = paramListOptions.getParserEmulationProfile();
/*  77 */     this.itemInterrupt = new ItemInterrupt(paramListOptions.getItemInterrupt());
/*     */     
/*  79 */     this.autoLoose = paramListOptions.isAutoLoose();
/*  80 */     this.autoLooseOneLevelLists = paramListOptions.isAutoLooseOneLevelLists();
/*  81 */     this.delimiterMismatchToNewList = paramListOptions.isDelimiterMismatchToNewList();
/*  82 */     this.endOnDoubleBlank = paramListOptions.isEndOnDoubleBlank();
/*  83 */     this.itemMarkerSpace = paramListOptions.isItemMarkerSpace();
/*  84 */     this.itemTypeMismatchToNewList = paramListOptions.isItemTypeMismatchToNewList();
/*  85 */     this.itemTypeMismatchToSubList = paramListOptions.isItemTypeMismatchToSubList();
/*  86 */     this.looseWhenPrevHasTrailingBlankLine = paramListOptions.isLooseWhenPrevHasTrailingBlankLine();
/*  87 */     this.looseWhenLastItemPrevHasTrailingBlankLine = paramListOptions.isLooseWhenLastItemPrevHasTrailingBlankLine();
/*  88 */     this.looseWhenHasNonListChildren = paramListOptions.isLooseWhenHasNonListChildren();
/*  89 */     this.looseWhenBlankLineFollowsItemParagraph = paramListOptions.isLooseWhenBlankLineFollowsItemParagraph();
/*  90 */     this.looseWhenHasLooseSubItem = paramListOptions.isLooseWhenHasLooseSubItem();
/*  91 */     this.looseWhenHasTrailingBlankLine = paramListOptions.isLooseWhenHasTrailingBlankLine();
/*  92 */     this.looseWhenContainsBlankLine = paramListOptions.isLooseWhenContainsBlankLine();
/*  93 */     this.numberedItemMarkerSuffixed = paramListOptions.isNumberedItemMarkerSuffixed();
/*  94 */     this.orderedItemDotOnly = paramListOptions.isOrderedItemDotOnly();
/*  95 */     this.orderedListManualStart = paramListOptions.isOrderedListManualStart();
/*  96 */     this.itemContentAfterSuffix = paramListOptions.isItemContentAfterSuffix();
/*  97 */     this.itemPrefixChars = paramListOptions.getItemPrefixChars();
/*     */     
/*  99 */     this.codeIndent = paramListOptions.getCodeIndent();
/* 100 */     this.itemIndent = paramListOptions.getItemIndent();
/* 101 */     this.newItemCodeIndent = paramListOptions.getNewItemCodeIndent();
/* 102 */     this.itemMarkerSuffixes = paramListOptions.getItemMarkerSuffixes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static ListOptions getFrom(DataHolder paramDataHolder) {
/* 112 */     return get(paramDataHolder);
/*     */   }
/*     */   
/*     */   public static ListOptions get(DataHolder paramDataHolder) {
/* 116 */     return new ListOptions(paramDataHolder);
/*     */   }
/*     */   
/*     */   public boolean isTightListItem(ListItem paramListItem) {
/* 120 */     if (paramListItem.isLoose()) {
/* 121 */       return false;
/*     */     }
/*     */     
/*     */     boolean bool;
/* 125 */     if ((bool = isAutoLoose()) && isAutoLooseOneLevelLists()) {
/* 126 */       bool = (paramListItem.getAncestorOfType(new Class[] { ListItem.class }) == null && paramListItem.getChildOfType(new Class[] { ListBlock.class }) == null);
/* 127 */       return (paramListItem.getFirstChild() == null || (!bool && paramListItem.isTight()) || (bool && paramListItem.isInTightList()));
/*     */     } 
/* 129 */     return (paramListItem.getFirstChild() == null || (!bool && paramListItem.isTight()) || (bool && paramListItem.isInTightList()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInTightListItem(Paragraph paramParagraph) {
/*     */     Block block;
/* 135 */     if (!(block = paramParagraph.getParent() instanceof ListItem)) return false;
/*     */     
/*     */     ListItem listItem;
/* 138 */     if (!(listItem = (ListItem)block).isItemParagraph(paramParagraph)) return false;
/*     */     
/*     */     boolean bool;
/* 141 */     if ((bool = isAutoLoose()) && isAutoLooseOneLevelLists()) {
/* 142 */       return isTightListItem(listItem);
/*     */     }
/* 144 */     return ((!bool && listItem.isParagraphInTightListItem(paramParagraph)) || (bool && listItem.isInTightList()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canInterrupt(ListBlock paramListBlock, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     boolean bool1;
/* 150 */     boolean bool = ((bool1 = paramListBlock instanceof OrderedList) && (!isOrderedListManualStart() || ((OrderedList)paramListBlock).getStartNumber() == 1)) ? true : false;
/*     */     
/* 152 */     return getItemInterrupt().canInterrupt(bool1, bool, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canStartSubList(ListBlock paramListBlock, boolean paramBoolean) {
/*     */     boolean bool1;
/* 158 */     boolean bool = ((bool1 = paramListBlock instanceof OrderedList) && (!isOrderedListManualStart() || ((OrderedList)paramListBlock).getStartNumber() == 1)) ? true : false;
/*     */     
/* 160 */     return getItemInterrupt().canStartSubList(bool1, bool, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean startNewList(ListBlock paramListBlock1, ListBlock paramListBlock2) {
/* 164 */     boolean bool1 = paramListBlock1 instanceof OrderedList;
/* 165 */     boolean bool2 = paramListBlock2 instanceof OrderedList;
/*     */     
/* 167 */     if (bool1 == bool2) {
/* 168 */       if (bool1) {
/* 169 */         return (isDelimiterMismatchToNewList() && ((OrderedList)paramListBlock1).getDelimiter() != ((OrderedList)paramListBlock2).getDelimiter());
/*     */       }
/* 171 */       return (isDelimiterMismatchToNewList() && ((BulletList)paramListBlock1).getOpeningMarker() != ((BulletList)paramListBlock2).getOpeningMarker());
/*     */     } 
/*     */     
/* 174 */     return isItemTypeMismatchToNewList();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean startSubList(ListBlock paramListBlock1, ListBlock paramListBlock2) {
/* 179 */     boolean bool1 = paramListBlock1 instanceof OrderedList;
/* 180 */     boolean bool2 = paramListBlock2 instanceof OrderedList;
/*     */     
/* 182 */     return (bool1 != bool2 && isItemTypeMismatchToSubList());
/*     */   }
/*     */   
/*     */   public MutableListOptions getMutable() {
/* 186 */     return new MutableListOptions(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 191 */     paramMutableDataHolder.set(Parser.PARSER_EMULATION_PROFILE, getParserEmulationProfile());
/* 192 */     getItemInterrupt().setIn(paramMutableDataHolder);
/*     */     
/* 194 */     paramMutableDataHolder.set(Parser.LISTS_AUTO_LOOSE, Boolean.valueOf(this.autoLoose));
/* 195 */     paramMutableDataHolder.set(Parser.LISTS_AUTO_LOOSE_ONE_LEVEL_LISTS, Boolean.valueOf(this.autoLooseOneLevelLists));
/* 196 */     paramMutableDataHolder.set(Parser.LISTS_DELIMITER_MISMATCH_TO_NEW_LIST, Boolean.valueOf(this.delimiterMismatchToNewList));
/* 197 */     paramMutableDataHolder.set(Parser.LISTS_END_ON_DOUBLE_BLANK, Boolean.valueOf(this.endOnDoubleBlank));
/* 198 */     paramMutableDataHolder.set(Parser.LISTS_ITEM_MARKER_SPACE, Boolean.valueOf(this.itemMarkerSpace));
/* 199 */     paramMutableDataHolder.set(Parser.LISTS_ITEM_TYPE_MISMATCH_TO_NEW_LIST, Boolean.valueOf(this.itemTypeMismatchToNewList));
/* 200 */     paramMutableDataHolder.set(Parser.LISTS_ITEM_TYPE_MISMATCH_TO_SUB_LIST, Boolean.valueOf(this.itemTypeMismatchToSubList));
/* 201 */     paramMutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_PREV_HAS_TRAILING_BLANK_LINE, Boolean.valueOf(this.looseWhenPrevHasTrailingBlankLine));
/* 202 */     paramMutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_LAST_ITEM_PREV_HAS_TRAILING_BLANK_LINE, Boolean.valueOf(this.looseWhenLastItemPrevHasTrailingBlankLine));
/* 203 */     paramMutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_HAS_NON_LIST_CHILDREN, Boolean.valueOf(this.looseWhenHasNonListChildren));
/* 204 */     paramMutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_BLANK_LINE_FOLLOWS_ITEM_PARAGRAPH, Boolean.valueOf(this.looseWhenBlankLineFollowsItemParagraph));
/* 205 */     paramMutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_HAS_LOOSE_SUB_ITEM, Boolean.valueOf(this.looseWhenHasLooseSubItem));
/* 206 */     paramMutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_HAS_TRAILING_BLANK_LINE, Boolean.valueOf(this.looseWhenHasTrailingBlankLine));
/* 207 */     paramMutableDataHolder.set(Parser.LISTS_LOOSE_WHEN_CONTAINS_BLANK_LINE, Boolean.valueOf(this.looseWhenContainsBlankLine));
/* 208 */     paramMutableDataHolder.set(Parser.LISTS_NUMBERED_ITEM_MARKER_SUFFIXED, Boolean.valueOf(this.numberedItemMarkerSuffixed));
/* 209 */     paramMutableDataHolder.set(Parser.LISTS_ORDERED_ITEM_DOT_ONLY, Boolean.valueOf(this.orderedItemDotOnly));
/* 210 */     paramMutableDataHolder.set(Parser.LISTS_ORDERED_LIST_MANUAL_START, Boolean.valueOf(this.orderedListManualStart));
/*     */     
/* 212 */     paramMutableDataHolder.set(Parser.LISTS_CODE_INDENT, Integer.valueOf(this.codeIndent));
/* 213 */     paramMutableDataHolder.set(Parser.LISTS_ITEM_INDENT, Integer.valueOf(this.itemIndent));
/* 214 */     paramMutableDataHolder.set(Parser.LISTS_NEW_ITEM_CODE_INDENT, Integer.valueOf(this.newItemCodeIndent));
/* 215 */     paramMutableDataHolder.set(Parser.LISTS_ITEM_MARKER_SUFFIXES, this.itemMarkerSuffixes);
/* 216 */     paramMutableDataHolder.set(Parser.LISTS_ITEM_CONTENT_AFTER_SUFFIX, Boolean.valueOf(this.itemContentAfterSuffix));
/* 217 */     paramMutableDataHolder.set(Parser.LISTS_ITEM_PREFIX_CHARS, this.itemPrefixChars);
/*     */     
/* 219 */     return paramMutableDataHolder;
/*     */   }
/*     */   
/*     */   public static void addItemMarkerSuffixes(MutableDataHolder paramMutableDataHolder, String... paramVarArgs) {
/* 223 */     String[] arrayOfString1 = (String[])Parser.LISTS_ITEM_MARKER_SUFFIXES.get((DataHolder)paramMutableDataHolder);
/* 224 */     int i = paramVarArgs.length;
/*     */     
/* 226 */     int j = paramVarArgs.length; String[] arrayOfString2; int k; byte b;
/* 227 */     for (k = (arrayOfString2 = arrayOfString1).length, b = 0; b < k; ) { String str = arrayOfString2[b];
/* 228 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         String str1;
/* 230 */         if ((str1 = paramVarArgs[b1]) != null && str1.equals(str)) {
/* 231 */           i--;
/* 232 */           paramVarArgs[b1] = null;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 237 */       if (i != 0)
/*     */         b++;  }
/*     */     
/* 240 */     if (i > 0) {
/* 241 */       arrayOfString2 = new String[arrayOfString1.length + i];
/* 242 */       System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
/*     */       
/* 244 */       k = arrayOfString1.length; String[] arrayOfString; int m; byte b1;
/* 245 */       for (m = (arrayOfString = paramVarArgs).length, b1 = 0; b1 < m; b1++) {
/* 246 */         String str; if ((str = arrayOfString[b1]) != null) {
/* 247 */           arrayOfString2[k++] = str;
/*     */         }
/*     */       } 
/* 250 */       paramMutableDataHolder.set(Parser.LISTS_ITEM_MARKER_SUFFIXES, arrayOfString2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ParserEmulationProfile getParserEmulationProfile() {
/* 255 */     return this.myParserEmulationProfile;
/*     */   }
/*     */   
/*     */   public ItemInterrupt getItemInterrupt() {
/* 259 */     return this.itemInterrupt;
/*     */   }
/*     */   
/*     */   public boolean isAutoLoose() {
/* 263 */     return this.autoLoose;
/*     */   }
/*     */   
/*     */   public boolean isAutoLooseOneLevelLists() {
/* 267 */     return this.autoLooseOneLevelLists;
/*     */   }
/*     */   
/*     */   public boolean isDelimiterMismatchToNewList() {
/* 271 */     return this.delimiterMismatchToNewList;
/*     */   }
/*     */   
/*     */   public boolean isEndOnDoubleBlank() {
/* 275 */     return this.endOnDoubleBlank;
/*     */   }
/*     */   
/*     */   public boolean isItemMarkerSpace() {
/* 279 */     return this.itemMarkerSpace;
/*     */   }
/*     */   
/*     */   public boolean isItemTypeMismatchToNewList() {
/* 283 */     return this.itemTypeMismatchToNewList;
/*     */   }
/*     */   
/*     */   public boolean isItemContentAfterSuffix() {
/* 287 */     return this.itemContentAfterSuffix;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getItemPrefixChars() {
/* 292 */     return this.itemPrefixChars;
/*     */   }
/*     */   
/*     */   public boolean isItemTypeMismatchToSubList() {
/* 296 */     return this.itemTypeMismatchToSubList;
/*     */   }
/*     */   
/*     */   public boolean isLooseWhenPrevHasTrailingBlankLine() {
/* 300 */     return this.looseWhenPrevHasTrailingBlankLine;
/*     */   }
/*     */   
/*     */   public boolean isLooseWhenLastItemPrevHasTrailingBlankLine() {
/* 304 */     return this.looseWhenLastItemPrevHasTrailingBlankLine;
/*     */   }
/*     */   
/*     */   public boolean isLooseWhenHasNonListChildren() {
/* 308 */     return this.looseWhenHasNonListChildren;
/*     */   }
/*     */   
/*     */   public boolean isLooseWhenHasLooseSubItem() {
/* 312 */     return this.looseWhenHasLooseSubItem;
/*     */   }
/*     */   
/*     */   public boolean isLooseWhenHasTrailingBlankLine() {
/* 316 */     return this.looseWhenHasTrailingBlankLine;
/*     */   }
/*     */   
/*     */   public boolean isLooseWhenContainsBlankLine() {
/* 320 */     return this.looseWhenContainsBlankLine;
/*     */   }
/*     */   
/*     */   public boolean isLooseWhenBlankLineFollowsItemParagraph() {
/* 324 */     return this.looseWhenBlankLineFollowsItemParagraph;
/*     */   }
/*     */   
/*     */   public boolean isOrderedItemDotOnly() {
/* 328 */     return this.orderedItemDotOnly;
/*     */   }
/*     */   
/*     */   public boolean isOrderedListManualStart() {
/* 332 */     return this.orderedListManualStart;
/*     */   }
/*     */   
/*     */   public boolean isNumberedItemMarkerSuffixed() {
/* 336 */     return this.numberedItemMarkerSuffixed;
/*     */   }
/*     */   
/*     */   public int getCodeIndent() {
/* 340 */     return this.codeIndent;
/*     */   }
/*     */   
/*     */   public int getItemIndent() {
/* 344 */     return this.itemIndent;
/*     */   }
/*     */   
/*     */   public int getNewItemCodeIndent() {
/* 348 */     return this.newItemCodeIndent;
/*     */   }
/*     */   
/*     */   public String[] getItemMarkerSuffixes() {
/* 352 */     return this.itemMarkerSuffixes;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ItemInterrupt
/*     */   {
/*     */     protected boolean bulletItemInterruptsParagraph;
/*     */     
/*     */     protected boolean orderedItemInterruptsParagraph;
/*     */     
/*     */     protected boolean orderedNonOneItemInterruptsParagraph;
/*     */     protected boolean emptyBulletItemInterruptsParagraph;
/*     */     protected boolean emptyOrderedItemInterruptsParagraph;
/*     */     protected boolean emptyOrderedNonOneItemInterruptsParagraph;
/*     */     protected boolean bulletItemInterruptsItemParagraph;
/*     */     protected boolean orderedItemInterruptsItemParagraph;
/*     */     protected boolean orderedNonOneItemInterruptsItemParagraph;
/*     */     protected boolean emptyBulletItemInterruptsItemParagraph;
/*     */     protected boolean emptyOrderedItemInterruptsItemParagraph;
/*     */     protected boolean emptyOrderedNonOneItemInterruptsItemParagraph;
/*     */     protected boolean emptyBulletSubItemInterruptsItemParagraph;
/*     */     protected boolean emptyOrderedSubItemInterruptsItemParagraph;
/*     */     protected boolean emptyOrderedNonOneSubItemInterruptsItemParagraph;
/*     */     
/*     */     public ItemInterrupt() {
/* 377 */       this.bulletItemInterruptsParagraph = false;
/* 378 */       this.orderedItemInterruptsParagraph = false;
/* 379 */       this.orderedNonOneItemInterruptsParagraph = false;
/*     */       
/* 381 */       this.emptyBulletItemInterruptsParagraph = false;
/* 382 */       this.emptyOrderedItemInterruptsParagraph = false;
/* 383 */       this.emptyOrderedNonOneItemInterruptsParagraph = false;
/*     */       
/* 385 */       this.bulletItemInterruptsItemParagraph = false;
/* 386 */       this.orderedItemInterruptsItemParagraph = false;
/* 387 */       this.orderedNonOneItemInterruptsItemParagraph = false;
/*     */       
/* 389 */       this.emptyBulletItemInterruptsItemParagraph = false;
/* 390 */       this.emptyOrderedItemInterruptsItemParagraph = false;
/* 391 */       this.emptyOrderedNonOneItemInterruptsItemParagraph = false;
/*     */       
/* 393 */       this.emptyBulletSubItemInterruptsItemParagraph = false;
/* 394 */       this.emptyOrderedSubItemInterruptsItemParagraph = false;
/* 395 */       this.emptyOrderedNonOneSubItemInterruptsItemParagraph = false;
/*     */     }
/*     */     
/*     */     public ItemInterrupt(DataHolder param1DataHolder) {
/* 399 */       this.bulletItemInterruptsParagraph = ((Boolean)Parser.LISTS_BULLET_ITEM_INTERRUPTS_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 400 */       this.orderedItemInterruptsParagraph = ((Boolean)Parser.LISTS_ORDERED_ITEM_INTERRUPTS_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 401 */       this.orderedNonOneItemInterruptsParagraph = ((Boolean)Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH.get(param1DataHolder)).booleanValue();
/*     */       
/* 403 */       this.emptyBulletItemInterruptsParagraph = ((Boolean)Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 404 */       this.emptyOrderedItemInterruptsParagraph = ((Boolean)Parser.LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 405 */       this.emptyOrderedNonOneItemInterruptsParagraph = ((Boolean)Parser.LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH.get(param1DataHolder)).booleanValue();
/*     */       
/* 407 */       this.bulletItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 408 */       this.orderedItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 409 */       this.orderedNonOneItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/*     */       
/* 411 */       this.emptyBulletItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 412 */       this.emptyOrderedItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 413 */       this.emptyOrderedNonOneItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/*     */       
/* 415 */       this.emptyBulletSubItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_EMPTY_BULLET_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 416 */       this.emptyOrderedSubItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_EMPTY_ORDERED_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/* 417 */       this.emptyOrderedNonOneSubItemInterruptsItemParagraph = ((Boolean)Parser.LISTS_EMPTY_ORDERED_NON_ONE_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH.get(param1DataHolder)).booleanValue();
/*     */     }
/*     */     
/*     */     public void setIn(MutableDataHolder param1MutableDataHolder) {
/* 421 */       param1MutableDataHolder.set(Parser.LISTS_BULLET_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.bulletItemInterruptsParagraph));
/* 422 */       param1MutableDataHolder.set(Parser.LISTS_ORDERED_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.orderedItemInterruptsParagraph));
/* 423 */       param1MutableDataHolder.set(Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.orderedNonOneItemInterruptsParagraph));
/*     */       
/* 425 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.emptyBulletItemInterruptsParagraph));
/* 426 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.emptyOrderedItemInterruptsParagraph));
/* 427 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_PARAGRAPH, Boolean.valueOf(this.emptyOrderedNonOneItemInterruptsParagraph));
/*     */       
/* 429 */       param1MutableDataHolder.set(Parser.LISTS_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.bulletItemInterruptsItemParagraph));
/* 430 */       param1MutableDataHolder.set(Parser.LISTS_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.orderedItemInterruptsItemParagraph));
/* 431 */       param1MutableDataHolder.set(Parser.LISTS_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.orderedNonOneItemInterruptsItemParagraph));
/*     */       
/* 433 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_BULLET_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyBulletItemInterruptsItemParagraph));
/* 434 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyOrderedItemInterruptsItemParagraph));
/* 435 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_NON_ONE_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyOrderedNonOneItemInterruptsItemParagraph));
/*     */       
/* 437 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_BULLET_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyBulletSubItemInterruptsItemParagraph));
/* 438 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyOrderedSubItemInterruptsItemParagraph));
/* 439 */       param1MutableDataHolder.set(Parser.LISTS_EMPTY_ORDERED_NON_ONE_SUB_ITEM_INTERRUPTS_ITEM_PARAGRAPH, Boolean.valueOf(this.emptyOrderedNonOneSubItemInterruptsItemParagraph));
/*     */     }
/*     */     
/*     */     public ItemInterrupt(ItemInterrupt param1ItemInterrupt) {
/* 443 */       this.bulletItemInterruptsParagraph = param1ItemInterrupt.bulletItemInterruptsParagraph;
/* 444 */       this.orderedItemInterruptsParagraph = param1ItemInterrupt.orderedItemInterruptsParagraph;
/* 445 */       this.orderedNonOneItemInterruptsParagraph = param1ItemInterrupt.orderedNonOneItemInterruptsParagraph;
/*     */       
/* 447 */       this.emptyBulletItemInterruptsParagraph = param1ItemInterrupt.emptyBulletItemInterruptsParagraph;
/* 448 */       this.emptyOrderedItemInterruptsParagraph = param1ItemInterrupt.emptyOrderedItemInterruptsParagraph;
/* 449 */       this.emptyOrderedNonOneItemInterruptsParagraph = param1ItemInterrupt.emptyOrderedNonOneItemInterruptsParagraph;
/*     */       
/* 451 */       this.bulletItemInterruptsItemParagraph = param1ItemInterrupt.bulletItemInterruptsItemParagraph;
/* 452 */       this.orderedItemInterruptsItemParagraph = param1ItemInterrupt.orderedItemInterruptsItemParagraph;
/* 453 */       this.orderedNonOneItemInterruptsItemParagraph = param1ItemInterrupt.orderedNonOneItemInterruptsItemParagraph;
/*     */       
/* 455 */       this.emptyBulletItemInterruptsItemParagraph = param1ItemInterrupt.emptyBulletItemInterruptsItemParagraph;
/* 456 */       this.emptyOrderedItemInterruptsItemParagraph = param1ItemInterrupt.emptyOrderedItemInterruptsItemParagraph;
/* 457 */       this.emptyOrderedNonOneItemInterruptsItemParagraph = param1ItemInterrupt.emptyOrderedNonOneItemInterruptsItemParagraph;
/*     */       
/* 459 */       this.emptyBulletSubItemInterruptsItemParagraph = param1ItemInterrupt.emptyBulletSubItemInterruptsItemParagraph;
/* 460 */       this.emptyOrderedSubItemInterruptsItemParagraph = param1ItemInterrupt.emptyOrderedSubItemInterruptsItemParagraph;
/* 461 */       this.emptyOrderedNonOneSubItemInterruptsItemParagraph = param1ItemInterrupt.emptyOrderedNonOneSubItemInterruptsItemParagraph;
/*     */     }
/*     */     
/*     */     public boolean canInterrupt(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
/* 465 */       if (param1Boolean1) {
/* 466 */         if (param1Boolean2) {
/* 467 */           if (param1Boolean4) {
/* 468 */             return (this.orderedItemInterruptsItemParagraph && (!param1Boolean3 || this.emptyOrderedItemInterruptsItemParagraph));
/*     */           }
/* 470 */           return (this.orderedItemInterruptsParagraph && (!param1Boolean3 || this.emptyOrderedItemInterruptsParagraph));
/*     */         } 
/*     */         
/* 473 */         if (param1Boolean4) {
/* 474 */           return (this.orderedNonOneItemInterruptsItemParagraph && (!param1Boolean3 || this.emptyOrderedNonOneItemInterruptsItemParagraph));
/*     */         }
/* 476 */         return (this.orderedNonOneItemInterruptsParagraph && (!param1Boolean3 || this.emptyOrderedNonOneItemInterruptsParagraph));
/*     */       } 
/*     */ 
/*     */       
/* 480 */       if (param1Boolean4) {
/* 481 */         return (this.bulletItemInterruptsItemParagraph && (!param1Boolean3 || this.emptyBulletItemInterruptsItemParagraph));
/*     */       }
/* 483 */       return (this.bulletItemInterruptsParagraph && (!param1Boolean3 || this.emptyBulletItemInterruptsParagraph));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean canStartSubList(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3) {
/* 489 */       if (param1Boolean1) {
/* 490 */         return (this.orderedItemInterruptsItemParagraph && (!param1Boolean3 || (this.emptyOrderedSubItemInterruptsItemParagraph && this.emptyOrderedItemInterruptsItemParagraph)) && (param1Boolean2 || (this.orderedNonOneItemInterruptsItemParagraph && (!param1Boolean3 || (this.emptyOrderedNonOneSubItemInterruptsItemParagraph && this.emptyOrderedNonOneItemInterruptsItemParagraph)))));
/*     */       }
/*     */ 
/*     */       
/* 494 */       return (this.bulletItemInterruptsItemParagraph && (!param1Boolean3 || (this.emptyBulletSubItemInterruptsItemParagraph && this.emptyBulletItemInterruptsItemParagraph)));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 500 */       if (this == param1Object) return true; 
/* 501 */       if (!(param1Object instanceof ItemInterrupt)) return false;
/*     */       
/* 503 */       param1Object = param1Object;
/*     */       
/* 505 */       if (this.bulletItemInterruptsParagraph != ((ItemInterrupt)param1Object).bulletItemInterruptsParagraph) return false; 
/* 506 */       if (this.orderedItemInterruptsParagraph != ((ItemInterrupt)param1Object).orderedItemInterruptsParagraph) return false; 
/* 507 */       if (this.orderedNonOneItemInterruptsParagraph != ((ItemInterrupt)param1Object).orderedNonOneItemInterruptsParagraph) return false; 
/* 508 */       if (this.emptyBulletItemInterruptsParagraph != ((ItemInterrupt)param1Object).emptyBulletItemInterruptsParagraph) return false; 
/* 509 */       if (this.emptyOrderedItemInterruptsParagraph != ((ItemInterrupt)param1Object).emptyOrderedItemInterruptsParagraph) return false; 
/* 510 */       if (this.emptyOrderedNonOneItemInterruptsParagraph != ((ItemInterrupt)param1Object).emptyOrderedNonOneItemInterruptsParagraph) return false; 
/* 511 */       if (this.bulletItemInterruptsItemParagraph != ((ItemInterrupt)param1Object).bulletItemInterruptsItemParagraph) return false; 
/* 512 */       if (this.orderedItemInterruptsItemParagraph != ((ItemInterrupt)param1Object).orderedItemInterruptsItemParagraph) return false; 
/* 513 */       if (this.orderedNonOneItemInterruptsItemParagraph != ((ItemInterrupt)param1Object).orderedNonOneItemInterruptsItemParagraph) return false; 
/* 514 */       if (this.emptyBulletItemInterruptsItemParagraph != ((ItemInterrupt)param1Object).emptyBulletItemInterruptsItemParagraph) return false; 
/* 515 */       if (this.emptyOrderedItemInterruptsItemParagraph != ((ItemInterrupt)param1Object).emptyOrderedItemInterruptsItemParagraph) return false; 
/* 516 */       if (this.emptyOrderedNonOneItemInterruptsItemParagraph != ((ItemInterrupt)param1Object).emptyOrderedNonOneItemInterruptsItemParagraph) return false; 
/* 517 */       if (this.emptyBulletSubItemInterruptsItemParagraph != ((ItemInterrupt)param1Object).emptyBulletSubItemInterruptsItemParagraph) return false; 
/* 518 */       if (this.emptyOrderedSubItemInterruptsItemParagraph != ((ItemInterrupt)param1Object).emptyOrderedSubItemInterruptsItemParagraph) return false; 
/* 519 */       return (this.emptyOrderedNonOneSubItemInterruptsItemParagraph == ((ItemInterrupt)param1Object).emptyOrderedNonOneSubItemInterruptsItemParagraph);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 524 */       int i = this.bulletItemInterruptsParagraph ? 1 : 0;
/* 525 */       i = i * 31 + (this.orderedItemInterruptsParagraph ? 1 : 0);
/* 526 */       i = i * 31 + (this.orderedNonOneItemInterruptsParagraph ? 1 : 0);
/* 527 */       i = i * 31 + (this.emptyBulletItemInterruptsParagraph ? 1 : 0);
/* 528 */       i = i * 31 + (this.emptyOrderedItemInterruptsParagraph ? 1 : 0);
/* 529 */       i = i * 31 + (this.emptyOrderedNonOneItemInterruptsParagraph ? 1 : 0);
/* 530 */       i = i * 31 + (this.bulletItemInterruptsItemParagraph ? 1 : 0);
/* 531 */       i = i * 31 + (this.orderedItemInterruptsItemParagraph ? 1 : 0);
/* 532 */       i = i * 31 + (this.orderedNonOneItemInterruptsItemParagraph ? 1 : 0);
/* 533 */       i = i * 31 + (this.emptyBulletItemInterruptsItemParagraph ? 1 : 0);
/* 534 */       i = i * 31 + (this.emptyOrderedItemInterruptsItemParagraph ? 1 : 0);
/* 535 */       i = i * 31 + (this.emptyOrderedNonOneItemInterruptsItemParagraph ? 1 : 0);
/* 536 */       i = i * 31 + (this.emptyBulletSubItemInterruptsItemParagraph ? 1 : 0);
/* 537 */       i = i * 31 + (this.emptyOrderedSubItemInterruptsItemParagraph ? 1 : 0);
/*     */       
/* 539 */       return i = i * 31 + (this.emptyOrderedNonOneSubItemInterruptsItemParagraph ? 1 : 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MutableItemInterrupt
/*     */     extends ItemInterrupt {
/*     */     public MutableItemInterrupt() {}
/*     */     
/*     */     public MutableItemInterrupt(DataHolder param1DataHolder) {
/* 548 */       super(param1DataHolder);
/*     */     }
/*     */     
/*     */     public MutableItemInterrupt(ListOptions.ItemInterrupt param1ItemInterrupt) {
/* 552 */       super(param1ItemInterrupt);
/*     */     }
/*     */     
/*     */     public boolean isBulletItemInterruptsParagraph() {
/* 556 */       return this.bulletItemInterruptsParagraph;
/* 557 */     } public boolean isOrderedItemInterruptsParagraph() { return this.orderedItemInterruptsParagraph; } public boolean isOrderedNonOneItemInterruptsParagraph() {
/* 558 */       return this.orderedNonOneItemInterruptsParagraph;
/*     */     }
/* 560 */     public boolean isEmptyBulletItemInterruptsParagraph() { return this.emptyBulletItemInterruptsParagraph; }
/* 561 */     public boolean isEmptyOrderedItemInterruptsParagraph() { return this.emptyOrderedItemInterruptsParagraph; } public boolean isEmptyOrderedNonOneItemInterruptsParagraph() {
/* 562 */       return this.emptyOrderedNonOneItemInterruptsParagraph;
/*     */     }
/* 564 */     public boolean isBulletItemInterruptsItemParagraph() { return this.bulletItemInterruptsItemParagraph; }
/* 565 */     public boolean isOrderedItemInterruptsItemParagraph() { return this.orderedItemInterruptsItemParagraph; } public boolean isOrderedNonOneItemInterruptsItemParagraph() {
/* 566 */       return this.orderedNonOneItemInterruptsItemParagraph;
/*     */     }
/* 568 */     public boolean isEmptyBulletItemInterruptsItemParagraph() { return this.emptyBulletItemInterruptsItemParagraph; }
/* 569 */     public boolean isEmptyOrderedItemInterruptsItemParagraph() { return this.emptyOrderedItemInterruptsItemParagraph; } public boolean isEmptyOrderedNonOneItemInterruptsItemParagraph() {
/* 570 */       return this.emptyOrderedNonOneItemInterruptsItemParagraph;
/*     */     }
/* 572 */     public boolean isEmptyBulletSubItemInterruptsItemParagraph() { return this.emptyBulletSubItemInterruptsItemParagraph; }
/* 573 */     public boolean isEmptyOrderedSubItemInterruptsItemParagraph() { return this.emptyOrderedSubItemInterruptsItemParagraph; } public boolean isEmptyOrderedNonOneSubItemInterruptsItemParagraph() {
/* 574 */       return this.emptyOrderedNonOneSubItemInterruptsItemParagraph;
/*     */     }
/* 576 */     public MutableItemInterrupt setBulletItemInterruptsParagraph(boolean param1Boolean) { this.bulletItemInterruptsParagraph = param1Boolean; return this; }
/* 577 */     public MutableItemInterrupt setOrderedItemInterruptsParagraph(boolean param1Boolean) { this.orderedItemInterruptsParagraph = param1Boolean; return this; } public MutableItemInterrupt setOrderedNonOneItemInterruptsParagraph(boolean param1Boolean) {
/* 578 */       this.orderedNonOneItemInterruptsParagraph = param1Boolean; return this;
/*     */     }
/* 580 */     public MutableItemInterrupt setEmptyBulletItemInterruptsParagraph(boolean param1Boolean) { this.emptyBulletItemInterruptsParagraph = param1Boolean; return this; }
/* 581 */     public MutableItemInterrupt setEmptyOrderedItemInterruptsParagraph(boolean param1Boolean) { this.emptyOrderedItemInterruptsParagraph = param1Boolean; return this; } public MutableItemInterrupt setEmptyOrderedNonOneItemInterruptsParagraph(boolean param1Boolean) {
/* 582 */       this.emptyOrderedNonOneItemInterruptsParagraph = param1Boolean; return this;
/*     */     }
/* 584 */     public MutableItemInterrupt setBulletItemInterruptsItemParagraph(boolean param1Boolean) { this.bulletItemInterruptsItemParagraph = param1Boolean; return this; }
/* 585 */     public MutableItemInterrupt setOrderedItemInterruptsItemParagraph(boolean param1Boolean) { this.orderedItemInterruptsItemParagraph = param1Boolean; return this; } public MutableItemInterrupt setOrderedNonOneItemInterruptsItemParagraph(boolean param1Boolean) {
/* 586 */       this.orderedNonOneItemInterruptsItemParagraph = param1Boolean; return this;
/*     */     }
/* 588 */     public MutableItemInterrupt setEmptyBulletItemInterruptsItemParagraph(boolean param1Boolean) { this.emptyBulletItemInterruptsItemParagraph = param1Boolean; return this; }
/* 589 */     public MutableItemInterrupt setEmptyOrderedItemInterruptsItemParagraph(boolean param1Boolean) { this.emptyOrderedItemInterruptsItemParagraph = param1Boolean; return this; } public MutableItemInterrupt setEmptyOrderedNonOneItemInterruptsItemParagraph(boolean param1Boolean) {
/* 590 */       this.emptyOrderedNonOneItemInterruptsItemParagraph = param1Boolean; return this;
/*     */     }
/* 592 */     public MutableItemInterrupt setEmptyBulletSubItemInterruptsItemParagraph(boolean param1Boolean) { this.emptyBulletSubItemInterruptsItemParagraph = param1Boolean; return this; }
/* 593 */     public MutableItemInterrupt setEmptyOrderedSubItemInterruptsItemParagraph(boolean param1Boolean) { this.emptyOrderedSubItemInterruptsItemParagraph = param1Boolean; return this; } public MutableItemInterrupt setEmptyOrderedNonOneSubItemInterruptsItemParagraph(boolean param1Boolean) {
/* 594 */       this.emptyOrderedNonOneSubItemInterruptsItemParagraph = param1Boolean; return this;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 601 */     if (this == paramObject) return true; 
/* 602 */     if (!(paramObject instanceof ListOptions)) return false;
/*     */     
/* 604 */     paramObject = paramObject;
/*     */     
/* 606 */     if (this.myParserEmulationProfile != ((ListOptions)paramObject).myParserEmulationProfile) return false; 
/* 607 */     if (this.autoLoose != ((ListOptions)paramObject).autoLoose) return false; 
/* 608 */     if (this.autoLooseOneLevelLists != ((ListOptions)paramObject).autoLooseOneLevelLists) return false; 
/* 609 */     if (this.delimiterMismatchToNewList != ((ListOptions)paramObject).delimiterMismatchToNewList) return false; 
/* 610 */     if (this.endOnDoubleBlank != ((ListOptions)paramObject).endOnDoubleBlank) return false; 
/* 611 */     if (this.itemMarkerSpace != ((ListOptions)paramObject).itemMarkerSpace) return false; 
/* 612 */     if (this.itemTypeMismatchToNewList != ((ListOptions)paramObject).itemTypeMismatchToNewList) return false; 
/* 613 */     if (this.itemTypeMismatchToSubList != ((ListOptions)paramObject).itemTypeMismatchToSubList) return false; 
/* 614 */     if (this.looseWhenPrevHasTrailingBlankLine != ((ListOptions)paramObject).looseWhenPrevHasTrailingBlankLine) return false; 
/* 615 */     if (this.looseWhenLastItemPrevHasTrailingBlankLine != ((ListOptions)paramObject).looseWhenLastItemPrevHasTrailingBlankLine) return false; 
/* 616 */     if (this.looseWhenHasNonListChildren != ((ListOptions)paramObject).looseWhenHasNonListChildren) return false; 
/* 617 */     if (this.looseWhenBlankLineFollowsItemParagraph != ((ListOptions)paramObject).looseWhenBlankLineFollowsItemParagraph) return false; 
/* 618 */     if (this.looseWhenHasLooseSubItem != ((ListOptions)paramObject).looseWhenHasLooseSubItem) return false; 
/* 619 */     if (this.looseWhenHasTrailingBlankLine != ((ListOptions)paramObject).looseWhenHasTrailingBlankLine) return false; 
/* 620 */     if (this.looseWhenContainsBlankLine != ((ListOptions)paramObject).looseWhenContainsBlankLine) return false; 
/* 621 */     if (this.numberedItemMarkerSuffixed != ((ListOptions)paramObject).numberedItemMarkerSuffixed) return false; 
/* 622 */     if (this.orderedItemDotOnly != ((ListOptions)paramObject).orderedItemDotOnly) return false; 
/* 623 */     if (this.orderedListManualStart != ((ListOptions)paramObject).orderedListManualStart) return false; 
/* 624 */     if (this.codeIndent != ((ListOptions)paramObject).codeIndent) return false; 
/* 625 */     if (this.itemIndent != ((ListOptions)paramObject).itemIndent) return false; 
/* 626 */     if (this.newItemCodeIndent != ((ListOptions)paramObject).newItemCodeIndent) return false; 
/* 627 */     if (this.itemMarkerSuffixes != ((ListOptions)paramObject).itemMarkerSuffixes) return false; 
/* 628 */     if (this.itemContentAfterSuffix != ((ListOptions)paramObject).itemContentAfterSuffix) return false; 
/* 629 */     if (!this.itemPrefixChars.equals(((ListOptions)paramObject).itemPrefixChars)) return false; 
/* 630 */     return this.itemInterrupt.equals(((ListOptions)paramObject).itemInterrupt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 635 */     int i = this.myParserEmulationProfile.hashCode();
/* 636 */     i = i * 31 + this.itemInterrupt.hashCode();
/* 637 */     i = i * 31 + (this.autoLoose ? 1 : 0);
/* 638 */     i = i * 31 + (this.autoLooseOneLevelLists ? 1 : 0);
/* 639 */     i = i * 31 + (this.delimiterMismatchToNewList ? 1 : 0);
/* 640 */     i = i * 31 + (this.endOnDoubleBlank ? 1 : 0);
/* 641 */     i = i * 31 + (this.itemMarkerSpace ? 1 : 0);
/* 642 */     i = i * 31 + (this.itemTypeMismatchToNewList ? 1 : 0);
/* 643 */     i = i * 31 + (this.itemTypeMismatchToSubList ? 1 : 0);
/* 644 */     i = i * 31 + (this.looseWhenPrevHasTrailingBlankLine ? 1 : 0);
/* 645 */     i = i * 31 + (this.looseWhenLastItemPrevHasTrailingBlankLine ? 1 : 0);
/* 646 */     i = i * 31 + (this.looseWhenHasNonListChildren ? 1 : 0);
/* 647 */     i = i * 31 + (this.looseWhenBlankLineFollowsItemParagraph ? 1 : 0);
/* 648 */     i = i * 31 + (this.looseWhenHasLooseSubItem ? 1 : 0);
/* 649 */     i = i * 31 + (this.looseWhenHasTrailingBlankLine ? 1 : 0);
/* 650 */     i = i * 31 + (this.looseWhenContainsBlankLine ? 1 : 0);
/* 651 */     i = i * 31 + (this.numberedItemMarkerSuffixed ? 1 : 0);
/* 652 */     i = i * 31 + (this.orderedItemDotOnly ? 1 : 0);
/* 653 */     i = i * 31 + (this.orderedListManualStart ? 1 : 0);
/* 654 */     i = i * 31 + (this.itemContentAfterSuffix ? 1 : 0);
/* 655 */     i = i * 31 + this.itemPrefixChars.hashCode();
/* 656 */     i = i * 31 + this.codeIndent;
/* 657 */     i = i * 31 + this.itemIndent;
/* 658 */     i = i * 31 + this.newItemCodeIndent;
/*     */     
/* 660 */     return i = i * 31 + Arrays.hashCode((Object[])this.itemMarkerSuffixes);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\ListOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */