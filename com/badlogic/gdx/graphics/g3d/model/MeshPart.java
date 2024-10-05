/*     */ package com.badlogic.gdx.graphics.g3d.model;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.glutils.ShaderProgram;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
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
/*     */ 
/*     */ 
/*     */ public class MeshPart
/*     */ {
/*     */   public String id;
/*     */   public int primitiveType;
/*     */   public int offset;
/*     */   public int size;
/*     */   public Mesh mesh;
/*  61 */   public final Vector3 center = new Vector3();
/*     */ 
/*     */ 
/*     */   
/*  65 */   public final Vector3 halfExtents = new Vector3();
/*     */ 
/*     */   
/*  68 */   public float radius = -1.0F;
/*     */   
/*  70 */   private static final BoundingBox bounds = new BoundingBox();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPart() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPart(String paramString, Mesh paramMesh, int paramInt1, int paramInt2, int paramInt3) {
/*  83 */     set(paramString, paramMesh, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPart(MeshPart paramMeshPart) {
/*  89 */     set(paramMeshPart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPart set(MeshPart paramMeshPart) {
/*  96 */     this.id = paramMeshPart.id;
/*  97 */     this.mesh = paramMeshPart.mesh;
/*  98 */     this.offset = paramMeshPart.offset;
/*  99 */     this.size = paramMeshPart.size;
/* 100 */     this.primitiveType = paramMeshPart.primitiveType;
/* 101 */     this.center.set(paramMeshPart.center);
/* 102 */     this.halfExtents.set(paramMeshPart.halfExtents);
/* 103 */     this.radius = paramMeshPart.radius;
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MeshPart set(String paramString, Mesh paramMesh, int paramInt1, int paramInt2, int paramInt3) {
/* 110 */     this.id = paramString;
/* 111 */     this.mesh = paramMesh;
/* 112 */     this.offset = paramInt1;
/* 113 */     this.size = paramInt2;
/* 114 */     this.primitiveType = paramInt3;
/* 115 */     this.center.set(0.0F, 0.0F, 0.0F);
/* 116 */     this.halfExtents.set(0.0F, 0.0F, 0.0F);
/* 117 */     this.radius = -1.0F;
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/* 126 */     this.mesh.calculateBoundingBox(bounds, this.offset, this.size);
/* 127 */     bounds.getCenter(this.center);
/* 128 */     bounds.getDimensions(this.halfExtents).scl(0.5F);
/* 129 */     this.radius = this.halfExtents.len();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(MeshPart paramMeshPart) {
/* 137 */     return (paramMeshPart == this || (paramMeshPart != null && paramMeshPart.mesh == this.mesh && paramMeshPart.primitiveType == this.primitiveType && paramMeshPart.offset == this.offset && paramMeshPart.size == this.size));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 143 */     if (paramObject == null) return false; 
/* 144 */     if (paramObject == this) return true; 
/* 145 */     if (!(paramObject instanceof MeshPart)) return false; 
/* 146 */     return equals((MeshPart)paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(ShaderProgram paramShaderProgram, boolean paramBoolean) {
/* 153 */     this.mesh.render(paramShaderProgram, this.primitiveType, this.offset, this.size, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(ShaderProgram paramShaderProgram) {
/* 159 */     this.mesh.render(paramShaderProgram, this.primitiveType, this.offset, this.size);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\MeshPart.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */