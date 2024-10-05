/*    */ package com.badlogic.gdx.backends.headless.mock.audio;
/*    */ 
/*    */ import com.badlogic.gdx.Audio;
/*    */ import com.badlogic.gdx.audio.AudioDevice;
/*    */ import com.badlogic.gdx.audio.AudioRecorder;
/*    */ import com.badlogic.gdx.audio.Music;
/*    */ import com.badlogic.gdx.audio.Sound;
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
/*    */   implements Audio
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
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\headless\mock\audio\MockAudio.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */