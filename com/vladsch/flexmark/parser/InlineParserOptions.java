/*    */ package com.vladsch.flexmark.parser;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ public class InlineParserOptions {
/*    */   public final boolean matchLookaheadFirst;
/*    */   public final boolean parseMultiLineImageUrls;
/*    */   public final boolean hardLineBreakLimit;
/*    */   public final boolean spaceInLinkUrls;
/*    */   public final boolean spaceInLinkElements;
/*    */   public final boolean codeSoftLineBreaks;
/*    */   public final boolean inlineDelimiterDirectionalPunctuations;
/*    */   public final boolean linksAllowMatchedParentheses;
/*    */   public final boolean wwwAutoLinkElement;
/*    */   public final boolean intellijDummyIdentifier;
/*    */   public final boolean parseJekyllMacrosInUrls;
/*    */   public final boolean useHardcodedLinkAddressParser;
/*    */   public final boolean linkTextPriorityOverLinkRef;
/*    */   
/*    */   public InlineParserOptions(DataHolder paramDataHolder) {
/* 21 */     this.matchLookaheadFirst = ((Boolean)Parser.MATCH_NESTED_LINK_REFS_FIRST.get(paramDataHolder)).booleanValue();
/* 22 */     this.parseMultiLineImageUrls = ((Boolean)Parser.PARSE_MULTI_LINE_IMAGE_URLS.get(paramDataHolder)).booleanValue();
/* 23 */     this.hardLineBreakLimit = ((Boolean)Parser.HARD_LINE_BREAK_LIMIT.get(paramDataHolder)).booleanValue();
/* 24 */     this.spaceInLinkUrls = ((Boolean)Parser.SPACE_IN_LINK_URLS.get(paramDataHolder)).booleanValue();
/* 25 */     this.spaceInLinkElements = ((Boolean)Parser.SPACE_IN_LINK_ELEMENTS.get(paramDataHolder)).booleanValue();
/* 26 */     this.wwwAutoLinkElement = ((Boolean)Parser.WWW_AUTO_LINK_ELEMENT.get(paramDataHolder)).booleanValue();
/* 27 */     this.intellijDummyIdentifier = ((Boolean)Parser.INTELLIJ_DUMMY_IDENTIFIER.get(paramDataHolder)).booleanValue();
/* 28 */     this.parseJekyllMacrosInUrls = ((Boolean)Parser.PARSE_JEKYLL_MACROS_IN_URLS.get(paramDataHolder)).booleanValue();
/* 29 */     this.useHardcodedLinkAddressParser = ((Boolean)Parser.USE_HARDCODED_LINK_ADDRESS_PARSER.get(paramDataHolder)).booleanValue();
/* 30 */     this.codeSoftLineBreaks = ((Boolean)Parser.CODE_SOFT_LINE_BREAKS.get(paramDataHolder)).booleanValue();
/* 31 */     this.inlineDelimiterDirectionalPunctuations = ((Boolean)Parser.INLINE_DELIMITER_DIRECTIONAL_PUNCTUATIONS.get(paramDataHolder)).booleanValue();
/* 32 */     this.linksAllowMatchedParentheses = ((Boolean)Parser.LINKS_ALLOW_MATCHED_PARENTHESES.get(paramDataHolder)).booleanValue();
/* 33 */     this.linkTextPriorityOverLinkRef = ((Boolean)Parser.LINK_TEXT_PRIORITY_OVER_LINK_REF.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\InlineParserOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */