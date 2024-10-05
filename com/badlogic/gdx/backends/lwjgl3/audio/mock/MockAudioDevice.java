/*    */ package com.badlogic.gdx.backends.lwjgl3.audio.mock;
/*    */ 
/*    */ import com.badlogic.gdx.audio.AudioDevice;
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
/*    */ public class MockAudioDevice
/*    */   implements AudioDevice
/*    */ {
/*    */   public boolean isMono() {
/* 27 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void writeSamples(short[] paramArrayOfshort, int paramInt1, int paramInt2) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void writeSamples(float[] paramArrayOffloat, int paramInt1, int paramInt2) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLatency() {
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */   public void dispose() {}
/*    */   
/*    */   public void setVolume(float paramFloat) {}
/*    */   
/*    */   public void pause() {}
/*    */   
/*    */   public void resume() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\mock\MockAudioDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */