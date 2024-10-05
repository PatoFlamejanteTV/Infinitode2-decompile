/*    */ package com.vladsch.flexmark.ext.definition.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionExtension;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.ParserEmulationProfile;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ class DefinitionOptions
/*    */ {
/*    */   public final int markerSpaces;
/*    */   public final boolean tildeMarker;
/*    */   public final boolean colonMarker;
/*    */   public final ParserEmulationProfile myParserEmulationProfile;
/*    */   public final boolean autoLoose;
/*    */   public final boolean autoLooseOneLevelLists;
/*    */   public final boolean looseOnPrevLooseItem;
/*    */   public final boolean looseWhenHasLooseSubItem;
/*    */   public final boolean looseWhenHasTrailingBlankLine;
/*    */   public final boolean looseWhenBlankFollowsItemParagraph;
/*    */   public final boolean doubleBlankLineBreaksList;
/*    */   public final int codeIndent;
/*    */   public final int itemIndent;
/*    */   public final int newItemCodeIndent;
/*    */   
/*    */   public DefinitionOptions(DataHolder paramDataHolder) {
/* 26 */     this.markerSpaces = ((Integer)DefinitionExtension.MARKER_SPACES.get(paramDataHolder)).intValue();
/* 27 */     this.tildeMarker = ((Boolean)DefinitionExtension.TILDE_MARKER.get(paramDataHolder)).booleanValue();
/* 28 */     this.colonMarker = ((Boolean)DefinitionExtension.COLON_MARKER.get(paramDataHolder)).booleanValue();
/* 29 */     this.myParserEmulationProfile = (ParserEmulationProfile)Parser.PARSER_EMULATION_PROFILE.get(paramDataHolder);
/* 30 */     this.autoLoose = ((Boolean)Parser.LISTS_AUTO_LOOSE.get(paramDataHolder)).booleanValue();
/* 31 */     this.autoLooseOneLevelLists = ((Boolean)Parser.LISTS_AUTO_LOOSE_ONE_LEVEL_LISTS.get(paramDataHolder)).booleanValue();
/* 32 */     this.looseOnPrevLooseItem = ((Boolean)Parser.LISTS_LOOSE_WHEN_PREV_HAS_TRAILING_BLANK_LINE.get(paramDataHolder)).booleanValue();
/* 33 */     this.looseWhenBlankFollowsItemParagraph = ((Boolean)Parser.LISTS_LOOSE_WHEN_BLANK_LINE_FOLLOWS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/* 34 */     this.looseWhenHasLooseSubItem = ((Boolean)Parser.LISTS_LOOSE_WHEN_HAS_LOOSE_SUB_ITEM.get(paramDataHolder)).booleanValue();
/* 35 */     this.looseWhenHasTrailingBlankLine = ((Boolean)Parser.LISTS_LOOSE_WHEN_HAS_TRAILING_BLANK_LINE.get(paramDataHolder)).booleanValue();
/* 36 */     this.codeIndent = ((Integer)Parser.LISTS_CODE_INDENT.get(paramDataHolder)).intValue();
/* 37 */     this.itemIndent = ((Integer)Parser.LISTS_ITEM_INDENT.get(paramDataHolder)).intValue();
/* 38 */     this.newItemCodeIndent = ((Integer)Parser.LISTS_NEW_ITEM_CODE_INDENT.get(paramDataHolder)).intValue();
/* 39 */     this.doubleBlankLineBreaksList = ((Boolean)DefinitionExtension.DOUBLE_BLANK_LINE_BREAKS_LIST.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\internal\DefinitionOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */