/*    */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
/*    */ import com.badlogic.gdx.math.Matrix4;
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
/*    */ public class ArrowShapeBuilder
/*    */   extends BaseShapeBuilder
/*    */ {
/*    */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt) {
/* 38 */     Vector3 vector32 = obtainV3().set(paramFloat1, paramFloat2, paramFloat3), vector31 = obtainV3().set(paramFloat4, paramFloat5, paramFloat6);
/*    */     
/* 40 */     paramFloat6 = (paramFloat5 = vector32.dst(vector31)) * paramFloat7;
/* 41 */     paramFloat7 = 2.0F * (float)(paramFloat6 * Math.sqrt(0.3333333432674408D));
/* 42 */     paramFloat5 -= paramFloat6;
/* 43 */     paramFloat8 = paramFloat7 * paramFloat8;
/*    */     
/* 45 */     Vector3 vector33 = obtainV3().set(vector31).sub(vector32).nor();
/*    */     Vector3 vector34;
/* 47 */     if ((vector34 = obtainV3().set(vector33).crs(Vector3.Z)).isZero()) vector34.set(Vector3.X); 
/* 48 */     vector34.crs(vector33).nor();
/* 49 */     Vector3 vector35 = obtainV3().set(vector33).crs(vector34).nor();
/* 50 */     vector31 = obtainV3().set(vector31).sub(vector32).nor();
/*    */ 
/*    */     
/* 53 */     Matrix4 matrix41 = paramMeshPartBuilder.getVertexTransform(obtainM4());
/*    */     Matrix4 matrix43;
/*    */     float[] arrayOfFloat;
/* 56 */     (arrayOfFloat = (matrix43 = obtainM4()).val)[0] = vector35.x;
/* 57 */     arrayOfFloat[4] = vector33.x;
/* 58 */     arrayOfFloat[8] = vector34.x;
/* 59 */     arrayOfFloat[1] = vector35.y;
/* 60 */     arrayOfFloat[5] = vector33.y;
/* 61 */     arrayOfFloat[9] = vector34.y;
/* 62 */     arrayOfFloat[2] = vector35.z;
/* 63 */     arrayOfFloat[6] = vector33.z;
/* 64 */     arrayOfFloat[10] = vector34.z;
/* 65 */     Matrix4 matrix42 = obtainM4();
/*    */ 
/*    */     
/* 68 */     matrix43.setTranslation(obtainV3().set(vector31).scl(paramFloat5 / 2.0F).add(paramFloat1, paramFloat2, paramFloat3));
/* 69 */     paramMeshPartBuilder.setVertexTransform(matrix42.set(matrix43).mul(matrix41));
/* 70 */     CylinderShapeBuilder.build(paramMeshPartBuilder, paramFloat8, paramFloat5, paramFloat8, paramInt);
/*    */ 
/*    */     
/* 73 */     matrix43.setTranslation(obtainV3().set(vector31).scl(paramFloat5).add(paramFloat1, paramFloat2, paramFloat3));
/* 74 */     paramMeshPartBuilder.setVertexTransform(matrix42.set(matrix43).mul(matrix41));
/* 75 */     ConeShapeBuilder.build(paramMeshPartBuilder, paramFloat7, paramFloat6, paramFloat7, paramInt);
/*    */     
/* 77 */     paramMeshPartBuilder.setVertexTransform(matrix41);
/* 78 */     freeAll();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\ArrowShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */