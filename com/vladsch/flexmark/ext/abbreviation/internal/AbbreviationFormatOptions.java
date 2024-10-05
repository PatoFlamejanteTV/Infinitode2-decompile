/*    */ package com.vladsch.flexmark.ext.abbreviation.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*    */ 
/*    */ public class AbbreviationFormatOptions
/*    */ {
/*    */   public final ElementPlacement abbreviationsPlacement;
/*    */   public final ElementPlacementSort abbreviationsSort;
/*    */   
/*    */   public AbbreviationFormatOptions(DataHolder paramDataHolder) {
/* 14 */     this.abbreviationsPlacement = (ElementPlacement)AbbreviationExtension.ABBREVIATIONS_PLACEMENT.get(paramDataHolder);
/* 15 */     this.abbreviationsSort = (ElementPlacementSort)AbbreviationExtension.ABBREVIATIONS_SORT.get(paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\internal\AbbreviationFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */