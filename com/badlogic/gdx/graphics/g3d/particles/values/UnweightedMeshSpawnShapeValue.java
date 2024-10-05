/*    */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Mesh;
/*    */ import com.badlogic.gdx.graphics.g3d.Model;
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
/*    */ public final class UnweightedMeshSpawnShapeValue
/*    */   extends MeshSpawnShapeValue
/*    */ {
/*    */   private float[] vertices;
/*    */   private short[] indices;
/*    */   private int positionOffset;
/*    */   private int vertexSize;
/*    */   private int vertexCount;
/*    */   private int triangleCount;
/*    */   
/*    */   public UnweightedMeshSpawnShapeValue(UnweightedMeshSpawnShapeValue paramUnweightedMeshSpawnShapeValue) {
/* 33 */     super(paramUnweightedMeshSpawnShapeValue);
/* 34 */     load(paramUnweightedMeshSpawnShapeValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public UnweightedMeshSpawnShapeValue() {}
/*    */ 
/*    */   
/*    */   public final void setMesh(Mesh paramMesh, Model paramModel) {
/* 42 */     super.setMesh(paramMesh, paramModel);
/* 43 */     this.vertexSize = paramMesh.getVertexSize() / 4;
/* 44 */     this.positionOffset = (paramMesh.getVertexAttribute(1)).offset / 4;
/*    */     int i;
/* 46 */     if ((i = paramMesh.getNumIndices()) > 0) {
/* 47 */       this.indices = new short[i];
/* 48 */       paramMesh.getIndices(this.indices);
/* 49 */       this.triangleCount = this.indices.length / 3;
/*    */     } else {
/* 51 */       this.indices = null;
/* 52 */     }  this.vertexCount = paramMesh.getNumVertices();
/* 53 */     this.vertices = new float[this.vertexCount * this.vertexSize];
/* 54 */     paramMesh.getVertices(this.vertices);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void spawnAux(Vector3 paramVector3, float paramFloat) {
/* 59 */     if (this.indices == null) {
/*    */ 
/*    */       
/* 62 */       int n, i1, m = (i1 = (n = (m = MathUtils.random(this.vertexCount - 3) * this.vertexSize) + this.positionOffset) + this.vertexSize) + this.vertexSize;
/* 63 */       float f13 = this.vertices[n], f14 = this.vertices[n + 1], f11 = this.vertices[n + 2], f15 = this.vertices[i1];
/* 64 */       float f16 = this.vertices[i1 + 1], f12 = this.vertices[i1 + 2], f17 = this.vertices[m], f18 = this.vertices[m + 1];
/* 65 */       float f10 = this.vertices[m + 2];
/* 66 */       MeshSpawnShapeValue.Triangle.pick(f13, f14, f11, f15, f16, f12, f17, f18, f10, paramVector3);
/*    */       return;
/*    */     } 
/* 69 */     int i = MathUtils.random(this.triangleCount - 1) * 3;
/* 70 */     int j = this.indices[i] * this.vertexSize + this.positionOffset;
/* 71 */     int k = this.indices[i + 1] * this.vertexSize + this.positionOffset;
/* 72 */     i = this.indices[i + 2] * this.vertexSize + this.positionOffset;
/* 73 */     float f4 = this.vertices[j], f5 = this.vertices[j + 1], f2 = this.vertices[j + 2], f6 = this.vertices[k];
/* 74 */     float f7 = this.vertices[k + 1], f3 = this.vertices[k + 2], f8 = this.vertices[i], f9 = this.vertices[i + 1];
/* 75 */     float f1 = this.vertices[i + 2];
/* 76 */     MeshSpawnShapeValue.Triangle.pick(f4, f5, f2, f6, f7, f3, f8, f9, f1, paramVector3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final SpawnShapeValue copy() {
/* 82 */     return new UnweightedMeshSpawnShapeValue(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\UnweightedMeshSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */