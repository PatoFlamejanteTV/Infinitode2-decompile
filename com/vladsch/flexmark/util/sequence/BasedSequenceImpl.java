/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.builder.BasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
/*     */ 
/*     */ public abstract class BasedSequenceImpl
/*     */   extends IRichSequenceBase<BasedSequence>
/*     */   implements BasedSequence {
/*     */   public static BasedSequence firstNonNull(BasedSequence... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  19 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) {
/*  20 */       BasedSequence basedSequence; if ((basedSequence = paramVarArgs[b]) != null && basedSequence != NULL) return basedSequence; 
/*     */       b++;
/*     */     } 
/*  23 */     return NULL;
/*     */   }
/*     */   
/*     */   public BasedSequenceImpl(int paramInt) {
/*  27 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence[] emptyArray() {
/*  33 */     return EMPTY_ARRAY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence nullSequence() {
/*  39 */     return NULL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence sequenceOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  45 */     return of(paramCharSequence).subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SequenceBuilder getBuilder() {
/*  52 */     return SequenceBuilder.emptyBuilder(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder) {
/*  57 */     paramIBasedSegmentBuilder.append(getStartOffset(), getEndOffset());
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
/*     */   public SegmentTree getSegmentTree() {
/*  69 */     BasedSegmentBuilder basedSegmentBuilder = BasedSegmentBuilder.emptyBuilder(getBaseSequence());
/*  70 */     addSegments((IBasedSegmentBuilder<?>)basedSegmentBuilder);
/*  71 */     return SegmentTree.build(basedSegmentBuilder.getSegments(), basedSegmentBuilder.getText());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence toMapped(CharMapper paramCharMapper) {
/*  77 */     return MappedBasedSequence.mappedOf(this, paramCharMapper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence baseSubSequence(int paramInt) {
/*  83 */     return baseSubSequence(paramInt, getBaseSequence().getEndOffset());
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence baseSubSequence(int paramInt1, int paramInt2) {
/*  88 */     return getBaseSequence().subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public char safeCharAt(int paramInt) {
/*  93 */     return (paramInt < 0 || paramInt >= length()) ? Character.MIN_VALUE : charAt(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public char safeBaseCharAt(int paramInt) {
/*  98 */     int i = getStartOffset();
/*  99 */     if (paramInt >= i && paramInt < i + length()) return charAt(paramInt - i);
/*     */     
/* 101 */     return getBaseSequence().safeCharAt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBaseCharAt(int paramInt, CharPredicate paramCharPredicate) {
/* 107 */     return paramCharPredicate.test(safeBaseCharAt(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getEmptyPrefix() {
/* 113 */     return subSequence(0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getEmptySuffix() {
/* 119 */     return subSequence(length());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toStringOrNull() {
/* 124 */     return isNull() ? null : toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String unescape() {
/* 130 */     return Escaping.unescapeString(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String unescapeNoEntities() {
/* 136 */     return Escaping.unescapeString(this, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence unescape(ReplacedTextMapper paramReplacedTextMapper) {
/* 142 */     return Escaping.unescape(this, paramReplacedTextMapper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence normalizeEOL(ReplacedTextMapper paramReplacedTextMapper) {
/* 148 */     return Escaping.normalizeEOL(this, paramReplacedTextMapper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence normalizeEndWithEOL(ReplacedTextMapper paramReplacedTextMapper) {
/* 154 */     return Escaping.normalizeEndWithEOL(this, paramReplacedTextMapper);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContinuedBy(BasedSequence paramBasedSequence) {
/* 159 */     return (paramBasedSequence.length() > 0 && length() > 0 && paramBasedSequence.getBase() == getBase() && paramBasedSequence.getStartOffset() == getEndOffset());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContinuationOf(BasedSequence paramBasedSequence) {
/* 164 */     return (paramBasedSequence.length() > 0 && length() > 0 && paramBasedSequence.getBase() == getBase() && paramBasedSequence.getEndOffset() == getStartOffset());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence spliceAtEnd(BasedSequence paramBasedSequence) {
/* 170 */     if (paramBasedSequence.isEmpty())
/* 171 */       return this; 
/* 172 */     if (isEmpty()) {
/* 173 */       return paramBasedSequence;
/*     */     }
/* 175 */     assert isContinuedBy(paramBasedSequence) : "sequence[" + getStartOffset() + ", " + getEndOffset() + "] is not continued by other[" + paramBasedSequence.getStartOffset() + ", " + paramBasedSequence.getEndOffset() + "]";
/* 176 */     return baseSubSequence(getStartOffset(), paramBasedSequence.getEndOffset());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAllOf(BasedSequence paramBasedSequence) {
/* 181 */     return (getBase() == paramBasedSequence.getBase() && paramBasedSequence.getStartOffset() >= getStartOffset() && paramBasedSequence.getEndOffset() <= getEndOffset());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsSomeOf(BasedSequence paramBasedSequence) {
/* 186 */     return (getBase() == paramBasedSequence.getBase() && getStartOffset() < paramBasedSequence.getEndOffset() && getEndOffset() > paramBasedSequence.getStartOffset());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence intersect(BasedSequence paramBasedSequence) {
/* 192 */     if (getBase() != paramBasedSequence.getBase()) return BasedSequence.NULL; 
/* 193 */     if (paramBasedSequence.getEndOffset() <= getStartOffset()) return subSequence(0, 0); 
/* 194 */     if (paramBasedSequence.getStartOffset() >= getEndOffset()) return subSequence(length(), length()); 
/* 195 */     return baseSubSequence(Utils.max(getStartOffset(), new int[] { paramBasedSequence.getStartOffset() }), Utils.min(getEndOffset(), new int[] { paramBasedSequence.getEndOffset() }));
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence extendByAny(CharPredicate paramCharPredicate) {
/* 200 */     return extendByAny(paramCharPredicate, Integer.MAX_VALUE - getEndOffset()); } public BasedSequence extendByOneOfAny(CharPredicate paramCharPredicate) {
/* 201 */     return extendByAny(paramCharPredicate, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence extendByAny(CharPredicate paramCharPredicate, int paramInt) {
/*     */     int i;
/* 208 */     return ((i = getBaseSequence().countLeading(paramCharPredicate, getEndOffset(), getEndOffset() + paramInt)) == 0) ? this : baseSubSequence(getStartOffset(), getEndOffset() + i);
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence extendByAnyNot(CharPredicate paramCharPredicate) {
/* 213 */     return extendByAnyNot(paramCharPredicate, Integer.MAX_VALUE - getEndOffset()); } public BasedSequence extendByOneOfAnyNot(CharPredicate paramCharPredicate) {
/* 214 */     return extendByAnyNot(paramCharPredicate, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence extendByAnyNot(CharPredicate paramCharPredicate, int paramInt) {
/*     */     int i;
/* 221 */     return ((i = getBaseSequence().countLeadingNot(paramCharPredicate, getEndOffset(), getEndOffset() + paramInt)) == getBaseSequence().length() - getEndOffset()) ? this : baseSubSequence(getStartOffset(), getEndOffset() + i + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence extendToEndOfLine(CharPredicate paramCharPredicate) {
/* 226 */     return extendToEndOfLine(paramCharPredicate, false); }
/* 227 */   public final BasedSequence extendToEndOfLine(boolean paramBoolean) { return extendToEndOfLine(CharPredicate.EOL, paramBoolean); }
/* 228 */   public final BasedSequence extendToEndOfLine() { return extendToEndOfLine(CharPredicate.EOL, false); }
/* 229 */   public final BasedSequence extendToStartOfLine(CharPredicate paramCharPredicate) { return extendToStartOfLine(paramCharPredicate, false); }
/* 230 */   public final BasedSequence extendToStartOfLine(boolean paramBoolean) { return extendToStartOfLine(CharPredicate.EOL, paramBoolean); } public final BasedSequence extendToStartOfLine() {
/* 231 */     return extendToStartOfLine(CharPredicate.EOL, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence extendToEndOfLine(CharPredicate paramCharPredicate, boolean paramBoolean) {
/* 237 */     int i = getEndOffset();
/*     */ 
/*     */     
/* 240 */     if (paramCharPredicate.test(lastChar())) return this;
/*     */     
/*     */     BasedSequence basedSequence;
/* 243 */     int j = (basedSequence = getBaseSequence()).endOfLine(i);
/*     */     
/* 245 */     if (paramBoolean) {
/* 246 */       j = Math.min(basedSequence.length(), j + Math.min(basedSequence.eolStartLength(j), 1));
/*     */     }
/*     */     
/* 249 */     if (j != i) {
/* 250 */       return basedSequence.subSequence(getStartOffset(), j);
/*     */     }
/* 252 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence extendToStartOfLine(CharPredicate paramCharPredicate, boolean paramBoolean) {
/* 258 */     int i = getStartOffset();
/*     */ 
/*     */     
/* 261 */     if (paramCharPredicate.test(firstChar())) return this;
/*     */     
/*     */     BasedSequence basedSequence;
/* 264 */     int j = (basedSequence = getBaseSequence()).startOfLine(i);
/*     */     
/* 266 */     if (paramBoolean) {
/* 267 */       j = Math.max(0, j - Math.min(basedSequence.eolEndLength(j), 1));
/*     */     }
/*     */     
/* 270 */     if (j != i) {
/* 271 */       return basedSequence.subSequence(j, getEndOffset());
/*     */     }
/* 273 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence prefixWith(CharSequence paramCharSequence) {
/* 279 */     return (paramCharSequence == null || paramCharSequence.length() == 0) ? this : PrefixedSubSequence.prefixOf(paramCharSequence.toString(), this);
/*     */   }
/*     */ 
/*     */   
/*     */   public final BasedSequence prefixWithIndent() {
/* 284 */     return prefixWithIndent(2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence prefixWithIndent(int paramInt) {
/* 290 */     int i = getStartOffset();
/* 291 */     int j = getStartOffset();
/* 292 */     int k = 0;
/* 293 */     int m = 0;
/* 294 */     int n = 0;
/*     */ 
/*     */     
/* 297 */     while (j >= 0) {
/*     */       char c;
/* 299 */       if ((c = getBaseSequence().charAt(j)) == '\t') { n = 1; }
/* 300 */       else if (c == '\n')
/* 301 */       { j++;
/*     */         break; }
/*     */       
/* 304 */       j--;
/*     */     } 
/*     */     
/* 307 */     if (j < 0) j = 0;
/*     */     
/* 309 */     if (j < i) {
/* 310 */       if (n) {
/*     */         
/* 312 */         int[] arrayOfInt = new int[i - j];
/* 313 */         n = j;
/* 314 */         while (n < i) {
/* 315 */           if (getBaseSequence().charAt(n) == '\t') {
/* 316 */             arrayOfInt[n - j] = 4 - m % 4; m += 4 - m % 4;
/*     */           } else {
/* 318 */             arrayOfInt[n - j] = 1; m++;
/*     */           } 
/* 320 */           n++;
/*     */         } 
/*     */         
/* 323 */         while (k < paramInt && i > 0 && (getBaseSequence().charAt(i - 1) == ' ' || getBaseSequence().charAt(i - 1) == '\t') && (
/*     */           
/* 325 */           k = k + arrayOfInt[i - 1 - j]) <= paramInt) {
/* 326 */           i--;
/*     */         }
/*     */       } else {
/* 329 */         while (k < paramInt && i > 0 && (getBaseSequence().charAt(i - 1) == ' ' || getBaseSequence().charAt(i - 1) == '\t')) {
/* 330 */           k++;
/* 331 */           i--;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 336 */     return (i == getStartOffset()) ? this : baseSubSequence(i, getEndOffset());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence prefixOf(BasedSequence paramBasedSequence) {
/* 342 */     if (getBase() != paramBasedSequence.getBase()) return BasedSequence.NULL; 
/* 343 */     if (paramBasedSequence.getStartOffset() <= getStartOffset()) return subSequence(0, 0); 
/* 344 */     if (paramBasedSequence.getStartOffset() >= getEndOffset()) return this; 
/* 345 */     return baseSubSequence(getStartOffset(), paramBasedSequence.getStartOffset());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence suffixOf(BasedSequence paramBasedSequence) {
/* 351 */     if (getBase() != paramBasedSequence.getBase()) return BasedSequence.NULL; 
/* 352 */     if (paramBasedSequence.getEndOffset() >= getEndOffset()) return subSequence(length(), length()); 
/* 353 */     if (paramBasedSequence.getEndOffset() <= getStartOffset()) return this; 
/* 354 */     return baseSubSequence(paramBasedSequence.getEndOffset(), getEndOffset());
/*     */   }
/*     */ 
/*     */   
/*     */   public Range baseLineRangeAtIndex(int paramInt) {
/* 359 */     return getBaseSequence().lineRangeAt(paramInt); }
/* 360 */   public Pair<Integer, Integer> baseLineColumnAtIndex(int paramInt) { return getBaseSequence().lineColumnAtIndex(paramInt); }
/* 361 */   public int baseEndOfLine(int paramInt) { return getBaseSequence().endOfLine(paramInt); }
/* 362 */   public int baseEndOfLineAnyEOL(int paramInt) { return getBaseSequence().endOfLineAnyEOL(paramInt); }
/* 363 */   public int baseStartOfLine(int paramInt) { return getBaseSequence().startOfLine(paramInt); }
/* 364 */   public int baseStartOfLineAnyEOL(int paramInt) { return getBaseSequence().startOfLineAnyEOL(paramInt); } public int baseColumnAtIndex(int paramInt) {
/* 365 */     return getBaseSequence().columnAtIndex(paramInt);
/*     */   }
/* 367 */   public int baseEndOfLine() { return baseEndOfLine(getEndOffset()); }
/* 368 */   public int baseEndOfLineAnyEOL() { return baseEndOfLineAnyEOL(getEndOffset()); }
/* 369 */   public int baseColumnAtEnd() { return baseColumnAtIndex(getEndOffset()); }
/* 370 */   public Range baseLineRangeAtEnd() { return baseLineRangeAtIndex(getEndOffset()); } public Pair<Integer, Integer> baseLineColumnAtEnd() {
/* 371 */     return baseLineColumnAtIndex(getEndOffset());
/*     */   }
/* 373 */   public int baseStartOfLine() { return baseStartOfLine(getStartOffset()); }
/* 374 */   public int baseStartOfLineAnyEOL() { return baseStartOfLineAnyEOL(getStartOffset()); }
/* 375 */   public int baseColumnAtStart() { return baseColumnAtIndex(getStartOffset()); }
/* 376 */   public Range baseLineRangeAtStart() { return baseLineRangeAtIndex(getStartOffset()); } public Pair<Integer, Integer> baseLineColumnAtStart() {
/* 377 */     return baseLineColumnAtIndex(getStartOffset());
/*     */   }
/*     */   
/*     */   static BasedSequence create(CharSequence paramCharSequence) {
/* 381 */     if (paramCharSequence == null) return BasedSequence.NULL;
/*     */     
/* 383 */     if (paramCharSequence instanceof BasedSequence) {
/* 384 */       return (BasedSequence)paramCharSequence;
/*     */     }
/* 386 */     return SubSequence.create(paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static BasedSequence of(CharSequence paramCharSequence) {
/* 392 */     return BasedSequence.of(paramCharSequence);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static BasedSequence of(CharSequence paramCharSequence, int paramInt) {
/* 397 */     return BasedSequence.of(paramCharSequence).subSequence(paramInt);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static BasedSequence of(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 402 */     return BasedSequence.of(paramCharSequence).subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\BasedSequenceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */