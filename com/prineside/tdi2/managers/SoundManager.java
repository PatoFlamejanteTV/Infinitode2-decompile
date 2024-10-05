/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.StaticSound;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = SoundManager.Serializer.class)
/*     */ public class SoundManager extends Manager.ManagerAdapter {
/*     */   private Thread b;
/*  18 */   private static final TLog a = TLog.forClass(SoundManager.class);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<SoundManager> {
/*     */     public SoundManager read() {
/*  22 */       return Game.i.soundManager;
/*     */     }
/*     */   }
/*     */   
/*  26 */   public final Array<SoundCfg> soundsToPlay = new Array(SoundCfg.class);
/*  27 */   private final Array<SoundCfg> c = new Array(SoundCfg.class);
/*  28 */   private final Array<SoundCfg> d = new Array(SoundCfg.class);
/*     */   
/*  30 */   public final DelayedRemovalArray<PlayingSoundStat> playingSoundStats = new DelayedRemovalArray(false, 64, PlayingSoundStat.class);
/*     */   
/*     */   public SoundManager() {
/*  33 */     b();
/*     */   }
/*     */   
/*     */   private void b() {
/*  37 */     this.b = new Thread(new Runnable(this) {
/*  38 */           private long a = -1L;
/*     */ 
/*     */ 
/*     */           
/*     */           public void run() {
/*     */             while (true) {
/*  44 */               long l1, l2 = (l1 = Game.getTimestampMillis()) - this.a;
/*  45 */               if (this.a == -1L) l2 = 0L; 
/*  46 */               this.a = l1;
/*     */               
/*  48 */               this.b.playingSoundStats.begin(); byte b;
/*  49 */               for (b = 0; b < this.b.playingSoundStats.size; b++) {
/*     */                 SoundManager.PlayingSoundStat playingSoundStat;
/*  51 */                 (playingSoundStat = ((SoundManager.PlayingSoundStat[])this.b.playingSoundStats.items)[b]).durationLeft = (int)((playingSoundStat = ((SoundManager.PlayingSoundStat[])this.b.playingSoundStats.items)[b]).durationLeft - l2);
/*  52 */                 if (playingSoundStat.durationLeft <= 0) {
/*  53 */                   this.b.playingSoundStats.removeIndex(b);
/*     */                 }
/*     */               } 
/*  56 */               this.b.playingSoundStats.end();
/*     */               
/*  58 */               if (this.b.soundsToPlay.size == 0) {
/*     */                 try {
/*  60 */                   if (Game.isLoaded() && Game.i.isDisposed()) {
/*  61 */                     SoundManager.a().i("game is disposed - stopping Sound thread (1)", new Object[0]);
/*     */                     
/*     */                     return;
/*     */                   } 
/*  65 */                   Thread.sleep(16L);
/*     */                 }
/*  67 */                 catch (InterruptedException interruptedException2) {
/*  68 */                   InterruptedException interruptedException1; (interruptedException1 = null).printStackTrace();
/*     */                   return;
/*     */                 } 
/*     */                 continue;
/*     */               } 
/*  73 */               SoundManager.a(this.b).clear();
/*  74 */               synchronized (this.b.soundsToPlay) {
/*  75 */                 SoundManager.a(this.b).addAll(this.b.soundsToPlay);
/*  76 */                 this.b.soundsToPlay.clear();
/*     */               } 
/*     */               
/*  79 */               for (b = 0; b < (SoundManager.a(this.b)).size; b++) {
/*  80 */                 SoundManager.SoundCfg soundCfg = ((SoundManager.SoundCfg[])(SoundManager.a(this.b)).items)[b];
/*     */                 SoundManager.PlayingSoundStat playingSoundStat;
/*  82 */                 (playingSoundStat = new SoundManager.PlayingSoundStat()).type = soundCfg.a.type;
/*  83 */                 playingSoundStat.durationLeft = (int)(soundCfg.a.durationMs / soundCfg.c);
/*  84 */                 this.b.playingSoundStats.add(playingSoundStat);
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  94 */               synchronized (SoundManager.b(this.b)) {
/*  95 */                 SoundManager.b(this.b).addAll(SoundManager.a(this.b));
/*     */               } 
/*  97 */               SoundManager.a(this.b).clear();
/*     */               
/*  99 */               if (Game.i != null && Game.i.isDisposed()) {
/* 100 */                 SoundManager.a().i("game is disposed - stopping Sound thread (2)", new Object[0]);
/*     */                 
/*     */                 return;
/*     */               } 
/*     */               
/*     */               try {
/* 106 */                 Thread.sleep(10L);
/* 107 */               } catch (InterruptedException interruptedException2) {
/* 108 */                 InterruptedException interruptedException1; (interruptedException1 = null).printStackTrace();
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }"Sounds");
/* 114 */     this.b.setDaemon(true);
/* 115 */     this.b.start();
/* 116 */     CrashHandler.handleThreadExceptionsForgiving(this.b);
/*     */   }
/*     */   
/*     */   private void a(StaticSound paramStaticSound, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean) {
/* 120 */     if (paramStaticSound == null) throw new IllegalArgumentException("sound is nul");
/*     */     
/* 122 */     if (Game.i.settingsManager.isSoundEnabled()) {
/* 123 */       paramFloat1 *= (float)Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SOUND_VOLUME);
/* 124 */       if (paramBoolean) {
/* 125 */         paramStaticSound.sound.loop(paramFloat1, paramFloat2, paramFloat3);
/*     */         return;
/*     */       } 
/* 128 */       synchronized (this.soundsToPlay) {
/* 129 */         for (byte b = 0; b < this.soundsToPlay.size; b++) {
/*     */           SoundCfg soundCfg1;
/* 131 */           if ((soundCfg1 = ((SoundCfg[])this.soundsToPlay.items)[b]).a == paramStaticSound) {
/*     */             
/* 133 */             soundCfg1.b = StrictMath.max(soundCfg1.b, paramFloat1);
/* 134 */             soundCfg1.d = (soundCfg1.d + paramFloat3) * 0.5F;
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */         
/* 140 */         SoundCfg soundCfg = null;
/* 141 */         synchronized (this.d) {
/* 142 */           if (this.d.size > 0) {
/* 143 */             soundCfg = (SoundCfg)this.d.pop();
/*     */           }
/*     */         } 
/* 146 */         if (soundCfg == null) soundCfg = new SoundCfg((byte)0);
/*     */         
/* 148 */         soundCfg.a = paramStaticSound;
/* 149 */         soundCfg.b = paramFloat1;
/* 150 */         soundCfg.d = paramFloat3;
/* 151 */         soundCfg.c = paramFloat2;
/* 152 */         this.soundsToPlay.add(soundCfg);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void playStatic(StaticSoundType paramStaticSoundType) {
/* 159 */     playStaticParameterized(paramStaticSoundType, 1.0F, 1.0F, 0.0F, false);
/*     */   }
/*     */   
/*     */   public void playStaticParameterized(StaticSoundType paramStaticSoundType, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean) {
/* 163 */     if (!Game.i.settingsManager.isSoundEnabled())
/*     */       return; 
/*     */     StaticSound staticSound;
/* 166 */     if ((staticSound = Game.i.assetManager.getSound(paramStaticSoundType)) != null) {
/* 167 */       a(staticSound, paramFloat1, paramFloat2, paramFloat3, paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   public StaticSoundType getRarity(RarityType paramRarityType) {
/* 172 */     switch (null.a[paramRarityType.ordinal()]) { case 1:
/* 173 */         return StaticSoundType.LOOT_COMMON;
/* 174 */       case 2: return StaticSoundType.LOOT_RARE;
/* 175 */       case 3: return StaticSoundType.LOOT_VERY_RARE;
/* 176 */       case 4: return StaticSoundType.LOOT_EPIC;
/* 177 */       case 5: return StaticSoundType.LOOT_LEGENDARY; }
/*     */ 
/*     */     
/* 180 */     return null;
/*     */   }
/*     */   
/*     */   public void playRarity(RarityType paramRarityType) {
/* 184 */     playStatic(getRarity(paramRarityType));
/*     */   }
/*     */   
/*     */   private static class SoundCfg
/*     */     implements Pool.Poolable {
/*     */     StaticSound a;
/*     */     float b;
/*     */     
/*     */     public void reset() {
/* 193 */       this.a = null;
/*     */     }
/*     */     
/*     */     float c;
/*     */     float d;
/*     */     
/*     */     private SoundCfg() {}
/*     */   }
/*     */   
/*     */   public static class PlayingSoundStat {
/*     */     public StaticSoundType type;
/*     */     public int durationLeft;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\SoundManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */