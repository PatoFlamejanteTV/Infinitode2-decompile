/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ import java.util.Locale;
/*    */ 
/*    */ public class ListState {
/*    */   public final boolean isNumbered;
/*    */   public int itemCount;
/*    */   
/*    */   public ListState(boolean paramBoolean) {
/* 10 */     this.isNumbered = paramBoolean;
/* 11 */     this.itemCount = 0;
/*    */   }
/*    */   
/*    */   public String getItemPrefix(HtmlConverterOptions paramHtmlConverterOptions) {
/* 15 */     if (this.isNumbered) {
/* 16 */       return String.format(Locale.US, "%d%c ", new Object[] { Integer.valueOf(this.itemCount), Character.valueOf(paramHtmlConverterOptions.orderedListDelimiter) });
/*    */     }
/* 18 */     return String.format("%c ", new Object[] { Character.valueOf(paramHtmlConverterOptions.unorderedListDelimiter) });
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\ListState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */