/*    */ package com.badlogic.gdx.ai.steer;
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
/*    */ public abstract class GroupBehavior<T extends Vector<T>>
/*    */   extends SteeringBehavior<T>
/*    */ {
/*    */   protected Proximity<T> proximity;
/*    */   
/*    */   public GroupBehavior(Steerable<T> paramSteerable, Proximity<T> paramProximity) {
/* 38 */     super(paramSteerable);
/* 39 */     this.proximity = paramProximity;
/*    */   }
/*    */ 
/*    */   
/*    */   public Proximity<T> getProximity() {
/* 44 */     return this.proximity;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setProximity(Proximity<T> paramProximity) {
/* 50 */     this.proximity = paramProximity;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\GroupBehavior.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */