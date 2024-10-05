/*     */ package com.prineside.tdi2.managers.music;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.LifecycleListener;
/*     */ import com.badlogic.gdx.audio.AudioDevice;
/*     */ import com.badlogic.gdx.audio.analysis.FFT;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.badlogic.gdx.utils.Timer;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.ibxm.IBXM;
/*     */ import com.prineside.tdi2.ibxm.Module;
/*     */ import com.prineside.tdi2.managers.MusicManager;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(serializer = MusicManager.Serializer.class)
/*     */ public final class LiveMusicManager
/*     */   extends MusicManager
/*     */ {
/*  32 */   private static final TLog e = TLog.forClass(LiveMusicManager.class);
/*     */   
/*  34 */   public enum SynthesizerStatus { NOT_ACTIVE,
/*  35 */     SLEEP_APP_INACTIVE,
/*  36 */     SLEEP_NOT_PLAYING,
/*  37 */     SLEEP_NO_IBXM,
/*  38 */     SLEEP_NO_FREE_BUFFER,
/*  39 */     SLEEP_NO_AUDIO_DATA,
/*  40 */     RESTART_PLAYBACK,
/*  41 */     ACTIVE; }
/*     */   
/*     */   public enum PlaybackStatus {
/*  44 */     STARTING,
/*  45 */     ACTIVE,
/*  46 */     STOPPED,
/*  47 */     SLEEP_NO_BUFFER,
/*  48 */     SLEEP_NO_AUDIO_DEVICE,
/*  49 */     SLEEP_APP_INACTIVE,
/*  50 */     SLEEP_NOT_PLAYING;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   private final Array<PcmBuffer> f = new Array(true, 3, PcmBuffer.class);
/*  57 */   private final PcmBuffer[] g = new PcmBuffer[3];
/*     */   
/*  59 */   private SynthesizerStatus h = SynthesizerStatus.NOT_ACTIVE;
/*  60 */   private PlaybackStatus i = PlaybackStatus.STARTING;
/*     */ 
/*     */   
/*  63 */   private final Array<SpectrumGenerator> j = new Array(true, 1, SpectrumGenerator.class);
/*     */   
/*     */   private boolean k;
/*     */   
/*     */   private AudioDevice l;
/*     */   private boolean m;
/*     */   public IBXM ibxm;
/*     */   private boolean n;
/*     */   private boolean o;
/*  72 */   private int[] p = new int[1];
/*     */   
/*  74 */   private long q = -1L;
/*     */   
/*     */   private Thread r;
/*     */   private Thread s;
/*     */   
/*     */   public LiveMusicManager() {
/*  80 */     if (Config.isHeadless())
/*     */       return; 
/*  82 */     e.i("initializing", new Object[0]);
/*     */     
/*  84 */     for (byte b = 0; b < 3; b++) {
/*  85 */       this.g[b] = new PcmBuffer();
/*     */     }
/*     */     
/*  88 */     this.r = new Thread(() -> {
/*     */           try {
/*     */             while (true) {
/*     */               null = null;
/*     */               
/*     */               if (!this.o || !this.n) {
/*     */                 if (!this.n) {
/*     */                   this.h = SynthesizerStatus.SLEEP_APP_INACTIVE;
/*     */                 } else {
/*     */                   this.h = SynthesizerStatus.SLEEP_NOT_PLAYING;
/*     */                 } 
/*     */                 
/*     */                 Thread.sleep(200L);
/*     */                 
/*     */                 continue;
/*     */               } 
/*     */               
/*     */               IBXM iBXM;
/*     */               
/*     */               if ((iBXM = this.ibxm) == null) {
/*     */                 this.h = SynthesizerStatus.SLEEP_NO_IBXM;
/*     */                 
/*     */                 Thread.sleep(100L);
/*     */                 
/*     */                 continue;
/*     */               } 
/*     */               
/*     */               while (null == null) {
/*     */                 for (byte b = 0; b < this.g.length; b++) {
/*     */                   if (this.g[b] != null) {
/*     */                     null = this.g[b];
/*     */                     
/*     */                     this.g[b] = null;
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */                 
/*     */                 if (null == null) {
/*     */                   if (this.n && this.o) {
/*     */                     this.h = SynthesizerStatus.SLEEP_NO_FREE_BUFFER;
/*     */                     
/*     */                     Thread.sleep(50L);
/*     */                     
/*     */                     continue;
/*     */                   } 
/*     */                   
/*     */                   if (!this.n) {
/*     */                     this.h = SynthesizerStatus.SLEEP_APP_INACTIVE;
/*     */                   } else {
/*     */                     this.h = SynthesizerStatus.SLEEP_NOT_PLAYING;
/*     */                   } 
/*     */                   
/*     */                   Thread.sleep(200L);
/*     */                 } 
/*     */               } 
/*     */               
/*     */               null.a(this.p.length << 1 << 1);
/*     */               byte b1 = 0;
/*     */               byte b2;
/*     */               for (b2 = 0; b2 < 2; b2++) {
/*     */                 int i = iBXM.getAudio(this.p);
/*     */                 byte b = 0;
/*     */                 i <<= 1;
/*     */                 while (b < i) {
/*     */                   int j;
/*     */                   if ((j = this.p[b]) > 32767) {
/*     */                     j = 32767;
/*     */                   }
/*     */                   if (j < -32768) {
/*     */                     j = -32768;
/*     */                   }
/*     */                   null.data[b1++] = (short)j;
/*     */                   b++;
/*     */                 } 
/*     */                 if ((iBXM.getModule()).restartPos != 0 && iBXM.getSequencePos() < iBXM.lastSeqPos) {
/*     */                   iBXM.setSequencePosApplyEffects((iBXM.getModule()).restartPos);
/*     */                 }
/*     */                 iBXM.lastSeqPos = iBXM.getSequencePos();
/*     */               } 
/*     */               null.length = b1;
/*     */               Arrays.fill(null.data, b1, MathUtils.nextPowerOfTwo(null.length - 1) - 1, (short)0);
/*     */               if (b1 == 0) {
/*     */                 this.h = SynthesizerStatus.SLEEP_NO_AUDIO_DATA;
/*     */                 b2 = 0;
/*     */                 synchronized (this.g) {
/*     */                   for (byte b = 0; b < this.g.length; b++) {
/*     */                     if (this.g[b] == null) {
/*     */                       this.g[b] = null;
/*     */                       b2 = 1;
/*     */                       break;
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */                 if (b2 == 0) {
/*     */                   e.e("buffer not freed - no space", new Object[0]);
/*     */                 }
/*     */                 Thread.sleep(5L);
/*     */                 continue;
/*     */               } 
/*     */               synchronized (this.f) {
/*     */                 this.f.add(null);
/*     */               } 
/*     */               this.h = SynthesizerStatus.ACTIVE;
/*     */             } 
/* 193 */           } catch (InterruptedException interruptedException) {
/*     */             e.i("synthesizer stopped: " + interruptedException.getMessage(), new Object[0]); return;
/* 195 */           } catch (Exception exception) {
/*     */             throw new RuntimeException(exception);
/*     */           } 
/*     */         }"IBXM synthesizer");
/* 199 */     this.r.setDaemon(true);
/*     */     
/* 201 */     CrashHandler.handleThreadExceptionsForgiving(this.r);
/* 202 */     this.r.start();
/* 203 */     b();
/*     */ 
/*     */ 
/*     */     
/* 207 */     Gdx.app.addLifecycleListener(new LifecycleListener(this)
/*     */         {
/*     */           public void pause() {
/* 210 */             LiveMusicManager.a(this.a, false);
/*     */           }
/*     */ 
/*     */           
/*     */           public void resume() {
/* 215 */             LiveMusicManager.a(this.a, true);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void dispose() {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void simulateSpectrums() {
/* 233 */     if (getMainVolume() <= 0.0F)
/*     */     {
/* 235 */       super.simulateSpectrums();
/*     */     }
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SynthesizerStatus getSynthesizerStatus() {
/* 291 */     return this.h;
/*     */   }
/*     */   
/*     */   public final PlaybackStatus getPlaybackStatus() {
/* 295 */     return this.i;
/*     */   }
/*     */   
/*     */   private void a(PcmBuffer paramPcmBuffer) {
/* 299 */     int i = this.d.size;
/* 300 */     int j = this.j.size;
/*     */     
/* 302 */     if (i > j) {
/* 303 */       synchronized (this.j) {
/* 304 */         for (j = j; j < i; j++) {
/* 305 */           e.i("creating new spectrum generator " + ((MusicManager.SpectrumConfig[])this.d.items)[j], new Object[0]);
/* 306 */           this.j.add(new SpectrumGenerator(((MusicManager.SpectrumConfig[])this.d.items)[j], (byte)0));
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 311 */     for (byte b = 0; b < j; b++) {
/* 312 */       SpectrumGenerator.a(((SpectrumGenerator[])this.j.items)[b], paramPcmBuffer, getSampleRate());
/*     */     }
/*     */   }
/*     */   
/*     */   private void b() {
/* 317 */     this.k = false;
/*     */     
/* 319 */     e.i("restartPlaybackThread", new Object[0]);
/* 320 */     if (this.s != null) {
/* 321 */       this.s.interrupt();
/* 322 */       e.i("restartPlaybackThread - playbackThread interrupted", new Object[0]);
/*     */     } 
/*     */     
/* 325 */     c();
/*     */     
/* 327 */     this.s = new Thread(() -> {
/*     */           this.i = PlaybackStatus.STARTING;
/*     */           
/*     */           int i = hashCode() % 1000;
/*     */           
/*     */           e.i("started playback thread " + i, new Object[0]);
/*     */           
/*     */           try {
/*     */             while (true) {
/*     */               boolean bool1 = false;
/*     */               
/*     */               PcmBuffer pcmBuffer = null;
/*     */               
/*     */               while (pcmBuffer == null) {
/*     */                 if (this.f.size != 0) {
/*     */                   synchronized (this.f) {
/*     */                     pcmBuffer = (PcmBuffer)this.f.removeIndex(0);
/*     */                   } 
/*     */                 }
/*     */                 
/*     */                 if (pcmBuffer == null) {
/*     */                   this.i = PlaybackStatus.SLEEP_NO_BUFFER;
/*     */                   
/*     */                   Thread.sleep(20L);
/*     */                 } 
/*     */               } 
/*     */               
/*     */               AudioDevice audioDevice = this.l;
/*     */               if (this.o && this.n && audioDevice != null && this.m) {
/*     */                 this.i = PlaybackStatus.ACTIVE;
/*     */                 try {
/*     */                   this.q = Game.getTimestampMillis();
/*     */                   audioDevice.writeSamples(pcmBuffer.data, 0, pcmBuffer.length);
/*     */                   this.lastSoundTimestamp = Game.getTimestampMillis();
/*     */                   if (this.q == -2L) {
/*     */                     e.e("playback thread " + i + " stops because someone has requested that due to large writeSamples delay", new Object[0]);
/*     */                     bool1 = true;
/*     */                     this.k = true;
/*     */                   } 
/*     */                   this.q = -1L;
/* 367 */                 } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*     */                   e.e("writeSamples failed - UnsatisfiedLinkError " + i, new Object[] { unsatisfiedLinkError });
/*     */                   
/*     */                   bool1 = true;
/*     */                   this.k = true;
/* 372 */                 } catch (GdxRuntimeException gdxRuntimeException) {
/*     */                   e.e("writeSamples failed - GdxRuntimeException " + i, new Object[] { gdxRuntimeException });
/*     */                   
/*     */                   bool1 = true;
/*     */                   
/*     */                   this.k = true;
/*     */                 } 
/*     */               } else {
/*     */                 if (audioDevice == null || !this.m) {
/*     */                   this.i = PlaybackStatus.SLEEP_NO_AUDIO_DEVICE;
/*     */                 } else if (!this.n) {
/*     */                   this.i = PlaybackStatus.SLEEP_APP_INACTIVE;
/*     */                 } else {
/*     */                   this.i = PlaybackStatus.SLEEP_NOT_PLAYING;
/*     */                 } 
/*     */                 
/*     */                 Thread.sleep(50L);
/*     */               } 
/*     */               
/*     */               a(pcmBuffer);
/*     */               boolean bool2 = false;
/*     */               synchronized (this.g) {
/*     */                 for (byte b = 0; b < this.g.length; b++) {
/*     */                   if (this.g[b] == null) {
/*     */                     this.g[b] = pcmBuffer;
/*     */                     bool2 = true;
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */               if (!bool2) {
/*     */                 e.e("buffer not freed after playback - no space", new Object[0]);
/*     */               }
/*     */               if (!bool1) {
/*     */                 continue;
/*     */               }
/*     */               break;
/*     */             } 
/* 410 */           } catch (InterruptedException interruptedException) {
/*     */           
/* 412 */           } catch (Exception exception) {
/*     */             e.i("exception in playback thread " + i, new Object[] { exception });
/*     */           } 
/*     */           
/*     */           e.i("stopped playback thread " + i, new Object[0]);
/*     */           this.i = PlaybackStatus.STOPPED;
/*     */         }"IBXM playback");
/* 419 */     this.s.setDaemon(true);
/* 420 */     CrashHandler.handleThreadExceptionsForgiving(this.s);
/* 421 */     this.s.start();
/*     */   }
/*     */   
/*     */   public final int getSampleRate() {
/* 425 */     return 44100;
/*     */   }
/*     */   
/*     */   private void c() {
/* 429 */     if (this.l != null) {
/* 430 */       if (this.l instanceof RestartableAudioDevice) {
/* 431 */         e.i("restarting old audioDevice", new Object[0]);
/* 432 */         ((RestartableAudioDevice)this.l).restart();
/* 433 */         e.i("old audioDevice restarted", new Object[0]);
/*     */       } else {
/* 435 */         e.i("disposing old audioDevice", new Object[0]);
/* 436 */         this.m = false;
/* 437 */         this.l.dispose();
/* 438 */         this.l = null;
/* 439 */         e.i("old audioDevice disposed", new Object[0]);
/*     */       } 
/*     */     }
/*     */     
/* 443 */     if (this.ibxm != null) this.ibxm.setSampleRate(getSampleRate());
/*     */     
/* 445 */     if (this.l != null)
/*     */       return; 
/*     */     try {
/* 448 */       e.i("creating new audio device...", new Object[0]);
/* 449 */       this.l = Game.i.actionResolver.newAudioDevice(getSampleRate(), false);
/* 450 */       this.m = true;
/* 451 */       e.i("set up new audio device", new Object[0]); return;
/* 452 */     } catch (Exception exception) {
/* 453 */       e.e("failed to setup audio device", new Object[] { exception });
/* 454 */       Timer.schedule(new Timer.Task(this)
/*     */           {
/*     */             public void run() {
/* 457 */               Threads.i().runOnMainThread(() -> {
/*     */                     if (Game.isLoaded()) {
/*     */                       Notifications.i().add("Failed to setup audio device", null, MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */                     }
/*     */                   });
/*     */             }
/*     */           }5.0F);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setBackendVolume(float paramFloat) {
/* 472 */     if (this.l != null) {
/* 473 */       if (Game.i != null && Game.i.debugManager != null && Game.i.debugManager.isEnabled()) {
/* 474 */         Game.i.debugManager.registerValue("Music backend vol").append(paramFloat);
/*     */       }
/* 476 */       this.l.setVolume(paramFloat);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 482 */     this.c = true;
/* 483 */     this.n = true;
/*     */     
/* 485 */     super.setup();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void preRender(float paramFloat) {
/* 491 */     super.preRender(paramFloat);
/*     */     
/* 493 */     if (this.k) {
/* 494 */       b();
/*     */     }
/*     */     
/* 497 */     if (this.c) {
/*     */       StringBuilder stringBuilder;
/*     */ 
/*     */ 
/*     */       
/* 502 */       if ((stringBuilder = Game.i.debugManager.registerValue("XM music playback queue")) != null) {
/* 503 */         stringBuilder.append(d());
/* 504 */         Game.i.debugManager.registerValue("XM music free buffers").append(e());
/* 505 */         Game.i.debugManager.registerValue("XM synthesizer").append(this.h.name());
/* 506 */         Game.i.debugManager.registerValue("XM playback").append(this.i.name());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private int d() {
/* 512 */     return this.f.size;
/*     */   }
/*     */   
/*     */   private int e() {
/* 516 */     byte b1 = 0; PcmBuffer[] arrayOfPcmBuffer; int i; byte b2;
/* 517 */     for (i = (arrayOfPcmBuffer = this.g).length, b2 = 0; b2 < i; b2++) {
/* 518 */       PcmBuffer pcmBuffer; if ((pcmBuffer = arrayOfPcmBuffer[b2]) != null) b1++; 
/*     */     } 
/* 520 */     return b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void stopMusic() {
/* 525 */     a(false);
/* 526 */     this.ibxm = null;
/*     */     
/* 528 */     Threads.i().runOnMainThread(() -> {
/*     */           synchronized (this.j) {
/*     */             for (byte b = 0; b < this.j.size; b++) {
/*     */               SpectrumGenerator.a((SpectrumGenerator)this.j.get(b)).zeroSpectrums();
/*     */             }
/*     */             return;
/*     */           } 
/*     */         });
/*     */   }
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
/*     */   public final void playMusic(Module paramModule) {
/* 549 */     if (paramModule == null) throw new IllegalArgumentException("Module is null");
/*     */     
/* 551 */     stopMusic();
/*     */     
/* 553 */     this.ibxm = new IBXM(paramModule, getSampleRate());
/* 554 */     this.ibxm.setInterpolation(getInterpolation());
/*     */     
/* 556 */     int i = this.ibxm.getMixBufferLength();
/* 557 */     if (this.p.length < i) {
/* 558 */       this.p = new int[i];
/*     */     }
/*     */     
/* 561 */     this.b = paramModule.getVolumeMultiplierFromInstrumentNames();
/*     */ 
/*     */     
/* 564 */     a(true);
/*     */     
/* 566 */     synchronized (this.j) {
/* 567 */       for (i = 0; i < this.j.size; i++) {
/* 568 */         SpectrumGenerator.a((SpectrumGenerator)this.j.get(i), 10.0F);
/*     */       }
/*     */     } 
/*     */     
/* 572 */     showSongNotification(this.ibxm.getModule(), 7.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Module getPlayingMusic() {
/* 577 */     if (this.ibxm == null) {
/* 578 */       return null;
/*     */     }
/*     */     
/* 581 */     return this.ibxm.getModule();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 585 */     this.o = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/*     */     try {
/* 593 */       this.s.interrupt();
/* 594 */     } catch (Exception exception) {}
/*     */     
/*     */     try {
/* 597 */       this.r.interrupt(); return;
/* 598 */     } catch (Exception exception) {
/*     */       return;
/*     */     } 
/*     */   }
/* 602 */   public static final class PcmBuffer { public short[] data = new short[4096];
/*     */     public int length;
/*     */     
/*     */     final void a(int param1Int) {
/* 606 */       if (this.data.length < param1Int) {
/* 607 */         this.data = new short[MathUtils.nextPowerOfTwo(param1Int)];
/*     */       }
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class SpectrumGenerator
/*     */   {
/*     */     private final MusicManager.SpectrumConfig a;
/*     */     
/*     */     private FFT b;
/*     */     
/*     */     private float[] c;
/*     */     private final float[] d;
/* 621 */     private float e = 10.0F;
/*     */     
/*     */     private float f;
/*     */     
/*     */     private SpectrumGenerator(MusicManager.SpectrumConfig param1SpectrumConfig) {
/* 626 */       this.a = param1SpectrumConfig;
/* 627 */       this.d = new float[param1SpectrumConfig.getSpectrumSize()];
/*     */     }
/*     */     
/*     */     private void a(LiveMusicManager.PcmBuffer param1PcmBuffer, int param1Int) {
/* 631 */       int i = MathUtils.nextPowerOfTwo(param1PcmBuffer.length - 1) / 2;
/* 632 */       if (this.b == null || this.b.getTimeSize() != i || this.f != this.a.fixedMaxValue) {
/* 633 */         this.b = new FFT(i, param1Int);
/*     */         
/* 635 */         this.c = new float[i];
/* 636 */         this.f = this.a.fixedMaxValue;
/*     */       } 
/*     */       
/* 639 */       for (param1Int = 0; param1Int < 2; param1Int++) {
/* 640 */         for (byte b1 = 3; b1 < i; b1++) {
/* 641 */           this.c[b1] = param1PcmBuffer.data[(b1 << 1) + param1Int] * 3.051757E-5F;
/*     */         }
/* 643 */         this.b.forward(this.c);
/*     */         
/* 645 */         float[] arrayOfFloat = this.b.getSpectrum();
/*     */         
/* 647 */         if (this.a.fixedMaxValue > 0.0F) {
/* 648 */           this.e = this.a.fixedMaxValue;
/*     */         }
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
/* 666 */         for (byte b2 = 0; b2 < this.d.length; b2++) {
/* 667 */           int j = this.b.freqToIndex(((MusicManager.FrequencyRange)this.a.frequencies.get(b2)).min);
/* 668 */           int k = this.b.freqToIndex(((MusicManager.FrequencyRange)this.a.frequencies.get(b2)).max);
/* 669 */           if (j < k)
/*     */           {
/* 671 */             k--;
/*     */           }
/*     */           
/* 674 */           float f = 0.0F;
/* 675 */           for (j = j; j <= k; j++) {
/* 676 */             f += arrayOfFloat[j];
/*     */           }
/*     */           
/* 679 */           if (this.e < f) {
/* 680 */             this.e = f;
/*     */           }
/*     */           
/* 683 */           f = MathUtils.clamp(f / this.e, 0.0F, 1.0F);
/* 684 */           this.d[b2] = f;
/*     */         } 
/* 686 */         if (this.a.fixedMaxValue <= 0.0F) {
/* 687 */           this.e *= this.a.maxValueEasing;
/*     */         }
/*     */         
/* 690 */         synchronized (this.a.spectrumLock) {
/* 691 */           System.arraycopy(this.d, 0, (param1Int == 0) ? this.a.spectrumLeft : this.a.spectrumRight, 0, this.d.length);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface RestartableAudioDevice {
/*     */     void restart();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\music\LiveMusicManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */