/*    */ package com.badlogic.gdx.graphics;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.utils.TimeUtils;
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
/*    */ public class FPSLogger
/*    */ {
/*    */   long startTime;
/*    */   int bound;
/*    */   
/*    */   public FPSLogger() {
/* 31 */     this(2147483647);
/*    */   }
/*    */ 
/*    */   
/*    */   public FPSLogger(int paramInt) {
/* 36 */     this.bound = paramInt;
/* 37 */     this.startTime = TimeUtils.nanoTime();
/*    */   }
/*    */   
/*    */   public void log() {
/*    */     long l;
/*    */     int i;
/* 43 */     if ((l = TimeUtils.nanoTime()) - this.startTime > 1000000000L && (
/*    */       
/* 45 */       i = Gdx.graphics.getFramesPerSecond()) < this.bound) {
/* 46 */       Gdx.app.log("FPSLogger", "fps: " + i);
/* 47 */       this.startTime = l;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\FPSLogger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */