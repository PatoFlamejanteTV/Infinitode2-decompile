/*     */ package com.google.common.base;
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
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public final class Ascii
/*     */ {
/*     */   public static final byte NUL = 0;
/*     */   public static final byte SOH = 1;
/*     */   public static final byte STX = 2;
/*     */   public static final byte ETX = 3;
/*     */   public static final byte EOT = 4;
/*     */   public static final byte ENQ = 5;
/*     */   public static final byte ACK = 6;
/*     */   public static final byte BEL = 7;
/*     */   public static final byte BS = 8;
/*     */   public static final byte HT = 9;
/*     */   public static final byte LF = 10;
/*     */   public static final byte NL = 10;
/*     */   public static final byte VT = 11;
/*     */   public static final byte FF = 12;
/*     */   public static final byte CR = 13;
/*     */   public static final byte SO = 14;
/*     */   public static final byte SI = 15;
/*     */   public static final byte DLE = 16;
/*     */   public static final byte DC1 = 17;
/*     */   public static final byte XON = 17;
/*     */   public static final byte DC2 = 18;
/*     */   public static final byte DC3 = 19;
/*     */   public static final byte XOFF = 19;
/*     */   public static final byte DC4 = 20;
/*     */   public static final byte NAK = 21;
/*     */   public static final byte SYN = 22;
/*     */   public static final byte ETB = 23;
/*     */   public static final byte CAN = 24;
/*     */   public static final byte EM = 25;
/*     */   public static final byte SUB = 26;
/*     */   public static final byte ESC = 27;
/*     */   public static final byte FS = 28;
/*     */   public static final byte GS = 29;
/*     */   public static final byte RS = 30;
/*     */   public static final byte US = 31;
/*     */   public static final byte SP = 32;
/*     */   public static final byte SPACE = 32;
/*     */   public static final byte DEL = 127;
/*     */   public static final char MIN = '\000';
/*     */   public static final char MAX = '';
/*     */   private static final char CASE_MASK = ' ';
/*     */   
/*     */   public static String toLowerCase(String paramString) {
/*     */     char[] arrayOfChar;
/* 408 */     int i = paramString.length();
/* 409 */     for (byte b = 0; b < i; b++) {
/* 410 */       if (isUpperCase(paramString.charAt(b))) {
/* 411 */         arrayOfChar = paramString.toCharArray();
/* 412 */         for (; b < i; b++) {
/*     */           char c;
/* 414 */           if (isUpperCase(c = arrayOfChar[b])) {
/* 415 */             arrayOfChar[b] = (char)(c ^ 0x20);
/*     */           }
/*     */         } 
/* 418 */         return String.valueOf(arrayOfChar);
/*     */       } 
/*     */     } 
/* 421 */     return (String)arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toLowerCase(CharSequence paramCharSequence) {
/* 432 */     if (paramCharSequence instanceof String) {
/* 433 */       return toLowerCase((String)paramCharSequence);
/*     */     }
/* 435 */     char[] arrayOfChar = new char[paramCharSequence.length()];
/* 436 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 437 */       arrayOfChar[b] = toLowerCase(paramCharSequence.charAt(b));
/*     */     }
/* 439 */     return String.valueOf(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char toLowerCase(char paramChar) {
/* 447 */     return isUpperCase(paramChar) ? (char)(paramChar ^ 0x20) : paramChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toUpperCase(String paramString) {
/*     */     char[] arrayOfChar;
/* 456 */     int i = paramString.length();
/* 457 */     for (byte b = 0; b < i; b++) {
/* 458 */       if (isLowerCase(paramString.charAt(b))) {
/* 459 */         arrayOfChar = paramString.toCharArray();
/* 460 */         for (; b < i; b++) {
/*     */           char c;
/* 462 */           if (isLowerCase(c = arrayOfChar[b])) {
/* 463 */             arrayOfChar[b] = (char)(c ^ 0x20);
/*     */           }
/*     */         } 
/* 466 */         return String.valueOf(arrayOfChar);
/*     */       } 
/*     */     } 
/* 469 */     return (String)arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toUpperCase(CharSequence paramCharSequence) {
/* 480 */     if (paramCharSequence instanceof String) {
/* 481 */       return toUpperCase((String)paramCharSequence);
/*     */     }
/* 483 */     char[] arrayOfChar = new char[paramCharSequence.length()];
/* 484 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 485 */       arrayOfChar[b] = toUpperCase(paramCharSequence.charAt(b));
/*     */     }
/* 487 */     return String.valueOf(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char toUpperCase(char paramChar) {
/* 495 */     return isLowerCase(paramChar) ? (char)(paramChar ^ 0x20) : paramChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isLowerCase(char paramChar) {
/* 506 */     return (paramChar >= 'a' && paramChar <= 'z');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isUpperCase(char paramChar) {
/* 515 */     return (paramChar >= 'A' && paramChar <= 'Z');
/*     */   }
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
/*     */   public static String truncate(CharSequence paramCharSequence, int paramInt, String paramString) {
/* 551 */     Preconditions.checkNotNull(paramCharSequence);
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/* 558 */     Preconditions.checkArgument(((i = paramInt - paramString.length()) >= 0), "maxLength (%s) must be >= length of the truncation indicator (%s)", paramInt, paramString
/*     */ 
/*     */ 
/*     */         
/* 562 */         .length());
/*     */     
/* 564 */     if (paramCharSequence.length() <= paramInt) {
/*     */       
/* 566 */       if ((paramCharSequence = paramCharSequence.toString()).length() <= paramInt) {
/* 567 */         return (String)paramCharSequence;
/*     */       }
/*     */       
/* 570 */       paramCharSequence = paramCharSequence;
/*     */     } 
/*     */     
/* 573 */     return (new StringBuilder(paramInt))
/* 574 */       .append(paramCharSequence, 0, i)
/* 575 */       .append(paramString)
/* 576 */       .toString();
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equalsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 603 */     int i = paramCharSequence1.length();
/* 604 */     if (paramCharSequence1 == paramCharSequence2) {
/* 605 */       return true;
/*     */     }
/* 607 */     if (i != paramCharSequence2.length()) {
/* 608 */       return false;
/*     */     }
/* 610 */     for (byte b = 0; b < i; b++) {
/* 611 */       char c1 = paramCharSequence1.charAt(b);
/* 612 */       char c2 = paramCharSequence2.charAt(b);
/* 613 */       if (c1 != c2) {
/*     */         int j;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 619 */         if ((j = getAlphaIndex(c1)) >= 26 || j != getAlphaIndex(c2))
/*     */         {
/*     */           
/* 622 */           return false; } 
/*     */       } 
/* 624 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getAlphaIndex(char paramChar) {
/* 633 */     return (char)((paramChar | 0x20) - 97);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Ascii.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */