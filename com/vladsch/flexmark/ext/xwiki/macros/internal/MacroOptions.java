/*    */ package com.vladsch.flexmark.ext.xwiki.macros.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.xwiki.macros.MacroExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ class MacroOptions {
/*    */   public final boolean enableInlineMacros;
/*    */   public final boolean enableBlockMacros;
/*    */   public final boolean enableRendering;
/*    */   
/*    */   public MacroOptions(DataHolder paramDataHolder) {
/* 12 */     this.enableInlineMacros = ((Boolean)MacroExtension.ENABLE_INLINE_MACROS.get(paramDataHolder)).booleanValue();
/* 13 */     this.enableBlockMacros = ((Boolean)MacroExtension.ENABLE_BLOCK_MACROS.get(paramDataHolder)).booleanValue();
/* 14 */     this.enableRendering = ((Boolean)MacroExtension.ENABLE_RENDERING.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\internal\MacroOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */