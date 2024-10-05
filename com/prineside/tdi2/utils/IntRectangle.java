/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ 
/*    */ public final class IntRectangle
/*    */ {
/*    */   public int minX;
/*    */   public int minY;
/*    */   public int maxX;
/*    */   public int maxY;
/*    */   
/*    */   public IntRectangle() {}
/*    */   
/*    */   public IntRectangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 14 */     this.minX = paramInt1;
/* 15 */     this.maxX = paramInt2;
/* 16 */     this.minY = paramInt3;
/* 17 */     this.maxY = paramInt4;
/*    */   }
/*    */   
/*    */   public final void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 21 */     this.minX = paramInt1;
/* 22 */     this.maxX = paramInt2;
/* 23 */     this.minY = paramInt3;
/* 24 */     this.maxY = paramInt4;
/*    */   }
/*    */   public final void setRect(IntRectangle paramIntRectangle) {
/* 27 */     this.minX = paramIntRectangle.minX;
/* 28 */     this.maxX = paramIntRectangle.maxX;
/* 29 */     this.minY = paramIntRectangle.minY;
/* 30 */     this.maxY = paramIntRectangle.maxY;
/*    */   }
/*    */   
/*    */   public final boolean contains(int paramInt1, int paramInt2) {
/* 34 */     return (this.minX <= paramInt1 && this.maxX >= paramInt1 && this.minY <= paramInt2 && this.maxY >= paramInt2);
/*    */   }
/*    */   
/*    */   public final boolean overlapsRect(IntRectangle paramIntRectangle) {
/* 38 */     return (this.minX < paramIntRectangle.maxX && this.maxX > paramIntRectangle.minX && this.minY < paramIntRectangle.maxY && this.maxY > paramIntRectangle.minY);
/*    */   }
/*    */   
/*    */   public final boolean overlaps(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 42 */     return (this.minX < paramInt3 && this.maxX > paramInt1 && this.minY < paramInt4 && this.maxY > paramInt2);
/*    */   }
/*    */   
/*    */   public final void extendToContain(int paramInt1, int paramInt2) {
/* 46 */     if (paramInt1 < this.minX) this.minX = paramInt1; 
/* 47 */     if (paramInt2 < this.minY) this.minY = paramInt2; 
/* 48 */     if (paramInt1 > this.maxX) this.maxX = paramInt1; 
/* 49 */     if (paramInt2 > this.maxY) this.maxY = paramInt2; 
/*    */   }
/*    */   
/*    */   public final void extendToContainRect(IntRectangle paramIntRectangle) {
/* 53 */     if (paramIntRectangle.minX < this.minX) this.minX = paramIntRectangle.minX; 
/* 54 */     if (paramIntRectangle.minY < this.minY) this.minY = paramIntRectangle.minY; 
/* 55 */     if (paramIntRectangle.maxX > this.maxX) this.maxX = paramIntRectangle.maxX; 
/* 56 */     if (paramIntRectangle.maxY > this.maxY) this.maxY = paramIntRectangle.maxY; 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\IntRectangle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */