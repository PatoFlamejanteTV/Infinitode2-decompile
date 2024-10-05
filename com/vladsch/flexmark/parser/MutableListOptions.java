/*    */ package com.vladsch.flexmark.parser;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MutableListOptions
/*    */   extends ListOptions
/*    */ {
/*    */   public MutableListOptions() {
/* 11 */     this.itemInterrupt = new ListOptions.MutableItemInterrupt(getItemInterrupt());
/*    */   }
/*    */   
/*    */   public MutableListOptions(DataHolder paramDataHolder) {
/* 15 */     this(ListOptions.get(paramDataHolder));
/*    */   }
/*    */   
/*    */   MutableListOptions(ListOptions paramListOptions) {
/* 19 */     super(paramListOptions);
/* 20 */     this.itemInterrupt = new ListOptions.MutableItemInterrupt(getItemInterrupt());
/*    */   }
/*    */   
/*    */   public MutableListOptions getMutable() {
/* 24 */     return new MutableListOptions(this);
/*    */   }
/*    */   
/*    */   public MutableListOptions setParserEmulationFamily(ParserEmulationProfile paramParserEmulationProfile) {
/* 28 */     this.myParserEmulationProfile = paramParserEmulationProfile; return this; } public MutableListOptions setItemInterrupt(ListOptions.MutableItemInterrupt paramMutableItemInterrupt) {
/* 29 */     this.itemInterrupt = paramMutableItemInterrupt; return this;
/*    */   }
/* 31 */   public MutableListOptions setAutoLoose(boolean paramBoolean) { this.autoLoose = paramBoolean; return this; }
/* 32 */   public MutableListOptions setAutoLooseOneLevelLists(boolean paramBoolean) { this.autoLooseOneLevelLists = paramBoolean; return this; }
/* 33 */   public MutableListOptions setDelimiterMismatchToNewList(boolean paramBoolean) { this.delimiterMismatchToNewList = paramBoolean; return this; }
/* 34 */   public MutableListOptions setEndOnDoubleBlank(boolean paramBoolean) { this.endOnDoubleBlank = paramBoolean; return this; }
/* 35 */   public MutableListOptions setItemMarkerSpace(boolean paramBoolean) { this.itemMarkerSpace = paramBoolean; return this; }
/* 36 */   public MutableListOptions setItemTypeMismatchToNewList(boolean paramBoolean) { this.itemTypeMismatchToNewList = paramBoolean; return this; }
/* 37 */   public MutableListOptions setItemTypeMismatchToSubList(boolean paramBoolean) { this.itemTypeMismatchToSubList = paramBoolean; return this; }
/* 38 */   public MutableListOptions setLooseWhenPrevHasTrailingBlankLine(boolean paramBoolean) { this.looseWhenPrevHasTrailingBlankLine = paramBoolean; return this; }
/* 39 */   public MutableListOptions setLooseWhenLastItemPrevHasTrailingBlankLine(boolean paramBoolean) { this.looseWhenLastItemPrevHasTrailingBlankLine = paramBoolean; return this; }
/* 40 */   public MutableListOptions setLooseWhenHasNonListChildren(boolean paramBoolean) { this.looseWhenHasNonListChildren = paramBoolean; return this; }
/* 41 */   public MutableListOptions setLooseWhenBlankLineFollowsItemParagraph(boolean paramBoolean) { this.looseWhenBlankLineFollowsItemParagraph = paramBoolean; return this; }
/* 42 */   public MutableListOptions setLooseWhenHasLooseSubItem(boolean paramBoolean) { this.looseWhenHasLooseSubItem = paramBoolean; return this; }
/* 43 */   public MutableListOptions setLooseWhenHasTrailingBlankLine(boolean paramBoolean) { this.looseWhenHasTrailingBlankLine = paramBoolean; return this; }
/* 44 */   public MutableListOptions setLooseWhenContainsBlankLine(boolean paramBoolean) { this.looseWhenContainsBlankLine = paramBoolean; return this; }
/* 45 */   public MutableListOptions setNumberedItemMarkerSuffixed(boolean paramBoolean) { this.numberedItemMarkerSuffixed = paramBoolean; return this; }
/* 46 */   public MutableListOptions setOrderedItemDotOnly(boolean paramBoolean) { this.orderedItemDotOnly = paramBoolean; return this; } public MutableListOptions setOrderedListManualStart(boolean paramBoolean) {
/* 47 */     this.orderedListManualStart = paramBoolean; return this;
/*    */   }
/* 49 */   public MutableListOptions setCodeIndent(int paramInt) { this.codeIndent = paramInt; return this; }
/* 50 */   public MutableListOptions setItemIndent(int paramInt) { this.itemIndent = paramInt; return this; }
/* 51 */   public MutableListOptions setNewItemCodeIndent(int paramInt) { this.newItemCodeIndent = paramInt; return this; } public MutableListOptions setItemMarkerSuffixes(String[] paramArrayOfString) {
/* 52 */     this.itemMarkerSuffixes = paramArrayOfString; return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\MutableListOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */