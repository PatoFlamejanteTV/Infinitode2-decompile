/*    */ package com.badlogic.gdx.utils.viewport;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Camera;
/*    */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*    */ import com.badlogic.gdx.math.Vector2;
/*    */ import com.badlogic.gdx.utils.Scaling;
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
/*    */ 
/*    */ 
/*    */ public class ScalingViewport
/*    */   extends Viewport
/*    */ {
/*    */   private Scaling scaling;
/*    */   
/*    */   public ScalingViewport(Scaling paramScaling, float paramFloat1, float paramFloat2) {
/* 43 */     this(paramScaling, paramFloat1, paramFloat2, (Camera)new OrthographicCamera());
/*    */   }
/*    */   
/*    */   public ScalingViewport(Scaling paramScaling, float paramFloat1, float paramFloat2, Camera paramCamera) {
/* 47 */     this.scaling = paramScaling;
/* 48 */     setWorldSize(paramFloat1, paramFloat2);
/* 49 */     setCamera(paramCamera);
/*    */   }
/*    */   
/*    */   public void update(int paramInt1, int paramInt2, boolean paramBoolean) {
/*    */     Vector2 vector2;
/* 54 */     int j = Math.round((vector2 = this.scaling.apply(getWorldWidth(), getWorldHeight(), paramInt1, paramInt2)).x);
/* 55 */     int i = Math.round(vector2.y);
/*    */ 
/*    */     
/* 58 */     setScreenBounds((paramInt1 - j) / 2, (paramInt2 - i) / 2, j, i);
/*    */     
/* 60 */     apply(paramBoolean);
/*    */   }
/*    */   
/*    */   public Scaling getScaling() {
/* 64 */     return this.scaling;
/*    */   }
/*    */   
/*    */   public void setScaling(Scaling paramScaling) {
/* 68 */     this.scaling = paramScaling;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\viewport\ScalingViewport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */