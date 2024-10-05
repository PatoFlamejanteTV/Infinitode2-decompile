/*    */ package com.vladsch.flexmark.util.sequence.builder.tree;
/*    */ 
/*    */ public class OffsetInfo {
/*    */   public final int pos;
/*    */   public final int offset;
/*    */   public final boolean isEndOffset;
/*    */   public final int startIndex;
/*    */   public final int endIndex;
/*    */   
/*    */   public OffsetInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
/* 11 */     this(paramInt1, paramInt2, paramBoolean, paramInt3, paramInt3);
/*    */   }
/*    */   
/*    */   public OffsetInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {
/* 15 */     this.pos = paramInt1;
/* 16 */     this.offset = paramInt2;
/* 17 */     this.isEndOffset = paramBoolean;
/* 18 */     this.startIndex = paramInt3;
/* 19 */     this.endIndex = paramInt4;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 24 */     return "OffsetInfo{ p=" + this.pos + ", o=" + (this.isEndOffset ? ("[" + this.offset + ")") : ("[" + this.offset + ", " + (this.offset + 1) + ")")) + ", i=[" + this.startIndex + ", " + this.endIndex + ") }";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\tree\OffsetInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */