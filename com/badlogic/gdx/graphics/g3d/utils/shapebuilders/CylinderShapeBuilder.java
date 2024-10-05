/*    */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
/*    */ import com.badlogic.gdx.math.MathUtils;
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
/*    */ public class CylinderShapeBuilder
/*    */   extends BaseShapeBuilder
/*    */ {
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
/* 28 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramFloat3, paramInt, 0.0F, 360.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5) {
/* 34 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramFloat3, paramInt, paramFloat4, paramFloat5, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5, boolean paramBoolean) {
/* 41 */     float f1 = paramFloat1 * 0.5F;
/* 42 */     paramFloat2 *= 0.5F;
/* 43 */     float f2 = paramFloat3 * 0.5F;
/* 44 */     float f3 = 0.017453292F * paramFloat4;
/* 45 */     float f4 = 0.017453292F * (paramFloat5 - paramFloat4) / paramInt;
/* 46 */     float f5 = 1.0F / paramInt;
/*    */     
/*    */     MeshPartBuilder.VertexInfo vertexInfo1;
/*    */     
/* 50 */     (vertexInfo1 = vertTmp3.set(null, null, null, null)).hasUV = vertexInfo1.hasPosition = vertexInfo1.hasNormal = true;
/*    */     MeshPartBuilder.VertexInfo vertexInfo2;
/* 52 */     (vertexInfo2 = vertTmp4.set(null, null, null, null)).hasUV = vertexInfo2.hasPosition = vertexInfo2.hasNormal = true;
/* 53 */     short s1 = 0, s2 = 0;
/*    */     
/* 55 */     paramMeshPartBuilder.ensureVertices(2 * (paramInt + 1));
/* 56 */     paramMeshPartBuilder.ensureRectangleIndices(paramInt);
/* 57 */     for (byte b = 0; b <= paramInt; b++) {
/* 58 */       float f7 = f3 + f4 * b;
/* 59 */       float f6 = 1.0F - f5 * b;
/* 60 */       vertexInfo1.position.set(MathUtils.cos(f7) * f1, 0.0F, MathUtils.sin(f7) * f2);
/* 61 */       vertexInfo1.normal.set(vertexInfo1.position).nor();
/* 62 */       vertexInfo1.position.y = -paramFloat2;
/* 63 */       vertexInfo1.uv.set(f6, 1.0F);
/* 64 */       vertexInfo2.position.set(vertexInfo1.position);
/* 65 */       vertexInfo2.normal.set(vertexInfo1.normal);
/* 66 */       vertexInfo2.position.y = paramFloat2;
/* 67 */       vertexInfo2.uv.set(f6, 0.0F);
/* 68 */       short s4 = paramMeshPartBuilder.vertex(vertexInfo1);
/* 69 */       short s3 = paramMeshPartBuilder.vertex(vertexInfo2);
/* 70 */       if (b != 0) paramMeshPartBuilder.rect(s1, s3, s4, s2); 
/* 71 */       s2 = s4;
/* 72 */       s1 = s3;
/*    */     } 
/* 74 */     if (paramBoolean) {
/* 75 */       EllipseShapeBuilder.build(paramMeshPartBuilder, paramFloat1, paramFloat3, 0.0F, 0.0F, paramInt, 0.0F, paramFloat2, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, paramFloat4, paramFloat5);
/*    */       
/* 77 */       EllipseShapeBuilder.build(paramMeshPartBuilder, paramFloat1, paramFloat3, 0.0F, 0.0F, paramInt, 0.0F, -paramFloat2, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 180.0F - paramFloat5, 180.0F - paramFloat4);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\CylinderShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */