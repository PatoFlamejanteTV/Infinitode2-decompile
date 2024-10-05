/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface BasedSequence
/*     */   extends BasedOptionsHolder, IRichSequence<BasedSequence>
/*     */ {
/*  29 */   public static final BasedSequence NULL = new EmptyBasedSequence();
/*  30 */   public static final BasedSequence EMPTY = new EmptyBasedSequence();
/*  31 */   public static final BasedSequence EOL = CharSubSequence.of("\n");
/*  32 */   public static final BasedSequence SPACE = CharSubSequence.of(" ");
/*  33 */   public static final List<BasedSequence> EMPTY_LIST = new ArrayList<>();
/*  34 */   public static final BasedSequence[] EMPTY_ARRAY = new BasedSequence[0];
/*  35 */   public static final BasedSequence[] EMPTY_SEGMENTS = new BasedSequence[0];
/*  36 */   public static final BasedSequence LINE_SEP = CharSubSequence.of(SequenceUtils.LINE_SEP);
/*     */ 
/*     */   
/*     */   static BasedSequence of(CharSequence paramCharSequence) {
/*  40 */     return BasedSequenceImpl.create(paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   static BasedSequence of(CharSequence paramCharSequence, int paramInt) {
/*  46 */     return of(paramCharSequence).subSequence(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   static BasedSequence of(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  52 */     return of(paramCharSequence).subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   static BasedSequence ofSpaces(int paramInt) {
/*  57 */     return of(RepeatedSequence.ofSpaces(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   static BasedSequence repeatOf(char paramChar, int paramInt) {
/*  62 */     return of(RepeatedSequence.repeatOf(String.valueOf(paramChar), 0, paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   static BasedSequence repeatOf(CharSequence paramCharSequence, int paramInt) {
/*  67 */     return of(RepeatedSequence.repeatOf(paramCharSequence, 0, paramCharSequence.length() * paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   static BasedSequence repeatOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  72 */     return of(RepeatedSequence.repeatOf(paramCharSequence, paramInt1, paramInt2));
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
/*     */   SequenceBuilder getBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object getBase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence getBaseSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getStartOffset();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getEndOffset();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getIndexOffset(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SegmentTree getSegmentTree();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Range getSourceRange();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence subSequence(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence baseSubSequence(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence baseSubSequence(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   char safeBaseCharAt(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isBaseCharAt(int paramInt, CharPredicate paramCharPredicate);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence getEmptyPrefix();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence getEmptySuffix();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String unescape();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String unescapeNoEntities();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence unescape(ReplacedTextMapper paramReplacedTextMapper);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence normalizeEOL(ReplacedTextMapper paramReplacedTextMapper);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence normalizeEndWithEOL(ReplacedTextMapper paramReplacedTextMapper);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isContinuedBy(BasedSequence paramBasedSequence);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isContinuationOf(BasedSequence paramBasedSequence);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence spliceAtEnd(BasedSequence paramBasedSequence);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean containsAllOf(BasedSequence paramBasedSequence);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean containsSomeOf(BasedSequence paramBasedSequence);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence prefixOf(BasedSequence paramBasedSequence);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence suffixOf(BasedSequence paramBasedSequence);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence intersect(BasedSequence paramBasedSequence);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BasedSequence extendByAny(CharPredicate paramCharPredicate, int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   default BasedSequence extendToAny(CharPredicate paramCharPredicate, int paramInt) {
/* 362 */     return extendByAnyNot(paramCharPredicate, paramInt);
/*     */   } BasedSequence extendByAny(CharPredicate paramCharPredicate); BasedSequence extendByOneOfAny(CharPredicate paramCharPredicate); BasedSequence extendByAnyNot(CharPredicate paramCharPredicate, int paramInt); BasedSequence extendByAnyNot(CharPredicate paramCharPredicate); BasedSequence extendByOneOfAnyNot(CharPredicate paramCharPredicate); BasedSequence extendToEndOfLine(CharPredicate paramCharPredicate, boolean paramBoolean); BasedSequence extendToEndOfLine(CharPredicate paramCharPredicate); BasedSequence extendToEndOfLine(boolean paramBoolean); BasedSequence extendToEndOfLine(); BasedSequence extendToStartOfLine(CharPredicate paramCharPredicate, boolean paramBoolean); BasedSequence extendToStartOfLine(CharPredicate paramCharPredicate); BasedSequence extendToStartOfLine(boolean paramBoolean); BasedSequence extendToStartOfLine(); BasedSequence prefixWithIndent(int paramInt); BasedSequence prefixWithIndent();
/*     */   Pair<Integer, Integer> baseLineColumnAtIndex(int paramInt);
/*     */   Range baseLineRangeAtIndex(int paramInt);
/*     */   @Deprecated
/*     */   default BasedSequence extendToAny(CharPredicate paramCharPredicate) {
/* 368 */     return extendByAnyNot(paramCharPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int baseEndOfLine(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   int baseEndOfLineAnyEOL(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   int baseStartOfLine(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   int baseStartOfLineAnyEOL(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   int baseColumnAtIndex(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   Pair<Integer, Integer> baseLineColumnAtStart();
/*     */ 
/*     */ 
/*     */   
/*     */   Pair<Integer, Integer> baseLineColumnAtEnd();
/*     */ 
/*     */ 
/*     */   
/*     */   int baseEndOfLine();
/*     */ 
/*     */ 
/*     */   
/*     */   int baseEndOfLineAnyEOL();
/*     */ 
/*     */ 
/*     */   
/*     */   int baseStartOfLine();
/*     */ 
/*     */   
/*     */   int baseStartOfLineAnyEOL();
/*     */ 
/*     */   
/*     */   Range baseLineRangeAtStart();
/*     */ 
/*     */   
/*     */   Range baseLineRangeAtEnd();
/*     */ 
/*     */   
/*     */   int baseColumnAtEnd();
/*     */ 
/*     */   
/*     */   int baseColumnAtStart();
/*     */ 
/*     */   
/*     */   public static class EmptyBasedSequence
/*     */     extends BasedSequenceImpl
/*     */   {
/*     */     public EmptyBasedSequence() {
/* 431 */       super(0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getOptionFlags() {
/* 436 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean allOptions(int param1Int) {
/* 441 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean anyOptions(int param1Int) {
/* 446 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public <T> T getOption(DataKeyBase<T> param1DataKeyBase) {
/* 451 */       return (T)param1DataKeyBase.get(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public DataHolder getOptions() {
/* 456 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public int length() {
/* 461 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public char charAt(int param1Int) {
/* 466 */       throw new StringIndexOutOfBoundsException("EMPTY sequence has no characters");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getIndexOffset(int param1Int) {
/* 471 */       SequenceUtils.validateIndexInclusiveEnd(param1Int, length());
/* 472 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BasedSequence subSequence(int param1Int1, int param1Int2) {
/* 478 */       SequenceUtils.validateStartEnd(param1Int1, param1Int2, length());
/* 479 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BasedSequence baseSubSequence(int param1Int1, int param1Int2) {
/* 485 */       return subSequence(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BasedSequence getBaseSequence() {
/* 491 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BasedSequence getBase() {
/* 497 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getStartOffset() {
/* 502 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getEndOffset() {
/* 507 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Range getSourceRange() {
/* 513 */       return Range.NULL;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\BasedSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */