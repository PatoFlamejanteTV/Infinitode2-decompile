/*     */ package com.vladsch.flexmark.util.format;
/*     */ 
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RomanNumeral
/*     */ {
/*     */   private final int num;
/*  25 */   private static final int[] numbers = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/*  26 */   private static final String[] letters = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/*     */ 
/*     */   
/*  29 */   public static final Pattern ROMAN_NUMERAL = Pattern.compile("M{0,3}(?:CM|DC{0,3}|CD|C{1,3})?(?:XC|LX{0,3}|XL|X{1,3})?(?:IX|VI{0,3}|IV|I{1,3})?");
/*  30 */   public static final Pattern LOWERCASE_ROMAN_NUMERAL = Pattern.compile("m{0,3}(?:cm|dc{0,3}|cd|c{1,3})?(?:xc|lx{0,3}|xl|x{1,3})?(?:ix|vi{0,3}|iv|i{1,3})?");
/*  31 */   public static final Pattern LIMITED_ROMAN_NUMERAL = Pattern.compile("(?:X{1,3})?(?:IX|VI{0,3}|IV|I{1,3})?");
/*  32 */   public static final Pattern LIMITED_LOWERCASE_ROMAN_NUMERAL = Pattern.compile("(?:x{1,3})?(?:ix|vi{0,3}|iv|i{1,3})?");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RomanNumeral(int paramInt) {
/*  38 */     if (paramInt <= 0)
/*  39 */       throw new NumberFormatException("Value of RomanNumeral must be positive."); 
/*  40 */     if (paramInt > 3999)
/*  41 */       throw new NumberFormatException("Value of RomanNumeral must be 3999 or less."); 
/*  42 */     this.num = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RomanNumeral(String paramString) {
/*  51 */     if (paramString.length() == 0) {
/*  52 */       throw new NumberFormatException("An empty string does not define a Roman numeral.");
/*     */     }
/*  54 */     paramString = paramString.toUpperCase();
/*     */     
/*  56 */     byte b = 0;
/*  57 */     int i = 0;
/*     */     
/*  59 */     while (b < paramString.length()) {
/*     */       
/*  61 */       char c = paramString.charAt(b);
/*     */       
/*     */       int j;
/*  64 */       if ((j = letterToNumber(c)) < 0) {
/*  65 */         throw new NumberFormatException("Illegal character \"" + c + "\" in roman numeral.");
/*     */       }
/*  67 */       b++;
/*     */       
/*  69 */       if (b != paramString.length()) {
/*     */         int k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  78 */         if ((k = letterToNumber(paramString.charAt(b))) > j) {
/*     */           
/*  80 */           i += k - j;
/*  81 */           b++; continue;
/*     */         } 
/*     */       } 
/*  84 */       i += j;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  89 */     if (i > 3999) {
/*  90 */       throw new NumberFormatException("Roman numeral must have value 3999 or less.");
/*     */     }
/*  92 */     this.num = i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int letterToNumber(char paramChar) {
/*  98 */     switch (paramChar) {
/*     */       case 'I':
/* 100 */         return 1;
/*     */       case 'V':
/* 102 */         return 5;
/*     */       case 'X':
/* 104 */         return 10;
/*     */       case 'L':
/* 106 */         return 50;
/*     */       case 'C':
/* 108 */         return 100;
/*     */       case 'D':
/* 110 */         return 500;
/*     */       case 'M':
/* 112 */         return 1000;
/*     */     } 
/* 114 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder stringBuilder = new StringBuilder();
/* 121 */     int i = this.num;
/* 122 */     for (byte b = 0; b < numbers.length; b++) {
/* 123 */       while (i >= numbers[b]) {
/* 124 */         stringBuilder.append(letters[b]);
/* 125 */         i -= numbers[b];
/*     */       } 
/*     */     } 
/* 128 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int toInt() {
/* 133 */     return this.num;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\RomanNumeral.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */