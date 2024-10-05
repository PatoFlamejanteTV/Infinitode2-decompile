/*    */ package com.vladsch.flexmark.ext.anchorlink.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ class AnchorLinkOptions {
/*    */   public final boolean wrapText;
/*    */   public final String textPrefix;
/*    */   public final String textSuffix;
/*    */   public final String anchorClass;
/*    */   public final boolean setName;
/*    */   public final boolean setId;
/*    */   public final boolean noBlockQuotes;
/*    */   
/*    */   public AnchorLinkOptions(DataHolder paramDataHolder) {
/* 16 */     this.wrapText = ((Boolean)AnchorLinkExtension.ANCHORLINKS_WRAP_TEXT.get(paramDataHolder)).booleanValue();
/* 17 */     this.textPrefix = (String)AnchorLinkExtension.ANCHORLINKS_TEXT_PREFIX.get(paramDataHolder);
/* 18 */     this.textSuffix = (String)AnchorLinkExtension.ANCHORLINKS_TEXT_SUFFIX.get(paramDataHolder);
/* 19 */     this.anchorClass = (String)AnchorLinkExtension.ANCHORLINKS_ANCHOR_CLASS.get(paramDataHolder);
/* 20 */     this.setName = ((Boolean)AnchorLinkExtension.ANCHORLINKS_SET_NAME.get(paramDataHolder)).booleanValue();
/* 21 */     this.setId = ((Boolean)AnchorLinkExtension.ANCHORLINKS_SET_ID.get(paramDataHolder)).booleanValue();
/* 22 */     this.noBlockQuotes = ((Boolean)AnchorLinkExtension.ANCHORLINKS_NO_BLOCK_QUOTE.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\anchorlink\internal\AnchorLinkOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */