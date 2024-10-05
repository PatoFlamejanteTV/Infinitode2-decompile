/*     */ package com.vladsch.flexmark.util.sequence.builder;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.DelimitedBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SegmentBuilderBase<S extends SegmentBuilderBase<S>>
/*     */   implements ISegmentBuilder<S>
/*     */ {
/*     */   public static final int MIN_PART_CAPACITY = 8;
/*  20 */   public static final int[] EMPTY_PARTS = new int[0];
/*     */   
/*  22 */   protected int[] parts = EMPTY_PARTS;
/*  23 */   protected int partsSize = 0;
/*  24 */   protected int anchorsSize = 0;
/*     */   
/*  26 */   protected int startOffset = Range.NULL.getStart();
/*  27 */   protected int endOffset = Range.NULL.getEnd();
/*  28 */   protected int length = 0;
/*     */   
/*     */   protected final SegmentStats stats;
/*     */   
/*     */   protected final SegmentStats textStats;
/*     */   protected final int options;
/*  34 */   protected final StringBuilder text = new StringBuilder();
/*  35 */   protected int immutableOffset = 0;
/*     */   
/*     */   private static int[] ensureCapacity(int[] paramArrayOfint, int paramInt) {
/*  38 */     assert paramInt >= 0;
/*     */     
/*     */     int i;
/*  41 */     if ((i = paramArrayOfint.length / 2) <= paramInt) {
/*  42 */       paramInt = Math.max(8, Math.max(i + i >> 1, paramInt));
/*  43 */       return Arrays.copyOf(paramArrayOfint, paramInt << 1);
/*     */     } 
/*  45 */     return paramArrayOfint;
/*     */   }
/*     */   
/*     */   private void ensureCapacity(int paramInt) {
/*  49 */     this.parts = ensureCapacity(this.parts, paramInt + 1);
/*     */   }
/*     */   
/*     */   public void trimToSize() {
/*  53 */     if (this.parts.length > this.partsSize) {
/*  54 */       this.parts = Arrays.copyOf(this.parts, this.partsSize << 1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected SegmentBuilderBase() {
/*  59 */     this(F_INCLUDE_ANCHORS);
/*     */   }
/*     */   
/*     */   protected SegmentBuilderBase(int paramInt) {
/*  63 */     this.options = paramInt & (F_INCLUDE_ANCHORS | F_TRACK_FIRST256);
/*  64 */     this.stats = new SegmentStats(((paramInt & F_TRACK_FIRST256) != 0));
/*  65 */     this.textStats = new SegmentStats(((paramInt & F_TRACK_FIRST256) != 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStartOffset() {
/*  70 */     return (this.startOffset <= this.endOffset) ? this.startOffset : -1;
/*     */   }
/*     */   
/*     */   public boolean needStartOffset() {
/*  74 */     return (getStartOffsetIfNeeded() != -1);
/*     */   }
/*     */   
/*     */   public int getStartOffsetIfNeeded() {
/*  78 */     int i = getStartOffset();
/*  79 */     Seg seg = getSegOrNull(0);
/*  80 */     return (i != -1 && seg != null && seg.isBase() && i != seg.getStart()) ? i : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getEndOffset() {
/*  85 */     return (this.endOffset >= this.startOffset) ? this.endOffset : -1;
/*     */   }
/*     */   
/*     */   public boolean needEndOffset() {
/*  89 */     return (getEndOffsetIfNeeded() != -1);
/*     */   }
/*     */   
/*     */   public int getEndOffsetIfNeeded() {
/*  93 */     int i = getEndOffset();
/*  94 */     Seg seg = getSegOrNull(this.partsSize - 1);
/*  95 */     return (i != -1 && seg != null && seg.isBase() && i != seg.getEnd()) ? i : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 100 */     return (this.length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBaseSubSequenceRange() {
/* 105 */     return (getBaseSubSequenceRange() != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Range getBaseSubSequenceRange() {
/* 111 */     if (this.partsSize == 1 && !haveDanglingText()) {
/*     */       Seg seg;
/* 113 */       if ((seg = getSeg(this.partsSize - 1)).length() != 0 && this.anchorsSize == 1) seg = getSeg(this.partsSize - 2); 
/* 114 */       if (seg.isBase() && seg.getStart() == this.startOffset && seg.getEnd() == this.endOffset) {
/* 115 */         return seg.getRange();
/*     */       }
/*     */     } 
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean haveOffsets() {
/* 123 */     return (this.startOffset <= this.endOffset);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 128 */     return this.partsSize + (haveDanglingText() ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getText() {
/* 133 */     return this.text;
/*     */   }
/*     */ 
/*     */   
/*     */   public int noAnchorsSize() {
/* 138 */     return size() - this.anchorsSize;
/*     */   }
/*     */   
/*     */   private int computeLength() {
/* 142 */     int i = 0;
/* 143 */     int j = this.partsSize;
/* 144 */     for (byte b = 0; b < j; b++) {
/* 145 */       Seg seg = getSeg(b);
/* 146 */       i += seg.length();
/*     */     } 
/*     */     
/* 149 */     if (haveDanglingText()) {
/* 150 */       i += this.text.length() - this.immutableOffset;
/*     */     }
/* 152 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 158 */     assert this.length == computeLength() : "length:" + this.length + " != computeLength(): " + computeLength();
/* 159 */     return this.length;
/*     */   }
/*     */   
/*     */   public SegmentStats getStats() {
/* 163 */     return this.stats;
/*     */   }
/*     */   
/*     */   public boolean isTrackTextFirst256() {
/* 167 */     return this.stats.isTrackTextFirst256();
/* 168 */   } public int getTextLength() { return this.stats.getTextLength(); }
/* 169 */   public int getTextSegments() { return this.stats.getTextSegments(); }
/* 170 */   public int getTextSpaceLength() { return this.stats.getTextSpaceLength(); }
/* 171 */   public int getTextSpaceSegments() { return this.stats.getTextSpaceSegments(); }
/* 172 */   public int getTextFirst256Length() { return this.stats.getTextFirst256Length(); } public int getTextFirst256Segments() {
/* 173 */     return this.stats.getTextFirst256Segments();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Object> iterator() {
/* 179 */     return new PartsIterator(this);
/*     */   }
/*     */   
/*     */   static class PartsIterator implements Iterator<Object> {
/*     */     final SegmentBuilderBase<?> builder;
/*     */     int nextIndex;
/*     */     
/*     */     public PartsIterator(SegmentBuilderBase<?> param1SegmentBuilderBase) {
/* 187 */       this.builder = param1SegmentBuilderBase;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 192 */       return (this.nextIndex < this.builder.size());
/*     */     }
/*     */ 
/*     */     
/*     */     public Object next() {
/* 197 */       return this.builder.getPart(this.nextIndex++);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterable<Seg> getSegments() {
/* 203 */     return new SegIterable(this);
/*     */   }
/*     */   
/*     */   static class SegIterable implements Iterable<Seg> {
/*     */     final SegmentBuilderBase<?> builder;
/*     */     
/*     */     public SegIterable(SegmentBuilderBase<?> param1SegmentBuilderBase) {
/* 210 */       this.builder = param1SegmentBuilderBase;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Iterator<Seg> iterator() {
/* 216 */       return new SegmentBuilderBase.SegIterator(this.builder);
/*     */     }
/*     */   }
/*     */   
/*     */   static class SegIterator implements Iterator<Seg> {
/*     */     final SegmentBuilderBase<?> builder;
/*     */     int nextIndex;
/*     */     
/*     */     public SegIterator(SegmentBuilderBase<?> param1SegmentBuilderBase) {
/* 225 */       this.builder = param1SegmentBuilderBase;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 230 */       return (this.nextIndex < this.builder.size());
/*     */     }
/*     */ 
/*     */     
/*     */     public Seg next() {
/* 235 */       return this.builder.getSegPart(this.nextIndex++);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOptions() {
/* 241 */     return this.options;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIncludeAnchors() {
/* 246 */     return ((this.options & F_INCLUDE_ANCHORS) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSpan() {
/* 256 */     return (this.startOffset > this.endOffset) ? -1 : (this.endOffset - this.startOffset);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Seg getSegOrNull(int paramInt) {
/* 262 */     return ((paramInt = paramInt << 1) + 1 >= this.parts.length) ? null : Seg.segOf(this.parts[paramInt], this.parts[paramInt + 1]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Seg getSeg(int paramInt) {
/* 268 */     return ((paramInt = paramInt << 1) + 1 >= this.parts.length) ? Seg.NULL : Seg.segOf(this.parts[paramInt], this.parts[paramInt + 1]);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getPart(int paramInt) {
/* 273 */     if (paramInt == this.partsSize && haveDanglingText())
/*     */     {
/* 275 */       return this.text.subSequence(this.immutableOffset, this.text.length());
/*     */     }
/*     */     
/*     */     Seg seg;
/* 279 */     return (seg = ((paramInt = paramInt << 1) + 1 >= this.parts.length) ? Seg.NULL : Seg.segOf(this.parts[paramInt], this.parts[paramInt + 1])).isBase() ? seg.getRange() : (seg.isText() ? this.text.subSequence(seg.getTextStart(), seg.getTextEnd()) : Range.NULL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Seg getSegPart(int paramInt) {
/* 285 */     if (paramInt == this.partsSize && haveDanglingText())
/*     */     {
/* 287 */       return Seg.textOf(this.immutableOffset, this.text.length(), this.textStats.isTextFirst256(), this.textStats.isRepeatedText());
/*     */     }
/*     */     
/* 290 */     return ((paramInt = paramInt << 1) + 1 >= this.parts.length) ? Seg.NULL : Seg.segOf(this.parts[paramInt], this.parts[paramInt + 1]);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setSegEnd(int paramInt1, int paramInt2) {
/* 295 */     paramInt1 <<= 1;
/* 296 */     assert paramInt1 + 1 < this.parts.length;
/*     */ 
/*     */ 
/*     */     
/* 300 */     if (this.parts[paramInt1] == paramInt2)
/* 301 */     { if (this.parts[paramInt1] != this.parts[paramInt1 + 1]) this.anchorsSize++;  }
/* 302 */     else if (this.parts[paramInt1] == this.parts[paramInt1 + 1]) { this.anchorsSize--; }
/*     */     
/* 304 */     this.parts[paramInt1 + 1] = paramInt2;
/*     */   }
/*     */   
/*     */   private void addSeg(int paramInt1, int paramInt2) {
/* 308 */     ensureCapacity(this.partsSize);
/* 309 */     int i = this.partsSize << 1;
/* 310 */     this.parts[i] = paramInt1;
/* 311 */     this.parts[i + 1] = paramInt2;
/* 312 */     this.partsSize++;
/* 313 */     if (paramInt1 == paramInt2) this.anchorsSize++;
/*     */   
/*     */   }
/*     */   
/*     */   private Seg lastSegOrNull() {
/* 318 */     return (this.partsSize == 0) ? null : getSegOrNull(this.partsSize - 1);
/*     */   }
/*     */   
/*     */   protected boolean haveDanglingText() {
/* 322 */     return (this.text.length() > this.immutableOffset);
/*     */   }
/*     */   
/*     */   protected Object[] optimizeText(Object[] paramArrayOfObject) {
/* 326 */     return paramArrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object[] handleOverlap(Object[] paramArrayOfObject) {
/* 331 */     Range range1 = (Range)paramArrayOfObject[0];
/* 332 */     CharSequence charSequence = (CharSequence)paramArrayOfObject[1];
/* 333 */     Range range2 = (Range)paramArrayOfObject[2];
/*     */     
/* 335 */     assert !range1.isNull() && range1.getEnd() > range2.getStart();
/*     */     
/* 337 */     if (range1.getEnd() < range2.getEnd()) {
/*     */       
/* 339 */       if (charSequence.length() > 0) {
/*     */         
/* 341 */         paramArrayOfObject[2] = Range.of(range1.getEnd(), range2.getEnd());
/*     */       } else {
/*     */         
/* 344 */         paramArrayOfObject[0] = range1.withEnd(range2.getEnd());
/*     */ 
/*     */ 
/*     */         
/* 348 */         paramArrayOfObject[2] = Range.NULL;
/*     */       } 
/* 350 */       return paramArrayOfObject;
/*     */     } 
/*     */     paramArrayOfObject[2] = Range.NULL;
/*     */   } private void processParts(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, Function<Object[], Object[]> paramFunction) {
/* 354 */     assert paramInt1 >= 0 && paramInt2 >= 0 && paramInt1 <= paramInt2;
/*     */     
/* 356 */     CharSequence charSequence = this.text.subSequence(this.immutableOffset, this.text.length());
/* 357 */     assert paramBoolean1 || charSequence.length() > 0;
/*     */     
/*     */     Seg seg;
/* 360 */     Range range = ((seg = lastSegOrNull()) == null || !seg.isBase()) ? Range.NULL : seg.getRange();
/*     */     
/* 362 */     if (!isIncludeAnchors() && haveOffsets())
/*     */     {
/* 364 */       if (range.isNull() || range.getEnd() < this.endOffset) range = Range.emptyOf(this.endOffset);
/*     */     
/*     */     }
/* 367 */     if (!haveOffsets()) this.startOffset = paramInt1;
/*     */ 
/*     */     
/* 370 */     if (!paramBoolean1) this.endOffset = Math.max(this.endOffset, paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 378 */     Object[] arrayOfObject1, arrayOfObject2 = (Object[])(arrayOfObject1 = new Object[] { range, charSequence, paramBoolean2 ? Range.NULL : Range.of(paramInt1, paramInt2) }).clone();
/* 379 */     arrayOfObject1 = paramFunction.apply(arrayOfObject1);
/* 380 */     assert arrayOfObject1.length > 0;
/*     */     
/* 382 */     if (Arrays.equals(arrayOfObject1, arrayOfObject2)) {
/*     */       
/* 384 */       assert !paramBoolean1;
/*     */       
/* 386 */       if (paramInt2 > paramInt1 || isIncludeAnchors()) {
/*     */         
/* 388 */         if (charSequence.length() > 0) {
/* 389 */           commitText();
/*     */         }
/*     */         
/* 392 */         this.length += paramInt2 - paramInt1;
/* 393 */         addSeg(paramInt1, paramInt2);
/*     */         return;
/*     */       } 
/*     */     } else {
/* 397 */       this.textStats.commitText();
/* 398 */       this.stats.commitText();
/* 399 */       this.stats.remove(this.textStats);
/* 400 */       this.textStats.clear();
/* 401 */       this.length -= charSequence.length();
/* 402 */       this.text.delete(this.immutableOffset, this.text.length());
/*     */       
/* 404 */       if (seg != null && seg.isBase()) {
/*     */         
/* 406 */         this.length -= seg.length();
/* 407 */         this.partsSize--;
/* 408 */         if (seg.length() == 0) this.anchorsSize--;
/*     */       
/*     */       } 
/* 411 */       paramInt1 = arrayOfObject1.length;
/* 412 */       paramInt2 = Integer.MAX_VALUE;
/* 413 */       int i = Integer.MIN_VALUE;
/*     */       
/* 415 */       for (byte b = 0; b < paramInt1; b++) {
/*     */         Object object;
/* 417 */         if (object = arrayOfObject1[b] instanceof CharSequence) {
/*     */           CharSequence charSequence1;
/* 419 */           if ((charSequence1 = (CharSequence)object).length() > 0)
/* 420 */             addText(charSequence1); 
/*     */         } else {
/* 422 */           int j; if (object instanceof Range) {
/* 423 */             if (((Range)object).isNotNull()) {
/* 424 */               int k = ((Range)object).getStart();
/* 425 */               j = ((Range)object).getEnd();
/* 426 */               assert k >= 0 && j >= 0 && k <= j;
/*     */               
/* 428 */               if (paramInt2 == Integer.MAX_VALUE) paramInt2 = k;
/*     */               
/* 430 */               if (k < i) {
/* 431 */                 throw new IllegalStateException(String.format("Accumulated range [%d, %d) overlaps Transformed Range[%d]: [%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(b), Integer.valueOf(k), Integer.valueOf(j) }));
/*     */               }
/*     */               
/* 434 */               i = Math.max(i, j);
/*     */               
/*     */               boolean bool;
/*     */               
/* 438 */               if ((bool = haveDanglingText()) && paramBoolean1) {
/* 439 */                 processParts(k, j, false, false, this::optimizeText);
/*     */               } else {
/*     */                 
/* 442 */                 this.startOffset = Math.min(this.startOffset, k);
/* 443 */                 this.endOffset = Math.max(this.endOffset, j);
/*     */                 
/* 445 */                 if (k != j || isIncludeAnchors()) {
/* 446 */                   if (bool) {
/* 447 */                     commitText();
/*     */                   }
/*     */ 
/*     */                   
/* 451 */                   this.length += j - k;
/* 452 */                   addSeg(k, j);
/*     */                 } 
/*     */               } 
/*     */             } 
/* 456 */           } else if (j != null) {
/* 457 */             throw new IllegalStateException("Invalid optimized part type " + j.getClass());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private void commitText() {
/* 464 */     addSeg(Seg.getTextStart(this.immutableOffset, this.textStats.isTextFirst256()), Seg.getTextEnd(this.text.length(), this.textStats.isRepeatedText()));
/* 465 */     this.immutableOffset = this.text.length();
/* 466 */     this.stats.commitText();
/* 467 */     this.textStats.clear();
/*     */   }
/*     */   
/*     */   private void addText(CharSequence paramCharSequence) {
/* 471 */     this.length += paramCharSequence.length();
/* 472 */     this.text.append(paramCharSequence);
/*     */     
/* 474 */     this.stats.addText(paramCharSequence);
/* 475 */     this.textStats.addText(paramCharSequence);
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
/*     */   public S appendAnchor(int paramInt) {
/* 487 */     return append(paramInt, paramInt);
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
/*     */   public S append(Range paramRange) {
/* 499 */     return append(paramRange.getStart(), paramRange.getEnd());
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
/*     */   public S append(int paramInt1, int paramInt2) {
/* 512 */     if (paramInt2 < 0 || paramInt1 > paramInt2)
/*     */     {
/* 514 */       return (S)this;
/*     */     }
/*     */     int i;
/* 517 */     if ((i = paramInt2 - paramInt1) == 0 && (!isIncludeAnchors() || paramInt1 < this.endOffset)) {
/* 518 */       if (paramInt1 >= this.endOffset)
/*     */       {
/* 520 */         if (haveDanglingText()) {
/* 521 */           processParts(paramInt1, paramInt2, false, false, this::optimizeText);
/*     */         } else {
/* 523 */           if (!haveOffsets()) this.startOffset = paramInt1; 
/* 524 */           this.endOffset = paramInt1;
/*     */         } 
/*     */       }
/*     */       
/* 528 */       return (S)this;
/*     */     } 
/*     */     
/* 531 */     if (this.endOffset > paramInt1) {
/*     */       
/* 533 */       processParts(paramInt1, paramInt2, true, false, this::handleOverlap);
/* 534 */     } else if (this.endOffset == paramInt1) {
/*     */ 
/*     */       
/* 537 */       if (haveDanglingText()) {
/* 538 */         processParts(paramInt1, paramInt2, false, false, this::optimizeText);
/*     */       } else {
/* 540 */         this.endOffset = paramInt2;
/* 541 */         this.length += i;
/*     */         
/* 543 */         if (this.partsSize == 0) {
/*     */           
/* 545 */           addSeg(paramInt1, paramInt2);
/*     */         } else {
/*     */           
/* 548 */           setSegEnd(this.partsSize - 1, paramInt2);
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 554 */     else if (haveDanglingText()) {
/* 555 */       processParts(paramInt1, paramInt2, false, false, this::optimizeText);
/*     */     } else {
/* 557 */       if (!haveOffsets()) this.startOffset = paramInt1; 
/* 558 */       this.endOffset = paramInt2;
/* 559 */       this.length += i;
/* 560 */       addSeg(paramInt1, paramInt2);
/*     */     } 
/*     */ 
/*     */     
/* 564 */     return (S)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public S append(CharSequence paramCharSequence) {
/*     */     int i;
/* 570 */     if ((i = paramCharSequence.length()) != 0) {
/* 571 */       this.stats.addText(paramCharSequence);
/* 572 */       this.textStats.addText(paramCharSequence);
/*     */       
/* 574 */       this.text.append(paramCharSequence);
/* 575 */       this.length += i;
/*     */     } 
/*     */     
/* 578 */     return (S)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public S append(char paramChar) {
/* 583 */     this.stats.addText(paramChar);
/* 584 */     this.textStats.addText(paramChar);
/*     */     
/* 586 */     this.text.append(paramChar);
/* 587 */     this.length++;
/*     */ 
/*     */     
/* 590 */     return (S)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public S append(char paramChar, int paramInt) {
/* 595 */     if (paramInt > 0) {
/* 596 */       this.stats.addText(paramChar, paramInt);
/* 597 */       this.textStats.addText(paramChar, paramInt);
/* 598 */       this.length += paramInt;
/*     */       
/* 600 */       for (; paramInt-- > 0; this.text.append(paramChar));
/*     */     } 
/*     */     
/* 603 */     return (S)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Function<CharSequence, CharSequence> paramFunction) {
/* 608 */     if (this.endOffset > paramCharSequence1.length()) {
/* 609 */       throw new IllegalArgumentException("baseSequence length() must be at least " + this.endOffset + ", got: " + paramCharSequence1.length());
/*     */     }
/*     */     
/* 612 */     if (haveDanglingText() && haveOffsets()) {
/* 613 */       processParts(this.endOffset, this.endOffset, false, true, this::optimizeText);
/*     */     }
/*     */     
/* 616 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 618 */     int i = this.partsSize;
/* 619 */     for (byte b = 0; b < i; b++) {
/*     */       Seg seg;
/*     */       
/* 622 */       if (!(seg = getSeg(b)).isBase()) {
/* 623 */         stringBuilder.append(paramFunction.apply(this.text.subSequence(seg.getTextStart(), seg.getTextEnd())));
/*     */       } else {
/* 625 */         stringBuilder.append(paramCharSequence2).append(paramFunction.apply(paramCharSequence1.subSequence(seg.getStart(), seg.getEnd()))).append(paramCharSequence3);
/*     */       } 
/*     */     } 
/*     */     
/* 629 */     if (haveDanglingText()) {
/* 630 */       stringBuilder.append(paramFunction.apply(this.text.subSequence(this.immutableOffset, this.text.length())));
/*     */     }
/*     */     
/* 633 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toStringWithRangesVisibleWhitespace(CharSequence paramCharSequence) {
/* 638 */     return toString(paramCharSequence, "⟦", "⟧", SequenceUtils::toVisibleWhitespaceString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toStringWithRanges(CharSequence paramCharSequence) {
/* 643 */     return toString(paramCharSequence, "⟦", "⟧", Function.identity());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(CharSequence paramCharSequence) {
/* 648 */     return toString(paramCharSequence, "", "", Function.identity());
/*     */   }
/*     */   
/*     */   public String toStringPrep() {
/* 652 */     if (haveDanglingText() && haveOffsets()) {
/* 653 */       processParts(this.endOffset, this.endOffset, false, true, this::optimizeText);
/*     */     }
/* 655 */     return toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*     */     DelimitedBuilder delimitedBuilder;
/* 661 */     (delimitedBuilder = new DelimitedBuilder(", ")).append(getClass().getSimpleName()).append("{");
/*     */     
/* 663 */     if (haveOffsets()) {
/* 664 */       delimitedBuilder.append("[").append(this.startOffset).mark()
/* 665 */         .append(this.endOffset).unmark()
/* 666 */         .append(")").mark();
/*     */     } else {
/* 668 */       delimitedBuilder.append("NULL").mark();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 676 */     SegmentStats segmentStats = this.stats.committedCopy();
/* 677 */     delimitedBuilder.append(segmentStats).mark()
/* 678 */       .append("l=").append(this.length).mark()
/* 679 */       .append("sz=").append(size()).mark()
/* 680 */       .append("na=").append(noAnchorsSize());
/*     */ 
/*     */     
/* 683 */     if (size() > 0) delimitedBuilder.append(": ");
/*     */     
/* 685 */     int i = this.partsSize;
/* 686 */     for (byte b = 0; b < i; b++) {
/* 687 */       Seg seg = getSeg(b);
/* 688 */       delimitedBuilder.append(seg.toString(this.text)).mark();
/*     */     } 
/*     */     
/* 691 */     if (haveDanglingText()) {
/* 692 */       Seg seg = Seg.textOf(this.immutableOffset, this.text.length(), this.textStats.isTextFirst256(), this.textStats.isRepeatedText());
/* 693 */       delimitedBuilder.append(seg.toString(this.text)).mark();
/*     */     } 
/*     */     
/* 696 */     delimitedBuilder.unmark().append(" }");
/* 697 */     return delimitedBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\SegmentBuilderBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */