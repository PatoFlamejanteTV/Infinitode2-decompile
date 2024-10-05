/*    */ package com.badlogic.gdx.graphics.g3d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Camera;
/*    */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*    */ import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
/*    */ import com.badlogic.gdx.math.Matrix4;
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import java.util.Comparator;
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
/*    */ public class DefaultRenderableSorter
/*    */   implements RenderableSorter, Comparator<Renderable>
/*    */ {
/*    */   private Camera camera;
/* 30 */   private final Vector3 tmpV1 = new Vector3();
/* 31 */   private final Vector3 tmpV2 = new Vector3();
/*    */ 
/*    */   
/*    */   public void sort(Camera paramCamera, Array<Renderable> paramArray) {
/* 35 */     this.camera = paramCamera;
/* 36 */     paramArray.sort(this);
/*    */   }
/*    */   
/*    */   private Vector3 getTranslation(Matrix4 paramMatrix4, Vector3 paramVector31, Vector3 paramVector32) {
/* 40 */     if (paramVector31.isZero()) {
/* 41 */       paramMatrix4.getTranslation(paramVector32);
/* 42 */     } else if (!paramMatrix4.hasRotationOrScaling()) {
/* 43 */       paramMatrix4.getTranslation(paramVector32).add(paramVector31);
/*    */     } else {
/* 45 */       paramVector32.set(paramVector31).mul(paramMatrix4);
/* 46 */     }  return paramVector32;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int compare(Renderable paramRenderable1, Renderable paramRenderable2) {
/* 52 */     boolean bool1 = (paramRenderable1.material.has(BlendingAttribute.Type) && ((BlendingAttribute)paramRenderable1.material.get(BlendingAttribute.Type)).blended) ? true : false;
/*    */     
/* 54 */     boolean bool2 = (paramRenderable2.material.has(BlendingAttribute.Type) && ((BlendingAttribute)paramRenderable2.material.get(BlendingAttribute.Type)).blended) ? true : false;
/* 55 */     if (bool1 != bool2) return bool1 ? 1 : -1;
/*    */ 
/*    */ 
/*    */     
/* 59 */     getTranslation(paramRenderable1.worldTransform, paramRenderable1.meshPart.center, this.tmpV1);
/* 60 */     getTranslation(paramRenderable2.worldTransform, paramRenderable2.meshPart.center, this.tmpV2);
/*    */     float f;
/* 62 */     byte b = ((f = ((int)(1000.0F * this.camera.position.dst2(this.tmpV1)) - (int)(1000.0F * this.camera.position.dst2(this.tmpV2)))) < 0.0F) ? -1 : ((f > 0.0F) ? 1 : 0);
/* 63 */     return bool1 ? -b : b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\DefaultRenderableSorter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */