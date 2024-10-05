/*     */ package com.vladsch.flexmark.util.sequence.builder;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.CharPredicate;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ import com.vladsch.flexmark.util.sequence.SegmentedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SequenceUtils;
/*     */ import java.util.HashMap;
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
/*     */ public class SequenceBuilder
/*     */   implements ISequenceBuilder<SequenceBuilder, BasedSequence>
/*     */ {
/*     */   private final BasedSegmentBuilder segments;
/*     */   private final BasedSequence baseSeq;
/*     */   private final BasedSequence altBase;
/*     */   private final HashMap<BasedSequence, Boolean> equivalentBases;
/*     */   private BasedSequence resultSeq;
/*     */   
/*     */   private SequenceBuilder(BasedSequence paramBasedSequence, SegmentOptimizer paramSegmentOptimizer) {
/*  35 */     this(paramBasedSequence, paramSegmentOptimizer, new HashMap<>());
/*     */   }
/*     */   
/*     */   private SequenceBuilder(BasedSequence paramBasedSequence, SegmentOptimizer paramSegmentOptimizer, HashMap<BasedSequence, Boolean> paramHashMap) {
/*  39 */     this.altBase = paramBasedSequence;
/*  40 */     this.baseSeq = paramBasedSequence.getBaseSequence();
/*  41 */     this.equivalentBases = paramHashMap;
/*  42 */     int i = PlainSegmentBuilder.F_DEFAULT;
/*     */     
/*  44 */     if (!this.baseSeq.anyOptions(BasedSequence.F_FULL_SEGMENTED_SEQUENCES) || this.baseSeq.anyOptions(BasedSequence.F_COLLECT_FIRST256_STATS)) i |= PlainSegmentBuilder.F_TRACK_FIRST256; 
/*  45 */     if (this.baseSeq.anyOptions(BasedSequence.F_NO_ANCHORS)) i &= PlainSegmentBuilder.F_INCLUDE_ANCHORS ^ 0xFFFFFFFF; 
/*  46 */     this.segments = (paramSegmentOptimizer == null) ? BasedSegmentBuilder.emptyBuilder(this.baseSeq, i) : BasedSegmentBuilder.emptyBuilder(this.baseSeq, paramSegmentOptimizer, i);
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
/*     */   private SequenceBuilder(BasedSequence paramBasedSequence, int paramInt, SegmentOptimizer paramSegmentOptimizer, HashMap<BasedSequence, Boolean> paramHashMap) {
/*  62 */     this.altBase = paramBasedSequence;
/*  63 */     this.baseSeq = paramBasedSequence.getBaseSequence();
/*  64 */     this.equivalentBases = paramHashMap;
/*     */     
/*  66 */     if (!this.baseSeq.anyOptions(BasedSequence.F_FULL_SEGMENTED_SEQUENCES) || this.baseSeq.anyOptions(BasedSequence.F_COLLECT_FIRST256_STATS)) paramInt |= PlainSegmentBuilder.F_TRACK_FIRST256; 
/*  67 */     if (this.baseSeq.anyOptions(BasedSequence.F_NO_ANCHORS)) paramInt &= PlainSegmentBuilder.F_INCLUDE_ANCHORS ^ 0xFFFFFFFF; 
/*  68 */     this.segments = (paramSegmentOptimizer == null) ? BasedSegmentBuilder.emptyBuilder(this.baseSeq, paramInt) : BasedSegmentBuilder.emptyBuilder(this.baseSeq, paramSegmentOptimizer, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getBaseSequence() {
/*  73 */     return this.baseSeq;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSegmentBuilder getSegmentBuilder() {
/*  78 */     return this.segments;
/*     */   }
/*     */ 
/*     */   
/*     */   public Range getLastRangeOrNull() {
/*     */     Object object;
/*  84 */     if (object = this.segments.getPart(this.segments.size()) instanceof Range && ((Range)object).isNotNull()) return (Range)object;  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getSingleBasedSequence() {
/*     */     Range range;
/*  91 */     return ((range = this.segments.getBaseSubSequenceRange()) == null) ? null : this.baseSeq.subSequence(range.getStart(), range.getEnd());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SequenceBuilder getBuilder() {
/*  97 */     return new SequenceBuilder(this.altBase, this.segments.options, this.segments.optimizer, this.equivalentBases);
/*     */   }
/*     */ 
/*     */   
/*     */   public char charAt(int paramInt) {
/* 102 */     return toSequence().charAt(paramInt);
/*     */   }
/*     */   
/*     */   boolean isCommonBaseSequence(BasedSequence paramBasedSequence) {
/* 106 */     if (paramBasedSequence.isNull()) return false;
/*     */ 
/*     */     
/* 109 */     if ((paramBasedSequence = paramBasedSequence.getBaseSequence()) == this.baseSeq) return true;
/*     */ 
/*     */     
/*     */     Boolean bool1;
/* 113 */     if ((bool1 = this.equivalentBases.get(paramBasedSequence)) != null) return bool1.booleanValue();
/*     */     
/* 115 */     boolean bool = this.baseSeq.equals(paramBasedSequence);
/* 116 */     this.equivalentBases.put(paramBasedSequence, Boolean.valueOf(bool));
/* 117 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SequenceBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 123 */     if (paramCharSequence instanceof BasedSequence && isCommonBaseSequence((BasedSequence)paramCharSequence)) {
/* 124 */       if (((BasedSequence)paramCharSequence).isNotNull()) {
/* 125 */         if (paramInt1 == 0 && paramInt2 == paramCharSequence.length()) {
/* 126 */           ((BasedSequence)paramCharSequence).addSegments(this.segments);
/*     */         } else {
/* 128 */           ((BasedSequence)paramCharSequence).subSequence(paramInt1, paramInt2).addSegments(this.segments);
/*     */         } 
/* 130 */         this.resultSeq = null;
/*     */       } 
/* 132 */     } else if (paramCharSequence != null && paramInt1 < paramInt2) {
/* 133 */       if (paramInt1 == 0 && paramInt2 == paramCharSequence.length()) {
/* 134 */         this.segments.append(paramCharSequence);
/*     */       } else {
/* 136 */         this.segments.append(paramCharSequence.subSequence(paramInt1, paramInt2));
/*     */       } 
/* 138 */       this.resultSeq = null;
/*     */     } 
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SequenceBuilder append(char paramChar) {
/* 145 */     this.segments.append(paramChar);
/* 146 */     this.resultSeq = null;
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SequenceBuilder append(char paramChar, int paramInt) {
/* 152 */     if (paramInt > 0) {
/* 153 */       this.segments.append(paramChar, paramInt);
/* 154 */       this.resultSeq = null;
/*     */     } 
/* 156 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SequenceBuilder append(int paramInt1, int paramInt2) {
/* 161 */     return addByOffsets(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public SequenceBuilder append(Range paramRange) {
/* 166 */     return addRange(paramRange);
/*     */   }
/*     */ 
/*     */   
/*     */   public SequenceBuilder addRange(Range paramRange) {
/* 171 */     this.segments.append(paramRange);
/* 172 */     this.resultSeq = null;
/* 173 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SequenceBuilder addByOffsets(int paramInt1, int paramInt2) {
/* 178 */     if (paramInt1 < 0 || paramInt1 > paramInt2 || paramInt2 > this.baseSeq.length()) {
/* 179 */       throw new IllegalArgumentException("addByOffsets start/end must be a valid range in [0, " + this.baseSeq.length() + "], got: [" + paramInt1 + ", " + paramInt2 + "]");
/*     */     }
/* 181 */     this.segments.append(Range.of(paramInt1, paramInt2));
/* 182 */     this.resultSeq = null;
/* 183 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SequenceBuilder addByLength(int paramInt1, int paramInt2) {
/* 188 */     return add((CharSequence)this.baseSeq.subSequence(paramInt1, paramInt1 + paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence toSequence() {
/* 194 */     if (this.resultSeq == null) {
/* 195 */       this.resultSeq = SegmentedSequence.create(this);
/*     */     }
/* 197 */     return this.resultSeq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence toSequence(BasedSequence paramBasedSequence) {
/* 208 */     return toSequence(paramBasedSequence, (CharPredicate)null, (CharPredicate)null);
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
/*     */   public BasedSequence toSequence(BasedSequence paramBasedSequence, CharPredicate paramCharPredicate1, CharPredicate paramCharPredicate2) {
/* 221 */     if (paramBasedSequence == this.altBase) {
/* 222 */       return toSequence();
/*     */     }
/*     */     
/* 225 */     assert paramBasedSequence.equals(this.altBase) : String.format("altSequence must be character identical to builder.altBase\naltBase: '%s'\n altSeq: '%s'\n", new Object[] { this.altBase
/*     */ 
/*     */           
/* 228 */           .toVisibleWhitespaceString(), paramBasedSequence.toVisibleWhitespaceString() });
/*     */ 
/*     */     
/* 231 */     SequenceBuilder sequenceBuilder = new SequenceBuilder(paramBasedSequence, this.segments.options, this.segments.optimizer, new HashMap<>());
/*     */     
/* 233 */     int i = 0;
/* 234 */     for (Iterator<Object> iterator = this.segments.iterator(); iterator.hasNext(); ) {
/* 235 */       Range range; if (range = (Range)iterator.next() instanceof Range) {
/* 236 */         BasedSequence basedSequence = paramBasedSequence.subSequence(i + ((Range)range).getStart(), i + ((Range)range).getEnd());
/*     */         
/*     */         byte b;
/* 239 */         if (b = (paramCharPredicate1 == null) ? 0 : basedSequence.countLeading(paramCharPredicate1)) {
/* 240 */           i += b;
/* 241 */           basedSequence = paramBasedSequence.subSequence(i + range.getStart(), i + range.getEnd());
/*     */         } 
/*     */         
/* 244 */         sequenceBuilder.append((CharSequence)basedSequence); continue;
/* 245 */       }  if (range instanceof CharSequence) {
/* 246 */         sequenceBuilder.append((CharSequence)range); continue;
/* 247 */       }  if (range != null) {
/* 248 */         throw new IllegalStateException("Invalid part type " + range.getClass());
/*     */       }
/*     */     } 
/*     */     
/* 252 */     BasedSequence basedSequence1 = SegmentedSequence.create(sequenceBuilder);
/* 253 */     BasedSequence basedSequence2 = toSequence();
/* 254 */     assert SequenceUtils.compare((CharSequence)basedSequence1, (CharSequence)basedSequence2, false, paramCharPredicate2) == 0 : String.format("result must be character identical to builder.toSequence()\nresult: '%s'\n sequence: '%s'\n", new Object[] { basedSequence1
/*     */ 
/*     */           
/* 257 */           .toVisibleWhitespaceString(), basedSequence2.toVisibleWhitespaceString() });
/* 258 */     return basedSequence1;
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
/*     */   public BasedSequence toSequenceByIndex(BasedSequence paramBasedSequence, CharPredicate paramCharPredicate1, CharPredicate paramCharPredicate2) {
/* 271 */     if (paramBasedSequence == this.altBase) {
/* 272 */       return toSequence();
/*     */     }
/*     */     
/* 275 */     assert paramBasedSequence.equals(this.altBase) : String.format("altSequence must be character identical to builder.altBase\naltBase: '%s'\n altSeq: '%s'\n", new Object[] { this.altBase
/*     */ 
/*     */           
/* 278 */           .toVisibleWhitespaceString(), paramBasedSequence.toVisibleWhitespaceString() });
/*     */ 
/*     */     
/* 281 */     SequenceBuilder sequenceBuilder = new SequenceBuilder(paramBasedSequence, this.segments.options, this.segments.optimizer, new HashMap<>());
/*     */     
/* 283 */     int i = 0;
/* 284 */     int j = 0;
/* 285 */     for (Iterator<Object> iterator = this.segments.iterator(); iterator.hasNext(); ) {
/* 286 */       Range range; if (range = (Range)iterator.next() instanceof Range) {
/* 287 */         BasedSequence basedSequence = paramBasedSequence.subSequence(i + j, i + j + ((Range)range).getSpan());
/*     */         
/*     */         byte b;
/* 290 */         if (b = (paramCharPredicate1 == null) ? 0 : basedSequence.countLeading(paramCharPredicate1)) {
/*     */           
/* 292 */           j += b;
/* 293 */           basedSequence = paramBasedSequence.subSequence(i + j, i + j + range.getSpan());
/*     */         } 
/*     */         
/* 296 */         sequenceBuilder.append((CharSequence)basedSequence);
/* 297 */         i += range.getSpan(); continue;
/* 298 */       }  if (range instanceof CharSequence) {
/* 299 */         sequenceBuilder.append((CharSequence)range);
/* 300 */         i += ((CharSequence)range).length(); continue;
/* 301 */       }  if (range != null) {
/* 302 */         throw new IllegalStateException("Invalid part type " + range.getClass());
/*     */       }
/*     */     } 
/*     */     
/* 306 */     BasedSequence basedSequence1 = SegmentedSequence.create(sequenceBuilder);
/* 307 */     BasedSequence basedSequence2 = toSequence();
/*     */     
/* 309 */     assert SequenceUtils.compare((CharSequence)basedSequence1, (CharSequence)basedSequence2, false, paramCharPredicate2) == 0 : String.format("result must be character identical to builder.toSequence()\nresult: '%s'\n sequence: '%s'\n", new Object[] { basedSequence1
/*     */ 
/*     */           
/* 312 */           .toVisibleWhitespaceString(), basedSequence2.toVisibleWhitespaceString() });
/* 313 */     return basedSequence1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 318 */     return this.segments.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toStringWithRanges() {
/* 323 */     return this.segments.toStringWithRangesVisibleWhitespace((CharSequence)this.baseSeq);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toStringWithRanges(boolean paramBoolean) {
/* 328 */     return paramBoolean ? this.segments.toStringWithRangesVisibleWhitespace((CharSequence)this.baseSeq) : this.segments.toStringWithRanges((CharSequence)this.baseSeq);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 333 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 335 */     for (Iterator<Object> iterator = this.segments.iterator(); iterator.hasNext(); ) {
/* 336 */       BasedSequence basedSequence; if (basedSequence = (BasedSequence)iterator.next() instanceof Range) {
/*     */ 
/*     */         
/* 339 */         if ((basedSequence = this.baseSeq.subSequence(((Range)basedSequence).getStart(), ((Range)basedSequence).getEnd())).isNotEmpty()) {
/* 340 */           basedSequence.appendTo(stringBuilder);
/*     */         }
/*     */         continue;
/*     */       } 
/* 344 */       if (basedSequence instanceof CharSequence) {
/* 345 */         stringBuilder.append(basedSequence); continue;
/*     */       } 
/* 347 */       if (basedSequence != null) {
/* 348 */         throw new IllegalStateException("Invalid part type " + basedSequence.getClass());
/*     */       }
/*     */     } 
/* 351 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toStringNoAddedSpaces() {
/* 356 */     StringBuilder stringBuilder = new StringBuilder();
/* 357 */     for (Iterator<Object> iterator = this.segments.iterator(); iterator.hasNext(); ) {
/* 358 */       Range range; if (range = (Range)iterator.next() instanceof Range) {
/* 359 */         stringBuilder.append((CharSequence)this.baseSeq.subSequence(((Range)range).getStart(), ((Range)range).getEnd())); continue;
/* 360 */       }  if (range instanceof CharSequence) {
/* 361 */         stringBuilder.append(range); continue;
/* 362 */       }  if (range != null) {
/* 363 */         throw new IllegalStateException("Invalid part type " + range.getClass());
/*     */       }
/*     */     } 
/* 366 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static SequenceBuilder emptyBuilder(BasedSequence paramBasedSequence) {
/* 371 */     return new SequenceBuilder(paramBasedSequence, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SequenceBuilder emptyBuilder(BasedSequence paramBasedSequence, SegmentOptimizer paramSegmentOptimizer) {
/* 376 */     return new SequenceBuilder(paramBasedSequence, paramSegmentOptimizer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SequenceBuilder emptyBuilder(BasedSequence paramBasedSequence, int paramInt) {
/* 381 */     return new SequenceBuilder(paramBasedSequence, paramInt, null, new HashMap<>());
/*     */   }
/*     */ 
/*     */   
/*     */   public static SequenceBuilder emptyBuilder(BasedSequence paramBasedSequence, int paramInt, SegmentOptimizer paramSegmentOptimizer) {
/* 386 */     return new SequenceBuilder(paramBasedSequence, paramInt, paramSegmentOptimizer, new HashMap<>());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\SequenceBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */