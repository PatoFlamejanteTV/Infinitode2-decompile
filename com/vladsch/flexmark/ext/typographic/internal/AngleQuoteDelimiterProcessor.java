/*    */ package com.vladsch.flexmark.ext.typographic.internal;
/*    */ 
/*    */ public class AngleQuoteDelimiterProcessor extends QuoteDelimiterProcessorBase {
/*    */   public AngleQuoteDelimiterProcessor(TypographicOptions paramTypographicOptions) {
/*  5 */     super(paramTypographicOptions, '<', '>', paramTypographicOptions.angleQuoteOpen, paramTypographicOptions.angleQuoteClose, paramTypographicOptions.angleQuoteUnmatched);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMinLength() {
/* 10 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeOpener(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 15 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBeCloser(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   protected boolean isAllowed(CharSequence paramCharSequence, int paramInt) {
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\typographic\internal\AngleQuoteDelimiterProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */