/*     */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*     */ 
/*     */ import com.badlogic.gdx.audio.AudioDevice;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
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
/*     */ 
/*     */ public class OpenALAudioDevice
/*     */   implements AudioDevice
/*     */ {
/*     */   private static final int bytesPerSample = 2;
/*     */   private final OpenALLwjgl3Audio audio;
/*     */   private final int channels;
/*     */   private IntBuffer buffers;
/*     */   private int format;
/*     */   private int sampleRate;
/*  39 */   private int sourceID = -1;
/*     */   
/*     */   private boolean isPlaying;
/*  42 */   private float volume = 1.0F;
/*     */   
/*     */   private float renderedSeconds;
/*     */   
/*     */   private float secondsPerBuffer;
/*     */   private byte[] bytes;
/*     */   
/*     */   public OpenALAudioDevice(OpenALLwjgl3Audio paramOpenALLwjgl3Audio, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
/*  50 */     this.audio = paramOpenALLwjgl3Audio;
/*  51 */     this.channels = paramBoolean ? 1 : 2;
/*  52 */     this.bufferSize = paramInt2;
/*  53 */     this.bufferCount = paramInt3;
/*  54 */     this.format = (this.channels > 1) ? 4355 : 4353;
/*  55 */     this.sampleRate = paramInt1;
/*  56 */     this.secondsPerBuffer = paramInt2 / 2.0F / this.channels / paramInt1;
/*  57 */     this.tempBuffer = BufferUtils.createByteBuffer(paramInt2);
/*     */   }
/*     */   private final int bufferSize; private final int bufferCount; private final ByteBuffer tempBuffer;
/*     */   public void writeSamples(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/*  61 */     if (this.bytes == null || this.bytes.length < paramInt2 << 1) this.bytes = new byte[paramInt2 << 1]; 
/*  62 */     int i = Math.min(paramInt1 + paramInt2, paramArrayOfshort.length); byte b;
/*  63 */     for (paramInt1 = paramInt1, b = 0; paramInt1 < i; paramInt1++) {
/*  64 */       short s = paramArrayOfshort[paramInt1];
/*  65 */       this.bytes[b++] = (byte)s;
/*  66 */       this.bytes[b++] = (byte)(s >> 8);
/*     */     } 
/*  68 */     writeSamples(this.bytes, 0, paramInt2 << 1);
/*     */   }
/*     */   
/*     */   public void writeSamples(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  72 */     if (this.bytes == null || this.bytes.length < paramInt2 << 1) this.bytes = new byte[paramInt2 << 1]; 
/*  73 */     int i = Math.min(paramInt1 + paramInt2, paramArrayOffloat.length); byte b;
/*  74 */     for (paramInt1 = paramInt1, b = 0; paramInt1 < i; paramInt1++) {
/*     */       float f;
/*     */       
/*  77 */       int j = (int)((f = MathUtils.clamp(f = paramArrayOffloat[paramInt1], -1.0F, 1.0F)) * 32767.0F);
/*  78 */       this.bytes[b++] = (byte)j;
/*  79 */       this.bytes[b++] = (byte)(j >> 8);
/*     */     } 
/*  81 */     writeSamples(this.bytes, 0, paramInt2 << 1);
/*     */   }
/*     */   
/*     */   public void writeSamples(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  85 */     if (paramInt2 < 0) throw new IllegalArgumentException("length cannot be < 0.");
/*     */     
/*  87 */     if (this.sourceID == -1) {
/*  88 */       this.sourceID = this.audio.obtainSource(true);
/*  89 */       if (this.sourceID == -1)
/*  90 */         return;  if (this.buffers == null) {
/*  91 */         this.buffers = BufferUtils.createIntBuffer(this.bufferCount);
/*  92 */         AL10.alGetError();
/*  93 */         AL10.alGenBuffers(this.buffers);
/*  94 */         if (AL10.alGetError() != 0) throw new GdxRuntimeException("Unabe to allocate audio buffers."); 
/*     */       } 
/*  96 */       AL10.alSourcei(this.sourceID, 4103, 0);
/*  97 */       AL10.alSourcef(this.sourceID, 4106, this.volume);
/*     */       
/*  99 */       for (byte b = 0; b < this.bufferCount; b++) {
/* 100 */         int i = this.buffers.get(b);
/* 101 */         int j = Math.min(this.bufferSize, paramInt2);
/* 102 */         this.tempBuffer.clear();
/* 103 */         this.tempBuffer.put(paramArrayOfbyte, paramInt1, j).flip();
/* 104 */         AL10.alBufferData(i, this.format, this.tempBuffer, this.sampleRate);
/* 105 */         AL10.alSourceQueueBuffers(this.sourceID, i);
/* 106 */         paramInt2 -= j;
/* 107 */         paramInt1 += j;
/*     */       } 
/* 109 */       AL10.alSourcePlay(this.sourceID);
/* 110 */       this.isPlaying = true;
/*     */     } 
/*     */     
/* 113 */     while (paramInt2 > 0) {
/* 114 */       int i = fillBuffer(paramArrayOfbyte, paramInt1, paramInt2);
/* 115 */       paramInt2 -= i;
/* 116 */       paramInt1 += i;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int fillBuffer(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 122 */     paramInt2 = Math.min(this.bufferSize, paramInt2);
/*     */     
/*     */     while (true) {
/*     */       int i;
/*     */       
/* 127 */       if ((i = AL10.alGetSourcei(this.sourceID, 4118)) > 0 && (
/*     */         
/* 129 */         i = AL10.alSourceUnqueueBuffers(this.sourceID)) != 40963) {
/* 130 */         this.renderedSeconds += this.secondsPerBuffer;
/*     */         
/* 132 */         this.tempBuffer.clear();
/* 133 */         this.tempBuffer.put(paramArrayOfbyte, paramInt1, paramInt2).flip();
/* 134 */         AL10.alBufferData(i, this.format, this.tempBuffer, this.sampleRate);
/*     */         
/* 136 */         AL10.alSourceQueueBuffers(this.sourceID, i);
/*     */         
/*     */         break;
/*     */       } 
/*     */       try {
/* 141 */         Thread.sleep((long)(1000.0F * this.secondsPerBuffer));
/* 142 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 147 */     if (!this.isPlaying || AL10.alGetSourcei(this.sourceID, 4112) != 4114) {
/* 148 */       AL10.alSourcePlay(this.sourceID);
/* 149 */       this.isPlaying = true;
/*     */     } 
/*     */     
/* 152 */     return paramInt2;
/*     */   }
/*     */   
/*     */   public void stop() {
/* 156 */     if (this.sourceID == -1)
/* 157 */       return;  this.audio.freeSource(this.sourceID);
/* 158 */     this.sourceID = -1;
/* 159 */     this.renderedSeconds = 0.0F;
/* 160 */     this.isPlaying = false;
/*     */   }
/*     */   
/*     */   public boolean isPlaying() {
/* 164 */     if (this.sourceID == -1) return false; 
/* 165 */     return this.isPlaying;
/*     */   }
/*     */   
/*     */   public void setVolume(float paramFloat) {
/* 169 */     this.volume = paramFloat;
/* 170 */     if (this.sourceID != -1) AL10.alSourcef(this.sourceID, 4106, paramFloat); 
/*     */   }
/*     */   
/*     */   public float getPosition() {
/* 174 */     if (this.sourceID == -1) return 0.0F; 
/* 175 */     return this.renderedSeconds + AL10.alGetSourcef(this.sourceID, 4132);
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat) {
/* 179 */     this.renderedSeconds = paramFloat;
/*     */   }
/*     */   
/*     */   public int getChannels() {
/* 183 */     return (this.format == 4355) ? 2 : 1;
/*     */   }
/*     */   
/*     */   public int getRate() {
/* 187 */     return this.sampleRate;
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 191 */     if (this.buffers == null)
/* 192 */       return;  if (this.sourceID != -1) {
/* 193 */       this.audio.freeSource(this.sourceID);
/* 194 */       this.sourceID = -1;
/*     */     } 
/* 196 */     AL10.alDeleteBuffers(this.buffers);
/* 197 */     this.buffers = null;
/*     */   }
/*     */   
/*     */   public boolean isMono() {
/* 201 */     return (this.channels == 1);
/*     */   }
/*     */   
/*     */   public int getLatency() {
/* 205 */     return (int)(this.bufferSize / 2.0F / this.channels * this.bufferCount);
/*     */   }
/*     */   
/*     */   public void pause() {}
/*     */   
/*     */   public void resume() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\OpenALAudioDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */