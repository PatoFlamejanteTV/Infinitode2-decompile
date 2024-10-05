/*     */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
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
/*     */ public class EllipseShapeBuilder
/*     */   extends BaseShapeBuilder
/*     */ {
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/*  32 */     build(paramMeshPartBuilder, paramFloat1, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, 0.0F, 360.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32) {
/*  37 */     build(paramMeshPartBuilder, paramFloat, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34) {
/*  43 */     build(paramMeshPartBuilder, paramFloat, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13) {
/*  51 */     build(paramMeshPartBuilder, paramFloat1, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, 0.0F, 360.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  58 */     build(paramMeshPartBuilder, paramFloat1 * 2.0F, paramFloat1 * 2.0F, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat2, float paramFloat3) {
/*  65 */     build(paramMeshPartBuilder, paramFloat1, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat2, float paramFloat3) {
/*  71 */     build(paramMeshPartBuilder, paramFloat1, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15) {
/*  79 */     build(paramMeshPartBuilder, paramFloat1 * 2.0F, paramFloat1 * 2.0F, 0.0F, 0.0F, paramInt, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
/*  86 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, 0.0F, 360.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32) {
/*  92 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34) {
/*  98 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14) {
/* 106 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, 0.0F, 360.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/* 113 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat3, float paramFloat4) {
/* 119 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat3, float paramFloat4) {
/* 126 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, paramVector33.x, paramVector33.y, paramVector33.z, paramVector34.x, paramVector34.y, paramVector34.z, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16) {
/* 134 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, 0.0F, 0.0F, paramInt, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12) {
/* 142 */     tmpV1.set(paramFloat8, paramFloat9, paramFloat10).crs(0.0F, 0.0F, 1.0F);
/* 143 */     tmpV2.set(paramFloat8, paramFloat9, paramFloat10).crs(0.0F, 1.0F, 0.0F);
/* 144 */     if (tmpV2.len2() > tmpV1.len2()) tmpV1.set(tmpV2); 
/* 145 */     tmpV2.set(tmpV1.nor()).crs(paramFloat8, paramFloat9, paramFloat10).nor();
/* 146 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, tmpV1.x, tmpV1.y, tmpV1.z, tmpV2.x, tmpV2.y, tmpV2.z, paramFloat11, paramFloat12);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10) {
/* 153 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, 0.0F, 360.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, Vector3 paramVector31, Vector3 paramVector32) {
/* 160 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, 0.0F, 360.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18) {
/* 168 */     if (paramFloat3 <= 0.0F || paramFloat4 <= 0.0F) {
/* 169 */       paramMeshPartBuilder.ensureVertices(paramInt + 2);
/* 170 */       paramMeshPartBuilder.ensureTriangleIndices(paramInt);
/* 171 */     } else if (paramFloat3 == paramFloat1 && paramFloat4 == paramFloat2) {
/* 172 */       paramMeshPartBuilder.ensureVertices(paramInt + 1);
/* 173 */       paramMeshPartBuilder.ensureIndices(paramInt + 1);
/* 174 */       if (paramMeshPartBuilder.getPrimitiveType() != 1) throw new GdxRuntimeException("Incorrect primitive type : expect GL_LINES because innerWidth == width && innerHeight == height");
/*     */     
/*     */     } else {
/* 177 */       paramMeshPartBuilder.ensureVertices(paramInt + 1 << 1);
/* 178 */       paramMeshPartBuilder.ensureRectangleIndices(paramInt + 1);
/*     */     } 
/*     */     
/* 181 */     float f = 0.017453292F * paramFloat17;
/* 182 */     paramFloat17 = 0.017453292F * (paramFloat18 - paramFloat17) / paramInt;
/* 183 */     Vector3 vector33 = tmpV1.set(paramFloat11, paramFloat12, paramFloat13).scl(paramFloat1 * 0.5F);
/* 184 */     Vector3 vector34 = tmpV2.set(paramFloat14, paramFloat15, paramFloat16).scl(paramFloat2 * 0.5F);
/* 185 */     Vector3 vector31 = tmpV3.set(paramFloat11, paramFloat12, paramFloat13).scl(paramFloat3 * 0.5F);
/* 186 */     Vector3 vector32 = tmpV4.set(paramFloat14, paramFloat15, paramFloat16).scl(paramFloat4 * 0.5F);
/*     */     MeshPartBuilder.VertexInfo vertexInfo1;
/* 188 */     (vertexInfo1 = vertTmp3.set(null, null, null, null)).hasUV = vertexInfo1.hasPosition = vertexInfo1.hasNormal = true;
/* 189 */     vertexInfo1.uv.set(0.5F, 0.5F);
/* 190 */     vertexInfo1.position.set(paramFloat5, paramFloat6, paramFloat7);
/* 191 */     vertexInfo1.normal.set(paramFloat8, paramFloat9, paramFloat10);
/*     */     MeshPartBuilder.VertexInfo vertexInfo2;
/* 193 */     (vertexInfo2 = vertTmp4.set(null, null, null, null)).hasUV = vertexInfo2.hasPosition = vertexInfo2.hasNormal = true;
/* 194 */     vertexInfo2.uv.set(0.5F, 0.5F);
/* 195 */     vertexInfo2.position.set(paramFloat5, paramFloat6, paramFloat7);
/* 196 */     vertexInfo2.normal.set(paramFloat8, paramFloat9, paramFloat10);
/* 197 */     short s = paramMeshPartBuilder.vertex(vertexInfo2);
/*     */     
/* 199 */     paramFloat10 = 0.5F * paramFloat3 / paramFloat1;
/* 200 */     paramFloat15 = 0.5F * paramFloat4 / paramFloat2;
/* 201 */     short s1 = 0, s2 = 0, s3 = 0;
/* 202 */     for (byte b = 0; b <= paramInt; b++) {
/*     */       
/* 204 */       float f1 = MathUtils.cos(paramFloat9 = f + paramFloat17 * b);
/* 205 */       float f2 = MathUtils.sin(paramFloat9);
/* 206 */       vertexInfo2.position.set(paramFloat5, paramFloat6, paramFloat7).add(vector33.x * f1 + vector34.x * f2, vector33.y * f1 + vector34.y * f2, vector33.z * f1 + vector34.z * f2);
/*     */       
/* 208 */       vertexInfo2.uv.set(0.5F + 0.5F * f1, 0.5F + 0.5F * f2);
/* 209 */       short s4 = paramMeshPartBuilder.vertex(vertexInfo2);
/*     */       
/* 211 */       if (paramFloat3 <= 0.0F || paramFloat4 <= 0.0F) {
/* 212 */         if (b != 0) paramMeshPartBuilder.triangle(s4, s1, s); 
/* 213 */         s1 = s4;
/* 214 */       } else if (paramFloat3 == paramFloat1 && paramFloat4 == paramFloat2) {
/* 215 */         if (b != 0) paramMeshPartBuilder.line(s4, s1); 
/* 216 */         s1 = s4;
/*     */       } else {
/* 218 */         vertexInfo1.position.set(paramFloat5, paramFloat6, paramFloat7).add(vector31.x * f1 + vector32.x * f2, vector31.y * f1 + vector32.y * f2, vector31.z * f1 + vector32.z * f2);
/*     */         
/* 220 */         vertexInfo1.uv.set(0.5F + paramFloat10 * f1, 0.5F + paramFloat15 * f2);
/* 221 */         s1 = s4;
/* 222 */         s4 = paramMeshPartBuilder.vertex(vertexInfo1);
/*     */         
/* 224 */         if (b != 0) paramMeshPartBuilder.rect(s4, s1, s3, s2); 
/* 225 */         s3 = s1;
/* 226 */         s2 = s4;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\EllipseShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */