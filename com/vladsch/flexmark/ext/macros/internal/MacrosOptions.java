/*    */ package com.vladsch.flexmark.ext.macros.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.macros.MacrosExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*    */ 
/*    */ class MacrosOptions
/*    */   implements MutableDataSetter {
/*    */   public final boolean sourceWrapMacroReferences;
/*    */   
/*    */   public MacrosOptions(DataHolder paramDataHolder) {
/* 13 */     this.sourceWrapMacroReferences = ((Boolean)MacrosExtension.SOURCE_WRAP_MACRO_REFERENCES.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 19 */     paramMutableDataHolder.set(MacrosExtension.SOURCE_WRAP_MACRO_REFERENCES, Boolean.valueOf(this.sourceWrapMacroReferences));
/* 20 */     return paramMutableDataHolder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\internal\MacrosOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */