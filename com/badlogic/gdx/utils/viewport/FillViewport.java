/*    */ package com.badlogic.gdx.utils.viewport;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Camera;
/*    */ import com.badlogic.gdx.utils.Scaling;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FillViewport
/*    */   extends ScalingViewport
/*    */ {
/*    */   public FillViewport(float paramFloat1, float paramFloat2) {
/* 15 */     super(Scaling.fill, paramFloat1, paramFloat2);
/*    */   }
/*    */   
/*    */   public FillViewport(float paramFloat1, float paramFloat2, Camera paramCamera) {
/* 19 */     super(Scaling.fill, paramFloat1, paramFloat2, paramCamera);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\viewport\FillViewport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */