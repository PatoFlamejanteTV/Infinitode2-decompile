/*     */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*     */ 
/*     */ import com.badlogic.gdx.audio.Music;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.FloatArray;
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
/*     */ 
/*     */ public abstract class OpenALMusic
/*     */   implements Music
/*     */ {
/*     */   private static final int bufferSize = 40960;
/*     */   private static final int bufferCount = 3;
/*  38 */   private static final byte[] tempBytes = new byte[40960];
/*  39 */   private static final ByteBuffer tempBuffer = BufferUtils.createByteBuffer(40960);
/*     */   
/*  41 */   private FloatArray renderedSecondsQueue = new FloatArray(3);
/*     */   
/*     */   private final OpenALLwjgl3Audio audio;
/*     */   private IntBuffer buffers;
/*  45 */   private int sourceID = -1;
/*     */   private int format;
/*     */   private int sampleRate;
/*  48 */   private float volume = 1.0F; private boolean isLooping; private boolean isPlaying;
/*  49 */   private float pan = 0.0F;
/*     */   
/*     */   private float renderedSeconds;
/*     */   private float maxSecondsPerBuffer;
/*     */   protected final FileHandle file;
/*     */   private Music.OnCompletionListener onCompletionListener;
/*     */   
/*     */   public OpenALMusic(OpenALLwjgl3Audio paramOpenALLwjgl3Audio, FileHandle paramFileHandle) {
/*  57 */     this.audio = paramOpenALLwjgl3Audio;
/*  58 */     this.file = paramFileHandle;
/*  59 */     this.onCompletionListener = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setup(int paramInt1, int paramInt2, int paramInt3) {
/*  67 */     this.format = OpenALUtils.determineFormat(paramInt1, paramInt2);
/*  68 */     this.sampleRate = paramInt3;
/*  69 */     this.maxSecondsPerBuffer = 40960.0F / ((paramInt2 >> 3) * paramInt1 * paramInt3);
/*     */   }
/*     */   
/*     */   public void play() {
/*  73 */     if (this.audio.noDevice)
/*  74 */       return;  if (this.sourceID == -1) {
/*  75 */       this.sourceID = this.audio.obtainSource(true);
/*  76 */       if (this.sourceID == -1)
/*     */         return; 
/*  78 */       this.audio.music.add(this);
/*     */ 
/*     */       
/*  81 */       this.buffers = BufferUtils.createIntBuffer(3);
/*  82 */       AL10.alGetError();
/*  83 */       AL10.alGenBuffers(this.buffers);
/*     */       int i;
/*  85 */       if (this.buffers == null && (i = AL10.alGetError()) != 0) {
/*  86 */         throw new GdxRuntimeException("Unable to allocate audio buffers. AL Error: " + i);
/*     */       }
/*     */       
/*  89 */       AL10.alSourcei(this.sourceID, 4103, 0);
/*  90 */       setPan(this.pan, this.volume);
/*     */       
/*  92 */       AL10.alGetError();
/*     */       
/*  94 */       i = 0;
/*  95 */       for (byte b = 0; b < 3; ) {
/*  96 */         int j = this.buffers.get(b);
/*  97 */         if (fill(j)) {
/*  98 */           i = 1;
/*  99 */           AL10.alSourceQueueBuffers(this.sourceID, j); b++;
/*     */         } 
/* 101 */       }  if (i == 0 && this.onCompletionListener != null) this.onCompletionListener.onCompletion(this);
/*     */       
/* 103 */       if (AL10.alGetError() != 0) {
/* 104 */         stop();
/*     */         return;
/*     */       } 
/*     */     } 
/* 108 */     if (!this.isPlaying) {
/* 109 */       AL10.alSourcePlay(this.sourceID);
/* 110 */       this.isPlaying = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stop() {
/* 115 */     if (this.audio.noDevice)
/* 116 */       return;  if (this.sourceID == -1)
/* 117 */       return;  this.audio.music.removeValue(this, true);
/* 118 */     reset();
/* 119 */     this.audio.freeSource(this.sourceID);
/* 120 */     this.sourceID = -1;
/* 121 */     this.renderedSeconds = 0.0F;
/* 122 */     this.renderedSecondsQueue.clear();
/* 123 */     this.isPlaying = false;
/*     */   }
/*     */   
/*     */   public void pause() {
/* 127 */     if (this.audio.noDevice)
/* 128 */       return;  if (this.sourceID != -1) AL10.alSourcePause(this.sourceID); 
/* 129 */     this.isPlaying = false;
/*     */   }
/*     */   
/*     */   public boolean isPlaying() {
/* 133 */     if (this.audio.noDevice) return false; 
/* 134 */     if (this.sourceID == -1) return false; 
/* 135 */     return this.isPlaying;
/*     */   }
/*     */   
/*     */   public void setLooping(boolean paramBoolean) {
/* 139 */     this.isLooping = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isLooping() {
/* 143 */     return this.isLooping;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVolume(float paramFloat) {
/* 148 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("volume cannot be < 0: " + paramFloat); 
/* 149 */     this.volume = paramFloat;
/* 150 */     if (this.audio.noDevice)
/* 151 */       return;  if (this.sourceID != -1) AL10.alSourcef(this.sourceID, 4106, paramFloat); 
/*     */   }
/*     */   
/*     */   public float getVolume() {
/* 155 */     return this.volume;
/*     */   }
/*     */   
/*     */   public void setPan(float paramFloat1, float paramFloat2) {
/* 159 */     this.volume = paramFloat2;
/* 160 */     this.pan = paramFloat1;
/* 161 */     if (this.audio.noDevice)
/* 162 */       return;  if (this.sourceID == -1)
/* 163 */       return;  AL10.alSource3f(this.sourceID, 4100, MathUtils.cos((paramFloat1 - 1.0F) * 1.5707964F), 0.0F, 
/* 164 */         MathUtils.sin((paramFloat1 + 1.0F) * 1.5707964F));
/* 165 */     AL10.alSourcef(this.sourceID, 4106, paramFloat2);
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat) {
/* 169 */     if (this.audio.noDevice)
/* 170 */       return;  if (this.sourceID == -1)
/* 171 */       return;  boolean bool = this.isPlaying;
/* 172 */     this.isPlaying = false;
/* 173 */     AL10.alSourceStop(this.sourceID);
/* 174 */     AL10.alSourceUnqueueBuffers(this.sourceID, this.buffers);
/* 175 */     while (this.renderedSecondsQueue.size > 0) {
/* 176 */       this.renderedSeconds = this.renderedSecondsQueue.pop();
/*     */     }
/* 178 */     if (paramFloat <= this.renderedSeconds) {
/* 179 */       reset();
/* 180 */       this.renderedSeconds = 0.0F;
/*     */     }  int i;
/* 182 */     while (this.renderedSeconds < paramFloat - this.maxSecondsPerBuffer && (
/*     */       
/* 184 */       i = read(tempBytes)) > 0) {
/* 185 */       float f = this.maxSecondsPerBuffer * i / 40960.0F;
/* 186 */       this.renderedSeconds += f;
/*     */     } 
/* 188 */     this.renderedSecondsQueue.add(this.renderedSeconds);
/* 189 */     i = 0;
/* 190 */     for (byte b = 0; b < 3; ) {
/* 191 */       int j = this.buffers.get(b);
/* 192 */       if (fill(j)) {
/* 193 */         i = 1;
/* 194 */         AL10.alSourceQueueBuffers(this.sourceID, j); b++;
/*     */       } 
/* 196 */     }  this.renderedSecondsQueue.pop();
/* 197 */     if (i == 0) {
/* 198 */       stop();
/* 199 */       if (this.onCompletionListener != null) this.onCompletionListener.onCompletion(this); 
/*     */     } 
/* 201 */     AL10.alSourcef(this.sourceID, 4132, paramFloat - this.renderedSeconds);
/* 202 */     if (bool) {
/* 203 */       AL10.alSourcePlay(this.sourceID);
/* 204 */       this.isPlaying = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPosition() {
/* 209 */     if (this.audio.noDevice) return 0.0F; 
/* 210 */     if (this.sourceID == -1) return 0.0F; 
/* 211 */     return this.renderedSeconds + AL10.alGetSourcef(this.sourceID, 4132);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int read(byte[] paramArrayOfbyte);
/*     */ 
/*     */   
/*     */   public abstract void reset();
/*     */ 
/*     */   
/*     */   protected void loop() {
/* 223 */     reset();
/*     */   }
/*     */   
/*     */   public int getChannels() {
/* 227 */     return (this.format == 4355) ? 2 : 1;
/*     */   }
/*     */   
/*     */   public int getRate() {
/* 231 */     return this.sampleRate;
/*     */   }
/*     */   
/*     */   public void update() {
/* 235 */     if (this.audio.noDevice)
/* 236 */       return;  if (this.sourceID == -1)
/*     */       return; 
/* 238 */     boolean bool = false;
/* 239 */     int i = AL10.alGetSourcei(this.sourceID, 4118); int j;
/* 240 */     while (i-- > 0 && (
/*     */       
/* 242 */       j = AL10.alSourceUnqueueBuffers(this.sourceID)) != 40963) {
/* 243 */       if (this.renderedSecondsQueue.size > 0) this.renderedSeconds = this.renderedSecondsQueue.pop(); 
/* 244 */       if (!bool) {
/* 245 */         if (fill(j)) {
/* 246 */           AL10.alSourceQueueBuffers(this.sourceID, j); continue;
/*     */         } 
/* 248 */         bool = true;
/*     */       } 
/* 250 */     }  if (bool && AL10.alGetSourcei(this.sourceID, 4117) == 0) {
/* 251 */       stop();
/* 252 */       if (this.onCompletionListener != null) this.onCompletionListener.onCompletion(this);
/*     */     
/*     */     } 
/*     */     
/* 256 */     if (this.isPlaying && AL10.alGetSourcei(this.sourceID, 4112) != 4114) AL10.alSourcePlay(this.sourceID); 
/*     */   }
/*     */   
/*     */   private boolean fill(int paramInt) {
/* 260 */     tempBuffer.clear();
/*     */     int i;
/* 262 */     if ((i = read(tempBytes)) <= 0)
/* 263 */       if (this.isLooping) {
/* 264 */         loop();
/*     */         
/* 266 */         if ((i = read(tempBytes)) <= 0) return false; 
/* 267 */         if (this.renderedSecondsQueue.size > 0) {
/* 268 */           this.renderedSecondsQueue.set(0, 0.0F);
/*     */         }
/*     */       } else {
/* 271 */         return false;
/*     */       }  
/* 273 */     float f1 = (this.renderedSecondsQueue.size > 0) ? this.renderedSecondsQueue.first() : 0.0F;
/* 274 */     float f2 = this.maxSecondsPerBuffer * i / 40960.0F;
/* 275 */     this.renderedSecondsQueue.insert(0, f1 + f2);
/*     */     
/* 277 */     tempBuffer.put(tempBytes, 0, i).flip();
/* 278 */     AL10.alBufferData(paramInt, this.format, tempBuffer, this.sampleRate);
/* 279 */     return true;
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 283 */     stop();
/* 284 */     if (this.audio.noDevice)
/* 285 */       return;  if (this.buffers == null)
/* 286 */       return;  AL10.alDeleteBuffers(this.buffers);
/* 287 */     this.buffers = null;
/* 288 */     this.onCompletionListener = null;
/*     */   }
/*     */   
/*     */   public void setOnCompletionListener(Music.OnCompletionListener paramOnCompletionListener) {
/* 292 */     this.onCompletionListener = paramOnCompletionListener;
/*     */   }
/*     */   
/*     */   public int getSourceId() {
/* 296 */     return this.sourceID;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\OpenALMusic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */