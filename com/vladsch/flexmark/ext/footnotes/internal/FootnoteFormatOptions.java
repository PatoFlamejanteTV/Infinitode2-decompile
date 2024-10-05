/*    */ package com.vladsch.flexmark.ext.footnotes.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*    */ 
/*    */ public class FootnoteFormatOptions
/*    */ {
/*    */   public final ElementPlacement footnotePlacement;
/*    */   public final ElementPlacementSort footnoteSort;
/*    */   
/*    */   public FootnoteFormatOptions(DataHolder paramDataHolder) {
/* 14 */     this.footnotePlacement = (ElementPlacement)FootnoteExtension.FOOTNOTE_PLACEMENT.get(paramDataHolder);
/* 15 */     this.footnoteSort = (ElementPlacementSort)FootnoteExtension.FOOTNOTE_SORT.get(paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\footnotes\internal\FootnoteFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */