/*    */ package com.vladsch.flexmark.util.sequence.builder.tree;
/*    */ 
/*    */ public final class SegmentTreePos {
/*    */   public final int pos;
/*    */   public final int startIndex;
/*    */   public final int iterations;
/*    */   
/*    */   public SegmentTreePos(int paramInt1, int paramInt2, int paramInt3) {
/*  9 */     this.pos = paramInt1;
/* 10 */     this.startIndex = paramInt2;
/* 11 */     this.iterations = paramInt3;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 16 */     if (this == paramObject) return true; 
/* 17 */     if (!(paramObject instanceof SegmentTreePos)) return false;
/*    */     
/* 19 */     paramObject = paramObject;
/*    */     
/* 21 */     if (this.pos != ((SegmentTreePos)paramObject).pos) return false; 
/* 22 */     return (this.startIndex == ((SegmentTreePos)paramObject).startIndex);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 27 */     int i = this.pos;
/*    */     
/* 29 */     return i = i * 31 + this.startIndex;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 34 */     return "{" + this.pos + ", s: " + this.startIndex + ", i: " + this.iterations + '}';
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\tree\SegmentTreePos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */