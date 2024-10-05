/*      */ package com.google.common.base;
/*      */ 
/*      */ import java.util.Arrays;
/*      */ import java.util.BitSet;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @ElementTypesAreNonnullByDefault
/*      */ public abstract class CharMatcher
/*      */   implements Predicate<Character>
/*      */ {
/*      */   private static final int DISTINCT_CHARS = 65536;
/*      */   
/*      */   public static CharMatcher any() {
/*  119 */     return Any.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher none() {
/*  128 */     return None.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher whitespace() {
/*  146 */     return Whitespace.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher breakingWhitespace() {
/*  157 */     return BreakingWhitespace.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher ascii() {
/*  166 */     return Ascii.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static CharMatcher digit() {
/*  179 */     return Digit.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static CharMatcher javaDigit() {
/*  192 */     return JavaDigit.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static CharMatcher javaLetter() {
/*  205 */     return JavaLetter.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static CharMatcher javaLetterOrDigit() {
/*  217 */     return JavaLetterOrDigit.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static CharMatcher javaUpperCase() {
/*  230 */     return JavaUpperCase.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static CharMatcher javaLowerCase() {
/*  243 */     return JavaLowerCase.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher javaIsoControl() {
/*  255 */     return JavaIsoControl.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static CharMatcher invisible() {
/*  271 */     return Invisible.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static CharMatcher singleWidth() {
/*  289 */     return SingleWidth.INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher is(char paramChar) {
/*  296 */     return new Is(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher isNot(char paramChar) {
/*  305 */     return new IsNot(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher anyOf(CharSequence paramCharSequence) {
/*  313 */     switch (paramCharSequence.length()) {
/*      */       case 0:
/*  315 */         return none();
/*      */       case 1:
/*  317 */         return is(paramCharSequence.charAt(0));
/*      */       case 2:
/*  319 */         return isEither(paramCharSequence.charAt(0), paramCharSequence.charAt(1));
/*      */     } 
/*      */ 
/*      */     
/*  323 */     return new AnyOf(paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher noneOf(CharSequence paramCharSequence) {
/*  332 */     return anyOf(paramCharSequence).negate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher inRange(char paramChar1, char paramChar2) {
/*  343 */     return new InRange(paramChar1, paramChar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CharMatcher forPredicate(Predicate<? super Character> paramPredicate) {
/*  351 */     return (paramPredicate instanceof CharMatcher) ? (CharMatcher)paramPredicate : new ForPredicate(paramPredicate);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharMatcher negate() {
/*  372 */     return new Negated(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharMatcher and(CharMatcher paramCharMatcher) {
/*  379 */     return new And(this, paramCharMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharMatcher or(CharMatcher paramCharMatcher) {
/*  386 */     return new Or(this, paramCharMatcher);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharMatcher precomputed() {
/*  399 */     return Platform.precomputeCharMatcher(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   CharMatcher precomputedInternal() {
/*  416 */     BitSet bitSet = new BitSet();
/*  417 */     setBits(bitSet);
/*      */     int i;
/*  419 */     if ((i = bitSet.cardinality()) << 1 <= 65536) {
/*  420 */       return precomputedPositive(i, bitSet, toString());
/*      */     }
/*      */     
/*  423 */     bitSet.flip(0, 65536);
/*  424 */     i = 65536 - i;
/*  425 */     String str1 = ".negate()";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  430 */     String.valueOf(str1); final String description; str1 = (str2 = toString()).endsWith(str1) ? str2.substring(0, str2.length() - str1.length()) : ((String.valueOf(str1).length() != 0) ? String.valueOf(str2).concat(String.valueOf(str1)) : new String(String.valueOf(str2)));
/*  431 */     return new NegatedFastMatcher(this, 
/*  432 */         precomputedPositive(i, bitSet, str1))
/*      */       {
/*      */         public String toString() {
/*  435 */           return description;
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static CharMatcher precomputedPositive(int paramInt, BitSet paramBitSet, String paramString) {
/*      */     // Byte code:
/*      */     //   0: iload_0
/*      */     //   1: tableswitch default -> 64, 0 -> 28, 1 -> 32, 2 -> 42
/*      */     //   28: invokestatic none : ()Lcom/google/common/base/CharMatcher;
/*      */     //   31: areturn
/*      */     //   32: aload_1
/*      */     //   33: iconst_0
/*      */     //   34: invokevirtual nextSetBit : (I)I
/*      */     //   37: i2c
/*      */     //   38: invokestatic is : (C)Lcom/google/common/base/CharMatcher;
/*      */     //   41: areturn
/*      */     //   42: aload_1
/*      */     //   43: iconst_0
/*      */     //   44: invokevirtual nextSetBit : (I)I
/*      */     //   47: i2c
/*      */     //   48: istore_0
/*      */     //   49: aload_1
/*      */     //   50: iload_0
/*      */     //   51: iconst_1
/*      */     //   52: iadd
/*      */     //   53: invokevirtual nextSetBit : (I)I
/*      */     //   56: i2c
/*      */     //   57: istore_1
/*      */     //   58: iload_0
/*      */     //   59: iload_1
/*      */     //   60: invokestatic isEither : (CC)Lcom/google/common/base/CharMatcher$IsEither;
/*      */     //   63: areturn
/*      */     //   64: iload_0
/*      */     //   65: aload_1
/*      */     //   66: invokevirtual length : ()I
/*      */     //   69: invokestatic isSmall : (II)Z
/*      */     //   72: ifeq -> 81
/*      */     //   75: aload_1
/*      */     //   76: aload_2
/*      */     //   77: invokestatic from : (Ljava/util/BitSet;Ljava/lang/String;)Lcom/google/common/base/CharMatcher;
/*      */     //   80: areturn
/*      */     //   81: new com/google/common/base/CharMatcher$BitSetMatcher
/*      */     //   84: dup
/*      */     //   85: aload_1
/*      */     //   86: aload_2
/*      */     //   87: aconst_null
/*      */     //   88: invokespecial <init> : (Ljava/util/BitSet;Ljava/lang/String;Lcom/google/common/base/CharMatcher$1;)V
/*      */     //   91: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #447	-> 0
/*      */     //   #449	-> 28
/*      */     //   #451	-> 32
/*      */     //   #453	-> 42
/*      */     //   #454	-> 49
/*      */     //   #455	-> 58
/*      */     //   #457	-> 64
/*      */     //   #458	-> 75
/*      */     //   #459	-> 81
/*      */     //   #457	-> 91
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isSmall(int paramInt1, int paramInt2) {
/*  465 */     return (paramInt1 <= 1023 && paramInt2 > paramInt1 << 2 << 4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setBits(BitSet paramBitSet) {
/*  473 */     for (char c = '￿'; c >= '\000'; c--) {
/*  474 */       if (matches((char)c)) {
/*  475 */         paramBitSet.set(c);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matchesAnyOf(CharSequence paramCharSequence) {
/*  494 */     return !matchesNoneOf(paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matchesAllOf(CharSequence paramCharSequence) {
/*  508 */     for (int i = paramCharSequence.length() - 1; i >= 0; i--) {
/*  509 */       if (!matches(paramCharSequence.charAt(i))) {
/*  510 */         return false;
/*      */       }
/*      */     } 
/*  513 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matchesNoneOf(CharSequence paramCharSequence) {
/*  528 */     return (indexIn(paramCharSequence) == -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexIn(CharSequence paramCharSequence) {
/*  542 */     return indexIn(paramCharSequence, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexIn(CharSequence paramCharSequence, int paramInt) {
/*  561 */     int i = paramCharSequence.length();
/*  562 */     Preconditions.checkPositionIndex(paramInt, i);
/*  563 */     for (paramInt = paramInt; paramInt < i; paramInt++) {
/*  564 */       if (matches(paramCharSequence.charAt(paramInt))) {
/*  565 */         return paramInt;
/*      */       }
/*      */     } 
/*  568 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexIn(CharSequence paramCharSequence) {
/*  582 */     for (int i = paramCharSequence.length() - 1; i >= 0; i--) {
/*  583 */       if (matches(paramCharSequence.charAt(i))) {
/*  584 */         return i;
/*      */       }
/*      */     } 
/*  587 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int countIn(CharSequence paramCharSequence) {
/*  596 */     byte b1 = 0;
/*  597 */     for (byte b2 = 0; b2 < paramCharSequence.length(); b2++) {
/*  598 */       if (matches(paramCharSequence.charAt(b2))) {
/*  599 */         b1++;
/*      */       }
/*      */     } 
/*  602 */     return b1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String removeFrom(CharSequence paramCharSequence) {
/*  616 */     paramCharSequence = paramCharSequence.toString();
/*      */     int i;
/*  618 */     if ((i = indexIn(paramCharSequence)) == -1) {
/*  619 */       return (String)paramCharSequence;
/*      */     }
/*      */     
/*  622 */     char[] arrayOfChar = paramCharSequence.toCharArray();
/*  623 */     byte b = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  628 */     i++;
/*      */     
/*  630 */     while (i != arrayOfChar.length) {
/*      */ 
/*      */       
/*  633 */       if (!matches(arrayOfChar[i])) {
/*      */ 
/*      */         
/*  636 */         arrayOfChar[i - b] = arrayOfChar[i];
/*      */         continue;
/*      */       } 
/*  639 */       b++;
/*      */     } 
/*  641 */     return new String(arrayOfChar, 0, i - b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String retainFrom(CharSequence paramCharSequence) {
/*  655 */     return negate().removeFrom(paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replaceFrom(CharSequence paramCharSequence, char paramChar) {
/*  678 */     paramCharSequence = paramCharSequence.toString();
/*      */     int i;
/*  680 */     if ((i = indexIn(paramCharSequence)) == -1) {
/*  681 */       return (String)paramCharSequence;
/*      */     }
/*      */     char[] arrayOfChar;
/*  684 */     (arrayOfChar = paramCharSequence.toCharArray())[i] = paramChar;
/*  685 */     for (; ++i < arrayOfChar.length; i++) {
/*  686 */       if (matches(arrayOfChar[i])) {
/*  687 */         arrayOfChar[i] = paramChar;
/*      */       }
/*      */     } 
/*  690 */     return new String(arrayOfChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*      */     int i;
/*  713 */     if ((i = paramCharSequence2.length()) == 0) {
/*  714 */       return removeFrom(paramCharSequence1);
/*      */     }
/*  716 */     if (i == 1) {
/*  717 */       return replaceFrom(paramCharSequence1, paramCharSequence2.charAt(0));
/*      */     }
/*      */     
/*  720 */     paramCharSequence1 = paramCharSequence1.toString();
/*      */     
/*  722 */     if ((i = indexIn(paramCharSequence1)) == -1) {
/*  723 */       return (String)paramCharSequence1;
/*      */     }
/*      */     
/*  726 */     int j = paramCharSequence1.length();
/*  727 */     StringBuilder stringBuilder = new StringBuilder(j * 3 / 2 + 16);
/*      */     
/*  729 */     int k = 0;
/*      */     do {
/*  731 */       stringBuilder.append(paramCharSequence1, k, i);
/*  732 */       stringBuilder.append(paramCharSequence2);
/*  733 */       k = i + 1;
/*      */     }
/*  735 */     while ((i = indexIn(paramCharSequence1, k)) != -1);
/*      */     
/*  737 */     stringBuilder.append(paramCharSequence1, k, j);
/*  738 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String trimFrom(CharSequence paramCharSequence) {
/*  760 */     int i = paramCharSequence.length();
/*      */     
/*      */     byte b;
/*      */     
/*  764 */     for (b = 0; b < i && 
/*  765 */       matches(paramCharSequence.charAt(b)); b++);
/*      */ 
/*      */ 
/*      */     
/*  769 */     for (; --i > b && 
/*  770 */       matches(paramCharSequence.charAt(i)); i--);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  775 */     return paramCharSequence.subSequence(b, i + 1).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String trimLeadingFrom(CharSequence paramCharSequence) {
/*  789 */     int i = paramCharSequence.length();
/*  790 */     for (byte b = 0; b < i; b++) {
/*  791 */       if (!matches(paramCharSequence.charAt(b))) {
/*  792 */         return paramCharSequence.subSequence(b, i).toString();
/*      */       }
/*      */     } 
/*  795 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String trimTrailingFrom(CharSequence paramCharSequence) {
/*  810 */     for (int i = (i = paramCharSequence.length()) - 1; i >= 0; i--) {
/*  811 */       if (!matches(paramCharSequence.charAt(i))) {
/*  812 */         return paramCharSequence.subSequence(0, i + 1).toString();
/*      */       }
/*      */     } 
/*  815 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String collapseFrom(CharSequence paramCharSequence, char paramChar) {
/*  839 */     int i = paramCharSequence.length();
/*  840 */     for (byte b = 0; b < i; b++) {
/*  841 */       char c = paramCharSequence.charAt(b);
/*  842 */       if (matches(c)) {
/*  843 */         if (c == paramChar && (b == i - 1 || !matches(paramCharSequence.charAt(b + 1)))) {
/*      */           
/*  845 */           b++;
/*      */         } else {
/*  847 */           StringBuilder stringBuilder = (new StringBuilder(i)).append(paramCharSequence, 0, b).append(paramChar);
/*  848 */           return finishCollapseFrom(paramCharSequence, b + 1, i, paramChar, stringBuilder, true);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  853 */     return paramCharSequence.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String trimAndCollapseFrom(CharSequence paramCharSequence, char paramChar) {
/*  863 */     int i = paramCharSequence.length();
/*  864 */     byte b = 0;
/*  865 */     int j = i - 1;
/*      */     
/*  867 */     while (b < i && matches(paramCharSequence.charAt(b))) {
/*  868 */       b++;
/*      */     }
/*      */     
/*  871 */     while (j > b && matches(paramCharSequence.charAt(j))) {
/*  872 */       j--;
/*      */     }
/*      */     
/*  875 */     if (b == 0 && j == i - 1)
/*  876 */       return collapseFrom(paramCharSequence, paramChar); 
/*  877 */     return finishCollapseFrom(paramCharSequence, b, j + 1, paramChar, new StringBuilder(j + 1 - b), false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String finishCollapseFrom(CharSequence paramCharSequence, int paramInt1, int paramInt2, char paramChar, StringBuilder paramStringBuilder, boolean paramBoolean) {
/*  888 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  889 */       char c = paramCharSequence.charAt(paramInt1);
/*  890 */       if (matches(c)) {
/*  891 */         if (!paramBoolean) {
/*  892 */           paramStringBuilder.append(paramChar);
/*  893 */           paramBoolean = true;
/*      */         } 
/*      */       } else {
/*  896 */         paramStringBuilder.append(c);
/*  897 */         paramBoolean = false;
/*      */       } 
/*      */     } 
/*  900 */     return paramStringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public boolean apply(Character paramCharacter) {
/*  910 */     return matches(paramCharacter.charValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  919 */     return super.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String showCharacter(char paramChar) {
/*  927 */     String str = "0123456789ABCDEF";
/*  928 */     char[] arrayOfChar = { '\\', 'u', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };
/*  929 */     for (byte b = 0; b < 4; b++) {
/*  930 */       arrayOfChar[5 - b] = str.charAt(paramChar & 0xF);
/*  931 */       paramChar = (char)(paramChar >> 4);
/*      */     } 
/*  933 */     return String.copyValueOf(arrayOfChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static abstract class FastMatcher
/*      */     extends CharMatcher
/*      */   {
/*      */     public final CharMatcher precomputed() {
/*  943 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public CharMatcher negate() {
/*  948 */       return new CharMatcher.NegatedFastMatcher(this);
/*      */     }
/*      */   }
/*      */   
/*      */   static abstract class NamedFastMatcher
/*      */     extends FastMatcher
/*      */   {
/*      */     private final String description;
/*      */     
/*      */     NamedFastMatcher(String param1String) {
/*  958 */       this.description = Preconditions.<String>checkNotNull(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/*  963 */       return this.description;
/*      */     }
/*      */   }
/*      */   
/*      */   static class NegatedFastMatcher
/*      */     extends Negated
/*      */   {
/*      */     NegatedFastMatcher(CharMatcher param1CharMatcher) {
/*  971 */       super(param1CharMatcher);
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher precomputed() {
/*  976 */       return this;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class BitSetMatcher
/*      */     extends NamedFastMatcher
/*      */   {
/*      */     private final BitSet table;
/*      */     
/*      */     private BitSetMatcher(BitSet param1BitSet, String param1String) {
/*  987 */       super(param1String);
/*  988 */       if (param1BitSet.length() + 64 < param1BitSet.size()) {
/*  989 */         param1BitSet = (BitSet)param1BitSet.clone();
/*      */       }
/*      */       
/*  992 */       this.table = param1BitSet;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/*  997 */       return this.table.get(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     final void setBits(BitSet param1BitSet) {
/* 1002 */       param1BitSet.or(this.table);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class Any
/*      */     extends NamedFastMatcher
/*      */   {
/* 1011 */     static final Any INSTANCE = new Any();
/*      */     
/*      */     private Any() {
/* 1014 */       super("CharMatcher.any()");
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1019 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int indexIn(CharSequence param1CharSequence) {
/* 1024 */       return (param1CharSequence.length() == 0) ? -1 : 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int indexIn(CharSequence param1CharSequence, int param1Int) {
/* 1029 */       int i = param1CharSequence.length();
/* 1030 */       Preconditions.checkPositionIndex(param1Int, i);
/* 1031 */       return (param1Int == i) ? -1 : param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int lastIndexIn(CharSequence param1CharSequence) {
/* 1036 */       return param1CharSequence.length() - 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matchesAllOf(CharSequence param1CharSequence) {
/* 1041 */       Preconditions.checkNotNull(param1CharSequence);
/* 1042 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matchesNoneOf(CharSequence param1CharSequence) {
/* 1047 */       return (param1CharSequence.length() == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String removeFrom(CharSequence param1CharSequence) {
/* 1052 */       Preconditions.checkNotNull(param1CharSequence);
/* 1053 */       return "";
/*      */     }
/*      */ 
/*      */     
/*      */     public final String replaceFrom(CharSequence param1CharSequence, char param1Char) {
/*      */       char[] arrayOfChar;
/* 1059 */       Arrays.fill(arrayOfChar = new char[param1CharSequence.length()], param1Char);
/* 1060 */       return new String(arrayOfChar);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String replaceFrom(CharSequence param1CharSequence1, CharSequence param1CharSequence2) {
/* 1065 */       StringBuilder stringBuilder = new StringBuilder(param1CharSequence1.length() * param1CharSequence2.length());
/* 1066 */       for (byte b = 0; b < param1CharSequence1.length(); b++) {
/* 1067 */         stringBuilder.append(param1CharSequence2);
/*      */       }
/* 1069 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public final String collapseFrom(CharSequence param1CharSequence, char param1Char) {
/* 1074 */       return (param1CharSequence.length() == 0) ? "" : String.valueOf(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String trimFrom(CharSequence param1CharSequence) {
/* 1079 */       Preconditions.checkNotNull(param1CharSequence);
/* 1080 */       return "";
/*      */     }
/*      */ 
/*      */     
/*      */     public final int countIn(CharSequence param1CharSequence) {
/* 1085 */       return param1CharSequence.length();
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher and(CharMatcher param1CharMatcher) {
/* 1090 */       return Preconditions.<CharMatcher>checkNotNull(param1CharMatcher);
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher or(CharMatcher param1CharMatcher) {
/* 1095 */       Preconditions.checkNotNull(param1CharMatcher);
/* 1096 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher negate() {
/* 1101 */       return none();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class None
/*      */     extends NamedFastMatcher
/*      */   {
/* 1108 */     static final None INSTANCE = new None();
/*      */     
/*      */     private None() {
/* 1111 */       super("CharMatcher.none()");
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1116 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int indexIn(CharSequence param1CharSequence) {
/* 1121 */       Preconditions.checkNotNull(param1CharSequence);
/* 1122 */       return -1;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int indexIn(CharSequence param1CharSequence, int param1Int) {
/* 1127 */       int i = param1CharSequence.length();
/* 1128 */       Preconditions.checkPositionIndex(param1Int, i);
/* 1129 */       return -1;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int lastIndexIn(CharSequence param1CharSequence) {
/* 1134 */       Preconditions.checkNotNull(param1CharSequence);
/* 1135 */       return -1;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matchesAllOf(CharSequence param1CharSequence) {
/* 1140 */       return (param1CharSequence.length() == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matchesNoneOf(CharSequence param1CharSequence) {
/* 1145 */       Preconditions.checkNotNull(param1CharSequence);
/* 1146 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public final String removeFrom(CharSequence param1CharSequence) {
/* 1151 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public final String replaceFrom(CharSequence param1CharSequence, char param1Char) {
/* 1156 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public final String replaceFrom(CharSequence param1CharSequence1, CharSequence param1CharSequence2) {
/* 1161 */       Preconditions.checkNotNull(param1CharSequence2);
/* 1162 */       return param1CharSequence1.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public final String collapseFrom(CharSequence param1CharSequence, char param1Char) {
/* 1167 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public final String trimFrom(CharSequence param1CharSequence) {
/* 1172 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public final String trimLeadingFrom(CharSequence param1CharSequence) {
/* 1177 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public final String trimTrailingFrom(CharSequence param1CharSequence) {
/* 1182 */       return param1CharSequence.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public final int countIn(CharSequence param1CharSequence) {
/* 1187 */       Preconditions.checkNotNull(param1CharSequence);
/* 1188 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher and(CharMatcher param1CharMatcher) {
/* 1193 */       Preconditions.checkNotNull(param1CharMatcher);
/* 1194 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher or(CharMatcher param1CharMatcher) {
/* 1199 */       return Preconditions.<CharMatcher>checkNotNull(param1CharMatcher);
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher negate() {
/* 1204 */       return any();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final class Whitespace
/*      */     extends NamedFastMatcher
/*      */   {
/*      */     static final String TABLE = " 　\r   　 \013　   　 \t     \f 　 　　 \n 　";
/*      */ 
/*      */ 
/*      */     
/*      */     static final int MULTIPLIER = 1682554634;
/*      */ 
/*      */ 
/*      */     
/* 1222 */     static final int SHIFT = Integer.numberOfLeadingZeros(32 - 1);
/*      */     
/* 1224 */     static final Whitespace INSTANCE = new Whitespace();
/*      */     
/*      */     Whitespace() {
/* 1227 */       super("CharMatcher.whitespace()");
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1232 */       return (" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(param1Char * 1682554634 >>> SHIFT) == param1Char);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     final void setBits(BitSet param1BitSet) {
/* 1238 */       for (byte b = 0; b < 32; b++) {
/* 1239 */         param1BitSet.set(" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(b));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class BreakingWhitespace
/*      */     extends CharMatcher
/*      */   {
/* 1247 */     static final CharMatcher INSTANCE = new BreakingWhitespace();
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1251 */       switch (param1Char) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\013':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */         case '':
/*      */         case ' ':
/*      */         case ' ':
/*      */         case ' ':
/*      */         case ' ':
/*      */         case '　':
/* 1264 */           return true;
/*      */         case ' ':
/* 1266 */           return false;
/*      */       } 
/* 1268 */       return (param1Char >= ' ' && param1Char <= ' ');
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1274 */       return "CharMatcher.breakingWhitespace()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class Ascii
/*      */     extends NamedFastMatcher
/*      */   {
/* 1281 */     static final Ascii INSTANCE = new Ascii();
/*      */     
/*      */     Ascii() {
/* 1284 */       super("CharMatcher.ascii()");
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1289 */       return (param1Char <= '');
/*      */     }
/*      */   }
/*      */   
/*      */   private static class RangesMatcher
/*      */     extends CharMatcher
/*      */   {
/*      */     private final String description;
/*      */     private final char[] rangeStarts;
/*      */     private final char[] rangeEnds;
/*      */     
/*      */     RangesMatcher(String param1String, char[] param1ArrayOfchar1, char[] param1ArrayOfchar2) {
/* 1301 */       this.description = param1String;
/* 1302 */       this.rangeStarts = param1ArrayOfchar1;
/* 1303 */       this.rangeEnds = param1ArrayOfchar2;
/* 1304 */       Preconditions.checkArgument((param1ArrayOfchar1.length == param1ArrayOfchar2.length));
/* 1305 */       for (byte b = 0; b < param1ArrayOfchar1.length; b++) {
/* 1306 */         Preconditions.checkArgument((param1ArrayOfchar1[b] <= param1ArrayOfchar2[b]));
/* 1307 */         if (b + 1 < param1ArrayOfchar1.length) {
/* 1308 */           Preconditions.checkArgument((param1ArrayOfchar2[b] < param1ArrayOfchar1[b + 1]));
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/*      */       int i;
/* 1316 */       if ((i = Arrays.binarySearch(this.rangeStarts, param1Char)) >= 0) {
/* 1317 */         return true;
/*      */       }
/*      */       
/* 1320 */       if ((i = (i ^ 0xFFFFFFFF) - 1) >= 0 && param1Char <= this.rangeEnds[i]) return true;  return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1326 */       return this.description;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class Digit
/*      */     extends RangesMatcher
/*      */   {
/*      */     private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static char[] zeroes() {
/* 1344 */       return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
/*      */     }
/*      */     
/*      */     private static char[] nines() {
/* 1348 */       char[] arrayOfChar = new char[37];
/* 1349 */       for (byte b = 0; b < 37; b++) {
/* 1350 */         arrayOfChar[b] = (char)("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(b) + 9);
/*      */       }
/* 1352 */       return arrayOfChar;
/*      */     }
/*      */     
/* 1355 */     static final Digit INSTANCE = new Digit();
/*      */     
/*      */     private Digit() {
/* 1358 */       super("CharMatcher.digit()", zeroes(), nines());
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class JavaDigit
/*      */     extends CharMatcher
/*      */   {
/* 1365 */     static final JavaDigit INSTANCE = new JavaDigit();
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1369 */       return Character.isDigit(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1374 */       return "CharMatcher.javaDigit()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class JavaLetter
/*      */     extends CharMatcher
/*      */   {
/* 1381 */     static final JavaLetter INSTANCE = new JavaLetter();
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1385 */       return Character.isLetter(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1390 */       return "CharMatcher.javaLetter()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class JavaLetterOrDigit
/*      */     extends CharMatcher
/*      */   {
/* 1397 */     static final JavaLetterOrDigit INSTANCE = new JavaLetterOrDigit();
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1401 */       return Character.isLetterOrDigit(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1406 */       return "CharMatcher.javaLetterOrDigit()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class JavaUpperCase
/*      */     extends CharMatcher
/*      */   {
/* 1413 */     static final JavaUpperCase INSTANCE = new JavaUpperCase();
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1417 */       return Character.isUpperCase(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1422 */       return "CharMatcher.javaUpperCase()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class JavaLowerCase
/*      */     extends CharMatcher
/*      */   {
/* 1429 */     static final JavaLowerCase INSTANCE = new JavaLowerCase();
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1433 */       return Character.isLowerCase(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1438 */       return "CharMatcher.javaLowerCase()";
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class JavaIsoControl
/*      */     extends NamedFastMatcher
/*      */   {
/* 1445 */     static final JavaIsoControl INSTANCE = new JavaIsoControl();
/*      */     
/*      */     private JavaIsoControl() {
/* 1448 */       super("CharMatcher.javaIsoControl()");
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1453 */       return (param1Char <= '\037' || (param1Char >= '' && param1Char <= ''));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class Invisible
/*      */     extends RangesMatcher
/*      */   {
/*      */     private static final String RANGE_STARTS = "\000­؀؜۝܏࢐࣢ ᠎   ⁦　?﻿￹";
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String RANGE_ENDS = "  ­؅؜۝܏࢑࣢ ᠎‏ ⁤⁯　﻿￻";
/*      */ 
/*      */     
/* 1470 */     static final Invisible INSTANCE = new Invisible();
/*      */     
/*      */     private Invisible() {
/* 1473 */       super("CharMatcher.invisible()", "\000­؀؜۝܏࢐࣢ ᠎   ⁦　?﻿￹".toCharArray(), "  ­؅؜۝܏࢑࣢ ᠎‏ ⁤⁯　﻿￻".toCharArray());
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class SingleWidth
/*      */     extends RangesMatcher
/*      */   {
/* 1480 */     static final SingleWidth INSTANCE = new SingleWidth();
/*      */     
/*      */     private SingleWidth() {
/* 1483 */       super("CharMatcher.singleWidth()", "\000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡"
/*      */           
/* 1485 */           .toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ"
/* 1486 */           .toCharArray());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class Negated
/*      */     extends CharMatcher
/*      */   {
/*      */     final CharMatcher original;
/*      */ 
/*      */     
/*      */     Negated(CharMatcher param1CharMatcher) {
/* 1498 */       this.original = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matches(char param1Char) {
/* 1503 */       return !this.original.matches(param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matchesAllOf(CharSequence param1CharSequence) {
/* 1508 */       return this.original.matchesNoneOf(param1CharSequence);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean matchesNoneOf(CharSequence param1CharSequence) {
/* 1513 */       return this.original.matchesAllOf(param1CharSequence);
/*      */     }
/*      */ 
/*      */     
/*      */     public int countIn(CharSequence param1CharSequence) {
/* 1518 */       return param1CharSequence.length() - this.original.countIn(param1CharSequence);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     void setBits(BitSet param1BitSet) {
/* 1524 */       BitSet bitSet = new BitSet();
/* 1525 */       this.original.setBits(bitSet);
/* 1526 */       bitSet.flip(0, 65536);
/* 1527 */       param1BitSet.or(bitSet);
/*      */     }
/*      */ 
/*      */     
/*      */     public CharMatcher negate() {
/* 1532 */       return this.original;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1537 */       String str = String.valueOf(this.original); return (new StringBuilder(9 + String.valueOf(str).length())).append(str).append(".negate()").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class And
/*      */     extends CharMatcher
/*      */   {
/*      */     final CharMatcher first;
/*      */     final CharMatcher second;
/*      */     
/*      */     And(CharMatcher param1CharMatcher1, CharMatcher param1CharMatcher2) {
/* 1548 */       this.first = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher1);
/* 1549 */       this.second = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher2);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1554 */       return (this.first.matches(param1Char) && this.second.matches(param1Char));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     final void setBits(BitSet param1BitSet) {
/* 1560 */       BitSet bitSet1 = new BitSet();
/* 1561 */       this.first.setBits(bitSet1);
/* 1562 */       BitSet bitSet2 = new BitSet();
/* 1563 */       this.second.setBits(bitSet2);
/* 1564 */       bitSet1.and(bitSet2);
/* 1565 */       param1BitSet.or(bitSet1);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1570 */       String str1 = String.valueOf(this.first), str2 = String.valueOf(this.second); return (new StringBuilder(19 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("CharMatcher.and(").append(str1).append(", ").append(str2).append(")").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class Or
/*      */     extends CharMatcher
/*      */   {
/*      */     final CharMatcher first;
/*      */     final CharMatcher second;
/*      */     
/*      */     Or(CharMatcher param1CharMatcher1, CharMatcher param1CharMatcher2) {
/* 1581 */       this.first = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher1);
/* 1582 */       this.second = Preconditions.<CharMatcher>checkNotNull(param1CharMatcher2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     final void setBits(BitSet param1BitSet) {
/* 1588 */       this.first.setBits(param1BitSet);
/* 1589 */       this.second.setBits(param1BitSet);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1594 */       return (this.first.matches(param1Char) || this.second.matches(param1Char));
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1599 */       String str1 = String.valueOf(this.first), str2 = String.valueOf(this.second); return (new StringBuilder(18 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("CharMatcher.or(").append(str1).append(", ").append(str2).append(")").toString();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class Is
/*      */     extends FastMatcher
/*      */   {
/*      */     private final char match;
/*      */ 
/*      */     
/*      */     Is(char param1Char) {
/* 1611 */       this.match = param1Char;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1616 */       return (param1Char == this.match);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String replaceFrom(CharSequence param1CharSequence, char param1Char) {
/* 1621 */       return param1CharSequence.toString().replace(this.match, param1Char);
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher and(CharMatcher param1CharMatcher) {
/* 1626 */       return param1CharMatcher.matches(this.match) ? this : none();
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher or(CharMatcher param1CharMatcher) {
/* 1631 */       return param1CharMatcher.matches(this.match) ? param1CharMatcher : super.or(param1CharMatcher);
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher negate() {
/* 1636 */       return isNot(this.match);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     final void setBits(BitSet param1BitSet) {
/* 1642 */       param1BitSet.set(this.match);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1647 */       String str = CharMatcher.showCharacter(this.match); return (new StringBuilder(18 + String.valueOf(str).length())).append("CharMatcher.is('").append(str).append("')").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class IsNot
/*      */     extends FastMatcher
/*      */   {
/*      */     private final char match;
/*      */     
/*      */     IsNot(char param1Char) {
/* 1657 */       this.match = param1Char;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1662 */       return (param1Char != this.match);
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher and(CharMatcher param1CharMatcher) {
/* 1667 */       return param1CharMatcher.matches(this.match) ? super.and(param1CharMatcher) : param1CharMatcher;
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher or(CharMatcher param1CharMatcher) {
/* 1672 */       return param1CharMatcher.matches(this.match) ? any() : this;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     final void setBits(BitSet param1BitSet) {
/* 1678 */       param1BitSet.set(0, this.match);
/* 1679 */       param1BitSet.set(this.match + 1, 65536);
/*      */     }
/*      */ 
/*      */     
/*      */     public final CharMatcher negate() {
/* 1684 */       return is(this.match);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1689 */       String str = CharMatcher.showCharacter(this.match); return (new StringBuilder(21 + String.valueOf(str).length())).append("CharMatcher.isNot('").append(str).append("')").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static IsEither isEither(char paramChar1, char paramChar2) {
/* 1694 */     return new IsEither(paramChar1, paramChar2);
/*      */   }
/*      */   
/*      */   public abstract boolean matches(char paramChar);
/*      */   
/*      */   private static final class IsEither extends FastMatcher {
/*      */     private final char match1;
/*      */     private final char match2;
/*      */     
/*      */     IsEither(char param1Char1, char param1Char2) {
/* 1704 */       this.match1 = param1Char1;
/* 1705 */       this.match2 = param1Char2;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1710 */       return (param1Char == this.match1 || param1Char == this.match2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     final void setBits(BitSet param1BitSet) {
/* 1716 */       param1BitSet.set(this.match1);
/* 1717 */       param1BitSet.set(this.match2);
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1722 */       String str1 = CharMatcher.showCharacter(this.match1), str2 = CharMatcher.showCharacter(this.match2); return (new StringBuilder(21 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("CharMatcher.anyOf(\"").append(str1).append(str2).append("\")").toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class AnyOf
/*      */     extends CharMatcher
/*      */   {
/*      */     private final char[] chars;
/*      */     
/*      */     public AnyOf(CharSequence param1CharSequence) {
/* 1732 */       this.chars = param1CharSequence.toString().toCharArray();
/* 1733 */       Arrays.sort(this.chars);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1738 */       return (Arrays.binarySearch(this.chars, param1Char) >= 0);
/*      */     }
/*      */     final void setBits(BitSet param1BitSet) {
/*      */       char[] arrayOfChar;
/*      */       int i;
/*      */       byte b;
/* 1744 */       for (i = (arrayOfChar = this.chars).length, b = 0; b < i; ) { char c = arrayOfChar[b];
/* 1745 */         param1BitSet.set(c);
/*      */         b++; }
/*      */     
/*      */     }
/*      */     
/*      */     public final String toString() {
/* 1751 */       StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\""); char[] arrayOfChar; int i; byte b;
/* 1752 */       for (i = (arrayOfChar = this.chars).length, b = 0; b < i; ) { char c = arrayOfChar[b];
/* 1753 */         stringBuilder.append(CharMatcher.showCharacter(c)); b++; }
/*      */       
/* 1755 */       stringBuilder.append("\")");
/* 1756 */       return stringBuilder.toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class InRange
/*      */     extends FastMatcher
/*      */   {
/*      */     private final char startInclusive;
/*      */     private final char endInclusive;
/*      */     
/*      */     InRange(char param1Char1, char param1Char2) {
/* 1767 */       Preconditions.checkArgument((param1Char2 >= param1Char1));
/* 1768 */       this.startInclusive = param1Char1;
/* 1769 */       this.endInclusive = param1Char2;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1774 */       return (this.startInclusive <= param1Char && param1Char <= this.endInclusive);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     final void setBits(BitSet param1BitSet) {
/* 1780 */       param1BitSet.set(this.startInclusive, this.endInclusive + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1786 */       String str1 = CharMatcher.showCharacter(this.startInclusive);
/*      */       
/* 1788 */       String str2 = CharMatcher.showCharacter(this.endInclusive); return (new StringBuilder(27 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("CharMatcher.inRange('").append(str1).append("', '").append(str2).append("')").toString();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class ForPredicate
/*      */     extends CharMatcher
/*      */   {
/*      */     private final Predicate<? super Character> predicate;
/*      */     
/*      */     ForPredicate(Predicate<? super Character> param1Predicate) {
/* 1799 */       this.predicate = Preconditions.<Predicate<? super Character>>checkNotNull(param1Predicate);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean matches(char param1Char) {
/* 1804 */       return this.predicate.apply(Character.valueOf(param1Char));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean apply(Character param1Character) {
/* 1810 */       return this.predicate.apply(Preconditions.checkNotNull(param1Character));
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1815 */       String str = String.valueOf(this.predicate); return (new StringBuilder(26 + String.valueOf(str).length())).append("CharMatcher.forPredicate(").append(str).append(")").toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\CharMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */