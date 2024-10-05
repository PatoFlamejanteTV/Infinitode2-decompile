/*      */ package com.vladsch.flexmark.util.sequence;
/*      */ 
/*      */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*      */ import com.vladsch.flexmark.util.misc.Pair;
/*      */ import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
/*      */ import java.util.Collection;
/*      */ import java.util.List;
/*      */ import java.util.function.BiPredicate;
/*      */ import java.util.function.Predicate;
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
/*      */ public interface IRichSequence<T extends IRichSequence<T>>
/*      */   extends SequenceUtils, CharSequence, Comparable<CharSequence>
/*      */ {
/*      */   @Deprecated
/*      */   default int countLeading(char paramChar) {
/*  315 */     return countLeading(CharPredicate.anyOf(new char[] { paramChar }));
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
/*      */   @Deprecated
/*      */   default int countLeading() {
/*  369 */     return countLeadingSpaceTab();
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   default int countTrailing() {
/*  374 */     return countLeadingSpaceTab();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   default int countOf(char paramChar) {
/*  385 */     return countOfAny(CharPredicate.anyOf(new char[] { paramChar }));
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
/*      */   @Deprecated
/*      */   T nullIfStartsWithNot(CharSequence... paramVarArgs) {
/*  597 */     return nullIfNotStartsWith(paramVarArgs);
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
/*      */   T nullIfEndsWithNot(CharSequence... paramVarArgs) {
/*  613 */     return nullIfNotEndsWith(paramVarArgs);
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
/*      */   @Deprecated
/*      */   default int eolStartLength() {
/*  633 */     return eolEndLength();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   default int eolLength(int paramInt) {
/*  666 */     return eolStartLength(paramInt);
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
/*      */   @Deprecated
/*      */   default T insert(CharSequence paramCharSequence, int paramInt) {
/* 1165 */     return insert(paramInt, paramCharSequence);
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
/*      */   @Deprecated
/*      */   default T[] split(char paramChar, int paramInt1, int paramInt2) {
/* 1243 */     return split(Character.toString(paramChar), paramInt1, paramInt2, (CharPredicate)null); } @Deprecated
/* 1244 */   default T[] split(char paramChar, int paramInt) { return split(Character.toString(paramChar), paramInt, 0, (CharPredicate)null); } @Deprecated
/* 1245 */   default T[] split(char paramChar) { return split(Character.toString(paramChar), 0, 0, (CharPredicate)null); }
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
/*      */   @Deprecated
/*      */   default Pair<Integer, Integer> getLineColumnAtIndex(int paramInt) {
/* 1381 */     return lineColumnAtIndex(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   default int getColumnAtIndex(int paramInt) {
/* 1388 */     return columnAtIndex(paramInt);
/*      */   }
/*      */   
/*      */   boolean equals(Object paramObject);
/*      */   
/*      */   int hashCode();
/*      */   
/*      */   T[] emptyArray();
/*      */   
/*      */   T nullSequence();
/*      */   
/*      */   char lastChar();
/*      */   
/*      */   char firstChar();
/*      */   
/*      */   char safeCharAt(int paramInt);
/*      */   
/*      */   T subSequence(int paramInt1, int paramInt2);
/*      */   
/*      */   T safeSubSequence(int paramInt1, int paramInt2);
/*      */   
/*      */   T safeSubSequence(int paramInt);
/*      */   
/*      */   T subSequence(Range paramRange);
/*      */   
/*      */   T subSequenceBefore(Range paramRange);
/*      */   
/*      */   T subSequenceAfter(Range paramRange);
/*      */   
/*      */   T subSequence(int paramInt);
/*      */   
/*      */   T endSequence(int paramInt1, int paramInt2);
/*      */   
/*      */   T endSequence(int paramInt);
/*      */   
/*      */   char endCharAt(int paramInt);
/*      */   
/*      */   T midSequence(int paramInt1, int paramInt2);
/*      */   
/*      */   T midSequence(int paramInt);
/*      */   
/*      */   char midCharAt(int paramInt);
/*      */   
/*      */   T sequenceOf(CharSequence paramCharSequence);
/*      */   
/*      */   T sequenceOf(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   T sequenceOf(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   <B extends com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder<B, T>> B getBuilder();
/*      */   
/*      */   int indexOf(CharSequence paramCharSequence);
/*      */   
/*      */   int indexOf(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   int indexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   int indexOf(char paramChar, int paramInt1, int paramInt2);
/*      */   
/*      */   int indexOf(char paramChar, int paramInt);
/*      */   
/*      */   int indexOf(char paramChar);
/*      */   
/*      */   int indexOfAny(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int indexOfAny(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int indexOfAny(CharPredicate paramCharPredicate);
/*      */   
/*      */   int indexOfNot(char paramChar, int paramInt1, int paramInt2);
/*      */   
/*      */   int indexOfNot(char paramChar, int paramInt);
/*      */   
/*      */   int indexOfNot(char paramChar);
/*      */   
/*      */   int indexOfAnyNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int indexOfAnyNot(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int indexOfAnyNot(CharPredicate paramCharPredicate);
/*      */   
/*      */   int lastIndexOf(CharSequence paramCharSequence);
/*      */   
/*      */   int lastIndexOf(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   int lastIndexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   int lastIndexOf(char paramChar, int paramInt1, int paramInt2);
/*      */   
/*      */   int lastIndexOf(char paramChar, int paramInt);
/*      */   
/*      */   int lastIndexOf(char paramChar);
/*      */   
/*      */   int lastIndexOfAny(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int lastIndexOfAny(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int lastIndexOfAny(CharPredicate paramCharPredicate);
/*      */   
/*      */   int lastIndexOfNot(char paramChar);
/*      */   
/*      */   int lastIndexOfNot(char paramChar, int paramInt);
/*      */   
/*      */   int lastIndexOfNot(char paramChar, int paramInt1, int paramInt2);
/*      */   
/*      */   int lastIndexOfAnyNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int lastIndexOfAnyNot(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int lastIndexOfAnyNot(CharPredicate paramCharPredicate);
/*      */   
/*      */   int countLeading(CharPredicate paramCharPredicate);
/*      */   
/*      */   int countLeadingNot(CharPredicate paramCharPredicate);
/*      */   
/*      */   int countLeading(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int countLeadingNot(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int countLeading(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int countLeadingNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int countTrailing(CharPredicate paramCharPredicate);
/*      */   
/*      */   int countTrailingNot(CharPredicate paramCharPredicate);
/*      */   
/*      */   int countTrailing(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int countTrailingNot(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int countTrailing(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int countTrailingNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int countLeadingSpace();
/*      */   
/*      */   int countLeadingNotSpace();
/*      */   
/*      */   int countLeadingSpace(int paramInt);
/*      */   
/*      */   int countLeadingNotSpace(int paramInt);
/*      */   
/*      */   int countLeadingSpace(int paramInt1, int paramInt2);
/*      */   
/*      */   int countLeadingNotSpace(int paramInt1, int paramInt2);
/*      */   
/*      */   int countTrailingSpace();
/*      */   
/*      */   int countTrailingNotSpace();
/*      */   
/*      */   int countTrailingSpace(int paramInt);
/*      */   
/*      */   int countTrailingNotSpace(int paramInt);
/*      */   
/*      */   int countTrailingSpace(int paramInt1, int paramInt2);
/*      */   
/*      */   int countTrailingNotSpace(int paramInt1, int paramInt2);
/*      */   
/*      */   int countLeadingSpaceTab();
/*      */   
/*      */   int countLeadingNotSpaceTab();
/*      */   
/*      */   int countLeadingSpaceTab(int paramInt);
/*      */   
/*      */   int countLeadingNotSpaceTab(int paramInt);
/*      */   
/*      */   int countLeadingSpaceTab(int paramInt1, int paramInt2);
/*      */   
/*      */   int countLeadingNotSpaceTab(int paramInt1, int paramInt2);
/*      */   
/*      */   int countTrailingSpaceTab();
/*      */   
/*      */   int countTrailingNotSpaceTab();
/*      */   
/*      */   int countTrailingSpaceTab(int paramInt);
/*      */   
/*      */   int countTrailingNotSpaceTab(int paramInt);
/*      */   
/*      */   int countTrailingSpaceTab(int paramInt1, int paramInt2);
/*      */   
/*      */   int countTrailingNotSpaceTab(int paramInt1, int paramInt2);
/*      */   
/*      */   int countLeadingWhitespace();
/*      */   
/*      */   int countLeadingNotWhitespace();
/*      */   
/*      */   int countLeadingWhitespace(int paramInt);
/*      */   
/*      */   int countLeadingNotWhitespace(int paramInt);
/*      */   
/*      */   int countLeadingWhitespace(int paramInt1, int paramInt2);
/*      */   
/*      */   int countLeadingNotWhitespace(int paramInt1, int paramInt2);
/*      */   
/*      */   int countTrailingWhitespace();
/*      */   
/*      */   int countTrailingNotWhitespace();
/*      */   
/*      */   int countTrailingWhitespace(int paramInt);
/*      */   
/*      */   int countTrailingNotWhitespace(int paramInt);
/*      */   
/*      */   int countTrailingWhitespace(int paramInt1, int paramInt2);
/*      */   
/*      */   int countTrailingNotWhitespace(int paramInt1, int paramInt2);
/*      */   
/*      */   int countOfSpaceTab();
/*      */   
/*      */   int countOfNotSpaceTab();
/*      */   
/*      */   int countOfWhitespace();
/*      */   
/*      */   int countOfNotWhitespace();
/*      */   
/*      */   int countOfAny(CharPredicate paramCharPredicate);
/*      */   
/*      */   int countOfAnyNot(CharPredicate paramCharPredicate);
/*      */   
/*      */   int countOfAny(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int countOfAnyNot(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int countOfAny(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int countOfAnyNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   int countLeadingColumns(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   Range trimStartRange(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   Range trimEndRange(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   Range trimRange(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   Range trimStartRange(CharPredicate paramCharPredicate);
/*      */   
/*      */   Range trimEndRange(CharPredicate paramCharPredicate);
/*      */   
/*      */   Range trimRange(CharPredicate paramCharPredicate);
/*      */   
/*      */   Range trimStartRange(int paramInt);
/*      */   
/*      */   Range trimEndRange(int paramInt);
/*      */   
/*      */   Range trimRange(int paramInt);
/*      */   
/*      */   Range trimStartRange();
/*      */   
/*      */   Range trimEndRange();
/*      */   
/*      */   Range trimRange();
/*      */   
/*      */   T trimStart(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   T trimEnd(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   T trim(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   T trimStart(int paramInt);
/*      */   
/*      */   T trimEnd(int paramInt);
/*      */   
/*      */   T trim(int paramInt);
/*      */   
/*      */   T trimStart(CharPredicate paramCharPredicate);
/*      */   
/*      */   T trimEnd(CharPredicate paramCharPredicate);
/*      */   
/*      */   T trim(CharPredicate paramCharPredicate);
/*      */   
/*      */   T trimStart();
/*      */   
/*      */   T trimEnd();
/*      */   
/*      */   T trim();
/*      */   
/*      */   T trimmedStart(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   T trimmedEnd(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   Pair<T, T> trimmed(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   T trimmedStart(int paramInt);
/*      */   
/*      */   T trimmedEnd(int paramInt);
/*      */   
/*      */   Pair<T, T> trimmed(int paramInt);
/*      */   
/*      */   T trimmedStart(CharPredicate paramCharPredicate);
/*      */   
/*      */   T trimmedEnd(CharPredicate paramCharPredicate);
/*      */   
/*      */   Pair<T, T> trimmed(CharPredicate paramCharPredicate);
/*      */   
/*      */   T trimmedStart();
/*      */   
/*      */   T trimmedEnd();
/*      */   
/*      */   Pair<T, T> trimmed();
/*      */   
/*      */   T padding(int paramInt, char paramChar);
/*      */   
/*      */   T padding(int paramInt);
/*      */   
/*      */   T padStart(int paramInt, char paramChar);
/*      */   
/*      */   T padEnd(int paramInt, char paramChar);
/*      */   
/*      */   T padStart(int paramInt);
/*      */   
/*      */   T padEnd(int paramInt);
/*      */   
/*      */   boolean isEmpty();
/*      */   
/*      */   boolean isBlank();
/*      */   
/*      */   boolean isNotEmpty();
/*      */   
/*      */   boolean isNotBlank();
/*      */   
/*      */   boolean isNull();
/*      */   
/*      */   boolean isNotNull();
/*      */   
/*      */   T ifNull(T paramT);
/*      */   
/*      */   T ifNullEmptyAfter(T paramT);
/*      */   
/*      */   T ifNullEmptyBefore(T paramT);
/*      */   
/*      */   T nullIfEmpty();
/*      */   
/*      */   T nullIfBlank();
/*      */   
/*      */   T nullIf(boolean paramBoolean);
/*      */   
/*      */   T nullIf(BiPredicate<? super T, ? super CharSequence> paramBiPredicate, CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNot(BiPredicate<? super T, ? super CharSequence> paramBiPredicate, CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIf(Predicate<? super CharSequence> paramPredicate, CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNot(Predicate<? super CharSequence> paramPredicate, CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIf(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNot(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfStartsWith(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNotStartsWith(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfEndsWith(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNotEndsWith(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfStartsWithIgnoreCase(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNotStartsWithIgnoreCase(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfEndsWithIgnoreCase(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNotEndsWithIgnoreCase(CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfStartsWith(boolean paramBoolean, CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNotStartsWith(boolean paramBoolean, CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfEndsWith(boolean paramBoolean, CharSequence... paramVarArgs);
/*      */   
/*      */   T nullIfNotEndsWith(boolean paramBoolean, CharSequence... paramVarArgs);
/*      */   
/*      */   int eolEndLength();
/*      */   
/*      */   int eolEndLength(int paramInt);
/*      */   
/*      */   int eolStartLength(int paramInt);
/*      */   
/*      */   Range eolEndRange(int paramInt);
/*      */   
/*      */   Range eolStartRange(int paramInt);
/*      */   
/*      */   T trimEOL();
/*      */   
/*      */   T trimmedEOL();
/*      */   
/*      */   int endOfDelimitedBy(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   int endOfDelimitedByAny(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int endOfDelimitedByAnyNot(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int startOfDelimitedBy(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   int startOfDelimitedByAny(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int startOfDelimitedByAnyNot(CharPredicate paramCharPredicate, int paramInt);
/*      */   
/*      */   int endOfLine(int paramInt);
/*      */   
/*      */   int endOfLineAnyEOL(int paramInt);
/*      */   
/*      */   int startOfLine(int paramInt);
/*      */   
/*      */   int startOfLineAnyEOL(int paramInt);
/*      */   
/*      */   Range lineRangeAt(int paramInt);
/*      */   
/*      */   Range lineRangeAtAnyEOL(int paramInt);
/*      */   
/*      */   T lineAt(int paramInt);
/*      */   
/*      */   T lineAtAnyEOL(int paramInt);
/*      */   
/*      */   T trimTailBlankLines();
/*      */   
/*      */   T trimLeadBlankLines();
/*      */   
/*      */   Range leadingBlankLinesRange(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   Range trailingBlankLinesRange(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   Range leadingBlankLinesRange();
/*      */   
/*      */   Range leadingBlankLinesRange(int paramInt);
/*      */   
/*      */   Range leadingBlankLinesRange(int paramInt1, int paramInt2);
/*      */   
/*      */   Range trailingBlankLinesRange();
/*      */   
/*      */   Range trailingBlankLinesRange(int paramInt);
/*      */   
/*      */   Range trailingBlankLinesRange(int paramInt1, int paramInt2);
/*      */   
/*      */   List<Range> blankLinesRemovedRanges();
/*      */   
/*      */   List<Range> blankLinesRemovedRanges(int paramInt);
/*      */   
/*      */   List<Range> blankLinesRemovedRanges(int paramInt1, int paramInt2);
/*      */   
/*      */   List<Range> blankLinesRemovedRanges(CharPredicate paramCharPredicate, int paramInt1, int paramInt2);
/*      */   
/*      */   T trimToEndOfLine(CharPredicate paramCharPredicate, boolean paramBoolean, int paramInt);
/*      */   
/*      */   T trimToEndOfLine(boolean paramBoolean, int paramInt);
/*      */   
/*      */   T trimToEndOfLine(boolean paramBoolean);
/*      */   
/*      */   T trimToEndOfLine(int paramInt);
/*      */   
/*      */   T trimToEndOfLine();
/*      */   
/*      */   T trimToStartOfLine(CharPredicate paramCharPredicate, boolean paramBoolean, int paramInt);
/*      */   
/*      */   T trimToStartOfLine(boolean paramBoolean, int paramInt);
/*      */   
/*      */   T trimToStartOfLine(boolean paramBoolean);
/*      */   
/*      */   T trimToStartOfLine(int paramInt);
/*      */   
/*      */   T trimToStartOfLine();
/*      */   
/*      */   String normalizeEOL();
/*      */   
/*      */   String normalizeEndWithEOL();
/*      */   
/*      */   boolean matches(CharSequence paramCharSequence);
/*      */   
/*      */   boolean matchesIgnoreCase(CharSequence paramCharSequence);
/*      */   
/*      */   boolean matches(CharSequence paramCharSequence, boolean paramBoolean);
/*      */   
/*      */   boolean equalsIgnoreCase(Object paramObject);
/*      */   
/*      */   boolean equals(Object paramObject, boolean paramBoolean);
/*      */   
/*      */   boolean matchChars(CharSequence paramCharSequence);
/*      */   
/*      */   boolean matchCharsIgnoreCase(CharSequence paramCharSequence);
/*      */   
/*      */   boolean matchChars(CharSequence paramCharSequence, boolean paramBoolean);
/*      */   
/*      */   boolean matchChars(CharSequence paramCharSequence, int paramInt, boolean paramBoolean);
/*      */   
/*      */   boolean matchChars(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   boolean matchCharsIgnoreCase(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   int matchedCharCount(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
/*      */   
/*      */   int matchedCharCount(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean);
/*      */   
/*      */   int matchedCharCount(CharSequence paramCharSequence, int paramInt, boolean paramBoolean);
/*      */   
/*      */   int matchedCharCount(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   int matchedCharCount(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   int matchedCharCountIgnoreCase(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   int matchedCharCountIgnoreCase(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   boolean matchCharsReversed(CharSequence paramCharSequence, int paramInt, boolean paramBoolean);
/*      */   
/*      */   boolean matchCharsReversed(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   boolean matchCharsReversedIgnoreCase(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   int matchedCharCountReversed(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean);
/*      */   
/*      */   int matchedCharCountReversed(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   int matchedCharCountReversedIgnoreCase(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   int matchedCharCountReversed(CharSequence paramCharSequence, int paramInt, boolean paramBoolean);
/*      */   
/*      */   int matchedCharCountReversed(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   int matchedCharCountReversedIgnoreCase(CharSequence paramCharSequence, int paramInt);
/*      */   
/*      */   boolean endsWith(CharSequence paramCharSequence);
/*      */   
/*      */   boolean endsWith(CharPredicate paramCharPredicate);
/*      */   
/*      */   boolean endsWithEOL();
/*      */   
/*      */   boolean endsWithAnyEOL();
/*      */   
/*      */   boolean endsWithSpace();
/*      */   
/*      */   boolean endsWithSpaceTab();
/*      */   
/*      */   boolean endsWithWhitespace();
/*      */   
/*      */   boolean endsWithIgnoreCase(CharSequence paramCharSequence);
/*      */   
/*      */   boolean endsWith(CharSequence paramCharSequence, boolean paramBoolean);
/*      */   
/*      */   boolean startsWith(CharSequence paramCharSequence);
/*      */   
/*      */   boolean startsWith(CharPredicate paramCharPredicate);
/*      */   
/*      */   boolean startsWithEOL();
/*      */   
/*      */   boolean startsWithAnyEOL();
/*      */   
/*      */   boolean startsWithSpace();
/*      */   
/*      */   boolean startsWithSpaceTab();
/*      */   
/*      */   boolean startsWithWhitespace();
/*      */   
/*      */   boolean startsWithIgnoreCase(CharSequence paramCharSequence);
/*      */   
/*      */   boolean startsWith(CharSequence paramCharSequence, boolean paramBoolean);
/*      */   
/*      */   T removeSuffix(CharSequence paramCharSequence);
/*      */   
/*      */   T removeSuffixIgnoreCase(CharSequence paramCharSequence);
/*      */   
/*      */   T removeSuffix(CharSequence paramCharSequence, boolean paramBoolean);
/*      */   
/*      */   T removePrefix(CharSequence paramCharSequence);
/*      */   
/*      */   T removePrefixIgnoreCase(CharSequence paramCharSequence);
/*      */   
/*      */   T removePrefix(CharSequence paramCharSequence, boolean paramBoolean);
/*      */   
/*      */   T removeProperSuffix(CharSequence paramCharSequence);
/*      */   
/*      */   T removeProperSuffixIgnoreCase(CharSequence paramCharSequence);
/*      */   
/*      */   T removeProperSuffix(CharSequence paramCharSequence, boolean paramBoolean);
/*      */   
/*      */   T removeProperPrefix(CharSequence paramCharSequence);
/*      */   
/*      */   T removeProperPrefixIgnoreCase(CharSequence paramCharSequence);
/*      */   
/*      */   T removeProperPrefix(CharSequence paramCharSequence, boolean paramBoolean);
/*      */   
/*      */   T insert(int paramInt, CharSequence paramCharSequence);
/*      */   
/*      */   T delete(int paramInt1, int paramInt2);
/*      */   
/*      */   T replace(int paramInt1, int paramInt2, CharSequence paramCharSequence);
/*      */   
/*      */   T replace(CharSequence paramCharSequence1, CharSequence paramCharSequence2);
/*      */   
/*      */   T toLowerCase();
/*      */   
/*      */   T toUpperCase();
/*      */   
/*      */   T toMapped(CharMapper paramCharMapper);
/*      */   
/*      */   T toNbSp();
/*      */   
/*      */   T toSpc();
/*      */   
/*      */   String toVisibleWhitespaceString();
/*      */   
/*      */   List<T> splitList(CharSequence paramCharSequence, int paramInt1, int paramInt2, CharPredicate paramCharPredicate);
/*      */   
/*      */   List<T> splitList(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   List<T> splitList(CharSequence paramCharSequence);
/*      */   
/*      */   T[] split(CharSequence paramCharSequence, int paramInt1, int paramInt2, CharPredicate paramCharPredicate);
/*      */   
/*      */   T[] split(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*      */   
/*      */   T[] split(CharSequence paramCharSequence);
/*      */   
/*      */   List<T> splitList(CharSequence paramCharSequence, int paramInt, boolean paramBoolean, CharPredicate paramCharPredicate);
/*      */   
/*      */   List<T> splitList(CharSequence paramCharSequence, boolean paramBoolean, CharPredicate paramCharPredicate);
/*      */   
/*      */   T[] split(CharSequence paramCharSequence, int paramInt, boolean paramBoolean, CharPredicate paramCharPredicate);
/*      */   
/*      */   T[] split(CharSequence paramCharSequence, boolean paramBoolean, CharPredicate paramCharPredicate);
/*      */   
/*      */   T[] splitEOL();
/*      */   
/*      */   T[] splitEOL(boolean paramBoolean);
/*      */   
/*      */   List<T> splitListEOL();
/*      */   
/*      */   List<T> splitListEOL(boolean paramBoolean);
/*      */   
/*      */   List<T> splitListEOL(boolean paramBoolean, CharPredicate paramCharPredicate);
/*      */   
/*      */   int[] indexOfAll(CharSequence paramCharSequence);
/*      */   
/*      */   T prefixWith(CharSequence paramCharSequence);
/*      */   
/*      */   T suffixWith(CharSequence paramCharSequence);
/*      */   
/*      */   T prefixOnceWith(CharSequence paramCharSequence);
/*      */   
/*      */   T suffixOnceWith(CharSequence paramCharSequence);
/*      */   
/*      */   T appendEOL();
/*      */   
/*      */   T suffixWithEOL();
/*      */   
/*      */   T prefixWithEOL();
/*      */   
/*      */   T prefixOnceWithEOL();
/*      */   
/*      */   T suffixOnceWithEOL();
/*      */   
/*      */   T appendSpace();
/*      */   
/*      */   T suffixWithSpace();
/*      */   
/*      */   T prefixWithSpace();
/*      */   
/*      */   T appendSpaces(int paramInt);
/*      */   
/*      */   T suffixWithSpaces(int paramInt);
/*      */   
/*      */   T prefixWithSpaces(int paramInt);
/*      */   
/*      */   T prefixOnceWithSpace();
/*      */   
/*      */   T suffixOnceWithSpace();
/*      */   
/*      */   T appendTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper, int paramInt1, int paramInt2);
/*      */   
/*      */   T appendTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper);
/*      */   
/*      */   T appendTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper, int paramInt);
/*      */   
/*      */   T appendTo(StringBuilder paramStringBuilder, int paramInt1, int paramInt2);
/*      */   
/*      */   T appendTo(StringBuilder paramStringBuilder);
/*      */   
/*      */   T appendTo(StringBuilder paramStringBuilder, int paramInt);
/*      */   
/*      */   T appendRangesTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper, Range... paramVarArgs);
/*      */   
/*      */   T appendRangesTo(StringBuilder paramStringBuilder, Range... paramVarArgs);
/*      */   
/*      */   T appendRangesTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper, Iterable<? extends Range> paramIterable);
/*      */   
/*      */   T appendRangesTo(StringBuilder paramStringBuilder, Iterable<? extends Range> paramIterable);
/*      */   
/*      */   T extractRanges(Range... paramVarArgs);
/*      */   
/*      */   T extractRanges(Iterable<Range> paramIterable);
/*      */   
/*      */   T append(CharSequence... paramVarArgs);
/*      */   
/*      */   T append(Iterable<? extends CharSequence> paramIterable);
/*      */   
/*      */   Pair<Integer, Integer> lineColumnAtIndex(int paramInt);
/*      */   
/*      */   int columnAtIndex(int paramInt);
/*      */   
/*      */   boolean isCharAt(int paramInt, CharPredicate paramCharPredicate);
/*      */   
/*      */   String toStringOrNull();
/*      */   
/*      */   boolean isIn(String[] paramArrayOfString);
/*      */   
/*      */   boolean isIn(Collection<? extends CharSequence> paramCollection);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\IRichSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */