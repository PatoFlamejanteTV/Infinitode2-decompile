/*    */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */ 
/*    */ public class PatchShapeBuilder
/*    */   extends BaseShapeBuilder
/*    */ {
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4, int paramInt1, int paramInt2) {
/* 30 */     if (paramInt1 <= 0 || paramInt2 <= 0) {
/* 31 */       throw new GdxRuntimeException("divisionsU and divisionV must be > 0, u,v: " + paramInt1 + ", " + paramInt2);
/*    */     }
/* 33 */     paramMeshPartBuilder.ensureVertices((paramInt2 + 1) * (paramInt1 + 1));
/* 34 */     paramMeshPartBuilder.ensureRectangleIndices(paramInt2 * paramInt1);
/* 35 */     for (byte b = 0; b <= paramInt1; b++) {
/* 36 */       float f = b / paramInt1;
/* 37 */       vertTmp5.set(paramVertexInfo1).lerp(paramVertexInfo2, f);
/* 38 */       vertTmp6.set(paramVertexInfo4).lerp(paramVertexInfo3, f);
/* 39 */       for (byte b1 = 0; b1 <= paramInt2; b1++) {
/* 40 */         short s = paramMeshPartBuilder.vertex(vertTmp7.set(vertTmp5).lerp(vertTmp6, b1 / paramInt2));
/* 41 */         if (b > 0 && b1 > 0) paramMeshPartBuilder.rect((short)(s - paramInt2 - 2), (short)(s - 1), s, (short)(s - paramInt2 - 1));
/*    */       
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, int paramInt1, int paramInt2) {
/* 49 */     build(paramMeshPartBuilder, vertTmp1.set(paramVector31, paramVector35, null, null).setUV(0.0F, 1.0F), vertTmp2
/* 50 */         .set(paramVector32, paramVector35, null, null).setUV(1.0F, 1.0F), vertTmp3.set(paramVector33, paramVector35, null, null).setUV(1.0F, 0.0F), vertTmp4
/* 51 */         .set(paramVector34, paramVector35, null, null).setUV(0.0F, 0.0F), paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, int paramInt1, int paramInt2) {
/* 58 */     build(paramMeshPartBuilder, vertTmp1.set(null).setPos(paramFloat1, paramFloat2, paramFloat3).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(0.0F, 1.0F), vertTmp2
/* 59 */         .set(null).setPos(paramFloat4, paramFloat5, paramFloat6).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(1.0F, 1.0F), vertTmp3
/* 60 */         .set(null).setPos(paramFloat7, paramFloat8, paramFloat9).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(1.0F, 0.0F), vertTmp4
/* 61 */         .set(null).setPos(paramFloat10, paramFloat11, paramFloat12).setNor(paramFloat13, paramFloat14, paramFloat15).setUV(0.0F, 0.0F), paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\PatchShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */