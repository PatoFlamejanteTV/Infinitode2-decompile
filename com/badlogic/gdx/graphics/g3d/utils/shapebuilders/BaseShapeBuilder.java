/*    */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
/*    */ import com.badlogic.gdx.math.Matrix4;
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ import com.badlogic.gdx.utils.FlushablePool;
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
/*    */ public class BaseShapeBuilder
/*    */ {
/* 30 */   protected static final Color tmpColor0 = new Color();
/* 31 */   protected static final Color tmpColor1 = new Color();
/* 32 */   protected static final Color tmpColor2 = new Color();
/* 33 */   protected static final Color tmpColor3 = new Color();
/* 34 */   protected static final Color tmpColor4 = new Color();
/*    */ 
/*    */   
/* 37 */   protected static final Vector3 tmpV0 = new Vector3();
/* 38 */   protected static final Vector3 tmpV1 = new Vector3();
/* 39 */   protected static final Vector3 tmpV2 = new Vector3();
/* 40 */   protected static final Vector3 tmpV3 = new Vector3();
/* 41 */   protected static final Vector3 tmpV4 = new Vector3();
/* 42 */   protected static final Vector3 tmpV5 = new Vector3();
/* 43 */   protected static final Vector3 tmpV6 = new Vector3();
/* 44 */   protected static final Vector3 tmpV7 = new Vector3();
/*    */ 
/*    */   
/* 47 */   protected static final MeshPartBuilder.VertexInfo vertTmp0 = new MeshPartBuilder.VertexInfo();
/* 48 */   protected static final MeshPartBuilder.VertexInfo vertTmp1 = new MeshPartBuilder.VertexInfo();
/* 49 */   protected static final MeshPartBuilder.VertexInfo vertTmp2 = new MeshPartBuilder.VertexInfo();
/* 50 */   protected static final MeshPartBuilder.VertexInfo vertTmp3 = new MeshPartBuilder.VertexInfo();
/* 51 */   protected static final MeshPartBuilder.VertexInfo vertTmp4 = new MeshPartBuilder.VertexInfo();
/* 52 */   protected static final MeshPartBuilder.VertexInfo vertTmp5 = new MeshPartBuilder.VertexInfo();
/* 53 */   protected static final MeshPartBuilder.VertexInfo vertTmp6 = new MeshPartBuilder.VertexInfo();
/* 54 */   protected static final MeshPartBuilder.VertexInfo vertTmp7 = new MeshPartBuilder.VertexInfo();
/* 55 */   protected static final MeshPartBuilder.VertexInfo vertTmp8 = new MeshPartBuilder.VertexInfo();
/*    */ 
/*    */   
/* 58 */   protected static final Matrix4 matTmp1 = new Matrix4();
/*    */   
/* 60 */   private static final FlushablePool<Vector3> vectorPool = new FlushablePool<Vector3>()
/*    */     {
/*    */       protected Vector3 newObject() {
/* 63 */         return new Vector3();
/*    */       }
/*    */     };
/*    */   
/* 67 */   private static final FlushablePool<Matrix4> matrices4Pool = new FlushablePool<Matrix4>()
/*    */     {
/*    */       protected Matrix4 newObject() {
/* 70 */         return new Matrix4();
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   protected static Vector3 obtainV3() {
/* 76 */     return (Vector3)vectorPool.obtain();
/*    */   }
/*    */ 
/*    */   
/*    */   protected static Matrix4 obtainM4() {
/*    */     Matrix4 matrix4;
/* 82 */     return matrix4 = (Matrix4)matrices4Pool.obtain();
/*    */   }
/*    */ 
/*    */   
/*    */   protected static void freeAll() {
/* 87 */     vectorPool.flush();
/* 88 */     matrices4Pool.flush();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\BaseShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */