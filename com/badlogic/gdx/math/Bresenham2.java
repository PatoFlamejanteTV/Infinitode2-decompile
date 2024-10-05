/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Pool;
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
/*     */ public class Bresenham2
/*     */ {
/*  29 */   private final Array<GridPoint2> points = new Array();
/*  30 */   private final Pool<GridPoint2> pool = new Pool<GridPoint2>()
/*     */     {
/*     */       protected GridPoint2 newObject() {
/*  33 */         return new GridPoint2();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<GridPoint2> line(GridPoint2 paramGridPoint21, GridPoint2 paramGridPoint22) {
/*  42 */     return line(paramGridPoint21.x, paramGridPoint21.y, paramGridPoint22.x, paramGridPoint22.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<GridPoint2> line(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  52 */     this.pool.freeAll(this.points);
/*  53 */     this.points.clear();
/*  54 */     return line(paramInt1, paramInt2, paramInt3, paramInt4, this.pool, this.points);
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
/*     */   public Array<GridPoint2> line(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Pool<GridPoint2> paramPool, Array<GridPoint2> paramArray) {
/*  67 */     paramInt3 -= paramInt1;
/*  68 */     paramInt4 -= paramInt2;
/*  69 */     byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
/*  70 */     if (paramInt3 < 0) {
/*  71 */       b1 = -1;
/*  72 */       b3 = -1;
/*  73 */     } else if (paramInt3 > 0) {
/*  74 */       b1 = 1;
/*  75 */       b3 = 1;
/*     */     } 
/*  77 */     if (paramInt4 < 0)
/*  78 */     { b2 = -1; }
/*  79 */     else if (paramInt4 > 0) { b2 = 1; }
/*  80 */      int i = Math.abs(paramInt3);
/*  81 */     int j = Math.abs(paramInt4);
/*  82 */     if (i < j) {
/*  83 */       i = Math.abs(paramInt4);
/*  84 */       j = Math.abs(paramInt3);
/*  85 */       if (paramInt4 < 0)
/*  86 */       { b4 = -1; }
/*  87 */       else if (paramInt4 > 0) { b4 = 1; }
/*  88 */        b3 = 0;
/*     */     } 
/*  90 */     paramInt3 = j << 1;
/*  91 */     paramInt4 = i << 1;
/*  92 */     j = 0;
/*  93 */     for (byte b = 0; b <= i; b++) {
/*     */       GridPoint2 gridPoint2;
/*  95 */       (gridPoint2 = (GridPoint2)paramPool.obtain()).set(paramInt1, paramInt2);
/*  96 */       paramArray.add(gridPoint2);
/*     */       
/*  98 */       if ((j = j + paramInt3) > i) {
/*  99 */         j -= paramInt4;
/* 100 */         paramInt1 += b1;
/* 101 */         paramInt2 += b2;
/*     */       } else {
/* 103 */         paramInt1 += b3;
/* 104 */         paramInt2 += b4;
/*     */       } 
/*     */     } 
/* 107 */     return paramArray;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Bresenham2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */