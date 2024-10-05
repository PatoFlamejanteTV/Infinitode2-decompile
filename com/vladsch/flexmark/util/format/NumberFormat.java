/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ public enum NumberFormat {
/*  4 */   NONE,
/*  5 */   ARABIC,
/*  6 */   LETTERS,
/*  7 */   ROMAN,
/*  8 */   CUSTOM;
/*    */ 
/*    */   
/*    */   public static String getFormat(NumberFormat paramNumberFormat, int paramInt) {
/* 12 */     switch (paramNumberFormat) {
/*    */       case NONE:
/* 14 */         return "";
/*    */       case ARABIC:
/* 16 */         return String.valueOf(paramInt);
/*    */       case LETTERS:
/* 18 */         if (paramInt <= 0) throw new NumberFormatException("Letter format count must be > 0, actual " + paramInt); 
/* 19 */         return getFormat(paramInt - 1, "abcdefghijklmnopqrstuvwxyz");
/*    */       case ROMAN:
/* 21 */         return (new RomanNumeral(paramInt)).toString();
/*    */       case CUSTOM:
/* 23 */         throw new IllegalStateException("CounterFormat.CUSTOM has to use custom conversion, possibly by calling getFormat(int count, CharSequence digitSet)");
/*    */     } 
/* 25 */     return "";
/*    */   }
/*    */   
/*    */   public static String getFormat(int paramInt, CharSequence paramCharSequence) {
/* 29 */     StringBuilder stringBuilder2 = new StringBuilder(10);
/* 30 */     int j = paramCharSequence.length();
/*    */     do {
/* 32 */       k = paramInt / j;
/* 33 */       paramInt -= k * j;
/* 34 */       stringBuilder2.append(paramCharSequence.charAt(paramInt));
/*    */     }
/* 36 */     while ((paramInt = k) > 0);
/*    */     
/* 38 */     int k = stringBuilder2.length();
/* 39 */     StringBuilder stringBuilder1 = new StringBuilder(k);
/* 40 */     for (int i = k; i-- > 0;) {
/* 41 */       stringBuilder1.append(stringBuilder2.charAt(i));
/*    */     }
/*    */     
/* 44 */     return stringBuilder1.toString();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\NumberFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */