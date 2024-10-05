/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.collection.iteration.ArrayIterable;
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.ChangeCase;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
/*     */ import com.vladsch.flexmark.util.sequence.mappers.SpaceMapper;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.function.BiPredicate;
/*     */ import java.util.function.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class IRichSequenceBase<T extends IRichSequence<T>>
/*     */   implements IRichSequence<T>
/*     */ {
/*     */   private int hash;
/*     */   
/*     */   public IRichSequenceBase(int paramInt) {
/*  42 */     this.hash = paramInt;
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
/*     */   public final boolean equals(Object paramObject) {
/*  58 */     return SequenceUtils.equals(this, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/*     */     int i;
/*  70 */     if ((i = this.hash) == 0 && length() > 0) {
/*  71 */       i = SequenceUtils.hashCode(this);
/*  72 */       this.hash = i;
/*     */     } 
/*  74 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equalsIgnoreCase(Object paramObject) {
/*  80 */     return (this == paramObject || (paramObject instanceof CharSequence && ((CharSequence)paramObject).length() == length() && matchChars((CharSequence)paramObject, 0, true)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject, boolean paramBoolean) {
/*  86 */     return (this == paramObject || (paramObject instanceof CharSequence && ((CharSequence)paramObject).length() == length() && matchChars((CharSequence)paramObject, 0, paramBoolean)));
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(CharSequence paramCharSequence) {
/*  91 */     return SequenceUtils.compare(this, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T sequenceOf(CharSequence paramCharSequence) {
/*  97 */     return (paramCharSequence == null) ? nullSequence() : sequenceOf(paramCharSequence, 0, paramCharSequence.length());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T sequenceOf(CharSequence paramCharSequence, int paramInt) {
/* 103 */     return (paramCharSequence == null) ? nullSequence() : sequenceOf(paramCharSequence, paramInt, paramCharSequence.length());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T subSequence(int paramInt) {
/* 109 */     return subSequence(paramInt, length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T subSequence(Range paramRange) {
/* 120 */     return (T)(paramRange.isNull() ? this : (Object)subSequence(paramRange.getStart(), paramRange.getEnd()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T subSequenceBefore(Range paramRange) {
/* 131 */     return paramRange.isNull() ? nullSequence() : subSequence(0, paramRange.getStart());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T subSequenceAfter(Range paramRange) {
/* 142 */     return paramRange.isNull() ? nullSequence() : subSequence(paramRange.getEnd());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Pair<T, T> subSequenceBeforeAfter(Range paramRange) {
/* 152 */     return Pair.of(subSequenceBefore(paramRange), subSequenceAfter(paramRange));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T endSequence(int paramInt1, int paramInt2) {
/*     */     int i;
/* 159 */     paramInt1 = (i = length()) - paramInt1;
/*     */ 
/*     */     
/* 162 */     paramInt2 = Utils.rangeLimit(paramInt2 = i - paramInt2, 0, i);
/* 163 */     paramInt1 = Utils.rangeLimit(paramInt1, 0, paramInt2);
/* 164 */     return subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T endSequence(int paramInt) {
/* 170 */     return endSequence(paramInt, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final char endCharAt(int paramInt) {
/* 175 */     int i = length();
/* 176 */     if (paramInt < 0 || paramInt >= i) return Character.MIN_VALUE; 
/* 177 */     return charAt(i - paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T midSequence(int paramInt1, int paramInt2) {
/* 183 */     int i = length();
/* 184 */     paramInt1 = (paramInt1 < 0) ? (i + paramInt1) : paramInt1;
/*     */ 
/*     */     
/* 187 */     paramInt2 = Utils.rangeLimit(paramInt2 = (paramInt2 < 0) ? (i + paramInt2) : paramInt2, 0, i);
/* 188 */     paramInt1 = Utils.rangeLimit(paramInt1, 0, paramInt2);
/* 189 */     return subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T midSequence(int paramInt) {
/* 195 */     return midSequence(paramInt, length());
/*     */   }
/*     */ 
/*     */   
/*     */   public final char midCharAt(int paramInt) {
/* 200 */     int i = length();
/* 201 */     if (paramInt < -i || paramInt >= i) return Character.MIN_VALUE; 
/* 202 */     return charAt((paramInt < 0) ? (i + paramInt) : paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final char lastChar() {
/* 207 */     return isEmpty() ? Character.MIN_VALUE : charAt(length() - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final char firstChar() {
/* 212 */     return isEmpty() ? Character.MIN_VALUE : charAt(0);
/*     */   }
/*     */   
/*     */   public final void validateIndex(int paramInt) {
/* 216 */     SequenceUtils.validateIndex(paramInt, length());
/*     */   }
/*     */   
/*     */   public final void validateIndexInclusiveEnd(int paramInt) {
/* 220 */     SequenceUtils.validateIndexInclusiveEnd(paramInt, length());
/*     */   }
/*     */   
/*     */   public final void validateStartEnd(int paramInt1, int paramInt2) {
/* 224 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, length());
/*     */   }
/*     */ 
/*     */   
/*     */   public char safeCharAt(int paramInt) {
/* 229 */     return (paramInt < 0 || paramInt >= length()) ? Character.MIN_VALUE : charAt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T safeSubSequence(int paramInt1, int paramInt2) {
/* 235 */     int i = length();
/*     */     
/* 237 */     paramInt2 = Math.max(paramInt1 = Math.max(0, Math.min(i, paramInt1)), Math.min(i, paramInt2));
/* 238 */     return subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T safeSubSequence(int paramInt) {
/* 244 */     int i = length();
/* 245 */     paramInt = Math.max(0, Math.min(i, paramInt));
/* 246 */     return subSequence(paramInt, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCharAt(int paramInt, CharPredicate paramCharPredicate) {
/* 251 */     return paramCharPredicate.test(safeCharAt(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toStringOrNull() {
/* 256 */     return isNull() ? null : toString();
/*     */   }
/*     */   
/*     */   public final int indexOf(CharSequence paramCharSequence) {
/* 260 */     return SequenceUtils.indexOf(this, paramCharSequence);
/* 261 */   } public final int indexOf(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.indexOf(this, paramCharSequence, paramInt); }
/* 262 */   public final int indexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return SequenceUtils.indexOf(this, paramCharSequence, paramInt1, paramInt2); }
/* 263 */   public final int indexOf(char paramChar) { return SequenceUtils.indexOf(this, paramChar); }
/* 264 */   public final int indexOf(char paramChar, int paramInt) { return SequenceUtils.indexOf(this, paramChar, paramInt); }
/* 265 */   public final int indexOfAny(CharPredicate paramCharPredicate) { return SequenceUtils.indexOfAny(this, paramCharPredicate); }
/* 266 */   public final int indexOfAny(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.indexOfAny(this, paramCharPredicate, paramInt); }
/* 267 */   public final int indexOfAnyNot(CharPredicate paramCharPredicate) { return SequenceUtils.indexOfAnyNot(this, paramCharPredicate); }
/* 268 */   public final int indexOfAnyNot(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.indexOfAnyNot(this, paramCharPredicate, paramInt); }
/* 269 */   public final int indexOfAnyNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return SequenceUtils.indexOfAnyNot(this, paramCharPredicate, paramInt1, paramInt2); }
/* 270 */   public final int indexOfNot(char paramChar) { return SequenceUtils.indexOfNot(this, paramChar); }
/* 271 */   public final int indexOfNot(char paramChar, int paramInt) { return SequenceUtils.indexOfNot(this, paramChar, paramInt); }
/* 272 */   public final int lastIndexOf(char paramChar) { return SequenceUtils.lastIndexOf(this, paramChar); }
/* 273 */   public final int lastIndexOf(char paramChar, int paramInt) { return SequenceUtils.lastIndexOf(this, paramChar, paramInt); }
/* 274 */   public final int lastIndexOfNot(char paramChar) { return SequenceUtils.lastIndexOfNot(this, paramChar); }
/* 275 */   public final int lastIndexOfNot(char paramChar, int paramInt) { return SequenceUtils.lastIndexOfNot(this, paramChar, paramInt); }
/* 276 */   public final int lastIndexOf(CharSequence paramCharSequence) { return SequenceUtils.lastIndexOf(this, paramCharSequence); }
/* 277 */   public final int lastIndexOf(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.lastIndexOf(this, paramCharSequence, paramInt); }
/* 278 */   public final int lastIndexOfAny(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.lastIndexOfAny(this, paramCharPredicate, paramInt); }
/* 279 */   public final int lastIndexOfAny(CharPredicate paramCharPredicate) { return SequenceUtils.lastIndexOfAny(this, paramCharPredicate); }
/* 280 */   public final int lastIndexOfAnyNot(CharPredicate paramCharPredicate) { return SequenceUtils.lastIndexOfAnyNot(this, paramCharPredicate); }
/* 281 */   public final int lastIndexOfAnyNot(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.lastIndexOfAnyNot(this, paramCharPredicate, paramInt); }
/* 282 */   public final int lastIndexOfAnyNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return SequenceUtils.lastIndexOfAnyNot(this, paramCharPredicate, paramInt1, paramInt2); }
/* 283 */   public final int indexOf(char paramChar, int paramInt1, int paramInt2) { return SequenceUtils.indexOf(this, paramChar, paramInt1, paramInt2); }
/* 284 */   public final int indexOfNot(char paramChar, int paramInt1, int paramInt2) { return SequenceUtils.indexOfNot(this, paramChar, paramInt1, paramInt2); }
/* 285 */   public final int indexOfAny(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return SequenceUtils.indexOfAny(this, paramCharPredicate, paramInt1, paramInt2); }
/* 286 */   public final int lastIndexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return SequenceUtils.lastIndexOf(this, paramCharSequence, paramInt1, paramInt2); }
/* 287 */   public final int lastIndexOf(char paramChar, int paramInt1, int paramInt2) { return SequenceUtils.lastIndexOf(this, paramChar, paramInt1, paramInt2); }
/* 288 */   public final int lastIndexOfNot(char paramChar, int paramInt1, int paramInt2) { return SequenceUtils.lastIndexOfNot(this, paramChar, paramInt1, paramInt2); } public final int lastIndexOfAny(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/* 289 */     return SequenceUtils.lastIndexOfAny(this, paramCharPredicate, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public final int countOfSpaceTab() {
/* 293 */     return SequenceUtils.countOfSpaceTab(this);
/* 294 */   } public final int countOfNotSpaceTab() { return SequenceUtils.countOfNotSpaceTab(this); }
/* 295 */   public final int countOfWhitespace() { return SequenceUtils.countOfWhitespace(this); } public final int countOfNotWhitespace() {
/* 296 */     return SequenceUtils.countOfNotWhitespace(this);
/*     */   }
/* 298 */   public final int countOfAny(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.countOfAny(this, paramCharPredicate, paramInt); }
/* 299 */   public final int countOfAny(CharPredicate paramCharPredicate) { return SequenceUtils.countOfAny(this, paramCharPredicate); }
/* 300 */   public final int countOfAnyNot(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.countOfAnyNot(this, paramCharPredicate, paramInt); }
/* 301 */   public final int countOfAnyNot(CharPredicate paramCharPredicate) { return SequenceUtils.countOfAnyNot(this, paramCharPredicate); }
/* 302 */   public final int countOfAny(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return SequenceUtils.countOfAny(this, paramCharPredicate, paramInt1, paramInt2); } public final int countOfAnyNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/* 303 */     return SequenceUtils.countOfAnyNot(this, paramCharPredicate, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public final int countLeading(CharPredicate paramCharPredicate) {
/* 307 */     return SequenceUtils.countLeading(this, paramCharPredicate);
/* 308 */   } public final int countLeading(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.countLeading(this, paramCharPredicate, paramInt); }
/* 309 */   public final int countLeadingNot(CharPredicate paramCharPredicate) { return SequenceUtils.countLeadingNot(this, paramCharPredicate); } public final int countLeadingNot(CharPredicate paramCharPredicate, int paramInt) {
/* 310 */     return SequenceUtils.countLeadingNot(this, paramCharPredicate, paramInt);
/*     */   }
/* 312 */   public final int countTrailing(CharPredicate paramCharPredicate) { return SequenceUtils.countTrailing(this, paramCharPredicate); }
/* 313 */   public final int countTrailing(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.countTrailing(this, paramCharPredicate, paramInt); }
/* 314 */   public final int countTrailingNot(CharPredicate paramCharPredicate) { return SequenceUtils.countTrailingNot(this, paramCharPredicate); } public final int countTrailingNot(CharPredicate paramCharPredicate, int paramInt) {
/* 315 */     return SequenceUtils.countTrailingNot(this, paramCharPredicate, paramInt);
/*     */   }
/* 317 */   public final int countLeadingNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return SequenceUtils.countLeadingNot(this, paramCharPredicate, paramInt1, paramInt2); }
/* 318 */   public final int countTrailingNot(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return SequenceUtils.countTrailingNot(this, paramCharPredicate, paramInt1, paramInt2); } public final int countLeading(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/* 319 */     return SequenceUtils.countLeading(this, paramCharPredicate, paramInt1, paramInt2);
/*     */   }
/* 321 */   public final int countLeadingColumns(int paramInt, CharPredicate paramCharPredicate) { return SequenceUtils.countLeadingColumns(this, paramInt, paramCharPredicate); } public final int countTrailing(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/* 322 */     return SequenceUtils.countTrailing(this, paramCharPredicate, paramInt1, paramInt2);
/*     */   }
/* 324 */   public final int countLeadingSpace() { return SequenceUtils.countLeadingSpace(this); }
/* 325 */   public final int countLeadingNotSpace() { return SequenceUtils.countLeadingNotSpace(this); }
/* 326 */   public final int countLeadingSpace(int paramInt) { return SequenceUtils.countLeadingSpace(this, paramInt); }
/* 327 */   public final int countLeadingNotSpace(int paramInt) { return SequenceUtils.countLeadingNotSpace(this, paramInt); }
/* 328 */   public final int countLeadingSpace(int paramInt1, int paramInt2) { return SequenceUtils.countLeadingSpace(this, paramInt1, paramInt2); } public final int countLeadingNotSpace(int paramInt1, int paramInt2) {
/* 329 */     return SequenceUtils.countLeadingNotSpace(this, paramInt1, paramInt2);
/*     */   }
/* 331 */   public final int countTrailingSpace() { return SequenceUtils.countTrailingSpace(this); }
/* 332 */   public final int countTrailingNotSpace() { return SequenceUtils.countTrailingNotSpace(this); }
/* 333 */   public final int countTrailingSpace(int paramInt) { return SequenceUtils.countTrailingSpace(this, paramInt); }
/* 334 */   public final int countTrailingNotSpace(int paramInt) { return SequenceUtils.countTrailingNotSpace(this, paramInt); }
/* 335 */   public final int countTrailingSpace(int paramInt1, int paramInt2) { return SequenceUtils.countTrailingSpace(this, paramInt1, paramInt2); } public final int countTrailingNotSpace(int paramInt1, int paramInt2) {
/* 336 */     return SequenceUtils.countTrailingNotSpace(this, paramInt1, paramInt2);
/*     */   }
/* 338 */   public final int countLeadingSpaceTab() { return SequenceUtils.countLeadingSpaceTab(this); }
/* 339 */   public final int countLeadingNotSpaceTab() { return SequenceUtils.countLeadingNotSpaceTab(this); }
/* 340 */   public final int countLeadingSpaceTab(int paramInt) { return SequenceUtils.countLeadingSpaceTab(this, paramInt); }
/* 341 */   public final int countLeadingNotSpaceTab(int paramInt) { return SequenceUtils.countLeadingNotSpaceTab(this, paramInt); }
/* 342 */   public final int countLeadingSpaceTab(int paramInt1, int paramInt2) { return SequenceUtils.countLeadingSpaceTab(this, paramInt1, paramInt2); } public final int countLeadingNotSpaceTab(int paramInt1, int paramInt2) {
/* 343 */     return SequenceUtils.countLeadingNotSpaceTab(this, paramInt1, paramInt2);
/*     */   }
/* 345 */   public final int countTrailingSpaceTab() { return SequenceUtils.countTrailingSpaceTab(this); }
/* 346 */   public final int countTrailingNotSpaceTab() { return SequenceUtils.countTrailingNotSpaceTab(this); }
/* 347 */   public final int countTrailingSpaceTab(int paramInt) { return SequenceUtils.countTrailingSpaceTab(this, paramInt); }
/* 348 */   public final int countTrailingNotSpaceTab(int paramInt) { return SequenceUtils.countTrailingNotSpaceTab(this, paramInt); }
/* 349 */   public final int countTrailingSpaceTab(int paramInt1, int paramInt2) { return SequenceUtils.countTrailingSpaceTab(this, paramInt1, paramInt2); } public final int countTrailingNotSpaceTab(int paramInt1, int paramInt2) {
/* 350 */     return SequenceUtils.countTrailingNotSpaceTab(this, paramInt1, paramInt2);
/*     */   }
/* 352 */   public final int countLeadingWhitespace() { return SequenceUtils.countLeadingWhitespace(this); }
/* 353 */   public final int countLeadingNotWhitespace() { return SequenceUtils.countLeadingNotWhitespace(this); }
/* 354 */   public final int countLeadingWhitespace(int paramInt) { return SequenceUtils.countLeadingWhitespace(this, paramInt); }
/* 355 */   public final int countLeadingNotWhitespace(int paramInt) { return SequenceUtils.countLeadingNotWhitespace(this, paramInt); }
/* 356 */   public final int countLeadingWhitespace(int paramInt1, int paramInt2) { return SequenceUtils.countLeadingWhitespace(this, paramInt1, paramInt2); } public final int countLeadingNotWhitespace(int paramInt1, int paramInt2) {
/* 357 */     return SequenceUtils.countLeadingNotWhitespace(this, paramInt1, paramInt2);
/*     */   }
/* 359 */   public final int countTrailingWhitespace() { return SequenceUtils.countTrailingWhitespace(this); }
/* 360 */   public final int countTrailingNotWhitespace() { return SequenceUtils.countTrailingNotWhitespace(this); }
/* 361 */   public final int countTrailingWhitespace(int paramInt) { return SequenceUtils.countTrailingWhitespace(this, paramInt); }
/* 362 */   public final int countTrailingNotWhitespace(int paramInt) { return SequenceUtils.countTrailingNotWhitespace(this, paramInt); }
/* 363 */   public final int countTrailingWhitespace(int paramInt1, int paramInt2) { return SequenceUtils.countTrailingWhitespace(this, paramInt1, paramInt2); } public final int countTrailingNotWhitespace(int paramInt1, int paramInt2) {
/* 364 */     return SequenceUtils.countTrailingNotWhitespace(this, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final T trimStart(CharPredicate paramCharPredicate) {
/* 369 */     return subSequence(trimStartRange(0, paramCharPredicate)); }
/* 370 */   public final T trimmedStart(CharPredicate paramCharPredicate) { return trimmedStart(0, paramCharPredicate); }
/* 371 */   public final T trimEnd(CharPredicate paramCharPredicate) { return trimEnd(0, paramCharPredicate); }
/* 372 */   public final T trimmedEnd(CharPredicate paramCharPredicate) { return trimmedEnd(0, paramCharPredicate); }
/* 373 */   public final T trim(CharPredicate paramCharPredicate) { return trim(0, paramCharPredicate); }
/* 374 */   public final Pair<T, T> trimmed(CharPredicate paramCharPredicate) { return trimmed(0, paramCharPredicate); }
/* 375 */   public final T trimStart(int paramInt) { return trimStart(paramInt, CharPredicate.WHITESPACE); }
/* 376 */   public final T trimmedStart(int paramInt) { return trimmedStart(paramInt, CharPredicate.WHITESPACE); }
/* 377 */   public final T trimEnd(int paramInt) { return trimEnd(paramInt, CharPredicate.WHITESPACE); }
/* 378 */   public final T trimmedEnd(int paramInt) { return trimmedEnd(paramInt, CharPredicate.WHITESPACE); }
/* 379 */   public final T trim(int paramInt) { return trim(paramInt, CharPredicate.WHITESPACE); }
/* 380 */   public final Pair<T, T> trimmed(int paramInt) { return trimmed(paramInt, CharPredicate.WHITESPACE); }
/* 381 */   public final T trimStart() { return trimStart(0, CharPredicate.WHITESPACE); }
/* 382 */   public final T trimmedStart() { return trimmedStart(0, CharPredicate.WHITESPACE); }
/* 383 */   public final T trimEnd() { return trimEnd(0, CharPredicate.WHITESPACE); }
/* 384 */   public final T trimmedEnd() { return trimmedEnd(0, CharPredicate.WHITESPACE); }
/* 385 */   public final T trim() { return trim(0, CharPredicate.WHITESPACE); }
/* 386 */   public final Pair<T, T> trimmed() { return trimmed(0, CharPredicate.WHITESPACE); }
/* 387 */   public final T trimStart(int paramInt, CharPredicate paramCharPredicate) { return subSequence(trimStartRange(paramInt, paramCharPredicate)); }
/* 388 */   public final T trimmedStart(int paramInt, CharPredicate paramCharPredicate) { return subSequenceBefore(trimStartRange(paramInt, paramCharPredicate)); }
/* 389 */   public final T trimEnd(int paramInt, CharPredicate paramCharPredicate) { return subSequence(trimEndRange(paramInt, paramCharPredicate)); }
/* 390 */   public final T trimmedEnd(int paramInt, CharPredicate paramCharPredicate) { return subSequenceAfter(trimEndRange(paramInt, paramCharPredicate)); }
/* 391 */   public final T trim(int paramInt, CharPredicate paramCharPredicate) { return subSequence(trimRange(paramInt, paramCharPredicate)); } public final Pair<T, T> trimmed(int paramInt, CharPredicate paramCharPredicate) {
/* 392 */     return subSequenceBeforeAfter(trimRange(paramInt, paramCharPredicate));
/*     */   }
/*     */   
/*     */   public final Range trimStartRange(int paramInt, CharPredicate paramCharPredicate) {
/* 396 */     return SequenceUtils.trimStartRange(this, paramInt, paramCharPredicate);
/* 397 */   } public final Range trimEndRange(int paramInt, CharPredicate paramCharPredicate) { return SequenceUtils.trimEndRange(this, paramInt, paramCharPredicate); }
/* 398 */   public final Range trimRange(int paramInt, CharPredicate paramCharPredicate) { return SequenceUtils.trimRange(this, paramInt, paramCharPredicate); }
/* 399 */   public final Range trimStartRange(CharPredicate paramCharPredicate) { return SequenceUtils.trimStartRange(this, paramCharPredicate); }
/* 400 */   public final Range trimEndRange(CharPredicate paramCharPredicate) { return SequenceUtils.trimEndRange(this, paramCharPredicate); }
/* 401 */   public final Range trimRange(CharPredicate paramCharPredicate) { return SequenceUtils.trimRange(this, paramCharPredicate); }
/* 402 */   public final Range trimStartRange(int paramInt) { return SequenceUtils.trimStartRange(this, paramInt); }
/* 403 */   public final Range trimEndRange(int paramInt) { return SequenceUtils.trimEndRange(this, paramInt); }
/* 404 */   public final Range trimRange(int paramInt) { return SequenceUtils.trimRange(this, paramInt); }
/* 405 */   public final Range trimStartRange() { return SequenceUtils.trimStartRange(this); }
/* 406 */   public final Range trimEndRange() { return SequenceUtils.trimEndRange(this); } public final Range trimRange() {
/* 407 */     return SequenceUtils.trimRange(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T padding(int paramInt, char paramChar) {
/* 413 */     return (paramInt <= length()) ? nullSequence() : sequenceOf(RepeatedSequence.repeatOf(paramChar, paramInt - length()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T padding(int paramInt) {
/* 419 */     return padStart(paramInt, ' ');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T padStart(int paramInt, char paramChar) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: iload_1
/*     */     //   2: iload_2
/*     */     //   3: invokevirtual padding : (IC)Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   6: dup
/*     */     //   7: astore_1
/*     */     //   8: invokeinterface isEmpty : ()Z
/*     */     //   13: ifeq -> 18
/*     */     //   16: aload_0
/*     */     //   17: areturn
/*     */     //   18: aload_0
/*     */     //   19: invokevirtual getBuilder : ()Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*     */     //   22: aload_1
/*     */     //   23: invokeinterface append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*     */     //   28: aload_0
/*     */     //   29: invokeinterface append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*     */     //   34: invokeinterface toSequence : ()Ljava/lang/CharSequence;
/*     */     //   39: checkcast com/vladsch/flexmark/util/sequence/IRichSequence
/*     */     //   42: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #425	-> 0
/*     */     //   #426	-> 7
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T padEnd(int paramInt, char paramChar) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: iload_1
/*     */     //   2: iload_2
/*     */     //   3: invokevirtual padding : (IC)Lcom/vladsch/flexmark/util/sequence/IRichSequence;
/*     */     //   6: dup
/*     */     //   7: astore_1
/*     */     //   8: invokeinterface isEmpty : ()Z
/*     */     //   13: ifeq -> 18
/*     */     //   16: aload_0
/*     */     //   17: areturn
/*     */     //   18: aload_0
/*     */     //   19: invokevirtual getBuilder : ()Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*     */     //   22: aload_0
/*     */     //   23: invokeinterface append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*     */     //   28: aload_1
/*     */     //   29: invokeinterface append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/sequence/builder/ISequenceBuilder;
/*     */     //   34: invokeinterface toSequence : ()Ljava/lang/CharSequence;
/*     */     //   39: checkcast com/vladsch/flexmark/util/sequence/IRichSequence
/*     */     //   42: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #432	-> 0
/*     */     //   #433	-> 7
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T padStart(int paramInt) {
/* 439 */     return padStart(paramInt, ' ');
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T padEnd(int paramInt) {
/* 445 */     return padEnd(paramInt, ' ');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int eolEndLength() {
/* 453 */     return SequenceUtils.eolEndLength(this);
/* 454 */   } public final int eolEndLength(int paramInt) { return SequenceUtils.eolEndLength(this, paramInt); } public final int eolStartLength(int paramInt) {
/* 455 */     return SequenceUtils.eolStartLength(this, paramInt);
/*     */   }
/* 457 */   public final int endOfLine(int paramInt) { return SequenceUtils.endOfLine(this, paramInt); }
/* 458 */   public final int endOfLineAnyEOL(int paramInt) { return SequenceUtils.endOfLineAnyEOL(this, paramInt); }
/* 459 */   public final int startOfLine(int paramInt) { return SequenceUtils.startOfLine(this, paramInt); } public final int startOfLineAnyEOL(int paramInt) {
/* 460 */     return SequenceUtils.startOfLineAnyEOL(this, paramInt);
/*     */   }
/* 462 */   public final int startOfDelimitedByAnyNot(CharPredicate paramCharPredicate, int paramInt) { return startOfDelimitedByAny(paramCharPredicate.negate(), paramInt); } public final int endOfDelimitedByAnyNot(CharPredicate paramCharPredicate, int paramInt) {
/* 463 */     return endOfDelimitedByAny(paramCharPredicate.negate(), paramInt);
/*     */   }
/* 465 */   public final int startOfDelimitedBy(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.startOfDelimitedBy(this, paramCharSequence, paramInt); }
/* 466 */   public final int startOfDelimitedByAny(CharPredicate paramCharPredicate, int paramInt) { return SequenceUtils.startOfDelimitedByAny(this, paramCharPredicate, paramInt); }
/* 467 */   public final int endOfDelimitedBy(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.endOfDelimitedBy(this, paramCharSequence, paramInt); } public final int endOfDelimitedByAny(CharPredicate paramCharPredicate, int paramInt) {
/* 468 */     return SequenceUtils.endOfDelimitedByAny(this, paramCharPredicate, paramInt);
/*     */   }
/* 470 */   public final Range lineRangeAt(int paramInt) { return SequenceUtils.lineRangeAt(this, paramInt); } public final Range lineRangeAtAnyEOL(int paramInt) {
/* 471 */     return SequenceUtils.lineRangeAtAnyEOL(this, paramInt);
/*     */   }
/* 473 */   public final T lineAt(int paramInt) { return subSequence(lineRangeAt(paramInt)); } public final T lineAtAnyEOL(int paramInt) {
/* 474 */     return subSequence(lineRangeAtAnyEOL(paramInt));
/*     */   }
/* 476 */   public final Range eolEndRange(int paramInt) { return SequenceUtils.eolEndRange(this, paramInt); } public Range eolStartRange(int paramInt) {
/* 477 */     return SequenceUtils.eolStartRange(this, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T trimEOL() {
/*     */     int i;
/* 484 */     return (T)(((i = eolEndLength()) > 0) ? (Object)subSequence(0, length() - i) : this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T trimmedEOL() {
/*     */     int i;
/* 491 */     return ((i = eolEndLength()) > 0) ? subSequence(length() - i) : nullSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T trimTailBlankLines() {
/*     */     Range range;
/* 498 */     return (T)((range = trailingBlankLinesRange()).isNull() ? this : (Object)subSequenceBefore(range));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T trimLeadBlankLines() {
/*     */     Range range;
/* 505 */     return (T)((range = leadingBlankLinesRange()).isNull() ? this : (Object)subSequenceAfter(range));
/*     */   }
/*     */   
/*     */   public final Range leadingBlankLinesRange() {
/* 509 */     return SequenceUtils.leadingBlankLinesRange(this);
/* 510 */   } public final Range leadingBlankLinesRange(int paramInt) { return SequenceUtils.leadingBlankLinesRange(this, paramInt); }
/* 511 */   public final Range leadingBlankLinesRange(int paramInt1, int paramInt2) { return SequenceUtils.leadingBlankLinesRange(this, paramInt1, paramInt2); }
/* 512 */   public final Range trailingBlankLinesRange() { return SequenceUtils.trailingBlankLinesRange(this); }
/* 513 */   public final Range trailingBlankLinesRange(int paramInt) { return SequenceUtils.trailingBlankLinesRange(this, paramInt); } public final Range trailingBlankLinesRange(int paramInt1, int paramInt2) {
/* 514 */     return SequenceUtils.trailingBlankLinesRange(this, paramInt1, paramInt2);
/*     */   }
/* 516 */   public final Range trailingBlankLinesRange(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) { return SequenceUtils.trailingBlankLinesRange(this, paramCharPredicate, paramInt1, paramInt2); } public final Range leadingBlankLinesRange(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/* 517 */     return SequenceUtils.leadingBlankLinesRange(this, paramCharPredicate, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public final List<Range> blankLinesRemovedRanges() {
/* 521 */     return SequenceUtils.blankLinesRemovedRanges(this);
/* 522 */   } public final List<Range> blankLinesRemovedRanges(int paramInt) { return SequenceUtils.blankLinesRemovedRanges(this, paramInt); }
/* 523 */   public final List<Range> blankLinesRemovedRanges(int paramInt1, int paramInt2) { return SequenceUtils.blankLinesRemovedRanges(this, paramInt1, paramInt2); } public final List<Range> blankLinesRemovedRanges(CharPredicate paramCharPredicate, int paramInt1, int paramInt2) {
/* 524 */     return SequenceUtils.blankLinesRemovedRanges(this, paramCharPredicate, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public T trimToEndOfLine(boolean paramBoolean) {
/* 528 */     return trimToEndOfLine(CharPredicate.EOL, paramBoolean, 0);
/* 529 */   } public T trimToEndOfLine(int paramInt) { return trimToEndOfLine(CharPredicate.EOL, false, paramInt); }
/* 530 */   public T trimToEndOfLine() { return trimToEndOfLine(CharPredicate.EOL, false, 0); } public T trimToEndOfLine(boolean paramBoolean, int paramInt) {
/* 531 */     return trimToEndOfLine(CharPredicate.EOL, paramBoolean, paramInt);
/*     */   }
/* 533 */   public T trimToStartOfLine(boolean paramBoolean) { return trimToStartOfLine(CharPredicate.EOL, paramBoolean, 0); }
/* 534 */   public T trimToStartOfLine(int paramInt) { return trimToStartOfLine(CharPredicate.EOL, false, paramInt); }
/* 535 */   public T trimToStartOfLine() { return trimToStartOfLine(CharPredicate.EOL, false, 0); } public T trimToStartOfLine(boolean paramBoolean, int paramInt) {
/* 536 */     return trimToStartOfLine(CharPredicate.EOL, paramBoolean, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T trimToEndOfLine(CharPredicate paramCharPredicate, boolean paramBoolean, int paramInt) {
/*     */     int i;
/* 543 */     if ((i = endOfDelimitedByAny(paramCharPredicate, paramInt)) < length()) {
/* 544 */       i = paramBoolean ? (i + eolStartLength(i)) : i;
/* 545 */       return subSequence(0, i);
/*     */     } 
/* 547 */     return (T)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T trimToStartOfLine(CharPredicate paramCharPredicate, boolean paramBoolean, int paramInt) {
/*     */     int i;
/* 554 */     if ((i = startOfDelimitedByAny(paramCharPredicate, paramInt)) > 0) {
/* 555 */       i = paramBoolean ? (i - eolEndLength(i - 1)) : i;
/* 556 */       return subSequence(i);
/*     */     } 
/* 558 */     return (T)this;
/*     */   }
/*     */   
/*     */   public final T ifNull(T paramT) {
/* 562 */     return (T)(isNull() ? (Object)paramT : this);
/* 563 */   } public final T ifNullEmptyAfter(T paramT) { return (T)(isNull() ? (Object)paramT.subSequence(paramT.length(), paramT.length()) : this); }
/* 564 */   public final T ifNullEmptyBefore(T paramT) { return (T)(isNull() ? (Object)paramT.subSequence(0, 0) : this); }
/* 565 */   public final T nullIfEmpty() { return (T)(isEmpty() ? (Object)nullSequence() : this); }
/* 566 */   public final T nullIfBlank() { return (T)(isBlank() ? (Object)nullSequence() : this); }
/* 567 */   public final T nullIf(boolean paramBoolean) { return (T)(paramBoolean ? (Object)nullSequence() : this); }
/* 568 */   public final T nullIfNot(BiPredicate<? super T, ? super CharSequence> paramBiPredicate, CharSequence... paramVarArgs) { return nullIf(paramBiPredicate.negate(), paramVarArgs); }
/* 569 */   public final T nullIf(Predicate<? super CharSequence> paramPredicate, CharSequence... paramVarArgs) { return nullIf((paramIRichSequence, paramCharSequence) -> paramPredicate.test(paramCharSequence), paramVarArgs); }
/* 570 */   public final T nullIfNot(Predicate<? super CharSequence> paramPredicate, CharSequence... paramVarArgs) { return nullIfNot((paramIRichSequence, paramCharSequence) -> paramPredicate.test(paramCharSequence), paramVarArgs); }
/* 571 */   public final T nullIf(CharSequence... paramVarArgs) { return nullIf(this::matches, paramVarArgs); }
/* 572 */   public final T nullIfNot(CharSequence... paramVarArgs) { return nullIfNot(this::matches, paramVarArgs); }
/* 573 */   public final T nullIfStartsWith(CharSequence... paramVarArgs) { return nullIf(this::startsWith, paramVarArgs); }
/* 574 */   public final T nullIfNotStartsWith(CharSequence... paramVarArgs) { return nullIfNot(this::startsWith, paramVarArgs); }
/* 575 */   public final T nullIfEndsWith(CharSequence... paramVarArgs) { return nullIf(this::endsWith, paramVarArgs); }
/* 576 */   public final T nullIfNotEndsWith(CharSequence... paramVarArgs) { return nullIfNot(this::endsWith, paramVarArgs); }
/* 577 */   public final T nullIfStartsWithIgnoreCase(CharSequence... paramVarArgs) { return nullIf(this::startsWithIgnoreCase, paramVarArgs); }
/* 578 */   public final T nullIfNotStartsWithIgnoreCase(CharSequence... paramVarArgs) { return nullIfNot(this::startsWithIgnoreCase, paramVarArgs); }
/* 579 */   public final T nullIfEndsWithIgnoreCase(CharSequence... paramVarArgs) { return nullIf(this::endsWithIgnoreCase, paramVarArgs); }
/* 580 */   public final T nullIfNotEndsWithIgnoreCase(CharSequence... paramVarArgs) { return nullIfNot(this::endsWithIgnoreCase, paramVarArgs); }
/* 581 */   public final T nullIfStartsWith(boolean paramBoolean, CharSequence... paramVarArgs) { return nullIf(paramCharSequence -> startsWith(paramCharSequence, paramBoolean), paramVarArgs); }
/* 582 */   public final T nullIfNotStartsWith(boolean paramBoolean, CharSequence... paramVarArgs) { return nullIfNot(paramCharSequence -> startsWith(paramCharSequence, paramBoolean), paramVarArgs); }
/* 583 */   public final T nullIfEndsWith(boolean paramBoolean, CharSequence... paramVarArgs) { return nullIf(paramCharSequence -> endsWith(paramCharSequence, paramBoolean), paramVarArgs); } public final T nullIfNotEndsWith(boolean paramBoolean, CharSequence... paramVarArgs) {
/* 584 */     return nullIfNot(paramCharSequence -> endsWith(paramCharSequence, paramBoolean), paramVarArgs);
/*     */   }
/*     */   
/*     */   public final T nullIf(BiPredicate<? super T, ? super CharSequence> paramBiPredicate, CharSequence... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/* 590 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { CharSequence charSequence = paramVarArgs[b];
/* 591 */       if (paramBiPredicate.test((T)this, charSequence)) return nullSequence();  b++; }
/*     */     
/* 593 */     return (T)this;
/*     */   }
/*     */   
/*     */   public final boolean isNull() {
/* 597 */     return (this == nullSequence()); } public final boolean isNotNull() {
/* 598 */     return (this != nullSequence());
/*     */   }
/* 600 */   public final boolean isEmpty() { return SequenceUtils.isEmpty(this); }
/* 601 */   public final boolean isBlank() { return SequenceUtils.isBlank(this); }
/* 602 */   public final boolean isNotEmpty() { return SequenceUtils.isNotEmpty(this); } public final boolean isNotBlank() {
/* 603 */     return SequenceUtils.isNotBlank(this);
/*     */   }
/* 605 */   public final boolean endsWith(CharSequence paramCharSequence) { return SequenceUtils.endsWith(this, paramCharSequence); }
/* 606 */   public final boolean endsWith(CharSequence paramCharSequence, boolean paramBoolean) { return SequenceUtils.endsWith(this, paramCharSequence, paramBoolean); }
/* 607 */   public final boolean startsWith(CharSequence paramCharSequence) { return SequenceUtils.startsWith(this, paramCharSequence); } public final boolean startsWith(CharSequence paramCharSequence, boolean paramBoolean) {
/* 608 */     return SequenceUtils.startsWith(this, paramCharSequence, paramBoolean);
/*     */   }
/* 610 */   public final boolean endsWith(CharPredicate paramCharPredicate) { return SequenceUtils.endsWith(this, paramCharPredicate); } public final boolean startsWith(CharPredicate paramCharPredicate) {
/* 611 */     return SequenceUtils.startsWith(this, paramCharPredicate);
/*     */   }
/* 613 */   public final boolean endsWithEOL() { return SequenceUtils.endsWithEOL(this); }
/* 614 */   public final boolean endsWithAnyEOL() { return SequenceUtils.endsWithAnyEOL(this); }
/* 615 */   public final boolean endsWithSpace() { return SequenceUtils.endsWithSpace(this); }
/* 616 */   public final boolean endsWithSpaceTab() { return SequenceUtils.endsWithSpaceTab(this); } public final boolean endsWithWhitespace() {
/* 617 */     return SequenceUtils.endsWithWhitespace(this);
/*     */   }
/* 619 */   public final boolean startsWithEOL() { return SequenceUtils.startsWithEOL(this); }
/* 620 */   public final boolean startsWithAnyEOL() { return SequenceUtils.startsWithAnyEOL(this); }
/* 621 */   public final boolean startsWithSpace() { return SequenceUtils.startsWithSpace(this); }
/* 622 */   public final boolean startsWithSpaceTab() { return SequenceUtils.startsWithSpaceTab(this); } public final boolean startsWithWhitespace() {
/* 623 */     return SequenceUtils.startsWithWhitespace(this);
/*     */   }
/* 625 */   public final T removeSuffix(CharSequence paramCharSequence) { return (T)(!endsWith(paramCharSequence) ? this : (Object)subSequence(0, length() - paramCharSequence.length())); }
/* 626 */   public final T removePrefix(CharSequence paramCharSequence) { return (T)(!startsWith(paramCharSequence) ? this : (Object)subSequence(paramCharSequence.length(), length())); }
/* 627 */   public final T removeProperSuffix(CharSequence paramCharSequence) { return (T)((length() <= paramCharSequence.length() || !endsWith(paramCharSequence)) ? this : (Object)subSequence(0, length() - paramCharSequence.length())); }
/* 628 */   public final T removeProperPrefix(CharSequence paramCharSequence) { return (T)((length() <= paramCharSequence.length() || !startsWith(paramCharSequence)) ? this : (Object)subSequence(paramCharSequence.length(), length())); }
/* 629 */   public final boolean endsWithIgnoreCase(CharSequence paramCharSequence) { return (length() > 0 && matchCharsReversed(paramCharSequence, length() - 1, true)); }
/* 630 */   public final boolean startsWithIgnoreCase(CharSequence paramCharSequence) { return (length() > 0 && matchChars(paramCharSequence, 0, true)); }
/* 631 */   public final T removeSuffixIgnoreCase(CharSequence paramCharSequence) { return (T)(!endsWithIgnoreCase(paramCharSequence) ? this : (Object)subSequence(0, length() - paramCharSequence.length())); }
/* 632 */   public final T removePrefixIgnoreCase(CharSequence paramCharSequence) { return (T)(!startsWithIgnoreCase(paramCharSequence) ? this : (Object)subSequence(paramCharSequence.length(), length())); }
/* 633 */   public final T removeProperSuffixIgnoreCase(CharSequence paramCharSequence) { return (T)((length() <= paramCharSequence.length() || !endsWithIgnoreCase(paramCharSequence)) ? this : (Object)subSequence(0, length() - paramCharSequence.length())); }
/* 634 */   public final T removeProperPrefixIgnoreCase(CharSequence paramCharSequence) { return (T)((length() <= paramCharSequence.length() || !startsWithIgnoreCase(paramCharSequence)) ? this : (Object)subSequence(paramCharSequence.length(), length())); }
/* 635 */   public final T removeSuffix(CharSequence paramCharSequence, boolean paramBoolean) { return (T)(!endsWith(paramCharSequence, paramBoolean) ? this : (Object)subSequence(0, length() - paramCharSequence.length())); }
/* 636 */   public final T removePrefix(CharSequence paramCharSequence, boolean paramBoolean) { return (T)(!startsWith(paramCharSequence, paramBoolean) ? this : (Object)subSequence(paramCharSequence.length(), length())); }
/* 637 */   public final T removeProperSuffix(CharSequence paramCharSequence, boolean paramBoolean) { return (T)((length() <= paramCharSequence.length() || !endsWith(paramCharSequence, paramBoolean)) ? this : (Object)subSequence(0, length() - paramCharSequence.length())); } public final T removeProperPrefix(CharSequence paramCharSequence, boolean paramBoolean) {
/* 638 */     return (T)((length() <= paramCharSequence.length() || !startsWith(paramCharSequence, paramBoolean)) ? this : (Object)subSequence(paramCharSequence.length(), length()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T insert(int paramInt, CharSequence paramCharSequence) {
/* 644 */     paramInt = Math.max(0, Math.min(length(), paramInt));
/*     */     
/* 646 */     if (paramCharSequence.length() == 0)
/* 647 */       return (T)this; 
/* 648 */     if (paramInt == 0)
/* 649 */       return prefixWith(paramCharSequence); 
/* 650 */     if (paramInt == length()) {
/* 651 */       return suffixWith(paramCharSequence);
/*     */     }
/* 653 */     return (T)getBuilder().add((CharSequence)subSequence(0, paramInt)).add(paramCharSequence).add((CharSequence)subSequence(paramInt)).toSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T delete(int paramInt1, int paramInt2) {
/* 663 */     if ((paramInt1 = Math.min(paramInt2 = Math.max(0, Math.min(length(), paramInt2)), Math.max(0, paramInt1))) == paramInt2)
/* 664 */       return (T)this; 
/* 665 */     if (paramInt1 == 0)
/* 666 */       return subSequence(paramInt2); 
/* 667 */     if (paramInt2 == length()) {
/* 668 */       return subSequence(0, paramInt1);
/*     */     }
/* 670 */     return (T)getBuilder().add((CharSequence)subSequence(0, paramInt1)).add((CharSequence)subSequence(paramInt2)).toSequence();
/*     */   }
/*     */ 
/*     */   
/*     */   public final T toLowerCase() {
/* 675 */     return toMapped(ChangeCase.toLowerCase); }
/* 676 */   public final T toUpperCase() { return toMapped(ChangeCase.toUpperCase); }
/* 677 */   public final T toNbSp() { return toMapped(SpaceMapper.toNonBreakSpace); } public final T toSpc() {
/* 678 */     return toMapped(SpaceMapper.fromNonBreakSpace);
/*     */   }
/*     */   
/*     */   public final boolean matches(CharSequence paramCharSequence, boolean paramBoolean) {
/* 682 */     return SequenceUtils.matches(this, paramCharSequence, paramBoolean);
/* 683 */   } public final boolean matches(CharSequence paramCharSequence) { return SequenceUtils.matches(this, paramCharSequence); } public final boolean matchesIgnoreCase(CharSequence paramCharSequence) {
/* 684 */     return SequenceUtils.matchesIgnoreCase(this, paramCharSequence);
/*     */   }
/* 686 */   public final boolean matchChars(CharSequence paramCharSequence, int paramInt, boolean paramBoolean) { return SequenceUtils.matchChars(this, paramCharSequence, paramInt, paramBoolean); }
/* 687 */   public final boolean matchChars(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.matchChars(this, paramCharSequence, paramInt); } public final boolean matchCharsIgnoreCase(CharSequence paramCharSequence, int paramInt) {
/* 688 */     return SequenceUtils.matchCharsIgnoreCase(this, paramCharSequence, paramInt);
/*     */   }
/* 690 */   public final boolean matchChars(CharSequence paramCharSequence, boolean paramBoolean) { return SequenceUtils.matchChars(this, paramCharSequence, paramBoolean); }
/* 691 */   public final boolean matchChars(CharSequence paramCharSequence) { return SequenceUtils.matchChars(this, paramCharSequence); } public final boolean matchCharsIgnoreCase(CharSequence paramCharSequence) {
/* 692 */     return SequenceUtils.matchCharsIgnoreCase(this, paramCharSequence);
/*     */   }
/* 694 */   public final boolean matchCharsReversed(CharSequence paramCharSequence, int paramInt, boolean paramBoolean) { return SequenceUtils.matchCharsReversed(this, paramCharSequence, paramInt, paramBoolean); }
/* 695 */   public final boolean matchCharsReversed(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.matchCharsReversed(this, paramCharSequence, paramInt); } public final boolean matchCharsReversedIgnoreCase(CharSequence paramCharSequence, int paramInt) {
/* 696 */     return SequenceUtils.matchCharsReversedIgnoreCase(this, paramCharSequence, paramInt);
/*     */   }
/* 698 */   public final int matchedCharCount(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean) { return SequenceUtils.matchedCharCount(this, paramCharSequence, paramInt1, paramInt2, paramBoolean); }
/* 699 */   public final int matchedCharCount(CharSequence paramCharSequence, int paramInt, boolean paramBoolean) { return SequenceUtils.matchedCharCount(this, paramCharSequence, paramInt, paramBoolean); }
/* 700 */   public final int matchedCharCount(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return SequenceUtils.matchedCharCount(this, paramCharSequence, paramInt1, paramInt2); }
/* 701 */   public final int matchedCharCount(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.matchedCharCount(this, paramCharSequence, paramInt); }
/* 702 */   public final int matchedCharCountIgnoreCase(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.matchedCharCountIgnoreCase(this, paramCharSequence, paramInt); } public final int matchedCharCountIgnoreCase(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 703 */     return SequenceUtils.matchedCharCountIgnoreCase(this, paramCharSequence, paramInt1, paramInt2);
/*     */   }
/* 705 */   public final int matchedCharCountReversedIgnoreCase(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return SequenceUtils.matchedCharCountReversedIgnoreCase(this, paramCharSequence, paramInt1, paramInt2); } public final int matchedCharCountReversed(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 706 */     return SequenceUtils.matchedCharCountReversed(this, paramCharSequence, paramInt1, paramInt2);
/*     */   }
/* 708 */   public final int matchedCharCountReversed(CharSequence paramCharSequence, int paramInt, boolean paramBoolean) { return SequenceUtils.matchedCharCountReversed(this, paramCharSequence, paramInt, paramBoolean); }
/* 709 */   public final int matchedCharCountReversed(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.matchedCharCountReversed(this, paramCharSequence, paramInt); }
/* 710 */   public final int matchedCharCountReversedIgnoreCase(CharSequence paramCharSequence, int paramInt) { return SequenceUtils.matchedCharCountReversedIgnoreCase(this, paramCharSequence, paramInt); }
/* 711 */   public final int matchedCharCount(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) { return SequenceUtils.matchedCharCount(this, paramCharSequence, paramInt1, paramInt2, paramBoolean1, paramBoolean2); } public final int matchedCharCountReversed(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 712 */     return SequenceUtils.matchedCharCountReversed(this, paramCharSequence, paramInt1, paramInt2, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 718 */     int i = length();
/* 719 */     StringBuilder stringBuilder = new StringBuilder(i);
/*     */     
/* 721 */     for (byte b = 0; b < i; b++) {
/* 722 */       stringBuilder.append(charAt(b));
/*     */     }
/*     */     
/* 725 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public final String normalizeEOL() {
/* 729 */     return Escaping.normalizeEOL(toString());
/* 730 */   } public final String normalizeEndWithEOL() { return Escaping.normalizeEndWithEOL(toString()); } public final String toVisibleWhitespaceString() {
/* 731 */     return SequenceUtils.toVisibleWhitespaceString(this);
/*     */   }
/*     */   
/*     */   public final List<T> splitList(CharSequence paramCharSequence) {
/* 735 */     return (List)SequenceUtils.splitList(this, paramCharSequence, 0, 0, (CharPredicate)null);
/* 736 */   } public final List<T> splitList(CharSequence paramCharSequence, int paramInt, boolean paramBoolean, CharPredicate paramCharPredicate) { return (List)SequenceUtils.splitList(this, paramCharSequence, paramInt, paramBoolean ? 1 : 0, paramCharPredicate); }
/* 737 */   public final List<T> splitList(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return (List)SequenceUtils.splitList(this, paramCharSequence, paramInt1, paramInt2, (CharPredicate)null); } public final List<T> splitList(CharSequence paramCharSequence, boolean paramBoolean, CharPredicate paramCharPredicate) {
/* 738 */     return (List)SequenceUtils.splitList(this, paramCharSequence, 0, paramBoolean ? 1 : 0, paramCharPredicate);
/*     */   }
/*     */   
/* 741 */   public final List<T> splitListEOL() { return (List)SequenceUtils.splitList(this, "\n", 0, 1, (CharPredicate)null); }
/* 742 */   public final List<T> splitListEOL(boolean paramBoolean) { return (List)SequenceUtils.splitList(this, "\n", 0, paramBoolean ? 1 : 0, (CharPredicate)null); }
/* 743 */   public final List<T> splitListEOL(boolean paramBoolean, CharPredicate paramCharPredicate) { return (List)SequenceUtils.splitList(this, "\n", 0, paramBoolean ? 1 : 0, paramCharPredicate); } public final List<T> splitList(CharSequence paramCharSequence, int paramInt1, int paramInt2, CharPredicate paramCharPredicate) {
/* 744 */     return (List)SequenceUtils.splitList(this, paramCharSequence, paramInt1, paramInt2, paramCharPredicate);
/*     */   }
/* 746 */   public final T[] splitEOL() { return split("\n", 0, 1, (CharPredicate)null); }
/* 747 */   public final T[] splitEOL(boolean paramBoolean) { return split("\n", 0, paramBoolean ? 1 : 0, (CharPredicate)null); }
/* 748 */   public final T[] split(CharSequence paramCharSequence, boolean paramBoolean, CharPredicate paramCharPredicate) { return split(paramCharSequence, 0, paramBoolean ? 1 : 0, paramCharPredicate); }
/* 749 */   public final T[] split(CharSequence paramCharSequence) { return split(paramCharSequence, 0, 0, (CharPredicate)null); }
/* 750 */   public final T[] split(CharSequence paramCharSequence, int paramInt, boolean paramBoolean, CharPredicate paramCharPredicate) { return split(paramCharSequence, paramInt, paramBoolean ? 1 : 0, paramCharPredicate); }
/* 751 */   public final T[] split(CharSequence paramCharSequence, int paramInt1, int paramInt2) { return split(paramCharSequence, paramInt1, paramInt2, (CharPredicate)null); } public final T[] split(CharSequence paramCharSequence, int paramInt1, int paramInt2, CharPredicate paramCharPredicate) {
/* 752 */     return (T[])SequenceUtils.<IRichSequenceBase>splitList(this, paramCharSequence, paramInt1, paramInt2, paramCharPredicate).toArray((Object[])emptyArray());
/*     */   }
/*     */   
/*     */   public final T appendTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper) {
/* 756 */     return appendTo(paramStringBuilder, paramCharMapper, 0, length());
/* 757 */   } public final T appendTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper, int paramInt) { return appendTo(paramStringBuilder, paramCharMapper, paramInt, length()); }
/* 758 */   public final T appendTo(StringBuilder paramStringBuilder) { return appendTo(paramStringBuilder, (CharMapper)null, 0, length()); }
/* 759 */   public final T appendTo(StringBuilder paramStringBuilder, int paramInt) { return appendTo(paramStringBuilder, (CharMapper)null, paramInt, length()); } public final T appendTo(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/* 760 */     return appendTo(paramStringBuilder, (CharMapper)null, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T appendTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper, int paramInt1, int paramInt2) {
/* 766 */     paramCharMapper = (paramCharMapper == null) ? (CharMapper)this : (CharMapper)toMapped(paramCharMapper);
/* 767 */     paramStringBuilder.append((CharSequence)paramCharMapper, paramInt1, paramInt2);
/* 768 */     return (T)this;
/*     */   }
/*     */   
/*     */   public final T appendRangesTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper, Range... paramVarArgs) {
/* 772 */     return appendRangesTo(paramStringBuilder, paramCharMapper, (Iterable<? extends Range>)new ArrayIterable((Object[])paramVarArgs));
/* 773 */   } public final T appendRangesTo(StringBuilder paramStringBuilder, Range... paramVarArgs) { return appendRangesTo(paramStringBuilder, (CharMapper)null, (Iterable<? extends Range>)new ArrayIterable((Object[])paramVarArgs)); } public final T appendRangesTo(StringBuilder paramStringBuilder, Iterable<? extends Range> paramIterable) {
/* 774 */     return appendRangesTo(paramStringBuilder, (CharMapper)null, paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T appendRangesTo(StringBuilder paramStringBuilder, CharMapper paramCharMapper, Iterable<? extends Range> paramIterable) {
/* 780 */     paramCharMapper = (paramCharMapper == null) ? (CharMapper)this : (CharMapper)toMapped(paramCharMapper);
/*     */     
/* 782 */     for (Iterator<? extends Range> iterator = paramIterable.iterator(); iterator.hasNext();) {
/* 783 */       if ((range = iterator.next()) != null && range.isNotNull()) paramStringBuilder.append((CharSequence)paramCharMapper, range.getStart(), range.getEnd()); 
/*     */     } 
/* 785 */     return (T)this;
/*     */   }
/*     */   
/*     */   public final int[] indexOfAll(CharSequence paramCharSequence) {
/* 789 */     return SequenceUtils.indexOfAll(this, paramCharSequence);
/*     */   }
/* 791 */   public final T appendEOL() { return suffixWith("\n"); }
/* 792 */   public final T suffixWithEOL() { return suffixWith("\n"); }
/* 793 */   public final T prefixWithEOL() { return prefixWith("\n"); }
/* 794 */   public final T prefixOnceWithEOL() { return prefixOnceWith("\n"); } public final T suffixOnceWithEOL() {
/* 795 */     return suffixOnceWith("\n");
/*     */   }
/* 797 */   public final T appendSpace() { return suffixWith(" "); }
/* 798 */   public final T suffixWithSpace() { return suffixWith(" "); }
/* 799 */   public final T prefixWithSpace() { return prefixWith(" "); }
/* 800 */   public final T appendSpaces(int paramInt) { return suffixWith(RepeatedSequence.ofSpaces(paramInt)); }
/* 801 */   public final T suffixWithSpaces(int paramInt) { return suffixWith(RepeatedSequence.ofSpaces(paramInt)); }
/* 802 */   public final T prefixWithSpaces(int paramInt) { return prefixWith(RepeatedSequence.ofSpaces(paramInt)); }
/* 803 */   public final T prefixOnceWithSpace() { return prefixOnceWith(" "); } public final T suffixOnceWithSpace() {
/* 804 */     return suffixOnceWith(" ");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T prefixWith(CharSequence paramCharSequence) {
/* 810 */     return (T)((paramCharSequence == null || paramCharSequence.length() == 0) ? this : (IRichSequence)getBuilder().add(paramCharSequence).add(this).toSequence());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T suffixWith(CharSequence paramCharSequence) {
/* 817 */     if (paramCharSequence == null || paramCharSequence.length() == 0) return (T)this; 
/* 818 */     return (T)getBuilder().add(this).add(paramCharSequence).toSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T prefixOnceWith(CharSequence paramCharSequence) {
/* 824 */     return (T)((paramCharSequence == null || paramCharSequence.length() == 0 || startsWith(paramCharSequence)) ? this : (Object)prefixWith(paramCharSequence));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T suffixOnceWith(CharSequence paramCharSequence) {
/* 830 */     return (T)((paramCharSequence == null || paramCharSequence.length() == 0 || endsWith(paramCharSequence)) ? this : (Object)suffixWith(paramCharSequence));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T replace(int paramInt1, int paramInt2, CharSequence paramCharSequence) {
/* 836 */     int i = length();
/* 837 */     paramInt1 = Math.max(paramInt1, 0);
/* 838 */     paramInt2 = Math.min(paramInt2, i);
/*     */     
/*     */     Object object;
/* 841 */     return (T)(object = getBuilder()).add((CharSequence)subSequence(0, paramInt1)).add(paramCharSequence).add((CharSequence)subSequence(paramInt2)).toSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T replace(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*     */     int[] arrayOfInt;
/* 848 */     if ((arrayOfInt = indexOfAll(paramCharSequence1)).length == 0) return (T)this; 
/* 849 */     Object object = getBuilder();
/*     */     
/* 851 */     int i = arrayOfInt.length;
/* 852 */     int j = length();
/*     */     
/* 854 */     byte b = 0;
/* 855 */     int k = 0;
/* 856 */     while (b < i) {
/* 857 */       int m = arrayOfInt[b++];
/* 858 */       if (k < m) object.add((CharSequence)subSequence(k, m)); 
/* 859 */       k = m + paramCharSequence1.length();
/* 860 */       object.add(paramCharSequence2);
/*     */     } 
/*     */     
/* 863 */     if (k < j) {
/* 864 */       object.add((CharSequence)subSequence(k, j));
/*     */     }
/*     */     
/* 867 */     return (T)object.toSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T append(CharSequence... paramVarArgs) {
/* 873 */     return append((Iterable<? extends CharSequence>)new ArrayIterable((Object[])paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T append(Iterable<? extends CharSequence> paramIterable) {
/*     */     Object object;
/* 880 */     (object = getBuilder()).add(this);
/* 881 */     for (CharSequence charSequence : paramIterable) {
/* 882 */       object.add(charSequence);
/*     */     }
/* 884 */     return (T)object.toSequence();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T extractRanges(Range... paramVarArgs) {
/* 890 */     return extractRanges((Iterable<Range>)new ArrayIterable((Object[])paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final T extractRanges(Iterable<Range> paramIterable) {
/* 896 */     Object object = getBuilder();
/* 897 */     for (Iterator<Range> iterator = paramIterable.iterator(); iterator.hasNext();) {
/* 898 */       if ((range = iterator.next()) != null && !range.isNull()) object.add(range.safeSubSequence(this)); 
/*     */     } 
/* 900 */     return (T)object.toSequence();
/*     */   }
/*     */   
/*     */   public final int columnAtIndex(int paramInt) {
/* 904 */     return SequenceUtils.columnAtIndex(this, paramInt); } public final Pair<Integer, Integer> lineColumnAtIndex(int paramInt) {
/* 905 */     return SequenceUtils.lineColumnAtIndex(this, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIn(String[] paramArrayOfString) {
/* 910 */     return SequenceUtils.containedBy(paramArrayOfString, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIn(Collection<? extends CharSequence> paramCollection) {
/* 915 */     return SequenceUtils.containedBy(paramCollection, this);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\IRichSequenceBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */