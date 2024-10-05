/*     */ package com.vladsch.flexmark.util.sequence.builder.tree;
/*     */ 
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ 
/*     */ public class BasedOffsetTracker
/*     */ {
/*     */   protected final BasedSequence sequence;
/*     */   protected final SegmentOffsetTree segmentOffsetTree;
/*     */   private Segment lastSegment;
/*     */   
/*     */   protected BasedOffsetTracker(BasedSequence paramBasedSequence, SegmentTree paramSegmentTree) {
/*  13 */     this.sequence = paramBasedSequence;
/*  14 */     this.segmentOffsetTree = paramSegmentTree.getSegmentOffsetTree(paramBasedSequence.getBaseSequence());
/*     */   }
/*     */   
/*     */   protected BasedOffsetTracker(BasedSequence paramBasedSequence, SegmentOffsetTree paramSegmentOffsetTree) {
/*  18 */     this.sequence = paramBasedSequence;
/*  19 */     this.segmentOffsetTree = paramSegmentOffsetTree;
/*     */   }
/*     */   
/*     */   public int size() {
/*  23 */     return this.segmentOffsetTree.size();
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
/*     */   public OffsetInfo getOffsetInfo(int paramInt, boolean paramBoolean) {
/*     */     OffsetInfo offsetInfo;
/*     */     int i;
/*  59 */     if ((i = paramBoolean ? paramInt : (paramInt + 1)) <= this.sequence.getStartOffset()) {
/*     */       
/*  61 */       offsetInfo = new OffsetInfo(-1, paramInt, true, 0);
/*  62 */     } else if (offsetInfo >= this.sequence.getEndOffset()) {
/*     */       
/*  64 */       offsetInfo = new OffsetInfo(this.segmentOffsetTree.size(), offsetInfo, true, this.sequence.length());
/*     */     } else {
/*     */       Segment segment;
/*  67 */       if ((segment = this.segmentOffsetTree.findSegmentByOffset(offsetInfo, this.sequence.getBaseSequence(), this.lastSegment)) == null) {
/*     */         
/*  69 */         if (offsetInfo < this.segmentOffsetTree.getSegment(0, this.sequence).getStartOffset()) {
/*  70 */           offsetInfo = new OffsetInfo(-1, offsetInfo, true, 0);
/*     */         } else {
/*  72 */           if (offsetInfo < this.segmentOffsetTree.getSegment(this.segmentOffsetTree.size() - 1, this.sequence).getEndOffset())
/*     */           {
/*  74 */             throw new IllegalStateException("Unexpected");
/*     */           }
/*  76 */           offsetInfo = new OffsetInfo(this.segmentOffsetTree.size(), offsetInfo, true, this.sequence.length());
/*     */         } 
/*     */       } else {
/*  79 */         this.lastSegment = segment;
/*     */         
/*  81 */         if (i > segment.getStartOffset() && offsetInfo < segment.getEndOffset()) {
/*     */           
/*  83 */           int j = segment.getStartIndex() + offsetInfo - segment.getStartOffset();
/*  84 */           i = segment.getStartIndex() + i - segment.getStartOffset();
/*  85 */           offsetInfo = new OffsetInfo(segment.getPos(), offsetInfo, paramBoolean, j, i);
/*  86 */         } else if (i <= segment.getStartOffset()) {
/*     */           int j;
/*     */           
/*     */           Segment segment1;
/*  90 */           if ((segment1 = this.segmentOffsetTree.getPreviousText(segment, this.sequence)) != null) {
/*  91 */             j = segment1.getStartIndex();
/*  92 */             i = segment1.getEndIndex();
/*     */           } else {
/*  94 */             i = j = segment.getStartIndex();
/*     */           } 
/*  96 */           offsetInfo = new OffsetInfo(segment.getPos() - 1, offsetInfo, true, j, i);
/*  97 */         } else if (offsetInfo >= segment.getEndOffset()) {
/*     */           int j;
/*     */           
/*     */           Segment segment1;
/* 101 */           if ((segment1 = this.segmentOffsetTree.getNextText(segment, this.sequence)) != null) {
/* 102 */             j = segment1.getStartIndex();
/* 103 */             i = segment1.getEndIndex();
/*     */           } else {
/* 105 */             i = j = segment.getEndIndex();
/*     */           } 
/* 107 */           offsetInfo = new OffsetInfo(segment.getPos() + 1, offsetInfo, true, j, i);
/*     */         } else {
/* 109 */           throw new IllegalStateException(String.format("Unexpected offset: [%d, %d), seg: %s, not inside nor at start nor at end", new Object[] { Integer.valueOf(offsetInfo), Integer.valueOf(i), segment.toString() }));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 114 */     return offsetInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasedSequence getSequence() {
/* 119 */     return this.sequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public SegmentOffsetTree getSegmentOffsetTree() {
/* 124 */     return this.segmentOffsetTree;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 129 */     return "BasedOffsetTracker{tree=" + this.segmentOffsetTree + '}';
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
/*     */   public static BasedOffsetTracker create(BasedSequence paramBasedSequence) {
/* 142 */     SegmentTree segmentTree = paramBasedSequence.getSegmentTree();
/* 143 */     return new BasedOffsetTracker(paramBasedSequence, segmentTree);
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
/*     */   public static BasedOffsetTracker create(BasedSequence paramBasedSequence, SegmentOffsetTree paramSegmentOffsetTree) {
/* 155 */     return new BasedOffsetTracker(paramBasedSequence, paramSegmentOffsetTree);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\tree\BasedOffsetTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */