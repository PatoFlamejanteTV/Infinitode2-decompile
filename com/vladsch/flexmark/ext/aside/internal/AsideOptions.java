/*    */ package com.vladsch.flexmark.ext.aside.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.aside.AsideExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ class AsideOptions {
/*    */   public final boolean extendToBlankLine;
/*    */   public final boolean ignoreBlankLine;
/*    */   public final boolean allowLeadingSpace;
/*    */   public final boolean interruptsParagraph;
/*    */   public final boolean interruptsItemParagraph;
/*    */   public final boolean withLeadSpacesInterruptsItemParagraph;
/*    */   
/*    */   public AsideOptions(DataHolder paramDataHolder) {
/* 15 */     this.extendToBlankLine = ((Boolean)AsideExtension.EXTEND_TO_BLANK_LINE.get(paramDataHolder)).booleanValue();
/* 16 */     this.ignoreBlankLine = ((Boolean)AsideExtension.IGNORE_BLANK_LINE.get(paramDataHolder)).booleanValue();
/* 17 */     this.allowLeadingSpace = ((Boolean)AsideExtension.ALLOW_LEADING_SPACE.get(paramDataHolder)).booleanValue();
/* 18 */     this.interruptsParagraph = ((Boolean)AsideExtension.INTERRUPTS_PARAGRAPH.get(paramDataHolder)).booleanValue();
/* 19 */     this.interruptsItemParagraph = ((Boolean)AsideExtension.INTERRUPTS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/* 20 */     this.withLeadSpacesInterruptsItemParagraph = ((Boolean)AsideExtension.WITH_LEAD_SPACES_INTERRUPTS_ITEM_PARAGRAPH.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\aside\internal\AsideOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */