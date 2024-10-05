/*    */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*    */ 
/*    */ import com.badlogic.gdx.audio.AudioRecorder;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ import javax.sound.sampled.AudioFormat;
/*    */ import javax.sound.sampled.AudioSystem;
/*    */ import javax.sound.sampled.TargetDataLine;
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
/*    */ public class JavaSoundAudioRecorder
/*    */   implements AudioRecorder
/*    */ {
/*    */   private TargetDataLine line;
/* 30 */   private byte[] buffer = new byte[4096];
/*    */   
/*    */   public JavaSoundAudioRecorder(int paramInt, boolean paramBoolean) {
/*    */     try {
/* 34 */       AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, paramInt, 16, paramBoolean ? 1 : 2, paramBoolean ? 2 : 4, paramInt, false);
/*    */       
/* 36 */       this.line = AudioSystem.getTargetDataLine(audioFormat);
/* 37 */       this.line.open(audioFormat, this.buffer.length);
/* 38 */       this.line.start(); return;
/* 39 */     } catch (Exception exception) {
/* 40 */       throw new GdxRuntimeException("Error creating JavaSoundAudioRecorder.", exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void read(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/* 45 */     if (this.buffer.length < paramInt2 << 1) this.buffer = new byte[paramInt2 << 1];
/*    */     
/* 47 */     paramInt2 <<= 1;
/* 48 */     int i = 0;
/* 49 */     while (i != paramInt2)
/* 50 */       i += this.line.read(this.buffer, i, paramInt2 - i); 
/*    */     byte b;
/* 52 */     for (i = 0, b = 0; i < paramInt2; i += 2, b++)
/* 53 */       paramArrayOfshort[paramInt1 + b] = (short)(this.buffer[i + 1] << 8 | this.buffer[i] & 0xFF); 
/*    */   }
/*    */   
/*    */   public void dispose() {
/* 57 */     this.line.close();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\JavaSoundAudioRecorder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */