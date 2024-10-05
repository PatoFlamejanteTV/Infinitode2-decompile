/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*    */ 
/*    */ public interface CharWidthProvider {
/*    */   int getSpaceWidth();
/*    */   
/*    */   int getCharWidth(char paramChar);
/*    */   
/*    */   default int getStringWidth(CharSequence paramCharSequence) {
/* 11 */     return getStringWidth(paramCharSequence, CharPredicate.NONE);
/*    */   }
/*    */   
/*    */   default int getStringWidth(CharSequence paramCharSequence, CharPredicate paramCharPredicate) {
/* 15 */     int i = paramCharSequence.length();
/* 16 */     int j = 0;
/*    */     
/* 18 */     for (byte b = 0; b < i; b++) {
/* 19 */       char c = paramCharSequence.charAt(b);
/* 20 */       if (!paramCharPredicate.test(c)) {
/* 21 */         j += getCharWidth(c);
/*    */       }
/*    */     } 
/* 24 */     return j;
/*    */   }
/*    */   
/* 27 */   public static final CharWidthProvider NULL = new CharWidthProvider()
/*    */     {
/*    */       public final int getSpaceWidth() {
/* 30 */         return 1;
/*    */       }
/*    */ 
/*    */       
/*    */       public final int getCharWidth(char param1Char) {
/* 35 */         return 1;
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\CharWidthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */