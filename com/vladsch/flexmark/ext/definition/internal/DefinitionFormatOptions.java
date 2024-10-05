/*    */ package com.vladsch.flexmark.ext.definition.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.definition.DefinitionExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.format.options.DefinitionMarker;
/*    */ 
/*    */ public class DefinitionFormatOptions {
/*    */   public final int markerSpaces;
/*    */   public final DefinitionMarker markerType;
/*    */   
/*    */   public DefinitionFormatOptions(DataHolder paramDataHolder) {
/* 12 */     this.markerSpaces = ((Integer)DefinitionExtension.FORMAT_MARKER_SPACES.get(paramDataHolder)).intValue();
/* 13 */     this.markerType = (DefinitionMarker)DefinitionExtension.FORMAT_MARKER_TYPE.get(paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\internal\DefinitionFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */