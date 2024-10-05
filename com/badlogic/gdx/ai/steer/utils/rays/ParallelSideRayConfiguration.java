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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParallelSideRayConfiguration<T extends Vector<T>>
/*    */   extends RayConfigurationBase<T>
/*    */ {
/*    */   private static final float HALF_PI = 1.5707964F;
/*    */   private float length;
/*    */   private float sideOffset;
/*    */   
/*    */   public ParallelSideRayConfiguration(Steerable<T> paramSteerable, float paramFloat1, float paramFloat2) {
/* 46 */     super(paramSteerable, 2);
/* 47 */     this.length = paramFloat1;
/* 48 */     this.sideOffset = paramFloat2;
/*    */   }
/*    */ 
/*    */   
/*    */   public Ray<T>[] updateRays() {
/* 53 */     float f = this.owner.vectorToAngle(this.owner.getLinearVelocity());
/*    */ 
/*    */     
/* 56 */     this.owner.angleToVector((this.rays[0]).start, f - 1.5707964F).scl(this.sideOffset).add(this.owner.getPosition());
/* 57 */     (this.rays[0]).end.set(this.owner.getLinearVelocity()).nor().scl(this.length);
/*    */ 
/*    */     
/* 60 */     this.owner.angleToVector((this.rays[1]).start, f + 1.5707964F).scl(this.sideOffset).add(this.owner.getPosition());
/* 61 */     (this.rays[1]).end.set((this.rays[0]).end).add((this.rays[1]).start);
/*    */ 
/*    */     
/* 64 */     (this.rays[0]).end.add((this.rays[0]).start);
/*    */     
/* 66 */     return this.rays;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getLength() {
/* 71 */     return this.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLength(float paramFloat) {
/* 76 */     this.length = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getSideOffset() {
/* 81 */     return this.sideOffset;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setSideOffset(float paramFloat) {
/* 86 */     this.sideOffset = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\stee\\utils\rays\ParallelSideRayConfiguration.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */