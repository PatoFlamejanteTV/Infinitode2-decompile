/*    */ package com.prineside.tdi2.shapes;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g2d.Batch;
/*    */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.prineside.tdi2.ProjectileTrail;
/*    */ import com.prineside.tdi2.Shape;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FlyingParticlesLine
/*    */   extends Shape
/*    */   implements ProjectileTrail
/*    */ {
/*    */   private float a;
/*    */   private float b;
/*    */   
/*    */   private FlyingParticlesLine() {
/* 21 */     reset();
/*    */   }
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
/*    */   public void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, TextureRegion paramTextureRegion, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, Color paramColor1, Color paramColor2, float paramFloat9, float paramFloat10, float paramFloat11, ParticleEmitter.ScaledNumericValue paramScaledNumericValue) {
/* 35 */     this.a = paramFloat10;
/*    */ 
/*    */ 
/*    */     
/* 39 */     this.b = 0.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void update(float paramFloat) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isFinished() {
/* 49 */     return (0.0F >= this.a);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(Batch paramBatch) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void reset() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void free() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public static class FlyingParticlesLineFactory
/*    */     extends Shape.Factory<FlyingParticlesLine>
/*    */   {
/*    */     public void setup() {}
/*    */ 
/*    */ 
/*    */     
/*    */     private static FlyingParticlesLine b() {
/* 74 */       return new FlyingParticlesLine((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\shapes\FlyingParticlesLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */