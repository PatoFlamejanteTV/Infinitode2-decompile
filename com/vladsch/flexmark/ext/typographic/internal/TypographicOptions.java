/*    */ package com.vladsch.flexmark.ext.typographic.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.typographic.TypographicExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ public class TypographicOptions {
/*    */   public final boolean typographicQuotes;
/*    */   public final boolean typographicSmarts;
/*    */   public final String ellipsis;
/*    */   public final String ellipsisSpaced;
/*    */   public final String enDash;
/*    */   public final String emDash;
/*    */   public final String singleQuoteOpen;
/*    */   public final String singleQuoteClose;
/*    */   public final String singleQuoteUnmatched;
/*    */   public final String doubleQuoteOpen;
/*    */   public final String doubleQuoteClose;
/*    */   public final String doubleQuoteUnmatched;
/*    */   public final String angleQuoteOpen;
/*    */   public final String angleQuoteClose;
/*    */   public final String angleQuoteUnmatched;
/*    */   
/*    */   public TypographicOptions(DataHolder paramDataHolder) {
/* 24 */     this.typographicQuotes = ((Boolean)TypographicExtension.ENABLE_QUOTES.get(paramDataHolder)).booleanValue();
/* 25 */     this.typographicSmarts = ((Boolean)TypographicExtension.ENABLE_SMARTS.get(paramDataHolder)).booleanValue();
/* 26 */     this.ellipsis = (String)TypographicExtension.ELLIPSIS.get(paramDataHolder);
/* 27 */     this.ellipsisSpaced = (String)TypographicExtension.ELLIPSIS_SPACED.get(paramDataHolder);
/* 28 */     this.enDash = (String)TypographicExtension.EN_DASH.get(paramDataHolder);
/* 29 */     this.emDash = (String)TypographicExtension.EM_DASH.get(paramDataHolder);
/* 30 */     this.singleQuoteOpen = (String)TypographicExtension.SINGLE_QUOTE_OPEN.get(paramDataHolder);
/* 31 */     this.singleQuoteClose = (String)TypographicExtension.SINGLE_QUOTE_CLOSE.get(paramDataHolder);
/* 32 */     this.singleQuoteUnmatched = (String)TypographicExtension.SINGLE_QUOTE_UNMATCHED.get(paramDataHolder);
/* 33 */     this.doubleQuoteOpen = (String)TypographicExtension.DOUBLE_QUOTE_OPEN.get(paramDataHolder);
/* 34 */     this.doubleQuoteClose = (String)TypographicExtension.DOUBLE_QUOTE_CLOSE.get(paramDataHolder);
/* 35 */     this.doubleQuoteUnmatched = (String)TypographicExtension.DOUBLE_QUOTE_UNMATCHED.get(paramDataHolder);
/* 36 */     this.angleQuoteOpen = (String)TypographicExtension.ANGLE_QUOTE_OPEN.get(paramDataHolder);
/* 37 */     this.angleQuoteClose = (String)TypographicExtension.ANGLE_QUOTE_CLOSE.get(paramDataHolder);
/* 38 */     this.angleQuoteUnmatched = (String)TypographicExtension.ANGLE_QUOTE_UNMATCHED.get(paramDataHolder);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\internal\TypographicOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */