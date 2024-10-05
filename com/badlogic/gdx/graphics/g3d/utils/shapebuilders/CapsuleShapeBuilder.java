/*    */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
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
/*    */ public class CapsuleShapeBuilder
/*    */   extends BaseShapeBuilder
/*    */ {
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, int paramInt) {
/* 27 */     if (paramFloat2 < paramFloat1 * 2.0F) throw new GdxRuntimeException("Height must be at least twice the radius"); 
/* 28 */     paramFloat1 *= 2.0F;
/* 29 */     CylinderShapeBuilder.build(paramMeshPartBuilder, paramFloat1, paramFloat2 - paramFloat1, paramFloat1, paramInt, 0.0F, 360.0F, false);
/* 30 */     SphereShapeBuilder.build(paramMeshPartBuilder, matTmp1.setToTranslation(0.0F, 0.5F * (paramFloat2 - paramFloat1), 0.0F), paramFloat1, paramFloat1, paramFloat1, paramInt, paramInt, 0.0F, 360.0F, 0.0F, 90.0F);
/*    */     
/* 32 */     SphereShapeBuilder.build(paramMeshPartBuilder, matTmp1.setToTranslation(0.0F, -0.5F * (paramFloat2 - paramFloat1), 0.0F), paramFloat1, paramFloat1, paramFloat1, paramInt, paramInt, 0.0F, 360.0F, 90.0F, 180.0F);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\CapsuleShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */