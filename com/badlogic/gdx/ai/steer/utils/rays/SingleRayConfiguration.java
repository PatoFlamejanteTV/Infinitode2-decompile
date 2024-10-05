/*    */ package com.badlogic.gdx.ai.steer.utils.rays;
/*    */ 
/*    */ import com.badlogic.gdx.ai.steer.Steerable;
/*    */ import com.badlogic.gdx.ai.utils.Ray;
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
/*    */ public class SingleRayConfiguration<T extends Vector<T>>
/*    */   extends RayConfigurationBase<T>
/*    */ {
/*    */   private float length;
/*    */   
/*    */   public SingleRayConfiguration(Steerable<T> paramSteerable, float paramFloat) {
/* 39 */     super(paramSteerable, 1);
/* 40 */     this.length = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public Ray<T>[] updateRays() {
/* 45 */     (this.rays[0]).start.set(this.owner.getPosition());
/* 46 */     (this.rays[0]).end.set(this.owner.getLinearVelocity()).nor().scl(this.length).add((this.rays[0]).start);
/* 47 */     return this.rays;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getLength() {
/* 52 */     return this.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLength(float paramFloat) {
/* 57 */     this.length = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\stee\\utils\rays\SingleRayConfiguration.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */