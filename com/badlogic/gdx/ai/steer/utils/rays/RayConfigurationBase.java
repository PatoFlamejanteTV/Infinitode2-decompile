/*    */ package com.badlogic.gdx.ai.steer.utils.rays;
/*    */ 
/*    */ import com.badlogic.gdx.ai.steer.Steerable;
/*    */ import com.badlogic.gdx.ai.steer.utils.RayConfiguration;
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
/*    */ public abstract class RayConfigurationBase<T extends Vector<T>>
/*    */   implements RayConfiguration<T>
/*    */ {
/*    */   protected Steerable<T> owner;
/*    */   protected Ray<T>[] rays;
/*    */   
/*    */   public RayConfigurationBase(Steerable<T> paramSteerable, int paramInt) {
/* 39 */     this.owner = paramSteerable;
/* 40 */     this.rays = (Ray<T>[])new Ray[paramInt];
/* 41 */     for (byte b = 0; b < paramInt; b++) {
/* 42 */       this.rays[b] = new Ray(paramSteerable.getPosition().cpy().setZero(), paramSteerable.getPosition().cpy().setZero());
/*    */     }
/*    */   }
/*    */   
/*    */   public Steerable<T> getOwner() {
/* 47 */     return this.owner;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setOwner(Steerable<T> paramSteerable) {
/* 52 */     this.owner = paramSteerable;
/*    */   }
/*    */ 
/*    */   
/*    */   public Ray<T>[] getRays() {
/* 57 */     return this.rays;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRays(Ray<T>[] paramArrayOfRay) {
/* 62 */     this.rays = paramArrayOfRay;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\stee\\utils\rays\RayConfigurationBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */