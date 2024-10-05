/*     */ package com.badlogic.gdx.graphics.g3d.particles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ParticleSorter
/*     */ {
/*     */   protected Camera camera;
/*     */   
/*     */   public abstract <T extends ParticleControllerRenderData> int[] sort(Array<T> paramArray);
/*     */   
/*  28 */   static final Vector3 TMP_V1 = new Vector3();
/*     */   
/*     */   public static class None
/*     */     extends ParticleSorter {
/*  32 */     int currentCapacity = 0;
/*     */     
/*     */     int[] indices;
/*     */     
/*     */     public void ensureCapacity(int param1Int) {
/*  37 */       if (this.currentCapacity < param1Int) {
/*  38 */         this.indices = new int[param1Int];
/*  39 */         for (byte b = 0; b < param1Int; b++)
/*  40 */           this.indices[b] = b; 
/*  41 */         this.currentCapacity = param1Int;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public <T extends ParticleControllerRenderData> int[] sort(Array<T> param1Array) {
/*  47 */       return this.indices;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Distance extends ParticleSorter {
/*     */     private float[] distances;
/*     */     private int[] particleIndices;
/*     */     private int[] particleOffsets;
/*  55 */     private int currentSize = 0;
/*     */ 
/*     */     
/*     */     public void ensureCapacity(int param1Int) {
/*  59 */       if (this.currentSize < param1Int) {
/*  60 */         this.distances = new float[param1Int];
/*  61 */         this.particleIndices = new int[param1Int];
/*  62 */         this.particleOffsets = new int[param1Int];
/*  63 */         this.currentSize = param1Int;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public <T extends ParticleControllerRenderData> int[] sort(Array<T> param1Array) {
/*  70 */       float arrayOfFloat[], f2 = (arrayOfFloat = this.camera.view.val)[2], f3 = arrayOfFloat[6], f1 = arrayOfFloat[10];
/*  71 */       int i = 0; byte b = 0;
/*  72 */       for (Array.ArrayIterator<ParticleControllerRenderData> arrayIterator = param1Array.iterator(); arrayIterator.hasNext(); ) { ParticleControllerRenderData particleControllerRenderData = arrayIterator.next(); int j, k;
/*  73 */         for (j = 0, k = b + particleControllerRenderData.controller.particles.size; b < k; b++, j += particleControllerRenderData.positionChannel.strideSize) {
/*  74 */           this.distances[b] = f2 * particleControllerRenderData.positionChannel.data[j] + f3 * particleControllerRenderData.positionChannel.data[j + 1] + f1 * particleControllerRenderData.positionChannel.data[j + 2];
/*     */ 
/*     */           
/*  77 */           this.particleIndices[b] = b;
/*     */         } 
/*  79 */         i += particleControllerRenderData.controller.particles.size; }
/*     */ 
/*     */       
/*  82 */       qsort(0, i - 1);
/*     */       
/*  84 */       for (b = 0; b < i; b++) {
/*  85 */         this.particleOffsets[this.particleIndices[b]] = b;
/*     */       }
/*  87 */       return this.particleOffsets;
/*     */     }
/*     */ 
/*     */     
/*     */     public void qsort(int param1Int1, int param1Int2) {
/*  92 */       if (param1Int1 < param1Int2) {
/*     */ 
/*     */ 
/*     */         
/*  96 */         if (param1Int2 - param1Int1 <= 8) {
/*  97 */           for (int m = param1Int1; m <= param1Int2; m++) {
/*  98 */             for (int n = m; n > param1Int1 && this.distances[n - 1] > this.distances[n]; n--) {
/*  99 */               float f1 = this.distances[n];
/* 100 */               this.distances[n] = this.distances[n - 1];
/* 101 */               this.distances[n - 1] = f1;
/*     */ 
/*     */               
/* 104 */               int i1 = this.particleIndices[n];
/* 105 */               this.particleIndices[n] = this.particleIndices[n - 1];
/* 106 */               this.particleIndices[n - 1] = i1;
/*     */             } 
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/* 112 */         float f = this.distances[param1Int1];
/* 113 */         int j = param1Int1 + 1;
/* 114 */         int i = this.particleIndices[param1Int1];
/*     */ 
/*     */         
/* 117 */         for (int k = j; k <= param1Int2; k++) {
/* 118 */           if (f > this.distances[k]) {
/* 119 */             if (k > j) {
/*     */               
/* 121 */               float f1 = this.distances[k];
/* 122 */               this.distances[k] = this.distances[j];
/* 123 */               this.distances[j] = f1;
/*     */ 
/*     */               
/* 126 */               int m = this.particleIndices[k];
/* 127 */               this.particleIndices[k] = this.particleIndices[j];
/* 128 */               this.particleIndices[j] = m;
/*     */             } 
/* 130 */             j++;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 135 */         this.distances[param1Int1] = this.distances[j - 1];
/* 136 */         this.distances[j - 1] = f;
/* 137 */         this.particleIndices[param1Int1] = this.particleIndices[j - 1];
/* 138 */         this.particleIndices[j - 1] = i;
/*     */ 
/*     */         
/* 141 */         qsort(param1Int1, j - 2);
/* 142 */         qsort(j, param1Int2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCamera(Camera paramCamera) {
/* 154 */     this.camera = paramCamera;
/*     */   }
/*     */   
/*     */   public void ensureCapacity(int paramInt) {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ParticleSorter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */