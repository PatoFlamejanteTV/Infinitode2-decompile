/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface LineAppendable
/*     */   extends Appendable, Iterable<LineInfo>
/*     */ {
/*     */   public enum Options
/*     */   {
/*  32 */     CONVERT_TABS,
/*  33 */     COLLAPSE_WHITESPACE,
/*  34 */     TRIM_TRAILING_WHITESPACE,
/*  35 */     PASS_THROUGH,
/*  36 */     TRIM_LEADING_WHITESPACE,
/*  37 */     TRIM_LEADING_EOL,
/*  38 */     PREFIX_PRE_FORMATTED;
/*     */   }
/*     */   
/*  41 */   public static final Options O_CONVERT_TABS = Options.CONVERT_TABS;
/*  42 */   public static final Options O_COLLAPSE_WHITESPACE = Options.COLLAPSE_WHITESPACE;
/*  43 */   public static final Options O_TRIM_TRAILING_WHITESPACE = Options.TRIM_TRAILING_WHITESPACE;
/*  44 */   public static final Options O_PASS_THROUGH = Options.PASS_THROUGH;
/*  45 */   public static final Options O_TRIM_LEADING_WHITESPACE = Options.TRIM_LEADING_WHITESPACE;
/*  46 */   public static final Options O_TRIM_LEADING_EOL = Options.TRIM_LEADING_EOL;
/*  47 */   public static final Options O_PREFIX_PRE_FORMATTED = Options.PREFIX_PRE_FORMATTED;
/*  48 */   public static final BitFieldSet<Options> O_FORMAT_ALL = BitFieldSet.of(O_CONVERT_TABS, O_COLLAPSE_WHITESPACE, O_TRIM_TRAILING_WHITESPACE, O_TRIM_LEADING_WHITESPACE);
/*     */   
/*  50 */   public static final int F_CONVERT_TABS = BitFieldSet.intMask(O_CONVERT_TABS);
/*  51 */   public static final int F_COLLAPSE_WHITESPACE = BitFieldSet.intMask(O_COLLAPSE_WHITESPACE);
/*  52 */   public static final int F_TRIM_TRAILING_WHITESPACE = BitFieldSet.intMask(O_TRIM_TRAILING_WHITESPACE);
/*  53 */   public static final int F_PASS_THROUGH = BitFieldSet.intMask(O_PASS_THROUGH);
/*     */ 
/*     */   
/*  56 */   public static final int F_TRIM_LEADING_WHITESPACE = BitFieldSet.intMask(O_TRIM_LEADING_WHITESPACE);
/*     */   
/*  58 */   public static final int F_TRIM_LEADING_EOL = BitFieldSet.intMask(O_TRIM_LEADING_EOL);
/*  59 */   public static final int F_PREFIX_PRE_FORMATTED = BitFieldSet.intMask(O_PREFIX_PRE_FORMATTED);
/*  60 */   public static final int F_FORMAT_ALL = F_CONVERT_TABS | F_COLLAPSE_WHITESPACE | F_TRIM_TRAILING_WHITESPACE | F_TRIM_LEADING_WHITESPACE | F_TRIM_LEADING_EOL;
/*     */   
/*  62 */   public static final int F_WHITESPACE_REMOVAL = F_COLLAPSE_WHITESPACE | F_TRIM_TRAILING_WHITESPACE | F_TRIM_LEADING_WHITESPACE;
/*     */   
/*     */   @Deprecated
/*  65 */   public static final int CONVERT_TABS = F_CONVERT_TABS; @Deprecated
/*  66 */   public static final int COLLAPSE_WHITESPACE = F_COLLAPSE_WHITESPACE; @Deprecated
/*  67 */   public static final int TRIM_TRAILING_WHITESPACE = F_TRIM_TRAILING_WHITESPACE; @Deprecated
/*  68 */   public static final int PASS_THROUGH = F_PASS_THROUGH;
/*     */   
/*     */   @Deprecated
/*     */   public static final int ALLOW_LEADING_WHITESPACE = 0;
/*     */   
/*     */   @Deprecated
/*  74 */   public static final int TRIM_LEADING_WHITESPACE = F_TRIM_LEADING_WHITESPACE;
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static final int ALLOW_LEADING_EOL = 0;
/*     */   
/*     */   @Deprecated
/*  81 */   public static final int PREFIX_PRE_FORMATTED = F_PREFIX_PRE_FORMATTED; @Deprecated
/*  82 */   public static final int FORMAT_ALL = F_FORMAT_ALL;
/*     */   
/*     */   static BitFieldSet<Options> toOptionSet(int paramInt) {
/*  85 */     return BitFieldSet.of(Options.class, paramInt);
/*     */   }
/*     */   
/*     */   static BitFieldSet<Options> toOptionSet(Options... paramVarArgs) {
/*  89 */     return BitFieldSet.of(Options.class, (Enum[])paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default int getOptions() {
/*  98 */     return getOptionSet().toInt();
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
/*     */   default LineAppendable copyAppendable(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 114 */     return getEmptyAppendable().append(this, paramInt1, paramInt2, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable copyAppendable(int paramInt1, int paramInt2) {
/* 119 */     return getEmptyAppendable().append(this, paramInt1, paramInt2, false);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable copyAppendable(int paramInt) {
/* 124 */     return getEmptyAppendable().append(this, paramInt, 2147483647, false);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable copyAppendable() {
/* 129 */     return getEmptyAppendable().append(this, 0, 2147483647, false);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable copyAppendable(boolean paramBoolean) {
/* 134 */     return getEmptyAppendable().append(this, 0, 2147483647, paramBoolean);
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
/*     */   default LineAppendable noTrimLeading() {
/* 153 */     return changeOptions(0, F_TRIM_LEADING_WHITESPACE);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable trimLeading() {
/* 158 */     return changeOptions(F_TRIM_LEADING_WHITESPACE, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable preserveSpaces() {
/* 163 */     return changeOptions(0, F_TRIM_LEADING_WHITESPACE | F_COLLAPSE_WHITESPACE);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable noPreserveSpaces() {
/* 168 */     return changeOptions(F_TRIM_LEADING_WHITESPACE | F_COLLAPSE_WHITESPACE, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable removeOptions(int paramInt) {
/* 173 */     return changeOptions(0, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable addOptions(int paramInt) {
/* 178 */     return changeOptions(paramInt, 0);
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
/*     */   default LineAppendable setOptions(int paramInt) {
/* 192 */     return setOptions(toOptionSet(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   LineAppendable setOptions(Options... paramVarArgs) {
/* 197 */     return setOptions(toOptionSet(paramVarArgs).toInt());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default LineAppendable setOptions(BitFieldSet<Options> paramBitFieldSet) {
/* 208 */     return setOptions(paramBitFieldSet.toInt());
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
/*     */   default int getTrailingBlankLines() {
/* 228 */     return getTrailingBlankLines(getLineCountWithPending());
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
/*     */   default LineAppendable appendAll(Iterable<CharSequence> paramIterable) {
/* 250 */     for (CharSequence charSequence : paramIterable) {
/* 251 */       append(charSequence);
/*     */     }
/* 253 */     return this;
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
/*     */   default LineAppendable append(LineAppendable paramLineAppendable) {
/* 284 */     return append(paramLineAppendable, 0, 2147483647, true);
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
/*     */   default LineAppendable append(LineAppendable paramLineAppendable, boolean paramBoolean) {
/* 300 */     return append(paramLineAppendable, 0, 2147483647, paramBoolean);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default LineAppendable addPrefix(CharSequence paramCharSequence) {
/* 469 */     return addPrefix(paramCharSequence, (getPendingEOL() == 0));
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
/*     */   default LineAppendable setPrefix(CharSequence paramCharSequence) {
/* 483 */     return setPrefix(paramCharSequence, (getPendingEOL() == 0));
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
/*     */   default LineAppendable popPrefix() {
/* 508 */     return popPrefix(false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default LineAppendable setLineOnFirstText() {
/* 564 */     return lineOnFirstText(true);
/*     */   }
/*     */ 
/*     */   
/*     */   default LineAppendable clearLineOnFirstText() {
/* 569 */     return lineOnFirstText(false);
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
/*     */   default boolean isEmpty() {
/* 601 */     return (getLineCountWithPending() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean isNotEmpty() {
/* 610 */     return (getLineCountWithPending() != 0);
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
/*     */   default LineInfo get(int paramInt) {
/* 641 */     return getLineInfo(paramInt);
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
/*     */ 
/*     */ 
/*     */   
/*     */   default Iterable<BasedSequence> getLines(int paramInt) {
/* 680 */     return getLines(paramInt, 0, 2147483647, true);
/*     */   }
/*     */ 
/*     */   
/*     */   default Iterable<BasedSequence> getLines() {
/* 685 */     return getLines(2147483647, 0, 2147483647, true);
/*     */   }
/*     */ 
/*     */   
/*     */   default Iterable<BasedSequence> getLines(int paramInt, boolean paramBoolean) {
/* 690 */     return getLines(paramInt, 0, 2147483647, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   default Iterable<BasedSequence> getLines(boolean paramBoolean) {
/* 695 */     return getLines(2147483647, 0, 2147483647, paramBoolean);
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
/*     */   default Iterable<LineInfo> getLinesInfo(int paramInt) {
/* 713 */     return getLinesInfo(paramInt, 0, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   default Iterable<LineInfo> getLinesInfo() {
/* 718 */     return getLinesInfo(2147483647, 0, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default BasedSequence getLineContent(int paramInt) {
/* 729 */     LineInfo lineInfo = getLineInfo(paramInt);
/*     */     BasedSequence basedSequence;
/* 731 */     return (basedSequence = getLine(paramInt)).subSequence(lineInfo.prefixLength, lineInfo.prefixLength + lineInfo.textLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default BasedSequence getLinePrefix(int paramInt) {
/* 742 */     LineInfo lineInfo = getLineInfo(paramInt);
/*     */     BasedSequence basedSequence;
/* 744 */     return (basedSequence = getLine(paramInt)).subSequence(0, lineInfo.prefixLength);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default String toString(int paramInt1, int paramInt2) {
/* 788 */     return toString(paramInt1, paramInt2, true);
/*     */   }
/*     */ 
/*     */   
/*     */   default String toString(int paramInt, boolean paramBoolean) {
/* 793 */     return toString(paramInt, paramInt, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   default String toString(boolean paramBoolean) {
/* 798 */     return toString(2147483647, 2147483647, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default String toString(int paramInt) {
/* 809 */     return toString(paramInt, paramInt, true);
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
/*     */   default CharSequence toSequence(int paramInt1, int paramInt2) {
/* 825 */     return toSequence(paramInt1, paramInt2, true);
/*     */   }
/*     */ 
/*     */   
/*     */   default CharSequence toSequence(int paramInt, boolean paramBoolean) {
/* 830 */     return toSequence(paramInt, paramInt, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   default CharSequence toSequence(boolean paramBoolean) {
/* 835 */     return toSequence(2147483647, 2147483647, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   default CharSequence toSequence() {
/* 840 */     return toSequence(2147483647, 2147483647, true);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   default <T extends Appendable> T appendTo(T paramT, int paramInt) {
/* 845 */     return appendTo(paramT, 2147483647, paramInt);
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
/*     */   default <T extends Appendable> T appendTo(T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 866 */     return appendTo(paramT, true, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   default <T extends Appendable> T appendTo(T paramT, int paramInt1, int paramInt2) {
/* 870 */     return appendTo(paramT, paramInt1, paramInt2, 0, 2147483647);
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
/*     */   default <T extends Appendable> T appendTo(T paramT) {
/* 882 */     return appendTo(paramT, 0, 0, 0, 2147483647);
/*     */   }
/*     */   
/*     */   default <T extends Appendable> T appendToSilently(T paramT, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*     */     try {
/* 887 */       appendTo(paramT, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
/* 888 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/* 891 */     return paramT;
/*     */   }
/*     */   
/*     */   default <T extends Appendable> T appendToSilently(T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 895 */     appendToSilently(paramT, true, paramInt1, paramInt2, paramInt3, paramInt4);
/* 896 */     return paramT;
/*     */   }
/*     */   
/*     */   default <T extends Appendable> T appendToSilently(T paramT, int paramInt1, int paramInt2) {
/* 900 */     appendToSilently(paramT, paramInt1, paramInt2, 0, 2147483647);
/* 901 */     return paramT;
/*     */   }
/*     */   
/*     */   default <T extends Appendable> T appendToSilently(T paramT) {
/* 905 */     return appendToSilently(paramT, 0, 0, 0, 2147483647);
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
/*     */   default LineAppendable removeExtraBlankLines(int paramInt1, int paramInt2) {
/* 920 */     return removeExtraBlankLines(paramInt1, paramInt2, 0, 2147483647);
/*     */   }
/*     */   
/*     */   static CharSequence combinedPrefix(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 924 */     if (paramCharSequence1 != null && paramCharSequence1.length() > 0 && paramCharSequence2 != null && paramCharSequence2.length() > 0)
/* 925 */       return String.valueOf(paramCharSequence1) + paramCharSequence2; 
/* 926 */     if (paramCharSequence1 != null && paramCharSequence1.length() > 0)
/* 927 */       return paramCharSequence1; 
/* 928 */     if (paramCharSequence2 != null && paramCharSequence2.length() > 0) {
/* 929 */       return paramCharSequence2;
/*     */     }
/* 931 */     return BasedSequence.NULL;
/*     */   }
/*     */   
/*     */   LineAppendable getEmptyAppendable();
/*     */   
/*     */   BitFieldSet<Options> getOptionSet();
/*     */   
/*     */   LineAppendable pushOptions();
/*     */   
/*     */   LineAppendable popOptions();
/*     */   
/*     */   LineAppendable changeOptions(int paramInt1, int paramInt2);
/*     */   
/*     */   ISequenceBuilder<?, ?> getBuilder();
/*     */   
/*     */   int getTrailingBlankLines(int paramInt);
/*     */   
/*     */   boolean endsWithEOL();
/*     */   
/*     */   LineAppendable append(CharSequence paramCharSequence);
/*     */   
/*     */   LineAppendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*     */   
/*     */   LineAppendable append(char paramChar);
/*     */   
/*     */   LineAppendable append(char paramChar, int paramInt);
/*     */   
/*     */   LineAppendable append(LineAppendable paramLineAppendable, int paramInt1, int paramInt2, boolean paramBoolean);
/*     */   
/*     */   LineAppendable line();
/*     */   
/*     */   LineAppendable lineWithTrailingSpaces(int paramInt);
/*     */   
/*     */   LineAppendable lineIf(boolean paramBoolean);
/*     */   
/*     */   LineAppendable blankLine();
/*     */   
/*     */   LineAppendable blankLineIf(boolean paramBoolean);
/*     */   
/*     */   LineAppendable blankLine(int paramInt);
/*     */   
/*     */   boolean isPreFormatted();
/*     */   
/*     */   LineAppendable openPreFormatted(boolean paramBoolean);
/*     */   
/*     */   LineAppendable closePreFormatted();
/*     */   
/*     */   LineAppendable indent();
/*     */   
/*     */   LineAppendable unIndent();
/*     */   
/*     */   LineAppendable unIndentNoEol();
/*     */   
/*     */   BasedSequence getIndentPrefix();
/*     */   
/*     */   LineAppendable setIndentPrefix(CharSequence paramCharSequence);
/*     */   
/*     */   BasedSequence getPrefix();
/*     */   
/*     */   BasedSequence getBeforeEolPrefix();
/*     */   
/*     */   LineAppendable addPrefix(CharSequence paramCharSequence, boolean paramBoolean);
/*     */   
/*     */   LineAppendable setPrefix(CharSequence paramCharSequence, boolean paramBoolean);
/*     */   
/*     */   LineAppendable pushPrefix();
/*     */   
/*     */   LineAppendable popPrefix(boolean paramBoolean);
/*     */   
/*     */   int getAfterEolPrefixDelta();
/*     */   
/*     */   int column();
/*     */   
/*     */   int offset();
/*     */   
/*     */   int offsetWithPending();
/*     */   
/*     */   boolean isPendingSpace();
/*     */   
/*     */   int getPendingSpace();
/*     */   
/*     */   int getPendingEOL();
/*     */   
/*     */   LineAppendable lineOnFirstText(boolean paramBoolean);
/*     */   
/*     */   LineAppendable addIndentOnFirstEOL(Runnable paramRunnable);
/*     */   
/*     */   LineAppendable removeIndentOnFirstEOL(Runnable paramRunnable);
/*     */   
/*     */   int getLineCount();
/*     */   
/*     */   int getLineCountWithPending();
/*     */   
/*     */   LineInfo getLineInfo(int paramInt);
/*     */   
/*     */   BasedSequence getLine(int paramInt);
/*     */   
/*     */   Iterator<LineInfo> iterator();
/*     */   
/*     */   Iterable<BasedSequence> getLines(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
/*     */   
/*     */   Iterable<LineInfo> getLinesInfo(int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   void setPrefixLength(int paramInt1, int paramInt2);
/*     */   
/*     */   void setLine(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2);
/*     */   
/*     */   void insertLine(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2);
/*     */   
/*     */   LineAppendable removeLines(int paramInt1, int paramInt2);
/*     */   
/*     */   String toString(int paramInt1, int paramInt2, boolean paramBoolean);
/*     */   
/*     */   CharSequence toSequence(int paramInt1, int paramInt2, boolean paramBoolean);
/*     */   
/*     */   <T extends Appendable> T appendTo(T paramT, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   LineAppendable removeExtraBlankLines(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\LineAppendable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */