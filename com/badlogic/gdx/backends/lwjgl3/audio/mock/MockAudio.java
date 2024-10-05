/*    */ package com.badlogic.gdx.backends.lwjgl3.audio.mock;
/*    */ 
/*    */ import com.badlogic.gdx.audio.AudioDevice;
/*    */ import com.badlogic.gdx.audio.AudioRecorder;
/*    */ import com.badlogic.gdx.audio.Music;
/*    */ import com.badlogic.gdx.audio.Sound;
/*    */ import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;
/*    */ import com.badlogic.gdx.files.FileHandle;
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
/*    */ public class MockAudio
/*    */   implements Lwjgl3Audio
/*    */ {
/*    */   public AudioDevice newAudioDevice(int paramInt, boolean paramBoolean) {
/* 32 */     return new MockAudioDevice();
/*    */   }
/*    */ 
/*    */   
/*    */   public AudioRecorder newAudioRecorder(int paramInt, boolean paramBoolean) {
/* 37 */     return new MockAudioRecorder();
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound newSound(FileHandle paramFileHandle) {
/* 42 */     return new MockSound();
/*    */   }
/*    */ 
/*    */   
/*    */   public Music newMusic(FileHandle paramFileHandle) {
/* 47 */     return new MockMusic();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean switchOutputDevice(String paramString) {
/* 52 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getAvailableOutputDevices() {
/* 57 */     return new String[0];
/*    */   }
/*    */   
/*    */   public void update() {}
/*    */   
/*    */   public void dispose() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\mock\MockAudio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */