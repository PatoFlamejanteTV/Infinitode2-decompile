/*    */ package com.vladsch.flexmark.ext.footnotes.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ public class FootnoteOptions {
/*    */   final String footnoteRefPrefix;
/*    */   final String footnoteRefSuffix;
/*    */   final String footnoteBackRefString;
/*    */   final String footnoteLinkRefClass;
/*    */   final String footnoteBackLinkRefClass;
/*    */   final int contentIndent;
/*    */   
/*    */   public FootnoteOptions(DataHolder paramDataHolder) {
/* 16 */     this.footnoteRefPrefix = (String)FootnoteExtension.FOOTNOTE_REF_PREFIX.get(paramDataHolder);
/* 17 */     this.footnoteRefSuffix = (String)FootnoteExtension.FOOTNOTE_REF_SUFFIX.get(paramDataHolder);
/* 18 */     this.footnoteBackRefString = (String)FootnoteExtension.FOOTNOTE_BACK_REF_STRING.get(paramDataHolder);
/* 19 */     this.footnoteLinkRefClass = (String)FootnoteExtension.FOOTNOTE_LINK_REF_CLASS.get(paramDataHolder);
/* 20 */     this.footnoteBackLinkRefClass = (String)FootnoteExtension.FOOTNOTE_BACK_LINK_REF_CLASS.get(paramDataHolder);
/* 21 */     this.contentIndent = ((Integer)Parser.LISTS_ITEM_INDENT.get(paramDataHolder)).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\internal\FootnoteOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */