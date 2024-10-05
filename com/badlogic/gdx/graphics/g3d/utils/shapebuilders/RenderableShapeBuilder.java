/*     */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Mesh;
/*     */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*     */ import com.badlogic.gdx.graphics.g3d.RenderableProvider;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.FlushablePool;
/*     */ import com.badlogic.gdx.utils.Pool;
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
/*     */ public class RenderableShapeBuilder
/*     */   extends BaseShapeBuilder
/*     */ {
/*     */   private static short[] indices;
/*     */   private static float[] vertices;
/*     */   
/*     */   private static class RenderablePool
/*     */     extends FlushablePool<Renderable>
/*     */   {
/*     */     protected Renderable newObject() {
/*  39 */       return new Renderable();
/*     */     }
/*     */ 
/*     */     
/*     */     public Renderable obtain() {
/*     */       Renderable renderable;
/*  45 */       (renderable = (Renderable)super.obtain()).environment = null;
/*  46 */       renderable.material = null;
/*  47 */       renderable.meshPart.set("", null, 0, 0, 0);
/*  48 */       renderable.shader = null;
/*  49 */       renderable.userData = null;
/*  50 */       return renderable;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  56 */   private static final RenderablePool renderablesPool = new RenderablePool();
/*  57 */   private static final Array<Renderable> renderables = new Array();
/*     */ 
/*     */   
/*     */   private static final int FLOAT_BYTES = 4;
/*     */ 
/*     */ 
/*     */   
/*     */   public static void buildNormals(MeshPartBuilder paramMeshPartBuilder, RenderableProvider paramRenderableProvider, float paramFloat) {
/*  65 */     buildNormals(paramMeshPartBuilder, paramRenderableProvider, paramFloat, tmpColor0.set(0.0F, 0.0F, 1.0F, 1.0F), tmpColor1.set(1.0F, 0.0F, 0.0F, 1.0F), tmpColor2
/*  66 */         .set(0.0F, 1.0F, 0.0F, 1.0F));
/*     */   }
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
/*     */   public static void buildNormals(MeshPartBuilder paramMeshPartBuilder, RenderableProvider paramRenderableProvider, float paramFloat, Color paramColor1, Color paramColor2, Color paramColor3) {
/*  79 */     paramRenderableProvider.getRenderables(renderables, (Pool)renderablesPool);
/*     */     
/*  81 */     for (Array.ArrayIterator<Renderable> arrayIterator = renderables.iterator(); arrayIterator.hasNext(); ) { Renderable renderable = arrayIterator.next();
/*  82 */       buildNormals(paramMeshPartBuilder, renderable, paramFloat, paramColor1, paramColor2, paramColor3); }
/*     */ 
/*     */     
/*  85 */     renderablesPool.flush();
/*  86 */     renderables.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void buildNormals(MeshPartBuilder paramMeshPartBuilder, Renderable paramRenderable, float paramFloat, Color paramColor1, Color paramColor2, Color paramColor3) {
/*     */     int i1, i2;
/*  98 */     Mesh mesh = paramRenderable.meshPart.mesh;
/*     */ 
/*     */     
/* 101 */     int i = -1;
/* 102 */     if (mesh.getVertexAttribute(1) != null) {
/* 103 */       i = (mesh.getVertexAttribute(1)).offset / 4;
/*     */     }
/*     */     
/* 106 */     int j = -1;
/* 107 */     if (mesh.getVertexAttribute(8) != null) {
/* 108 */       j = (mesh.getVertexAttribute(8)).offset / 4;
/*     */     }
/*     */     
/* 111 */     int k = -1;
/* 112 */     if (mesh.getVertexAttribute(128) != null) {
/* 113 */       k = (mesh.getVertexAttribute(128)).offset / 4;
/*     */     }
/*     */     
/* 116 */     int m = -1;
/* 117 */     if (mesh.getVertexAttribute(256) != null) {
/* 118 */       m = (mesh.getVertexAttribute(256)).offset / 4;
/*     */     }
/* 120 */     int n = mesh.getVertexSize() / 4;
/*     */ 
/*     */ 
/*     */     
/* 124 */     if (mesh.getNumIndices() > 0) {
/*     */       
/* 126 */       ensureIndicesCapacity(mesh.getNumIndices());
/* 127 */       mesh.getIndices(paramRenderable.meshPart.offset, paramRenderable.meshPart.size, indices, 0);
/*     */       
/* 129 */       short s1 = minVerticeInIndices();
/* 130 */       short s2 = maxVerticeInIndices();
/*     */       
/* 132 */       i1 = s1;
/* 133 */       i2 = s2 - s1;
/*     */     } else {
/* 135 */       i1 = paramRenderable.meshPart.offset;
/* 136 */       i2 = paramRenderable.meshPart.size;
/*     */     } 
/*     */     
/* 139 */     ensureVerticesCapacity(i2 * n);
/* 140 */     mesh.getVertices(i1 * n, i2 * n, vertices, 0);
/*     */     
/* 142 */     for (int i3 = i1; i3 < i2; i3++) {
/* 143 */       int i4 = i3 * n;
/*     */ 
/*     */       
/* 146 */       tmpV0.set(vertices[i4 + i], vertices[i4 + i + 1], vertices[i4 + i + 2]);
/*     */ 
/*     */       
/* 149 */       if (j != -1) {
/* 150 */         tmpV1.set(vertices[i4 + j], vertices[i4 + j + 1], vertices[i4 + j + 2]);
/* 151 */         tmpV2.set(tmpV0).add(tmpV1.scl(paramFloat));
/*     */       } 
/*     */       
/* 154 */       if (k != -1) {
/* 155 */         tmpV3.set(vertices[i4 + k], vertices[i4 + k + 1], vertices[i4 + k + 2]);
/* 156 */         tmpV4.set(tmpV0).add(tmpV3.scl(paramFloat));
/*     */       } 
/*     */       
/* 159 */       if (m != -1) {
/* 160 */         tmpV5.set(vertices[i4 + m], vertices[i4 + m + 1], vertices[i4 + m + 2]);
/* 161 */         tmpV6.set(tmpV0).add(tmpV5.scl(paramFloat));
/*     */       } 
/*     */ 
/*     */       
/* 165 */       tmpV0.mul(paramRenderable.worldTransform);
/* 166 */       tmpV2.mul(paramRenderable.worldTransform);
/* 167 */       tmpV4.mul(paramRenderable.worldTransform);
/* 168 */       tmpV6.mul(paramRenderable.worldTransform);
/*     */ 
/*     */       
/* 171 */       if (j != -1) {
/* 172 */         paramMeshPartBuilder.setColor(paramColor1);
/* 173 */         paramMeshPartBuilder.line(tmpV0, tmpV2);
/*     */       } 
/*     */       
/* 176 */       if (k != -1) {
/* 177 */         paramMeshPartBuilder.setColor(paramColor2);
/* 178 */         paramMeshPartBuilder.line(tmpV0, tmpV4);
/*     */       } 
/*     */       
/* 181 */       if (m != -1) {
/* 182 */         paramMeshPartBuilder.setColor(paramColor3);
/* 183 */         paramMeshPartBuilder.line(tmpV0, tmpV6);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void ensureVerticesCapacity(int paramInt) {
/* 189 */     if (vertices == null || vertices.length < paramInt) vertices = new float[paramInt]; 
/*     */   }
/*     */   
/*     */   private static void ensureIndicesCapacity(int paramInt) {
/* 193 */     if (indices == null || indices.length < paramInt) indices = new short[paramInt]; 
/*     */   }
/*     */   
/*     */   private static short minVerticeInIndices() {
/* 197 */     short s = Short.MAX_VALUE;
/* 198 */     for (byte b = 0; b < indices.length; b++) {
/* 199 */       if (indices[b] < s) s = indices[b]; 
/* 200 */     }  return s;
/*     */   }
/*     */   
/*     */   private static short maxVerticeInIndices() {
/* 204 */     short s = -32768;
/* 205 */     for (byte b = 0; b < indices.length; b++) {
/* 206 */       if (indices[b] > s) s = indices[b]; 
/* 207 */     }  return s;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\RenderableShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */