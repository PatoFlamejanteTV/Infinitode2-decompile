/*      */ package com.vladsch.flexmark.util.sequence;
/*      */ 
/*      */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*      */ import com.vladsch.flexmark.util.misc.Pair;
/*      */ import com.vladsch.flexmark.util.misc.Utils;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.ParsePosition;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.function.Predicate;
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface SequenceUtils
/*      */ {
/*      */   public static final String EOL = "\n";
/*      */   public static final String SPACE = " ";
/*      */   public static final String ANY_EOL = "\r\n";
/*   22 */   public static final char EOL_CHAR = "\r\n".charAt(1);
/*   23 */   public static final char EOL_CHAR1 = "\r\n".charAt(0);
/*   24 */   public static final char EOL_CHAR2 = "\r\n".charAt(1);
/*      */   
/*      */   public static final char SPC = ' ';
/*      */   public static final char NUL = '\000';
/*      */   public static final char ENC_NUL = '�';
/*      */   public static final char NBSP = ' ';
/*      */   public static final char LS = ' ';
/*      */   public static final char US = '\037';
/*   32 */   public static final String LINE_SEP = Character.toString(' ');
/*      */   public static final String SPACE_TAB = " \t";
/*      */   public static final String SPACE_EOL = " \n";
/*   35 */   public static final String US_CHARS = Character.toString('\037');
/*      */   public static final String WHITESPACE = " \t\r\n";
/*   37 */   public static final String NBSP_CHARS = Character.toString(' ');
/*      */ 
/*      */   
/*      */   public static final String WHITESPACE_NBSP = " \t\r\n ";
/*      */   
/*      */   @Deprecated
/*   43 */   public static final CharPredicate SPACE_SET = CharPredicate.SPACE; @Deprecated
/*   44 */   public static final CharPredicate TAB_SET = CharPredicate.TAB; @Deprecated
/*   45 */   public static final CharPredicate EOL_SET = CharPredicate.EOL; @Deprecated
/*   46 */   public static final CharPredicate SPACE_TAB_SET = CharPredicate.SPACE_TAB; @Deprecated
/*   47 */   public static final CharPredicate SPACE_TAB_NBSP_SET = CharPredicate.SPACE_TAB_NBSP; @Deprecated
/*   48 */   public static final CharPredicate SPACE_TAB_EOL_SET = CharPredicate.SPACE_TAB_EOL; @Deprecated
/*   49 */   public static final CharPredicate SPACE_EOL_SET = CharPredicate.WHITESPACE; @Deprecated
/*   50 */   public static final CharPredicate ANY_EOL_SET = CharPredicate.ANY_EOL; @Deprecated
/*   51 */   public static final CharPredicate WHITESPACE_SET = CharPredicate.WHITESPACE; @Deprecated
/*   52 */   public static final CharPredicate WHITESPACE_NBSP_SET = CharPredicate.WHITESPACE_NBSP; @Deprecated public static final CharPredicate US_SET; @Deprecated
/*   53 */   public static final CharPredicate BACKSLASH_SET = CharPredicate.BACKSLASH; static {
/*   54 */     US_SET = (paramInt -> (paramInt == 31)); } @Deprecated
/*   55 */   public static final CharPredicate HASH_SET = CharPredicate.HASH; @Deprecated
/*   56 */   public static final CharPredicate DECIMAL_DIGITS = CharPredicate.HASH; @Deprecated
/*   57 */   public static final CharPredicate HEXADECIMAL_DIGITS = CharPredicate.HASH; @Deprecated
/*   58 */   public static final CharPredicate OCTAL_DIGITS = CharPredicate.HASH;
/*      */   @Deprecated
/*      */   public static final char LSEP = ' ';
/*      */   @Deprecated
/*      */   public static final String EOL_CHARS = "\r\n";
/*      */   @Deprecated
/*      */   public static final String WHITESPACE_NO_EOL_CHARS = " \t";
/*      */   @Deprecated
/*      */   public static final String WHITESPACE_CHARS = " \t\r\n";
/*      */   @Deprecated
/*      */   public static final String WHITESPACE_NBSP_CHARS = " \t\r\n ";
/*      */   public static final int SPLIT_INCLUDE_DELIMS = 1;
/*      */   public static final int SPLIT_TRIM_PARTS = 2;
/*      */   public static final int SPLIT_SKIP_EMPTY = 4;
/*      */   public static final int SPLIT_INCLUDE_DELIM_PARTS = 8;
/*      */   public static final int SPLIT_TRIM_SKIP_EMPTY = 6;
/*      */   
/*      */   static Map<Character, String> getVisibleSpacesMap() {
/*      */     HashMap<Object, Object> hashMap;
/*   77 */     (hashMap = new HashMap<>()).put(Character.valueOf('\n'), "\\n");
/*   78 */     hashMap.put(Character.valueOf('\r'), "\\r");
/*   79 */     hashMap.put(Character.valueOf('\f'), "\\f");
/*   80 */     hashMap.put(Character.valueOf('\t'), "\\u2192");
/*   81 */     hashMap.put(Character.valueOf(' '), "➥");
/*   82 */     return (Map)hashMap;
/*      */   }
/*      */   
/*   85 */   public static final Map<Character, String> visibleSpacesMap = getVisibleSpacesMap();
/*      */   
/*   87 */   public static final int[] EMPTY_INDICES = new int[0];
/*      */ 
/*      */   
/*      */   static <T extends CharSequence> T subSequence(T paramT, int paramInt) {
/*   91 */     return (T)paramT.subSequence(paramInt, paramT.length());
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
/*      */   static <T extends CharSequence> T subSequence(T paramT, Range paramRange) {
/*  104 */     return (T)(paramRange.isNull() ? (Object)paramT : paramT.subSequence(paramRange.getStart(), paramRange.getEnd()));
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
/*      */   static <T extends CharSequence> T subSequenceBefore(T paramT, Range paramRange) {
/*  117 */     return (T)(paramRange.isNull() ? null : paramT.subSequence(0, paramRange.getStart()));
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
/*      */   static <T extends CharSequence> T subSequenceAfter(T paramT, Range paramRange) {
/*  130 */     return (T)(paramRange.isNull() ? null : paramT.subSequence(paramRange.getEnd(), paramT.length()));
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
/*      */   static <T extends CharSequence> Pair<T, T> subSequenceBeforeAfter(T paramT, Range paramRange) {
/*  143 */     return Pair.of(subSequenceBefore(paramT, paramRange), subSequenceAfter(paramT, paramRange));
/*      */   }
/*      */   
/*      */   static boolean containsAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate) {
/*  147 */     return (indexOfAny(paramCharSequence, paramCharPredicate, 0, 2147483647) != -1);
/*  148 */   } static boolean containsAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return (indexOfAny(paramCharSequence, paramCharPredicate, paramInt, 2147483647) != -1); }
/*  149 */   static boolean containsAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return (indexOfAny(paramCharSequence, paramCharPredicate.negate(), 0, 2147483647) != -1); }
/*  150 */   static boolean containsAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return (indexOfAny(paramCharSequence, paramCharPredicate.negate(), paramInt, 2147483647) != -1); } static boolean containsAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  151 */     return (indexOfAny(paramCharSequence, paramCharPredicate.negate(), paramInt1, paramInt2) != -1);
/*      */   }
/*  153 */   static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2) { return indexOf(paramCharSequence1, paramCharSequence2, 0, 2147483647); }
/*  154 */   static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) { return indexOf(paramCharSequence1, paramCharSequence2, paramInt, 2147483647); }
/*  155 */   static int indexOf(CharSequence paramCharSequence, char paramChar) { return indexOf(paramCharSequence, paramChar, 0, 2147483647); }
/*  156 */   static int indexOf(CharSequence paramCharSequence, char paramChar, int paramInt) { return indexOf(paramCharSequence, paramChar, paramInt, 2147483647); }
/*  157 */   static int indexOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return indexOfAny(paramCharSequence, paramCharPredicate, 0, 2147483647); }
/*  158 */   static int indexOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return indexOfAny(paramCharSequence, paramCharPredicate, paramInt, 2147483647); }
/*  159 */   static int indexOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return indexOfAny(paramCharSequence, paramCharPredicate.negate(), 0, 2147483647); }
/*  160 */   static int indexOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return indexOfAny(paramCharSequence, paramCharPredicate.negate(), paramInt, 2147483647); }
/*  161 */   static int indexOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return indexOfAny(paramCharSequence, paramCharPredicate.negate(), paramInt1, paramInt2); }
/*  162 */   static int indexOfNot(CharSequence paramCharSequence, char paramChar) { return indexOfNot(paramCharSequence, paramChar, 0, 2147483647); } static int indexOfNot(CharSequence paramCharSequence, char paramChar, int paramInt) {
/*  163 */     return indexOfNot(paramCharSequence, paramChar, paramInt, 2147483647);
/*      */   }
/*  165 */   static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2) { return lastIndexOf(paramCharSequence1, paramCharSequence2, 0, 2147483647); }
/*  166 */   static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) { return lastIndexOf(paramCharSequence1, paramCharSequence2, 0, paramInt); }
/*  167 */   static int lastIndexOf(CharSequence paramCharSequence, char paramChar) { return lastIndexOf(paramCharSequence, paramChar, 0, 2147483647); }
/*  168 */   static int lastIndexOf(CharSequence paramCharSequence, char paramChar, int paramInt) { return lastIndexOf(paramCharSequence, paramChar, 0, paramInt); }
/*  169 */   static int lastIndexOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return lastIndexOfAny(paramCharSequence, paramCharPredicate, 0, 2147483647); }
/*  170 */   static int lastIndexOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return lastIndexOfAny(paramCharSequence, paramCharPredicate, 0, paramInt); }
/*  171 */   static int lastIndexOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return lastIndexOfAny(paramCharSequence, paramCharPredicate.negate(), 0, 2147483647); }
/*  172 */   static int lastIndexOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return lastIndexOfAny(paramCharSequence, paramCharPredicate.negate(), 0, paramInt); }
/*  173 */   static int lastIndexOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return lastIndexOfAny(paramCharSequence, paramCharPredicate.negate(), paramInt1, paramInt2); }
/*  174 */   static int lastIndexOfNot(CharSequence paramCharSequence, char paramChar) { return lastIndexOfNot(paramCharSequence, paramChar, 0, 2147483647); } static int lastIndexOfNot(CharSequence paramCharSequence, char paramChar, int paramInt) {
/*  175 */     return lastIndexOfNot(paramCharSequence, paramChar, 0, paramInt);
/*      */   }
/*      */   
/*      */   static int indexOf(CharSequence paramCharSequence, char paramChar, int paramInt1, int paramInt2) {
/*  179 */     paramInt1 = Math.max(paramInt1, 0);
/*  180 */     paramInt2 = Math.min(paramCharSequence.length(), paramInt2);
/*      */     
/*  182 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  183 */       if (paramChar == paramCharSequence.charAt(paramInt1)) return paramInt1; 
/*      */     } 
/*  185 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) {
/*  190 */     paramInt1 = Math.max(paramInt1, 0);
/*      */     
/*      */     int i;
/*  193 */     if ((i = paramCharSequence2.length()) == 0) return paramInt1; 
/*  194 */     paramInt2 = Math.min(paramCharSequence1.length(), paramInt2);
/*      */     
/*  196 */     if (paramInt1 < paramInt2) {
/*  197 */       char c = paramCharSequence2.charAt(0);
/*  198 */       paramInt1 = paramInt1;
/*      */ 
/*      */ 
/*      */       
/*  202 */       while ((paramInt1 = indexOf(paramCharSequence1, c, paramInt1)) >= 0 && paramInt1 + i <= paramInt2) {
/*  203 */         if (matchChars(paramCharSequence1, paramCharSequence2, paramInt1)) return paramInt1; 
/*  204 */         paramInt1++;
/*  205 */         if (paramInt1 + i >= paramInt2)
/*      */           break; 
/*      */       } 
/*  208 */     }  return -1;
/*      */   }
/*      */   
/*      */   static int lastIndexOf(CharSequence paramCharSequence, char paramChar, int paramInt1, int paramInt2) {
/*  212 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length() - 1);
/*  213 */     paramInt2++;
/*      */     
/*  215 */     paramInt1 = Math.max(paramInt1, 0);
/*      */     
/*  217 */     for (paramInt2 = paramInt2; paramInt2-- > paramInt1;) {
/*  218 */       if (paramChar == paramCharSequence.charAt(paramInt2)) return paramInt2; 
/*      */     } 
/*  220 */     return -1;
/*      */   }
/*      */   
/*      */   static int indexOfNot(CharSequence paramCharSequence, char paramChar, int paramInt1, int paramInt2) {
/*  224 */     paramInt1 = Math.max(paramInt1, 0);
/*  225 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length());
/*      */     
/*  227 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  228 */       if (paramCharSequence.charAt(paramInt1) != paramChar) return paramInt1; 
/*      */     } 
/*  230 */     return -1;
/*      */   }
/*      */   
/*      */   static int indexOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  234 */     paramInt1 = Math.max(paramInt1, 0);
/*  235 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length());
/*      */     
/*  237 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  238 */       char c = paramCharSequence.charAt(paramInt1);
/*  239 */       if (paramCharPredicate.test(c)) return paramInt1; 
/*      */     } 
/*  241 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) {
/*  246 */     paramInt1 = Math.max(paramInt1, 0);
/*      */     
/*      */     int i;
/*  249 */     if ((i = paramCharSequence2.length()) == 0) return paramInt1;
/*      */     
/*  251 */     paramInt2 = Math.min(paramInt2, paramCharSequence1.length());
/*      */     
/*  253 */     if (paramInt1 < paramInt2) {
/*  254 */       paramInt2 = paramInt2;
/*  255 */       char c = paramCharSequence2.charAt(i - 1);
/*      */ 
/*      */ 
/*      */       
/*  259 */       while ((paramInt2 = lastIndexOf(paramCharSequence1, c, paramInt2)) + 1 >= paramInt1 + i) {
/*  260 */         if (matchCharsReversed(paramCharSequence1, paramCharSequence2, paramInt2)) return paramInt2 + 1 - i; 
/*  261 */         paramInt2--;
/*  262 */         if (paramInt2 + 1 < paramInt1 + i)
/*      */           break; 
/*      */       } 
/*  265 */     }  return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   static int lastIndexOfNot(CharSequence paramCharSequence, char paramChar, int paramInt1, int paramInt2) {
/*  270 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length() - 1);
/*  271 */     paramInt2++;
/*      */     
/*  273 */     paramInt1 = Math.max(paramInt1, 0);
/*      */     
/*  275 */     for (paramInt2 = paramInt2; paramInt2-- > paramInt1;) {
/*  276 */       if (paramCharSequence.charAt(paramInt2) != paramChar) return paramInt2; 
/*      */     } 
/*  278 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   static int lastIndexOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  283 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length() - 1);
/*  284 */     paramInt2++;
/*      */     
/*  286 */     paramInt1 = Math.max(paramInt1, 0);
/*      */     
/*  288 */     for (paramInt2 = paramInt2; paramInt2-- > paramInt1; ) {
/*  289 */       char c = paramCharSequence.charAt(paramInt2);
/*  290 */       if (paramCharPredicate.test(c)) return paramInt2; 
/*      */     } 
/*  292 */     return -1;
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
/*      */   static boolean equals(CharSequence paramCharSequence, Object paramObject) {
/*  306 */     if (paramObject == paramCharSequence) return true; 
/*  307 */     if (!(paramObject instanceof CharSequence)) return false;
/*      */     
/*      */     CharSequence charSequence;
/*  310 */     if ((charSequence = (CharSequence)paramObject).length() != paramCharSequence.length()) return false;
/*      */     
/*  312 */     if (paramObject instanceof String)
/*      */     
/*  314 */     { if ((paramObject = paramObject).hashCode() != paramCharSequence.hashCode()) return false;
/*      */        }
/*      */     
/*  317 */     else if (paramObject instanceof IRichSequence && (
/*      */       
/*  319 */       paramObject = paramObject).hashCode() != paramCharSequence.hashCode()) { return false; }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  324 */     return matchChars(paramCharSequence, charSequence, 0, false);
/*      */   }
/*      */ 
/*      */   
/*      */   static int hashCode(CharSequence paramCharSequence) {
/*  329 */     int i = 0;
/*      */     int j;
/*  331 */     if ((j = paramCharSequence.length()) > 0) {
/*  332 */       for (byte b = 0; b < j; b++) {
/*  333 */         i = i * 31 + paramCharSequence.charAt(b);
/*      */       }
/*      */     }
/*  336 */     return i;
/*      */   }
/*      */   
/*      */   static int compareReversed(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  340 */     return compare(paramCharSequence2, paramCharSequence1);
/*      */   }
/*      */   
/*      */   static int compare(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  344 */     return compare(paramCharSequence1, paramCharSequence2, false);
/*      */   }
/*      */   
/*      */   static int compare(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean) {
/*  348 */     return compare(paramCharSequence1, paramCharSequence2, paramBoolean, null);
/*      */   }
/*      */   
/*      */   static int compare(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean, CharPredicate paramCharPredicate) {
/*  352 */     if (paramCharSequence1 == null || paramCharSequence2 == null) return (paramCharSequence1 == null && paramCharSequence2 == null) ? 0 : ((paramCharSequence1 == null) ? -1 : 1);
/*      */     
/*  354 */     int i = paramCharSequence1.length();
/*  355 */     int j = paramCharSequence2.length();
/*  356 */     int k = Math.min(i, j);
/*  357 */     if (paramBoolean) {
/*  358 */       for (paramBoolean = false; paramBoolean < k; paramBoolean++) {
/*  359 */         char c1 = paramCharSequence1.charAt(paramBoolean);
/*  360 */         char c2 = paramCharSequence2.charAt(paramBoolean);
/*  361 */         if (c1 != c2) {
/*  362 */           char c3 = Character.toUpperCase(c1);
/*  363 */           char c4 = Character.toUpperCase(c2);
/*  364 */           if (c3 != c4)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  371 */             if (Character.toLowerCase(c3) != Character.toLowerCase(c4))
/*      */             {
/*      */ 
/*      */ 
/*      */               
/*  376 */               if (paramCharPredicate == null || !paramCharPredicate.test(c1) || !paramCharPredicate.test(c2))
/*  377 */                 return c1 - c2;  } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } else {
/*  382 */       for (paramBoolean = false; paramBoolean < k; paramBoolean++) {
/*  383 */         char c1 = paramCharSequence1.charAt(paramBoolean);
/*  384 */         char c2 = paramCharSequence2.charAt(paramBoolean);
/*  385 */         if (c1 != c2)
/*      */         {
/*  387 */           if (paramCharPredicate == null || !paramCharPredicate.test(c1) || !paramCharPredicate.test(c2)) {
/*  388 */             return c1 - c2;
/*      */           }
/*      */         }
/*      */       } 
/*      */     } 
/*  393 */     return i - j;
/*      */   }
/*      */ 
/*      */   
/*      */   static String[] toStringArray(CharSequence... paramVarArgs) {
/*  398 */     String[] arrayOfString = new String[paramVarArgs.length];
/*  399 */     byte b1 = 0; CharSequence[] arrayOfCharSequence; int i; byte b2;
/*  400 */     for (i = (arrayOfCharSequence = paramVarArgs).length, b2 = 0; b2 < i; b2++) {
/*  401 */       arrayOfString[b1] = (paramVarArgs[b1] == null) ? null : paramVarArgs[b1].toString();
/*  402 */       b1++;
/*      */     } 
/*  404 */     return arrayOfString;
/*      */   }
/*      */   
/*      */   static boolean isVisibleWhitespace(char paramChar) {
/*  408 */     return visibleSpacesMap.containsKey(Character.valueOf(paramChar));
/*      */   }
/*      */ 
/*      */   
/*      */   static int columnsToNextTabStop(int paramInt) {
/*  413 */     return 4 - paramInt % 4;
/*      */   }
/*      */ 
/*      */   
/*      */   static int[] expandTo(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  418 */     int i = paramInt1 & paramInt2;
/*  419 */     paramInt1 += (i != 0) ? paramInt2 : 0;
/*  420 */     if (paramArrayOfint.length < paramInt1) {
/*  421 */       int[] arrayOfInt = new int[paramInt1];
/*  422 */       System.arraycopy(paramArrayOfint, 0, arrayOfInt, 0, paramArrayOfint.length);
/*  423 */       return arrayOfInt;
/*      */     } 
/*  425 */     return paramArrayOfint;
/*      */   }
/*      */ 
/*      */   
/*      */   static int[] truncateTo(int[] paramArrayOfint, int paramInt) {
/*  430 */     if (paramArrayOfint.length > paramInt) {
/*  431 */       int[] arrayOfInt = new int[paramInt];
/*  432 */       System.arraycopy(paramArrayOfint, 0, arrayOfInt, 0, paramInt);
/*  433 */       return arrayOfInt;
/*      */     } 
/*  435 */     return paramArrayOfint;
/*      */   }
/*      */ 
/*      */   
/*      */   static int[] indexOfAll(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*      */     int i;
/*  441 */     if ((i = paramCharSequence2.length()) == 0) return EMPTY_INDICES; 
/*      */     int j;
/*  443 */     if ((j = indexOf(paramCharSequence1, paramCharSequence2)) == -1) return EMPTY_INDICES;
/*      */     
/*  445 */     byte b = 0;
/*      */     
/*  447 */     b++; int[] arrayOfInt; (arrayOfInt = new int[32])[0] = j;
/*      */ 
/*      */ 
/*      */     
/*  451 */     while ((j = indexOf(paramCharSequence1, paramCharSequence2, j + i)) != -1) {
/*  452 */       if (arrayOfInt.length <= b) arrayOfInt = expandTo(arrayOfInt, b + 1, 32); 
/*  453 */       arrayOfInt[b++] = j;
/*      */     } 
/*  455 */     return truncateTo(arrayOfInt, b);
/*      */   }
/*      */   
/*      */   static boolean matches(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
/*      */   {
/*  460 */     return (paramCharSequence2.length() == paramCharSequence1.length() && matchChars(paramCharSequence1, paramCharSequence2, 0, paramBoolean));
/*  461 */   } static boolean matches(CharSequence paramCharSequence1, CharSequence paramCharSequence2) { return (paramCharSequence2.length() == paramCharSequence1.length() && matchChars(paramCharSequence1, paramCharSequence2, 0, false)); } static boolean matchesIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  462 */     return (paramCharSequence2.length() == paramCharSequence1.length() && matchChars(paramCharSequence1, paramCharSequence2, 0, true));
/*      */   }
/*  464 */   static boolean matchChars(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, boolean paramBoolean) { return (matchedCharCount(paramCharSequence1, paramCharSequence2, paramInt, 2147483647, true, paramBoolean) == paramCharSequence2.length()); }
/*  465 */   static boolean matchChars(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) { return matchChars(paramCharSequence1, paramCharSequence2, paramInt, false); } static boolean matchCharsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/*  466 */     return matchChars(paramCharSequence1, paramCharSequence2, paramInt, true);
/*      */   }
/*  468 */   static boolean matchChars(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean) { return matchChars(paramCharSequence1, paramCharSequence2, 0, paramBoolean); }
/*  469 */   static boolean matchChars(CharSequence paramCharSequence1, CharSequence paramCharSequence2) { return matchChars(paramCharSequence1, paramCharSequence2, 0, false); } static boolean matchCharsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  470 */     return matchChars(paramCharSequence1, paramCharSequence2, 0, true);
/*      */   }
/*  472 */   static boolean matchCharsReversed(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, boolean paramBoolean) { return (paramInt + 1 >= paramCharSequence2.length() && matchChars(paramCharSequence1, paramCharSequence2, paramInt + 1 - paramCharSequence2.length(), paramBoolean)); }
/*  473 */   static boolean matchCharsReversed(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) { return (paramInt + 1 >= paramCharSequence2.length() && matchChars(paramCharSequence1, paramCharSequence2, paramInt + 1 - paramCharSequence2.length(), false)); } static boolean matchCharsReversedIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/*  474 */     return (paramInt + 1 >= paramCharSequence2.length() && matchChars(paramCharSequence1, paramCharSequence2, paramInt + 1 - paramCharSequence2.length(), true));
/*      */   }
/*  476 */   static int matchedCharCount(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean) { return matchedCharCount(paramCharSequence1, paramCharSequence2, paramInt1, 2147483647, false, paramBoolean); }
/*  477 */   static int matchedCharCount(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, boolean paramBoolean) { return matchedCharCount(paramCharSequence1, paramCharSequence2, paramInt, 2147483647, false, paramBoolean); }
/*  478 */   static int matchedCharCount(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) { return matchedCharCount(paramCharSequence1, paramCharSequence2, paramInt1, 2147483647, false, false); }
/*  479 */   static int matchedCharCount(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) { return matchedCharCount(paramCharSequence1, paramCharSequence2, paramInt, 2147483647, false, false); }
/*  480 */   static int matchedCharCountIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) { return matchedCharCount(paramCharSequence1, paramCharSequence2, paramInt1, 2147483647, false, true); } static int matchedCharCountIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/*  481 */     return matchedCharCount(paramCharSequence1, paramCharSequence2, paramInt, 2147483647, false, true);
/*      */   }
/*  483 */   static int matchedCharCountReversed(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) { return matchedCharCountReversed(paramCharSequence1, paramCharSequence2, paramInt1, paramInt2, false); } static int matchedCharCountReversedIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2) {
/*  484 */     return matchedCharCountReversed(paramCharSequence1, paramCharSequence2, paramInt1, paramInt2, true);
/*      */   }
/*  486 */   static int matchedCharCountReversed(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, boolean paramBoolean) { return matchedCharCountReversed(paramCharSequence1, paramCharSequence2, 0, paramInt, paramBoolean); }
/*  487 */   static int matchedCharCountReversed(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) { return matchedCharCountReversed(paramCharSequence1, paramCharSequence2, 0, paramInt, false); } static int matchedCharCountReversedIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/*  488 */     return matchedCharCountReversed(paramCharSequence1, paramCharSequence2, 0, paramInt, true);
/*      */   }
/*      */   
/*      */   static int matchedCharCount(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/*  492 */     int i = paramCharSequence2.length();
/*      */     
/*  494 */     paramInt2 = Math.min((paramInt2 = Math.min(paramCharSequence1.length(), paramInt2)) - paramInt1, i);
/*  495 */     if (paramBoolean1 && paramInt2 < i) return 0;
/*      */     
/*  497 */     if (paramBoolean2) {
/*  498 */       for (paramBoolean1 = false; paramBoolean1 < paramInt2; paramBoolean1++) {
/*  499 */         char c = paramCharSequence2.charAt(paramBoolean1);
/*  500 */         i = paramCharSequence1.charAt(paramBoolean1 + paramInt1);
/*  501 */         if (c != i) {
/*  502 */           c = Character.toUpperCase(c);
/*  503 */           i = Character.toUpperCase(i);
/*  504 */           if (c != i)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  511 */             if (Character.toLowerCase(c) != Character.toLowerCase(i))
/*      */             {
/*      */               
/*  514 */               return paramBoolean1; }  } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*  518 */       for (paramBoolean1 = false; paramBoolean1 < paramInt2; paramBoolean1++) {
/*  519 */         if (paramCharSequence2.charAt(paramBoolean1) != paramCharSequence1.charAt(paramBoolean1 + paramInt1)) return paramBoolean1; 
/*      */       } 
/*      */     } 
/*  522 */     return paramInt2;
/*      */   }
/*      */ 
/*      */   
/*      */   static int matchedCharCountReversed(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean) {
/*  527 */     paramInt1 = Math.max(0, paramInt1);
/*  528 */     paramInt2 = Math.max(0, Math.min(paramCharSequence1.length(), paramInt2));
/*      */     
/*  530 */     int i = paramCharSequence2.length();
/*  531 */     paramInt1 = Math.min(paramInt2 - paramInt1, i);
/*      */     
/*  533 */     paramInt2 -= paramInt1;
/*  534 */     if (paramBoolean) {
/*  535 */       for (int j = paramInt1; j-- > 0; ) {
/*  536 */         i = paramCharSequence2.charAt(j);
/*  537 */         char c = paramCharSequence1.charAt(paramInt2 + j);
/*  538 */         if (i != c) {
/*  539 */           i = Character.toUpperCase(i);
/*  540 */           c = Character.toUpperCase(c);
/*  541 */           if (i != c)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  548 */             if (Character.toLowerCase(i) != Character.toLowerCase(c))
/*      */             {
/*      */               
/*  551 */               return paramInt1 - j - 1; }  } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*  555 */       for (int j = paramInt1; j-- > 0;) {
/*  556 */         if (paramCharSequence2.charAt(j) != paramCharSequence1.charAt(paramInt2 + j)) return paramInt1 - j - 1; 
/*      */       } 
/*      */     } 
/*  559 */     return paramInt1;
/*      */   }
/*      */   
/*      */   static int countOfSpaceTab(CharSequence paramCharSequence) {
/*  563 */     return countOfAny(paramCharSequence, CharPredicate.SPACE_TAB, 0, 2147483647); } static int countOfNotSpaceTab(CharSequence paramCharSequence) {
/*  564 */     return countOfAny(paramCharSequence, CharPredicate.SPACE_TAB.negate(), 0, 2147483647);
/*      */   }
/*  566 */   static int countOfWhitespace(CharSequence paramCharSequence) { return countOfAny(paramCharSequence, CharPredicate.WHITESPACE, 2147483647); } static int countOfNotWhitespace(CharSequence paramCharSequence) {
/*  567 */     return countOfAny(paramCharSequence, CharPredicate.WHITESPACE.negate(), 0, 2147483647);
/*      */   }
/*  569 */   static int countOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return countOfAny(paramCharSequence, paramCharPredicate, paramInt, 2147483647); } static int countOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate) {
/*  570 */     return countOfAny(paramCharSequence, paramCharPredicate, 0, 2147483647);
/*      */   }
/*  572 */   static int countOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return countOfAny(paramCharSequence, paramCharPredicate.negate(), paramInt1, paramInt2); }
/*  573 */   static int countOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return countOfAny(paramCharSequence, paramCharPredicate.negate(), paramInt, 2147483647); } static int countOfAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate) {
/*  574 */     return countOfAny(paramCharSequence, paramCharPredicate.negate(), 0, 2147483647);
/*      */   }
/*      */   
/*      */   static int countOfAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  578 */     paramInt1 = Math.max(paramInt1, 0);
/*  579 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length());
/*      */     
/*  581 */     byte b = 0;
/*  582 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  583 */       char c = paramCharSequence.charAt(paramInt1);
/*  584 */       if (paramCharPredicate.test(c)) b++; 
/*      */     } 
/*  586 */     return b;
/*      */   }
/*      */   
/*      */   static int countLeadingSpace(CharSequence paramCharSequence) {
/*  590 */     return countLeading(paramCharSequence, CharPredicate.SPACE, 0, 2147483647);
/*  591 */   } static int countLeadingSpace(CharSequence paramCharSequence, int paramInt) { return countLeading(paramCharSequence, CharPredicate.SPACE, paramInt, 2147483647); }
/*  592 */   static int countLeadingSpace(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return countLeading(paramCharSequence, CharPredicate.SPACE, paramInt1, paramInt2); }
/*  593 */   static int countLeadingNotSpace(CharSequence paramCharSequence) { return countLeading(paramCharSequence, CharPredicate.SPACE.negate(), 0, 2147483647); }
/*  594 */   static int countLeadingNotSpace(CharSequence paramCharSequence, int paramInt) { return countLeading(paramCharSequence, CharPredicate.SPACE.negate(), paramInt, 2147483647); } static int countLeadingNotSpace(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  595 */     return countLeading(paramCharSequence, CharPredicate.SPACE.negate(), paramInt1, paramInt2);
/*      */   }
/*  597 */   static int countTrailingSpace(CharSequence paramCharSequence) { return countTrailing(paramCharSequence, CharPredicate.SPACE, 0, 2147483647); }
/*  598 */   static int countTrailingSpace(CharSequence paramCharSequence, int paramInt) { return countTrailing(paramCharSequence, CharPredicate.SPACE, 0, paramInt); }
/*  599 */   static int countTrailingSpace(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return countTrailing(paramCharSequence, CharPredicate.SPACE, paramInt1, paramInt2); }
/*  600 */   static int countTrailingNotSpace(CharSequence paramCharSequence) { return countTrailing(paramCharSequence, CharPredicate.SPACE.negate(), 0, 2147483647); }
/*  601 */   static int countTrailingNotSpace(CharSequence paramCharSequence, int paramInt) { return countTrailing(paramCharSequence, CharPredicate.SPACE.negate(), 0, paramInt); } static int countTrailingNotSpace(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  602 */     return countTrailing(paramCharSequence, CharPredicate.SPACE.negate(), paramInt1, paramInt2);
/*      */   }
/*  604 */   static int countLeadingSpaceTab(CharSequence paramCharSequence) { return countLeading(paramCharSequence, CharPredicate.SPACE_TAB, 0, 2147483647); }
/*  605 */   static int countLeadingSpaceTab(CharSequence paramCharSequence, int paramInt) { return countLeading(paramCharSequence, CharPredicate.SPACE_TAB, paramInt, 2147483647); }
/*  606 */   static int countLeadingSpaceTab(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return countLeading(paramCharSequence, CharPredicate.SPACE_TAB, paramInt1, paramInt2); }
/*  607 */   static int countLeadingNotSpaceTab(CharSequence paramCharSequence) { return countLeading(paramCharSequence, CharPredicate.SPACE_TAB.negate(), 0, 2147483647); }
/*  608 */   static int countLeadingNotSpaceTab(CharSequence paramCharSequence, int paramInt) { return countLeading(paramCharSequence, CharPredicate.SPACE_TAB.negate(), paramInt, 2147483647); } static int countLeadingNotSpaceTab(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  609 */     return countLeading(paramCharSequence, CharPredicate.SPACE_TAB.negate(), paramInt1, paramInt2);
/*      */   }
/*  611 */   static int countTrailingSpaceTab(CharSequence paramCharSequence) { return countTrailing(paramCharSequence, CharPredicate.SPACE_TAB, 0, 2147483647); }
/*  612 */   static int countTrailingSpaceTab(CharSequence paramCharSequence, int paramInt) { return countTrailing(paramCharSequence, CharPredicate.SPACE_TAB, 0, paramInt); }
/*  613 */   static int countTrailingSpaceTab(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return countTrailing(paramCharSequence, CharPredicate.SPACE_TAB, paramInt1, paramInt2); }
/*  614 */   static int countTrailingNotSpaceTab(CharSequence paramCharSequence) { return countTrailing(paramCharSequence, CharPredicate.SPACE_TAB.negate(), 0, 2147483647); }
/*  615 */   static int countTrailingNotSpaceTab(CharSequence paramCharSequence, int paramInt) { return countTrailing(paramCharSequence, CharPredicate.SPACE_TAB.negate(), 0, paramInt); } static int countTrailingNotSpaceTab(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  616 */     return countTrailing(paramCharSequence, CharPredicate.SPACE_TAB.negate(), paramInt1, paramInt2);
/*      */   }
/*  618 */   static int countLeadingWhitespace(CharSequence paramCharSequence) { return countLeading(paramCharSequence, CharPredicate.WHITESPACE, 0, 2147483647); }
/*  619 */   static int countLeadingWhitespace(CharSequence paramCharSequence, int paramInt) { return countLeading(paramCharSequence, CharPredicate.WHITESPACE, paramInt, 2147483647); }
/*  620 */   static int countLeadingWhitespace(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return countLeading(paramCharSequence, CharPredicate.WHITESPACE, paramInt1, paramInt2); }
/*  621 */   static int countLeadingNotWhitespace(CharSequence paramCharSequence) { return countLeading(paramCharSequence, CharPredicate.WHITESPACE.negate(), 0, 2147483647); }
/*  622 */   static int countLeadingNotWhitespace(CharSequence paramCharSequence, int paramInt) { return countLeading(paramCharSequence, CharPredicate.WHITESPACE.negate(), paramInt, 2147483647); } static int countLeadingNotWhitespace(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  623 */     return countLeading(paramCharSequence, CharPredicate.WHITESPACE.negate(), paramInt1, paramInt2);
/*      */   }
/*  625 */   static int countTrailingWhitespace(CharSequence paramCharSequence) { return countTrailing(paramCharSequence, CharPredicate.WHITESPACE, 0, 2147483647); }
/*  626 */   static int countTrailingWhitespace(CharSequence paramCharSequence, int paramInt) { return countTrailing(paramCharSequence, CharPredicate.WHITESPACE, 0, paramInt); }
/*  627 */   static int countTrailingWhitespace(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return countTrailing(paramCharSequence, CharPredicate.WHITESPACE, paramInt1, paramInt2); }
/*  628 */   static int countTrailingNotWhitespace(CharSequence paramCharSequence) { return countTrailing(paramCharSequence, CharPredicate.WHITESPACE.negate(), 0, 2147483647); }
/*  629 */   static int countTrailingNotWhitespace(CharSequence paramCharSequence, int paramInt) { return countTrailing(paramCharSequence, CharPredicate.WHITESPACE.negate(), 0, paramInt); } static int countTrailingNotWhitespace(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  630 */     return countTrailing(paramCharSequence, CharPredicate.WHITESPACE.negate(), paramInt1, paramInt2);
/*      */   }
/*  632 */   static int countLeading(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return countLeading(paramCharSequence, paramCharPredicate, 0, 2147483647); }
/*  633 */   static int countLeading(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return countLeading(paramCharSequence, paramCharPredicate, paramInt, 2147483647); }
/*  634 */   static int countLeadingNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return countLeading(paramCharSequence, paramCharPredicate.negate(), 0, 2147483647); } static int countLeadingNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) {
/*  635 */     return countLeading(paramCharSequence, paramCharPredicate.negate(), paramInt, 2147483647);
/*      */   }
/*  637 */   static int countTrailing(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return countTrailing(paramCharSequence, paramCharPredicate, 0, 2147483647); }
/*  638 */   static int countTrailing(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return countTrailing(paramCharSequence, paramCharPredicate, 0, paramInt); }
/*  639 */   static int countTrailingNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return countTrailing(paramCharSequence, paramCharPredicate.negate(), 0, 2147483647); } static int countTrailingNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) {
/*  640 */     return countTrailing(paramCharSequence, paramCharPredicate.negate(), 0, paramInt);
/*      */   }
/*  642 */   static int countLeadingNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return countLeading(paramCharSequence, paramCharPredicate.negate(), paramInt1, paramInt2); } static int countTrailingNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  643 */     return countTrailing(paramCharSequence, paramCharPredicate.negate(), paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   static int countLeading(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  647 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length());
/*  648 */     paramInt1 = Utils.rangeLimit(paramInt1, 0, paramInt2);
/*      */     
/*      */     int i;
/*  651 */     return ((i = indexOfAnyNot(paramCharSequence, paramCharPredicate, paramInt1, paramInt2)) == -1) ? (paramInt2 - paramInt1) : (i - paramInt1);
/*      */   }
/*      */ 
/*      */   
/*      */   static int countLeadingColumns(CharSequence paramCharSequence, int paramInt, CharPredicate paramCharPredicate) {
/*  656 */     int j = paramCharSequence.length();
/*      */ 
/*      */ 
/*      */     
/*  660 */     int i, k = ((i = indexOfAnyNot(paramCharSequence, paramCharPredicate, 0, j)) == -1) ? j : i;
/*  661 */     i = (i == -1) ? j : i;
/*      */     
/*  663 */     if ((k = indexOf(paramCharSequence, '\t', 0, k)) != -1) {
/*  664 */       paramInt = paramInt;
/*      */       do {
/*  666 */         paramInt += k + columnsToNextTabStop(k + paramInt);
/*      */       }
/*  668 */       while ((k = indexOf(paramCharSequence, '\t', k + 1)) >= 0 && k < j);
/*  669 */       i += paramInt;
/*      */     } 
/*  671 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   static int countTrailing(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  676 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length());
/*  677 */     paramInt1 = Utils.rangeLimit(paramInt1, 0, paramInt2);
/*      */     
/*      */     int i;
/*  680 */     return ((i = lastIndexOfAnyNot(paramCharSequence, paramCharPredicate, paramInt1, paramInt2 - 1)) == -1) ? (paramInt2 - paramInt1) : ((paramInt2 <= i) ? 0 : (paramInt2 - i - 1));
/*      */   }
/*      */   
/*      */   static <T extends CharSequence> T trimStart(T paramT, CharPredicate paramCharPredicate) {
/*  684 */     return subSequence(paramT, trimStartRange((CharSequence)paramT, 0, paramCharPredicate));
/*  685 */   } static <T extends CharSequence> T trimmedStart(T paramT, CharPredicate paramCharPredicate) { return trimmedStart(paramT, 0, paramCharPredicate); }
/*  686 */   static <T extends CharSequence> T trimEnd(T paramT, CharPredicate paramCharPredicate) { return trimEnd(paramT, 0, paramCharPredicate); }
/*  687 */   static <T extends CharSequence> T trimmedEnd(T paramT, CharPredicate paramCharPredicate) { return trimmedEnd(paramT, 0, paramCharPredicate); }
/*  688 */   static <T extends CharSequence> T trim(T paramT, CharPredicate paramCharPredicate) { return trim(paramT, 0, paramCharPredicate); }
/*  689 */   static <T extends CharSequence> Pair<T, T> trimmed(T paramT, CharPredicate paramCharPredicate) { return trimmed(paramT, 0, paramCharPredicate); }
/*  690 */   static <T extends CharSequence> T trimStart(T paramT, int paramInt) { return trimStart(paramT, paramInt, CharPredicate.WHITESPACE); }
/*  691 */   static <T extends CharSequence> T trimmedStart(T paramT, int paramInt) { return trimmedStart(paramT, paramInt, CharPredicate.WHITESPACE); }
/*  692 */   static <T extends CharSequence> T trimEnd(T paramT, int paramInt) { return trimEnd(paramT, paramInt, CharPredicate.WHITESPACE); }
/*  693 */   static <T extends CharSequence> T trimmedEnd(T paramT, int paramInt) { return trimmedEnd(paramT, paramInt, CharPredicate.WHITESPACE); }
/*  694 */   static <T extends CharSequence> T trim(T paramT, int paramInt) { return trim(paramT, paramInt, CharPredicate.WHITESPACE); }
/*  695 */   static <T extends CharSequence> Pair<T, T> trimmed(T paramT, int paramInt) { return trimmed(paramT, paramInt, CharPredicate.WHITESPACE); }
/*  696 */   static <T extends CharSequence> T trimStart(T paramT) { return trimStart(paramT, 0, CharPredicate.WHITESPACE); }
/*  697 */   static <T extends CharSequence> T trimmedStart(T paramT) { return trimmedStart(paramT, 0, CharPredicate.WHITESPACE); }
/*  698 */   static <T extends CharSequence> T trimEnd(T paramT) { return trimEnd(paramT, 0, CharPredicate.WHITESPACE); }
/*  699 */   static <T extends CharSequence> T trimmedEnd(T paramT) { return trimmedEnd(paramT, 0, CharPredicate.WHITESPACE); }
/*  700 */   static <T extends CharSequence> T trim(T paramT) { return trim(paramT, 0, CharPredicate.WHITESPACE); }
/*  701 */   static <T extends CharSequence> Pair<T, T> trimmed(T paramT) { return trimmed(paramT, 0, CharPredicate.WHITESPACE); }
/*  702 */   static <T extends CharSequence> T trimStart(T paramT, int paramInt, CharPredicate paramCharPredicate) { return subSequence(paramT, trimStartRange((CharSequence)paramT, paramInt, paramCharPredicate)); }
/*  703 */   static <T extends CharSequence> T trimmedStart(T paramT, int paramInt, CharPredicate paramCharPredicate) { return subSequenceBefore(paramT, trimStartRange((CharSequence)paramT, paramInt, paramCharPredicate)); }
/*  704 */   static <T extends CharSequence> T trimEnd(T paramT, int paramInt, CharPredicate paramCharPredicate) { return subSequence(paramT, trimEndRange((CharSequence)paramT, paramInt, paramCharPredicate)); }
/*  705 */   static <T extends CharSequence> T trimmedEnd(T paramT, int paramInt, CharPredicate paramCharPredicate) { return subSequenceAfter(paramT, trimEndRange((CharSequence)paramT, paramInt, paramCharPredicate)); }
/*  706 */   static <T extends CharSequence> T trim(T paramT, int paramInt, CharPredicate paramCharPredicate) { return subSequence(paramT, trimRange((CharSequence)paramT, paramInt, paramCharPredicate)); } static <T extends CharSequence> Pair<T, T> trimmed(T paramT, int paramInt, CharPredicate paramCharPredicate) {
/*  707 */     return subSequenceBeforeAfter(paramT, trimRange((CharSequence)paramT, paramInt, paramCharPredicate));
/*      */   }
/*      */   
/*      */   static Range trimStartRange(CharSequence paramCharSequence, CharPredicate paramCharPredicate) {
/*  711 */     return trimStartRange(paramCharSequence, 0, paramCharPredicate);
/*  712 */   } static Range trimEndRange(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return trimEndRange(paramCharSequence, 0, paramCharPredicate); }
/*  713 */   static Range trimRange(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return trimRange(paramCharSequence, 0, paramCharPredicate); }
/*  714 */   static Range trimStartRange(CharSequence paramCharSequence, int paramInt) { return trimStartRange(paramCharSequence, paramInt, CharPredicate.WHITESPACE); }
/*  715 */   static Range trimEndRange(CharSequence paramCharSequence, int paramInt) { return trimEndRange(paramCharSequence, paramInt, CharPredicate.WHITESPACE); }
/*  716 */   static Range trimRange(CharSequence paramCharSequence, int paramInt) { return trimRange(paramCharSequence, paramInt, CharPredicate.WHITESPACE); }
/*  717 */   static Range trimStartRange(CharSequence paramCharSequence) { return trimStartRange(paramCharSequence, 0, CharPredicate.WHITESPACE); }
/*  718 */   static Range trimEndRange(CharSequence paramCharSequence) { return trimEndRange(paramCharSequence, 0, CharPredicate.WHITESPACE); } static Range trimRange(CharSequence paramCharSequence) {
/*  719 */     return trimRange(paramCharSequence, 0, CharPredicate.WHITESPACE);
/*      */   }
/*      */ 
/*      */   
/*      */   static Range trimStartRange(CharSequence paramCharSequence, int paramInt, CharPredicate paramCharPredicate) {
/*  724 */     int j = paramCharSequence.length();
/*      */     int i;
/*  726 */     return ((i = countLeading(paramCharSequence, paramCharPredicate, 0, j)) > paramInt) ? Range.of(i - paramInt, j) : Range.NULL;
/*      */   }
/*      */ 
/*      */   
/*      */   static Range trimEndRange(CharSequence paramCharSequence, int paramInt, CharPredicate paramCharPredicate) {
/*  731 */     int j = paramCharSequence.length();
/*      */     int i;
/*  733 */     return ((i = countTrailing(paramCharSequence, paramCharPredicate, 0, j)) > paramInt) ? Range.of(0, j - i + paramInt) : Range.NULL;
/*      */   }
/*      */ 
/*      */   
/*      */   static Range trimRange(CharSequence paramCharSequence, int paramInt, CharPredicate paramCharPredicate) {
/*  738 */     int j = paramCharSequence.length();
/*  739 */     if (paramInt >= j) return Range.NULL;
/*      */     
/*      */     int k;
/*  742 */     if ((k = countLeading(paramCharSequence, paramCharPredicate, 0, j)) > paramInt)
/*      */     {
/*  744 */       return ((i = countTrailing(paramCharSequence, paramCharPredicate, k - paramInt, j)) > paramInt) ? Range.of(k - paramInt, j - i + paramInt) : Range.of(k - paramInt, j);
/*      */     }
/*      */     int i;
/*  747 */     return ((i = countTrailing(i, paramCharPredicate, k, j)) > paramInt) ? Range.of(0, j - i + paramInt) : Range.NULL;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static String padStart(CharSequence paramCharSequence, int paramInt, char paramChar) {
/*  753 */     return (paramInt <= paramCharSequence.length()) ? "" : RepeatedSequence.repeatOf(paramChar, paramInt - paramCharSequence.length()).toString();
/*      */   }
/*      */ 
/*      */   
/*      */   static String padEnd(CharSequence paramCharSequence, int paramInt, char paramChar) {
/*  758 */     return (paramInt <= paramCharSequence.length()) ? "" : RepeatedSequence.repeatOf(paramChar, paramInt - paramCharSequence.length()).toString();
/*      */   }
/*      */ 
/*      */   
/*      */   static String padStart(CharSequence paramCharSequence, int paramInt) {
/*  763 */     return padStart(paramCharSequence, paramInt, ' ');
/*      */   }
/*      */ 
/*      */   
/*      */   static String padEnd(CharSequence paramCharSequence, int paramInt) {
/*  768 */     return padEnd(paramCharSequence, paramInt, ' ');
/*      */   }
/*      */ 
/*      */   
/*      */   static String toVisibleWhitespaceString(CharSequence paramCharSequence) {
/*  773 */     StringBuilder stringBuilder = new StringBuilder();
/*  774 */     int i = paramCharSequence.length();
/*  775 */     for (byte b = 0; b < i; b++) {
/*  776 */       char c = paramCharSequence.charAt(b);
/*      */       
/*      */       String str;
/*  779 */       if ((str = visibleSpacesMap.get(Character.valueOf(c))) != null) {
/*  780 */         stringBuilder.append(str);
/*      */       } else {
/*  782 */         stringBuilder.append(c);
/*      */       } 
/*      */     } 
/*  785 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static char lastChar(CharSequence paramCharSequence) {
/*  793 */     return (paramCharSequence.length() == 0) ? Character.MIN_VALUE : paramCharSequence.charAt(paramCharSequence.length() - 1);
/*      */   }
/*      */   
/*      */   static char firstChar(CharSequence paramCharSequence) {
/*  797 */     return (paramCharSequence.length() == 0) ? Character.MIN_VALUE : paramCharSequence.charAt(0);
/*      */   }
/*      */   
/*      */   static char safeCharAt(CharSequence paramCharSequence, int paramInt) {
/*  801 */     return (paramInt < 0 || paramInt >= paramCharSequence.length()) ? Character.MIN_VALUE : paramCharSequence.charAt(paramInt);
/*      */   }
/*      */   
/*      */   static int eolEndLength(CharSequence paramCharSequence) {
/*  805 */     return eolEndLength(paramCharSequence, paramCharSequence.length());
/*      */   }
/*      */ 
/*      */   
/*      */   static int eolEndLength(CharSequence paramCharSequence, int paramInt) {
/*  810 */     if ((paramInt = Math.min(paramInt - 1, paramCharSequence.length() - 1)) < 0) return 0;
/*      */     
/*  812 */     byte b = 0;
/*      */     char c;
/*  814 */     if ((c = paramCharSequence.charAt(paramInt)) == '\r')
/*  815 */     { if (safeCharAt(paramCharSequence, paramInt + 1) != '\n')
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  822 */         b = 1; }  }
/*      */     else { if (c == '\n')
/*      */       { if (safeCharAt(paramCharSequence, paramInt - 1) == '\r')
/*  825 */         { b = 2; return b; }  } else { return b; }  b = 1; }  return b;
/*      */   }
/*      */   
/*      */   static int eolStartLength(CharSequence paramCharSequence, int paramInt) {
/*  829 */     int i = paramCharSequence.length();
/*  830 */     paramInt = Math.min(paramInt, i);
/*      */     
/*  832 */     byte b = 0;
/*      */     
/*  834 */     if (paramInt >= 0 && paramInt < i)
/*      */     {
/*  836 */       if ((i = paramCharSequence.charAt(paramInt)) == 13) {
/*  837 */         if (safeCharAt(paramCharSequence, paramInt + 1) == '\n') {
/*  838 */           b = 2;
/*      */         } else {
/*  840 */           b = 1;
/*      */         } 
/*  842 */       } else if (i == 10 && 
/*  843 */         safeCharAt(paramCharSequence, paramInt - 1) != '\r') {
/*  844 */         b = 1;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  849 */     return b;
/*      */   }
/*      */   
/*      */   static int endOfLine(CharSequence paramCharSequence, int paramInt) {
/*  853 */     return endOfDelimitedBy(paramCharSequence, "\n", paramInt);
/*  854 */   } static int endOfLineAnyEOL(CharSequence paramCharSequence, int paramInt) { return endOfDelimitedByAny(paramCharSequence, CharPredicate.ANY_EOL, paramInt); }
/*  855 */   static int startOfLine(CharSequence paramCharSequence, int paramInt) { return startOfDelimitedBy(paramCharSequence, "\n", paramInt); } static int startOfLineAnyEOL(CharSequence paramCharSequence, int paramInt) {
/*  856 */     return startOfDelimitedByAny(paramCharSequence, CharPredicate.ANY_EOL, paramInt);
/*      */   }
/*  858 */   static int startOfDelimitedByAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) { return startOfDelimitedByAny(paramCharSequence, paramCharPredicate.negate(), paramInt); } static int endOfDelimitedByAnyNot(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) {
/*  859 */     return endOfDelimitedByAny(paramCharSequence, paramCharPredicate.negate(), paramInt);
/*      */   }
/*      */   
/*      */   static int startOfDelimitedBy(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/*  863 */     paramInt = Utils.rangeLimit(paramInt, 0, paramCharSequence1.length());
/*      */     int i;
/*  865 */     return ((i = lastIndexOf(paramCharSequence1, paramCharSequence2, paramInt - 1)) == -1) ? 0 : (i + 1);
/*      */   }
/*      */   
/*      */   static int startOfDelimitedByAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) {
/*  869 */     paramInt = Utils.rangeLimit(paramInt, 0, paramCharSequence.length());
/*      */     int i;
/*  871 */     return ((i = lastIndexOfAny(paramCharSequence, paramCharPredicate, paramInt - 1)) == -1) ? 0 : (i + 1);
/*      */   }
/*      */   
/*      */   static int endOfDelimitedBy(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt) {
/*  875 */     int j = paramCharSequence1.length();
/*  876 */     paramInt = Utils.rangeLimit(paramInt, 0, j);
/*      */     int i;
/*  878 */     return ((i = indexOf(paramCharSequence1, paramCharSequence2, paramInt)) == -1) ? j : i;
/*      */   }
/*      */   
/*      */   static int endOfDelimitedByAny(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt) {
/*  882 */     int j = paramCharSequence.length();
/*  883 */     paramInt = Utils.rangeLimit(paramInt, 0, j);
/*      */     int i;
/*  885 */     return ((i = indexOfAny(paramCharSequence, paramCharPredicate, paramInt)) == -1) ? j : i;
/*      */   }
/*      */ 
/*      */   
/*      */   static Range lineRangeAt(CharSequence paramCharSequence, int paramInt) {
/*  890 */     return Range.of(startOfLine(paramCharSequence, paramInt), endOfLine(paramCharSequence, paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   static Range lineRangeAtAnyEOL(CharSequence paramCharSequence, int paramInt) {
/*  895 */     return Range.of(startOfLineAnyEOL(paramCharSequence, paramInt), endOfLineAnyEOL(paramCharSequence, paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   static Range eolEndRange(CharSequence paramCharSequence, int paramInt) {
/*      */     int i;
/*  901 */     return ((i = eolEndLength(paramCharSequence, paramInt)) == 0) ? Range.NULL : Range.of(paramInt - i, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   static Range eolStartRange(CharSequence paramCharSequence, int paramInt) {
/*      */     int i;
/*  907 */     return ((i = eolStartLength(paramCharSequence, paramInt)) == 0) ? Range.NULL : Range.of(paramInt, paramInt + i);
/*      */   }
/*      */ 
/*      */   
/*      */   static <T extends CharSequence> T trimEOL(T paramT) {
/*      */     int i;
/*  913 */     return (T)(((i = eolEndLength((CharSequence)paramT)) > 0) ? paramT.subSequence(0, paramT.length() - i) : (Object)paramT);
/*      */   }
/*      */ 
/*      */   
/*      */   static <T extends CharSequence> T trimmedEOL(T paramT) {
/*      */     int i;
/*  919 */     return (T)(((i = eolEndLength((CharSequence)paramT)) > 0) ? paramT.subSequence(paramT.length() - i, paramT.length()) : null);
/*      */   }
/*      */ 
/*      */   
/*      */   static <T extends CharSequence> T trimTailBlankLines(T paramT) {
/*      */     Range range;
/*  925 */     return (range = trailingBlankLinesRange((CharSequence)paramT)).isNull() ? paramT : subSequenceBefore(paramT, range);
/*      */   }
/*      */ 
/*      */   
/*      */   static <T extends CharSequence> T trimLeadBlankLines(T paramT) {
/*      */     Range range;
/*  931 */     return (range = leadingBlankLinesRange((CharSequence)paramT)).isNull() ? paramT : subSequenceAfter(paramT, range);
/*      */   }
/*      */   
/*      */   static Range leadingBlankLinesRange(CharSequence paramCharSequence) {
/*  935 */     return leadingBlankLinesRange(paramCharSequence, CharPredicate.EOL, 0, 2147483647);
/*  936 */   } static Range leadingBlankLinesRange(CharSequence paramCharSequence, int paramInt) { return leadingBlankLinesRange(paramCharSequence, CharPredicate.EOL, paramInt, 2147483647); }
/*  937 */   static Range leadingBlankLinesRange(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return leadingBlankLinesRange(paramCharSequence, CharPredicate.EOL, paramInt1, paramInt2); }
/*  938 */   static Range trailingBlankLinesRange(CharSequence paramCharSequence) { return trailingBlankLinesRange(paramCharSequence, CharPredicate.EOL, 0, 2147483647); }
/*  939 */   static Range trailingBlankLinesRange(CharSequence paramCharSequence, int paramInt) { return trailingBlankLinesRange(paramCharSequence, CharPredicate.EOL, paramInt, 2147483647); } static Range trailingBlankLinesRange(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  940 */     return trailingBlankLinesRange(paramCharSequence, CharPredicate.EOL, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   static Range trailingBlankLinesRange(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  945 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length());
/*  946 */     paramInt1 = Utils.rangeLimit(paramInt1, 0, paramInt2);
/*      */ 
/*      */     
/*  949 */     int i = paramInt2;
/*      */     
/*      */     int j;
/*  952 */     for (j = paramInt2; j-- > paramInt1; ) {
/*  953 */       char c = paramCharSequence.charAt(j);
/*  954 */       if (paramCharPredicate.test(c)) { i = Math.min(j + Math.min(eolStartLength(paramCharSequence, j), 1), paramInt2); continue; }
/*  955 */        if (c == ' ' || c == '\t');
/*      */     } 
/*      */     
/*  958 */     if (j < paramInt1) return Range.of(paramInt1, paramInt2); 
/*  959 */     if (i != paramInt2) return Range.of(i, paramInt2); 
/*  960 */     return Range.NULL;
/*      */   }
/*      */ 
/*      */   
/*      */   static Range leadingBlankLinesRange(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*  965 */     paramInt2 = Math.min(paramInt2, paramCharSequence.length());
/*  966 */     paramInt1 = Utils.rangeLimit(paramInt1, 0, paramInt2);
/*      */ 
/*      */     
/*  969 */     int i = -1;
/*      */     
/*      */     int j;
/*  972 */     for (j = paramInt1; j < paramInt2; j++) {
/*  973 */       char c = paramCharSequence.charAt(j);
/*  974 */       if (paramCharPredicate.test(c)) { i = j; continue; }
/*  975 */        if (c == ' ' || c == '\t')
/*      */         continue; 
/*      */     } 
/*  978 */     if (j == paramInt2) return Range.of(paramInt1, paramInt2); 
/*  979 */     if (i >= 0) return Range.of(paramInt1, Math.min(i + Math.min(eolStartLength(paramCharSequence, i), 1), paramInt2)); 
/*  980 */     return Range.NULL;
/*      */   }
/*      */   
/*      */   static List<Range> blankLinesRemovedRanges(CharSequence paramCharSequence) {
/*  984 */     return blankLinesRemovedRanges(paramCharSequence, CharPredicate.EOL, 0, 2147483647);
/*  985 */   } static List<Range> blankLinesRemovedRanges(CharSequence paramCharSequence, int paramInt) { return blankLinesRemovedRanges(paramCharSequence, CharPredicate.EOL, paramInt, 2147483647); } static List<Range> blankLinesRemovedRanges(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  986 */     return blankLinesRemovedRanges(paramCharSequence, CharPredicate.EOL, paramInt1, paramInt2);
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
/*      */   static List<Range> blankLinesRemovedRanges(CharSequence paramCharSequence, CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/*      */     // Byte code:
/*      */     //   0: iload_3
/*      */     //   1: aload_0
/*      */     //   2: invokeinterface length : ()I
/*      */     //   7: invokestatic min : (II)I
/*      */     //   10: istore_3
/*      */     //   11: iload_2
/*      */     //   12: iconst_0
/*      */     //   13: iload_3
/*      */     //   14: invokestatic rangeLimit : (III)I
/*      */     //   17: dup
/*      */     //   18: istore_2
/*      */     //   19: istore_2
/*      */     //   20: new java/util/ArrayList
/*      */     //   23: dup
/*      */     //   24: invokespecial <init> : ()V
/*      */     //   27: astore #4
/*      */     //   29: iload_2
/*      */     //   30: iload_3
/*      */     //   31: if_icmpge -> 120
/*      */     //   34: aload_0
/*      */     //   35: aload_1
/*      */     //   36: iload_2
/*      */     //   37: iload_3
/*      */     //   38: invokestatic leadingBlankLinesRange : (Ljava/lang/CharSequence;Lcom/vladsch/flexmark/util/misc/CharPredicate;II)Lcom/vladsch/flexmark/util/sequence/Range;
/*      */     //   41: dup
/*      */     //   42: astore #5
/*      */     //   44: invokevirtual isNull : ()Z
/*      */     //   47: ifeq -> 87
/*      */     //   50: aload_0
/*      */     //   51: iload_2
/*      */     //   52: invokestatic endOfLine : (Ljava/lang/CharSequence;I)I
/*      */     //   55: iconst_1
/*      */     //   56: iadd
/*      */     //   57: iload_3
/*      */     //   58: invokestatic min : (II)I
/*      */     //   61: istore #5
/*      */     //   63: iload_2
/*      */     //   64: iload #5
/*      */     //   66: if_icmpge -> 81
/*      */     //   69: aload #4
/*      */     //   71: iload_2
/*      */     //   72: iload #5
/*      */     //   74: invokestatic of : (II)Lcom/vladsch/flexmark/util/sequence/Range;
/*      */     //   77: invokevirtual add : (Ljava/lang/Object;)Z
/*      */     //   80: pop
/*      */     //   81: iload #5
/*      */     //   83: istore_2
/*      */     //   84: goto -> 29
/*      */     //   87: iload_2
/*      */     //   88: aload #5
/*      */     //   90: invokevirtual getStart : ()I
/*      */     //   93: if_icmpge -> 111
/*      */     //   96: aload #4
/*      */     //   98: iload_2
/*      */     //   99: aload #5
/*      */     //   101: invokevirtual getStart : ()I
/*      */     //   104: invokestatic of : (II)Lcom/vladsch/flexmark/util/sequence/Range;
/*      */     //   107: invokevirtual add : (Ljava/lang/Object;)Z
/*      */     //   110: pop
/*      */     //   111: aload #5
/*      */     //   113: invokevirtual getEnd : ()I
/*      */     //   116: istore_2
/*      */     //   117: goto -> 29
/*      */     //   120: aload #4
/*      */     //   122: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #991	-> 0
/*      */     //   #992	-> 11
/*      */     //   #993	-> 18
/*      */     //   #994	-> 20
/*      */     //   #996	-> 29
/*      */     //   #997	-> 34
/*      */     //   #998	-> 42
/*      */     //   #999	-> 50
/*      */     //   #1000	-> 63
/*      */     //   #1001	-> 81
/*      */     //   #1002	-> 84
/*      */     //   #1003	-> 87
/*      */     //   #1004	-> 111
/*      */     //   #1006	-> 117
/*      */     //   #1007	-> 120
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
/*      */   static boolean isEmpty(CharSequence paramCharSequence) {
/* 1011 */     return (paramCharSequence.length() == 0);
/* 1012 */   } static boolean isBlank(CharSequence paramCharSequence) { return (isEmpty(paramCharSequence) || countLeading(paramCharSequence, CharPredicate.WHITESPACE, 0, 2147483647) == paramCharSequence.length()); }
/* 1013 */   static boolean isNotEmpty(CharSequence paramCharSequence) { return (paramCharSequence.length() != 0); } static boolean isNotBlank(CharSequence paramCharSequence) {
/* 1014 */     return !isBlank(paramCharSequence);
/*      */   }
/* 1016 */   static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) { return (paramCharSequence1.length() > 0 && matchCharsReversed(paramCharSequence1, paramCharSequence2, paramCharSequence1.length() - 1, false)); }
/* 1017 */   static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean) { return (paramCharSequence1.length() > 0 && matchCharsReversed(paramCharSequence1, paramCharSequence2, paramCharSequence1.length() - 1, paramBoolean)); }
/* 1018 */   static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) { return (paramCharSequence1.length() > 0 && matchChars(paramCharSequence1, paramCharSequence2, 0, false)); } static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean) {
/* 1019 */     return (paramCharSequence1.length() > 0 && matchChars(paramCharSequence1, paramCharSequence2, 0, paramBoolean));
/*      */   }
/* 1021 */   static boolean endsWith(CharSequence paramCharSequence, CharPredicate paramCharPredicate) { return (countTrailing(paramCharSequence, paramCharPredicate) > 0); } static boolean startsWith(CharSequence paramCharSequence, CharPredicate paramCharPredicate) {
/* 1022 */     return (countLeading(paramCharSequence, paramCharPredicate) > 0);
/*      */   }
/* 1024 */   static boolean endsWithEOL(CharSequence paramCharSequence) { return endsWith(paramCharSequence, CharPredicate.EOL); }
/* 1025 */   static boolean endsWithAnyEOL(CharSequence paramCharSequence) { return endsWith(paramCharSequence, CharPredicate.ANY_EOL); }
/* 1026 */   static boolean endsWithSpace(CharSequence paramCharSequence) { return endsWith(paramCharSequence, CharPredicate.SPACE); }
/* 1027 */   static boolean endsWithSpaceTab(CharSequence paramCharSequence) { return endsWith(paramCharSequence, CharPredicate.SPACE_TAB); } static boolean endsWithWhitespace(CharSequence paramCharSequence) {
/* 1028 */     return endsWith(paramCharSequence, CharPredicate.WHITESPACE);
/*      */   }
/* 1030 */   static boolean startsWithEOL(CharSequence paramCharSequence) { return startsWith(paramCharSequence, CharPredicate.EOL); }
/* 1031 */   static boolean startsWithAnyEOL(CharSequence paramCharSequence) { return startsWith(paramCharSequence, CharPredicate.ANY_EOL); }
/* 1032 */   static boolean startsWithSpace(CharSequence paramCharSequence) { return startsWith(paramCharSequence, CharPredicate.SPACE); }
/* 1033 */   static boolean startsWithSpaceTab(CharSequence paramCharSequence) { return startsWith(paramCharSequence, CharPredicate.SPACE_TAB); } static boolean startsWithWhitespace(CharSequence paramCharSequence) {
/* 1034 */     return startsWith(paramCharSequence, CharPredicate.WHITESPACE);
/*      */   }
/*      */   
/*      */   static <T extends CharSequence> List<T> splitList(T paramT, CharSequence paramCharSequence) {
/* 1038 */     return splitList(paramT, paramCharSequence, 0, 0, (CharPredicate)null);
/* 1039 */   } static <T extends CharSequence> List<T> splitList(T paramT, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, CharPredicate paramCharPredicate) { return splitList(paramT, paramCharSequence, paramInt, paramBoolean ? 1 : 0, paramCharPredicate); }
/* 1040 */   static <T extends CharSequence> List<T> splitList(T paramT, CharSequence paramCharSequence, int paramInt1, int paramInt2) { return splitList(paramT, paramCharSequence, paramInt1, paramInt2, (CharPredicate)null); } static <T extends CharSequence> List<T> splitList(T paramT, CharSequence paramCharSequence, boolean paramBoolean, CharPredicate paramCharPredicate) {
/* 1041 */     return splitList(paramT, paramCharSequence, 0, paramBoolean ? 1 : 0, paramCharPredicate);
/*      */   }
/*      */   
/* 1044 */   static <T extends CharSequence> List<T> splitListEOL(T paramT) { return splitList(paramT, "\n", 0, 1, (CharPredicate)null); }
/* 1045 */   static <T extends CharSequence> List<T> splitListEOL(T paramT, boolean paramBoolean) { return splitList(paramT, "\n", 0, paramBoolean ? 1 : 0, (CharPredicate)null); } static <T extends CharSequence> List<T> splitListEOL(T paramT, boolean paramBoolean, CharPredicate paramCharPredicate) {
/* 1046 */     return splitList(paramT, "\n", 0, paramBoolean ? 1 : 0, paramCharPredicate);
/*      */   }
/* 1048 */   static <T extends CharSequence> T[] splitEOL(T paramT, T[] paramArrayOfT) { return split(paramT, paramArrayOfT, "\n", 0, 1, (CharPredicate)null); }
/* 1049 */   static <T extends CharSequence> T[] splitEOL(T paramT, T[] paramArrayOfT, boolean paramBoolean) { return split(paramT, paramArrayOfT, "\n", 0, paramBoolean ? 1 : 0, (CharPredicate)null); }
/* 1050 */   static <T extends CharSequence> T[] split(T paramT, T[] paramArrayOfT, CharSequence paramCharSequence, boolean paramBoolean, CharPredicate paramCharPredicate) { return split(paramT, paramArrayOfT, "\n", 0, paramBoolean ? 1 : 0, paramCharPredicate); }
/* 1051 */   static <T extends CharSequence> T[] split(T paramT, T[] paramArrayOfT, CharSequence paramCharSequence) { return split(paramT, paramArrayOfT, paramCharSequence, 0, 0, (CharPredicate)null); }
/* 1052 */   static <T extends CharSequence> T[] split(T paramT, T[] paramArrayOfT, CharSequence paramCharSequence, int paramInt, boolean paramBoolean, CharPredicate paramCharPredicate) { return split(paramT, paramArrayOfT, paramCharSequence, paramInt, paramBoolean ? 1 : 0, paramCharPredicate); }
/* 1053 */   static <T extends CharSequence> T[] split(T paramT, T[] paramArrayOfT, CharSequence paramCharSequence, int paramInt1, int paramInt2) { return split(paramT, paramArrayOfT, paramCharSequence, paramInt1, paramInt2, (CharPredicate)null); } static <T extends CharSequence> T[] split(T paramT, T[] paramArrayOfT, CharSequence paramCharSequence, int paramInt1, int paramInt2, CharPredicate paramCharPredicate) {
/* 1054 */     return (T[])splitList(paramT, paramCharSequence, paramInt1, paramInt2, paramCharPredicate).toArray((Object[])paramArrayOfT);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static <T extends CharSequence> List<T> splitList(T paramT, CharSequence paramCharSequence, int paramInt1, int paramInt2, CharPredicate paramCharPredicate) {
/* 1060 */     if (paramCharPredicate == null) { paramCharPredicate = CharPredicate.WHITESPACE; }
/* 1061 */     else { paramInt2 |= 0x2; }
/*      */     
/* 1063 */     if (paramInt1 <= 0) paramInt1 = Integer.MAX_VALUE;
/*      */     
/*      */     boolean bool1;
/* 1066 */     byte b = (!(bool1 = ((paramInt2 & 0x8) != 0) ? true : false) && (paramInt2 & 0x1) != 0) ? paramCharSequence.length() : 0;
/* 1067 */     boolean bool2 = ((paramInt2 & 0x2) != 0) ? true : false;
/* 1068 */     paramInt2 = ((paramInt2 & 0x4) != 0) ? 1 : 0;
/* 1069 */     ArrayList<CharSequence> arrayList = new ArrayList();
/*      */     
/* 1071 */     int i = 0;
/* 1072 */     int j = paramT.length();
/* 1073 */     if (paramInt1 > 1) {
/* 1074 */       int k; while (i < j && (
/*      */         
/* 1076 */         k = indexOf((CharSequence)paramT, paramCharSequence, i)) >= 0) {
/*      */         
/* 1078 */         if (i < k || paramInt2 == 0) {
/* 1079 */           CharSequence charSequence = paramT.subSequence(i, k + b);
/* 1080 */           if (bool2) charSequence = trim(charSequence, paramCharPredicate); 
/* 1081 */           if (!isEmpty(charSequence) || paramInt2 == 0) {
/* 1082 */             arrayList.add(charSequence);
/* 1083 */             if (bool1) {
/* 1084 */               arrayList.add(paramT.subSequence(k, k + paramCharSequence.length()));
/*      */             }
/* 1086 */             if (arrayList.size() >= paramInt1 - 1) {
/* 1087 */               int m = k + 1;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/* 1092 */         i = k + 1;
/*      */       } 
/*      */     } 
/*      */     
/* 1096 */     if (i < j) {
/* 1097 */       CharSequence charSequence = paramT.subSequence(i, j);
/* 1098 */       if (bool2) charSequence = trim(charSequence, paramCharPredicate); 
/* 1099 */       if (!isEmpty(charSequence) || paramInt2 == 0) {
/* 1100 */         arrayList.add(charSequence);
/*      */       }
/*      */     } 
/* 1103 */     return (List)arrayList;
/*      */   }
/*      */   
/*      */   static int columnAtIndex(CharSequence paramCharSequence, int paramInt) {
/* 1107 */     int i = lastIndexOfAny(paramCharSequence, CharPredicate.ANY_EOL, paramInt);
/* 1108 */     return paramInt - ((i == -1) ? 0 : (i + eolStartLength(paramCharSequence, i)));
/*      */   }
/*      */ 
/*      */   
/*      */   static Pair<Integer, Integer> lineColumnAtIndex(CharSequence paramCharSequence, int paramInt) {
/* 1113 */     int i = paramCharSequence.length();
/* 1114 */     if (paramInt < 0 || paramInt > i) {
/* 1115 */       throw new IllegalArgumentException("Index: " + paramInt + " out of range [0, " + i + "]");
/*      */     }
/*      */     
/* 1118 */     i = 0;
/* 1119 */     byte b1 = 0;
/* 1120 */     byte b2 = 0;
/* 1121 */     for (byte b3 = 0; b3 < paramInt; b3++) {
/*      */       char c;
/* 1123 */       if ((c = paramCharSequence.charAt(b3)) == '\r') {
/* 1124 */         b2 = 0;
/* 1125 */         b1++;
/* 1126 */         i = 1;
/* 1127 */       } else if (c == '\n') {
/* 1128 */         if (i == 0) {
/* 1129 */           b1++;
/*      */         }
/* 1131 */         b2 = 0;
/* 1132 */         i = 0;
/*      */       } else {
/* 1134 */         b2++;
/*      */       } 
/*      */     } 
/*      */     
/* 1138 */     return new Pair(Integer.valueOf(b1), Integer.valueOf(b2));
/*      */   }
/*      */   
/*      */   static void validateIndex(int paramInt1, int paramInt2) {
/* 1142 */     if (paramInt1 < 0 || paramInt1 >= paramInt2) {
/* 1143 */       throw new StringIndexOutOfBoundsException("String index: " + paramInt1 + " out of range: [0, " + paramInt2 + ")");
/*      */     }
/*      */   }
/*      */   
/*      */   static void validateIndexInclusiveEnd(int paramInt1, int paramInt2) {
/* 1148 */     if (paramInt1 < 0 || paramInt1 > paramInt2) {
/* 1149 */       throw new StringIndexOutOfBoundsException("index: " + paramInt1 + " out of range: [0, " + paramInt2 + "]");
/*      */     }
/*      */   }
/*      */   
/*      */   static void validateStartEnd(int paramInt1, int paramInt2, int paramInt3) {
/* 1154 */     if (paramInt1 < 0 || paramInt1 > paramInt3) {
/* 1155 */       throw new StringIndexOutOfBoundsException("startIndex: " + paramInt1 + " out of range: [0, " + paramInt3 + ")");
/*      */     }
/*      */     
/* 1158 */     if (paramInt2 < paramInt1 || paramInt2 > paramInt3) {
/* 1159 */       throw new StringIndexOutOfBoundsException("endIndex: " + paramInt2 + " out of range: [" + paramInt1 + ", " + paramInt3 + "]");
/*      */     }
/*      */   }
/*      */   
/*      */   static Integer parseUnsignedIntOrNull(String paramString) {
/* 1164 */     return parseUnsignedIntOrNull(paramString, 10);
/*      */   }
/*      */   
/*      */   static Integer parseUnsignedIntOrNull(String paramString, int paramInt) {
/*      */     try {
/*      */       int i;
/* 1170 */       return ((i = Integer.parseInt(paramString, paramInt)) >= 0) ? Integer.valueOf(i) : null;
/* 1171 */     } catch (NumberFormatException numberFormatException) {
/* 1172 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   static Integer parseIntOrNull(String paramString) {
/* 1177 */     return parseIntOrNull(paramString, 10);
/*      */   }
/*      */   
/*      */   static Integer parseIntOrNull(String paramString, int paramInt) {
/*      */     try {
/* 1182 */       return Integer.valueOf(Integer.parseInt(paramString, paramInt));
/* 1183 */     } catch (NumberFormatException numberFormatException) {
/* 1184 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   static Long parseLongOrNull(String paramString) {
/* 1189 */     return parseLongOrNull(paramString, 10);
/*      */   }
/*      */   
/*      */   static Long parseLongOrNull(String paramString, int paramInt) {
/*      */     try {
/* 1194 */       return Long.valueOf(Long.parseLong(paramString, paramInt));
/* 1195 */     } catch (NumberFormatException numberFormatException) {
/* 1196 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   static int parseUnsignedIntOrDefault(String paramString, int paramInt) {
/* 1201 */     return parseUnsignedIntOrDefault(paramString, paramInt, 10);
/*      */   }
/*      */   
/*      */   static int parseUnsignedIntOrDefault(String paramString, int paramInt1, int paramInt2) {
/*      */     try {
/*      */       int i;
/* 1207 */       return ((i = Integer.parseInt(paramString, paramInt2)) >= 0) ? i : paramInt1;
/* 1208 */     } catch (NumberFormatException numberFormatException) {
/* 1209 */       return paramInt1;
/*      */     } 
/*      */   }
/*      */   
/*      */   static int parseIntOrDefault(String paramString, int paramInt) {
/* 1214 */     return parseIntOrDefault(paramString, paramInt, 10);
/*      */   }
/*      */   
/*      */   static int parseIntOrDefault(String paramString, int paramInt1, int paramInt2) {
/*      */     try {
/* 1219 */       return Integer.parseInt(paramString, paramInt2);
/* 1220 */     } catch (NumberFormatException numberFormatException) {
/* 1221 */       return paramInt1;
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
/*      */   static Number parseNumberOrNull(String paramString) {
/* 1234 */     if (paramString == null) return null;
/*      */     
/* 1236 */     if (paramString.startsWith("0x"))
/* 1237 */       return parseLongOrNull(paramString.substring(2), 16); 
/* 1238 */     if (paramString.startsWith("0b"))
/* 1239 */       return parseLongOrNull(paramString.substring(2), 2);  Long long_;
/* 1240 */     if (paramString.startsWith("0") && (
/*      */       
/* 1242 */       long_ = parseLongOrNull(paramString.substring(1), 8)) != null) return long_;
/*      */ 
/*      */     
/* 1245 */     NumberFormat numberFormat = NumberFormat.getInstance();
/* 1246 */     ParsePosition parsePosition = new ParsePosition(0);
/* 1247 */     Number number = numberFormat.parse(paramString, parsePosition);
/* 1248 */     return (parsePosition.getIndex() == paramString.length()) ? number : null;
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
/*      */   static Pair<Number, String> parseNumberPrefixOrNull(String paramString, Predicate<String> paramPredicate) {
/* 1261 */     if (paramString == null) return null;
/*      */     
/* 1263 */     if (paramString.startsWith("0x")) {
/* 1264 */       int i = countLeading(paramString.substring(2), CharPredicate.HEXADECIMAL_DIGITS);
/* 1265 */       String str = paramString.substring(i + 2);
/* 1266 */       if (i > 0 && (str.isEmpty() || paramPredicate == null || paramPredicate.test(str))) {
/* 1267 */         return Pair.of(parseLongOrNull(paramString.substring(2, i + 2), 16), str);
/*      */       }
/* 1269 */     } else if (paramString.startsWith("0b")) {
/* 1270 */       int i = countLeading(paramString.substring(2), CharPredicate.BINARY_DIGITS);
/* 1271 */       String str = paramString.substring(i + 2);
/* 1272 */       if (i > 0 && (str.isEmpty() || paramPredicate == null || paramPredicate.test(str))) {
/* 1273 */         return Pair.of(parseLongOrNull(paramString.substring(2, i + 2), 2), str);
/*      */       }
/* 1275 */     } else if (paramString.startsWith("0")) {
/* 1276 */       int i = countLeading(paramString.substring(1), CharPredicate.OCTAL_DIGITS);
/* 1277 */       int j = countLeading(paramString.substring(1), CharPredicate.DECIMAL_DIGITS);
/* 1278 */       if (i == j) {
/* 1279 */         String str = paramString.substring(i + 1);
/* 1280 */         if (i > 0 && (str.isEmpty() || paramPredicate == null || paramPredicate.test(str))) {
/* 1281 */           return Pair.of(parseLongOrNull(paramString.substring(1, i + 1), 8), str);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1286 */     NumberFormat numberFormat = NumberFormat.getInstance();
/* 1287 */     ParsePosition parsePosition = new ParsePosition(0);
/* 1288 */     Number number = numberFormat.parse(paramString, parsePosition);
/* 1289 */     paramString = paramString.substring(parsePosition.getIndex());
/* 1290 */     if (parsePosition.getIndex() > 0 && (paramString.isEmpty() || paramPredicate == null || paramPredicate.test(paramString))) {
/* 1291 */       return Pair.of(number, paramString);
/*      */     }
/*      */     
/* 1294 */     return null;
/*      */   } static <T extends CharSequence> boolean containedBy(T[] paramArrayOfT, CharSequence paramCharSequence) {
/*      */     int i;
/*      */     byte b;
/* 1298 */     for (i = (paramArrayOfT = paramArrayOfT).length, b = 0; b < i; ) { T t = paramArrayOfT[b];
/* 1299 */       if (equals(paramCharSequence, t)) return true;  b++; }
/*      */     
/* 1301 */     return false;
/*      */   }
/*      */   
/*      */   static boolean containedBy(Collection<? extends CharSequence> paramCollection, CharSequence paramCharSequence) {
/* 1305 */     for (CharSequence charSequence : paramCollection) {
/* 1306 */       if (equals(paramCharSequence, charSequence)) return true; 
/*      */     } 
/* 1308 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\SequenceUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */