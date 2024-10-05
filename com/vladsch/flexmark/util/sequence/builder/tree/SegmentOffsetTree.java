/*     */ package com.vladsch.flexmark.util.sequence.builder.tree;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.DelimitedBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.BasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
/*     */ import com.vladsch.flexmark.util.sequence.builder.Seg;
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
/*     */ public class SegmentOffsetTree
/*     */   extends SegmentTree
/*     */ {
/*     */   protected final int[] startIndices;
/*     */   
/*     */   protected SegmentOffsetTree(int[] paramArrayOfint1, byte[] paramArrayOfbyte, int[] paramArrayOfint2) {
/*  24 */     super(paramArrayOfint1, paramArrayOfbyte);
/*  25 */     this.startIndices = paramArrayOfint2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SegmentOffsetTree build(Iterable<Seg> paramIterable, CharSequence paramCharSequence) {
/*  30 */     SegmentTree.SegmentTreeData segmentTreeData = buildTreeData(paramIterable, paramCharSequence, false);
/*  31 */     assert segmentTreeData.startIndices != null;
/*  32 */     return new SegmentOffsetTree(segmentTreeData.treeData, segmentTreeData.segmentBytes, segmentTreeData.startIndices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SegmentOffsetTree build(BasedSegmentBuilder paramBasedSegmentBuilder) {
/*  37 */     SegmentTree.SegmentTreeData segmentTreeData = buildTreeData(paramBasedSegmentBuilder.getSegments(), paramBasedSegmentBuilder.getText(), true);
/*  38 */     return (new SegmentTree(segmentTreeData.treeData, segmentTreeData.segmentBytes)).getSegmentOffsetTree(paramBasedSegmentBuilder.getBaseSequence());
/*     */   }
/*     */ 
/*     */   
/*     */   public static SegmentOffsetTree build(BasedSequence paramBasedSequence) {
/*  43 */     return paramBasedSequence.getSegmentTree().getSegmentOffsetTree(paramBasedSequence);
/*     */   }
/*     */   
/*     */   public int endOffset(int paramInt) {
/*  47 */     return super.aggrLength(paramInt);
/*     */   }
/*     */   
/*     */   public int getStartIndex(int paramInt) {
/*  51 */     return (paramInt < 0) ? 0 : ((paramInt >= this.startIndices.length) ? this.startIndices[this.startIndices.length - 1] : this.startIndices[paramInt]);
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment getSegment(int paramInt, BasedSequence paramBasedSequence) {
/*  56 */     return Segment.getSegment(this.segmentBytes, byteOffset(paramInt), paramInt, this.startIndices[paramInt], paramBasedSequence);
/*     */   }
/*     */   
/*     */   public SegmentTreePos findSegmentPosByOffset(int paramInt) {
/*  60 */     return findSegmentPos(paramInt, this.treeData, 0, size());
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment getPreviousText(Segment paramSegment, BasedSequence paramBasedSequence) {
/*  65 */     if (paramSegment.getPos() == 0) {
/*  66 */       if (paramSegment.getStartIndex() > 0 && (
/*     */         
/*  68 */         paramSegment = getSegment(0, -1, 0, paramBasedSequence)).isText()) return paramSegment;
/*     */     
/*     */     } else {
/*  71 */       paramSegment = getSegment(paramSegment.getPos() - 1, paramBasedSequence);
/*  72 */       return getNextText(paramSegment, paramBasedSequence);
/*     */     } 
/*  74 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment getNextText(Segment paramSegment, BasedSequence paramBasedSequence) {
/*  79 */     if (paramSegment.getByteOffset() + paramSegment.getByteLength() < this.segmentBytes.length && (
/*     */       
/*  81 */       paramSegment = getSegment(paramSegment.getByteOffset() + paramSegment.getByteLength(), -1, paramSegment.getEndIndex(), paramBasedSequence)).isText()) return paramSegment;
/*     */     
/*  83 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Segment findSegmentByOffset(int paramInt, BasedSequence paramBasedSequence, Segment paramSegment) {
/*  88 */     int i = size();
/*     */     
/*     */     SegmentTreePos segmentTreePos;
/*  91 */     if ((segmentTreePos = super.findSegmentPos(paramInt, 0, i)) != null) {
/*  92 */       return Segment.getSegment(this.segmentBytes, byteOffset(segmentTreePos.pos), segmentTreePos.pos, this.startIndices[segmentTreePos.pos], paramBasedSequence);
/*     */     }
/*     */     
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(BasedSequence paramBasedSequence) {
/*     */     DelimitedBuilder delimitedBuilder;
/* 101 */     (delimitedBuilder = new DelimitedBuilder(", ")).append(getClass().getSimpleName()).append("{aggr: {");
/* 102 */     int i = size(); int j;
/* 103 */     for (j = 0; j < i; j++) {
/* 104 */       delimitedBuilder.append("[").append(aggrLength(j)).append(", ").append(byteOffset(j)).append(":");
/* 105 */       delimitedBuilder.append(", :").append(this.startIndices[j]);
/* 106 */       delimitedBuilder.append("]").mark();
/*     */     } 
/*     */     
/* 109 */     delimitedBuilder.unmark().append(" }, seg: { ");
/* 110 */     j = 0;
/* 111 */     while (j < this.segmentBytes.length) {
/* 112 */       Segment segment = Segment.getSegment(this.segmentBytes, j, 0, 0, paramBasedSequence);
/* 113 */       delimitedBuilder.append(j).append(":").append(segment).mark();
/* 114 */       j += segment.getByteLength();
/*     */     } 
/* 116 */     delimitedBuilder.unmark().append(" } }");
/* 117 */     return delimitedBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean hasPreviousAnchor(int paramInt) {
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int previousAnchorOffset(int paramInt) {
/* 129 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int aggrLength(int paramInt) {
/* 136 */     return super.aggrLength(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public SegmentTreePos findSegmentPos(int paramInt) {
/* 142 */     throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Segment findSegment(int paramInt, BasedSequence paramBasedSequence, Segment paramSegment) {
/* 148 */     throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Segment findSegment(int paramInt1, int paramInt2, int paramInt3, BasedSequence paramBasedSequence, Segment paramSegment) {
/* 154 */     throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public SegmentTreeRange getSegmentRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BasedSequence paramBasedSequence, Segment paramSegment) {
/* 160 */     return super.getSegmentRange(paramInt1, paramInt2, paramInt3, paramInt4, paramBasedSequence, paramSegment);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder, SegmentTreeRange paramSegmentTreeRange) {
/* 166 */     throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addSegments(IBasedSegmentBuilder<?> paramIBasedSegmentBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 172 */     throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public SegmentTreePos findSegmentPos(int paramInt1, int paramInt2, int paramInt3) {
/* 178 */     throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Segment getPrevAnchor(int paramInt, BasedSequence paramBasedSequence) {
/* 184 */     throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\tree\SegmentOffsetTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */