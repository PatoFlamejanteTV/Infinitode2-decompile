/*     */ package com.vladsch.flexmark.util.misc;public interface CharPredicate extends IntPredicate { public static final CharPredicate NONE = paramInt -> false; public static final CharPredicate ALL = paramInt -> true;
/*     */   public static final CharPredicate SPACE;
/*     */   public static final CharPredicate TAB;
/*     */   public static final CharPredicate EOL;
/*     */   public static final CharPredicate ANY_EOL;
/*     */   public static final CharPredicate ANY_EOL_NUL;
/*     */   public static final CharPredicate BACKSLASH;
/*     */   public static final CharPredicate SLASH;
/*     */   public static final CharPredicate LINE_SEP;
/*     */   public static final CharPredicate HASH;
/*     */   public static final CharPredicate SPACE_TAB;
/*     */   public static final CharPredicate SPACE_TAB_NUL;
/*     */   public static final CharPredicate SPACE_TAB_LINE_SEP;
/*     */   
/*     */   static {
/*  16 */     SPACE = (paramInt -> (paramInt == 32));
/*  17 */     TAB = (paramInt -> (paramInt == 9));
/*  18 */     EOL = (paramInt -> (paramInt == 10));
/*  19 */     ANY_EOL = (paramInt -> (paramInt == 10 || paramInt == 13));
/*  20 */     ANY_EOL_NUL = (paramInt -> (paramInt == 10 || paramInt == 13 || paramInt == 0));
/*  21 */     BACKSLASH = (paramInt -> (paramInt == 92));
/*  22 */     SLASH = (paramInt -> (paramInt == 47));
/*  23 */     LINE_SEP = (paramInt -> (paramInt == 8232));
/*  24 */     HASH = (paramInt -> (paramInt == 35));
/*  25 */     SPACE_TAB = (paramInt -> (paramInt == 32 || paramInt == 9));
/*  26 */     SPACE_TAB_NUL = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 0));
/*  27 */     SPACE_TAB_LINE_SEP = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 8232));
/*  28 */     SPACE_TAB_NBSP_LINE_SEP = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 160 || paramInt == 8232));
/*  29 */     SPACE_EOL = (paramInt -> (paramInt == 32 || paramInt == 10));
/*  30 */     SPACE_ANY_EOL = (paramInt -> (paramInt == 32 || paramInt == 13 || paramInt == 10));
/*  31 */     SPACE_TAB_NBSP = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 160));
/*  32 */     SPACE_TAB_EOL = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 10));
/*  33 */     SPACE_TAB_NBSP_EOL = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 160));
/*  34 */     WHITESPACE = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 13));
/*  35 */     WHITESPACE_OR_NUL = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 13 || paramInt == 0));
/*  36 */     WHITESPACE_NBSP = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 13 || paramInt == 160));
/*  37 */     WHITESPACE_NBSP_OR_NUL = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 13 || paramInt == 160 || paramInt == 0));
/*  38 */     BLANKSPACE = (paramInt -> (paramInt == 32 || paramInt == 9 || paramInt == 10 || paramInt == 13 || paramInt == 11 || paramInt == 12));
/*  39 */     HEXADECIMAL_DIGITS = (paramInt -> ((paramInt >= 48 && paramInt <= 57) || (paramInt >= 97 && paramInt <= 102) || (paramInt >= 65 && paramInt <= 70)));
/*  40 */     DECIMAL_DIGITS = (paramInt -> (paramInt >= 48 && paramInt <= 57));
/*  41 */     OCTAL_DIGITS = (paramInt -> (paramInt >= 48 && paramInt <= 55));
/*  42 */     BINARY_DIGITS = (paramInt -> (paramInt >= 48 && paramInt <= 49));
/*     */   }
/*     */   public static final CharPredicate SPACE_TAB_NBSP_LINE_SEP; public static final CharPredicate SPACE_EOL; public static final CharPredicate SPACE_ANY_EOL; public static final CharPredicate SPACE_TAB_NBSP; public static final CharPredicate SPACE_TAB_EOL; public static final CharPredicate SPACE_TAB_NBSP_EOL; public static final CharPredicate WHITESPACE; public static final CharPredicate WHITESPACE_OR_NUL; public static final CharPredicate WHITESPACE_NBSP; public static final CharPredicate WHITESPACE_NBSP_OR_NUL; public static final CharPredicate BLANKSPACE; public static final CharPredicate HEXADECIMAL_DIGITS; public static final CharPredicate DECIMAL_DIGITS; public static final CharPredicate OCTAL_DIGITS; public static final CharPredicate BINARY_DIGITS; @Deprecated
/*  45 */   public static final CharPredicate FALSE = NONE;
/*     */   @Deprecated
/*  47 */   public static final CharPredicate TRUE = ALL;
/*     */   @Deprecated
/*  49 */   public static final CharPredicate SPACE_TAB_OR_NUL = SPACE_TAB_NUL;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean test(char paramChar) {
/*  55 */     return test(paramChar);
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
/*     */   default CharPredicate and(CharPredicate paramCharPredicate) {
/*  76 */     Objects.requireNonNull(paramCharPredicate);
/*  77 */     return (this == NONE || paramCharPredicate == NONE) ? NONE : ((this == ALL) ? paramCharPredicate : ((paramCharPredicate == ALL) ? this : (paramInt -> (test(paramInt) && paramCharPredicate.test(paramInt)))));
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
/*     */   default CharPredicate negate() {
/*  89 */     return (this == NONE) ? ALL : ((this == ALL) ? NONE : (paramInt -> !test(paramInt)));
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
/*     */   default CharPredicate or(CharPredicate paramCharPredicate) {
/* 110 */     Objects.requireNonNull(paramCharPredicate);
/* 111 */     return (this == ALL || paramCharPredicate == ALL) ? ALL : ((this == NONE) ? paramCharPredicate : ((paramCharPredicate == NONE) ? this : (paramInt -> (test(paramInt) || paramCharPredicate.test(paramInt)))));
/*     */   }
/*     */ 
/*     */   
/*     */   static CharPredicate standardOrAnyOf(char paramChar) {
/* 116 */     if (SPACE.test(paramChar)) return SPACE;  if (EOL
/* 117 */       .test(paramChar)) return EOL;  if (TAB
/* 118 */       .test(paramChar)) return TAB;
/*     */     
/*     */     return paramInt -> (paramInt == paramChar);
/*     */   }
/*     */   
/*     */   static CharPredicate standardOrAnyOf(char paramChar1, char paramChar2) {
/* 124 */     if (paramChar1 == paramChar2) return standardOrAnyOf(paramChar1);  if (SPACE_TAB
/* 125 */       .test(paramChar1) && SPACE_TAB.test(paramChar2)) return SPACE_TAB;  if (ANY_EOL
/* 126 */       .test(paramChar1) && ANY_EOL.test(paramChar2)) return ANY_EOL; 
/* 127 */     return paramInt -> (paramInt == paramChar1 || paramInt == paramChar2);
/*     */   }
/*     */ 
/*     */   
/*     */   static CharPredicate standardOrAnyOf(char paramChar1, char paramChar2, char paramChar3) {
/* 132 */     if (paramChar1 == paramChar2 && paramChar2 == paramChar3) return standardOrAnyOf(paramChar1);  if (paramChar1 == paramChar2 || paramChar1 == paramChar3)
/* 133 */       return standardOrAnyOf(paramChar2, paramChar3);  if (paramChar2 == paramChar3)
/* 134 */       return standardOrAnyOf(paramChar1, paramChar3); 
/* 135 */     return paramInt -> (paramInt == paramChar1 || paramInt == paramChar2 || paramInt == paramChar3);
/*     */   }
/*     */ 
/*     */   
/*     */   static CharPredicate standardOrAnyOf(char paramChar1, char paramChar2, char paramChar3, char paramChar4) {
/* 140 */     if (paramChar1 == paramChar2 && paramChar2 == paramChar3 && paramChar3 == paramChar4) return standardOrAnyOf(paramChar1);  if (paramChar1 == paramChar2 || paramChar1 == paramChar3 || paramChar1 == paramChar4)
/* 141 */       return standardOrAnyOf(paramChar2, paramChar3, paramChar4);  if (paramChar2 == paramChar3 || paramChar2 == paramChar4)
/* 142 */       return standardOrAnyOf(paramChar1, paramChar3, paramChar4);  if (paramChar3 == paramChar4)
/* 143 */       return standardOrAnyOf(paramChar1, paramChar2, paramChar3);  if (WHITESPACE
/* 144 */       .test(paramChar1) && WHITESPACE.test(paramChar2) && WHITESPACE.test(paramChar3) && WHITESPACE.test(paramChar4)) return WHITESPACE; 
/* 145 */     return paramInt -> (paramInt == paramChar1 || paramInt == paramChar2 || paramInt == paramChar3 || paramInt == paramChar4);
/*     */   }
/*     */ 
/*     */   
/*     */   static CharPredicate anyOf(char... paramVarArgs) {
/* 150 */     switch (paramVarArgs.length) {
/*     */       case 0:
/* 152 */         return NONE;
/*     */       case 1:
/* 154 */         return standardOrAnyOf(paramVarArgs[0]);
/*     */       case 2:
/* 156 */         return standardOrAnyOf(paramVarArgs[0], paramVarArgs[1]);
/*     */       case 3:
/* 158 */         return standardOrAnyOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
/*     */       case 4:
/* 160 */         return standardOrAnyOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
/*     */     } 
/* 162 */     return anyOf(String.valueOf(paramVarArgs));
/*     */   }
/*     */ 
/*     */   
/*     */   static int indexOf(CharSequence paramCharSequence, char paramChar) {
/* 167 */     return indexOf(paramCharSequence, paramChar, 0, paramCharSequence.length());
/*     */   }
/*     */   
/*     */   static int indexOf(CharSequence paramCharSequence, char paramChar, int paramInt1, int paramInt2) {
/* 171 */     paramInt1 = Math.max(paramInt1, 0);
/* 172 */     paramInt2 = Math.min(paramCharSequence.length(), paramInt2);
/*     */     
/* 174 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/* 175 */       if (paramChar == paramCharSequence.charAt(paramInt1)) return paramInt1; 
/*     */     } 
/* 177 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static CharPredicate anyOf(CharSequence paramCharSequence) {
/* 183 */     switch (paramCharSequence.length()) {
/*     */       case 0:
/* 185 */         return NONE;
/*     */       case 1:
/* 187 */         return standardOrAnyOf(paramCharSequence.charAt(0));
/*     */       case 2:
/* 189 */         return standardOrAnyOf(paramCharSequence.charAt(0), paramCharSequence.charAt(1));
/*     */       case 3:
/* 191 */         return standardOrAnyOf(paramCharSequence.charAt(0), paramCharSequence.charAt(1), paramCharSequence.charAt(2));
/*     */       case 4:
/* 193 */         return standardOrAnyOf(paramCharSequence.charAt(0), paramCharSequence.charAt(1), paramCharSequence.charAt(2), paramCharSequence.charAt(3));
/*     */     } 
/*     */     
/* 196 */     BitSet bitSet = null;
/* 197 */     StringBuilder stringBuilder = null;
/* 198 */     int i = paramCharSequence.length();
/*     */     
/* 200 */     for (byte b = 0; b < i; b++) {
/*     */       char c;
/* 202 */       if ((c = paramCharSequence.charAt(b)) <= '') {
/* 203 */         if (bitSet == null) bitSet = new BitSet(); 
/* 204 */         bitSet.set(c);
/*     */       } else {
/* 206 */         if (stringBuilder == null) stringBuilder = new StringBuilder(); 
/* 207 */         if (indexOf(stringBuilder, c) == -1) {
/* 208 */           stringBuilder.append(c);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*     */     String str;
/* 214 */     CharPredicate charPredicate2 = ((str = (String)((stringBuilder == null) ? null : stringBuilder.toString())) == null || str.isEmpty()) ? null : ((str.length() <= 4) ? anyOf(stringBuilder) : (paramInt -> (indexOf(paramString, (char)paramInt) != -1)));
/* 215 */     CharPredicate charPredicate1 = (bitSet == null || bitSet.cardinality() == 0) ? null : bitSet::get;
/*     */     
/* 217 */     if (!null.$assertionsDisabled && charPredicate1 == null && charPredicate2 == null) throw new AssertionError();
/*     */     
/* 219 */     if (charPredicate1 != null && charPredicate2 != null)
/* 220 */       return charPredicate1.or(charPredicate2); 
/* 221 */     if (charPredicate1 != null) {
/* 222 */       return charPredicate1;
/*     */     }
/* 224 */     return charPredicate2;
/*     */   }
/*     */   
/*     */   boolean test(int paramInt); }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\CharPredicate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */