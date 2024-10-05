/*    */ package com.badlogic.gdx.backends.headless.mock.audio;
/*    */ 
/*    */ import com.badlogic.gdx.audio.Music;
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
/*    */ public class MockMusic
/*    */   implements Music
/*    */ {
/*    */   public void play() {}
/*    */   
/*    */   public void pause() {}
/*    */   
/*    */   public void stop() {}
/*    */   
/*    */   public boolean isPlaying() {
/* 41 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setLooping(boolean paramBoolean) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isLooping() {
/* 51 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setVolume(float paramFloat) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public float getVolume() {
/* 61 */     return 0.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPan(float paramFloat1, float paramFloat2) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPosition(float paramFloat) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public float getPosition() {
/* 76 */     return 0.0F;
/*    */   }
/*    */   
/*    */   public void dispose() {}
/*    */   
/*    */   public void setOnCompletionListener(Music.OnCompletionListener paramOnCompletionListener) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\headless\mock\audio\MockMusic.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */