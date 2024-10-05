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
/*    */ public class ConeShapeBuilder
/*    */   extends BaseShapeBuilder
/*    */ {
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
/* 27 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramFloat3, paramInt, 0.0F, 360.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5) {
/* 32 */     build(paramMeshPartBuilder, paramFloat1, paramFloat2, paramFloat3, paramInt, paramFloat4, paramFloat5, true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5, boolean paramBoolean) {
/* 38 */     paramMeshPartBuilder.ensureVertices(paramInt + 2);
/* 39 */     paramMeshPartBuilder.ensureTriangleIndices(paramInt);
/*    */     
/* 41 */     float f1 = paramFloat1 * 0.5F;
/* 42 */     paramFloat2 *= 0.5F;
/* 43 */     float f2 = paramFloat3 * 0.5F;
/* 44 */     float f3 = 0.017453292F * paramFloat4;
/* 45 */     float f4 = 0.017453292F * (paramFloat5 - paramFloat4) / paramInt;
/* 46 */     float f5 = 1.0F / paramInt;
/*    */     
/*    */     MeshPartBuilder.VertexInfo vertexInfo2;
/*    */     
/* 50 */     (vertexInfo2 = vertTmp3.set(null, null, null, null)).hasUV = vertexInfo2.hasPosition = vertexInfo2.hasNormal = true;
/* 51 */     MeshPartBuilder.VertexInfo vertexInfo1 = vertTmp4.set(null, null, null, null).setPos(0.0F, paramFloat2, 0.0F).setNor(0.0F, 1.0F, 0.0F).setUV(0.5F, 0.0F);
/* 52 */     short s = paramMeshPartBuilder.vertex(vertexInfo1);
/* 53 */     short s1 = 0;
/* 54 */     for (byte b = 0; b <= paramInt; b++) {
/* 55 */       float f7 = f3 + f4 * b;
/* 56 */       float f6 = 1.0F - f5 * b;
/* 57 */       vertexInfo2.position.set(MathUtils.cos(f7) * f1, 0.0F, MathUtils.sin(f7) * f2);
/* 58 */       vertexInfo2.normal.set(vertexInfo2.position).nor();
/* 59 */       vertexInfo2.position.y = -paramFloat2;
/* 60 */       vertexInfo2.uv.set(f6, 1.0F);
/* 61 */       short s2 = paramMeshPartBuilder.vertex(vertexInfo2);
/* 62 */       if (b != 0) paramMeshPartBuilder.triangle(s, s2, s1); 
/* 63 */       s1 = s2;
/*    */     } 
/* 65 */     if (paramBoolean) EllipseShapeBuilder.build(paramMeshPartBuilder, paramFloat1, paramFloat3, 0.0F, 0.0F, paramInt, 0.0F, -paramFloat2, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 180.0F - paramFloat5, 180.0F - paramFloat4); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\ConeShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */