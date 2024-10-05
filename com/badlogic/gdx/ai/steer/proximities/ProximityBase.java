/*    */ package com.badlogic.gdx.ai.steer.proximities;
/*    */ 
/*    */ import com.badlogic.gdx.ai.steer.Proximity;
/*    */ import com.badlogic.gdx.ai.steer.Steerable;
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
/*    */ 
/*    */ 
/*    */ public abstract class ProximityBase<T extends Vector<T>>
/*    */   implements Proximity<T>
/*    */ {
/*    */   protected Steerable<T> owner;
/*    */   protected Iterable<? extends Steerable<T>> agents;
/*    */   
/*    */   public ProximityBase(Steerable<T> paramSteerable, Iterable<? extends Steerable<T>> paramIterable) {
/* 43 */     this.owner = paramSteerable;
/* 44 */     this.agents = paramIterable;
/*    */   }
/*    */ 
/*    */   
/*    */   public Steerable<T> getOwner() {
/* 49 */     return this.owner;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setOwner(Steerable<T> paramSteerable) {
/* 54 */     this.owner = paramSteerable;
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterable<? extends Steerable<T>> getAgents() {
/* 59 */     return this.agents;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAgents(Iterable<Steerable<T>> paramIterable) {
/* 64 */     this.agents = paramIterable;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\proximities\ProximityBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */