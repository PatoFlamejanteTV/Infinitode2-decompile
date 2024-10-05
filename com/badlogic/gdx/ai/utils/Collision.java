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
/*    */ public class Collision<T extends Vector<T>>
/*    */ {
/*    */   public T point;
/*    */   public T normal;
/*    */   
/*    */   public Collision(T paramT1, T paramT2) {
/* 38 */     this.point = paramT1;
/* 39 */     this.normal = paramT2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Collision<T> set(Collision<T> paramCollision) {
/* 46 */     this.point.set((Vector)paramCollision.point);
/* 47 */     this.normal.set((Vector)paramCollision.normal);
/* 48 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Collision<T> set(T paramT1, T paramT2) {
/* 56 */     this.point.set((Vector)paramT1);
/* 57 */     this.normal.set((Vector)paramT2);
/* 58 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\Collision.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */