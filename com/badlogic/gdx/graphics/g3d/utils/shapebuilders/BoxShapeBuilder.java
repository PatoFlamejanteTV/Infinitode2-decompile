/*     */ package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
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
/*     */ 
/*     */ public class BoxShapeBuilder
/*     */   extends BaseShapeBuilder
/*     */ {
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, BoundingBox paramBoundingBox) {
/*  34 */     paramMeshPartBuilder.box(paramBoundingBox.getCorner000(obtainV3()), paramBoundingBox.getCorner010(obtainV3()), paramBoundingBox.getCorner100(obtainV3()), paramBoundingBox
/*  35 */         .getCorner110(obtainV3()), paramBoundingBox.getCorner001(obtainV3()), paramBoundingBox.getCorner011(obtainV3()), paramBoundingBox.getCorner101(obtainV3()), paramBoundingBox
/*  36 */         .getCorner111(obtainV3()));
/*  37 */     freeAll();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4, MeshPartBuilder.VertexInfo paramVertexInfo5, MeshPartBuilder.VertexInfo paramVertexInfo6, MeshPartBuilder.VertexInfo paramVertexInfo7, MeshPartBuilder.VertexInfo paramVertexInfo8) {
/*  43 */     paramMeshPartBuilder.ensureVertices(8);
/*  44 */     short s1 = paramMeshPartBuilder.vertex(paramVertexInfo1);
/*  45 */     short s3 = paramMeshPartBuilder.vertex(paramVertexInfo3);
/*  46 */     short s4 = paramMeshPartBuilder.vertex(paramVertexInfo4);
/*  47 */     short s2 = paramMeshPartBuilder.vertex(paramVertexInfo2);
/*  48 */     short s5 = paramMeshPartBuilder.vertex(paramVertexInfo5);
/*  49 */     short s7 = paramMeshPartBuilder.vertex(paramVertexInfo7);
/*  50 */     short s8 = paramMeshPartBuilder.vertex(paramVertexInfo8);
/*  51 */     short s6 = paramMeshPartBuilder.vertex(paramVertexInfo6);
/*     */     
/*     */     int i;
/*  54 */     if ((i = paramMeshPartBuilder.getPrimitiveType()) == 1) {
/*  55 */       paramMeshPartBuilder.ensureIndices(24);
/*  56 */       paramMeshPartBuilder.rect(s1, s3, s4, s2);
/*  57 */       paramMeshPartBuilder.rect(s7, s5, s6, s8);
/*  58 */       paramMeshPartBuilder.index(s1, s5, s2, s6, s4, s8, s3, s7); return;
/*  59 */     }  if (i == 0) {
/*  60 */       paramMeshPartBuilder.ensureRectangleIndices(2);
/*  61 */       paramMeshPartBuilder.rect(s1, s3, s4, s2);
/*  62 */       paramMeshPartBuilder.rect(s7, s5, s6, s8); return;
/*     */     } 
/*  64 */     paramMeshPartBuilder.ensureRectangleIndices(6);
/*  65 */     paramMeshPartBuilder.rect(s1, s3, s4, s2);
/*  66 */     paramMeshPartBuilder.rect(s7, s5, s6, s8);
/*  67 */     paramMeshPartBuilder.rect(s1, s2, s6, s5);
/*  68 */     paramMeshPartBuilder.rect(s7, s8, s4, s3);
/*  69 */     paramMeshPartBuilder.rect(s7, s3, s1, s5);
/*  70 */     paramMeshPartBuilder.rect(s4, s8, s6, s2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, Vector3 paramVector36, Vector3 paramVector37, Vector3 paramVector38) {
/*  77 */     if ((paramMeshPartBuilder.getAttributes().getMask() & 0x198L) == 0L) {
/*  78 */       build(paramMeshPartBuilder, vertTmp1.set(paramVector31, null, null, null), vertTmp2.set(paramVector32, null, null, null), vertTmp3
/*  79 */           .set(paramVector33, null, null, null), vertTmp4.set(paramVector34, null, null, null), vertTmp5
/*  80 */           .set(paramVector35, null, null, null), vertTmp6.set(paramVector36, null, null, null), vertTmp7
/*  81 */           .set(paramVector37, null, null, null), vertTmp8.set(paramVector38, null, null, null)); return;
/*     */     } 
/*  83 */     paramMeshPartBuilder.ensureVertices(24);
/*  84 */     paramMeshPartBuilder.ensureRectangleIndices(6);
/*  85 */     Vector3 vector3 = tmpV1.set(paramVector31).lerp(paramVector34, 0.5F).sub(tmpV2.set(paramVector35).lerp(paramVector38, 0.5F)).nor();
/*  86 */     paramMeshPartBuilder.rect(paramVector31, paramVector32, paramVector34, paramVector33, vector3);
/*  87 */     paramMeshPartBuilder.rect(paramVector36, paramVector35, paramVector37, paramVector38, vector3.scl(-1.0F));
/*  88 */     vector3 = tmpV1.set(paramVector31).lerp(paramVector37, 0.5F).sub(tmpV2.set(paramVector32).lerp(paramVector38, 0.5F)).nor();
/*  89 */     paramMeshPartBuilder.rect(paramVector35, paramVector31, paramVector33, paramVector37, vector3);
/*  90 */     paramMeshPartBuilder.rect(paramVector32, paramVector36, paramVector38, paramVector34, vector3.scl(-1.0F));
/*  91 */     vector3 = tmpV1.set(paramVector31).lerp(paramVector36, 0.5F).sub(tmpV2.set(paramVector33).lerp(paramVector38, 0.5F)).nor();
/*  92 */     paramMeshPartBuilder.rect(paramVector35, paramVector36, paramVector32, paramVector31, vector3);
/*  93 */     paramMeshPartBuilder.rect(paramVector33, paramVector34, paramVector38, paramVector37, vector3.scl(-1.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, Matrix4 paramMatrix4) {
/*  99 */     build(paramMeshPartBuilder, obtainV3().set(-0.5F, -0.5F, -0.5F).mul(paramMatrix4), obtainV3().set(-0.5F, 0.5F, -0.5F).mul(paramMatrix4), 
/* 100 */         obtainV3().set(0.5F, -0.5F, -0.5F).mul(paramMatrix4), obtainV3().set(0.5F, 0.5F, -0.5F).mul(paramMatrix4), 
/* 101 */         obtainV3().set(-0.5F, -0.5F, 0.5F).mul(paramMatrix4), obtainV3().set(-0.5F, 0.5F, 0.5F).mul(paramMatrix4), 
/* 102 */         obtainV3().set(0.5F, -0.5F, 0.5F).mul(paramMatrix4), obtainV3().set(0.5F, 0.5F, 0.5F).mul(paramMatrix4));
/* 103 */     freeAll();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 108 */     build(paramMeshPartBuilder, 0.0F, 0.0F, 0.0F, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void build(MeshPartBuilder paramMeshPartBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 113 */     paramFloat4 *= 0.5F;
/* 114 */     paramFloat5 *= 0.5F;
/* 115 */     paramFloat6 *= 0.5F;
/* 116 */     float f1 = paramFloat1 - paramFloat4, f2 = paramFloat2 - paramFloat5, f3 = paramFloat3 - paramFloat6; paramFloat1 += paramFloat4; paramFloat2 += paramFloat5; paramFloat3 += paramFloat6;
/* 117 */     build(paramMeshPartBuilder, 
/* 118 */         obtainV3().set(f1, f2, f3), obtainV3().set(f1, paramFloat2, f3), obtainV3().set(paramFloat1, f2, f3), obtainV3().set(paramFloat1, paramFloat2, f3), 
/* 119 */         obtainV3().set(f1, f2, paramFloat3), obtainV3().set(f1, paramFloat2, paramFloat3), obtainV3().set(paramFloat1, f2, paramFloat3), obtainV3().set(paramFloat1, paramFloat2, paramFloat3));
/* 120 */     freeAll();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\shapebuilders\BoxShapeBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */