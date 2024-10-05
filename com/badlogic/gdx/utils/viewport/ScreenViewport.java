/*    */ package com.badlogic.gdx.utils.viewport;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Camera;
/*    */ import com.badlogic.gdx.graphics.OrthographicCamera;
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
/*    */ public class ScreenViewport
/*    */   extends Viewport
/*    */ {
/* 27 */   private float unitsPerPixel = 1.0F;
/*    */ 
/*    */   
/*    */   public ScreenViewport() {
/* 31 */     this((Camera)new OrthographicCamera());
/*    */   }
/*    */   
/*    */   public ScreenViewport(Camera paramCamera) {
/* 35 */     setCamera(paramCamera);
/*    */   }
/*    */   
/*    */   public void update(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 39 */     setScreenBounds(0, 0, paramInt1, paramInt2);
/* 40 */     setWorldSize(paramInt1 * this.unitsPerPixel, paramInt2 * this.unitsPerPixel);
/* 41 */     apply(paramBoolean);
/*    */   }
/*    */   
/*    */   public float getUnitsPerPixel() {
/* 45 */     return this.unitsPerPixel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUnitsPerPixel(float paramFloat) {
/* 51 */     this.unitsPerPixel = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\viewport\ScreenViewport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */