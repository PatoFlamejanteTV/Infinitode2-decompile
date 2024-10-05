/*     */ package com.prineside.tdi2.managers.music;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.ibxm.IBXM;
/*     */ import com.prineside.tdi2.ibxm.Instrument;
/*     */ import com.prineside.tdi2.ibxm.Module;
/*     */ import com.prineside.tdi2.ibxm.WavInputStream;
/*     */ import com.prineside.tdi2.managers.MusicManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public abstract class CachedMusicManager
/*     */   extends MusicManager
/*     */ {
/*  28 */   private static final TLog e = TLog.forClass(CachedMusicManager.class);
/*     */ 
/*     */   
/*     */   private enum Status
/*     */   {
/*  33 */     IDLE,
/*  34 */     WAITING_CACHE_GENERATION,
/*  35 */     CACHE_GENERATED,
/*  36 */     PLAYING; static {
/*     */     
/*  38 */     } public static final Status[] values = values();
/*     */   }
/*     */   
/*  41 */   private Status f = Status.IDLE;
/*     */   
/*     */   private Module g;
/*     */   
/*     */   private String h;
/*     */   
/*     */   private Notifications.Notification i;
/*     */   private Thread j;
/*     */   private float k;
/*  50 */   private static final byte[] l = new byte[WavInputStream.header.length];
/*     */   
/*     */   public CachedMusicManager() {
/*  53 */     e.i("initializing", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup() {
/*  58 */     Game.i.screenManager.addListener(() -> b());
/*     */     
/*  60 */     super.setup();
/*     */   }
/*     */   
/*     */   public static double getWavDuration(FileHandle paramFileHandle) {
/*  64 */     paramFileHandle.readBytes(l, 0, l.length);
/*     */     
/*  66 */     int i = WavInputStream.readInt32(l, 24);
/*     */     
/*     */     int j;
/*  69 */     return (j = WavInputStream.readInt32(l, 40)) / i / 4.0D;
/*     */   }
/*     */   
/*     */   private static void b(Module paramModule) {
/*  73 */     String str = c(paramModule);
/*  74 */     Array array = (SettingsPrefs.i()).music.cacheStatuses;
/*  75 */     for (byte b = 0; b < array.size; b++) {
/*  76 */       if ((((CacheStatus[])array.items)[b]).songFileName.equals(str)) {
/*  77 */         (((CacheStatus[])array.items)[b]).lastPlayTimestamp = Game.getTimestampSeconds();
/*  78 */         SettingsPrefs.i().requireSave();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*     */     CacheStatus cacheStatus;
/*  85 */     (cacheStatus = new CacheStatus()).songFileName = str;
/*  86 */     cacheStatus.lastPlayTimestamp = Game.getTimestampSeconds();
/*  87 */     array.add(cacheStatus);
/*  88 */     SettingsPrefs.i().requireSave();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/*  95 */     if (this.j != null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 100 */     long l = 0L;
/*     */     FileHandle fileHandle;
/* 102 */     if ((fileHandle = Gdx.files.local("cache/music/")).exists() && fileHandle.isDirectory()) {
/*     */       FileHandle[] arrayOfFileHandle1; byte b; FileHandle[] arrayOfFileHandle2; int k;
/* 104 */       for (k = (arrayOfFileHandle2 = arrayOfFileHandle1 = fileHandle.list()).length, b = 0; b < k; ) { FileHandle fileHandle1 = arrayOfFileHandle2[b];
/*     */         try {
/* 106 */           if (fileHandle1.name().endsWith(".wav")) {
/*     */             
/* 108 */             long l1 = fileHandle1.length();
/* 109 */             l += l1;
/*     */           } 
/* 111 */         } catch (Exception exception) {
/* 112 */           e.e("cleanupCache failed to get size for " + fileHandle1.name(), new Object[] { exception });
/*     */         } 
/*     */         
/*     */         b++; }
/*     */     
/*     */     } else {
/*     */       return;
/*     */     } 
/* 120 */     int i = (int)(l / 1024L / 1024L);
/* 121 */     int j = (int)Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_CACHE_MAX_SIZE);
/* 122 */     if (i > j) {
/*     */       
/* 124 */       e.i("music cache limit exceeded, cleaning up (" + i + "/" + j + " Mb)", new Object[0]);
/*     */       
/* 126 */       Array array = new Array(FileCacheStatus.class); FileHandle[] arrayOfFileHandle1, arrayOfFileHandle2; int n;
/*     */       byte b;
/* 128 */       for (n = (arrayOfFileHandle2 = arrayOfFileHandle1 = fileHandle.list()).length, b = 0; b < n; ) { fileHandle = arrayOfFileHandle2[b];
/*     */         try {
/* 130 */           if (fileHandle.name().endsWith(".wav")) {
/*     */             FileCacheStatus fileCacheStatus;
/*     */             
/* 133 */             (fileCacheStatus = new FileCacheStatus((byte)0)).a = fileHandle;
/* 134 */             fileCacheStatus.b = fileHandle.length();
/*     */             
/* 136 */             Array array1 = (SettingsPrefs.i()).music.cacheStatuses;
/* 137 */             for (byte b1 = 0; b1 < array1.size; b1++) {
/* 138 */               CacheStatus cacheStatus = ((CacheStatus[])array1.items)[b1];
/* 139 */               if (fileHandle.name().startsWith(cacheStatus.songFileName)) {
/*     */                 
/* 141 */                 fileCacheStatus.c = cacheStatus;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/* 146 */             array.add(fileCacheStatus);
/*     */           } 
/* 148 */         } catch (Exception exception) {
/* 149 */           e.e("cleanupCache failed for " + fileHandle.name(), new Object[] { exception });
/*     */         } 
/*     */         b++; }
/*     */       
/*     */       int m;
/* 154 */       for (m = array.size - 1; m >= 0; m--) {
/* 155 */         if ((((FileCacheStatus[])array.items)[m]).c == null) {
/* 156 */           FileCacheStatus fileCacheStatus = (FileCacheStatus)array.removeIndex(m);
/*     */           
/* 158 */           if (this.h == null || !fileCacheStatus.a.name().startsWith(this.h)) {
/*     */             
/*     */             try {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 165 */               fileCacheStatus.a.delete();
/* 166 */               l -= fileCacheStatus.b;
/* 167 */             } catch (Exception exception) {
/* 168 */               e.e("failed to delete file with unknown cache " + fileCacheStatus.a.name(), new Object[] { exception });
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 175 */       array.sort((paramFileCacheStatus1, paramFileCacheStatus2) -> Integer.compare(paramFileCacheStatus1.c.lastPlayTimestamp, paramFileCacheStatus2.c.lastPlayTimestamp));
/*     */       int k;
/* 177 */       for (m = 0; m < array.size && (
/*     */ 
/*     */         
/* 180 */         k = (int)(l / 1024L / 1024L)) >= j; m++) {
/*     */         FileCacheStatus fileCacheStatus;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 187 */         if (!(fileCacheStatus = ((FileCacheStatus[])array.items)[m]).c.songFileName.equals(this.h)) {
/*     */           Array array1;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 193 */           if ((array1 = (SettingsPrefs.i()).music.cacheStatuses).removeValue(fileCacheStatus.c, true)) {
/* 194 */             SettingsPrefs.i().requireSave();
/*     */           }
/*     */ 
/*     */           
/*     */           try {
/* 199 */             fileCacheStatus.a.delete();
/* 200 */             l -= (((FileCacheStatus[])array.items)[m]).b;
/* 201 */           } catch (Exception exception) {
/* 202 */             e.e("failed to delete file " + fileCacheStatus.a.name(), new Object[] { exception });
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String c(Module paramModule) {
/*     */     String str;
/* 213 */     int i = 1; byte b1;
/* 214 */     for (b1 = 0; b1 < paramModule.sequence.length; b1++) {
/* 215 */       i = i * 31 + paramModule.sequence[b1];
/*     */     }
/* 217 */     i = i * 31 + paramModule.patterns.length;
/*     */     
/* 219 */     for (b1 = 0; b1 < paramModule.songName.length(); b1++)
/* 220 */       i = i * 31 + paramModule.songName.charAt(b1);  Instrument[] arrayOfInstrument;
/*     */     int j;
/*     */     byte b2;
/* 223 */     for (j = (arrayOfInstrument = paramModule.instruments).length, b2 = 0; b2 < j; b2++) {
/* 224 */       Instrument instrument; if ((instrument = arrayOfInstrument[b2]).name.length() != 0) {
/* 225 */         for (byte b = 0; b < instrument.name.length(); b++) {
/* 226 */           i = i * 31 + instrument.name.charAt(b);
/*     */         }
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 232 */     if (i < 0) {
/* 233 */       str = "n" + Integer.toHexString(-i);
/*     */     } else {
/* 235 */       str = Integer.toHexString(i);
/*     */     } 
/*     */     
/* 238 */     return paramModule.songName.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ENGLISH) + "-" + str.toLowerCase(Locale.ENGLISH);
/*     */   }
/*     */   
/*     */   protected static String a(Module paramModule, boolean paramBoolean) {
/* 242 */     return "cache/music/" + c(paramModule) + (paramBoolean ? "-l" : "") + ".wav";
/*     */   }
/*     */   
/*     */   public static boolean isMusicCached(Module paramModule) {
/* 246 */     if (paramModule.restartPos != 0 && 
/* 247 */       !Gdx.files.local(a(paramModule, false)).exists()) {
/* 248 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 252 */     return Gdx.files.local(a(paramModule, true)).exists();
/*     */   }
/*     */ 
/*     */   
/*     */   public void preRender(float paramFloat) {
/* 257 */     super.preRender(paramFloat);
/*     */     
/* 259 */     if (this.c) {
/*     */       
/* 261 */       if (this.i != null) {
/* 262 */         this.i.showProgress(this.k, Color.GREEN);
/*     */       }
/*     */ 
/*     */       
/*     */       StringBuilder stringBuilder;
/*     */ 
/*     */       
/* 269 */       if ((stringBuilder = Game.i.debugManager.registerValue("XM cached music status")) != null) {
/* 270 */         stringBuilder.append(this.f.name());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d(Module paramModule) {
/* 282 */     stopMusic();
/*     */     
/* 284 */     this.f = Status.PLAYING;
/* 285 */     this.g = paramModule;
/* 286 */     this.h = c(paramModule);
/*     */     
/* 288 */     b(paramModule);
/*     */ 
/*     */     
/* 291 */     a(paramModule);
/* 292 */     setVolumeToStartNewTrack();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c() {
/* 298 */     if (this.j != null) {
/* 299 */       this.j.interrupt();
/* 300 */       this.j = null;
/*     */       
/* 302 */       e.i("interrupted caching thread", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void playMusic(Module paramModule) {
/* 308 */     if (paramModule == this.g)
/* 309 */       return;  if (paramModule == null) stopMusic();
/*     */ 
/*     */ 
/*     */     
/* 313 */     this.a = false;
/*     */     
/* 315 */     this.g = paramModule;
/*     */     
/* 317 */     this.h = c(paramModule);
/*     */     
/* 319 */     if (this.i != null) {
/* 320 */       this.i.hide(0.0F);
/* 321 */       this.i = null;
/*     */     } 
/*     */     
/* 324 */     this.b = paramModule.getVolumeMultiplierFromInstrumentNames();
/*     */     
/* 326 */     if (isMusicCached(paramModule)) {
/*     */       
/* 328 */       d(paramModule);
/* 329 */       showSongNotification(paramModule, 7.0F);
/*     */       return;
/*     */     } 
/* 332 */     this.i = showSongNotification(paramModule, 30.0F);
/* 333 */     this.k = 0.0F;
/*     */     
/* 335 */     this.f = Status.WAITING_CACHE_GENERATION;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 341 */     c();
/* 342 */     this.j = new Thread(() -> {
/*     */           e.i("caching thread started", new Object[0]);
/*     */           
/*     */           IBXM iBXM;
/*     */           
/*     */           (iBXM = new IBXM(paramModule, 44100)).setInterpolation(getInterpolation());
/*     */           
/*     */           byte[] arrayOfByte = new byte[4096];
/*     */           
/*     */           if (paramModule.restartPos != 0 && !Thread.currentThread().isInterrupted()) {
/*     */             WavInputStream wavInputStream = new WavInputStream(iBXM, 0, WavInputStream.Mode.INTRO_PART);
/*     */             
/*     */             String str = a(paramModule, false);
/*     */             
/*     */             FileHandle fileHandle;
/*     */             
/*     */             OutputStream outputStream = (fileHandle = Gdx.files.local(str)).write(false);
/*     */             
/*     */             try {
/*     */               int i = 0;
/*     */               
/*     */               int j;
/*     */               
/*     */               while ((j = wavInputStream.read(arrayOfByte, 0, 4096)) > 0) {
/*     */                 i += j;
/*     */                 outputStream.write(arrayOfByte, 0, j);
/*     */                 this.k = i / (i + wavInputStream.getRemain()) * 0.5F;
/*     */               } 
/* 370 */             } catch (Exception exception) {
/*     */               e.e("failed to write" + str, new Object[0]);
/*     */             } 
/*     */             
/*     */             this.k = 0.5F;
/*     */             
/*     */             e.i("prepared intro cache for " + str, new Object[0]);
/*     */           } 
/*     */           
/*     */           if (!Thread.currentThread().isInterrupted()) {
/*     */             WavInputStream wavInputStream = new WavInputStream(iBXM, 0, WavInputStream.Mode.LOOPING_PART);
/*     */             
/*     */             String str = a(paramModule, true);
/*     */             
/*     */             FileHandle fileHandle;
/*     */             
/*     */             OutputStream outputStream = (fileHandle = Gdx.files.local(str)).write(false);
/*     */             
/*     */             try {
/*     */               int i = 0;
/*     */               
/*     */               int j;
/*     */               
/*     */               while ((j = wavInputStream.read(arrayOfByte, 0, 4096)) > 0) {
/*     */                 i += j;
/*     */                 
/*     */                 outputStream.write(arrayOfByte, 0, j);
/*     */                 
/*     */                 this.k = i / (i + wavInputStream.getRemain());
/*     */                 if (paramModule.restartPos != 0) {
/*     */                   this.k = 0.5F + this.k * 0.5F;
/*     */                 }
/*     */               } 
/* 403 */             } catch (Exception exception) {
/*     */               e.e("failed to write" + str, new Object[0]);
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/*     */             this.k = 1.0F;
/*     */ 
/*     */ 
/*     */             
/*     */             e.i("prepared looping cache for " + str, new Object[0]);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*     */           if (!Thread.currentThread().isInterrupted() && this.f == Status.WAITING_CACHE_GENERATION) {
/*     */             this.f = Status.CACHE_GENERATED;
/*     */ 
/*     */ 
/*     */             
/*     */             Threads.i().runOnMainThread(());
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*     */           e.i("caching thread ended", new Object[0]);
/*     */ 
/*     */ 
/*     */           
/*     */           this.j = null;
/*     */         });
/*     */ 
/*     */     
/* 436 */     this.j.setDaemon(true);
/* 437 */     this.j.start();
/* 438 */     CrashHandler.handleThreadExceptionsForgiving(this.j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Module getPlayingMusic() {
/* 444 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopMusic() {
/* 449 */     this.g = null;
/* 450 */     this.f = Status.IDLE;
/*     */     
/* 452 */     this.h = null;
/*     */   }
/*     */   
/*     */   protected abstract void a(Module paramModule);
/*     */   
/*     */   public static class CacheStatus { public String songFileName;
/*     */     public int lastPlayTimestamp;
/*     */     
/*     */     public static CacheStatus fromJson(JsonValue param1JsonValue) {
/*     */       CacheStatus cacheStatus;
/* 462 */       (cacheStatus = new CacheStatus()).songFileName = param1JsonValue.getString("sfn", "");
/* 463 */       cacheStatus.lastPlayTimestamp = param1JsonValue.getInt("lpt", 0);
/*     */       
/* 465 */       return cacheStatus;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void toJson(Json param1Json) {
/* 472 */       param1Json.writeValue("sfn", this.songFileName);
/* 473 */       param1Json.writeValue("lpt", Integer.valueOf(this.lastPlayTimestamp));
/*     */     } }
/*     */ 
/*     */   
/*     */   private class FileCacheStatus {
/*     */     FileHandle a;
/*     */     long b;
/*     */     CachedMusicManager.CacheStatus c;
/*     */     
/*     */     private FileCacheStatus(CachedMusicManager this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\music\CachedMusicManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */