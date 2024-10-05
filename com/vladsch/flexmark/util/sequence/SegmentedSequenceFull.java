/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public final class SegmentedSequenceFull
/*     */   extends SegmentedSequence
/*     */ {
/*     */   private final boolean nonBaseChars;
/*     */   private final int[] baseOffsets;
/*     */   private final int baseStartOffset;
/*     */   
/*     */   private SegmentedSequenceFull(BasedSequence paramBasedSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int[] paramArrayOfint, int paramInt4) {
/*  17 */     super(paramBasedSequence, paramInt1, paramInt2, paramInt3);
/*  18 */     this.nonBaseChars = paramBoolean;
/*  19 */     this.baseOffsets = paramArrayOfint;
/*  20 */     this.baseStartOffset = paramInt4;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getIndexOffset(int paramInt) {
/*  25 */     SequenceUtils.validateIndexInclusiveEnd(paramInt, length());
/*     */ 
/*     */     
/*  28 */     return ((paramInt = this.baseOffsets[this.baseStartOffset + paramInt]) < 0) ? -1 : paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder) {
/*  34 */     BasedUtils.generateSegments(paramIBasedSegmentBuilder, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public final char charAt(int paramInt) {
/*  39 */     SequenceUtils.validateIndex(paramInt, length());
/*     */ 
/*     */ 
/*     */     
/*  43 */     if ((paramInt = this.baseOffsets[this.baseStartOffset + paramInt]) < 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  49 */       return (char)(-paramInt - 1);
/*     */     }
/*  51 */     return this.baseSeq.charAt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence subSequence(int paramInt1, int paramInt2) {
/*  58 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, length());
/*     */     
/*  60 */     if (paramInt1 == 0 && paramInt2 == this.length) {
/*  61 */       return this;
/*     */     }
/*  63 */     return subSequence(this.baseSeq, this.baseOffsets, this.baseStartOffset + paramInt1, this.nonBaseChars, paramInt2 - paramInt1);
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
/*     */   public static SegmentedSequenceFull create(BasedSequence paramBasedSequence, ISegmentBuilder<?> paramISegmentBuilder) {
/*  75 */     paramBasedSequence = paramBasedSequence.getBaseSequence();
/*     */ 
/*     */     
/*  78 */     int i, arrayOfInt[] = new int[(i = paramISegmentBuilder.length()) + 1];
/*     */     
/*  80 */     byte b = 0;
/*  81 */     for (Iterator<Object> iterator = paramISegmentBuilder.iterator(); iterator.hasNext(); ) {
/*  82 */       Range range; if (range = (Range)iterator.next() instanceof Range) {
/*  83 */         if (!((Range)range).isEmpty()) {
/*     */           
/*  85 */           int n = range.getEnd();
/*  86 */           for (int i1 = range.getStart(); i1 < n; i1++)
/*  87 */             arrayOfInt[b++] = i1; 
/*     */         }  continue;
/*  89 */       }  if (range instanceof CharSequence) {
/*     */         CharSequence charSequence;
/*  91 */         int n = (charSequence = (CharSequence)range).length();
/*  92 */         for (byte b1 = 0; b1 < n; b1++)
/*  93 */           arrayOfInt[b++] = -charSequence.charAt(b1) - 1;  continue;
/*     */       } 
/*  95 */       if (range != null) {
/*  96 */         throw new IllegalStateException("Invalid part type " + range.getClass());
/*     */       }
/*     */     } 
/*     */     
/* 100 */     int j = arrayOfInt[i - 1];
/* 101 */     arrayOfInt[i] = (j < 0) ? (j - 1) : (j + 1);
/*     */     
/* 103 */     int k = paramISegmentBuilder.getStartOffset();
/* 104 */     int m = paramISegmentBuilder.getEndOffset();
/* 105 */     boolean bool = (paramISegmentBuilder.getTextLength() > 0) ? true : false;
/*     */     SegmentedSequenceStats segmentedSequenceStats;
/* 107 */     if (paramBasedSequence.anyOptions(F_COLLECT_SEGMENTED_STATS) && (
/*     */       
/* 109 */       segmentedSequenceStats = paramBasedSequence.getOption((DataKeyBase<SegmentedSequenceStats>)SEGMENTED_STATS)) != null) {
/* 110 */       segmentedSequenceStats.addStats(paramISegmentBuilder.noAnchorsSize(), i, arrayOfInt.length << 2);
/*     */     }
/*     */ 
/*     */     
/* 114 */     return new SegmentedSequenceFull(paramBasedSequence, k, m, i, bool, arrayOfInt, 0);
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
/*     */   private SegmentedSequenceFull subSequence(BasedSequence paramBasedSequence, int[] paramArrayOfint, int paramInt1, boolean paramBoolean, int paramInt2) {
/* 126 */     int i = paramArrayOfint.length - 1;
/* 127 */     assert paramInt1 + paramInt2 <= i : "Sub-sequence offsets list length < baseStartOffset + sub-sequence length";
/*     */     
/* 129 */     int j = 0;
/* 130 */     int k = 0;
/*     */     
/* 132 */     if (!paramBoolean) {
/* 133 */       if (paramInt1 < i) {
/*     */         
/* 135 */         j = paramArrayOfint[paramInt1];
/*     */       } else {
/* 137 */         j = paramBasedSequence.getEndOffset();
/*     */       } 
/*     */       
/* 140 */       if (paramInt2 == 0) {
/* 141 */         k = j;
/*     */       } else {
/* 143 */         k = paramArrayOfint[paramInt1 + paramInt2 - 1] + 1;
/* 144 */         assert j <= k;
/*     */       } 
/*     */     } else {
/*     */       
/* 148 */       boolean bool = false;
/*     */       
/* 150 */       for (int m = paramInt1; m < i; m++) {
/* 151 */         if (paramArrayOfint[m] >= 0) {
/* 152 */           j = paramArrayOfint[m];
/*     */           
/* 154 */           if (paramInt2 != 0)
/*     */           {
/* 156 */             for (i = paramInt1 + paramInt2; i-- > m;) {
/* 157 */               if (paramArrayOfint[i] >= 0) {
/*     */                 
/* 159 */                 k = paramArrayOfint[i] + 1;
/* 160 */                 assert j <= k;
/*     */                 
/* 162 */                 bool = true;
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/* 167 */           if (!bool) {
/* 168 */             k = j;
/*     */           }
/*     */           
/* 171 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 175 */       if (!bool)
/*     */       {
/*     */         
/* 178 */         k = j = paramBasedSequence.getEndOffset();
/*     */       }
/*     */     } 
/*     */     
/* 182 */     return new SegmentedSequenceFull(paramBasedSequence, j, k, paramInt2, paramBoolean, paramArrayOfint, paramInt1);
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
/*     */   @Deprecated
/*     */   public static BasedSequence of(BasedSequence paramBasedSequence, Iterable<? extends BasedSequence> paramIterable) {
/* 206 */     return SegmentedSequence.create(paramBasedSequence, paramIterable);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static BasedSequence of(BasedSequence... paramVarArgs) {
/* 211 */     return SegmentedSequence.create(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\SegmentedSequenceFull.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */