/*    */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.VertexAttributes;
/*    */ import com.badlogic.gdx.math.CumulativeDistribution;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.badlogic.gdx.math.Vector3;
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
/*    */ public final class WeightMeshSpawnShapeValue
/*    */   extends MeshSpawnShapeValue
/*    */ {
/*    */   private CumulativeDistribution<MeshSpawnShapeValue.Triangle> distribution;
/*    */   
/*    */   public WeightMeshSpawnShapeValue(WeightMeshSpawnShapeValue paramWeightMeshSpawnShapeValue) {
/* 32 */     super(paramWeightMeshSpawnShapeValue);
/* 33 */     this.distribution = new CumulativeDistribution();
/* 34 */     load(paramWeightMeshSpawnShapeValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public WeightMeshSpawnShapeValue() {
/* 39 */     this.distribution = new CumulativeDistribution();
/*    */   }
/*    */ 
/*    */   
/*    */   public final void init() {
/* 44 */     calculateWeights();
/*    */   }
/*    */ 
/*    */   
/*    */   public final void calculateWeights() {
/*    */     float f;
/* 50 */     this.distribution.clear();
/* 51 */     VertexAttributes vertexAttributes = this.mesh.getVertexAttributes();
/* 52 */     int i = this.mesh.getNumIndices();
/* 53 */     int j = this.mesh.getNumVertices();
/* 54 */     short s2 = (short)(vertexAttributes.vertexSize / 4);
/* 55 */     short s1 = (short)((vertexAttributes.findByUsage(1)).offset / 4);
/* 56 */     float[] arrayOfFloat = new float[j * s2];
/* 57 */     this.mesh.getVertices(arrayOfFloat);
/* 58 */     if (i > 0) {
/* 59 */       short[] arrayOfShort = new short[i];
/* 60 */       this.mesh.getIndices(arrayOfShort);
/*    */ 
/*    */       
/* 63 */       for (byte b = 0; b < i; b += 3) {
/* 64 */         int k = arrayOfShort[b] * s2 + s1, m = arrayOfShort[b + 1] * s2 + s1;
/* 65 */         int n = arrayOfShort[b + 2] * s2 + s1;
/* 66 */         float f3 = arrayOfFloat[k], f4 = arrayOfFloat[k + 1], f5 = arrayOfFloat[k + 2], f6 = arrayOfFloat[m];
/* 67 */         float f1 = arrayOfFloat[m + 1], f7 = arrayOfFloat[m + 2], f8 = arrayOfFloat[n], f2 = arrayOfFloat[n + 1];
/* 68 */         float f9 = arrayOfFloat[n + 2];
/* 69 */         f = Math.abs((f3 * (f1 - f2) + f6 * (f2 - f4) + f8 * (f4 - f1)) / 2.0F);
/* 70 */         this.distribution.add(new MeshSpawnShapeValue.Triangle(f3, f4, f5, f6, f1, f7, f8, f2, f9), f);
/*    */       } 
/*    */     } else {
/*    */       int k;
/* 74 */       for (k = 0; k < f; k += s2) {
/* 75 */         int m, n, i1 = (n = (m = k + s1) + s2) + s2;
/* 76 */         float f3 = arrayOfFloat[m], f4 = arrayOfFloat[m + 1], f5 = arrayOfFloat[m + 2], f6 = arrayOfFloat[n];
/* 77 */         float f7 = arrayOfFloat[n + 1], f1 = arrayOfFloat[n + 2], f8 = arrayOfFloat[i1], f9 = arrayOfFloat[i1 + 1];
/* 78 */         float f2 = arrayOfFloat[i1 + 2];
/* 79 */         float f10 = Math.abs((f3 * (f7 - f9) + f6 * (f9 - f4) + f8 * (f4 - f7)) / 2.0F);
/* 80 */         this.distribution.add(new MeshSpawnShapeValue.Triangle(f3, f4, f5, f6, f7, f1, f8, f9, f2), f10);
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 85 */     this.distribution.generateNormalized();
/*    */   }
/*    */ 
/*    */   
/*    */   public final void spawnAux(Vector3 paramVector3, float paramFloat) {
/* 90 */     MeshSpawnShapeValue.Triangle triangle = (MeshSpawnShapeValue.Triangle)this.distribution.value();
/* 91 */     float f1 = MathUtils.random(), f2 = MathUtils.random();
/* 92 */     paramVector3.set(triangle.x1 + f1 * (triangle.x2 - triangle.x1) + f2 * (triangle.x3 - triangle.x1), triangle.y1 + f1 * (triangle.y2 - triangle.y1) + f2 * (triangle.y3 - triangle.y1), triangle.z1 + f1 * (triangle.z2 - triangle.z1) + f2 * (triangle.z3 - triangle.z1));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final SpawnShapeValue copy() {
/* 98 */     return new WeightMeshSpawnShapeValue(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\WeightMeshSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */