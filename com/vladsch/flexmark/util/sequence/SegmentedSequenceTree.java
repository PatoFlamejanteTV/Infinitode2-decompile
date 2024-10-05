/*     */ package com.vladsch.flexmark.util.sequence;
/*     */ 
/*     */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.Segment;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
/*     */ import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTreeRange;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SegmentedSequenceTree
/*     */   extends SegmentedSequence
/*     */ {
/*     */   private final SegmentTree segmentTree;
/*     */   private final int startIndex;
/*     */   private final int startPos;
/*     */   private final int endPos;
/*  22 */   private final ThreadLocal<Cache> cache = new ThreadLocal<>();
/*     */   
/*     */   private static class Cache {
/*     */     final Segment segment;
/*     */     final CharSequence chars;
/*     */     final int indexDelta;
/*     */     
/*     */     public Cache(Segment param1Segment, CharSequence param1CharSequence, int param1Int) {
/*  30 */       this.segment = param1Segment;
/*  31 */       this.chars = param1CharSequence;
/*  32 */       this.indexDelta = param1Int - param1Segment.getStartIndex();
/*     */     }
/*     */     
/*     */     public char charAt(int param1Int) {
/*  36 */       return this.chars.charAt(param1Int + this.indexDelta);
/*     */     }
/*     */     
/*     */     public int charIndex(int param1Int) {
/*  40 */       return param1Int + this.indexDelta;
/*     */     }
/*     */   }
/*     */   
/*     */   private SegmentedSequenceTree(BasedSequence paramBasedSequence, int paramInt1, int paramInt2, int paramInt3, SegmentTree paramSegmentTree) {
/*  45 */     super(paramBasedSequence, paramInt1, paramInt2, paramInt3);
/*  46 */     this.segmentTree = paramSegmentTree;
/*  47 */     this.startIndex = 0;
/*  48 */     this.startPos = 0;
/*  49 */     this.endPos = paramSegmentTree.size();
/*     */   }
/*     */   
/*     */   private SegmentedSequenceTree(BasedSequence paramBasedSequence, SegmentTree paramSegmentTree, SegmentTreeRange paramSegmentTreeRange) {
/*  53 */     super(paramBasedSequence, paramSegmentTreeRange.startOffset, paramSegmentTreeRange.endOffset, paramSegmentTreeRange.length);
/*  54 */     this.segmentTree = paramSegmentTree;
/*  55 */     this.startIndex = paramSegmentTreeRange.startIndex;
/*  56 */     this.startPos = paramSegmentTreeRange.startPos;
/*  57 */     this.endPos = paramSegmentTreeRange.endPos;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Cache getCache(int paramInt) {
/*     */     Cache cache;
/*  64 */     if ((cache = this.cache.get()) == null || cache.segment.notInSegment(paramInt + this.startIndex)) {
/*  65 */       Segment segment = this.segmentTree.findSegment(paramInt + this.startIndex, this.startPos, this.endPos, this.baseSeq, (cache == null) ? null : cache.segment);
/*  66 */       assert segment != null;
/*     */       
/*  68 */       cache = new Cache(segment, segment.getCharSequence(), this.startIndex);
/*  69 */       this.cache.set(cache);
/*     */     } 
/*  71 */     return cache;
/*     */   }
/*     */ 
/*     */   
/*     */   private Segment getCachedSegment() {
/*     */     Cache cache;
/*  77 */     return ((cache = this.cache.get()) == null) ? null : cache.segment;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getIndexOffset(int paramInt) {
/*  82 */     if (paramInt == this.length) {
/*     */       Cache cache1;
/*     */       CharSequence charSequence1;
/*  85 */       if (charSequence1 = (cache1 = getCache(paramInt - 1)).chars instanceof BasedSequence) {
/*  86 */         return ((BasedSequence)charSequence1).getIndexOffset(cache1.charIndex(paramInt));
/*     */       }
/*  88 */       return -1;
/*     */     } 
/*     */     
/*  91 */     SequenceUtils.validateIndexInclusiveEnd(paramInt, length());
/*     */     
/*     */     Cache cache;
/*     */     CharSequence charSequence;
/*  95 */     if (charSequence = (cache = getCache(paramInt)).chars instanceof BasedSequence) {
/*  96 */       return ((BasedSequence)charSequence).getIndexOffset(cache.charIndex(paramInt));
/*     */     }
/*  98 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder) {
/* 105 */     this.segmentTree.addSegments(paramIBasedSegmentBuilder, this.startIndex, this.startIndex + this.length, this.startOffset, this.endOffset, this.startPos, this.endPos);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final SegmentTree getSegmentTree() {
/* 111 */     return this.segmentTree;
/*     */   }
/*     */ 
/*     */   
/*     */   public final char charAt(int paramInt) {
/* 116 */     SequenceUtils.validateIndex(paramInt, length());
/* 117 */     return getCache(paramInt).charAt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BasedSequence subSequence(int paramInt1, int paramInt2) {
/* 123 */     if (paramInt1 == 0 && paramInt2 == this.length) {
/* 124 */       return this;
/*     */     }
/* 126 */     SequenceUtils.validateStartEnd(paramInt1, paramInt2, length());
/* 127 */     SegmentTreeRange segmentTreeRange = this.segmentTree.getSegmentRange(paramInt1 + this.startIndex, paramInt2 + this.startIndex, this.startPos, this.endPos, this.baseSeq, getCachedSegment());
/* 128 */     return new SegmentedSequenceTree(this.baseSeq, this.segmentTree, segmentTreeRange);
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
/*     */   public static SegmentedSequenceTree create(BasedSequence paramBasedSequence, ISegmentBuilder<?> paramISegmentBuilder) {
/* 140 */     SegmentTree segmentTree = SegmentTree.build(paramISegmentBuilder.getSegments(), paramISegmentBuilder.getText());
/*     */     SegmentedSequenceStats segmentedSequenceStats;
/* 142 */     if (paramBasedSequence.anyOptions(F_COLLECT_SEGMENTED_STATS) && (
/*     */       
/* 144 */       segmentedSequenceStats = paramBasedSequence.getOption((DataKeyBase<SegmentedSequenceStats>)SEGMENTED_STATS)) != null) {
/* 145 */       segmentedSequenceStats.addStats(paramISegmentBuilder.noAnchorsSize(), paramISegmentBuilder.length(), ((segmentTree.getTreeData()).length << 2) + (segmentTree.getSegmentBytes()).length);
/*     */     }
/*     */ 
/*     */     
/* 149 */     return new SegmentedSequenceTree(paramBasedSequence.getBaseSequence(), paramISegmentBuilder.getStartOffset(), paramISegmentBuilder.getEndOffset(), paramISegmentBuilder.length(), segmentTree);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\SegmentedSequenceTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */