/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Base64Coder;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.ibxm.Module;
/*     */ import com.prineside.tdi2.managers.music.LiveMusicManager;
/*     */ import com.prineside.tdi2.managers.music.RecordedSpectrum;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.tiles.EqualizerTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MusicManager
/*     */   extends Manager.ManagerAdapter
/*     */ {
/*     */   private static final TLog e = TLog.forClass(MusicManager.class);
/*     */   
/*     */   public static class Serializer
/*     */     extends SingletonSerializer<MusicManager>
/*     */   {
/*     */     public MusicManager read() {
/*     */       return Game.i.musicManager;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum MusicSourceType
/*     */   {
/*     */     DEFAULT, BASIC_LEVEL, USER_MAP;
/*     */     public static final MusicSourceType[] values = values();
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MusicSource
/*     */   {
/*     */     public static final MusicSource DEFAULT = new MusicSource(MusicManager.MusicSourceType.DEFAULT, null);
/*     */     public MusicManager.MusicSourceType type;
/*     */     public String id;
/*     */     public int repeats = 1;
/*     */     
/*     */     public MusicSource(MusicManager.MusicSourceType param1MusicSourceType, String param1String) {
/*     */       this.type = param1MusicSourceType;
/*     */       this.id = param1String;
/*     */     }
/*     */     
/*     */     public Module getModule() {
/*     */       if (this.type == MusicManager.MusicSourceType.BASIC_LEVEL)
/*     */         try {
/*     */           return Game.i.basicLevelManager.getLevel(this.id).getMap().getMusicTile().getModule();
/*     */         } catch (Exception exception) {
/*     */           return null;
/*     */         }  
/*     */       if (this.type == MusicManager.MusicSourceType.USER_MAP)
/*     */         try {
/*     */           return (Game.i.userMapManager.getUserMap(this.id)).map.getMusicTile().getModule();
/*     */         } catch (Exception exception) {
/*     */           return null;
/*     */         }  
/*     */       if (this.type == MusicManager.MusicSourceType.DEFAULT)
/*     */         try {
/*     */           return Game.i.assetManager.getMenuXmSoundTrack();
/*     */         } catch (Exception exception) {
/*     */           return null;
/*     */         }  
/*     */       return null;
/*     */     }
/*     */     
/*     */     public String getBase64() {
/*     */       if (this.type == MusicManager.MusicSourceType.BASIC_LEVEL)
/*     */         return Game.i.basicLevelManager.getLevel(this.id).getMap().getMusicTile().getTrackBase64(); 
/*     */       if (this.type == MusicManager.MusicSourceType.USER_MAP)
/*     */         return (Game.i.userMapManager.getUserMap(this.id)).map.getMusicTile().getTrackBase64(); 
/*     */       return null;
/*     */     }
/*     */     
/*     */     public boolean sameAs(MusicSource param1MusicSource) {
/*     */       if (this.type != param1MusicSource.type)
/*     */         return false; 
/*     */       if (this.type == MusicManager.MusicSourceType.DEFAULT)
/*     */         return true; 
/*     */       return (this.id == null || this.id.equals(param1MusicSource.id));
/*     */     }
/*     */     
/*     */     public void toJson(Json param1Json) {
/*     */       param1Json.writeValue("type", this.type.name());
/*     */       if (this.id != null)
/*     */         param1Json.writeValue("id", this.id); 
/*     */       if (this.repeats > 1)
/*     */         param1Json.writeValue("repeats", Integer.valueOf(this.repeats)); 
/*     */     }
/*     */     
/*     */     public static MusicSource fromJson(JsonValue param1JsonValue) {
/*     */       try {
/*     */         MusicManager.MusicSourceType musicSourceType = MusicManager.MusicSourceType.valueOf(param1JsonValue.getString("type", MusicManager.MusicSourceType.DEFAULT.name()));
/*     */         String str = param1JsonValue.getString("id", null);
/*     */         int i = param1JsonValue.getInt("repeats", 1);
/*     */         MusicSource musicSource;
/*     */         (musicSource = new MusicSource(musicSourceType, str)).repeats = i;
/*     */         return musicSource;
/*     */       } catch (Exception exception) {
/*     */         MusicManager.a().e("failed MusicSource.fromJson: " + param1JsonValue.toString(), new Object[] { exception });
/*     */         return DEFAULT;
/*     */       } 
/*     */     }
/*     */     
/*     */     public String toString() {
/*     */       return super.toString() + " (" + this.type + ":" + this.id + ")";
/*     */     }
/*     */   }
/*     */   private static final Color f = (new Color(255)).mul(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   private static final Color g = new Color(-508394241);
/*     */   
/*     */   public MusicManager() {
/* 157 */     this.h = 0.0F;
/* 158 */     this.i = 1.0F;
/* 159 */     this.j = 0.0F;
/*     */     
/* 161 */     this.b = 1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     this.l = new IntMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     this.o = new IntIntMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     this.d = new Array(true, 1, SpectrumConfig.class);
/*     */     
/* 180 */     this.d.add(SpectrumConfig.DEFAULT);
/*     */   }
/*     */   public static final float DEFAULT_VOLUME_CHANGE_SPEED = 2.0F; private float h; private float i; private float j; protected boolean a;
/*     */   
/*     */   public void setup() {
/* 185 */     this.c = true;
/*     */     
/* 187 */     Game.i.settingsManager.addListener(new SettingsManager.SettingsManagerListener.SettingsManagerListenerAdapter(this)
/*     */         {
/*     */           public void customValueChanged(SettingsManager.CustomValueType param1CustomValueType, double param1Double) {
/* 190 */             if (param1CustomValueType == SettingsManager.CustomValueType.MUSIC_VOLUME)
/* 191 */               this.a.setVolume(MusicManager.a(this.a), 0.0F, false); 
/*     */           }
/*     */         });
/*     */   }
/*     */   protected float b; protected boolean c;
/*     */   private float k;
/*     */   private final IntMap<SoftReference<ModuleCacheConfig>> l;
/*     */   private static final Array<ModuleCacheConfig> m = new Array(ModuleCacheConfig.class);
/*     */   
/*     */   public SpectrumConfig getSpectrumConfig(SpectrumConfig paramSpectrumConfig) {
/* 201 */     for (byte b = 0; b < this.d.size; b++) {
/* 202 */       if (paramSpectrumConfig.sameAs(((SpectrumConfig[])this.d.items)[b])) {
/* 203 */         return ((SpectrumConfig[])this.d.items)[b];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 208 */     e.i("registering new spectrum config " + paramSpectrumConfig, new Object[0]);
/* 209 */     this.d.add(paramSpectrumConfig);
/*     */     
/* 211 */     return paramSpectrumConfig;
/*     */   } private static final Comparator<ModuleCacheConfig> n; private final IntIntMap o; public long lastSoundTimestamp; private RecordedSpectrum p; protected final Array<SpectrumConfig> d; static {
/*     */     n = ((paramModuleCacheConfig1, paramModuleCacheConfig2) -> Integer.compare(paramModuleCacheConfig2.lastUsed, paramModuleCacheConfig1.lastUsed));
/*     */   } public int getInterpolation() {
/* 215 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SMOOTH_MUSIC) == 0.0D) {
/* 216 */       return 0;
/*     */     }
/* 218 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMainVolume() {
/* 223 */     return (float)Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME);
/*     */   }
/*     */   
/*     */   public RecordedSpectrum getSpectrumSim() {
/* 227 */     if (this.p == null) {
/* 228 */       e.i("loading spectrum sim", new Object[0]);
/* 229 */       this.p = RecordedSpectrum.fromFile(AssetManager.localOrInternalFile("res/music-spectrum-sim.bin"));
/*     */     } 
/* 231 */     return this.p;
/*     */   }
/*     */   
/*     */   public boolean isMenuMusicSourceEnabled(MusicSource paramMusicSource) {
/* 235 */     Array array = (SettingsPrefs.i()).music.menuThemeSources;
/* 236 */     for (byte b = 0; b < array.size; b++) {
/* 237 */       if (((MusicSource[])array.items)[b].sameAs(paramMusicSource)) {
/* 238 */         return true;
/*     */       }
/*     */     } 
/* 241 */     return false;
/*     */   }
/*     */   
/*     */   public void addMenuMusicSource(MusicSource paramMusicSource) {
/* 245 */     if (isMenuMusicSourceEnabled(paramMusicSource))
/*     */       return;  Array array;
/* 247 */     (array = (SettingsPrefs.i()).music.menuThemeSources).clear();
/* 248 */     array.add(paramMusicSource);
/* 249 */     SettingsPrefs.i().requireSave();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMenuMusicSourceRepeatCount(MusicSource paramMusicSource) {
/* 256 */     Array array = (SettingsPrefs.i()).music.menuThemeSources;
/* 257 */     for (byte b = 0; b < array.size; b++) {
/*     */       MusicSource musicSource;
/* 259 */       if ((musicSource = ((MusicSource[])array.items)[b]).sameAs(paramMusicSource)) {
/* 260 */         return musicSource.repeats;
/*     */       }
/*     */     } 
/*     */     
/* 264 */     return 1;
/*     */   }
/*     */   
/*     */   public void removeMenuMusicSource(MusicSource paramMusicSource) {
/* 268 */     Array array = (SettingsPrefs.i()).music.menuThemeSources;
/* 269 */     for (byte b = 0; b < array.size; b++) {
/* 270 */       MusicSource musicSource = ((MusicSource[])array.items)[b];
/* 271 */       if (paramMusicSource.sameAs(musicSource)) {
/* 272 */         array.removeIndex(b);
/*     */         
/* 274 */         if (array.size == 0)
/*     */         {
/* 276 */           array.add(MusicSource.DEFAULT);
/*     */         }
/* 278 */         SettingsPrefs.i().requireSave();
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void voteThumbsUp(int paramInt, boolean paramBoolean) {
/* 285 */     IntArray intArray = (SettingsPrefs.i()).music.thumbsUpMusicHashes;
/* 286 */     if (paramBoolean) {
/* 287 */       if (!intArray.contains(paramInt)) {
/* 288 */         intArray.add(paramInt);
/* 289 */         SettingsPrefs.i().requireSave();
/*     */         return;
/*     */       } 
/* 292 */     } else if (intArray.removeValue(paramInt)) {
/* 293 */       SettingsPrefs.i().requireSave();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMusicThumbsUp(int paramInt) {
/* 299 */     return (SettingsPrefs.i()).music.thumbsUpMusicHashes.contains(paramInt);
/*     */   }
/*     */   
/*     */   public Array<MusicSource> getMenuThemeSources() {
/* 303 */     return (SettingsPrefs.i()).music.menuThemeSources;
/*     */   }
/*     */ 
/*     */   
/*     */   public MusicSource getCurrentlyPlayingMenuThemeSource() {
/* 308 */     return (MusicSource)(SettingsPrefs.i()).music.menuThemeSources.first();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMusicB64hash(String paramString) {
/* 314 */     int j, i = paramString.hashCode();
/*     */ 
/*     */     
/* 317 */     synchronized (this.o) {
/*     */ 
/*     */       
/* 320 */       if ((j = this.o.get(i, 0)) == 0) {
/* 321 */         j = 1; byte b; int k;
/* 322 */         for (b = 0, k = paramString.length(); b < k; b++) {
/* 323 */           j = j * 31 + paramString.charAt(b);
/*     */         }
/* 325 */         this.o.put(i, j);
/*     */       } 
/*     */     } 
/*     */     
/* 329 */     return j;
/*     */   }
/*     */   
/*     */   public Module getModule(String paramString) {
/* 333 */     int i = getMusicB64hash(paramString);
/*     */     
/* 335 */     synchronized (this.l) {
/* 336 */       ModuleCacheConfig moduleCacheConfig; if (this.l.containsKey(i) && (
/*     */         
/* 338 */         moduleCacheConfig = ((SoftReference<ModuleCacheConfig>)this.l.get(i)).get()) != null) {
/* 339 */         return moduleCacheConfig.module;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 345 */       Module module = Module.fromZipInputStream(new ByteArrayInputStream(Base64Coder.decode(paramString)));
/*     */       ModuleCacheConfig moduleCacheConfig;
/* 347 */       (moduleCacheConfig = new ModuleCacheConfig()).hash = i;
/* 348 */       moduleCacheConfig.module = module;
/* 349 */       moduleCacheConfig.lastUsed = Game.getTimestampSeconds();
/* 350 */       moduleCacheConfig.size = paramString.length();
/* 351 */       synchronized (this.l) {
/* 352 */         this.l.put(i, new SoftReference<>(moduleCacheConfig));
/*     */       } 
/*     */       
/* 355 */       b();
/*     */       
/* 357 */       return module;
/* 358 */     } catch (Exception exception) {
/* 359 */       throw new IllegalStateException("failed to read module from base64", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/* 368 */     IntArray intArray = null;
/* 369 */     m.clear();
/*     */     
/* 371 */     int i = Game.getTimestampSeconds();
/* 372 */     for (Iterator<IntMap.Entry> iterator = this.l.iterator(); iterator.hasNext(); ) {
/*     */       IntMap.Entry entry; ModuleCacheConfig moduleCacheConfig;
/* 374 */       if ((moduleCacheConfig = ((SoftReference<ModuleCacheConfig>)(entry = iterator.next()).value).get()) != null) {
/* 375 */         if (i - moduleCacheConfig.lastUsed > 300) {
/*     */           
/* 377 */           if (intArray == null) intArray = new IntArray(); 
/* 378 */           intArray.add(entry.key);
/*     */           continue;
/*     */         } 
/* 381 */         m.add(moduleCacheConfig);
/*     */         
/*     */         continue;
/*     */       } 
/* 385 */       if (intArray == null) intArray = new IntArray(); 
/* 386 */       intArray.add(entry.key);
/*     */     } 
/*     */     
/* 389 */     if (m.size > 5) {
/*     */       
/* 391 */       m.sort(n);
/* 392 */       for (byte b = 5; b < m.size; b++) {
/* 393 */         if (intArray == null) intArray = new IntArray(); 
/* 394 */         intArray.add((((ModuleCacheConfig[])m.items)[b]).hash);
/*     */       } 
/*     */     } 
/*     */     
/* 398 */     if (intArray != null) {
/* 399 */       for (byte b = 0; b < intArray.size; b++) {
/* 400 */         int j = intArray.items[b];
/* 401 */         this.l.remove(j);
/*     */       } 
/*     */     }
/*     */     
/* 405 */     m.clear();
/*     */   }
/*     */   
/*     */   public void setVolumeToStartNewTrack() {
/* 409 */     setVolume(0.0F, 0.0F, false);
/* 410 */     setVolume(1.0F, 1.0F, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVolume(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 417 */     if (Config.isHeadless()) {
/*     */       return;
/*     */     }
/*     */     
/* 421 */     this.i = paramFloat1;
/*     */     
/* 423 */     if (paramFloat2 <= 0.0F) {
/* 424 */       if (paramFloat1 <= 0.0F) {
/* 425 */         if (paramBoolean) {
/* 426 */           this.a = false;
/* 427 */           stopMusic(); return;
/*     */         } 
/* 429 */         this.h = 0.0F;
/* 430 */         setBackendVolume(0.0F);
/*     */         return;
/*     */       } 
/* 433 */       this.h = paramFloat1;
/* 434 */       setBackendVolume(getFactVolume(paramFloat1));
/*     */       return;
/*     */     } 
/* 437 */     this.j = paramFloat2;
/* 438 */     this.a = paramBoolean;
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
/*     */   public float getFactVolume(float paramFloat) {
/* 454 */     if (paramFloat < 0.0F) paramFloat = 0.0F; 
/* 455 */     if (paramFloat > 1.0F) paramFloat = 1.0F;
/*     */     
/* 457 */     return paramFloat * getMainVolume() * this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void simulateSpectrums() {
/* 462 */     for (byte b = 0; b < this.d.size; b++) {
/* 463 */       SpectrumConfig.a((SpectrumConfig)this.d.get(b));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void preRender(float paramFloat) {
/* 469 */     if (!this.c)
/*     */       return; 
/* 471 */     simulateSpectrums();
/*     */ 
/*     */     
/* 474 */     float f = this.h;
/* 475 */     if (this.j != 0.0F) {
/* 476 */       if (f != this.i) {
/*     */         
/* 478 */         float f1 = paramFloat * this.j;
/* 479 */         float f2 = this.i - f;
/*     */         
/* 481 */         if ((f1 = f1 / StrictMath.abs(f2)) >= 1.0F) {
/* 482 */           this.h = this.i;
/*     */         } else {
/* 484 */           this.h = f + f2 * f1;
/*     */         } 
/* 486 */         setBackendVolume(getFactVolume(this.h));
/*     */       } else {
/*     */         
/* 489 */         this.j = 0.0F;
/* 490 */         setBackendVolume(getFactVolume(this.h));
/*     */       } 
/*     */     } else {
/* 493 */       setBackendVolume(getFactVolume(this.i));
/*     */     } 
/*     */     
/* 496 */     if (this.a && f == 0.0F) {
/* 497 */       stopMusic();
/* 498 */       this.a = false;
/*     */     } 
/*     */ 
/*     */     
/* 502 */     this.k += paramFloat;
/* 503 */     if (this.k > 60.0F) {
/* 504 */       this.k = 0.0F;
/* 505 */       b();
/*     */     } 
/*     */ 
/*     */     
/*     */     StringBuilder stringBuilder;
/*     */ 
/*     */     
/* 512 */     if ((stringBuilder = Game.i.debugManager.registerValue("Music")) != null) {
/* 513 */       stringBuilder.append("v:").append((int)(this.h * 100.0F)).append("% ").append((getPlayingMusic() == null) ? "NP" : "P");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MusicManager createSelfSetuppingDummy() {
/* 521 */     return new MusicManager()
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void setup()
/*     */         {
/* 530 */           Game.i.musicManager = (MusicManager)new LiveMusicManager();
/*     */ 
/*     */           
/* 533 */           int i = Game.i.managers.indexOf(this, true);
/* 534 */           Game.i.managers.removeIndex(i);
/* 535 */           Game.i.managers.insert(i, Game.i.musicManager);
/*     */           
/* 537 */           Game.i.musicManager.setup();
/*     */           
/* 539 */           MusicManager.a().i("music manager replaced", new Object[0]);
/*     */         }
/*     */ 
/*     */         
/*     */         public void stopMusic() {
/* 544 */           MusicManager.a().i("music manager is not set up yet", new Object[0]);
/*     */         }
/*     */ 
/*     */         
/*     */         public void setBackendVolume(float param1Float) {
/* 549 */           MusicManager.a().i("music manager is not set up yet", new Object[0]);
/*     */         }
/*     */ 
/*     */         
/*     */         public void playMusic(Module param1Module) {
/* 554 */           MusicManager.a().i("music manager is not set up yet", new Object[0]);
/*     */         }
/*     */ 
/*     */         
/*     */         public Module getPlayingMusic() {
/* 559 */           MusicManager.a().i("music manager is not set up yet", new Object[0]);
/* 560 */           return null;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void continuePlayingMenuMusicTrack() {
/* 566 */     if (!Game.i.settingsManager.isMusicEnabled()) {
/*     */       
/* 568 */       stopMusic();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     MusicSource musicSource;
/*     */     Module module;
/* 575 */     if ((module = (musicSource = getCurrentlyPlayingMenuThemeSource()).getModule()) == null) {
/* 576 */       module = Game.i.assetManager.getMenuXmSoundTrack();
/*     */     }
/* 578 */     if (module == null) {
/*     */       
/* 580 */       stopMusic();
/*     */       
/*     */       return;
/*     */     } 
/* 584 */     if (getPlayingMusic() == null || !(getPlayingMusic()).songName.equals(module.songName)) {
/* 585 */       setVolumeToStartNewTrack();
/* 586 */       playMusic(module);
/* 587 */       e.i("started menu music", new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Notifications.Notification showSongNotification(Module paramModule, float paramFloat) {
/* 592 */     Notifications.i().hideNotification("MusicManager_CurrentlyPlaying");
/*     */     
/*     */     Table table;
/* 595 */     (table = new Table()).setTouchable(Touchable.childrenOnly);
/* 596 */     table.setWidth(340.0F);
/*     */     
/*     */     Label label;
/* 599 */     (label = new Label(paramModule.songName, Game.i.assetManager.getLabelStyle(24))).setColor(g);
/* 600 */     table.add((Actor)label).growX().row();
/*     */     
/*     */     Array array;
/* 603 */     for (Array.ArrayIterator<Module.TrackInfoEntry> arrayIterator = (array = paramModule.getInfoFromInstrumentNames()).iterator(); arrayIterator.hasNext(); ) { Label label1; Module.TrackInfoEntry trackInfoEntry = arrayIterator.next();
/* 604 */       LimitedWidthLabel limitedWidthLabel = new LimitedWidthLabel(trackInfoEntry.value, 24, 18, 340.0F);
/* 605 */       switch (null.a[trackInfoEntry.type.ordinal()]) {
/*     */         
/*     */         case 1:
/* 608 */           (label1 = new Label(Game.i.localeManager.i18n.get("music_track_author") + ":", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 609 */           table.add((Actor)label1).growX().padTop(8.0F).row();
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/* 614 */           (label1 = new Label(Game.i.localeManager.i18n.get("music_track_group") + ":", Game.i.assetManager.getLabelStyle(18))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 615 */           table.add((Actor)label1).growX().padTop(8.0F).row();
/*     */           break;
/*     */         
/*     */         case 3:
/* 619 */           limitedWidthLabel.setTouchable(Touchable.enabled);
/* 620 */           limitedWidthLabel.addListener((EventListener)new ClickListener(this, (Module.TrackInfoEntry)label1)
/*     */               {
/*     */                 public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 623 */                   Gdx.net.openURI(this.a.getCompleteLink());
/*     */                 }
/*     */               });
/* 626 */           limitedWidthLabel.addListener((EventListener)new InputListener(this, limitedWidthLabel)
/*     */               {
/*     */                 public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 629 */                   this.a.setColor(MaterialColor.LIGHT_BLUE.P200);
/*     */                 }
/*     */                 
/*     */                 public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 633 */                   this.a.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */                 }
/*     */               });
/* 636 */           limitedWidthLabel.setText(limitedWidthLabel.getText() + Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-link-out>").toString());
/* 637 */           limitedWidthLabel.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */           break;
/*     */       } 
/* 640 */       limitedWidthLabel.setAlignment(8);
/* 641 */       table.add((Actor)limitedWidthLabel).growX().row(); }
/*     */ 
/*     */     
/*     */     Notifications.Notification notification;
/* 645 */     (notification = Notifications.i().addWithContents(table, (Drawable)Game.i.assetManager.getDrawable("icon-note"), f, null, paramFloat)).iconImage.setColor(g);
/* 646 */     notification.setTouchable(Touchable.childrenOnly);
/*     */     
/*     */     EqualizerTile equalizerTile;
/* 649 */     (equalizerTile = new EqualizerTile()).barsWidth = 1.0F;
/* 650 */     equalizerTile.barsHeight = 1.0F;
/* 651 */     equalizerTile.shiftX = 0.0F;
/* 652 */     equalizerTile.shiftY = 0.0F;
/* 653 */     equalizerTile.drawAlways = true;
/* 654 */     equalizerTile.colorHigh = new Color(g.cpy().mul(1.0F, 1.0F, 1.0F, 0.0F));
/* 655 */     equalizerTile.colorLow = g.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F);
/* 656 */     equalizerTile.spectrumFrequencies = (getSpectrumConfig(SpectrumConfig.DEFAULT)).frequencies;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Image image;
/*     */ 
/*     */ 
/*     */     
/* 665 */     (image = new Image(this, equalizerTile) { public void draw(Batch param1Batch, float param1Float) { validate(); this.j.drawFancy(param1Batch, Gdx.graphics.getDeltaTime(), getX(), getY(), 128.0F); } }).setTouchable(Touchable.disabled);
/* 666 */     image.setSize(340.0F, 80.0F);
/* 667 */     image.setPosition(-106.0F, -20.0F);
/* 668 */     table.addActor((Actor)image);
/*     */     
/* 670 */     notification.id = "MusicManager_CurrentlyPlaying";
/*     */     
/* 672 */     return notification;
/*     */   }
/*     */   public abstract void stopMusic();
/*     */   protected abstract void setBackendVolume(float paramFloat);
/*     */   public abstract void playMusic(Module paramModule);
/*     */   public abstract Module getPlayingMusic();
/*     */   public static class ModuleCacheConfig {
/*     */     public int hash; public Module module;
/*     */     public int lastUsed;
/*     */     public int size; }
/*     */   
/*     */   @REGS
/* 684 */   public static final class SpectrumConfig implements KryoSerializable { public static final SpectrumConfig DEFAULT = new SpectrumConfig(new Array((Object[])new MusicManager.FrequencyRange[] { new MusicManager.FrequencyRange(0.0F, 20.0F), new MusicManager.FrequencyRange(20.0F, 55.0F), new MusicManager.FrequencyRange(55.0F, 110.0F), new MusicManager.FrequencyRange(110.0F, 220.0F), new MusicManager.FrequencyRange(220.0F, 440.0F), new MusicManager.FrequencyRange(440.0F, 880.0F), new MusicManager.FrequencyRange(880.0F, 1760.0F), new MusicManager.FrequencyRange(1760.0F, 3520.0F), new MusicManager.FrequencyRange(3520.0F, 7040.0F), new MusicManager.FrequencyRange(7040.0F, 14080.0F), new MusicManager.FrequencyRange(14080.0F, 28160.0F) }));
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
/* 699 */     public Array<MusicManager.FrequencyRange> frequencies = new Array(true, 1, MusicManager.FrequencyRange.class);
/* 700 */     public float fixedMaxValue = 0.0F;
/* 701 */     public float maxValueEasing = 0.998F;
/*     */     @NAGS
/* 703 */     public final Object spectrumLock = new Object(); @NAGS
/*     */     public float[] spectrumLeft;
/*     */     @NAGS
/*     */     public float[] spectrumRight;
/*     */     @NAGS
/*     */     private float a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 711 */       param1Kryo.writeObject(param1Output, this.frequencies);
/* 712 */       param1Output.writeFloat(this.maxValueEasing);
/* 713 */       param1Output.writeFloat(this.fixedMaxValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 718 */       this.frequencies = (Array<MusicManager.FrequencyRange>)param1Kryo.readObject(param1Input, Array.class);
/* 719 */       this.maxValueEasing = param1Input.readFloat();
/* 720 */       this.fixedMaxValue = param1Input.readFloat();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SpectrumConfig(Array<MusicManager.FrequencyRange> param1Array) {
/* 727 */       this.frequencies.addAll(param1Array);
/* 728 */       this.spectrumLeft = new float[getSpectrumSize()];
/* 729 */       this.spectrumRight = new float[getSpectrumSize()];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int getSpectrumSize() {
/* 737 */       return this.frequencies.size;
/*     */     }
/*     */     
/*     */     public final void copySpectrum(float[] param1ArrayOffloat, boolean param1Boolean) {
/* 741 */       synchronized (this.spectrumLock) {
/* 742 */         System.arraycopy(param1Boolean ? this.spectrumLeft : this.spectrumRight, 0, param1ArrayOffloat, 0, this.spectrumLeft.length);
/*     */         return;
/*     */       } 
/*     */     }
/*     */     private void a() {
/* 747 */       this.a += Gdx.graphics.getDeltaTime();
/* 748 */       Game.i.musicManager.getSpectrumSim().generateSpectrum(this.a, this.spectrumLeft, this.spectrumRight);
/*     */     }
/*     */     
/*     */     public final void zeroSpectrums() {
/* 752 */       Arrays.fill(this.spectrumLeft, 0.0F);
/* 753 */       Arrays.fill(this.spectrumRight, 0.0F);
/*     */     }
/*     */     
/*     */     public final boolean sameAs(SpectrumConfig param1SpectrumConfig) {
/* 757 */       if (this.frequencies.size != param1SpectrumConfig.frequencies.size) return false; 
/* 758 */       for (byte b = 0; b < this.frequencies.size; b++) {
/* 759 */         if (((MusicManager.FrequencyRange)this.frequencies.get(b)).min != ((MusicManager.FrequencyRange)param1SpectrumConfig.frequencies.get(b)).min) {
/* 760 */           return false;
/*     */         }
/* 762 */         if (((MusicManager.FrequencyRange)this.frequencies.get(b)).max != ((MusicManager.FrequencyRange)param1SpectrumConfig.frequencies.get(b)).max) {
/* 763 */           return false;
/*     */         }
/*     */       } 
/* 766 */       if (this.maxValueEasing != param1SpectrumConfig.maxValueEasing) return false; 
/* 767 */       if (this.fixedMaxValue != param1SpectrumConfig.fixedMaxValue) return false;
/*     */       
/* 769 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/*     */       StringBuilder stringBuilder;
/* 775 */       (stringBuilder = new StringBuilder()).append(" { frequencies (").append(this.frequencies.size).append("): [");
/* 776 */       for (byte b = 0; b < this.frequencies.size; b++) {
/* 777 */         if (b != 0) stringBuilder.append(","); 
/* 778 */         stringBuilder.append("[").append((((MusicManager.FrequencyRange[])this.frequencies.items)[b]).min).append(",").append((((MusicManager.FrequencyRange[])this.frequencies.items)[b]).max).append("]");
/*     */       } 
/* 780 */       stringBuilder.append("], fixedMaxValue: ").append(this.fixedMaxValue);
/* 781 */       stringBuilder.append(", maxValueEasing: ").append(this.maxValueEasing);
/* 782 */       stringBuilder.append(" }");
/*     */       
/* 784 */       return super.toString() + stringBuilder;
/*     */     }
/*     */     
/*     */     public SpectrumConfig() {} }
/*     */   
/*     */   @REGS
/*     */   public static final class FrequencyRange implements KryoSerializable { public float min;
/*     */     public float max;
/* 792 */     public float multiplier = 1.0F;
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 796 */       param1Output.writeFloat(this.min);
/* 797 */       param1Output.writeFloat(this.max);
/* 798 */       param1Output.writeFloat(this.multiplier);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 803 */       this.min = param1Input.readFloat();
/* 804 */       this.max = param1Input.readFloat();
/* 805 */       this.multiplier = param1Input.readFloat();
/*     */     }
/*     */     
/*     */     public final boolean sameAs(FrequencyRange param1FrequencyRange) {
/* 809 */       if (param1FrequencyRange.min != this.min) return false; 
/* 810 */       if (param1FrequencyRange.max != this.max) return false; 
/* 811 */       if (param1FrequencyRange.multiplier != this.multiplier) return false; 
/* 812 */       return true;
/*     */     }
/*     */     
/*     */     public FrequencyRange() {}
/*     */     
/*     */     public FrequencyRange(float param1Float1, float param1Float2) {
/* 818 */       Preconditions.checkArgument((param1Float1 < param1Float2), "Min must be smaller than max, %s and %s given", Float.valueOf(param1Float1), Float.valueOf(param1Float2));
/* 819 */       this.min = param1Float1;
/* 820 */       this.max = param1Float2;
/*     */     }
/*     */     
/*     */     public final FrequencyRange setMultiplier(float param1Float) {
/* 824 */       this.multiplier = param1Float;
/* 825 */       return this;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\MusicManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */