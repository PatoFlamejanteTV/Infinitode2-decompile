/*     */ package com.badlogic.gdx.ai.pfa;
/*     */ 
/*     */ import com.badlogic.gdx.ai.utils.Ray;
/*     */ import com.badlogic.gdx.ai.utils.RaycastCollisionDetector;
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ import com.badlogic.gdx.utils.TimeUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PathSmoother<N, V extends Vector<V>>
/*     */ {
/*     */   RaycastCollisionDetector<V> raycastCollisionDetector;
/*     */   Ray<V> ray;
/*     */   
/*     */   public PathSmoother(RaycastCollisionDetector<V> paramRaycastCollisionDetector) {
/*  53 */     this.raycastCollisionDetector = paramRaycastCollisionDetector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int smoothPath(SmoothableGraphPath<N, V> paramSmoothableGraphPath) {
/*     */     int i;
/*  63 */     if ((i = paramSmoothableGraphPath.getCount()) <= 2) return 0;
/*     */ 
/*     */     
/*  66 */     if (this.ray == null) {
/*  67 */       V v = paramSmoothableGraphPath.getNodePosition(0);
/*  68 */       this.ray = new Ray(v.cpy(), v.cpy());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  73 */     byte b1 = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     byte b2 = 2;
/*     */ 
/*     */     
/*  81 */     while (b2 < i) {
/*     */       
/*  83 */       this.ray.start.set((Vector)paramSmoothableGraphPath.getNodePosition(b1 - 1));
/*  84 */       this.ray.end.set((Vector)paramSmoothableGraphPath.getNodePosition(b2));
/*     */ 
/*     */       
/*     */       boolean bool;
/*     */       
/*  89 */       if (bool = this.raycastCollisionDetector.collides(this.ray)) {
/*     */         
/*  91 */         paramSmoothableGraphPath.swapNodes(b1, b2 - 1);
/*  92 */         b1++;
/*     */       } 
/*     */ 
/*     */       
/*  96 */       b2++;
/*     */     } 
/*     */ 
/*     */     
/* 100 */     paramSmoothableGraphPath.swapNodes(b1, b2 - 1);
/* 101 */     paramSmoothableGraphPath.truncatePath(b1 + 1);
/*     */ 
/*     */     
/* 104 */     return b2 - b1 - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean smoothPath(PathSmootherRequest<N, V> paramPathSmootherRequest, long paramLong) {
/* 113 */     long l = TimeUtils.nanoTime();
/*     */     
/*     */     SmoothableGraphPath<N, V> smoothableGraphPath;
/*     */     
/*     */     int i;
/*     */     
/* 119 */     if ((i = (smoothableGraphPath = paramPathSmootherRequest.path).getCount()) <= 2) return true;
/*     */     
/* 121 */     if (paramPathSmootherRequest.isNew) {
/* 122 */       paramPathSmootherRequest.isNew = false;
/*     */ 
/*     */       
/* 125 */       if (this.ray == null) {
/* 126 */         V v = paramPathSmootherRequest.path.getNodePosition(0);
/* 127 */         this.ray = new Ray(v.cpy(), v.cpy());
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 132 */       paramPathSmootherRequest.outputIndex = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       paramPathSmootherRequest.inputIndex = 2;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 142 */     while (paramPathSmootherRequest.inputIndex < i) {
/*     */ 
/*     */       
/* 145 */       long l2 = TimeUtils.nanoTime();
/*     */       
/* 147 */       if ((paramLong = paramLong - l2 - l) <= 100L) return false;
/*     */ 
/*     */       
/* 150 */       this.ray.start.set((Vector)smoothableGraphPath.getNodePosition(paramPathSmootherRequest.outputIndex - 1));
/* 151 */       this.ray.end.set((Vector)smoothableGraphPath.getNodePosition(paramPathSmootherRequest.inputIndex));
/*     */ 
/*     */       
/*     */       boolean bool;
/*     */       
/* 156 */       if (bool = this.raycastCollisionDetector.collides(this.ray)) {
/*     */         
/* 158 */         smoothableGraphPath.swapNodes(paramPathSmootherRequest.outputIndex, paramPathSmootherRequest.inputIndex - 1);
/* 159 */         paramPathSmootherRequest.outputIndex++;
/*     */       } 
/*     */ 
/*     */       
/* 163 */       paramPathSmootherRequest.inputIndex++;
/*     */ 
/*     */       
/* 166 */       long l1 = l2;
/*     */     } 
/*     */ 
/*     */     
/* 170 */     smoothableGraphPath.swapNodes(paramPathSmootherRequest.outputIndex, paramPathSmootherRequest.inputIndex - 1);
/* 171 */     smoothableGraphPath.truncatePath(paramPathSmootherRequest.outputIndex + 1);
/*     */ 
/*     */     
/* 174 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\pfa\PathSmoother.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */