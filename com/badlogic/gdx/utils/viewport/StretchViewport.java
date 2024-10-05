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
/*    */ public class StretchViewport
/*    */   extends ScalingViewport
/*    */ {
/*    */   public StretchViewport(float paramFloat1, float paramFloat2) {
/* 15 */     super(Scaling.stretch, paramFloat1, paramFloat2);
/*    */   }
/*    */   
/*    */   public StretchViewport(float paramFloat1, float paramFloat2, Camera paramCamera) {
/* 19 */     super(Scaling.stretch, paramFloat1, paramFloat2, paramCamera);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\viewport\StretchViewport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */