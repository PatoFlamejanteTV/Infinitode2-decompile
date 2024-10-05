/*    */ package com.vladsch.flexmark.ext.enumerated.reference.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.enumerated.reference.EnumeratedReferenceExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*    */ 
/*    */ public class EnumeratedReferenceFormatOptions
/*    */ {
/*    */   public final ElementPlacement enumeratedReferencePlacement;
/*    */   public final ElementPlacementSort enumeratedReferenceSort;
/*    */   
/*    */   public EnumeratedReferenceFormatOptions(DataHolder paramDataHolder) {
/* 14 */     this.enumeratedReferencePlacement = (ElementPlacement)EnumeratedReferenceExtension.ENUMERATED_REFERENCE_PLACEMENT.get(paramDataHolder);
/* 15 */     this.enumeratedReferenceSort = (ElementPlacementSort)EnumeratedReferenceExtension.ENUMERATED_REFERENCE_SORT.get(paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\internal\EnumeratedReferenceFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */