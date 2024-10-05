/*     */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Matrix3;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.utils.ShortArray;
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
/*     */ public class SphereShapeBuilder
/*     */   extends BaseShapeBuilder
/*     */ {
/*  29 */   private static final ShortArray tmpIndices = new ShortArray();
/*  30 */   private static final Matrix3 normalTransform = new Matrix3();
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2) {
/*  33 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, 0.0F, 360.0F, 0.0F, 180.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2) {
/*  41 */     build(paramMeshPartBuilder, paramMatrix4, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, 0.0F, 360.0F, 0.0F, 180.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/*  46 */     build(paramMeshPartBuilder, matTmp1.idt(), paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramFloat4, paramFloat5, paramFloat6, paramFloat7);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) {
/*  54 */     boolean bool1 = MathUtils.isEqual(paramFloat6, 0.0F);
/*  55 */     boolean bool2 = MathUtils.isEqual(paramFloat7, 180.0F);
/*  56 */     paramFloat1 *= 0.5F;
/*  57 */     paramFloat2 *= 0.5F;
/*  58 */     paramFloat3 *= 0.5F;
/*  59 */     float f1 = 0.017453292F * paramFloat4;
/*  60 */     paramFloat4 = 0.017453292F * (paramFloat5 - paramFloat4) / paramInt1;
/*  61 */     paramFloat5 = 0.017453292F * paramFloat6;
/*  62 */     paramFloat6 = 0.017453292F * (paramFloat7 - paramFloat6) / paramInt2;
/*  63 */     paramFloat7 = 1.0F / paramInt1;
/*  64 */     float f2 = 1.0F / paramInt2;
/*     */ 
/*     */     
/*     */     MeshPartBuilder.VertexInfo vertexInfo;
/*     */ 
/*     */     
/*  70 */     (vertexInfo = vertTmp3.set(null, null, null, null)).hasUV = vertexInfo.hasPosition = vertexInfo.hasNormal = true;
/*     */     
/*  72 */     normalTransform.set(paramMatrix4);
/*     */     
/*  74 */     int i = paramInt1 + 3;
/*  75 */     tmpIndices.clear();
/*  76 */     tmpIndices.ensureCapacity(paramInt1 << 1);
/*  77 */     tmpIndices.size = i;
/*  78 */     int j = 0;
/*     */     
/*  80 */     paramMeshPartBuilder.ensureVertices((paramInt2 + 1) * (paramInt1 + 1));
/*  81 */     paramMeshPartBuilder.ensureRectangleIndices(paramInt1);
/*  82 */     for (byte b = 0; b <= paramInt2; b++) {
/*  83 */       float f3 = paramFloat5 + paramFloat6 * b;
/*  84 */       float f4 = f2 * b;
/*  85 */       float f5 = MathUtils.sin(f3);
/*  86 */       float f6 = MathUtils.cos(f3) * paramFloat2;
/*  87 */       for (byte b1 = 0; b1 <= paramInt1; b1++) {
/*  88 */         float f = f1 + paramFloat4 * b1;
/*  89 */         if ((b == 0 && bool1) || (b == paramInt2 && bool2)) {
/*  90 */           f3 = 1.0F - paramFloat7 * (b1 - 0.5F);
/*     */         } else {
/*  92 */           f3 = 1.0F - paramFloat7 * b1;
/*     */         } 
/*  94 */         vertexInfo.position.set(MathUtils.cos(f) * paramFloat1 * f5, f6, MathUtils.sin(f) * paramFloat3 * f5);
/*  95 */         vertexInfo.normal.set(vertexInfo.position).mul(normalTransform).nor();
/*  96 */         vertexInfo.position.mul(paramMatrix4);
/*  97 */         vertexInfo.uv.set(f3, f4);
/*  98 */         tmpIndices.set(j, paramMeshPartBuilder.vertex(vertexInfo));
/*  99 */         int k = j + i;
/* 100 */         if (b > 0 && b1 > 0) {
/* 101 */           if (b == 1 && bool1) {
/* 102 */             paramMeshPartBuilder.triangle(tmpIndices.get(j), tmpIndices.get((k - 1) % i), tmpIndices
/* 103 */                 .get((k - paramInt1 + 1) % i));
/* 104 */           } else if (b == paramInt2 && bool2) {
/* 105 */             paramMeshPartBuilder.triangle(tmpIndices.get(j), tmpIndices.get((k - paramInt1 + 2) % i), tmpIndices
/* 106 */                 .get((k - paramInt1 + 1) % i));
/*     */           } else {
/* 108 */             paramMeshPartBuilder.rect(tmpIndices.get(j), tmpIndices.get((k - 1) % i), tmpIndices
/* 109 */                 .get((k - paramInt1 + 2) % i), tmpIndices.get((k - paramInt1 + 1) % i));
/*     */           } 
/*     */         }
/* 112 */         j = (j + 1) % tmpIndices.size;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\SphereShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */