/*     */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*     */ 
/*     */ import com.badlogic.gdx.audio.Sound;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.openal.AL10;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpenALSound
/*     */   implements Sound
/*     */ {
/*  30 */   private int bufferID = -1;
/*     */   
/*     */   private final OpenALLwjgl3Audio audio;
/*     */   
/*     */   private float duration;
/*     */   
/*     */   public OpenALSound(OpenALLwjgl3Audio paramOpenALLwjgl3Audio) {
/*  37 */     this.audio = paramOpenALLwjgl3Audio;
/*     */   }
/*     */ 
/*     */   
/*     */   private int sampleRate;
/*     */   private int channels;
/*     */   private String type;
/*     */   
/*     */   void setup(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
/*     */     int i;
/*     */     ByteBuffer byteBuffer;
/*  48 */     (byteBuffer = BufferUtils.newByteBuffer(i = paramArrayOfbyte.length - paramArrayOfbyte.length % paramInt1 * (paramInt2 >> 3))).put(paramArrayOfbyte, 0, i);
/*  49 */     byteBuffer.flip();
/*     */     
/*  51 */     setup(byteBuffer.asShortBuffer(), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   void setup(ShortBuffer paramShortBuffer, int paramInt1, int paramInt2, int paramInt3) {
/*  55 */     this.channels = paramInt1;
/*  56 */     this.sampleRate = paramInt3;
/*  57 */     int i = (paramShortBuffer.limit() << 1) / (paramInt2 >> 3) / paramInt1;
/*  58 */     this.duration = i / paramInt3;
/*     */     
/*  60 */     if (this.bufferID == -1) {
/*  61 */       this.bufferID = AL10.alGenBuffers();
/*  62 */       paramInt1 = OpenALUtils.determineFormat(paramInt1, paramInt2);
/*  63 */       AL10.alBufferData(this.bufferID, paramInt1, paramShortBuffer, paramInt3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public long play() {
/*  68 */     return play(1.0F);
/*     */   }
/*     */   
/*     */   public long play(float paramFloat) {
/*  72 */     if (this.audio.noDevice) return 0L; 
/*     */     int i;
/*  74 */     if ((i = this.audio.obtainSource(false)) == -1) {
/*     */       
/*  76 */       this.audio.retain(this, true);
/*  77 */       i = this.audio.obtainSource(false);
/*     */     } else {
/*  79 */       this.audio.retain(this, false);
/*     */     } 
/*  81 */     if (i == -1) return -1L; 
/*  82 */     long l = this.audio.getSoundId(i);
/*  83 */     AL10.alSourcei(i, 4105, this.bufferID);
/*  84 */     AL10.alSourcei(i, 4103, 0);
/*  85 */     AL10.alSourcef(i, 4106, paramFloat);
/*  86 */     AL10.alSourcePlay(i);
/*  87 */     return l;
/*     */   }
/*     */   
/*     */   public long loop() {
/*  91 */     return loop(1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public long loop(float paramFloat) {
/*  96 */     if (this.audio.noDevice) return 0L; 
/*     */     int i;
/*  98 */     if ((i = this.audio.obtainSource(false)) == -1) return -1L; 
/*  99 */     long l = this.audio.getSoundId(i);
/* 100 */     AL10.alSourcei(i, 4105, this.bufferID);
/* 101 */     AL10.alSourcei(i, 4103, 1);
/* 102 */     AL10.alSourcef(i, 4106, paramFloat);
/* 103 */     AL10.alSourcePlay(i);
/* 104 */     return l;
/*     */   }
/*     */   
/*     */   public void stop() {
/* 108 */     if (this.audio.noDevice)
/* 109 */       return;  this.audio.stopSourcesWithBuffer(this.bufferID);
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 113 */     if (this.audio.noDevice)
/* 114 */       return;  if (this.bufferID == -1)
/* 115 */       return;  this.audio.freeBuffer(this.bufferID);
/* 116 */     AL10.alDeleteBuffers(this.bufferID);
/* 117 */     this.bufferID = -1;
/* 118 */     this.audio.forget(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop(long paramLong) {
/* 123 */     if (this.audio.noDevice)
/* 124 */       return;  this.audio.stopSound(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void pause() {
/* 129 */     if (this.audio.noDevice)
/* 130 */       return;  this.audio.pauseSourcesWithBuffer(this.bufferID);
/*     */   }
/*     */ 
/*     */   
/*     */   public void pause(long paramLong) {
/* 135 */     if (this.audio.noDevice)
/* 136 */       return;  this.audio.pauseSound(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resume() {
/* 141 */     if (this.audio.noDevice)
/* 142 */       return;  this.audio.resumeSourcesWithBuffer(this.bufferID);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resume(long paramLong) {
/* 147 */     if (this.audio.noDevice)
/* 148 */       return;  this.audio.resumeSound(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPitch(long paramLong, float paramFloat) {
/* 153 */     if (this.audio.noDevice)
/* 154 */       return;  this.audio.setSoundPitch(paramLong, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVolume(long paramLong, float paramFloat) {
/* 159 */     if (this.audio.noDevice)
/* 160 */       return;  this.audio.setSoundGain(paramLong, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLooping(long paramLong, boolean paramBoolean) {
/* 165 */     if (this.audio.noDevice)
/* 166 */       return;  this.audio.setSoundLooping(paramLong, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPan(long paramLong, float paramFloat1, float paramFloat2) {
/* 171 */     if (this.audio.noDevice)
/* 172 */       return;  this.audio.setSoundPan(paramLong, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */   
/*     */   public long play(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 177 */     long l = play();
/* 178 */     setPitch(l, paramFloat2);
/* 179 */     setPan(l, paramFloat3, paramFloat1);
/* 180 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public long loop(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 185 */     long l = loop();
/* 186 */     setPitch(l, paramFloat2);
/* 187 */     setPan(l, paramFloat3, paramFloat1);
/* 188 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public float duration() {
/* 193 */     return this.duration;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRate() {
/* 198 */     return this.sampleRate;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getChannels() {
/* 203 */     return this.channels;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setType(String paramString) {
/* 208 */     this.type = paramString;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 212 */     return this.type;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\OpenALSound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */