/*    */ package com.badlogic.gdx.ai.utils;
/*    */ 
/*    */ import com.badlogic.gdx.math.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ray<T extends Vector<T>>
/*    */ {
/*    */   public T start;
/*    */   public T end;
/*    */   
/*    */   public Ray(T paramT1, T paramT2) {
/* 38 */     this.start = paramT1;
/* 39 */     this.end = paramT2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ray<T> set(Ray<T> paramRay) {
/* 46 */     this.start.set((Vector)paramRay.start);
/* 47 */     this.end.set((Vector)paramRay.end);
/* 48 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ray<T> set(T paramT1, T paramT2) {
/* 56 */     this.start.set((Vector)paramT1);
/* 57 */     this.end.set((Vector)paramT2);
/* 58 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\Ray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */