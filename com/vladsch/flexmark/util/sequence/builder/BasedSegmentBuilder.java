/*     */ package com.vladsch.flexmark.util.sequence.builder;
/*     */ 
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.PositionAnchor;
/*     */ import com.vladsch.flexmark.util.sequence.Range;
/*     */ 
/*     */ public class BasedSegmentBuilder
/*     */   extends SegmentBuilderBase<BasedSegmentBuilder> implements IBasedSegmentBuilder<BasedSegmentBuilder> {
/*     */   final BasedSequence baseSeq;
/*     */   final SegmentOptimizer optimizer;
/*     */   
/*     */   protected BasedSegmentBuilder(BasedSequence paramBasedSequence) {
/*  13 */     this(paramBasedSequence, new CharRecoveryOptimizer(PositionAnchor.CURRENT));
/*     */   }
/*     */ 
/*     */   
/*     */   protected BasedSegmentBuilder(BasedSequence paramBasedSequence, SegmentOptimizer paramSegmentOptimizer) {
/*  18 */     this.baseSeq = paramBasedSequence.getBaseSequence();
/*  19 */     this.optimizer = paramSegmentOptimizer;
/*     */   }
/*     */   
/*     */   protected BasedSegmentBuilder(BasedSequence paramBasedSequence, int paramInt) {
/*  23 */     this(paramBasedSequence, new CharRecoveryOptimizer(PositionAnchor.CURRENT), paramInt);
/*     */   }
/*     */   
/*     */   protected BasedSegmentBuilder(BasedSequence paramBasedSequence, SegmentOptimizer paramSegmentOptimizer, int paramInt) {
/*  27 */     super(paramInt);
/*  28 */     this.baseSeq = paramBasedSequence.getBaseSequence();
/*  29 */     this.optimizer = paramSegmentOptimizer;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getBaseSequence() {
/*  34 */     return this.baseSeq;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object[] optimizeText(Object[] paramArrayOfObject) {
/*  39 */     return this.optimizer.apply((CharSequence)this.baseSeq, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object[] handleOverlap(Object[] paramArrayOfObject) {
/*  46 */     Range range3, range1 = (Range)paramArrayOfObject[0];
/*  47 */     CharSequence charSequence = (CharSequence)paramArrayOfObject[1];
/*  48 */     Range range2 = (Range)paramArrayOfObject[2];
/*  49 */     assert !range1.isNull() && range1.getEnd() > range2.getStart();
/*     */ 
/*     */     
/*  52 */     Range range4 = Range.NULL;
/*     */     
/*  54 */     if (range2.getEnd() <= range1.getStart()) {
/*     */       
/*  56 */       range3 = range2;
/*  57 */     } else if (range2.getStart() <= range1.getStart()) {
/*     */       
/*  59 */       range3 = Range.of(range2.getStart(), Math.min(range2.getEnd(), range1.getEnd()));
/*  60 */       if (range1.getEnd() < range2.getEnd()) {
/*  61 */         range4 = Range.of(range1.getEnd(), range2.getEnd());
/*     */       }
/*  63 */     } else if (range2.getEnd() <= range1.getEnd()) {
/*     */       
/*  65 */       range3 = range2;
/*     */     } else {
/*  67 */       assert range2.getStart() < range1.getEnd();
/*  68 */       range3 = range2.withEnd(range1.getEnd());
/*  69 */       range4 = range2.withStart(range1.getEnd());
/*     */     } 
/*     */     
/*  72 */     int i = range3.getSpan();
/*  73 */     assert i + range4.getSpan() == range2.getSpan();
/*     */ 
/*     */     
/*  76 */     if (charSequence.length() == 0) {
/*  77 */       paramArrayOfObject[1] = this.baseSeq.subSequence(range3.getStart(), range3.getEnd()).toString();
/*     */     } else {
/*  79 */       paramArrayOfObject[1] = charSequence.toString() + this.baseSeq.subSequence(range3.getStart(), range3.getEnd()).toString();
/*     */     } 
/*  81 */     paramArrayOfObject[2] = range4;
/*     */     
/*  83 */     return paramArrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toStringWithRangesVisibleWhitespace() {
/*  89 */     return toStringWithRangesVisibleWhitespace((CharSequence)this.baseSeq);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toStringWithRanges() {
/*  95 */     return toStringWithRanges((CharSequence)this.baseSeq);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toStringChars() {
/* 101 */     return toString((CharSequence)this.baseSeq);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSegmentBuilder emptyBuilder(BasedSequence paramBasedSequence) {
/* 106 */     return new BasedSegmentBuilder(paramBasedSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSegmentBuilder emptyBuilder(BasedSequence paramBasedSequence, int paramInt) {
/* 111 */     return new BasedSegmentBuilder(paramBasedSequence, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSegmentBuilder emptyBuilder(BasedSequence paramBasedSequence, SegmentOptimizer paramSegmentOptimizer) {
/* 116 */     return new BasedSegmentBuilder(paramBasedSequence, paramSegmentOptimizer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BasedSegmentBuilder emptyBuilder(BasedSequence paramBasedSequence, SegmentOptimizer paramSegmentOptimizer, int paramInt) {
/* 121 */     return new BasedSegmentBuilder(paramBasedSequence, paramSegmentOptimizer, paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\BasedSegmentBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */