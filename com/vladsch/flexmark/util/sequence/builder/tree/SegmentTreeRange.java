/*    */ package com.vladsch.flexmark.util.sequence.builder.tree;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SegmentTreeRange
/*    */ {
/*    */   public final int startIndex;
/*    */   public final int endIndex;
/*    */   public final int startOffset;
/*    */   public final int endOffset;
/*    */   public final int startPos;
/*    */   public final int endPos;
/*    */   public final int length;
/*    */   
/*    */   public SegmentTreeRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 16 */     this.startIndex = paramInt1;
/* 17 */     this.endIndex = paramInt2;
/* 18 */     this.startOffset = paramInt3;
/* 19 */     this.endOffset = paramInt4;
/* 20 */     this.startPos = paramInt5;
/* 21 */     this.endPos = paramInt6;
/* 22 */     this.length = paramInt2 - paramInt1;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 27 */     return "SegmentTreeRange{startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", startPos=" + this.startPos + ", endPos=" + this.endPos + ", length=" + this.length + '}';
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\tree\SegmentTreeRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */