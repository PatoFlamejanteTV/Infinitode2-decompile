/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.Utils;
/*    */ 
/*    */ public class FormattedCounter {
/*    */   private final NumberFormat numberFormat;
/*    */   private final Boolean isLowercase;
/*    */   private final String delimiter;
/*    */   private int count;
/*    */   
/*    */   public FormattedCounter(NumberFormat paramNumberFormat, Boolean paramBoolean, String paramString) {
/* 12 */     this.numberFormat = paramNumberFormat;
/* 13 */     this.isLowercase = paramBoolean;
/* 14 */     this.delimiter = paramString;
/* 15 */     reset();
/*    */   }
/*    */   
/*    */   public void reset() {
/* 19 */     this.count = 0;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 23 */     return this.count;
/*    */   }
/*    */   
/*    */   public int nextCount() {
/* 27 */     return ++this.count;
/*    */   }
/*    */   
/*    */   public String getFormatted(boolean paramBoolean) {
/* 31 */     String str = NumberFormat.getFormat(this.numberFormat, Utils.minLimit(this.count, new int[] { 1 }));
/* 32 */     str = (this.isLowercase == null) ? str : (this.isLowercase.booleanValue() ? str.toLowerCase() : str.toUpperCase());
/* 33 */     return (paramBoolean && this.delimiter != null && !this.delimiter.isEmpty()) ? (str + this.delimiter) : str;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\FormattedCounter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */