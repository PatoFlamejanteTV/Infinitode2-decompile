/*    */ package com.vladsch.flexmark.ext.macros.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.macros.MacrosExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacement;
/*    */ import com.vladsch.flexmark.util.format.options.ElementPlacementSort;
/*    */ 
/*    */ public class MacroFormatOptions
/*    */ {
/*    */   public final ElementPlacement macrosPlacement;
/*    */   public final ElementPlacementSort macrosSort;
/*    */   
/*    */   public MacroFormatOptions(DataHolder paramDataHolder) {
/* 14 */     this.macrosPlacement = (ElementPlacement)MacrosExtension.MACRO_DEFINITIONS_PLACEMENT.get(paramDataHolder);
/* 15 */     this.macrosSort = (ElementPlacementSort)MacrosExtension.MACRO_DEFINITIONS_SORT.get(paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\internal\MacroFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */