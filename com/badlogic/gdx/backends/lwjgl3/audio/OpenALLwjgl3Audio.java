/*     */ package com.badlogic.gdx.backends.lwjgl3.audio;
/*     */ 
/*     */ import com.badlogic.gdx.audio.AudioDevice;
/*     */ import com.badlogic.gdx.audio.AudioRecorder;
/*     */ import com.badlogic.gdx.audio.Music;
/*     */ import com.badlogic.gdx.audio.Sound;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.LongMap;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.openal.AL;
/*     */ import org.lwjgl.openal.AL10;
/*     */ import org.lwjgl.openal.ALC;
/*     */ import org.lwjgl.openal.ALC10;
/*     */ import org.lwjgl.openal.ALCCapabilities;
/*     */ import org.lwjgl.openal.ALUtil;
/*     */ import org.lwjgl.openal.SOFTReopenDevice;
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
/*     */ 
/*     */ 
/*     */ public class OpenALLwjgl3Audio
/*     */   implements Lwjgl3Audio
/*     */ {
/*     */   private final int deviceBufferSize;
/*     */   private final int deviceBufferCount;
/*     */   private IntArray idleSources;
/*     */   private IntArray allSources;
/*     */   private LongMap<Integer> soundIdToSource;
/*     */   private IntMap<Long> sourceToSoundId;
/*  60 */   private long nextSoundId = 0L;
/*  61 */   private ObjectMap<String, Class<? extends OpenALSound>> extensionToSoundClass = new ObjectMap();
/*  62 */   private ObjectMap<String, Class<? extends OpenALMusic>> extensionToMusicClass = new ObjectMap();
/*     */   private OpenALSound[] recentSounds;
/*  64 */   private int mostRecetSound = -1;
/*  65 */   private String preferredOutputDevice = null;
/*     */   
/*     */   private Thread observerThread;
/*  68 */   Array<OpenALMusic> music = new Array(false, 1, OpenALMusic.class);
/*     */   long device;
/*     */   long context;
/*     */   boolean noDevice = false;
/*     */   
/*     */   public OpenALLwjgl3Audio() {
/*  74 */     this(16, 9, 512);
/*     */   }
/*     */   
/*     */   public OpenALLwjgl3Audio(int paramInt1, int paramInt2, int paramInt3) {
/*  78 */     this.deviceBufferSize = paramInt3;
/*  79 */     this.deviceBufferCount = paramInt2;
/*     */     
/*  81 */     registerSound("ogg", (Class)Ogg.Sound.class);
/*  82 */     registerMusic("ogg", (Class)Ogg.Music.class);
/*  83 */     registerSound("wav", (Class)Wav.Sound.class);
/*  84 */     registerMusic("wav", (Class)Wav.Music.class);
/*  85 */     registerSound("mp3", (Class)Mp3.Sound.class);
/*  86 */     registerMusic("mp3", (Class)Mp3.Music.class);
/*     */     
/*  88 */     this.device = ALC10.alcOpenDevice((ByteBuffer)null);
/*  89 */     if (this.device == 0L) {
/*  90 */       this.noDevice = true;
/*     */       return;
/*     */     } 
/*  93 */     ALCCapabilities aLCCapabilities = ALC.createCapabilities(this.device);
/*  94 */     this.context = ALC10.alcCreateContext(this.device, (IntBuffer)null);
/*  95 */     if (this.context == 0L) {
/*  96 */       ALC10.alcCloseDevice(this.device);
/*  97 */       this.noDevice = true;
/*     */       return;
/*     */     } 
/* 100 */     if (!ALC10.alcMakeContextCurrent(this.context)) {
/* 101 */       this.noDevice = true;
/*     */       return;
/*     */     } 
/* 104 */     AL.createCapabilities(aLCCapabilities);
/*     */     
/* 106 */     AL10.alGetError();
/* 107 */     this.allSources = new IntArray(false, paramInt1);
/* 108 */     for (byte b = 0; b < paramInt1; ) {
/* 109 */       paramInt3 = AL10.alGenSources();
/* 110 */       if (AL10.alGetError() == 0) {
/* 111 */         this.allSources.add(paramInt3); b++;
/*     */       } 
/* 113 */     }  this.idleSources = new IntArray(this.allSources);
/* 114 */     this.soundIdToSource = new LongMap();
/* 115 */     this.sourceToSoundId = new IntMap();
/*     */     
/*     */     FloatBuffer floatBuffer1;
/* 118 */     (floatBuffer1 = BufferUtils.createFloatBuffer(6).put(new float[] { 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 0.0F })).flip();
/* 119 */     AL10.alListenerfv(4111, floatBuffer1);
/*     */     FloatBuffer floatBuffer2;
/* 121 */     (floatBuffer2 = BufferUtils.createFloatBuffer(3).put(new float[] { 0.0F, 0.0F, 0.0F })).flip();
/* 122 */     AL10.alListenerfv(4102, floatBuffer2);
/*     */     
/* 124 */     (floatBuffer1 = BufferUtils.createFloatBuffer(3).put(new float[] { 0.0F, 0.0F, 0.0F })).flip();
/* 125 */     AL10.alListenerfv(4100, floatBuffer1);
/*     */     
/* 127 */     AL10.alDisable(6571);
/* 128 */     this.observerThread = new Thread(new Runnable()
/*     */         {
/* 130 */           private String[] lastAvailableDevices = new String[0];
/*     */ 
/*     */           
/*     */           public void run() {
/*     */             while (true) {
/*     */               boolean bool;
/* 136 */               if (!(bool = (ALC10.alcGetInteger(OpenALLwjgl3Audio.this.device, 787) != 0) ? true : false)) {
/*     */ 
/*     */                 
/* 139 */                 OpenALLwjgl3Audio.this.switchOutputDevice(null, false);
/*     */                 continue;
/*     */               } 
/* 142 */               if (OpenALLwjgl3Audio.this.preferredOutputDevice != null) {
/* 143 */                 if (Arrays.<String>asList(OpenALLwjgl3Audio.this.getAvailableOutputDevices()).contains(OpenALLwjgl3Audio.this.preferredOutputDevice)) {
/* 144 */                   if (!OpenALLwjgl3Audio.this.preferredOutputDevice.equals(ALC10.alcGetString(OpenALLwjgl3Audio.this.device, 4115)))
/*     */                   {
/* 146 */                     OpenALLwjgl3Audio.this.switchOutputDevice(OpenALLwjgl3Audio.this.preferredOutputDevice);
/*     */                   
/*     */                   }
/*     */                 }
/* 150 */                 else if (OpenALLwjgl3Audio.this.preferredOutputDevice.equals(ALC10.alcGetString(OpenALLwjgl3Audio.this.device, 4115))) {
/*     */                   
/* 152 */                   OpenALLwjgl3Audio.this.switchOutputDevice(null, false);
/*     */                 } 
/*     */               } else {
/*     */                 String[] arrayOfString;
/*     */ 
/*     */                 
/* 158 */                 if (!Arrays.equals((Object[])(arrayOfString = OpenALLwjgl3Audio.this.getAvailableOutputDevices()), (Object[])this.lastAvailableDevices)) {
/* 159 */                   OpenALLwjgl3Audio.this.switchOutputDevice(null);
/*     */                 }
/*     */                 
/* 162 */                 this.lastAvailableDevices = arrayOfString;
/*     */               } 
/*     */               try {
/* 165 */                 Thread.sleep(1000L);
/* 166 */               } catch (InterruptedException interruptedException) {
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/* 172 */     this.observerThread.setDaemon(true);
/* 173 */     this.observerThread.start();
/*     */     
/* 175 */     this.recentSounds = new OpenALSound[paramInt1];
/*     */   }
/*     */   
/*     */   public void registerSound(String paramString, Class<? extends OpenALSound> paramClass) {
/* 179 */     if (paramString == null) throw new IllegalArgumentException("extension cannot be null."); 
/* 180 */     if (paramClass == null) throw new IllegalArgumentException("soundClass cannot be null."); 
/* 181 */     this.extensionToSoundClass.put(paramString, paramClass);
/*     */   }
/*     */   
/*     */   public void registerMusic(String paramString, Class<? extends OpenALMusic> paramClass) {
/* 185 */     if (paramString == null) throw new IllegalArgumentException("extension cannot be null."); 
/* 186 */     if (paramClass == null) throw new IllegalArgumentException("musicClass cannot be null."); 
/* 187 */     this.extensionToMusicClass.put(paramString, paramClass);
/*     */   }
/*     */   
/*     */   public OpenALSound newSound(FileHandle paramFileHandle) {
/* 191 */     String str = paramFileHandle.extension().toLowerCase();
/* 192 */     return newSound(paramFileHandle, str);
/*     */   }
/*     */   
/*     */   public OpenALSound newSound(FileHandle paramFileHandle, String paramString) {
/* 196 */     if (paramFileHandle == null) throw new IllegalArgumentException("file cannot be null."); 
/*     */     Class<OpenALSound> clazz;
/* 198 */     if ((clazz = (Class)this.extensionToSoundClass.get(paramString)) == null) throw new GdxRuntimeException("Unknown file extension for sound: " + paramFileHandle);
/*     */     
/*     */     try {
/*     */       OpenALSound openALSound;
/* 202 */       if ((openALSound = clazz.getConstructor(new Class[] { OpenALLwjgl3Audio.class, FileHandle.class }).newInstance(new Object[] { this, paramFileHandle })).getType() != null && !openALSound.getType().equals(paramString)) {
/* 203 */         return newSound(paramFileHandle, openALSound.getType());
/*     */       }
/* 205 */       return openALSound;
/* 206 */     } catch (Exception exception) {
/* 207 */       throw new GdxRuntimeException("Error creating sound " + clazz.getName() + " for file: " + paramFileHandle, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public OpenALMusic newMusic(FileHandle paramFileHandle) {
/* 212 */     if (paramFileHandle == null) throw new IllegalArgumentException("file cannot be null."); 
/*     */     Class<OpenALMusic> clazz;
/* 214 */     if ((clazz = (Class)this.extensionToMusicClass.get(paramFileHandle.extension().toLowerCase())) == null) throw new GdxRuntimeException("Unknown file extension for music: " + paramFileHandle); 
/*     */     try {
/* 216 */       return clazz.getConstructor(new Class[] { OpenALLwjgl3Audio.class, FileHandle.class }).newInstance(new Object[] { this, paramFileHandle });
/* 217 */     } catch (Exception exception) {
/* 218 */       throw new GdxRuntimeException("Error creating music " + clazz.getName() + " for file: " + paramFileHandle, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean switchOutputDevice(String paramString) {
/* 224 */     return switchOutputDevice(paramString, true);
/*     */   }
/*     */   
/*     */   private boolean switchOutputDevice(String paramString, boolean paramBoolean) {
/* 228 */     if (paramBoolean) {
/* 229 */       this.preferredOutputDevice = paramString;
/*     */     }
/* 231 */     return SOFTReopenDevice.alcReopenDeviceSOFT(this.device, paramString, (IntBuffer)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getAvailableOutputDevices() {
/*     */     List list;
/* 237 */     if ((list = ALUtil.getStringList(0L, 4115)) == null) return new String[0]; 
/* 238 */     return (String[])list.toArray((Object[])new String[0]);
/*     */   }
/*     */   
/*     */   int obtainSource(boolean paramBoolean) {
/* 242 */     if (this.noDevice) return 0;  byte b; int i;
/* 243 */     for (b = 0, i = this.idleSources.size; b < i; b++) {
/*     */       int j;
/*     */       int k;
/* 246 */       if ((k = AL10.alGetSourcei(j = this.idleSources.get(b), 4112)) != 4114 && k != 4115) {
/*     */         Long long_;
/* 248 */         if ((long_ = (Long)this.sourceToSoundId.remove(j)) != null) this.soundIdToSource.remove(long_.longValue()); 
/* 249 */         if (paramBoolean) {
/* 250 */           this.idleSources.removeIndex(b);
/*     */         } else {
/* 252 */           long l = this.nextSoundId++;
/* 253 */           this.sourceToSoundId.put(j, Long.valueOf(l));
/* 254 */           this.soundIdToSource.put(l, Integer.valueOf(j));
/*     */         } 
/* 256 */         AL10.alSourceStop(j);
/* 257 */         AL10.alSourcei(j, 4105, 0);
/* 258 */         AL10.alSourcef(j, 4106, 1.0F);
/* 259 */         AL10.alSourcef(j, 4099, 1.0F);
/* 260 */         AL10.alSource3f(j, 4100, 0.0F, 0.0F, 1.0F);
/* 261 */         AL10.alSourcei(j, 4147, 2);
/* 262 */         return j;
/*     */       } 
/*     */     } 
/* 265 */     return -1;
/*     */   }
/*     */   
/*     */   void freeSource(int paramInt) {
/* 269 */     if (this.noDevice)
/* 270 */       return;  AL10.alSourceStop(paramInt);
/* 271 */     AL10.alSourcei(paramInt, 4105, 0);
/*     */     Long long_;
/* 273 */     if ((long_ = (Long)this.sourceToSoundId.remove(paramInt)) != null) this.soundIdToSource.remove(long_.longValue()); 
/* 274 */     this.idleSources.add(paramInt);
/*     */   }
/*     */   
/*     */   void freeBuffer(int paramInt) {
/* 278 */     if (this.noDevice)
/* 279 */       return;  byte b; int i; for (b = 0, i = this.idleSources.size; b < i; b++) {
/*     */       int j;
/* 281 */       if (AL10.alGetSourcei(j = this.idleSources.get(b), 4105) == paramInt) {
/*     */         Long long_;
/* 283 */         if ((long_ = (Long)this.sourceToSoundId.remove(j)) != null) this.soundIdToSource.remove(long_.longValue()); 
/* 284 */         AL10.alSourceStop(j);
/* 285 */         AL10.alSourcei(j, 4105, 0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void stopSourcesWithBuffer(int paramInt) {
/* 291 */     if (this.noDevice)
/* 292 */       return;  byte b; int i; for (b = 0, i = this.idleSources.size; b < i; b++) {
/*     */       int j;
/* 294 */       if (AL10.alGetSourcei(j = this.idleSources.get(b), 4105) == paramInt) {
/*     */         Long long_;
/* 296 */         if ((long_ = (Long)this.sourceToSoundId.remove(j)) != null) this.soundIdToSource.remove(long_.longValue()); 
/* 297 */         AL10.alSourceStop(j);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void pauseSourcesWithBuffer(int paramInt) {
/* 303 */     if (this.noDevice)
/* 304 */       return;  byte b; int i; for (b = 0, i = this.idleSources.size; b < i; b++) {
/*     */       int j;
/* 306 */       if (AL10.alGetSourcei(j = this.idleSources.get(b), 4105) == paramInt) AL10.alSourcePause(j); 
/*     */     } 
/*     */   }
/*     */   
/*     */   void resumeSourcesWithBuffer(int paramInt) {
/* 311 */     if (this.noDevice)
/* 312 */       return;  byte b; int i; for (b = 0, i = this.idleSources.size; b < i; b++) {
/*     */       int j;
/* 314 */       if (AL10.alGetSourcei(j = this.idleSources.get(b), 4105) == paramInt && 
/* 315 */         AL10.alGetSourcei(j, 4112) == 4115) AL10.alSourcePlay(j);
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 322 */     if (this.noDevice)
/* 323 */       return;  for (byte b = 0; b < this.music.size; b++)
/* 324 */       ((OpenALMusic[])this.music.items)[b].update(); 
/*     */   }
/*     */   
/*     */   public long getSoundId(int paramInt) {
/*     */     Long long_;
/* 329 */     return ((long_ = (Long)this.sourceToSoundId.get(paramInt)) != null) ? long_.longValue() : -1L;
/*     */   }
/*     */   
/*     */   public int getSourceId(long paramLong) {
/*     */     Integer integer;
/* 334 */     return ((integer = (Integer)this.soundIdToSource.get(paramLong)) != null) ? integer.intValue() : -1;
/*     */   }
/*     */   
/*     */   public void stopSound(long paramLong) {
/*     */     Integer integer;
/* 339 */     if ((integer = (Integer)this.soundIdToSource.get(paramLong)) != null) AL10.alSourceStop(integer.intValue()); 
/*     */   }
/*     */   
/*     */   public void pauseSound(long paramLong) {
/*     */     Integer integer;
/* 344 */     if ((integer = (Integer)this.soundIdToSource.get(paramLong)) != null) AL10.alSourcePause(integer.intValue()); 
/*     */   }
/*     */   
/*     */   public void resumeSound(long paramLong) {
/*     */     int i;
/* 349 */     if ((i = ((Integer)this.soundIdToSource.get(paramLong, Integer.valueOf(-1))).intValue()) != -1 && AL10.alGetSourcei(i, 4112) == 4115) AL10.alSourcePlay(i); 
/*     */   }
/*     */   
/*     */   public void setSoundGain(long paramLong, float paramFloat) {
/*     */     Integer integer;
/* 354 */     if ((integer = (Integer)this.soundIdToSource.get(paramLong)) != null) AL10.alSourcef(integer.intValue(), 4106, paramFloat); 
/*     */   }
/*     */   
/*     */   public void setSoundLooping(long paramLong, boolean paramBoolean) {
/*     */     Integer integer;
/* 359 */     if ((integer = (Integer)this.soundIdToSource.get(paramLong)) != null) AL10.alSourcei(integer.intValue(), 4103, paramBoolean ? 1 : 0); 
/*     */   }
/*     */   
/*     */   public void setSoundPitch(long paramLong, float paramFloat) {
/*     */     Integer integer;
/* 364 */     if ((integer = (Integer)this.soundIdToSource.get(paramLong)) != null) AL10.alSourcef(integer.intValue(), 4099, paramFloat); 
/*     */   }
/*     */   
/*     */   public void setSoundPan(long paramLong, float paramFloat1, float paramFloat2) {
/*     */     int i;
/* 369 */     if ((i = ((Integer)this.soundIdToSource.get(paramLong, Integer.valueOf(-1))).intValue()) != -1) {
/* 370 */       AL10.alSource3f(i, 4100, MathUtils.cos((paramFloat1 - 1.0F) * 1.5707964F), 0.0F, 
/* 371 */           MathUtils.sin((paramFloat1 + 1.0F) * 1.5707964F));
/* 372 */       AL10.alSourcef(i, 4106, paramFloat2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 377 */     if (this.noDevice)
/* 378 */       return;  this.observerThread.interrupt(); byte b; int i;
/* 379 */     for (b = 0, i = this.allSources.size; b < i; b++) {
/*     */       int j;
/*     */       int k;
/* 382 */       if ((k = AL10.alGetSourcei(j = this.allSources.get(b), 4112)) != 4116) AL10.alSourceStop(j); 
/* 383 */       AL10.alDeleteSources(j);
/*     */     } 
/*     */     
/* 386 */     this.sourceToSoundId = null;
/* 387 */     this.soundIdToSource = null;
/*     */     
/* 389 */     ALC10.alcDestroyContext(this.context);
/* 390 */     ALC10.alcCloseDevice(this.device);
/*     */   }
/*     */   
/*     */   public AudioDevice newAudioDevice(int paramInt, final boolean isMono) {
/* 394 */     if (this.noDevice) return new AudioDevice()
/*     */         {
/*     */           public void writeSamples(float[] param1ArrayOffloat, int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public void writeSamples(short[] param1ArrayOfshort, int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public void setVolume(float param1Float) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isMono() {
/* 409 */             return isMono;
/*     */           }
/*     */ 
/*     */           
/*     */           public int getLatency() {
/* 414 */             return 0;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void dispose() {}
/*     */ 
/*     */ 
/*     */           
/*     */           public void pause() {}
/*     */ 
/*     */           
/*     */           public void resume() {}
/*     */         };
/*     */     
/* 429 */     return new OpenALAudioDevice(this, paramInt, isMono, this.deviceBufferSize, this.deviceBufferCount);
/*     */   }
/*     */   
/*     */   public AudioRecorder newAudioRecorder(int paramInt, boolean paramBoolean) {
/* 433 */     if (this.noDevice) return new AudioRecorder()
/*     */         {
/*     */           public void read(short[] param1ArrayOfshort, int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public void dispose() {}
/*     */         };
/*     */     
/* 442 */     return new JavaSoundAudioRecorder(paramInt, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void retain(OpenALSound paramOpenALSound, boolean paramBoolean) {
/* 449 */     this.mostRecetSound++;
/* 450 */     this.mostRecetSound %= this.recentSounds.length;
/*     */     
/* 452 */     if (paramBoolean)
/*     */     {
/* 454 */       if (this.recentSounds[this.mostRecetSound] != null) this.recentSounds[this.mostRecetSound].stop();
/*     */     
/*     */     }
/* 457 */     this.recentSounds[this.mostRecetSound] = paramOpenALSound;
/*     */   }
/*     */ 
/*     */   
/*     */   public void forget(OpenALSound paramOpenALSound) {
/* 462 */     for (byte b = 0; b < this.recentSounds.length; b++) {
/* 463 */       if (this.recentSounds[b] == paramOpenALSound) this.recentSounds[b] = null; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\audio\OpenALLwjgl3Audio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */