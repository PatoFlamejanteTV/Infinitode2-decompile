/*     */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MeshSpawnShapeValue
/*     */   extends SpawnShapeValue
/*     */ {
/*     */   protected Mesh mesh;
/*     */   protected Model model;
/*     */   
/*     */   public static class Triangle
/*     */   {
/*     */     float x1;
/*     */     float y1;
/*     */     float z1;
/*     */     float x2;
/*     */     float y2;
/*     */     float z2;
/*     */     float x3;
/*     */     float y3;
/*     */     float z3;
/*     */     
/*     */     public Triangle(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, float param1Float8, float param1Float9) {
/*  37 */       this.x1 = param1Float1;
/*  38 */       this.y1 = param1Float2;
/*  39 */       this.z1 = param1Float3;
/*  40 */       this.x2 = param1Float4;
/*  41 */       this.y2 = param1Float5;
/*  42 */       this.z2 = param1Float6;
/*  43 */       this.x3 = param1Float7;
/*  44 */       this.y3 = param1Float8;
/*  45 */       this.z3 = param1Float9;
/*     */     }
/*     */ 
/*     */     
/*     */     public static Vector3 pick(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, float param1Float8, float param1Float9, Vector3 param1Vector3) {
/*  50 */       float f1 = MathUtils.random(), f2 = MathUtils.random();
/*  51 */       return param1Vector3.set(param1Float1 + f1 * (param1Float4 - param1Float1) + f2 * (param1Float7 - param1Float1), param1Float2 + f1 * (param1Float5 - param1Float2) + f2 * (param1Float8 - param1Float2), param1Float3 + f1 * (param1Float6 - param1Float3) + f2 * (param1Float9 - param1Float3));
/*     */     }
/*     */ 
/*     */     
/*     */     public Vector3 pick(Vector3 param1Vector3) {
/*  56 */       float f1 = MathUtils.random(), f2 = MathUtils.random();
/*  57 */       return param1Vector3.set(this.x1 + f1 * (this.x2 - this.x1) + f2 * (this.x3 - this.x1), this.y1 + f1 * (this.y2 - this.y1) + f2 * (this.y3 - this.y1), this.z1 + f1 * (this.z2 - this.z1) + f2 * (this.z3 - this.z1));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshSpawnShapeValue(MeshSpawnShapeValue paramMeshSpawnShapeValue) {
/*  67 */     super(paramMeshSpawnShapeValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public MeshSpawnShapeValue() {}
/*     */ 
/*     */   
/*     */   public void load(ParticleValue paramParticleValue) {
/*  75 */     super.load(paramParticleValue);
/*  76 */     paramParticleValue = paramParticleValue;
/*  77 */     setMesh(((MeshSpawnShapeValue)paramParticleValue).mesh, ((MeshSpawnShapeValue)paramParticleValue).model);
/*     */   }
/*     */   
/*     */   public void setMesh(Mesh paramMesh, Model paramModel) {
/*  81 */     if (paramMesh.getVertexAttribute(1) == null)
/*  82 */       throw new GdxRuntimeException("Mesh vertices must have Usage.Position"); 
/*  83 */     this.model = paramModel;
/*  84 */     this.mesh = paramMesh;
/*     */   }
/*     */   
/*     */   public void setMesh(Mesh paramMesh) {
/*  88 */     setMesh(paramMesh, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/*  93 */     if (this.model != null) {
/*     */       ResourceData.SaveData saveData;
/*  95 */       (saveData = paramResourceData.createSaveData()).saveAsset(paramAssetManager.getAssetFileName(this.model), Model.class);
/*  96 */       saveData.save("index", Integer.valueOf(this.model.meshes.indexOf(this.mesh, true)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/*     */     ResourceData.SaveData saveData;
/*     */     AssetDescriptor assetDescriptor;
/* 104 */     if ((assetDescriptor = (saveData = paramResourceData.getSaveData()).loadAsset()) != null) {
/* 105 */       Model model = (Model)paramAssetManager.get(assetDescriptor);
/* 106 */       setMesh((Mesh)model.meshes.get(((Integer)saveData.load("index")).intValue()), model);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\MeshSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */