/*    */ package com.vladsch.flexmark.ext.admonition.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.admonition.AdmonitionExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class AdmonitionOptions
/*    */ {
/*    */   public final int contentIndent;
/*    */   public final boolean allowLeadingSpace;
/*    */   public final boolean interruptsParagraph;
/*    */   public final boolean interruptsItemParagraph;
/*    */   public final boolean withSpacesInterruptsItemParagraph;
/*    */   public final boolean allowLazyContinuation;
/*    */   public final String unresolvedQualifier;
/*    */   public final Map<String, String> qualifierTypeMap;
/*    */   public final Map<String, String> qualifierTitleMap;
/*    */   public final Map<String, String> typeSvgMap;
/*    */   
/*    */   public AdmonitionOptions(DataHolder paramDataHolder) {
/* 21 */     this.contentIndent = ((Integer)AdmonitionExtension.CONTENT_INDENT.get(paramDataHolder)).intValue();
/* 22 */     this.allowLeadingSpace = ((Boolean)AdmonitionExtension.ALLOW_LEADING_SPACE.get(paramDataHolder)).booleanValue();
/* 23 */     this.interruptsParagraph = ((Boolean)AdmonitionExtension.INTERRUPTS_PARAGRAPH.get(paramDataHolder)).booleanValue();
/* 24 */     this.interruptsItemParagraph = ((Boolean)AdmonitionExtension.INTERRUPTS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/* 25 */     this.withSpacesInterruptsItemParagraph = ((Boolean)AdmonitionExtension.WITH_SPACES_INTERRUPTS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/* 26 */     this.allowLazyContinuation = ((Boolean)AdmonitionExtension.ALLOW_LAZY_CONTINUATION.get(paramDataHolder)).booleanValue();
/* 27 */     this.unresolvedQualifier = (String)AdmonitionExtension.UNRESOLVED_QUALIFIER.get(paramDataHolder);
/* 28 */     this.qualifierTypeMap = (Map<String, String>)AdmonitionExtension.QUALIFIER_TYPE_MAP.get(paramDataHolder);
/* 29 */     this.qualifierTitleMap = (Map<String, String>)AdmonitionExtension.QUALIFIER_TITLE_MAP.get(paramDataHolder);
/* 30 */     this.typeSvgMap = (Map<String, String>)AdmonitionExtension.TYPE_SVG_MAP.get(paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\admonition\internal\AdmonitionOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */