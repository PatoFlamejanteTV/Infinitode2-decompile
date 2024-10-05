/*    */ package com.badlogic.gdx.graphics.g3d.particles.batches;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Camera;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;
/*    */ import com.badlogic.gdx.utils.Array;
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
/*    */ public abstract class BufferedParticleBatch<T extends ParticleControllerRenderData>
/*    */   implements ParticleBatch<T>
/*    */ {
/*    */   protected Array<T> renderData;
/*    */   protected int bufferedParticlesCount;
/* 28 */   protected int currentCapacity = 0;
/*    */   protected ParticleSorter sorter;
/*    */   protected Camera camera;
/*    */   
/*    */   protected BufferedParticleBatch(Class<T> paramClass) {
/* 33 */     this.sorter = (ParticleSorter)new ParticleSorter.Distance();
/* 34 */     this.renderData = new Array(false, 10, paramClass);
/*    */   }
/*    */   
/*    */   public void begin() {
/* 38 */     this.renderData.clear();
/* 39 */     this.bufferedParticlesCount = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(T paramT) {
/* 44 */     if (((ParticleControllerRenderData)paramT).controller.particles.size > 0) {
/* 45 */       this.renderData.add(paramT);
/* 46 */       this.bufferedParticlesCount += ((ParticleControllerRenderData)paramT).controller.particles.size;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void end() {
/* 52 */     if (this.bufferedParticlesCount > 0) {
/* 53 */       ensureCapacity(this.bufferedParticlesCount);
/* 54 */       flush(this.sorter.sort(this.renderData));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void ensureCapacity(int paramInt) {
/* 60 */     if (this.currentCapacity >= paramInt)
/* 61 */       return;  this.sorter.ensureCapacity(paramInt);
/* 62 */     allocParticlesData(paramInt);
/* 63 */     this.currentCapacity = paramInt;
/*    */   }
/*    */   
/*    */   public void resetCapacity() {
/* 67 */     this.currentCapacity = this.bufferedParticlesCount = 0;
/*    */   }
/*    */   
/*    */   protected abstract void allocParticlesData(int paramInt);
/*    */   
/*    */   public void setCamera(Camera paramCamera) {
/* 73 */     this.camera = paramCamera;
/* 74 */     this.sorter.setCamera(paramCamera);
/*    */   }
/*    */   
/*    */   public ParticleSorter getSorter() {
/* 78 */     return this.sorter;
/*    */   }
/*    */   
/*    */   public void setSorter(ParticleSorter paramParticleSorter) {
/* 82 */     this.sorter = paramParticleSorter;
/* 83 */     paramParticleSorter.setCamera(this.camera);
/* 84 */     paramParticleSorter.ensureCapacity(this.currentCapacity);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract void flush(int[] paramArrayOfint);
/*    */ 
/*    */   
/*    */   public int getBufferedCount() {
/* 93 */     return this.bufferedParticlesCount;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\batches\BufferedParticleBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */