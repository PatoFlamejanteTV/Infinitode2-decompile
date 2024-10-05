/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ 
/*     */ public class Range
/*     */ {
/*   6 */   public static final Range NULL = new Range(2147483647, -2147483648);
/*   7 */   public static final Range EMPTY = new Range(0, 0); private final int start;
/*     */   private final int end;
/*     */   
/*     */   public static Range of(int paramInt1, int paramInt2) {
/*  11 */     return (paramInt1 == NULL.start && paramInt2 == NULL.end) ? NULL : new Range(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Range emptyOf(int paramInt) {
/*  16 */     return new Range(paramInt, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Range ofLength(int paramInt1, int paramInt2) {
/*  21 */     return new Range(paramInt1, paramInt1 + paramInt2);
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
/*     */   protected Range(int paramInt1, int paramInt2) {
/*  34 */     this.start = paramInt1;
/*  35 */     this.end = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Range(Range paramRange) {
/*  40 */     this.start = paramRange.start;
/*  41 */     this.end = paramRange.end;
/*     */   }
/*     */   
/*     */   public int getStart() {
/*  45 */     return this.start; } public int getEnd() {
/*  46 */     return this.end;
/*     */   }
/*     */   
/*  49 */   public int component1() { return this.start; } public int component2() {
/*  50 */     return this.end;
/*     */   }
/*  52 */   public int getStartOffset() { return this.start; } public int getEndOffset() {
/*  53 */     return this.end;
/*     */   }
/*     */ 
/*     */   
/*     */   public Range withStart(int paramInt) {
/*  58 */     return (paramInt == this.start) ? this : of(paramInt, this.end); }
/*  59 */   public Range withEnd(int paramInt) { return (paramInt == this.end) ? this : of(this.start, paramInt); }
/*  60 */   public Range endMinus(int paramInt) { return (paramInt == 0) ? this : of(this.start, this.end - paramInt); }
/*  61 */   public Range endPlus(int paramInt) { return (paramInt == 0) ? this : of(this.start, this.end + paramInt); }
/*  62 */   public Range startMinus(int paramInt) { return (paramInt == 0) ? this : of(this.start - paramInt, this.end); }
/*  63 */   public Range startPlus(int paramInt) { return (paramInt == 0) ? this : of(this.start + paramInt, this.end); }
/*  64 */   public Range withRange(int paramInt1, int paramInt2) { return (paramInt1 == this.start && paramInt2 == this.end) ? this : of(paramInt1, paramInt2); }
/*  65 */   public Range shiftLeft(int paramInt) { return (paramInt == 0) ? this : of(this.start - paramInt, this.end - paramInt); } public Range shiftRight(int paramInt) {
/*  66 */     return (paramInt == 0) ? this : of(this.start + paramInt, this.end + paramInt);
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
/*     */   public int getSpan() {
/*  78 */     return isNull() ? 0 : (this.end - this.start);
/*     */   }
/*     */   
/*  81 */   public boolean isNull() { return (this.start == NULL.start && this.end == NULL.end); }
/*  82 */   public boolean isNotNull() { return !isNull(); }
/*  83 */   public boolean isEmpty() { return (this.start >= this.end); } public boolean isNotEmpty() {
/*  84 */     return (this.start < this.end);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Range paramRange) {
/*  89 */     return (this.end >= paramRange.end && this.start <= paramRange.start); } public boolean doesContain(Range paramRange) {
/*  90 */     return (this.end >= paramRange.end && this.start <= paramRange.start);
/*     */   }
/*  92 */   public boolean contains(int paramInt) { return (this.start <= paramInt && paramInt < this.end); } public boolean doesContain(int paramInt) {
/*  93 */     return (this.start <= paramInt && paramInt < this.end);
/*     */   }
/*  95 */   public boolean contains(int paramInt1, int paramInt2) { return (this.start <= paramInt1 && paramInt2 <= this.end); } public boolean doesContain(int paramInt1, int paramInt2) {
/*  96 */     return (this.start <= paramInt1 && paramInt2 <= this.end);
/*     */   }
/*  98 */   public boolean overlaps(Range paramRange) { return (paramRange.end > this.start && paramRange.start < this.end); }
/*  99 */   public boolean doesOverlap(Range paramRange) { return (paramRange.end > this.start && paramRange.start < this.end); } public boolean doesNotOverlap(Range paramRange) {
/* 100 */     return (paramRange.end <= this.start || paramRange.start >= this.end);
/*     */   }
/* 102 */   public boolean overlapsOrAdjacent(Range paramRange) { return (paramRange.end >= this.start && paramRange.start <= this.end); }
/* 103 */   public boolean doesOverlapOrAdjacent(Range paramRange) { return (paramRange.end >= this.start && paramRange.start <= this.end); }
/* 104 */   public boolean doesNotOverlapOrAdjacent(Range paramRange) { return (paramRange.end < this.start || paramRange.start > this.end); } public boolean doesNotOverlapNorAdjacent(Range paramRange) {
/* 105 */     return (paramRange.end < this.start || paramRange.start > this.end);
/*     */   }
/* 107 */   public boolean properlyContains(Range paramRange) { return (this.end > paramRange.end && this.start < paramRange.start); } public boolean doesProperlyContain(Range paramRange) {
/* 108 */     return (this.end > paramRange.end && this.start < paramRange.start);
/*     */   }
/* 110 */   public boolean isAdjacent(int paramInt) { return (paramInt == this.start - 1 || paramInt == this.end); }
/* 111 */   public boolean isAdjacentAfter(int paramInt) { return (this.start - 1 == paramInt); }
/* 112 */   public boolean isAdjacentBefore(int paramInt) { return (this.end == paramInt); }
/* 113 */   public boolean isAdjacent(Range paramRange) { return (this.start == paramRange.end || this.end == paramRange.start); }
/* 114 */   public boolean isAdjacentBefore(Range paramRange) { return (this.end == paramRange.start); } public boolean isAdjacentAfter(Range paramRange) {
/* 115 */     return (this.start == paramRange.end);
/*     */   }
/* 117 */   public boolean isContainedBy(Range paramRange) { return (paramRange.end >= this.end && paramRange.start <= this.start); }
/* 118 */   public boolean isContainedBy(int paramInt1, int paramInt2) { return (paramInt2 >= this.end && paramInt1 <= this.start); }
/* 119 */   public boolean isProperlyContainedBy(Range paramRange) { return (paramRange.end > this.end && paramRange.start < this.start); } public boolean isProperlyContainedBy(int paramInt1, int paramInt2) {
/* 120 */     return (paramInt2 > this.end && paramInt1 < this.start);
/*     */   } public boolean isEqual(Range paramRange) {
/* 122 */     return (this.end == paramRange.end && this.start == paramRange.start);
/*     */   }
/* 124 */   public boolean isValidIndex(int paramInt) { return (paramInt >= this.start && paramInt <= this.end); }
/* 125 */   public boolean isStart(int paramInt) { return (paramInt == this.start); }
/* 126 */   public boolean isEnd(int paramInt) { return (paramInt == this.end); } public boolean isLast(int paramInt) {
/* 127 */     return (paramInt >= this.start && paramInt == this.end - 1);
/*     */   }
/* 129 */   public boolean leadBy(int paramInt) { return (paramInt <= this.start); }
/* 130 */   public boolean leads(int paramInt) { return (this.end <= paramInt); }
/* 131 */   public boolean trailedBy(int paramInt) { return (this.end <= paramInt); } public boolean trails(int paramInt) {
/* 132 */     return (paramInt <= this.start);
/*     */   }
/*     */ 
/*     */   
/*     */   public Range intersect(Range paramRange) {
/* 137 */     int j = Math.max(this.start, paramRange.start);
/* 138 */     int i = Math.min(this.end, paramRange.end);
/*     */     
/* 140 */     if (j >= i) j = i; 
/* 141 */     return withRange(j, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public Range exclude(Range paramRange) {
/*     */     int i;
/* 147 */     if ((i = this.start) >= paramRange.start && i < paramRange.end) i = paramRange.end;
/*     */     
/*     */     int j;
/* 150 */     if ((j = this.end) <= paramRange.end && j > paramRange.start) j = paramRange.start;
/*     */     
/* 152 */     if (i >= j) i = j = 0; 
/* 153 */     return withRange(i, j);
/*     */   }
/*     */   
/*     */   public int compare(Range paramRange) {
/* 157 */     if (this.start < paramRange.start)
/* 158 */       return -1; 
/* 159 */     if (this.start > paramRange.start)
/* 160 */       return 1; 
/* 161 */     if (this.end > paramRange.end)
/* 162 */       return -1; 
/* 163 */     if (this.end < paramRange.end) {
/* 164 */       return 1;
/*     */     }
/* 166 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Range include(Range paramRange) {
/* 171 */     return paramRange.isNull() ? (isNull() ? NULL : this) : expandToInclude(paramRange);
/*     */   }
/*     */ 
/*     */   
/*     */   public Range include(int paramInt) {
/* 176 */     return include(paramInt, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Range include(int paramInt1, int paramInt2) {
/* 181 */     return isNull() ? of(paramInt1, paramInt2) : expandToInclude(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Range expandToInclude(Range paramRange) {
/* 186 */     return expandToInclude(paramRange.start, paramRange.end);
/*     */   }
/*     */ 
/*     */   
/*     */   public Range expandToInclude(int paramInt1, int paramInt2) {
/* 191 */     return withRange(Math.min(this.start, paramInt1), Math.max(this.end, paramInt2));
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
/*     */   @Deprecated
/*     */   public BasedSequence subSequence(CharSequence paramCharSequence) {
/* 204 */     return basedSubSequence(paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence basedSubSequence(CharSequence paramCharSequence) {
/* 209 */     return BasedSequence.of(paramCharSequence).subSequence(this.start, this.end);
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence basedSafeSubSequence(CharSequence paramCharSequence) {
/* 214 */     int i = Math.min(paramCharSequence.length(), this.end);
/* 215 */     return isNull() ? BasedSequence.NULL : BasedSequence.of(paramCharSequence).subSequence(Math.min(i, Math.max(0, this.start)), i);
/*     */   }
/*     */ 
/*     */   
/*     */   public RichSequence richSubSequence(CharSequence paramCharSequence) {
/* 220 */     return RichSequence.of(paramCharSequence.subSequence(this.start, this.end));
/*     */   }
/*     */ 
/*     */   
/*     */   public RichSequence richSafeSubSequence(CharSequence paramCharSequence) {
/* 225 */     int i = Math.min(paramCharSequence.length(), this.end);
/* 226 */     return isNull() ? RichSequence.NULL : RichSequence.of(paramCharSequence, Math.min(i, Math.max(0, this.start)), i);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence charSubSequence(CharSequence paramCharSequence) {
/* 231 */     return paramCharSequence.subSequence(this.start, this.end);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence safeSubSequence(CharSequence paramCharSequence) {
/* 236 */     int i = Math.min(paramCharSequence.length(), this.end);
/* 237 */     return isNull() ? paramCharSequence.subSequence(0, 0) : paramCharSequence.subSequence(Math.min(i, Math.max(0, this.start)), i);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 242 */     return "[" + this.start + ", " + this.end + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 247 */     if (this == paramObject) return true; 
/* 248 */     if (!(paramObject instanceof Range)) return false; 
/* 249 */     paramObject = paramObject;
/* 250 */     return (this.start == ((Range)paramObject).start && this.end == ((Range)paramObject).end);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 255 */     int i = this.start;
/*     */     
/* 257 */     return i = i * 31 + this.end;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\Range.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */