/*     */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
/*     */ import com.badlogic.gdx.math.Frustum;
/*     */ import com.badlogic.gdx.math.Vector3;
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
/*     */ public class FrustumShapeBuilder
/*     */   extends BaseShapeBuilder
/*     */ {
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, Camera paramCamera) {
/*  34 */     build(paramMeshPartBuilder, paramCamera, tmpColor0.set(1.0F, 0.66F, 0.0F, 1.0F), tmpColor1.set(1.0F, 0.0F, 0.0F, 1.0F), tmpColor2.set(0.0F, 0.66F, 1.0F, 1.0F), tmpColor3
/*  35 */         .set(1.0F, 1.0F, 1.0F, 1.0F), tmpColor4.set(0.2F, 0.2F, 0.2F, 1.0F));
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
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, Camera paramCamera, Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4, Color paramColor5) {
/*  48 */     Vector3[] arrayOfVector3 = paramCamera.frustum.planePoints;
/*     */ 
/*     */     
/*  51 */     build(paramMeshPartBuilder, paramCamera.frustum, paramColor1, paramColor5);
/*     */ 
/*     */     
/*  54 */     paramMeshPartBuilder.line(arrayOfVector3[0], paramColor2, paramCamera.position, paramColor2);
/*  55 */     paramMeshPartBuilder.line(arrayOfVector3[1], paramColor2, paramCamera.position, paramColor2);
/*  56 */     paramMeshPartBuilder.line(arrayOfVector3[2], paramColor2, paramCamera.position, paramColor2);
/*  57 */     paramMeshPartBuilder.line(arrayOfVector3[3], paramColor2, paramCamera.position, paramColor2);
/*     */ 
/*     */     
/*  60 */     paramMeshPartBuilder.line(paramCamera.position, paramColor4, centerPoint(arrayOfVector3[4], arrayOfVector3[5], arrayOfVector3[6]), paramColor4);
/*     */ 
/*     */     
/*  63 */     float f = tmpV0.set(arrayOfVector3[1]).sub(arrayOfVector3[0]).scl(0.5F).len();
/*  64 */     Vector3 vector3 = centerPoint(arrayOfVector3[0], arrayOfVector3[1], arrayOfVector3[2]);
/*  65 */     tmpV0.set(paramCamera.up).scl(f * 2.0F);
/*  66 */     vector3.add(tmpV0);
/*     */     
/*  68 */     paramMeshPartBuilder.line(vector3, paramColor3, arrayOfVector3[2], paramColor3);
/*  69 */     paramMeshPartBuilder.line(arrayOfVector3[2], paramColor3, arrayOfVector3[3], paramColor3);
/*  70 */     paramMeshPartBuilder.line(arrayOfVector3[3], paramColor3, vector3, paramColor3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, Frustum paramFrustum, Color paramColor1, Color paramColor2) {
/*  79 */     Vector3[] arrayOfVector3 = paramFrustum.planePoints;
/*     */ 
/*     */     
/*  82 */     paramMeshPartBuilder.line(arrayOfVector3[0], paramColor1, arrayOfVector3[1], paramColor1);
/*  83 */     paramMeshPartBuilder.line(arrayOfVector3[1], paramColor1, arrayOfVector3[2], paramColor1);
/*  84 */     paramMeshPartBuilder.line(arrayOfVector3[2], paramColor1, arrayOfVector3[3], paramColor1);
/*  85 */     paramMeshPartBuilder.line(arrayOfVector3[3], paramColor1, arrayOfVector3[0], paramColor1);
/*     */ 
/*     */     
/*  88 */     paramMeshPartBuilder.line(arrayOfVector3[4], paramColor1, arrayOfVector3[5], paramColor1);
/*  89 */     paramMeshPartBuilder.line(arrayOfVector3[5], paramColor1, arrayOfVector3[6], paramColor1);
/*  90 */     paramMeshPartBuilder.line(arrayOfVector3[6], paramColor1, arrayOfVector3[7], paramColor1);
/*  91 */     paramMeshPartBuilder.line(arrayOfVector3[7], paramColor1, arrayOfVector3[4], paramColor1);
/*     */ 
/*     */     
/*  94 */     paramMeshPartBuilder.line(arrayOfVector3[0], paramColor1, arrayOfVector3[4], paramColor1);
/*  95 */     paramMeshPartBuilder.line(arrayOfVector3[1], paramColor1, arrayOfVector3[5], paramColor1);
/*  96 */     paramMeshPartBuilder.line(arrayOfVector3[2], paramColor1, arrayOfVector3[6], paramColor1);
/*  97 */     paramMeshPartBuilder.line(arrayOfVector3[3], paramColor1, arrayOfVector3[7], paramColor1);
/*     */ 
/*     */     
/* 100 */     paramMeshPartBuilder.line(middlePoint(arrayOfVector3[1], arrayOfVector3[0]), paramColor2, middlePoint(arrayOfVector3[3], arrayOfVector3[2]), paramColor2);
/*     */     
/* 102 */     paramMeshPartBuilder.line(middlePoint(arrayOfVector3[2], arrayOfVector3[1]), paramColor2, middlePoint(arrayOfVector3[3], arrayOfVector3[0]), paramColor2);
/*     */ 
/*     */ 
/*     */     
/* 106 */     paramMeshPartBuilder.line(middlePoint(arrayOfVector3[5], arrayOfVector3[4]), paramColor2, middlePoint(arrayOfVector3[7], arrayOfVector3[6]), paramColor2);
/*     */     
/* 108 */     paramMeshPartBuilder.line(middlePoint(arrayOfVector3[6], arrayOfVector3[5]), paramColor2, middlePoint(arrayOfVector3[7], arrayOfVector3[4]), paramColor2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Vector3 middlePoint(Vector3 paramVector31, Vector3 paramVector32) {
/* 117 */     tmpV0.set(paramVector32).sub(paramVector31).scl(0.5F);
/* 118 */     return tmpV1.set(paramVector31).add(tmpV0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Vector3 centerPoint(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33) {
/* 127 */     tmpV0.set(paramVector32).sub(paramVector31).scl(0.5F);
/* 128 */     tmpV1.set(paramVector31).add(tmpV0);
/* 129 */     tmpV0.set(paramVector33).sub(paramVector32).scl(0.5F);
/* 130 */     return tmpV1.add(tmpV0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\FrustumShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */