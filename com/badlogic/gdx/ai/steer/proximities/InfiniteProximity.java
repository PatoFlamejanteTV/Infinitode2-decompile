/*    */ package com.badlogic.gdx.ai.steer.proximities;
/*    */ 
/*    */ import com.badlogic.gdx.ai.steer.Proximity;
/*    */ import com.badlogic.gdx.ai.steer.Steerable;
/*    */ import com.badlogic.gdx.math.Vector;
/*    */ import java.util.Iterator;
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
/*    */ public class InfiniteProximity<T extends Vector<T>>
/*    */   extends ProximityBase<T>
/*    */ {
/*    */   public InfiniteProximity(Steerable<T> paramSteerable, Iterable<? extends Steerable<T>> paramIterable) {
/* 34 */     super(paramSteerable, paramIterable);
/*    */   }
/*    */ 
/*    */   
/*    */   public int findNeighbors(Proximity.ProximityCallback<T> paramProximityCallback) {
/* 39 */     byte b = 0;
/* 40 */     for (Iterator<? extends Steerable<T>> iterator = this.agents.iterator(); iterator.hasNext();) {
/*    */       
/* 42 */       if ((steerable = iterator.next()) != this.owner && 
/* 43 */         paramProximityCallback.reportNeighbor(steerable)) {
/* 44 */         b++;
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 49 */     return b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\proximities\InfiniteProximity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */