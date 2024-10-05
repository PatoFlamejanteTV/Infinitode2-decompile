/*    */ package com.badlogic.gdx;
/*    */ 
/*    */ 
/*    */ public abstract class AbstractGraphics
/*    */   implements Graphics
/*    */ {
/*    */   public float getRawDeltaTime() {
/*  8 */     return getDeltaTime();
/*    */   }
/*    */ 
/*    */   
/*    */   public float getDensity() {
/*    */     float f;
/* 14 */     if ((f = getPpiX()) > 0.0F && f <= Float.MAX_VALUE) return f / 160.0F;  return 1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getBackBufferScale() {
/* 19 */     return getBackBufferWidth() / getWidth();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\AbstractGraphics.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */